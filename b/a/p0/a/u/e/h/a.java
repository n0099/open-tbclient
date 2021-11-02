package b.a.p0.a.u.e.h;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.o0.d.b;
import b.a.p0.a.u.c.d;
import b.a.p0.a.v2.n0;
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

    /* renamed from: d  reason: collision with root package name */
    public View f8202d;

    /* renamed from: e  reason: collision with root package name */
    public int f8203e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f8204f;

    /* renamed from: b.a.p0.a.u.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0397a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8205e;

        public ViewTreeObserver$OnGlobalLayoutListenerC0397a(a aVar) {
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
            this.f8205e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f8205e.f8202d.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8205e.f8203e == height) {
                    return;
                }
                if (this.f8205e.f8203e - height <= 180) {
                    if (height - this.f8205e.f8203e > 180) {
                        if (d.f8000c) {
                            String str = "onKeyBoardHide: mRootViewVisibleHeight " + this.f8205e.f8203e + " visibleHeight " + height;
                        }
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("height", 0);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        hashMap.put("data", jSONObject.toString());
                        f.T().u(new b("keyboardHeightChange", hashMap));
                        this.f8205e.f8203e = height;
                        return;
                    }
                    return;
                }
                if (d.f8000c) {
                    String str2 = "onKeyBoardShow: mRootViewVisibleHeight " + this.f8205e.f8203e + " visibleHeight " + height;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("height", n0.L(this.f8205e.f8203e - height));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                hashMap2.put("data", jSONObject2.toString());
                f.T().u(new b("keyboardHeightChange", hashMap2));
                this.f8205e.f8203e = height;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwanAppActivity activity = f.T().getActivity();
            if (activity == null) {
                b.a.p0.a.e0.d.b("Api-GetKeyboardHeight", "activity is null");
                return;
            }
            this.f8202d = activity.getWindow().getDecorView();
            Rect rect = new Rect();
            this.f8202d.getWindowVisibleDisplayFrame(rect);
            this.f8203e = rect.height();
            if (this.f8204f == null) {
                this.f8204f = new ViewTreeObserver$OnGlobalLayoutListenerC0397a(this);
                this.f8202d.getViewTreeObserver().addOnGlobalLayoutListener(this.f8204f);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f8204f != null) {
                this.f8202d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f8204f);
            }
            this.f8204f = null;
            this.f8203e = 0;
        }
    }

    public b.a.p0.a.u.h.b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = d.f8000c;
            if (e.P() == null) {
                return new b.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            t();
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = d.f8000c;
            if (e.P() == null) {
                return new b.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            u();
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }
}
