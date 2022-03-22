package c.a.n0.a.x.u;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.e0.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.n0.a.e0.d.b> f7473d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("combine");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7473d = new ArrayList();
    }

    @Override // c.a.n0.a.e0.d.b
    public String c(c.a.n0.a.x.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null || this.f7473d.size() <= 0) {
                return null;
            }
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (c.a.n0.a.e0.d.b bVar : this.f7473d) {
                sb.append(bVar.d("event" + i, aVar));
                i++;
            }
            if (c.a.n0.a.e0.d.b.f4226b) {
                Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.n0.a.e0.d.b
    public void h(c.a.n0.a.x.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null || aVar.isWebView() || this.f7473d.size() <= 0) {
            return;
        }
        if (c.a.n0.a.e0.d.b.f4226b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        for (c.a.n0.a.e0.d.b bVar : this.f7473d) {
            JSEvent e2 = bVar.e(aVar);
            if (e2 != null) {
                j(aVar, e2);
                if (c.a.n0.a.e0.d.b.f4226b) {
                    Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e2.type + " on v8 : " + e2.data);
                }
            }
        }
    }

    public c t(c.a.n0.a.e0.d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (bVar != null && !this.f7473d.contains(bVar)) {
                this.f7473d.add(bVar);
            }
            return this;
        }
        return (c) invokeL.objValue;
    }
}
