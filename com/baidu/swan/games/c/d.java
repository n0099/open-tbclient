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
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dEO;
    private boolean dEP;

    /* loaded from: classes10.dex */
    public interface a {
        void el(boolean z);
    }

    private d() {
        this.dEP = DEBUG && com.baidu.swan.apps.ad.a.a.aAm();
    }

    public static d aPW() {
        if (dEO == null) {
            synchronized (d.class) {
                if (dEO == null) {
                    dEO = new d();
                }
            }
        }
        return dEO;
    }

    private File aPX() {
        File file = new File(com.baidu.swan.games.l.a.arV(), "game_core_console");
        File file2 = (DEBUG && this.dEP) ? new File(file, ETAG.KEY_DEBUG) : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aPY() {
        return new File(aPX(), "res");
    }

    public File aPZ() {
        return new File(com.baidu.swan.apps.r.d.arX(), "sConsole-core");
    }

    private File aQa() {
        return new File(aPX(), "debugGameSconsole.zip");
    }

    private File aQb() {
        return new File(aPY(), "swan-game-sconsole.js");
    }

    private File aQc() {
        return new File(aPY(), "swan-game-sconsole.version");
    }

    private File aQd() {
        return new File(aPX(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQe() {
        File aQb = aQb();
        File aQd = aQd();
        if (!aQd.exists() && aQb.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.asf(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aQd);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.dEP;
            this.dEP = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aQa = aQa();
            new com.baidu.swan.apps.l.a().a(cVar, aQa.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void eX(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aPY = d.this.aPY();
                    if (aPY.exists()) {
                        com.baidu.swan.c.d.deleteFile(aPY);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aQa.getAbsolutePath(), aPY.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aQe();
                        d.this.vZ(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aQa);
                    aVar.el(unzipFile);
                    d.this.dEP = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.el(false);
                    d.this.dEP = z;
                }
            });
        }
    }

    public void vZ(String str) {
        File aQc = aQc();
        if (aQc.exists()) {
            com.baidu.swan.c.d.deleteFile(aQc);
        }
        com.baidu.swan.c.d.saveFile(str, aQc);
    }

    public String aQf() {
        return com.baidu.swan.c.d.readFileData(aQc());
    }

    public String aQg() {
        try {
            return aQd().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aQh() {
        return aQb().exists() && aQd().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.dEP) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.el(d.this.aQh());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aQf()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File ajm() {
                    return d.aPW().aPY();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void mi(@NonNull String str) {
                    d.aPW().vZ(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void ej(boolean z) {
                    d.this.aQe();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.el(d.this.aQh());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).hK(a.h.aiapps_debug_switch_title).hJ(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).fV(false).c(a.h.aiapps_ok, onClickListener).aCH();
    }
}
