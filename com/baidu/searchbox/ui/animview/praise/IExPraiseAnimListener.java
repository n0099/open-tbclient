package com.baidu.searchbox.ui.animview.praise;
/* loaded from: classes12.dex */
public interface IExPraiseAnimListener extends IPraiseAnimListener {
    public static final int PREVENTED_REASON_CANCELLED = 1;
    public static final int PREVENTED_REASON_OUT_OF_BOUND = 0;

    void onPraiseAnimPrevented(int i);
}
