package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class i extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6381a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lBSAuthManager, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6381a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Hashtable hashtable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            a.a("handleMessage !!");
            String string = message.getData().getString("listenerKey");
            hashtable = LBSAuthManager.f6360f;
            LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) hashtable.get(string);
            a.a("handleMessage listener = " + lBSAuthManagerListener);
            if (lBSAuthManagerListener != null) {
                lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
            }
        }
    }
}
