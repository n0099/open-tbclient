package com.baidu.swan.games.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.pms.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private static b bfk;
    private boolean bfl;

    /* loaded from: classes2.dex */
    public interface a {
        void aX(boolean z);
    }

    private b() {
        this.bfl = DEBUG && com.baidu.swan.apps.ac.a.a.Il();
    }

    public static b Qv() {
        if (bfk == null) {
            synchronized (b.class) {
                if (bfk == null) {
                    bfk = new b();
                }
            }
        }
        return bfk;
    }

    private File Qw() {
        File file = new File(com.baidu.swan.games.i.a.Dq(), "game_core_console");
        File file2 = (DEBUG && this.bfl) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File Qx() {
        return new File(Qw(), "res");
    }

    private File Qy() {
        return new File(Qw(), "debugGameSconsole.zip");
    }

    private File Qz() {
        return new File(Qx(), "swan-game-sconsole.js");
    }

    private File QA() {
        return new File(Qx(), "swan-game-sconsole.version");
    }

    private File QB() {
        return new File(Qw(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QC() {
        File Qz = Qz();
        File QB = QB();
        if (!QB.exists() && Qz.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String ae = com.baidu.swan.c.a.ae(com.baidu.swan.apps.u.a.DB(), "aigames/sConsole.html");
            if (ae != null) {
                com.baidu.swan.c.a.b(String.format(ae, format), QB);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.bfl;
            this.bfl = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File Qy = Qy();
            new com.baidu.swan.apps.k.a().a(cVar, Qy.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.c.a.b.1
                @Override // com.baidu.swan.apps.install.e.b
                public void cv(int i) {
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onSuccess() {
                    File Qx = b.this.Qx();
                    if (Qx.exists()) {
                        com.baidu.swan.c.a.deleteFile(Qx);
                    }
                    boolean bs = com.baidu.swan.c.a.bs(Qy.getAbsolutePath(), Qx.getAbsolutePath());
                    if (bs) {
                        b.this.QC();
                        b.this.iT(com.baidu.swan.apps.an.e.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.a.deleteFile(Qy);
                    aVar.aX(bs);
                    b.this.bfl = z;
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onFailed() {
                    aVar.aX(false);
                    b.this.bfl = z;
                }
            });
        }
    }

    public void iT(String str) {
        File QA = QA();
        if (QA.exists()) {
            com.baidu.swan.c.a.deleteFile(QA);
        }
        com.baidu.swan.c.a.b(str, QA);
    }

    public String QD() {
        return com.baidu.swan.c.a.v(QA());
    }

    public String QE() {
        try {
            return QB().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean QF() {
        return Qz().exists() && QB().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.bfl) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.aX(b.this.QF());
                }
            });
        } else if (com.baidu.swan.apps.core.pms.a.co(1)) {
            c.a(new com.baidu.swan.pms.b.d.a(QD()), new com.baidu.swan.games.c.b.a(new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.3
                @Override // com.baidu.swan.games.c.b
                public void cK(boolean z) {
                    b.this.QC();
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.aX(b.this.QF());
                        }
                    });
                }
            }));
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.swan.games.c.a.a(Qx(), new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.4
                @Override // com.baidu.swan.games.c.b
                public void cK(boolean z) {
                    b.this.QC();
                    final boolean QF = b.this.QF();
                    if (!QF) {
                        com.baidu.swan.games.c.a.a.Qu();
                    }
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.aX(QF);
                        }
                    });
                }
            }));
            com.baidu.b.a.a.init(appContext, true);
            com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.DY().Ew());
            com.baidu.b.a.c.a.b(arrayList, true);
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).cm(a.h.aiapps_debug_switch_title).cl(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.b.a()).cb(false).b(a.h.aiapps_ok, onClickListener).KK();
    }
}
