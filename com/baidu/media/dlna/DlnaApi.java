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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class DlnaApi {

    /* renamed from: a  reason: collision with root package name */
    public static DlnaProvider.DlnaSearchListener f7931a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f7932b = new a(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            try {
                if (i == 1) {
                    Map<String, Object> map = (Map) message.obj;
                    synchronized (DlnaApi.class) {
                        if (DlnaApi.f7931a != null && map != null) {
                            DlnaApi.f7931a.onDeviceChangeNotification(map);
                        }
                    }
                } else if (i == 2) {
                    synchronized (DlnaApi.class) {
                        if (DlnaApi.f7931a != null) {
                            DlnaApi.f7931a.onRefreshFinishNotification(message.arg1, message.arg2);
                        }
                    }
                }
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
            super.handleMessage(message);
        }
    }

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
        } catch (Exception unused) {
        }
        return str;
    }

    public static long getExternalStorageSpace() {
        String path;
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (path = Environment.getExternalStorageDirectory().getPath()) != null && path.length() > 0) {
                StatFs statFs = new StatFs(path);
                return statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public static long getInternalStorageSpace() {
        return CyberPlayerManager.getApplicationContext().getFilesDir().getUsableSpace();
    }

    public static boolean hasExternalStoragePermission(Context context) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                if (packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                    return packageManager.checkPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, context.getPackageName()) == 0;
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static native long nativeCtrlPoint(String str);

    public static native void nativeSearch();

    public static native void nativeStop();

    @Keep
    public static void onDeviceChanged(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("friendlyName", str);
        hashMap.put("uuid", str2);
        Message.obtain(f7932b, 1, hashMap).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
        if (getExternalStorageSpace() < com.baidu.mobstat.Config.FULL_TRACE_LOG_LIMIT) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
        if (getInternalStorageSpace() >= com.baidu.mobstat.Config.FULL_TRACE_LOG_LIMIT) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
        if (r5 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        if (r2 != null) goto L19;
     */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String onFindFilePath(int i) {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        String str = applicationContext.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
        String externalStorageCacheDirectory = getExternalStorageCacheDirectory(applicationContext);
        if (externalStorageCacheDirectory != null) {
            externalStorageCacheDirectory = externalStorageCacheDirectory + File.separator + applicationContext.getPackageName() + File.separator + ".video_statistic" + File.separator + "duplayer";
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (externalStorageCacheDirectory != null) {
                        }
                    }
                } else if (str != null) {
                }
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        new File(str).mkdirs();
        return str;
    }

    @Keep
    public static void onRefreshFinished(int i, int i2) {
        Message obtain = Message.obtain(f7932b, 2);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    public static void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        f7931a = dlnaSearchListener;
        nativeSearch();
    }

    public static void stop() {
        synchronized (DlnaApi.class) {
            f7931a = null;
        }
        nativeStop();
    }
}
