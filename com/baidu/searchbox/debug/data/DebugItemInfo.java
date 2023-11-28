package com.baidu.searchbox.debug.data;

import android.view.View;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "Lcom/baidu/searchbox/debug/data/ViewType;", "viewType", "Lcom/baidu/searchbox/debug/data/ViewType;", "getViewType", "()Lcom/baidu/searchbox/debug/data/ViewType;", "setViewType", "(Lcom/baidu/searchbox/debug/data/ViewType;)V", "<init>", "(Landroid/view/View;Lcom/baidu/searchbox/debug/data/ViewType;)V", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class DebugItemInfo {

    /* renamed from: view  reason: collision with root package name */
    public View f1055view;
    public ViewType viewType;

    public DebugItemInfo(View view2, ViewType viewType) {
        this.f1055view = view2;
        this.viewType = viewType;
    }

    public final View getView() {
        return this.f1055view;
    }

    public final ViewType getViewType() {
        return this.viewType;
    }

    public final void setView(View view2) {
        this.f1055view = view2;
    }

    public final void setViewType(ViewType viewType) {
        this.viewType = viewType;
    }
}
