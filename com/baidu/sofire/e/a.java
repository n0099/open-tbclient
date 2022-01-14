package com.baidu.sofire.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f38430b;

    /* renamed from: c  reason: collision with root package name */
    public int f38431c;

    /* renamed from: d  reason: collision with root package name */
    public String f38432d;

    /* renamed from: e  reason: collision with root package name */
    public long f38433e;

    /* renamed from: f  reason: collision with root package name */
    public int f38434f;

    /* renamed from: g  reason: collision with root package name */
    public int f38435g;

    /* renamed from: h  reason: collision with root package name */
    public int f38436h;

    /* renamed from: i  reason: collision with root package name */
    public int f38437i;

    /* renamed from: j  reason: collision with root package name */
    public String f38438j;

    public a() {
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
