package com.baidu.searchbox.aideviceperformance.utils;

import android.content.Context;
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
/* loaded from: classes4.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private float calculateAve(List<DBItemModel.LaunchTimeItemModel> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, list)) == null) {
            if (list != null && list.size() >= 8) {
                long j2 = list.get(0).launchTime;
                long j3 = 0;
                long j4 = j2;
                for (DBItemModel.LaunchTimeItemModel launchTimeItemModel : list) {
                    if (DEBUG) {
                        String str = "Launch Time: " + launchTimeItemModel.launchTime;
                    }
                    long j5 = launchTimeItemModel.launchTime;
                    if (j5 > j2) {
                        j2 = j5;
                    }
                    long j6 = launchTimeItemModel.launchTime;
                    if (j6 < j4) {
                        j4 = j6;
                    }
                    j3 += launchTimeItemModel.launchTime;
                }
                return ((((float) j3) - ((float) j2)) - ((float) j4)) / (list.size() - 2);
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    public float calculateAverageLaunchTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            List<DBItemModel.LaunchTimeItemModel> queryLast = LaunchTimeSQLiteOpenHelper.getInstance(context).queryLast(50);
            if (queryLast == null) {
                boolean z = DEBUG;
                return -1.0f;
            } else if (queryLast.size() < 8) {
                if (DEBUG) {
                    String str = "launchTimeItems not enough : " + queryLast.size();
                }
                return -1.0f;
            } else {
                return calculateAve(queryLast);
            }
        }
        return invokeL.floatValue;
    }
}
