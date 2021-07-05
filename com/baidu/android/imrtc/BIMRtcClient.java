package com.baidu.android.imrtc;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.request.BIMRtcAnswerAbilityListener;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCancelRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.send.BIMKickRequestRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BIMRtcClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BIMRtcClient() {
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

    public static void answer(@NonNull Context context, @NonNull BIMAnswerRtcInfo bIMAnswerRtcInfo, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, bIMAnswerRtcInfo, iStatusListener) == null) {
            BIMRtcManager.getInstance(context).answer(bIMAnswerRtcInfo, iStatusListener);
        }
    }

    public static void cancelCall(@NonNull Context context, @NonNull BIMCancelRtcInfo bIMCancelRtcInfo, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, bIMCancelRtcInfo, iStatusListener) == null) {
            BIMRtcManager.getInstance(context).cancelCall(bIMCancelRtcInfo, iStatusListener);
        }
    }

    public static void checkAnswerAbility(@NonNull Context context, String str, String str2, @NonNull BIMRtcAnswerAbilityListener bIMRtcAnswerAbilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, context, str, str2, bIMRtcAnswerAbilityListener) == null) {
            BIMRtcManager.getInstance(context).checkAnswerAbility(str, str2, bIMRtcAnswerAbilityListener);
        }
    }

    public static void closeRoom(@NonNull Context context, @NonNull BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, context, bIMCloseRoomRtcInfo, iStatusListener) == null) {
            BIMRtcManager.getInstance(context).closeRoom(bIMCloseRoomRtcInfo, iStatusListener);
        }
    }

    public static void createRoom(@NonNull Context context, String str, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, bIMRtcTokenListener) == null) {
            BIMRtcManager.getInstance(context).createRoom(str, bIMRtcTokenListener);
        }
    }

    public static void generateToken(@NonNull Context context, String str, String str2, long j, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, str2, Long.valueOf(j), bIMRtcTokenListener}) == null) {
            BIMRtcManager.getInstance(context).generateToken(str, str2, j, bIMRtcTokenListener);
        }
    }

    public static void hangout(@NonNull Context context, @NonNull String str, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, str, iStatusListener) == null) {
            BIMRtcManager.getInstance(context).hangout(str, iStatusListener);
        }
    }

    public static void invite(@NonNull Context context, @NonNull BIMInviteRtcInfo bIMInviteRtcInfo, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, bIMInviteRtcInfo, iStatusListener) == null) {
            BIMRtcManager.getInstance(context).invite(bIMInviteRtcInfo, iStatusListener);
        }
    }

    public static void join(@NonNull Context context, @NonNull String str, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, iStatusListener) == null) {
            BIMRtcManager.getInstance(context).join(str, iStatusListener);
        }
    }

    public static void kickoff(Context context, @NonNull BIMKickRequestRtcInfo bIMKickRequestRtcInfo, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, bIMKickRequestRtcInfo, iStatusListener) == null) {
            BIMRtcManager.getInstance(context).kickoff(bIMKickRequestRtcInfo, iStatusListener);
        }
    }

    public static void registerRtcListener(@NonNull Context context, @NonNull BIMRtcListener bIMRtcListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, bIMRtcListener) == null) {
            BIMRtcManager.getInstance(context).registerRtcListener(bIMRtcListener);
        }
    }

    public static String report(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? BIMRtcManager.getInstance(context).report() : (String) invokeL.objValue;
    }

    public static void setRtcDebugAndLogEnable(@NonNull Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            BIMRtcManager.getInstance(context).setRtcDebugEnv(context, z);
            RtcConstants.LOG_DEBUG = z2;
        }
    }

    public static void unRegisterRtcListener(@NonNull Context context, @NonNull BIMRtcListener bIMRtcListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, bIMRtcListener) == null) {
            BIMRtcManager.getInstance(context).unRegisterRtcListener(bIMRtcListener);
        }
    }

    public static void createRoom(@NonNull Context context, String str, String str2, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2, bIMRtcTokenListener) == null) {
            BIMRtcManager.getInstance(context).createRoom(str, str2, bIMRtcTokenListener);
        }
    }

    public static void hangout(@NonNull Context context, @NonNull BIMRtcInfo bIMRtcInfo, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, bIMRtcInfo, iStatusListener) == null) {
            BIMRtcManager.getInstance(context).hangout(bIMRtcInfo, iStatusListener);
        }
    }
}
