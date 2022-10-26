package com.baidu.android.util.io;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public final class PathUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String DIRCTORY_APP = "xxx";
    public static final String DIRCTORY_BAIDU = "baidu";
    public static final String DIRCTORY_BAIDU2 = "BaiduBox";
    public static final String DIRCTORY_DOWNLOAD = "downloads";
    public static final String DIRCTORY_IMAGE_CACHE_FOR_IMAGELOADER = "img_cache";
    public static final String DIRCTORY_IMAGE_CACHE_FOR_NUOMI_SDK = "img_cache_nuomi";
    public static final String DIRCTORY_IMAGE_CACHE_FOR_OTHER = "img_other";
    public static final String DIRECTORY_DATA_CACHE = "baidu/xxx";
    public static final String PATH_DEFAULT_DOWNLOAD = "baidu/xxx/downloads";
    public static final String PATH_DEFAULT_DOWNLOAD2 = "BaiduBox/downloads";
    public static final String TAG = "PathUtils";
    public static String sCacheDir;
    public static String sImageCacheDirBaseForFresco;
    public static String sImageCacheDirForImageloader;
    public static String sImageCacheDirForOther;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1122379591, "Lcom/baidu/android/util/io/PathUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1122379591, "Lcom/baidu/android/util/io/PathUtils;");
        }
    }

    public PathUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Deprecated
    public static boolean deleteDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                File file = new File(str);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            file2.delete();
                        }
                    }
                    file.delete();
                    return true;
                }
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File getDownloadDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            File externalFilesDir = context.getExternalFilesDir("downloads");
            if (externalFilesDir != null) {
                boolean z = false;
                if (externalFilesDir.exists()) {
                    if (!externalFilesDir.isDirectory()) {
                        deleteFile(externalFilesDir);
                    }
                    if (z) {
                        externalFilesDir.mkdirs();
                    }
                }
                z = true;
                if (z) {
                }
            }
            return externalFilesDir;
        }
        return (File) invokeL.objValue;
    }

    @Deprecated
    public static String getExternalStorageDir(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (isExternalStorageWritable()) {
                file = Environment.getExternalStorageDirectory();
            } else {
                file = null;
            }
            if (file == null) {
                return "";
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public static String getImageCacheDirForOthers(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            String cacheDirectory = getCacheDirectory(context);
            if (!TextUtils.isEmpty(cacheDirectory)) {
                File file = new File(cacheDirectory, DIRCTORY_IMAGE_CACHE_FOR_OTHER);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file.getAbsolutePath();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static boolean deleteFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            try {
                String absolutePath = file.getAbsolutePath();
                File file2 = new File(absolutePath);
                long currentTimeMillis = System.currentTimeMillis();
                File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
                file2.renameTo(file3);
                return file3.delete();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static void deleteOldFiles(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) && TextUtils.equals("mounted", Environment.getExternalStorageState())) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (!defaultSharedPreferences.getBoolean("key_path_utils_delete_old_file", false)) {
                File file = new File(Environment.getExternalStorageDirectory(), ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
                if (file.exists()) {
                    if (file.delete()) {
                        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                        edit.putBoolean("key_path_utils_delete_old_file", true);
                        edit.apply();
                        return;
                    }
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("key_path_utils_delete_old_file", true);
                edit2.apply();
            }
        }
    }

    public static String getCacheDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (!TextUtils.isEmpty(sCacheDir)) {
                return sCacheDir;
            }
            File file = null;
            try {
                file = context.getExternalCacheDir();
            } catch (Exception unused) {
            }
            if (file == null) {
                file = context.getCacheDir();
            }
            if (file == null) {
                file = context.getFilesDir();
            }
            if (file != null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                sCacheDir = file.getAbsolutePath();
            }
            return sCacheDir;
        }
        return (String) invokeL.objValue;
    }

    public static String getFileExtFromUrl(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= 0) {
                return "";
            }
            return str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static String getImageCacheDirForImageLoader(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String cacheDirectory = getCacheDirectory(context);
            if (!TextUtils.isEmpty(cacheDirectory)) {
                return new File(cacheDirectory, DIRCTORY_IMAGE_CACHE_FOR_IMAGELOADER).getAbsolutePath();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getImageCacheDirctoryForImageLoader(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (TextUtils.isEmpty(sImageCacheDirForImageloader)) {
                sImageCacheDirForImageloader = getImageCacheDirForImageLoader(context);
            }
            return sImageCacheDirForImageloader;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getImageCacheDirectoryBaseForFresco(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (TextUtils.isEmpty(sImageCacheDirBaseForFresco)) {
                sImageCacheDirBaseForFresco = getCacheDirectory(context);
            }
            return sImageCacheDirBaseForFresco;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getImageCacheDirectoryForOthers(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (TextUtils.isEmpty(sImageCacheDirForOther)) {
                sImageCacheDirForOther = getImageCacheDirForOthers(context);
            }
            return sImageCacheDirForOther;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isExternalStorageWritable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && !TextUtils.isEmpty(sCacheDir)) {
                try {
                    File file = new File(sCacheDir, ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
                    if (file.exists()) {
                        return true;
                    }
                    return file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
