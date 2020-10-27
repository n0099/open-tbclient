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
    private static d dNl;
    private boolean dNm;

    /* loaded from: classes10.dex */
    public interface a {
        void ey(boolean z);
    }

    private d() {
        this.dNm = DEBUG && com.baidu.swan.apps.ad.a.a.aCg();
    }

    public static d aRQ() {
        if (dNl == null) {
            synchronized (d.class) {
                if (dNl == null) {
                    dNl = new d();
                }
            }
        }
        return dNl;
    }

    private File aRR() {
        File file = new File(com.baidu.swan.games.l.a.atQ(), "game_core_console");
        File file2 = (DEBUG && this.dNm) ? new File(file, ETAG.KEY_DEBUG) : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aRS() {
        return new File(aRR(), "res");
    }

    public File aRT() {
        return new File(com.baidu.swan.apps.r.d.atS(), "sConsole-core");
    }

    private File aRU() {
        return new File(aRR(), "debugGameSconsole.zip");
    }

    private File aRV() {
        return new File(aRS(), "swan-game-sconsole.js");
    }

    private File aRW() {
        return new File(aRS(), "swan-game-sconsole.version");
    }

    private File aRX() {
        return new File(aRR(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRY() {
        File aRV = aRV();
        File aRX = aRX();
        if (!aRX.exists() && aRV.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.aua(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aRX);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.dNm;
            this.dNm = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aRU = aRU();
            new com.baidu.swan.apps.l.a().a(cVar, aRU.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void fa(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aRS = d.this.aRS();
                    if (aRS.exists()) {
                        com.baidu.swan.c.d.deleteFile(aRS);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aRU.getAbsolutePath(), aRS.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aRY();
                        d.this.ws(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aRU);
                    aVar.ey(unzipFile);
                    d.this.dNm = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.ey(false);
                    d.this.dNm = z;
                }
            });
        }
    }

    public void ws(String str) {
        File aRW = aRW();
        if (aRW.exists()) {
            com.baidu.swan.c.d.deleteFile(aRW);
        }
        com.baidu.swan.c.d.saveFile(str, aRW);
    }

    public String aRZ() {
        return com.baidu.swan.c.d.readFileData(aRW());
    }

    public String aSa() {
        try {
            return aRX().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aSb() {
        return aRV().exists() && aRX().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.dNm) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.ey(d.this.aSb());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aRZ()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File alg() {
                    return d.aRQ().aRS();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void mB(@NonNull String str) {
                    d.aRQ().ws(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void ew(boolean z) {
                    d.this.aRY();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.ey(d.this.aSb());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).hV(a.h.aiapps_debug_switch_title).hU(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).gi(false).c(a.h.aiapps_ok, onClickListener).aEB();
    }
}
