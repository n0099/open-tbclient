package c.a.p.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.UpdateConstants;
import com.baidu.searchbox.net.update.ioc.UpdateRuntime;
import com.baidu.searchbox.net.update.v2.IUpdatePostDataFilter;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends UpdateCloudControlProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Pair<String, String>> a;

    /* loaded from: classes.dex */
    public class a implements IUpdatePostDataFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4519b;

        public a(c cVar, List list, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, list, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.f4519b = jSONObject;
        }

        @Override // com.baidu.searchbox.net.update.v2.IUpdatePostDataFilter
        public boolean isNeedFilter(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                List list = this.a;
                if (list == null || !list.contains(String.format("%s/%s", str, str2))) {
                    return CloudControlManager.getInstance().isInDegradeList(this.f4519b, str, str2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public c() {
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
        this.a = new ArrayList();
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.a.add(new Pair<>(str, str2));
        }
    }

    public final void b(Context context, CommandPostData commandPostData, IUpdatePostDataFilter iUpdatePostDataFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, commandPostData, iUpdatePostDataFilter) == null) {
            for (Pair<String, String> pair : this.a) {
                if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.isNeedFilter((String) pair.first, (String) pair.second)) {
                    try {
                        JSONObject version = commandPostData.getVersion();
                        JSONObject data = commandPostData.getData();
                        JSONObject optJSONObject = version.optJSONObject((String) pair.first);
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                            version.put((String) pair.first, optJSONObject);
                        }
                        JSONObject optJSONObject2 = data.optJSONObject((String) pair.first);
                        if (optJSONObject2 == null) {
                            optJSONObject2 = new JSONObject();
                            data.put((String) pair.first, optJSONObject2);
                        }
                        c.a.p.c.d.a.a(context, (String) pair.first, (String) pair.second, new CommandPostData(optJSONObject, optJSONObject2, commandPostData.getPubData()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (AppConfig.isDebug()) {
                            String str = "addPostData error " + e2.getMessage();
                        }
                    }
                }
            }
            commandPostData.cleanEmptyData();
        }
    }

    @Override // com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor, com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), jSONObject})) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject2.put("version", jSONObject3);
                jSONObject2.put("data", jSONObject4);
                jSONObject2.put(UpdateConstants.POST_DATA_PUBDATA, jSONObject5);
                b(AppRuntime.getAppContext(), new CommandPostData(jSONObject3, jSONObject4, jSONObject5), new a(this, UpdateRuntime.getUpdateContext().getCustomUpdateBlackList(), jSONObject));
                return new CloudControlRequestInfo(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, jSONObject3, null, null);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (CloudControlRequestInfo) invokeCommon.objValue;
    }

    @Override // com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor, com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cloudControlResponseInfo, iCloudControlUBCCallBack) == null) {
            String serviceName = cloudControlResponseInfo.getServiceName();
            JSONObject serviceData = cloudControlResponseInfo.getServiceData();
            JSONObject option = cloudControlResponseInfo.getOption();
            if (!UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME.equals(serviceName) || serviceData == null) {
                return;
            }
            try {
                if (serviceData.length() == 0 && this.a.size() > 0) {
                    HashMap hashMap = new HashMap();
                    for (Pair<String, String> pair : this.a) {
                        if (pair != null) {
                            String str = (String) pair.first;
                            String str2 = (String) pair.second;
                            if (!str.isEmpty() && !str2.isEmpty()) {
                                String b2 = c.a.p.c.d.b.b(c.a.p.c.d.a.d("key_version", str, str2), "");
                                String b3 = c.a.p.c.d.b.b(c.a.p.c.d.a.d("key_data", str, str2), "");
                                if (!TextUtils.isEmpty(b3)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("data", b3);
                                    jSONObject.put("version", b2);
                                    hashMap.put(str + "/" + str2, jSONObject.toString());
                                }
                            }
                        }
                    }
                    c.a.p.c.a.b(hashMap);
                    return;
                }
                b bVar = new b(this.a);
                Map g2 = bVar.g(new StringReader(serviceData.toString()), 16, option);
                JSONObject d2 = bVar.d();
                if (d2 == null) {
                    return;
                }
                c.a.p.c.a.b(g2);
                JSONObject jSONObject2 = new JSONObject();
                JSONArray optJSONArray = d2.optJSONArray("detail");
                String optString = d2.optString("totalCount");
                String optString2 = d2.optString("successCount");
                String optString3 = d2.optString("versionFilterCount");
                jSONObject2.put("items", optJSONArray);
                jSONObject2.put("count", String.format("%s,%s,%s", optString, optString2, optString3));
                iCloudControlUBCCallBack.setServiceInfo(jSONObject2);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
