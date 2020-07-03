package com.baidu.media.duplayer;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private static e buK;
    private static String b = null;
    private static String c = null;
    private static final Set<String> d = new LinkedHashSet();

    private e() {
    }

    public static synchronized e MO() {
        e eVar;
        synchronized (e.class) {
            if (buK == null) {
                b = Utils.f();
                buK = new e();
            }
            eVar = buK;
        }
        return eVar;
    }

    private String a(Context context, d dVar) {
        String findLibrary = dVar.b().equals(a(dVar.a())) ? ((BaseDexClassLoader) context.getClassLoader()).findLibrary(dVar.a()) : null;
        return TextUtils.isEmpty(findLibrary) ? c + File.separator + b + File.separator + dVar.a() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.b() + File.separator + "lib" + dVar.a() + PluginInstallerService.APK_LIB_SUFFIX : findLibrary;
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
            String a = a(context, dVar);
            dVar.a(a);
            File parentFile = new File(a).getParentFile();
            if (!parentFile.exists() || parentFile.isFile()) {
                parentFile.mkdirs();
            }
            d.add(parentFile.getAbsolutePath());
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

    public String[] MP() {
        return (String[]) d.toArray(new String[d.size()]);
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
        return (i & 16) == 16 ? i2 | 3 : i2;
    }

    public String c() {
        return b;
    }

    public String c(int i) {
        d dM = dM(i);
        if (dM == null) {
            return null;
        }
        return b + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dM.a() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dM.b() + ".zip";
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
                            } else if (file.getName().equals(e.b)) {
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

    public d dM(int i) {
        return LibsInfoDef.getAllGroupMap().get(Integer.valueOf(i));
    }

    public boolean dN(int i) {
        return (i & 896) == i;
    }

    public boolean e(int i) {
        return (i & 32) == i;
    }

    public boolean f(int i) {
        return (i & 64) == i;
    }

    public boolean h(int i) {
        return (i & 3) == i;
    }
}
