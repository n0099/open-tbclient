package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes3.dex */
public class b {
    public int bkl;
    public int bkm;
    public int bkn;
    public boolean bko = false;
    private ForegroundColorSpan bkp;
    private URLSpan bkq;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.bkp = foregroundColorSpan;
        this.bkn = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bkq = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bko = true;
    }
}
