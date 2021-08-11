package com.baidu.android.pushservice.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36749a;

    /* renamed from: b  reason: collision with root package name */
    public String f36750b;

    /* renamed from: c  reason: collision with root package name */
    public String f36751c;

    /* renamed from: d  reason: collision with root package name */
    public String f36752d;

    /* renamed from: e  reason: collision with root package name */
    public long f36753e;

    /* renamed from: f  reason: collision with root package name */
    public long f36754f;

    /* renamed from: g  reason: collision with root package name */
    public long f36755g;

    /* renamed from: h  reason: collision with root package name */
    public String f36756h;

    /* renamed from: i  reason: collision with root package name */
    public long f36757i;

    public d() {
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
