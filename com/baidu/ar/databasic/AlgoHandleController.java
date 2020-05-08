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
    private AlgoHandleAdapter kQ;
    private HandlerThread kU;
    private a kV;
    private final List<Long> kR = Collections.synchronizedList(new ArrayList());
    private boolean kS = true;

    /* renamed from: io  reason: collision with root package name */
    private int f975io = 0;
    private long kT = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a extends Handler {
        private boolean cs;

        public a(Looper looper) {
            super(looper);
            this.cs = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cs) {
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
                this.cs = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public AlgoHandleController() {
        this.kQ = null;
        this.kQ = new AlgoHandleAdapter();
        if (this.kU == null) {
            this.kU = new HandlerThread("HandleHandlerThread");
            this.kU.start();
        }
        if (this.kV == null) {
            this.kV = new a(this.kU.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj() {
        this.kS = false;
        try {
            if (this.kR.size() > 0 && this.kQ != null) {
                for (Long l : this.kR) {
                    long longValue = l.longValue();
                    if (longValue <= 0 || longValue != this.kT) {
                        AlgoHandleAdapter algoHandleAdapter = this.kQ;
                        AlgoHandleAdapter.destroyHandle(longValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            b.aK("release Exception:" + e.getMessage());
        }
        this.kQ = null;
        if (this.kV != null) {
            this.kV = null;
        }
        if (this.kU != null) {
            this.kU.quit();
            this.kU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o(long j) {
        if (this.kQ != null) {
            p(j);
            AlgoHandleAdapter algoHandleAdapter = this.kQ;
            return AlgoHandleAdapter.destroyHandle(j);
        }
        return -1;
    }

    private void p(long j) {
        try {
            if (this.kR.contains(Long.valueOf(j))) {
                int indexOf = this.kR.indexOf(Long.valueOf(j));
                if (indexOf >= 0) {
                    this.kR.remove(indexOf);
                    if (indexOf >= 1) {
                        v(indexOf);
                    }
                } else {
                    b.aK("removeHandle cant find:" + j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            b.aK("removeHandle Exception:" + e.getMessage());
        }
    }

    private void v(int i) {
        if (i > 5) {
            b.aJ("type:" + this.f975io + " destroyIgnoreHandles current size:" + i);
            for (int i2 = 0; i2 < i; i2++) {
                long longValue = this.kR.get(0).longValue();
                this.kR.remove(0);
                if (this.kQ != null) {
                    AlgoHandleAdapter algoHandleAdapter = this.kQ;
                    AlgoHandleAdapter.destroyHandle(longValue);
                }
            }
        }
    }

    public long createHandle() {
        if (this.kQ == null || !this.kS) {
            return 0L;
        }
        AlgoHandleAdapter algoHandleAdapter = this.kQ;
        final long createHandle = AlgoHandleAdapter.createHandle();
        if (this.kU == null || !this.kU.isAlive() || this.kV == null) {
            return createHandle;
        }
        this.kV.a(1001, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.3
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.kR.add(Long.valueOf(createHandle));
            }
        });
        return createHandle;
    }

    public int destroyHandle(final long j) {
        if (this.kQ == null || this.kU == null || !this.kU.isAlive() || this.kV == null) {
            return -1;
        }
        this.kV.a(1003, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.4
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.o(j);
            }
        });
        return 0;
    }

    public byte[] getHandleMaskData(long j) {
        if (this.kQ != null) {
            AlgoHandleAdapter algoHandleAdapter = this.kQ;
            return AlgoHandleAdapter.getHandleMaskData(j);
        }
        return new byte[0];
    }

    public int getHandleReserveData(long j, ReserveHandleData reserveHandleData) {
        if (this.kQ != null) {
            AlgoHandleAdapter algoHandleAdapter = this.kQ;
            return AlgoHandleAdapter.getHandleReserveData(j, reserveHandleData);
        }
        return -1;
    }

    public int getHandleType(long j) {
        if (this.kQ != null) {
            AlgoHandleAdapter algoHandleAdapter = this.kQ;
            return AlgoHandleAdapter.getHandleType(j);
        }
        return 0;
    }

    public int increaseHandleReference(long j) {
        if (this.kQ != null) {
            AlgoHandleAdapter algoHandleAdapter = this.kQ;
            return AlgoHandleAdapter.increaseHandleReference(j);
        }
        return -1;
    }

    public void release() {
        this.kS = false;
        if (this.kU == null || !this.kU.isAlive() || this.kV == null) {
            return;
        }
        this.kV.a(1004, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.2
            @Override // java.lang.Runnable
            public void run() {
                AlgoHandleController.this.cj();
            }
        });
    }

    public void sendHandleToRenderer(final long j, final j jVar, final String str) {
        if (this.kU == null || !this.kU.isAlive() || this.kV == null) {
            return;
        }
        this.kV.a(1002, new Runnable() { // from class: com.baidu.ar.databasic.AlgoHandleController.1
            @Override // java.lang.Runnable
            public void run() {
                if (jVar != null) {
                    jVar.a(j, str);
                }
            }
        });
    }

    public int setHandleFaceHandle(long j, long j2) {
        if (this.kQ != null) {
            AlgoHandleAdapter algoHandleAdapter = this.kQ;
            return AlgoHandleAdapter.setHandleFaceHandle(j, j2);
        }
        return -1;
    }

    public int setHandleInput(long j, int i, long j2, int i2, int i3, int i4, boolean z, int i5, boolean z2, ByteBuffer byteBuffer) {
        if (this.kQ != null) {
            this.f975io = i;
            AlgoHandleAdapter algoHandleAdapter = this.kQ;
            return AlgoHandleAdapter.setHandleInput(j, i, j2, i2, i3, i4, z, i5, z2, byteBuffer);
        }
        return -1;
    }

    public int setHandleMaskThreshold(long j, float f) {
        if (this.kQ != null) {
            AlgoHandleAdapter algoHandleAdapter = this.kQ;
            return AlgoHandleAdapter.setHandleMaskThreshold(j, f);
        }
        return -1;
    }

    public void setUsingHandle(long j) {
        this.kT = j;
    }
}
