package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes2.dex */
public class b {
    public int azm;
    public int azn;
    public int azo;
    public boolean azp = false;
    private ForegroundColorSpan azq;
    private URLSpan azr;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.azq = foregroundColorSpan;
        this.azo = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.azr = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.azp = true;
    }
}
