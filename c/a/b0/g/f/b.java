package c.a.b0.g.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.b0.g.d.e;
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
public class b extends c.a.b0.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final c.a.b0.g.d.a f1536j;

    /* renamed from: k  reason: collision with root package name */
    public final g f1537k;
    public HashMap<String, C0036b> l;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(817135592, "Lc/a/b0/g/f/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(817135592, "Lc/a/b0/g/f/b$a;");
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

    /* renamed from: c.a.b0.g.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0036b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f1538b;

        public C0036b() {
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
    public b(@NonNull c.a.b0.g.d.a aVar) {
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
                super((c.a.b0.g.d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new HashMap<>();
        this.f1536j = aVar;
        this.f1537k = new f(this);
    }

    public void A(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        this.l.remove(str + "_" + str4 + "_" + str3 + "_" + str2);
    }

    @NonNull
    public c.a.b0.g.d.a v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1536j : (c.a.b0.g.d.a) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = a.a[this.f1536j.f1495c.ordinal()];
            if (i2 == 1) {
                c.a.b0.g.d.a aVar = this.f1536j;
                aVar.f1501i = 0.0f;
                aVar.f1502j = 0.0f;
                return "0";
            } else if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return i2 != 5 ? "0" : "4";
                    }
                    c.a.b0.g.d.a aVar2 = this.f1536j;
                    aVar2.f1501i = 1.0f;
                    aVar2.f1502j = 1.0f;
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
            p(this.f1537k);
        }
    }

    public void y(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) {
            c.a.b0.g.d.e eVar = new c.a.b0.g.d.e();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            String a2 = c.a.b0.g.i.b.a(str, str2, str3, str4);
            c.a.b0.u.b.d(jSONObject, "status", "0");
            c.a.b0.u.b.d(jSONObject, "message", "");
            c.a.b0.u.b.d(jSONObject, "data", a2);
            for (String str5 : this.l.keySet()) {
                C0036b c0036b = (C0036b) c.a.b0.u.c.b(this.l, str5);
                if (c0036b != null && !TextUtils.isEmpty(c0036b.a)) {
                    e.a aVar = new e.a();
                    aVar.f1525b = c0036b.f1538b;
                    aVar.a = c0036b.a;
                    aVar.f1526c = jSONObject.toString();
                    c.a.b0.u.a.b(arrayList, aVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            c.a.b0.h.e.a().a(eVar);
        }
    }

    public void z(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str5 = str + "_" + str4 + "_" + str3 + "_" + str2;
        this.l.remove(str5);
        C0036b c0036b = new C0036b();
        c0036b.f1538b = str;
        c0036b.a = str2;
        this.l.put(str5, c0036b);
    }
}
