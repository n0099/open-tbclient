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
import com.baidu.tieba.el0;
import com.baidu.tieba.kp0;
import com.baidu.tieba.lk0;
import com.baidu.tieba.m31;
import com.baidu.tieba.np0;
import com.baidu.tieba.qp0;
import com.baidu.tieba.tj0;
import com.baidu.tieba.u81;
import com.baidu.tieba.uj0;
import com.baidu.tieba.w81;
import com.baidu.tieba.yk0;
import com.baidu.tieba.yp0;
import com.baidu.tieba.z01;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class AdCriusPopView extends AdCriusBaseView<CriusData> implements View.OnClickListener, w81<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yk0 e;
    public Animation f;
    public Animation g;
    public u81 h;
    public boolean i;

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.id.obfuscated_res_0x7f09160a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.w81
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.layout.obfuscated_res_0x7f0d05f5 : invokeV.intValue;
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.id.obfuscated_res_0x7f09160b : invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCriusPopView a;

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

    @Override // com.baidu.tieba.w81
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

    public final void p(np0 np0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, np0Var) == null) {
            z01.b(new ClogBuilder().z(np0Var.c).v(np0Var.a).j(np0Var.b).p(np0Var.d).k(np0Var.e).l(np0Var.f).m(np0Var.g));
        }
    }

    @Override // com.baidu.tieba.w81
    public void setData(@NonNull qp0 qp0Var) {
        CriusData criusData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, qp0Var) == null) {
            setTag(qp0Var);
            Object obj = qp0Var.c;
            if (!(obj instanceof tj0)) {
                return;
            }
            Map<String, tj0.a> map = ((tj0) obj).b;
            if (map == null) {
                setVisibility(8);
                return;
            }
            tj0.a aVar = map.get("crius_pop");
            if (aVar != null && (criusData = aVar.a) != null) {
                k(criusData, false);
                a();
                return;
            }
            setVisibility(8);
        }
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

    public final void n(@NonNull qp0 qp0Var, el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, qp0Var, el0Var) == null) {
            kp0 kp0Var = qp0Var.d;
            np0 np0Var = qp0Var.e;
            if (kp0Var != null && np0Var != null) {
                qp0Var.a = 2;
                this.e = new yk0(lk0.d(kp0Var, np0Var.d, ""), el0Var);
                if (el0Var instanceof NadCriusMiniVideoDownloadView) {
                    NadCriusMiniVideoDownloadView nadCriusMiniVideoDownloadView = (NadCriusMiniVideoDownloadView) el0Var;
                    int a2 = m31.c.a(getContext(), 12.0f);
                    nadCriusMiniVideoDownloadView.setImageViewLayout(new FrameLayout.LayoutParams(a2, a2));
                    nadCriusMiniVideoDownloadView.setVisibility(0);
                    nadCriusMiniVideoDownloadView.setOnClickListener(new b(this));
                }
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

    @Override // com.baidu.tieba.w81
    public void setContainer(@Nullable ViewGroup viewGroup, @Nullable ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, viewGroup, layoutParams) != null) || viewGroup == null) {
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

    @Override // com.baidu.tieba.w81
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || getVisibility() == 0) {
            return;
        }
        if (z) {
            q();
            return;
        }
        setVisibility(0);
        u81 u81Var = this.h;
        if (u81Var != null) {
            u81Var.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091604) {
            b("1", true);
        }
    }

    @Override // com.baidu.tieba.w81
    public void setCriusPopListener(@NonNull u81 u81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, u81Var) == null) {
            this.h = u81Var;
        }
    }

    public void update(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (getTag() instanceof qp0) && (i2 = ((qp0) getTag()).b) >= 0 && !this.i && i >= i2) {
            q();
        }
    }

    @Override // com.baidu.tieba.w81
    public void b(String str, boolean z) {
        np0 np0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            this.i = false;
            this.f = null;
            if (z && this.g != null) {
                return;
            }
            u81 u81Var = this.h;
            if (u81Var != null) {
                u81Var.a(z, 480L);
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
            if (!(getTag() instanceof qp0) || (np0Var = ((qp0) getTag()).e) == null) {
                return;
            }
            np0Var.a();
            np0Var.c = ClogBuilder.LogType.NAVIDEO_POP_CLOSE.type;
            np0Var.g = str;
            p(np0Var);
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
                yp0 yp0Var = new yp0();
                yp0Var.a = str;
                yp0Var.b = str2;
                yp0Var.c = true;
                if (map != null) {
                    TextUtils.equals("1", map.get(NativeConstants.CHARGE_TYPE));
                }
                this.h.b(yp0Var);
            }
        }
    }

    @Override // com.baidu.nadcore.crius.view.AdCriusBaseView
    public void e(CriusData criusData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, criusData) == null) {
            View viewByComponent = this.d.getViewByComponent(NativeConstants.COMPONENT_CLOSEAD);
            if (viewByComponent instanceof ImageView) {
                ImageView imageView = (ImageView) viewByComponent;
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080e1e);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setOnClickListener(this);
            }
            View viewByComponent2 = this.d.getViewByComponent("download");
            if (viewByComponent2 instanceof ApkDownloadView) {
                uj0 realDownloadView = ((ApkDownloadView) viewByComponent2).getRealDownloadView();
                if ((realDownloadView instanceof el0) && (getTag() instanceof qp0)) {
                    n((qp0) getTag(), (el0) realDownloadView);
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
            if (view2.getId() == R.id.obfuscated_res_0x7f091604) {
                b("1", true);
            } else {
                o(str, map);
            }
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
            u81 u81Var = this.h;
            if (u81Var != null) {
                u81Var.c();
            }
            this.i = true;
        }
    }
}
