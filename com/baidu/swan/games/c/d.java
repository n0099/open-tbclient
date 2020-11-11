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
    private static d dTd;
    private boolean dTe;

    /* loaded from: classes10.dex */
    public interface a {
        void eH(boolean z);
    }

    private d() {
        this.dTe = DEBUG && com.baidu.swan.apps.ad.a.a.aEG();
    }

    public static d aUq() {
        if (dTd == null) {
            synchronized (d.class) {
                if (dTd == null) {
                    dTd = new d();
                }
            }
        }
        return dTd;
    }

    private File aUr() {
        File file = new File(com.baidu.swan.games.l.a.awq(), "game_core_console");
        File file2 = (DEBUG && this.dTe) ? new File(file, ETAG.KEY_DEBUG) : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aUs() {
        return new File(aUr(), "res");
    }

    public File aUt() {
        return new File(com.baidu.swan.apps.r.d.aws(), "sConsole-core");
    }

    private File aUu() {
        return new File(aUr(), "debugGameSconsole.zip");
    }

    private File aUv() {
        return new File(aUs(), "swan-game-sconsole.js");
    }

    private File aUw() {
        return new File(aUs(), "swan-game-sconsole.version");
    }

    private File aUx() {
        return new File(aUr(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUy() {
        File aUv = aUv();
        File aUx = aUx();
        if (!aUx.exists() && aUv.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.awA(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aUx);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.dTe;
            this.dTe = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aUu = aUu();
            new com.baidu.swan.apps.l.a().a(cVar, aUu.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void fa(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aUs = d.this.aUs();
                    if (aUs.exists()) {
                        com.baidu.swan.c.d.deleteFile(aUs);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aUu.getAbsolutePath(), aUs.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aUy();
                        d.this.wG(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aUu);
                    aVar.eH(unzipFile);
                    d.this.dTe = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.eH(false);
                    d.this.dTe = z;
                }
            });
        }
    }

    public void wG(String str) {
        File aUw = aUw();
        if (aUw.exists()) {
            com.baidu.swan.c.d.deleteFile(aUw);
        }
        com.baidu.swan.c.d.saveFile(str, aUw);
    }

    public String aUz() {
        return com.baidu.swan.c.d.readFileData(aUw());
    }

    public String aUA() {
        try {
            return aUx().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aUB() {
        return aUv().exists() && aUx().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.dTe) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.eH(d.this.aUB());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aUz()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File anG() {
                    return d.aUq().aUs();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void mQ(@NonNull String str) {
                    d.aUq().wG(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void eF(boolean z) {
                    d.this.aUy();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.eH(d.this.aUB());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).mo33if(a.h.aiapps_debug_switch_title).ie(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).gr(false).c(a.h.aiapps_ok, onClickListener).aHb();
    }
}
