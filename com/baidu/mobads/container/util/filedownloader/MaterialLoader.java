package com.baidu.mobads.container.util.filedownloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import com.baidu.mobads.container.util.cache.CacheEngine;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class MaterialLoader {
    public static final String IMAGE_CACHE_PATH = "img_download/";
    public static final String KEY_OF_CACHING_RESULT = "caching_result";
    public static final String KEY_OF_DL_TIME_CONSUME = "caching_time_consume";
    public static final String KEY_OF_LOCAL_CREATIVE_URL = "local_creative_url";
    public static final int MAX_IMAGE_HEIGHT = 1140;
    public static final int MAX_IMAGE_SIZE = 2457600;
    public static final int MAX_IMAGE_WIDTH = 1140;
    public static final int MAX_RATIO = 6;
    public static final String TAG = "MaterialLoader";
    public static final String VIDEO_CACHE_PATH = "video_download/";
    public static volatile MaterialLoader mSingleton;
    public MaterialLoadingListener emptyListener = new MaterialLoadingListener() { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.1
        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }

        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingFailed(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
        }

        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    };
    public Context mContext;

    /* loaded from: classes2.dex */
    public static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
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
    }

    public MaterialLoader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void downloadMaterial(final String str, final ImageView imageView, final MaterialLoadingListener materialLoadingListener) {
        OAdURLConnection oAdURLConnection = new OAdURLConnection(1, str);
        oAdURLConnection.addImageRequestListener(new OAdURLConnection.OnImageRequestListener() { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.3
            @Override // com.baidu.mobads.container.components.net.OAdURLConnection.OnImageRequestListener
            public void onFail(String str2, int i) {
                String str3 = MaterialLoader.TAG;
                Log.e(str3, "素材请求失败，onFail: " + str2);
                materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
            }

            @Override // com.baidu.mobads.container.components.net.OAdURLConnection.OnImageRequestListener
            public void onSuccess(InputStream inputStream, String str2) {
                try {
                    if (inputStream != null) {
                        if (str.indexOf(".mp4") <= 0 && str.indexOf(".gif") <= 0) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPurgeable = true;
                            options.inInputShareable = true;
                            final Bitmap decodeStream = BitmapFactory.decodeStream(new FlushedInputStream(inputStream), null, options);
                            if (decodeStream != null) {
                                Bitmap pixelCompress = !str.substring(str.lastIndexOf("/") + 1).toUpperCase().contains("PNG") ? MaterialLoader.pixelCompress(MaterialLoader.qualityCompress(decodeStream, 100 - (MaterialLoader.this.qualityCompressionRatio(decodeStream) * 10)), MaterialLoader.sizeCompressRatio(options)) : decodeStream;
                                if (pixelCompress != null) {
                                    decodeStream = pixelCompress;
                                }
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    if (imageView != null) {
                                        imageView.setImageBitmap(decodeStream);
                                        imageView.setBackgroundResource(17170445);
                                        imageView.setVisibility(0);
                                    }
                                } else {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.3.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            ImageView imageView2 = imageView;
                                            if (imageView2 != null) {
                                                imageView2.setImageBitmap(decodeStream);
                                                imageView.setBackgroundResource(17170445);
                                                imageView.setVisibility(0);
                                            }
                                        }
                                    });
                                }
                                MaterialLoader.this.storeImageData(decodeStream, str);
                                materialLoadingListener.onLoadingComplete(str, imageView, decodeStream);
                                inputStream.close();
                                return;
                            }
                            return;
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            MaterialLoader.this.storeData(byteArrayOutputStream.toByteArray(), str, new CacheEngine.CacheListener() { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.3.1
                                @Override // com.baidu.mobads.container.util.cache.CacheEngine.CacheListener
                                public void onCacheComplete() {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    materialLoadingListener.onLoadingComplete(str, null, null);
                                }

                                @Override // com.baidu.mobads.container.util.cache.CacheEngine.CacheListener
                                public void onCacheFailed() {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    materialLoadingListener.onLoadingFailed(str, null, MaterialLoadErrorCode.ERROR_CODE_CACHE_ERROR);
                                }
                            });
                            byteArrayOutputStream.flush();
                        } catch (FileNotFoundException e2) {
                            e2.printStackTrace();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return;
                    }
                    Log.e(MaterialLoader.TAG, "素材请求失败，无数据流");
                    materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                } catch (OutOfMemoryError unused) {
                    Log.e(MaterialLoader.TAG, "素材请求失败，OOM");
                    materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                } catch (Throwable unused2) {
                    Log.e(MaterialLoader.TAG, "素材请求失败，解析异常");
                    materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_REQUEST_ERROR);
                }
            }
        });
        oAdURLConnection.asynLoad();
    }

    public static int getBitmapSize(Bitmap bitmap) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (i >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static MaterialLoader getInstance(Context context) {
        if (mSingleton == null) {
            synchronized (MaterialLoader.class) {
                if (mSingleton == null) {
                    mSingleton = new MaterialLoader(context);
                }
            }
        }
        return mSingleton;
    }

    public static Bitmap pixelCompress(Bitmap bitmap, int i) {
        if (i <= 1) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float f2 = 1.0f / i;
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap qualityCompress(Bitmap bitmap, int i) {
        if (i == 100) {
            return bitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        try {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (byteArray != null) {
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Bitmap retrieveDataForKey(String str) {
        return CacheEngine.getInstance(this.mContext).retrieveBitmapForKey(str);
    }

    public static int sizeCompressRatio(BitmapFactory.Options options) {
        int i;
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 > 1140 || i3 > 1140) {
            int i4 = 2;
            int i5 = i2 / 2;
            int i6 = i3 / 2;
            while (true) {
                if (i5 < 1140 && i6 < 1140) {
                    break;
                }
                i4 *= 2;
            }
            i = i4;
        } else {
            i = 1;
        }
        if (i > 6) {
            return 6;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeData(byte[] bArr, String str, CacheEngine.CacheListener cacheListener) {
        CacheEngine.getInstance(this.mContext).storeData(str, bArr, false, cacheListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeImageData(Bitmap bitmap, String str) {
        CacheEngine.getInstance(this.mContext).storeBitmap(str, bitmap);
    }

    public void cacheMaterialForURLString(String str, MaterialLoadingListener materialLoadingListener) {
        if (materialLoadingListener == null) {
            materialLoadingListener = this.emptyListener;
        }
        if (isCachedDataExistsForKey(str).booleanValue()) {
            materialLoadingListener.onLoadingComplete(str, null, retrieveDataForKey(str));
        } else {
            downloadMaterial(str, null, materialLoadingListener);
        }
    }

    public Bitmap getBitmapFromURLString(String str, MaterialLoadingListener materialLoadingListener) {
        if (materialLoadingListener == null) {
            materialLoadingListener = this.emptyListener;
        }
        if (isCachedDataExistsForKey(str).booleanValue()) {
            return retrieveDataForKey(str);
        }
        downloadMaterial(str, null, materialLoadingListener);
        return null;
    }

    public String getMaterialFilePath(String str) {
        return CacheEngine.getInstance(this.mContext).getFilePath(str);
    }

    public Boolean isCachedDataExistsForKey(String str) {
        return Boolean.valueOf(CacheEngine.getInstance(this.mContext).isDataExistsForKey(str));
    }

    public void loadImageForURLString(ImageView imageView, String str) {
        loadImageForURLString(imageView, str, this.emptyListener);
    }

    public int qualityCompressionRatio(Bitmap bitmap) {
        int bitmapSize = getBitmapSize(bitmap);
        if (bitmapSize > 2457600) {
            int i = bitmapSize / MAX_IMAGE_SIZE;
            if (i > 6) {
                return 6;
            }
            return i;
        }
        return 0;
    }

    public void loadImageForURLString(final ImageView imageView, String str, MaterialLoadingListener materialLoadingListener) {
        if (materialLoadingListener == null) {
            try {
                materialLoadingListener = this.emptyListener;
            } catch (Throwable unused) {
                materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_PARSE_ERROR);
                return;
            }
        }
        materialLoadingListener.onLoadingStarted(str, imageView);
        if (TextUtils.isEmpty(str)) {
            materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_URL_NULL);
        } else if (imageView == null) {
            materialLoadingListener.onLoadingFailed(str, imageView, MaterialLoadErrorCode.ERROR_CODE_VIEW_NULL);
        } else {
            final Bitmap retrieveDataForKey = retrieveDataForKey(str);
            if (retrieveDataForKey == null) {
                downloadMaterial(str, imageView, materialLoadingListener);
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                imageView.setImageBitmap(retrieveDataForKey);
                imageView.setBackgroundResource(17170445);
                imageView.setVisibility(0);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.mobads.container.util.filedownloader.MaterialLoader.2
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(retrieveDataForKey);
                        imageView.setBackgroundResource(17170445);
                        imageView.setVisibility(0);
                    }
                });
            }
            materialLoadingListener.onLoadingComplete(str, imageView, retrieveDataForKey);
        }
    }
}
