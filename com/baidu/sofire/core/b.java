package com.baidu.sofire.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public final class b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f42974a;

    /* renamed from: b  reason: collision with root package name */
    public int f42975b;

    /* renamed from: c  reason: collision with root package name */
    public String f42976c;

    /* renamed from: d  reason: collision with root package name */
    public String f42977d;

    /* renamed from: e  reason: collision with root package name */
    public String f42978e;

    /* renamed from: f  reason: collision with root package name */
    public int f42979f;

    /* renamed from: g  reason: collision with root package name */
    public int f42980g;

    /* renamed from: h  reason: collision with root package name */
    public int f42981h;

    /* renamed from: i  reason: collision with root package name */
    public int f42982i;
    public String j;
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
