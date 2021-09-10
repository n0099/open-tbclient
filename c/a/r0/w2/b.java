package c.a.r0.w2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.m;
import c.a.e.e.p.q;
import c.a.q0.s.y.r;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.quickWebView.message.WebViewCacheReqMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f28137f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f28138g;

    /* renamed from: h  reason: collision with root package name */
    public static int f28139h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28140a;

    /* renamed from: b  reason: collision with root package name */
    public String f28141b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f28142c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f28143d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.c.g.a f28144e;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28145a;

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
            this.f28145a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.f28145a.f28140a) {
                return;
            }
            this.f28145a.f28140a = true;
            if (QuickWebViewSwitch.getInOn()) {
                if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                    f fVar = new f(this.f28145a);
                    fVar.setPriority(4);
                    fVar.execute(new Void[0]);
                    return;
                }
                c cVar = new c(this.f28145a, null);
                cVar.setPriority(4);
                cVar.execute(new Void[0]);
            }
        }
    }

    /* renamed from: c.a.r0.w2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1327b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1327b(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                if (header != null && header.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= header.size()) {
                            break;
                        }
                        if (!TextUtils.isEmpty(header.get(i2)) && header.get(i2).contains("BAIDUID=")) {
                            c.a.q0.m.a.i(header.get(i2));
                            break;
                        }
                        i2++;
                    }
                }
                Map<String, c.a.r0.w2.e.a> moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                if (moduleInfos != null && moduleInfos.size() > 0) {
                    for (String str : moduleInfos.keySet()) {
                        b.o(str, moduleInfos.get(str));
                    }
                    return;
                }
                c.a.r0.w2.c.a().e(true);
            } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                Map<String, c.a.r0.w2.e.a> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                    for (String str2 : moduleInfos2.keySet()) {
                        b.o(str2, moduleInfos2.get(str2));
                    }
                    return;
                }
                c.a.r0.w2.c.a().e(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f28146a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f28147b;

        public c(b bVar) {
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
            this.f28147b = bVar;
            this.f28146a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            e A;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                String modName = TbSingleton.getInstance().getModName();
                if (TextUtils.isEmpty(modName) || (A = this.f28147b.A(modName)) == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.f28146a = netWork;
                netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.f28146a.addPostData("mod_name", modName);
                this.f28146a.addPostData("status", A.f28155a ? "1" : "2");
                this.f28146a.addPostData("fail_reason", A.f28155a ? "" : A.f28156b);
                this.f28146a.postNetData();
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                f fVar = new f(this.f28147b);
                fVar.setPriority(4);
                fVar.execute(new Void[0]);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends BdAsyncTask<Void, Void, h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f28148a;

        /* renamed from: b  reason: collision with root package name */
        public final c.a.r0.w2.e.a f28149b;

        /* renamed from: c  reason: collision with root package name */
        public final String f28150c;

        /* renamed from: d  reason: collision with root package name */
        public final String f28151d;

        /* renamed from: e  reason: collision with root package name */
        public final String f28152e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f28153f;

        /* renamed from: g  reason: collision with root package name */
        public NetWork f28154g;

        public d(String str, c.a.r0.w2.e.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28148a = str;
            this.f28149b = aVar;
            this.f28151d = aVar.c();
            this.f28150c = this.f28149b.a();
            this.f28152e = this.f28149b.b();
            this.f28153f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01b6  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            h r;
            HashMap<String, c.a.r0.w2.d.a> hashMap;
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                b.m(this.f28148a);
                b.q().k(this.f28148a);
                if (this.f28153f) {
                    if (!TextUtils.isEmpty(b.q().s(this.f28148a))) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.f28148a).param("obj_id", this.f28151d));
                    }
                    return null;
                }
                NetWork netWork = new NetWork();
                this.f28154g = netWork;
                netWork.setUrl(this.f28150c);
                new File(b.f28138g + "bdtbWCacheTemp/" + this.f28148a + "/").mkdirs();
                String str2 = b.f28138g + "bdtbWCacheTemp/" + this.f28148a + "/bdtbNWCache.zip";
                if (this.f28154g.downloadFile(str2, null, 0, 3, 0, true)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                    try {
                        fileInputStream2 = new FileInputStream(str2);
                        try {
                            try {
                                String b2 = q.b(fileInputStream2);
                                if (StringUtils.isNull(b2) || !b2.toLowerCase().equals(this.f28152e.toLowerCase())) {
                                    b.f28139h = 2;
                                    c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f28148a, "hybridResult", "md5 error");
                                    b.m(this.f28148a);
                                    m.e(fileInputStream2);
                                    return null;
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                m.e(fileInputStream2);
                                str = b.f28138g + "bdtbWCacheTemp/" + this.f28148a + "/" + this.f28151d + "/";
                                new File(str).mkdirs();
                                if (!r.b(str2, str)) {
                                }
                                b.m(this.f28148a);
                                r = b.r(this.f28148a, this.f28151d);
                                if (r == null) {
                                }
                                b.f28139h = 5;
                                c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f28148a, "hybridResult", "bundle incomplete");
                                b.q().k(this.f28148a);
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            m.e(fileInputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileInputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        m.e(fileInputStream);
                        throw th;
                    }
                    m.e(fileInputStream2);
                    str = b.f28138g + "bdtbWCacheTemp/" + this.f28148a + "/" + this.f28151d + "/";
                    new File(str).mkdirs();
                    if (!r.b(str2, str)) {
                        String str3 = b.f28138g + "bdtbNWCache/" + this.f28148a + "/" + this.f28151d + "/";
                        new File(str3).mkdirs();
                        if (!FileHelper.CopyDir(str, str3, true)) {
                            b.f28139h = 4;
                            c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f28148a, "hybridResult", "write error");
                        }
                    } else {
                        b.f28139h = 3;
                        c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f28148a, "hybridResult", "unzip error");
                    }
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                    b.f28139h = 1;
                    c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f28148a, "hybridResult", "download error");
                }
                b.m(this.f28148a);
                r = b.r(this.f28148a, this.f28151d);
                if (r == null && !TextUtils.isEmpty(r.f28160a) && (hashMap = r.f28161b) != null && hashMap.size() != 0) {
                    b.l(r.f28162c, this.f28148a);
                    return r;
                }
                b.f28139h = 5;
                c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f28148a, "hybridResult", "bundle incomplete");
                b.q().k(this.f28148a);
                return null;
            }
            return (h) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
                super.onPostExecute(hVar);
                if (hVar != null) {
                    b.q().z(this.f28148a, hVar.f28162c);
                    b.q().y();
                    c.a.r0.w2.c.a().h(this.f28148a, hVar.f28161b);
                    c.a.r0.w2.c.a().f(true, this.f28148a);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.f28148a).param("obj_id", hVar.f28162c));
                    return;
                }
                b.q().j(this.f28148a);
                b.q().y();
                c.a.r0.w2.c.a().d(this.f28148a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28155a;

        /* renamed from: b  reason: collision with root package name */
        public String f28156b;

        public e() {
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

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Void, Void, g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28157a;

        public f(b bVar) {
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
            this.f28157a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public g doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            HashMap<String, c.a.r0.w2.d.a> hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                g gVar = new g(null);
                for (String str : b.q().t()) {
                    h r = b.r(str, b.q().s(str));
                    if (r != null && !TextUtils.isEmpty(r.f28160a) && (hashMap = r.f28161b) != null && hashMap.size() != 0) {
                        if (gVar.f28158a == null) {
                            gVar.f28158a = new HashMap();
                        }
                        gVar.f28158a.put(str, r);
                        if (gVar.f28159b == null) {
                            gVar.f28159b = new HashMap<>();
                        }
                        gVar.f28159b.putAll(r.f28161b);
                        b.l(r.f28162c, str);
                    } else {
                        b.f28139h = 5;
                        c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", str, "hybridResult", "bundle incomplete");
                        this.f28157a.k(str);
                    }
                }
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                if (gVar == null) {
                    c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
                } else {
                    c.a.r0.w2.c.a().g(gVar.f28159b);
                }
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, h> f28158a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, c.a.r0.w2.d.a> f28159b;

        public g() {
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

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f28160a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, c.a.r0.w2.d.a> f28161b;

        /* renamed from: c  reason: collision with root package name */
        public String f28162c;

        public h() {
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

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1799565858, "Lc/a/r0/w2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1799565858, "Lc/a/r0/w2/b;");
                return;
            }
        }
        r0 = b.class.getSimpleName() + " TestActivity";
        f28138g = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
        f28139h = 0;
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
        this.f28140a = false;
        this.f28143d = new a(this, 2001371);
        this.f28144e = new C1327b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
    }

    public static void l(String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = f28138g + "bdtbNWCache/" + str2;
        File file = new File(str3);
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length == 0) {
            return;
        }
        for (String str4 : list) {
            if (!StringUtils.isNull(str4) && !str4.equals(str)) {
                FileHelper.deleteFileOrDir(new File(str3 + "/" + str4));
            }
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(f28138g + "bdtbWCacheTemp/" + str));
    }

    public static void o(String str, c.a.r0.w2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, aVar) == null) {
            if (aVar != null && !StringUtils.isNull(aVar.c()) && !StringUtils.isNull(aVar.b()) && !StringUtils.isNull(aVar.a())) {
                String s = q().s(str);
                String c2 = aVar.c();
                String a2 = aVar.a();
                boolean d2 = aVar.d();
                if (StringUtils.isNull(s)) {
                    s = "0.0.0.0";
                }
                if (d2 && c2.equals(s)) {
                    c.a.r0.w2.c.a().f(true, str);
                    return;
                }
                c.a.q0.s.z.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", a2, "hybridVersion", c2, "lastVersion", s, "type", "start", "hybridModule", str, "hybridResult", "success");
                new d(str, aVar, true ^ d2).execute(new Void[0]);
                return;
            }
            c.a.r0.w2.c.a().f(true, str);
        }
    }

    public static b q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f28137f == null) {
                synchronized (b.class) {
                    if (f28137f == null) {
                        f28137f = new b();
                    }
                }
            }
            return f28137f;
        }
        return (b) invokeV.objValue;
    }

    public static h r(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65550, null, str, str2)) != null) {
            return (h) invokeLL.objValue;
        }
        File file = new File(f28138g + "bdtbNWCache");
        FileInputStream fileInputStream2 = null;
        if (!file.exists() || TextUtils.isEmpty(str2)) {
            return null;
        }
        h hVar = new h(null);
        File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
        hVar.f28160a = file.getAbsolutePath();
        hVar.f28162c = str2;
        File file3 = new File(file2, "router.json");
        try {
            if (file3.exists()) {
                try {
                    fileInputStream = new FileInputStream(file3);
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
                try {
                    hVar.f28161b = x(fileInputStream);
                    m.e(fileInputStream);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    m.e(fileInputStream2);
                    return hVar;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    m.e(fileInputStream2);
                    throw th;
                }
                return hVar;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static HashMap<String, c.a.r0.w2.d.a> x(InputStream inputStream) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        HashMap<String, c.a.r0.w2.d.a> hashMap;
        StringBuffer stringBuffer;
        InputStreamReader inputStreamReader;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Iterator<String> keys;
        JSONObject jSONObject2;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65551, null, inputStream)) != null) {
            return (HashMap) invokeL.objValue;
        }
        InputStreamReader inputStreamReader2 = null;
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    hashMap = new HashMap<>();
                    try {
                        stringBuffer = new StringBuffer();
                        inputStreamReader = new InputStreamReader(inputStream);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = null;
                        } catch (JSONException e3) {
                            e = e3;
                            bufferedReader = null;
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = null;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (JSONException e6) {
                        e = e6;
                        bufferedReader = null;
                    } catch (Exception e7) {
                        e = e7;
                        bufferedReader = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (IOException e8) {
                e = e8;
                hashMap = null;
                bufferedReader = null;
            } catch (JSONException e9) {
                e = e9;
                hashMap = null;
                bufferedReader = null;
            } catch (Exception e10) {
                e = e10;
                hashMap = null;
                bufferedReader = null;
            }
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                jSONObject = new JSONObject(stringBuffer.toString());
            } catch (IOException e11) {
                e = e11;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                m.g(inputStreamReader2);
                m.g(bufferedReader);
                return hashMap;
            } catch (JSONException e12) {
                e = e12;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                m.g(inputStreamReader2);
                m.g(bufferedReader);
                return hashMap;
            } catch (Exception e13) {
                e = e13;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                m.g(inputStreamReader2);
                m.g(bufferedReader);
                return hashMap;
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader2 = inputStreamReader;
                m.g(inputStreamReader2);
                m.g(bufferedReader);
                throw th;
            }
            if (jSONObject.has("config") && (optJSONObject = jSONObject.optJSONObject("config")) != null && (keys = optJSONObject.keys()) != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = optJSONObject.getJSONObject(next);
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (jSONObject3.has("data_urls") && (optJSONArray2 = jSONObject3.optJSONArray("data_urls")) != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            arrayList.add(optJSONArray2.optString(i2));
                        }
                    }
                    String optString = jSONObject3.has("module") ? jSONObject3.optString("module") : "";
                    String optString2 = jSONObject3.has("path") ? jSONObject3.optString("path") : "";
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    if (!jSONObject3.has("source") || (optJSONArray = jSONObject3.optJSONArray("source")) == null) {
                        jSONObject2 = optJSONObject;
                    } else {
                        jSONObject2 = optJSONObject;
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            arrayList2.add(optJSONArray.optString(i3));
                        }
                    }
                    c.a.r0.w2.d.a aVar = new c.a.r0.w2.d.a();
                    aVar.f28165a = arrayList;
                    aVar.f28166b = optString;
                    aVar.f28167c = optString2;
                    aVar.f28168d = arrayList2;
                    hashMap.put(next, aVar);
                    optJSONObject = jSONObject2;
                }
                m.g(inputStreamReader);
                m.g(bufferedReader);
                return hashMap;
            }
            m.g(inputStreamReader);
            m.g(bufferedReader);
            return null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final e A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            e eVar = new e();
            if (TextUtils.isEmpty(str)) {
                eVar.f28156b = "module not exit";
                return eVar;
            }
            File file = new File(f28138g + "bdtbNWCache", str);
            String s = q().s(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                eVar.f28155a = false;
                if (!file.exists()) {
                    eVar.f28156b = "bundle not exist";
                    return eVar;
                } else if (TextUtils.isEmpty(s)) {
                    eVar.f28156b = "the local has no valid version name";
                    return eVar;
                } else {
                    String str2 = file.getAbsolutePath() + "/" + s + "/";
                    if (!new File(str2).exists()) {
                        eVar.f28156b = "bundle not exist";
                        return eVar;
                    }
                    String str3 = file.getAbsolutePath() + "/" + s + ".zip";
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        FileHelper.deleteFileOrDir(file2);
                    }
                    if (r.e(str2, str3)) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        netWork.addPostData("offline_pack_version", s);
                        netWork.addPostData("mod_name", str);
                        netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                        netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                        v(netWork.uploadFile("offline_pack_file_stream", str3), eVar);
                        if (!eVar.f28155a) {
                            return eVar;
                        }
                    } else {
                        eVar.f28156b = "zip bundle error";
                        return eVar;
                    }
                }
            } else {
                eVar.f28155a = true;
            }
            if (TbSingleton.getInstance().isClearOffPack()) {
                k(str);
                if (!TextUtils.isEmpty(s)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", s));
                }
                if (!file.exists() || StringUtils.isNull(s) || !new File(file.getAbsolutePath(), s).exists()) {
                    return eVar;
                }
                eVar.f28156b = "delete fail";
                eVar.f28155a = false;
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public JSONObject B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<String, String> map = this.f28142c;
            if (map == null || map.isEmpty()) {
                return null;
            }
            return new JSONObject(this.f28142c);
        }
        return (JSONObject) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.f28142c;
            if (map == null || map.isEmpty()) {
                return null;
            }
            return new JSONObject(this.f28142c).toString();
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n();
            c.a.q0.s.d0.b.j().x("pref_key_quick_webview_versions", "");
            String str = f28138g + "bdtbNWCache";
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length == 0) {
                return;
            }
            for (String str2 : list) {
                if (!StringUtils.isNull(str2)) {
                    FileHelper.deleteFileOrDir(new File(str + "/" + str2));
                }
            }
        }
    }

    public void j(String str) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str) || (map = this.f28142c) == null) {
            return;
        }
        map.remove(str);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        j(str);
        c.a.q0.s.d0.b.j().x("pref_key_quick_webview_versions", C());
        File file = new File(f28138g + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f28142c == null) {
                this.f28142c = new ConcurrentHashMap();
            }
            this.f28142c.clear();
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28141b : (String) invokeV.objValue;
    }

    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.f28142c == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f28142c.get(str);
        }
        return (String) invokeL.objValue;
    }

    public Set<String> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f28142c == null) {
                this.f28142c = new ConcurrentHashMap();
            }
            return this.f28142c.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            System.currentTimeMillis();
            MessageManager.getInstance().registerListener(this.f28144e);
            MessageManager.getInstance().registerListener(this.f28143d);
            this.f28141b = new File(f28138g + "bdtbNWCache").getAbsolutePath();
            w(c.a.q0.s.d0.b.j().p("pref_key_quick_webview_versions", ""));
        }
    }

    public final e v(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            if (StringUtils.isNull(str)) {
                eVar.f28156b = "serve return is null";
                return eVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eVar.f28155a = jSONObject.optInt("error_code") == 0;
                eVar.f28156b = jSONObject.optString("error_msg");
            } catch (JSONException e2) {
                eVar.f28156b = "parse json exception";
                BdLog.e(e2);
            }
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (keys == null) {
                return;
            }
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    if (this.f28142c == null) {
                        this.f28142c = new ConcurrentHashMap();
                    }
                    this.f28142c.put(next, optString);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String C = C();
            if (TextUtils.isEmpty(C)) {
                return;
            }
            c.a.q0.s.d0.b.j().x("pref_key_quick_webview_versions", C);
        }
    }

    public void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f28142c == null) {
            this.f28142c = new ConcurrentHashMap();
        }
        this.f28142c.put(str, str2);
    }
}
