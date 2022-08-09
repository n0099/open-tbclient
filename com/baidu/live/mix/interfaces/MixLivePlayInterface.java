package com.baidu.live.mix.interfaces;

import android.content.Context;
import android.view.View;
import com.baidu.live.mix.MixLiveItemModel;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/live/mix/interfaces/MixLivePlayInterface;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "Landroid/view/View;", "createLiveView", "(Landroid/content/Context;)Landroid/view/View;", "Lcom/baidu/live/mix/MixLiveItemModel;", "model", "", "onLiveBindData", "(Lcom/baidu/live/mix/MixLiveItemModel;)V", "", CriusAttrConstants.POSITION, "", "", "isFromUser", "onPageSelected", "(ILjava/lang/Object;Z)V", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixLivePlayInterface {
    View createLiveView(Context context);

    void onLiveBindData(MixLiveItemModel mixLiveItemModel);

    void onPageSelected(int i, Object obj, boolean z);
}
