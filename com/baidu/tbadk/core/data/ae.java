package com.baidu.tbadk.core.data;

import java.util.List;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
/* loaded from: classes.dex */
public class ae {
    private TwZhiBoUser WS;
    private List<TwAnchorProfitItem> WT;

    public TwZhiBoUser pW() {
        return this.WS;
    }

    public void a(TwZhiBoUser twZhiBoUser) {
        this.WS = twZhiBoUser;
    }

    public List<TwAnchorProfitItem> pX() {
        return this.WT;
    }

    public void p(List<TwAnchorProfitItem> list) {
        this.WT = list;
    }
}
