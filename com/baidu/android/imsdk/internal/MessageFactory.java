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
        return invokeMethod(context, "newInstance", i, new Class[]{Context.class, Intent.class}, new Object[]{context, intent});
    }

    public Message parseMessage(Context context, int i, String str, String str2, String str3) {
        return invokeMethod(context, "parseBody", i, new Class[]{Context.class, String.class, String.class, String.class}, new Object[]{context, str, str2, str3});
    }

    private Message invokeMethod(Context context, String str, int i, Class<?>[] clsArr, Object[] objArr) {
        Method method;
        Message message;
        Message message2 = null;
        LogUtils.d(TAG, "parseMessage type:" + i);
        synchronized (mInstance) {
            if (!this.classMap.isEmpty()) {
                Class<?> cls = this.classMap.get(Integer.valueOf(i));
                if (cls == null) {
                    LogUtils.d(TAG, ": don't hava class ,type=" + i);
                } else {
                    try {
                        method = cls.getMethod(str, clsArr);
                        if (method != null) {
                            try {
                                message = (Message) method.invoke(cls, objArr);
                            } catch (Exception e) {
                                e = e;
                                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                                LogUtils.e(LogUtils.TAG, "IllegalArgumentException " + cls.getSimpleName() + ":" + method, e);
                                return message2;
                            }
                        } else {
                            message = null;
                        }
                        message2 = message;
                    } catch (Exception e2) {
                        e = e2;
                        method = null;
                    }
                }
            }
        }
        return message2;
    }
}
