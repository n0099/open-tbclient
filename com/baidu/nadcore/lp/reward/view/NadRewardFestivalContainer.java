package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.ks0;
import com.baidu.tieba.mp0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.rp0;
/* loaded from: classes3.dex */
public class NadRewardFestivalContainer extends RelativeLayout {
    public View.OnClickListener a;
    public LinearLayout b;
    public LottieAnimationView c;
    public LottieAnimationView d;
    public NadRewardVideoAdOverContainer e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ AdBaseModel a;

        public a(AdBaseModel adBaseModel) {
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (NadRewardFestivalContainer.this.a != null) {
                NadRewardFestivalContainer.this.a.onClick(view2);
            }
            NadRewardFestivalContainer.this.d.setVisibility(8);
            if (NadRewardFestivalContainer.this.e != null) {
                NadRewardFestivalContainer.this.e.D(ClogBuilder.LogType.FREE_SHOW, "packet", this.a);
            }
        }
    }

    public NadRewardFestivalContainer(Context context) {
        super(context);
        this.a = null;
        d(context);
    }

    public final void d(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.b = (LinearLayout) findViewById(R.id.festival_entrance_container);
        this.d = (LottieAnimationView) findViewById(R.id.festival_bubble_lottie);
        this.c = (LottieAnimationView) findViewById(R.id.festival_entrance_lottie);
    }

    public void setContainer(NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer) {
        this.e = nadRewardVideoAdOverContainer;
    }

    public void setData(AdBaseModel adBaseModel) {
        e(adBaseModel);
    }

    public void setFestivalClickCallback(@NonNull View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    public NadRewardFestivalContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        d(context);
    }

    public NadRewardFestivalContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        d(context);
    }

    private int getLayoutId() {
        return mp0.a().n();
    }

    public void f() {
        this.d.cancelAnimation();
        this.c.cancelAnimation();
    }

    public void setFestivalEntranceContainerInvisible() {
        this.b.setVisibility(8);
    }

    public final void e(@NonNull AdBaseModel adBaseModel) {
        ks0 ks0Var;
        if (adBaseModel instanceof pr0) {
            ks0Var = ((pr0) adBaseModel).h().m();
        } else {
            ks0Var = null;
        }
        if (ks0Var == null) {
            this.b.setVisibility(8);
            return;
        }
        rp0.a(getContext(), this.d, ks0Var.b);
        rp0.a(getContext(), this.c, ks0Var.a);
        this.b.setVisibility(0);
        NadRewardVideoAdOverContainer nadRewardVideoAdOverContainer = this.e;
        if (nadRewardVideoAdOverContainer != null) {
            nadRewardVideoAdOverContainer.D(ClogBuilder.LogType.FREE_SHOW, "packet", adBaseModel);
        }
        this.b.setOnClickListener(new a(adBaseModel));
    }
}
