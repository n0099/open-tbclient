package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import com.baidu.pass.face.platform.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class PathUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String sCacheSubDirectory;
    public static String sDataDirectorySuffix;
    public static FutureTask<String[]> sDirPathFetchTask;

    /* loaded from: classes.dex */
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

    public static /* synthetic */ String[] access$000() {
        String[] strArr = null;
        try {
            if (sDirPathFetchTask.cancel(false)) {
                StrictModeContext allowDiskWrites = StrictModeContext.allowDiskWrites();
                String[] privateDataDirectorySuffixInternal = setPrivateDataDirectorySuffixInternal();
                $closeResource(null, allowDiskWrites);
                strArr = privateDataDirectorySuffixInternal;
            } else {
                strArr = sDirPathFetchTask.get();
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        return strArr;
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
        for (int i2 = 0; i2 < fileArr.length; i2++) {
            if (fileArr[i2] != null && !TextUtils.isEmpty(fileArr[i2].getAbsolutePath())) {
                arrayList.add(fileArr[i2].getAbsolutePath());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @CalledByNative
    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    @CalledByNative
    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    public static String getDirectoryPath(int i2) {
        return Holder.DIRECTORY_PATHS[i2];
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @CalledByNative
    public static String getDownloadsDirectory() {
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            if (BuildInfo.isAtLeastQ()) {
                String str = getAllPrivateDownloadsDirectories()[0];
                $closeResource(null, allowDiskReads);
                return str;
            }
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            $closeResource(null, allowDiskReads);
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
        int i2 = applicationInfo.flags;
        return ((i2 & 128) != 0 || (i2 & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    public static String[] setPrivateDataDirectorySuffixInternal() {
        String[] strArr = new String[3];
        Context context = ContextUtils.sApplicationContext;
        strArr[0] = context.getDir(sDataDirectorySuffix, 0).getPath();
        String str = strArr[0];
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.chmod(str, FileUtils.S_IRWXU);
            } catch (Exception unused) {
                Log.e(com.baidu.android.util.io.PathUtils.TAG, "Failed to set permissions for path \"" + str + "\"", new Object[0]);
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
