package c.a.c0.g.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.c0.g.d.e;
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
public class b extends c.a.c0.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final c.a.c0.g.d.a f1981j;

    /* renamed from: k  reason: collision with root package name */
    public final g f1982k;
    public HashMap<String, C0059b> l;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-979815767, "Lc/a/c0/g/f/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-979815767, "Lc/a/c0/g/f/b$a;");
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

    /* renamed from: c.a.c0.g.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0059b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f1983b;

        public C0059b() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.c0.g.d.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.c0.g.d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new HashMap<>();
        this.f1981j = aVar;
        this.f1982k = new f(this);
    }

    public void A(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        this.l.remove(str + "_" + str4 + "_" + str3 + "_" + str2);
    }

    @NonNull
    public c.a.c0.g.d.a v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1981j : (c.a.c0.g.d.a) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = a.a[this.f1981j.f1940c.ordinal()];
            if (i2 == 1) {
                c.a.c0.g.d.a aVar = this.f1981j;
                aVar.f1946i = 0.0f;
                aVar.f1947j = 0.0f;
                return "0";
            } else if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return i2 != 5 ? "0" : "4";
                    }
                    c.a.c0.g.d.a aVar2 = this.f1981j;
                    aVar2.f1946i = 1.0f;
                    aVar2.f1947j = 1.0f;
                    return "3";
                }
                return "2";
            } else {
                return "1";
            }
        }
        return (String) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            p(this.f1982k);
        }
    }

    public void y(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) {
            c.a.c0.g.d.e eVar = new c.a.c0.g.d.e();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            String a2 = c.a.c0.g.i.b.a(str, str2, str3, str4);
            c.a.c0.u.b.d(jSONObject, "status", "0");
            c.a.c0.u.b.d(jSONObject, "message", "");
            c.a.c0.u.b.d(jSONObject, "data", a2);
            for (String str5 : this.l.keySet()) {
                C0059b c0059b = (C0059b) c.a.c0.u.c.b(this.l, str5);
                if (c0059b != null && !TextUtils.isEmpty(c0059b.a)) {
                    e.a aVar = new e.a();
                    aVar.f1970b = c0059b.f1983b;
                    aVar.a = c0059b.a;
                    aVar.f1971c = jSONObject.toString();
                    c.a.c0.u.a.b(arrayList, aVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            c.a.c0.h.e.a().a(eVar);
        }
    }

    public void z(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str5 = str + "_" + str4 + "_" + str3 + "_" + str2;
        this.l.remove(str5);
        C0059b c0059b = new C0059b();
        c0059b.f1983b = str;
        c0059b.a = str2;
        this.l.put(str5, c0059b);
    }
}
