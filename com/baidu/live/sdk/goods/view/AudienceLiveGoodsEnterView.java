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
    private TBLottieAnimationView brA;
    private a brB;
    private ViewGroup brC;
    private boolean brD;
    private View bry;
    private ImageView brz;
    private Handler mHandler;

    public AudienceLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        this.brD = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brD = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.brD = true;
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        this.brD = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        View inflate = View.inflate(context, a.g.ala_audience_live_goods_enter_view, this);
        this.bry = inflate.findViewById(a.f.audience_goods_layout);
        this.brz = (ImageView) inflate.findViewById(a.f.audience_goods_imageView);
        this.brA = (TBLottieAnimationView) inflate.findViewById(a.f.audience_goods_lottieView);
        if (this.brD) {
            this.brA.setImageAssetsFolder("lottie/testa/shopimages");
            this.brA.setAnimation("lottie/liveshow_shopping_testa.json");
            this.brz.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.brA.setImageAssetsFolder("lottie/testb/shopimages");
            this.brA.setAnimation("lottie/liveshow_shopping_testb.json");
            this.brz.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
        this.brA.setRepeatCount(0);
        this.brA.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cv(false);
            }
        });
        this.brB = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bry.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(boolean z) {
        if (this.bry.getVisibility() == 0 && this.brA != null && this.brz != null) {
            if (z) {
                if (!this.brA.isAnimating()) {
                    this.brA.setVisibility(0);
                    this.brz.setVisibility(4);
                    this.brA.playAnimation();
                    return;
                }
                return;
            }
            if (this.brA.isAnimating()) {
                this.brA.cancelAnimation();
            }
            this.brA.setVisibility(4);
            this.brz.setVisibility(0);
        }
    }

    public void cw(boolean z) {
        if (this.brB != null) {
            if (z) {
                cv(true);
                this.mHandler.removeCallbacks(this.brB);
                this.mHandler.postDelayed(this.brB, 7000L);
                return;
            }
            cv(false);
            this.mHandler.removeCallbacks(this.brB);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bry.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Pd() {
        return this.bry.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.brC = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.brC;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bry.setVisibility(8);
            return;
        }
        if (this.bry.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bry.setVisibility(0);
        cw(true);
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
            AudienceLiveGoodsEnterView.this.cv(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.brB, 12000L);
        }
    }
}
