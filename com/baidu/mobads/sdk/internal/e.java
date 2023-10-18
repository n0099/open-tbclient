package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public di a;
    public String b;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(int i, String str);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i);

        void a(List<NativeResponse> list);

        void b();

        void b(int i, String str);

        void b(NativeResponse nativeResponse);

        void c();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public e(Context context, a aVar, di diVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, diVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = diVar;
        diVar.a(aVar);
    }

    public e(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, entryAdListener, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        di diVar = new di(context, str, IAdInterListener.AdProdType.PRODUCT_SONES, z, i);
        this.a = diVar;
        diVar.a(entryAdListener);
    }

    public e(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, expressAdListener, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        di diVar = new di(context, str, "feed", z, i);
        this.a = diVar;
        diVar.a(expressAdListener);
        this.a.a(1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Context context, String str, a aVar, boolean z, int i) {
        this(context, aVar, new di(context, str, "feed", z, i));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, aVar, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (a) objArr2[1], (di) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public e(Context context, String str, a aVar, boolean z, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, aVar, Boolean.valueOf(z), Integer.valueOf(i), str2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.a = new di(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.a = new di(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z, i);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.a = new di(context, str, "video", z, i);
            } else {
                this.a = new di(context, str, "feed", z, i);
            }
        }
        this.a.a(aVar);
    }

    public String a(RequestParameters requestParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestParameters)) == null) {
            if (this.a != null) {
                if (requestParameters == null) {
                    requestParameters = new RequestParameters.Builder().build();
                }
                this.a.h(this.b);
                this.a.a(requestParameters);
                return this.a.m();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void a() {
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (diVar = this.a) != null) {
            diVar.e();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b((RequestParameters) null);
        }
    }

    public void a(int i) {
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (diVar = this.a) != null) {
            diVar.p = i;
        }
    }

    public void b(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, requestParameters) == null) {
            if (requestParameters == null) {
                requestParameters = new RequestParameters.Builder().build();
            }
            di diVar = this.a;
            if (diVar != null) {
                diVar.h(this.b);
            }
            this.a.a(requestParameters);
            this.a.a();
        }
    }

    public void a(b bVar) {
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && (diVar = this.a) != null) {
            diVar.a(bVar);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.b = str;
        }
    }

    public void a(String str) {
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (diVar = this.a) != null) {
            diVar.b(str);
        }
    }

    public void a(boolean z) {
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (diVar = this.a) != null) {
            diVar.c(z);
        }
    }
}
