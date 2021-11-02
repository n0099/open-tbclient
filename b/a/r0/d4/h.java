package b.a.r0.d4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class h extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f15833a;

    /* renamed from: b  reason: collision with root package name */
    public a f15834b;

    /* renamed from: c  reason: collision with root package name */
    public int f15835c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15836d;

    /* renamed from: e  reason: collision with root package name */
    public Context f15837e;

    /* renamed from: f  reason: collision with root package name */
    public int f15838f;

    /* loaded from: classes4.dex */
    public interface a {
        void onPrefixItemClick(int i2);
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f15839e;

        /* renamed from: f  reason: collision with root package name */
        public a f15840f;

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
            this.f15839e = i2;
            this.f15840f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f15840f) == null) {
                return;
            }
            aVar.onPrefixItemClick(this.f15839e);
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
        this.f15833a = -1;
        this.f15837e = context;
        b(context);
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            view.setOnClickListener(new b(this.f15835c, this.f15834b));
            this.f15836d.addView(view);
            this.f15835c++;
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ScrollView scrollView = new ScrollView(context);
            scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = new LinearLayout(context);
            this.f15836d = linearLayout;
            linearLayout.setOrientation(1);
            this.f15836d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            scrollView.addView(this.f15836d);
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
            int i3 = this.f15833a;
            if (i3 != -1) {
                this.f15836d.getChildAt(i3).setSelected(false);
            }
            this.f15833a = i2;
            this.f15836d.getChildAt(i2).setSelected(true);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f15838f = i2;
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f15834b = aVar;
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, view, i2, i3) == null) {
            getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.f15837e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f15837e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
            int measuredWidth = getContentView().getMeasuredWidth();
            if (measuredWidth < view.getWidth()) {
                measuredWidth = view.getWidth();
            }
            int measuredHeight = getContentView().getMeasuredHeight();
            int i4 = this.f15838f;
            if (measuredHeight > i4) {
                measuredHeight = i4;
            }
            setWidth(measuredWidth);
            setHeight(measuredHeight);
            super.showAsDropDown(view, i2, i3);
        }
    }
}
