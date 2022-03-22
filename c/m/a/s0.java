package c.m.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes3.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23551b;

    /* renamed from: c  reason: collision with root package name */
    public p0 f23552c;

    /* renamed from: d  reason: collision with root package name */
    public Info f23553d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f23554e;

    public s0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23554e = new p(this, Looper.getMainLooper());
    }

    public void a(View view, Info info, p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, view, info, p0Var) == null) {
            this.a = view;
            this.f23552c = p0Var;
            this.f23553d = info;
            try {
                Log.e(MiPushClient.COMMAND_REGISTER, "b111:" + this.f23551b);
                if (!this.f23551b) {
                    this.f23554e.sendEmptyMessage(1101);
                }
                Log.e(MiPushClient.COMMAND_REGISTER, "b2222");
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
        if (view.getGlobalVisibleRect(rect) && this.f23553d != null) {
            if (rect.width() >= this.f23553d.getSper() * view.getMeasuredWidth()) {
                if (rect.height() >= this.f23553d.getSper() * view.getMeasuredHeight()) {
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
