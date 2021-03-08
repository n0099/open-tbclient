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
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.Date;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d egm;
    private boolean egn;

    /* loaded from: classes8.dex */
    public interface a {
        void fg(boolean z);
    }

    private d() {
        this.egn = DEBUG && com.baidu.swan.apps.ad.a.a.aFe();
    }

    public static d aVD() {
        if (egm == null) {
            synchronized (d.class) {
                if (egm == null) {
                    egm = new d();
                }
            }
        }
        return egm;
    }

    private File aVE() {
        File file = new File(com.baidu.swan.games.l.a.awP(), "game_core_console");
        File file2 = (DEBUG && this.egn) ? new File(file, ETAG.KEY_DEBUG) : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aVF() {
        return new File(aVE(), "res");
    }

    public File aVG() {
        return new File(com.baidu.swan.apps.r.d.awR(), "sConsole-core");
    }

    private File aVH() {
        return new File(aVE(), "debugGameSconsole.zip");
    }

    private File aVI() {
        return new File(aVF(), "swan-game-sconsole.js");
    }

    private File aVJ() {
        return new File(aVF(), "swan-game-sconsole.version");
    }

    private File aVK() {
        return new File(aVE(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVL() {
        File aVI = aVI();
        File aVK = aVK();
        if (!aVK.exists() && aVI.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.awZ(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aVK);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.egn;
            this.egn = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aVH = aVH();
            new com.baidu.swan.apps.l.a().a(cVar, aVH.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void fo(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aVF = d.this.aVF();
                    if (aVF.exists()) {
                        com.baidu.swan.c.d.deleteFile(aVF);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aVH.getAbsolutePath(), aVF.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aVL();
                        d.this.ww(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aVH);
                    aVar.fg(unzipFile);
                    d.this.egn = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.fg(false);
                    d.this.egn = z;
                }
            });
        }
    }

    public void ww(String str) {
        File aVJ = aVJ();
        if (aVJ.exists()) {
            com.baidu.swan.c.d.deleteFile(aVJ);
        }
        com.baidu.swan.c.d.saveFile(str, aVJ);
    }

    public String aVM() {
        return com.baidu.swan.c.d.readFileData(aVJ());
    }

    public String aVN() {
        try {
            return aVK().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aVO() {
        return aVI().exists() && aVK().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.egn) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.fg(d.this.aVO());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aVM()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File anZ() {
                    return d.aVD().aVF();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void my(@NonNull String str) {
                    d.aVD().ww(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void fe(boolean z) {
                    d.this.aVL();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.fg(d.this.aVO());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).gS(a.h.aiapps_debug_switch_title).gR(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_ok, onClickListener).aIa();
    }
}
