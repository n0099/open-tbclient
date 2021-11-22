package b.a.e.f.n.n;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.g;
import b.a.e.f.p.j;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f1963f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.f.n.d f1964a;

    /* renamed from: b  reason: collision with root package name */
    public String f1965b;

    /* renamed from: c  reason: collision with root package name */
    public String f1966c;

    /* renamed from: d  reason: collision with root package name */
    public C0031b f1967d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f1968e;

    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f1969a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1969a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                this.f1969a.f();
            }
        }
    }

    /* renamed from: b.a.e.f.n.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0031b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b this$0;

        public C0031b(b bVar) {
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
            this.this$0 = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            this.this$0.o(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }

        public /* synthetic */ C0031b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.e.f.n.j.a f1970a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f1971b;

        public c(@NonNull b bVar, b.a.e.f.n.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1971b = bVar;
            this.f1970a = null;
            this.f1970a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d(this.f1970a);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.f1970a.J(false);
            }
        }

        public final void d(b.a.e.f.n.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                try {
                    BdUploadingLogInfo b2 = b.a.e.f.n.n.c.b(aVar);
                    int size = b2.size();
                    if (b2 == null || size <= 0) {
                        return;
                    }
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        ArrayList<String> trackLogStringByIndex = b2.getTrackLogStringByIndex(i2);
                        if (trackLogStringByIndex != null && trackLogStringByIndex.size() != 0) {
                            this.f1971b.i(aVar, trackLogStringByIndex, b2.get(i2));
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.e.f.n.j.a f1972a;

        /* renamed from: b  reason: collision with root package name */
        public String f1973b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f1974c;

        public d(b bVar, b.a.e.f.n.j.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1974c = bVar;
            this.f1972a = aVar;
            this.f1973b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String e2 = b.a.e.f.n.n.d.e(this.f1972a, this.f1974c.f1964a);
                String str = this.f1973b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                BdLog.i("commonHeader = " + e2);
                BdLog.i("cache = " + str);
                this.f1972a.d();
                this.f1974c.h(this.f1972a, e2, arrayList, null, true);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.e.f.n.j.a f1975a;

        /* renamed from: b  reason: collision with root package name */
        public String f1976b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f1977c;

        public e(b bVar, b.a.e.f.n.j.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1977c = bVar;
            this.f1975a = aVar;
            this.f1976b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String str = this.f1976b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.f1975a.f();
                this.f1977c.i(this.f1975a, arrayList, null);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.e.f.n.j.a f1978a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f1979b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1980c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1981d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f1983f;

        public f(b bVar, b.a.e.f.n.j.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1983f = bVar;
            this.f1978a = null;
            this.f1979b = null;
            this.f1980c = false;
            this.f1981d = false;
            this.f1982e = false;
            this.f1978a = aVar;
            this.f1979b = arrayList;
            this.f1980c = z;
            this.f1981d = z2;
            this.f1982e = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d(this.f1978a, this.f1980c, this.f1981d, this.f1982e);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.f1978a.K(false);
            }
        }

        public final void d(b.a.e.f.n.j.a aVar, boolean z, boolean z2, boolean z3) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                try {
                    String e2 = b.a.e.f.n.n.d.e(aVar, this.f1983f.f1964a);
                    BdUploadingLogInfo b2 = b.a.e.f.n.n.a.b(aVar, z2);
                    int size = b2.size();
                    if (b2 == null || size <= 0) {
                        return;
                    }
                    if (!z) {
                        int i3 = 0;
                        while (i3 < size) {
                            ArrayList<String> logStringByIndex = b2.getLogStringByIndex(i3, this.f1979b);
                            if (logStringByIndex != null && logStringByIndex.size() != 0) {
                                if (!z2) {
                                    i2 = i3;
                                    this.f1983f.h(aVar, e2, logStringByIndex, b2.get(i2), z3);
                                } else {
                                    ArrayList<b.a.e.f.n.j.d> arrayList = b2.get(i3);
                                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                        if (arrayList.get(i4).f1947b.contains("notUpload/")) {
                                            arrayList.get(i4).f1947b = arrayList.get(i4).f1947b.replace("notUpload/", "");
                                        }
                                    }
                                    i2 = i3;
                                    this.f1983f.h(aVar, e2, logStringByIndex, arrayList, z3);
                                }
                                i3 = i2 + 1;
                            }
                            i2 = i3;
                            i3 = i2 + 1;
                        }
                        return;
                    }
                    int i5 = 0;
                    for (int i6 = size - 1; i6 >= 0; i6--) {
                        ArrayList<String> logStringByIndex2 = b2.getLogStringByIndex(i6, this.f1979b);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (!j.H() && (i5 = i5 + logStringByIndex2.toString().length()) > 102400) {
                                return;
                            }
                            int i7 = i5;
                            if (!z2) {
                                this.f1983f.h(aVar, e2, logStringByIndex2, b2.get(i6), z3);
                            } else {
                                ArrayList<b.a.e.f.n.j.d> arrayList2 = b2.get(i6);
                                for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                                    if (arrayList2.get(i8).f1947b.contains("notUpload/")) {
                                        arrayList2.get(i8).f1947b = arrayList2.get(i8).f1947b.replace("notUpload/", "");
                                    }
                                }
                                this.f1983f.h(aVar, e2, logStringByIndex2, arrayList2, z3);
                            }
                            i5 = i7;
                        }
                    }
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1603646251, "Lb/a/e/f/n/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1603646251, "Lb/a/e/f/n/n/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1968e = new a(this, 2000994);
    }

    public static b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f1963f == null) {
                synchronized (b.class) {
                    if (f1963f == null) {
                        f1963f = new b();
                    }
                }
            }
            return f1963f;
        }
        return (b) invokeV.objValue;
    }

    public final void e(ArrayList<String> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.contains(str)) {
            return;
        }
        arrayList.add(str);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1964a.o = b.a.e.f.n.e.a(BdBaseApplication.getInst());
            this.f1964a.p = String.valueOf(j.I());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(String str, b.a.e.f.n.j.a aVar, String str2, ArrayList<String> arrayList, ArrayList<b.a.e.f.n.j.d> arrayList2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        byte[] l;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, aVar, str2, arrayList, arrayList2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str3 = str;
            if (str3 != null && aVar != null && (l = l(str2, arrayList)) != null && l.length > 0) {
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(l.length / 2);
                    try {
                        try {
                            g.b(l, byteArrayOutputStream);
                            bArr = byteArrayOutputStream.toByteArray();
                            b.a.e.f.m.a.d(byteArrayOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e);
                            b.a.e.f.m.a.d(byteArrayOutputStream);
                            bArr = null;
                            if (bArr != null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        b.a.e.f.m.a.d(byteArrayOutputStream2);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    b.a.e.f.m.a.d(byteArrayOutputStream2);
                    throw th;
                }
                if (bArr != null) {
                    return "";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(aVar.p(), bArr);
                ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
                if (aVar != null) {
                    try {
                        if (aVar.o().equals("pfmonitor") && BdStatisticsSwitchStatic.isOn()) {
                            try {
                                b.a.e.f.j.a.e eVar = new b.a.e.f.j.a.e();
                                String str4 = this.f1965b;
                                if (z2 && str4.contains("c.tieba.baidu.com")) {
                                    str4 = str4.replace("c.tieba.baidu.com", "123.125.115.120");
                                    eVar.b().a("Host", "c.tieba.baidu.com");
                                }
                                eVar.b().s(str4);
                                eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
                                HashMap<String, Object> f2 = b.a.e.f.n.n.d.f(this.f1964a, z);
                                if (f2 != null) {
                                    eVar.b().r(new ArrayList(f2.entrySet()));
                                }
                                hashMap.clear();
                                hashMap.put("pf", bArr);
                                arrayList3.clear();
                                arrayList3.addAll(hashMap.entrySet());
                                eVar.b().r(arrayList3);
                                try {
                                    new b.a.e.f.j.a.c(eVar).n(3, -1, -1);
                                } catch (Exception e4) {
                                    BdLog.detailException(e4);
                                }
                                j(arrayList2, aVar.E());
                                return null;
                            } catch (Exception e5) {
                                BdLog.e(e5);
                                return e5.getMessage();
                            }
                        }
                    } catch (Exception e6) {
                        BdLog.e(e6);
                        return e6.getMessage();
                    }
                }
                b.a.e.f.j.a.e eVar2 = new b.a.e.f.j.a.e();
                if (z2 && str3.contains("c.tieba.baidu.com")) {
                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                    eVar2.b().a("Host", "c.tieba.baidu.com");
                }
                eVar2.b().s(str3);
                eVar2.b().q(HttpMessageTask.HTTP_METHOD.POST);
                HashMap<String, Object> f3 = b.a.e.f.n.n.d.f(this.f1964a, z);
                if (f3 != null) {
                    eVar2.b().r(new ArrayList(f3.entrySet()));
                }
                eVar2.b().r(arrayList3);
                try {
                    new b.a.e.f.j.a.c(eVar2).n(3, -1, -1);
                    int i2 = eVar2.c().f1809b;
                    byte[] bArr2 = eVar2.c().f1815h;
                    if (bArr2 != null && i2 == 200) {
                        try {
                            if (new JSONObject(new String(bArr2, "utf-8")).optInt("error_code", -1) == 0) {
                                j(arrayList2, aVar.E());
                                return null;
                            }
                        } catch (Exception e7) {
                            BdLog.e(e7);
                            return e7.getMessage();
                        }
                    }
                    List<b.a.e.f.j.a.d> d2 = eVar2.d();
                    if (d2 != null && d2.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < d2.size(); i3++) {
                            b.a.e.f.j.a.d dVar = d2.get(i3);
                            if (dVar != null && !TextUtils.isEmpty(dVar.f1795h)) {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(dVar.f1795h);
                            }
                        }
                        if (sb.length() > 0) {
                            return sb.toString();
                        }
                    }
                } catch (Exception e8) {
                    BdLog.detailException(e8);
                    return e8.getMessage();
                }
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public final void h(b.a.e.f.n.j.a aVar, String str, ArrayList<String> arrayList, ArrayList<b.a.e.f.n.j.d> arrayList2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{aVar, str, arrayList, arrayList2, Boolean.valueOf(z)}) == null) && g(this.f1965b, aVar, str, arrayList, arrayList2, z, false) != null && j.z()) {
            String g2 = g(this.f1965b, aVar, str, arrayList, arrayList2, z, true);
            if (g2 == null) {
                b.a.e.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            b.a.e.f.n.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.b("issuc", "false");
            statsItem2.b("reason", g2);
            BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(b.a.e.f.n.j.a aVar, ArrayList<String> arrayList, ArrayList<b.a.e.f.n.j.d> arrayList2) {
        InterceptResult invokeLLL;
        byte[] k;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, aVar, arrayList, arrayList2)) == null) {
            if (aVar == null || arrayList == null || arrayList.isEmpty() || (k = k(arrayList)) == null || k.length == 0) {
                return false;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            byte[] bArr = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(k.length / 2);
                try {
                    try {
                        g.b(k, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                        b.a.e.f.m.a.d(byteArrayOutputStream);
                        if (bArr != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    b.a.e.f.m.a.d(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                b.a.e.f.m.a.d(byteArrayOutputStream2);
                throw th;
            }
            b.a.e.f.m.a.d(byteArrayOutputStream);
            if (bArr != null) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(aVar.q(), bArr);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            b.a.e.f.j.a.e eVar = new b.a.e.f.j.a.e();
            eVar.b().a("Host", "c.tieba.baidu.com");
            eVar.b().s(this.f1966c);
            eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
            HashMap<String, Object> f2 = b.a.e.f.n.n.d.f(this.f1964a, false);
            if (f2 != null) {
                eVar.b().r(new ArrayList(f2.entrySet()));
            }
            eVar.b().r(arrayList3);
            try {
                new b.a.e.f.j.a.c(eVar).n(3, -1, -1);
                if (eVar.c().f1809b == 200) {
                    try {
                        if (new JSONObject(new String(eVar.c().f1815h, "utf-8")).optString("error_code").equals("0")) {
                            ArrayList arrayList4 = new ArrayList();
                            Iterator<b.a.e.f.n.j.d> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                arrayList4.add(it.next().f1947b);
                            }
                            if (arrayList4.size() > 0) {
                                b.a.e.f.n.j.c.a(arrayList4, aVar.C());
                                return true;
                            }
                            return true;
                        }
                        return true;
                    } catch (Exception e4) {
                        BdLog.e(e4);
                        return false;
                    }
                }
                return true;
            } catch (Exception e5) {
                BdLog.detailException(e5);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void j(ArrayList<b.a.e.f.n.j.d> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, arrayList, z) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<b.a.e.f.n.j.d> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().f1947b);
        }
        if (arrayList2.size() > 0) {
            b.a.e.f.n.j.b.a(arrayList2, z);
        }
    }

    public final byte[] k(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i2 != 0) {
                            sb.append("&");
                        }
                        sb.append(URLEncoder.encode(arrayList.get(i2), "utf-8"));
                    }
                    return sb.toString().getBytes();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] l(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append("&rec");
                        sb.append(i2);
                        sb.append(com.alipay.sdk.encrypt.a.f34958h);
                        try {
                            sb.append(URLEncoder.encode(arrayList.get(i2), "utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            BdLog.e(e2);
                        }
                    }
                    return sb.toString().getBytes();
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public void n(b.a.e.f.n.d dVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, str, str2) == null) {
            this.f1965b = str;
            this.f1966c = str2;
            this.f1964a = dVar;
            if (dVar != null) {
                dVar.k = Build.MODEL;
                dVar.q = Build.VERSION.RELEASE;
                dVar.o = b.a.e.f.n.e.a(BdBaseApplication.getInst());
                this.f1964a.p = String.valueOf(j.I());
            }
            try {
                MessageManager.getInstance().registerListener(this.f1968e);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f1967d == null) {
                this.f1967d = new C0031b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f1967d, intentFilter);
            }
        }
    }

    public void o(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) {
            if (this.f1964a.l == null && str == null) {
                return;
            }
            String str4 = this.f1964a.l;
            if (str4 == null || !str4.equals(str)) {
                b.a.e.f.n.d dVar = this.f1964a;
                dVar.l = str;
                dVar.m = str2;
                dVar.n = str3;
            }
        }
    }

    public void p(b.a.e.f.n.j.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, aVar, str) == null) {
            new d(this, aVar, str).execute(new Object[0]);
        }
    }

    public void q(b.a.e.f.n.j.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, str) == null) {
            new e(this, aVar, str).execute(new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(b.a.e.f.n.j.a aVar, boolean z, boolean z2, boolean z3) {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048588, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || !BdStatisticsManager.getInstance().isMainProcess() || aVar == null) {
            return;
        }
        ArrayList<String> n = b.a.e.f.n.m.a.o().n(aVar.o());
        ArrayList arrayList2 = null;
        if (!z) {
            boolean x = b.a.e.f.n.m.a.o().x(aVar.o(), null);
            boolean H = j.H();
            if (x && !H) {
                return;
            }
            if (n != null && n.size() > 0) {
                arrayList = new ArrayList<>();
                Iterator<String> it = n.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!b.a.e.f.n.m.a.o().u(aVar.o(), next)) {
                        e(arrayList, next);
                    } else if (!b.a.e.f.n.m.a.o().A(aVar.o(), next)) {
                        e(arrayList, next);
                    } else {
                        boolean x2 = b.a.e.f.n.m.a.o().x(aVar.o(), next);
                        boolean H2 = j.H();
                        if (x2 && !H2) {
                            e(arrayList, next);
                        }
                    }
                }
                if (aVar.D()) {
                    aVar.K(true);
                    if (arrayList != null && arrayList.size() > 0) {
                        arrayList2 = new ArrayList();
                        Iterator<String> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            try {
                                arrayList2.add("st=" + URLEncoder.encode(b.a.e.f.n.a.i(next2), "utf-8") + "&");
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    new f(this, aVar, arrayList2, z, z2, z3).execute(new Object[0]);
                    return;
                }
                return;
            }
        }
        arrayList = null;
        if (aVar.D()) {
        }
    }

    public void s(b.a.e.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar.B()) {
            return;
        }
        aVar.J(true);
        new c(this, aVar).execute(new Object[0]);
    }
}
