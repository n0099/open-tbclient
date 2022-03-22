package c.a.n0.a.e2.h;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.o1.b.g;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static AshmemFileDescriptor a(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", str);
            bundle.putInt("size", i);
            g c2 = c.a.n0.a.o1.b.e.c(a.class, bundle);
            if (c2.a()) {
                c2.a.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
                return (AshmemFileDescriptor) c2.a.getParcelable("result");
            }
            return null;
        }
        return (AshmemFileDescriptor) invokeLI.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            String string = bundle.getString("name", null);
            int i = bundle.getInt("size", 0);
            Bundle bundle2 = new Bundle();
            bundle2.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
            bundle2.putParcelable("result", f.a(string, i));
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }
}
