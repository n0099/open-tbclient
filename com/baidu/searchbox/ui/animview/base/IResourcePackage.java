package com.baidu.searchbox.ui.animview.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieResult;
import com.baidu.android.util.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
/* loaded from: classes4.dex */
public interface IResourcePackage {
    Drawable getDrawable(String str, Object... objArr);

    LottieResource getLottie(String str, Object... objArr);

    int getResourceCounts(String str);

    void releaseResource();

    /* loaded from: classes4.dex */
    public static class LottieResource {
        public ImageAssetDelegate mImageAssetDelegate;
        public LottieComposition mLottieComposition;

        public static LottieResource newInstance(Context context, final File file) {
            String name;
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2 = null;
            if (file != null) {
                try {
                    name = file.getName();
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream = null;
                    e.printStackTrace();
                    Closeables.closeSafely(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(fileInputStream2);
                    throw th;
                }
            } else {
                name = "";
            }
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    LottieResult<LottieComposition> fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(fileInputStream, name);
                    if (fromJsonInputStreamSync == null) {
                        Closeables.closeSafely(fileInputStream);
                        return null;
                    }
                    LottieResource lottieResource = new LottieResource();
                    lottieResource.mImageAssetDelegate = new ImageAssetDelegate() { // from class: com.baidu.searchbox.ui.animview.base.IResourcePackage.LottieResource.1
                        /* JADX WARN: Not initialized variable reg: 1, insn: 0x0046: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:17:0x0046 */
                        @Override // com.airbnb.lottie.ImageAssetDelegate
                        public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                            FileInputStream fileInputStream3;
                            Closeable closeable;
                            Closeable closeable2 = null;
                            try {
                                try {
                                    fileInputStream3 = new FileInputStream(new File(file.getParent() + "/" + lottieImageAsset.getDirName() + lottieImageAsset.getFileName()));
                                    try {
                                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream3);
                                        Closeables.closeSafely(fileInputStream3);
                                        return decodeStream;
                                    } catch (FileNotFoundException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        Closeables.closeSafely(fileInputStream3);
                                        return null;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    closeable2 = closeable;
                                    Closeables.closeSafely(closeable2);
                                    throw th;
                                }
                            } catch (FileNotFoundException e3) {
                                e = e3;
                                fileInputStream3 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                Closeables.closeSafely(closeable2);
                                throw th;
                            }
                        }
                    };
                    lottieResource.mLottieComposition = fromJsonInputStreamSync.getValue();
                    Closeables.closeSafely(fileInputStream);
                    return lottieResource;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    Closeables.closeSafely(fileInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                Closeables.closeSafely(fileInputStream2);
                throw th;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Utils {
        public static File[] findAllTargetFiles(File file, final String str, final boolean z) {
            if (file == null) {
                return null;
            }
            return file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.base.IResourcePackage.Utils.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    boolean isDirectory;
                    if (z) {
                        if (!file2.isDirectory()) {
                            isDirectory = true;
                        } else {
                            isDirectory = false;
                        }
                    } else {
                        isDirectory = file2.isDirectory();
                    }
                    if (isDirectory && (TextUtils.isEmpty(str) || file2.getName().toLowerCase(Locale.getDefault()).contains(str))) {
                        return true;
                    }
                    return false;
                }
            });
        }

        public static LottieResource prepareLottieResource(Context context, File file, String str) {
            if (file == null) {
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                str = ".json";
            }
            File[] findAllTargetFiles = findAllTargetFiles(file, str, true);
            if (findAllTargetFiles == null || findAllTargetFiles.length <= 0) {
                return null;
            }
            return LottieResource.newInstance(context, findAllTargetFiles[0]);
        }

        public static Drawable loadImageFromFile(Context context, File file) {
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2 = null;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inDensity = 480;
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), null, fileInputStream, file.getName(), options);
                        Closeables.closeSafely(fileInputStream);
                        return createFromResourceStream;
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    Closeables.closeSafely(fileInputStream2);
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(fileInputStream2);
                throw th;
            }
        }
    }
}
