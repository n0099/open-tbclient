package c.a.c0.h0.b0.e;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.h0.d0.b;
import c.a.c0.h0.o;
import c.a.c0.h0.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.ArrowView;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.nadcore.widget.bubble.shadow.MaskViewGroup;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public View f2120b;

    /* renamed from: c  reason: collision with root package name */
    public View f2121c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f2122d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f2123e;

    /* renamed from: f  reason: collision with root package name */
    public MaskViewGroup f2124f;

    /* renamed from: g  reason: collision with root package name */
    public ArrowView f2125g;

    /* renamed from: h  reason: collision with root package name */
    public ArrowView f2126h;

    /* renamed from: i  reason: collision with root package name */
    public ArrowView f2127i;

    /* renamed from: j  reason: collision with root package name */
    public ArrowView f2128j;

    /* renamed from: k  reason: collision with root package name */
    public ArrowView f2129k;
    public View l;
    public View m;
    @ColorInt
    public int n;
    public c.a.c0.h0.d0.a o;

    /* renamed from: c.a.c0.h0.b0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0075a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Resources a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2130b;

        public C0075a(a aVar, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2130b = aVar;
            this.a = resources;
        }

        @Override // c.a.c0.h0.d0.b.a
        public void a(TextView textView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, textView, motionEvent) == null) {
            }
        }

        @Override // c.a.c0.h0.d0.b.a
        public void b(TextView textView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, motionEvent) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f2130b.f2123e.setLinkTextColor(this.a.getColor(o.nad_bubble_link_text_color));
                } else {
                    this.f2130b.f2123e.setLinkTextColor(this.a.getColorStateList(o.nad_home_tab_bubble_tips_text_color));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-944793156, "Lc/a/c0/h0/b0/e/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-944793156, "Lc/a/c0/h0/b0/e/a$b;");
                    return;
                }
            }
            int[] iArr = new int[BubblePosition.values().length];
            a = iArr;
            try {
                iArr[BubblePosition.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BubblePosition.UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BubblePosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BubblePosition.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BubblePosition.INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a() {
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
        this.n = -1;
    }

    public void A(int[] iArr) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iArr) == null) || (view = this.f2120b) == null) {
            return;
        }
        view.setX(iArr[0]);
        this.f2120b.setY(iArr[1]);
        this.f2122d.setVisibility(0);
        this.f2120b.setVisibility(0);
        this.f2125g.setVisibility(0);
        this.l.setVisibility(0);
        MaskViewGroup maskViewGroup = this.f2124f;
        if (maskViewGroup != null) {
            maskViewGroup.setVisibility(0);
        }
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
        c.a.c0.h0.b0.a.a().b("——>checkSafe remove view end");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2126h.setVisibility(8);
            this.f2127i.setVisibility(8);
            this.f2128j.setVisibility(8);
            this.f2129k.setVisibility(8);
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.f2121c;
            return view != null ? view.getClass().getSimpleName() : "NULL";
        }
        return (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.n;
            return i2 != -1 ? i2 : c.a.c0.e.a.b().getResources().getColor(o.NAD_UC29);
        }
        return invokeV.intValue;
    }

    public abstract int e();

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Resources resources = c.a.c0.e.a.b().getResources();
            this.f2123e.setLinkTextColor(resources.getColorStateList(o.nad_home_tab_bubble_tips_text_color));
            this.f2123e.setHighlightColor(0);
            c.a.c0.h0.d0.b bVar = new c.a.c0.h0.d0.b();
            bVar.a(new C0075a(this, resources));
            this.f2123e.setMovementMethod(bVar);
            if (this.o == null) {
                this.o = new c.a.c0.h0.d0.a(this.f2123e);
            }
            this.f2123e.getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f2120b == null) {
                View inflate = LayoutInflater.from(this.f2121c.getContext()).inflate(e(), this.a, false);
                this.f2120b = inflate;
                inflate.setVisibility(4);
                this.f2122d = (ViewGroup) this.f2120b.findViewById(r.bubble_content);
                this.f2124f = (MaskViewGroup) this.f2120b.findViewById(r.shadowLayout);
                this.f2126h = (ArrowView) this.f2120b.findViewById(r.bubble_arrow_up);
                this.f2127i = (ArrowView) this.f2120b.findViewById(r.bubble_arrow_down);
                this.f2128j = (ArrowView) this.f2120b.findViewById(r.bubble_arrow_left);
                this.f2129k = (ArrowView) this.f2120b.findViewById(r.bubble_arrow_right);
                int d2 = d();
                MaskViewGroup maskViewGroup = this.f2124f;
                if (maskViewGroup != null) {
                    maskViewGroup.setShadowColor(d2);
                }
                if (this.f2122d.getBackground() instanceof GradientDrawable) {
                    ((GradientDrawable) this.f2122d.getBackground()).setColor(d2);
                }
                this.f2122d.setVisibility(4);
                this.f2126h.setArrowViewColor(d2);
                this.f2127i.setArrowViewColor(d2);
                this.f2128j.setArrowViewColor(d2);
                this.f2129k.setArrowViewColor(d2);
                View view = new View(this.f2121c.getContext());
                this.l = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.l.setVisibility(4);
                this.m = new View(this.f2121c.getContext());
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.f2121c == null || this.a == null) ? false : true : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.f2121c == null || this.a == null || this.f2120b == null) ? false : true : invokeV.booleanValue;
    }

    public void j(Runnable runnable) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) || (view = this.f2121c) == null) {
            return;
        }
        view.post(runnable);
    }

    public void k() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (viewGroup = this.a) == null || this.f2120b == null || this.l == null) {
            return;
        }
        viewGroup.removeView(this.m);
    }

    public void l() {
        ViewGroup viewGroup;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (viewGroup = this.a) == null || this.f2120b == null || (view = this.l) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void m() {
        ViewGroup viewGroup;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (viewGroup = this.a) == null || (view = this.f2120b) == null || this.l == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void n() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.o != null && (textView = this.f2123e) != null) {
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this.o);
                this.o = null;
            }
            this.a = null;
            this.f2120b = null;
            this.f2122d = null;
            this.f2125g = null;
            this.f2123e = null;
            this.f2121c = null;
            this.f2126h = null;
            this.f2127i = null;
            this.l = null;
            this.m = null;
            this.f2124f = null;
        }
    }

    public void o() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (view = this.m) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = 0;
        this.m.setLayoutParams(layoutParams);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.m == null) {
            return;
        }
        c.a.c0.h0.b0.a.a().b("——>checksafe anchor layer begin");
        a(this.m);
        c.a.c0.h0.b0.a.a().b("——>checksafe anchor layer end");
        this.a.addView(this.m);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.l == null) {
            return;
        }
        c.a.c0.h0.b0.a.a().b("——>check bg view begin");
        a(this.l);
        c.a.c0.h0.b0.a.a().b("——>check bg view end");
        this.a.addView(this.l);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f2120b == null) {
            return;
        }
        c.a.c0.h0.b0.a.a().b("——>check bubble view begin");
        a(this.f2120b);
        c.a.c0.h0.b0.a.a().b("——>check bubble view end");
        this.f2120b.setVisibility(4);
        this.a.addView(this.f2120b);
    }

    public void s(View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view, viewGroup) == null) {
            if (view != null) {
                this.f2121c = view;
                this.a = viewGroup;
                if (viewGroup != null || view == null) {
                    return;
                }
                ViewGroup viewGroup2 = (ViewGroup) view.getRootView().findViewById(16908290);
                this.a = viewGroup2;
                if (viewGroup2 == null) {
                    throw new IllegalArgumentException("root view must be a child of android.R.id.content");
                }
                return;
            }
            throw new IllegalArgumentException("anchor view must not be null !!!");
        }
    }

    public void t(View.OnClickListener onClickListener) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) || (view = this.m) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public void u(View.OnClickListener onClickListener) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) || (view = this.l) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public void v(View.OnClickListener onClickListener) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) || (view = this.f2120b) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public void w(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.n = i2;
        }
    }

    public void x(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
        }
    }

    public void y() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (view = this.m) == null || this.f2121c == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = this.f2121c.getMeasuredWidth();
        layoutParams.height = this.f2121c.getMeasuredHeight();
        this.m.setLayoutParams(layoutParams);
        int[] iArr = new int[2];
        this.f2121c.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.a.getLocationOnScreen(iArr2);
        this.m.setX(iArr[0] - iArr2[0]);
        this.m.setY(iArr[1] - iArr2[1]);
    }

    public void z(BubblePosition bubblePosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bubblePosition) == null) {
            b();
            int i2 = b.a[bubblePosition.ordinal()];
            if (i2 == 1) {
                this.f2126h.setDirection(2);
                ArrowView arrowView = this.f2126h;
                this.f2125g = arrowView;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2125g.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin - ((int) arrowView.dpToPixel(1.0f)));
                    this.f2125g.setLayoutParams(marginLayoutParams);
                }
            } else if (i2 == 2) {
                this.f2127i.setDirection(4);
                this.f2125g = this.f2127i;
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                this.f2129k.setDirection(3);
                this.f2125g = this.f2129k;
            } else {
                this.f2128j.setDirection(1);
                ArrowView arrowView2 = this.f2128j;
                this.f2125g = arrowView2;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f2125g.getLayoutParams();
                    marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin - ((int) arrowView2.dpToPixel(1.0f)), marginLayoutParams2.bottomMargin);
                    this.f2125g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
    }
}
