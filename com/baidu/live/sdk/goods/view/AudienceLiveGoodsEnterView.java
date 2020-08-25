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
/* loaded from: classes7.dex */
public class AudienceLiveGoodsEnterView extends FrameLayout implements com.baidu.live.core.a.a {
    private View bjs;
    private ImageView bjt;
    private TBLottieAnimationView bju;
    private a bjv;
    private ViewGroup bjw;
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
        this.bjs = inflate.findViewById(a.g.audience_goods_layout);
        this.bjt = (ImageView) inflate.findViewById(a.g.audience_goods_imageView);
        this.bju = (TBLottieAnimationView) inflate.findViewById(a.g.audience_goods_lottieView);
        this.bju.setImageAssetsFolder("images/");
        this.bju.setAnimation("shoppingJson.json");
        this.bju.setRepeatCount(0);
        this.bju.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cl(false);
            }
        });
        this.bjv = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bjs.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (this.bjs.getVisibility() == 0 && this.bju != null && this.bjt != null) {
            if (z) {
                if (!this.bju.isAnimating()) {
                    this.bju.setVisibility(0);
                    this.bjt.setVisibility(4);
                    this.bju.playAnimation();
                    return;
                }
                return;
            }
            if (this.bju.isAnimating()) {
                this.bju.cancelAnimation();
            }
            this.bju.setVisibility(4);
            this.bjt.setVisibility(0);
        }
    }

    public void cm(boolean z) {
        if (this.bjv != null) {
            if (z) {
                cl(true);
                this.mHandler.removeCallbacks(this.bjv);
                this.mHandler.postDelayed(this.bjv, 7000L);
                return;
            }
            cl(false);
            this.mHandler.removeCallbacks(this.bjv);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bjs.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Ng() {
        return this.bjs.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bjw = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bjw;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bjs.setVisibility(8);
            return;
        }
        if (this.bjs.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bjs.setVisibility(0);
        cm(true);
        if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j2))) {
            ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j2));
            LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j2 + "", j + "", str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AudienceLiveGoodsEnterView.this.cl(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bjv, 12000L);
        }
    }
}
