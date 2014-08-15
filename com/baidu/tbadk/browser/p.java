package com.baidu.tbadk.browser;

import android.text.TextUtils;
import android.util.Log;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.SAXParserFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ TbWebViewActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbWebViewActivity tbWebViewActivity, String str) {
        this.a = tbWebViewActivity;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar = new t(this.a, null);
        try {
            URLConnection openConnection = new URL(this.b).openConnection();
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setValidating(false);
            newInstance.newSAXParser().parse(openConnection.getInputStream(), tVar);
        } catch (Exception e) {
            Log.d("yxj", e.getLocalizedMessage());
        }
        String a = tVar.a("screen-orientation");
        Log.d("yxj", "orientation:" + a);
        if (!TextUtils.isEmpty(a)) {
            this.a.setRequestedOrientation(com.baidu.tbadk.core.frameworkData.a.PORTRAIT.equals(a) ? 1 : 0);
        }
    }
}
