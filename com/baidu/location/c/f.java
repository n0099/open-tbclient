package com.baidu.location.c;

import android.location.OnNmeaMessageListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f implements OnNmeaMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f41093a;

    public f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41093a = eVar;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) && this.f41093a.b(str)) {
            this.f41093a.a(str);
        }
    }
}
