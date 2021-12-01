package c.a.r0.q2.u.f.e1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.k.a;
import c.a.k.o;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.g0.d0;
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
/* loaded from: classes6.dex */
public class f extends c.a.r0.q2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21954f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f21955g;

    /* renamed from: h  reason: collision with root package name */
    public d2 f21956h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.q.a f21957i;

    /* renamed from: j  reason: collision with root package name */
    public o f21958j;

    /* loaded from: classes6.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f21959e;

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
            this.f21959e = fVar;
        }

        @Override // c.a.q0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.q0.s.q.a
        public d2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21959e.f21956h : (d2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f21960e;

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
            this.f21960e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0129a interfaceC0129a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0129a = (fVar = this.f21960e).f21931c) == null) {
                return;
            }
            interfaceC0129a.a(fVar.f21957i);
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

    @Override // c.a.r0.q2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f21954f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f21954f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f21954f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f21954f, c.a.r0.q2.f.CAM_X0206);
                this.f21954f.setOrientation(1);
                this.f21954f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f21954f.removeAllViews();
            if (this.f21958j == null) {
                o oVar = new o(this.a.getPageActivity());
                this.f21958j = oVar;
                oVar.m(Boolean.TRUE);
                this.f21958j.w("pb");
                this.f21958j.y(0);
                this.f21958j.D(this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007), this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X005), this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007), 0);
                this.f21958j.E(false);
                this.f21958j.C(true);
            }
            this.f21954f.addView(this.f21958j.f());
            if (this.f21955g == null) {
                ItemCardView itemCardView = new ItemCardView(this.a.getPageActivity());
                this.f21955g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f21955g.setBackGroundColor(c.a.r0.q2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X004);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            layoutParams.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X005);
            this.f21954f.addView(this.f21955g, layoutParams);
            return this.f21954f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f21933e == i2) {
            return;
        }
        this.f21933e = i2;
        SkinManager.setBackgroundColor(this.f21954f, c.a.r0.q2.f.CAM_X0206);
        o oVar = this.f21958j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f21955g;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f21932d = originalThreadInfo;
            this.f21956h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f21957i = new a(this);
            ItemCardView itemCardView = this.f21955g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.C, 17, originalThreadInfo.f40904f);
            }
            o oVar = this.f21958j;
            if (oVar != null) {
                oVar.onBindDataToView(this.f21957i);
            }
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void d(a.InterfaceC0129a interfaceC0129a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0129a) == null) {
            super.d(interfaceC0129a);
            o oVar = this.f21958j;
            if (oVar != null) {
                oVar.z(interfaceC0129a);
            }
            LinearLayout linearLayout = this.f21954f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            o oVar = this.f21958j;
            if (oVar != null) {
                oVar.k(this.f21930b);
            }
        }
    }
}
