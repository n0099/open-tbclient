package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes2.dex */
public class b {
    public int ayD;
    public int ayE;
    public int ayF;
    public boolean ayG = false;
    private ForegroundColorSpan ayH;
    private URLSpan ayI;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.ayH = foregroundColorSpan;
        this.ayF = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.ayI = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.ayG = true;
    }
}
