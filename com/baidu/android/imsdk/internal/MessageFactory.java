package com.baidu.android.imsdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class MessageFactory {
    public static final String TAG = "MessageFactory";
    public static MessageFactory mInstance;
    public Map<Integer, Class<?>> classMap;

    @SuppressLint({"UseSparseArrays"})
    public MessageFactory() {
        this.classMap = null;
        this.classMap = new HashMap();
    }

    public static MessageFactory getInstance() {
        if (mInstance == null) {
            mInstance = new MessageFactory();
        }
        return mInstance;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: java.lang.reflect.Method */
    /* JADX WARN: Multi-variable type inference failed */
    private Message invokeMethod(Context context, String str, int i, Class<?>[] clsArr, Object[] objArr, Intent intent) {
        Message message;
        synchronized (mInstance) {
            Message message2 = null;
            if (this.classMap.isEmpty()) {
                return null;
            }
            Class<?> cls = this.classMap.get(Integer.valueOf(i));
            if (cls == null) {
                LogUtils.d(TAG, ": don't hava class ,type=" + i);
                return null;
            }
            try {
                Method method = cls.getMethod(str, clsArr);
                if (method != 0) {
                    try {
                        message2 = (Message) method.invoke(cls, objArr);
                    } catch (Exception e2) {
                        e = e2;
                        Message message3 = message2;
                        message2 = method;
                        message = message3;
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(LogUtils.TAG, "IllegalArgumentException " + cls.getSimpleName() + ":" + message2, e);
                        message2 = message;
                        return message2;
                    }
                }
                if (intent != null && message2 != null && intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                    message2.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                }
            } catch (Exception e3) {
                e = e3;
                message = null;
            }
            return message2;
        }
    }

    public void addType(int i, Class<?> cls) {
        synchronized (mInstance) {
            try {
                this.classMap.put(Integer.valueOf(i), cls);
            } catch (SecurityException e2) {
                LogUtils.e(LogUtils.TAG, "", e2);
            }
        }
    }

    public Message createNewMessage(Context context, int i, Intent intent) {
        return invokeMethod(context, "newInstance", i, new Class[]{Context.class, Intent.class}, new Object[]{context, intent}, intent);
    }

    public Message parseMessage(Context context, int i, String str, String str2, String str3) {
        return invokeMethod(context, "parseBody", i, new Class[]{Context.class, String.class, String.class, String.class}, new Object[]{context, str, str2, str3}, null);
    }
}
