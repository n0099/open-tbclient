package com.baidu.tbadk.core.elementsMaven;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.x15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EMManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CARD_ALL = 0;
    public static final int CARD_BOTTOM = 2;
    public static final int CARD_TOP = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable backGroundDrawable;
    public View fromView;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ EMManager b;

        public a(EMManager eMManager, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eMManager, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eMManager;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EMManager eMManager = this.b;
                eMManager.backGroundDrawable = x15.F(eMManager.backGroundDrawable, this.a, this.b.fromView.getMeasuredHeight());
                this.b.fromView.setBackgroundDrawable(this.b.backGroundDrawable);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ EMManager c;

        public b(EMManager eMManager, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eMManager, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eMManager;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EMManager eMManager = this.c;
                eMManager.backGroundDrawable = x15.G(eMManager.backGroundDrawable, this.a, this.b, this.c.fromView.getMeasuredHeight());
                this.c.fromView.setBackgroundDrawable(this.c.backGroundDrawable);
            }
        }
    }

    public EMManager(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fromView = view2;
        this.backGroundDrawable = x15.e(view2);
    }

    public EMManager setTextLinePadding(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            View view2 = this.fromView;
            if (view2 instanceof EMTextView) {
                ((EMTextView) view2).setLineSpacing(x15.p(i), ((EMTextView) this.fromView).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setTextShadow(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            if (!(this.fromView instanceof TextView)) {
                return this;
            }
            float[] E = x15.E(i);
            ((TextView) this.fromView).setShadowLayer(E[1], E[2], E[3], (int) E[0]);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public static EMManager from(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            return new EMManager(view2);
        }
        return (EMManager) invokeL.objValue;
    }

    public EMManager setAlpha(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.fromView == null) {
                return this;
            }
            this.backGroundDrawable = x15.c(this.backGroundDrawable, i);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public void setBackGroundColor(int i) {
        Drawable k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.fromView == null || (k = x15.k(this.backGroundDrawable, i)) == null) {
            return;
        }
        this.backGroundDrawable = k;
        this.fromView.setBackgroundDrawable(k);
    }

    public void setBackGroundColorString(String str) {
        Drawable l;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || this.fromView == null || (l = x15.l(this.backGroundDrawable, str)) == null) {
            return;
        }
        this.backGroundDrawable = l;
        this.fromView.setBackgroundDrawable(l);
    }

    public void setBackGroundRealColor(int i) {
        Drawable z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.fromView == null || (z = x15.z(this.backGroundDrawable, i)) == null) {
            return;
        }
        this.backGroundDrawable = z;
        this.fromView.setBackgroundDrawable(z);
    }

    public void setBackGroundSelectorColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || (view2 = this.fromView) == null) {
            return;
        }
        view2.post(new a(this, i));
    }

    public EMManager setBorderAlpha(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.fromView == null) {
                return this;
            }
            Drawable f = x15.f(this.backGroundDrawable, i);
            if (f == null) {
                return this;
            }
            this.backGroundDrawable = f;
            this.fromView.setBackgroundDrawable(f);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setBorderColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.fromView == null) {
                return this;
            }
            Drawable g = x15.g(this.backGroundDrawable, i);
            if (g == null) {
                return this;
            }
            this.backGroundDrawable = g;
            this.fromView.setBackgroundDrawable(g);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setBorderWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.fromView == null) {
                return this;
            }
            this.backGroundDrawable = x15.h(this.backGroundDrawable, i);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setCardType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.fromView == null) {
                return this;
            }
            this.backGroundDrawable = x15.o(this.backGroundDrawable, i);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setCorner(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.fromView == null) {
                return this;
            }
            this.backGroundDrawable = x15.n(this.backGroundDrawable, i);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public void setGradientColor(int[] iArr) {
        Drawable s;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, iArr) != null) || this.fromView == null || (s = x15.s(this.backGroundDrawable, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.backGroundDrawable = s;
        this.fromView.setBackgroundDrawable(s);
    }

    public EMManager setLayerType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            View view2 = this.fromView;
            if (view2 == null) {
                return this;
            }
            view2.setLayerType(i, null);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setLinkTextColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            View view2 = this.fromView;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setLinkTextColor(x15.i(i));
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public void setMaskBackGround(int i) {
        Drawable w;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048592, this, i) != null) || this.fromView == null || (w = x15.w(this.backGroundDrawable, x15.I(i))) == null) {
            return;
        }
        this.backGroundDrawable = w;
        this.fromView.setBackgroundDrawable(w);
    }

    public EMManager setRealBorderColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.fromView == null) {
                return this;
            }
            Drawable y = x15.y(this.backGroundDrawable, i);
            if (y == null) {
                return this;
            }
            this.backGroundDrawable = y;
            this.fromView.setBackgroundDrawable(y);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setShadow(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            View view2 = this.fromView;
            if (view2 == null) {
                return this;
            }
            Drawable D = x15.D(view2, this.backGroundDrawable, x15.I(i));
            if (D == null) {
                return this;
            }
            this.backGroundDrawable = D;
            this.fromView.setBackgroundDrawable(D);
            setLayerType(1);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setTextColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            View view2 = this.fromView;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(x15.i(i));
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setTextColorStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            View view2 = this.fromView;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(x15.j(str));
            return this;
        }
        return (EMManager) invokeL.objValue;
    }

    public EMManager setTextSelectorColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            View view2 = this.fromView;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(x15.J(i));
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setTextSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            View view2 = this.fromView;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextSize(0, x15.p(i));
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setTextStyle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            View view2 = this.fromView;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTypeface(x15.L(x15.H(i)));
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public EMManager setVisibility(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            View view2 = this.fromView;
            if (view2 == null) {
                return this;
            }
            view2.setVisibility(i);
            return this;
        }
        return (EMManager) invokeI.objValue;
    }

    public void setBackGroundSelectorColor(int i, int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048581, this, i, i2) != null) || (view2 = this.fromView) == null) {
            return;
        }
        view2.post(new b(this, i, i2));
    }

    public void setGradientColor(int[] iArr, Direction direction) {
        Drawable s;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, iArr, direction) != null) || this.fromView == null || (s = x15.s(this.backGroundDrawable, direction, iArr)) == null) {
            return;
        }
        this.backGroundDrawable = s;
        this.fromView.setBackgroundDrawable(s);
    }

    public void setGradientColorValue(int[] iArr, Direction direction) {
        Drawable M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, iArr, direction) != null) || this.fromView == null || (M = x15.M(this.backGroundDrawable, direction, iArr)) == null) {
            return;
        }
        this.backGroundDrawable = M;
        this.fromView.setBackgroundDrawable(M);
    }

    public EMManager setTextSelectorColor(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i, i2)) == null) {
            View view2 = this.fromView;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(x15.K(i, i2));
            return this;
        }
        return (EMManager) invokeII.objValue;
    }

    public EMManager setTextSizeint(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            View view2 = this.fromView;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextSize(i, f);
            return this;
        }
        return (EMManager) invokeCommon.objValue;
    }
}
