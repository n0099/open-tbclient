package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/* loaded from: classes.dex */
public class AsyncImageLoader extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    private static final String f834a = AsyncImageLoader.class.getSimpleName();
    private Context b;
    private IAsyncImageLoaderListener c;

    /* loaded from: classes.dex */
    public interface IAsyncImageLoaderListener {
        void onComplete(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) {
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

    public AsyncImageLoader(Context context, IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        this.b = context;
        this.c = iAsyncImageLoaderListener;
    }

    private static int a(BitmapFactory.Options options, int i, int i2) {
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
        int min = i == -1 ? DERTags.TAGGED : (int) Math.min(Math.floor(d / i), Math.floor(d2 / i));
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i != -1 ? min : ceil;
    }

    private InputStream a(Uri uri) {
        try {
        } catch (IOException e) {
            Log.e(f834a, "IOexception");
            e.printStackTrace();
        }
        if (uri.getScheme() == null) {
            return new FileInputStream(new File(uri.toString()));
        }
        if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https")) {
            return new URL(uri.toString()).openStream();
        }
        if ((uri.getScheme().equalsIgnoreCase("content") || uri.getScheme().equalsIgnoreCase("file")) && this.b != null) {
            return this.b.getContentResolver().openInputStream(uri);
        }
        return null;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int a2 = a(options, i, i2);
        if (a2 <= 8) {
            int i3 = 1;
            while (i3 < a2) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((a2 + 7) / 8) * 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Bitmap doInBackground(Uri... uriArr) {
        Uri uri;
        InputStream a2;
        if (uriArr == null || uriArr.length < 1 || (uri = uriArr[0]) == null || (a2 = a(uri)) == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(a2, null, options);
        options.inSampleSize = computeSampleSize(options, -1, Util.BYTE_OF_MB);
        options.inJustDecodeBounds = false;
        InputStream a3 = a(uri);
        if (a3 != null) {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(new a(a3), null, options);
                try {
                    a3.close();
                } catch (IOException e) {
                    Log.e(f834a, "IO exception");
                    e.printStackTrace();
                }
                return decodeStream;
            } catch (OutOfMemoryError e2) {
                Log.e(f834a, "out of memory err no bitmap found");
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        if (this.c != null) {
            this.c.onComplete(bitmap);
        }
    }
}
