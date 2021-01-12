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
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d ecD;
    private boolean ecE;

    /* loaded from: classes8.dex */
    public interface a {
        void fe(boolean z);
    }

    private d() {
        this.ecE = DEBUG && com.baidu.swan.apps.ad.a.a.aEG();
    }

    public static d aVo() {
        if (ecD == null) {
            synchronized (d.class) {
                if (ecD == null) {
                    ecD = new d();
                }
            }
        }
        return ecD;
    }

    private File aVp() {
        File file = new File(com.baidu.swan.games.l.a.awo(), "game_core_console");
        File file2 = (DEBUG && this.ecE) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File aVq() {
        return new File(aVp(), "res");
    }

    public File aVr() {
        return new File(com.baidu.swan.apps.r.d.awq(), "sConsole-core");
    }

    private File aVs() {
        return new File(aVp(), "debugGameSconsole.zip");
    }

    private File aVt() {
        return new File(aVq(), "swan-game-sconsole.js");
    }

    private File aVu() {
        return new File(aVq(), "swan-game-sconsole.version");
    }

    private File aVv() {
        return new File(aVp(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVw() {
        File aVt = aVt();
        File aVv = aVv();
        if (!aVv.exists() && aVt.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.c.d.readAssetData(com.baidu.swan.apps.t.a.awy(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.c.d.saveFile(String.format(readAssetData, format), aVv);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.ecE;
            this.ecE = true;
            d.c cVar = new d.c();
            cVar.mDownloadUrl = str;
            final File aVs = aVs();
            new com.baidu.swan.apps.l.a().a(cVar, aVs.getAbsolutePath(), new d.b() { // from class: com.baidu.swan.games.c.d.1
                @Override // com.baidu.swan.apps.r.d.b
                public void dO(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File aVq = d.this.aVq();
                    if (aVq.exists()) {
                        com.baidu.swan.c.d.deleteFile(aVq);
                    }
                    boolean unzipFile = com.baidu.swan.c.d.unzipFile(aVs.getAbsolutePath(), aVq.getAbsolutePath());
                    if (unzipFile) {
                        d.this.aVw();
                        d.this.vW(j.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.d.deleteFile(aVs);
                    aVar.fe(unzipFile);
                    d.this.ecE = z;
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    aVar.fe(false);
                    d.this.ecE = z;
                }
            });
        }
    }

    public void vW(String str) {
        File aVu = aVu();
        if (aVu.exists()) {
            com.baidu.swan.c.d.deleteFile(aVu);
        }
        com.baidu.swan.c.d.saveFile(str, aVu);
    }

    public String aVx() {
        return com.baidu.swan.c.d.readFileData(aVu());
    }

    public String aVy() {
        try {
            return aVv().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean aVz() {
        return aVt().exists() && aVv().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.ecE) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.fe(d.this.aVz());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(aVx()), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.games.c.d.3
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File any() {
                    return d.aVo().aVq();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void lZ(@NonNull String str) {
                    d.aVo().vW(str);
                }
            }, new b() { // from class: com.baidu.swan.games.c.d.4
                @Override // com.baidu.swan.games.c.b
                public void fc(boolean z) {
                    d.this.aVw();
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.fe(d.this.aVz());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).gO(a.h.aiapps_debug_switch_title).gN(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).gR(false).c(a.h.aiapps_ok, onClickListener).aHE();
    }
}
