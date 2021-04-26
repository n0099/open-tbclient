package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.chatuser.Utility;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class GetChatObjectInfoForRecordManager {
    public static final int RETRYTIMES = 2;
    public static final int TYPE_BOX_PA = 1;
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_DUMI_PA = 100;
    public static final int TYPE_GROUP_DISCUSS = 3;
    public static final int TYPE_GROUP_STAR = 4;
    public static final int TYPE_IP = 10;
    public static final int TYPE_USER = 0;
    public static Map<Pair<Integer, Integer>, String> classFinder;
    public static String[] classNameArray = {"com.baidu.android.imsdk.chatuser.GetUserInfoForRecordHandler", "com.baidu.android.imsdk.group.GetGroupfoForRecordHandler", "com.baidu.android.imsdk.pubaccount.GetPaInfoForSessionHandler"};
    public static String TAG = GetChatObjectInfoForRecordManager.class.getSimpleName();

    static {
        HashMap hashMap = new HashMap();
        classFinder = hashMap;
        hashMap.put(new Pair(0, 0), classNameArray[0]);
        classFinder.put(new Pair<>(1, 0), classNameArray[1]);
        classFinder.put(new Pair<>(0, 1), classNameArray[2]);
    }

    public static void getChatObjectForSession(final Context context, final ChatObject chatObject) {
        final GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) newInstance(context, chatObject.getCategory(), chatObject.getContacter(), -1);
        if (getChatObjectInfoForRecordHandler == null) {
            return;
        }
        final String chatObject2 = chatObject.toString();
        DBManager.getInstance(context).saveCmdMsg(chatObject2, Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, chatObject.toString(), null, 15, 2);
        getChatObjectInfoForRecordHandler.setUuid(chatObject2);
        DBManager.getInstance(context).updateCmdMsgSendStatus(chatObject2, 2);
        getChatObjectInfoForRecordHandler.getChatObjectInfo(chatObject.getContacter(), new CallBack() { // from class: com.baidu.android.imsdk.GetChatObjectInfoForRecordManager.1
            public int retryTimes = 0;

            @Override // com.baidu.android.imsdk.CallBack
            public void onError(int i2, int i3, long j) {
                String str = GetChatObjectInfoForRecordManager.TAG;
                LogUtils.i(str, "testsession callback type ," + i2 + " ,category :" + i3 + ", contacterId" + j);
                if (i3 == 0 && i2 == 10) {
                    GetChatObjectInfoForRecordHandler.this.updateChatRecord(chatObject, Utility.createAnonyMousUserName(null), 0, "", 0, "", "", 0, 0, 0L, 0, 0L, "", "", "");
                    return;
                }
                int i4 = this.retryTimes + 1;
                this.retryTimes = i4;
                if (i4 >= 2) {
                    DBManager.getInstance(context).updateCmdMsgSendStatus(chatObject2, 1);
                } else {
                    GetChatObjectInfoForRecordHandler.this.getChatObjectInfo(chatObject.getContacter(), this);
                }
            }

            @Override // com.baidu.android.imsdk.CallBack
            public void onSuccess(int i2, int i3, Object obj) {
                if (obj != null) {
                    if (i3 == 0 || i3 == 1) {
                        String str = GetChatObjectInfoForRecordManager.TAG;
                        LogUtils.i(str, "testsession callback" + obj.toString());
                        GetChatObjectInfoForRecordHandler.this.updateChatRecord(chatObject, i2, i3, obj);
                        DBManager.getInstance(context).deleteCmdMsg(chatObject2);
                    }
                }
            }
        });
    }

    public static Object newInstance(Context context, int i2, long j, int i3) {
        if (i2 == 0) {
            if (i3 != -1) {
                return newInstance(context, i2, i3);
            }
            if ((j & Constants.PAFLAG) == 0) {
                return newInstance(context, i2, 0);
            }
            return newInstance(context, i2, 1);
        }
        return newInstance(context, i2, 0);
    }

    public static Object newInstance(Context context, int i2, int i3) {
        String str = classFinder.get(new Pair(Integer.valueOf(i2), Integer.valueOf(i3)));
        String str2 = TAG;
        LogUtils.i(str2, "className : " + str);
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str).getConstructor(Context.class).newInstance(context);
        } catch (Exception e2) {
            LogUtils.e(LogUtils.TAG, "Class.forName error", e2);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            return null;
        }
    }
}
