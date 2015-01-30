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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class d {
    public static final Object vy = new Object();
    private static volatile SparseArray<SoftReference<Bitmap>> mG = new SparseArray<>();
    private static volatile SparseArray<SoftReference<Bitmap>> Hh = new SparseArray<>();

    public static synchronized Bitmap bN(int i) {
        Bitmap bitmap;
        synchronized (d.class) {
            SoftReference<Bitmap> softReference = mG.get(i);
            bitmap = softReference != null ? softReference.get() : null;
            if (bitmap == null && (bitmap = b(TbadkCoreApplication.m255getInst().getApp(), i)) != null) {
                mG.put(i, new SoftReference<>(bitmap));
            }
        }
        return bitmap;
    }

    public static synchronized Bitmap a(Resources resources, int i, int i2) {
        Bitmap bitmap;
        synchronized (d.class) {
            SoftReference<Bitmap> softReference = Hh.get(i2);
            bitmap = softReference != null ? softReference.get() : null;
            if (bitmap == null) {
                try {
                    bitmap = BitmapFactory.decodeResource(resources, i, new BitmapFactory.Options());
                } catch (OutOfMemoryError e) {
                    TbadkCoreApplication.m255getInst().onAppMemoryLow();
                }
                if (bitmap != null) {
                    Hh.put(i2, new SoftReference<>(bitmap));
                }
            }
        }
        return bitmap;
    }

    public static synchronized void bO(int i) {
        synchronized (d.class) {
            mG.remove(i);
            Hh.remove(i);
        }
    }

    public static synchronized void eS() {
        synchronized (d.class) {
            mG.clear();
            Hh.clear();
        }
    }

    public static int d(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static Bitmap f(Context context, int i) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeResource(context.getResources(), i, options);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    public static Bitmap b(Context context, int i) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, new BitmapFactory.Options());
        } catch (OutOfMemoryError e) {
            TbadkCoreApplication.m255getInst().onAppMemoryLow();
            return null;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, boolean z) {
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
            synchronized (vy) {
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

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        float f;
        Bitmap createBitmap;
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
            synchronized (vy) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                matrix.postTranslate((i - (width * f)) / 2.0f, (i2 - (height * f)) / 2.0f);
                createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
                new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap d(Bitmap bitmap, int i) {
        return a(bitmap, i, i, true);
    }

    public static Bitmap f(Bitmap bitmap, int i) {
        return a(bitmap, i, i);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static android.graphics.Bitmap b(java.lang.String r8, int r9, int r10) {
        /*
            r1 = 1
            r0 = 0
            if (r8 == 0) goto Le
            int r2 = r8.length()
            if (r2 <= 0) goto Le
            if (r9 <= 0) goto Le
            if (r10 > 0) goto Lf
        Le:
            return r0
        Lf:
            java.io.File r4 = new java.io.File
            r4.<init>(r8)
            boolean r2 = r4.exists()
            if (r2 == 0) goto Le
            java.lang.Object r5 = com.baidu.tbadk.core.util.d.vy     // Catch: java.lang.Throwable -> L6d
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L6d
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L5b
            r6.<init>()     // Catch: java.lang.Throwable -> L5b
            r2 = 1
            r6.inJustDecodeBounds = r2     // Catch: java.lang.Throwable -> L5b
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5b
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5b
            r2 = 0
            android.graphics.BitmapFactory.decodeStream(r3, r2, r6)     // Catch: java.lang.Throwable -> L70
            android.graphics.Bitmap$Config r2 = com.baidu.tbadk.TbConfig.BitmapConfig     // Catch: java.lang.Throwable -> L70
            r6.inPreferredConfig = r2     // Catch: java.lang.Throwable -> L70
            com.baidu.adp.lib.util.t.d(r3)     // Catch: java.lang.Throwable -> L70
        L35:
            int r2 = r6.outWidth     // Catch: java.lang.Throwable -> L70
            int r7 = r1 * 2
            int r2 = r2 / r7
            if (r2 > r9) goto L58
            int r2 = r6.outHeight     // Catch: java.lang.Throwable -> L70
            int r7 = r1 * 2
            int r2 = r2 / r7
            if (r2 > r10) goto L58
            r2 = 0
            r6.inJustDecodeBounds = r2     // Catch: java.lang.Throwable -> L70
            r6.inSampleSize = r1     // Catch: java.lang.Throwable -> L70
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L70
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L70
            r1 = 0
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r2, r1, r6)     // Catch: java.lang.Throwable -> L73
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L73
            com.baidu.adp.lib.util.t.d(r2)
            r0 = r1
            goto Le
        L58:
            int r1 = r1 * 2
            goto L35
        L5b:
            r1 = move-exception
            r2 = r0
        L5d:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L73
            throw r1     // Catch: java.lang.Throwable -> L5f
        L5f:
            r1 = move-exception
        L60:
            com.baidu.adp.lib.util.t.d(r2)
            goto Le
        L64:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L67:
            com.baidu.adp.lib.util.t.d(r2)
            throw r0
        L6b:
            r0 = move-exception
            goto L67
        L6d:
            r1 = move-exception
            r2 = r0
            goto L60
        L70:
            r1 = move-exception
            r2 = r3
            goto L5d
        L73:
            r1 = move-exception
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.d.b(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static android.graphics.Bitmap ca(java.lang.String r5) {
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
            java.lang.Object r3 = com.baidu.tbadk.core.util.d.vy     // Catch: java.lang.Throwable -> L46
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
            com.baidu.adp.lib.util.t.d(r2)
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
            com.baidu.adp.lib.util.t.d(r2)
            goto L9
        L3d:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L40:
            com.baidu.adp.lib.util.t.d(r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.d.ca(java.lang.String):android.graphics.Bitmap");
    }

    public static Bitmap m(String str, int i) {
        Bitmap decodeStream;
        int i2 = 1;
        if (str == null || str.length() <= 0 || i <= 0) {
            return null;
        }
        try {
            synchronized (vy) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream cl = s.cl(str);
                BitmapFactory.decodeStream(cl, null, options);
                options.inPreferredConfig = TbConfig.BitmapConfig;
                com.baidu.adp.lib.util.t.d(cl);
                while (true) {
                    if (options.outWidth / (i2 * 2) > i || options.outHeight / (i2 * 2) > i) {
                        i2 *= 2;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        InputStream cl2 = s.cl(str);
                        decodeStream = BitmapFactory.decodeStream(cl2, null, options);
                        com.baidu.adp.lib.util.t.d(cl2);
                    }
                }
            }
            return decodeStream;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Bitmap a(Context context, Uri uri, int i) {
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
            synchronized (vy) {
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
    public static Bitmap a(Bitmap bitmap, float f, boolean z) {
        Bitmap bitmap2 = null;
        try {
            synchronized (vy) {
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

    public static Bitmap e(Bitmap bitmap) {
        Bitmap createBitmap;
        if (bitmap == null) {
            return null;
        }
        synchronized (vy) {
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

    public static byte[] e(Bitmap bitmap, int i) {
        byte[] byteArray;
        synchronized (vy) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public static Bitmap v(byte[] bArr) {
        return a(bArr, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [588=5, 589=5, 590=5, 564=4] */
    public static Bitmap a(byte[] bArr, StringBuilder sb) {
        boolean z;
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        if (bArr != null && bArr.length != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            try {
                try {
                    synchronized (vy) {
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
                                            TbadkCoreApplication.m255getInst().onAppMemoryLow();
                                            if (e != null && sb != null) {
                                                sb.append(String.valueOf(e.getClass().getName()) + " " + e.getMessage());
                                            }
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            return bitmap2;
                                        } catch (Error e2) {
                                            bitmap2 = bitmap;
                                            r2 = z;
                                            e = e2;
                                            if (e != null && sb != null) {
                                                sb.append(String.valueOf(e.getClass().getName()) + " " + e.getMessage());
                                            }
                                            if (sb != null && sb.length() == 0 && r2) {
                                                sb.append("UnKnow Error");
                                            }
                                            return bitmap2;
                                        } catch (Exception e3) {
                                            bitmap2 = bitmap;
                                            r2 = z;
                                            e = e3;
                                            if (e != null && sb != null) {
                                                sb.append(String.valueOf(e.getClass().getName()) + " " + e.getMessage());
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
            } catch (Exception e4) {
                e = e4;
            } catch (OutOfMemoryError e5) {
                e = e5;
            } catch (Error e6) {
                e = e6;
            }
        }
        return bitmap2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [641=5, 642=5, 643=5, 608=4, 635=5, 636=5, 637=5, 639=5] */
    public static Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        boolean z;
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (byteArrayInputStream != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            options.inScreenDensity = TbadkCoreApplication.m255getInst().getResources().getDisplayMetrics().densityDpi;
            options.inTargetDensity = options.inScreenDensity;
            options.inDensity = options.inScreenDensity;
            try {
                try {
                    synchronized (vy) {
                        try {
                            bitmap2 = BitmapFactory.decodeStream(byteArrayInputStream, rect, options);
                            r2 = bitmap2 == null;
                        } catch (Throwable th2) {
                            z = true;
                            bitmap = null;
                            th = th2;
                        }
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
                        } catch (Throwable th3) {
                            z = r2;
                            bitmap = bitmap2;
                            th = th3;
                            while (true) {
                                try {
                                    try {
                                        break;
                                    } catch (Error e2) {
                                        bitmap2 = bitmap;
                                        r2 = z;
                                        e = e2;
                                        if (e != null && sb != null) {
                                            sb.append(String.valueOf(e.getClass().getName()) + " " + e.getMessage());
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
                                    } catch (Exception e4) {
                                        bitmap2 = bitmap;
                                        r2 = z;
                                        e = e4;
                                        if (e != null && sb != null) {
                                            sb.append(String.valueOf(e.getClass().getName()) + " " + e.getMessage());
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
                                    } catch (OutOfMemoryError e6) {
                                        bitmap2 = bitmap;
                                        r2 = z;
                                        e = e6;
                                        TbadkCoreApplication.m255getInst().onAppMemoryLow();
                                        e.printStackTrace();
                                        if (e != null && sb != null) {
                                            sb.append(String.valueOf(e.getClass().getName()) + " " + e.getMessage());
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
                                    } catch (Throwable th4) {
                                        th = th4;
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
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (OutOfMemoryError e9) {
                e = e9;
            } catch (Error e10) {
                e = e10;
            } catch (Exception e11) {
                e = e11;
            }
        }
        return bitmap2;
    }

    public static Bitmap g(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (vy) {
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

    public static Bitmap h(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (vy) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
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

    public static int cb(String str) {
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
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap i(Bitmap bitmap, int i) {
        Bitmap createBitmap;
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 2) {
            matrix.setScale(1.0f, -1.0f);
        } else if (i == 3) {
            matrix.setScale(-1.0f, 1.0f);
        }
        synchronized (vy) {
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

    public static int bP(int i) {
        if (i > 15) {
            return com.baidu.tieba.v.icon_grade_yellow;
        }
        if (i > 9) {
            return com.baidu.tieba.v.icon_grade_red;
        }
        if (i > 3) {
            return com.baidu.tieba.v.icon_grade_blue;
        }
        if (i > 0) {
            return com.baidu.tieba.v.icon_grade_green;
        }
        return 0;
    }
}
