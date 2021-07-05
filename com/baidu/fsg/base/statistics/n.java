package com.baidu.fsg.base.statistics;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class n implements r.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5330a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h[] f5331b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f5332c;

    public n(l lVar, String str, h[] hVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, str, hVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5332c = lVar;
        this.f5330a = str;
        this.f5331b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogUtil.d(l.f5324a, "====send-success==");
            if (b.o.equals(this.f5330a)) {
                f.a().a(this.f5330a);
            } else {
                i.a(RimStatisticsUtil.getAppContext()).a(this.f5331b);
            }
        }
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogUtil.d(l.f5324a, "====send-fail=====");
        }
    }
}
