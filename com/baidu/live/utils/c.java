package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes4.dex */
public class c {
    public int bxk;
    public int bxl;
    public int bxm;
    public boolean bxn = false;
    private ForegroundColorSpan bxo;
    private URLSpan bxp;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bxo = foregroundColorSpan;
        this.bxm = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bxp = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bxn = true;
    }
}
