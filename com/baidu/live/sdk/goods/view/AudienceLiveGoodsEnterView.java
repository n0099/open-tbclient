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
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import java.util.List;
/* loaded from: classes4.dex */
public class AudienceLiveGoodsEnterView extends FrameLayout implements com.baidu.live.core.a.a {
    private View bmo;
    private ImageView bmp;
    private TBLottieAnimationView bmq;
    private a bmr;
    private ViewGroup bms;
    private Handler mHandler;

    public AudienceLiveGoodsEnterView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AudienceLiveGoodsEnterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        View inflate = View.inflate(context, a.h.ala_audience_live_goods_enter_view, this);
        this.bmo = inflate.findViewById(a.g.audience_goods_layout);
        this.bmp = (ImageView) inflate.findViewById(a.g.audience_goods_imageView);
        this.bmq = (TBLottieAnimationView) inflate.findViewById(a.g.audience_goods_lottieView);
        this.bmq.setImageAssetsFolder("images/");
        this.bmq.setAnimation("shoppingJson.json");
        this.bmq.setRepeatCount(0);
        this.bmq.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cn(false);
            }
        });
        this.bmr = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bmo.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (this.bmo.getVisibility() == 0 && this.bmq != null && this.bmp != null) {
            if (z) {
                if (!this.bmq.isAnimating()) {
                    this.bmq.setVisibility(0);
                    this.bmp.setVisibility(4);
                    this.bmq.playAnimation();
                    return;
                }
                return;
            }
            if (this.bmq.isAnimating()) {
                this.bmq.cancelAnimation();
            }
            this.bmq.setVisibility(4);
            this.bmp.setVisibility(0);
        }
    }

    public void co(boolean z) {
        if (this.bmr != null) {
            if (z) {
                cn(true);
                this.mHandler.removeCallbacks(this.bmr);
                this.mHandler.postDelayed(this.bmr, 7000L);
                return;
            }
            cn(false);
            this.mHandler.removeCallbacks(this.bmr);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bmo.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean NJ() {
        return this.bmo.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bms = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bms;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bmo.setVisibility(8);
            return;
        }
        if (this.bmo.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bmo.setVisibility(0);
        co(true);
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
            AudienceLiveGoodsEnterView.this.cn(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bmr, 12000L);
        }
    }
}
