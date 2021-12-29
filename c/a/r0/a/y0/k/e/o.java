package c.a.r0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends c.a.r0.a.y0.a<c.a.r0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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

    @Override // c.a.r0.a.y0.a
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setDataSource" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull c.a.r0.a.y0.k.g.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, aVar) == null) || (obj = command.obj) == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        boolean z = command.arg1 != 0;
        String str = (String) arrayList.get(0);
        String f2 = c.a.r0.a.p2.b.l().f(str, (String) arrayList.get(1));
        command.ret = aVar.O(str, f2, (String) arrayList.get(2), z) ? 1 : 0;
        String str2 = command.what;
        d(aVar, str2, "DataSource: " + str + " ;UserAgent: " + ((String) arrayList.get(2)) + " ;Cookies: " + f2 + ";hideUrlLog: " + z, true);
    }
}
