package c.a.r0.p;

import c.a.e.e.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f23221a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f23222b;

    /* renamed from: c  reason: collision with root package name */
    public c f23223c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23222b = arrayList;
        this.f23223c = cVar;
        this.f23221a = new HashMap<>();
    }

    public int a(String str, int i2) {
        InterceptResult invokeLI;
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (this.f23221a == null || k.isEmpty(str) || (arrayList = this.f23222b) == null || !arrayList.contains(Integer.valueOf(i2))) {
                return 0;
            }
            if (!this.f23221a.containsKey(str)) {
                b(str);
            }
            b bVar = this.f23221a.get(str);
            if (bVar == null) {
                return 0;
            }
            return bVar.a(i2);
        }
        return invokeLI.intValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f23221a == null || k.isEmpty(str) || this.f23223c == null) {
            return;
        }
        if (this.f23221a.containsKey(str)) {
            b bVar = this.f23221a.get(str);
            this.f23223c.b(this.f23222b, bVar);
            this.f23221a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f23223c.b(this.f23222b, bVar2);
        this.f23221a.put(str, bVar2);
    }
}
