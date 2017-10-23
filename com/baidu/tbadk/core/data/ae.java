package com.baidu.tbadk.core.data;

import java.util.List;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
/* loaded from: classes.dex */
public class ae {
    private TwZhiBoUser WA;
    private List<TwAnchorProfitItem> WB;

    public TwZhiBoUser pR() {
        return this.WA;
    }

    public void a(TwZhiBoUser twZhiBoUser) {
        this.WA = twZhiBoUser;
    }

    public List<TwAnchorProfitItem> pS() {
        return this.WB;
    }

    public void o(List<TwAnchorProfitItem> list) {
        this.WB = list;
    }
}
