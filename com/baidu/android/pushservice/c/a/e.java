package com.baidu.android.pushservice.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f37035a;

    /* renamed from: b  reason: collision with root package name */
    public String f37036b;

    /* renamed from: c  reason: collision with root package name */
    public long f37037c;

    /* renamed from: d  reason: collision with root package name */
    public long f37038d;

    /* renamed from: e  reason: collision with root package name */
    public long f37039e;

    /* renamed from: f  reason: collision with root package name */
    public String f37040f;

    /* renamed from: g  reason: collision with root package name */
    public long f37041g;

    public e() {
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
}
