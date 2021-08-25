package c.a.o0.a.u.e.h;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import c.a.o0.a.a2.e;
import c.a.o0.a.g1.f;
import c.a.o0.a.o0.d.b;
import c.a.o0.a.u.c.d;
import c.a.o0.a.v2.n0;
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
    public View f8908d;

    /* renamed from: e  reason: collision with root package name */
    public int f8909e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f8910f;

    /* renamed from: c.a.o0.a.u.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0400a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8911e;

        public ViewTreeObserver$OnGlobalLayoutListenerC0400a(a aVar) {
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
            this.f8911e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f8911e.f8908d.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8911e.f8909e == height) {
                    return;
                }
                if (this.f8911e.f8909e - height <= 180) {
                    if (height - this.f8911e.f8909e > 180) {
                        if (d.f8699c) {
                            String str = "onKeyBoardHide: mRootViewVisibleHeight " + this.f8911e.f8909e + " visibleHeight " + height;
                        }
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("height", 0);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        hashMap.put("data", jSONObject.toString());
                        f.V().v(new b("keyboardHeightChange", hashMap));
                        this.f8911e.f8909e = height;
                        return;
                    }
                    return;
                }
                if (d.f8699c) {
                    String str2 = "onKeyBoardShow: mRootViewVisibleHeight " + this.f8911e.f8909e + " visibleHeight " + height;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("height", n0.L(this.f8911e.f8909e - height));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                hashMap2.put("data", jSONObject2.toString());
                f.V().v(new b("keyboardHeightChange", hashMap2));
                this.f8911e.f8909e = height;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.o0.a.u.c.b bVar) {
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
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwanAppActivity activity = f.V().getActivity();
            if (activity == null) {
                c.a.o0.a.e0.d.b("Api-GetKeyboardHeight", "activity is null");
                return;
            }
            this.f8908d = activity.getWindow().getDecorView();
            Rect rect = new Rect();
            this.f8908d.getWindowVisibleDisplayFrame(rect);
            this.f8909e = rect.height();
            if (this.f8910f == null) {
                this.f8910f = new ViewTreeObserver$OnGlobalLayoutListenerC0400a(this);
                this.f8908d.getViewTreeObserver().addOnGlobalLayoutListener(this.f8910f);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f8910f != null) {
                this.f8908d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f8910f);
            }
            this.f8910f = null;
            this.f8909e = 0;
        }
    }

    public c.a.o0.a.u.h.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = d.f8699c;
            if (e.Q() == null) {
                return new c.a.o0.a.u.h.b(1001, "SwanApp is null");
            }
            u();
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeV.objValue;
    }

    public c.a.o0.a.u.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = d.f8699c;
            if (e.Q() == null) {
                return new c.a.o0.a.u.h.b(1001, "SwanApp is null");
            }
            v();
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeV.objValue;
    }
}
