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
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dRv;
    private boolean dRw;

    /* loaded from: classes7.dex */
    public interface a {
        void eK(boolean z);
    }

    private d() {
        this.dRw = DEBUG && com.baidu.swan.apps.ad.a.a.aDY();
    }

    public static d aTI() {
        if (dRv == null) {
            synchronized (d.class) {
                if (dRv == null) {
                    dRv = new d();
                }
            }
        }
        return dRv;
    }

    private File aTJ() {
        File file = new File(com.baidu.swan.games.l.a.avI(), "game_core_console");
        File file2 = (DEBUG && this.dRw) ? new File(file, ETAG.KEY_DEBUG) : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aTK() {
        return new File(aTJ(), "res");
    }

    public File aTL() {
        return new File(com.baidu.swan.apps.r.d.avK(), "sConsole-core");
    }

    private File aTM() {
        return new File(aTJ(), "debugGameSconsole.zip");
    }

    private File aTN() {
        return new File(aTK(), "swan-game-sconsole.js");
    }

    private File aTO() {
        return new File(aTK(), "swan-game-sconsole.version");
    }

    private File aTP() {
        return new File(aTJ(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTQ() {
        File aTN = aTN();
        File aTP = aTP();
        if (!aTP.exists() && aTN.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.avS(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aTP);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.dRw;
            this.dRw = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aTM = aTM();
            new com.baidu.swan.apps.l.a().a(cVar, aTM.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void eW(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aTK = d.this.aTK();
                    if (aTK.exists()) {
                        com.baidu.swan.c.d.deleteFile(aTK);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aTM.getAbsolutePath(), aTK.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aTQ();
                        d.this.wB(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aTM);
                    aVar.eK(unzipFile);
                    d.this.dRw = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.eK(false);
                    d.this.dRw = z;
                }
            });
        }
    }

    public void wB(String str) {
        File aTO = aTO();
        if (aTO.exists()) {
            com.baidu.swan.c.d.deleteFile(aTO);
        }
        com.baidu.swan.c.d.saveFile(str, aTO);
    }

    public String aTR() {
        return com.baidu.swan.c.d.readFileData(aTO());
    }

    public String aTS() {
        try {
            return aTP().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aTT() {
        return aTN().exists() && aTP().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.dRw) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.eK(d.this.aTT());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aTR()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File amY() {
                    return d.aTI().aTK();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void mK(@NonNull String str) {
                    d.aTI().wB(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void eI(boolean z) {
                    d.this.aTQ();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.eK(d.this.aTT());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).ib(a.h.aiapps_debug_switch_title).ia(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).gu(false).c(a.h.aiapps_ok, onClickListener).aGt();
    }
}
