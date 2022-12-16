package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void acceptPaPush(Context context, long j, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), iAcceptPaPushListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iAcceptPaPushListener != null) {
                    iAcceptPaPushListener.onAcceptPaPushResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
                    return;
                }
                return;
            }
            PaManagerImpl.getInstance(context).acceptPaPush(j, z, iAcceptPaPushListener);
        }
    }

    public static void clickPaQuickReply(Context context, long j, String str, long j2, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Long.valueOf(j), str, Long.valueOf(j2), iClickPaQuickReplyListener}) == null) {
            PaManagerImpl.getInstance(context).clickPaQuickReply(j, str, j2, iClickPaQuickReplyListener);
        }
    }

    public static void delPaLocalInfosByPaType(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, context, i) == null) {
            LogUtils.d(BaseManager.TAG, "---delPaLocalInfosByPaType---");
            PaManagerImpl.getInstance(context).delPaLocalInfosByPaType(i);
        }
    }

    public static PaInfo getPaInfo(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, j)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return PaManagerImpl.getInstance(context).getPaInfo(j);
        }
        return (PaInfo) invokeLJ.objValue;
    }

    public static PaInfo getPaInfoByThirdId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            return PaManagerImpl.getInstance(context).getPaInfoByThirdId(str);
        }
        return (PaInfo) invokeLL.objValue;
    }

    public static List<PaInfo> getPaInfoListFromDb(Context context, List<Long> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, list)) == null) {
            return PaManagerImpl.getInstance(context).getPaInfoListFromDb(list);
        }
        return (List) invokeLL.objValue;
    }

    public static void querySubscribedPaList(Context context, IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65549, null, context, iQuerySubscribedPaListListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).queryPaInfoList(iQuerySubscribedPaListListener);
    }

    @Deprecated
    public static void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65551, null, context, iPaSubscriptionChangeListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).registerPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
    }

    public static void registerSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, context, iSubscriptionChangeListener) == null) && !BaseManager.isNullContext(context) && iSubscriptionChangeListener != null) {
            PaManagerImpl.getInstance(context).registerSubscriptionChangeListener(iSubscriptionChangeListener);
        }
    }

    public static void syncAllPainfo(Context context, IGetPaInfosListener iGetPaInfosListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, context, iGetPaInfosListener) == null) {
            PaManagerImpl.getInstance(context).syncAllPainfo(context, iGetPaInfosListener);
        }
    }

    @Deprecated
    public static void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65557, null, context, iPaSubscriptionChangeListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).unregisterPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
    }

    public static void unregisterSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65558, null, context, iSubscriptionChangeListener) == null) && !BaseManager.isNullContext(context) && iSubscriptionChangeListener != null) {
            PaManagerImpl.getInstance(context).unregisterPaSubscriptionChangeListener(iSubscriptionChangeListener);
        }
    }

    public static void getPaInfo(Context context, long j, IGetPaInfoListener iGetPaInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, Long.valueOf(j), iGetPaInfoListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iGetPaInfoListener != null) {
                    iGetPaInfoListener.onGetPaInfoResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                    return;
                }
                return;
            }
            PaManagerImpl.getInstance(context).getPaInfo(j, iGetPaInfoListener);
        }
    }

    public static void isSubscribed(Context context, long j, IIsSubscribedListener iIsSubscribedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, Long.valueOf(j), iIsSubscribedListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iIsSubscribedListener != null) {
                    iIsSubscribedListener.onIsSubscribedResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j, false);
                    return;
                }
                return;
            }
            PaManagerImpl.getInstance(context).isSubscribed(j, iIsSubscribedListener);
        }
    }

    public static void subscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, Long.valueOf(j), iSubscribePaListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iSubscribePaListener != null) {
                    iSubscribePaListener.onSubsribePaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
                    return;
                }
                return;
            }
            PaManagerImpl.getInstance(context).subscribePa(j, iSubscribePaListener);
        }
    }

    public static void unSubscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, Long.valueOf(j), iSubscribePaListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iSubscribePaListener != null) {
                    iSubscribePaListener.onUnsubsribePaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
                    return;
                }
                return;
            }
            PaManagerImpl.getInstance(context).unsubscribePa(j, iSubscribePaListener);
        }
    }

    public static void getPaInfos(Context context, ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, arrayList, iGetPaInfosListener) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iGetPaInfosListener != null) {
                    iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                    return;
                }
                return;
            }
            PaManagerImpl.getInstance(context).getPaInfos(arrayList, iGetPaInfosListener);
        }
    }

    public static void getPaQuickReplies(Context context, long j, IGetQuickReplyListener iGetQuickReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, Long.valueOf(j), iGetQuickReplyListener}) == null) {
            PaManagerImpl.getInstance(context).getPaQuickReplies(j, iGetQuickReplyListener);
        }
    }

    public static void getPaInfos(Context context, ArrayList<Long> arrayList, boolean z, IGetPaInfosListener iGetPaInfosListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, arrayList, Boolean.valueOf(z), iGetPaInfosListener}) == null) {
            if (!BaseManager.isNullContext(context) && arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<Long> it = arrayList.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    if (longValue > 0) {
                        arrayList2.add(Long.valueOf(longValue));
                    }
                }
                if (arrayList2.size() == 0) {
                    if (iGetPaInfosListener != null) {
                        iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                    }
                } else if (z) {
                    getPaInfos(context, arrayList2, iGetPaInfosListener);
                } else {
                    List<PaInfo> paInfoListFromDb = getPaInfoListFromDb(context, arrayList2);
                    if (paInfoListFromDb != null && paInfoListFromDb.size() != 0) {
                        if (paInfoListFromDb.size() == arrayList2.size()) {
                            if (iGetPaInfosListener != null) {
                                iGetPaInfosListener.onResult(0, Constants.ERROR_MSG_SUCCESS, new ArrayList<>(paInfoListFromDb));
                                return;
                            }
                            return;
                        }
                        for (PaInfo paInfo : paInfoListFromDb) {
                            arrayList2.remove(Long.valueOf(paInfo.getPaId()));
                        }
                        getPaInfos(context, arrayList2, new IGetPaInfosListener(paInfoListFromDb, iGetPaInfosListener) { // from class: com.baidu.android.imsdk.pubaccount.PaManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List val$infos;
                            public final /* synthetic */ IGetPaInfosListener val$listener;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {paInfoListFromDb, iGetPaInfosListener};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$infos = paInfoListFromDb;
                                this.val$listener = iGetPaInfosListener;
                            }

                            @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                            public void onResult(int i, String str, ArrayList<PaInfo> arrayList3) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, arrayList3) == null) {
                                    if (arrayList3 != null) {
                                        this.val$infos.addAll(arrayList3);
                                    }
                                    IGetPaInfosListener iGetPaInfosListener2 = this.val$listener;
                                    if (iGetPaInfosListener2 != null) {
                                        iGetPaInfosListener2.onResult(0, Constants.ERROR_MSG_SUCCESS, new ArrayList<>(this.val$infos));
                                    }
                                }
                            }
                        });
                        return;
                    }
                    getPaInfos(context, arrayList2, iGetPaInfosListener);
                }
            } else if (iGetPaInfosListener != null) {
                iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        }
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, context) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context);
    }

    public static List<PaInfo> querySubscribedPaListSync(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return PaManagerImpl.getInstance(context).querySubscribedPaListSync(context);
        }
        return (List) invokeL.objValue;
    }

    public static void syncAllPainfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            PaManagerImpl.getInstance(context).syncAllPainfo(context);
        }
    }
}
