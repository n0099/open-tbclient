package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes6.dex */
public class b {
    public int arh;
    public int ari;
    public int arj;
    public boolean ark = false;
    private ForegroundColorSpan arl;
    private URLSpan arm;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.arl = foregroundColorSpan;
        this.arj = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.arm = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.ark = true;
    }
}
