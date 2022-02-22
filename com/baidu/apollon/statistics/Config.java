package com.baidu.apollon.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class Config {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TYPE_NORMAL = "normal_log";
    public static final String a = "wallet_stastics";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f32878b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final int f32879c = 204800;

    /* renamed from: d  reason: collision with root package name */
    public static final int f32880d = 51200;

    /* renamed from: e  reason: collision with root package name */
    public static final long f32881e = 604800000;

    /* renamed from: f  reason: collision with root package name */
    public static final long f32882f = 86400000;

    /* renamed from: g  reason: collision with root package name */
    public static final String f32883g = "publish_data";

    /* renamed from: h  reason: collision with root package name */
    public static final String f32884h = "sign";

    /* renamed from: i  reason: collision with root package name */
    public static final String f32885i = "mk";

    /* renamed from: j  reason: collision with root package name */
    public static final String f32886j = "array";
    public static final String k = "exception";
    public static final String l = "dim_excep_time";
    public static final String m = "dim_excep_owner";
    public static final String n = "dim_excep_key";
    public static final String o = "dim_excep_cont";
    public static final String p = "dim_excep_type";
    public static final String q = "dim_excep_line_way";
    public static final String r = "dim_excep_free_mem";
    public static final String s = "dim_excep_total_mem";
    public static final int t = 30000;
    public static final int u = 5000;
    public static final String v = "befe5b2c729481d3a0dea6748aaa7d98.json";
    public static final String w = "customer_svc_log";
    public static final boolean x = false;
    public transient /* synthetic */ FieldHolder $fh;

    public Config() {
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
