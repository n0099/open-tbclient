package c.g.b0.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.ReflectionUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Ssp.Pid pid) {
        super(pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Ssp.Pid) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009b A[Catch: JSONException -> 0x0100, TryCatch #0 {JSONException -> 0x0100, blocks: (B:11:0x001e, B:13:0x002b, B:15:0x0033, B:17:0x0047, B:19:0x0056, B:25:0x0068, B:27:0x0070, B:33:0x009b, B:35:0x00a3, B:36:0x00ab, B:28:0x0082, B:30:0x008a), top: B:45:0x001e }] */
    @Override // com.fun.ad.sdk.internal.api.ripper.BaseAdRipper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        Object invoke;
        String str;
        String str2;
        String str3;
        String str4;
        String optString;
        String str5;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            Object findField = ReflectionUtils.findField("com.bytedance.sdk.openadsdk.core.o.r", obj);
            if (findField == null || (invoke = ReflectionUtils.invoke(findField, "bt", null, new Object[0])) == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(invoke.toString());
                JSONObject optJSONObject3 = jSONObject.optJSONObject("icon");
                String optString2 = optJSONObject3 != null ? optJSONObject3.optString("url") : null;
                String combineStrWithComma = RippedAd.combineStrWithComma(jSONObject.optJSONArray("image"), a.a);
                JSONObject optJSONObject4 = jSONObject.optJSONObject("video");
                if (optJSONObject4 != null) {
                    str2 = optJSONObject4.optString("video_url");
                    str = optJSONObject4.optString("cover_url");
                } else {
                    str = null;
                    str2 = null;
                }
                int optInt = jSONObject.optInt("interaction_type", -1);
                if (optInt == 3) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("deep_link");
                    if (optJSONObject5 != null) {
                        str3 = null;
                        str4 = null;
                        optString = optJSONObject5.optString("deeplink_url");
                        str5 = null;
                        if (str3 == null) {
                        }
                        RippedAd.Builder builder = new RippedAd.Builder();
                        builder.setCorporation(jSONObject.optString("source")).setTitle(jSONObject.optString("title")).setDescription(jSONObject.optString("description")).setAppName(str3).setAppPkg(str4).setAppUrl(str5).setIconUrl(optString2).setImageUrl(combineStrWithComma).setVideoImageUrl(str).setVideoUrl(str2).setClickUrl(jSONObject.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                        return builder.build();
                    }
                    str5 = null;
                    optString = null;
                    str3 = null;
                    str4 = null;
                    if (str3 == null) {
                    }
                    RippedAd.Builder builder2 = new RippedAd.Builder();
                    builder2.setCorporation(jSONObject.optString("source")).setTitle(jSONObject.optString("title")).setDescription(jSONObject.optString("description")).setAppName(str3).setAppPkg(str4).setAppUrl(str5).setIconUrl(optString2).setImageUrl(combineStrWithComma).setVideoImageUrl(str).setVideoUrl(str2).setClickUrl(jSONObject.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                    return builder2.build();
                }
                if (optInt == 4 && (optJSONObject2 = jSONObject.optJSONObject("app")) != null) {
                    String optString3 = optJSONObject2.optString("app_name");
                    String optString4 = optJSONObject2.optString("package_name");
                    str5 = optJSONObject2.optString("download_url");
                    str4 = optString4;
                    str3 = optString3;
                    optString = null;
                    if (str3 == null && (optJSONObject = jSONObject.optJSONObject("app_manage")) != null) {
                        str3 = optJSONObject.optString("app_name");
                        str4 = optJSONObject.optString("package_name");
                    }
                    RippedAd.Builder builder22 = new RippedAd.Builder();
                    builder22.setCorporation(jSONObject.optString("source")).setTitle(jSONObject.optString("title")).setDescription(jSONObject.optString("description")).setAppName(str3).setAppPkg(str4).setAppUrl(str5).setIconUrl(optString2).setImageUrl(combineStrWithComma).setVideoImageUrl(str).setVideoUrl(str2).setClickUrl(jSONObject.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                    return builder22.build();
                }
                str5 = null;
                optString = null;
                str3 = null;
                str4 = null;
                if (str3 == null) {
                    str3 = optJSONObject.optString("app_name");
                    str4 = optJSONObject.optString("package_name");
                }
                RippedAd.Builder builder222 = new RippedAd.Builder();
                builder222.setCorporation(jSONObject.optString("source")).setTitle(jSONObject.optString("title")).setDescription(jSONObject.optString("description")).setAppName(str3).setAppPkg(str4).setAppUrl(str5).setIconUrl(optString2).setImageUrl(combineStrWithComma).setVideoImageUrl(str).setVideoUrl(str2).setClickUrl(jSONObject.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                return builder222.build();
            } catch (JSONException e2) {
                LogPrinter.e(e2);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
