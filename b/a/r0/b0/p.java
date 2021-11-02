package b.a.r0.b0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class p implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f14833e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f14834f;

    /* renamed from: g  reason: collision with root package name */
    public View f14835g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f14836h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f14837i;
    public ImageView j;
    public TextView k;
    public ImageView l;

    public p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14833e = 3;
        this.f14834f = context;
        c();
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageView imageView = this.l;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestClose");
            }
            return imageView;
        }
        return (View) invokeV.objValue;
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.f14835g;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f14834f).inflate(R.layout.card_interest_view, (ViewGroup) null);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(mCon…card_interest_view, null)");
            this.f14835g = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            View findViewById = inflate.findViewById(R.id.card_interest_root);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mView.findViewById(R.id.card_interest_root)");
            this.f14836h = (RelativeLayout) findViewById;
            View view = this.f14835g;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            View findViewById2 = view.findViewById(R.id.card_interest_insind);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mView.findViewById(R.id.card_interest_insind)");
            this.f14837i = (RelativeLayout) findViewById2;
            View view2 = this.f14835g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            View findViewById3 = view2.findViewById(R.id.card_interest_add);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "mView.findViewById(R.id.card_interest_add)");
            this.j = (ImageView) findViewById3;
            View view3 = this.f14835g;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            View findViewById4 = view3.findViewById(R.id.card_interest_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "mView.findViewById(R.id.card_interest_content)");
            this.k = (TextView) findViewById4;
            View view4 = this.f14835g;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            View findViewById5 = view4.findViewById(R.id.card_interest_close);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "mView.findViewById(R.id.card_interest_close)");
            this.l = (ImageView) findViewById5;
            RelativeLayout relativeLayout = this.f14837i;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestInsind");
            }
            relativeLayout.setOnClickListener(this);
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
            d(inst.getSkinType());
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f14833e == i2) {
            return;
        }
        RelativeLayout relativeLayout = this.f14836h;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInterestRoot");
        }
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(relativeLayout);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        ImageView imageView = this.j;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInterestAdd");
        }
        WebPManager.setPureDrawable(imageView, R.drawable.icon_card_interest_add, R.color.CAM_X0304, null);
        TextView textView = this.k;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInterestContent");
        }
        b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(textView);
        d3.v(R.color.CAM_X0304);
        d3.z(R.dimen.T_X08);
        ImageView imageView2 = this.l;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInterestClose");
        }
        imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view.getId() == R.id.card_interest_insind) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this.f14834f, 5)));
            b.a.r0.h1.h.n.a.a(1);
        }
    }
}
