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
import com.baidu.android.imrtc.send.BIMKickRequestRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class a {
    private final int aCB = 3;
    private Handler aCC;
    private BIMRtcTokenListener aCD;
    private IStatusListener aCE;
    private IStatusListener aCF;
    private IStatusListener aCG;
    private IStatusListener aCH;
    private IStatusListener aCI;
    private IStatusListener aCJ;
    private IStatusListener aCK;
    private IStatusListener aCL;

    public a(Handler handler) {
        this.aCC = handler;
    }

    public void createRoom(final Context context, final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        final int[] iArr = {0};
        this.aCD = new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.e.a.1
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
                            BIMRtcClient.createRoom(context, str, a.this.aCD);
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
        BIMRtcClient.createRoom(context, str, this.aCD);
    }

    public void join(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCE = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.join(context, str, a.this.aCE);
                    }
                });
            }
        };
        BIMRtcClient.join(context, str, this.aCE);
    }

    public void cancelCall(final Context context, final BIMCancelRtcInfo bIMCancelRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCF = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, a.this.aCF);
                    }
                });
            }
        };
        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, this.aCF);
    }

    public void invite(final Context context, final BIMInviteRtcInfo bIMInviteRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCG = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.invite(context, bIMInviteRtcInfo, a.this.aCG);
                    }
                });
            }
        };
        BIMRtcClient.invite(context, bIMInviteRtcInfo, this.aCG);
    }

    public void answer(final Context context, final BIMAnswerRtcInfo bIMAnswerRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCH = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.answer(context, bIMAnswerRtcInfo, a.this.aCH);
                    }
                });
            }
        };
        BIMRtcClient.answer(context, bIMAnswerRtcInfo, this.aCH);
    }

    public void kickoff(final Context context, final BIMKickRequestRtcInfo bIMKickRequestRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCI = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, a.this.aCI);
                    }
                });
            }
        };
        BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, this.aCI);
    }

    public void hangout(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCJ = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.hangout(context, str, a.this.aCJ);
                    }
                });
            }
        };
        BIMRtcClient.hangout(context, str, this.aCJ);
    }

    public void hangout(final Context context, final BIMRtcInfo bIMRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCK = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.8
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.hangout(context, bIMRtcInfo, a.this.aCK);
                    }
                });
            }
        };
        BIMRtcClient.hangout(context, bIMRtcInfo, this.aCK);
    }

    public void closeRoom(final Context context, final BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aCL = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, a.this.aCL);
                    }
                });
            }
        };
        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, this.aCL);
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
                this.aCC.post(runnable);
                return true;
            case 1004:
                this.aCC.post(runnable);
                return true;
            case 1005:
                this.aCC.post(runnable);
                return true;
            case 5010:
                this.aCC.post(runnable);
                return true;
            case 5011:
                this.aCC.postDelayed(runnable, 1000L);
                return true;
            case 5012:
                this.aCC.postDelayed(runnable, 1000L);
                return true;
            case 5013:
                this.aCC.postDelayed(runnable, 1000L);
                return true;
            case 5014:
                this.aCC.post(runnable);
                return true;
            case 5015:
                this.aCC.post(runnable);
                return true;
            case 5016:
                this.aCC.post(runnable);
                return true;
            case 5017:
                this.aCC.post(runnable);
                return true;
            case 5018:
                this.aCC.post(runnable);
                return true;
            case 5022:
                this.aCC.post(runnable);
                return true;
            default:
                return false;
        }
    }
}
