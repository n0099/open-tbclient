package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.util.ay;
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
        if (!ay.aA(str)) {
            Toast.makeText(this.mActivity, str, 0).show();
        }
        this.mActivity.finish();
    }

    @JavascriptInterface
    public void jumpToLogin(int i) {
        LoginActivity.g(this.mActivity, com.baidu.adp.lib.g.c.f(String.valueOf(i), 0));
    }

    @JavascriptInterface
    public void showShareDialog(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
        hVar.title = str;
        hVar.content = str2;
        hVar.MW = str4;
        if (!ay.aA(str3)) {
            hVar.MX = Uri.parse(str3);
        }
        com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this.mActivity);
        dVar.a(hVar, true);
        dVar.show();
    }

    @JavascriptInterface
    public void payWithDQ(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(this.mActivity, DealIntentService.class);
        intent.putExtra("class", 15);
        intent.putExtra("pay_type", str);
        intent.putExtra(PayActivityConfig.PROPS_ID, str2);
        intent.putExtra("quan_num", str3);
        intent.putExtra(PayActivityConfig.IS_LEFT, str4);
        intent.putExtra(PayActivityConfig.PROPS_MON, str5);
        com.baidu.adp.lib.g.i.b(this.mActivity, intent);
    }

    @JavascriptInterface
    public void payWithNative(String str) {
        Intent intent = new Intent(this.mActivity, DealIntentService.class);
        intent.putExtra("class", 23);
        intent.putExtra("wanted_type", str);
        com.baidu.adp.lib.g.i.b(this.mActivity, intent);
    }

    @JavascriptInterface
    public void buyTBeans() {
        Intent intent = new Intent(this.mActivity, DealIntentService.class);
        intent.putExtra("class", 25);
        com.baidu.adp.lib.g.i.b(this.mActivity, intent);
    }
}
