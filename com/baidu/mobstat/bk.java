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
/* loaded from: classes2.dex */
public abstract class bk implements bi.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public bi f8856a;

    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class a extends bk {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Activity> f8857a;

        /* renamed from: b  reason: collision with root package name */
        public b f8858b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakHashMap<View, C0131a> f8859c;

        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0131a extends View.AccessibilityDelegate {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f8860a;

            /* renamed from: b  reason: collision with root package name */
            public View.AccessibilityDelegate f8861b;

            /* renamed from: c  reason: collision with root package name */
            public View f8862c;

            /* renamed from: d  reason: collision with root package name */
            public volatile boolean f8863d;

            public C0131a(a aVar, WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
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
                this.f8860a = aVar;
                this.f8861b = accessibilityDelegate;
                aVar.f8857a = weakReference;
                this.f8862c = view;
                this.f8863d = z;
            }

            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f8863d = z;
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i2) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
                    if (view == this.f8862c && i2 == 1) {
                        if (bd.c().b() && this.f8863d) {
                            bd c2 = bd.c();
                            c2.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (bh.c().b()) {
                            bh c3 = bh.c();
                            c3.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (this.f8860a.f8857a != null && (activity = (Activity) this.f8860a.f8857a.get()) != null) {
                            this.f8860a.f8858b.a(view, this.f8863d, activity);
                        }
                    }
                    View.AccessibilityDelegate accessibilityDelegate = this.f8861b;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8861b : (View.AccessibilityDelegate) invokeV.objValue;
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
            this.f8857a = weakReference;
            this.f8858b = bVar;
            this.f8859c = new WeakHashMap<>();
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{weakReference, view, str, Boolean.valueOf(z)}) == null) {
                View.AccessibilityDelegate a2 = a(view);
                if (!(a2 instanceof C0131a)) {
                    C0131a c0131a = new C0131a(this, weakReference, view, str, a2, z);
                    view.setAccessibilityDelegate(c0131a);
                    this.f8859c.put(view, c0131a);
                    return;
                }
                ((C0131a) a2).a(z);
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
                a(this.f8857a, view, bj.a(view), z);
            }
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            WeakHashMap<View, C0131a> weakHashMap;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakHashMap = this.f8859c) == null) {
                return;
            }
            for (Map.Entry<View, C0131a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.f8859c.clear();
        }
    }

    /* loaded from: classes2.dex */
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
            if (this.f8856a == null) {
                bi biVar = new bi(activity, this, z);
                this.f8856a = biVar;
                biVar.a(jSONObject);
            }
            this.f8856a.a(activity);
        }
    }
}
