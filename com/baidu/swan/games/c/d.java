package com.baidu.swan.games.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import java.io.File;
import java.util.Date;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    private static d daN;
    private boolean daO;

    /* loaded from: classes11.dex */
    public interface a {
        void dD(boolean z);
    }

    private d() {
        this.daO = DEBUG && com.baidu.swan.apps.af.a.a.anm();
    }

    public static d aAi() {
        if (daN == null) {
            synchronized (d.class) {
                if (daN == null) {
                    daN = new d();
                }
            }
        }
        return daN;
    }

    private File aAj() {
        File file = new File(com.baidu.swan.games.l.a.afO(), "game_core_console");
        File file2 = (DEBUG && this.daO) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aAk() {
        return new File(aAj(), "res");
    }

    public File aAl() {
        return new File(com.baidu.swan.apps.r.e.afP(), "sConsole-core");
    }

    private File aAm() {
        return new File(aAj(), "debugGameSconsole.zip");
    }

    private File aAn() {
        return new File(aAk(), "swan-game-sconsole.js");
    }

    private File aAo() {
        return new File(aAk(), "swan-game-sconsole.version");
    }

    private File aAp() {
        return new File(aAj(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAq() {
        File aAn = aAn();
        File aAp = aAp();
        if (!aAp.exists() && aAn.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.e.d.readAssetData(com.baidu.swan.apps.u.a.afX(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.e.d.saveFile(String.format(readAssetData, format), aAp);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.daO;
            this.daO = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File aAm = aAm();
            new com.baidu.swan.apps.k.a().a(cVar, aAm.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.e.b
                public void dE(int i) {
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onSuccess() {
                    File aAk = d.this.aAk();
                    if (aAk.exists()) {
                        com.baidu.swan.e.d.deleteFile(aAk);
                    }
                    boolean unzipFile = com.baidu.swan.e.d.unzipFile(aAm.getAbsolutePath(), aAk.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aAq();
                        d.this.rD(com.baidu.swan.apps.aq.i.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.e.d.deleteFile(aAm);
                    aVar.dD(unzipFile);
                    d.this.daO = z;
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onFailed() {
                    aVar.dD(false);
                    d.this.daO = z;
                }
            });
        }
    }

    public void rD(String str) {
        File aAo = aAo();
        if (aAo.exists()) {
            com.baidu.swan.e.d.deleteFile(aAo);
        }
        com.baidu.swan.e.d.saveFile(str, aAo);
    }

    public String aAr() {
        return com.baidu.swan.e.d.readFileData(aAo());
    }

    public String aAs() {
        try {
            return aAp().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aAt() {
        return aAn().exists() && aAp().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.daO) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.dD(d.this.aAt());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aAr()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File YQ() {
                    return d.aAi().aAk();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void jo(@NonNull String str) {
                    d.aAi().rD(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void dB(boolean z) {
                    d.this.aAq();
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.dD(d.this.aAt());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).fe(a.h.aiapps_debug_switch_title).fd(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).eY(false).c(a.h.aiapps_ok, onClickListener).apu();
    }
}
