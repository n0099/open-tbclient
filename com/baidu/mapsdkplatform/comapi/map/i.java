package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
import com.baidu.mapsdkvi.VMsg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static int f3056a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f3057b = BMapManager.getContext();

    static {
        if (!com.baidu.mapapi.VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion())) {
            throw new BaiduMapSDKException("the version of map is not match with base");
        }
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        VMsg.InitClass(VMsg.getInstance());
        AppEngine.InitClass();
        a(BMapManager.getContext());
        SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
        SysUpdateObservable.getInstance().init();
    }

    public static void a() {
        if (f3056a == 0) {
            if (f3057b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            VMsg.init();
            AppEngine.InitEngine(f3057b);
            AppEngine.StartSocketProc();
            NetworkUtil.updateNetworkProxy(f3057b);
        }
        f3056a++;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x015b A[Catch: Exception -> 0x01d2, TryCatch #1 {Exception -> 0x01d2, blocks: (B:10:0x00eb, B:12:0x0114, B:14:0x012b, B:16:0x014e, B:20:0x015b, B:22:0x0161, B:23:0x0164, B:25:0x0195, B:26:0x0198, B:28:0x01bb), top: B:44:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01c2 A[LOOP:0: B:30:0x01bf->B:32:0x01c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01da A[LOOP:1: B:38:0x01da->B:40:0x01dd, LOOP_START, PHI: r1 
      PHI: (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:37:0x01d8, B:40:0x01dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context) {
        boolean z;
        int i;
        if (context == null) {
            return;
        }
        try {
            File file = new File(SysOSUtil.getModuleFileName());
            if (!file.exists()) {
                file.mkdirs();
            }
            context.getAssets();
            String[] strArr = {"cfg/a/mode_1/map.sdkrs", "cfg/a/mode_1/reduct.sdkrs", "cfg/a/mode_1/traffic.sdkrs", "cfg/a/mode_1/map.sty", "cfg/a/mode_1/reduct.sty", "cfg/a/mode_1/traffic.sty", "cfg/idrres/ResPackIndoorMap.sdkrs", "cfg/idrres/DVIndoor.cfg", "cfg/idrres/baseindoormap.sty", "cfg/a/DVDirectory.cfg", "cfg/a/DVHotcity.cfg", "cfg/a/DVHotMap.cfg", "cfg/a/DVSDirectory.cfg", "cfg/a/DVVersion.cfg", "cfg/a/CustomIndex"};
            String[] strArr2 = {"cfg/a/CustomIndex"};
            String[] strArr3 = {"cfg/a/mode_1/map.rs", "cfg/a/mode_1/reduct.rs", "cfg/a/mode_1/traffic.rs", "cfg/a/mode_1/map.sty", "cfg/a/mode_1/reduct.sty", "cfg/a/mode_1/traffic.sty", "cfg/idrres/ResPackIndoorMap.rs", "cfg/idrres/DVIndoor.cfg", "cfg/idrres/baseindoormap.sty", "cfg/a/DVDirectory.cfg", "cfg/a/DVHotcity.cfg", "cfg/a/DVHotMap.cfg", "cfg/a/DVSDirectory.cfg", "cfg/a/DVVersion.cfg", "cfg/a/CustomIndex"};
            String[] strArr4 = {"cfg/a/CustomIndex"};
            try {
                File file2 = new File(SysOSUtil.getModuleFileName() + "/ver.dat");
                byte[] bArr = {5, 2, 1, 0, 0, 0};
                if (file2.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    fileInputStream.close();
                    if (Arrays.equals(bArr2, bArr)) {
                        File file3 = new File(SysOSUtil.getModuleFileName() + "/cfg/a/mode_1/map.sty");
                        if (file3.exists() && file3.length() > 0) {
                            z = false;
                            if (z) {
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                file2.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                fileOutputStream.write(bArr);
                                fileOutputStream.close();
                                File file4 = new File(SysOSUtil.getModuleFileName() + "/cfg/a/mode_1");
                                if (!file4.exists()) {
                                    file4.mkdirs();
                                }
                                File file5 = new File(SysOSUtil.getModuleFileName() + "/cfg/idrres");
                                if (!file5.exists()) {
                                    file5.mkdirs();
                                }
                            }
                            for (i = 0; i < strArr4.length; i++) {
                                com.baidu.mapsdkplatform.comapi.commonutils.a.a(strArr2[i], strArr4[i], context);
                            }
                            if (z) {
                                return;
                            }
                            for (int i2 = 0; i2 < strArr3.length; i2++) {
                                com.baidu.mapsdkplatform.comapi.commonutils.a.a(strArr[i2], strArr3[i2], context);
                            }
                            return;
                        }
                    }
                }
                z = true;
                if (z) {
                }
                while (i < strArr4.length) {
                }
                if (z) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(boolean z) {
        e.l(z);
    }

    public static void b() {
        f3056a--;
        if (f3056a == 0) {
            AppEngine.UnInitEngine();
            VMsg.destroy();
        }
    }
}
