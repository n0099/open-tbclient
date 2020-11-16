package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes4.dex */
public class c {
    public int bEM;
    public int bEN;
    public int bEO;
    public boolean bEP = false;
    private ForegroundColorSpan bEQ;
    private URLSpan bER;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bEQ = foregroundColorSpan;
        this.bEO = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bER = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bEP = true;
    }
}
