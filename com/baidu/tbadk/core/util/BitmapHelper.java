package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.SparseArray;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.m;
import d.a.c.k.d.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
/* loaded from: classes3.dex */
public class BitmapHelper {
    public static final int FILE_2_BITMAP_MUL = 10;
    public static final int ROTATE_LEFT = 0;
    public static final int ROTATE_LEFT_RIGHT = 2;
    public static final int ROTATE_RIGHT = 1;
    public static final int ROTATE_UP_DOWN = 3;
    public static final Object lockForSyncImageDecoder = new Object();
    public static volatile SparseArray<SoftReference<Bitmap>> mBitmapHash = new SparseArray<>();
    public static volatile SparseArray<SoftReference<Bitmap>> mBitmapNightHash = new SparseArray<>();
    public static volatile SparseArray<SoftReference<Bitmap>> mBitmapDarkHash = new SparseArray<>();
    public static volatile SparseArray<SoftReference<Bitmap>> mBitmapThemeHash = new SparseArray<>();

    public static byte[] Bitmap2Bytes(Bitmap bitmap, int i2) {
        byte[] byteArray;
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, i2, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public static Bitmap Bytes2Bitmap(byte[] bArr) {
        Bitmap bitmap = null;
        if (bArr != null && bArr.length != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            try {
                synchronized (lockForSyncImageDecoder) {
                    bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            } catch (Error e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return bitmap;
    }

    public static Bitmap Bytes2NineBitmap(byte[] bArr, Rect rect) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        int i2 = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().densityDpi;
        options.inScreenDensity = i2;
        options.inTargetDensity = i2;
        options.inDensity = i2;
        Bitmap bitmap = null;
        try {
            try {
                try {
                    try {
                        synchronized (lockForSyncImageDecoder) {
                            bitmap = BitmapFactory.decodeStream(byteArrayInputStream, rect, options);
                        }
                        byteArrayInputStream.close();
                    } catch (Error e2) {
                        e2.printStackTrace();
                        byteArrayInputStream.close();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    byteArrayInputStream.close();
                } catch (OutOfMemoryError e4) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    e4.printStackTrace();
                    byteArrayInputStream.close();
                }
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e5) {
                    BdLog.d(e5.getMessage());
                }
                throw th;
            }
        } catch (IOException e6) {
            BdLog.d(e6.getMessage());
        }
        return bitmap;
    }

    public static int calcNearestSize(int i2) {
        int i3 = 1;
        for (int i4 = 1; i4 <= i2; i4 *= 2) {
            int i5 = i2 - i4;
            if (i5 == 0) {
                return i2;
            }
            if (i5 > 0) {
                i3 = i4;
            }
        }
        return i3;
    }

    public static Bitmap checkBitmapSize(Bitmap bitmap, int i2, int i3) {
        return bitmap;
    }

    public static a checkIsValidPhotoMemoryCache(String str, a aVar, int i2, int i3) {
        return aVar;
    }

    public static a checkIsValidPicMemoryCache(String str, a aVar, int i2, int i3) {
        return aVar;
    }

    public static void clearCashBitmap() {
        mBitmapHash.clear();
        mBitmapNightHash.clear();
        mBitmapThemeHash.clear();
    }

    public static void clearThemeCashBitmap() {
        mBitmapThemeHash.clear();
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            try {
                if (bArr.length != 0 && i2 > 0 && i3 > 0) {
                    synchronized (lockForSyncImageDecoder) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = TbConfig.BitmapConfig;
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                            options.inSampleSize = ImageUtil.calculateInSampleSize(options, i2, i3);
                            options.inJustDecodeBounds = false;
                            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        }
                        return null;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Bitmap fastblur(Bitmap bitmap, int i2, float f2) {
        int[] iArr;
        int i3 = i2;
        if (i3 < 1 || bitmap == null || f2 <= 0.0f) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f2), Math.round(bitmap.getHeight() * f2), false);
        Bitmap copy = createScaledBitmap.copy(createScaledBitmap.getConfig(), true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i4 = width * height;
        int[] iArr2 = new int[i4];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3 + 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width, height)];
        int i8 = (i7 + 1) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr7 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr7[i11] = i11 / i9;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, i7, 3);
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            Bitmap bitmap2 = copy;
            int i16 = height;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = -i3;
            int i26 = 0;
            while (i25 <= i3) {
                int i27 = i6;
                int[] iArr9 = iArr6;
                int i28 = iArr2[i14 + Math.min(i5, Math.max(i25, 0))];
                int[] iArr10 = iArr8[i25 + i3];
                iArr10[0] = (i28 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr10[1] = (i28 & 65280) >> 8;
                iArr10[2] = i28 & 255;
                int abs = i12 - Math.abs(i25);
                i26 += iArr10[0] * abs;
                i17 += iArr10[1] * abs;
                i18 += iArr10[2] * abs;
                if (i25 > 0) {
                    i22 += iArr10[0];
                    i23 += iArr10[1];
                    i24 += iArr10[2];
                } else {
                    i19 += iArr10[0];
                    i20 += iArr10[1];
                    i21 += iArr10[2];
                }
                i25++;
                i6 = i27;
                iArr6 = iArr9;
            }
            int i29 = i6;
            int[] iArr11 = iArr6;
            int i30 = i26;
            int i31 = i3;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i14] = iArr7[i30];
                iArr4[i14] = iArr7[i17];
                iArr5[i14] = iArr7[i18];
                int i33 = i30 - i19;
                int i34 = i17 - i20;
                int i35 = i18 - i21;
                int[] iArr12 = iArr8[((i31 - i3) + i7) % i7];
                int i36 = i19 - iArr12[0];
                int i37 = i20 - iArr12[1];
                int i38 = i21 - iArr12[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr11[i32] = Math.min(i32 + i3 + 1, i5);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i15 + iArr11[i32]];
                iArr12[0] = (i39 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr12[1] = (i39 & 65280) >> 8;
                iArr12[2] = i39 & 255;
                int i40 = i22 + iArr12[0];
                int i41 = i23 + iArr12[1];
                int i42 = i24 + iArr12[2];
                i30 = i33 + i40;
                i17 = i34 + i41;
                i18 = i35 + i42;
                i31 = (i31 + 1) % i7;
                int[] iArr13 = iArr8[i31 % i7];
                i19 = i36 + iArr13[0];
                i20 = i37 + iArr13[1];
                i21 = i38 + iArr13[2];
                i22 = i40 - iArr13[0];
                i23 = i41 - iArr13[1];
                i24 = i42 - iArr13[2];
                i14++;
                i32++;
                iArr7 = iArr;
            }
            i15 += width;
            i13++;
            copy = bitmap2;
            height = i16;
            i6 = i29;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i43 = height;
        int[] iArr14 = iArr7;
        int i44 = i6;
        int[] iArr15 = iArr6;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i3;
            int i47 = i7;
            int[] iArr16 = iArr2;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = i46;
            int i56 = i46 * width;
            int i57 = 0;
            int i58 = 0;
            while (i55 <= i3) {
                int i59 = width;
                int max = Math.max(0, i56) + i45;
                int[] iArr17 = iArr8[i55 + i3];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i55);
                i57 += iArr3[max] * abs2;
                i58 += iArr4[max] * abs2;
                i48 += iArr5[max] * abs2;
                if (i55 > 0) {
                    i52 += iArr17[0];
                    i53 += iArr17[1];
                    i54 += iArr17[2];
                } else {
                    i49 += iArr17[0];
                    i50 += iArr17[1];
                    i51 += iArr17[2];
                }
                int i60 = i44;
                if (i55 < i60) {
                    i56 += i59;
                }
                i55++;
                i44 = i60;
                width = i59;
            }
            int i61 = width;
            int i62 = i44;
            int i63 = i45;
            int i64 = i3;
            int i65 = i49;
            int i66 = i43;
            int i67 = i48;
            int i68 = i58;
            int i69 = i57;
            int i70 = 0;
            while (i70 < i66) {
                iArr16[i63] = (iArr16[i63] & (-16777216)) | (iArr14[i69] << 16) | (iArr14[i68] << 8) | iArr14[i67];
                int i71 = i69 - i65;
                int i72 = i68 - i50;
                int i73 = i67 - i51;
                int[] iArr18 = iArr8[((i64 - i3) + i47) % i47];
                int i74 = i65 - iArr18[0];
                int i75 = i50 - iArr18[1];
                int i76 = i51 - iArr18[2];
                if (i45 == 0) {
                    iArr15[i70] = Math.min(i70 + i12, i62) * i61;
                }
                int i77 = iArr15[i70] + i45;
                iArr18[0] = iArr3[i77];
                iArr18[1] = iArr4[i77];
                iArr18[2] = iArr5[i77];
                int i78 = i52 + iArr18[0];
                int i79 = i53 + iArr18[1];
                int i80 = i54 + iArr18[2];
                i69 = i71 + i78;
                i68 = i72 + i79;
                i67 = i73 + i80;
                i64 = (i64 + 1) % i47;
                int[] iArr19 = iArr8[i64];
                i65 = i74 + iArr19[0];
                i50 = i75 + iArr19[1];
                i51 = i76 + iArr19[2];
                i52 = i78 - iArr19[0];
                i53 = i79 - iArr19[1];
                i54 = i80 - iArr19[2];
                i63 += i61;
                i70++;
                i3 = i2;
            }
            i45++;
            i3 = i2;
            i44 = i62;
            i43 = i66;
            i7 = i47;
            iArr2 = iArr16;
            width = i61;
        }
        int i81 = width;
        bitmap3.setPixels(iArr2, 0, i81, 0, 0, i81, i43);
        return bitmap3;
    }

    public static int getBitmapSize(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static Bitmap getCashBitmap(int i2, BitmapFactory.Options options) {
        SoftReference<Bitmap> softReference = mBitmapHash.get(i2);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap resBitmap = getResBitmap(TbadkCoreApplication.getInst().getApp(), i2, options);
        if (resBitmap != null) {
            mBitmapHash.put(i2, new SoftReference<>(resBitmap));
        }
        return resBitmap;
    }

    public static Bitmap getDarkCashBitmap(Resources resources, int i2, int i3, BitmapFactory.Options options) {
        SoftReference<Bitmap> softReference = mBitmapDarkHash.get(i3);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap != null) {
            return bitmap;
        }
        try {
            bitmap = BitmapFactory.decodeResource(resources, i2, options);
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
        }
        if (bitmap != null) {
            mBitmapDarkHash.put(i3, new SoftReference<>(bitmap));
        }
        return bitmap;
    }

    public static int getGradeResourceIdInEnterForum(int i2) {
        switch (i2) {
            case 1:
                return R.drawable.icon_level_01;
            case 2:
                return R.drawable.icon_level_02;
            case 3:
                return R.drawable.icon_level_03;
            case 4:
                return R.drawable.icon_level_04;
            case 5:
                return R.drawable.icon_level_05;
            case 6:
                return R.drawable.icon_level_06;
            case 7:
                return R.drawable.icon_level_07;
            case 8:
                return R.drawable.icon_level_08;
            case 9:
                return R.drawable.icon_level_09;
            case 10:
                return R.drawable.icon_level_10;
            case 11:
                return R.drawable.icon_level_11;
            case 12:
                return R.drawable.icon_level_12;
            case 13:
                return R.drawable.icon_level_13;
            case 14:
                return R.drawable.icon_level_14;
            case 15:
                return R.drawable.icon_level_15;
            case 16:
                return R.drawable.icon_level_16;
            case 17:
                return R.drawable.icon_level_17;
            case 18:
                return R.drawable.icon_level_18;
            default:
                return 0;
        }
    }

    public static int getGradeResourceIdNew(int i2) {
        return getGradeResourceIdInEnterForum(i2);
    }

    public static Bitmap getLogoBitmap(Context context, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeResource(context.getResources(), i2, options);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    public static Bitmap getNightCashBitmap(Resources resources, int i2, int i3, BitmapFactory.Options options) {
        SoftReference<Bitmap> softReference = mBitmapNightHash.get(i3);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap != null) {
            return bitmap;
        }
        try {
            bitmap = BitmapFactory.decodeResource(resources, i2, options);
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
        }
        if (bitmap != null) {
            mBitmapNightHash.put(i3, new SoftReference<>(bitmap));
        }
        return bitmap;
    }

    public static Bitmap getResBitmap(Context context, int i2, BitmapFactory.Options options) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i2, options);
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            return null;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    public static Bitmap getResBitmapPowerOf2Size(Context context, int i2) {
        int i3;
        Bitmap resBitmap = getResBitmap(context, i2);
        int i4 = 0;
        if (resBitmap != null) {
            i4 = calcNearestSize(resBitmap.getWidth());
            i3 = calcNearestSize(resBitmap.getHeight());
        } else {
            i3 = 0;
        }
        return getResizedBitmap(resBitmap, i4, i3);
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i2, int i3) {
        Bitmap bitmap2;
        Bitmap bitmap3 = null;
        if (i2 <= 0 || i3 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            int width = bitmap.getWidth();
            float f2 = i3;
            float height = bitmap.getHeight();
            float f3 = f2 / height;
            float f4 = i2;
            float f5 = width;
            float f6 = f4 / f5;
            if (f3 < f6) {
                f3 = f6;
            }
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postScale(f3, f3);
                matrix.postTranslate((f4 - (f5 * f3)) / 2.0f, (f2 - (height * f3)) / 2.0f);
                try {
                    bitmap2 = Bitmap.createBitmap(i2, i3, bitmap.getConfig());
                } catch (NullPointerException unused) {
                } catch (OutOfMemoryError unused2) {
                }
                try {
                    new Canvas(bitmap2).drawBitmap(bitmap, matrix, null);
                } catch (NullPointerException unused3) {
                    bitmap3 = bitmap2;
                    bitmap2 = bitmap3;
                    return bitmap2;
                } catch (OutOfMemoryError unused4) {
                    bitmap3 = bitmap2;
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    bitmap2 = bitmap3;
                    return bitmap2;
                }
            }
            return bitmap2;
        }
        return bitmap;
    }

    public static Bitmap getResizedBitmapFillCenter(Bitmap bitmap, int i2, int i3) {
        Bitmap createBitmap;
        if (i2 <= 0 || i3 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f2 = i3 / height;
            float f3 = i2 / width;
            if (f2 > f3) {
                f2 = f3;
            }
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f2, boolean z) {
        Bitmap bitmap2 = null;
        try {
            synchronized (lockForSyncImageDecoder) {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(bitmap2);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                RectF rectF = new RectF(rect);
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-12434878);
                canvas.drawRoundRect(rectF, f2, f2, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);
            }
            if (bitmap2 != bitmap && z) {
                bitmap.recycle();
            }
        } catch (Throwable unused) {
        }
        return bitmap2;
    }

    public static int getSmallGradeResourceIdNew(int i2) {
        return getGradeResourceIdInEnterForum(i2);
    }

    public static Bitmap getSquareBitmap(Bitmap bitmap) {
        Bitmap createBitmap;
        if (bitmap == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            if (bitmap.getHeight() < bitmap.getWidth()) {
                createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - bitmap.getHeight()) >> 1, 0, bitmap.getHeight(), bitmap.getHeight());
            } else {
                createBitmap = bitmap.getHeight() > bitmap.getWidth() ? Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - bitmap.getWidth()) >> 1, bitmap.getWidth(), bitmap.getWidth()) : bitmap;
            }
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
        }
        return createBitmap;
    }

    public static Bitmap getThemeCashBitmap(Resources resources, int i2, int i3, BitmapFactory.Options options) {
        SoftReference<Bitmap> softReference = mBitmapThemeHash.get(i3);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap != null) {
            return bitmap;
        }
        try {
            bitmap = BitmapFactory.decodeResource(resources, i2, options);
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
        }
        if (bitmap != null) {
            mBitmapThemeHash.put(i3, new SoftReference<>(bitmap));
        }
        return bitmap;
    }

    public static Bitmap loadBitmap(String str) {
        InputStream inputStream;
        if (str != null && str.length() > 0) {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            try {
                try {
                    synchronized (lockForSyncImageDecoder) {
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPreferredConfig = TbConfig.BitmapConfig;
                            options.inJustDecodeBounds = false;
                            FileInputStream fileInputStream = new FileInputStream(file);
                            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                            m.e(fileInputStream);
                            return decodeStream;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = null;
                            try {
                                throw th;
                            } catch (Throwable unused) {
                                m.e(inputStream);
                                return null;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
        }
        return null;
    }

    public static Bitmap loadResizedBitmap(String str, int i2, int i3) {
        FileInputStream fileInputStream;
        try {
            synchronized (lockForSyncImageDecoder) {
                try {
                    if (str != null) {
                        try {
                            if (str.length() > 0 && i2 > 0 && i3 > 0) {
                                File file = new File(str);
                                if (!file.exists()) {
                                    m.e(null);
                                    return null;
                                }
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                int i4 = 1;
                                options.inJustDecodeBounds = true;
                                FileInputStream fileInputStream2 = new FileInputStream(file);
                                BitmapFactory.decodeStream(fileInputStream2, null, options);
                                options.inPreferredConfig = TbConfig.BitmapConfig;
                                m.e(fileInputStream2);
                                while (true) {
                                    int i5 = i4 * 2;
                                    if (options.outWidth / i5 <= i2 && options.outHeight / i5 <= i3) {
                                        options.inJustDecodeBounds = false;
                                        options.inSampleSize = i4;
                                        FileInputStream fileInputStream3 = new FileInputStream(file);
                                        try {
                                            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream3, null, options);
                                            m.e(fileInputStream3);
                                            return decodeStream;
                                        } catch (Throwable th) {
                                            th = th;
                                            fileInputStream = fileInputStream3;
                                            try {
                                                throw th;
                                            } catch (Throwable unused) {
                                                m.e(fileInputStream);
                                                return null;
                                            }
                                        }
                                    }
                                    i4 = i5;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = null;
                        }
                    }
                    m.e(null);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static int readPictureDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException unused) {
            return 0;
        }
    }

    public static void removeCashBitmap(int i2) {
        mBitmapHash.remove(i2);
        mBitmapNightHash.remove(i2);
        mBitmapThemeHash.remove(i2);
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i2, int i3, boolean z) {
        Bitmap createBitmap;
        if (i2 <= 0 || i3 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if ((bitmap.getWidth() > i2 || bitmap.getHeight() > i3) && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f2 = i3 / height;
            float f3 = i2 / width;
            if (f2 > f3) {
                f2 = f3;
            }
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                if (createBitmap != bitmap && z) {
                    bitmap.recycle();
                }
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap resizeBitmapAbsolute(String str, int i2) {
        return resizeBitmap(subSampleBitmapAbsolute(str, i2), i2);
    }

    public static Bitmap resizeBitmapAtLeast(Bitmap bitmap, int i2, int i3) {
        Bitmap createBitmap;
        if (i2 < 0 || i3 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (i2 == 0 || i3 == 0 || ((i2 >= bitmap.getWidth() && i3 >= bitmap.getHeight()) || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0)) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = i2 / width;
        float f3 = i3 / height;
        if (f2 <= f3) {
            f2 = f3;
        }
        if (f2 >= 1.0f) {
            return bitmap;
        }
        synchronized (lockForSyncImageDecoder) {
            Matrix matrix = new Matrix();
            matrix.postScale(f2, f2);
            createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
        }
        return createBitmap;
    }

    public static Bitmap reversalBitmap(Bitmap bitmap, int i2) {
        Bitmap createBitmap;
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i2 == 2) {
            matrix.setScale(1.0f, -1.0f);
        } else if (i2 == 3) {
            matrix.setScale(-1.0f, 1.0f);
        }
        synchronized (lockForSyncImageDecoder) {
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            matrix.setRotate(180.0f);
            createBitmap = Bitmap.createBitmap(createBitmap2, 0, 0, createBitmap2.getWidth(), createBitmap2.getHeight(), matrix, true);
            if (createBitmap2 != createBitmap) {
                createBitmap2.recycle();
            }
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
        }
        return createBitmap;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i2) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (lockForSyncImageDecoder) {
            Matrix matrix = new Matrix();
            if (i2 == 0) {
                matrix.postRotate(-90.0f);
            } else if (i2 == 1) {
                matrix.postRotate(90.0f);
            }
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (OutOfMemoryError unused) {
                bitmap2 = null;
            }
            if (bitmap2 == null) {
                bitmap2 = bitmap;
            }
            if (bitmap != bitmap2) {
                bitmap.recycle();
            }
        }
        return bitmap2;
    }

    public static Bitmap rotateBitmapBydegree(Bitmap bitmap, int i2) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (lockForSyncImageDecoder) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i2);
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Throwable unused) {
                bitmap2 = null;
            }
            if (bitmap2 == null) {
                bitmap2 = bitmap;
            }
            if (bitmap != bitmap2) {
                bitmap.recycle();
            }
        }
        return bitmap2;
    }

    public static Bitmap subSampleBitmap(String str, int i2) {
        Bitmap decodeStream;
        if (str != null && str.length() > 0 && i2 > 0) {
            try {
                synchronized (lockForSyncImageDecoder) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    int i3 = 1;
                    options.inJustDecodeBounds = true;
                    InputStream GetStreamFromFile = FileHelper.GetStreamFromFile(str);
                    BitmapFactory.decodeStream(GetStreamFromFile, null, options);
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    m.e(GetStreamFromFile);
                    while (true) {
                        int i4 = i3 * 2;
                        if (options.outWidth / i4 <= i2 && options.outHeight / i4 <= i2) {
                            options.inJustDecodeBounds = false;
                            options.inSampleSize = i3;
                            InputStream GetStreamFromFile2 = FileHelper.GetStreamFromFile(str);
                            decodeStream = BitmapFactory.decodeStream(GetStreamFromFile2, null, options);
                            m.e(GetStreamFromFile2);
                        }
                        i3 = i4;
                    }
                }
                return decodeStream;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Bitmap subSampleBitmapAbsolute(String str, int i2) {
        Bitmap decodeStream;
        if (str != null && str.length() > 0 && i2 > 0) {
            try {
                synchronized (lockForSyncImageDecoder) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    int i3 = 1;
                    options.inJustDecodeBounds = true;
                    InputStream GetStreamFromFile = FileHelper.GetStreamFromFile(new File(str));
                    BitmapFactory.decodeStream(GetStreamFromFile, null, options);
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    m.e(GetStreamFromFile);
                    while (true) {
                        int i4 = i3 * 2;
                        if (options.outWidth / i4 <= i2 && options.outHeight / i4 <= i2) {
                            options.inJustDecodeBounds = false;
                            options.inSampleSize = i3;
                            InputStream GetStreamFromFile2 = FileHelper.GetStreamFromFile(new File(str));
                            decodeStream = BitmapFactory.decodeStream(GetStreamFromFile2, null, options);
                            m.e(GetStreamFromFile2);
                        }
                        i3 = i4;
                    }
                }
                return decodeStream;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Bitmap getResBitmap(Context context, int i2) {
        return getResBitmap(context, i2, new BitmapFactory.Options());
    }

    public static Bitmap getCashBitmap(int i2) {
        return getCashBitmap(i2, new BitmapFactory.Options());
    }

    public static Bitmap getNightCashBitmap(Resources resources, int i2, int i3) {
        return getNightCashBitmap(resources, i2, i3, new BitmapFactory.Options());
    }

    public static Bitmap getThemeCashBitmap(Resources resources, int i2, int i3) {
        return getThemeCashBitmap(resources, i2, i3, new BitmapFactory.Options());
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i2) {
        return resizeBitmap(bitmap, i2, i2, true);
    }

    public static Bitmap loadBitmap(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        try {
            synchronized (lockForSyncImageDecoder) {
                if (str != null) {
                    try {
                        if (str.length() > 0) {
                            File file = new File(str);
                            if (file.exists() && file.isFile()) {
                                if (options == null) {
                                    options = new BitmapFactory.Options();
                                }
                                options.inPreferredConfig = TbConfig.BitmapConfig;
                                options.inJustDecodeBounds = false;
                                FileInputStream fileInputStream2 = new FileInputStream(file);
                                try {
                                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                                    m.e(fileInputStream2);
                                    return decodeStream;
                                } catch (Throwable th) {
                                    fileInputStream = fileInputStream2;
                                    th = th;
                                    while (true) {
                                        try {
                                            try {
                                                break;
                                            } catch (Throwable unused) {
                                                m.e(fileInputStream);
                                                return null;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            m.e(null);
                            return null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                }
                m.e(null);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static Bitmap resizeBitmap(String str, int i2) {
        return resizeBitmap(subSampleBitmap(str, i2), i2);
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i2, int i3, boolean z) {
        Bitmap createBitmap;
        if (i2 <= 0 || i3 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (z) {
            if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
                return bitmap;
            }
        } else if (bitmap.getWidth() <= i2 && bitmap.getHeight() <= i3) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        float f2 = i3;
        float height = bitmap.getHeight();
        float f3 = f2 / height;
        float f4 = i2;
        float f5 = width;
        float f6 = f4 / f5;
        if (f3 < f6) {
            f3 = f6;
        }
        synchronized (lockForSyncImageDecoder) {
            Matrix matrix = new Matrix();
            matrix.postScale(f3, f3);
            matrix.postTranslate((f4 - (f5 * f3)) / 2.0f, (f2 - (height * f3)) / 2.0f);
            createBitmap = Bitmap.createBitmap(i2, i3, bitmap.getConfig());
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
        }
        return createBitmap;
    }

    public static Bitmap resizeBitmap(Context context, Uri uri, int i2) {
        return resizeBitmap(subSampleBitmap(context, uri, i2), i2);
    }

    public static Bitmap subSampleBitmap(Context context, Uri uri, int i2) {
        ParcelFileDescriptor parcelFileDescriptor;
        Bitmap decodeFileDescriptor;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, r.f7715a);
        } catch (Throwable unused) {
            parcelFileDescriptor = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            options.inDither = false;
            int i3 = 1;
            options.inJustDecodeBounds = true;
            synchronized (lockForSyncImageDecoder) {
                BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                while (true) {
                    int i4 = i3 + 1;
                    if (options.outWidth / i4 <= i2 && options.outHeight / i4 <= i2) {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i3;
                        decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                    }
                    i3 = i4;
                }
            }
            return decodeFileDescriptor;
        } catch (Throwable unused2) {
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (Throwable unused3) {
                }
            }
            return null;
        }
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i2) {
        return getResizedBitmap(bitmap, i2, i2);
    }
}
