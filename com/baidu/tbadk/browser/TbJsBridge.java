package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class TbJsBridge {
    private final Activity mActivity;

    public TbJsBridge(Activity activity) {
        this.mActivity = activity;
    }

    @JavascriptInterface
    public void closePage(String str) {
        if (!bg.c(str)) {
            Toast.makeText(this.mActivity, str, 0).show();
        }
        this.mActivity.finish();
    }

    @JavascriptInterface
    public void jumpToLogin(int i) {
        LoginActivity.a(this.mActivity, com.baidu.adp.lib.f.b.a(String.valueOf(i), 0));
    }

    @JavascriptInterface
    public void showShareDialog(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        fVar.a = str;
        fVar.b = str2;
        fVar.c = str4;
        if (!bg.c(str3)) {
            fVar.d = Uri.parse(str3);
        }
        com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this.mActivity);
        dVar.a(fVar, true);
        dVar.a();
    }

    @JavascriptInterface
    public void payWithDQ(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(this.mActivity, DealIntentService.class);
        intent.putExtra("class", 15);
        intent.putExtra(PayActivityConfig.PAY_TYPE, str);
        intent.putExtra(PayActivityConfig.PROPS_ID, str2);
        intent.putExtra(PayActivityConfig.QUAN_NUM, str3);
        intent.putExtra(PayActivityConfig.IS_LEFT, str4);
        intent.putExtra(PayActivityConfig.PROPS_MON, str5);
        com.baidu.adp.lib.f.c.a(this.mActivity, intent);
    }
}
