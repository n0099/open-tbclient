package com.baidu.searchbox.live.list.controller;

import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.livepager.AlaLoopViewPager;
import com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew;
import com.baidu.searchbox.live.util.ListLogKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/livepager/AlaLoopViewPager;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PagerController$alaLoopViewPager$2 extends Lambda implements Function0<AlaLoopViewPager> {
    public final /* synthetic */ PagerController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerController$alaLoopViewPager$2(PagerController pagerController) {
        super(0);
        this.this$0 = pagerController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AlaLoopViewPager invoke() {
        ViewPager.OnPageChangeListener onPageChangeListener;
        AlaVerticalViewPagerNew.Callback callback;
        AlaLoopViewPager alaLoopViewPager = new AlaLoopViewPager(this.this$0.getContext());
        onPageChangeListener = this.this$0.onPageChangedListener;
        alaLoopViewPager.setOnPageChangeListener(onPageChangeListener);
        callback = this.this$0.mCallBack;
        alaLoopViewPager.setCallback(callback);
        alaLoopViewPager.setBoundaryCaching(true);
        alaLoopViewPager.setDetermineYRatio(1.0f);
        alaLoopViewPager.setScrollControl(new AlaLoopViewPager.IScrollControl() { // from class: com.baidu.searchbox.live.list.controller.PagerController$alaLoopViewPager$2$$special$$inlined$apply$lambda$1
            @Override // com.baidu.searchbox.live.livepager.AlaLoopViewPager.IScrollControl
            public boolean isEnableScrollDown(MotionEvent motionEvent) {
                boolean isFirstLive;
                IMixActivityInterface iMixActivityInterface;
                Boolean bool;
                JSONObject mixEventDispatcher;
                isFirstLive = PagerController$alaLoopViewPager$2.this.this$0.isFirstLive();
                boolean z = true;
                boolean z2 = !isFirstLive;
                if (z2) {
                    iMixActivityInterface = PagerController$alaLoopViewPager$2.this.this$0.mixActivity;
                    if (iMixActivityInterface != null && (mixEventDispatcher = iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_GET_AUDIO_ROOM_SCROLLABLE, motionEvent)) != null) {
                        bool = Boolean.valueOf(mixEventDispatcher.optBoolean(MixConstants.RES_GET_AUDIO_ROOM_SCROLLABLE, true));
                    } else {
                        bool = null;
                    }
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                    z2 = z;
                }
                ListLogKt.log(MixTagConstants.MIX_PAGER, "isEnableScrollDown " + z2);
                return z2;
            }

            @Override // com.baidu.searchbox.live.livepager.AlaLoopViewPager.IScrollControl
            public boolean isEnableScrollUp(MotionEvent motionEvent) {
                boolean isLastLive;
                IMixActivityInterface iMixActivityInterface;
                Boolean bool;
                JSONObject mixEventDispatcher;
                isLastLive = PagerController$alaLoopViewPager$2.this.this$0.isLastLive();
                boolean z = true;
                boolean z2 = !isLastLive;
                if (z2) {
                    iMixActivityInterface = PagerController$alaLoopViewPager$2.this.this$0.mixActivity;
                    if (iMixActivityInterface != null && (mixEventDispatcher = iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_GET_AUDIO_ROOM_SCROLLABLE, motionEvent)) != null) {
                        bool = Boolean.valueOf(mixEventDispatcher.optBoolean(MixConstants.RES_GET_AUDIO_ROOM_SCROLLABLE, true));
                    } else {
                        bool = null;
                    }
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                    z2 = z;
                }
                ListLogKt.log(MixTagConstants.MIX_PAGER, "isEnableScrollUp " + z2);
                return z2;
            }
        });
        return alaLoopViewPager;
    }
}
