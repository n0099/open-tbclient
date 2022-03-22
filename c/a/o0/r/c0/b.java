package c.a.o0.r.c0;

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
/* loaded from: classes2.dex */
public class b extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.r.c0.a a;

    /* renamed from: b  reason: collision with root package name */
    public int f10558b;

    /* renamed from: c  reason: collision with root package name */
    public int f10559c;

    /* renamed from: d  reason: collision with root package name */
    public int f10560d;

    /* renamed from: e  reason: collision with root package name */
    public View f10561e;

    /* renamed from: f  reason: collision with root package name */
    public View f10562f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f10563g;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f10561e == null) {
                return;
            }
            this.a.e();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10563g = activity;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.obfuscated_res_0x7f0d0414, (ViewGroup) null, false);
        this.f10561e = inflate;
        setContentView(inflate);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.f10562f = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.f10561e.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10563g.getResources().getConfiguration().orientation : invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Point point = new Point();
            this.f10563g.getWindowManager().getDefaultDisplay().getSize(point);
            Rect rect = new Rect();
            this.f10561e.getWindowVisibleDisplayFrame(rect);
            int d2 = d();
            int i = point.y - rect.bottom;
            if (i == 0) {
                f(0, d2);
            } else if (d2 == 1) {
                this.f10560d = i;
                f(i, d2);
            } else {
                this.f10559c = i;
                f(i, d2);
            }
        }
    }

    public final void f(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            if (i <= 0) {
                this.f10558b = i;
                i3 = 0;
            } else {
                i3 = i - this.f10558b;
            }
            c.a.o0.r.c0.a aVar = this.a;
            if (aVar != null) {
                aVar.onKeyboardHeightChanged(i3, i2);
            }
        }
    }

    public void g(c.a.o0.r.c0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || isShowing() || this.f10562f.getWindowToken() == null) {
            return;
        }
        setBackgroundDrawable(new ColorDrawable(0));
        showAtLocation(this.f10562f, 0, 0, 0);
    }
}
