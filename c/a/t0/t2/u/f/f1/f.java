package c.a.t0.t2.u.f.f1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.o;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import c.a.t0.g0.d0;
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
public class f extends c.a.t0.t2.u.f.f1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23123f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f23124g;

    /* renamed from: h  reason: collision with root package name */
    public e2 f23125h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.s.q.a f23126i;

    /* renamed from: j  reason: collision with root package name */
    public o f23127j;

    /* loaded from: classes8.dex */
    public class a extends c.a.s0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23128e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23128e = fVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23128e.f23125h : (e2) invokeV.objValue;
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
        public final /* synthetic */ f f23129e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23129e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0202a interfaceC0202a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0202a = (fVar = this.f23129e).f23100c) == null) {
                return;
            }
            interfaceC0202a.a(fVar.f23126i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext) {
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
            if (this.f23123f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f23123f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f23123f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f23123f, c.a.t0.t2.f.CAM_X0206);
                this.f23123f.setOrientation(1);
                this.f23123f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f23123f.removeAllViews();
            if (this.f23127j == null) {
                o oVar = new o(this.a.getPageActivity());
                this.f23127j = oVar;
                oVar.m(Boolean.TRUE);
                this.f23127j.w("pb");
                this.f23127j.y(0);
                this.f23127j.D(this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007), this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X005), this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007), 0);
                this.f23127j.E(false);
                this.f23127j.C(true);
            }
            this.f23123f.addView(this.f23127j.f());
            if (this.f23124g == null) {
                ItemCardView itemCardView = new ItemCardView(this.a.getPageActivity());
                this.f23124g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f23124g.setBackGroundColor(c.a.t0.t2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X004);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007);
            layoutParams.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X005);
            this.f23123f.addView(this.f23124g, layoutParams);
            return this.f23123f;
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
        SkinManager.setBackgroundColor(this.f23123f, c.a.t0.t2.f.CAM_X0206);
        o oVar = this.f23127j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f23124g;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f23101d = originalThreadInfo;
            this.f23125h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f23126i = new a(this);
            ItemCardView itemCardView = this.f23124g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.D, 17, originalThreadInfo.f40160f);
            }
            o oVar = this.f23127j;
            if (oVar != null) {
                oVar.onBindDataToView(this.f23126i);
            }
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void d(a.InterfaceC0202a interfaceC0202a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0202a) == null) {
            super.d(interfaceC0202a);
            o oVar = this.f23127j;
            if (oVar != null) {
                oVar.z(interfaceC0202a);
            }
            LinearLayout linearLayout = this.f23123f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            o oVar = this.f23127j;
            if (oVar != null) {
                oVar.k(this.f23099b);
            }
        }
    }
}
