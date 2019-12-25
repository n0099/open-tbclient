package com.baidu.searchbox.ugc.lightbrowser;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.browser.ILightBrowser;
/* loaded from: classes11.dex */
public class InvokeLightBrowser implements ILightBrowser {
    @Override // com.baidu.searchbox.browser.ILightBrowser
    public void open(Context context, String str) {
        Intent intent = new Intent(context, LightBrowserActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }
}
