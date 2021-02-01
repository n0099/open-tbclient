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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public class BitmapHelper {
    public static final int FILE_2_BITMAP_MUL = 10;
    public static final int ROTATE_LEFT = 0;
    public static final int ROTATE_LEFT_RIGHT = 2;
    public static final int ROTATE_RIGHT = 1;
    public static final int ROTATE_UP_DOWN = 3;
    public static final Object lockForSyncImageDecoder = new Object();
    private static volatile SparseArray<SoftReference<Bitmap>> mBitmapHash = new SparseArray<>();
    private static volatile SparseArray<SoftReference<Bitmap>> mBitmapNightHash = new SparseArray<>();
    private static volatile SparseArray<SoftReference<Bitmap>> mBitmapDarkHash = new SparseArray<>();
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

    public static Bitmap getDarkCashBitmap(Resources resources, int i, int i2, BitmapFactory.Options options) {
        Bitmap bitmap;
        SoftReference<Bitmap> softReference = mBitmapDarkHash.get(i2);
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
                mBitmapDarkHash.put(i2, new SoftReference<>(bitmap));
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
        int i3;
        Bitmap resBitmap = getResBitmap(context, i);
        if (resBitmap != null) {
            int calcNearestSize = calcNearestSize(resBitmap.getWidth());
            i2 = calcNearestSize(resBitmap.getHeight());
            i3 = calcNearestSize;
        } else {
            i2 = 0;
            i3 = 0;
        }
        return getResizedBitmap(resBitmap, i3, i2);
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

    public static com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache(String str, com.baidu.adp.widget.ImageView.a aVar, int i, int i2) {
        return aVar;
    }

    public static com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache(String str, com.baidu.adp.widget.ImageView.a aVar, int i, int i2) {
        return aVar;
    }

    public static Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    public static Bitmap resizeBitmapAtLeast(Bitmap bitmap, int i, int i2) {
        float f;
        Bitmap createBitmap;
        if (i < 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (i != 0 && i2 != 0) {
            if ((i < bitmap.getWidth() || i2 < bitmap.getHeight()) && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (i / width > i2 / height) {
                    f = i / width;
                } else {
                    f = i2 / height;
                }
                if (f < 1.0f) {
                    synchronized (lockForSyncImageDecoder) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(f, f);
                        createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                        if (createBitmap != bitmap) {
                            bitmap.recycle();
                        }
                    }
                    return createBitmap;
                }
                return bitmap;
            }
            return bitmap;
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [676=4] */
    public static android.graphics.Bitmap loadResizedBitmap(java.lang.String r8, int r9, int r10) {
        /*
            r1 = 1
            r0 = 0
            java.lang.Object r4 = com.baidu.tbadk.core.util.BitmapHelper.lockForSyncImageDecoder     // Catch: java.lang.Throwable -> L76
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L76
            if (r8 == 0) goto L11
            int r2 = r8.length()     // Catch: java.lang.Throwable -> L64
            if (r2 <= 0) goto L11
            if (r9 <= 0) goto L11
            if (r10 > 0) goto L16
        L11:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L64
            com.baidu.adp.lib.util.n.close(r0)
        L15:
            return r0
        L16:
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L64
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L64
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> L64
            if (r2 != 0) goto L26
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L64
            com.baidu.adp.lib.util.n.close(r0)
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
            android.graphics.Bitmap$Config r3 = com.baidu.tbadk.TbConfig.BitmapConfig     // Catch: java.lang.Throwable -> L79
            r6.inPreferredConfig = r3     // Catch: java.lang.Throwable -> L79
            com.baidu.adp.lib.util.n.close(r2)     // Catch: java.lang.Throwable -> L79
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
            com.baidu.adp.lib.util.n.close(r3)
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
            com.baidu.adp.lib.util.n.close(r2)
            goto L15
        L6d:
            r1 = move-exception
            r2 = r0
        L6f:
            com.baidu.adp.lib.util.n.close(r2)
            throw r1
        L73:
            r0 = move-exception
            r1 = r0
            goto L6f
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.BitmapHelper.loadResizedBitmap(java.lang.String, int, int):android.graphics.Bitmap");
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
            java.lang.Object r3 = com.baidu.tbadk.core.util.BitmapHelper.lockForSyncImageDecoder     // Catch: java.lang.Throwable -> L46
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L46
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L34
            r4.<init>()     // Catch: java.lang.Throwable -> L34
            android.graphics.Bitmap$Config r2 = com.baidu.tbadk.TbConfig.BitmapConfig     // Catch: java.lang.Throwable -> L34
            r4.inPreferredConfig = r2     // Catch: java.lang.Throwable -> L34
            r2 = 0
            r4.inJustDecodeBounds = r2     // Catch: java.lang.Throwable -> L34
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L34
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L34
            r1 = 0
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r2, r1, r4)     // Catch: java.lang.Throwable -> L49
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L49
            com.baidu.adp.lib.util.n.close(r2)
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
            com.baidu.adp.lib.util.n.close(r2)
            goto L9
        L3d:
            r1 = move-exception
            r2 = r0
        L3f:
            com.baidu.adp.lib.util.n.close(r2)
            throw r1
        L43:
            r0 = move-exception
            r1 = r0
            goto L3f
        L46:
            r1 = move-exception
            r2 = r0
            goto L39
        L49:
            r1 = move-exception
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.BitmapHelper.loadBitmap(java.lang.String):android.graphics.Bitmap");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [739=4] */
    public static android.graphics.Bitmap loadBitmap(java.lang.String r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r1 = 0
            java.lang.Object r3 = com.baidu.tbadk.core.util.BitmapHelper.lockForSyncImageDecoder     // Catch: java.lang.Throwable -> L58
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto Lc
            int r0 = r4.length()     // Catch: java.lang.Throwable -> L46
            if (r0 > 0) goto L12
        Lc:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L46
            com.baidu.adp.lib.util.n.close(r1)
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
            com.baidu.adp.lib.util.n.close(r1)
            r0 = r1
            goto L11
        L29:
            if (r5 != 0) goto L30
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L46
            r5.<init>()     // Catch: java.lang.Throwable -> L46
        L30:
            android.graphics.Bitmap$Config r2 = com.baidu.tbadk.TbConfig.BitmapConfig     // Catch: java.lang.Throwable -> L46
            r5.inPreferredConfig = r2     // Catch: java.lang.Throwable -> L46
            r2 = 0
            r5.inJustDecodeBounds = r2     // Catch: java.lang.Throwable -> L46
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L46
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L46
            r0 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r2, r0, r5)     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5b
            com.baidu.adp.lib.util.n.close(r2)
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
            com.baidu.adp.lib.util.n.close(r2)
            r0 = r1
            goto L11
        L50:
            r0 = move-exception
        L51:
            com.baidu.adp.lib.util.n.close(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.BitmapHelper.loadBitmap(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
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
                InputStream GetStreamFromFile = o.GetStreamFromFile(str);
                BitmapFactory.decodeStream(GetStreamFromFile, null, options);
                options.inPreferredConfig = TbConfig.BitmapConfig;
                com.baidu.adp.lib.util.n.close(GetStreamFromFile);
                while (true) {
                    if (options.outWidth / (i2 * 2) > i || options.outHeight / (i2 * 2) > i) {
                        i2 *= 2;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        InputStream GetStreamFromFile2 = o.GetStreamFromFile(str);
                        decodeStream = BitmapFactory.decodeStream(GetStreamFromFile2, null, options);
                        com.baidu.adp.lib.util.n.close(GetStreamFromFile2);
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
                InputStream GetStreamFromFile = o.GetStreamFromFile(new File(str));
                BitmapFactory.decodeStream(GetStreamFromFile, null, options);
                options.inPreferredConfig = TbConfig.BitmapConfig;
                com.baidu.adp.lib.util.n.close(GetStreamFromFile);
                while (true) {
                    if (options.outWidth / (i2 * 2) > i || options.outHeight / (i2 * 2) > i) {
                        i2 *= 2;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        InputStream GetStreamFromFile2 = o.GetStreamFromFile(new File(str));
                        decodeStream = BitmapFactory.decodeStream(GetStreamFromFile2, null, options);
                        com.baidu.adp.lib.util.n.close(GetStreamFromFile2);
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
        r10.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0052, code lost:
        if (r0 == r10) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0054, code lost:
        if (r12 == false) goto L20;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005b -> B:14:0x005c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f, boolean z) {
        Throwable th;
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
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap2 = createBitmap;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            try {
                throw th;
            } catch (Throwable th4) {
                return bitmap2;
            }
        } catch (Throwable th5) {
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
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        if (bArr != null && bArr.length != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            try {
                synchronized (lockForSyncImageDecoder) {
                    try {
                        bitmap2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        try {
                        } catch (Throwable th) {
                            th = th;
                            bitmap = bitmap2;
                            while (true) {
                                try {
                                    try {
                                        break;
                                    } catch (OutOfMemoryError e) {
                                        bitmap2 = bitmap;
                                        TbadkCoreApplication.getInst().onAppMemoryLow();
                                        return bitmap2;
                                    } catch (Error e2) {
                                        e = e2;
                                        bitmap2 = bitmap;
                                        e.printStackTrace();
                                        return bitmap2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bitmap2 = bitmap;
                                        th.printStackTrace();
                                        return bitmap2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bitmap = null;
                    }
                }
            } catch (OutOfMemoryError e3) {
            } catch (Error e4) {
                e = e4;
            } catch (Throwable th5) {
                th = th5;
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1002=5, 1003=5, 1004=5] */
    public static Bitmap Bytes2NineBitmap(byte[] bArr, Rect rect) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inScreenDensity = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().densityDpi;
        options.inTargetDensity = options.inScreenDensity;
        options.inDensity = options.inScreenDensity;
        try {
            try {
            } finally {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    BdLog.d(e.getMessage());
                }
            }
        } catch (Error e2) {
            e = e2;
            bitmap = null;
        } catch (Exception e3) {
            e = e3;
            bitmap = null;
        } catch (OutOfMemoryError e4) {
            e = e4;
            bitmap = null;
        }
        synchronized (lockForSyncImageDecoder) {
            try {
                bitmap = BitmapFactory.decodeStream(byteArrayInputStream, rect, options);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                bitmap2 = bitmap;
                try {
                    throw th;
                } catch (OutOfMemoryError e5) {
                    e = e5;
                    bitmap = bitmap2;
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    e.printStackTrace();
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e6) {
                        BdLog.d(e6.getMessage());
                    }
                    return bitmap;
                } catch (Error e7) {
                    e = e7;
                    bitmap = bitmap2;
                    e.printStackTrace();
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e8) {
                        BdLog.d(e8.getMessage());
                    }
                    return bitmap;
                } catch (Exception e9) {
                    e = e9;
                    bitmap = bitmap2;
                    e.printStackTrace();
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e10) {
                        BdLog.d(e10.getMessage());
                    }
                    return bitmap;
                }
            }
        }
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
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
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
                i22 += iArr8[0] * abs;
                i21 += iArr8[1] * abs;
                i20 += abs * iArr8[2];
                if (i23 > 0) {
                    i16 += iArr8[0];
                    i15 += iArr8[1];
                    i14 += iArr8[2];
                } else {
                    i19 += iArr8[0];
                    i18 += iArr8[1];
                    i17 += iArr8[2];
                }
            }
            int i25 = i;
            for (int i26 = 0; i26 < width; i26++) {
                iArr2[i12] = iArr6[i22];
                iArr3[i12] = iArr6[i21];
                iArr4[i12] = iArr6[i20];
                int i27 = i22 - i19;
                int i28 = i21 - i18;
                int i29 = i20 - i17;
                int[] iArr9 = iArr7[((i25 - i) + i5) % i5];
                int i30 = i19 - iArr9[0];
                int i31 = i18 - iArr9[1];
                int i32 = i17 - iArr9[2];
                if (i13 == 0) {
                    iArr5[i26] = Math.min(i26 + i + 1, i2);
                }
                int i33 = iArr[iArr5[i26] + i11];
                iArr9[0] = (16711680 & i33) >> 16;
                iArr9[1] = (65280 & i33) >> 8;
                iArr9[2] = i33 & 255;
                int i34 = i16 + iArr9[0];
                int i35 = i15 + iArr9[1];
                int i36 = i14 + iArr9[2];
                i22 = i27 + i34;
                i21 = i28 + i35;
                i20 = i29 + i36;
                i25 = (i25 + 1) % i5;
                int[] iArr10 = iArr7[i25 % i5];
                i19 = i30 + iArr10[0];
                i18 = i31 + iArr10[1];
                i17 = i32 + iArr10[2];
                i16 = i34 - iArr10[0];
                i15 = i35 - iArr10[1];
                i14 = i36 - iArr10[2];
                i12++;
            }
            i10 = i13 + 1;
            i11 += width;
        }
        for (int i37 = 0; i37 < width; i37++) {
            int i38 = (-i) * width;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            for (int i48 = -i; i48 <= i; i48++) {
                int max = Math.max(0, i38) + i37;
                int[] iArr11 = iArr7[i48 + i];
                iArr11[0] = iArr2[max];
                iArr11[1] = iArr3[max];
                iArr11[2] = iArr4[max];
                int abs2 = i9 - Math.abs(i48);
                i47 += iArr2[max] * abs2;
                i46 += iArr3[max] * abs2;
                i45 += iArr4[max] * abs2;
                if (i48 > 0) {
                    i41 += iArr11[0];
                    i40 += iArr11[1];
                    i39 += iArr11[2];
                } else {
                    i44 += iArr11[0];
                    i43 += iArr11[1];
                    i42 += iArr11[2];
                }
                if (i48 < i3) {
                    i38 += width;
                }
            }
            int i49 = 0;
            int i50 = i39;
            int i51 = i;
            int i52 = i37;
            while (i49 < height) {
                iArr[i52] = ((-16777216) & iArr[i52]) | (iArr6[i47] << 16) | (iArr6[i46] << 8) | iArr6[i45];
                int i53 = i47 - i44;
                int i54 = i46 - i43;
                int i55 = i45 - i42;
                int[] iArr12 = iArr7[((i51 - i) + i5) % i5];
                int i56 = i44 - iArr12[0];
                int i57 = i43 - iArr12[1];
                int i58 = i42 - iArr12[2];
                if (i37 == 0) {
                    iArr5[i49] = Math.min(i49 + i9, i3) * width;
                }
                int i59 = iArr5[i49] + i37;
                iArr12[0] = iArr2[i59];
                iArr12[1] = iArr3[i59];
                iArr12[2] = iArr4[i59];
                int i60 = i41 + iArr12[0];
                int i61 = i40 + iArr12[1];
                int i62 = i50 + iArr12[2];
                i47 = i53 + i60;
                i46 = i54 + i61;
                i45 = i55 + i62;
                i51 = (i51 + 1) % i5;
                int[] iArr13 = iArr7[i51];
                i44 = i56 + iArr13[0];
                i43 = i57 + iArr13[1];
                i42 = i58 + iArr13[2];
                i41 = i60 - iArr13[0];
                int i63 = i61 - iArr13[1];
                i50 = i62 - iArr13[2];
                i52 += width;
                i49++;
                i40 = i63;
            }
        }
        copy.setPixels(iArr, 0, width, 0, 0, width, height);
        return copy;
    }
}
