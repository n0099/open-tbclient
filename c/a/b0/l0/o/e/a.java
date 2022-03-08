package c.a.b0.l0.o.e;

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
import c.a.b0.l0.q.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.ArrowView;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.nadcore.widget.bubble.shadow.MaskViewGroup;
import com.baidu.tieba.R;
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
    public View f1850b;

    /* renamed from: c  reason: collision with root package name */
    public View f1851c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f1852d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f1853e;

    /* renamed from: f  reason: collision with root package name */
    public MaskViewGroup f1854f;

    /* renamed from: g  reason: collision with root package name */
    public ArrowView f1855g;

    /* renamed from: h  reason: collision with root package name */
    public ArrowView f1856h;

    /* renamed from: i  reason: collision with root package name */
    public ArrowView f1857i;

    /* renamed from: j  reason: collision with root package name */
    public ArrowView f1858j;
    public ArrowView k;
    public View l;
    public View m;
    @ColorInt
    public int n;
    public c.a.b0.l0.q.a o;

    /* renamed from: c.a.b0.l0.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0074a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Resources a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1859b;

        public C0074a(a aVar, Resources resources) {
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
            this.f1859b = aVar;
            this.a = resources;
        }

        @Override // c.a.b0.l0.q.b.a
        public void a(TextView textView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, textView, motionEvent) == null) {
            }
        }

        @Override // c.a.b0.l0.q.b.a
        public void b(TextView textView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, motionEvent) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f1859b.f1853e.setLinkTextColor(this.a.getColor(R.color.nad_bubble_link_text_color));
                } else {
                    this.f1859b.f1853e.setLinkTextColor(this.a.getColorStateList(R.color.nad_home_tab_bubble_tips_text_color));
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1180215018, "Lc/a/b0/l0/o/e/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1180215018, "Lc/a/b0/l0/o/e/a$b;");
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iArr) == null) || (view = this.f1850b) == null) {
            return;
        }
        view.setX(iArr[0]);
        this.f1850b.setY(iArr[1]);
        this.f1852d.setVisibility(0);
        this.f1850b.setVisibility(0);
        this.f1855g.setVisibility(0);
        this.l.setVisibility(0);
        MaskViewGroup maskViewGroup = this.f1854f;
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
        c.a.b0.l0.o.a.a().b("——>checkSafe remove view end");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1856h.setVisibility(8);
            this.f1857i.setVisibility(8);
            this.f1858j.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.f1851c;
            return view != null ? view.getClass().getSimpleName() : "NULL";
        }
        return (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.n;
            return i2 != -1 ? i2 : c.a.b0.h.a.b().getResources().getColor(R.color.NAD_UC29);
        }
        return invokeV.intValue;
    }

    public abstract int e();

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Resources resources = c.a.b0.h.a.b().getResources();
            this.f1853e.setLinkTextColor(resources.getColorStateList(R.color.nad_home_tab_bubble_tips_text_color));
            this.f1853e.setHighlightColor(0);
            c.a.b0.l0.q.b bVar = new c.a.b0.l0.q.b();
            bVar.a(new C0074a(this, resources));
            this.f1853e.setMovementMethod(bVar);
            if (this.o == null) {
                this.o = new c.a.b0.l0.q.a(this.f1853e);
            }
            this.f1853e.getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f1850b == null) {
                View inflate = LayoutInflater.from(this.f1851c.getContext()).inflate(e(), this.a, false);
                this.f1850b = inflate;
                inflate.setVisibility(4);
                this.f1852d = (ViewGroup) this.f1850b.findViewById(R.id.bubble_content);
                this.f1854f = (MaskViewGroup) this.f1850b.findViewById(R.id.shadowLayout);
                this.f1856h = (ArrowView) this.f1850b.findViewById(R.id.bubble_arrow_up);
                this.f1857i = (ArrowView) this.f1850b.findViewById(R.id.bubble_arrow_down);
                this.f1858j = (ArrowView) this.f1850b.findViewById(R.id.bubble_arrow_left);
                this.k = (ArrowView) this.f1850b.findViewById(R.id.bubble_arrow_right);
                int d2 = d();
                MaskViewGroup maskViewGroup = this.f1854f;
                if (maskViewGroup != null) {
                    maskViewGroup.setShadowColor(d2);
                }
                if (this.f1852d.getBackground() instanceof GradientDrawable) {
                    ((GradientDrawable) this.f1852d.getBackground()).setColor(d2);
                }
                this.f1852d.setVisibility(4);
                this.f1856h.setArrowViewColor(d2);
                this.f1857i.setArrowViewColor(d2);
                this.f1858j.setArrowViewColor(d2);
                this.k.setArrowViewColor(d2);
                View view = new View(this.f1851c.getContext());
                this.l = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.l.setVisibility(4);
                this.m = new View(this.f1851c.getContext());
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.f1851c == null || this.a == null) ? false : true : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.f1851c == null || this.a == null || this.f1850b == null) ? false : true : invokeV.booleanValue;
    }

    public void j(Runnable runnable) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) || (view = this.f1851c) == null) {
            return;
        }
        view.post(runnable);
    }

    public void k() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (viewGroup = this.a) == null || this.f1850b == null || this.l == null) {
            return;
        }
        viewGroup.removeView(this.m);
    }

    public void l() {
        ViewGroup viewGroup;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (viewGroup = this.a) == null || this.f1850b == null || (view = this.l) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void m() {
        ViewGroup viewGroup;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (viewGroup = this.a) == null || (view = this.f1850b) == null || this.l == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void n() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.o != null && (textView = this.f1853e) != null) {
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this.o);
                this.o = null;
            }
            this.a = null;
            this.f1850b = null;
            this.f1852d = null;
            this.f1855g = null;
            this.f1853e = null;
            this.f1851c = null;
            this.f1856h = null;
            this.f1857i = null;
            this.l = null;
            this.m = null;
            this.f1854f = null;
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
        c.a.b0.l0.o.a.a().b("——>checksafe anchor layer begin");
        a(this.m);
        c.a.b0.l0.o.a.a().b("——>checksafe anchor layer end");
        this.a.addView(this.m);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.l == null) {
            return;
        }
        c.a.b0.l0.o.a.a().b("——>check bg view begin");
        a(this.l);
        c.a.b0.l0.o.a.a().b("——>check bg view end");
        this.a.addView(this.l);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f1850b == null) {
            return;
        }
        c.a.b0.l0.o.a.a().b("——>check bubble view begin");
        a(this.f1850b);
        c.a.b0.l0.o.a.a().b("——>check bubble view end");
        this.f1850b.setVisibility(4);
        this.a.addView(this.f1850b);
    }

    public void s(View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view, viewGroup) == null) {
            if (view != null) {
                this.f1851c = view;
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
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) || (view = this.f1850b) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (view = this.m) == null || this.f1851c == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = this.f1851c.getMeasuredWidth();
        layoutParams.height = this.f1851c.getMeasuredHeight();
        this.m.setLayoutParams(layoutParams);
        int[] iArr = new int[2];
        this.f1851c.getLocationOnScreen(iArr);
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
                this.f1856h.setDirection(2);
                ArrowView arrowView = this.f1856h;
                this.f1855g = arrowView;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1855g.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin - ((int) arrowView.dpToPixel(1.0f)));
                    this.f1855g.setLayoutParams(marginLayoutParams);
                }
            } else if (i2 == 2) {
                this.f1857i.setDirection(4);
                this.f1855g = this.f1857i;
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                this.k.setDirection(3);
                this.f1855g = this.k;
            } else {
                this.f1858j.setDirection(1);
                ArrowView arrowView2 = this.f1858j;
                this.f1855g = arrowView2;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f1855g.getLayoutParams();
                    marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin - ((int) arrowView2.dpToPixel(1.0f)), marginLayoutParams2.bottomMargin);
                    this.f1855g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
    }
}
