package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes11.dex */
public class c {
    public int bNG;
    public int bNH;
    public int bNI;
    public boolean bNJ = false;
    private ForegroundColorSpan bNK;
    private URLSpan bNL;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bNK = foregroundColorSpan;
        this.bNI = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bNL = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bNJ = true;
    }
}
