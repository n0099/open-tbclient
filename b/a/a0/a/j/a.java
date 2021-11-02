package b.a.a0.a.j;

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
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f1245h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f1246c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Context> f1247d;

    /* renamed from: e  reason: collision with root package name */
    public String f1248e;

    /* renamed from: f  reason: collision with root package name */
    public File f1249f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1250g;

    /* renamed from: b.a.a0.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class AsyncTaskC0012a extends AsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f1251a;

        public AsyncTaskC0012a(a aVar) {
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
            this.f1251a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (a.f1245h == null) {
                    a.f1245h = new JSONObject();
                }
                if (this.f1251a.f1249f != null) {
                    if (this.f1251a.f1250g || !this.f1251a.m()) {
                        if (!this.f1251a.f1249f.isDirectory()) {
                            try {
                                a.f1245h.put("file-del", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            this.f1251a.f1249f.delete();
                        }
                        File file = new File(this.f1251a.f1249f.getAbsoluteFile() + ".loading");
                        boolean a2 = this.f1251a.f1246c.a(this.f1251a.f1248e, file);
                        if (a2) {
                            try {
                                a.f1245h.put("assetsToSD", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            a2 = file.renameTo(this.f1251a.f1249f);
                        }
                        if (!a2) {
                            try {
                                a.f1245h.put("renameTo-del", true);
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                            e.b(file);
                            if (this.f1251a.f1249f.exists()) {
                                e.b(this.f1251a.f1249f);
                            }
                        }
                        try {
                            a.f1245h.put("result", a2);
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                        }
                        if (this.f1251a.l()) {
                            i.a("ARSourceCopyManager", "sdk exist + " + a.f1245h.toString());
                        }
                        return Boolean.valueOf(a2);
                    }
                    try {
                        a.f1245h.put("exist", true);
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    return Boolean.TRUE;
                }
                try {
                    a.f1245h.put("sdcardPath", StringUtil.NULL_STRING);
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
                this.f1251a.d(bool.booleanValue() ? 2 : 3);
            }
        }
    }

    public a() {
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

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            WeakReference<Context> weakReference = this.f1247d;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    @Override // b.a.a0.a.j.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean m = m();
            JSONObject jSONObject = new JSONObject();
            f1245h = jSONObject;
            if (m) {
                try {
                    jSONObject.put("type", b.a.a0.a.c.f1136a ? "assets" : "soloader");
                    f1245h.put("exist", m);
                    f1245h.put("path", this.f1249f);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (l()) {
                    i.a("ARSourceCopyManager", "sdk exist + " + f1245h.toString());
                }
                d(2);
            } else if (getContext() != null) {
                try {
                    if (l()) {
                        i.a("ARSourceCopyManager", "sdk loading .. to " + this.f1249f.getAbsoluteFile());
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
            this.f1246c = new c(getContext());
            new AsyncTaskC0012a(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.a0.a.b.m() : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = this.f1249f;
            return file != null && file.isDirectory() && this.f1249f.exists();
        }
        return invokeV.booleanValue;
    }
}
