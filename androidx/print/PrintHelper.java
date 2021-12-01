package androidx.print;

import android.annotation.SuppressLint;
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
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class PrintHelper {
    public static /* synthetic */ Interceptable $ic = null;
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final boolean IS_MIN_MARGINS_HANDLING_CORRECT;
    public static final String LOG_TAG = "PrintHelper";
    public static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mColorMode;
    public final Context mContext;
    public BitmapFactory.Options mDecodeOptions;
    public final Object mLock;
    public int mOrientation;
    public int mScaleMode;

    /* loaded from: classes.dex */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @RequiresApi(19)
    /* loaded from: classes.dex */
    public class PrintBitmapAdapter extends PrintDocumentAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PrintAttributes mAttributes;
        public final Bitmap mBitmap;
        public final OnPrintFinishCallback mCallback;
        public final int mFittingMode;
        public final String mJobName;
        public final /* synthetic */ PrintHelper this$0;

        public PrintBitmapAdapter(PrintHelper printHelper, String str, int i2, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {printHelper, str, Integer.valueOf(i2), bitmap, onPrintFinishCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = printHelper;
            this.mJobName = str;
            this.mFittingMode = i2;
            this.mBitmap = bitmap;
            this.mCallback = onPrintFinishCallback;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (onPrintFinishCallback = this.mCallback) == null) {
                return;
            }
            onPrintFinishCallback.onFinish();
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, printAttributes, printAttributes2, cancellationSignal, layoutResultCallback, bundle) == null) {
                this.mAttributes = printAttributes2;
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, pageRangeArr, parcelFileDescriptor, cancellationSignal, writeResultCallback) == null) {
                this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
            }
        }
    }

    @RequiresApi(19)
    /* loaded from: classes.dex */
    public class PrintUriAdapter extends PrintDocumentAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PrintAttributes mAttributes;
        public Bitmap mBitmap;
        public final OnPrintFinishCallback mCallback;
        public final int mFittingMode;
        public final Uri mImageFile;
        public final String mJobName;
        public AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
        public final /* synthetic */ PrintHelper this$0;

        public PrintUriAdapter(PrintHelper printHelper, String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {printHelper, str, uri, onPrintFinishCallback, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = printHelper;
            this.mJobName = str;
            this.mImageFile = uri;
            this.mCallback = onPrintFinishCallback;
            this.mFittingMode = i2;
            this.mBitmap = null;
        }

        public void cancelLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0.mLock) {
                    if (this.this$0.mDecodeOptions != null) {
                        if (Build.VERSION.SDK_INT < 24) {
                            this.this$0.mDecodeOptions.requestCancelDecode();
                        }
                        this.this$0.mDecodeOptions = null;
                    }
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onFinish();
                cancelLoad();
                AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.mLoadBitmap;
                if (asyncTask != null) {
                    asyncTask.cancel(true);
                }
                OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
                if (onPrintFinishCallback != null) {
                    onPrintFinishCallback.onFinish();
                }
                Bitmap bitmap = this.mBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.mBitmap = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, printAttributes, printAttributes2, cancellationSignal, layoutResultCallback, bundle) == null) {
                synchronized (this) {
                    this.mAttributes = printAttributes2;
                }
                if (cancellationSignal.isCanceled()) {
                    layoutResultCallback.onLayoutCancelled();
                } else if (this.mBitmap != null) {
                    layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
                } else {
                    this.mLoadBitmap = new AsyncTask<Uri, Boolean, Bitmap>(this, cancellationSignal, printAttributes2, printAttributes, layoutResultCallback) { // from class: androidx.print.PrintHelper.PrintUriAdapter.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PrintUriAdapter this$1;
                        public final /* synthetic */ CancellationSignal val$cancellationSignal;
                        public final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback val$layoutResultCallback;
                        public final /* synthetic */ PrintAttributes val$newPrintAttributes;
                        public final /* synthetic */ PrintAttributes val$oldPrintAttributes;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cancellationSignal, printAttributes2, printAttributes, layoutResultCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$cancellationSignal = cancellationSignal;
                            this.val$newPrintAttributes = printAttributes2;
                            this.val$oldPrintAttributes = printAttributes;
                            this.val$layoutResultCallback = layoutResultCallback;
                        }

                        @Override // android.os.AsyncTask
                        public void onPreExecute() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                                this.val$cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener(this) { // from class: androidx.print.PrintHelper.PrintUriAdapter.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$2;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$2 = this;
                                    }

                                    @Override // android.os.CancellationSignal.OnCancelListener
                                    public void onCancel() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.this$2.this$1.cancelLoad();
                                            cancel(false);
                                        }
                                    }
                                });
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.os.AsyncTask
                        public Bitmap doInBackground(Uri... uriArr) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, uriArr)) == null) {
                                try {
                                    return this.this$1.this$0.loadConstrainedBitmap(this.this$1.mImageFile);
                                } catch (FileNotFoundException unused) {
                                    return null;
                                }
                            }
                            return (Bitmap) invokeL.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.os.AsyncTask
                        public void onCancelled(Bitmap bitmap) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                                this.val$layoutResultCallback.onLayoutCancelled();
                                this.this$1.mLoadBitmap = null;
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.os.AsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            PrintAttributes.MediaSize mediaSize;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048580, this, bitmap) == null) {
                                super.onPostExecute((AnonymousClass1) bitmap);
                                if (bitmap != null && (!PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION || this.this$1.this$0.mOrientation == 0)) {
                                    synchronized (this) {
                                        mediaSize = this.this$1.mAttributes.getMediaSize();
                                    }
                                    if (mediaSize != null && mediaSize.isPortrait() != PrintHelper.isPortrait(bitmap)) {
                                        Matrix matrix = new Matrix();
                                        matrix.postRotate(90.0f);
                                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                    }
                                }
                                this.this$1.mBitmap = bitmap;
                                if (bitmap != null) {
                                    this.val$layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.this$1.mJobName).setContentType(1).setPageCount(1).build(), true ^ this.val$newPrintAttributes.equals(this.val$oldPrintAttributes));
                                } else {
                                    this.val$layoutResultCallback.onLayoutFailed(null);
                                }
                                this.this$1.mLoadBitmap = null;
                            }
                        }
                    }.execute(new Uri[0]);
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, pageRangeArr, parcelFileDescriptor, cancellationSignal, writeResultCallback) == null) {
                this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-398296260, "Landroidx/print/PrintHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-398296260, "Landroidx/print/PrintHelper;");
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = i2 < 20 || i2 > 23;
        IS_MIN_MARGINS_HANDLING_CORRECT = Build.VERSION.SDK_INT != 23;
    }

    public PrintHelper(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDecodeOptions = null;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = context;
    }

    public static Bitmap convertBitmapForColorMode(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bitmap, i2)) == null) {
            if (i2 != 1) {
                return bitmap;
            }
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
        return (Bitmap) invokeLI.objValue;
    }

    @RequiresApi(19)
    public static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, printAttributes)) == null) {
            PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
            if (printAttributes.getColorMode() != 0) {
                minMargins.setColorMode(printAttributes.getColorMode());
            }
            if (Build.VERSION.SDK_INT >= 23 && printAttributes.getDuplexMode() != 0) {
                minMargins.setDuplexMode(printAttributes.getDuplexMode());
            }
            return minMargins;
        }
        return (PrintAttributes.Builder) invokeL.objValue;
    }

    public static Matrix getMatrix(int i2, int i3, RectF rectF, int i4) {
        InterceptResult invokeCommon;
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), rectF, Integer.valueOf(i4)})) == null) {
            Matrix matrix = new Matrix();
            float f2 = i2;
            float width = rectF.width() / f2;
            if (i4 == 2) {
                min = Math.max(width, rectF.height() / i3);
            } else {
                min = Math.min(width, rectF.height() / i3);
            }
            matrix.postScale(min, min);
            matrix.postTranslate((rectF.width() - (f2 * min)) / 2.0f, (rectF.height() - (i3 * min)) / 2.0f);
            return matrix;
        }
        return (Matrix) invokeCommon.objValue;
    }

    public static boolean isPortrait(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) ? bitmap.getWidth() <= bitmap.getHeight() : invokeL.booleanValue;
    }

    private Bitmap loadBitmap(Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        InterceptResult invokeLL;
        Context context;
        InputStream openInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, uri, options)) == null) {
            if (uri != null && (context = this.mContext) != null) {
                InputStream inputStream = null;
                try {
                    openInputStream = context.getContentResolver().openInputStream(uri);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return decodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = openInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static boolean systemSupportsPrint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.VERSION.SDK_INT >= 19 : invokeV.booleanValue;
    }

    public int getColorMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mColorMode : invokeV.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT < 19 || this.mOrientation != 0) {
                return this.mOrientation;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int getScaleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mScaleMode : invokeV.intValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public Bitmap loadConstrainedBitmap(Uri uri) throws FileNotFoundException {
        InterceptResult invokeL;
        BitmapFactory.Options options;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            if (uri != null && this.mContext != null) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                loadBitmap(uri, options2);
                int i2 = options2.outWidth;
                int i3 = options2.outHeight;
                if (i2 > 0 && i3 > 0) {
                    int max = Math.max(i2, i3);
                    int i4 = 1;
                    while (max > 3500) {
                        max >>>= 1;
                        i4 <<= 1;
                    }
                    if (i4 > 0 && Math.min(i2, i3) / i4 > 0) {
                        synchronized (this.mLock) {
                            options = new BitmapFactory.Options();
                            this.mDecodeOptions = options;
                            options.inMutable = true;
                            options.inSampleSize = i4;
                        }
                        try {
                            Bitmap loadBitmap = loadBitmap(uri, options);
                            synchronized (this.mLock) {
                                this.mDecodeOptions = null;
                            }
                            return loadBitmap;
                        } catch (Throwable th) {
                            synchronized (this.mLock) {
                                this.mDecodeOptions = null;
                                throw th;
                            }
                        }
                    }
                }
                return null;
            }
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        return (Bitmap) invokeL.objValue;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, bitmap) == null) {
            printBitmap(str, bitmap, (OnPrintFinishCallback) null);
        }
    }

    public void setColorMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mColorMode = i2;
        }
    }

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mOrientation = i2;
        }
    }

    public void setScaleMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mScaleMode = i2;
        }
    }

    @RequiresApi(19)
    public void writeBitmap(PrintAttributes printAttributes, int i2, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{printAttributes, Integer.valueOf(i2), bitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback}) == null) {
            new AsyncTask<Void, Void, Throwable>(this, cancellationSignal, IS_MIN_MARGINS_HANDLING_CORRECT ? printAttributes : copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build(), bitmap, printAttributes, i2, parcelFileDescriptor, writeResultCallback) { // from class: androidx.print.PrintHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PrintHelper this$0;
                public final /* synthetic */ PrintAttributes val$attributes;
                public final /* synthetic */ Bitmap val$bitmap;
                public final /* synthetic */ CancellationSignal val$cancellationSignal;
                public final /* synthetic */ ParcelFileDescriptor val$fileDescriptor;
                public final /* synthetic */ int val$fittingMode;
                public final /* synthetic */ PrintAttributes val$pdfAttributes;
                public final /* synthetic */ PrintDocumentAdapter.WriteResultCallback val$writeResultCallback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cancellationSignal, r8, bitmap, printAttributes, Integer.valueOf(i2), parcelFileDescriptor, writeResultCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$cancellationSignal = cancellationSignal;
                    this.val$pdfAttributes = r8;
                    this.val$bitmap = bitmap;
                    this.val$attributes = printAttributes;
                    this.val$fittingMode = i2;
                    this.val$fileDescriptor = parcelFileDescriptor;
                    this.val$writeResultCallback = writeResultCallback;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public Throwable doInBackground(Void... voidArr) {
                    RectF rectF;
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                        try {
                            if (this.val$cancellationSignal.isCanceled()) {
                                return null;
                            }
                            PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.this$0.mContext, this.val$pdfAttributes);
                            Bitmap convertBitmapForColorMode = PrintHelper.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
                            if (this.val$cancellationSignal.isCanceled()) {
                                return null;
                            }
                            PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                            if (PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT) {
                                rectF = new RectF(startPage.getInfo().getContentRect());
                            } else {
                                PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(this.this$0.mContext, this.val$attributes);
                                PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                                RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                                printedPdfDocument2.finishPage(startPage2);
                                printedPdfDocument2.close();
                                rectF = rectF2;
                            }
                            Matrix matrix = PrintHelper.getMatrix(convertBitmapForColorMode.getWidth(), convertBitmapForColorMode.getHeight(), rectF, this.val$fittingMode);
                            if (!PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT) {
                                matrix.postTranslate(rectF.left, rectF.top);
                                startPage.getCanvas().clipRect(rectF);
                            }
                            startPage.getCanvas().drawBitmap(convertBitmapForColorMode, matrix, null);
                            printedPdfDocument.finishPage(startPage);
                            if (this.val$cancellationSignal.isCanceled()) {
                                printedPdfDocument.close();
                                if (this.val$fileDescriptor != null) {
                                    try {
                                        this.val$fileDescriptor.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (convertBitmapForColorMode != this.val$bitmap) {
                                    convertBitmapForColorMode.recycle();
                                }
                                return null;
                            }
                            printedPdfDocument.writeTo(new FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                            printedPdfDocument.close();
                            if (this.val$fileDescriptor != null) {
                                try {
                                    this.val$fileDescriptor.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (convertBitmapForColorMode != this.val$bitmap) {
                                convertBitmapForColorMode.recycle();
                            }
                            return null;
                        } catch (Throwable th) {
                            return th;
                        }
                    }
                    return (Throwable) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public void onPostExecute(Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, th) == null) {
                        if (this.val$cancellationSignal.isCanceled()) {
                            this.val$writeResultCallback.onWriteCancelled();
                        } else if (th == null) {
                            this.val$writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                        } else {
                            this.val$writeResultCallback.onWriteFailed(null);
                        }
                    }
                }
            }.execute(new Void[0]);
        }
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, bitmap, onPrintFinishCallback) == null) || Build.VERSION.SDK_INT < 19 || bitmap == null) {
            return;
        }
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        if (isPortrait(bitmap)) {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
        } else {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        }
        printManager.print(str, new PrintBitmapAdapter(this, str, this.mScaleMode, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build());
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, uri) == null) {
            printBitmap(str, uri, (OnPrintFinishCallback) null);
        }
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri, @Nullable OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, uri, onPrintFinishCallback) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        PrintUriAdapter printUriAdapter = new PrintUriAdapter(this, str, uri, onPrintFinishCallback, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.mColorMode);
        int i2 = this.mOrientation;
        if (i2 == 1 || i2 == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i2 == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, printUriAdapter, builder.build());
    }
}
