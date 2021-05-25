package com.baidu.android.imsdk.request;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.pms.constants.PmsConstant;
import d.a.s.a;
import d.a.t.a.b.d.b;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AckHandlerThread extends HandlerThread {
    public static final long ACK_DELAY = 1000;
    public static final int RETRY_COUNT = 3;
    public static String TAG = "AckHandlerThread";
    public static final String THREAD_NAME = "AckHandlerThread";
    public static AckHandlerThread sInstance;
    public Handler mAckHandler;
    public Context mContext;
    public AtomicInteger mRetryCount;

    public AckHandlerThread(Context context) {
        super(THREAD_NAME);
        this.mRetryCount = new AtomicInteger(0);
        this.mContext = context;
        start();
        this.mAckHandler = new Handler(getLooper()) { // from class: com.baidu.android.imsdk.request.AckHandlerThread.1
            @Override // android.os.Handler
            public void handleMessage(@NonNull android.os.Message message) {
                if (message.what != 1) {
                    return;
                }
                AckHandlerThread ackHandlerThread = AckHandlerThread.this;
                ackHandlerThread.retryAck(ackHandlerThread.mContext, (NewAckMessage) message.obj);
            }
        };
    }

    public static AckHandlerThread getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AckHandlerThread.class) {
                if (sInstance == null) {
                    sInstance = new AckHandlerThread(context);
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryAck(final Context context, final NewAckMessage newAckMessage) {
        if (!a.f64463e || newAckMessage == null) {
            return;
        }
        BLCPRequest bLCPRequest = new BLCPRequest();
        bLCPRequest.f6322a = 2L;
        bLCPRequest.f6323b = 95L;
        bLCPRequest.f6324c = newAckMessage.getBody().getBytes();
        bLCPRequest.f6325d = System.nanoTime();
        String str = TAG;
        LogUtils.d(str, "ackRequest msgid:" + bLCPRequest.f6325d);
        d.a.t.a.b.a.c(bLCPRequest, new b() { // from class: com.baidu.android.imsdk.request.AckHandlerThread.2
            @Override // d.a.t.a.b.d.b
            public void onResponse(int i2, String str2, long j, long j2, long j3, byte[] bArr) {
                if (i2 == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr));
                        int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                        String optString = jSONObject.optString("msg", "");
                        if (j2 == 95) {
                            String str3 = AckHandlerThread.TAG;
                            LogUtils.d(str3, "retry Ack Response err :" + optInt + ", methodId :" + j2 + ", data :" + bArr.length);
                            newAckMessage.handleMessageResult(context, new JSONObject(new String(bArr)), optInt, optString);
                            if (optInt != 0) {
                                if (AckHandlerThread.this.mRetryCount.get() < 3) {
                                    LogUtils.d(AckHandlerThread.TAG, "ack failed, retry~~");
                                    AckHandlerThread.this.mAckHandler.sendMessageDelayed(AckMessage.getSendMessage(1, newAckMessage), 1000L);
                                }
                                AckHandlerThread.this.mRetryCount.incrementAndGet();
                            }
                            AckHandlerThread.this.mRetryCount.set(0);
                        }
                    } catch (JSONException e2) {
                        LogUtils.e(AckHandlerThread.TAG, "handle sendNewAckToServer response, e :", e2);
                    }
                }
            }
        });
    }

    public Handler getAckHandler() {
        return this.mAckHandler;
    }
}
