package com.baidu.searchbox.debug.data;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/debug/data/CustomItemInfo;", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "viewFetcher", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "getViewFetcher", "()Lcom/baidu/searchbox/debug/data/ViewFetcher;", "setViewFetcher", "(Lcom/baidu/searchbox/debug/data/ViewFetcher;)V", "<init>", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class CustomItemInfo extends DebugItemInfo {
    public ViewFetcher viewFetcher;

    public CustomItemInfo(ViewFetcher viewFetcher) {
        super(null, ViewType.CUSTOMIZE_VIEW);
        this.viewFetcher = viewFetcher;
    }

    public final void setViewFetcher(ViewFetcher viewFetcher) {
        this.viewFetcher = viewFetcher;
    }

    public final ViewFetcher getViewFetcher() {
        return this.viewFetcher;
    }
}
