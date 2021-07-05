package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class PathUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static String sCacheSubDirectory;
    public static String sDataDirectorySuffix;
    public static FutureTask<String[]> sDirPathFetchTask;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] DIRECTORY_PATHS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(931526389, "Laegon/chrome/base/PathUtils$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(931526389, "Laegon/chrome/base/PathUtils$Holder;");
                    return;
                }
            }
            DIRECTORY_PATHS = PathUtils.access$000();
        }
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
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1479621679, "Laegon/chrome/base/PathUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1479621679, "Laegon/chrome/base/PathUtils;");
                return;
            }
        }
        new AtomicBoolean();
    }

    public PathUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
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
        InterceptResult invokeV;
        File[] fileArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
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
        return (String[]) invokeV.objValue;
    }

    @CalledByNative
    public static String getCacheDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? getDirectoryPath(2) : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getDataDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? getDirectoryPath(0) : (String) invokeV.objValue;
    }

    public static String getDirectoryPath(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? Holder.DIRECTORY_PATHS[i2] : (String) invokeI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @CalledByNative
    public static String getDownloadsDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65544, null)) != null) {
            return (String) invokeV.objValue;
        }
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
        } finally {
        }
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? Environment.getExternalStorageDirectory().getAbsolutePath() : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getNativeLibraryDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            ApplicationInfo applicationInfo = ContextUtils.sApplicationContext.getApplicationInfo();
            int i2 = applicationInfo.flags;
            return ((i2 & 128) != 0 || (i2 & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? getDirectoryPath(1) : (String) invokeV.objValue;
    }

    public static String[] setPrivateDataDirectorySuffixInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
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
        return (String[]) invokeV.objValue;
    }
}
