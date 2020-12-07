package com.baidu.live.sdk.goods.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import java.util.List;
/* loaded from: classes4.dex */
public class AudienceLiveGoodsEnterView extends FrameLayout implements com.baidu.live.core.a.a {
    private View bwI;
    private ImageView bwJ;
    private TBLottieAnimationView bwK;
    private a bwL;
    private ViewGroup bwM;
    private boolean bwN;
    private Handler mHandler;

    public AudienceLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        this.bwN = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwN = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwN = true;
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        this.bwN = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        View inflate = View.inflate(context, a.g.ala_audience_live_goods_enter_view, this);
        this.bwI = inflate.findViewById(a.f.audience_goods_layout);
        this.bwJ = (ImageView) inflate.findViewById(a.f.audience_goods_imageView);
        this.bwK = (TBLottieAnimationView) inflate.findViewById(a.f.audience_goods_lottieView);
        if (this.bwN) {
            this.bwK.setImageAssetsFolder("lottie/testa/shopimages");
            this.bwK.setAnimation("lottie/liveshow_shopping_testa.json");
            this.bwJ.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bwK.setImageAssetsFolder("lottie/testb/shopimages");
            this.bwK.setAnimation("lottie/liveshow_shopping_testb.json");
            this.bwJ.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
        this.bwK.setRepeatCount(0);
        this.bwK.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cJ(false);
            }
        });
        this.bwL = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bwI.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(boolean z) {
        if (this.bwI.getVisibility() == 0 && this.bwK != null && this.bwJ != null) {
            if (z) {
                if (!this.bwK.isAnimating()) {
                    this.bwK.setVisibility(0);
                    this.bwJ.setVisibility(4);
                    this.bwK.playAnimation();
                    return;
                }
                return;
            }
            if (this.bwK.isAnimating()) {
                this.bwK.cancelAnimation();
            }
            this.bwK.setVisibility(4);
            this.bwJ.setVisibility(0);
        }
    }

    public void cK(boolean z) {
        if (this.bwL != null) {
            if (z) {
                cJ(true);
                this.mHandler.removeCallbacks(this.bwL);
                this.mHandler.postDelayed(this.bwL, 7000L);
                return;
            }
            cJ(false);
            this.mHandler.removeCallbacks(this.bwL);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bwI.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Rx() {
        return this.bwI.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bwM = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bwM;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bwI.setVisibility(8);
            return;
        }
        if (this.bwI.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bwI.setVisibility(0);
        cK(true);
        if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j2))) {
            ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j2));
            LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j2 + "", j + "", str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AudienceLiveGoodsEnterView.this.cJ(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bwL, 12000L);
        }
    }
}
