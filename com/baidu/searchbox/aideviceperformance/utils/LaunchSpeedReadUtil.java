package com.baidu.searchbox.aideviceperformance.utils;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.aideviceperformance.data.DBItemModel;
import com.baidu.searchbox.aideviceperformance.data.LaunchTimeSQLiteOpenHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class LaunchSpeedReadUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CACHE_EXPIRE_TIME = 604800000;
    public static final boolean DEBUG;
    public static final int MAX_DATA_COUNT = 50;
    public static final int MIN_DATA_COUNT = 8;
    public static final String TAG = "LaunchSpeedReadUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-977862140, "Lcom/baidu/searchbox/aideviceperformance/utils/LaunchSpeedReadUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-977862140, "Lcom/baidu/searchbox/aideviceperformance/utils/LaunchSpeedReadUtil;");
                return;
            }
        }
        DEBUG = Config.isDebug();
    }

    public LaunchSpeedReadUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private float calculateAve(List<DBItemModel.LaunchTimeItemModel> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, list)) == null) {
            if (list == null || list.size() < 8) {
                return -1.0f;
            }
            long j = list.get(0).launchTime;
            long j2 = 0;
            long j3 = j;
            for (DBItemModel.LaunchTimeItemModel launchTimeItemModel : list) {
                if (DEBUG) {
                    Log.d(TAG, "Launch Time: " + launchTimeItemModel.launchTime);
                }
                long j4 = launchTimeItemModel.launchTime;
                if (j4 > j) {
                    j = j4;
                }
                long j5 = launchTimeItemModel.launchTime;
                if (j5 < j3) {
                    j3 = j5;
                }
                j2 += launchTimeItemModel.launchTime;
            }
            return ((((float) j2) - ((float) j)) - ((float) j3)) / (list.size() - 2);
        }
        return invokeL.floatValue;
    }

    public float calculateAverageLaunchTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            List<DBItemModel.LaunchTimeItemModel> queryLast = LaunchTimeSQLiteOpenHelper.getInstance(context).queryLast(50);
            if (queryLast == null) {
                if (DEBUG) {
                    Log.d(TAG, "launchTimeItems null");
                }
                return -1.0f;
            } else if (queryLast.size() < 8) {
                if (DEBUG) {
                    Log.d(TAG, "launchTimeItems not enough : " + queryLast.size());
                }
                return -1.0f;
            } else {
                return calculateAve(queryLast);
            }
        }
        return invokeL.floatValue;
    }
}
