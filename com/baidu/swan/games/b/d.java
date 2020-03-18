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
    private static d cmm;
    private boolean cmn;

    /* loaded from: classes11.dex */
    public interface a {
        void co(boolean z);
    }

    private d() {
        this.cmn = DEBUG && com.baidu.swan.apps.ah.a.a.aav();
    }

    public static d ana() {
        if (cmm == null) {
            synchronized (d.class) {
                if (cmm == null) {
                    cmm = new d();
                }
            }
        }
        return cmm;
    }

    private File anb() {
        File file = new File(com.baidu.swan.games.k.a.TQ(), "game_core_console");
        File file2 = (DEBUG && this.cmn) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File anc() {
        return new File(anb(), "res");
    }

    public File and() {
        return new File(com.baidu.swan.apps.t.e.TR(), "sConsole-core");
    }

    private File ane() {
        return new File(anb(), "debugGameSconsole.zip");
    }

    private File anf() {
        return new File(anc(), "swan-game-sconsole.js");
    }

    private File ang() {
        return new File(anc(), "swan-game-sconsole.version");
    }

    private File anh() {
        return new File(anb(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ani() {
        File anf = anf();
        File anh = anh();
        if (!anh.exists() && anf.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.d.c.readAssetData(com.baidu.swan.apps.w.a.TZ(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.d.c.saveFile(String.format(readAssetData, format), anh);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.cmn;
            this.cmn = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File ane = ane();
            new com.baidu.swan.apps.l.a().a(cVar, ane.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.b.d.1
                @Override // com.baidu.swan.apps.t.e.b
                public void cX(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    File anc = d.this.anc();
                    if (anc.exists()) {
                        com.baidu.swan.d.c.deleteFile(anc);
                    }
                    boolean unzipFile = com.baidu.swan.d.c.unzipFile(ane.getAbsolutePath(), anc.getAbsolutePath());
                    if (unzipFile) {
                        d.this.ani();
                        d.this.oG(com.baidu.swan.apps.as.h.getFormatDateTime(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.d.c.deleteFile(ane);
                    aVar.co(unzipFile);
                    d.this.cmn = z;
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    aVar.co(false);
                    d.this.cmn = z;
                }
            });
        }
    }

    public void oG(String str) {
        File ang = ang();
        if (ang.exists()) {
            com.baidu.swan.d.c.deleteFile(ang);
        }
        com.baidu.swan.d.c.saveFile(str, ang);
    }

    public String anj() {
        return com.baidu.swan.d.c.readFileData(ang());
    }

    public String ank() {
        try {
            return anh().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean anl() {
        return anf().exists() && anh().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.cmn) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.co(d.this.anl());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(anj()), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.games.b.d.3
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File Ns() {
                    return d.ana().anc();
                }

                @Override // com.baidu.swan.games.b.b.a
                public void gR(@NonNull String str) {
                    d.ana().oG(str);
                }
            }, new b() { // from class: com.baidu.swan.games.b.d.4
                @Override // com.baidu.swan.games.b.b
                public void cn(boolean z) {
                    d.this.ani();
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.co(d.this.anl());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).eD(a.h.aiapps_debug_switch_title).eC(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).dE(false).c(a.h.aiapps_ok, onClickListener).acs();
    }
}
