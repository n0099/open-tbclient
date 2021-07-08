package com.baidu.pass.biometrics.face.liveness.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static final int f9222h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f9223i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final int m = 5;
    public static final int n = 6;
    public static final int o = 7;
    public static final int p = 8;
    public static final int q = 9;
    public static final int r = 10;
    public static final int s = 11;
    public static final int t = 17;
    public static final int u = 18;
    public static final int v = 19;
    public static final int w = 20;
    public static final int x = 5000;
    public static final int y = 20000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f9224a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9225b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9226c;

    /* renamed from: d  reason: collision with root package name */
    public long f9227d;

    /* renamed from: e  reason: collision with root package name */
    public long f9228e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9229f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9230g;

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
                return;
            }
        }
        this.f9224a = 0;
        this.f9225b = false;
        this.f9226c = false;
        this.f9228e = 20000L;
        this.f9229f = false;
        this.f9230g = false;
    }
}
