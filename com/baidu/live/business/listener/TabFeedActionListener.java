package com.baidu.live.business.listener;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J#\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/live/business/listener/TabFeedActionListener;", "Lkotlin/Any;", "", "onClickErrorRefresh", "()V", "onClickSearch", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "showTextView", "onClickStartLive", "(Landroid/view/View;Landroid/widget/TextView;)V", "", "show", "onSearchShowing", "(Z)V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface TabFeedActionListener {
    void onClickErrorRefresh();

    void onClickSearch();

    void onClickStartLive(View view2, TextView textView);

    void onSearchShowing(boolean z);
}
