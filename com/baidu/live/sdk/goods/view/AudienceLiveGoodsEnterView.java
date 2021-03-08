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
/* loaded from: classes10.dex */
public class AudienceLiveGoodsEnterView extends FrameLayout implements com.baidu.live.core.a.a {
    private View bBK;
    private ImageView bBL;
    private TBLottieAnimationView bBM;
    private a bBN;
    private ViewGroup bBO;
    private boolean bBP;
    private Handler mHandler;

    public AudienceLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        this.bBP = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBP = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBP = true;
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        this.bBP = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        View inflate = View.inflate(context, a.g.ala_audience_live_goods_enter_view, this);
        this.bBK = inflate.findViewById(a.f.audience_goods_layout);
        this.bBL = (ImageView) inflate.findViewById(a.f.audience_goods_imageView);
        this.bBM = (TBLottieAnimationView) inflate.findViewById(a.f.audience_goods_lottieView);
        if (this.bBP) {
            this.bBM.setImageAssetsFolder("lottie/testa/shopimages");
            this.bBM.setAnimation("lottie/liveshow_shopping_testa.json");
            this.bBL.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bBM.setImageAssetsFolder("lottie/testb/shopimages");
            this.bBM.setAnimation("lottie/liveshow_shopping_testb.json");
            this.bBL.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
        this.bBM.setRepeatCount(0);
        this.bBM.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cR(false);
            }
        });
        this.bBN = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bBK.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(boolean z) {
        if (this.bBK.getVisibility() == 0 && this.bBM != null && this.bBL != null) {
            if (z) {
                if (!this.bBM.isAnimating()) {
                    this.bBM.setVisibility(0);
                    this.bBL.setVisibility(4);
                    this.bBM.playAnimation();
                    return;
                }
                return;
            }
            if (this.bBM.isAnimating()) {
                this.bBM.cancelAnimation();
            }
            this.bBM.setVisibility(4);
            this.bBL.setVisibility(0);
        }
    }

    public void cS(boolean z) {
        if (this.bBN != null) {
            if (z) {
                cR(true);
                this.mHandler.removeCallbacks(this.bBN);
                this.mHandler.postDelayed(this.bBN, 7000L);
                return;
            }
            cR(false);
            this.mHandler.removeCallbacks(this.bBN);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bBK.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Qi() {
        return this.bBK.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bBO = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bBO;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bBK.setVisibility(8);
            return;
        }
        if (this.bBK.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bBK.setVisibility(0);
        cS(true);
        if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j2))) {
            ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j2));
            LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j2 + "", j + "", str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AudienceLiveGoodsEnterView.this.cR(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bBN, 12000L);
        }
    }
}
