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

    /* renamed from: a  reason: collision with root package name */
    public int f10297a;

    /* renamed from: b  reason: collision with root package name */
    public int f10298b;

    /* renamed from: c  reason: collision with root package name */
    public String f10299c;

    /* renamed from: d  reason: collision with root package name */
    public String f10300d;

    /* renamed from: e  reason: collision with root package name */
    public String f10301e;

    /* renamed from: f  reason: collision with root package name */
    public int f10302f;

    /* renamed from: g  reason: collision with root package name */
    public int f10303g;

    /* renamed from: h  reason: collision with root package name */
    public int f10304h;

    /* renamed from: i  reason: collision with root package name */
    public int f10305i;
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
