package com.baidu.fsg.base.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "wallet_stastics";

    /* renamed from: b  reason: collision with root package name */
    public static final int f33767b = 204800;

    /* renamed from: c  reason: collision with root package name */
    public static final int f33768c = 51200;

    /* renamed from: d  reason: collision with root package name */
    public static final int f33769d = 200;

    /* renamed from: e  reason: collision with root package name */
    public static final long f33770e = 604800000;

    /* renamed from: f  reason: collision with root package name */
    public static final long f33771f = 86400000;

    /* renamed from: g  reason: collision with root package name */
    public static final String f33772g = "publish_data";

    /* renamed from: h  reason: collision with root package name */
    public static final String f33773h = "sign";

    /* renamed from: i  reason: collision with root package name */
    public static final String f33774i = "mk";

    /* renamed from: j  reason: collision with root package name */
    public static final String f33775j = "array";
    public static final String k = "exception";
    public static final String l = "https://www.baifubao.com/chanpin_stat";
    public static final String m = "http://yf-wallet-rd-red-dc00.epc.baidu.com:8090/chanpin_stat";
    public static final String n = "QmFpZHVfRlNHX1JJTV9TREtfQ3Jhc2hfbG9nX1BhdGg=.json";
    public static final String o = "crash_log";
    public static final String p = "normal_log";
    public transient /* synthetic */ FieldHolder $fh;

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
