package com.baidu.android.pushservice.x;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public byte[] c;
    public byte[] d;
    public int e;
    public String f;
    public String g;
    public int h;
    public int i;
    public String j;

    public h(String str, String str2, byte[] bArr, byte[] bArr2, int i, String str3, String str4, int i2, int i3, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bArr, bArr2, Integer.valueOf(i), str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = bArr;
        this.d = bArr2;
        this.e = i;
        this.f = str3;
        this.g = str4;
        this.j = str5;
        this.i = i3;
        this.h = i2;
    }
}
