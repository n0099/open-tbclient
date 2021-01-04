package com.baidu.live.sdk.goods.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import java.util.List;
/* loaded from: classes11.dex */
public class AudienceLiveGoodsEnterView extends FrameLayout implements com.baidu.live.core.a.a {
    private View bBt;
    private ImageView bBu;
    private TBLottieAnimationView bBv;
    private a bBw;
    private ViewGroup bBx;
    private boolean bBy;
    private Handler mHandler;

    public AudienceLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        this.bBy = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBy = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBy = true;
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        this.bBy = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        View inflate = View.inflate(context, a.g.ala_audience_live_goods_enter_view, this);
        this.bBt = inflate.findViewById(a.f.audience_goods_layout);
        this.bBu = (ImageView) inflate.findViewById(a.f.audience_goods_imageView);
        this.bBv = (TBLottieAnimationView) inflate.findViewById(a.f.audience_goods_lottieView);
        if (this.bBy) {
            this.bBv.setImageAssetsFolder("lottie/testa/shopimages");
            this.bBv.setAnimation("lottie/liveshow_shopping_testa.json");
            this.bBu.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bBv.setImageAssetsFolder("lottie/testb/shopimages");
            this.bBv.setAnimation("lottie/liveshow_shopping_testb.json");
            this.bBu.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
        this.bBv.setRepeatCount(0);
        this.bBv.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cM(false);
            }
        });
        this.bBw = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bBt.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(boolean z) {
        if (this.bBt.getVisibility() == 0 && this.bBv != null && this.bBu != null) {
            if (z) {
                if (!this.bBv.isAnimating()) {
                    this.bBv.setVisibility(0);
                    this.bBu.setVisibility(4);
                    this.bBv.playAnimation();
                    return;
                }
                return;
            }
            if (this.bBv.isAnimating()) {
                this.bBv.cancelAnimation();
            }
            this.bBv.setVisibility(4);
            this.bBu.setVisibility(0);
        }
    }

    public void cN(boolean z) {
        if (this.bBw != null) {
            if (z) {
                cM(true);
                this.mHandler.removeCallbacks(this.bBw);
                this.mHandler.postDelayed(this.bBw, 7000L);
                return;
            }
            cM(false);
            this.mHandler.removeCallbacks(this.bBw);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bBt.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean SA() {
        return this.bBt.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bBx = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bBx;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bBt.setVisibility(8);
            return;
        }
        if (this.bBt.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bBt.setVisibility(0);
        cN(true);
        if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j2))) {
            ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j2));
            LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j2 + "", j + "", str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AudienceLiveGoodsEnterView.this.cM(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bBw, 12000L);
        }
    }
}
