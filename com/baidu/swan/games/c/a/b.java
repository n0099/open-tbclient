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
    private static b bfW;
    private boolean bfX;

    /* loaded from: classes2.dex */
    public interface a {
        void ba(boolean z);
    }

    private b() {
        this.bfX = DEBUG && com.baidu.swan.apps.ac.a.a.IY();
    }

    public static b Ro() {
        if (bfW == null) {
            synchronized (b.class) {
                if (bfW == null) {
                    bfW = new b();
                }
            }
        }
        return bfW;
    }

    private File Rp() {
        File file = new File(com.baidu.swan.games.i.a.DZ(), "game_core_console");
        File file2 = (DEBUG && this.bfX) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File Rq() {
        return new File(Rp(), "res");
    }

    private File Rr() {
        return new File(Rp(), "debugGameSconsole.zip");
    }

    private File Rs() {
        return new File(Rq(), "swan-game-sconsole.js");
    }

    private File Rt() {
        return new File(Rq(), "swan-game-sconsole.version");
    }

    private File Ru() {
        return new File(Rp(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rv() {
        File Rs = Rs();
        File Ru = Ru();
        if (!Ru.exists() && Rs.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String ad = com.baidu.swan.c.a.ad(com.baidu.swan.apps.u.a.Ek(), "aigames/sConsole.html");
            if (ad != null) {
                com.baidu.swan.c.a.b(String.format(ad, format), Ru);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.bfX;
            this.bfX = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File Rr = Rr();
            new com.baidu.swan.apps.k.a().a(cVar, Rr.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.c.a.b.1
                @Override // com.baidu.swan.apps.install.e.b
                public void cv(int i) {
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onSuccess() {
                    File Rq = b.this.Rq();
                    if (Rq.exists()) {
                        com.baidu.swan.c.a.deleteFile(Rq);
                    }
                    boolean bs = com.baidu.swan.c.a.bs(Rr.getAbsolutePath(), Rq.getAbsolutePath());
                    if (bs) {
                        b.this.Rv();
                        b.this.jb(com.baidu.swan.apps.an.e.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.a.deleteFile(Rr);
                    aVar.ba(bs);
                    b.this.bfX = z;
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onFailed() {
                    aVar.ba(false);
                    b.this.bfX = z;
                }
            });
        }
    }

    public void jb(String str) {
        File Rt = Rt();
        if (Rt.exists()) {
            com.baidu.swan.c.a.deleteFile(Rt);
        }
        com.baidu.swan.c.a.b(str, Rt);
    }

    public String Rw() {
        return com.baidu.swan.c.a.v(Rt());
    }

    public String Rx() {
        try {
            return Ru().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean Ry() {
        return Rs().exists() && Ru().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.bfX) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.ba(b.this.Ry());
                }
            });
        } else if (com.baidu.swan.apps.core.pms.a.co(1)) {
            c.a(new com.baidu.swan.pms.b.d.a(Rw()), new com.baidu.swan.games.c.b.a(new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.3
                @Override // com.baidu.swan.games.c.b
                public void cN(boolean z) {
                    b.this.Rv();
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.ba(b.this.Ry());
                        }
                    });
                }
            }));
        } else {
            Context appContext = AppRuntime.getAppContext();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.swan.games.c.a.a(Rq(), new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.games.c.a.b.4
                @Override // com.baidu.swan.games.c.b
                public void cN(boolean z) {
                    b.this.Rv();
                    final boolean Ry = b.this.Ry();
                    if (!Ry) {
                        com.baidu.swan.games.c.a.a.Rn();
                    }
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.ba(Ry);
                        }
                    });
                }
            }));
            com.baidu.b.a.a.init(appContext, true);
            com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.EH().Ff());
            com.baidu.b.a.c.a.b(arrayList, true);
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).cm(a.h.aiapps_debug_switch_title).cl(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.b.a()).ce(false).b(a.h.aiapps_ok, onClickListener).Lx();
    }
}
