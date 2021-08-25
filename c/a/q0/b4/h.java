package c.a.q0.b4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class h extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f16149a;

    /* renamed from: b  reason: collision with root package name */
    public a f16150b;

    /* renamed from: c  reason: collision with root package name */
    public int f16151c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f16152d;

    /* renamed from: e  reason: collision with root package name */
    public Context f16153e;

    /* renamed from: f  reason: collision with root package name */
    public int f16154f;

    /* loaded from: classes3.dex */
    public interface a {
        void onPrefixItemClick(int i2);
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f16155e;

        /* renamed from: f  reason: collision with root package name */
        public a f16156f;

        public b(int i2, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16155e = i2;
            this.f16156f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f16156f) == null) {
                return;
            }
            aVar.onPrefixItemClick(this.f16155e);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16149a = -1;
        this.f16153e = context;
        b(context);
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            view.setOnClickListener(new b(this.f16151c, this.f16150b));
            this.f16152d.addView(view);
            this.f16151c++;
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ScrollView scrollView = new ScrollView(context);
            scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = new LinearLayout(context);
            this.f16152d = linearLayout;
            linearLayout.setOrientation(1);
            this.f16152d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            scrollView.addView(this.f16152d);
            scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            scrollView.setPadding(0, 0, l.e(context, 1.0f), l.e(context, 1.0f));
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

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            int i3 = this.f16149a;
            if (i3 != -1) {
                this.f16152d.getChildAt(i3).setSelected(false);
            }
            this.f16149a = i2;
            this.f16152d.getChildAt(i2).setSelected(true);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f16154f = i2;
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f16150b = aVar;
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, view, i2, i3) == null) {
            getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.f16153e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f16153e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
            int measuredWidth = getContentView().getMeasuredWidth();
            if (measuredWidth < view.getWidth()) {
                measuredWidth = view.getWidth();
            }
            int measuredHeight = getContentView().getMeasuredHeight();
            int i4 = this.f16154f;
            if (measuredHeight > i4) {
                measuredHeight = i4;
            }
            setWidth(measuredWidth);
            setHeight(measuredHeight);
            super.showAsDropDown(view, i2, i3);
        }
    }
}
