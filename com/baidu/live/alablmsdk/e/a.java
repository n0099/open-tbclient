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
/* loaded from: classes11.dex */
public class a {
    private Handler aDN;
    private BIMRtcTokenListener aDO;
    private IStatusListener aDP;
    private IStatusListener aDQ;
    private IStatusListener aDR;
    private IStatusListener aDS;
    private IStatusListener aDT;
    private IStatusListener aDU;
    private IStatusListener aDV;
    private IStatusListener aDW;
    private final int aDM = 3;
    private boolean aDX = false;

    public a(Handler handler) {
        this.aDN = handler;
    }

    public void createRoom(final Context context, final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        final int[] iArr = {0};
        this.aDO = new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.e.a.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str2, BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (a.this.aDX) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal createRoom hasRelease , not callback", "");
                } else if (i == 0) {
                    if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str2, bIMRTCGetTokeResult);
                    }
                } else if (iArr[0] < 3) {
                    if (a.this.b(i, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.createRoom(context, str, a.this.aDO);
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
        BIMRtcClient.createRoom(context, str, this.aDO);
    }

    public void join(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDP = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (!a.this.aDX) {
                    a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.join(context, str, a.this.aDP);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal join hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.join(context, str, this.aDP);
    }

    public void cancelCall(final Context context, final BIMCancelRtcInfo bIMCancelRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDQ = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDX) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, a.this.aDQ);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal cancelCall hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, this.aDQ);
    }

    public void invite(final Context context, final BIMInviteRtcInfo bIMInviteRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDR = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDX) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.invite(context, bIMInviteRtcInfo, a.this.aDR);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal invite hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.invite(context, bIMInviteRtcInfo, this.aDR);
    }

    public void answer(final Context context, final BIMAnswerRtcInfo bIMAnswerRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDS = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDX) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.answer(context, bIMAnswerRtcInfo, a.this.aDS);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal answer hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.answer(context, bIMAnswerRtcInfo, this.aDS);
    }

    public void kickoff(final Context context, final BIMKickRequestRtcInfo bIMKickRequestRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDT = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDX) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, a.this.aDT);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal kickoff hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, this.aDT);
    }

    public void hangout(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDU = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (!a.this.aDX) {
                    a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.hangout(context, str, a.this.aDU);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal hangout hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.hangout(context, str, this.aDU);
    }

    public void hangout(final Context context, final BIMRtcInfo bIMRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDV = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.8
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDX) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.hangout(context, bIMRtcInfo, a.this.aDV);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal hangout hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.hangout(context, bIMRtcInfo, this.aDV);
    }

    public void closeRoom(final Context context, final BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDW = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDX) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, a.this.aDW);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.aj(" signal closeRoom hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, this.aDW);
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
                this.aDN.post(runnable);
                return true;
            case 1004:
                this.aDN.post(runnable);
                return true;
            case 1005:
                this.aDN.post(runnable);
                return true;
            case 5010:
                this.aDN.post(runnable);
                return true;
            case 5011:
                this.aDN.postDelayed(runnable, 1000L);
                return true;
            case 5012:
                this.aDN.postDelayed(runnable, 1000L);
                return true;
            case 5013:
                this.aDN.postDelayed(runnable, 1000L);
                return true;
            case 5014:
                this.aDN.post(runnable);
                return true;
            case 5015:
                this.aDN.post(runnable);
                return true;
            case 5016:
                this.aDN.post(runnable);
                return true;
            case 5017:
                this.aDN.post(runnable);
                return true;
            case 5018:
                this.aDN.post(runnable);
                return true;
            case 5022:
                this.aDN.post(runnable);
                return true;
            default:
                return false;
        }
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.aj(" signal re try manager release", "");
        this.aDX = true;
        if (this.aDO != null) {
            this.aDO = null;
        }
        if (this.aDP != null) {
            this.aDP = null;
        }
        if (this.aDQ != null) {
            this.aDQ = null;
        }
        if (this.aDR != null) {
            this.aDR = null;
        }
        if (this.aDS != null) {
            this.aDS = null;
        }
        if (this.aDT != null) {
            this.aDT = null;
        }
        if (this.aDU != null) {
            this.aDU = null;
        }
        if (this.aDV != null) {
            this.aDV = null;
        }
        if (this.aDW != null) {
            this.aDW = null;
        }
    }
}
