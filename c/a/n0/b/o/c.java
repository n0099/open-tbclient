package c.a.n0.b.o;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
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

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            int i2 = bundle.getInt("type");
            b bVar = new b();
            String string = bundle.getString("param1");
            Bundle bundle2 = new Bundle();
            if (i2 == 1) {
                bundle2.putBoolean("result", bVar.shouldAcceptCookie(string, bundle.getString("param2")));
                return bundle2;
            } else if (i2 == 2) {
                bundle2.putBoolean("result", bVar.shouldSendCookie(string, bundle.getString("param2")));
                return bundle2;
            } else if (i2 == 3) {
                bVar.storeCookie(string, bundle.getStringArrayList("param2"));
                return bundle2;
            } else if (i2 != 4) {
                return bundle2;
            } else {
                bundle2.putString("result", bVar.getCookie(string));
                return bundle2;
            }
        }
        return (Bundle) invokeL.objValue;
    }
}
