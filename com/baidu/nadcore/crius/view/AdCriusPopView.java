package com.baidu.nadcore.crius.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.crius.uiwidget.ApkDownloadView;
import com.baidu.nadcore.crius.uiwidget.NadCriusMiniVideoDownloadView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.an0;
import com.repackage.bj0;
import com.repackage.hj0;
import com.repackage.hy0;
import com.repackage.in0;
import com.repackage.oi0;
import com.repackage.p01;
import com.repackage.u51;
import com.repackage.um0;
import com.repackage.vh0;
import com.repackage.w51;
import com.repackage.wh0;
import com.repackage.xm0;
import java.util.Map;
/* loaded from: classes2.dex */
public class AdCriusPopView extends AdCriusBaseView<CriusData> implements View.OnClickListener, w51<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bj0 e;
    public Animation f;
    public Animation g;
    public u51 h;
    public boolean i;

    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCriusPopView a;

        public a(AdCriusPopView adCriusPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCriusPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCriusPopView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.setVisibility(8);
                this.a.g = null;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCriusPopView a;

        public b(AdCriusPopView adCriusPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCriusPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCriusPopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-924028396, "Lcom/baidu/nadcore/crius/view/AdCriusPopView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-924028396, "Lcom/baidu/nadcore/crius/view/AdCriusPopView;");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdCriusPopView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.w51
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Animation animation = this.f;
            if (animation != null) {
                animation.cancel();
                this.f = null;
            }
            Animation animation2 = this.g;
            if (animation2 != null) {
                animation2.cancel();
                this.g = null;
            }
        }
    }

    @Override // com.repackage.w51
    public void b(String str, boolean z) {
        xm0 xm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            this.i = false;
            this.f = null;
            if (!z || this.g == null) {
                u51 u51Var = this.h;
                if (u51Var != null) {
                    u51Var.a(z, 480L);
                }
                if (z) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f0100ab);
                    this.g = loadAnimation;
                    loadAnimation.setDuration(480L);
                    this.g.setAnimationListener(new a(this));
                    startAnimation(this.g);
                } else {
                    setVisibility(8);
                }
                if ((getTag() instanceof an0) && (xm0Var = ((an0) getTag()).e) != null) {
                    xm0Var.a();
                    xm0Var.c = ClogBuilder.LogType.NAVIDEO_POP_CLOSE.type;
                    xm0Var.g = str;
                    p(xm0Var);
                }
            }
        }
    }

    @Override // com.repackage.w51
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || getVisibility() == 0) {
            return;
        }
        if (z) {
            q();
            return;
        }
        setVisibility(0);
        u51 u51Var = this.h;
        if (u51Var != null) {
            u51Var.c();
        }
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.id.obfuscated_res_0x7f0915ae : invokeV.intValue;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public void e(CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, criusData) == null) {
            View viewByComponent = this.d.getViewByComponent(NativeConstants.COMPONENT_CLOSEAD);
            if (viewByComponent instanceof ImageView) {
                ImageView imageView = (ImageView) viewByComponent;
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080dd0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setOnClickListener(this);
            }
            View viewByComponent2 = this.d.getViewByComponent("download");
            if (viewByComponent2 instanceof ApkDownloadView) {
                wh0 realDownloadView = ((ApkDownloadView) viewByComponent2).getRealDownloadView();
                if ((realDownloadView instanceof hj0) && (getTag() instanceof an0)) {
                    n((an0) getTag(), (hj0) realDownloadView);
                    return;
                } else {
                    this.e = null;
                    return;
                }
            }
            this.e = null;
        }
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public void f(View view2, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, view2, str, map) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0915a8) {
                b("1", true);
            } else {
                o(str, map);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.w51
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.layout.obfuscated_res_0x7f0d05cc : invokeV.intValue;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.id.obfuscated_res_0x7f0915af : invokeV.intValue;
    }

    public final void n(@NonNull an0 an0Var, hj0 hj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, an0Var, hj0Var) == null) {
            um0 um0Var = an0Var.d;
            xm0 xm0Var = an0Var.e;
            if (um0Var == null || xm0Var == null) {
                return;
            }
            an0Var.a = 2;
            this.e = new bj0(oi0.d(um0Var, xm0Var.d, ""), hj0Var);
            if (hj0Var instanceof NadCriusMiniVideoDownloadView) {
                NadCriusMiniVideoDownloadView nadCriusMiniVideoDownloadView = (NadCriusMiniVideoDownloadView) hj0Var;
                int a2 = p01.c.a(getContext(), 12.0f);
                nadCriusMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(a2, a2));
                nadCriusMiniVideoDownloadView.setVisibility(0);
                nadCriusMiniVideoDownloadView.setOnClickListener(new b(this));
            }
        }
    }

    public final void o(String str, Map<String, String> map) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, map) == null) {
            if (map != null && !TextUtils.isEmpty(map.get(NativeConstants.URL_STAT))) {
                map.get(NativeConstants.URL_STAT);
            }
            if (map != null && !TextUtils.isEmpty(map.get(NativeConstants.ALS_STAT))) {
                str2 = map.get(NativeConstants.ALS_STAT);
            } else {
                str2 = ClogBuilder.Area.HOTAREA.type;
            }
            if (this.h != null) {
                in0 in0Var = new in0();
                in0Var.a = str;
                in0Var.b = str2;
                in0Var.c = true;
                if (map != null) {
                    TextUtils.equals("1", map.get(NativeConstants.CHARGE_TYPE));
                }
                this.h.b(in0Var);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f0915a8) {
            b("1", true);
        }
    }

    public final void p(xm0 xm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xm0Var) == null) {
            hy0.b(new ClogBuilder().z(xm0Var.c).v(xm0Var.a).j(xm0Var.b).p(xm0Var.d).k(xm0Var.e).l(xm0Var.f).m(xm0Var.g));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f0100aa);
            this.f = loadAnimation;
            loadAnimation.setDuration(480L);
            setVisibility(0);
            startAnimation(this.f);
            u51 u51Var = this.h;
            if (u51Var != null) {
                u51Var.c();
            }
            this.i = true;
        }
    }

    @Override // com.repackage.w51
    public void setContainer(@Nullable ViewGroup viewGroup, @Nullable ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, viewGroup, layoutParams) == null) || viewGroup == null) {
            return;
        }
        View view2 = (View) getParent();
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).removeView(this);
        }
        if (layoutParams != null) {
            viewGroup.addView(this, layoutParams);
        } else {
            viewGroup.addView(this);
        }
        setVisibility(8);
    }

    @Override // com.repackage.w51
    public void setCriusPopListener(@NonNull u51 u51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, u51Var) == null) {
            this.h = u51Var;
        }
    }

    @Override // com.repackage.w51
    public void setData(@NonNull an0 an0Var) {
        CriusData criusData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, an0Var) == null) {
            setTag(an0Var);
            Object obj = an0Var.c;
            if (obj instanceof vh0) {
                Map<String, vh0.a> map = ((vh0) obj).b;
                if (map == null) {
                    setVisibility(8);
                    return;
                }
                vh0.a aVar = map.get("crius_pop");
                if (aVar != null && (criusData = aVar.a) != null) {
                    k(criusData, false);
                    a();
                    return;
                }
                setVisibility(8);
            }
        }
    }

    public void update(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || !(getTag() instanceof an0) || (i2 = ((an0) getTag()).b) < 0 || this.i || i < i2) {
            return;
        }
        q();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdCriusPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCriusPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.d.setIgnoreImageNightMode(true);
    }
}
