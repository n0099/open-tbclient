package com.baidu.media.duplayer;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class b {
    private static volatile int a = 0;
    private static String b;
    private static String c;
    private static boolean d;

    public static void a(Context context, String str) {
        c = str;
        d = Utils.e(context);
        e.LF().a(context, str);
    }

    private static void a(Context context, Map<String, String> map) {
        int i;
        String str;
        CyberLog.d("CyberLibsLoader", "initCyberPlayer");
        IjkMediaPlayer.e();
        IjkMediaPlayer.f();
        String str2 = map != null ? map.get(CyberPlayerManager.OPT_CHCHE_PATH) : null;
        CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.media.duplayer.b.1
            @Override // java.lang.Runnable
            public void run() {
                c.a();
            }
        });
        String str3 = str2 == null ? Utils.a(context) + File.separator + "baidu" + File.separator + "flyflow" + File.separator + Utils.c + File.separator + context.getPackageName() + File.separator : str2 + File.separator + Utils.c + File.separator;
        if (d) {
            str3 = str3 + "remote" + File.separator;
        }
        Utils.a(str3);
        if (map == null || (str = map.get(CyberPlayerManager.INSTALL_OPT_PIPELINE_NUM)) == null) {
            i = 5;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
                i = 5;
            }
        }
        Utils.a(i);
        Utils.e();
        c();
    }

    public static boolean a(int i) {
        int b2 = e.LF().b(i);
        return (a & b2) == b2;
    }

    private static boolean a(int i, String str) {
        if (d && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SR, true)) {
            if (i != 512) {
                System.load(str);
            } else {
                String str2 = c + File.separator + "model_video-sr_1.2";
                String str3 = str2 + File.separator + "params.mlm";
                if (!new File(str2 + File.separator + "model.mlm").exists() || !new File(str3).exists()) {
                    throw new FileNotFoundException("model_video-sr_1.2.zip");
                }
                CyberLog.d("CyberLibsLoader", "initVideoSR");
                Utils.a(str, str2);
            }
            return true;
        }
        return false;
    }

    public static String[] a() {
        return e.LF().LG();
    }

    public static String b() {
        return b;
    }

    private static void c() {
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MONITOR, false)) {
            try {
                String str = c + File.separator + "config";
                String str2 = str + File.separator + LibsInfoDef.CYBER_CODEC_MONITOR_NAME + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + LibsInfoDef.CYBER_CODEC_MONITOR_VERSION + ".json";
                File file = new File(str);
                boolean z = true;
                if (file.exists()) {
                    if (!new File(str2).exists() && !d) {
                        z = false;
                    }
                } else if (d) {
                    file.mkdirs();
                } else {
                    z = false;
                }
                if (z) {
                    Utils.a(str2, d);
                }
            } catch (Exception e) {
            }
        }
    }

    private static boolean c(int i, Map<String, String> map) {
        int i2;
        String str;
        String str2;
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_CRASHPAD, true)) {
            String str3 = map.get(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE);
            if (TextUtils.isEmpty(str3)) {
                i2 = 3;
            } else {
                try {
                    i2 = Integer.parseInt(str3);
                } catch (Exception e) {
                    i2 = 3;
                }
            }
            if (d) {
                if ((i2 & 2) != 2) {
                    return false;
                }
            } else if ((i2 & 1) != 1) {
                return false;
            }
            if (a.a()) {
                if (i == 1) {
                    return true;
                }
                try {
                    try {
                        File file = new File(e.LF().dC(1).c());
                        File file2 = new File(e.LF().dC(2).c());
                        String parent = file.getParent();
                        String parent2 = file2.getParent();
                        try {
                            str = CyberPlayerManager.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
                        } catch (Exception e2) {
                            str = null;
                        }
                        if (d) {
                            str2 = "4";
                        } else {
                            str2 = map.get(CyberPlayerManager.INSTALL_OPT_PROCESS_TYPE);
                            if (TextUtils.isEmpty(str2)) {
                                str2 = "-1";
                            }
                        }
                        if (!file2.canExecute()) {
                            file2.setExecutable(true);
                            CyberLog.d("CyberLibsLoader", "set " + file2.getAbsolutePath() + " executable");
                        }
                        String[] strArr = {SDKVersion.VERSION, "neon", CyberPlayerManager.getClientID(), "unKnown", "0", "0", str2, "true", str, GlobalConstants.DEFAULT_VERSION, parent, parent2};
                        a.a(true);
                        a.a(CyberPlayerManager.getApplicationContext(), strArr);
                        String str4 = map.get("abtest_sid");
                        if (!TextUtils.isEmpty(str4)) {
                            a.a("{searchbox_sid=" + str4 + "}");
                        }
                        return true;
                    } catch (Error e3) {
                        CyberLog.e("CyberLibsLoader", "initCrashPad Error:" + e3.toString());
                        return false;
                    }
                } catch (Exception e4) {
                    CyberLog.e("CyberLibsLoader", "initCrashPad Exception:" + e4.toString());
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public static void d(int i, Map<String, String> map) {
        int b2 = e.LF().b(i);
        if ((a & b2) == b2) {
            return;
        }
        for (int i2 = (a ^ b2) & b2; i2 > 0 && e(1 << Integer.numberOfTrailingZeros(i2), map); i2 = (a ^ b2) & b2) {
        }
        e.LF().d();
    }

    private static boolean e(int i, Map<String, String> map) {
        boolean a2;
        d dC = e.LF().dC(i);
        if (dC == null) {
            CyberLog.e("CyberLibsLoader", "Unable to find (" + i + ") LibInfo");
            return false;
        }
        String a3 = dC.a();
        String b2 = dC.b();
        String c2 = dC.c();
        if (!new File(c2).exists()) {
            if (i == 8) {
                i = 16;
            }
            throw new FileNotFoundException(e.LF().c(i));
        }
        if (e.LF().d(i)) {
            System.load(c2);
            if (i == 16) {
                a(CyberPlayerManager.getApplicationContext(), map);
                a2 = true;
            }
            a2 = true;
        } else if (e.LF().e(i)) {
            IjkMediaPlayer.nativeSetEnableFFmpegExtend(c2);
            a2 = true;
        } else if (e.LF().f(i)) {
            b = c2;
            a2 = true;
        } else if (e.LF().h(i)) {
            a2 = c(i, map);
        } else {
            if (e.LF().dD(i)) {
                a2 = a(i, c2);
            }
            a2 = true;
        }
        a |= i;
        if (a2) {
            CyberLog.d("CyberLibsLoader", "isMediaProcess:" + d + " abi:" + e.LF().c() + " lib:" + a3 + " ver:" + b2 + " load success");
            return true;
        }
        return true;
    }
}
