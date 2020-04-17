package com.baidu.live.tbadk.core.util;

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
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.CloseUtil;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
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
    private static volatile SparseArray<SoftReference<Bitmap>> mBitmapHash = new SparseArray<>();
    private static volatile SparseArray<SoftReference<Bitmap>> mBitmapNightHash = new SparseArray<>();
    private static volatile SparseArray<SoftReference<Bitmap>> mBitmapThemeHash = new SparseArray<>();

    public static Bitmap getCashBitmap(int i, BitmapFactory.Options options) {
        Bitmap bitmap;
        SoftReference<Bitmap> softReference = mBitmapHash.get(i);
        if (softReference == null) {
            bitmap = null;
        } else {
            bitmap = softReference.get();
        }
        if (bitmap == null && (bitmap = getResBitmap(TbadkCoreApplication.getInst().getApp(), i, options)) != null) {
            mBitmapHash.put(i, new SoftReference<>(bitmap));
        }
        return bitmap;
    }

    public static Bitmap getCashBitmap(int i) {
        return getCashBitmap(i, new BitmapFactory.Options());
    }

    public static Bitmap getNightCashBitmap(Resources resources, int i, int i2, BitmapFactory.Options options) {
        Bitmap bitmap;
        SoftReference<Bitmap> softReference = mBitmapNightHash.get(i2);
        if (softReference == null) {
            bitmap = null;
        } else {
            bitmap = softReference.get();
        }
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeResource(resources, i, options);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            }
            if (bitmap != null) {
                mBitmapNightHash.put(i2, new SoftReference<>(bitmap));
            }
        }
        return bitmap;
    }

    public static Bitmap getNightCashBitmap(Resources resources, int i, int i2) {
        return getNightCashBitmap(resources, i, i2, new BitmapFactory.Options());
    }

    public static Bitmap getThemeCashBitmap(Resources resources, int i, int i2, BitmapFactory.Options options) {
        Bitmap bitmap;
        SoftReference<Bitmap> softReference = mBitmapThemeHash.get(i2);
        if (softReference == null) {
            bitmap = null;
        } else {
            bitmap = softReference.get();
        }
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeResource(resources, i, options);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            }
            if (bitmap != null) {
                mBitmapThemeHash.put(i2, new SoftReference<>(bitmap));
            }
        }
        return bitmap;
    }

    public static Bitmap getThemeCashBitmap(Resources resources, int i, int i2) {
        return getThemeCashBitmap(resources, i, i2, new BitmapFactory.Options());
    }

    public static void removeCashBitmap(int i) {
        mBitmapHash.remove(i);
        mBitmapNightHash.remove(i);
        mBitmapThemeHash.remove(i);
    }

    public static void clearCashBitmap() {
        mBitmapHash.clear();
        mBitmapNightHash.clear();
        mBitmapThemeHash.clear();
    }

    public static void clearThemeCashBitmap() {
        mBitmapThemeHash.clear();
    }

    public static int getBitmapSize(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static Bitmap getLogoBitmap(Context context, int i) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeResource(context.getResources(), i, options);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    public static Bitmap getResBitmap(Context context, int i, BitmapFactory.Options options) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, options);
        } catch (OutOfMemoryError e) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            return null;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    public static Bitmap getResBitmapPowerOf2Size(Context context, int i) {
        int i2;
        int i3 = 0;
        Bitmap resBitmap = getResBitmap(context, i);
        if (resBitmap != null) {
            i2 = calcNearestSize(resBitmap.getWidth());
            i3 = calcNearestSize(resBitmap.getHeight());
        } else {
            i2 = 0;
        }
        return getResizedBitmap(resBitmap, i2, i3);
    }

    private static int calcNearestSize(int i) {
        int i2 = 1;
        for (int i3 = 1; i3 <= i; i3 *= 2) {
            int i4 = i - i3;
            if (i4 != 0) {
                if (i4 > 0) {
                    i2 = i3;
                }
            } else {
                return i;
            }
        }
        return i2;
    }

    public static Bitmap getResBitmap(Context context, int i) {
        return getResBitmap(context, i, new BitmapFactory.Options());
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        float f;
        Bitmap createBitmap;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if ((bitmap.getWidth() > i || bitmap.getHeight() > i2) && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i2 / height > i / width) {
                f = i / width;
            } else {
                f = i2 / height;
            }
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                if (createBitmap != bitmap && z) {
                    bitmap.recycle();
                }
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        float f;
        Bitmap bitmap2;
        Bitmap bitmap3 = null;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i2 / height < i / width) {
                f = i / width;
            } else {
                f = i2 / height;
            }
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                matrix.postTranslate((i - (width * f)) / 2.0f, (i2 - (height * f)) / 2.0f);
                try {
                    bitmap3 = Bitmap.createBitmap(i, i2, bitmap.getConfig());
                    new Canvas(bitmap3).drawBitmap(bitmap, matrix, null);
                    bitmap2 = bitmap3;
                } catch (NullPointerException e) {
                    bitmap2 = bitmap3;
                } catch (OutOfMemoryError e2) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    bitmap2 = bitmap3;
                }
            }
            return bitmap2;
        }
        return bitmap;
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        float f;
        Bitmap createBitmap;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (z) {
            if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                return bitmap;
            }
        } else if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i2 / height < i / width) {
            f = i / width;
        } else {
            f = i2 / height;
        }
        synchronized (lockForSyncImageDecoder) {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            matrix.postTranslate((i - (width * f)) / 2.0f, (i2 - (height * f)) / 2.0f);
            createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
        }
        return createBitmap;
    }

    public static Bitmap getResizedBitmapFillCenter(Bitmap bitmap, int i, int i2) {
        float f;
        Bitmap createBitmap;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i2 / height > i / width) {
                f = i / width;
            } else {
                f = i2 / height;
            }
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i) {
        return resizeBitmap(bitmap, i, i, true);
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i) {
        return getResizedBitmap(bitmap, i, i);
    }

    public static Bitmap resizeBitmap(String str, int i) {
        return resizeBitmap(subSampleBitmap(str, i), i);
    }

    public static Bitmap resizeBitmapAbsolute(String str, int i) {
        return resizeBitmap(subSampleBitmapAbsolute(str, i), i);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [508=5] */
    public static android.graphics.Bitmap loadResizedBitmap(java.lang.String r8, int r9, int r10) {
        /*
            r1 = 1
            r0 = 0
            java.lang.Object r4 = com.baidu.live.tbadk.core.util.BitmapHelper.lockForSyncImageDecoder     // Catch: java.lang.Throwable -> L76
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L76
            if (r8 == 0) goto L11
            int r2 = r8.length()     // Catch: java.lang.Throwable -> L64
            if (r2 <= 0) goto L11
            if (r9 <= 0) goto L11
            if (r10 > 0) goto L16
        L11:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L64
            com.baidu.live.adp.lib.util.CloseUtil.close(r0)
        L15:
            return r0
        L16:
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L64
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L64
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> L64
            if (r2 != 0) goto L26
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L64
            com.baidu.live.adp.lib.util.CloseUtil.close(r0)
            goto L15
        L26:
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L64
            r6.<init>()     // Catch: java.lang.Throwable -> L64
            r2 = 1
            r6.inJustDecodeBounds = r2     // Catch: java.lang.Throwable -> L64
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L64
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L64
            r3 = 0
            android.graphics.BitmapFactory.decodeStream(r2, r3, r6)     // Catch: java.lang.Throwable -> L79
            android.graphics.Bitmap$Config r3 = com.baidu.live.tbadk.TbConfig.BitmapConfig     // Catch: java.lang.Throwable -> L79
            r6.inPreferredConfig = r3     // Catch: java.lang.Throwable -> L79
            com.baidu.live.adp.lib.util.CloseUtil.close(r2)     // Catch: java.lang.Throwable -> L79
        L3e:
            int r3 = r6.outWidth     // Catch: java.lang.Throwable -> L79
            int r7 = r1 * 2
            int r3 = r3 / r7
            if (r3 > r9) goto L4c
            int r3 = r6.outHeight     // Catch: java.lang.Throwable -> L79
            int r7 = r1 * 2
            int r3 = r3 / r7
            if (r3 <= r10) goto L4f
        L4c:
            int r1 = r1 * 2
            goto L3e
        L4f:
            r3 = 0
            r6.inJustDecodeBounds = r3     // Catch: java.lang.Throwable -> L79
            r6.inSampleSize = r1     // Catch: java.lang.Throwable -> L79
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L79
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L79
            r1 = 0
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r3, r1, r6)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L7b
            com.baidu.live.adp.lib.util.CloseUtil.close(r3)
            r0 = r1
            goto L15
        L64:
            r1 = move-exception
            r2 = r0
        L66:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L79
            throw r1     // Catch: java.lang.Throwable -> L68
        L68:
            r1 = move-exception
        L69:
            com.baidu.live.adp.lib.util.CloseUtil.close(r2)
            goto L15
        L6d:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L70:
            com.baidu.live.adp.lib.util.CloseUtil.close(r2)
            throw r0
        L74:
            r0 = move-exception
            goto L70
        L76:
            r1 = move-exception
            r2 = r0
            goto L69
        L79:
            r1 = move-exception
            goto L66
        L7b:
            r1 = move-exception
            r2 = r3
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.tbadk.core.util.BitmapHelper.loadResizedBitmap(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static android.graphics.Bitmap loadBitmap(java.lang.String r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L9
            int r1 = r5.length()
            if (r1 > 0) goto La
        L9:
            return r0
        La:
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L9
            java.lang.Object r3 = com.baidu.live.tbadk.core.util.BitmapHelper.lockForSyncImageDecoder     // Catch: java.lang.Throwable -> L46
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L46
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L34
            r4.<init>()     // Catch: java.lang.Throwable -> L34
            android.graphics.Bitmap$Config r2 = com.baidu.live.tbadk.TbConfig.BitmapConfig     // Catch: java.lang.Throwable -> L34
            r4.inPreferredConfig = r2     // Catch: java.lang.Throwable -> L34
            r2 = 0
            r4.inJustDecodeBounds = r2     // Catch: java.lang.Throwable -> L34
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L34
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L34
            r1 = 0
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r2, r1, r4)     // Catch: java.lang.Throwable -> L49
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L49
            com.baidu.live.adp.lib.util.CloseUtil.close(r2)
            r0 = r1
            goto L9
        L34:
            r1 = move-exception
            r2 = r0
        L36:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L49
            throw r1     // Catch: java.lang.Throwable -> L38
        L38:
            r1 = move-exception
        L39:
            com.baidu.live.adp.lib.util.CloseUtil.close(r2)
            goto L9
        L3d:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L40:
            com.baidu.live.adp.lib.util.CloseUtil.close(r2)
            throw r0
        L44:
            r0 = move-exception
            goto L40
        L46:
            r1 = move-exception
            r2 = r0
            goto L39
        L49:
            r1 = move-exception
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.tbadk.core.util.BitmapHelper.loadBitmap(java.lang.String):android.graphics.Bitmap");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [571=6] */
    public static android.graphics.Bitmap loadBitmap(java.lang.String r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r1 = 0
            java.lang.Object r3 = com.baidu.live.tbadk.core.util.BitmapHelper.lockForSyncImageDecoder     // Catch: java.lang.Throwable -> L58
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto Lc
            int r0 = r4.length()     // Catch: java.lang.Throwable -> L46
            if (r0 > 0) goto L12
        Lc:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L46
            com.baidu.live.adp.lib.util.CloseUtil.close(r1)
            r0 = r1
        L11:
            return r0
        L12:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L46
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L46
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L23
            boolean r2 = r0.isFile()     // Catch: java.lang.Throwable -> L46
            if (r2 != 0) goto L29
        L23:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L46
            com.baidu.live.adp.lib.util.CloseUtil.close(r1)
            r0 = r1
            goto L11
        L29:
            if (r5 != 0) goto L30
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L46
            r5.<init>()     // Catch: java.lang.Throwable -> L46
        L30:
            android.graphics.Bitmap$Config r2 = com.baidu.live.tbadk.TbConfig.BitmapConfig     // Catch: java.lang.Throwable -> L46
            r5.inPreferredConfig = r2     // Catch: java.lang.Throwable -> L46
            r2 = 0
            r5.inJustDecodeBounds = r2     // Catch: java.lang.Throwable -> L46
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L46
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L46
            r0 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r2, r0, r5)     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5b
            com.baidu.live.adp.lib.util.CloseUtil.close(r2)
            goto L11
        L46:
            r0 = move-exception
            r2 = r1
        L48:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5b
            throw r0     // Catch: java.lang.Throwable -> L4a
        L4a:
            r0 = move-exception
        L4b:
            com.baidu.live.adp.lib.util.CloseUtil.close(r2)
            r0 = r1
            goto L11
        L50:
            r0 = move-exception
        L51:
            com.baidu.live.adp.lib.util.CloseUtil.close(r1)
            throw r0
        L55:
            r0 = move-exception
            r1 = r2
            goto L51
        L58:
            r0 = move-exception
            r2 = r1
            goto L4b
        L5b:
            r0 = move-exception
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.tbadk.core.util.BitmapHelper.loadBitmap(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static Bitmap subSampleBitmap(String str, int i) {
        Bitmap decodeStream;
        int i2 = 1;
        if (str == null || str.length() <= 0 || i <= 0) {
            return null;
        }
        try {
            synchronized (lockForSyncImageDecoder) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream GetStreamFromFile = FileHelper.GetStreamFromFile(str);
                BitmapFactory.decodeStream(GetStreamFromFile, null, options);
                options.inPreferredConfig = TbConfig.BitmapConfig;
                CloseUtil.close(GetStreamFromFile);
                while (true) {
                    if (options.outWidth / (i2 * 2) > i || options.outHeight / (i2 * 2) > i) {
                        i2 *= 2;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        InputStream GetStreamFromFile2 = FileHelper.GetStreamFromFile(str);
                        decodeStream = BitmapFactory.decodeStream(GetStreamFromFile2, null, options);
                        CloseUtil.close(GetStreamFromFile2);
                    }
                }
            }
            return decodeStream;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Bitmap subSampleBitmapAbsolute(String str, int i) {
        Bitmap decodeStream;
        int i2 = 1;
        if (str == null || str.length() <= 0 || i <= 0) {
            return null;
        }
        try {
            synchronized (lockForSyncImageDecoder) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream GetStreamFromFile = FileHelper.GetStreamFromFile(new File(str));
                BitmapFactory.decodeStream(GetStreamFromFile, null, options);
                options.inPreferredConfig = TbConfig.BitmapConfig;
                CloseUtil.close(GetStreamFromFile);
                while (true) {
                    if (options.outWidth / (i2 * 2) > i || options.outHeight / (i2 * 2) > i) {
                        i2 *= 2;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        InputStream GetStreamFromFile2 = FileHelper.GetStreamFromFile(new File(str));
                        decodeStream = BitmapFactory.decodeStream(GetStreamFromFile2, null, options);
                        CloseUtil.close(GetStreamFromFile2);
                    }
                }
            }
            return decodeStream;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Bitmap resizeBitmap(Context context, Uri uri, int i) {
        return resizeBitmap(subSampleBitmap(context, uri, i), i);
    }

    public static Bitmap subSampleBitmap(Context context, Uri uri, int i) {
        ParcelFileDescriptor parcelFileDescriptor;
        ParcelFileDescriptor openFileDescriptor;
        Bitmap decodeFileDescriptor;
        int i2 = 1;
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        } catch (Throwable th) {
            parcelFileDescriptor = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            options.inDither = false;
            options.inJustDecodeBounds = true;
            synchronized (lockForSyncImageDecoder) {
                BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                while (true) {
                    if (options.outWidth / (i2 + 1) > i || options.outHeight / (i2 + 1) > i) {
                        i2++;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                    }
                }
            }
            return decodeFileDescriptor;
        } catch (Throwable th2) {
            parcelFileDescriptor = openFileDescriptor;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (Throwable th3) {
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
        r11.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0052, code lost:
        if (r0 == r11) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0054, code lost:
        if (r13 == false) goto L20;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005a -> B:13:0x005b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f, boolean z) {
        Bitmap bitmap2 = null;
        try {
            synchronized (lockForSyncImageDecoder) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                    try {
                        Canvas canvas = new Canvas(createBitmap);
                        Paint paint = new Paint();
                        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        RectF rectF = new RectF(rect);
                        paint.setAntiAlias(true);
                        canvas.drawARGB(0, 0, 0, 0);
                        paint.setColor(-12434878);
                        canvas.drawRoundRect(rectF, f, f, paint);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                        canvas.drawBitmap(bitmap, rect, rect, paint);
                    } catch (Throwable th) {
                        bitmap2 = createBitmap;
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            try {
                throw th;
            } catch (Throwable th3) {
                return bitmap2;
            }
        } catch (Throwable th4) {
            return null;
        }
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

    public static byte[] Bitmap2Bytes(Bitmap bitmap, int i) {
        byte[] byteArray;
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public static Bitmap Bytes2Bitmap(byte[] bArr) {
        return Bytes2Bitmap(bArr, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [814=6, 816=5] */
    public static Bitmap Bytes2Bitmap(byte[] bArr, StringBuilder sb) {
        boolean z;
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        if (bArr != null && bArr.length != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            try {
                try {
                    synchronized (lockForSyncImageDecoder) {
                        try {
                            bitmap2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                            r2 = bitmap2 == null;
                            try {
                                if (sb != null && sb.length() == 0 && r2) {
                                    sb.append("UnKnow Error");
                                }
                            } catch (Throwable th2) {
                                z = r2;
                                bitmap = bitmap2;
                                th = th2;
                                while (true) {
                                    try {
                                        try {
                                            break;
                                        } catch (OutOfMemoryError e) {
                                            bitmap2 = bitmap;
                                            r2 = z;
                                            e = e;
                                            TbadkCoreApplication.getInst().onAppMemoryLow();
                                            if (sb != null) {
                                                sb.append("OOM ");
                                                if (e != null) {
                                                    sb.append(e.getClass().getName() + " " + e.getMessage());
                                                }
                                            }
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            return bitmap2;
                                        } catch (Error e2) {
                                            bitmap2 = bitmap;
                                            r2 = z;
                                            e = e2;
                                            if (sb != null) {
                                                sb.append("Error ");
                                                if (e != null) {
                                                    sb.append(e.getClass().getName() + " " + e.getMessage());
                                                }
                                            }
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            return bitmap2;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            r2 = z;
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            z = true;
                            bitmap = null;
                            th = th5;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (OutOfMemoryError e3) {
                e = e3;
            } catch (Error e4) {
                e = e4;
            } catch (Throwable th7) {
                th = th7;
            }
        }
        return bitmap2;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        Bitmap bitmap;
        if (bArr != null) {
            try {
                if (bArr.length != 0 && i > 0 && i2 > 0) {
                    synchronized (lockForSyncImageDecoder) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = TbConfig.BitmapConfig;
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
                            bitmap = null;
                        } else {
                            options.inSampleSize = Math.min(options.outWidth / i, options.outHeight / i2);
                            options.inJustDecodeBounds = false;
                            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        }
                    }
                    return bitmap;
                }
            } catch (Throwable th) {
                return null;
            }
        }
        bitmap = null;
        return bitmap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [884=6, 886=5, 888=5, 890=5, 891=5, 892=5] */
    public static Bitmap Bytes2NineBitmap(byte[] bArr, Rect rect, StringBuilder sb) {
        boolean z;
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (byteArrayInputStream != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            options.inScreenDensity = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().densityDpi;
            options.inTargetDensity = options.inScreenDensity;
            options.inDensity = options.inScreenDensity;
            try {
                try {
                    synchronized (lockForSyncImageDecoder) {
                        try {
                            bitmap2 = BitmapFactory.decodeStream(byteArrayInputStream, rect, options);
                            r2 = bitmap2 == null;
                            try {
                                if (sb != null && sb.length() == 0 && r2) {
                                    sb.append("UnKnow Error");
                                }
                                if (byteArrayInputStream != null) {
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException e) {
                                        BdLog.d(e.getMessage());
                                    }
                                }
                            } catch (Throwable th2) {
                                z = r2;
                                bitmap = bitmap2;
                                th = th2;
                                while (true) {
                                    try {
                                        try {
                                            break;
                                        } catch (Exception e2) {
                                            bitmap2 = bitmap;
                                            r2 = z;
                                            e = e2;
                                            if (e != null && sb != null) {
                                                sb.append(e.getClass().getName() + " " + e.getMessage());
                                            }
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            if (byteArrayInputStream != null) {
                                                try {
                                                    byteArrayInputStream.close();
                                                } catch (IOException e3) {
                                                    BdLog.d(e3.getMessage());
                                                }
                                            }
                                            return bitmap2;
                                        } catch (OutOfMemoryError e4) {
                                            bitmap2 = bitmap;
                                            r2 = z;
                                            e = e4;
                                            TbadkCoreApplication.getInst().onAppMemoryLow();
                                            e.printStackTrace();
                                            if (e != null && sb != null) {
                                                sb.append(e.getClass().getName() + " " + e.getMessage());
                                            }
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            if (byteArrayInputStream != null) {
                                                try {
                                                    byteArrayInputStream.close();
                                                } catch (IOException e5) {
                                                    BdLog.d(e5.getMessage());
                                                }
                                            }
                                            return bitmap2;
                                        } catch (Error e6) {
                                            bitmap2 = bitmap;
                                            r2 = z;
                                            e = e6;
                                            if (e != null && sb != null) {
                                                sb.append(e.getClass().getName() + " " + e.getMessage());
                                            }
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            if (byteArrayInputStream != null) {
                                                try {
                                                    byteArrayInputStream.close();
                                                } catch (IOException e7) {
                                                    BdLog.d(e7.getMessage());
                                                }
                                            }
                                            return bitmap2;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            r2 = z;
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            if (byteArrayInputStream != null) {
                                                try {
                                                    byteArrayInputStream.close();
                                                } catch (IOException e8) {
                                                    BdLog.d(e8.getMessage());
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            z = true;
                            bitmap = null;
                            th = th5;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Error e9) {
                e = e9;
            } catch (Exception e10) {
                e = e10;
            } catch (OutOfMemoryError e11) {
                e = e11;
            }
        }
        return bitmap2;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (lockForSyncImageDecoder) {
            Matrix matrix = new Matrix();
            if (i == 0) {
                matrix.postRotate(-90.0f);
            } else if (i == 1) {
                matrix.postRotate(90.0f);
            }
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (OutOfMemoryError e) {
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

    public static Bitmap rotateBitmapBydegree(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (lockForSyncImageDecoder) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Throwable th) {
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

    public static int readPictureDegree(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1)) {
                case 3:
                    return 180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return 270;
            }
        } catch (IOException e) {
            return 0;
        }
    }

    public static Bitmap reversalBitmap(Bitmap bitmap, int i) {
        Bitmap createBitmap;
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 2) {
            matrix.setScale(1.0f, -1.0f);
        } else if (i == 3) {
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

    public static int getGradeResourceIdNew(int i) {
        return getGradeResourceIdInEnterForum(i);
    }

    public static int getSmallGradeResourceIdNew(int i) {
        return getGradeResourceIdInEnterForum(i);
    }

    public static int getGradeResourceIdInEnterForum(int i) {
        switch (i) {
            case 1:
                return a.f.sdk_icon_level_01;
            case 2:
                return a.f.sdk_icon_level_02;
            case 3:
                return a.f.sdk_icon_level_03;
            case 4:
                return a.f.sdk_icon_level_04;
            case 5:
                return a.f.sdk_icon_level_05;
            case 6:
                return a.f.sdk_icon_level_06;
            case 7:
                return a.f.sdk_icon_level_07;
            case 8:
                return a.f.sdk_icon_level_08;
            case 9:
                return a.f.sdk_icon_level_09;
            case 10:
                return a.f.sdk_icon_level_10;
            case 11:
                return a.f.sdk_icon_level_11;
            case 12:
                return a.f.sdk_icon_level_12;
            case 13:
                return a.f.sdk_icon_level_13;
            case 14:
                return a.f.sdk_icon_level_14;
            case 15:
                return a.f.sdk_icon_level_15;
            case 16:
                return a.f.sdk_icon_level_16;
            case 17:
                return a.f.sdk_icon_level_17;
            case 18:
                return a.f.sdk_icon_level_18;
            default:
                return 0;
        }
    }

    public static Bitmap fastblur(Bitmap bitmap, int i, float f) {
        if (i < 1 || bitmap == null || f <= 0.0f) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f), Math.round(bitmap.getHeight() * f), false);
        Bitmap copy = createScaledBitmap.copy(createScaledBitmap.getConfig(), true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        int[] iArr = new int[width * height];
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = width - 1;
        int i3 = height - 1;
        int i4 = width * height;
        int i5 = i + i + 1;
        int[] iArr2 = new int[i4];
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[Math.max(width, height)];
        int i6 = (i5 + 1) >> 1;
        int i7 = i6 * i6;
        int[] iArr6 = new int[i7 * 256];
        for (int i8 = 0; i8 < i7 * 256; i8++) {
            iArr6[i8] = i8 / i7;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, i5, 3);
        int i9 = i + 1;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i10;
            if (i13 >= height) {
                break;
            }
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            for (int i23 = -i; i23 <= i; i23++) {
                int i24 = iArr[Math.min(i2, Math.max(i23, 0)) + i12];
                int[] iArr8 = iArr7[i23 + i];
                iArr8[0] = (16711680 & i24) >> 16;
                iArr8[1] = (65280 & i24) >> 8;
                iArr8[2] = i24 & 255;
                int abs = i9 - Math.abs(i23);
                i21 += iArr8[0] * abs;
                i20 += iArr8[1] * abs;
                i19 += abs * iArr8[2];
                if (i23 > 0) {
                    i15 += iArr8[0];
                    i22 += iArr8[1];
                    i14 += iArr8[2];
                } else {
                    i18 += iArr8[0];
                    i17 += iArr8[1];
                    i16 += iArr8[2];
                }
            }
            int i25 = i21;
            int i26 = i20;
            int i27 = i19;
            int i28 = i12;
            int i29 = i;
            for (int i30 = 0; i30 < width; i30++) {
                iArr2[i28] = iArr6[i25];
                iArr3[i28] = iArr6[i26];
                iArr4[i28] = iArr6[i27];
                int i31 = i25 - i18;
                int i32 = i26 - i17;
                int i33 = i27 - i16;
                int[] iArr9 = iArr7[((i29 - i) + i5) % i5];
                int i34 = i18 - iArr9[0];
                int i35 = i17 - iArr9[1];
                int i36 = i16 - iArr9[2];
                if (i13 == 0) {
                    iArr5[i30] = Math.min(i30 + i + 1, i2);
                }
                int i37 = iArr[iArr5[i30] + i11];
                iArr9[0] = (16711680 & i37) >> 16;
                iArr9[1] = (65280 & i37) >> 8;
                iArr9[2] = i37 & 255;
                int i38 = i15 + iArr9[0];
                int i39 = i22 + iArr9[1];
                int i40 = i14 + iArr9[2];
                i25 = i31 + i38;
                i26 = i32 + i39;
                i27 = i33 + i40;
                i29 = (i29 + 1) % i5;
                int[] iArr10 = iArr7[i29 % i5];
                i18 = i34 + iArr10[0];
                i17 = i35 + iArr10[1];
                i16 = i36 + iArr10[2];
                i15 = i38 - iArr10[0];
                i22 = i39 - iArr10[1];
                i14 = i40 - iArr10[2];
                i28++;
            }
            i10 = i13 + 1;
            i11 += width;
            i12 = i28;
        }
        for (int i41 = 0; i41 < width; i41++) {
            int i42 = 0;
            int i43 = (-i) * width;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = -i;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            while (i48 <= i) {
                int max = Math.max(0, i43) + i41;
                int[] iArr11 = iArr7[i48 + i];
                iArr11[0] = iArr2[max];
                iArr11[1] = iArr3[max];
                iArr11[2] = iArr4[max];
                int abs2 = i9 - Math.abs(i48);
                int i53 = (iArr2[max] * abs2) + i51;
                int i54 = (iArr3[max] * abs2) + i50;
                int i55 = (iArr4[max] * abs2) + i49;
                if (i48 > 0) {
                    i44 += iArr11[0];
                    i52 += iArr11[1];
                    i42 += iArr11[2];
                } else {
                    i47 += iArr11[0];
                    i46 += iArr11[1];
                    i45 += iArr11[2];
                }
                if (i48 < i3) {
                    i43 += width;
                }
                i48++;
                i49 = i55;
                i50 = i54;
                i51 = i53;
            }
            int i56 = i50;
            int i57 = i51;
            int i58 = i49;
            int i59 = i41;
            int i60 = i42;
            int i61 = i52;
            int i62 = i44;
            int i63 = i45;
            int i64 = i46;
            int i65 = i47;
            int i66 = i;
            for (int i67 = 0; i67 < height; i67++) {
                iArr[i59] = ((-16777216) & iArr[i59]) | (iArr6[i57] << 16) | (iArr6[i56] << 8) | iArr6[i58];
                int i68 = i57 - i65;
                int i69 = i56 - i64;
                int i70 = i58 - i63;
                int[] iArr12 = iArr7[((i66 - i) + i5) % i5];
                int i71 = i65 - iArr12[0];
                int i72 = i64 - iArr12[1];
                int i73 = i63 - iArr12[2];
                if (i41 == 0) {
                    iArr5[i67] = Math.min(i67 + i9, i3) * width;
                }
                int i74 = iArr5[i67] + i41;
                iArr12[0] = iArr2[i74];
                iArr12[1] = iArr3[i74];
                iArr12[2] = iArr4[i74];
                int i75 = i62 + iArr12[0];
                int i76 = i61 + iArr12[1];
                int i77 = i60 + iArr12[2];
                i57 = i68 + i75;
                i56 = i69 + i76;
                i58 = i70 + i77;
                i66 = (i66 + 1) % i5;
                int[] iArr13 = iArr7[i66];
                i65 = i71 + iArr13[0];
                i64 = i72 + iArr13[1];
                i63 = i73 + iArr13[2];
                i62 = i75 - iArr13[0];
                i61 = i76 - iArr13[1];
                i60 = i77 - iArr13[2];
                i59 += width;
            }
        }
        copy.setPixels(iArr, 0, width, 0, 0, width, height);
        return copy;
    }
}
