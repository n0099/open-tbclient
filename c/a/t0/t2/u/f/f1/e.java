package c.a.t0.t2.u.f.f1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e extends c.a.t0.t2.u.f.f1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23116f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f23117g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f23118h;

    /* renamed from: i  reason: collision with root package name */
    public e2 f23119i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s.q.a f23120j;

    /* loaded from: classes8.dex */
    public class a extends c.a.s0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23121e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23121e = eVar;
        }

        @Override // c.a.s0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.s0.s.q.a
        public e2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23121e.f23119i : (e2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23122e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23122e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            a.InterfaceC0202a interfaceC0202a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0202a = (eVar = this.f23122e).f23100c) == null) {
                return;
            }
            interfaceC0202a.a(eVar.f23120j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext tbPageContext) {
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

    @Override // c.a.t0.t2.u.f.f1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f23116f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f23116f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f23116f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f23116f, c.a.t0.t2.f.CAM_X0206);
                this.f23116f.setOrientation(1);
                this.f23116f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f23116f.removeAllViews();
            if (this.f23117g == null) {
                g0 g0Var = new g0(this.a);
                this.f23117g = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007);
            this.f23116f.addView(this.f23117g.f(), layoutParams);
            if (this.f23118h == null) {
                this.f23118h = new ItemCardView(this.a.getPageActivity());
            }
            this.f23118h.setBackGroundColor(c.a.t0.t2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X004);
            layoutParams2.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007);
            layoutParams2.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007);
            layoutParams2.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X005);
            this.f23116f.addView(this.f23118h, layoutParams2);
            return this.f23116f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f23102e == i2) {
            return;
        }
        this.f23102e = i2;
        SkinManager.setBackgroundColor(this.f23116f, c.a.t0.t2.f.CAM_X0206);
        g0 g0Var = this.f23117g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f23118h;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f23101d = originalThreadInfo;
            this.f23119i = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f23120j = new a(this);
            ItemCardView itemCardView = this.f23118h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.D, 17, originalThreadInfo.f40160f);
            }
            g0 g0Var = this.f23117g;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f23120j);
            }
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void d(a.InterfaceC0202a interfaceC0202a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0202a) == null) {
            super.d(interfaceC0202a);
            g0 g0Var = this.f23117g;
            if (g0Var != null) {
                g0Var.v(interfaceC0202a);
            }
            LinearLayout linearLayout = this.f23116f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }
}
