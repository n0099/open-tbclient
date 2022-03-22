package c.a.p0.w0.o;

import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.n1;
import c.a.o0.r.r.x;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e extends c.a.o0.k0.f.a<x, c.a.p0.w0.e.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public View f19592g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19593h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public BarImageView p;
    public TextView q;
    public ViewEventCenter r;
    public View s;
    public TextView t;
    public View u;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.w0.e.h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19594b;

        public a(e eVar, c.a.p0.w0.e.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19594b = eVar;
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c13386");
                this.f19594b.r.dispatchMvcEvent(new c.a.o0.k0.c.b(15, this.a, null, null));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19595b;

        public b(e eVar, x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19595b = eVar;
            this.a = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.f19595b.p());
                bundle.putParcelable("info_forum_name_rect", this.f19595b.q());
                c.a.o0.k0.c.b bVar = new c.a.o0.k0.c.b(1, this.a, null, null);
                bVar.g(bundle);
                this.f19595b.r.dispatchMvcEvent(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19596b;

        public c(e eVar, x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19596b = eVar;
            this.a = xVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f19596b.r.dispatchMvcEvent(new c.a.o0.k0.c.b(12, this.a, null, null));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f19597b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f19598c;

        public d(e eVar, TextView textView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, textView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19598c = eVar;
            this.a = textView;
            this.f19597b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (k = n.k(this.f19598c.getContext())) != 0) {
                this.a.setMaxWidth(k - (this.f19597b + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = viewEventCenter;
        View findViewById = view.findViewById(R.id.obfuscated_res_0x7f091aef);
        this.f19592g = findViewById;
        this.f19593h = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0914e9);
        this.i = (TextView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f0912b8);
        this.j = (TextView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f091843);
        this.k = (TextView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f092151);
        this.l = (TextView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f09084a);
        this.m = (ImageView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f091cfc);
        this.n = (ImageView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f090ce0);
        this.o = (TextView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f091634);
        this.s = this.f19592g.findViewById(R.id.obfuscated_res_0x7f0908e5);
        this.t = (TextView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f09217a);
        this.p = (BarImageView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f090a1e);
        this.u = this.f19592g.findViewById(R.id.obfuscated_res_0x7f090a98);
        this.q = (TextView) this.f19592g.findViewById(R.id.obfuscated_res_0x7f090a54);
        this.p.setPlaceHolder(1);
        this.p.setStrokeColorResId(R.color.CAM_X0201);
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            c.a.o0.w0.a.a(tbPageContext, e());
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final Rect p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Rect rect = new Rect();
            this.p.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final Rect q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Rect rect = new Rect();
            this.f19593h.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: r */
    public void i(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xVar) == null) {
            super.i(xVar);
            if (xVar == null) {
                return;
            }
            u(xVar);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.obfuscated_res_0x7f0808de, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f19593h, (int) R.color.CAM_X0105);
        }
    }

    public final void s(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, textView, i) == null) || textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, textView, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: t */
    public void k(c.a.p0.w0.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            super.k(eVar);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
            stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
            this.f19592g.setBackgroundDrawable(stateListDrawable);
            this.p.setPlaceHolder(1);
        }
    }

    public final void u(x xVar) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xVar) == null) || xVar == null) {
            return;
        }
        c.a.p0.w0.e.e eVar = (c.a.p0.w0.e.e) f();
        this.f19592g.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i2 = 0;
        this.f19592g.setVisibility(0);
        this.f19593h.setVisibility(0);
        if (xVar instanceof c.a.p0.w0.e.h) {
            c.a.p0.w0.e.h hVar = (c.a.p0.w0.e.h) xVar;
            this.f19593h.setText(hVar.r());
            this.m.setVisibility(hVar.G() == 0 ? 8 : 0);
            if (hVar.q() == 0) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                SkinManager.setImageResource(this.n, BitmapHelper.getGradeResourceIdInEnterForum(hVar.q()));
            }
            this.p.setShowOval(true);
            this.p.J(hVar.i(), 10, false);
            this.p.setShowOuterBorder(false);
            this.p.setShowInnerBorder(true);
            this.p.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.p.setStrokeColorResId(R.color.CAM_X0401);
            if (hVar.m() > 0) {
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.u, R.color.transparent);
            }
            this.q.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0877), StringHelper.numberUniformFormatExtraWithRoundInt(hVar.A())));
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(hVar.r())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            this.o.setVisibility((hVar.E() == 1 && hVar.F() == 1) ? 0 : 8);
            if (hVar.C() == 1) {
                this.j.setVisibility(0);
                this.j.setText(R.string.obfuscated_res_0x7f0f032e);
                SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f0804d3);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
                this.i.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(c.a.d.f.m.b.g(hVar.getId(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.i.setVisibility(0);
                    this.i.setText("");
                    SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f08068f);
                    SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0111);
                } else {
                    this.i.setVisibility(8);
                }
                this.j.setVisibility(8);
            }
            if (hVar.H()) {
                this.k.setVisibility(0);
                i = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.k.setVisibility(8);
                i = 0;
            }
            if (hVar.D()) {
                this.l.setVisibility(0);
                i += n.f(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.l.setVisibility(8);
            }
            i2 = i;
            this.l.setOnClickListener(new a(this, hVar));
        } else if (xVar instanceof n1) {
            n1 n1Var = (n1) xVar;
            this.f19593h.setText(n1Var.m());
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(n1Var.m())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setBackgroundResource(this.o, R.drawable.obfuscated_res_0x7f08087e);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f19593h, (int) R.color.CAM_X0105);
        this.t.setVisibility(8);
        this.f19592g.setOnClickListener(new b(this, xVar));
        this.f19592g.setOnLongClickListener(new c(this, xVar));
        s(this.f19593h, i2);
    }
}
