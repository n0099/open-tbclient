package c.a.u.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f30137c;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f30138d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.u.a.a.a f30139a;

    /* renamed from: b  reason: collision with root package name */
    public f f30140b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f30141e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f30142f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f30143g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f30144h;

        public a(d dVar, Context context, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30144h = dVar;
            this.f30141e = context;
            this.f30142f = str;
            this.f30143g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30144h.j(this.f30141e, this.f30142f, this.f30143g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements IMPushUploadResponseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f30145a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f30146b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f30147c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f30148d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f30149e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f30150e;

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
                this.f30150e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f30150e;
                    bVar.f30149e.g(bVar.f30145a, bVar.f30146b, bVar.f30147c, bVar.f30148d);
                }
            }
        }

        public b(d dVar, Context context, String str, List list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context, str, list, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30149e = dVar;
            this.f30145a = context;
            this.f30146b = str;
            this.f30147c = list;
            this.f30148d = i2;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                d.f30138d.set(false);
                if (i2 == 0) {
                    this.f30149e.f30139a.f().execute(new a(this));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1083077133, "Lc/a/u/a/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1083077133, "Lc/a/u/a/a/d;");
                return;
            }
        }
        f30138d = new AtomicBoolean(false);
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30139a = c.a.u.a.a.a.h(context);
        this.f30140b = new f();
    }

    public static d h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (f30137c == null) {
                synchronized (d.class) {
                    if (f30137c == null) {
                        f30137c = new d(context);
                    }
                }
            }
            return f30137c;
        }
        return (d) invokeL.objValue;
    }

    public static Boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Boolean.valueOf(f30138d.get()) : (Boolean) invokeV.objValue;
    }

    public synchronized void e(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, str, i2) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!TextUtils.isEmpty(str) && context != null && RequsetNetworkUtils.isConnected(context) && g.f(context) && g.e(context, Integer.parseInt(str))) {
                    if (this.f30139a != null) {
                        this.f30139a.f().execute(new a(this, context, str, i2));
                    }
                    return;
                }
                c.a.u.a.h.e.a("FlowTrackManager", "flow 无网、参数不对、未命中小流量不上报");
            }
        }
    }

    public void f() {
        c.a.u.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f30139a) == null) {
            return;
        }
        aVar.c();
    }

    public final void g(Context context, String str, List<h> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, str, list, i2) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            if (hVar != null) {
                arrayList.add(hVar.b());
            }
        }
        c.a.u.a.h.e.a("FlowTrackManager", "flow clear上报成功的数据");
        c.a.u.a.d.a.n(context).i(str, arrayList);
        if (c.a.u.a.d.a.n(context).m(str) > 0) {
            j(context, str, i2);
        }
    }

    public final void j(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, context, str, i2) == null) {
            c.a.u.a.h.e.a("FlowTrackManager", "flow begin uplodFlow~~~");
            f30138d.set(true);
            ArrayList arrayList = new ArrayList();
            f fVar = this.f30140b;
            if (fVar != null) {
                byte[] c2 = fVar.c(context, str, arrayList, i2);
                if (c2 != null && arrayList.size() > 0) {
                    if (c2.length >= 307200) {
                        c.a.u.a.h.e.a("FlowTrackManager", "flow 上报数据长度超过300k");
                        f30138d.set(false);
                        return;
                    }
                    IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new b(this, context, str, arrayList, i2));
                    return;
                }
                c.a.u.a.h.e.a("FlowTrackManager", "flow 上报数据为空");
                f30138d.set(false);
            }
        }
    }
}
