package c.a.e1.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.yunjiasu.tornadosdk.Pinger;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ a f3616e = new a();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ a() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) ? Pinger.m107pingHandler$lambda0(message) : invokeL.booleanValue;
    }
}
