package com.baidu.bankdetection;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.baidu.idl.authority.AlgorithmOnMainThreadException;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.idl.license.License;
import com.baidu.idl.statistics.Statistics;
import com.baidu.idl.util.UIThread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class BankCardProcessing {
    public static final String TAG = "BankCardProcessing";
    public static String mApiKey = null;
    public static int mAuthorityStatus = 0;
    public static BankCardProcessing mInstance = null;
    public static final boolean sCheckAuthority = true;
    public static String tokenString;
    public String mCardNumber;
    public AtomicInteger mNumberOfTasks = new AtomicInteger(0);

    static {
        System.loadLibrary(License.LICENSE_DEFAULT_FILE_NAME);
        System.loadLibrary("bankcardprocess.1.1.1");
        mInstance = null;
        mAuthorityStatus = 256;
    }

    private native BCResult BankCardProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

    public static synchronized BankCardProcessing getInstance() {
        BankCardProcessing bankCardProcessing;
        synchronized (BankCardProcessing.class) {
            if (mInstance == null) {
                mInstance = new BankCardProcessing();
            }
            bankCardProcessing = mInstance;
        }
        return bankCardProcessing;
    }

    public native int bankcardCaptchaInit(AssetManager assetManager, String str);

    public native int bankcardCaptchaRelease();

    public native int bankcardModelInit(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, String str6);

    public native int bankcardModelRelease();

    public byte[] getRGBImageData(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        byte[] bArr = new byte[i2 * 3];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = iArr[i3];
            int i5 = i3 * 3;
            bArr[i5 + 0] = (byte) ((i4 >> 16) & 255);
            bArr[i5 + 1] = (byte) ((i4 >> 8) & 255);
            bArr[i5 + 2] = (byte) (i4 & 255);
        }
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        Log.w(TAG, "getPixelsTime = " + currentTimeMillis2 + " ms");
        Log.w(TAG, "getRGBsTime = " + currentTimeMillis4 + " ms");
        return bArr;
    }

    public int init(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Log.i(TAG, "[In init] number of tasks is " + this.mNumberOfTasks.get());
        int bankcardModelInit = bankcardModelInit(assetManager, str, str2, str3, str4, str5, str6);
        if (bankcardModelInit < 0) {
            Log.e(TAG, "Model initialization failure.");
            return bankcardModelInit;
        }
        int bankcardCaptchaInit = bankcardCaptchaInit(assetManager, str7);
        if (bankcardCaptchaInit < 0) {
            Log.e(TAG, "Captcha initialization failure");
            bankcardModelRelease();
            return bankcardCaptchaInit;
        } else if (bankcardModelInit == 0 || bankcardCaptchaInit == 0) {
            this.mNumberOfTasks.incrementAndGet();
            return 0;
        } else {
            return 0;
        }
    }

    public int release() {
        Log.i(TAG, "[In release] number of tasks is " + this.mNumberOfTasks.get());
        do {
        } while (this.mNumberOfTasks.get() > 1);
        int bankcardModelRelease = bankcardModelRelease();
        if (bankcardModelRelease != 0) {
            Log.e(TAG, "Error: release of bankcard model failure!");
            return bankcardModelRelease;
        }
        int bankcardCaptchaRelease = bankcardCaptchaRelease();
        if (bankcardCaptchaRelease != 0) {
            Log.e(TAG, "Error: release of captcha failure!");
            return bankcardCaptchaRelease;
        }
        this.mNumberOfTasks.decrementAndGet();
        return 0;
    }

    public Bitmap resize(Bitmap bitmap, int i2) {
        if (bitmap.getHeight() != i2) {
            int width = (bitmap.getWidth() * i2) / bitmap.getHeight();
            if (width <= i2) {
                width = i2;
            }
            return Bitmap.createScaledBitmap(bitmap, width, i2, false);
        }
        return bitmap;
    }

    public BCResult runBankCardProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        if (!UIThread.isUITread()) {
            if (mAuthorityStatus <= 48) {
                Log.i(TAG, "[In runBankCardProcess] number of tasks is " + this.mNumberOfTasks.get());
                if (this.mNumberOfTasks.get() >= 1) {
                    this.mNumberOfTasks.incrementAndGet();
                    BCResult BankCardProcess = BankCardProcess(bArr, i2, i3, i4, i5, i6, i7, i8, z);
                    this.mNumberOfTasks.decrementAndGet();
                    return BankCardProcess;
                }
                Log.e(TAG, "Error: Initialize the model first!");
                return null;
            }
            throw new IDLAuthorityException();
        }
        throw new AlgorithmOnMainThreadException();
    }

    public BCResult runBankCardProcessing(AssetManager assetManager, String str, String str2, String str3, String str4, Bitmap bitmap, int i2, boolean z) {
        return runBankCardProcessing(assetManager, str, null, str2, null, str3, null, str4, bitmap, i2, z);
    }

    public void saveBCRImage(BCResult bCResult) {
        saveRGBDataToJPG(bCResult.pbDstImg, bCResult.nDstWidth, bCResult.nDstHeight);
    }

    public void saveRGBDataToJPG(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 * 3;
            iArr[i5] = (bArr[i6 + 2] & 255) | ((bArr[i6] & 255) << 16) | (-16777216) | ((bArr[i6 + 1] & 255) << 8);
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i2, i3, Bitmap.Config.ARGB_8888);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        try {
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, new FileOutputStream(new File(absolutePath + "/bankcard/card.jpg")));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public BCResult runBankCardProcessing(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, String str6, String str7, Bitmap bitmap, int i2, boolean z) {
        if (!UIThread.isUITread()) {
            if (mAuthorityStatus <= 48) {
                if (bitmap == null) {
                    Log.e(TAG, "Error: input bitmap is null.");
                    return null;
                } else if (bankcardModelInit(assetManager, str, str2, str3, str4, str5, str6) < 0) {
                    Log.e(TAG, "Model initialization failure.");
                    return null;
                } else if (bankcardCaptchaInit(assetManager, str7) < 0) {
                    Log.e(TAG, "Captcha initialization failure");
                    bankcardModelRelease();
                    return null;
                } else {
                    int height = bitmap.getHeight();
                    int width = bitmap.getWidth();
                    BCResult runBankCardProcess = runBankCardProcess(getRGBImageData(bitmap), height, width, 1, 1, width - 1, height - 1, i2, z);
                    if (runBankCardProcess != null) {
                        String cardNumberToString = runBankCardProcess.cardNumberToString();
                        this.mCardNumber = cardNumberToString;
                        if (cardNumberToString != null) {
                            Log.i(TAG, "cardNumber is " + this.mCardNumber);
                        }
                    }
                    Statistics.getInstance().triggerEvent(TAG);
                    return runBankCardProcess;
                }
            }
            throw new IDLAuthorityException();
        }
        throw new AlgorithmOnMainThreadException();
    }

    public static synchronized int init(String str) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        int i2;
        synchronized (BankCardProcessing.class) {
            if (!UIThread.isUITread()) {
                tokenString = str;
                try {
                    mAuthorityStatus = License.getInstance().init(tokenString);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                i2 = mAuthorityStatus;
            } else {
                throw new AlgorithmOnMainThreadException();
            }
        }
        return i2;
    }

    public BCResult runBankCardProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        return runBankCardProcess(bArr, i2, i3, i4, i5, i6, i7, 2, true);
    }

    public static synchronized int init(Context context, String str) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        int i2;
        synchronized (BankCardProcessing.class) {
            if (!UIThread.isUITread()) {
                mApiKey = str;
                try {
                    mAuthorityStatus = License.getInstance().init(context, mApiKey, 2, "bankcard");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                i2 = mAuthorityStatus;
            } else {
                throw new AlgorithmOnMainThreadException();
            }
        }
        return i2;
    }

    public BCResult runBankCardProcessing(AssetManager assetManager, String str, String str2, String str3, String str4, Bitmap bitmap) {
        return runBankCardProcessing(assetManager, str, null, str2, null, str3, null, str4, bitmap, 2, true);
    }

    public BCResult runBankCardProcessing(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, String str6, String str7, Bitmap bitmap) {
        return runBankCardProcessing(assetManager, str, str2, str3, str4, str5, str6, str7, bitmap, 2, true);
    }
}
