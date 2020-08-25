package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes7.dex */
public class b {
    public int bqk;
    public int bql;
    public int bqm;
    public boolean bqn = false;
    private ForegroundColorSpan bqo;
    private URLSpan bqp;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.bqo = foregroundColorSpan;
        this.bqm = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bqp = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bqn = true;
    }
}
