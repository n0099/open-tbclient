package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PaManager extends BaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PaManager() {
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

    public static void acceptPaPush(Context context, long j, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), iAcceptPaPushListener}) == null) {
            if (!BaseManager.isNullContext(context)) {
                PaManagerImpl.getInstance(context).acceptPaPush(j, z, iAcceptPaPushListener);
            } else if (iAcceptPaPushListener != null) {
                iAcceptPaPushListener.onAcceptPaPushResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
            }
        }
    }

    public static void clickPaQuickReply(Context context, long j, String str, long j2, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Long.valueOf(j), str, Long.valueOf(j2), iClickPaQuickReplyListener}) == null) {
            PaManagerImpl.getInstance(context).clickPaQuickReply(j, str, j2, iClickPaQuickReplyListener);
        }
    }

    public static void delPaLocalInfosByPaType(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, context, i2) == null) {
            LogUtils.d(BaseManager.TAG, "---delPaLocalInfosByPaType---");
            PaManagerImpl.getInstance(context).delPaLocalInfosByPaType(i2);
        }
    }

    public static PaInfo getPaInfo(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65540, null, context, j)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return PaManagerImpl.getInstance(context).getPaInfo(j);
        }
        return (PaInfo) invokeLJ.objValue;
    }

    public static void getPaInfos(Context context, ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, arrayList, iGetPaInfosListener) == null) {
            if (!BaseManager.isNullContext(context)) {
                PaManagerImpl.getInstance(context).getPaInfos(arrayList, iGetPaInfosListener);
            } else if (iGetPaInfosListener != null) {
                iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        }
    }

    public static void getPaQuickReplies(Context context, long j, IGetQuickReplyListener iGetQuickReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, Long.valueOf(j), iGetQuickReplyListener}) == null) {
            PaManagerImpl.getInstance(context).getPaQuickReplies(j, iGetQuickReplyListener);
        }
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, context) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context);
    }

    public static void isSubscribed(Context context, long j, IIsSubscribedListener iIsSubscribedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, Long.valueOf(j), iIsSubscribedListener}) == null) {
            if (!BaseManager.isNullContext(context)) {
                PaManagerImpl.getInstance(context).isSubscribed(j, iIsSubscribedListener);
            } else if (iIsSubscribedListener != null) {
                iIsSubscribedListener.onIsSubscribedResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j, false);
            }
        }
    }

    public static void querySubscribedPaList(Context context, IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, iQuerySubscribedPaListListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).queryPaInfoList(iQuerySubscribedPaListListener);
    }

    public static List<PaInfo> querySubscribedPaListSync(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return PaManagerImpl.getInstance(context).querySubscribedPaListSync(context);
        }
        return (List) invokeL.objValue;
    }

    @Deprecated
    public static void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, context, iPaSubscriptionChangeListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).registerPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
    }

    public static void registerSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, context, iSubscriptionChangeListener) == null) || BaseManager.isNullContext(context) || iSubscriptionChangeListener == null) {
            return;
        }
        PaManagerImpl.getInstance(context).registerSubscriptionChangeListener(iSubscriptionChangeListener);
    }

    public static void subscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, Long.valueOf(j), iSubscribePaListener}) == null) {
            if (!BaseManager.isNullContext(context)) {
                PaManagerImpl.getInstance(context).subscribePa(j, iSubscribePaListener);
            } else if (iSubscribePaListener != null) {
                iSubscribePaListener.onSubsribePaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
            }
        }
    }

    public static void syncAllPainfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
            PaManagerImpl.getInstance(context).syncAllPainfo(context);
        }
    }

    public static void unSubscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, Long.valueOf(j), iSubscribePaListener}) == null) {
            if (!BaseManager.isNullContext(context)) {
                PaManagerImpl.getInstance(context).unsubscribePa(j, iSubscribePaListener);
            } else if (iSubscribePaListener != null) {
                iSubscribePaListener.onUnsubsribePaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
            }
        }
    }

    @Deprecated
    public static void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, context, iPaSubscriptionChangeListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).unregisterPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
    }

    public static void unregisterSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, context, iSubscriptionChangeListener) == null) || BaseManager.isNullContext(context) || iSubscriptionChangeListener == null) {
            return;
        }
        PaManagerImpl.getInstance(context).unregisterPaSubscriptionChangeListener(iSubscriptionChangeListener);
    }

    public void searchPaList(Context context, String str, ISearchPaListListener iSearchPaListListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, str, iSearchPaListListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).searchPaList(str, iSearchPaListListener);
    }

    public static void getPaInfo(Context context, long j, IGetPaInfoListener iGetPaInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Long.valueOf(j), iGetPaInfoListener}) == null) {
            if (!BaseManager.isNullContext(context)) {
                PaManagerImpl.getInstance(context).getPaInfo(j, iGetPaInfoListener);
            } else if (iGetPaInfoListener != null) {
                iGetPaInfoListener.onGetPaInfoResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        }
    }
}
