package com.baidu.swan.facade.requred.webview.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.core.k.c;
import com.baidu.swan.apps.env.b.d;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.a;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.swan.facade.requred.webview.b;
/* loaded from: classes16.dex */
public class a implements b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean mIsLoading = false;

    @Override // com.baidu.swan.facade.requred.webview.b.a
    public boolean isNeedDownload() {
        return false;
    }

    @Override // com.baidu.swan.facade.requred.webview.b.a
    public void b(boolean z, final c cVar) {
        if (this.mIsLoading) {
            if (!z) {
                showLoading();
            }
            a(cVar);
        } else if (z) {
            a(cVar);
        } else {
            a(new DialogInterface.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.a.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (-2 != i) {
                        a.this.showLoading();
                        a.this.a(cVar);
                        return;
                    }
                    cVar.onFail();
                }
            });
        }
    }

    @Override // com.baidu.swan.facade.requred.webview.b.a
    public com.baidu.swan.pms.e.b aiv() {
        return new com.baidu.swan.d.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final c cVar) {
        this.mIsLoading = true;
        if (DEBUG) {
            Log.i("SailorSoDownloadAdapter", "startDownload: ");
        }
        com.baidu.swan.apps.env.b.c.cSD.a(new d().a("zeus", new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.facade.requred.webview.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: f */
            public void M(Boolean bool) {
                if (a.DEBUG) {
                    Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
                }
                a.this.mIsLoading = false;
                a.this.hideLoading();
                if (bool.booleanValue()) {
                    cVar.onSuccess();
                } else {
                    cVar.onFail();
                }
            }
        }));
    }

    private void a(DialogInterface.OnClickListener onClickListener) {
        SwanAppErrorDialog.aNE().jU(a.e.aiapps_t7_download_tip_title).jV(a.e.aiapps_t7_download_tip_msg).b(a.e.aiapps_t7_download_tip_btn_cancel, onClickListener).a(a.e.aiapps_t7_download_tip_btn_ok, onClickListener).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                Context appContext = AppRuntime.getAppContext();
                Intent intent = new Intent(appContext, LoadingActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("so_lib_name", "zeus");
                e.startActivitySafely(appContext, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.facade.requred.webview.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.runtime.d.aHq().rT("loading_hide");
            }
        });
    }
}
