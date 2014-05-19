package com.baidu.adp.lib.voice;

import com.baidu.adp.lib.stats.h;
import com.baidu.adp.lib.util.BdLog;
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
        String str;
        bLoadLibrary = false;
        try {
            if (com.baidu.adp.base.a.getInst().getApp() != null && com.baidu.adp.base.a.getInst().getApp().getApplicationInfo() != null) {
                String str2 = String.valueOf(com.baidu.adp.base.a.getInst().getApp().getApplicationInfo().dataDir) + File.separator + "lib" + File.separator + "libamrnb.so";
                if (new File(str2).exists()) {
                    str = str2;
                } else {
                    h.a().a("so", "loadAmrnbFile", "", "", -9101, String.valueOf(str2) + "FileNotFound", new Object[0]);
                    str = null;
                }
            } else {
                h.a().a("so", "loadAmrnbFile", "", "", -9101, "CannotGetApp", new Object[0]);
                str = null;
            }
            if (str != null) {
                System.load(str);
            } else {
                System.loadLibrary("amrnb");
            }
            bLoadLibrary = true;
        } catch (Throwable th) {
            BdLog.i("----load amrnb so failed.");
            h.a().a("so", "loadAmrnb", "", "", -9102, String.valueOf(th.getClass().getName()) + "-" + th.getMessage(), new Object[0]);
            try {
                System.loadLibrary("amrnb");
                bLoadLibrary = true;
            } catch (Throwable th2) {
                bLoadLibrary = false;
                h.a().a("so", "reloadAmrnb", "", "", -9103, String.valueOf(th2.getClass().getName()) + "-" + th2.getMessage(), new Object[0]);
                BdLog.i("----load amrnb so failed2.");
            }
        }
        if (bLoadLibrary) {
            try {
                native_init();
                bLoadLibrary = true;
            } catch (Throwable th3) {
                bLoadLibrary = false;
                h.a().a("so", "initAmrnb", "", "", -9104, String.valueOf(th3.getClass().getName()) + " " + th3.getMessage(), new Object[0]);
                BdLog.i("----load amrnb so failed2.");
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
