package com.baidu.tbadk.browser;

import android.util.Log;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
/* loaded from: classes.dex */
class t extends DefaultHandler {
    final /* synthetic */ TbWebViewActivity a;
    private HashMap<String, String> b;

    private t(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
        this.b = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(TbWebViewActivity tbWebViewActivity, t tVar) {
        this(tbWebViewActivity);
    }

    public String a(String str) {
        return this.b.get(str);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        super.startDocument();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        super.startElement(str, str2, str3, attributes);
        Log.d("yxj", "localName:" + str2);
        if (str2.equals("meta") && attributes != null) {
            String value = attributes.getValue("name");
            if ("screen-orientation".equals(value)) {
                Log.d("yxj", String.valueOf(value) + " :" + attributes.getValue("content"));
                this.b.put(value, attributes.getValue("content"));
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        super.endElement(str, str2, str3);
    }
}
