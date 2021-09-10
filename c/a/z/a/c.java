package c.a.z.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.PathUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.media.duplayer.Utils;
import com.baidu.media.duplayer.d;
import com.baidu.media.duplayer.monitor.DuplayerQualityMonitorManager;
import com.baidu.media.ext.CyberMediaExtLoader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f31251a;

    /* renamed from: b  reason: collision with root package name */
    public static String f31252b;

    /* renamed from: c  reason: collision with root package name */
    public static String f31253c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f31254d;

    /* renamed from: e  reason: collision with root package name */
    public static CyberPlayerManager.InstallListener2 f31255e;

    /* renamed from: f  reason: collision with root package name */
    public static Object f31256f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.d();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-899320831, "Lc/a/z/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-899320831, "Lc/a/z/a/c;");
                return;
            }
        }
        f31256f = new Object();
    }

    public static void a(int i2, Map<String, String> map) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i2, map) == null) {
            int j2 = e.b().j(i2);
            if ((f31251a & j2) == j2) {
                return;
            }
            do {
                i3 = (f31251a ^ j2) & j2;
                if (i3 <= 0) {
                    break;
                }
            } while (n(1 << Integer.numberOfTrailingZeros(i3), map));
            e.b().s();
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            f31253c = str;
            f31254d = Utils.t(context);
            e.b().f(context, str);
        }
    }

    public static void c(Context context, Map<String, String> map) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, map) == null) {
            CyberLog.d("CyberLibsLoader", "initCyberPlayer");
            IjkMediaPlayer.e();
            IjkMediaPlayer.f();
            String str3 = map != null ? map.get("cache-path") : null;
            CyberTaskExcutor.getInstance().execute(new a());
            if (str3 == null) {
                str = Utils.b(context) + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + "flyflow" + File.separator + Utils.f42617c + File.separator + context.getPackageName() + File.separator;
            } else {
                str = str3 + File.separator + Utils.f42617c + File.separator;
            }
            if (f31254d) {
                str = str + "remote" + File.separator;
            }
            Utils.f(str);
            int i2 = 5;
            if (map != null && (str2 = map.get(CyberPlayerManager.INSTALL_OPT_PIPELINE_NUM)) != null) {
                try {
                    i2 = Integer.parseInt(str2);
                } catch (Exception unused) {
                }
            }
            Utils.c(i2);
            Utils.q();
            o();
            p();
        }
    }

    public static void d(CyberPlayerManager.InstallListener2 installListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, installListener2) == null) {
            synchronized (f31256f) {
                f31255e = installListener2;
            }
        }
    }

    public static boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            int j2 = e.b().j(i2);
            return (f31251a & j2) == j2;
        }
        return invokeI.booleanValue;
    }

    public static boolean f(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, str)) == null) {
            if (f31254d && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SR, true)) {
                if (i2 != 2048) {
                    System.load(str);
                } else {
                    String str2 = f31253c + File.separator + "model_video-sr_1.2";
                    String str3 = str2 + File.separator + "params.mlm";
                    if (!new File(str2 + File.separator + "model.mlm").exists() || !new File(str3).exists()) {
                        throw new FileNotFoundException("model_video-sr_1.2.zip");
                    }
                    CyberLog.d("CyberLibsLoader", "initVideoSR");
                    Utils.g(str, str2);
                }
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (f31254d && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_BSO, false)) {
                Utils.m(str);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? e.b().o() : (String[]) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f31252b : (String) invokeV.objValue;
    }

    public static void j(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65546, null, i2, str) == null) {
            int i3 = i2 == 16 ? 100 : i2 == 8 ? 101 : i2 == 4 ? 102 : -1;
            if (i3 > 0) {
                synchronized (f31256f) {
                    if (f31255e != null) {
                        f31255e.onInstallInfo(i3, i2, str);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean k(int i2, Map<String, String> map) {
        InterceptResult invokeIL;
        String str;
        int i3;
        StringBuilder sb;
        String error;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65547, null, i2, map)) == null) {
            if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_CRASHPAD, true)) {
                String str3 = null;
                String str4 = "-1";
                if (map != null) {
                    String str5 = map.get(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE);
                    if (!TextUtils.isEmpty(str5)) {
                        try {
                            i3 = Integer.parseInt(str5);
                        } catch (Exception unused) {
                        }
                        str = map.get("abtest_sid");
                        str2 = map.get(CyberPlayerManager.INSTALL_OPT_PROCESS_TYPE);
                        if (!TextUtils.isEmpty(str2)) {
                            str4 = str2;
                        }
                    }
                    i3 = 3;
                    str = map.get("abtest_sid");
                    str2 = map.get(CyberPlayerManager.INSTALL_OPT_PROCESS_TYPE);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                } else {
                    str = null;
                    i3 = 3;
                }
                if (f31254d) {
                    if ((i3 & 2) != 2) {
                        return false;
                    }
                } else if ((i3 & 1) != 1) {
                    return false;
                }
                if (b.e()) {
                    if (i2 == 1) {
                        return true;
                    }
                    try {
                        try {
                            File file = new File(e.b().a(1).j());
                            File file2 = new File(e.b().a(2).j());
                            String parent = file.getParent();
                            String parent2 = file2.getParent();
                            try {
                                str3 = CyberPlayerManager.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
                            } catch (Exception unused2) {
                            }
                            if (f31254d) {
                                str4 = "4";
                            }
                            if (!file2.canExecute()) {
                                file2.setExecutable(true);
                                CyberLog.d("CyberLibsLoader", "set " + file2.getAbsolutePath() + " executable");
                            }
                            String[] strArr = {SDKVersion.VERSION, "neon", CyberPlayerManager.getClientID(), "unKnown", "0", "0", str4, "true", str3, GlobalConstants.DEFAULT_VERSION, parent, parent2, ""};
                            b.d(true);
                            b.a(CyberPlayerManager.getApplicationContext(), strArr);
                            b.b("{searchbox_sid=" + str + "}");
                            return true;
                        } catch (Exception e2) {
                            sb = new StringBuilder();
                            sb.append("initCrashPad Exception:");
                            error = e2.toString();
                            sb.append(error);
                            CyberLog.e("CyberLibsLoader", sb.toString());
                            return false;
                        }
                    } catch (Error e3) {
                        sb = new StringBuilder();
                        sb.append("initCrashPad Error:");
                        error = e3.toString();
                        sb.append(error);
                        CyberLog.e("CyberLibsLoader", sb.toString());
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public static boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (f31254d && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DMO, false)) {
                Utils.o(str);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f31253c : (String) invokeV.objValue;
    }

    public static boolean n(int i2, Map<String, String> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65550, null, i2, map)) == null) {
            com.baidu.media.duplayer.d a2 = e.b().a(i2);
            boolean z = false;
            if (a2 == null) {
                CyberLog.e("CyberLibsLoader", "Unable to find (" + i2 + ") LibInfo");
                return false;
            }
            String a3 = a2.a();
            String d2 = a2.d();
            String j2 = a2.j();
            File file = new File(j2);
            if (a2.l() == d.a.f42632a) {
                if (!"apk_internal_jar".equals(j2)) {
                    if (file.exists()) {
                        if (e.b().C(i2)) {
                            z = CyberMediaExtLoader.init(CyberPlayerManager.getApplicationContext());
                        }
                    } else if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
                        throw new FileNotFoundException(e.b().q(i2));
                    } else {
                        CyberLog.e("CyberLibsLoader", "not exist: " + a3);
                    }
                }
                z = true;
            } else {
                if (a2.l() == d.a.f42633b) {
                    if (!file.exists() && !a2.p()) {
                        if (i2 == 32) {
                            i2 = 64;
                        }
                        throw new FileNotFoundException(e.b().q(i2));
                    } else if (e.b().u(i2)) {
                        j(i2, j2);
                        System.load(j2);
                        if (i2 == 64) {
                            c(CyberPlayerManager.getApplicationContext(), map);
                        }
                    } else if (e.b().w(i2)) {
                        IjkMediaPlayer.nativeSetEnableFFmpegExtend(j2);
                    } else if (e.b().y(i2)) {
                        f31252b = j2;
                    } else if (e.b().E(i2)) {
                        z = k(i2, map);
                    } else if (e.b().A(i2)) {
                        z = f(i2, j2);
                    } else if (e.b().F(i2)) {
                        z = i2 == 16384 ? g(j2) : true;
                        if (i2 == 32768) {
                            z = l(j2);
                        }
                    }
                }
                z = true;
            }
            f31251a = i2 | f31251a;
            if (z) {
                CyberLog.d("CyberLibsLoader", "isMediaProcess:" + f31254d + " abi:" + e.b().p() + " lib:" + a3 + " ver:" + d2 + " path:" + j2 + " load success");
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[Catch: Exception -> 0x0086, TRY_LEAVE, TryCatch #0 {Exception -> 0x0086, blocks: (B:7:0x0012, B:9:0x0065, B:11:0x0069, B:19:0x0081, B:13:0x006f, B:15:0x007a), top: B:25:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65551, null) != null) {
            return;
        }
        boolean z = true;
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MONITOR, true)) {
            return;
        }
        try {
            String str = f31253c + File.separator + "config";
            String str2 = str + File.separator + LibsInfoDef.CYBER_CODEC_MONITOR_NAME + "_" + CyberCfgManager.getInstance().getCfgValue("monitor_version", LibsInfoDef.CYBER_CODEC_MONITOR_VERSION) + ".json";
            File file = new File(str);
            if (file.exists()) {
                if (!new File(str2).exists() && !f31254d) {
                    z = false;
                }
                if (z) {
                }
            } else {
                if (f31254d) {
                    file.mkdirs();
                    if (z) {
                        Utils.h(str2, f31254d);
                        return;
                    }
                    return;
                }
                z = false;
                if (z) {
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0077 A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #0 {Exception -> 0x0080, blocks: (B:7:0x0012, B:9:0x005b, B:11:0x005f, B:19:0x0077, B:13:0x0065, B:15:0x0070), top: B:25:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65552, null) != null) {
            return;
        }
        boolean z = true;
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAY_SCORE_MONITOR, true)) {
            return;
        }
        try {
            String str = f31253c + File.separator + "config";
            String str2 = str + File.separator + LibsInfoDef.CYBER_PLAY_SCORE_STORAGE_NAME + "_" + LibsInfoDef.CYBER_PLAY_SCORE_STORAGE_VERSION + ".json";
            File file = new File(str);
            if (file.exists()) {
                if (!new File(str2).exists() && !f31254d) {
                    z = false;
                }
                if (z) {
                }
            } else {
                if (f31254d) {
                    file.mkdirs();
                    if (z) {
                        DuplayerQualityMonitorManager.getInstance().init(str2, f31254d);
                        return;
                    }
                    return;
                }
                z = false;
                if (z) {
                }
            }
        } catch (Exception unused) {
        }
    }
}
