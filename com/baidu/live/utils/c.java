package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes4.dex */
public class c {
    public boolean btA = false;
    private ForegroundColorSpan btB;
    private URLSpan btC;
    public int btx;
    public int bty;
    public int btz;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.btB = foregroundColorSpan;
        this.btz = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.btC = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.btA = true;
    }
}
