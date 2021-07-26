package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.util.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1854a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1855b;

    public b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1854a = context;
        this.f1855b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d dVar = new d();
            try {
                String b2 = j.b(this.f1854a, a.f1852a, null);
                if (!TextUtils.isEmpty(b2) && dVar.a(this.f1854a, b2) != null) {
                    j.b(this.f1854a, a.f1852a);
                }
            } catch (Throwable unused) {
            }
            try {
                if (TextUtils.isEmpty(this.f1855b)) {
                    return;
                }
                dVar.a(this.f1854a, this.f1855b);
            } catch (IOException unused2) {
                j.a(this.f1854a, a.f1852a, this.f1855b);
            } catch (Throwable unused3) {
            }
        }
    }
}
