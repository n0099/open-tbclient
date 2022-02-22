package com.baidu.searchbox.aideviceperformance.stickiness;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.data.DBItemModel;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class StickinessScoreManager implements IStickinessScoreManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int MAX_DATA_COUNT = 50;
    public static final int MIN_DATA_COUNT = 10;
    public static final String TAG = "UserStickinessScore";
    public transient /* synthetic */ FieldHolder $fh;
    public IStickinessScoreDataProvider mStickinessScoreDataProvider;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1289530040, "Lcom/baidu/searchbox/aideviceperformance/stickiness/StickinessScoreManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1289530040, "Lcom/baidu/searchbox/aideviceperformance/stickiness/StickinessScoreManager;");
                return;
            }
        }
        DEBUG = Config.isDebug();
    }

    public StickinessScoreManager(IStickinessScoreDataProvider iStickinessScoreDataProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iStickinessScoreDataProvider};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStickinessScoreDataProvider = iStickinessScoreDataProvider;
    }

    private float getSingleUserStickinessScore(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (i2 <= 0 || j2 <= 0) {
                return 0.0f;
            }
            float f2 = i2 * 0.2f;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            float f3 = 1.5f - (((float) j2) / 60000.0f);
            float f4 = f3 <= 1.0f ? f3 : 1.0f;
            return Math.max(f4 >= 0.0f ? f4 : 0.0f, f2);
        }
        return invokeCommon.floatValue;
    }

    private String getSpKeyStickinessScore(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            return "stickiness_score_" + str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.stickiness.IStickinessScoreManager
    public float getStickinessScore(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1.0f;
            }
            return DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(getSpKeyStickinessScore(str), -1.0f);
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.stickiness.IStickinessScoreManager
    public boolean updateStickinessScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            IStickinessScoreDataProvider iStickinessScoreDataProvider = this.mStickinessScoreDataProvider;
            if (iStickinessScoreDataProvider == null) {
                return false;
            }
            List<DBItemModel.UserStickinessItemModel> queryLast = iStickinessScoreDataProvider.getUserStickinessSQLiteOpenHelper(context).queryLast(51);
            if (queryLast == null) {
                boolean z = DEBUG;
                return false;
            } else if (queryLast.size() <= 10) {
                if (DEBUG) {
                    String str = "userStickinessItems not enough : " + queryLast.size();
                }
                return false;
            } else {
                queryLast.remove(0);
                HashMap hashMap = new HashMap();
                for (DBItemModel.UserStickinessItemModel userStickinessItemModel : queryLast) {
                    if (DEBUG) {
                        String str2 = "userStickinessItem detail : " + userStickinessItemModel.toString();
                    }
                    for (Map.Entry<String, DBItemModel.UserStickinessItemModel.ItemDetailModel> entry : userStickinessItemModel.getIdToItemDetailMap().entrySet()) {
                        String key = entry.getKey();
                        DBItemModel.UserStickinessItemModel.ItemDetailModel value = entry.getValue();
                        if (key != null && value != null) {
                            float singleUserStickinessScore = getSingleUserStickinessScore(value.count, value.firstTime);
                            Float f2 = (Float) hashMap.get(key);
                            if (f2 == null) {
                                hashMap.put(key, Float.valueOf(singleUserStickinessScore));
                            } else {
                                hashMap.put(key, Float.valueOf(singleUserStickinessScore + f2.floatValue()));
                            }
                        } else {
                            boolean z2 = DEBUG;
                            return false;
                        }
                    }
                }
                int size = queryLast.size();
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    float floatValue = ((Float) entry2.getValue()).floatValue() / size;
                    DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(getSpKeyStickinessScore((String) entry2.getKey()), floatValue);
                    if (DEBUG) {
                        String str3 = "stickiness score updated. businessId:" + ((String) entry2.getKey()) + " score:" + floatValue + " userStickinessItems count:" + size;
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
