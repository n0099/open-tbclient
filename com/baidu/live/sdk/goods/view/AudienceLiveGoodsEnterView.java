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
/* loaded from: classes3.dex */
public class AudienceLiveGoodsEnterView extends FrameLayout implements com.baidu.live.core.a.a {
    private TBLottieAnimationView bdA;
    private a bdB;
    private ViewGroup bdC;
    private View bdy;
    private ImageView bdz;
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
        this.bdy = inflate.findViewById(a.g.audience_goods_layout);
        this.bdz = (ImageView) inflate.findViewById(a.g.audience_goods_imageView);
        this.bdA = (TBLottieAnimationView) inflate.findViewById(a.g.audience_goods_lottieView);
        this.bdA.setImageAssetsFolder("images/");
        this.bdA.setAnimation("icon_shopping.json");
        this.bdA.setRepeatCount(0);
        this.bdA.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.ca(false);
            }
        });
        this.bdB = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bdy.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(boolean z) {
        if (this.bdy.getVisibility() == 0 && this.bdA != null && this.bdz != null) {
            if (z) {
                if (!this.bdA.isAnimating()) {
                    this.bdA.setVisibility(0);
                    this.bdz.setVisibility(4);
                    this.bdA.playAnimation();
                    return;
                }
                return;
            }
            if (this.bdA.isAnimating()) {
                this.bdA.cancelAnimation();
            }
            this.bdA.setVisibility(4);
            this.bdz.setVisibility(0);
        }
    }

    public void cb(boolean z) {
        if (this.bdB != null) {
            if (z) {
                ca(true);
                this.mHandler.removeCallbacks(this.bdB);
                this.mHandler.postDelayed(this.bdB, 7000L);
                return;
            }
            ca(false);
            this.mHandler.removeCallbacks(this.bdB);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bdy.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Hi() {
        return this.bdy.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bdC = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bdC;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bdy.setVisibility(8);
            return;
        }
        if (this.bdy.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bdy.setVisibility(0);
        cb(true);
        if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j2))) {
            ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j2));
            LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j2 + "", j + "", str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AudienceLiveGoodsEnterView.this.ca(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bdB, 12000L);
        }
    }
}
