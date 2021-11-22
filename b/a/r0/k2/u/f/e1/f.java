package b.a.r0.k2.u.f.e1;

import android.view.View;
import android.widget.LinearLayout;
import b.a.l.a;
import b.a.l.o;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.b0.d0;
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
/* loaded from: classes5.dex */
public class f extends b.a.r0.k2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20768f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f20769g;

    /* renamed from: h  reason: collision with root package name */
    public d2 f20770h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.s.q.a f20771i;
    public o j;

    /* loaded from: classes5.dex */
    public class a extends b.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f20772e;

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
            this.f20772e = fVar;
        }

        @Override // b.a.q0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // b.a.q0.s.q.a
        public d2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20772e.f20770h : (d2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.m.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f20773e;

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
            this.f20773e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0090a interfaceC0090a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0090a = (fVar = this.f20773e).f20746c) == null) {
                return;
            }
            interfaceC0090a.a(fVar.f20771i);
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

    @Override // b.a.r0.k2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20768f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f20744a.getPageActivity());
                this.f20768f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f20768f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f20768f, b.a.r0.k2.f.CAM_X0206);
                this.f20768f.setOrientation(1);
                this.f20768f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f20768f.removeAllViews();
            if (this.j == null) {
                o oVar = new o(this.f20744a.getPageActivity());
                this.j = oVar;
                oVar.m(Boolean.TRUE);
                this.j.w("pb");
                this.j.y(0);
                this.j.D(this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007), this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005), this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007), 0);
                this.j.E(false);
                this.j.C(true);
            }
            this.f20768f.addView(this.j.f());
            if (this.f20769g == null) {
                ItemCardView itemCardView = new ItemCardView(this.f20744a.getPageActivity());
                this.f20769g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f20769g.setBackGroundColor(b.a.r0.k2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X004);
            layoutParams.leftMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams.rightMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams.bottomMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            this.f20768f.addView(this.f20769g, layoutParams);
            return this.f20768f;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f20748e == i2) {
            return;
        }
        this.f20748e = i2;
        SkinManager.setBackgroundColor(this.f20768f, b.a.r0.k2.f.CAM_X0206);
        o oVar = this.j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f20769g;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20747d = originalThreadInfo;
            this.f20770h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f20771i = new a(this);
            ItemCardView itemCardView = this.f20769g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.C, 17, originalThreadInfo.f45889f);
            }
            o oVar = this.j;
            if (oVar != null) {
                oVar.onBindDataToView(this.f20771i);
            }
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void d(a.InterfaceC0090a interfaceC0090a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0090a) == null) {
            super.d(interfaceC0090a);
            o oVar = this.j;
            if (oVar != null) {
                oVar.z(interfaceC0090a);
            }
            LinearLayout linearLayout = this.f20768f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            o oVar = this.j;
            if (oVar != null) {
                oVar.k(this.f20745b);
            }
        }
    }
}
