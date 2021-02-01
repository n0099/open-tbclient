package com.baidu.android.imsdk.request;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.g.a;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.client.bean.b;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AckHandlerThread extends HandlerThread {
    public static final long ACK_DELAY = 1000;
    public static final int RETRY_COUNT = 3;
    private static AckHandlerThread sInstance;
    private Handler mAckHandler;
    private Context mContext;
    public AtomicInteger mRetryCount;
    private static final String THREAD_NAME = "AckHandlerThread";
    private static String TAG = THREAD_NAME;

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

    public AckHandlerThread(Context context) {
        super(THREAD_NAME);
        this.mRetryCount = new AtomicInteger(0);
        this.mContext = context;
        start();
        this.mAckHandler = new Handler(getLooper()) { // from class: com.baidu.android.imsdk.request.AckHandlerThread.1
            @Override // android.os.Handler
            public void handleMessage(@NonNull android.os.Message message) {
                switch (message.what) {
                    case 1:
                        AckHandlerThread.this.retryAck(AckHandlerThread.this.mContext, (NewAckMessage) message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryAck(final Context context, final NewAckMessage newAckMessage) {
        if (a.aug && newAckMessage != null) {
            BLCPRequest bLCPRequest = new BLCPRequest();
            bLCPRequest.serviceId = 2L;
            bLCPRequest.methodId = 95L;
            bLCPRequest.auv = newAckMessage.getBody().getBytes();
            bLCPRequest.msgId = System.nanoTime();
            LogUtils.d(TAG, "ackRequest msgid:" + bLCPRequest.msgId);
            com.baidu.lcp.sdk.client.a.a(bLCPRequest, new b() { // from class: com.baidu.android.imsdk.request.AckHandlerThread.2
                @Override // com.baidu.lcp.sdk.client.bean.b
                public void onResponse(int i, String str, long j, long j2, long j3, byte[] bArr) {
                    if (j2 == 95) {
                        try {
                            LogUtils.d(AckHandlerThread.TAG, "retry Ack Response err :" + i + ", methodId :" + j2 + ", data :" + bArr.length);
                            newAckMessage.handleMessageResult(context, new JSONObject(new String(bArr)), i, str);
                            if (i != 0) {
                                if (AckHandlerThread.this.mRetryCount.get() < 3) {
                                    LogUtils.d(AckHandlerThread.TAG, "ack failed, retry~~");
                                    AckHandlerThread.this.mAckHandler.sendMessageDelayed(AckMessage.getSendMessage(1, newAckMessage), 1000L);
                                }
                                AckHandlerThread.this.mRetryCount.incrementAndGet();
                            }
                            AckHandlerThread.this.mRetryCount.set(0);
                        } catch (JSONException e) {
                            LogUtils.e(AckHandlerThread.TAG, "handle sendNewAckToServer response, e :", e);
                        }
                    }
                }
            });
        }
    }

    public Handler getAckHandler() {
        return this.mAckHandler;
    }
}
