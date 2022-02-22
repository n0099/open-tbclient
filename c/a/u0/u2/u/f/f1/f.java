package c.a.u0.u2.u.f.f1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.o;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.x0;
import c.a.u0.g0.b0;
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
/* loaded from: classes9.dex */
public class f extends c.a.u0.u2.u.f.f1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23621f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f23622g;

    /* renamed from: h  reason: collision with root package name */
    public e2 f23623h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.s.r.a f23624i;

    /* renamed from: j  reason: collision with root package name */
    public o f23625j;

    /* loaded from: classes9.dex */
    public class a extends c.a.t0.s.r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23626e;

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
            this.f23626e = fVar;
        }

        @Override // c.a.t0.s.r.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.t0.s.r.a
        public e2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23626e.f23623h : (e2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23627e;

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
            this.f23627e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0208a interfaceC0208a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0208a = (fVar = this.f23627e).f23598c) == null) {
                return;
            }
            interfaceC0208a.a(fVar.f23624i);
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

    @Override // c.a.u0.u2.u.f.f1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f23621f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f23621f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f23621f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f23621f, c.a.u0.u2.f.CAM_X0206);
                this.f23621f.setOrientation(1);
                this.f23621f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f23621f.removeAllViews();
            if (this.f23625j == null) {
                o oVar = new o(this.a.getPageActivity());
                this.f23625j = oVar;
                oVar.m(Boolean.TRUE);
                this.f23625j.w("pb");
                this.f23625j.y(0);
                this.f23625j.D(this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_W_X007), this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_H_X005), this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_W_X007), 0);
                this.f23625j.E(false);
                this.f23625j.C(true);
            }
            this.f23621f.addView(this.f23625j.f());
            if (this.f23622g == null) {
                ItemCardView itemCardView = new ItemCardView(this.a.getPageActivity());
                this.f23622g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f23622g.setBackGroundColor(c.a.u0.u2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_H_X004);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_W_X007);
            layoutParams.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_H_X005);
            this.f23621f.addView(this.f23622g, layoutParams);
            return this.f23621f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f23600e == i2) {
            return;
        }
        this.f23600e = i2;
        SkinManager.setBackgroundColor(this.f23621f, c.a.u0.u2.f.CAM_X0206);
        o oVar = this.f23625j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f23622g;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f23599d = originalThreadInfo;
            this.f23623h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f23624i = new a(this);
            ItemCardView itemCardView = this.f23622g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.D, 17, originalThreadInfo.f40389f);
            }
            o oVar = this.f23625j;
            if (oVar != null) {
                oVar.onBindDataToView(this.f23624i);
            }
        }
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public void d(a.InterfaceC0208a interfaceC0208a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0208a) == null) {
            super.d(interfaceC0208a);
            o oVar = this.f23625j;
            if (oVar != null) {
                oVar.z(interfaceC0208a);
            }
            LinearLayout linearLayout = this.f23621f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            o oVar = this.f23625j;
            if (oVar != null) {
                oVar.k(this.f23597b);
            }
        }
    }
}
