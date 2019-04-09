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
    private static b bbn;
    private boolean bbo;

    /* loaded from: classes2.dex */
    public interface a {
        void aV(boolean z);
    }

    private b() {
        this.bbo = DEBUG && com.baidu.swan.apps.ac.a.a.Gc();
    }

    public static b ND() {
        if (bbn == null) {
            synchronized (b.class) {
                if (bbn == null) {
                    bbn = new b();
                }
            }
        }
        return bbn;
    }

    private File NE() {
        File file = new File(com.baidu.swan.games.i.a.Co(), "game_core_console");
        File file2 = (DEBUG && this.bbo) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File NF() {
        return new File(NE(), "res");
    }

    private File NG() {
        return new File(NE(), "debugGameSconsole.zip");
    }

    private File NH() {
        return new File(NF(), "swan-game-sconsole.js");
    }

    private File NI() {
        return new File(NF(), "swan-game-sconsole.version");
    }

    private File NJ() {
        return new File(NE(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NK() {
        File NH = NH();
        File NJ = NJ();
        if (!NJ.exists() && NH.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String aq = com.baidu.swan.c.b.aq(com.baidu.swan.apps.u.a.Cw(), "aigames/sConsole.html");
            if (aq != null) {
                com.baidu.swan.c.b.b(String.format(aq, format), NJ);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.bbo;
            this.bbo = true;
            c.C0144c c0144c = new c.C0144c();
            c0144c.mDownloadUrl = str;
            final File NG = NG();
            new com.baidu.swan.apps.k.a().a(c0144c, NG.getAbsolutePath(), new c.b() { // from class: com.baidu.swan.games.c.a.b.1
                @Override // com.baidu.swan.apps.install.c.b
                public void cu(int i) {
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onSuccess() {
                    File NF = b.this.NF();
                    if (NF.exists()) {
                        com.baidu.swan.c.b.deleteFile(NF);
                    }
                    boolean bl = com.baidu.swan.c.b.bl(NG.getAbsolutePath(), NF.getAbsolutePath());
                    if (bl) {
                        b.this.NK();
                        b.this.il(e.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.c.b.deleteFile(NG);
                    aVar.aV(bl);
                    b.this.bbo = z;
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onFailed() {
                    aVar.aV(false);
                    b.this.bbo = z;
                }
            });
        }
    }

    public void il(String str) {
        File NI = NI();
        if (NI.exists()) {
            com.baidu.swan.c.b.deleteFile(NI);
        }
        com.baidu.swan.c.b.b(str, NI);
    }

    public String NL() {
        return com.baidu.swan.c.b.B(NI());
    }

    public String NM() {
        try {
            return NJ().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean NN() {
        return NH().exists() && NJ().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.bbo) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.aV(b.this.NN());
                }
            });
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.swan.games.c.a.a(NF(), new a.InterfaceC0189a() { // from class: com.baidu.swan.games.c.a.b.3
        }));
        com.baidu.b.a.a.init(appContext, true);
        com.baidu.b.a.c.a.a(appContext, com.baidu.swan.apps.u.a.CT().Dr());
        com.baidu.b.a.c.a.c(arrayList, true);
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new e.a(activity).cm(a.h.aiapps_debug_switch_title).cl(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.b.a()).bR(false).b(a.h.aiapps_ok, onClickListener).Is();
    }
}
