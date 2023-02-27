package com.baidu.android.pushservice.ach;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.manageach.components.BaseAchProvider;
import com.baidu.android.pushservice.z.c;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PushAchProvider extends BaseAchProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* loaded from: classes.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushAchProvider c;

        public a(PushAchProvider pushAchProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushAchProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pushAchProvider;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15913, this, null);
            }
        }
    }

    public PushAchProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = PushAchProvider.class.getName();
    }

    public static /* synthetic */ String a(PushAchProvider pushAchProvider) {
        return (String) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15916, null, pushAchProvider);
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, uri, contentValues, str, strArr)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15915, this, uri, contentValues, str, strArr) : invokeLLLL.intValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public int a(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15910, this, uri, str, strArr) : invokeLLL.intValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, uri, strArr, str, strArr2, str2)) == null) ? (Cursor) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15909, this, uri, strArr, str, strArr2, str2) : (Cursor) invokeLLLLL.objValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public Uri a(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) ? (Uri) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15912, this, uri, contentValues) : (Uri) invokeLL.objValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public String a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) ? (String) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15911, this, uri) : (String) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchProvider
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15906, this, null) : invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15905, this, null);
        }
    }
}
