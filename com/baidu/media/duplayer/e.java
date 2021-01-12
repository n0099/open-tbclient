package com.baidu.media.duplayer;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.media.duplayer.d;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes14.dex */
public class e {
    private static e ceo;

    /* renamed from: b  reason: collision with root package name */
    private static String f3207b = null;
    private static String c = null;
    private static final Set<String> d = new LinkedHashSet();

    private e() {
    }

    public static synchronized e ZI() {
        e eVar;
        synchronized (e.class) {
            if (ceo == null) {
                f3207b = Utils.f();
                ceo = new e();
            }
            eVar = ceo;
        }
        return eVar;
    }

    private String a(Context context, d dVar) {
        if (dVar.ZH() == d.a.LIB_TYPE_JAR) {
            return (dVar.b().equals(a(dVar.a())) && com.baidu.media.ext.a.c(context.getClassLoader())) ? "apk_internal_jar" : c + File.separator + dVar.a() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.b() + ".jar";
        } else if (dVar.ZH() == d.a.LIB_TYPE_SO) {
            String findLibrary = dVar.b().equals(a(dVar.a())) ? ((BaseDexClassLoader) context.getClassLoader()).findLibrary(dVar.a()) : null;
            return TextUtils.isEmpty(findLibrary) ? c + File.separator + f3207b + File.separator + dVar.a() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.b() + File.separator + "lib" + dVar.a() + PluginInstallerService.APK_LIB_SUFFIX : findLibrary;
        } else {
            return null;
        }
    }

    private String a(String str) {
        return CyberCfgManager.getInstance().getPrefStr(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        try {
            if (!file.isFile() || file.getName().contains(SDKVersion.VERSION)) {
                return;
            }
            file.delete();
        } catch (Exception e) {
        }
    }

    private void b(Context context, String str) {
        c = str + File.separator + "libs";
        for (d dVar : LibsInfoDef.getAllGroupMap().values()) {
            String a2 = a(context, dVar);
            dVar.a(a2);
            if (dVar.ZH() == d.a.LIB_TYPE_SO) {
                File parentFile = new File(a2).getParentFile();
                if (!parentFile.exists() || parentFile.isFile()) {
                    parentFile.mkdirs();
                }
                d.add(parentFile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        File[] listFiles;
        boolean z;
        try {
            for (File file2 : file.listFiles()) {
                Iterator<String> it = d.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().contains(file2.getAbsolutePath())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    Utils.a(file2);
                }
            }
        } catch (Exception e) {
        }
    }

    private void g() {
        for (d dVar : LibsInfoDef.getAllGroupMap().values()) {
            CyberCfgManager.getInstance().setPrefStr(dVar.a(), dVar.b());
        }
    }

    public void a(Context context, String str) {
        if (SDKVersion.VERSION.equals(CyberPlayerManager.getSDKVersion())) {
            g();
        }
        b(context, str);
    }

    public int b(int i) {
        int i2 = (i & 2) == 2 ? 92 : 28;
        if ((i & 4) == 4) {
            i2 |= 32;
        }
        if ((i & 8) == 8) {
            i2 |= 896;
        }
        if ((i & 16) == 16) {
            i2 |= 3;
        }
        return (i & 32) == 32 ? i2 | 2048 : i2;
    }

    public String[] b() {
        return (String[]) d.toArray(new String[d.size()]);
    }

    public String c() {
        return f3207b;
    }

    public String c(int i) {
        d ft = ft(i);
        if (ft == null) {
            return null;
        }
        return f3207b + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ft.a() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ft.b() + ".zip";
    }

    public void d() {
        long prefLong = CyberCfgManager.getInstance().getPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - prefLong > 432000000) {
            CyberCfgManager.getInstance().setPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, currentTimeMillis);
            CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.media.duplayer.e.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    try {
                        for (File file : new File(e.c).listFiles()) {
                            if (file.isFile()) {
                                e.this.a(file);
                            } else if (file.getName().equals(e.f3207b)) {
                                e.this.b(file);
                            } else {
                                Utils.a(file);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    public boolean d(int i) {
        return (i & 28) == i;
    }

    public boolean e(int i) {
        return (i & 32) == i;
    }

    public boolean f(int i) {
        return (i & 64) == i;
    }

    public d ft(int i) {
        return LibsInfoDef.getAllGroupMap().get(Integer.valueOf(i));
    }

    public boolean g(int i) {
        return (i & 896) == i;
    }

    public boolean h(int i) {
        return (i & 2048) == i;
    }

    public boolean i(int i) {
        return (i & 3) == i;
    }
}
