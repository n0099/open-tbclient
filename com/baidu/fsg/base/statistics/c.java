package com.baidu.fsg.base.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39534a = "dim_excep_time";

    /* renamed from: b  reason: collision with root package name */
    public static final String f39535b = "dim_excep_cont";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39536c = "dim_excep_type";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39537d = "dim_excep_line_way";

    /* renamed from: e  reason: collision with root package name */
    public static final String f39538e = "dim_excep_free_mem";

    /* renamed from: f  reason: collision with root package name */
    public static final String f39539f = "dim_excep_total_mem";
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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
