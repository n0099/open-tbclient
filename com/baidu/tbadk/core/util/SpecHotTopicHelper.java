package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.fa5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class SpecHotTopicHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Long, Pair<String, String>> mMap;
    public static BdResourceCallback mResourceCallback;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-76439824, "Lcom/baidu/tbadk/core/util/SpecHotTopicHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-76439824, "Lcom/baidu/tbadk/core/util/SpecHotTopicHelper;");
                return;
            }
        }
        mMap = new HashMap();
        mResourceCallback = new BdResourceCallback<BdImage>() { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String str, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, bdImage, str, i) == null) {
                    super.onLoaded((AnonymousClass2) bdImage, str, i);
                    if (bdImage != null) {
                        TbImageMemoryCache.A().g(str, bdImage.getRawBitmap());
                    }
                }
            }
        };
    }

    public SpecHotTopicHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addSpecTopic(ThreadData threadData, SpannableString spannableString, String str, int i) {
        BdImage loadBdImageFromLocal;
        BdImage loadBdImageFromLocal2;
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65539, null, threadData, spannableString, str, i) == null) && threadData != null && spannableString != null && !StringUtils.isNull(str)) {
            String leftHotIconUrl = threadData.getLeftHotIconUrl();
            String rightHotIconUrl = threadData.getRightHotIconUrl();
            if (!StringUtils.isNull(leftHotIconUrl) && !StringUtils.isNull(rightHotIconUrl)) {
                Bitmap w = TbImageMemoryCache.A().w(leftHotIconUrl);
                if ((w == null || !AbstractImageLoaderProc.isImageFileExist(leftHotIconUrl, 10)) && (loadBdImageFromLocal = AbstractImageLoaderProc.loadBdImageFromLocal(leftHotIconUrl, 10)) != null) {
                    w = loadBdImageFromLocal.getRawBitmap();
                    TbImageMemoryCache.A().g(leftHotIconUrl, w);
                }
                Bitmap w2 = TbImageMemoryCache.A().w(rightHotIconUrl);
                if ((w2 == null || !AbstractImageLoaderProc.isImageFileExist(rightHotIconUrl, 10)) && (loadBdImageFromLocal2 = AbstractImageLoaderProc.loadBdImageFromLocal(rightHotIconUrl, 10)) != null) {
                    w2 = loadBdImageFromLocal2.getRawBitmap();
                    TbImageMemoryCache.A().g(rightHotIconUrl, w2);
                }
                if (w != null && !w.isRecycled() && w2 != null && !w2.isRecycled()) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < str.length(); i3++) {
                        if (str.charAt(i3) == '#') {
                            if (i2 % 2 == 0) {
                                bitmapDrawable = new BitmapDrawable(w);
                                bitmapDrawable.setBounds(0, 0, w.getWidth(), w.getHeight());
                            } else {
                                bitmapDrawable = new BitmapDrawable(w2);
                                bitmapDrawable.setBounds(0, 0, w2.getWidth(), w2.getHeight());
                            }
                            fa5 fa5Var = new fa5(bitmapDrawable);
                            fa5Var.b(BdUtilHelper.dip2px(TbadkCoreApplication.getInst(), threadData.threadTitleSpanOffset));
                            int i4 = i + i3;
                            spannableString.setSpan(fa5Var, i4, i4 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                loadSpecTopicIconIfNeed(leftHotIconUrl, rightHotIconUrl);
            }
        }
    }

    public static void loadSpecTopicIconIfNeed(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            Bitmap w = TbImageMemoryCache.A().w(str);
            Bitmap w2 = TbImageMemoryCache.A().w(str2);
            if (w != null && w2 != null) {
                return;
            }
            if (!BdUtilHelper.isMainThread()) {
                SafeHandler.getInst().post(new Runnable(str, str2) { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$left;
                    public final /* synthetic */ String val$right;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$left = str;
                        this.val$right = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BdResourceLoader.getInstance().loadResource(this.val$left, 10, SpecHotTopicHelper.mResourceCallback, null);
                            BdResourceLoader.getInstance().loadResource(this.val$right, 10, SpecHotTopicHelper.mResourceCallback, null);
                        }
                    }
                });
                return;
            }
            BdResourceLoader.getInstance().loadResource(str, 10, mResourceCallback, null);
            BdResourceLoader.getInstance().loadResource(str2, 10, mResourceCallback, null);
        }
    }

    public static void putSpecialTopicIcon(Long l, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, l, str, str2) == null) && l != null && l.intValue() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            loadSpecTopicIconIfNeed(str, str2);
            mMap.put(l, new Pair<>(str, str2));
        }
    }

    public static void removeSpecTopicIconForFrs(Long l) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, l) == null) && l.longValue() > 0) {
            mMap.remove(l);
        }
    }

    public static void setSpecTopicIcon(long j, ThreadData threadData) {
        Pair<String, String> pair;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(65543, null, j, threadData) == null) && (pair = mMap.get(Long.valueOf(j))) != null) {
            threadData.setFid(j);
            threadData.setSpecUrl((String) pair.first, (String) pair.second);
        }
    }
}
