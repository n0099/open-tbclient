package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes7.dex */
public class b {
    public int bqn;
    public int bqo;
    public int bqp;
    public boolean bqq = false;
    private ForegroundColorSpan bqr;
    private URLSpan bqs;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.bqr = foregroundColorSpan;
        this.bqp = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bqs = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bqq = true;
    }
}
