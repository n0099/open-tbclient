package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.bh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class bj implements bh.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bh a;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view2, boolean z, Activity activity);
    }

    public abstract void a();

    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class a extends bj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Activity> a;
        public b b;
        public final WeakHashMap<View, C0129a> c;

        /* renamed from: com.baidu.mobstat.bj$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0129a extends View.AccessibilityDelegate {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;
            public View.AccessibilityDelegate b;
            public View c;
            public volatile boolean d;
            public long e;
            public long f;

            public C0129a(a aVar, WeakReference<Activity> weakReference, View view2, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, weakReference, view2, str, accessibilityDelegate, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
                this.b = accessibilityDelegate;
                aVar.a = weakReference;
                this.c = view2;
                this.d = z;
            }

            public View.AccessibilityDelegate a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.b;
                }
                return (View.AccessibilityDelegate) invokeV.objValue;
            }

            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.d = z;
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view2, int i) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
                    try {
                        if (CooperService.instance().isCloseTrace()) {
                            this.a.a();
                            return;
                        }
                        this.e = System.currentTimeMillis();
                        if (view2 == this.c && i == 1) {
                            if (bc.c().b() && this.d) {
                                bc c = bc.c();
                                c.a("watch view  OnEvent:" + view2.getClass().getName());
                            }
                            if (bg.c().b()) {
                                bg c2 = bg.c();
                                c2.a("watch view  OnEvent:" + view2.getClass().getName());
                            }
                            if (this.a.a != null && (activity = (Activity) this.a.a.get()) != null) {
                                this.a.b.a(view2, this.d, activity);
                            }
                        }
                        if (this.e - this.f < 100) {
                            return;
                        }
                        this.f = System.currentTimeMillis();
                        if (this.b != null && !(this.b instanceof C0129a) && this.b != this) {
                            this.b.sendAccessibilityEvent(view2, i);
                        } else {
                            super.sendAccessibilityEvent(view2, i);
                        }
                    } catch (Throwable unused) {
                        this.a.a();
                        CooperService.instance().setEnableAutoEvent(false);
                    }
                }
            }
        }

        public a(int i, WeakReference<Activity> weakReference, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), weakReference, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
            this.b = bVar;
            this.c = new WeakHashMap<>();
        }

        private View.AccessibilityDelegate a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, view2)) == null) {
                try {
                    return (View.AccessibilityDelegate) view2.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view2, new Object[0]);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (View.AccessibilityDelegate) invokeL.objValue;
        }

        @Override // com.baidu.mobstat.bj
        public void a() {
            WeakHashMap<View, C0129a> weakHashMap;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (weakHashMap = this.c) == null) {
                return;
            }
            for (Map.Entry<View, C0129a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.c.clear();
        }

        @Override // com.baidu.mobstat.bh.a
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, z) == null) {
                a(this.a, view2, bi.a(view2), z);
            }
        }

        public void a(WeakReference<Activity> weakReference, View view2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{weakReference, view2, str, Boolean.valueOf(z)}) == null) {
                View.AccessibilityDelegate a = a(view2);
                if (!(a instanceof C0129a)) {
                    C0129a c0129a = new C0129a(this, weakReference, view2, str, a, z);
                    view2.setAccessibilityDelegate(c0129a);
                    this.c.put(view2, c0129a);
                    return;
                }
                ((C0129a) a).a(z);
            }
        }
    }

    public bj() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, jSONObject, z) == null) {
            if (this.a == null) {
                bh bhVar = new bh(activity, this, z);
                this.a = bhVar;
                bhVar.a(jSONObject);
            }
            this.a.a(activity);
        }
    }
}
