package c.a.p0.a.k.e.g;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import c.a.p0.a.e0.d.c;
import c.a.p0.a.k.c.b;
import c.a.p0.a.k.c.d;
import c.a.p0.a.p2.n0;
import c.a.p0.a.t1.e;
import c.a.p0.a.w0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f6046f;

    /* renamed from: g  reason: collision with root package name */
    public int f6047g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f6048h;

    /* renamed from: c.a.p0.a.k.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0352a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6049e;

        public ViewTreeObserver$OnGlobalLayoutListenerC0352a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6049e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f6049e.f6046f.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f6049e.f6047g == height) {
                    return;
                }
                if (this.f6049e.f6047g - height <= 180) {
                    if (height - this.f6049e.f6047g > 180) {
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("height", 0);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        hashMap.put("data", jSONObject.toString());
                        f.U().u(new c("keyboardHeightChange", hashMap));
                        this.f6049e.f6047g = height;
                        return;
                    }
                    return;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("height", n0.P(this.f6049e.f6047g - height));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                hashMap2.put("data", jSONObject2.toString());
                f.U().u(new c("keyboardHeightChange", hashMap2));
                this.f6049e.f6047g = height;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwanAppActivity activity = f.U().getActivity();
            if (activity == null) {
                c.a.p0.a.u.d.c("SoftKeyboardApi", "activity is null");
                return;
            }
            this.f6046f = activity.getWindow().getDecorView();
            Rect rect = new Rect();
            this.f6046f.getWindowVisibleDisplayFrame(rect);
            this.f6047g = rect.height();
            if (this.f6048h == null) {
                this.f6048h = new ViewTreeObserver$OnGlobalLayoutListenerC0352a(this);
                this.f6046f.getViewTreeObserver().addOnGlobalLayoutListener(this.f6048h);
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f6048h != null) {
                this.f6046f.getViewTreeObserver().removeOnGlobalLayoutListener(this.f6048h);
            }
            this.f6048h = null;
            this.f6047g = 0;
        }
    }

    public c.a.p0.a.k.h.b C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#startKeyboardHeightChange", false);
            if (e.a0() == null) {
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            A();
            return c.a.p0.a.k.h.b.f();
        }
        return (c.a.p0.a.k.h.b) invokeV.objValue;
    }

    public c.a.p0.a.k.h.b D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            q("#stopKeyboardHeightChange", false);
            if (e.a0() == null) {
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            B();
            return c.a.p0.a.k.h.b.f();
        }
        return (c.a.p0.a.k.h.b) invokeV.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Keyboard" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SoftKeyboardApi" : (String) invokeV.objValue;
    }
}
