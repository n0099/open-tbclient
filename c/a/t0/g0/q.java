package c.a.t0.g0;

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
/* loaded from: classes7.dex */
public final class q implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f17674e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f17675f;

    /* renamed from: g  reason: collision with root package name */
    public View f17676g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f17677h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f17678i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f17679j;
    public TextView k;
    public ImageView l;

    public q(Context context) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.f17674e = 3;
        this.f17675f = context;
        c();
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageView imageView = this.l;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestClose");
                return null;
            }
            return imageView;
        }
        return (View) invokeV.objValue;
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.f17676g;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                return null;
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = null;
            View inflate = LayoutInflater.from(this.f17675f).inflate(R.layout.card_interest_view, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext).inflate(R…card_interest_view, null)");
            this.f17676g = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                inflate = null;
            }
            View findViewById = inflate.findViewById(R.id.card_interest_root);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.card_interest_root)");
            this.f17677h = (RelativeLayout) findViewById;
            View view = this.f17676g;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view = null;
            }
            View findViewById2 = view.findViewById(R.id.card_interest_insind);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mView.findViewById(R.id.card_interest_insind)");
            this.f17678i = (RelativeLayout) findViewById2;
            View view2 = this.f17676g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view2 = null;
            }
            View findViewById3 = view2.findViewById(R.id.card_interest_add);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mView.findViewById(R.id.card_interest_add)");
            this.f17679j = (ImageView) findViewById3;
            View view3 = this.f17676g;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view3 = null;
            }
            View findViewById4 = view3.findViewById(R.id.card_interest_content);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mView.findViewById(R.id.card_interest_content)");
            this.k = (TextView) findViewById4;
            View view4 = this.f17676g;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view4 = null;
            }
            View findViewById5 = view4.findViewById(R.id.card_interest_close);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "mView.findViewById(R.id.card_interest_close)");
            this.l = (ImageView) findViewById5;
            RelativeLayout relativeLayout2 = this.f17678i;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestInsind");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setOnClickListener(this);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f17674e == i2) {
            return;
        }
        RelativeLayout relativeLayout = this.f17677h;
        ImageView imageView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInterestRoot");
            relativeLayout = null;
        }
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(relativeLayout);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        ImageView imageView2 = this.f17679j;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInterestAdd");
            imageView2 = null;
        }
        WebPManager.setPureDrawable(imageView2, R.drawable.icon_card_interest_add, R.color.CAM_X0304, null);
        TextView textView = this.k;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInterestContent");
            textView = null;
        }
        c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(textView);
        d3.v(R.color.CAM_X0304);
        d3.z(R.dimen.T_X08);
        ImageView imageView3 = this.l;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardInterestClose");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (v.getId() == R.id.card_interest_insind) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this.f17675f, 5)));
                c.a.t0.p1.h.n.b.a(1);
            }
        }
    }
}
