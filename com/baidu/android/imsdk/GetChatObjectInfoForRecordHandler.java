package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MethodInvokeUtil;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class GetChatObjectInfoForRecordHandler {
    public static Method method;
    public Context mContext;
    public String mUuid;

    public GetChatObjectInfoForRecordHandler(Context context) {
        this.mContext = context;
    }

    public void deleteUUid() {
        DBManager.getInstance(this.mContext).deleteCmdMsg(this.mUuid);
    }

    public abstract void getChatObjectInfo(long j, CallBack callBack);

    public boolean getChatObjectInfoSync(Context context, long j, CallBack callBack) {
        return false;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }

    public abstract void updateChatRecord(ChatObject chatObject, int i2, int i3, Object obj);

    public void updateChatRecord(ChatObject chatObject, String str, int i2, String str2, int i3, String str3, String str4, int i4, int i5, long j, int i6, long j2, String str5, String str6, String str7) {
        Object[] objArr = {this.mContext, chatObject, str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, str4, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j), Integer.valueOf(i6), Long.valueOf(j2), str5, str6, str7};
        Class<?> cls = Integer.TYPE;
        updateChatRecord("com.baidu.android.imsdk.chatmessage.ChatMsgManager", "createChatSession", new Class[]{Context.class, ChatObject.class, String.class, cls, String.class, cls, String.class, String.class, cls, cls, Long.TYPE, Integer.TYPE, Long.TYPE, String.class, String.class, String.class}, objArr);
    }

    private void updateChatRecord(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls = null;
        try {
            if (method == null) {
                cls = Class.forName(str);
                if (cls == null) {
                    return;
                }
                method = cls.getDeclaredMethod(str2, clsArr);
            }
            if (method != null) {
                MethodInvokeUtil.invoke(method, cls, objArr);
            }
        } catch (Exception e2) {
            LogUtils.e(LogUtils.TAG, "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }
}
