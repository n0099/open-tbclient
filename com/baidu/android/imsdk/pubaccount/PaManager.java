package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PaManager extends BaseManager {
    public static void init(Context context) {
        if (!isNullContext(context)) {
            PaManagerImpl.getInstance(context);
        }
    }

    public static List<PaInfo> querySubscribedPaListSync(Context context) {
        if (isNullContext(context)) {
            return null;
        }
        return PaManagerImpl.getInstance(context).querySubscribedPaListSync(context);
    }

    public static PaInfo getPaInfo(Context context, long j) {
        if (isNullContext(context)) {
            return null;
        }
        return PaManagerImpl.getInstance(context).getPaInfo(j);
    }

    @Deprecated
    public static void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        if (!isNullContext(context)) {
            PaManagerImpl.getInstance(context).unregisterPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
        }
    }

    @Deprecated
    public static void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        if (!isNullContext(context)) {
            PaManagerImpl.getInstance(context).registerPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
        }
    }

    public static void registerSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        if (!isNullContext(context) && iSubscriptionChangeListener != null) {
            PaManagerImpl.getInstance(context).registerSubscriptionChangeListener(iSubscriptionChangeListener);
        }
    }

    public static void unregisterSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        if (!isNullContext(context) && iSubscriptionChangeListener != null) {
            PaManagerImpl.getInstance(context).unregisterPaSubscriptionChangeListener(iSubscriptionChangeListener);
        }
    }

    public static void subscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        if (isNullContext(context)) {
            if (iSubscribePaListener != null) {
                iSubscribePaListener.onSubsribePaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
                return;
            }
            return;
        }
        PaManagerImpl.getInstance(context).subscribePa(j, iSubscribePaListener);
    }

    public static void unSubscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        if (isNullContext(context)) {
            if (iSubscribePaListener != null) {
                iSubscribePaListener.onUnsubsribePaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
                return;
            }
            return;
        }
        PaManagerImpl.getInstance(context).unsubscribePa(j, iSubscribePaListener);
    }

    public static void getPaInfo(Context context, long j, IGetPaInfoListener iGetPaInfoListener) {
        if (isNullContext(context)) {
            if (iGetPaInfoListener != null) {
                iGetPaInfoListener.onGetPaInfoResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                return;
            }
            return;
        }
        PaManagerImpl.getInstance(context).getPaInfo(j, iGetPaInfoListener);
    }

    public static void getPaInfos(Context context, ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        if (isNullContext(context)) {
            if (iGetPaInfosListener != null) {
                iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                return;
            }
            return;
        }
        PaManagerImpl.getInstance(context).getPaInfos(arrayList, iGetPaInfosListener);
    }

    public void searchPaList(Context context, String str, ISearchPaListListener iSearchPaListListener) {
        if (!isNullContext(context)) {
            PaManagerImpl.getInstance(context).searchPaList(str, iSearchPaListListener);
        }
    }

    public static void querySubscribedPaList(Context context, IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        if (!isNullContext(context)) {
            PaManagerImpl.getInstance(context).queryPaInfoList(iQuerySubscribedPaListListener);
        }
    }

    public static void acceptPaPush(Context context, long j, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        if (isNullContext(context)) {
            if (iAcceptPaPushListener != null) {
                iAcceptPaPushListener.onAcceptPaPushResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
                return;
            }
            return;
        }
        PaManagerImpl.getInstance(context).acceptPaPush(j, z, iAcceptPaPushListener);
    }

    public static void isSubscribed(Context context, long j, IIsSubscribedListener iIsSubscribedListener) {
        if (isNullContext(context)) {
            if (iIsSubscribedListener != null) {
                iIsSubscribedListener.onIsSubscribedResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j, false);
                return;
            }
            return;
        }
        PaManagerImpl.getInstance(context).isSubscribed(j, iIsSubscribedListener);
    }

    public static void syncAllPainfo(Context context) {
        PaManagerImpl.getInstance(context).syncAllPainfo(context);
    }

    public static void delPaLocalInfosByPaType(Context context, int i) {
        LogUtils.d(TAG, "---delPaLocalInfosByPaType---");
        PaManagerImpl.getInstance(context).delPaLocalInfosByPaType(i);
    }

    public static void getPaQuickReplies(Context context, long j, IGetQuickReplyListener iGetQuickReplyListener) {
        PaManagerImpl.getInstance(context).getPaQuickReplies(j, iGetQuickReplyListener);
    }

    public static void clickPaQuickReply(Context context, long j, String str, long j2, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        PaManagerImpl.getInstance(context).clickPaQuickReply(j, str, j2, iClickPaQuickReplyListener);
    }
}
