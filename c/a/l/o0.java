package c.a.l;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class o0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout l;
    public BjhArticleLayout m;
    public c.a.p0.s.q.a n;
    public int o;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o0 f3861e;

        public a(o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3861e = o0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o0 o0Var;
            a.InterfaceC0094a interfaceC0094a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0094a = (o0Var = this.f3861e).f3792i) == null) {
                return;
            }
            interfaceC0094a.a(o0Var.n);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 3;
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.l == null) {
                LinearLayout linearLayout = new LinearLayout(this.f3789f);
                this.l = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.l.setOrientation(1);
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.l.removeAllViews();
            if (this.m == null) {
                BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(this.f3789f);
                this.m = bjhArticleLayout;
                bjhArticleLayout.setJumpToPbListener(new a(this));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.f3789f.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f3789f.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f3789f.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.f3789f.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
            this.l.addView(this.m, layoutParams);
            return this.l;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void k(c.a.q0.a0.b0<c.a.p0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b0Var) == null) {
            super.k(b0Var);
            BjhArticleLayout bjhArticleLayout = this.m;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.setSubClickListener(b0Var);
            }
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || i2 == this.o) {
            return;
        }
        this.o = i2;
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
        BjhArticleLayout bjhArticleLayout = this.m;
        if (bjhArticleLayout != null) {
            bjhArticleLayout.onChangeSkinType(tbPageContext, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: s */
    public void onBindDataToView(c.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.n = aVar;
            BjhArticleLayout bjhArticleLayout = this.m;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.onBindDataToView(aVar);
            }
        }
    }

    public void t(a.InterfaceC0094a interfaceC0094a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0094a) == null) {
            this.f3792i = interfaceC0094a;
        }
    }
}
