package com.baidu.ar.databasic;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arrender.k;
import com.baidu.ar.g.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class AlgoHandleController {
    private HandlerThread lZ;
    private a ma;
    private final List<Long> lW = Collections.synchronizedList(new ArrayList());
    private boolean lX = true;
    private int ib = 0;
    private long lY = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class a extends Handler {
        private boolean cx;

        public a(Looper looper) {
            super(looper);
            this.cx = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cx) {
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
                this.cx = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public AlgoHandleController() {
        if (this.lZ == null) {
            this.lZ = new HandlerThread("HandleHandlerThread");
            this.lZ.start();
        }
        if (this.ma == null) {
            this.ma = new a(this.lZ.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db() {
        this.lX = false;
        if (this.lW.size() > 0) {
            try {
                for (Long l : this.lW) {
                    long longValue = l.longValue();
                    if (longValue <= 0 || longValue != this.lY) {
                        AlgoHandleAdapter.destroyHandle(longValue);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                b.aP("release Exception:" + e.getMessage());
            }
        }
        if (this.ma != null) {
            this.ma = null;
        }
        if (this.lZ != null) {
            this.lZ.quit();
            this.lZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n(long j) {
        o(j);
        return AlgoHandleAdapter.destroyHandle(j);
    }

    private void o(long j) {
        try {
            if (this.lW.contains(Long.valueOf(j))) {
                int indexOf = this.lW.indexOf(Long.valueOf(j));
                if (indexOf >= 0) {
                    this.lW.remove(indexOf);
                    if (indexOf >= 1) {
                        w(indexOf);
                    }
                } else {
                    b.aP("removeHandle cant find:" + j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            b.aP("removeHandle Exception:" + e.getMessage());
        }
    }

    private void w(int i) {
        if (i > 5) {
            b.aO("type:" + this.ib + " destroyIgnoreHandles current size:" + i);
            for (int i2 = 0; i2 < i; i2++) {
                long longValue = this.lW.get(0).longValue();
                this.lW.remove(0);
                AlgoHandleAdapter.destroyHandle(longValue);
            }
        }
    }

    public long createHandle() {
        if (this.lX) {
            final long createHandle = AlgoHandleAdapter.createHandle();
            if (this.lZ == null || !this.lZ.isAlive() || this.ma == null) {
                return createHandle;
            }
            this.ma.a(1001, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlgoHandleController.this.lW.add(Long.valueOf(createHandle));
                }
            });
            return createHandle;
        }
        return 0L;
    }

    public int destroyHandle(final long j) {
        if (this.lZ == null || !this.lZ.isAlive() || this.ma == null) {
            return -1;
        }
        this.ma.a(1003, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.4
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.n(j);
            }
        });
        return 0;
    }

    public byte[] getHandleMaskData(long j) {
        return AlgoHandleAdapter.getHandleMaskData(j);
    }

    public int getHandleReserveData(long j, ReserveHandleData reserveHandleData) {
        return AlgoHandleAdapter.getHandleReserveData(j, reserveHandleData);
    }

    public int getHandleType(long j) {
        return AlgoHandleAdapter.getHandleType(j);
    }

    public int increaseHandleReference(long j) {
        return AlgoHandleAdapter.increaseHandleReference(j);
    }

    public void release() {
        this.lX = false;
        if (this.lZ == null || !this.lZ.isAlive() || this.ma == null) {
            return;
        }
        this.ma.a(1004, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.2
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.db();
            }
        });
    }

    public void sendHandleToRenderer(final long j, final k kVar, final String str) {
        if (this.lZ == null || !this.lZ.isAlive() || this.ma == null) {
            return;
        }
        this.ma.a(1002, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.1
            @Override // java.lang.Runnable
            public void run() {
                if (kVar != null) {
                    kVar.a(j, str);
                }
            }
        });
    }

    public int setHandleFaceHandle(long j, long j2) {
        return AlgoHandleAdapter.setHandleFaceHandle(j, j2);
    }

    public int setHandleInput(long j, int i, long j2, int i2, int i3, int i4, boolean z, int i5, boolean z2, ByteBuffer byteBuffer) {
        this.ib = i;
        return AlgoHandleAdapter.setHandleInput(j, i, j2, i2, i3, i4, z, i5, z2, byteBuffer);
    }

    public int setHandleMaskThreshold(long j, float f) {
        return AlgoHandleAdapter.setHandleMaskThreshold(j, f);
    }

    public void setUsingHandle(long j) {
        this.lY = j;
    }
}
