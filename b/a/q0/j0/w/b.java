package b.a.q0.j0.w;

import b.a.e.k.i;
import b.a.e.k.j;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.mutiprocess.soloader.SoLoaderEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class b implements b.a.q0.j0.b<SoLoaderEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.q0.j0.b
    /* renamed from: a */
    public boolean onEvent(SoLoaderEvent soLoaderEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, soLoaderEvent)) == null) {
            if (soLoaderEvent == null || StringUtils.isNull(soLoaderEvent.name)) {
                return false;
            }
            if (j.a(BdBaseApplication.getInst().getContext(), i.a(soLoaderEvent.name))) {
                ConcurrentHashMap<String, String> resHashMap = BdBaseApplication.getInst().getResHashMap();
                String str = soLoaderEvent.name;
                resHashMap.put(str, i.a(str));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
