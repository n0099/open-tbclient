package c.a.p0.s4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class h extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public a f18303b;

    /* renamed from: c  reason: collision with root package name */
    public int f18304c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f18305d;

    /* renamed from: e  reason: collision with root package name */
    public Context f18306e;

    /* renamed from: f  reason: collision with root package name */
    public int f18307f;

    /* loaded from: classes2.dex */
    public interface a {
        void onPrefixItemClick(int i);
    }

    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public a f18308b;

        public b(int i, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f18308b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f18308b) == null) {
                return;
            }
            aVar.onPrefixItemClick(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f18306e = context;
        b(context);
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            view.setOnClickListener(new b(this.f18304c, this.f18303b));
            this.f18305d.addView(view);
            this.f18304c++;
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ScrollView scrollView = new ScrollView(context);
            scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = new LinearLayout(context);
            this.f18305d = linearLayout;
            linearLayout.setOrientation(1);
            this.f18305d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            scrollView.addView(this.f18305d);
            scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            scrollView.setPadding(0, 0, n.d(context, 1.0f), n.d(context, 1.0f));
            scrollView.setFadingEdgeLength(0);
            scrollView.setScrollbarFadingEnabled(false);
            try {
                Method declaredMethod = scrollView.getClass().getDeclaredMethod("setOverScrollMode", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(scrollView, 2);
            } catch (Exception unused) {
            }
            setContentView(scrollView);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int i2 = this.a;
            if (i2 != -1) {
                this.f18305d.getChildAt(i2).setSelected(false);
            }
            this.a = i;
            this.f18305d.getChildAt(i).setSelected(true);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f18307f = i;
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f18303b = aVar;
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, view, i, i2) == null) {
            getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.f18306e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f18306e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
            int measuredWidth = getContentView().getMeasuredWidth();
            if (measuredWidth < view.getWidth()) {
                measuredWidth = view.getWidth();
            }
            int measuredHeight = getContentView().getMeasuredHeight();
            int i3 = this.f18307f;
            if (measuredHeight > i3) {
                measuredHeight = i3;
            }
            setWidth(measuredWidth);
            setHeight(measuredHeight);
            super.showAsDropDown(view, i, i2);
        }
    }
}
