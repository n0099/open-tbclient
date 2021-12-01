package c.a.b0.h0.b0;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.d0.f;
import c.a.b0.h0.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public float f1652b;

    /* renamed from: c  reason: collision with root package name */
    public float f1653c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1654d;

    /* renamed from: e  reason: collision with root package name */
    public BubblePosition f1655e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1656f;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1105726865, "Lc/a/b0/h0/b0/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1105726865, "Lc/a/b0/h0/b0/b$a;");
                    return;
                }
            }
            int[] iArr = new int[BubblePosition.values().length];
            a = iArr;
            try {
                iArr[BubblePosition.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BubblePosition.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BubblePosition.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BubblePosition.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f1652b = 0.0f;
        this.f1654d = true;
        this.f1655e = BubblePosition.INVALID;
        this.f1656f = true;
    }

    public int[] a(c.a.b0.h0.b0.e.a aVar, int[] iArr, BubblePosition bubblePosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, iArr, bubblePosition)) == null) {
            if (aVar == null) {
                return new int[]{0, 0};
            }
            if (bubblePosition == BubblePosition.INVALID) {
                return iArr;
            }
            Context context = aVar.a.getContext();
            int i2 = iArr[0];
            int i3 = iArr[1];
            int[] iArr2 = new int[2];
            int measuredWidth = aVar.f1675b.getMeasuredWidth();
            int measuredHeight = aVar.f1675b.getMeasuredHeight();
            int measuredWidth2 = aVar.a.getMeasuredWidth();
            int measuredHeight2 = aVar.a.getMeasuredHeight();
            float f2 = this.f1656f ? 0.0f : 15.0f;
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    int i4 = measuredHeight / 2;
                    if (i4 >= i3) {
                        iArr2[1] = f.c.a(context, f2);
                    } else if (i4 >= measuredHeight2 - i3) {
                        iArr2[1] = (measuredHeight2 - measuredHeight) - f.c.a(context, f2);
                    } else {
                        iArr2[1] = iArr[1] - (aVar.f1675b.getMeasuredHeight() / 2);
                    }
                    if (bubblePosition == BubblePosition.LEFT) {
                        iArr2[0] = iArr[0] - aVar.f1675b.getMeasuredWidth();
                    } else {
                        iArr2[0] = iArr[0];
                    }
                }
            } else {
                int i5 = measuredWidth / 2;
                if (i5 >= i2) {
                    iArr2[0] = f.c.a(context, f2);
                } else if (i5 >= measuredWidth2 - i2) {
                    iArr2[0] = (measuredWidth2 - measuredWidth) - f.c.a(context, f2);
                } else {
                    iArr2[0] = iArr[0] - (aVar.f1675b.getMeasuredWidth() / 2);
                }
                if (bubblePosition == BubblePosition.UP) {
                    iArr2[1] = iArr[1] - aVar.f1675b.getMeasuredHeight();
                } else {
                    iArr2[1] = iArr[1];
                }
            }
            return iArr2;
        }
        return (int[]) invokeLLL.objValue;
    }

    public BubblePosition b(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (!aVar.i()) {
                return BubblePosition.INVALID;
            }
            if (this.f1654d) {
                if (n(aVar)) {
                    return BubblePosition.UP;
                }
                if (j(aVar)) {
                    return BubblePosition.DOWN;
                }
                if (k(aVar)) {
                    return BubblePosition.LEFT;
                }
                if (m(aVar)) {
                    return BubblePosition.RIGHT;
                }
                return BubblePosition.INVALID;
            } else if (l(aVar, this.f1655e)) {
                return this.f1655e;
            } else {
                return BubblePosition.INVALID;
            }
        }
        return (BubblePosition) invokeL.objValue;
    }

    public final int c(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? (aVar.a.getMeasuredHeight() - g(aVar)[1]) - (aVar.f1676c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int d(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? g(aVar)[0] + (aVar.f1676c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public int e(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) ? (aVar.a.getMeasuredWidth() - g(aVar)[0]) - (aVar.f1676c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public final int f(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) ? g(aVar)[1] + (aVar.f1676c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int[] g(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            int[] iArr = new int[2];
            aVar.f1676c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            aVar.a.getLocationOnScreen(iArr2);
            return new int[]{iArr[0] - iArr2[0], iArr[1] - iArr2[1]};
        }
        return (int[]) invokeL.objValue;
    }

    public final int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (this.f1656f) {
                return context.getResources().getDimensionPixelSize(p.nad_bubble_radius_d20);
            }
            return context.getResources().getDimensionPixelSize(p.nad_bubble_radius);
        }
        return invokeL.intValue;
    }

    public int[] i(BubblePosition bubblePosition, c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bubblePosition, aVar)) == null) {
            if (bubblePosition == null || aVar == null) {
                return new int[]{0, 0};
            }
            int[] iArr = new int[2];
            aVar.f1676c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            aVar.a.getLocationOnScreen(iArr2);
            int[] iArr3 = new int[2];
            if (bubblePosition == BubblePosition.UP) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (aVar.f1676c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) - f.c.a(aVar.f1676c.getContext(), this.f1652b);
            } else if (bubblePosition == BubblePosition.DOWN) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (aVar.f1676c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) + aVar.f1676c.getMeasuredHeight() + f.c.a(aVar.f1676c.getContext(), this.f1652b);
            } else if (bubblePosition == BubblePosition.LEFT) {
                iArr3[0] = ((iArr[0] - iArr2[0]) - (aVar.f1682i.getMeasuredWidth() / 2)) - f.c.a(aVar.f1676c.getContext(), this.f1652b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (aVar.f1676c.getMeasuredHeight() / 2);
            } else if (bubblePosition == BubblePosition.RIGHT) {
                iArr3[0] = (iArr[0] - iArr2[0]) + aVar.f1676c.getMeasuredWidth() + f.c.a(aVar.f1676c.getContext(), this.f1652b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (aVar.f1676c.getMeasuredHeight() / 2);
            }
            int[] a2 = a(aVar, iArr3, bubblePosition);
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    aVar.f1680g.setY(((iArr3[1] - a2[1]) - Math.max(aVar.f1683j.getMeasuredHeight() / 2, aVar.f1684k.getMeasuredHeight() / 2)) + this.f1653c);
                }
            } else {
                aVar.f1680g.setX(((iArr3[0] - a2[0]) - Math.max(aVar.f1682i.getMeasuredWidth() / 2, aVar.f1681h.getMeasuredWidth() / 2)) + this.f1653c);
            }
            return a2;
        }
        return (int[]) invokeLL.objValue;
    }

    public final boolean j(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aVar)) == null) ? aVar.f1675b.getMeasuredHeight() + f.c.a(aVar.f1676c.getContext(), this.f1652b) <= (aVar.a.getMeasuredHeight() - aVar.f1676c.getMeasuredHeight()) - g(aVar)[1] && p(aVar) : invokeL.booleanValue;
    }

    public final boolean k(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) ? aVar.f1675b.getMeasuredWidth() + f.c.a(aVar.f1676c.getContext(), this.f1652b) <= g(aVar)[0] && o(aVar) : invokeL.booleanValue;
    }

    public final boolean l(c.a.b0.h0.b0.e.a aVar, BubblePosition bubblePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, aVar, bubblePosition)) == null) {
            int i2 = a.a[bubblePosition.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return false;
                        }
                        return m(aVar);
                    }
                    return k(aVar);
                }
                return j(aVar);
            }
            return n(aVar);
        }
        return invokeLL.booleanValue;
    }

    public final boolean m(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, aVar)) == null) ? aVar.f1675b.getMeasuredWidth() + f.c.a(aVar.f1676c.getContext(), this.f1652b) <= (aVar.a.getMeasuredWidth() - aVar.f1676c.getMeasuredWidth()) - g(aVar)[0] && o(aVar) : invokeL.booleanValue;
    }

    public final boolean n(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aVar)) == null) ? aVar.f1675b.getMeasuredHeight() + f.c.a(aVar.f1676c.getContext(), this.f1652b) <= g(aVar)[1] && p(aVar) : invokeL.booleanValue;
    }

    public final boolean o(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) {
            float f2 = this.f1656f ? 0.0f : 15.0f;
            Context context = aVar.f1676c.getContext();
            int a2 = f.c.a(context, f2) + context.getResources().getDimensionPixelSize(p.nad_bubble_radius) + (context.getResources().getDimensionPixelSize(p.nad_bubble_horizontal_arrow_view_height) / 2);
            return a2 <= f(aVar) && a2 <= c(aVar);
        }
        return invokeL.booleanValue;
    }

    public final boolean p(c.a.b0.h0.b0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, aVar)) == null) {
            float f2 = this.f1656f ? 0.0f : 15.0f;
            Context context = aVar.f1676c.getContext();
            int a2 = f.c.a(context, f2) + (h(context) / 2) + (context.getResources().getDimensionPixelSize(p.nad_bubble_vertical_arrow_view_width) / 2);
            return a2 <= d(aVar) && a2 <= e(aVar);
        }
        return invokeL.booleanValue;
    }

    public void q(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.f1652b = f2;
        }
    }
}
