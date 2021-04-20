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
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static int f7668a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f7669b = BMapManager.getContext();

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
        if (f7668a == 0) {
            if (f7669b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            VMsg.init();
            AppEngine.InitEngine(f7669b);
            AppEngine.StartSocketProc();
            NetworkUtil.updateNetworkProxy(f7669b);
        }
        f7668a++;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e5 A[Catch: Exception -> 0x015e, TryCatch #0 {Exception -> 0x015e, blocks: (B:10:0x006a, B:12:0x009f, B:14:0x00b6, B:16:0x00d6, B:21:0x00e5, B:23:0x00eb, B:24:0x00ee, B:26:0x011c, B:27:0x011f, B:29:0x013f), top: B:43:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0145 A[LOOP:0: B:31:0x0143->B:32:0x0145, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0151 A[LOOP:1: B:34:0x0151->B:35:0x0153, LOOP_START, PHI: r9 
      PHI: (r9v3 int) = (r9v2 int), (r9v4 int) binds: [B:33:0x014f, B:35:0x0153] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
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
                            for (i = 0; i < 1; i++) {
                                com.baidu.mapsdkplatform.comapi.commonutils.a.a(strArr2[i], strArr4[i], context);
                            }
                            if (z) {
                                return;
                            }
                            for (int i2 = 0; i2 < 15; i2++) {
                                com.baidu.mapsdkplatform.comapi.commonutils.a.a(strArr[i2], strArr3[i2], context);
                            }
                            return;
                        }
                    }
                }
                z = true;
                if (z) {
                }
                while (i < 1) {
                }
                if (z) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(boolean z) {
        e.l(z);
    }

    public static void b() {
        int i = f7668a - 1;
        f7668a = i;
        if (i == 0) {
            AppEngine.UnInitEngine();
            VMsg.destroy();
        }
    }
}
