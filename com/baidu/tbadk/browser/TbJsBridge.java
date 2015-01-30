package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class TbJsBridge {
    private final Activity mActivity;

    public TbJsBridge(Activity activity) {
        this.mActivity = activity;
    }

    @JavascriptInterface
    public void closePage(String str) {
        if (!bf.isEmpty(str)) {
            Toast.makeText(this.mActivity, str, 0).show();
        }
        this.mActivity.finish();
    }

    @JavascriptInterface
    public void jumpToLogin(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.mActivity, com.baidu.adp.lib.g.c.toInt(String.valueOf(i), 0))));
    }

    @JavascriptInterface
    public void showShareDialog(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        fVar.title = str;
        fVar.content = str2;
        fVar.Tq = str4;
        if (!bf.isEmpty(str3)) {
            fVar.Tr = Uri.parse(str3);
        }
        com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this.mActivity);
        dVar.a(fVar, true);
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
        com.baidu.adp.lib.g.j.f(this.mActivity, intent);
    }

    @JavascriptInterface
    public void payWithNative(String str) {
        Intent intent = new Intent(this.mActivity, DealIntentService.class);
        intent.putExtra("class", 23);
        intent.putExtra("wanted_type", str);
        com.baidu.adp.lib.g.j.f(this.mActivity, intent);
    }

    @JavascriptInterface
    public void buyTBeans() {
        Intent intent = new Intent(this.mActivity, DealIntentService.class);
        intent.putExtra("class", 25);
        com.baidu.adp.lib.g.j.f(this.mActivity, intent);
    }
}
