package com.baidu.pass.biometrics.face.liveness.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static final int f37826h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f37827i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f37828j = 2;
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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37829b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37830c;

    /* renamed from: d  reason: collision with root package name */
    public long f37831d;

    /* renamed from: e  reason: collision with root package name */
    public long f37832e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37833f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37834g;

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
        this.f37829b = false;
        this.f37830c = false;
        this.f37832e = 20000L;
        this.f37833f = false;
        this.f37834g = false;
    }
}
