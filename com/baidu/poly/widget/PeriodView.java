package com.baidu.poly.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.f0.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.poly.widget.entitiy.PayChannelExtInfoEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class PeriodView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38433e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38434f;

    /* renamed from: g  reason: collision with root package name */
    public PolyFrameLayout f38435g;

    /* renamed from: h  reason: collision with root package name */
    public View f38436h;

    /* renamed from: i  reason: collision with root package name */
    public g f38437i;

    /* renamed from: j  reason: collision with root package name */
    public View f38438j;

    /* renamed from: k  reason: collision with root package name */
    public ListView f38439k;
    public View l;
    public TextView m;
    public TextView n;
    public PayChannelEntity o;
    public c.a.f0.t.b p;
    public InstallmentEntity q;
    public String r;

    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PeriodView f38440e;

        public a(PeriodView periodView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38440e = periodView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f38440e.l.setAlpha(0.2f);
                    return false;
                } else if (action != 1) {
                    return false;
                } else {
                    this.f38440e.l.setAlpha(1.0f);
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PeriodView f38441e;

        public b(PeriodView periodView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38441e = periodView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PayChannelExtInfoEntity payChannelExtInfoEntity;
            ArrayList<InstallmentEntity> installmentEntities;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38441e.f38437i == null || this.f38441e.o == null || this.f38441e.o.getPayChannelExtInfoEntity() == null || (payChannelExtInfoEntity = this.f38441e.o.getPayChannelExtInfoEntity()) == null || (installmentEntities = payChannelExtInfoEntity.getInstallmentEntities()) == null) {
                return;
            }
            for (int i2 = 0; i2 < installmentEntities.size(); i2++) {
                InstallmentEntity installmentEntity = installmentEntities.get(i2);
                if (this.f38441e.q == installmentEntity) {
                    installmentEntity.setIsSelected("1");
                } else {
                    installmentEntity.setIsSelected("0");
                }
            }
            this.f38441e.f38437i.a();
            this.f38441e.f38437i.b("confirm");
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PeriodView f38442e;

        public c(PeriodView periodView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38442e = periodView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38442e.f38437i == null) {
                return;
            }
            this.f38442e.f38437i.b(com.alipay.sdk.widget.d.u);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f38443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PeriodView f38444f;

        public d(PeriodView periodView, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38444f = periodView;
            this.f38443e = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                c.a.f0.p.a.f3175c++;
                this.f38444f.q = (InstallmentEntity) this.f38443e.get(i2);
                this.f38444f.m.setText(this.f38444f.o.getPayChannelExtInfoEntity().getInstallmentTotal());
                this.f38444f.n.setText(this.f38444f.q.getCommission());
                this.f38444f.l.setEnabled(true);
                for (int i3 = 0; i3 < this.f38443e.size(); i3++) {
                    InstallmentEntity installmentEntity = (InstallmentEntity) this.f38443e.get(i3);
                    if (this.f38444f.q == installmentEntity) {
                        installmentEntity.setChecked(true);
                    } else {
                        installmentEntity.setChecked(false);
                    }
                }
                this.f38444f.p.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PeriodView f38445e;

        public e(PeriodView periodView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38445e = periodView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f38445e.f38434f = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PeriodView f38446e;

        public f(PeriodView periodView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38446e = periodView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f38446e.f38434f = false;
                this.f38446e.l();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a();

        void b(String str);

        void onDetach();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodView(Context context, PayChannelEntity payChannelEntity, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, payChannelEntity, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38433e = false;
        this.f38434f = false;
        this.o = payChannelEntity;
        this.r = str;
        m(context);
        initData();
    }

    public void attach(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f38435g.getLayoutParams().height = i2;
            k();
        }
    }

    public void enter(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || this.f38434f || !this.f38433e) {
            return;
        }
        this.f38434f = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_X, 0.0f, view.getMeasuredWidth() * (-1));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f38436h, AnimationProperty.TRANSLATE_X, view.getMeasuredWidth(), 0.0f);
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new e(this));
    }

    public void initData() {
        PayChannelEntity payChannelEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (payChannelEntity = this.o) == null || payChannelEntity.getPayChannelExtInfoEntity() == null || this.o.getPayChannelExtInfoEntity().getInstallmentEntities() == null) {
            return;
        }
        ArrayList<InstallmentEntity> installmentEntities = this.o.getPayChannelExtInfoEntity().getInstallmentEntities();
        for (int i2 = 0; i2 < installmentEntities.size(); i2++) {
            InstallmentEntity installmentEntity = installmentEntities.get(i2);
            if (installmentEntity.isSelected()) {
                this.q = installmentEntity;
                this.m.setText(this.o.getPayChannelExtInfoEntity().getInstallmentTotal());
                this.n.setText(this.q.getCommission());
                this.l.setEnabled(true);
                installmentEntity.setChecked(true);
            } else {
                installmentEntity.setChecked(false);
            }
        }
        this.p.b(installmentEntities);
        this.f38439k.setOnItemClickListener(new d(this, installmentEntities));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f38433e) {
            return;
        }
        this.f38433e = true;
        if (getContext() instanceof Activity) {
            View findViewById = ((Activity) getContext()).findViewById(16908290);
            if (findViewById instanceof ViewGroup) {
                ((ViewGroup) findViewById).addView(this);
            }
            h.g("PeriodView->attach()");
            return;
        }
        throw new IllegalStateException("can not attach to context " + getContext());
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f38433e) {
            this.f38433e = false;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            g gVar = this.f38437i;
            if (gVar != null) {
                gVar.onDetach();
            }
            h.g("PeriodView->detach()");
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(c.a.f0.h.period_list, (ViewGroup) this, true);
            this.f38435g = (PolyFrameLayout) findViewById(c.a.f0.g.root_layout);
            this.f38436h = findViewById(c.a.f0.g.period_layout);
            View findViewById = findViewById(c.a.f0.g.chosePeriod);
            this.l = findViewById;
            findViewById.setOnTouchListener(new a(this));
            this.l.setOnClickListener(new b(this));
            View findViewById2 = findViewById(c.a.f0.g.back);
            this.f38438j = findViewById2;
            findViewById2.setOnClickListener(new c(this));
            this.f38439k = (ListView) findViewById(c.a.f0.g.period_list);
            this.m = (TextView) findViewById(c.a.f0.g.installmentTotal);
            this.n = (TextView) findViewById(c.a.f0.g.commission);
            c.a.f0.t.b bVar = new c.a.f0.t.b(getContext());
            this.p = bVar;
            this.f38439k.setAdapter((ListAdapter) bVar);
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            c.a.f0.p.c cVar = new c.a.f0.p.c("10");
            cVar.a("type", this.r);
            c.a.f0.p.f.e(cVar);
        }
    }

    public boolean onBackPressed() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.f38434f && this.f38433e && (gVar = this.f38437i) != null) {
                gVar.b(com.alipay.sdk.widget.d.u);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void quit(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null || this.f38434f || !this.f38433e) {
            return;
        }
        this.f38434f = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_X, view.getMeasuredWidth() * (-1), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f38436h, AnimationProperty.TRANSLATE_X, 0.0f, view.getMeasuredWidth());
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new f(this));
    }

    public void setListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            this.f38437i = gVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38433e = false;
        this.f38434f = false;
        m(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38433e = false;
        this.f38434f = false;
        m(context);
    }
}
