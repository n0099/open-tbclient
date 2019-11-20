package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes6.dex */
public class b {
    public int aqP;
    public int aqQ;
    public int aqR;
    public boolean aqS = false;
    private ForegroundColorSpan aqT;
    private URLSpan aqU;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.aqT = foregroundColorSpan;
        this.aqR = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.aqU = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.aqS = true;
    }
}
