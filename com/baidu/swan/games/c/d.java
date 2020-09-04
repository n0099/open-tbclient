package com.baidu.swan.games.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.Date;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dqJ;
    private boolean dqK;

    /* loaded from: classes8.dex */
    public interface a {
        void dR(boolean z);
    }

    private d() {
        this.dqK = DEBUG && com.baidu.swan.apps.ad.a.a.awS();
    }

    public static d aMC() {
        if (dqJ == null) {
            synchronized (d.class) {
                if (dqJ == null) {
                    dqJ = new d();
                }
            }
        }
        return dqJ;
    }

    private File aMD() {
        File file = new File(com.baidu.swan.games.l.a.aoz(), "game_core_console");
        File file2 = (DEBUG && this.dqK) ? new File(file, ETAG.KEY_DEBUG) : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aME() {
        return new File(aMD(), "res");
    }

    public File aMF() {
        return new File(com.baidu.swan.apps.r.d.aoB(), "sConsole-core");
    }

    private File aMG() {
        return new File(aMD(), "debugGameSconsole.zip");
    }

    private File aMH() {
        return new File(aME(), "swan-game-sconsole.js");
    }

    private File aMI() {
        return new File(aME(), "swan-game-sconsole.version");
    }

    private File aMJ() {
        return new File(aMD(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMK() {
        File aMH = aMH();
        File aMJ = aMJ();
        if (!aMJ.exists() && aMH.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.aoJ(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aMJ);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.dqK;
            this.dqK = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aMG = aMG();
            new com.baidu.swan.apps.l.a().a(cVar, aMG.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void fy(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aME = d.this.aME();
                    if (aME.exists()) {
                        com.baidu.swan.c.d.deleteFile(aME);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aMG.getAbsolutePath(), aME.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aMK();
                        d.this.uU(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aMG);
                    aVar.dR(unzipFile);
                    d.this.dqK = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.dR(false);
                    d.this.dqK = z;
                }
            });
        }
    }

    public void uU(String str) {
        File aMI = aMI();
        if (aMI.exists()) {
            com.baidu.swan.c.d.deleteFile(aMI);
        }
        com.baidu.swan.c.d.saveFile(str, aMI);
    }

    public String aML() {
        return com.baidu.swan.c.d.readFileData(aMI());
    }

    public String aMM() {
        try {
            return aMJ().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aMN() {
        return aMH().exists() && aMJ().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.dqK) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.dR(d.this.aMN());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aML()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File afR() {
                    return d.aMC().aME();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void ld(@NonNull String str) {
                    d.aMC().uU(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void dP(boolean z) {
                    d.this.aMK();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.dR(d.this.aMN());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).he(a.h.aiapps_debug_switch_title).hd(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).fB(false).c(a.h.aiapps_ok, onClickListener).azp();
    }
}
