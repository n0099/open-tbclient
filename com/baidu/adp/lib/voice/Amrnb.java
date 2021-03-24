package com.baidu.adp.lib.voice;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import d.b.b.e.p.h;
import d.b.b.e.p.i;
/* loaded from: classes.dex */
public class Amrnb {
    public static boolean bLoadLibrary = false;
    public static Amrnb instance;
    public int mEncoderContext = 0;
    public int mDecoderContext = 0;

    /* loaded from: classes.dex */
    public static class a extends i {
        @Override // d.b.b.e.p.i
        public void a(boolean z) {
            Amrnb.bLoadLibrary = z;
            if (z) {
                try {
                    Amrnb.native_init();
                    Amrnb.bLoadLibrary = true;
                } catch (Throwable th) {
                    Amrnb.bLoadLibrary = false;
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    bdStatisticsManager.error("so", "initAmrnb", "", -9104, th.getClass().getName() + " " + th.getMessage(), new Object[0]);
                }
            }
        }
    }

    static {
        boolean k = h.f().k("amrnb", 2, new a());
        bLoadLibrary = k;
        if (k) {
            try {
                native_init();
                bLoadLibrary = true;
            } catch (Throwable th) {
                bLoadLibrary = false;
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                bdStatisticsManager.error("so", "initAmrnb", "", -9104, th.getClass().getName() + " " + th.getMessage(), new Object[0]);
            }
        }
    }

    private native void _decoderDecode(byte[] bArr, short[] sArr);

    private native void _decoderDeinit();

    private native void _decoderInit();

    private native void _encoderDeinit();

    private native int _encoderEncode(int i, short[] sArr, byte[] bArr);

    private native void _encoderInit();

    public static Amrnb getInstance() {
        Amrnb amrnb;
        Amrnb amrnb2 = instance;
        if (amrnb2 == null) {
            synchronized (Amrnb.class) {
                if (instance == null) {
                    instance = new Amrnb();
                }
                amrnb = instance;
            }
            return amrnb;
        }
        return amrnb2;
    }

    private final native void native_finalize();

    public static final native void native_init();

    public void decoderDecode(byte[] bArr, short[] sArr) {
        if (bLoadLibrary) {
            _decoderDecode(bArr, sArr);
        }
    }

    public void decoderDeinit() {
        if (bLoadLibrary) {
            _decoderDeinit();
        }
    }

    public void decoderInit() {
        if (bLoadLibrary) {
            _decoderInit();
        }
    }

    public void encoderDeinit() {
        if (bLoadLibrary) {
            _encoderDeinit();
        }
    }

    public int encoderEncode(int i, short[] sArr, byte[] bArr) {
        if (bLoadLibrary) {
            return _encoderEncode(i, sArr, bArr);
        }
        return 0;
    }

    public void encoderInit() {
        if (bLoadLibrary) {
            _encoderInit();
        }
    }

    public void finalize() {
        if (bLoadLibrary) {
            native_finalize();
        }
    }
}
