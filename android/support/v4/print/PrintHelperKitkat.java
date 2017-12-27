package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class PrintHelperKitkat {
    int At;
    final Context mContext;
    BitmapFactory.Options Au = null;
    private final Object mLock = new Object();
    int mScaleMode = 2;
    int As = 2;
    protected boolean Av = true;
    protected boolean Aw = true;

    /* loaded from: classes2.dex */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrintHelperKitkat(Context context) {
        this.mContext = context;
    }

    public void setScaleMode(int i) {
        this.mScaleMode = i;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public void setColorMode(int i) {
        this.As = i;
    }

    public void setOrientation(int i) {
        this.At = i;
    }

    public int getOrientation() {
        if (this.At == 0) {
            return 1;
        }
        return this.At;
    }

    public int getColorMode() {
        return this.As;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PrintAttributes.Builder a(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        return minMargins;
    }

    public void a(final String str, final Bitmap bitmap, final OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (bitmap != null) {
            final int i = this.mScaleMode;
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            if (b(bitmap)) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            } else {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new PrintDocumentAdapter() { // from class: android.support.v4.print.PrintHelperKitkat.1
                private PrintAttributes Ax;

                @Override // android.print.PrintDocumentAdapter
                public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                    this.Ax = printAttributes2;
                    layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(str).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ? false : true);
                }

                @Override // android.print.PrintDocumentAdapter
                public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                    PrintHelperKitkat.this.a(this.Ax, i, bitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
                }

                @Override // android.print.PrintDocumentAdapter
                public void onFinish() {
                    if (onPrintFinishCallback != null) {
                        onPrintFinishCallback.onFinish();
                    }
                }
            }, new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.As).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Matrix a(int i, int i2, RectF rectF, int i3) {
        float min;
        Matrix matrix = new Matrix();
        float width = rectF.width() / i;
        if (i3 == 2) {
            min = Math.max(width, rectF.height() / i2);
        } else {
            min = Math.min(width, rectF.height() / i2);
        }
        matrix.postScale(min, min);
        matrix.postTranslate((rectF.width() - (i * min)) / 2.0f, (rectF.height() - (min * i2)) / 2.0f);
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.support.v4.print.PrintHelperKitkat$2] */
    public void a(final PrintAttributes printAttributes, final int i, final Bitmap bitmap, final ParcelFileDescriptor parcelFileDescriptor, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final PrintAttributes build = this.Aw ? printAttributes : a(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        new AsyncTask<Void, Void, Throwable>() { // from class: android.support.v4.print.PrintHelperKitkat.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: b */
            public Throwable doInBackground(Void... voidArr) {
                RectF rectF;
                try {
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, build);
                    Bitmap c = PrintHelperKitkat.this.c(bitmap, build.getColorMode());
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                    if (PrintHelperKitkat.this.Aw) {
                        rectF = new RectF(startPage.getInfo().getContentRect());
                    } else {
                        PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, printAttributes);
                        PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                        rectF = new RectF(startPage2.getInfo().getContentRect());
                        printedPdfDocument2.finishPage(startPage2);
                        printedPdfDocument2.close();
                    }
                    Matrix a = PrintHelperKitkat.this.a(c.getWidth(), c.getHeight(), rectF, i);
                    if (!PrintHelperKitkat.this.Aw) {
                        a.postTranslate(rectF.left, rectF.top);
                        startPage.getCanvas().clipRect(rectF);
                    }
                    startPage.getCanvas().drawBitmap(c, a, null);
                    printedPdfDocument.finishPage(startPage);
                    if (!cancellationSignal.isCanceled()) {
                        printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                        printedPdfDocument.close();
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException e) {
                            }
                        }
                        if (c != bitmap) {
                            c.recycle();
                            return null;
                        }
                        return null;
                    }
                    printedPdfDocument.close();
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (c != bitmap) {
                        c.recycle();
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    return th;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: c */
            public void onPostExecute(Throwable th) {
                if (cancellationSignal.isCanceled()) {
                    writeResultCallback.onWriteCancelled();
                } else if (th == null) {
                    writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    Log.e("PrintHelperKitkat", "Error writing printed content", th);
                    writeResultCallback.onWriteFailed(null);
                }
            }
        }.execute(new Void[0]);
    }

    public void a(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(str, uri, onPrintFinishCallback, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.As);
        if (this.At == 1 || this.At == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.At == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, anonymousClass3, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.print.PrintHelperKitkat$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends PrintDocumentAdapter {
        final /* synthetic */ OnPrintFinishCallback AB;
        AsyncTask<Uri, Boolean, Bitmap> AI;
        final /* synthetic */ Uri AJ;
        private PrintAttributes Ax;
        final /* synthetic */ String Ay;
        final /* synthetic */ int Az;
        Bitmap mBitmap = null;

        AnonymousClass3(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.Ay = str;
            this.AJ = uri;
            this.AB = onPrintFinishCallback;
            this.Az = i;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.support.v4.print.PrintHelperKitkat$3$1] */
        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes printAttributes, final PrintAttributes printAttributes2, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.Ax = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.mBitmap != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.Ay).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ? false : true);
            } else {
                this.AI = new AsyncTask<Uri, Boolean, Bitmap>() { // from class: android.support.v4.print.PrintHelperKitkat.3.1
                    @Override // android.os.AsyncTask
                    protected void onPreExecute() {
                        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: android.support.v4.print.PrintHelperKitkat.3.1.1
                            @Override // android.os.CancellationSignal.OnCancelListener
                            public void onCancel() {
                                AnonymousClass3.this.dE();
                                cancel(false);
                            }
                        });
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public Bitmap doInBackground(Uri... uriArr) {
                        try {
                            return PrintHelperKitkat.this.a(AnonymousClass3.this.AJ, 3500);
                        } catch (FileNotFoundException e) {
                            return null;
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(Bitmap bitmap) {
                        PrintAttributes.MediaSize mediaSize;
                        super.onPostExecute((AnonymousClass1) bitmap);
                        if (bitmap != null && (!PrintHelperKitkat.this.Av || PrintHelperKitkat.this.At == 0)) {
                            synchronized (this) {
                                mediaSize = AnonymousClass3.this.Ax.getMediaSize();
                            }
                            if (mediaSize != null && mediaSize.isPortrait() != PrintHelperKitkat.b(bitmap)) {
                                Matrix matrix = new Matrix();
                                matrix.postRotate(90.0f);
                                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            }
                        }
                        AnonymousClass3.this.mBitmap = bitmap;
                        if (bitmap != null) {
                            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(AnonymousClass3.this.Ay).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ? false : true);
                        } else {
                            layoutResultCallback.onLayoutFailed(null);
                        }
                        AnonymousClass3.this.AI = null;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: d */
                    public void onCancelled(Bitmap bitmap) {
                        layoutResultCallback.onLayoutCancelled();
                        AnonymousClass3.this.AI = null;
                    }
                }.execute(new Uri[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dE() {
            synchronized (PrintHelperKitkat.this.mLock) {
                if (PrintHelperKitkat.this.Au != null) {
                    PrintHelperKitkat.this.Au.requestCancelDecode();
                    PrintHelperKitkat.this.Au = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            dE();
            if (this.AI != null) {
                this.AI.cancel(true);
            }
            if (this.AB != null) {
                this.AB.onFinish();
            }
            if (this.mBitmap != null) {
                this.mBitmap.recycle();
                this.mBitmap = null;
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelperKitkat.this.a(this.Ax, this.Az, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(Uri uri, int i) throws FileNotFoundException {
        BitmapFactory.Options options;
        int i2 = 1;
        Bitmap bitmap = null;
        if (i <= 0 || uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        a(uri, options2);
        int i3 = options2.outWidth;
        int i4 = options2.outHeight;
        if (i3 > 0 && i4 > 0) {
            int max = Math.max(i3, i4);
            while (max > i) {
                max >>>= 1;
                i2 <<= 1;
            }
            if (i2 > 0 && Math.min(i3, i4) / i2 > 0) {
                synchronized (this.mLock) {
                    this.Au = new BitmapFactory.Options();
                    this.Au.inMutable = true;
                    this.Au.inSampleSize = i2;
                    options = this.Au;
                }
                try {
                    bitmap = a(uri, options);
                    synchronized (this.mLock) {
                        this.Au = null;
                    }
                } catch (Throwable th) {
                    synchronized (this.mLock) {
                        this.Au = null;
                        throw th;
                    }
                }
            }
        }
        return bitmap;
    }

    private Bitmap a(Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        InputStream inputStream = null;
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        try {
            inputStream = this.mContext.getContentResolver().openInputStream(uri);
            return BitmapFactory.decodeStream(inputStream, null, options);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.w("PrintHelperKitkat", "close fail ", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap c(Bitmap bitmap, int i) {
        if (i == 1) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return createBitmap;
        }
        return bitmap;
    }
}
