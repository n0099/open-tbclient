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
    private static d ehq;
    private boolean ehr;

    /* loaded from: classes9.dex */
    public interface a {
        void fi(boolean z);
    }

    private d() {
        this.ehr = DEBUG && com.baidu.swan.apps.ad.a.a.aIz();
    }

    public static d aZh() {
        if (ehq == null) {
            synchronized (d.class) {
                if (ehq == null) {
                    ehq = new d();
                }
            }
        }
        return ehq;
    }

    private File aZi() {
        File file = new File(com.baidu.swan.games.l.a.aAh(), "game_core_console");
        File file2 = (DEBUG && this.ehr) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aZj() {
        return new File(aZi(), "res");
    }

    public File aZk() {
        return new File(com.baidu.swan.apps.r.d.aAj(), "sConsole-core");
    }

    private File aZl() {
        return new File(aZi(), "debugGameSconsole.zip");
    }

    private File aZm() {
        return new File(aZj(), "swan-game-sconsole.js");
    }

    private File aZn() {
        return new File(aZj(), "swan-game-sconsole.version");
    }

    private File aZo() {
        return new File(aZi(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZp() {
        File aZm = aZm();
        File aZo = aZo();
        if (!aZo.exists() && aZm.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.aAr(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aZo);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.ehr;
            this.ehr = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aZl = aZl();
            new com.baidu.swan.apps.l.a().a(cVar, aZl.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void fu(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aZj = d.this.aZj();
                    if (aZj.exists()) {
                        com.baidu.swan.c.d.deleteFile(aZj);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aZl.getAbsolutePath(), aZj.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aZp();
                        d.this.xh(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aZl);
                    aVar.fi(unzipFile);
                    d.this.ehr = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.fi(false);
                    d.this.ehr = z;
                }
            });
        }
    }

    public void xh(String str) {
        File aZn = aZn();
        if (aZn.exists()) {
            com.baidu.swan.c.d.deleteFile(aZn);
        }
        com.baidu.swan.c.d.saveFile(str, aZn);
    }

    public String aZq() {
        return com.baidu.swan.c.d.readFileData(aZn());
    }

    public String aZr() {
        try {
            return aZo().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aZs() {
        return aZm().exists() && aZo().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.ehr) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.fi(d.this.aZs());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aZq()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File ars() {
                    return d.aZh().aZj();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void nk(@NonNull String str) {
                    d.aZh().xh(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void fg(boolean z) {
                    d.this.aZp();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.fi(d.this.aZs());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).iu(a.h.aiapps_debug_switch_title).it(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).gV(false).c(a.h.aiapps_ok, onClickListener).aLx();
    }
}
