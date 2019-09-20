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
    private static b bgv;
    private boolean bgw;

    /* loaded from: classes2.dex */
    public interface a {
        void ba(boolean z);
    }

    private b() {
        this.bgw = DEBUG && com.baidu.swan.apps.ac.a.a.Jc();
    }

    public static b Rs() {
        if (bgv == null) {
            synchronized (b.class) {
                if (bgv == null) {
                    bgv = new b();
                }
            }
        }
        return bgv;
    }

    private File Rt() {
        File file = new File(com.baidu.swan.games.i.a.Ed(), "game_core_console");
        File file2 = (DEBUG && this.bgw) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File Ru() {
        return new File(Rt(), "res");
    }

    private File Rv() {
        return new File(Rt(), "debugGameSconsole.zip");
    }

    private File Rw() {
        return new File(Ru(), "swan-game-sconsole.js");
    }

    private File Rx() {
        return new File(Ru(), "swan-game-sconsole.version");
    }

    private File Ry() {
        return new File(Rt(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rz() {
        File Rw = Rw();
        File Ry = Ry();
        if (!Ry.exists() && Rw.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String ad = com.baidu.swan.c.a.ad(com.baidu.swan.apps.u.a.Eo(), "aigames/sConsole.html");
            if (ad != null) {
                com.baidu.swan.c.a.b(String.format(ad, format), Ry);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.bgw;
            this.bgw = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File Rv = Rv();
            new com.baidu.swan.apps.k.a().a(cVar, Rv.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.c.a.b.1
                @Override // com.baidu.swan.apps.install.e.b
                public void cw(int i) {
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onSuccess() {
                    File Ru = b.this.Ru();
                    if (Ru.exists()) {
                        com.baidu.swan.c.a.deleteFile(Ru);
                    }
                    boolean bs = com.baidu.swan.c.a.bs(Rv.getAbsolutePath(), Ru.getAbsolutePath());
                    if (bs) {
                        b.this.Rz();
                        b.this.jd(com.baidu.swan.apps.an.e.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.a.deleteFile(Rv);
                    aVar.ba(bs);
                    b.this.bgw = z;
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onFailed() {
                    aVar.ba(false);
                    b.this.bgw = z;
                }
            });
        }
    }

    public void jd(String str) {
        File Rx = Rx();
        if (Rx.exists()) {
            com.baidu.swan.c.a.deleteFile(Rx);
        }
        com.baidu.swan.c.a.b(str, Rx);
    }

    public String RA() {
        return com.baidu.swan.c.a.v(Rx());
    }

    public String RB() {
        try {
            return Ry().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean RC() {
        return Rw().exists() && Ry().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.bgw) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.ba(b.this.RC());
                }
            });
        } else if (com.baidu.swan.apps.core.pms.a.cp(1)) {
            c.a(new com.baidu.swan.pms.b.d.a(RA()), new com.baidu.swan.games.c.b.a(new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.3
                @Override // com.baidu.swan.games.c.b
                public void cN(boolean z) {
                    b.this.Rz();
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.ba(b.this.RC());
                        }
                    });
                }
            }));
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.swan.games.c.a.a(Ru(), new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.4
                @Override // com.baidu.swan.games.c.b
                public void cN(boolean z) {
                    b.this.Rz();
                    final boolean RC = b.this.RC();
                    if (!RC) {
                        com.baidu.swan.games.c.a.a.Rr();
                    }
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.ba(RC);
                        }
                    });
                }
            }));
            com.baidu.b.a.a.init(appContext, true);
            com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.EL().Fj());
            com.baidu.b.a.c.a.b((List<Object>) arrayList, true);
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).cn(a.h.aiapps_debug_switch_title).cm(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.b.a()).ce(false).b(a.h.aiapps_ok, onClickListener).LB();
    }
}
