package c.a.q0.t.j;

import c.a.e.e.p.k;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14973a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f14974b;

    /* renamed from: c  reason: collision with root package name */
    public c f14975c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14976d;

    /* renamed from: c.a.q0.t.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0710a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f14977a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f14978b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f14979c;

        /* renamed from: c.a.q0.t.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0711a implements Comparator<Map.Entry<String, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0711a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? (int) (c.a.e.e.m.b.e(String.valueOf(entry.getValue()), 0) - c.a.e.e.m.b.e(String.valueOf(entry2.getValue()), 0)) : invokeLL.intValue;
            }
        }

        public c(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14979c = aVar;
            this.f14977a = null;
            this.f14978b = null;
            this.f14977a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    this.f14978b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                    String postNetData = this.f14978b.postNetData();
                    if (!this.f14978b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        this.f14979c.f14974b = this.f14979c.j(optString);
                        if (this.f14979c.f14974b == null || this.f14979c.f14974b.size() <= 0) {
                            return null;
                        }
                        HashMap hashMap = new HashMap();
                        int i2 = 0;
                        for (int i3 = 0; i3 < this.f14979c.f14974b.size(); i3++) {
                            String str = (String) this.f14979c.f14974b.get(i3);
                            f fVar = new f();
                            fVar.a(str);
                            if (fVar.d()) {
                                hashMap.put(str, Integer.valueOf(fVar.b()));
                            }
                        }
                        if (hashMap.size() > 0) {
                            this.f14979c.f14974b = new ArrayList();
                            ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                            Collections.sort(arrayList, new C0711a(this));
                            StringBuilder sb = new StringBuilder(50);
                            for (Map.Entry entry : arrayList) {
                                this.f14979c.f14974b.add(entry.getKey());
                                if (i2 != 0) {
                                    sb.append(",");
                                }
                                i2++;
                                sb.append((String) entry.getKey());
                            }
                            optString = sb.toString();
                        }
                        c.a.q0.s.d0.b.j().w("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                        c.a.q0.s.d0.b.j().x("KeyOfSharedPrefIpList", optString);
                        return null;
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.f14979c.f14975c = null;
                b bVar = this.f14977a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f14978b != null) {
                    this.f14978b.cancelNetConnect();
                    this.f14978b = null;
                }
                this.f14979c.f14975c = null;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.f14979c.f14975c = null;
                b bVar = this.f14977a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f14979c.f14975c = null;
                b bVar = this.f14977a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f14980a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(928853764, "Lc/a/q0/t/j/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(928853764, "Lc/a/q0/t/j/a$d;");
                    return;
                }
            }
            f14980a = new a(null);
        }
    }

    public /* synthetic */ a(C0710a c0710a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.f14980a : (a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.q0.s.d0.b.j().k("KeyOfSharedPrefImCount", 0) : invokeV.intValue;
    }

    public List<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f14974b == null) {
                if (System.currentTimeMillis() - c.a.q0.s.d0.b.j().l("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                    c.a.q0.s.d0.b.j().x("KeyOfSharedPrefIpList", "");
                    return null;
                }
                this.f14974b = j(c.a.q0.s.d0.b.j().p("KeyOfSharedPrefIpList", null));
            }
            return this.f14974b;
        }
        return (List) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int e2 = e();
            if (e2 >= 10) {
                c.a.q0.s.d0.b.j().v("KeyOfSharedPrefImCount", 0);
                c.a.q0.s.d0.b.j().x("KeyOfSharedPrefValidIp", "");
                this.f14973a = null;
                return null;
            }
            if (this.f14973a == null) {
                this.f14973a = c.a.q0.s.d0.b.j().p("KeyOfSharedPrefValidIp", null);
            }
            if (!k.isEmpty(this.f14973a)) {
                c.a.q0.s.d0.b.j().v("KeyOfSharedPrefImCount", e2 + 1);
            } else {
                this.f14973a = null;
            }
            return this.f14973a;
        }
        return (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14976d : invokeV.booleanValue;
    }

    public final List<String> j(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null || str.length() <= 0 || (split = str.split(",")) == null || split.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(3);
            for (String str2 : split) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14976d = false;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f14973a = str;
        c.a.q0.s.d0.b.j().x("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) && this.f14975c == null) {
            this.f14976d = true;
            c cVar = new c(this, bVar);
            this.f14975c = cVar;
            cVar.setSelfExecute(true);
            this.f14975c.execute(new Object[0]);
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
                return;
            }
        }
        this.f14973a = null;
        this.f14974b = null;
        this.f14975c = null;
        this.f14976d = false;
        this.f14976d = false;
        this.f14974b = null;
    }
}
