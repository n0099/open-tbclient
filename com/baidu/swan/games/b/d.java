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
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    private static d clY;
    private boolean clZ;

    /* loaded from: classes11.dex */
    public interface a {
        void cn(boolean z);
    }

    private d() {
        this.clZ = DEBUG && com.baidu.swan.apps.ah.a.a.aaq();
    }

    public static d amV() {
        if (clY == null) {
            synchronized (d.class) {
                if (clY == null) {
                    clY = new d();
                }
            }
        }
        return clY;
    }

    private File amW() {
        File file = new File(com.baidu.swan.games.k.a.TL(), "game_core_console");
        File file2 = (DEBUG && this.clZ) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File amX() {
        return new File(amW(), "res");
    }

    public File amY() {
        return new File(com.baidu.swan.apps.t.e.TM(), "sConsole-core");
    }

    private File amZ() {
        return new File(amW(), "debugGameSconsole.zip");
    }

    private File ana() {
        return new File(amX(), "swan-game-sconsole.js");
    }

    private File anb() {
        return new File(amX(), "swan-game-sconsole.version");
    }

    private File anc() {
        return new File(amW(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void and() {
        File ana = ana();
        File anc = anc();
        if (!anc.exists() && ana.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.d.c.readAssetData(com.baidu.swan.apps.w.a.TU(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.d.c.saveFile(String.format(readAssetData, format), anc);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.clZ;
            this.clZ = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File amZ = amZ();
            new com.baidu.swan.apps.l.a().a(cVar, amZ.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.b.d.1
                @Override // com.baidu.swan.apps.t.e.b
                public void cX(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    File amX = d.this.amX();
                    if (amX.exists()) {
                        com.baidu.swan.d.c.deleteFile(amX);
                    }
                    boolean unzipFile = com.baidu.swan.d.c.unzipFile(amZ.getAbsolutePath(), amX.getAbsolutePath());
                    if (unzipFile) {
                        d.this.and();
                        d.this.oH(com.baidu.swan.apps.as.h.getFormatDateTime(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.d.c.deleteFile(amZ);
                    aVar.cn(unzipFile);
                    d.this.clZ = z;
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    aVar.cn(false);
                    d.this.clZ = z;
                }
            });
        }
    }

    public void oH(String str) {
        File anb = anb();
        if (anb.exists()) {
            com.baidu.swan.d.c.deleteFile(anb);
        }
        com.baidu.swan.d.c.saveFile(str, anb);
    }

    public String ane() {
        return com.baidu.swan.d.c.readFileData(anb());
    }

    public String anf() {
        try {
            return anc().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean ang() {
        return ana().exists() && anc().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.clZ) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.cn(d.this.ang());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(ane()), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.games.b.d.3
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File Nn() {
                    return d.amV().amX();
                }

                @Override // com.baidu.swan.games.b.b.a
                public void gS(@NonNull String str) {
                    d.amV().oH(str);
                }
            }, new b() { // from class: com.baidu.swan.games.b.d.4
                @Override // com.baidu.swan.games.b.b
                public void cm(boolean z) {
                    d.this.and();
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.cn(d.this.ang());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).eD(a.h.aiapps_debug_switch_title).eC(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).dD(false).c(a.h.aiapps_ok, onClickListener).acn();
    }
}
