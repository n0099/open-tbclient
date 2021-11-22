package b.a.r0.i0.i;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f19302a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, b> f19303b;

    /* renamed from: c  reason: collision with root package name */
    public long f19304c;

    /* renamed from: d  reason: collision with root package name */
    public long f19305d;

    /* renamed from: e  reason: collision with root package name */
    public String f19306e;

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
        this.f19302a = new HashMap<>();
        this.f19303b = new HashMap<>();
    }

    public static final a a(ConnectPointData connectPointData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, connectPointData)) == null) {
            if (connectPointData == null) {
                return null;
            }
            a aVar = new a();
            aVar.f19306e = connectPointData.name;
            aVar.f19304c = connectPointData.last_connect_rate_update_time.longValue();
            aVar.f19305d = connectPointData.last_speed_data_update_time.longValue();
            for (DnsIpData dnsIpData : connectPointData.dns_ip_connect_rate) {
                b c2 = b.c(dnsIpData);
                if (c2 != null) {
                    aVar.f19302a.put(c2.f19307a, c2);
                }
            }
            for (DnsIpData dnsIpData2 : connectPointData.dns_ip_speed_data) {
                b c3 = b.c(dnsIpData2);
                if (c3 != null) {
                    aVar.f19303b.put(c3.f19307a, c3);
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static final String b() {
        WifiInfo connectionInfo;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkCoreApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    String typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (!TextUtils.isEmpty(typeName)) {
                        if (TextUtils.isEmpty(extraInfo) && typeName.equalsIgnoreCase(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) && (connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getContext().getSystemService("wifi")).getConnectionInfo()) != null) {
                            extraInfo = connectionInfo.getBSSID();
                        }
                        if (!TextUtils.isEmpty(extraInfo)) {
                            return typeName + "_" + extraInfo;
                        }
                    }
                    b.a.r0.i0.d c2 = b.a.r0.i0.d.c();
                    c2.a("get_connectpoint_null", typeName + "_" + extraInfo);
                    return null;
                }
                return null;
            } catch (Throwable th) {
                BdLog.detailException(th);
                b.a.r0.i0.d.c().a("get_connectpoint_name", th.getMessage());
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static final ConnectPointData c(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            ConnectPointData.Builder builder = new ConnectPointData.Builder();
            builder.name = aVar.f19306e;
            builder.last_connect_rate_update_time = Long.valueOf(aVar.f19304c);
            builder.last_speed_data_update_time = Long.valueOf(aVar.f19305d);
            builder.dns_ip_connect_rate = new ArrayList();
            builder.dns_ip_speed_data = new ArrayList();
            for (Map.Entry<String, b> entry : aVar.f19302a.entrySet()) {
                DnsIpData d2 = b.d(entry.getValue());
                if (d2 != null) {
                    builder.dns_ip_connect_rate.add(d2);
                }
            }
            for (Map.Entry<String, b> entry2 : aVar.f19303b.entrySet()) {
                DnsIpData d3 = b.d(entry2.getValue());
                if (d3 != null) {
                    builder.dns_ip_speed_data.add(d3);
                }
            }
            return builder.build(true);
        }
        return (ConnectPointData) invokeL.objValue;
    }
}
