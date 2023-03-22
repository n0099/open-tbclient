package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tieba.m35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* loaded from: classes3.dex */
public class MemberBroadcastHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BROADCAST_TYPE_DAILY = 1;
    public static final int BROADCAST_TYPE_OM = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public MemberBroadcastData mMemberBroadcastData;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SpType {
    }

    public MemberBroadcastHelper(MemberBroadcastData memberBroadcastData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberBroadcastData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMemberBroadcastData = memberBroadcastData;
    }

    private void clearSaveInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            String generatorSpNumKey = generatorSpNumKey(i);
            String generatorSpTimeKey = generatorSpTimeKey(i);
            if (!StringUtils.isNull(generatorSpNumKey)) {
                m35.m().H(generatorSpNumKey);
            }
            if (!StringUtils.isNull(generatorSpTimeKey)) {
                m35.m().H(generatorSpTimeKey);
            }
        }
    }

    public static String generatorSpNumKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i == 1) {
                return m35.q("key_daily_member_broadcast_show_num_");
            }
            if (i == 2) {
                return m35.q("key_om_member_broadcast_show_num_");
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public static String generatorSpTimeKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return m35.q("key_daily_member_broadcast_show_time_");
            }
            if (i == 2) {
                return m35.q("key_om_member_broadcast_show_time_");
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    private int getSpNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            String generatorSpNumKey = generatorSpNumKey(i);
            if (!TimeHelper.isSameDay(m35.m().o(generatorSpTimeKey(i), 0L), System.currentTimeMillis())) {
                clearSaveInfo(i);
                return 0;
            }
            return m35.m().n(generatorSpNumKey, 0);
        }
        return invokeI.intValue;
    }

    private boolean isMeetTimeInterval(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
            long o = m35.m().o(generatorSpTimeKey(i), 0L);
            if (i == 1) {
                i2 = this.mMemberBroadcastData.getDailyMinStep();
            } else if (i == 2) {
                i2 = this.mMemberBroadcastData.getOmMinStep();
            } else {
                i2 = 0;
            }
            if ((System.currentTimeMillis() - o) / 1000 > i2) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void saveSpInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            String generatorSpNumKey = generatorSpNumKey(i);
            String generatorSpTimeKey = generatorSpTimeKey(i);
            if (!StringUtils.isNull(generatorSpNumKey)) {
                m35.m().z(generatorSpNumKey, m35.m().n(generatorSpNumKey, 0) + 1);
            }
            if (!StringUtils.isNull(generatorSpTimeKey)) {
                m35.m().A(generatorSpTimeKey, System.currentTimeMillis());
            }
        }
    }

    public boolean isMeetFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MemberBroadcastData memberBroadcastData = this.mMemberBroadcastData;
            if (memberBroadcastData == null) {
                return false;
            }
            if (memberBroadcastData.getBroadcastType() == 1) {
                if (!isMeetTimeInterval(1) || getSpNum(1) >= this.mMemberBroadcastData.getDailyMaxNum()) {
                    return false;
                }
                return true;
            } else if (this.mMemberBroadcastData.getBroadcastType() != 2 || !isMeetTimeInterval(2) || getSpNum(2) >= this.mMemberBroadcastData.getOmMaxNum()) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
