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
    private IStatusListener aDA;
    private IStatusListener aDB;
    private IStatusListener aDC;
    private IStatusListener aDD;
    private IStatusListener aDE;
    private IStatusListener aDF;
    private Handler aDw;
    private BIMRtcTokenListener aDx;
    private IStatusListener aDy;
    private IStatusListener aDz;
    private final int aDv = 3;
    private boolean aDG = false;

    public a(Handler handler) {
        this.aDw = handler;
    }

    public void createRoom(final Context context, final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        final int[] iArr = {0};
        this.aDx = new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.e.a.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str2, BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (a.this.aDG) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal createRoom hasRelease , not callback", "");
                } else if (i == 0) {
                    if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str2, bIMRTCGetTokeResult);
                    }
                } else if (iArr[0] < 3) {
                    if (a.this.b(i, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.createRoom(context, str, a.this.aDx);
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
        BIMRtcClient.createRoom(context, str, this.aDx);
    }

    public void join(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDy = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (!a.this.aDG) {
                    a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.join(context, str, a.this.aDy);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal join hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.join(context, str, this.aDy);
    }

    public void cancelCall(final Context context, final BIMCancelRtcInfo bIMCancelRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDz = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDG) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, a.this.aDz);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal cancelCall hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, this.aDz);
    }

    public void invite(final Context context, final BIMInviteRtcInfo bIMInviteRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDA = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDG) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.invite(context, bIMInviteRtcInfo, a.this.aDA);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal invite hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.invite(context, bIMInviteRtcInfo, this.aDA);
    }

    public void answer(final Context context, final BIMAnswerRtcInfo bIMAnswerRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDB = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDG) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.answer(context, bIMAnswerRtcInfo, a.this.aDB);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal answer hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.answer(context, bIMAnswerRtcInfo, this.aDB);
    }

    public void kickoff(final Context context, final BIMKickRequestRtcInfo bIMKickRequestRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDC = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDG) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, a.this.aDC);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal kickoff hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, this.aDC);
    }

    public void hangout(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDD = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (!a.this.aDG) {
                    a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.hangout(context, str, a.this.aDD);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal hangout hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.hangout(context, str, this.aDD);
    }

    public void hangout(final Context context, final BIMRtcInfo bIMRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDE = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.8
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDG) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.hangout(context, bIMRtcInfo, a.this.aDE);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal hangout hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.hangout(context, bIMRtcInfo, this.aDE);
    }

    public void closeRoom(final Context context, final BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aDF = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.aDG) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, a.this.aDF);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ak(" signal closeRoom hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, this.aDF);
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
                this.aDw.post(runnable);
                return true;
            case 1004:
                this.aDw.post(runnable);
                return true;
            case 1005:
                this.aDw.post(runnable);
                return true;
            case 5010:
                this.aDw.post(runnable);
                return true;
            case 5011:
                this.aDw.postDelayed(runnable, 1000L);
                return true;
            case 5012:
                this.aDw.postDelayed(runnable, 1000L);
                return true;
            case 5013:
                this.aDw.postDelayed(runnable, 1000L);
                return true;
            case 5014:
                this.aDw.post(runnable);
                return true;
            case 5015:
                this.aDw.post(runnable);
                return true;
            case 5016:
                this.aDw.post(runnable);
                return true;
            case 5017:
                this.aDw.post(runnable);
                return true;
            case 5018:
                this.aDw.post(runnable);
                return true;
            case 5022:
                this.aDw.post(runnable);
                return true;
            default:
                return false;
        }
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.ak(" signal re try manager release", "");
        this.aDG = true;
        if (this.aDx != null) {
            this.aDx = null;
        }
        if (this.aDy != null) {
            this.aDy = null;
        }
        if (this.aDz != null) {
            this.aDz = null;
        }
        if (this.aDA != null) {
            this.aDA = null;
        }
        if (this.aDB != null) {
            this.aDB = null;
        }
        if (this.aDC != null) {
            this.aDC = null;
        }
        if (this.aDD != null) {
            this.aDD = null;
        }
        if (this.aDE != null) {
            this.aDE = null;
        }
        if (this.aDF != null) {
            this.aDF = null;
        }
    }
}
