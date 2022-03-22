package c.a.a0.j.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.a0.j.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.a0.j.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final c.a.a0.j.d.a f1278f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, C0034b> f1279g;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-747416636, "Lc/a/a0/j/f/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-747416636, "Lc/a/a0/j/f/b$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadStatus.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: c.a.a0.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f1280b;

        public C0034b() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.a0.j.d.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.a0.j.d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1279g = new HashMap<>();
        this.f1278f = aVar;
        this.f1274c = new f(this);
    }

    public void A(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str5 = str + "_" + str4 + "_" + str3 + "_" + str2;
        this.f1279g.remove(str5);
        C0034b c0034b = new C0034b();
        c0034b.f1280b = str;
        c0034b.a = str2;
        this.f1279g.put(str5, c0034b);
    }

    public void B(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        this.f1279g.remove(str + "_" + str4 + "_" + str3 + "_" + str2);
    }

    @NonNull
    public c.a.a0.j.d.a w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1278f : (c.a.a0.j.d.a) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = a.a[this.f1278f.f1246c.ordinal()];
            if (i == 1) {
                c.a.a0.j.d.a aVar = this.f1278f;
                aVar.i = 0.0f;
                aVar.j = 0.0f;
                return "0";
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return i != 5 ? "0" : "4";
                    }
                    c.a.a0.j.d.a aVar2 = this.f1278f;
                    aVar2.i = 1.0f;
                    aVar2.j = 1.0f;
                    return "3";
                }
                return "2";
            } else {
                return "1";
            }
        }
        return (String) invokeV.objValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q(this.f1274c);
        }
    }

    public void z(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            c.a.a0.j.d.e eVar = new c.a.a0.j.d.e();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            String a2 = c.a.a0.j.i.b.a(str, str2, str3, str4);
            c.a.a0.x.b.e(jSONObject, "status", "0");
            c.a.a0.x.b.e(jSONObject, "message", "");
            c.a.a0.x.b.e(jSONObject, "data", a2);
            for (String str5 : this.f1279g.keySet()) {
                C0034b c0034b = (C0034b) c.a.a0.x.c.b(this.f1279g, str5);
                if (c0034b != null && !TextUtils.isEmpty(c0034b.a)) {
                    e.a aVar = new e.a();
                    aVar.f1268b = c0034b.f1280b;
                    aVar.a = c0034b.a;
                    aVar.f1269c = jSONObject.toString();
                    c.a.a0.x.a.b(arrayList, aVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            eVar.a = arrayList;
            c.a.a0.k.e.a().a(eVar);
        }
    }
}
