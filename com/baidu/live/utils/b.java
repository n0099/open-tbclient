package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes3.dex */
public class b {
    public int bfa;
    public int bfc;
    public int bfd;
    public boolean bfe = false;
    private ForegroundColorSpan bff;
    private URLSpan bfg;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.bff = foregroundColorSpan;
        this.bfd = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bfg = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bfe = true;
    }
}
