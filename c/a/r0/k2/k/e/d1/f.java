package c.a.r0.k2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.o;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.b0.c0;
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
public class f extends c.a.r0.k2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20201f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f20202g;

    /* renamed from: h  reason: collision with root package name */
    public d2 f20203h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.q.a f20204i;

    /* renamed from: j  reason: collision with root package name */
    public o f20205j;

    /* loaded from: classes3.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f20206e;

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
            this.f20206e = fVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20206e.f20203h : (d2) invokeV.objValue;
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
        public final /* synthetic */ f f20207e;

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
            this.f20207e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            a.InterfaceC0093a interfaceC0093a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0093a = (fVar = this.f20207e).f20177c) == null) {
                return;
            }
            interfaceC0093a.a(fVar.f20204i);
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

    @Override // c.a.r0.k2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20201f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f20175a.getPageActivity());
                this.f20201f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f20201f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f20201f, R.color.CAM_X0206);
                this.f20201f.setOrientation(1);
                this.f20201f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f20201f.removeAllViews();
            if (this.f20205j == null) {
                o oVar = new o(this.f20175a.getPageActivity());
                this.f20205j = oVar;
                oVar.m(Boolean.TRUE);
                this.f20205j.w("pb");
                this.f20205j.y(0);
                this.f20205j.D(this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
                this.f20205j.E(false);
                this.f20205j.C(true);
            }
            this.f20201f.addView(this.f20205j.f());
            if (this.f20202g == null) {
                ItemCardView itemCardView = new ItemCardView(this.f20175a.getPageActivity());
                this.f20202g = itemCardView;
                itemCardView.setIsShowRightBtn(true);
            }
            this.f20202g.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f20201f.addView(this.f20202g, layoutParams);
            return this.f20201f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f20179e == i2) {
            return;
        }
        this.f20179e = i2;
        SkinManager.setBackgroundColor(this.f20201f, R.color.CAM_X0206);
        o oVar = this.f20205j;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f20202g;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20178d = originalThreadInfo;
            this.f20203h = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f20204i = new a(this);
            ItemCardView itemCardView = this.f20202g;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.C, 17, originalThreadInfo.f47437f);
            }
            o oVar = this.f20205j;
            if (oVar != null) {
                oVar.onBindDataToView(this.f20204i);
            }
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void d(a.InterfaceC0093a interfaceC0093a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0093a) == null) {
            super.d(interfaceC0093a);
            o oVar = this.f20205j;
            if (oVar != null) {
                oVar.z(interfaceC0093a);
            }
            LinearLayout linearLayout = this.f20201f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void e(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            super.e(c0Var);
            o oVar = this.f20205j;
            if (oVar != null) {
                oVar.k(this.f20176b);
            }
        }
    }
}
