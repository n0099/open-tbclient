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
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private static b bzn;
    private boolean bzo;

    /* loaded from: classes2.dex */
    public interface a {
        void bs(boolean z);
    }

    private b() {
        this.bzo = DEBUG && com.baidu.swan.apps.ac.a.a.NW();
    }

    public static b Wj() {
        if (bzn == null) {
            synchronized (b.class) {
                if (bzn == null) {
                    bzn = new b();
                }
            }
        }
        return bzn;
    }

    private File Wk() {
        File file = new File(com.baidu.swan.games.i.a.IX(), "game_core_console");
        File file2 = (DEBUG && this.bzo) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File Wl() {
        return new File(Wk(), "res");
    }

    private File Wm() {
        return new File(Wk(), "debugGameSconsole.zip");
    }

    private File Wn() {
        return new File(Wl(), "swan-game-sconsole.js");
    }

    private File Wo() {
        return new File(Wl(), "swan-game-sconsole.version");
    }

    private File Wp() {
        return new File(Wk(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wq() {
        File Wn = Wn();
        File Wp = Wp();
        if (!Wp.exists() && Wn.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String ac = com.baidu.swan.c.a.ac(com.baidu.swan.apps.u.a.Ji(), "aigames/sConsole.html");
            if (ac != null) {
                com.baidu.swan.c.a.b(String.format(ac, format), Wp);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.bzo;
            this.bzo = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File Wm = Wm();
            new com.baidu.swan.apps.k.a().a(cVar, Wm.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.c.a.b.1
                @Override // com.baidu.swan.apps.install.e.b
                public void cr(int i) {
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onSuccess() {
                    File Wl = b.this.Wl();
                    if (Wl.exists()) {
                        com.baidu.swan.c.a.deleteFile(Wl);
                    }
                    boolean bz = com.baidu.swan.c.a.bz(Wm.getAbsolutePath(), Wl.getAbsolutePath());
                    if (bz) {
                        b.this.Wq();
                        b.this.jG(com.baidu.swan.apps.an.e.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.a.deleteFile(Wm);
                    aVar.bs(bz);
                    b.this.bzo = z;
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onFailed() {
                    aVar.bs(false);
                    b.this.bzo = z;
                }
            });
        }
    }

    public void jG(String str) {
        File Wo = Wo();
        if (Wo.exists()) {
            com.baidu.swan.c.a.deleteFile(Wo);
        }
        com.baidu.swan.c.a.b(str, Wo);
    }

    public String Wr() {
        return com.baidu.swan.c.a.l(Wo());
    }

    public String Ws() {
        try {
            return Wp().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean Wt() {
        return Wn().exists() && Wp().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.bzo) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.bs(b.this.Wt());
                }
            });
        } else if (com.baidu.swan.apps.core.pms.a.dl(1)) {
            c.a(new com.baidu.swan.pms.b.d.a(Wr()), new com.baidu.swan.games.c.b.a(new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.3
                @Override // com.baidu.swan.games.c.b
                public void de(boolean z) {
                    b.this.Wq();
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.bs(b.this.Wt());
                        }
                    });
                }
            }));
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.swan.games.c.a.a(Wl(), new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.4
                @Override // com.baidu.swan.games.c.b
                public void de(boolean z) {
                    b.this.Wq();
                    final boolean Wt = b.this.Wt();
                    if (!Wt) {
                        com.baidu.swan.games.c.a.a.Wi();
                    }
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.bs(Wt);
                        }
                    });
                }
            }));
            com.baidu.a.a.a.init(appContext, true);
            com.baidu.a.a.c.a.a(appContext, com.baidu.swan.apps.u.a.JF().Kd());
            com.baidu.a.a.c.a.b((List<Object>) arrayList, true);
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).dj(a.h.aiapps_debug_switch_title).di(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.b.a()).cv(false).b(a.h.aiapps_ok, onClickListener).Qu();
    }
}
