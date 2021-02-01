package com.baidu.swan.games.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import java.io.File;
import java.util.Date;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d eeK;
    private boolean eeL;

    /* loaded from: classes9.dex */
    public interface a {
        void fg(boolean z);
    }

    private d() {
        this.eeL = DEBUG && com.baidu.swan.apps.ad.a.a.aFb();
    }

    public static d aVA() {
        if (eeK == null) {
            synchronized (d.class) {
                if (eeK == null) {
                    eeK = new d();
                }
            }
        }
        return eeK;
    }

    private File aVB() {
        File file = new File(com.baidu.swan.games.l.a.awM(), "game_core_console");
        File file2 = (DEBUG && this.eeL) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aVC() {
        return new File(aVB(), "res");
    }

    public File aVD() {
        return new File(com.baidu.swan.apps.r.d.awO(), "sConsole-core");
    }

    private File aVE() {
        return new File(aVB(), "debugGameSconsole.zip");
    }

    private File aVF() {
        return new File(aVC(), "swan-game-sconsole.js");
    }

    private File aVG() {
        return new File(aVC(), "swan-game-sconsole.version");
    }

    private File aVH() {
        return new File(aVB(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVI() {
        File aVF = aVF();
        File aVH = aVH();
        if (!aVH.exists() && aVF.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.awW(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aVH);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.eeL;
            this.eeL = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aVE = aVE();
            new com.baidu.swan.apps.l.a().a(cVar, aVE.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void fn(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aVC = d.this.aVC();
                    if (aVC.exists()) {
                        com.baidu.swan.c.d.deleteFile(aVC);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aVE.getAbsolutePath(), aVC.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aVI();
                        d.this.wp(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aVE);
                    aVar.fg(unzipFile);
                    d.this.eeL = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.fg(false);
                    d.this.eeL = z;
                }
            });
        }
    }

    public void wp(String str) {
        File aVG = aVG();
        if (aVG.exists()) {
            com.baidu.swan.c.d.deleteFile(aVG);
        }
        com.baidu.swan.c.d.saveFile(str, aVG);
    }

    public String aVJ() {
        return com.baidu.swan.c.d.readFileData(aVG());
    }

    public String aVK() {
        try {
            return aVH().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aVL() {
        return aVF().exists() && aVH().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.eeL) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.fg(d.this.aVL());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aVJ()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File anW() {
                    return d.aVA().aVC();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void mr(@NonNull String str) {
                    d.aVA().wp(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void fe(boolean z) {
                    d.this.aVI();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.fg(d.this.aVL());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).gR(a.h.aiapps_debug_switch_title).gQ(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_ok, onClickListener).aHX();
    }
}
