package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PhoneUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;
/* loaded from: classes2.dex */
public class PassBiometricUtil {
    public static final String CPU_TYPE_ARM64_V8A = "arm64-v8a";
    public static final String CPU_TYPE_ARMEABI = "armeabi";
    public static final String CPU_TYPE_ARMEABI_V7A = "armeabi-v7a";
    public static final String CPU_TYPE_X86 = "x86";
    static final int STANDARD_BG_HEIGHT = 1335;
    static final int STANDARD_BG_WIDTH = 750;
    static final int STANDARD_FACE_INSIDE_MAX_HEIGHT = 620;
    static final int STANDARD_FACE_INSIDE_MAX_WIDTH = 480;
    static final int STANDARD_FACE_MIDDLE_MARGIN_TOP = 728;
    static final int STANDARD_FACE_WIDTH = 480;
    static final int STANDARD_MAX_FACE_WIDTH = 480;
    static final int STANDARD_MIN_FACE_WIDTH = 192;
    private static final String TAG = "PassBiometricUtil";

    public static String getOSVersion() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : LivenessStat.TYPE_STRING_DEFAULT;
    }

    public static String getOSModel() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : LivenessStat.TYPE_STRING_DEFAULT;
    }

    public static String getClientId(Context context) {
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable th) {
            return "123456789";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0144 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #1 {IOException -> 0x0148, blocks: (B:38:0x013f, B:40:0x0144), top: B:87:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuType() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str;
        String str2;
        String readLine;
        FileReader fileReader2 = null;
        String[] strArr = {"", ""};
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (IOException e) {
                e = e;
                bufferedReader = null;
                fileReader2 = fileReader;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            fileReader = null;
        }
        try {
            String readLine2 = bufferedReader.readLine();
            String[] split = readLine2.split("\\s+");
            Log.d(TAG, "getCpuType()str2:" + readLine2);
            for (int i = 2; i < split.length; i++) {
                strArr[0] = strArr[0] + split[i] + " ";
            }
            Log.d(TAG, "getCpuType()str2" + bufferedReader.readLine());
            strArr[1] = strArr[1] + readLine.split("\\s+")[2];
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e4) {
            e = e4;
            fileReader2 = fileReader;
            try {
                e.printStackTrace();
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                str = Build.CPU_ABI;
                if (Build.VERSION.SDK_INT >= 8) {
                }
                str2 = IXAdSystemUtils.NT_NONE;
                Log.i(TAG, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
                if (!str.equals(CPU_TYPE_ARMEABI)) {
                }
                return CPU_TYPE_ARMEABI;
            } catch (Throwable th3) {
                th = th3;
                fileReader = fileReader2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileReader != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        str = Build.CPU_ABI;
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                str2 = (String) Build.class.getDeclaredField("cpuAbi2").get(null);
            } catch (Exception e7) {
                Log.w(TAG, "getCpuType() abi2" + e7.toString());
            }
            Log.i(TAG, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
            if (!str.equals(CPU_TYPE_ARMEABI) || str2.equals(CPU_TYPE_ARMEABI)) {
                return CPU_TYPE_ARMEABI;
            }
            if (str.equals(CPU_TYPE_ARMEABI_V7A) || str2.equals(CPU_TYPE_ARMEABI_V7A)) {
                return CPU_TYPE_ARMEABI_V7A;
            }
            if (str.equals(CPU_TYPE_ARM64_V8A) || str2.equals(CPU_TYPE_ARM64_V8A)) {
                return CPU_TYPE_ARM64_V8A;
            }
            if (str.equals(CPU_TYPE_X86) || str2.equals(CPU_TYPE_X86)) {
                return CPU_TYPE_X86;
            }
            if (strArr[0].toLowerCase().contains(PhoneUtils.CPUInfo.PROCESSOR_ARMV7)) {
                return CPU_TYPE_ARMEABI_V7A;
            }
            if (strArr[0].toLowerCase().contains("arm")) {
                return CPU_TYPE_ARMEABI;
            }
            if (strArr[0].toLowerCase().contains("arm64")) {
                return CPU_TYPE_ARM64_V8A;
            }
            if (strArr[0].toLowerCase().contains(CPU_TYPE_X86)) {
                return CPU_TYPE_X86;
            }
            return CPU_TYPE_ARMEABI;
        }
        str2 = IXAdSystemUtils.NT_NONE;
        Log.i(TAG, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
        if (!str.equals(CPU_TYPE_ARMEABI)) {
        }
        return CPU_TYPE_ARMEABI;
    }

    public static String getPackageSign(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures.length <= 0) {
                return "";
            }
            return MD5Util.toMd5(packageInfo.signatures[0].toByteArray(), false);
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(i3 / i2);
        int round2 = Math.round(i4 / i);
        return round < round2 ? round : round2;
    }

    public static boolean isTooNearFromCamera(int[] iArr, int[] iArr2) {
        if (iArr2 == null || iArr2.length != 2) {
            return false;
        }
        Rect currentFaceRect = getCurrentFaceRect(iArr);
        return currentFaceRect.right - currentFaceRect.left > (iArr2[0] * 480) / 750;
    }

    public static boolean isTooFarFromCamera(int[] iArr, int[] iArr2) {
        if (iArr2 == null || iArr2.length != 2) {
            return false;
        }
        Rect currentFaceRect = getCurrentFaceRect(iArr);
        return currentFaceRect.right - currentFaceRect.left < (iArr2[0] * STANDARD_MIN_FACE_WIDTH) / 750;
    }

    public static void drawShape(int[] iArr, Bitmap bitmap) {
        Point point;
        Point point2;
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        paint.setStrokeWidth(4.0f);
        paint.setColor(-16711936);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setColor(-16711936);
        for (int i = 0; i < iArr.length / 2; i++) {
            canvas.drawCircle(iArr[i << 1], iArr[(i << 1) + 1], 2.0f, paint);
        }
        Rect currentFaceRect = getCurrentFaceRect(iArr);
        canvas.drawRect(currentFaceRect, paint);
        new Point().set(currentFaceRect.centerX(), currentFaceRect.centerY());
        paint.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawCircle(point.x, point.y, 5.0f, paint);
        canvas.drawRect(getFaceInsideRoundRect(new int[]{bitmap.getWidth(), bitmap.getHeight()}), paint);
        new Point().set(bitmap.getWidth() / 2, (bitmap.getHeight() * STANDARD_FACE_MIDDLE_MARGIN_TOP) / STANDARD_BG_HEIGHT);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawCircle(point2.x, point2.y, 5.0f, paint);
        int width = ((bitmap.getWidth() * 480) / 750) / 2;
        canvas.drawRect(point2.x - width, point2.y - width, point2.x + width, width + point2.y, paint);
        int width2 = ((bitmap.getWidth() * STANDARD_MIN_FACE_WIDTH) / 750) / 2;
        canvas.drawRect(point2.x - width2, point2.y - width2, point2.x + width2, width2 + point2.y, paint);
    }

    private static Rect getCurrentFaceRect(int[] iArr) {
        Point point = new Point();
        Point point2 = new Point();
        if (iArr.length > 2) {
            point.x = iArr[0];
            point.y = iArr[1];
            point2.x = iArr[0];
            point2.y = iArr[1];
        }
        for (int i = 0; i < iArr.length / 2; i++) {
            float f = iArr[i << 1];
            float f2 = iArr[(i << 1) + 1];
            if (f < point.x) {
                point.x = (int) f;
            }
            if (f2 < point.y) {
                point.y = (int) f2;
            }
            if (f > point2.x) {
                point2.x = (int) f;
            }
            if (f2 > point2.y) {
                point2.y = (int) f2;
            }
        }
        return new Rect(point.x, point.y, point2.x, point2.y);
    }

    public static boolean isFaceInsideRound(int[] iArr, int[] iArr2) {
        if (iArr2 == null || iArr2.length != 2) {
            return false;
        }
        Rect currentFaceRect = getCurrentFaceRect(iArr);
        Rect faceInsideRoundRect = getFaceInsideRoundRect(iArr2);
        return faceInsideRoundRect.bottom > currentFaceRect.bottom && faceInsideRoundRect.top < currentFaceRect.top;
    }

    public static Rect getFaceInsideRoundRect(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return new Rect(0, 0, 0, 0);
        }
        int i = ((iArr[0] * 480) / 750) / 2;
        int i2 = ((iArr[1] * STANDARD_FACE_INSIDE_MAX_HEIGHT) / STANDARD_BG_HEIGHT) / 2;
        Point point = new Point();
        point.set(iArr[0] / 2, (iArr[1] * STANDARD_FACE_MIDDLE_MARGIN_TOP) / STANDARD_BG_HEIGHT);
        return new Rect(point.x - i, point.y - i2, i + point.x, i2 + point.y);
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        if (!TextUtils.isEmpty(uuid)) {
            return uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        }
        return uuid;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    public static void savePic(Bitmap bitmap) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/awe");
                file.mkdirs();
                File file2 = new File(file, String.format("%d.jpg", Long.valueOf(System.currentTimeMillis())));
                if (file2.exists()) {
                    file2.delete();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                if (fileOutputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String getUA(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("pass_bio").append("-p-");
        sb.append("android").append("-p-");
        sb.append(str).append("-p-");
        sb.append(getVersionCode(context)).append("-p-");
        sb.append(PassBiometricDefaultFactory.VERSION_NAME).append("-p-");
        sb.append(getOSModel()).append("-p-");
        sb.append(getOSVersion());
        return sb.toString();
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
            return Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0;
        }
        return true;
    }
}
