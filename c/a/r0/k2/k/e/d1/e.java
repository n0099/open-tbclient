package c.a.r0.k2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
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
public class e extends c.a.r0.k2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20194f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f20195g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f20196h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f20197i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.q.a f20198j;

    /* loaded from: classes3.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20199e;

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
            this.f20199e = eVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20199e.f20197i : (d2) invokeV.objValue;
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
        public final /* synthetic */ e f20200e;

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
            this.f20200e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            a.InterfaceC0093a interfaceC0093a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0093a = (eVar = this.f20200e).f20177c) == null) {
                return;
            }
            interfaceC0093a.a(eVar.f20198j);
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

    @Override // c.a.r0.k2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20194f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f20175a.getPageActivity());
                this.f20194f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f20194f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f20194f, R.color.CAM_X0206);
                this.f20194f.setOrientation(1);
                this.f20194f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f20194f.removeAllViews();
            if (this.f20195g == null) {
                g0 g0Var = new g0(this.f20175a);
                this.f20195g = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f20194f.addView(this.f20195g.f(), layoutParams);
            if (this.f20196h == null) {
                this.f20196h = new ItemCardView(this.f20175a.getPageActivity());
            }
            this.f20196h.setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams2.leftMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams2.rightMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams2.bottomMargin = this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f20194f.addView(this.f20196h, layoutParams2);
            return this.f20194f;
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
        SkinManager.setBackgroundColor(this.f20194f, R.color.CAM_X0206);
        g0 g0Var = this.f20195g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f20196h;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20178d = originalThreadInfo;
            this.f20197i = originalThreadInfo == null ? null : originalThreadInfo.a();
            this.f20198j = new a(this);
            ItemCardView itemCardView = this.f20196h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.C, 17, originalThreadInfo.f47437f);
            }
            g0 g0Var = this.f20195g;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f20198j);
            }
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void d(a.InterfaceC0093a interfaceC0093a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0093a) == null) {
            super.d(interfaceC0093a);
            g0 g0Var = this.f20195g;
            if (g0Var != null) {
                g0Var.v(interfaceC0093a);
            }
            LinearLayout linearLayout = this.f20194f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }
}
