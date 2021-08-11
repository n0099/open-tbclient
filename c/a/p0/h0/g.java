package c.a.p0.h0;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.dnsproxy.DnsProxyResponseData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends BdAsyncTask<Collection<String>, Void, HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> doInBackground(Collection<String>... collectionArr) {
        InterceptResult invokeL;
        Collection<String> collection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collectionArr)) == null) {
            if (collectionArr == null || collectionArr.length != 1 || (collection = collectionArr[0]) == null) {
                return null;
            }
            HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap = new HashMap<>(collection.size());
            for (String str : collection) {
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    if (allByName != null) {
                        ArrayList arrayList = new ArrayList(allByName.length);
                        for (InetAddress inetAddress : allByName) {
                            if (inetAddress != null) {
                                DnsProxyResponseData.DnsProxyIpData dnsProxyIpData = new DnsProxyResponseData.DnsProxyIpData();
                                dnsProxyIpData.setIp(inetAddress.getHostAddress());
                                arrayList.add(dnsProxyIpData);
                            }
                        }
                        hashMap.put(str, arrayList);
                    }
                } catch (UnknownHostException e2) {
                    BdLog.detailException(e2);
                    d.c().a("sysdns_get", e2.getMessage());
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    d.c().a("sysdns_get", th.getMessage());
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
