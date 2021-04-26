package com.baidu.mobads.container.components.statemachine;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class StateMachine {
    public static final int MAX_CACHED_AD_NUM = 100;
    public static final long STATE_TIME_OUT_MILLIS = 1800000;
    public static Context mContext;
    public static String mLastAdEvent;
    public static String mLastAdId;
    public static ConcurrentHashMap<String, AdStateInstance> mAdStatusList = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, String> mIdTransformMap = new ConcurrentHashMap<>();
    public static LinkedList<String> mAdOrderList = new LinkedList<>();

    public static boolean addIdMapper(String str, String str2) {
        return false;
    }

    public static void createState(long j, String str, IXAdInstanceInfo iXAdInstanceInfo) {
        if (j < 0 || iXAdInstanceInfo == null) {
            return;
        }
        String uniqueId = iXAdInstanceInfo.getUniqueId();
        if (TextUtils.isEmpty(uniqueId)) {
            return;
        }
        if (getAdStateById(uniqueId) == null) {
            mAdStatusList.put(uniqueId, new AdStateInstance(j, str, iXAdInstanceInfo));
            mAdOrderList.add(uniqueId);
        }
        StateUploadScheduler.getInstance().start();
    }

    public static void event(String str, AdStateCode adStateCode) {
    }

    public static void event(String str, String str2) {
    }

    public static void event(String str, String str2, String str3) {
    }

    public static void finish(String str) {
    }

    public static AdStateInstance getAdStateById(String str) {
        try {
            if (TextUtils.isEmpty(str) || mAdStatusList.size() <= 0) {
                return null;
            }
            if (!mAdStatusList.containsKey(str) && mIdTransformMap.containsKey(str)) {
                str = mIdTransformMap.get(str);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return mAdStatusList.get(str);
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d(th);
            return null;
        }
    }

    public static void markTimeoutState() {
        try {
            Set<String> keySet = mAdStatusList.keySet();
            if (keySet == null || keySet.size() <= 0) {
                return;
            }
            for (String str : keySet) {
                AdStateInstance adStateById = getAdStateById(str);
                if (adStateById != null && System.currentTimeMillis() - adStateById.mRequestTimeMillis > 1800000) {
                    adStateById.markReady4Send(true);
                    String str2 = AdStateEvent.EVENT_AD_TIMEOUT;
                    adStateById.addExtra(str2, System.currentTimeMillis() + "");
                }
            }
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d(th);
        }
    }

    public static long queryLong(String str, String str2) {
        return 0L;
    }

    public static String queryPossibleUniqueId(String str) {
        return null;
    }

    public static void removeUnusedState() {
        try {
            if (mAdStatusList.size() > 100) {
                Set<String> keySet = mAdStatusList.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        AdStateInstance adStateInstance = mAdStatusList.get(str);
                        if (adStateInstance != null && adStateInstance.isHasSend.get()) {
                            mAdStatusList.remove(str);
                            mAdOrderList.remove(str);
                        }
                    }
                }
                if (mAdStatusList.size() > 100) {
                    int size = mAdStatusList.size() - 100;
                    for (int i2 = 0; i2 < size; i2++) {
                        mAdOrderList.remove(0);
                        mAdStatusList.remove(mAdOrderList.getFirst());
                    }
                }
                Set<String> keySet2 = mIdTransformMap.keySet();
                if (keySet2.size() > 0) {
                    for (String str2 : keySet2) {
                        String str3 = mIdTransformMap.get(str2);
                        if (!TextUtils.isEmpty(str3) && !mAdStatusList.containsKey(str3)) {
                            mIdTransformMap.remove(str2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d(th);
        }
    }

    public static void sendLog(AdStateInstance adStateInstance) {
        try {
            if (mContext != null) {
                SendLogUtil.Builder append = SendLogUtil.Builder.create(mContext).appendType(SDKLogTypeConstants.STATE_MACHINE).appendAdInfo(adStateInstance.mAdInstanceInfo).appendProdType(adStateInstance.mProdType).append("states", adStateInstance.getAllState());
                String str = AdStateEvent.EVENT_REQUEST_TIME;
                append.append(str, "" + adStateInstance.mRequestTimeMillis).append(adStateInstance.getExtraInfo()).send();
                adStateInstance.setHasSend(true);
            }
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d(th);
        }
    }

    public static void setApplicationContext(Context context) {
        if (context == null || mContext != null) {
            return;
        }
        mContext = context.getApplicationContext();
    }

    public static void uploadState() {
        try {
            if (mAdStatusList.size() > 0) {
                for (String str : mAdStatusList.keySet()) {
                    AdStateInstance adStateInstance = mAdStatusList.get(str);
                    if (adStateInstance != null && adStateInstance.isReady4Send.get() && !adStateInstance.isHasSend.get()) {
                        sendLog(adStateInstance);
                    }
                }
            }
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().d(th);
        }
    }
}
