package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.b45;
import com.baidu.tieba.bg;
import com.baidu.tieba.cg;
import com.baidu.tieba.hi;
import com.baidu.tieba.jg;
import com.baidu.tieba.rm;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SpecHotTopicHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Long, Pair<String, String>> mMap;
    public static bg mResourceCallback;
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
        mResourceCallback = new bg<rm>() { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.2
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
            @Override // com.baidu.tieba.bg
            public void onLoaded(rm rmVar, String str, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, rmVar, str, i) == null) {
                    super.onLoaded((AnonymousClass2) rmVar, str, i);
                    if (rmVar != null) {
                        TbImageMemoryCache.o().c(str, rmVar.p());
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
        rm loadBdImageFromLocal;
        rm loadBdImageFromLocal2;
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65539, null, threadData, spannableString, str, i) == null) && threadData != null && spannableString != null && !StringUtils.isNull(str)) {
            String leftHotIconUrl = threadData.getLeftHotIconUrl();
            String rightHotIconUrl = threadData.getRightHotIconUrl();
            if (!StringUtils.isNull(leftHotIconUrl) && !StringUtils.isNull(rightHotIconUrl)) {
                Bitmap n = TbImageMemoryCache.o().n(leftHotIconUrl);
                if ((n == null || !AbstractImageLoaderProc.isImageFileExist(leftHotIconUrl, 10)) && (loadBdImageFromLocal = AbstractImageLoaderProc.loadBdImageFromLocal(leftHotIconUrl, 10)) != null) {
                    n = loadBdImageFromLocal.p();
                    TbImageMemoryCache.o().c(leftHotIconUrl, n);
                }
                Bitmap n2 = TbImageMemoryCache.o().n(rightHotIconUrl);
                if ((n2 == null || !AbstractImageLoaderProc.isImageFileExist(rightHotIconUrl, 10)) && (loadBdImageFromLocal2 = AbstractImageLoaderProc.loadBdImageFromLocal(rightHotIconUrl, 10)) != null) {
                    n2 = loadBdImageFromLocal2.p();
                    TbImageMemoryCache.o().c(rightHotIconUrl, n2);
                }
                if (n != null && !n.isRecycled() && n2 != null && !n2.isRecycled()) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < str.length(); i3++) {
                        if (str.charAt(i3) == '#') {
                            if (i2 % 2 == 0) {
                                bitmapDrawable = new BitmapDrawable(n);
                                bitmapDrawable.setBounds(0, 0, n.getWidth(), n.getHeight());
                            } else {
                                bitmapDrawable = new BitmapDrawable(n2);
                                bitmapDrawable.setBounds(0, 0, n2.getWidth(), n2.getHeight());
                            }
                            b45 b45Var = new b45(bitmapDrawable);
                            b45Var.b(hi.d(TbadkCoreApplication.getInst(), threadData.threadTitleSpanOffset));
                            int i4 = i + i3;
                            spannableString.setSpan(b45Var, i4, i4 + 1, 33);
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
            Bitmap n = TbImageMemoryCache.o().n(str);
            Bitmap n2 = TbImageMemoryCache.o().n(str2);
            if (n != null && n2 != null) {
                return;
            }
            if (!hi.E()) {
                jg.a().post(new Runnable(str, str2) { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.1
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
                            cg.h().m(this.val$left, 10, SpecHotTopicHelper.mResourceCallback, null);
                            cg.h().m(this.val$right, 10, SpecHotTopicHelper.mResourceCallback, null);
                        }
                    }
                });
                return;
            }
            cg.h().m(str, 10, mResourceCallback, null);
            cg.h().m(str2, 10, mResourceCallback, null);
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
