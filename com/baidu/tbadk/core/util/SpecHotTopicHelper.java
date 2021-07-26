package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.l.c;
import d.a.d.e.l.d;
import d.a.d.e.m.e;
import d.a.d.k.d.a;
import d.a.p0.s.f0.l;
import d.a.p0.s.q.b2;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SpecHotTopicHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Long, Pair<String, String>> mMap;
    public static c mResourceCallback;
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
        mResourceCallback = new c<a>() { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.d.e.l.c
            public void onLoaded(a aVar, String str, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, aVar, str, i2) == null) {
                    super.onLoaded((AnonymousClass2) aVar, str, i2);
                    if (aVar != null) {
                        d.a.p0.b0.c.k().a(str, aVar.p());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addSpecTopic(b2 b2Var, SpannableString spannableString, String str, int i2) {
        a loadBdImageFromLocal;
        a loadBdImageFromLocal2;
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65539, null, b2Var, spannableString, str, i2) == null) || b2Var == null || spannableString == null || StringUtils.isNull(str)) {
            return;
        }
        String t0 = b2Var.t0();
        String T0 = b2Var.T0();
        if (StringUtils.isNull(t0) || StringUtils.isNull(T0)) {
            return;
        }
        Bitmap j = d.a.p0.b0.c.k().j(t0);
        if ((j == null || !AbstractImageLoaderProc.isImageFileExist(t0, 10)) && (loadBdImageFromLocal = AbstractImageLoaderProc.loadBdImageFromLocal(t0, 10)) != null) {
            j = loadBdImageFromLocal.p();
            d.a.p0.b0.c.k().a(t0, j);
        }
        Bitmap j2 = d.a.p0.b0.c.k().j(T0);
        if ((j2 == null || !AbstractImageLoaderProc.isImageFileExist(T0, 10)) && (loadBdImageFromLocal2 = AbstractImageLoaderProc.loadBdImageFromLocal(T0, 10)) != null) {
            j2 = loadBdImageFromLocal2.p();
            d.a.p0.b0.c.k().a(T0, j2);
        }
        if (j != null && !j.isRecycled() && j2 != null && !j2.isRecycled()) {
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                if (str.charAt(i4) == '#') {
                    if (i3 % 2 == 0) {
                        bitmapDrawable = new BitmapDrawable(j);
                        bitmapDrawable.setBounds(0, 0, j.getWidth(), j.getHeight());
                    } else {
                        bitmapDrawable = new BitmapDrawable(j2);
                        bitmapDrawable.setBounds(0, 0, j2.getWidth(), j2.getHeight());
                    }
                    l lVar = new l(bitmapDrawable);
                    lVar.b(d.a.d.e.p.l.e(TbadkCoreApplication.getInst(), b2Var.p));
                    int i5 = i2 + i4;
                    spannableString.setSpan(lVar, i5, i5 + 1, 33);
                    i3++;
                }
            }
            return;
        }
        loadSpecTopicIconIfNeed(t0, T0);
    }

    public static void loadSpecTopicIconIfNeed(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            Bitmap j = d.a.p0.b0.c.k().j(str);
            Bitmap j2 = d.a.p0.b0.c.k().j(str2);
            if (j == null || j2 == null) {
                if (!d.a.d.e.p.l.C()) {
                    e.a().post(new Runnable(str, str2) { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.1
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
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
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
                                d.h().m(this.val$left, 10, SpecHotTopicHelper.mResourceCallback, null);
                                d.h().m(this.val$right, 10, SpecHotTopicHelper.mResourceCallback, null);
                            }
                        }
                    });
                    return;
                }
                d.h().m(str, 10, mResourceCallback, null);
                d.h().m(str2, 10, mResourceCallback, null);
            }
        }
    }

    public static void putSpecialTopicIcon(Long l, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, l, str, str2) == null) || l == null || l.intValue() <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        loadSpecTopicIconIfNeed(str, str2);
        mMap.put(l, new Pair<>(str, str2));
    }

    public static void removeSpecTopicIconForFrs(Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, l) == null) || l.longValue() <= 0) {
            return;
        }
        mMap.remove(l);
    }

    public static void setSpecTopicIcon(long j, b2 b2Var) {
        Pair<String, String> pair;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65543, null, j, b2Var) == null) || (pair = mMap.get(Long.valueOf(j))) == null) {
            return;
        }
        b2Var.o3(j);
        b2Var.d4((String) pair.first, (String) pair.second);
    }
}
