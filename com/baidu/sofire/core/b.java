package com.baidu.sofire.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public final class b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f37033b;

    /* renamed from: c  reason: collision with root package name */
    public String f37034c;

    /* renamed from: d  reason: collision with root package name */
    public String f37035d;

    /* renamed from: e  reason: collision with root package name */
    public String f37036e;

    /* renamed from: f  reason: collision with root package name */
    public int f37037f;

    /* renamed from: g  reason: collision with root package name */
    public int f37038g;

    /* renamed from: h  reason: collision with root package name */
    public int f37039h;

    /* renamed from: i  reason: collision with root package name */
    public int f37040i;

    /* renamed from: j  reason: collision with root package name */
    public String f37041j;
    public String k;
    public int l;
    public String m;

    public b() {
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
