package b.a.e0.s;

import android.os.Bundle;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e0.l.c f2698a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f2699b;

    /* renamed from: c  reason: collision with root package name */
    public PayChannelEntity f2700c;

    public a(b.a.e0.l.c cVar, Bundle bundle, PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bundle, payChannelEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2698a = cVar;
        this.f2699b = bundle;
        this.f2700c = payChannelEntity;
    }
}
