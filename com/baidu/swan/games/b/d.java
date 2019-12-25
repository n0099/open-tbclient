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
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    private static d chH;
    private boolean chI;

    /* loaded from: classes9.dex */
    public interface a {
        void cb(boolean z);
    }

    private d() {
        this.chI = DEBUG && com.baidu.swan.apps.ah.a.a.XF();
    }

    public static d ako() {
        if (chH == null) {
            synchronized (d.class) {
                if (chH == null) {
                    chH = new d();
                }
            }
        }
        return chH;
    }

    private File akp() {
        File file = new File(com.baidu.swan.games.k.a.Rb(), "game_core_console");
        File file2 = (DEBUG && this.chI) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File akq() {
        return new File(akp(), "res");
    }

    public File akr() {
        return new File(com.baidu.swan.apps.t.e.Rc(), "sConsole-core");
    }

    private File aks() {
        return new File(akp(), "debugGameSconsole.zip");
    }

    private File akt() {
        return new File(akq(), "swan-game-sconsole.js");
    }

    private File aku() {
        return new File(akq(), "swan-game-sconsole.version");
    }

    private File akv() {
        return new File(akp(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akw() {
        File akt = akt();
        File akv = akv();
        if (!akv.exists() && akt.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.d.c.readAssetData(com.baidu.swan.apps.w.a.Rk(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.d.c.saveFile(String.format(readAssetData, format), akv);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.chI;
            this.chI = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File aks = aks();
            new com.baidu.swan.apps.l.a().a(cVar, aks.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.b.d.1
                @Override // com.baidu.swan.apps.t.e.b
                public void cG(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    File akq = d.this.akq();
                    if (akq.exists()) {
                        com.baidu.swan.d.c.deleteFile(akq);
                    }
                    boolean unzipFile = com.baidu.swan.d.c.unzipFile(aks.getAbsolutePath(), akq.getAbsolutePath());
                    if (unzipFile) {
                        d.this.akw();
                        d.this.op(com.baidu.swan.apps.as.h.getFormatDateTime(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.d.c.deleteFile(aks);
                    aVar.cb(unzipFile);
                    d.this.chI = z;
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    aVar.cb(false);
                    d.this.chI = z;
                }
            });
        }
    }

    public void op(String str) {
        File aku = aku();
        if (aku.exists()) {
            com.baidu.swan.d.c.deleteFile(aku);
        }
        com.baidu.swan.d.c.saveFile(str, aku);
    }

    public String akx() {
        return com.baidu.swan.d.c.readFileData(aku());
    }

    public String aky() {
        try {
            return akv().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean akz() {
        return akt().exists() && akv().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.chI) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.cb(d.this.akz());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(akx()), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.games.b.d.3
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File KC() {
                    return d.ako().akq();
                }

                @Override // com.baidu.swan.games.b.b.a
                public void gA(@NonNull String str) {
                    d.ako().op(str);
                }
            }, new b() { // from class: com.baidu.swan.games.b.d.4
                @Override // com.baidu.swan.games.b.b
                public void ca(boolean z) {
                    d.this.akw();
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.cb(d.this.akz());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).em(a.h.aiapps_debug_switch_title).el(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).dr(false).c(a.h.aiapps_ok, onClickListener).ZC();
    }
}
