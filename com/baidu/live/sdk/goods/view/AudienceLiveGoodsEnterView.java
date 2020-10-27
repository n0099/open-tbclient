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
    private View brQ;
    private ImageView brR;
    private TBLottieAnimationView brS;
    private a brT;
    private ViewGroup brU;
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
        this.brQ = inflate.findViewById(a.g.audience_goods_layout);
        this.brR = (ImageView) inflate.findViewById(a.g.audience_goods_imageView);
        this.brS = (TBLottieAnimationView) inflate.findViewById(a.g.audience_goods_lottieView);
        this.brS.setImageAssetsFolder("images/");
        this.brS.setAnimation("shoppingJson.json");
        this.brS.setRepeatCount(0);
        this.brS.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AudienceLiveGoodsEnterView.this.cs(false);
            }
        });
        this.brT = new a();
    }

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.brQ.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(boolean z) {
        if (this.brQ.getVisibility() == 0 && this.brS != null && this.brR != null) {
            if (z) {
                if (!this.brS.isAnimating()) {
                    this.brS.setVisibility(0);
                    this.brR.setVisibility(4);
                    this.brS.playAnimation();
                    return;
                }
                return;
            }
            if (this.brS.isAnimating()) {
                this.brS.cancelAnimation();
            }
            this.brS.setVisibility(4);
            this.brR.setVisibility(0);
        }
    }

    public void ct(boolean z) {
        if (this.brT != null) {
            if (z) {
                cs(true);
                this.mHandler.removeCallbacks(this.brT);
                this.mHandler.postDelayed(this.brT, 7000L);
                return;
            }
            cs(false);
            this.mHandler.removeCallbacks(this.brT);
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.brQ.setVisibility(8);
    }

    @Override // com.baidu.live.core.a.a
    public View getRootLayout() {
        return this;
    }

    public boolean Pm() {
        return this.brQ.getVisibility() == 0;
    }

    @Override // com.baidu.live.core.a.a
    public void setTargetView(View view) {
        this.brU = (ViewGroup) view;
    }

    public ViewGroup getTargetView() {
        return this.brU;
    }

    public void a(long j, String str, long j2, String str2, int i, List<com.baidu.live.sdk.goods.a.a> list) {
        if (i <= 0) {
            this.brQ.setVisibility(8);
            return;
        }
        if (this.brQ.getVisibility() == 8) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
        }
        this.brQ.setVisibility(0);
        ct(true);
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
            AudienceLiveGoodsEnterView.this.cs(true);
            AudienceLiveGoodsEnterView.this.mHandler.postDelayed(AudienceLiveGoodsEnterView.this.brT, 12000L);
        }
    }
}
