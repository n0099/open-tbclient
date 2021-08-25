package c.a.q0.i2.k.e.b1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.o;
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
public class f extends c.a.q0.i2.k.e.b1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19299f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f19300g;

    /* renamed from: h  reason: collision with root package name */
    public c2 f19301h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.s.q.a f19302i;

    /* renamed from: j  reason: collision with root package name */
    public o f19303j;

    /* loaded from: classes3.dex */
    public class a extends c.a.p0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f19304e;

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
            this.f19304e = fVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19304e.f19301h : (c2) invokeV.objValue;
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
        public final /* synthetic */ f f19305e;

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
            this.f19305e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0094a interfaceC0094a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0094a = (fVar = this.f19305e).f19275c) == null) {
                return;
            }
            interfaceC0094a.a(fVar.f19302i);
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

    @Override // c.a.q0.i2.k.e.b1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19299f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19273a.getPageActivity());
                this.f19299f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f19299f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f19299f, R.color.CAM_X0206);
                this.f19299f.setOrientation(1);
                this.f19299f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f19299f.removeAllViews();
            if (this.f19303j == null) {
                o oVar = new o(this.f19273a.getPageActivity());
                this.f19303j = oVar;
                oVar.m(Boolean.TRUE);
                this.f19303j.w("pb");
                this.f19303j.y(0);
                this.f19303j.D(this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
                this.f19303j.E(false);
                this.f19303j.C(true);
            }
            this.f19299f.addView(this.f19303j.f());
            if (this.f19300g == null) {
                ItemCardView itemCardView = new ItemCardView(this.f19273a.getPageActivity());
                this.f19300g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f19300g.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f19299f.addView(this.f19300g, layoutParams);
            return this.f19299f;
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
        SkinManager.setBackgroundColor(this.f19299f, R.color.CAM_X0206);
        o oVar = this.f19303j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f19300g;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19276d = originalThreadInfo;
            this.f19301h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f19302i = new a(this);
            ItemCardView itemCardView = this.f19300g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.B, 17, originalThreadInfo.f47306f);
            }
            o oVar = this.f19303j;
            if (oVar != null) {
                oVar.onBindDataToView(this.f19302i);
            }
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void d(a.InterfaceC0094a interfaceC0094a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0094a) == null) {
            super.d(interfaceC0094a);
            o oVar = this.f19303j;
            if (oVar != null) {
                oVar.z(interfaceC0094a);
            }
            LinearLayout linearLayout = this.f19299f;
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
            o oVar = this.f19303j;
            if (oVar != null) {
                oVar.k(this.f19274b);
            }
        }
    }
}
