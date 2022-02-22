package c.a.d.f.n.n;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.i;
import c.a.d.f.p.l;
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
    public static b f2129f;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.f.n.d a;

    /* renamed from: b  reason: collision with root package name */
    public String f2130b;

    /* renamed from: c  reason: collision with root package name */
    public String f2131c;

    /* renamed from: d  reason: collision with root package name */
    public C0050b f2132d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f2133e;

    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                this.a.f();
            }
        }
    }

    /* renamed from: c.a.d.f.n.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0050b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b this$0;

        public C0050b(b bVar) {
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
            this.this$0.q(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }

        public /* synthetic */ C0050b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.d.f.n.j.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f2134b;

        public c(@NonNull b bVar, c.a.d.f.n.j.a aVar) {
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
            this.f2134b = bVar;
            this.a = null;
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d(this.a);
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
                this.a.J(false);
            }
        }

        public final void d(c.a.d.f.n.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                try {
                    BdUploadingLogInfo b2 = c.a.d.f.n.n.c.b(aVar);
                    int size = b2.size();
                    if (b2 == null || size <= 0) {
                        return;
                    }
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        ArrayList<String> trackLogStringByIndex = b2.getTrackLogStringByIndex(i2);
                        if (trackLogStringByIndex != null && trackLogStringByIndex.size() != 0) {
                            this.f2134b.i(aVar, trackLogStringByIndex, b2.get(i2));
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
        public c.a.d.f.n.j.a a;

        /* renamed from: b  reason: collision with root package name */
        public String f2135b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f2136c;

        public d(b bVar, c.a.d.f.n.j.a aVar, String str) {
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
            this.f2136c = bVar;
            this.a = aVar;
            this.f2135b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String e2 = c.a.d.f.n.n.d.e(this.a, this.f2136c.a);
                String str = this.f2135b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                BdLog.i("commonHeader = " + e2);
                BdLog.i("cache = " + str);
                this.a.d();
                this.f2136c.h(this.a, e2, arrayList, null, true);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.d.f.n.j.a a;

        /* renamed from: b  reason: collision with root package name */
        public String f2137b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f2138c;

        public e(b bVar, c.a.d.f.n.j.a aVar, String str) {
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
            this.f2138c = bVar;
            this.a = aVar;
            this.f2137b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String str = this.f2137b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.a.f();
                this.f2138c.i(this.a, arrayList, null);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.d.f.n.j.a a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f2139b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2140c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2141d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2142e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f2143f;

        public f(b bVar, c.a.d.f.n.j.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
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
            this.f2143f = bVar;
            this.a = null;
            this.f2139b = null;
            this.f2140c = false;
            this.f2141d = false;
            this.f2142e = false;
            this.a = aVar;
            this.f2139b = arrayList;
            this.f2140c = z;
            this.f2141d = z2;
            this.f2142e = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d(this.a, this.f2140c, this.f2141d, this.f2142e);
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
                this.a.K(false);
            }
        }

        public final void d(c.a.d.f.n.j.a aVar, boolean z, boolean z2, boolean z3) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                try {
                    String e2 = c.a.d.f.n.n.d.e(aVar, this.f2143f.a);
                    BdUploadingLogInfo b2 = c.a.d.f.n.n.a.b(aVar, z2);
                    int size = b2.size();
                    if (b2 == null || size <= 0) {
                        return;
                    }
                    if (!z) {
                        int i3 = 0;
                        while (i3 < size) {
                            ArrayList<String> logStringByIndex = b2.getLogStringByIndex(i3, this.f2139b);
                            if (logStringByIndex != null && logStringByIndex.size() != 0) {
                                if (!z2) {
                                    i2 = i3;
                                    this.f2143f.h(aVar, e2, logStringByIndex, b2.get(i2), z3);
                                } else {
                                    ArrayList<c.a.d.f.n.j.d> arrayList = b2.get(i3);
                                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                        if (arrayList.get(i4).f2116b.contains("notUpload/")) {
                                            arrayList.get(i4).f2116b = arrayList.get(i4).f2116b.replace("notUpload/", "");
                                        }
                                    }
                                    i2 = i3;
                                    this.f2143f.h(aVar, e2, logStringByIndex, arrayList, z3);
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
                        ArrayList<String> logStringByIndex2 = b2.getLogStringByIndex(i6, this.f2139b);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (!l.H() && (i5 = i5 + logStringByIndex2.toString().length()) > 102400) {
                                return;
                            }
                            int i7 = i5;
                            if (!z2) {
                                this.f2143f.h(aVar, e2, logStringByIndex2, b2.get(i6), z3);
                            } else {
                                ArrayList<c.a.d.f.n.j.d> arrayList2 = b2.get(i6);
                                for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                                    if (arrayList2.get(i8).f2116b.contains("notUpload/")) {
                                        arrayList2.get(i8).f2116b = arrayList2.get(i8).f2116b.replace("notUpload/", "");
                                    }
                                }
                                this.f2143f.h(aVar, e2, logStringByIndex2, arrayList2, z3);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1912691371, "Lc/a/d/f/n/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1912691371, "Lc/a/d/f/n/n/b;");
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
        this.f2133e = new a(this, 2000994);
    }

    public static b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (f2129f == null) {
                synchronized (b.class) {
                    if (f2129f == null) {
                        f2129f = new b();
                    }
                }
            }
            return f2129f;
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
            this.a.o = c.a.d.f.n.e.a(BdBaseApplication.getInst());
            this.a.p = String.valueOf(l.I());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(String str, c.a.d.f.n.j.a aVar, String str2, ArrayList<String> arrayList, ArrayList<c.a.d.f.n.j.d> arrayList2, boolean z, boolean z2) {
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
                            i.b(l, byteArrayOutputStream);
                            bArr = byteArrayOutputStream.toByteArray();
                            c.a.d.f.m.a.d(byteArrayOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e);
                            c.a.d.f.m.a.d(byteArrayOutputStream);
                            bArr = null;
                            if (bArr != null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        c.a.d.f.m.a.d(byteArrayOutputStream2);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    c.a.d.f.m.a.d(byteArrayOutputStream2);
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
                                c.a.d.f.j.b.f fVar = new c.a.d.f.j.b.f();
                                String str4 = this.f2130b;
                                if (z2 && str4.contains("c.tieba.baidu.com")) {
                                    str4 = str4.replace("c.tieba.baidu.com", "123.125.115.120");
                                    fVar.b().a("Host", "c.tieba.baidu.com");
                                }
                                fVar.b().t(str4);
                                fVar.b().r(HttpMessageTask.HTTP_METHOD.POST);
                                HashMap<String, Object> f2 = c.a.d.f.n.n.d.f(str4, this.a, z);
                                if (f2 != null) {
                                    fVar.b().s(new ArrayList(f2.entrySet()));
                                }
                                hashMap.clear();
                                hashMap.put("pf", bArr);
                                arrayList3.clear();
                                arrayList3.addAll(hashMap.entrySet());
                                fVar.b().s(arrayList3);
                                try {
                                    new c.a.d.f.j.b.c(fVar).n(3, -1, -1);
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
                c.a.d.f.j.b.f fVar2 = new c.a.d.f.j.b.f();
                if (z2 && str3.contains("c.tieba.baidu.com")) {
                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                    fVar2.b().a("Host", "c.tieba.baidu.com");
                }
                fVar2.b().t(str3);
                fVar2.b().r(HttpMessageTask.HTTP_METHOD.POST);
                HashMap<String, Object> f3 = c.a.d.f.n.n.d.f(str3, this.a, z);
                if (f3 != null) {
                    fVar2.b().s(new ArrayList(f3.entrySet()));
                }
                fVar2.b().s(arrayList3);
                try {
                    new c.a.d.f.j.b.c(fVar2).n(3, -1, -1);
                    int i2 = fVar2.c().f1997b;
                    byte[] bArr2 = fVar2.c().f2003h;
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
                    List<c.a.d.f.j.b.e> d2 = fVar2.d();
                    if (d2 != null && d2.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < d2.size(); i3++) {
                            c.a.d.f.j.b.e eVar = d2.get(i3);
                            if (eVar != null && !TextUtils.isEmpty(eVar.f1984h)) {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(eVar.f1984h);
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

    public final void h(c.a.d.f.n.j.a aVar, String str, ArrayList<String> arrayList, ArrayList<c.a.d.f.n.j.d> arrayList2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{aVar, str, arrayList, arrayList2, Boolean.valueOf(z)}) == null) && g(this.f2130b, aVar, str, arrayList, arrayList2, z, false) != null && l.z()) {
            String g2 = g(this.f2130b, aVar, str, arrayList, arrayList2, z, true);
            if (g2 == null) {
                c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            c.a.d.f.n.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
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
    public final boolean i(c.a.d.f.n.j.a aVar, ArrayList<String> arrayList, ArrayList<c.a.d.f.n.j.d> arrayList2) {
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
                        i.b(k, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                        c.a.d.f.m.a.d(byteArrayOutputStream);
                        if (bArr != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    c.a.d.f.m.a.d(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.d.f.m.a.d(byteArrayOutputStream2);
                throw th;
            }
            c.a.d.f.m.a.d(byteArrayOutputStream);
            if (bArr != null) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(aVar.q(), bArr);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            c.a.d.f.j.b.f fVar = new c.a.d.f.j.b.f();
            fVar.b().a("Host", "c.tieba.baidu.com");
            fVar.b().t(this.f2131c);
            fVar.b().r(HttpMessageTask.HTTP_METHOD.POST);
            HashMap<String, Object> f2 = c.a.d.f.n.n.d.f(this.f2131c, this.a, false);
            if (f2 != null) {
                fVar.b().s(new ArrayList(f2.entrySet()));
            }
            fVar.b().s(arrayList3);
            try {
                new c.a.d.f.j.b.c(fVar).n(3, -1, -1);
                if (fVar.c().f1997b == 200) {
                    try {
                        if (new JSONObject(new String(fVar.c().f2003h, "utf-8")).optString("error_code").equals("0")) {
                            ArrayList arrayList4 = new ArrayList();
                            Iterator<c.a.d.f.n.j.d> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                arrayList4.add(it.next().f2116b);
                            }
                            if (arrayList4.size() > 0) {
                                c.a.d.f.n.j.c.a(arrayList4, aVar.C());
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

    public final void j(ArrayList<c.a.d.f.n.j.d> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, arrayList, z) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<c.a.d.f.n.j.d> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().f2116b);
        }
        if (arrayList2.size() > 0) {
            c.a.d.f.n.j.b.a(arrayList2, z);
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
                        sb.append(com.alipay.sdk.encrypt.a.f31099h);
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

    public void n(c.a.d.f.n.d dVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, str, str2) == null) {
            this.f2130b = str;
            this.f2131c = str2;
            this.a = dVar;
            if (dVar != null) {
                dVar.k = Build.MODEL;
                dVar.q = Build.VERSION.RELEASE;
                dVar.o = c.a.d.f.n.e.a(BdBaseApplication.getInst());
                this.a.p = String.valueOf(l.I());
            }
            try {
                MessageManager.getInstance().registerListener(this.f2133e);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f2132d == null) {
                this.f2132d = new C0050b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f2132d, intentFilter);
            }
        }
    }

    public void o(String str) {
        c.a.d.f.n.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (dVar = this.a) == null) {
            return;
        }
        dVar.f2083g = str;
    }

    public void p(String str) {
        c.a.d.f.n.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (dVar = this.a) == null) {
            return;
        }
        dVar.f2084h = str;
    }

    public void q(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            if (this.a.l == null && str == null) {
                return;
            }
            String str4 = this.a.l;
            if (str4 == null || !str4.equals(str)) {
                c.a.d.f.n.d dVar = this.a;
                dVar.l = str;
                dVar.m = str2;
                dVar.n = str3;
            }
        }
    }

    public void r(c.a.d.f.n.j.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, aVar, str) == null) {
            new d(this, aVar, str).execute(new Object[0]);
        }
    }

    public void s(c.a.d.f.n.j.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, aVar, str) == null) {
            new e(this, aVar, str).execute(new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(c.a.d.f.n.j.a aVar, boolean z, boolean z2, boolean z3) {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || !BdStatisticsManager.getInstance().isMainProcess() || aVar == null) {
            return;
        }
        ArrayList<String> n = c.a.d.f.n.m.a.o().n(aVar.o());
        ArrayList arrayList2 = null;
        if (!z) {
            boolean x = c.a.d.f.n.m.a.o().x(aVar.o(), null);
            boolean H = l.H();
            if (x && !H) {
                return;
            }
            if (n != null && n.size() > 0) {
                arrayList = new ArrayList<>();
                Iterator<String> it = n.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!c.a.d.f.n.m.a.o().u(aVar.o(), next)) {
                        e(arrayList, next);
                    } else if (!c.a.d.f.n.m.a.o().B(aVar.o(), next)) {
                        e(arrayList, next);
                    } else {
                        boolean x2 = c.a.d.f.n.m.a.o().x(aVar.o(), next);
                        boolean H2 = l.H();
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
                                arrayList2.add("st=" + URLEncoder.encode(c.a.d.f.n.a.i(next2), "utf-8") + "&");
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

    public void u(c.a.d.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || aVar.B()) {
            return;
        }
        aVar.J(true);
        new c(this, aVar).execute(new Object[0]);
    }
}
