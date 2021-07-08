package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class JNIFavorite {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JNIFavorite() {
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

    public native boolean Add(long j, String str, String str2);

    public native boolean Clear(long j);

    public native long Create();

    public native int GetAll(long j, Bundle bundle);

    public native String GetValue(long j, String str);

    public native boolean IsExist(long j, String str);

    public native boolean Load(long j, String str, String str2, String str3, int i2, int i3, int i4);

    public native int Release(long j);

    public native boolean Remove(long j, String str);

    public native boolean SaveCache(long j);

    public native boolean SetType(long j, int i2);

    public native boolean Update(long j, String str, String str2);
}
