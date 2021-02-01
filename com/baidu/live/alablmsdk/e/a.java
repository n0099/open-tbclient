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
    private Handler aAB;
    private BIMRtcTokenListener aAC;
    private BIMRtcTokenListener aAD;
    private IStatusListener aAE;
    private IStatusListener aAF;
    private IStatusListener aAG;
    private IStatusListener aAH;
    private IStatusListener aAI;
    private IStatusListener aAJ;
    private IStatusListener aAK;
    private IStatusListener aAL;
    private boolean aAM = false;

    public a(Handler handler) {
        this.aAB = handler;
    }

    public void createRoom(final Context context, final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        final int[] iArr = {0};
        this.aAC = new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.e.a.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str2, BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (a.this.aAM) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal createRoom hasRelease , not callback", "");
                } else if (i == 0) {
                    if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str2, bIMRTCGetTokeResult);
                    }
                } else if (iArr[0] < 3) {
                    if (a.this.b(i, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.createRoom(context, str, a.this.aAC);
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
        BIMRtcClient.createRoom(context, str, this.aAC);
    }

    public void generateToken(final Context context, final String str, final String str2, final long j, final BIMRtcTokenListener bIMRtcTokenListener) {
        final int[] iArr = {0};
        this.aAD = new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.e.a.3
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str3, BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (a.this.aAM) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal createRoom hasRelease , not callback", "");
                } else if (i == 0) {
                    if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str3, bIMRTCGetTokeResult);
                    }
                } else if (iArr[0] < 3) {
                    if (a.this.b(i, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.generateToken(context, str, str2, j, a.this.aAD);
                        }
                    })) {
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + 1;
                    } else if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str3, bIMRTCGetTokeResult);
                    }
                } else if (bIMRtcTokenListener != null) {
                    bIMRtcTokenListener.onResult(i, str3, bIMRTCGetTokeResult);
                }
            }
        };
        BIMRtcClient.generateToken(context, str, str2, j, this.aAD);
    }

    public void join(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aAE = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (!a.this.aAM) {
                    a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.join(context, str, a.this.aAE);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal join hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.join(context, str, this.aAE);
    }

    public void cancelCall(final Context context, final BIMCancelRtcInfo bIMCancelRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aAF = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aAM) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, a.this.aAF);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal cancelCall hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, this.aAF);
    }

    public void invite(final Context context, final BIMInviteRtcInfo bIMInviteRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aAG = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aAM) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.invite(context, bIMInviteRtcInfo, a.this.aAG);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal invite hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.invite(context, bIMInviteRtcInfo, this.aAG);
    }

    public void answer(final Context context, final BIMAnswerRtcInfo bIMAnswerRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aAH = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aAM) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.answer(context, bIMAnswerRtcInfo, a.this.aAH);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal answer hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.answer(context, bIMAnswerRtcInfo, this.aAH);
    }

    public void kickoff(final Context context, final BIMKickRequestRtcInfo bIMKickRequestRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aAI = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.8
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aAM) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, a.this.aAI);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal kickoff hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, this.aAI);
    }

    public void hangout(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aAJ = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (!a.this.aAM) {
                    a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.hangout(context, str, a.this.aAJ);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal hangout hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.hangout(context, str, this.aAJ);
    }

    public void hangout(final Context context, final BIMRtcInfo bIMRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aAK = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.10
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aAM) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.hangout(context, bIMRtcInfo, a.this.aAK);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal hangout hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.hangout(context, bIMRtcInfo, this.aAK);
    }

    public void closeRoom(final Context context, final BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aAL = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aAM) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, a.this.aAL);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ag(" signal closeRoom hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, this.aAL);
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
                this.aAB.post(runnable);
                return true;
            case 1004:
                this.aAB.post(runnable);
                return true;
            case 1005:
                this.aAB.post(runnable);
                return true;
            case 5010:
                this.aAB.post(runnable);
                return true;
            case 5011:
                this.aAB.postDelayed(runnable, 1000L);
                return true;
            case 5012:
                this.aAB.postDelayed(runnable, 1000L);
                return true;
            case 5013:
                this.aAB.postDelayed(runnable, 1000L);
                return true;
            case 5014:
                this.aAB.post(runnable);
                return true;
            case 5015:
                this.aAB.post(runnable);
                return true;
            case 5016:
                this.aAB.post(runnable);
                return true;
            case 5017:
                this.aAB.post(runnable);
                return true;
            case 5018:
                this.aAB.post(runnable);
                return true;
            case 5022:
                this.aAB.post(runnable);
                return true;
            default:
                return false;
        }
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.ag(" signal re try manager release", "");
        this.aAM = true;
        if (this.aAC != null) {
            this.aAC = null;
        }
        if (this.aAD != null) {
            this.aAD = null;
        }
        if (this.aAE != null) {
            this.aAE = null;
        }
        if (this.aAF != null) {
            this.aAF = null;
        }
        if (this.aAG != null) {
            this.aAG = null;
        }
        if (this.aAH != null) {
            this.aAH = null;
        }
        if (this.aAI != null) {
            this.aAI = null;
        }
        if (this.aAJ != null) {
            this.aAJ = null;
        }
        if (this.aAK != null) {
            this.aAK = null;
        }
        if (this.aAL != null) {
            this.aAL = null;
        }
    }
}
