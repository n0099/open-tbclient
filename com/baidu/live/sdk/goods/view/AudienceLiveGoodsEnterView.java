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
    private View bwH;
    private ImageView bwI;
    private TBLottieAnimationView bwJ;
    private a bwK;
    private ViewGroup bwL;
    private boolean bwM;
    private Handler mHandler;

    public AudienceLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        this.bwM = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwM = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwM = true;
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        this.bwM = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        View inflate = View.inflate(context, a.g.ala_audience_live_goods_enter_view, this);
        this.bwH = inflate.findViewById(a.f.audience_goods_layout);
        this.bwI = (ImageView) inflate.findViewById(a.f.audience_goods_imageView);
        this.bwJ = (TBLottieAnimationView) inflate.findViewById(a.f.audience_goods_lottieView);
        if (this.bwM) {
            this.bwJ.setImageAssetsFolder("lottie/testa/shopimages");
            this.bwJ.setAnimation("lottie/liveshow_shopping_testa.json");
            this.bwI.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bwJ.setImageAssetsFolder("lottie/testb/shopimages");
            this.bwJ.setAnimation("lottie/liveshow_shopping_testb.json");
            this.bwI.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
        this.bwJ.setRepeatCount(0);
        this.bwJ.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cI(false);
            }
        });
        this.bwK = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bwH.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(boolean z) {
        if (this.bwH.getVisibility() == 0 && this.bwJ != null && this.bwI != null) {
            if (z) {
                if (!this.bwJ.isAnimating()) {
                    this.bwJ.setVisibility(0);
                    this.bwI.setVisibility(4);
                    this.bwJ.playAnimation();
                    return;
                }
                return;
            }
            if (this.bwJ.isAnimating()) {
                this.bwJ.cancelAnimation();
            }
            this.bwJ.setVisibility(4);
            this.bwI.setVisibility(0);
        }
    }

    public void cJ(boolean z) {
        if (this.bwK != null) {
            if (z) {
                cI(true);
                this.mHandler.removeCallbacks(this.bwK);
                this.mHandler.postDelayed(this.bwK, 7000L);
                return;
            }
            cI(false);
            this.mHandler.removeCallbacks(this.bwK);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bwH.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean OF() {
        return this.bwH.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bwL = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bwL;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bwH.setVisibility(8);
            return;
        }
        if (this.bwH.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bwH.setVisibility(0);
        cJ(true);
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
            AudienceLiveGoodsEnterView.this.cI(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bwK, 12000L);
        }
    }
}
