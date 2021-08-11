package c.b.c.b.h.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Application f31319a;

    /* renamed from: b  reason: collision with root package name */
    public Context f31320b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f31321c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f31322d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f31323e;

    /* renamed from: f  reason: collision with root package name */
    public List<Long> f31324f;

    /* renamed from: g  reason: collision with root package name */
    public String f31325g;

    /* renamed from: h  reason: collision with root package name */
    public long f31326h;

    /* renamed from: i  reason: collision with root package name */
    public String f31327i;

    /* renamed from: j  reason: collision with root package name */
    public long f31328j;
    public String k;
    public long l;
    public String m;
    public long n;
    public String o;
    public long p;
    public int q;
    public final Application.ActivityLifecycleCallbacks r;

    /* loaded from: classes4.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f31329e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31329e = bVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                this.f31329e.f31325g = activity.getClass().getName();
                this.f31329e.f31326h = System.currentTimeMillis();
                this.f31329e.f31321c.add(this.f31329e.f31325g);
                this.f31329e.f31322d.add(Long.valueOf(this.f31329e.f31326h));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                String name = activity.getClass().getName();
                int indexOf = this.f31329e.f31321c.indexOf(name);
                if (indexOf > -1 && indexOf < this.f31329e.f31321c.size()) {
                    this.f31329e.f31321c.remove(indexOf);
                    this.f31329e.f31322d.remove(indexOf);
                }
                this.f31329e.f31323e.add(name);
                this.f31329e.f31324f.add(Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                this.f31329e.m = activity.getClass().getName();
                this.f31329e.n = System.currentTimeMillis();
                b.v(this.f31329e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                this.f31329e.k = activity.getClass().getName();
                this.f31329e.l = System.currentTimeMillis();
                b.r(this.f31329e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                this.f31329e.f31327i = activity.getClass().getName();
                this.f31329e.f31328j = System.currentTimeMillis();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                this.f31329e.o = activity.getClass().getName();
                this.f31329e.p = System.currentTimeMillis();
            }
        }
    }

    public b(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31321c = new ArrayList();
        this.f31322d = new ArrayList();
        this.f31323e = new ArrayList();
        this.f31324f = new ArrayList();
        this.r = new a(this);
        this.f31320b = context;
        if (context instanceof Application) {
            this.f31319a = (Application) context;
        }
        m();
    }

    public static /* synthetic */ int r(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int v(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 - 1;
        return i2;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("last_create_activity", e(this.f31325g, this.f31326h));
                jSONObject.put("last_start_activity", e(this.f31327i, this.f31328j));
                jSONObject.put("last_resume_activity", e(this.k, this.l));
                jSONObject.put("last_pause_activity", e(this.m, this.n));
                jSONObject.put("last_stop_activity", e(this.o, this.p));
                jSONObject.put("alive_activities", q());
                jSONObject.put("finish_activities", u());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject e(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("time", j2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLJ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: Exception -> 0x007b, TryCatch #1 {Exception -> 0x007b, blocks: (B:5:0x0009, B:8:0x0016, B:11:0x001e, B:12:0x0022, B:14:0x0028, B:16:0x0030, B:19:0x0035), top: B:30:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray i() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                activityManager = (ActivityManager) this.f31320b.getSystemService("activity");
            } catch (Exception unused) {
            }
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
                return jSONArray;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null) {
                    if (runningTaskInfo.baseActivity != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", runningTaskInfo.id);
                            jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                            jSONObject.put("description", runningTaskInfo.description);
                            jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                            jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                            jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                            jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused2) {
                        }
                    }
                    while (r1.hasNext()) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final void m() {
        Application application;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 14 || (application = this.f31319a) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this.r);
    }

    public final JSONArray q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.f31321c;
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < this.f31321c.size(); i2++) {
                    try {
                        jSONArray.put(e(this.f31321c.get(i2), this.f31322d.get(i2).longValue()));
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final JSONArray u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.f31323e;
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < this.f31323e.size(); i2++) {
                    try {
                        jSONArray.put(e(this.f31323e.get(i2), this.f31324f.get(i2).longValue()));
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }
}
