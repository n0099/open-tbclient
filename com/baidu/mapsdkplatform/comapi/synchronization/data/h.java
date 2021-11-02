package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.mapsdkplatform.comapi.synchronization.data.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
/* loaded from: classes7.dex */
public class h extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f40324a;

    public h(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40324a = gVar;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            bVar = this.f40324a.j;
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.what = CustomerServiceMenu.TRANSFER_RECORD;
            obtainMessage.obj = aVar;
            bVar2 = this.f40324a.j;
            if (bVar2 != null) {
                bVar3 = this.f40324a.j;
                bVar3.sendMessage(obtainMessage);
            }
            if (c.a.f40257e == aVar || c.a.f40254b == aVar || c.a.f40255c == aVar) {
                g.b(this.f40324a);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            bVar = this.f40324a.j;
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.what = 100000;
            obtainMessage.obj = str;
            bVar2 = this.f40324a.j;
            if (bVar2 != null) {
                bVar3 = this.f40324a.j;
                bVar3.sendMessage(obtainMessage);
            }
            this.f40324a.k = 0;
        }
    }
}
