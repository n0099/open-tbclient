package c.a.q0.i2.k.e.b1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.l.s0;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.x0;
import c.a.q0.a0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g extends c.a.q0.i2.k.e.b1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19306f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f19307g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f19308h;

    /* renamed from: i  reason: collision with root package name */
    public c2 f19309i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.s.q.a f19310j;
    public s0 k;

    /* loaded from: classes3.dex */
    public class a extends c.a.p0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19311e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19311e = gVar;
        }

        @Override // c.a.p0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.p0.s.q.a
        public c2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19311e.f19309i : (c2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19312e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19312e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            a.InterfaceC0094a interfaceC0094a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0094a = (gVar = this.f19312e).f19275c) == null) {
                return;
            }
            interfaceC0094a.a(gVar.f19310j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19306f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19273a.getPageActivity());
                this.f19306f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f19306f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f19306f, R.color.CAM_X0206);
                this.f19306f.setOrientation(1);
                this.f19306f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f19306f.removeAllViews();
            if (this.f19307g == null) {
                g0 g0Var = new g0(this.f19273a);
                this.f19307g = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f19306f.addView(this.f19307g.f(), layoutParams);
            if (this.k == null) {
                s0 s0Var = new s0(this.f19273a.getPageActivity());
                this.k = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams2.bottomMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
            this.f19306f.addView(this.k.f(), layoutParams2);
            if (this.f19308h == null) {
                this.f19308h = new ItemCardView(this.f19273a.getPageActivity());
            }
            this.f19308h.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams3.leftMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams3.rightMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams3.bottomMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f19306f.addView(this.f19308h, layoutParams3);
            return this.f19306f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19277e == i2) {
            return;
        }
        this.f19277e = i2;
        SkinManager.setBackgroundColor(this.f19306f, R.color.CAM_X0206);
        g0 g0Var = this.f19307g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f19308h;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19276d = originalThreadInfo;
            this.f19309i = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f19310j = aVar;
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            ItemCardView itemCardView = this.f19308h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.B, 17, originalThreadInfo.f47306f);
            }
            g0 g0Var = this.f19307g;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f19310j);
            }
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void d(a.InterfaceC0094a interfaceC0094a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0094a) == null) {
            super.d(interfaceC0094a);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.w(interfaceC0094a);
            }
            g0 g0Var = this.f19307g;
            if (g0Var != null) {
                g0Var.v(interfaceC0094a);
            }
            LinearLayout linearLayout = this.f19306f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.k(this.f19274b);
            }
        }
    }
}
