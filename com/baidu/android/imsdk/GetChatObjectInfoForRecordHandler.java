package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MethodInvokeUtil;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public abstract class GetChatObjectInfoForRecordHandler {
    private static Method method = null;
    protected Context mContext;
    private String mUuid;

    public abstract void getChatObjectInfo(long j, CallBack callBack);

    public abstract void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj);

    public GetChatObjectInfoForRecordHandler(Context context) {
        this.mContext = context;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }

    public String getUuid() {
        return this.mUuid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateChatRecord(ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j) {
        updateChatRecord("com.baidu.android.imsdk.chatmessage.ChatMsgManager", "createChatSession", new Class[]{Context.class, ChatObject.class, String.class, Integer.TYPE, String.class, Integer.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Long.TYPE}, new Object[]{this.mContext, chatObject, str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)});
    }

    private void updateChatRecord(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls = null;
        try {
            if (method == null) {
                cls = Class.forName(str);
                if (cls != null) {
                    method = cls.getDeclaredMethod(str2, clsArr);
                } else {
                    return;
                }
            }
            if (method != null) {
                MethodInvokeUtil.invoke(method, cls, objArr);
            }
        } catch (Exception e) {
            LogUtils.e(LogUtils.TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteUUid() {
        DBManager.getInstance(this.mContext).deleteCmdMsg(this.mUuid);
    }

    public boolean getChatObjectInfoSync(Context context, long j, CallBack callBack) {
        return false;
    }
}
