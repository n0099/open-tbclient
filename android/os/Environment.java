package android.os;

import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.core.BdPath;
import java.io.File;
/* loaded from: classes.dex */
public class Environment implements BdNoProGuard {
    public static final String MEDIA_BAD_REMOVAL = "bad_removal";
    public static final String MEDIA_CHECKING = "checking";
    public static final String MEDIA_MOUNTED = "mounted";
    public static final String MEDIA_MOUNTED_READ_ONLY = "mounted_ro";
    public static final String MEDIA_NOFS = "nofs";
    public static final String MEDIA_REMOVED = "removed";
    public static final String MEDIA_SHARED = "shared";
    public static final String MEDIA_UNMOUNTABLE = "unmountable";
    public static final String MEDIA_UNMOUNTED = "unmounted";
    private static final File ROOT_DIRECTORY = getDirectory("ANDROID_ROOT", "/system");
    private static final File DATA_DIRECTORY = getDirectory("ANDROID_DATA", BdPath.DIR_DATA);
    private static final File EXTERNAL_STORAGE_DIRECTORY = getDirectory("EXTERNAL_STORAGE", "/sdcard");
    private static final File DOWNLOAD_CACHE_DIRECTORY = getDirectory("DOWNLOAD_CACHE", "/cache");
    public static String DIRECTORY_DCIM = "DCIM";

    public static File getRootDirectory() {
        return ROOT_DIRECTORY;
    }

    public static File getDataDirectory() {
        return DATA_DIRECTORY;
    }

    public static File getExternalStorageDirectory() {
        return EXTERNAL_STORAGE_DIRECTORY;
    }

    public static File getDownloadCacheDirectory() {
        return DOWNLOAD_CACHE_DIRECTORY;
    }

    public static String getExternalStorageState() {
        throw new RuntimeException("stub!");
    }

    static File getDirectory(String str, String str2) {
        String str3 = System.getenv(str);
        return str3 == null ? new File(str2) : new File(str3);
    }

    public static File getExternalStoragePublicDirectory(String str) {
        throw new RuntimeException("stub!");
    }
}
