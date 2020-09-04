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
    private View bjv;
    private ImageView bjw;
    private TBLottieAnimationView bjx;
    private a bjy;
    private ViewGroup bjz;
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
        this.bjv = inflate.findViewById(a.g.audience_goods_layout);
        this.bjw = (ImageView) inflate.findViewById(a.g.audience_goods_imageView);
        this.bjx = (TBLottieAnimationView) inflate.findViewById(a.g.audience_goods_lottieView);
        this.bjx.setImageAssetsFolder("images/");
        this.bjx.setAnimation("shoppingJson.json");
        this.bjx.setRepeatCount(0);
        this.bjx.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cm(false);
            }
        });
        this.bjy = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bjv.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(boolean z) {
        if (this.bjv.getVisibility() == 0 && this.bjx != null && this.bjw != null) {
            if (z) {
                if (!this.bjx.isAnimating()) {
                    this.bjx.setVisibility(0);
                    this.bjw.setVisibility(4);
                    this.bjx.playAnimation();
                    return;
                }
                return;
            }
            if (this.bjx.isAnimating()) {
                this.bjx.cancelAnimation();
            }
            this.bjx.setVisibility(4);
            this.bjw.setVisibility(0);
        }
    }

    public void cn(boolean z) {
        if (this.bjy != null) {
            if (z) {
                cm(true);
                this.mHandler.removeCallbacks(this.bjy);
                this.mHandler.postDelayed(this.bjy, 7000L);
                return;
            }
            cm(false);
            this.mHandler.removeCallbacks(this.bjy);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bjv.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Ng() {
        return this.bjv.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bjz = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bjz;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bjv.setVisibility(8);
            return;
        }
        if (this.bjv.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bjv.setVisibility(0);
        cn(true);
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
            AudienceLiveGoodsEnterView.this.cm(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bjy, 12000L);
        }
    }
}
