package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.model.ImageStruct;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class SelectUtil {
    private static String selectedVideoPath;
    private static List<ImageStruct> selectedImages = new ArrayList();
    public static int MAX_SELECTED_DEFAULT = 9;
    public static int maxSelected = MAX_SELECTED_DEFAULT;
    private static float MIN_LARGE_IMG_RATIO = 2.5f;
    private static float MIN_LARGE_IMG_SCALE = 100.0f;
    private static float MAX_IMG_MB_VALUE = 1.572864E7f;
    private static float WENDA_MAX_IMG_MB_VALUE = 5242880.0f;
    public static boolean supportGifLongImg = true;
    private static boolean isWenda = false;
    private static int photoFirstIndex = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int photoLastIndex = -1;

    public static List<ImageStruct> getSeletedImages() {
        return selectedImages;
    }

    public static int getSelectedCount() {
        return selectedImages.size();
    }

    public static void setSeletedImages(List<ImageStruct> list) {
        selectedImages.clear();
        selectedImages.addAll(list);
    }

    public static String getSelectedVideoPath() {
        return selectedVideoPath;
    }

    public static void setSelectedVideoPath(String str) {
        selectedVideoPath = str;
    }

    public static void clear() {
        selectedImages.clear();
        resetSelectedIndex();
    }

    private static void resetSelectedIndex() {
        photoFirstIndex = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        photoLastIndex = -1;
    }

    public static void saveSelectedImages(ImageStruct imageStruct) {
        if (imageStruct != null) {
            selectedImages.add(imageStruct);
        }
    }

    public static void saveSelectedImages(ImageStruct imageStruct, int i) {
        saveSelectedImages(imageStruct);
        if (i < photoFirstIndex) {
            photoFirstIndex = i;
        }
        if (i > photoLastIndex) {
            photoLastIndex = i;
        }
    }

    public static void isWenda(boolean z) {
        isWenda = z;
    }

    public static void removeSelectedImags(ImageStruct imageStruct) {
        selectedImages.remove(imageStruct);
    }

    public static boolean tryRemoveNoExistsImags() {
        if (selectedImages == null) {
            return false;
        }
        int size = selectedImages.size();
        Iterator<ImageStruct> it = selectedImages.iterator();
        while (it.hasNext()) {
            if (!FileHelper.exists(it.next().contentUri)) {
                it.remove();
            }
        }
        return size != selectedImages.size();
    }

    public static boolean hasImage(ImageStruct imageStruct) {
        return selectedImages.contains(imageStruct);
    }

    public static List<ImageStruct> getPath() {
        return selectedImages;
    }

    public static List<String> getPathUrlList() {
        ArrayList arrayList = new ArrayList();
        if (selectedImages == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= selectedImages.size()) {
                return arrayList;
            }
            if (selectedImages.get(i2) != null) {
                arrayList.add(selectedImages.get(i2).uriStr);
            }
            i = i2 + 1;
        }
    }

    public static boolean isLargeImage(Uri uri) {
        BitmapFactory.Options options = getOptions(uri);
        if (options != null) {
            return isLargeImage(options.outWidth, options.outHeight, isGif(uri));
        }
        return false;
    }

    public static boolean isLargeImage(int i, int i2, boolean z) {
        if (!z && i > MIN_LARGE_IMG_SCALE && i2 > MIN_LARGE_IMG_SCALE) {
            float f = i / i2;
            if (f > MIN_LARGE_IMG_RATIO || 1.0f / f > MIN_LARGE_IMG_RATIO) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLargeImage(ImageStruct imageStruct) {
        if (imageStruct == null) {
            return false;
        }
        if (imageStruct.width > 0 && imageStruct.height > 0) {
            return isLargeImage(imageStruct.width, imageStruct.height, imageStruct.isGif());
        }
        return isLargeImage(imageStruct.contentUri);
    }

    public static boolean isLargeImage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isLargeImage(UgcUriUtils.getUri(str));
    }

    public static boolean isGif(Uri uri) {
        BitmapFactory.Options options = getOptions(uri);
        if (options != null) {
            String str = options.outMimeType;
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("image/gif")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isGif(UgcUriUtils.getUri(str));
    }

    private static boolean isWideHighLegal(Uri uri) {
        BitmapFactory.Options options = getOptions(uri);
        if (options != null) {
            return isWideHighLegal(options.outWidth, options.outHeight);
        }
        return false;
    }

    public static boolean isWideHighLegal(ImageStruct imageStruct) {
        if (imageStruct == null) {
            return false;
        }
        if (imageStruct.width > 0 && imageStruct.height > 0) {
            return isWideHighLegal(imageStruct.width, imageStruct.height);
        }
        return isWideHighLegal(imageStruct.contentUri);
    }

    public static boolean isWideHighLegal(float f, float f2) {
        return f > 0.0f && f2 > 0.0f && (f < MIN_LARGE_IMG_SCALE || f2 < MIN_LARGE_IMG_SCALE);
    }

    private static boolean isScaleLegal(Uri uri) {
        BitmapFactory.Options options = getOptions(uri);
        if (options != null) {
            return isScaleLegal(options.outWidth, options.outHeight);
        }
        return false;
    }

    public static boolean isScaleLegal(ImageStruct imageStruct) {
        if (imageStruct == null) {
            return false;
        }
        if (imageStruct.width > 0 && imageStruct.height > 0) {
            return isScaleLegal(imageStruct.width, imageStruct.height);
        }
        return isScaleLegal(imageStruct.contentUri);
    }

    public static boolean isScaleLegal(float f, float f2) {
        return f > 0.0f && f2 > 0.0f && f / f2 <= 3.0f && f2 / f <= 3.0f;
    }

    public static BitmapFactory.Options getOptions(Uri uri) {
        InputStream inputStream = null;
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || uri == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            inputStream = appContext.getContentResolver().openInputStream(uri);
            BitmapFactory.decodeStream(inputStream, null, options);
            return options;
        } catch (FileNotFoundException e) {
            return options;
        } finally {
            Closeables.closeSafely(inputStream);
        }
    }

    public static BitmapFactory.Options getOptions(String str) {
        Uri uri = UgcUriUtils.getUri(str);
        if (uri == null) {
            return null;
        }
        if (UgcUriUtils.isLocalContentUri(uri)) {
            return getOptions(uri);
        }
        if (UgcUriUtils.isLocalFileUri(uri)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uri.getPath(), options);
            return options;
        }
        return null;
    }

    public static boolean isTooBigImage(long j) {
        if (((float) j) > (isWenda ? WENDA_MAX_IMG_MB_VALUE : MAX_IMG_MB_VALUE)) {
            return true;
        }
        return false;
    }

    public static void replaceImageUri(String str, Uri uri) {
        if (!TextUtils.isEmpty(str) && uri != null) {
            Uri uri2 = UgcUriUtils.getUri(str);
            if (selectedImages != null && selectedImages.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < selectedImages.size()) {
                        ImageStruct imageStruct = selectedImages.get(i2);
                        if (!imageStruct.contentUri.equals(uri2)) {
                            i = i2 + 1;
                        } else {
                            imageStruct.contentUri = uri;
                            imageStruct.uriStr = uri.toString();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static int getPhotoFirstIndex() {
        return photoFirstIndex;
    }

    public static int getPhotoLastIndex() {
        return photoLastIndex;
    }
}
