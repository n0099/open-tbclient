package com.baidu.ar.databasic;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arrender.j;
import com.baidu.ar.f.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class AlgoHandleController {
    private AlgoHandleAdapter ln;
    private HandlerThread lr;
    private a ls;
    private final List<Long> lo = Collections.synchronizedList(new ArrayList());
    private boolean lp = true;
    private int iD = 0;
    private long lq = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a extends Handler {
        private boolean cF;

        public a(Looper looper) {
            super(looper);
            this.cF = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cF) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1004) {
                this.cF = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public AlgoHandleController() {
        this.ln = null;
        this.ln = new AlgoHandleAdapter();
        if (this.lr == null) {
            this.lr = new HandlerThread("HandleHandlerThread");
            this.lr.start();
        }
        if (this.ls == null) {
            this.ls = new a(this.lr.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB() {
        this.lp = false;
        if (this.lo.size() > 0 && this.ln != null) {
            try {
                for (Long l : this.lo) {
                    long longValue = l.longValue();
                    if (longValue <= 0 || longValue != this.lq) {
                        AlgoHandleAdapter algoHandleAdapter = this.ln;
                        AlgoHandleAdapter.destroyHandle(longValue);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                b.aL("release Exception:" + e.getMessage());
            }
        }
        this.ln = null;
        if (this.ls != null) {
            this.ls = null;
        }
        if (this.lr != null) {
            this.lr.quit();
            this.lr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n(long j) {
        if (this.ln != null) {
            o(j);
            AlgoHandleAdapter algoHandleAdapter = this.ln;
            return AlgoHandleAdapter.destroyHandle(j);
        }
        return -1;
    }

    private void o(long j) {
        try {
            if (this.lo.contains(Long.valueOf(j))) {
                int indexOf = this.lo.indexOf(Long.valueOf(j));
                if (indexOf >= 0) {
                    this.lo.remove(indexOf);
                    if (indexOf >= 1) {
                        z(indexOf);
                    }
                } else {
                    b.aL("removeHandle cant find:" + j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            b.aL("removeHandle Exception:" + e.getMessage());
        }
    }

    private void z(int i) {
        if (i > 5) {
            b.aK("type:" + this.iD + " destroyIgnoreHandles current size:" + i);
            for (int i2 = 0; i2 < i; i2++) {
                long longValue = this.lo.get(0).longValue();
                this.lo.remove(0);
                if (this.ln != null) {
                    AlgoHandleAdapter algoHandleAdapter = this.ln;
                    AlgoHandleAdapter.destroyHandle(longValue);
                }
            }
        }
    }

    public long createHandle() {
        if (this.ln == null || !this.lp) {
            return 0L;
        }
        AlgoHandleAdapter algoHandleAdapter = this.ln;
        final long createHandle = AlgoHandleAdapter.createHandle();
        if (this.lr == null || !this.lr.isAlive() || this.ls == null) {
            return createHandle;
        }
        this.ls.a(1001, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.3
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.lo.add(Long.valueOf(createHandle));
            }
        });
        return createHandle;
    }

    public int destroyHandle(final long j) {
        if (this.ln == null || this.lr == null || !this.lr.isAlive() || this.ls == null) {
            return -1;
        }
        this.ls.a(1003, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.4
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.n(j);
            }
        });
        return 0;
    }

    public byte[] getHandleMaskData(long j) {
        if (this.ln != null) {
            AlgoHandleAdapter algoHandleAdapter = this.ln;
            return AlgoHandleAdapter.getHandleMaskData(j);
        }
        return new byte[0];
    }

    public int getHandleReserveData(long j, ReserveHandleData reserveHandleData) {
        if (this.ln != null) {
            AlgoHandleAdapter algoHandleAdapter = this.ln;
            return AlgoHandleAdapter.getHandleReserveData(j, reserveHandleData);
        }
        return -1;
    }

    public int getHandleType(long j) {
        if (this.ln != null) {
            AlgoHandleAdapter algoHandleAdapter = this.ln;
            return AlgoHandleAdapter.getHandleType(j);
        }
        return 0;
    }

    public int increaseHandleReference(long j) {
        if (this.ln != null) {
            AlgoHandleAdapter algoHandleAdapter = this.ln;
            return AlgoHandleAdapter.increaseHandleReference(j);
        }
        return -1;
    }

    public void release() {
        this.lp = false;
        if (this.lr == null || !this.lr.isAlive() || this.ls == null) {
            return;
        }
        this.ls.a(1004, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.2
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.cB();
            }
        });
    }

    public void sendHandleToRenderer(final long j, final j jVar, final String str) {
        if (this.lr == null || !this.lr.isAlive() || this.ls == null) {
            return;
        }
        this.ls.a(1002, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.1
            @Override // java.lang.Runnable
            public void run() {
                if (jVar != null) {
                    jVar.a(j, str);
                }
            }
        });
    }

    public int setHandleFaceHandle(long j, long j2) {
        if (this.ln != null) {
            AlgoHandleAdapter algoHandleAdapter = this.ln;
            return AlgoHandleAdapter.setHandleFaceHandle(j, j2);
        }
        return -1;
    }

    public int setHandleInput(long j, int i, long j2, int i2, int i3, int i4, boolean z, int i5, boolean z2, ByteBuffer byteBuffer) {
        if (this.ln != null) {
            this.iD = i;
            AlgoHandleAdapter algoHandleAdapter = this.ln;
            return AlgoHandleAdapter.setHandleInput(j, i, j2, i2, i3, i4, z, i5, z2, byteBuffer);
        }
        return -1;
    }

    public int setHandleMaskThreshold(long j, float f) {
        if (this.ln != null) {
            AlgoHandleAdapter algoHandleAdapter = this.ln;
            return AlgoHandleAdapter.setHandleMaskThreshold(j, f);
        }
        return -1;
    }

    public void setUsingHandle(long j) {
        this.lq = j;
    }
}
