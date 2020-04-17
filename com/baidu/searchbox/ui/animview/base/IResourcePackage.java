package com.baidu.searchbox.ui.animview.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.airbnb.lottie.c;
import com.airbnb.lottie.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.h;
import com.airbnb.lottie.l;
import com.baidu.android.util.io.Closeables;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes13.dex */
public interface IResourcePackage {
    Drawable getDrawable(String str, Object... objArr);

    LottieResource getLottie(String str, Object... objArr);

    int getResourceCounts(String str);

    void releaseResource();

    /* loaded from: classes13.dex */
    public static class Utils {
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
            Throwable th;
            Drawable drawable = null;
            try {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDensity = 480;
                    fileInputStream = new FileInputStream(file);
                    try {
                        drawable = Drawable.createFromResourceStream(context.getResources(), null, fileInputStream, file.getName(), options);
                        Closeables.closeSafely(fileInputStream);
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream);
                        return drawable;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                Closeables.closeSafely(fileInputStream);
                throw th;
            }
            return drawable;
        }

        public static File[] findAllTargetFiles(File file, final String str, final boolean z) {
            if (file == null) {
                return null;
            }
            return file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.base.IResourcePackage.Utils.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return (z ? !file2.isDirectory() : file2.isDirectory()) && (TextUtils.isEmpty(str) || file2.getName().toLowerCase().contains(str));
                }
            });
        }
    }

    /* loaded from: classes13.dex */
    public static class LottieResource {
        public c mImageAssetDelegate;
        public e mLottieComposition;

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [140=4] */
        public static LottieResource newInstance(Context context, final File file) {
            String name;
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2;
            if (file != null) {
                try {
                    name = file.getName();
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream2 = null;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream2);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        Closeables.closeSafely(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    Closeables.closeSafely(fileInputStream);
                    throw th;
                }
            } else {
                name = "";
            }
            fileInputStream = new FileInputStream(file);
            try {
                l<e> c = f.c(fileInputStream, name);
                if (c == null) {
                    Closeables.closeSafely(fileInputStream);
                    return null;
                }
                LottieResource lottieResource = new LottieResource();
                lottieResource.mImageAssetDelegate = new c() { // from class: com.baidu.searchbox.ui.animview.base.IResourcePackage.LottieResource.1
                    @Override // com.airbnb.lottie.c
                    public Bitmap fetchBitmap(h hVar) {
                        FileInputStream fileInputStream3;
                        Throwable th3;
                        Bitmap bitmap = null;
                        try {
                            fileInputStream3 = new FileInputStream(new File(file.getParent() + "/" + hVar.gU() + hVar.getFileName()));
                            try {
                                try {
                                    bitmap = BitmapFactory.decodeStream(fileInputStream3);
                                    Closeables.closeSafely(fileInputStream3);
                                } catch (FileNotFoundException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    Closeables.closeSafely(fileInputStream3);
                                    return bitmap;
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                Closeables.closeSafely(fileInputStream3);
                                throw th3;
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            fileInputStream3 = null;
                        } catch (Throwable th5) {
                            fileInputStream3 = null;
                            th3 = th5;
                            Closeables.closeSafely(fileInputStream3);
                            throw th3;
                        }
                        return bitmap;
                    }
                };
                lottieResource.mLottieComposition = c.getValue();
                Closeables.closeSafely(fileInputStream);
                return lottieResource;
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                Closeables.closeSafely(fileInputStream2);
                return null;
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely(fileInputStream);
                throw th;
            }
        }
    }
}
