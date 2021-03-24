package com.baidu.idl.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;
import com.baidu.idl.authority.AlgorithmOnMainThreadException;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.idl.license.License;
import com.baidu.idl.statistics.Statistics;
import com.baidu.idl.util.UIThread;
import com.bumptech.glide.load.engine.executor.RuntimeCompat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class FaceSDK {
    public static final String TAG = "FaceSDK";
    public static final String VERSION = "3.0.3.0";
    public static String cdnn_alignmean_path = "";
    public static String cdnn_alignmodel_path = "align_model.binary";
    public static String cdnn_parsingmodel_path1 = "3_class_model";
    public static String cdnn_parsingmodel_path2 = "7_class_model";
    public static String cdnn_parsingparam_path1 = "";
    public static String cdnn_parsingparam_path2 = "";
    public static String mApiKey = null;
    public static int mAuthorityStatus = 256;
    public static FaceSDK mInstance = null;
    public static String sdm_15pts_model_path = "15pts.bin";
    public static String sdm_7pts_model_path = "7pts.bin";
    public static String sdm_alignmodel_path = "facialLandmarksModel2.bin";
    public static final String tag = "FaceSDK";

    /* loaded from: classes2.dex */
    public enum AlignMethodType {
        SDM,
        CDNN,
        SDM_7PTS,
        SDM_15PTS
    }

    /* loaded from: classes2.dex */
    public enum DetectMethodType {
        BOOST
    }

    /* loaded from: classes2.dex */
    public enum ImgType {
        ARGB
    }

    /* loaded from: classes2.dex */
    public enum LivenessAction {
        RESET,
        ADD_ONE_FRAME
    }

    /* loaded from: classes2.dex */
    public enum LivenessMethodType {
        EYE_BLINK,
        MOUTH_MOTION,
        HEAD_POSE,
        ALL
    }

    /* loaded from: classes2.dex */
    public enum ParsMethodType {
        NOT_USE,
        CLASS_NUM_3,
        CLASS_NUM_7,
        CLASS_NUM_10
    }

    public static native int AlignModelInit(AssetManager assetManager, String str, String str2, int i);

    public static native int CropFaceImg(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int[] iArr4);

    @Deprecated
    public static boolean copyFileFromAssets(Context context, String str, String str2) {
        try {
            InputStream open = context.getAssets().open(str);
            File file = new File(str2);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    open.close();
                    return true;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static native int getARGBFromYUV420img(byte[] bArr, int[] iArr, int i, int i2);

    public static native int getARGBFromYUVimg(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4);

    public static synchronized void getInstance(AssetManager assetManager, final Context context, final String str, final String str2, final String str3, AlignMethodType alignMethodType, ParsMethodType parsMethodType) {
        synchronized (FaceSDK.class) {
            if (mAuthorityStatus > 48) {
                new Thread(new Runnable() { // from class: com.baidu.idl.facesdk.FaceSDK.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (str2 == null || str2.length() <= 0) {
                                FaceSDK.initLicense(context, str, str3);
                            } else {
                                FaceSDK.init(context, str, str2);
                            }
                        } catch (AlgorithmOnMainThreadException e2) {
                            e2.printStackTrace();
                        } catch (IDLAuthorityException e3) {
                            e3.printStackTrace();
                        }
                    }
                }).start();
            }
            if (mInstance == null) {
                mInstance = new FaceSDK();
            }
            if (alignMethodType == AlignMethodType.SDM) {
                AlignModelInit(assetManager, sdm_alignmodel_path, "", AlignMethodType.SDM.ordinal());
            } else if (alignMethodType == AlignMethodType.CDNN) {
                AlignModelInit(assetManager, cdnn_alignmodel_path, cdnn_alignmean_path, AlignMethodType.CDNN.ordinal());
            } else if (alignMethodType == AlignMethodType.SDM_7PTS) {
                AlignModelInit(assetManager, sdm_7pts_model_path, "", AlignMethodType.SDM_7PTS.ordinal());
            } else if (alignMethodType == AlignMethodType.SDM_15PTS) {
                AlignModelInit(assetManager, sdm_15pts_model_path, "", AlignMethodType.SDM_15PTS.ordinal());
            }
            int numCores = getNumCores();
            setNumberOfThreads(numCores > 1 ? numCores / 2 : 1);
        }
    }

    @Deprecated
    public static int getNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.idl.facesdk.FaceSDK.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches(RuntimeCompat.CPU_NAME_REGEX, file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static String getVersion() {
        return VERSION;
    }

    @Deprecated
    public static synchronized int init(Context context, String str) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        int init;
        synchronized (FaceSDK.class) {
            if (!UIThread.isUITread()) {
                mApiKey = str;
                Statistics.getInstance().init(context.getApplicationContext(), str);
                init = License.getInstance().init(context, mApiKey);
                mAuthorityStatus = init;
            } else {
                throw new AlgorithmOnMainThreadException();
            }
        }
        return init;
    }

    public static synchronized int initLicense(Context context, String str, String str2) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        int init;
        synchronized (FaceSDK.class) {
            if (!UIThread.isUITread()) {
                mApiKey = str;
                init = License.getInstance().init(context, mApiKey, str2);
                mAuthorityStatus = init;
            } else {
                throw new AlgorithmOnMainThreadException();
            }
        }
        return init;
    }

    public static boolean isAuthoritySucceeded() {
        return mAuthorityStatus < 48;
    }

    @Deprecated
    public static void savePic(Bitmap bitmap) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory.getAbsolutePath() + "/awe/");
            file.mkdirs();
            File file2 = new File(file, String.format("%d.png", Long.valueOf(System.currentTimeMillis())));
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static native int setBaseInfoValueLogFlag(int i);

    public static native int setLivenessValueLogFlag(int i);

    public static native int setNumberOfThreads(int i);

    public static native int setPerfLogFlag(int i);

    public static native int setQualityValueLogFlag(int i);

    public static native int setValueLogFlag(int i);

    @Deprecated
    public static synchronized int init(Context context, String str, String str2) throws AlgorithmOnMainThreadException, IDLAuthorityException {
        int init;
        synchronized (FaceSDK.class) {
            if (!UIThread.isUITread()) {
                mApiKey = str;
                Statistics.getInstance().init(context.getApplicationContext(), str);
                init = License.getInstance().init(str2);
                mAuthorityStatus = init;
            } else {
                throw new AlgorithmOnMainThreadException();
            }
        }
        return init;
    }
}
