package com.baidu.sofire.rp.network.engine;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.EncryptConnUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ReportEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public ReportEngine(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static void initDafalutConfiger(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = jSONObject.optJSONObject("3").getJSONObject("c");
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                int optInt = jSONObject2.optInt("n");
                if (optInt > 0) {
                    sharedPreferenceManager.setReportNetworkType(optInt);
                }
                int optInt2 = jSONObject2.optInt("i");
                if (optInt2 > 0) {
                    sharedPreferenceManager.setReportPollHour(optInt2);
                }
                int optInt3 = jSONObject2.optInt("i2");
                if (optInt3 > 0) {
                    sharedPreferenceManager.setReportPollBackHour(optInt3);
                }
                int optInt4 = jSONObject2.optInt("w");
                if (optInt4 > 0) {
                    sharedPreferenceManager.setReportLastTime(optInt4);
                }
                if (jSONObject2.optInt(HttpClientWrap.h) > 0) {
                    sharedPreferenceManager.setReportOneceLimit(jSONObject2.optInt(HttpClientWrap.h));
                }
                int optInt5 = jSONObject2.optInt(Config.SESSTION_TRACK_START_TIME);
                if (optInt5 > 0) {
                    sharedPreferenceManager.setReportDayLimit(optInt5);
                }
                int optInt6 = jSONObject2.optInt("t");
                if (optInt6 > 0) {
                    sharedPreferenceManager.setReportOverTime(optInt6);
                }
                int optInt7 = jSONObject2.optInt("l1");
                if (optInt7 > 0) {
                    sharedPreferenceManager.setUploadNumberCondition(optInt7);
                }
                int optInt8 = jSONObject2.optInt("l2");
                if (optInt8 > 0) {
                    sharedPreferenceManager.setUploadNumberLimit(optInt8);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public boolean report(String str, String str2) {
        InterceptResult invokeLL;
        String encryptRequestPost;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                encryptRequestPost = EncryptConnUtil.encryptRequestPost(this.mContext, CommonMethods.getUrl(this.mContext) + "p/1/r", str, false, false);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (TextUtils.isEmpty(encryptRequestPost)) {
                return false;
            }
            return new JSONObject(encryptRequestPost).getInt("response") == 1;
        }
        return invokeLL.booleanValue;
    }
}
