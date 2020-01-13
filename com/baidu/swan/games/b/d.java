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
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    private static d chU;
    private boolean chV;

    /* loaded from: classes10.dex */
    public interface a {
        void cg(boolean z);
    }

    private d() {
        this.chV = DEBUG && com.baidu.swan.apps.ah.a.a.Yc();
    }

    public static d akH() {
        if (chU == null) {
            synchronized (d.class) {
                if (chU == null) {
                    chU = new d();
                }
            }
        }
        return chU;
    }

    private File akI() {
        File file = new File(com.baidu.swan.games.k.a.Rx(), "game_core_console");
        File file2 = (DEBUG && this.chV) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File akJ() {
        return new File(akI(), "res");
    }

    public File akK() {
        return new File(com.baidu.swan.apps.t.e.Ry(), "sConsole-core");
    }

    private File akL() {
        return new File(akI(), "debugGameSconsole.zip");
    }

    private File akM() {
        return new File(akJ(), "swan-game-sconsole.js");
    }

    private File akN() {
        return new File(akJ(), "swan-game-sconsole.version");
    }

    private File akO() {
        return new File(akI(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akP() {
        File akM = akM();
        File akO = akO();
        if (!akO.exists() && akM.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.d.c.readAssetData(com.baidu.swan.apps.w.a.RG(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.d.c.saveFile(String.format(readAssetData, format), akO);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.chV;
            this.chV = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File akL = akL();
            new com.baidu.swan.apps.l.a().a(cVar, akL.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.b.d.1
                @Override // com.baidu.swan.apps.t.e.b
                public void cH(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    File akJ = d.this.akJ();
                    if (akJ.exists()) {
                        com.baidu.swan.d.c.deleteFile(akJ);
                    }
                    boolean unzipFile = com.baidu.swan.d.c.unzipFile(akL.getAbsolutePath(), akJ.getAbsolutePath());
                    if (unzipFile) {
                        d.this.akP();
                        d.this.os(com.baidu.swan.apps.as.h.getFormatDateTime(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.d.c.deleteFile(akL);
                    aVar.cg(unzipFile);
                    d.this.chV = z;
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    aVar.cg(false);
                    d.this.chV = z;
                }
            });
        }
    }

    public void os(String str) {
        File akN = akN();
        if (akN.exists()) {
            com.baidu.swan.d.c.deleteFile(akN);
        }
        com.baidu.swan.d.c.saveFile(str, akN);
    }

    public String akQ() {
        return com.baidu.swan.d.c.readFileData(akN());
    }

    public String akR() {
        try {
            return akO().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean akS() {
        return akM().exists() && akO().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.chV) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.cg(d.this.akS());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(akQ()), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.games.b.d.3
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File KY() {
                    return d.akH().akJ();
                }

                @Override // com.baidu.swan.games.b.b.a
                public void gD(@NonNull String str) {
                    d.akH().os(str);
                }
            }, new b() { // from class: com.baidu.swan.games.b.d.4
                @Override // com.baidu.swan.games.b.b
                public void cf(boolean z) {
                    d.this.akP();
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.cg(d.this.akS());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).en(a.h.aiapps_debug_switch_title).em(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).dw(false).c(a.h.aiapps_ok, onClickListener).ZZ();
    }
}
