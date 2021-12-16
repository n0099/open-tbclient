package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
import com.baidu.mapsdkvi.VMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f36945b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724782251, "Lcom/baidu/mapsdkplatform/comapi/map/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724782251, "Lcom/baidu/mapsdkplatform/comapi/map/i;");
                return;
            }
        }
        f36945b = BMapManager.getContext();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (a == 0) {
                if (f36945b == null) {
                    throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                }
                VMsg.init();
                AppEngine.InitEngine(f36945b);
                AppEngine.StartSocketProc();
                NetworkUtil.updateNetworkProxy(f36945b);
            }
            a++;
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || context == null) {
            return;
        }
        try {
            File file = new File(SysOSUtil.getModuleFileName());
            if (!file.exists()) {
                file.mkdirs();
            }
            context.getAssets();
            String[] strArr = {"cfg/a/mode_1/map.sdkrs", "cfg/a/mode_1/reduct.sdkrs", "cfg/a/mode_1/traffic.sdkrs", "cfg/a/mode_1/map.sty", "cfg/a/mode_1/reduct.sty", "cfg/a/mode_1/traffic.sty", "cfg/idrres/ResPackIndoorMap.sdkrs", "cfg/idrres/DVIndoor.cfg", "cfg/idrres/baseindoormap.sty", "cfg/a/DVDirectory.cfg", "cfg/a/DVHotcity.cfg", "cfg/a/DVHotMap.cfg", "cfg/a/DVSDirectory.cfg", "cfg/a/DVVersion.cfg"};
            String[] strArr2 = {"cfg/a/mode_1/map.rs", "cfg/a/mode_1/reduct.rs", "cfg/a/mode_1/traffic.rs", "cfg/a/mode_1/map.sty", "cfg/a/mode_1/reduct.sty", "cfg/a/mode_1/traffic.sty", "cfg/idrres/ResPackIndoorMap.rs", "cfg/idrres/DVIndoor.cfg", "cfg/idrres/baseindoormap.sty", "cfg/a/DVDirectory.cfg", "cfg/a/DVHotcity.cfg", "cfg/a/DVHotMap.cfg", "cfg/a/DVSDirectory.cfg", "cfg/a/DVVersion.cfg"};
            try {
                File file2 = new File(SysOSUtil.getModuleFileName() + "/ver.dat");
                boolean z = true;
                byte[] bArr = {5, 4, 4, 0, 0, 0};
                if (file2.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    byte[] bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    fileInputStream.close();
                    if (Arrays.equals(bArr2, bArr)) {
                        File file3 = new File(SysOSUtil.getModuleFileName() + "/cfg/a/mode_1/map.sty");
                        if (file3.exists() && file3.length() > 0) {
                            z = false;
                        }
                    }
                }
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
                if (z) {
                    for (int i2 = 0; i2 < 14; i2++) {
                        com.baidu.mapsdkplatform.comapi.commonutils.a.a(strArr[i2], strArr2[i2], context);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            e.m(z);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            int i2 = a - 1;
            a = i2;
            if (i2 == 0) {
                AppEngine.UnInitEngine();
                VMsg.destroy();
            }
        }
    }
}
