package c.a.n0.i.g.d;

import android.os.Bundle;
import android.text.TextUtils;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.t1.d;
import c.a.n0.i.a.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.gamecenter.network.models.ReservationGameInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.i.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0682a implements c.a.n0.i.f.b<List<ReservationGameInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8558b;

        public C0682a(a aVar, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8558b = aVar;
            this.a = strArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.i.f.b
        /* renamed from: a */
        public void onSuccess(List<ReservationGameInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            ArrayList arrayList2 = new ArrayList(Arrays.asList(this.a));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ReservationGameInfo reservationGameInfo = (ReservationGameInfo) it.next();
                boolean z = reservationGameInfo.auto_download;
                String str = reservationGameInfo.app_id;
                if (z) {
                    String str2 = reservationGameInfo.download_url;
                    String str3 = reservationGameInfo.package_id;
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
                        this.f8558b.e(str2, str3, str);
                        c.a.n0.i.f.a.b().c(str);
                        if (arrayList2.remove(str)) {
                            this.f8558b.f(arrayList2);
                        }
                    }
                } else if (arrayList2.remove(str)) {
                    this.f8558b.f(arrayList2);
                }
            }
        }

        @Override // c.a.n0.i.f.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1479601308, "Lc/a/n0/i/g/d/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1479601308, "Lc/a/n0/i/g/d/a$b;");
                    return;
                }
            }
            a = new a();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.n0.i.a.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
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
                }
            }
        }

        @Override // c.a.n0.i.a.f.b
        public void a(c.a.n0.i.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
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

    public static final a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.n0.a.s0.a.h0().e(c.a.n0.a.s0.a.c())) {
            String string = h.a().getString("reservation_apk_ids", "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String[] split = string.split(",");
            if (split.length == 0) {
                return;
            }
            c.a.n0.i.f.a.b().d(new C0682a(this, split));
        }
    }

    public final void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            if (ProcessUtils.isMainProcess()) {
                c.a.n0.i.a.a.n().H(str, str2, str3, new c(this));
                return;
            }
            c.a.n0.a.o1.c.e.a z = d.J().z();
            if (z != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", str);
                    jSONObject.put("packageName", str2);
                    jSONObject.put("apkId", str3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                Bundle bundle = new Bundle();
                bundle.putString("operation", "startDownload");
                bundle.putString("data", jSONObject.toString());
                bundle.putString("ubc_params", new c.a.n0.i.a.i.a().a());
                z.V(bundle, e.class);
            }
        }
    }

    public final void f(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuffer.append(arrayList.get(i));
                if (i < arrayList.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            h.a().putString("reservation_apk_ids", stringBuffer.toString());
        }
    }
}
