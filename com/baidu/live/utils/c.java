package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes10.dex */
public class c {
    public int bPg;
    public int bPh;
    public int bPi;
    public boolean bPj = false;
    private ForegroundColorSpan bPk;
    private URLSpan bPl;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bPk = foregroundColorSpan;
        this.bPi = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bPl = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bPj = true;
    }
}
