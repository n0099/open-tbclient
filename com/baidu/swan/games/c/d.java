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
    private static d cWb;
    private boolean cWc;

    /* loaded from: classes11.dex */
    public interface a {
        void dy(boolean z);
    }

    private d() {
        this.cWc = DEBUG && com.baidu.swan.apps.af.a.a.amg();
    }

    public static d azc() {
        if (cWb == null) {
            synchronized (d.class) {
                if (cWb == null) {
                    cWb = new d();
                }
            }
        }
        return cWb;
    }

    private File azd() {
        File file = new File(com.baidu.swan.games.l.a.aeI(), "game_core_console");
        File file2 = (DEBUG && this.cWc) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aze() {
        return new File(azd(), "res");
    }

    public File azf() {
        return new File(com.baidu.swan.apps.r.e.aeJ(), "sConsole-core");
    }

    private File azg() {
        return new File(azd(), "debugGameSconsole.zip");
    }

    private File azh() {
        return new File(aze(), "swan-game-sconsole.js");
    }

    private File azi() {
        return new File(aze(), "swan-game-sconsole.version");
    }

    private File azj() {
        return new File(azd(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azk() {
        File azh = azh();
        File azj = azj();
        if (!azj.exists() && azh.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.e.d.readAssetData(com.baidu.swan.apps.u.a.aeR(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.e.d.saveFile(String.format(readAssetData, format), azj);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.cWc;
            this.cWc = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File azg = azg();
            new com.baidu.swan.apps.k.a().a(cVar, azg.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.e.b
                public void dr(int i) {
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onSuccess() {
                    File aze = d.this.aze();
                    if (aze.exists()) {
                        com.baidu.swan.e.d.deleteFile(aze);
                    }
                    boolean unzipFile = com.baidu.swan.e.d.unzipFile(azg.getAbsolutePath(), aze.getAbsolutePath());
                    if (unzipFile) {
                        d.this.azk();
                        d.this.rv(com.baidu.swan.apps.aq.i.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.e.d.deleteFile(azg);
                    aVar.dy(unzipFile);
                    d.this.cWc = z;
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onFailed() {
                    aVar.dy(false);
                    d.this.cWc = z;
                }
            });
        }
    }

    public void rv(String str) {
        File azi = azi();
        if (azi.exists()) {
            com.baidu.swan.e.d.deleteFile(azi);
        }
        com.baidu.swan.e.d.saveFile(str, azi);
    }

    public String azl() {
        return com.baidu.swan.e.d.readFileData(azi());
    }

    public String azm() {
        try {
            return azj().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean azn() {
        return azh().exists() && azj().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.cWc) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.dy(d.this.azn());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(azl()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File XK() {
                    return d.azc().aze();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void jg(@NonNull String str) {
                    d.azc().rv(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void dw(boolean z) {
                    d.this.azk();
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.dy(d.this.azn());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).eR(a.h.aiapps_debug_switch_title).eQ(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).eT(false).c(a.h.aiapps_ok, onClickListener).aon();
    }
}
