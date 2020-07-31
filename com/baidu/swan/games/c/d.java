package com.baidu.swan.games.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import java.io.File;
import java.util.Date;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    private static d dgw;
    private boolean dgx;

    /* loaded from: classes7.dex */
    public interface a {
        void dG(boolean z);
    }

    private d() {
        this.dgx = DEBUG && com.baidu.swan.apps.ae.a.a.aoV();
    }

    public static d aDN() {
        if (dgw == null) {
            synchronized (d.class) {
                if (dgw == null) {
                    dgw = new d();
                }
            }
        }
        return dgw;
    }

    private File aDO() {
        File file = new File(com.baidu.swan.games.l.a.agZ(), "game_core_console");
        File file2 = (DEBUG && this.dgx) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aDP() {
        return new File(aDO(), "res");
    }

    public File aDQ() {
        return new File(com.baidu.swan.apps.r.d.ahb(), "sConsole-core");
    }

    private File aDR() {
        return new File(aDO(), "debugGameSconsole.zip");
    }

    private File aDS() {
        return new File(aDP(), "swan-game-sconsole.js");
    }

    private File aDT() {
        return new File(aDP(), "swan-game-sconsole.version");
    }

    private File aDU() {
        return new File(aDO(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDV() {
        File aDS = aDS();
        File aDU = aDU();
        if (!aDU.exists() && aDS.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.d.d.readAssetData(com.baidu.swan.apps.t.a.ahj(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.d.d.saveFile(String.format(readAssetData, format), aDU);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.dgx;
            this.dgx = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aDR = aDR();
            new com.baidu.swan.apps.k.a().a(cVar, aDR.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void dE(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aDP = d.this.aDP();
                    if (aDP.exists()) {
                        com.baidu.swan.d.d.deleteFile(aDP);
                    }
                    boolean unzipFile = com.baidu.swan.d.d.unzipFile(aDR.getAbsolutePath(), aDP.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aDV();
                        d.this.sC(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.d.d.deleteFile(aDR);
                    aVar.dG(unzipFile);
                    d.this.dgx = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.dG(false);
                    d.this.dgx = z;
                }
            });
        }
    }

    public void sC(String str) {
        File aDT = aDT();
        if (aDT.exists()) {
            com.baidu.swan.d.d.deleteFile(aDT);
        }
        com.baidu.swan.d.d.saveFile(str, aDT);
    }

    public String aDW() {
        return com.baidu.swan.d.d.readFileData(aDT());
    }

    public String aDX() {
        try {
            return aDU().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aDY() {
        return aDS().exists() && aDU().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.dgx) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.dG(d.this.aDY());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aDW()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File ZI() {
                    return d.aDN().aDP();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void jD(@NonNull String str) {
                    d.aDN().sC(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void dE(boolean z) {
                    d.this.aDV();
                    al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.dG(d.this.aDY());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).fi(a.h.aiapps_debug_switch_title).fh(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).fh(false).c(a.h.aiapps_ok, onClickListener).ard();
    }
}
