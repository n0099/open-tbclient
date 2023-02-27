package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.slidingtag.NadRewardSlidingTagView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.br0;
import com.baidu.tieba.qr0;
import com.baidu.tieba.tr0;
import com.baidu.tieba.xd1;
/* loaded from: classes2.dex */
public class NadRewardVideoAdOverContainer extends NadVideoAdOverContainer {
    public LinearLayout A;
    public LottieAnimationView B;
    public LottieAnimationView C;
    public NadRewardSlidingTagView y;
    public View.OnClickListener z;

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public int getLayoutId() {
        return R.layout.nad_reward_video_ad_over_layout;
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ AdBaseModel a;

        public a(AdBaseModel adBaseModel) {
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (NadRewardVideoAdOverContainer.this.z != null) {
                NadRewardVideoAdOverContainer.this.z.onClick(view2);
            }
            NadRewardVideoAdOverContainer.this.C.setVisibility(8);
            NadRewardVideoAdOverContainer.this.z(ClogBuilder.LogType.FREE_CLICK, "packet", this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements LottieListener<Throwable> {
        public final /* synthetic */ LottieAnimationView a;

        public b(LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            this.a.setVisibility(8);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements LottieListener<LottieComposition> {
        public final /* synthetic */ LottieAnimationView a;

        public c(LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            this.a.setComposition(lottieComposition);
            this.a.setRepeatCount(-1);
            this.a.playAnimation();
            this.a.setVisibility(0);
        }
    }

    public NadRewardVideoAdOverContainer(Context context) {
        super(context);
        this.z = null;
    }

    public final void H(@NonNull AdBaseModel adBaseModel) {
        qr0 qr0Var;
        if (adBaseModel instanceof br0) {
            qr0Var = ((br0) adBaseModel).i();
        } else {
            qr0Var = null;
        }
        if (qr0Var == null) {
            this.y.setVisibility(8);
            return;
        }
        this.y.setVisibility(0);
        this.y.F(qr0Var);
        this.y.setOnClickListener(s(adBaseModel, ClogBuilder.Area.REWARD_SLIDING_TAG.type));
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void n(Context context) {
        super.n(context);
        this.y = (NadRewardSlidingTagView) findViewById(R.id.ad_sliding_tag);
        this.A = (LinearLayout) findViewById(R.id.festival_entrance_container);
        this.C = (LottieAnimationView) findViewById(R.id.festival_bubble_lottie);
        this.B = (LottieAnimationView) findViewById(R.id.festival_entrance_lottie);
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void setData(AdBaseModel adBaseModel) {
        super.setData(adBaseModel);
        H(adBaseModel);
        G(adBaseModel);
    }

    public void setFestivalClickCallback(@NonNull View.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public NadRewardVideoAdOverContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = null;
    }

    public NadRewardVideoAdOverContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = null;
    }

    public final void I(@NonNull Context context, @NonNull LottieAnimationView lottieAnimationView, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            lottieAnimationView.setVisibility(8);
        } else {
            LottieCompositionFactory.fromUrl(context, str, String.valueOf(str.hashCode())).addListener(new c(lottieAnimationView)).addFailureListener(new b(lottieAnimationView));
        }
    }

    public final void G(@NonNull AdBaseModel adBaseModel) {
        tr0 tr0Var;
        if (adBaseModel instanceof br0) {
            tr0Var = ((br0) adBaseModel).g().m();
        } else {
            tr0Var = null;
        }
        if (tr0Var == null) {
            this.A.setVisibility(8);
            return;
        }
        I(getContext(), this.C, tr0Var.b);
        I(getContext(), this.B, tr0Var.a);
        this.A.setVisibility(0);
        z(ClogBuilder.LogType.FREE_SHOW, "packet", adBaseModel);
        this.A.setOnClickListener(new a(adBaseModel));
    }

    @NonNull
    public xd1<View> getTransitionButtonView() {
        return this.j;
    }

    public void setFestivalEntranceContainerInvisible() {
        this.A.setVisibility(8);
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void y() {
        super.y();
        this.y.x();
        this.C.cancelAnimation();
        this.B.cancelAnimation();
    }
}
