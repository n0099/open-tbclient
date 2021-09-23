package com.baidu.sofire.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public final class b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f45330a;

    /* renamed from: b  reason: collision with root package name */
    public int f45331b;

    /* renamed from: c  reason: collision with root package name */
    public String f45332c;

    /* renamed from: d  reason: collision with root package name */
    public String f45333d;

    /* renamed from: e  reason: collision with root package name */
    public String f45334e;

    /* renamed from: f  reason: collision with root package name */
    public int f45335f;

    /* renamed from: g  reason: collision with root package name */
    public int f45336g;

    /* renamed from: h  reason: collision with root package name */
    public int f45337h;

    /* renamed from: i  reason: collision with root package name */
    public int f45338i;

    /* renamed from: j  reason: collision with root package name */
    public String f45339j;
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
