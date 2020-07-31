package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes4.dex */
public class b {
    public int bkF;
    public int bkG;
    public int bkH;
    public boolean bkI = false;
    private ForegroundColorSpan bkJ;
    private URLSpan bkK;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.bkJ = foregroundColorSpan;
        this.bkH = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bkK = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bkI = true;
    }
}
