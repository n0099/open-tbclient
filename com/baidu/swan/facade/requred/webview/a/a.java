package com.baidu.swan.facade.requred.webview.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.j.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.a;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.swan.facade.requred.webview.b;
/* loaded from: classes11.dex */
public class a implements b.a {
    private boolean mIsLoading = false;

    @Override // com.baidu.swan.facade.requred.webview.b.a
    public boolean isNeedDownload() {
        return false;
    }

    @Override // com.baidu.swan.facade.requred.webview.b.a
    public String getDownloadUrl() {
        return null;
    }

    @Override // com.baidu.swan.facade.requred.webview.b.a
    public void b(final c cVar) {
        if (this.mIsLoading) {
            showLoading();
            c(cVar);
            return;
        }
        a(new DialogInterface.OnClickListener() { // from class: com.baidu.swan.facade.requred.webview.a.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (-2 != i) {
                    a.this.showLoading();
                    a.this.c(cVar);
                    return;
                }
                cVar.onFail();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final c cVar) {
        com.baidu.swan.e.c.awB().a(new com.baidu.swan.e.a() { // from class: com.baidu.swan.facade.requred.webview.a.a.2
            @Override // com.baidu.swan.e.a
            public void onSuccess() {
                a.this.hideLoading();
                cVar.onSuccess();
            }

            @Override // com.baidu.swan.e.a
            public void onFail() {
                a.this.hideLoading();
                cVar.onFail();
            }

            @Override // com.baidu.swan.e.a
            public void onProgress(long j, long j2) {
                cVar.onProgress(j, j2);
                a.this.o(j, j2);
            }
        }).awC();
    }

    private void a(DialogInterface.OnClickListener onClickListener) {
        SwanAppErrorDialog.ahy().fP(a.e.aiapps_t7_download_tip_title).fQ(a.e.aiapps_t7_download_tip_msg).b(a.e.aiapps_t7_download_tip_btn_cancel, onClickListener).a(a.e.aiapps_t7_download_tip_btn_ok, onClickListener).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        int i = 0;
        if (com.baidu.swan.apps.w.a.UI().IE()) {
            i = 100;
        }
        Context appContext = AppRuntime.getAppContext();
        Intent intent = new Intent(appContext, LoadingActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("current", i);
        com.baidu.swan.apps.as.c.startActivitySafely(appContext, intent);
        this.mIsLoading = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j, long j2) {
        Bundle bundle = new Bundle();
        bundle.putLong("current", j);
        bundle.putLong("sum", j2);
        d.acC().d("t7_loading", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        d.acC().kL("loading_hide");
        this.mIsLoading = false;
    }
}
