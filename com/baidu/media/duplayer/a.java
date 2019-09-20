package com.baidu.media.duplayer;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.xiaomi.mipush.sdk.Constants;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class a {
    private static Set<String> a = new HashSet();
    private static String b;
    private static String c;

    public static String a() {
        return c;
    }

    public static void a(Context context, int i, Map<String, String> map) {
        Set<String> bD = b.bD(i);
        if (a.containsAll(bD)) {
            return;
        }
        c();
        if (SDKVersion.VERSION.equals(CyberPlayerManager.getSDKVersion())) {
            b.a();
        }
        try {
            for (String str : bD) {
                a(str, context, map);
            }
        } catch (SecurityException e) {
            CyberLog.w("CyberLibsLoader", e.toString());
            b = e.toString();
        } catch (UnsatisfiedLinkError e2) {
            CyberLog.w("CyberLibsLoader", e2.toString());
            b = e2.toString();
        }
    }

    private static void a(Context context, Map<String, String> map) {
        CyberLog.d("CyberLibsLoader", "initCyberPlayer");
        IjkMediaPlayer.e();
        IjkMediaPlayer.f();
        String str = map != null ? map.get(CyberPlayerManager.OPT_CHCHE_PATH) : null;
        String str2 = str == null ? Utils.a(context) + File.separator + "baidu" + File.separator + "flyflow" + File.separator + Utils.c + File.separator + context.getPackageName() + File.separator : str + File.separator + Utils.c + File.separator;
        if (!Utils.d(context)) {
            str2 = str2 + "remote" + File.separator;
        }
        Utils.a(str2);
        Utils.f();
    }

    private static void a(String str, Context context, Map<String, String> map) {
        CyberLog.d("CyberLibsLoader", "curLoaded Libs:" + a + " reqLoad Lib:" + str);
        if (a.contains(str)) {
            return;
        }
        String b2 = b.b(str);
        if (TextUtils.isEmpty(b2)) {
            b = "not find " + str + " version info. coreVer:" + SDKVersion.VERSION;
            return;
        }
        String findLibrary = b2.equals(b.a(str)) ? ((BaseDexClassLoader) context.getClassLoader()).findLibrary(str) : null;
        if (TextUtils.isEmpty(findLibrary)) {
            findLibrary = Utils.e() + File.separator + "cybermedia" + File.separator + "libs" + File.separator + str + File.separator + b2 + File.separator + Plugin.SO_LIB_DIR_NAME + str + PluginInstallerService.APK_LIB_SUFFIX;
        }
        if (!new File(findLibrary).exists()) {
            if ("cyber-sdl".equals(str)) {
                str = "cyber-player";
            }
            throw new FileNotFoundException(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + b2);
        }
        if (str.equals("cyber-pcdn")) {
            c = findLibrary;
        } else if (str.equals("cyber-ffmpeg-extend")) {
            IjkMediaPlayer.nativeSetEnableFFmpegExtend(findLibrary);
        } else {
            System.load(findLibrary);
        }
        if ("cyber-player".equals(str)) {
            a(CyberPlayerManager.getApplicationContext(), map);
        }
        a.add(str);
        CyberLog.d("CyberLibsLoader", "lib:" + str + " ver:" + b2 + " load success");
    }

    public static boolean a(int i) {
        return a.containsAll(b.bD(i));
    }

    public static String b() {
        return b;
    }

    private static void c() {
        if (CyberCfgManager.getInstance().getPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, 0L) - System.currentTimeMillis() > 86400000) {
            CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.media.duplayer.a.1
                @Override // java.lang.Runnable
                public void run() {
                    String str = Utils.e() + File.separator + "cybermedia" + File.separator + "libs";
                    com.baidu.cyberplayer.sdk.Utils.deleteMismatchChildFile(str, "cyber-media-dex", SDKVersion.VERSION);
                    for (String str2 : b.bD(Integer.MAX_VALUE)) {
                        com.baidu.cyberplayer.sdk.Utils.deleteMismatchChildFile(str, str2, b.b(str2));
                    }
                    CyberCfgManager.getInstance().setPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, System.currentTimeMillis());
                }
            });
        }
    }
}
