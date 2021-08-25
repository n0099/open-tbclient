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
    public String f36855a;

    /* renamed from: b  reason: collision with root package name */
    public String f36856b;

    /* renamed from: c  reason: collision with root package name */
    public String f36857c;

    /* renamed from: d  reason: collision with root package name */
    public String f36858d;

    /* renamed from: e  reason: collision with root package name */
    public long f36859e;

    /* renamed from: f  reason: collision with root package name */
    public long f36860f;

    /* renamed from: g  reason: collision with root package name */
    public long f36861g;

    /* renamed from: h  reason: collision with root package name */
    public String f36862h;

    /* renamed from: i  reason: collision with root package name */
    public long f36863i;

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
