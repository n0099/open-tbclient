package b.a.r0.i0;

import android.text.TextUtils;
import b.a.e.e.d.l;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tieba.dnsproxy.DnsProxyResponseData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class c extends BdAsyncTask<Collection<String>, HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>, HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f17825a;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17825a = z;
        setPriority(4);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02af  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> doInBackground(Collection<String>... collectionArr) {
        InterceptResult invokeL;
        Collection<String> collection;
        String message;
        String str;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collectionArr)) == null) {
            l<String> c2 = BdCacheService.k().c("dnsproxy", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
            if (this.f17825a) {
                String str2 = c2.get("dnsproxycachedata");
                if (str2 != null) {
                    DnsProxyResponseData dnsProxyResponseData = (DnsProxyResponseData) OrmObject.objectWithJsonStr(str2, DnsProxyResponseData.class);
                    if (dnsProxyResponseData != null && dnsProxyResponseData.getErrno() == 0) {
                        List<HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> data = dnsProxyResponseData.getData();
                        HashMap hashMap = new HashMap(data.size());
                        for (HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap2 : data) {
                            for (Map.Entry<String, List<DnsProxyResponseData.DnsProxyIpData>> entry : hashMap2.entrySet()) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        publishProgress(hashMap);
                    } else {
                        publishProgress(null);
                    }
                } else {
                    publishProgress(null);
                }
                return null;
            }
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (collectionArr == null || collectionArr.length != 1 || (collection = collectionArr[0]) == null) {
                return null;
            }
            String a2 = new a().a();
            StringBuilder sb2 = new StringBuilder();
            for (String str3 : collection) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
            String str4 = "http://" + a2 + "/domains/resolve?domains=" + ((Object) sb2) + "&t=" + System.currentTimeMillis();
            b.a.e.e.j.a.e eVar = new b.a.e.e.j.a.e();
            b.a.e.e.j.a.c cVar = new b.a.e.e.j.a.c(eVar);
            eVar.b().s(str4);
            cVar.e(-1, -1, -1);
            byte[] bArr = eVar.c().f1812h;
            if (bArr != null) {
                try {
                    str = new String(bArr, "UTF-8");
                    message = null;
                } catch (Throwable th) {
                    message = th.getMessage();
                    str = null;
                }
                DnsProxyResponseData dnsProxyResponseData2 = (DnsProxyResponseData) OrmObject.objectWithJsonStr(str, DnsProxyResponseData.class);
                if (dnsProxyResponseData2 != null && dnsProxyResponseData2.getErrno() == 0) {
                    sb = new StringBuilder();
                    List<HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> data2 = dnsProxyResponseData2.getData();
                    HashSet hashSet = new HashSet();
                    HashMap hashMap3 = new HashMap(data2.size());
                    for (HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap4 : data2) {
                        for (Map.Entry<String, List<DnsProxyResponseData.DnsProxyIpData>> entry2 : hashMap4.entrySet()) {
                            hashMap3.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    for (Map.Entry entry3 : hashMap3.entrySet()) {
                        List<DnsProxyResponseData.DnsProxyIpData> list = (List) entry3.getValue();
                        if (list != null && list.size() > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                                if (dnsProxyIpData != null) {
                                    hashSet.add(dnsProxyIpData.getIp());
                                    if (sb3.length() > 0) {
                                        sb3.append(",");
                                    }
                                    sb3.append(dnsProxyIpData.getIp());
                                }
                            }
                            if (sb3.length() > 0) {
                                sb3.insert(0, ":");
                                sb3.insert(0, (String) entry3.getKey());
                                if (sb.length() > 0) {
                                    sb.append(";");
                                }
                                sb.append((CharSequence) sb3);
                            }
                        }
                    }
                    b.a().b(hashSet);
                    publishProgress(hashMap3);
                    c2.g("dnsproxycachedata", str);
                    if (!TextUtils.isEmpty(message)) {
                        b.a.e.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                        statsItem.b("workflow", "dnsproxy_get");
                        statsItem.c("issuc", Boolean.TRUE);
                        statsItem.b("comment", sb == null ? "" : sb.toString());
                        BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    } else {
                        b.a.e.e.n.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
                        statsItem2.b("workflow", "dnsproxy_get");
                        statsItem2.c("issuc", Boolean.FALSE);
                        statsItem2.b("comment", message);
                        BdStatisticsManager.getInstance().debug("dnsproxy", statsItem2);
                    }
                    return null;
                } else if (dnsProxyResponseData2 == null) {
                    message = "parser response error return null";
                } else {
                    message = dnsProxyResponseData2.getErrno() + " " + dnsProxyResponseData2.getErrmsg();
                }
            } else if (eVar.a() != null) {
                message = eVar.a().f1792h;
            } else {
                StringBuilder sb4 = new StringBuilder();
                List<b.a.e.e.j.a.d> d2 = eVar.d();
                if (d2 != null) {
                    for (b.a.e.e.j.a.d dVar : d2) {
                        if (dVar != null && !TextUtils.isEmpty(dVar.f1792h)) {
                            if (sb4.length() > 0) {
                                sb4.append(",");
                            }
                            sb4.append(dVar.f1792h);
                        }
                    }
                }
                message = sb4.length() <= 0 ? "http get data is null" : sb4.toString();
            }
            sb = null;
            if (!TextUtils.isEmpty(message)) {
            }
            return null;
        }
        return (HashMap) invokeL.objValue;
    }
}
