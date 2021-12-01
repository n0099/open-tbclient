package c.p.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30908b;

    /* renamed from: c  reason: collision with root package name */
    public p0 f30909c;

    /* renamed from: d  reason: collision with root package name */
    public Info f30910d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f30911e;

    public s0() {
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
        this.f30911e = new p(this, Looper.getMainLooper());
    }

    public void a(View view, Info info, p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, view, info, p0Var) == null) {
            this.a = view;
            this.f30909c = p0Var;
            this.f30910d = info;
            try {
                String str = "b111:" + this.f30908b;
                if (!this.f30908b) {
                    this.f30911e.sendEmptyMessage(1101);
                }
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                viewTreeObserver.addOnScrollChangedListener(new t(this, p0Var));
                viewTreeObserver.addOnGlobalFocusChangeListener(new x(this, p0Var));
                if (Build.VERSION.SDK_INT >= 18) {
                    viewTreeObserver.addOnWindowFocusChangeListener(new b0(this));
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    viewTreeObserver.addOnWindowAttachListener(new e0(this));
                }
                viewTreeObserver.addOnTouchModeChangeListener(new h0(this));
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.addOnDrawListener(new k0(this, viewTreeObserver));
                }
                viewTreeObserver.addOnGlobalLayoutListener(new n0(this, viewTreeObserver));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(View view) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) != null) {
            return invokeL.booleanValue;
        }
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && this.f30910d != null) {
            if (rect.width() >= this.f30910d.getSper() * view.getMeasuredWidth()) {
                if (rect.height() >= this.f30910d.getSper() * view.getMeasuredHeight()) {
                    z = false;
                    return z;
                }
            }
        }
        z = true;
        if (z) {
        }
    }
}
