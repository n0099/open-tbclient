package c.a.t0.h3;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.o;
import c.a.d.f.p.t;
import c.a.s0.s.z.r;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
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
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f18580f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f18581g;

    /* renamed from: h  reason: collision with root package name */
    public static int f18582h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f18583b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f18584c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f18585d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.c.g.a f18586e;

    /* loaded from: classes7.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.a.a) {
                return;
            }
            this.a.a = true;
            if (QuickWebViewSwitch.getInOn()) {
                if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                    f fVar = new f(this.a);
                    fVar.setPriority(4);
                    fVar.execute(new Void[0]);
                    return;
                }
                c cVar = new c(this.a, null);
                cVar.setPriority(4);
                cVar.execute(new Void[0]);
            }
        }
    }

    /* renamed from: c.a.t0.h3.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1117b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1117b(b bVar, int i2, int i3) {
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

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
            c.a.s0.m.a.i(r0.get(r2));
         */
        @Override // c.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                try {
                    List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                    if (header != null && header.size() > 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= header.size()) {
                                break;
                            }
                            if (!TextUtils.isEmpty(header.get(i2)) && header.get(i2).contains("BAIDUID=")) {
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                }
                Map<String, c.a.t0.h3.e.a> moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                if (moduleInfos != null && moduleInfos.size() > 0) {
                    for (String str : moduleInfos.keySet()) {
                        b.o(str, moduleInfos.get(str));
                    }
                    return;
                }
                c.a.t0.h3.c.a().e(true);
            } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                Map<String, c.a.t0.h3.e.a> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                    for (String str2 : moduleInfos2.keySet()) {
                        b.o(str2, moduleInfos2.get(str2));
                    }
                    return;
                }
                c.a.t0.h3.c.a().e(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f18587b;

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
            this.f18587b = bVar;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            e B;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                String modName = TbSingleton.getInstance().getModName();
                if (TextUtils.isEmpty(modName) || (B = this.f18587b.B(modName)) == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.a = netWork;
                netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.a.addPostData("mod_name", modName);
                this.a.addPostData("status", B.a ? "1" : "2");
                this.a.addPostData("fail_reason", B.a ? "" : B.f18594b);
                this.a.postNetData();
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                f fVar = new f(this.f18587b);
                fVar.setPriority(4);
                fVar.execute(new Void[0]);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends BdAsyncTask<Void, Void, h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final c.a.t0.h3.e.a f18588b;

        /* renamed from: c  reason: collision with root package name */
        public final String f18589c;

        /* renamed from: d  reason: collision with root package name */
        public final String f18590d;

        /* renamed from: e  reason: collision with root package name */
        public final String f18591e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f18592f;

        /* renamed from: g  reason: collision with root package name */
        public NetWork f18593g;

        public d(String str, c.a.t0.h3.e.a aVar, boolean z) {
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
            this.a = str;
            this.f18588b = aVar;
            this.f18590d = aVar.c();
            this.f18589c = this.f18588b.a();
            this.f18591e = this.f18588b.b();
            this.f18592f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:31:0x016e  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01ca  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            h r;
            HashMap<String, c.a.t0.h3.d.a> hashMap;
            InputStream inputStream;
            FileInputStream fileInputStream;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                b.m(this.a);
                b.q().k(this.a);
                if (this.f18592f) {
                    if (!TextUtils.isEmpty(b.q().s(this.a))) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", this.f18590d));
                    }
                    return null;
                }
                NetWork netWork = new NetWork();
                this.f18593g = netWork;
                netWork.setUrl(this.f18589c);
                new File(b.f18581g + "bdtbWCacheTemp/" + this.a + "/").mkdirs();
                String str2 = b.f18581g + "bdtbWCacheTemp/" + this.a + "/bdtbNWCache.zip";
                if (this.f18593g.downloadFile(str2, null, 0, 3, 0, true)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                    try {
                        try {
                            fileInputStream = new FileInputStream(str2);
                            try {
                                String b2 = t.b(fileInputStream);
                                if (StringUtils.isNull(b2) || !b2.toLowerCase().equals(this.f18591e.toLowerCase())) {
                                    b.f18582h = 2;
                                    c.a.s0.s.b0.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.f18590d, "hybridResult", "md5 error");
                                    b.m(this.a);
                                    o.e(fileInputStream);
                                    return null;
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                o.e(fileInputStream);
                                str = b.f18581g + "bdtbWCacheTemp/" + this.a + "/" + this.f18590d + "/";
                                new File(str).mkdirs();
                                if (!r.b(str2, str)) {
                                }
                                b.m(this.a);
                                r = b.r(this.a, this.f18590d);
                                if (r == null) {
                                }
                                b.f18582h = 5;
                                c.a.s0.s.b0.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.f18590d, "hybridResult", "bundle incomplete");
                                b.q().k(this.a);
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = "obj_type";
                            o.e(inputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        o.e(inputStream);
                        throw th;
                    }
                    o.e(fileInputStream);
                    str = b.f18581g + "bdtbWCacheTemp/" + this.a + "/" + this.f18590d + "/";
                    new File(str).mkdirs();
                    if (!r.b(str2, str)) {
                        String str3 = b.f18581g + "bdtbNWCache/" + this.a + "/" + this.f18590d + "/";
                        new File(str3).mkdirs();
                        if (!FileHelper.CopyDir(str, str3, true)) {
                            b.f18582h = 4;
                            c.a.s0.s.b0.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.f18590d, "hybridResult", "write error");
                        }
                    } else {
                        b.f18582h = 3;
                        c.a.s0.s.b0.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.f18590d, "hybridResult", "unzip error");
                    }
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                    b.f18582h = 1;
                    c.a.s0.s.b0.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.f18590d, "hybridResult", "download error");
                }
                b.m(this.a);
                r = b.r(this.a, this.f18590d);
                if (r == null && !TextUtils.isEmpty(r.a) && (hashMap = r.f18596b) != null && hashMap.size() != 0) {
                    b.l(r.f18597c, this.a);
                    return r;
                }
                b.f18582h = 5;
                c.a.s0.s.b0.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.f18590d, "hybridResult", "bundle incomplete");
                b.q().k(this.a);
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
                    b.q().A(this.a, hVar.f18597c);
                    b.q().y();
                    c.a.t0.h3.c.a().h(this.a, hVar.f18596b);
                    c.a.t0.h3.c.a().f(true, this.a);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", hVar.f18597c));
                    return;
                }
                b.q().j(this.a);
                b.q().y();
                c.a.t0.h3.c.a().d(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f18594b;

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

    /* loaded from: classes7.dex */
    public class f extends BdAsyncTask<Void, Void, g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public g doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            HashMap<String, c.a.t0.h3.d.a> hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                g gVar = new g(null);
                for (String str : b.q().t()) {
                    String s = b.q().s(str);
                    h r = b.r(str, s);
                    if (r != null && !TextUtils.isEmpty(r.a) && (hashMap = r.f18596b) != null && hashMap.size() != 0) {
                        if (gVar.a == null) {
                            gVar.a = new HashMap();
                        }
                        gVar.a.put(str, r);
                        if (gVar.f18595b == null) {
                            gVar.f18595b = new HashMap<>();
                        }
                        gVar.f18595b.putAll(r.f18596b);
                        b.l(r.f18597c, str);
                    } else {
                        b.f18582h = 5;
                        c.a.s0.s.b0.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", str, "hybridVersion", s, "hybridResult", "bundle incomplete");
                        this.a.k(str);
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
                    c.a.s0.s.b0.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
                } else {
                    c.a.t0.h3.c.a().g(gVar.f18595b);
                }
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, h> a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, c.a.t0.h3.d.a> f18595b;

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

    /* loaded from: classes7.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, c.a.t0.h3.d.a> f18596b;

        /* renamed from: c  reason: collision with root package name */
        public String f18597c;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(976396208, "Lc/a/t0/h3/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(976396208, "Lc/a/t0/h3/b;");
                return;
            }
        }
        r0 = b.class.getSimpleName() + " TestActivity";
        f18581g = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
        f18582h = 0;
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
        this.a = false;
        this.f18585d = new a(this, 2001371);
        this.f18586e = new C1117b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
    }

    public static void l(String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = f18581g + "bdtbNWCache/" + str2;
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
        FileHelper.deleteFileOrDir(new File(f18581g + "bdtbWCacheTemp/" + str));
    }

    public static void o(String str, c.a.t0.h3.e.a aVar) {
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
                    c.a.t0.h3.c.a().f(true, str);
                    return;
                }
                c.a.s0.s.b0.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", a2, "hybridVersion", c2, "lastVersion", s, "type", "start", "hybridName", str, "hybridResult", "success");
                new d(str, aVar, true ^ d2).execute(new Void[0]);
                return;
            }
            c.a.t0.h3.c.a().f(true, str);
        }
    }

    public static b q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f18580f == null) {
                synchronized (b.class) {
                    if (f18580f == null) {
                        f18580f = new b();
                    }
                }
            }
            return f18580f;
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
        File file = new File(f18581g + "bdtbNWCache");
        FileInputStream fileInputStream2 = null;
        if (!file.exists() || TextUtils.isEmpty(str2)) {
            return null;
        }
        h hVar = new h(null);
        File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
        hVar.a = file.getAbsolutePath();
        hVar.f18597c = str2;
        File file3 = new File(file2, "router.json");
        try {
            if (file3.exists()) {
                try {
                    fileInputStream = new FileInputStream(file3);
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
                try {
                    hVar.f18596b = x(fileInputStream);
                    o.e(fileInputStream);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    o.e(fileInputStream2);
                    return hVar;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    o.e(fileInputStream2);
                    throw th;
                }
                return hVar;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static HashMap<String, c.a.t0.h3.d.a> x(InputStream inputStream) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        HashMap<String, c.a.t0.h3.d.a> hashMap;
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
                o.g(inputStreamReader2);
                o.g(bufferedReader);
                return hashMap;
            } catch (JSONException e12) {
                e = e12;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                o.g(inputStreamReader2);
                o.g(bufferedReader);
                return hashMap;
            } catch (Exception e13) {
                e = e13;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                o.g(inputStreamReader2);
                o.g(bufferedReader);
                return hashMap;
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader2 = inputStreamReader;
                o.g(inputStreamReader2);
                o.g(bufferedReader);
                throw th;
            }
            if (jSONObject.has(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME) && (optJSONObject = jSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME)) != null && (keys = optJSONObject.keys()) != null) {
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
                    c.a.t0.h3.d.a aVar = new c.a.t0.h3.d.a();
                    aVar.a = arrayList;
                    aVar.f18599b = optString;
                    aVar.f18600c = optString2;
                    aVar.f18601d = arrayList2;
                    hashMap.put(next, aVar);
                    optJSONObject = jSONObject2;
                }
                o.g(inputStreamReader);
                o.g(bufferedReader);
                return hashMap;
            }
            o.g(inputStreamReader);
            o.g(bufferedReader);
            return null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @NonNull
    public static String z(boolean z, @Nullable String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65552, null, z, str)) == null) {
            return TextUtils.isEmpty(str) ? z ? "none" : "0.0.0.0" : str;
        }
        return (String) invokeZL.objValue;
    }

    public void A(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f18584c == null) {
            this.f18584c = new ConcurrentHashMap();
        }
        this.f18584c.put(str, str2);
    }

    public final e B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            e eVar = new e();
            if (TextUtils.isEmpty(str)) {
                eVar.f18594b = "module not exit";
                return eVar;
            }
            File file = new File(f18581g + "bdtbNWCache", str);
            String s = q().s(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                eVar.a = false;
                if (!file.exists()) {
                    eVar.f18594b = "bundle not exist";
                    return eVar;
                } else if (TextUtils.isEmpty(s)) {
                    eVar.f18594b = "the local has no valid version name";
                    return eVar;
                } else {
                    String str2 = file.getAbsolutePath() + "/" + s + "/";
                    if (!new File(str2).exists()) {
                        eVar.f18594b = "bundle not exist";
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
                        if (!eVar.a) {
                            return eVar;
                        }
                    } else {
                        eVar.f18594b = "zip bundle error";
                        return eVar;
                    }
                }
            } else {
                eVar.a = true;
            }
            if (TbSingleton.getInstance().isClearOffPack()) {
                k(str);
                if (!TextUtils.isEmpty(s)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", s));
                }
                if (!file.exists() || StringUtils.isNull(s) || !new File(file.getAbsolutePath(), s).exists()) {
                    return eVar;
                }
                eVar.f18594b = "delete fail";
                eVar.a = false;
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public JSONObject C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.f18584c;
            if (map == null || map.isEmpty()) {
                return null;
            }
            return new JSONObject(this.f18584c);
        }
        return (JSONObject) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Map<String, String> map = this.f18584c;
            if (map == null || map.isEmpty()) {
                return null;
            }
            return new JSONObject(this.f18584c).toString();
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n();
            c.a.s0.s.g0.b.j().x("pref_key_quick_webview_versions", "");
            String str = f18581g + "bdtbNWCache";
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str) || (map = this.f18584c) == null) {
            return;
        }
        map.remove(str);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        j(str);
        c.a.s0.s.g0.b.j().x("pref_key_quick_webview_versions", D());
        File file = new File(f18581g + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f18584c == null) {
                this.f18584c = new ConcurrentHashMap();
            }
            this.f18584c.clear();
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18583b : (String) invokeV.objValue;
    }

    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (this.f18584c == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f18584c.get(str);
        }
        return (String) invokeL.objValue;
    }

    public Set<String> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f18584c == null) {
                this.f18584c = new ConcurrentHashMap();
            }
            return this.f18584c.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            System.currentTimeMillis();
            MessageManager.getInstance().registerListener(this.f18586e);
            MessageManager.getInstance().registerListener(this.f18585d);
            this.f18583b = new File(f18581g + "bdtbNWCache").getAbsolutePath();
            w(c.a.s0.s.g0.b.j().p("pref_key_quick_webview_versions", ""));
        }
    }

    public final e v(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, eVar)) == null) {
            if (StringUtils.isNull(str)) {
                eVar.f18594b = "serve return is null";
                return eVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eVar.a = jSONObject.optInt("error_code") == 0;
                eVar.f18594b = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (JSONException e2) {
                eVar.f18594b = "parse json exception";
                BdLog.e(e2);
            }
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str)) {
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
                    if (this.f18584c == null) {
                        this.f18584c = new ConcurrentHashMap();
                    }
                    this.f18584c.put(next, optString);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String D = D();
            if (TextUtils.isEmpty(D)) {
                return;
            }
            c.a.s0.s.g0.b.j().x("pref_key_quick_webview_versions", D);
        }
    }
}
