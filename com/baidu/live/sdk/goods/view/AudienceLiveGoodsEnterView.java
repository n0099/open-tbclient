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
    private View bAk;
    private ImageView bAl;
    private TBLottieAnimationView bAm;
    private a bAn;
    private ViewGroup bAo;
    private boolean bAp;
    private Handler mHandler;

    public AudienceLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        this.bAp = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAp = true;
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAp = true;
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        this.bAp = ExtraParamsManager.getABTestSwitcher(ExtraParamsManager.KEY_SHOP_GIFT_ICON_AB, true);
        View inflate = View.inflate(context, a.g.ala_audience_live_goods_enter_view, this);
        this.bAk = inflate.findViewById(a.f.audience_goods_layout);
        this.bAl = (ImageView) inflate.findViewById(a.f.audience_goods_imageView);
        this.bAm = (TBLottieAnimationView) inflate.findViewById(a.f.audience_goods_lottieView);
        if (this.bAp) {
            this.bAm.setImageAssetsFolder("lottie/testa/shopimages");
            this.bAm.setAnimation("lottie/liveshow_shopping_testa.json");
            this.bAl.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testa);
        } else {
            this.bAm.setImageAssetsFolder("lottie/testb/shopimages");
            this.bAm.setAnimation("lottie/liveshow_shopping_testb.json");
            this.bAl.setImageResource(a.e.ala_live_icon_bottom_bar_shop_testb);
        }
        this.bAm.setRepeatCount(0);
        this.bAm.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cR(false);
            }
        });
        this.bAn = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bAk.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(boolean z) {
        if (this.bAk.getVisibility() == 0 && this.bAm != null && this.bAl != null) {
            if (z) {
                if (!this.bAm.isAnimating()) {
                    this.bAm.setVisibility(0);
                    this.bAl.setVisibility(4);
                    this.bAm.playAnimation();
                    return;
                }
                return;
            }
            if (this.bAm.isAnimating()) {
                this.bAm.cancelAnimation();
            }
            this.bAm.setVisibility(4);
            this.bAl.setVisibility(0);
        }
    }

    public void cS(boolean z) {
        if (this.bAn != null) {
            if (z) {
                cR(true);
                this.mHandler.removeCallbacks(this.bAn);
                this.mHandler.postDelayed(this.bAn, 7000L);
                return;
            }
            cR(false);
            this.mHandler.removeCallbacks(this.bAn);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bAk.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Qf() {
        return this.bAk.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bAo = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bAo;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bAk.setVisibility(8);
            return;
        }
        if (this.bAk.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bAk.setVisibility(0);
        cS(true);
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
            AudienceLiveGoodsEnterView.this.cR(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bAn, 12000L);
        }
    }
}
