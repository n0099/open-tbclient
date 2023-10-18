package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class ViewCompatDelegate implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "generateViewId";
    public static final AtomicInteger b;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final c c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-903234735, "Lcom/baidu/mobads/sdk/internal/concrete/ViewCompatDelegate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-903234735, "Lcom/baidu/mobads/sdk/internal/concrete/ViewCompatDelegate;");
                return;
            }
        }
        b = new AtomicInteger(DefaultOggSeeker.MATCH_BYTE_RANGE);
        d = ar.a((Class<?>) ViewCompat.class, a, (Class<?>[]) new Class[0]);
    }

    @SuppressLint({"NewApi"})
    public static int generateViewId() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d) {
                return ViewCompat.generateViewId();
            }
            if (bj.a((Context) null).a() >= 17) {
                return View.generateViewId();
            }
            do {
                i = b.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } while (!b.compareAndSet(i, i2));
            return i;
        }
        return invokeV.intValue;
    }

    public ViewCompatDelegate(@NonNull IAdInterListener iAdInterListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAdInterListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = c.a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getCode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c.getData();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.getDelegator();
        }
        return (IAdInterListener) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.getMessage();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c.getTarget();
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c.getType();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, objArr)) == null) {
            if (a.equals(str2)) {
                return Integer.valueOf(generateViewId());
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.c.setTarget(obj);
        }
    }
}
