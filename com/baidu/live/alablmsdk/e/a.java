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
/* loaded from: classes10.dex */
public class a {
    private Handler aza;
    private BIMRtcTokenListener azb;
    private IStatusListener azc;
    private IStatusListener azd;
    private IStatusListener aze;
    private IStatusListener azf;
    private IStatusListener azg;
    private IStatusListener azh;
    private IStatusListener azi;
    private IStatusListener azj;
    private final int ayZ = 3;
    private boolean azk = false;

    public a(Handler handler) {
        this.aza = handler;
    }

    public void createRoom(final Context context, final String str, final BIMRtcTokenListener bIMRtcTokenListener) {
        final int[] iArr = {0};
        this.azb = new BIMRtcTokenListener() { // from class: com.baidu.live.alablmsdk.e.a.1
            @Override // com.baidu.android.imrtc.request.BIMRtcTokenListener
            public void onResult(int i, String str2, BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult) {
                if (a.this.azk) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal createRoom hasRelease , not callback", "");
                } else if (i == 0) {
                    if (bIMRtcTokenListener != null) {
                        bIMRtcTokenListener.onResult(i, str2, bIMRTCGetTokeResult);
                    }
                } else if (iArr[0] < 3) {
                    if (a.this.b(i, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.createRoom(context, str, a.this.azb);
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
        BIMRtcClient.createRoom(context, str, this.azb);
    }

    public void join(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.azc = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.2
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (!a.this.azk) {
                    a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.join(context, str, a.this.azc);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal join hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.join(context, str, this.azc);
    }

    public void cancelCall(final Context context, final BIMCancelRtcInfo bIMCancelRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.azd = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.3
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.azk) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, a.this.azd);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal cancelCall hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.cancelCall(context, bIMCancelRtcInfo, this.azd);
    }

    public void invite(final Context context, final BIMInviteRtcInfo bIMInviteRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.aze = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.4
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.azk) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.invite(context, bIMInviteRtcInfo, a.this.aze);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal invite hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.invite(context, bIMInviteRtcInfo, this.aze);
    }

    public void answer(final Context context, final BIMAnswerRtcInfo bIMAnswerRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.azf = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.5
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.azk) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.answer(context, bIMAnswerRtcInfo, a.this.azf);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal answer hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.answer(context, bIMAnswerRtcInfo, this.azf);
    }

    public void kickoff(final Context context, final BIMKickRequestRtcInfo bIMKickRequestRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.azg = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.6
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.azk) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, a.this.azg);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal kickoff hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.kickoff(context, bIMKickRequestRtcInfo, this.azg);
    }

    public void hangout(final Context context, final String str, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.azh = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.7
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str2) {
                if (!a.this.azk) {
                    a.this.a(i, str2, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.hangout(context, str, a.this.azh);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal hangout hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.hangout(context, str, this.azh);
    }

    public void hangout(final Context context, final BIMRtcInfo bIMRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.azi = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.8
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.azk) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.hangout(context, bIMRtcInfo, a.this.azi);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal hangout hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.hangout(context, bIMRtcInfo, this.azi);
    }

    public void closeRoom(final Context context, final BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, final IStatusListener iStatusListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.azj = new IStatusListener() { // from class: com.baidu.live.alablmsdk.e.a.9
            @Override // com.baidu.android.imrtc.utils.IStatusListener
            public void onResult(int i, String str) {
                if (!a.this.azk) {
                    a.this.a(i, str, atomicInteger, iStatusListener, new Runnable() { // from class: com.baidu.live.alablmsdk.e.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, a.this.azj);
                        }
                    });
                } else {
                    com.baidu.live.alablmsdk.a.b.a.ai(" signal closeRoom hasRelease , not callback", "");
                }
            }
        };
        BIMRtcClient.closeRoom(context, bIMCloseRoomRtcInfo, this.azj);
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
                this.aza.post(runnable);
                return true;
            case 1004:
                this.aza.post(runnable);
                return true;
            case 1005:
                this.aza.post(runnable);
                return true;
            case 5010:
                this.aza.post(runnable);
                return true;
            case 5011:
                this.aza.postDelayed(runnable, 1000L);
                return true;
            case 5012:
                this.aza.postDelayed(runnable, 1000L);
                return true;
            case 5013:
                this.aza.postDelayed(runnable, 1000L);
                return true;
            case 5014:
                this.aza.post(runnable);
                return true;
            case 5015:
                this.aza.post(runnable);
                return true;
            case 5016:
                this.aza.post(runnable);
                return true;
            case 5017:
                this.aza.post(runnable);
                return true;
            case 5018:
                this.aza.post(runnable);
                return true;
            case 5022:
                this.aza.post(runnable);
                return true;
            default:
                return false;
        }
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.ai(" signal re try manager release", "");
        this.azk = true;
        if (this.azb != null) {
            this.azb = null;
        }
        if (this.azc != null) {
            this.azc = null;
        }
        if (this.azd != null) {
            this.azd = null;
        }
        if (this.aze != null) {
            this.aze = null;
        }
        if (this.azf != null) {
            this.azf = null;
        }
        if (this.azg != null) {
            this.azg = null;
        }
        if (this.azh != null) {
            this.azh = null;
        }
        if (this.azi != null) {
            this.azi = null;
        }
        if (this.azj != null) {
            this.azj = null;
        }
    }
}
