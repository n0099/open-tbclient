package com.baidu.pass.biometrics.face.liveness.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static final int f38206h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f38207i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f38208j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f38209k = 3;
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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38210b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38211c;

    /* renamed from: d  reason: collision with root package name */
    public long f38212d;

    /* renamed from: e  reason: collision with root package name */
    public long f38213e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38214f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38215g;

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
        this.a = 0;
        this.f38210b = false;
        this.f38211c = false;
        this.f38213e = 20000L;
        this.f38214f = false;
        this.f38215g = false;
    }
}
