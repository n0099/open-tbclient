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
import com.baidu.tieba.ns0;
import com.baidu.tieba.qs0;
import com.baidu.tieba.ue1;
import com.baidu.tieba.yr0;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        ns0 ns0Var;
        if (adBaseModel instanceof yr0) {
            ns0Var = ((yr0) adBaseModel).i();
        } else {
            ns0Var = null;
        }
        if (ns0Var == null) {
            this.y.setVisibility(8);
            return;
        }
        this.y.setVisibility(0);
        this.y.F(ns0Var);
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
        qs0 qs0Var;
        if (adBaseModel instanceof yr0) {
            qs0Var = ((yr0) adBaseModel).g().m();
        } else {
            qs0Var = null;
        }
        if (qs0Var == null) {
            this.A.setVisibility(8);
            return;
        }
        I(getContext(), this.C, qs0Var.b);
        I(getContext(), this.B, qs0Var.a);
        this.A.setVisibility(0);
        z(ClogBuilder.LogType.FREE_SHOW, "packet", adBaseModel);
        this.A.setOnClickListener(new a(adBaseModel));
    }

    @NonNull
    public ue1<View> getTransitionButtonView() {
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
