package com.baidu.mobads.container.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes2.dex */
public class XAdSimpleImageLoader {
    public static final String TAG = "XAdSimpleImageLoader";
    public static final String TEMP_SUFFIX = ".temp";
    public static XAdSimpleImageLoader sInstance;
    public Context mAppContext;
    public LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 32) { // from class: com.baidu.mobads.container.util.XAdSimpleImageLoader.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        public int sizeOf(String str, Bitmap bitmap) {
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getByteCount();
        }
    };

    /* loaded from: classes2.dex */
    public static class ImageSize {
        public int height;
        public int width;

        public ImageSize() {
        }
    }

    public XAdSimpleImageLoader(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public static int caculateInSampleSize(BitmapFactory.Options options, ImageView imageView) {
        ImageSize generateImageViewSize = generateImageViewSize(imageView);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i2 > generateImageViewSize.width || i3 > generateImageViewSize.height) {
            return Math.max(Math.round((i2 * 1.0f) / generateImageViewSize.width), Math.round((i3 * 1.0f) / generateImageViewSize.height));
        }
        return 1;
    }

    public static String fileFolder(Context context) {
        return SdcardUtils.getStoragePath(context.getApplicationContext());
    }

    public static String fileLocation(Context context, String str) {
        String storagePath = SdcardUtils.getStoragePath(context.getApplicationContext());
        String md5 = EncryptUtils.getMD5(str);
        return storagePath + md5 + TEMP_SUFFIX;
    }

    public static String fileName(String str) {
        return EncryptUtils.getMD5(str);
    }

    public static ImageSize generateImageViewSize(ImageView imageView) {
        ImageSize imageSize = new ImageSize();
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = imageView.getMaxWidth();
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = imageView.getMaxHeight();
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        imageSize.width = width;
        imageSize.height = height;
        return imageSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertToLruCache(String str, Bitmap bitmap) {
        if (this.mCache.get(str) != null || str == null || bitmap == null) {
            return;
        }
        this.mCache.put(str, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap loadImageFromFile(String str, ImageView imageView, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        generateImageViewSize(imageView);
        options.inSampleSize = caculateInSampleSize(options, imageView);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (z) {
            imageView.setImageBitmap(decodeFile);
        }
        return decodeFile;
    }

    private void loadImageFromNet(String str, Observer observer) {
        try {
            URL url = new URL(str);
            OAdRemoteDownloadManager oAdRemoteDownloadManager = OAdRemoteDownloadManager.getInstance(this.mAppContext);
            String fileFolder = fileFolder(this.mAppContext);
            IDownloader createSimpleFileDownloader = oAdRemoteDownloadManager.createSimpleFileDownloader(url, fileFolder, fileName(str) + TEMP_SUFFIX, true);
            createSimpleFileDownloader.addObserver(observer);
            createSimpleFileDownloader.start();
        } catch (MalformedURLException unused) {
        }
    }

    public static XAdSimpleImageLoader obtain(Context context) {
        if (sInstance == null) {
            synchronized (XAdSimpleImageLoader.class) {
                if (sInstance == null) {
                    sInstance = new XAdSimpleImageLoader(context);
                }
            }
        }
        return sInstance;
    }

    public boolean isNeedCacheFromNet(String str) {
        if (TextUtils.isEmpty(str) || this.mCache.get(str) != null) {
            return false;
        }
        Bitmap loadImageFromFile = loadImageFromFile(fileLocation(this.mAppContext, str));
        if (loadImageFromFile == null) {
            return true;
        }
        insertToLruCache(str, loadImageFromFile);
        return false;
    }

    public void load(final ImageView imageView, final String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalThreadStateException("please invoke in main thread!");
        }
        if (imageView == null || str == null) {
            return;
        }
        Bitmap bitmap = this.mCache.get(str);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        Bitmap loadImageFromFile = loadImageFromFile(fileLocation(this.mAppContext, str), imageView, true);
        if (loadImageFromFile != null) {
            insertToLruCache(str, loadImageFromFile);
        } else {
            loadImageFromNet(str, new Observer() { // from class: com.baidu.mobads.container.util.XAdSimpleImageLoader.2
                @Override // java.util.Observer
                public void update(Observable observable, Object obj) {
                    if (((IDownloader) observable).getState() == IDownloader.DownloadStatus.COMPLETED) {
                        XAdSimpleImageLoader xAdSimpleImageLoader = XAdSimpleImageLoader.this;
                        final Bitmap loadImageFromFile2 = xAdSimpleImageLoader.loadImageFromFile(XAdSimpleImageLoader.fileLocation(xAdSimpleImageLoader.mAppContext, str), imageView, false);
                        if (loadImageFromFile2 != null) {
                            ActivityUtils.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.container.util.XAdSimpleImageLoader.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    imageView.setImageBitmap(loadImageFromFile2);
                                }
                            });
                            XAdSimpleImageLoader.this.insertToLruCache(str, loadImageFromFile2);
                        }
                    }
                }
            });
        }
    }

    public void load(String str, Observer observer) {
        if (str == null || observer == null) {
            return;
        }
        try {
            loadImageFromNet(str, observer);
        } catch (Throwable unused) {
        }
    }

    private Bitmap loadImageFromFile(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }
}
