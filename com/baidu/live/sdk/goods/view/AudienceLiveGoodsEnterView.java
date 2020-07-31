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
    private View bdQ;
    private ImageView bdR;
    private TBLottieAnimationView bdS;
    private a bdT;
    private ViewGroup bdU;
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
        this.bdQ = inflate.findViewById(a.g.audience_goods_layout);
        this.bdR = (ImageView) inflate.findViewById(a.g.audience_goods_imageView);
        this.bdS = (TBLottieAnimationView) inflate.findViewById(a.g.audience_goods_lottieView);
        this.bdS.setImageAssetsFolder("images/");
        this.bdS.setAnimation("shoppingJson.json");
        this.bdS.setRepeatCount(0);
        this.bdS.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cc(false);
            }
        });
        this.bdT = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bdQ.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(boolean z) {
        if (this.bdQ.getVisibility() == 0 && this.bdS != null && this.bdR != null) {
            if (z) {
                if (!this.bdS.isAnimating()) {
                    this.bdS.setVisibility(0);
                    this.bdR.setVisibility(4);
                    this.bdS.playAnimation();
                    return;
                }
                return;
            }
            if (this.bdS.isAnimating()) {
                this.bdS.cancelAnimation();
            }
            this.bdS.setVisibility(4);
            this.bdR.setVisibility(0);
        }
    }

    public void cd(boolean z) {
        if (this.bdT != null) {
            if (z) {
                cc(true);
                this.mHandler.removeCallbacks(this.bdT);
                this.mHandler.postDelayed(this.bdT, 7000L);
                return;
            }
            cc(false);
            this.mHandler.removeCallbacks(this.bdT);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.bdQ.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Ho() {
        return this.bdQ.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.bdU = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.bdU;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.bdQ.setVisibility(8);
            return;
        }
        if (this.bdQ.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.bdQ.setVisibility(0);
        cd(true);
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
            AudienceLiveGoodsEnterView.this.cc(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.bdT, 12000L);
        }
    }
}
