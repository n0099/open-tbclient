package c.a.p0.i2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.o;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.x0;
import c.a.p0.a0.b0;
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
public class f extends c.a.p0.i2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19112f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f19113g;

    /* renamed from: h  reason: collision with root package name */
    public c2 f19114h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.o0.s.q.a f19115i;

    /* renamed from: j  reason: collision with root package name */
    public o f19116j;

    /* loaded from: classes3.dex */
    public class a extends c.a.o0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f19117e;

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
            this.f19117e = fVar;
        }

        @Override // c.a.o0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.o0.s.q.a
        public c2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19117e.f19114h : (c2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.k.e.n
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
        public final /* synthetic */ f f19118e;

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
            this.f19118e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0086a interfaceC0086a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0086a = (fVar = this.f19118e).f19088c) == null) {
                return;
            }
            interfaceC0086a.a(fVar.f19115i);
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

    @Override // c.a.p0.i2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19112f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19086a.getPageActivity());
                this.f19112f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f19112f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f19112f, R.color.CAM_X0206);
                this.f19112f.setOrientation(1);
                this.f19112f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f19112f.removeAllViews();
            if (this.f19116j == null) {
                o oVar = new o(this.f19086a.getPageActivity());
                this.f19116j = oVar;
                oVar.m(Boolean.TRUE);
                this.f19116j.w("pb");
                this.f19116j.y(0);
                this.f19116j.D(this.f19086a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f19086a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f19086a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
                this.f19116j.E(false);
                this.f19116j.C(true);
            }
            this.f19112f.addView(this.f19116j.f());
            if (this.f19113g == null) {
                ItemCardView itemCardView = new ItemCardView(this.f19086a.getPageActivity());
                this.f19113g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f19113g.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f19086a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f19086a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f19086a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.f19086a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f19112f.addView(this.f19113g, layoutParams);
            return this.f19112f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.p0.i2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19090e == i2) {
            return;
        }
        this.f19090e = i2;
        SkinManager.setBackgroundColor(this.f19112f, R.color.CAM_X0206);
        o oVar = this.f19116j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f19113g;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.p0.i2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19089d = originalThreadInfo;
            this.f19114h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f19115i = new a(this);
            ItemCardView itemCardView = this.f19113g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.B, 17, originalThreadInfo.f47200f);
            }
            o oVar = this.f19116j;
            if (oVar != null) {
                oVar.onBindDataToView(this.f19115i);
            }
        }
    }

    @Override // c.a.p0.i2.k.e.d1.a
    public void d(a.InterfaceC0086a interfaceC0086a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0086a) == null) {
            super.d(interfaceC0086a);
            o oVar = this.f19116j;
            if (oVar != null) {
                oVar.z(interfaceC0086a);
            }
            LinearLayout linearLayout = this.f19112f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.p0.i2.k.e.d1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            o oVar = this.f19116j;
            if (oVar != null) {
                oVar.k(this.f19087b);
            }
        }
    }
}
