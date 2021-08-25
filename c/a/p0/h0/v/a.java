package c.a.p0.h0.v;

import c.a.p0.b.c;
import c.a.p0.h0.b;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements b<SyncDataEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: a */
    public boolean onEvent(SyncDataEvent syncDataEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, syncDataEvent)) == null) {
            if (syncDataEvent == null) {
                return false;
            }
            TbSingleton.getInstance().setSampleId(syncDataEvent.sampleId);
            c.a.p0.b1.a.d().f(syncDataEvent.abtestExtraData);
            c.d().i(syncDataEvent.ubsABTest);
            return true;
        }
        return invokeL.booleanValue;
    }
}
