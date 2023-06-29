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
import com.baidu.tieba.ga5;
import com.baidu.tieba.in;
import com.baidu.tieba.qg;
import com.baidu.tieba.rg;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
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
    public static qg mResourceCallback;
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
        mResourceCallback = new qg<in>() { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.2
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
            @Override // com.baidu.tieba.qg
            public void onLoaded(in inVar, String str, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, inVar, str, i) == null) {
                    super.onLoaded((AnonymousClass2) inVar, str, i);
                    if (inVar != null) {
                        TbImageMemoryCache.u().f(str, inVar.p());
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
        in loadBdImageFromLocal;
        in loadBdImageFromLocal2;
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65539, null, threadData, spannableString, str, i) == null) && threadData != null && spannableString != null && !StringUtils.isNull(str)) {
            String leftHotIconUrl = threadData.getLeftHotIconUrl();
            String rightHotIconUrl = threadData.getRightHotIconUrl();
            if (!StringUtils.isNull(leftHotIconUrl) && !StringUtils.isNull(rightHotIconUrl)) {
                Bitmap t = TbImageMemoryCache.u().t(leftHotIconUrl);
                if ((t == null || !AbstractImageLoaderProc.isImageFileExist(leftHotIconUrl, 10)) && (loadBdImageFromLocal = AbstractImageLoaderProc.loadBdImageFromLocal(leftHotIconUrl, 10)) != null) {
                    t = loadBdImageFromLocal.p();
                    TbImageMemoryCache.u().f(leftHotIconUrl, t);
                }
                Bitmap t2 = TbImageMemoryCache.u().t(rightHotIconUrl);
                if ((t2 == null || !AbstractImageLoaderProc.isImageFileExist(rightHotIconUrl, 10)) && (loadBdImageFromLocal2 = AbstractImageLoaderProc.loadBdImageFromLocal(rightHotIconUrl, 10)) != null) {
                    t2 = loadBdImageFromLocal2.p();
                    TbImageMemoryCache.u().f(rightHotIconUrl, t2);
                }
                if (t != null && !t.isRecycled() && t2 != null && !t2.isRecycled()) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < str.length(); i3++) {
                        if (str.charAt(i3) == '#') {
                            if (i2 % 2 == 0) {
                                bitmapDrawable = new BitmapDrawable(t);
                                bitmapDrawable.setBounds(0, 0, t.getWidth(), t.getHeight());
                            } else {
                                bitmapDrawable = new BitmapDrawable(t2);
                                bitmapDrawable.setBounds(0, 0, t2.getWidth(), t2.getHeight());
                            }
                            ga5 ga5Var = new ga5(bitmapDrawable);
                            ga5Var.b(xi.d(TbadkCoreApplication.getInst(), threadData.threadTitleSpanOffset));
                            int i4 = i + i3;
                            spannableString.setSpan(ga5Var, i4, i4 + 1, 33);
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
            Bitmap t = TbImageMemoryCache.u().t(str);
            Bitmap t2 = TbImageMemoryCache.u().t(str2);
            if (t != null && t2 != null) {
                return;
            }
            if (!xi.E()) {
                yg.a().post(new Runnable(str, str2) { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.1
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
                            rg.h().m(this.val$left, 10, SpecHotTopicHelper.mResourceCallback, null);
                            rg.h().m(this.val$right, 10, SpecHotTopicHelper.mResourceCallback, null);
                        }
                    }
                });
                return;
            }
            rg.h().m(str, 10, mResourceCallback, null);
            rg.h().m(str2, 10, mResourceCallback, null);
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
