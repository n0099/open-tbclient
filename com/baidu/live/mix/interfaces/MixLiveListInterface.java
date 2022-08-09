package com.baidu.live.mix.interfaces;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.baidu.live.mix.MixLiveItemModel;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH&¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/baidu/live/mix/interfaces/MixLiveListInterface;", "Lkotlin/Any;", "Landroid/view/MotionEvent;", "e", "", "getIsCanScrollable", "(Landroid/view/MotionEvent;)Z", "Landroid/view/ViewGroup;", NativeConstants.TYPE_VIEW, "Lcom/baidu/live/mix/MixLiveItemModel;", "model", "", "onLiveAttach", "(Landroid/view/ViewGroup;Lcom/baidu/live/mix/MixLiveItemModel;)V", "onLiveDeselected", "(Landroid/view/ViewGroup;)V", "onLiveDetach", "()V", "", CriusAttrConstants.POSITION, "isFromUser", "onLiveSelected", "(ILandroid/view/ViewGroup;Lcom/baidu/live/mix/MixLiveItemModel;Z)V", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixLiveListInterface {
    boolean getIsCanScrollable(MotionEvent motionEvent);

    void onLiveAttach(ViewGroup viewGroup, MixLiveItemModel mixLiveItemModel);

    void onLiveDeselected(ViewGroup viewGroup);

    void onLiveDetach();

    void onLiveSelected(int i, ViewGroup viewGroup, MixLiveItemModel mixLiveItemModel, boolean z);
}
