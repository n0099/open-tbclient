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
/* loaded from: classes18.dex */
public class MessageFactory {
    private static final String TAG = MessageFactory.class.getSimpleName();
    private static MessageFactory mInstance = null;
    private Map<Integer, Class<?>> classMap;

    @SuppressLint({"UseSparseArrays"})
    private MessageFactory() {
        this.classMap = null;
        this.classMap = new HashMap();
    }

    public static MessageFactory getInstance() {
        if (mInstance == null) {
            mInstance = new MessageFactory();
        }
        return mInstance;
    }

    public void addType(int i, Class<?> cls) {
        synchronized (mInstance) {
            try {
                this.classMap.put(Integer.valueOf(i), cls);
            } catch (SecurityException e) {
                LogUtils.e(LogUtils.TAG, "", e);
            }
        }
    }

    public Message createNewMessage(Context context, int i, Intent intent) {
        return invokeMethod(context, "newInstance", i, new Class[]{Context.class, Intent.class}, new Object[]{context, intent}, intent);
    }

    public Message parseMessage(Context context, int i, String str, String str2, String str3) {
        return invokeMethod(context, "parseBody", i, new Class[]{Context.class, String.class, String.class, String.class}, new Object[]{context, str, str2, str3}, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.reflect.Method */
    /* JADX WARN: Multi-variable type inference failed */
    private Message invokeMethod(Context context, String str, int i, Class<?>[] clsArr, Object[] objArr, Intent intent) {
        Message message;
        Message message2;
        Message message3 = null;
        synchronized (mInstance) {
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
                        message3 = (Message) method.invoke(cls, objArr);
                    } catch (Exception e) {
                        e = e;
                        message = null;
                        message3 = method;
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(LogUtils.TAG, "IllegalArgumentException " + cls.getSimpleName() + ":" + message3, e);
                        message2 = message;
                        return message2;
                    }
                }
                if (intent != null && message3 != null) {
                    try {
                        if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                            message3.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        message = message3;
                        message3 = method;
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(LogUtils.TAG, "IllegalArgumentException " + cls.getSimpleName() + ":" + message3, e);
                        message2 = message;
                        return message2;
                    }
                }
                message2 = message3;
            } catch (Exception e3) {
                e = e3;
                message = null;
            }
            return message2;
        }
    }
}
