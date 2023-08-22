package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tieba.hs0;
import com.baidu.tieba.ks0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.ud1;
/* loaded from: classes3.dex */
public class NadRewardVideoAdOverContainer extends NadVideoAdOverContainer {
    public LinearLayout A;
    public LottieAnimationView B;
    public LottieAnimationView C;
    public NadRewardSlidingTagView y;
    public View.OnClickListener z;

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public String n(String str) {
        return str;
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
            NadRewardVideoAdOverContainer.this.D(ClogBuilder.LogType.FREE_CLICK, "packet", this.a);
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

    public final void L(@NonNull AdBaseModel adBaseModel) {
        hs0 hs0Var;
        if (adBaseModel instanceof pr0) {
            hs0Var = ((pr0) adBaseModel).k();
        } else {
            hs0Var = null;
        }
        if (hs0Var == null) {
            this.y.setVisibility(8);
            return;
        }
        this.y.setVisibility(0);
        this.y.G(hs0Var);
        this.y.setOnClickListener(w(adBaseModel, ClogBuilder.Area.REWARD_SLIDING_TAG.type));
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public float q(Drawable drawable) {
        return getResources().getDimension(mp0.a().m());
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void r(Context context) {
        super.r(context);
        this.y = (NadRewardSlidingTagView) findViewById(R.id.ad_sliding_tag);
        this.A = (LinearLayout) findViewById(R.id.festival_entrance_container);
        this.C = (LottieAnimationView) findViewById(R.id.festival_bubble_lottie);
        this.B = (LottieAnimationView) findViewById(R.id.festival_entrance_lottie);
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void setData(AdBaseModel adBaseModel) {
        super.setData(adBaseModel);
        L(adBaseModel);
        K(adBaseModel);
        this.q.setFontSize(R.dimen.nad_dimen_10dp, R.dimen.nad_dimen_10dp, R.dimen.nad_dimen_10dp, R.dimen.nad_dimen_10dp, R.dimen.nad_dimen_10dp);
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

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void D(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        super.D(logType, str, adBaseModel);
    }

    public final void M(@NonNull Context context, @NonNull LottieAnimationView lottieAnimationView, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            lottieAnimationView.setVisibility(8);
        } else {
            LottieCompositionFactory.fromUrl(context, str, String.valueOf(str.hashCode())).addListener(new c(lottieAnimationView)).addFailureListener(new b(lottieAnimationView));
        }
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public ud1<View> l(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2) {
        return new NadRewardEnhanceButtonView(context, viewGroup, view2);
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public void C() {
        super.C();
        this.y.x();
        this.C.cancelAnimation();
        this.B.cancelAnimation();
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer
    public int getLayoutId() {
        return mp0.a().u();
    }

    @Nullable
    public ud1<View> getTransitionButtonView() {
        return this.j;
    }

    public void setFestivalEntranceContainerInvisible() {
        this.A.setVisibility(8);
    }

    public final void K(@NonNull AdBaseModel adBaseModel) {
        ks0 ks0Var;
        if (adBaseModel instanceof pr0) {
            ks0Var = ((pr0) adBaseModel).h().m();
        } else {
            ks0Var = null;
        }
        if (ks0Var == null) {
            this.A.setVisibility(8);
            return;
        }
        M(getContext(), this.C, ks0Var.b);
        M(getContext(), this.B, ks0Var.a);
        this.A.setVisibility(0);
        D(ClogBuilder.LogType.FREE_SHOW, "packet", adBaseModel);
        this.A.setOnClickListener(new a(adBaseModel));
    }
}
