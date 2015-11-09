package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
public class Amrnb {
    public static boolean bLoadLibrary;
    private static Amrnb instance;
    private int mEncoderContext = 0;
    private int mDecoderContext = 0;

    private native void _decoderDecode(byte[] bArr, short[] sArr);

    private native void _decoderDeinit();

    private native void _decoderInit();

    private native void _encoderDeinit();

    private native int _encoderEncode(int i, short[] sArr, byte[] bArr);

    private native void _encoderInit();

    private final native void native_finalize();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native void native_init();

    static {
        bLoadLibrary = false;
        bLoadLibrary = com.baidu.adp.lib.util.g.iA().a("amrnb", 2, new g());
        if (bLoadLibrary) {
            try {
                native_init();
                bLoadLibrary = true;
            } catch (Throwable th) {
                bLoadLibrary = false;
                com.baidu.adp.lib.stats.a.hj().a("so", "initAmrnb", "", -9104, String.valueOf(th.getClass().getName()) + " " + th.getMessage(), new Object[0]);
            }
        }
    }

    public static Amrnb getInstance() {
        Amrnb amrnb;
        if (instance == null) {
            synchronized (Amrnb.class) {
                if (instance == null) {
                    instance = new Amrnb();
                }
                amrnb = instance;
            }
            return amrnb;
        }
        return instance;
    }

    protected void finalize() {
        if (bLoadLibrary) {
            native_finalize();
        }
    }

    public void encoderInit() {
        if (bLoadLibrary) {
            _encoderInit();
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

    public void decoderInit() {
        if (bLoadLibrary) {
            _decoderInit();
        }
    }

    public void decoderDeinit() {
        if (bLoadLibrary) {
            _decoderDeinit();
        }
    }

    public void decoderDecode(byte[] bArr, short[] sArr) {
        if (bLoadLibrary) {
            _decoderDecode(bArr, sArr);
        }
    }
}
