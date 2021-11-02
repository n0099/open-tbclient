package com.baidu.bankdetection;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.idl.authority.AlgorithmOnMainThreadException;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.idl.license.License;
import com.baidu.idl.statistics.Statistics;
import com.baidu.idl.util.UIThread;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class BankCardProcessing {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BankCardProcessing";
    public static String mApiKey = null;
    public static int mAuthorityStatus = 0;
    public static BankCardProcessing mInstance = null;
    public static final boolean sCheckAuthority = true;
    public static String tokenString;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCardNumber;
    public AtomicInteger mNumberOfTasks;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(946326472, "Lcom/baidu/bankdetection/BankCardProcessing;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(946326472, "Lcom/baidu/bankdetection/BankCardProcessing;");
                return;
            }
        }
        System.loadLibrary(License.LICENSE_ASSETS_FILE);
        System.loadLibrary("bankcardprocess.1.1.1");
        mInstance = null;
        mAuthorityStatus = 256;
    }

    public BankCardProcessing() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNumberOfTasks = new AtomicInteger(0);
    }

    private native BCResult BankCardProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

    public static synchronized BankCardProcessing getInstance() {
        InterceptResult invokeV;
        BankCardProcessing bankCardProcessing;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (BankCardProcessing.class) {
                if (mInstance == null) {
                    mInstance = new BankCardProcessing();
                }
                bankCardProcessing = mInstance;
            }
            return bankCardProcessing;
        }
        return (BankCardProcessing) invokeV.objValue;
    }

    public native int bankcardCaptchaInit(AssetManager assetManager, String str);

    public native int bankcardCaptchaRelease();

    public native int bankcardModelInit(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, String str6);

    public native int bankcardModelRelease();

    public byte[] getRGBImageData(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bitmap)) == null) {
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
            String str = "getPixelsTime = " + currentTimeMillis2 + " ms";
            String str2 = "getRGBsTime = " + (System.currentTimeMillis() - currentTimeMillis3) + " ms";
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public int init(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{assetManager, str, str2, str3, str4, str5, str6, str7})) == null) {
            String str8 = "[In init] number of tasks is " + this.mNumberOfTasks.get();
            int bankcardModelInit = bankcardModelInit(assetManager, str, str2, str3, str4, str5, str6);
            if (bankcardModelInit < 0) {
                return bankcardModelInit;
            }
            int bankcardCaptchaInit = bankcardCaptchaInit(assetManager, str7);
            if (bankcardCaptchaInit < 0) {
                bankcardModelRelease();
                return bankcardCaptchaInit;
            } else if (bankcardModelInit == 0 || bankcardCaptchaInit == 0) {
                this.mNumberOfTasks.incrementAndGet();
                return 0;
            } else {
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    public int release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = "[In release] number of tasks is " + this.mNumberOfTasks.get();
            do {
            } while (this.mNumberOfTasks.get() > 1);
            int bankcardModelRelease = bankcardModelRelease();
            if (bankcardModelRelease != 0) {
                return bankcardModelRelease;
            }
            int bankcardCaptchaRelease = bankcardCaptchaRelease();
            if (bankcardCaptchaRelease != 0) {
                return bankcardCaptchaRelease;
            }
            this.mNumberOfTasks.decrementAndGet();
            return 0;
        }
        return invokeV.intValue;
    }

    public Bitmap resize(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, bitmap, i2)) == null) {
            if (bitmap.getHeight() != i2) {
                int width = (bitmap.getWidth() * i2) / bitmap.getHeight();
                if (width <= i2) {
                    width = i2;
                }
                return Bitmap.createScaledBitmap(bitmap, width, i2, false);
            }
            return bitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public BCResult runBankCardProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})) == null) {
            if (!UIThread.isUITread()) {
                if (mAuthorityStatus <= 48) {
                    String str = "[In runBankCardProcess] number of tasks is " + this.mNumberOfTasks.get();
                    if (this.mNumberOfTasks.get() >= 1) {
                        this.mNumberOfTasks.incrementAndGet();
                        BCResult BankCardProcess = BankCardProcess(bArr, i2, i3, i4, i5, i6, i7, i8, z);
                        this.mNumberOfTasks.decrementAndGet();
                        return BankCardProcess;
                    }
                    return null;
                }
                throw new IDLAuthorityException();
            }
            throw new AlgorithmOnMainThreadException();
        }
        return (BCResult) invokeCommon.objValue;
    }

    public BCResult runBankCardProcessing(AssetManager assetManager, String str, String str2, String str3, String str4, Bitmap bitmap, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{assetManager, str, str2, str3, str4, bitmap, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? runBankCardProcessing(assetManager, str, null, str2, null, str3, null, str4, bitmap, i2, z) : (BCResult) invokeCommon.objValue;
    }

    public void saveBCRImage(BCResult bCResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bCResult) == null) {
            saveRGBDataToJPG(bCResult.pbDstImg, bCResult.nDstWidth, bCResult.nDstHeight);
        }
    }

    public void saveRGBDataToJPG(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, bArr, i2, i3) == null) {
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
    }

    public BCResult runBankCardProcessing(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, String str6, String str7, Bitmap bitmap, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{assetManager, str, str2, str3, str4, str5, str6, str7, bitmap, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (!UIThread.isUITread()) {
                if (mAuthorityStatus <= 48) {
                    if (bitmap != null && bankcardModelInit(assetManager, str, str2, str3, str4, str5, str6) >= 0) {
                        if (bankcardCaptchaInit(assetManager, str7) < 0) {
                            bankcardModelRelease();
                            return null;
                        }
                        int height = bitmap.getHeight();
                        int width = bitmap.getWidth();
                        BCResult runBankCardProcess = runBankCardProcess(getRGBImageData(bitmap), height, width, 1, 1, width - 1, height - 1, i2, z);
                        if (runBankCardProcess != null) {
                            String cardNumberToString = runBankCardProcess.cardNumberToString();
                            this.mCardNumber = cardNumberToString;
                            if (cardNumberToString != null) {
                                String str8 = "cardNumber is " + this.mCardNumber;
                            }
                        }
                        Statistics.getInstance().triggerEvent(TAG);
                        return runBankCardProcess;
                    }
                    return null;
                }
                throw new IDLAuthorityException();
            }
            throw new AlgorithmOnMainThreadException();
        }
        return (BCResult) invokeCommon.objValue;
    }

    public static synchronized int init(String str) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
        return invokeL.intValue;
    }

    public BCResult runBankCardProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) ? runBankCardProcess(bArr, i2, i3, i4, i5, i6, i7, 2, true) : (BCResult) invokeCommon.objValue;
    }

    public static synchronized int init(Context context, String str) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
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
        return invokeLL.intValue;
    }

    public BCResult runBankCardProcessing(AssetManager assetManager, String str, String str2, String str3, String str4, Bitmap bitmap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{assetManager, str, str2, str3, str4, bitmap})) == null) ? runBankCardProcessing(assetManager, str, null, str2, null, str3, null, str4, bitmap, 2, true) : (BCResult) invokeCommon.objValue;
    }

    public BCResult runBankCardProcessing(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, String str6, String str7, Bitmap bitmap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{assetManager, str, str2, str3, str4, str5, str6, str7, bitmap})) == null) ? runBankCardProcessing(assetManager, str, str2, str3, str4, str5, str6, str7, bitmap, 2, true) : (BCResult) invokeCommon.objValue;
    }
}
