package c.a.r0.a.h0.o.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.r0.a.e0.d;
import c.a.r0.a.h0.o.g.f.h;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends c.a.r0.a.h0.o.g.f.a implements c.a.r0.a.h0.o.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.h0.o.g.c.b.a f6938b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, c.a.r0.a.h0.o.g.b.a aVar) {
        super(context, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.r0.a.h0.o.g.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6938b = new b();
    }

    @Override // c.a.r0.a.h0.o.g.f.h
    @SuppressLint({"BDThrowableCheck"})
    public WebResourceResponse a(@NonNull h.a aVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String d2 = aVar.d();
            if (!d(aVar)) {
                return aVar.b(d2, aVar.getRequestHeaders(), aVar.c());
            }
            if (c.a.r0.a.h0.o.g.d.a.a) {
                String str2 = "intercept file = " + d2;
            }
            String c2 = c(d2);
            if (TextUtils.isEmpty(c2)) {
                if (c.a.r0.a.h0.o.g.d.a.a) {
                    throw new IllegalArgumentException("file path can't be null, src = " + d2);
                }
                return null;
            }
            File file = new File(c2);
            if (file.exists() && file.isFile()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (c2.endsWith(FileHelper.FILE_CACHE_CSS)) {
                        str = "text/css";
                    } else {
                        str = c2.endsWith(".js") ? FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE : "text/plan";
                    }
                    return b(str, fileInputStream);
                } catch (Throwable th) {
                    if (c.a.r0.a.h0.o.g.d.a.a) {
                        Log.getStackTraceString(th);
                    }
                }
            }
            d.c("HybridIntercept", "file intercept error, src = " + d2);
            return null;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final WebResourceResponse b(String str, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, inputStream)) == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("Cache-Control", "max-age=86400");
            return new WebResourceResponse(true, str, "UTF-8", 200, NewBindCardEntry.BING_CARD_SUCCESS_MSG, hashMap, new BufferedInputStream(inputStream));
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.startsWith("interceptfile://") && str.length() > 16) {
                str = str.substring(16);
            }
            if (c.a.r0.a.h0.o.g.d.a.a) {
                String str2 = "file request url = " + str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public boolean d(@NonNull h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            if (aVar.c()) {
                return this.f6938b.a(aVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
