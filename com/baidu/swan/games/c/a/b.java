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
    private static b byw;
    private boolean byx;

    /* loaded from: classes2.dex */
    public interface a {
        void bs(boolean z);
    }

    private b() {
        this.byx = DEBUG && com.baidu.swan.apps.ac.a.a.NX();
    }

    public static b Wh() {
        if (byw == null) {
            synchronized (b.class) {
                if (byw == null) {
                    byw = new b();
                }
            }
        }
        return byw;
    }

    private File Wi() {
        File file = new File(com.baidu.swan.games.i.a.IY(), "game_core_console");
        File file2 = (DEBUG && this.byx) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File Wj() {
        return new File(Wi(), "res");
    }

    private File Wk() {
        return new File(Wi(), "debugGameSconsole.zip");
    }

    private File Wl() {
        return new File(Wj(), "swan-game-sconsole.js");
    }

    private File Wm() {
        return new File(Wj(), "swan-game-sconsole.version");
    }

    private File Wn() {
        return new File(Wi(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wo() {
        File Wl = Wl();
        File Wn = Wn();
        if (!Wn.exists() && Wl.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String ac = com.baidu.swan.c.a.ac(com.baidu.swan.apps.u.a.Jj(), "aigames/sConsole.html");
            if (ac != null) {
                com.baidu.swan.c.a.b(String.format(ac, format), Wn);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.byx;
            this.byx = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File Wk = Wk();
            new com.baidu.swan.apps.k.a().a(cVar, Wk.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.c.a.b.1
                @Override // com.baidu.swan.apps.install.e.b
                public void cr(int i) {
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onSuccess() {
                    File Wj = b.this.Wj();
                    if (Wj.exists()) {
                        com.baidu.swan.c.a.deleteFile(Wj);
                    }
                    boolean bz = com.baidu.swan.c.a.bz(Wk.getAbsolutePath(), Wj.getAbsolutePath());
                    if (bz) {
                        b.this.Wo();
                        b.this.jG(com.baidu.swan.apps.an.e.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.a.deleteFile(Wk);
                    aVar.bs(bz);
                    b.this.byx = z;
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onFailed() {
                    aVar.bs(false);
                    b.this.byx = z;
                }
            });
        }
    }

    public void jG(String str) {
        File Wm = Wm();
        if (Wm.exists()) {
            com.baidu.swan.c.a.deleteFile(Wm);
        }
        com.baidu.swan.c.a.b(str, Wm);
    }

    public String Wp() {
        return com.baidu.swan.c.a.l(Wm());
    }

    public String Wq() {
        try {
            return Wn().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean Wr() {
        return Wl().exists() && Wn().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.byx) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.bs(b.this.Wr());
                }
            });
        } else if (com.baidu.swan.apps.core.pms.a.dl(1)) {
            c.a(new com.baidu.swan.pms.b.d.a(Wp()), new com.baidu.swan.games.c.b.a(new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.3
                @Override // com.baidu.swan.games.c.b
                public void de(boolean z) {
                    b.this.Wo();
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.bs(b.this.Wr());
                        }
                    });
                }
            }));
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.swan.games.c.a.a(Wj(), new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.4
                @Override // com.baidu.swan.games.c.b
                public void de(boolean z) {
                    b.this.Wo();
                    final boolean Wr = b.this.Wr();
                    if (!Wr) {
                        com.baidu.swan.games.c.a.a.Wg();
                    }
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.bs(Wr);
                        }
                    });
                }
            }));
            com.baidu.a.a.a.init(appContext, true);
            com.baidu.a.a.c.a.a(appContext, com.baidu.swan.apps.u.a.JG().Ke());
            com.baidu.a.a.c.a.b((List<Object>) arrayList, true);
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).dj(a.h.aiapps_debug_switch_title).di(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.b.a()).cv(false).b(a.h.aiapps_ok, onClickListener).Qv();
    }
}
