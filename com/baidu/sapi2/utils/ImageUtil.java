package com.baidu.sapi2.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import com.baidu.sapi2.base.debug.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class ImageUtil {
    private static final int mMaxNumOfPixels = 19656;

    /* loaded from: classes2.dex */
    public interface ImageLoaderListener {
        void onError(Exception exc);

        void onSuccess(Bitmap bitmap);
    }

    public static AsyncTask loadImage(String str, final ImageLoaderListener imageLoaderListener) {
        Uri parse = Uri.parse(str);
        if (parse == null) {
            imageLoaderListener.onError(new Exception("request url is null"));
            return null;
        }
        String scheme = parse.getScheme();
        if (scheme == null || !scheme.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            imageLoaderListener.onError(new Exception("the url: " + str + " is not http request"));
            return null;
        }
        return new AsyncImageLoader(mMaxNumOfPixels, new ImageLoaderListener() { // from class: com.baidu.sapi2.utils.ImageUtil.1
            @Override // com.baidu.sapi2.utils.ImageUtil.ImageLoaderListener
            public void onSuccess(Bitmap bitmap) {
                if (bitmap == null) {
                    ImageLoaderListener.this.onError(new Exception("bitmap is null"));
                } else {
                    ImageLoaderListener.this.onSuccess(bitmap);
                }
            }

            @Override // com.baidu.sapi2.utils.ImageUtil.ImageLoaderListener
            public void onError(Exception exc) {
                ImageLoaderListener.this.onError(exc);
            }
        }).execute(parse);
    }

    /* loaded from: classes2.dex */
    private static class AsyncImageLoader extends AsyncTask<Uri, Integer, Bitmap> {
        private ImageLoaderListener mListener;
        private int mMaxNumOfPixels;

        public AsyncImageLoader(int i, ImageLoaderListener imageLoaderListener) {
            this.mMaxNumOfPixels = ImageUtil.mMaxNumOfPixels;
            this.mListener = imageLoaderListener;
            this.mMaxNumOfPixels = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Uri... uriArr) {
            Uri uri;
            InputStream inputStreamFromUri;
            if (uriArr == null || uriArr.length < 1 || (uri = uriArr[0]) == null || (inputStreamFromUri = getInputStreamFromUri(uri)) == null) {
                return null;
            }
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
                        Log.e(e);
                    }
                    return decodeStream;
                } catch (OutOfMemoryError e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return null;
        }

        private InputStream getInputStreamFromUri(Uri uri) {
            try {
                return new URL(uri.toString()).openStream();
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }

        public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
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

        private static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
            double d = options.outWidth;
            double d2 = options.outHeight;
            int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
            int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / i), Math.floor(d2 / i));
            if (min >= ceil) {
                if (i2 == -1 && i == -1) {
                    return 1;
                }
                return i != -1 ? min : ceil;
            }
            return ceil;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (this.mListener != null) {
                this.mListener.onSuccess(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long skip = this.in.skip(j - j2);
                if (skip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    skip = 1;
                }
                j2 = skip + j2;
            }
            return j2;
        }
    }
}
