package com.baidu.adp.lib.voice;

import com.baidu.adp.lib.stats.g;
import com.baidu.adp.lib.util.e;
import java.io.File;
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

    private static final native void native_init();

    static {
        String str = null;
        bLoadLibrary = false;
        try {
            if (com.baidu.adp.a.b.a().b() != null && com.baidu.adp.a.b.a().b().getApplicationInfo() != null) {
                String str2 = String.valueOf(com.baidu.adp.a.b.a().b().getApplicationInfo().dataDir) + File.separator + "lib/libamrnb.so";
                if (new File(str2).exists()) {
                    str = str2;
                }
            }
            if (str != null) {
                System.load(str);
                g.a().a("loadVoiceSoLocal", "", 1, new Object[0]);
            } else {
                System.loadLibrary("amrnb");
                g.a().a("loadVoiceSoSystem", "", 1, new Object[0]);
            }
            bLoadLibrary = true;
        } catch (Throwable th) {
            e.d("----load amrnb so failed.");
            try {
                System.loadLibrary("amrnb");
                g.a().a("loadVoiceSoSystem", "", 1, new Object[0]);
                bLoadLibrary = true;
            } catch (Throwable th2) {
                bLoadLibrary = false;
                g.a().a("loadVoiceSoFail", "", 1, new Object[0]);
                e.d("----load amrnb so failed2.");
            }
        }
        if (bLoadLibrary) {
            try {
                native_init();
                bLoadLibrary = true;
            } catch (Throwable th3) {
                bLoadLibrary = false;
                e.d("----load amrnb so failed2.");
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
