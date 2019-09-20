package com.baidu.tbadk.browser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbWebViewProxyActivity extends BaseActivity {
    public String mUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.ZA().d(data, new f.a() { // from class: com.baidu.tbadk.browser.TbWebViewProxyActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.PARAM_URL) instanceof String)) {
                            TbWebViewProxyActivity.this.mUrl = (String) hashMap.get(com.baidu.tbadk.BdToken.f.PARAM_URL);
                        }
                    }
                });
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this, null, this.mUrl, true)));
            finish();
        }
    }
}
