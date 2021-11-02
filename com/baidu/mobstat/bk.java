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
/* loaded from: classes7.dex */
public abstract class bk implements bi.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public bi f41178a;

    @TargetApi(14)
    /* loaded from: classes7.dex */
    public static class a extends bk {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Activity> f41179a;

        /* renamed from: b  reason: collision with root package name */
        public b f41180b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakHashMap<View, C1644a> f41181c;

        /* renamed from: com.baidu.mobstat.bk$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1644a extends View.AccessibilityDelegate {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f41182a;

            /* renamed from: b  reason: collision with root package name */
            public View.AccessibilityDelegate f41183b;

            /* renamed from: c  reason: collision with root package name */
            public View f41184c;

            /* renamed from: d  reason: collision with root package name */
            public volatile boolean f41185d;

            public C1644a(a aVar, WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
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
                this.f41182a = aVar;
                this.f41183b = accessibilityDelegate;
                aVar.f41179a = weakReference;
                this.f41184c = view;
                this.f41185d = z;
            }

            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f41185d = z;
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i2) {
                Activity activity;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
                    if (view == this.f41184c && i2 == 1) {
                        if (bd.c().b() && this.f41185d) {
                            bd c2 = bd.c();
                            c2.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (bh.c().b()) {
                            bh c3 = bh.c();
                            c3.a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (this.f41182a.f41179a != null && (activity = (Activity) this.f41182a.f41179a.get()) != null) {
                            this.f41182a.f41180b.a(view, this.f41185d, activity);
                        }
                    }
                    View.AccessibilityDelegate accessibilityDelegate = this.f41183b;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41183b : (View.AccessibilityDelegate) invokeV.objValue;
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
            this.f41179a = weakReference;
            this.f41180b = bVar;
            this.f41181c = new WeakHashMap<>();
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{weakReference, view, str, Boolean.valueOf(z)}) == null) {
                View.AccessibilityDelegate a2 = a(view);
                if (!(a2 instanceof C1644a)) {
                    C1644a c1644a = new C1644a(this, weakReference, view, str, a2, z);
                    view.setAccessibilityDelegate(c1644a);
                    this.f41181c.put(view, c1644a);
                    return;
                }
                ((C1644a) a2).a(z);
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
                a(this.f41179a, view, bj.a(view), z);
            }
        }

        @Override // com.baidu.mobstat.bk
        public void a() {
            WeakHashMap<View, C1644a> weakHashMap;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakHashMap = this.f41181c) == null) {
                return;
            }
            for (Map.Entry<View, C1644a> entry : weakHashMap.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.f41181c.clear();
        }
    }

    /* loaded from: classes7.dex */
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
            if (this.f41178a == null) {
                bi biVar = new bi(activity, this, z);
                this.f41178a = biVar;
                biVar.a(jSONObject);
            }
            this.f41178a.a(activity);
        }
    }
}
