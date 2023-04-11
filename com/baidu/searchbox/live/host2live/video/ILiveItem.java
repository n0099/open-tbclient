package com.baidu.searchbox.live.host2live.video;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/host2live/video/ILiveItem;", "Lkotlin/Any;", "", CriusAttrConstants.POSITION, "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "createItemView", "(ILandroid/view/ViewGroup;)Landroid/view/View;", NativeConstants.TYPE_VIEW, "", "onLiveSelected", "(ILandroid/view/View;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveItem {
    View createItemView(int i, ViewGroup viewGroup);

    void onLiveSelected(int i, View view2);
}
