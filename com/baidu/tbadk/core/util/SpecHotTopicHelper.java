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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ig;
import com.repackage.jg;
import com.repackage.m45;
import com.repackage.mu4;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.ym;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SpecHotTopicHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Long, Pair<String, String>> mMap;
    public static ig mResourceCallback;
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
        mResourceCallback = new ig<ym>() { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.2
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
            @Override // com.repackage.ig
            public void onLoaded(ym ymVar, String str, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, ymVar, str, i) == null) {
                    super.onLoaded((AnonymousClass2) ymVar, str, i);
                    if (ymVar != null) {
                        m45.k().a(str, ymVar.p());
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
        ym loadBdImageFromLocal;
        ym loadBdImageFromLocal2;
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65539, null, threadData, spannableString, str, i) == null) || threadData == null || spannableString == null || StringUtils.isNull(str)) {
            return;
        }
        String leftHotIconUrl = threadData.getLeftHotIconUrl();
        String rightHotIconUrl = threadData.getRightHotIconUrl();
        if (StringUtils.isNull(leftHotIconUrl) || StringUtils.isNull(rightHotIconUrl)) {
            return;
        }
        Bitmap j = m45.k().j(leftHotIconUrl);
        if ((j == null || !AbstractImageLoaderProc.isImageFileExist(leftHotIconUrl, 10)) && (loadBdImageFromLocal = AbstractImageLoaderProc.loadBdImageFromLocal(leftHotIconUrl, 10)) != null) {
            j = loadBdImageFromLocal.p();
            m45.k().a(leftHotIconUrl, j);
        }
        Bitmap j2 = m45.k().j(rightHotIconUrl);
        if ((j2 == null || !AbstractImageLoaderProc.isImageFileExist(rightHotIconUrl, 10)) && (loadBdImageFromLocal2 = AbstractImageLoaderProc.loadBdImageFromLocal(rightHotIconUrl, 10)) != null) {
            j2 = loadBdImageFromLocal2.p();
            m45.k().a(rightHotIconUrl, j2);
        }
        if (j != null && !j.isRecycled() && j2 != null && !j2.isRecycled()) {
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                if (str.charAt(i3) == '#') {
                    if (i2 % 2 == 0) {
                        bitmapDrawable = new BitmapDrawable(j);
                        bitmapDrawable.setBounds(0, 0, j.getWidth(), j.getHeight());
                    } else {
                        bitmapDrawable = new BitmapDrawable(j2);
                        bitmapDrawable.setBounds(0, 0, j2.getWidth(), j2.getHeight());
                    }
                    mu4 mu4Var = new mu4(bitmapDrawable);
                    mu4Var.b(pi.d(TbadkCoreApplication.getInst(), threadData.threadTitleSpanOffset));
                    int i4 = i + i3;
                    spannableString.setSpan(mu4Var, i4, i4 + 1, 33);
                    i2++;
                }
            }
            return;
        }
        loadSpecTopicIconIfNeed(leftHotIconUrl, rightHotIconUrl);
    }

    public static void loadSpecTopicIconIfNeed(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            Bitmap j = m45.k().j(str);
            Bitmap j2 = m45.k().j(str2);
            if (j == null || j2 == null) {
                if (!pi.C()) {
                    qg.a().post(new Runnable(str, str2) { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.1
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
                                jg.h().m(this.val$left, 10, SpecHotTopicHelper.mResourceCallback, null);
                                jg.h().m(this.val$right, 10, SpecHotTopicHelper.mResourceCallback, null);
                            }
                        }
                    });
                    return;
                }
                jg.h().m(str, 10, mResourceCallback, null);
                jg.h().m(str2, 10, mResourceCallback, null);
            }
        }
    }

    public static void putSpecialTopicIcon(Long l, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, l, str, str2) == null) || l == null || l.intValue() <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        loadSpecTopicIconIfNeed(str, str2);
        mMap.put(l, new Pair<>(str, str2));
    }

    public static void removeSpecTopicIconForFrs(Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, l) == null) || l.longValue() <= 0) {
            return;
        }
        mMap.remove(l);
    }

    public static void setSpecTopicIcon(long j, ThreadData threadData) {
        Pair<String, String> pair;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65543, null, j, threadData) == null) || (pair = mMap.get(Long.valueOf(j))) == null) {
            return;
        }
        threadData.setFid(j);
        threadData.setSpecUrl((String) pair.first, (String) pair.second);
    }
}
