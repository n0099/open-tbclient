package c.a.r0.j2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.o;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.a0.b0;
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
public class f extends c.a.r0.j2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20009f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f20010g;

    /* renamed from: h  reason: collision with root package name */
    public d2 f20011h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.q.a f20012i;

    /* renamed from: j  reason: collision with root package name */
    public o f20013j;

    /* loaded from: classes3.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f20014e;

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
            this.f20014e = fVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20014e.f20011h : (d2) invokeV.objValue;
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
        public final /* synthetic */ f f20015e;

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
            this.f20015e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0093a interfaceC0093a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0093a = (fVar = this.f20015e).f19985c) == null) {
                return;
            }
            interfaceC0093a.a(fVar.f20012i);
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

    @Override // c.a.r0.j2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20009f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19983a.getPageActivity());
                this.f20009f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f20009f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f20009f, R.color.CAM_X0206);
                this.f20009f.setOrientation(1);
                this.f20009f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f20009f.removeAllViews();
            if (this.f20013j == null) {
                o oVar = new o(this.f19983a.getPageActivity());
                this.f20013j = oVar;
                oVar.m(Boolean.TRUE);
                this.f20013j.w("pb");
                this.f20013j.y(0);
                this.f20013j.D(this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
                this.f20013j.E(false);
                this.f20013j.C(true);
            }
            this.f20009f.addView(this.f20013j.f());
            if (this.f20010g == null) {
                ItemCardView itemCardView = new ItemCardView(this.f19983a.getPageActivity());
                this.f20010g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f20010g.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f20009f.addView(this.f20010g, layoutParams);
            return this.f20009f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.j2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19987e == i2) {
            return;
        }
        this.f19987e = i2;
        SkinManager.setBackgroundColor(this.f20009f, R.color.CAM_X0206);
        o oVar = this.f20013j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f20010g;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.r0.j2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19986d = originalThreadInfo;
            this.f20011h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f20012i = new a(this);
            ItemCardView itemCardView = this.f20010g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.B, 17, originalThreadInfo.f47422f);
            }
            o oVar = this.f20013j;
            if (oVar != null) {
                oVar.onBindDataToView(this.f20012i);
            }
        }
    }

    @Override // c.a.r0.j2.k.e.d1.a
    public void d(a.InterfaceC0093a interfaceC0093a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0093a) == null) {
            super.d(interfaceC0093a);
            o oVar = this.f20013j;
            if (oVar != null) {
                oVar.z(interfaceC0093a);
            }
            LinearLayout linearLayout = this.f20009f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.r0.j2.k.e.d1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            o oVar = this.f20013j;
            if (oVar != null) {
                oVar.k(this.f19984b);
            }
        }
    }
}
