package b.a.u.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.CommonUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    public static IMPushPb.Action b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.NEWCONNECTION).setNewConnection(IMPushPb.NewConnection.newBuilder().setAliasId(601110L).setConnectErrorCode(jSONObject.optString("con_err_code", "")).setTokenBegin(jSONObject.optLong("token_begin", 0L)).setTokenEnd(jSONObject.optLong("token_end", 0L)).setDnsBegin(jSONObject.optLong("dns_begin", 0L)).setDnsEnd(jSONObject.optLong("dns_end", 0L)).setSocketBegin(jSONObject.optLong("socket_begin", 0L)).setSocketEnd(jSONObject.optLong("socket_end", 0L)).setLcpLoginBegin(jSONObject.optLong("login_begin", 0L)).setLcpLoginEnd(jSONObject.optLong("login_end", 0L)).setConnectSource(jSONObject.optString("source", "")).setConnectState(jSONObject.optLong("connect_state", -1L)).setEndTime(jSONObject.optLong("flow_end_time", 0L)).setStartTime(jSONObject.optLong("flow_start_time", 0L)).setRetry(jSONObject.optInt("retry_cout", 0)).setExt(jSONObject.toString()).setNetInfo(IMPushPb.LcpNetInfo.newBuilder().setDomain(jSONObject.optString("domain", "")).setIp(jSONObject.optString("ip", "")).setPort(jSONObject.optString(ClientCookie.PORT_ATTR, "")).setProtocol(jSONObject.optString("protocol", "")).build()).build()).build() : (IMPushPb.Action) invokeL.objValue;
    }

    public static IMPushPb.Action d(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str3, Long.valueOf(j4)})) == null) ? IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build() : (IMPushPb.Action) invokeCommon.objValue;
    }

    public static IMPushPb.Action e(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), str2, Long.valueOf(j5)})) == null) ? IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(j).setStopTime(j2).setReason(str).setRetryTime(j3).setRetryCount(j4).setExt(str2).setAliasId(j5).build()).build() : (IMPushPb.Action) invokeCommon.objValue;
    }

    public static void f(Context context, Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, connection) == null) {
            try {
                HashSet hashSet = new HashSet(g.b(context));
                hashSet.add(Base64.encodeToString(e(connection.startTime, connection.stopTime, connection.reason, connection.retryTime, connection.retryCount, connection.ext, connection.aliasId).toByteArray(), 0));
                g.k(context, hashSet);
            } catch (Exception e2) {
                b.a.u.a.h.e.c("TrackPbGenerator", "putIMConnectionToActions :", e2);
            }
        }
    }

    public static void g(Context context, Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, request) == null) {
            try {
                HashSet hashSet = new HashSet(g.d(context));
                hashSet.add(Base64.encodeToString(d(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId).toByteArray(), 0));
                g.o(context, hashSet);
            } catch (Exception e2) {
                b.a.u.a.h.e.c("TrackPbGenerator", "putIMRequestToActions :", e2);
            }
        }
    }

    public final List<String> a(String str, List<h> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !TextUtils.isEmpty(str) && list.size() > 0) {
                b.a.u.a.h.e.a("TrackPbGenerator", "flow upload details list");
                for (h hVar : list) {
                    if (hVar != null) {
                        String a2 = hVar.a();
                        if (!TextUtils.isEmpty(a2) && a2.length() > 0) {
                            arrayList.add(a2);
                        }
                    }
                }
                b.a.u.a.h.e.a("TrackPbGenerator", "flow upload detal list:" + arrayList.toString());
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public byte[] c(Context context, String str, List<h> list, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, list, i2)) == null) {
            list.addAll(b.a.u.a.d.a.j(context).g(str, i2));
            List<String> a2 = a(str, list);
            if (a2 != null) {
                try {
                    if (a2.size() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        if (a2.size() > 0) {
                            for (String str2 : a2) {
                                copyOnWriteArrayList.add(b(new JSONObject(str2)));
                            }
                        }
                        return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, b.a.u.a.h.f.e(context))).setSdkName("lcp").setSdkVersion(2280016L).addAllActions(copyOnWriteArrayList).build().toByteArray();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (byte[]) invokeLLLI.objValue;
    }
}
