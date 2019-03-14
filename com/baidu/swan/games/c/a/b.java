package com.baidu.swan.games.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.e;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.games.c.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private static b bbj;
    private boolean bbk;

    /* loaded from: classes2.dex */
    public interface a {
        void aV(boolean z);
    }

    private b() {
        this.bbk = DEBUG && com.baidu.swan.apps.ac.a.a.Ge();
    }

    public static b NF() {
        if (bbj == null) {
            synchronized (b.class) {
                if (bbj == null) {
                    bbj = new b();
                }
            }
        }
        return bbj;
    }

    private File NG() {
        File file = new File(com.baidu.swan.games.i.a.Cq(), "game_core_console");
        File file2 = (DEBUG && this.bbk) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File NH() {
        return new File(NG(), "res");
    }

    private File NI() {
        return new File(NG(), "debugGameSconsole.zip");
    }

    private File NJ() {
        return new File(NH(), "swan-game-sconsole.js");
    }

    private File NK() {
        return new File(NH(), "swan-game-sconsole.version");
    }

    private File NL() {
        return new File(NG(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NM() {
        File NJ = NJ();
        File NL = NL();
        if (!NL.exists() && NJ.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String aq = com.baidu.swan.c.b.aq(com.baidu.swan.apps.u.a.Cy(), "aigames/sConsole.html");
            if (aq != null) {
                com.baidu.swan.c.b.b(String.format(aq, format), NL);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.bbk;
            this.bbk = true;
            c.C0144c c0144c = new c.C0144c();
            c0144c.mDownloadUrl = str;
            final File NI = NI();
            new com.baidu.swan.apps.k.a().a(c0144c, NI.getAbsolutePath(), new c.b() { // from class: com.baidu.swan.games.c.a.b.1
                @Override // com.baidu.swan.apps.install.c.b
                public void cv(int i) {
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onSuccess() {
                    File NH = b.this.NH();
                    if (NH.exists()) {
                        com.baidu.swan.c.b.deleteFile(NH);
                    }
                    boolean bl = com.baidu.swan.c.b.bl(NI.getAbsolutePath(), NH.getAbsolutePath());
                    if (bl) {
                        b.this.NM();
                        b.this.ik(e.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.b.deleteFile(NI);
                    aVar.aV(bl);
                    b.this.bbk = z;
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onFailed() {
                    aVar.aV(false);
                    b.this.bbk = z;
                }
            });
        }
    }

    public void ik(String str) {
        File NK = NK();
        if (NK.exists()) {
            com.baidu.swan.c.b.deleteFile(NK);
        }
        com.baidu.swan.c.b.b(str, NK);
    }

    public String NN() {
        return com.baidu.swan.c.b.B(NK());
    }

    public String NO() {
        try {
            return NL().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean NP() {
        return NJ().exists() && NL().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.bbk) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.aV(b.this.NP());
                }
            });
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.swan.games.c.a.a(NH(), new a.InterfaceC0189a() { // from class: com.baidu.swan.games.c.a.b.3
        }));
        com.baidu.b.a.a.init(appContext, true);
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.CV().Dt());
        com.baidu.b.a.c.a.c(arrayList, true);
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new e.a(activity).cn(a.h.aiapps_debug_switch_title).cm(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.b.a()).bR(false).b(a.h.aiapps_ok, onClickListener).Iu();
    }
}
