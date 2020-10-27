package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes4.dex */
public class c {
    public int bAm;
    public int bAn;
    public int bAo;
    public boolean bAp = false;
    private ForegroundColorSpan bAq;
    private URLSpan bAr;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bAq = foregroundColorSpan;
        this.bAo = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bAr = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bAp = true;
    }
}
