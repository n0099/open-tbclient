package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/* loaded from: classes.dex */
public class AsyncImageLoader extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public IAsyncImageLoaderListener mListener;
    public int mMaxNumOfPixels;

    /* loaded from: classes.dex */
    public interface IAsyncImageLoaderListener {
        void onComplete(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public class FlushedInputStream extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                long j2 = 0;
                while (j2 < j) {
                    long skip = ((FilterInputStream) this).in.skip(j - j2);
                    if (skip == 0) {
                        if (read() < 0) {
                            break;
                        }
                        skip = 1;
                    }
                    j2 += skip;
                }
                return j2;
            }
            return invokeJ.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(971405160, "Lcom/baidu/cloudsdk/common/imgloader/AsyncImageLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(971405160, "Lcom/baidu/cloudsdk/common/imgloader/AsyncImageLoader;");
                return;
            }
        }
        TAG = AsyncImageLoader.class.getSimpleName();
    }

    public AsyncImageLoader(Context context, int i, IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), iAsyncImageLoaderListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaxNumOfPixels = 19656;
        this.mContext = context.getApplicationContext();
        this.mListener = iAsyncImageLoaderListener;
        this.mMaxNumOfPixels = i;
    }

    public static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        int ceil;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, options, i, i2)) == null) {
            double d = options.outWidth;
            double d2 = options.outHeight;
            if (i2 == -1) {
                ceil = 1;
            } else {
                ceil = (int) Math.ceil(Math.sqrt((d * d2) / i2));
            }
            if (i == -1) {
                min = 128;
            } else {
                double d3 = i;
                min = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
            }
            if (min < ceil) {
                return ceil;
            }
            if (i2 == -1 && i == -1) {
                return 1;
            }
            if (i == -1) {
                return ceil;
            }
            return min;
        }
        return invokeLII.intValue;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, options, i, i2)) == null) {
            int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
            if (computeInitialSampleSize <= 8) {
                int i3 = 1;
                while (i3 < computeInitialSampleSize) {
                    i3 <<= 1;
                }
                return i3;
            }
            return ((computeInitialSampleSize + 7) / 8) * 8;
        }
        return invokeLII.intValue;
    }

    private InputStream getInputStreamFromUri(Uri uri) {
        InterceptResult invokeL;
        InputStream openStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, uri)) == null) {
            try {
                if (uri.getScheme() == null) {
                    openStream = new FileInputStream(new File(uri.toString()));
                } else {
                    if (!uri.getScheme().equalsIgnoreCase("http") && !uri.getScheme().equalsIgnoreCase("https")) {
                        if ((!uri.getScheme().equalsIgnoreCase("content") && !uri.getScheme().equalsIgnoreCase("file")) || this.mContext == null) {
                            return null;
                        }
                        String uri2 = uri.toString();
                        if (uri2.startsWith("file:///android_asset/")) {
                            openStream = this.mContext.getAssets().open(uri2.substring(22, uri2.length()));
                        } else {
                            openStream = this.mContext.getContentResolver().openInputStream(uri);
                        }
                    }
                    openStream = new URL(uri.toString()).openStream();
                }
                return openStream;
            } catch (IOException e) {
                Log.e(TAG, "IOexception");
                e.printStackTrace();
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public Bitmap doInBackground(Uri... uriArr) {
        InterceptResult invokeL;
        Uri uri;
        InputStream inputStreamFromUri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uriArr)) == null) {
            if (uriArr != null && uriArr.length >= 1 && (uri = uriArr[0]) != null && (inputStreamFromUri = getInputStreamFromUri(uri)) != null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamFromUri, null, options);
                options.inSampleSize = computeSampleSize(options, -1, this.mMaxNumOfPixels);
                options.inJustDecodeBounds = false;
                InputStream inputStreamFromUri2 = getInputStreamFromUri(uri);
                if (inputStreamFromUri2 != null) {
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(new FlushedInputStream(inputStreamFromUri2), null, options);
                        try {
                            inputStreamFromUri2.close();
                        } catch (IOException e) {
                            Log.e(TAG, "IO exception");
                            e.printStackTrace();
                        }
                        return decodeStream;
                    } catch (OutOfMemoryError e2) {
                        Log.e(TAG, "out of memory err no bitmap found");
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            IAsyncImageLoaderListener iAsyncImageLoaderListener = this.mListener;
            if (iAsyncImageLoaderListener != null) {
                iAsyncImageLoaderListener.onComplete(bitmap);
            }
            this.mContext = null;
        }
    }
}
