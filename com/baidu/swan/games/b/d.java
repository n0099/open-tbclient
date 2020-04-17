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
    private static d cLi;
    private boolean cLj;

    /* loaded from: classes11.dex */
    public interface a {
        void dk(boolean z);
    }

    private d() {
        this.cLj = DEBUG && com.baidu.swan.apps.ah.a.a.aiA();
    }

    public static d avn() {
        if (cLi == null) {
            synchronized (d.class) {
                if (cLi == null) {
                    cLi = new d();
                }
            }
        }
        return cLi;
    }

    private File avo() {
        File file = new File(com.baidu.swan.games.k.a.abF(), "game_core_console");
        File file2 = (DEBUG && this.cLj) ? new File(file, "debug") : file;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public File avp() {
        return new File(avo(), "res");
    }

    public File avq() {
        return new File(com.baidu.swan.apps.t.e.abG(), "sConsole-core");
    }

    private File avr() {
        return new File(avo(), "debugGameSconsole.zip");
    }

    private File avs() {
        return new File(avp(), "swan-game-sconsole.js");
    }

    private File avt() {
        return new File(avp(), "swan-game-sconsole.version");
    }

    private File avu() {
        return new File(avo(), "swan-game-sconsole.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avv() {
        File avs = avs();
        File avu = avu();
        if (!avu.exists() && avs.exists()) {
            String format = String.format("%s%s%s", "res", File.separator, "swan-game-sconsole.js");
            String readAssetData = com.baidu.swan.d.c.readAssetData(com.baidu.swan.apps.w.a.abO(), "aigames/sConsole.html");
            if (readAssetData != null) {
                com.baidu.swan.d.c.saveFile(String.format(readAssetData, format), avu);
            }
        }
    }

    public void a(String str, final a aVar) {
        if (DEBUG) {
            final boolean z = this.cLj;
            this.cLj = true;
            e.c cVar = new e.c();
            cVar.mDownloadUrl = str;
            final File avr = avr();
            new com.baidu.swan.apps.l.a().a(cVar, avr.getAbsolutePath(), new e.b() { // from class: com.baidu.swan.games.b.d.1
                @Override // com.baidu.swan.apps.t.e.b
                public void dm(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    File avp = d.this.avp();
                    if (avp.exists()) {
                        com.baidu.swan.d.c.deleteFile(avp);
                    }
                    boolean unzipFile = com.baidu.swan.d.c.unzipFile(avr.getAbsolutePath(), avp.getAbsolutePath());
                    if (unzipFile) {
                        d.this.avv();
                        d.this.pT(com.baidu.swan.apps.as.h.b(new Date(), "'debug'-HH:mm:ss"));
                    }
                    com.baidu.swan.d.c.deleteFile(avr);
                    aVar.dk(unzipFile);
                    d.this.cLj = z;
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    aVar.dk(false);
                    d.this.cLj = z;
                }
            });
        }
    }

    public void pT(String str) {
        File avt = avt();
        if (avt.exists()) {
            com.baidu.swan.d.c.deleteFile(avt);
        }
        com.baidu.swan.d.c.saveFile(str, avt);
    }

    public String avw() {
        return com.baidu.swan.d.c.readFileData(avt());
    }

    public String avx() {
        try {
            return avu().toURI().toURL().toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getGameConsoleHtmlUrl:" + e);
            }
            return "";
        }
    }

    public boolean avy() {
        return avs().exists() && avu().exists();
    }

    public void a(@NonNull final a aVar) {
        if (DEBUG && this.cLj) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.dk(d.this.avy());
                }
            });
        } else {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.a(avw()), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.games.b.d.3
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File Vf() {
                    return d.avn().avp();
                }

                @Override // com.baidu.swan.games.b.b.a
                /* renamed from: if */
                public void mo26if(@NonNull String str) {
                    d.avn().pT(str);
                }
            }, new b() { // from class: com.baidu.swan.games.b.d.4
                @Override // com.baidu.swan.games.b.b
                public void dj(boolean z) {
                    d.this.avv();
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.b.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.dk(d.this.avy());
                        }
                    });
                }
            }));
        }
    }

    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        new g.a(activity).eI(a.h.aiapps_debug_switch_title).eH(a.h.aiapps_sconsole_load_error).a(new com.baidu.swan.apps.view.c.a()).eA(false).c(a.h.aiapps_ok, onClickListener).akx();
    }
}
