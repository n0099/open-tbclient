package com.baidu.swan.games.network.c;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class d {
    @V8JavascriptField
    public String data;
    @V8JavascriptField
    public Object header;
    @V8JavascriptField
    public int statusCode;

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
    }
}
