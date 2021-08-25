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
/* loaded from: classes5.dex */
public abstract class bk implements bi.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public bi f43298a;

    @TargetApi(14)
    /* loaded from: classes5.dex */
    public static class a extends bk {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Activity> f43299a;

        /* renamed from: b  reason: collision with root package name */
        public b f43300b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakHashMap<View, C1683a> f43301c;

        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1683a extends View.AccessibilityDelegate {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f43302a;

            /* renamed from: b  reason: collision with root package name */
            public View.AccessibilityDelegate f43303b;

            /* renamed from: c  reason: collision with root package name */
            public View f43304c;

            /* renamed from: d  reason: collision with root package name */
            public volatile boolean f43305d;

            public C1683a(a aVar, WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
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
                this.f43302a = aVar;
                this.f43303b = accessibilityDelegate;
                aVar.f43299a = weakReference;
                this.f43304c = view;
                this.f43305d = z;
            }

            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f43305d = z;
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i2) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
                    if (view == this.f43304c && i2 == 1) {
                        if (bd.c().b() && this.f43305d) {
                            bd c2 = bd.c();
                            c2.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (bh.c().b()) {
                            bh c3 = bh.c();
                            c3.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (this.f43302a.f43299a != null && (activity = (Activity) this.f43302a.f43299a.get()) != null) {
                            this.f43302a.f43300b.a(view, this.f43305d, activity);
                        }
                    }
                    View.AccessibilityDelegate accessibilityDelegate = this.f43303b;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43303b : (View.AccessibilityDelegate) invokeV.objValue;
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
            this.f43299a = weakReference;
            this.f43300b = bVar;
            this.f43301c = new WeakHashMap<>();
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{weakReference, view, str, Boolean.valueOf(z)}) == null) {
                View.AccessibilityDelegate a2 = a(view);
                if (!(a2 instanceof C1683a)) {
                    C1683a c1683a = new C1683a(this, weakReference, view, str, a2, z);
                    view.setAccessibilityDelegate(c1683a);
                    this.f43301c.put(view, c1683a);
                    return;
                }
                ((C1683a) a2).a(z);
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
                a(this.f43299a, view, bj.a(view), z);
            }
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            WeakHashMap<View, C1683a> weakHashMap;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakHashMap = this.f43301c) == null) {
                return;
            }
            for (Map.Entry<View, C1683a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.f43301c.clear();
        }
    }

    /* loaded from: classes5.dex */
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
            if (this.f43298a == null) {
                bi biVar = new bi(activity, this, z);
                this.f43298a = biVar;
                biVar.a(jSONObject);
            }
            this.f43298a.a(activity);
        }
    }
}
