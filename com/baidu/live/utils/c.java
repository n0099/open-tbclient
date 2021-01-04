package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes11.dex */
public class c {
    public int bOI;
    public int bOJ;
    public int bOK;
    public boolean bOL = false;
    private ForegroundColorSpan bOM;
    private URLSpan bON;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bOM = foregroundColorSpan;
        this.bOK = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bON = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bOL = true;
    }
}
