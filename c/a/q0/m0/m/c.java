package c.a.q0.m0.m;

import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.q.p1;
import c.a.p0.s.q.x;
import c.a.q0.m0.d.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
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
/* loaded from: classes3.dex */
public class c extends c.a.p0.i0.f.a<x, c.a.q0.m0.d.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public ImageView r;
    public TextView s;
    public BarImageView t;
    public TextView u;
    public ViewEventCenter v;
    public View w;
    public TextView x;
    public View y;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f22252e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f22253f;

        public a(c cVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22253f = cVar;
            this.f22252e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c13386");
                this.f22253f.v.dispatchMvcEvent(new c.a.p0.i0.c.b(15, this.f22252e, null, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f22254e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f22255f;

        public b(c cVar, x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22255f = cVar;
            this.f22254e = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.f22255f.r());
                bundle.putParcelable("info_forum_name_rect", this.f22255f.s());
                c.a.p0.i0.c.b bVar = new c.a.p0.i0.c.b(1, this.f22254e, null, null);
                bVar.g(bundle);
                this.f22255f.v.dispatchMvcEvent(bVar);
            }
        }
    }

    /* renamed from: c.a.q0.m0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnLongClickListenerC1034c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f22256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f22257f;

        public View$OnLongClickListenerC1034c(c cVar, x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22257f = cVar;
            this.f22256e = xVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f22257f.v.dispatchMvcEvent(new c.a.p0.i0.c.b(12, this.f22256e, null, null));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f22258e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22259f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f22260g;

        public d(c cVar, TextView textView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, textView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22260g = cVar;
            this.f22258e = textView;
            this.f22259f = i2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f22258e.getParent() instanceof ViewGroup) && (k = l.k(this.f22260g.b())) != 0) {
                this.f22258e.setMaxWidth(k - (this.f22259f + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.f22258e.postInvalidate();
                this.f22258e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = viewEventCenter;
        View findViewById = view.findViewById(R.id.rootview);
        this.k = findViewById;
        this.l = (TextView) findViewById.findViewById(R.id.name);
        this.m = (TextView) this.k.findViewById(R.id.live_label);
        this.n = (TextView) this.k.findViewById(R.id.pinpai_label);
        this.o = (TextView) this.k.findViewById(R.id.trial_label);
        this.p = (TextView) this.k.findViewById(R.id.edit_btn_label);
        this.q = (ImageView) this.k.findViewById(R.id.sign);
        this.r = (ImageView) this.k.findViewById(R.id.grade);
        this.s = (TextView) this.k.findViewById(R.id.owner_flag);
        this.w = this.k.findViewById(R.id.enterforum_item_divider);
        this.x = (TextView) this.k.findViewById(R.id.tv_add_love);
        this.t = (BarImageView) this.k.findViewById(R.id.forum_avatar);
        this.y = this.k.findViewById(R.id.forum_top_divider);
        this.u = (TextView) this.k.findViewById(R.id.forum_intro);
        this.t.setPlaceHolder(1);
        this.t.setStrokeColorResId(R.color.CAM_X0201);
    }

    @Override // c.a.q0.i3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2)) == null) {
            c.a.p0.u0.a.a(tbPageContext, g());
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final Rect r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Rect rect = new Rect();
            this.t.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final Rect s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Rect rect = new Rect();
            this.l.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.i0.f.e
    /* renamed from: t */
    public void k(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xVar) == null) {
            super.k(xVar);
            if (xVar == null) {
                return;
            }
            w(xVar);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        }
    }

    public final void u(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, textView, i2) == null) || textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, textView, i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.i0.f.e
    /* renamed from: v */
    public void m(c.a.q0.m0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            super.m(cVar);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
            stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
            this.k.setBackgroundDrawable(stateListDrawable);
            this.t.setPlaceHolder(1);
        }
    }

    public final void w(x xVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xVar) == null) || xVar == null) {
            return;
        }
        c.a.q0.m0.d.c cVar = (c.a.q0.m0.d.c) h();
        this.k.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i3 = 0;
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        if (xVar instanceof f) {
            f fVar = (f) xVar;
            this.l.setText(fVar.w());
            this.q.setVisibility(fVar.G() == 0 ? 8 : 0);
            if (fVar.t() == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                SkinManager.setImageResource(this.r, BitmapHelper.getGradeResourceIdInEnterForum(fVar.t()));
            }
            this.t.setShowOval(true);
            this.t.startLoad(fVar.k(), 10, false);
            this.t.setShowOuterBorder(false);
            this.t.setShowInnerBorder(true);
            this.t.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.t.setStrokeColorResId(R.color.CAM_X0401);
            if (fVar.q() > 0) {
                SkinManager.setBackgroundColor(this.y, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.y, R.color.transparent);
            }
            if (!fVar.A().isEmpty()) {
                this.u.setText(fVar.A());
            }
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(fVar.w())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            this.s.setVisibility((fVar.E() == 1 && fVar.F() == 1) ? 0 : 8);
            if (fVar.C() == 1) {
                this.n.setVisibility(0);
                this.n.setText(R.string.brand_label_ba_text);
                SkinManager.setBackgroundResource(this.n, R.drawable.enter_forum_brand_label_bg_shape);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
                this.m.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(c.a.e.e.m.b.f(fVar.p(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.m.setVisibility(0);
                    this.m.setText("");
                    SkinManager.setBackgroundResource(this.m, R.drawable.icon_ba_list_live);
                    SkinManager.setViewTextColor(this.m, R.color.CAM_X0111);
                } else {
                    this.m.setVisibility(8);
                }
                this.n.setVisibility(8);
            }
            if (fVar.H()) {
                this.o.setVisibility(0);
                i2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.o.setVisibility(8);
                i2 = 0;
            }
            if (fVar.D()) {
                this.p.setVisibility(0);
                i2 += l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.p.setVisibility(8);
            }
            i3 = i2;
            this.p.setOnClickListener(new a(this, fVar));
        } else if (xVar instanceof p1) {
            p1 p1Var = (p1) xVar;
            this.l.setText(p1Var.p());
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(p1Var.p())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setBackgroundResource(this.s, R.drawable.icon_owner_bg);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        this.x.setVisibility(8);
        this.k.setOnClickListener(new b(this, xVar));
        this.k.setOnLongClickListener(new View$OnLongClickListenerC1034c(this, xVar));
        u(this.l, i3);
    }
}
