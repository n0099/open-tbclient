package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PaManager extends BaseManager {
    public static void acceptPaPush(Context context, long j, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        if (!BaseManager.isNullContext(context)) {
            PaManagerImpl.getInstance(context).acceptPaPush(j, z, iAcceptPaPushListener);
        } else if (iAcceptPaPushListener != null) {
            iAcceptPaPushListener.onAcceptPaPushResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
        }
    }

    public static void clickPaQuickReply(Context context, long j, String str, long j2, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        PaManagerImpl.getInstance(context).clickPaQuickReply(j, str, j2, iClickPaQuickReplyListener);
    }

    public static void delPaLocalInfosByPaType(Context context, int i) {
        LogUtils.d(BaseManager.TAG, "---delPaLocalInfosByPaType---");
        PaManagerImpl.getInstance(context).delPaLocalInfosByPaType(i);
    }

    public static PaInfo getPaInfo(Context context, long j) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return PaManagerImpl.getInstance(context).getPaInfo(j);
    }

    public static void getPaInfos(Context context, ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        if (!BaseManager.isNullContext(context)) {
            PaManagerImpl.getInstance(context).getPaInfos(arrayList, iGetPaInfosListener);
        } else if (iGetPaInfosListener != null) {
            iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        }
    }

    public static void getPaQuickReplies(Context context, long j, IGetQuickReplyListener iGetQuickReplyListener) {
        PaManagerImpl.getInstance(context).getPaQuickReplies(j, iGetQuickReplyListener);
    }

    public static void init(Context context) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context);
    }

    public static void isSubscribed(Context context, long j, IIsSubscribedListener iIsSubscribedListener) {
        if (!BaseManager.isNullContext(context)) {
            PaManagerImpl.getInstance(context).isSubscribed(j, iIsSubscribedListener);
        } else if (iIsSubscribedListener != null) {
            iIsSubscribedListener.onIsSubscribedResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j, false);
        }
    }

    public static void querySubscribedPaList(Context context, IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).queryPaInfoList(iQuerySubscribedPaListListener);
    }

    public static List<PaInfo> querySubscribedPaListSync(Context context) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return PaManagerImpl.getInstance(context).querySubscribedPaListSync(context);
    }

    @Deprecated
    public static void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).registerPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
    }

    public static void registerSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        if (BaseManager.isNullContext(context) || iSubscriptionChangeListener == null) {
            return;
        }
        PaManagerImpl.getInstance(context).registerSubscriptionChangeListener(iSubscriptionChangeListener);
    }

    public static void subscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        if (!BaseManager.isNullContext(context)) {
            PaManagerImpl.getInstance(context).subscribePa(j, iSubscribePaListener);
        } else if (iSubscribePaListener != null) {
            iSubscribePaListener.onSubsribePaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
        }
    }

    public static void syncAllPainfo(Context context) {
        PaManagerImpl.getInstance(context).syncAllPainfo(context);
    }

    public static void unSubscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        if (!BaseManager.isNullContext(context)) {
            PaManagerImpl.getInstance(context).unsubscribePa(j, iSubscribePaListener);
        } else if (iSubscribePaListener != null) {
            iSubscribePaListener.onUnsubsribePaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, j);
        }
    }

    @Deprecated
    public static void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).unregisterPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
    }

    public static void unregisterSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        if (BaseManager.isNullContext(context) || iSubscriptionChangeListener == null) {
            return;
        }
        PaManagerImpl.getInstance(context).unregisterPaSubscriptionChangeListener(iSubscriptionChangeListener);
    }

    public void searchPaList(Context context, String str, ISearchPaListListener iSearchPaListListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        PaManagerImpl.getInstance(context).searchPaList(str, iSearchPaListListener);
    }

    public static void getPaInfo(Context context, long j, IGetPaInfoListener iGetPaInfoListener) {
        if (!BaseManager.isNullContext(context)) {
            PaManagerImpl.getInstance(context).getPaInfo(j, iGetPaInfoListener);
        } else if (iGetPaInfoListener != null) {
            iGetPaInfoListener.onGetPaInfoResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        }
    }
}
