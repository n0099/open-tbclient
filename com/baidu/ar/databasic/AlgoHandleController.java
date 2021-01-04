package com.baidu.ar.databasic;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arrender.l;
import com.baidu.ar.h.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class AlgoHandleController {
    private HandlerThread mo;
    private a mp;
    private final List<Long> ml = Collections.synchronizedList(new ArrayList());
    private boolean mm = true;
    private int ir = 0;
    private long mn = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends Handler {
        private boolean cC;

        public a(Looper looper) {
            super(looper);
            this.cC = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cC) {
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
                this.cC = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public AlgoHandleController() {
        if (this.mo == null) {
            this.mo = new HandlerThread("HandleHandlerThread");
            this.mo.start();
        }
        if (this.mp == null) {
            this.mp = new a(this.mo.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        this.mm = false;
        if (this.ml.size() > 0) {
            try {
                for (Long l : this.ml) {
                    long longValue = l.longValue();
                    if (longValue <= 0 || longValue != this.mn) {
                        AlgoHandleAdapter.destroyHandle(longValue);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                b.aS("release Exception:" + e.getMessage());
            }
        }
        if (this.mp != null) {
            this.mp = null;
        }
        if (this.mo != null) {
            this.mo.quit();
            this.mo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(long j) {
        m(j);
        return AlgoHandleAdapter.destroyHandle(j);
    }

    private void m(long j) {
        try {
            if (this.ml.contains(Long.valueOf(j))) {
                int indexOf = this.ml.indexOf(Long.valueOf(j));
                if (indexOf >= 0) {
                    this.ml.remove(indexOf);
                    if (indexOf >= 1) {
                        y(indexOf);
                    }
                } else {
                    b.aS("removeHandle cant find:" + j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            b.aS("removeHandle Exception:" + e.getMessage());
        }
    }

    private void y(int i) {
        if (i > 5) {
            b.aR("type:" + this.ir + " destroyIgnoreHandles current size:" + i);
            for (int i2 = 0; i2 < i; i2++) {
                long longValue = this.ml.get(0).longValue();
                this.ml.remove(0);
                AlgoHandleAdapter.destroyHandle(longValue);
            }
        }
    }

    public long createHandle() {
        if (this.mm) {
            final long createHandle = AlgoHandleAdapter.createHandle();
            if (this.mo == null || !this.mo.isAlive() || this.mp == null) {
                return createHandle;
            }
            this.mp.a(1001, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlgoHandleController.this.ml.add(Long.valueOf(createHandle));
                }
            });
            return createHandle;
        }
        return 0L;
    }

    public int destroyHandle(final long j) {
        if (this.mo == null || !this.mo.isAlive() || this.mp == null) {
            return -1;
        }
        this.mp.a(1003, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.4
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.l(j);
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
        this.mm = false;
        if (this.mo == null || !this.mo.isAlive() || this.mp == null) {
            return;
        }
        this.mp.a(1004, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.2
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.da();
            }
        });
    }

    public void sendHandleToRenderer(final long j, final l lVar, final String str) {
        if (this.mo == null || !this.mo.isAlive() || this.mp == null) {
            return;
        }
        this.mp.a(1002, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.1
            @Override // java.lang.Runnable
            public void run() {
                if (lVar != null) {
                    lVar.a(j, str);
                }
            }
        });
    }

    public int setHandleFaceHandle(long j, long j2) {
        return AlgoHandleAdapter.setHandleFaceHandle(j, j2);
    }

    public int setHandleInput(long j, int i, long j2, int i2, int i3, int i4, boolean z, int i5, boolean z2, ByteBuffer byteBuffer) {
        this.ir = i;
        return AlgoHandleAdapter.setHandleInput(j, i, j2, i2, i3, i4, z, i5, z2, byteBuffer);
    }

    public int setHandleMaskThreshold(long j, float f) {
        return AlgoHandleAdapter.setHandleMaskThreshold(j, f);
    }

    public void setUsingHandle(long j) {
        this.mn = j;
    }
}
