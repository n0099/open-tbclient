package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class PathUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = !PathUtils.class.desiredAssertionStatus();
    public static String sCacheSubDirectory;
    public static String sDataDirectorySuffix;
    public static FutureTask<String[]> sDirPathFetchTask;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Holder {
        public static final String[] DIRECTORY_PATHS = PathUtils.access$000();
    }

    public static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    static {
        new AtomicBoolean();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static /* synthetic */ String[] access$000() {
        try {
            if (sDirPathFetchTask.cancel(false)) {
                StrictModeContext allowDiskWrites = StrictModeContext.allowDiskWrites();
                try {
                    String[] privateDataDirectorySuffixInternal = setPrivateDataDirectorySuffixInternal();
                    $closeResource(null, allowDiskWrites);
                    return privateDataDirectorySuffixInternal;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        $closeResource(th, allowDiskWrites);
                        throw th2;
                    }
                }
            }
            return sDirPathFetchTask.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @CalledByNative
    public static String[] getAllPrivateDownloadsDirectories() {
        File[] fileArr;
        if (Build.VERSION.SDK_INT >= 19) {
            StrictModeContext allowDiskWrites = StrictModeContext.allowDiskWrites();
            try {
                fileArr = ContextUtils.sApplicationContext.getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
                $closeResource(null, allowDiskWrites);
            } finally {
            }
        } else {
            fileArr = new File[]{Environment.getExternalStorageDirectory()};
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fileArr.length; i++) {
            if (fileArr[i] != null && !TextUtils.isEmpty(fileArr[i].getAbsolutePath())) {
                arrayList.add(fileArr[i].getAbsolutePath());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @CalledByNative
    public static String getCacheDirectory() {
        if ($assertionsDisabled || sDirPathFetchTask != null) {
            return getDirectoryPath(2);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getDataDirectory() {
        if ($assertionsDisabled || sDirPathFetchTask != null) {
            return getDirectoryPath(0);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    public static String getDirectoryPath(int i) {
        return Holder.DIRECTORY_PATHS[i];
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @CalledByNative
    public static String getDownloadsDirectory() {
        String path;
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            if (BuildInfo.isAtLeastQ()) {
                path = getAllPrivateDownloadsDirectories()[0];
                $closeResource(null, allowDiskReads);
            } else {
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                $closeResource(null, allowDiskReads);
            }
            return path;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                $closeResource(th, allowDiskReads);
                throw th2;
            }
        }
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @CalledByNative
    public static String getNativeLibraryDirectory() {
        ApplicationInfo applicationInfo = ContextUtils.sApplicationContext.getApplicationInfo();
        int i = applicationInfo.flags;
        return ((i & 128) != 0 || (i & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        if ($assertionsDisabled || sDirPathFetchTask != null) {
            return getDirectoryPath(1);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    public static String[] setPrivateDataDirectorySuffixInternal() {
        String[] strArr = new String[3];
        Context context = ContextUtils.sApplicationContext;
        strArr[0] = context.getDir(sDataDirectorySuffix, 0).getPath();
        String str = strArr[0];
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.chmod(str, 448);
            } catch (Exception e) {
                Log.e("PathUtils", "Failed to set permissions for path \"" + str + "\"", new Object[0]);
            }
        }
        strArr[1] = context.getDir("textures", 0).getPath();
        if (context.getCacheDir() != null) {
            if (sCacheSubDirectory == null) {
                strArr[2] = context.getCacheDir().getPath();
            } else {
                strArr[2] = new File(context.getCacheDir(), sCacheSubDirectory).getPath();
            }
        }
        return strArr;
    }
}
