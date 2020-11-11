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
    private View btj;
    private ImageView btk;
    private TBLottieAnimationView btl;
    private a btm;
    private ViewGroup bto;
    private boolean btp;
    private Handler mHandler;

    public AudienceLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        this.btp = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btp = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btp = true;
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        this.btp = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        View inflate = View.inflate(context, a.g.ala_audience_live_goods_enter_view, this);
        this.btj = inflate.findViewById(a.f.audience_goods_layout);
        this.btk = (ImageView) inflate.findViewById(a.f.audience_goods_imageView);
        this.btl = (TBLottieAnimationView) inflate.findViewById(a.f.audience_goods_lottieView);
        if (this.btp) {
            this.btl.setImageAssetsFolder("lottie/testa/shopimages");
            this.btl.setAnimation("lottie/liveshow_shopping_testa.json");
            this.btk.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.btl.setImageAssetsFolder("lottie/testb/shopimages");
            this.btl.setAnimation("lottie/liveshow_shopping_testb.json");
            this.btk.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
        this.btl.setRepeatCount(0);
        this.btl.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.ct(false);
            }
        });
        this.btm = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.btj.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(boolean z) {
        if (this.btj.getVisibility() == 0 && this.btl != null && this.btk != null) {
            if (z) {
                if (!this.btl.isAnimating()) {
                    this.btl.setVisibility(0);
                    this.btk.setVisibility(4);
                    this.btl.playAnimation();
                    return;
                }
                return;
            }
            if (this.btl.isAnimating()) {
                this.btl.cancelAnimation();
            }
            this.btl.setVisibility(4);
            this.btk.setVisibility(0);
        }
    }

    public void cu(boolean z) {
        if (this.btm != null) {
            if (z) {
                ct(true);
                this.mHandler.removeCallbacks(this.btm);
                this.mHandler.postDelayed(this.btm, 7000L);
                return;
            }
            ct(false);
            this.mHandler.removeCallbacks(this.btm);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.btj.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean PM() {
        return this.btj.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bto = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bto;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.btj.setVisibility(8);
            return;
        }
        if (this.btj.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.btj.setVisibility(0);
        cu(true);
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
            AudienceLiveGoodsEnterView.this.ct(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.btm, 12000L);
        }
    }
}
