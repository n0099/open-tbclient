package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes4.dex */
public class c {
    public int bJV;
    public int bJW;
    public int bJX;
    public boolean bJY = false;
    private ForegroundColorSpan bJZ;
    private URLSpan bKa;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bJZ = foregroundColorSpan;
        this.bJX = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bKa = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bJY = true;
    }
}
