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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes7.dex */
public interface IResourcePackage {

    /* loaded from: classes7.dex */
    public static class LottieResource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageAssetDelegate mImageAssetDelegate;
        public LottieComposition mLottieComposition;

        public LottieResource() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0037 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
        public static LottieResource newInstance(Context context, File file) {
            InterceptResult invokeLL;
            String name;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, context, file)) != null) {
                return (LottieResource) invokeLL.objValue;
            }
            ?? r4 = 0;
            try {
                if (file != null) {
                    try {
                        name = file.getName();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream = null;
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely((Closeable) r4);
                        throw th;
                    }
                } else {
                    name = "";
                }
                fileInputStream = new FileInputStream(file);
                try {
                    LottieResult<LottieComposition> fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(fileInputStream, name);
                    if (fromJsonInputStreamSync == null) {
                        Closeables.closeSafely(fileInputStream);
                        return null;
                    }
                    LottieResource lottieResource = new LottieResource();
                    lottieResource.mImageAssetDelegate = new ImageAssetDelegate(file) { // from class: com.baidu.searchbox.ui.animview.base.IResourcePackage.LottieResource.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ File val$resFile;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {file};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$resFile = file;
                        }

                        /* JADX WARN: Not initialized variable reg: 1, insn: 0x004a: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:19:0x004a */
                        @Override // com.airbnb.lottie.ImageAssetDelegate
                        public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                            InterceptResult invokeL;
                            FileInputStream fileInputStream2;
                            Closeable closeable;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && (invokeL = interceptable2.invokeL(1048576, this, lottieImageAsset)) != null) {
                                return (Bitmap) invokeL.objValue;
                            }
                            Closeable closeable2 = null;
                            try {
                                try {
                                    fileInputStream2 = new FileInputStream(new File(this.val$resFile.getParent() + "/" + lottieImageAsset.getDirName() + lottieImageAsset.getFileName()));
                                    try {
                                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2);
                                        Closeables.closeSafely(fileInputStream2);
                                        return decodeStream;
                                    } catch (FileNotFoundException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        Closeables.closeSafely(fileInputStream2);
                                        return null;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    closeable2 = closeable;
                                    Closeables.closeSafely(closeable2);
                                    throw th;
                                }
                            } catch (FileNotFoundException e4) {
                                e = e4;
                                fileInputStream2 = null;
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
                } catch (FileNotFoundException e3) {
                    e = e3;
                    e.printStackTrace();
                    Closeables.closeSafely(fileInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                r4 = interceptable;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class Utils {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Utils() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static File[] findAllTargetFiles(File file, String str, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, file, str, z)) == null) {
                if (file == null) {
                    return null;
                }
                return file.listFiles(new FileFilter(z, str) { // from class: com.baidu.searchbox.ui.animview.base.IResourcePackage.Utils.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean val$fileOnly;
                    public final /* synthetic */ String val$searchKeyWord;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Boolean.valueOf(z), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$fileOnly = z;
                        this.val$searchKeyWord = str;
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) {
                            return (this.val$fileOnly ? !file2.isDirectory() : file2.isDirectory()) && (TextUtils.isEmpty(this.val$searchKeyWord) || file2.getName().toLowerCase().contains(this.val$searchKeyWord));
                        }
                        return invokeL.booleanValue;
                    }
                });
            }
            return (File[]) invokeLLZ.objValue;
        }

        public static Drawable loadImageFromFile(Context context, File file) {
            InterceptResult invokeLL;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, context, file)) != null) {
                return (Drawable) invokeLL.objValue;
            }
            Closeable closeable = null;
            try {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDensity = 480;
                    fileInputStream = new FileInputStream(file);
                    try {
                        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), null, fileInputStream, file.getName(), options);
                        Closeables.closeSafely(fileInputStream);
                        return createFromResourceStream;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable = 65538;
                    Closeables.closeSafely(closeable);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(closeable);
                throw th;
            }
        }

        public static LottieResource prepareLottieResource(Context context, File file, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, file, str)) == null) {
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
            return (LottieResource) invokeLLL.objValue;
        }
    }

    Drawable getDrawable(String str, Object... objArr);

    LottieResource getLottie(String str, Object... objArr);

    int getResourceCounts(String str);

    void releaseResource();
}
