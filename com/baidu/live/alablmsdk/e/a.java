package com.baidu.live.alablmsdk.e;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCancelRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class a {
    private final int aBX = 3;
    private Handler aBY;
    private BIMRtcTokenListener aBZ;
    private IStatusListener aCa;
    private IStatusListener aCb;
    private IStatusListener aCc;
    private IStatusListener aCd;
    private IStatusListener aCe;
    private IStatusListener aCf;
    private IStatusListener aCg;

    public a(Handler handler) {
        this.aBY = handler;
    }

    public void createRoom(final Context context, final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        final int[] iArr = {0};
        this.aBZ = new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.e.a.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str2, BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (i == 0) {
                    if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str2, bIMRTCGetTokeResult);
                    }
                } else if (iArr[0] < 3) {
                    if (a.this.b(i, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.createRoom(context, str, a.this.aBZ);
                        }
                    })) {
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + 1;
                    } else if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str2, bIMRTCGetTokeResult);
                    }
                } else if (bIMRtcTokenListener != null) {
                    bIMRtcTokenListener.onResult(i, str2, bIMRTCGetTokeResult);
                }
            }
        };
        BIMRtcClient.createRoom(context, str, this.aBZ);
    }

    public void join(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCa = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.join(context, str, a.this.aCa);
                    }
                });
            }
        };
        BIMRtcClient.join(context, str, this.aCa);
    }

    public void cancelCall(final Context context, final BIMCancelRtcInfo bIMCancelRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCb = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, a.this.aCb);
                    }
                });
            }
        };
        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, this.aCb);
    }

    public void invite(final Context context, final BIMInviteRtcInfo bIMInviteRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCc = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.invite(context, bIMInviteRtcInfo, a.this.aCc);
                    }
                });
            }
        };
        BIMRtcClient.invite(context, bIMInviteRtcInfo, this.aCc);
    }

    public void answer(final Context context, final BIMAnswerRtcInfo bIMAnswerRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCd = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.answer(context, bIMAnswerRtcInfo, a.this.aCd);
                    }
                });
            }
        };
        BIMRtcClient.answer(context, bIMAnswerRtcInfo, this.aCd);
    }

    public void hangout(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCe = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.hangout(context, str, a.this.aCe);
                    }
                });
            }
        };
        BIMRtcClient.hangout(context, str, this.aCe);
    }

    public void hangout(final Context context, final BIMRtcInfo bIMRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCf = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.hangout(context, bIMRtcInfo, a.this.aCf);
                    }
                });
            }
        };
        BIMRtcClient.hangout(context, bIMRtcInfo, this.aCf);
    }

    public void closeRoom(final Context context, final BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCg = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.8
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, a.this.aCg);
                    }
                });
            }
        };
        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, this.aCg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, AtomicInteger atomicInteger, IStatusListener iStatusListener, Runnable runnable) {
        if (i == 0) {
            if (iStatusListener != null) {
                iStatusListener.onResult(i, str);
            }
        } else if (atomicInteger.get() < 3) {
            if (b(i, runnable)) {
                atomicInteger.incrementAndGet();
            } else if (iStatusListener != null) {
                iStatusListener.onResult(i, str);
            }
        } else if (iStatusListener != null) {
            iStatusListener.onResult(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i, Runnable runnable) {
        switch (i) {
            case -1:
                this.aBY.post(runnable);
                return true;
            case 1004:
                this.aBY.post(runnable);
                return true;
            case 1005:
                this.aBY.post(runnable);
                return true;
            case 5010:
                this.aBY.post(runnable);
                return true;
            case 5011:
                this.aBY.postDelayed(runnable, 1000L);
                return true;
            case 5012:
                this.aBY.postDelayed(runnable, 1000L);
                return true;
            case 5013:
                this.aBY.postDelayed(runnable, 1000L);
                return true;
            case 5014:
                this.aBY.post(runnable);
                return true;
            case 5015:
                this.aBY.post(runnable);
                return true;
            case 5016:
                this.aBY.post(runnable);
                return true;
            case 5017:
                this.aBY.post(runnable);
                return true;
            case 5018:
                this.aBY.post(runnable);
                return true;
            case 5022:
                this.aBY.post(runnable);
                return true;
            default:
                return false;
        }
    }
}
