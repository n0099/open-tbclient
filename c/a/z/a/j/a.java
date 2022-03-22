package c.a.z.a.j;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f22219h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f22220c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Context> f22221d;

    /* renamed from: e  reason: collision with root package name */
    public String f22222e;

    /* renamed from: f  reason: collision with root package name */
    public File f22223f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22224g;

    /* renamed from: c.a.z.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class AsyncTaskC1639a extends AsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public AsyncTaskC1639a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (a.f22219h == null) {
                    a.f22219h = new JSONObject();
                }
                if (this.a.f22223f != null) {
                    if (this.a.f22224g || !this.a.m()) {
                        if (!this.a.f22223f.isDirectory()) {
                            try {
                                a.f22219h.put("file-del", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            this.a.f22223f.delete();
                        }
                        File file = new File(this.a.f22223f.getAbsoluteFile() + ".loading");
                        boolean a = this.a.f22220c.a(this.a.f22222e, file);
                        if (a) {
                            try {
                                a.f22219h.put("assetsToSD", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            a = file.renameTo(this.a.f22223f);
                        }
                        if (!a) {
                            try {
                                a.f22219h.put("renameTo-del", true);
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                            e.b(file);
                            if (this.a.f22223f.exists()) {
                                e.b(this.a.f22223f);
                            }
                        }
                        try {
                            a.f22219h.put("result", a);
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                        }
                        if (this.a.l()) {
                            i.a("ARSourceCopyManager", "sdk exist + " + a.f22219h.toString());
                        }
                        return Boolean.valueOf(a);
                    }
                    try {
                        a.f22219h.put("exist", true);
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    return Boolean.TRUE;
                }
                try {
                    a.f22219h.put("sdcardPath", StringUtil.NULL_STRING);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                super.onPostExecute(bool);
                this.a.d(bool.booleanValue() ? 2 : 3);
            }
        }
    }

    public a() {
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

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            WeakReference<Context> weakReference = this.f22221d;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    @Override // c.a.z.a.j.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean m = m();
            JSONObject jSONObject = new JSONObject();
            f22219h = jSONObject;
            if (m) {
                try {
                    jSONObject.put("type", c.a.z.a.c.a ? "assets" : "soloader");
                    f22219h.put("exist", m);
                    f22219h.put("path", this.f22223f);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (l()) {
                    i.a("ARSourceCopyManager", "sdk exist + " + f22219h.toString());
                }
                d(2);
            } else if (getContext() != null) {
                try {
                    if (l()) {
                        i.a("ARSourceCopyManager", "sdk loading .. to " + this.f22223f.getAbsoluteFile());
                    }
                    k();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22220c = new c(getContext());
            new AsyncTaskC1639a(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.z.a.b.m() : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = this.f22223f;
            return file != null && file.isDirectory() && this.f22223f.exists();
        }
        return invokeV.booleanValue;
    }
}
