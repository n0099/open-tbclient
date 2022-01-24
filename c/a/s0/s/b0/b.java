package c.a.s0.s.b0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.s.b0.a a;

    /* renamed from: b  reason: collision with root package name */
    public int f13182b;

    /* renamed from: c  reason: collision with root package name */
    public int f13183c;

    /* renamed from: d  reason: collision with root package name */
    public int f13184d;

    /* renamed from: e  reason: collision with root package name */
    public View f13185e;

    /* renamed from: f  reason: collision with root package name */
    public View f13186f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f13187g;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13188e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13188e = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13188e.f13185e == null) {
                return;
            }
            this.f13188e.e();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
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
        this.f13187g = activity;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.keyboard_height_popupwindow, (ViewGroup) null, false);
        this.f13185e = inflate;
        setContentView(inflate);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.f13186f = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.f13185e.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
            dismiss();
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13187g.getResources().getConfiguration().orientation : invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Point point = new Point();
            this.f13187g.getWindowManager().getDefaultDisplay().getSize(point);
            Rect rect = new Rect();
            this.f13185e.getWindowVisibleDisplayFrame(rect);
            int d2 = d();
            int i2 = point.y - rect.bottom;
            if (i2 == 0) {
                f(0, d2);
            } else if (d2 == 1) {
                this.f13184d = i2;
                f(i2, d2);
            } else {
                this.f13183c = i2;
                f(i2, d2);
            }
        }
    }

    public final void f(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            if (i2 <= 0) {
                this.f13182b = i2;
                i4 = 0;
            } else {
                i4 = i2 - this.f13182b;
            }
            c.a.s0.s.b0.a aVar = this.a;
            if (aVar != null) {
                aVar.onKeyboardHeightChanged(i4, i3);
            }
        }
    }

    public void g(c.a.s0.s.b0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || isShowing() || this.f13186f.getWindowToken() == null) {
            return;
        }
        setBackgroundDrawable(new ColorDrawable(0));
        showAtLocation(this.f13186f, 0, 0, 0);
    }
}
