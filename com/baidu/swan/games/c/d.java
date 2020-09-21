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
/* loaded from: classes3.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dsM;
    private boolean dsN;

    /* loaded from: classes3.dex */
    public interface a {
        void dP(boolean z);
    }

    private d() {
        this.dsN = DEBUG && com.baidu.swan.apps.ad.a.a.axB();
    }

    public static d aNn() {
        if (dsM == null) {
            synchronized (d.class) {
                if (dsM == null) {
                    dsM = new d();
                }
            }
        }
        return dsM;
    }

    private File aNo() {
        File file = new File(com.baidu.swan.games.l.a.apk(), "game_core_console");
        File file2 = (DEBUG && this.dsN) ? new File(file, ETAG.KEY_DEBUG) : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aNp() {
        return new File(aNo(), "res");
    }

    public File aNq() {
        return new File(com.baidu.swan.apps.r.d.apm(), "sConsole-core");
    }

    private File aNr() {
        return new File(aNo(), "debugGameSconsole.zip");
    }

    private File aNs() {
        return new File(aNp(), "swan-game-sconsole.js");
    }

    private File aNt() {
        return new File(aNp(), "swan-game-sconsole.version");
    }

    private File aNu() {
        return new File(aNo(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNv() {
        File aNs = aNs();
        File aNu = aNu();
        if (!aNu.exists() && aNs.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.apu(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aNu);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.dsN;
            this.dsN = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aNr = aNr();
            new com.baidu.swan.apps.l.a().a(cVar, aNr.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void eO(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aNp = d.this.aNp();
                    if (aNp.exists()) {
                        com.baidu.swan.c.d.deleteFile(aNp);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aNr.getAbsolutePath(), aNp.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aNv();
                        d.this.vn(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aNr);
                    aVar.dP(unzipFile);
                    d.this.dsN = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.dP(false);
                    d.this.dsN = z;
                }
            });
        }
    }

    public void vn(String str) {
        File aNt = aNt();
        if (aNt.exists()) {
            com.baidu.swan.c.d.deleteFile(aNt);
        }
        com.baidu.swan.c.d.saveFile(str, aNt);
    }

    public String aNw() {
        return com.baidu.swan.c.d.readFileData(aNt());
    }

    public String aNx() {
        try {
            return aNu().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aNy() {
        return aNs().exists() && aNu().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.dsN) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.dP(d.this.aNy());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aNw()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File agB() {
                    return d.aNn().aNp();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void lw(@NonNull String str) {
                    d.aNn().vn(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void dN(boolean z) {
                    d.this.aNv();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.dP(d.this.aNy());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).hn(a.h.aiapps_debug_switch_title).hm(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).fz(false).c(a.h.aiapps_ok, onClickListener).azY();
    }
}
