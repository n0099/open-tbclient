package c.a.p0.a.w;

import android.os.Bundle;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.g1.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0514a implements d<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8182b;

        public C0514a(a aVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8182b = aVar;
            this.a = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.d
        /* renamed from: a */
        public Bundle create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8182b.b(this.a) : (Bundle) invokeV.objValue;
        }
    }

    public a() {
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

    public final Bundle b(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            int i2 = bundle.getInt("type");
            c cVar = new c();
            String string = bundle.getString("param1");
            Bundle bundle2 = new Bundle();
            if (i2 == 1) {
                bundle2.putBoolean("result", cVar.shouldAcceptCookie(string, bundle.getString("param2")));
                return bundle2;
            } else if (i2 == 2) {
                bundle2.putBoolean("result", cVar.shouldSendCookie(string, bundle.getString("param2")));
                return bundle2;
            } else if (i2 == 3) {
                cVar.storeCookie(string, bundle.getStringArrayList("param2"));
                return bundle2;
            } else if (i2 != 4) {
                return bundle2;
            } else {
                bundle2.putString("result", cVar.getCookie(string));
                return bundle2;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) ? (Bundle) c.a.p0.a.p2.g1.a.b(new C0514a(this, bundle)) : (Bundle) invokeL.objValue;
    }
}
