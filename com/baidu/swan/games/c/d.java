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
/* loaded from: classes25.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dYt;
    private boolean dYu;

    /* loaded from: classes25.dex */
    public interface a {
        void eZ(boolean z);
    }

    private d() {
        this.dYu = DEBUG && com.baidu.swan.apps.ad.a.a.aHg();
    }

    public static d aWN() {
        if (dYt == null) {
            synchronized (d.class) {
                if (dYt == null) {
                    dYt = new d();
                }
            }
        }
        return dYt;
    }

    private File aWO() {
        File file = new File(com.baidu.swan.games.l.a.ayQ(), "game_core_console");
        File file2 = (DEBUG && this.dYu) ? new File(file, ETAG.KEY_DEBUG) : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aWP() {
        return new File(aWO(), "res");
    }

    public File aWQ() {
        return new File(com.baidu.swan.apps.r.d.ayS(), "sConsole-core");
    }

    private File aWR() {
        return new File(aWO(), "debugGameSconsole.zip");
    }

    private File aWS() {
        return new File(aWP(), "swan-game-sconsole.js");
    }

    private File aWT() {
        return new File(aWP(), "swan-game-sconsole.version");
    }

    private File aWU() {
        return new File(aWO(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWV() {
        File aWS = aWS();
        File aWU = aWU();
        if (!aWU.exists() && aWS.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.aza(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aWU);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.dYu;
            this.dYu = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aWR = aWR();
            new com.baidu.swan.apps.l.a().a(cVar, aWR.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void fu(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aWP = d.this.aWP();
                    if (aWP.exists()) {
                        com.baidu.swan.c.d.deleteFile(aWP);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aWR.getAbsolutePath(), aWP.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aWV();
                        d.this.xi(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aWR);
                    aVar.eZ(unzipFile);
                    d.this.dYu = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.eZ(false);
                    d.this.dYu = z;
                }
            });
        }
    }

    public void xi(String str) {
        File aWT = aWT();
        if (aWT.exists()) {
            com.baidu.swan.c.d.deleteFile(aWT);
        }
        com.baidu.swan.c.d.saveFile(str, aWT);
    }

    public String aWW() {
        return com.baidu.swan.c.d.readFileData(aWT());
    }

    public String aWX() {
        try {
            return aWU().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aWY() {
        return aWS().exists() && aWU().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.dYu) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.eZ(d.this.aWY());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aWW()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File aqg() {
                    return d.aWN().aWP();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void nr(@NonNull String str) {
                    d.aWN().xi(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void eX(boolean z) {
                    d.this.aWV();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.eZ(d.this.aWY());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).iz(a.h.aiapps_debug_switch_title).iy(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).gJ(false).c(a.h.aiapps_ok, onClickListener).aJB();
    }
}
