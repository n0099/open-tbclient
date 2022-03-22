package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.bi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class bk implements bi.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bi a;

    @TargetApi(14)
    /* loaded from: classes4.dex */
    public static class a extends bk {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Activity> a;

        /* renamed from: b  reason: collision with root package name */
        public b f27320b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakHashMap<View, C1773a> f27321c;

        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1773a extends View.AccessibilityDelegate {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: b  reason: collision with root package name */
            public View.AccessibilityDelegate f27322b;

            /* renamed from: c  reason: collision with root package name */
            public View f27323c;

            /* renamed from: d  reason: collision with root package name */
            public volatile boolean f27324d;

            public C1773a(a aVar, WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, weakReference, view, str, accessibilityDelegate, Boolean.valueOf(z)};
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
                this.f27322b = accessibilityDelegate;
                aVar.a = weakReference;
                this.f27323c = view;
                this.f27324d = z;
            }

            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f27324d = z;
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i) == null) {
                    if (view == this.f27323c && i == 1) {
                        if (bd.c().b() && this.f27324d) {
                            bd c2 = bd.c();
                            c2.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (bh.c().b()) {
                            bh c3 = bh.c();
                            c3.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (this.a.a != null && (activity = (Activity) this.a.a.get()) != null) {
                            this.a.f27320b.a(view, this.f27324d, activity);
                        }
                    }
                    View.AccessibilityDelegate accessibilityDelegate = this.f27322b;
                    if (accessibilityDelegate != null) {
                        accessibilityDelegate.sendAccessibilityEvent(view, i);
                    } else {
                        super.sendAccessibilityEvent(view, i);
                    }
                }
            }

            public View.AccessibilityDelegate a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27322b : (View.AccessibilityDelegate) invokeV.objValue;
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
            this.f27320b = bVar;
            this.f27321c = new WeakHashMap<>();
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{weakReference, view, str, Boolean.valueOf(z)}) == null) {
                View.AccessibilityDelegate a = a(view);
                if (!(a instanceof C1773a)) {
                    C1773a c1773a = new C1773a(this, weakReference, view, str, a, z);
                    view.setAccessibilityDelegate(c1773a);
                    this.f27321c.put(view, c1773a);
                    return;
                }
                ((C1773a) a).a(z);
            }
        }

        private View.AccessibilityDelegate a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, view)) == null) {
                try {
                    return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (View.AccessibilityDelegate) invokeL.objValue;
        }

        @Override // com.baidu.mobstat.bi.a
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, z) == null) {
                a(this.a, view, bj.a(view), z);
            }
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            WeakHashMap<View, C1773a> weakHashMap;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakHashMap = this.f27321c) == null) {
                return;
            }
            for (Map.Entry<View, C1773a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.f27321c.clear();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public bk() {
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

    public abstract void a();

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, jSONObject, z) == null) {
            if (this.a == null) {
                bi biVar = new bi(activity, this, z);
                this.a = biVar;
                biVar.a(jSONObject);
            }
            this.a.a(activity);
        }
    }
}
