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
/* loaded from: classes10.dex */
public abstract class bk implements bi.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bi a;

    @TargetApi(14)
    /* loaded from: classes10.dex */
    public static class a extends bk {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Activity> a;

        /* renamed from: b  reason: collision with root package name */
        public b f36574b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakHashMap<View, C1833a> f36575c;

        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C1833a extends View.AccessibilityDelegate {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: b  reason: collision with root package name */
            public View.AccessibilityDelegate f36576b;

            /* renamed from: c  reason: collision with root package name */
            public View f36577c;

            /* renamed from: d  reason: collision with root package name */
            public volatile boolean f36578d;

            public C1833a(a aVar, WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, weakReference, view, str, accessibilityDelegate, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
                this.f36576b = accessibilityDelegate;
                aVar.a = weakReference;
                this.f36577c = view;
                this.f36578d = z;
            }

            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f36578d = z;
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i2) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
                    if (view == this.f36577c && i2 == 1) {
                        if (bd.c().b() && this.f36578d) {
                            bd c2 = bd.c();
                            c2.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (bh.c().b()) {
                            bh c3 = bh.c();
                            c3.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (this.a.a != null && (activity = (Activity) this.a.a.get()) != null) {
                            this.a.f36574b.a(view, this.f36578d, activity);
                        }
                    }
                    View.AccessibilityDelegate accessibilityDelegate = this.f36576b;
                    if (accessibilityDelegate != null) {
                        accessibilityDelegate.sendAccessibilityEvent(view, i2);
                    } else {
                        super.sendAccessibilityEvent(view, i2);
                    }
                }
            }

            public View.AccessibilityDelegate a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36576b : (View.AccessibilityDelegate) invokeV.objValue;
            }
        }

        public a(int i2, WeakReference<Activity> weakReference, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), weakReference, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
            this.f36574b = bVar;
            this.f36575c = new WeakHashMap<>();
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{weakReference, view, str, Boolean.valueOf(z)}) == null) {
                View.AccessibilityDelegate a = a(view);
                if (!(a instanceof C1833a)) {
                    C1833a c1833a = new C1833a(this, weakReference, view, str, a, z);
                    view.setAccessibilityDelegate(c1833a);
                    this.f36575c.put(view, c1833a);
                    return;
                }
                ((C1833a) a).a(z);
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
            WeakHashMap<View, C1833a> weakHashMap;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakHashMap = this.f36575c) == null) {
                return;
            }
            for (Map.Entry<View, C1833a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.f36575c.clear();
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public bk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
