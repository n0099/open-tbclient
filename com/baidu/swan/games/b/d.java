package com.baidu.swan.games.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.t.e;
import java.io.File;
import java.util.Date;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    private static d clZ;
    private boolean cma;

    /* loaded from: classes11.dex */
    public interface a {
        void cn(boolean z);
    }

    private d() {
        this.cma = DEBUG && com.baidu.swan.apps.ah.a.a.aas();
    }

    public static d amX() {
        if (clZ == null) {
            synchronized (d.class) {
                if (clZ == null) {
                    clZ = new d();
                }
            }
        }
        return clZ;
    }

    private File amY() {
        File file = new File(com.baidu.swan.games.k.a.TN(), "game_core_console");
        File file2 = (DEBUG && this.cma) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File amZ() {
        return new File(amY(), "res");
    }

    public File ana() {
        return new File(com.baidu.swan.apps.t.e.TO(), "sConsole-core");
    }

    private File anb() {
        return new File(amY(), "debugGameSconsole.zip");
    }

    private File anc() {
        return new File(amZ(), "swan-game-sconsole.js");
    }

    private File and() {
        return new File(amZ(), "swan-game-sconsole.version");
    }

    private File ane() {
        return new File(amY(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anf() {
        File anc = anc();
        File ane = ane();
        if (!ane.exists() && anc.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.d.c.readAssetData(com.baidu.swan.apps.w.a.TW(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.d.c.saveFile(String.format(readAssetData, format), ane);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.cma;
            this.cma = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File anb = anb();
            new com.baidu.swan.apps.l.a().a(cVar, anb.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.b.d.1
                @Override // com.baidu.swan.apps.t.e.b
                public void cX(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    File amZ = d.this.amZ();
                    if (amZ.exists()) {
                        com.baidu.swan.d.c.deleteFile(amZ);
                    }
                    boolean unzipFile = com.baidu.swan.d.c.unzipFile(anb.getAbsolutePath(), amZ.getAbsolutePath());
                    if (unzipFile) {
                        d.this.anf();
                        d.this.oH(com.baidu.swan.apps.as.h.getFormatDateTime(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.d.c.deleteFile(anb);
                    aVar.cn(unzipFile);
                    d.this.cma = z;
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    aVar.cn(false);
                    d.this.cma = z;
                }
            });
        }
    }

    public void oH(String str) {
        File and = and();
        if (and.exists()) {
            com.baidu.swan.d.c.deleteFile(and);
        }
        com.baidu.swan.d.c.saveFile(str, and);
    }

    public String ang() {
        return com.baidu.swan.d.c.readFileData(and());
    }

    public String anh() {
        try {
            return ane().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean ani() {
        return anc().exists() && ane().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.cma) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.cn(d.this.ani());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(ang()), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.games.b.d.3
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File Np() {
                    return d.amX().amZ();
                }

                @Override // com.baidu.swan.games.b.b.a
                public void gS(@NonNull String str) {
                    d.amX().oH(str);
                }
            }, new b() { // from class: com.baidu.swan.games.b.d.4
                @Override // com.baidu.swan.games.b.b
                public void cm(boolean z) {
                    d.this.anf();
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.cn(d.this.ani());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).eD(a.h.aiapps_debug_switch_title).eC(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).dD(false).c(a.h.aiapps_ok, onClickListener).acp();
    }
}
