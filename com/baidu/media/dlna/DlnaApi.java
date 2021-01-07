package com.baidu.media.dlna;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.media.duplayer.Keep;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes15.dex */
public class DlnaApi {
    private static DlnaProvider.DlnaSearchListener ciN = null;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f3227b = new Handler(Looper.getMainLooper()) { // from class: com.baidu.media.dlna.DlnaApi.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Map<String, Object> map = (Map) message.obj;
                    try {
                        synchronized (DlnaApi.class) {
                            if (DlnaApi.ciN != null && map != null) {
                                DlnaApi.ciN.onDeviceChangeNotification(map);
                            }
                        }
                        break;
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        break;
                    }
                case 2:
                    try {
                        synchronized (DlnaApi.class) {
                            if (DlnaApi.ciN != null) {
                                DlnaApi.ciN.onRefreshFinishNotification(message.arg1, message.arg2);
                            }
                        }
                        break;
                    } catch (NullPointerException e2) {
                        e2.printStackTrace();
                        break;
                    }
            }
            super.handleMessage(message);
        }
    };

    public static CtrlPointProvider ctrlPoint(String str) {
        return new CtrlPoint(nativeCtrlPoint(str), str);
    }

    public static String getExternalStorageCacheDirectory(Context context) {
        String str = null;
        try {
            if (hasExternalStoragePermission(context)) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath();
            } else if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                str = context.getExternalCacheDir().getPath();
            }
        } catch (Exception e) {
        }
        return str;
    }

    public static long getExternalStorageSpace() {
        String path;
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (path = Environment.getExternalStorageDirectory().getPath()) != null && path.length() > 0) {
                StatFs statFs = new StatFs(path);
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return -1L;
        } catch (Exception e) {
            return -1L;
        }
    }

    public static long getInternalStorageSpace() {
        return CyberPlayerManager.getApplicationContext().getFilesDir().getUsableSpace();
    }

    public static boolean hasExternalStoragePermission(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            if (packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                return packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static native long nativeCtrlPoint(String str);

    private static native void nativeSearch();

    private static native void nativeStop();

    @Keep
    private static void onDeviceChanged(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("friendlyName", str);
        hashMap.put("uuid", str2);
        Message.obtain(f3227b, 1, hashMap).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0085, code lost:
        if (r1 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0095, code lost:
        if (getInternalStorageSpace() >= 10485760) goto L10;
     */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String onFindFilePath(int i) {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        String str = applicationContext.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
        String externalStorageCacheDirectory = getExternalStorageCacheDirectory(applicationContext);
        if (externalStorageCacheDirectory != null) {
            externalStorageCacheDirectory = externalStorageCacheDirectory + File.separator + applicationContext.getPackageName() + File.separator + ".video_statistic" + File.separator + "duplayer";
        }
        switch (i) {
            case 0:
                break;
            case 1:
                if (externalStorageCacheDirectory != null) {
                    str = externalStorageCacheDirectory;
                    break;
                }
                str = null;
                break;
            case 2:
                if (str != null) {
                    break;
                }
                str = null;
                break;
            case 3:
                if (externalStorageCacheDirectory != null && getExternalStorageSpace() >= 10485760) {
                    str = externalStorageCacheDirectory;
                    break;
                }
                str = null;
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            new File(str).mkdirs();
            return str;
        }
        return null;
    }

    @Keep
    private static void onRefreshFinished(int i, int i2) {
        Message obtain = Message.obtain(f3227b, 2);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    public static void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        ciN = dlnaSearchListener;
        nativeSearch();
    }

    public static void stop() {
        synchronized (DlnaApi.class) {
            ciN = null;
        }
        nativeStop();
    }
}
