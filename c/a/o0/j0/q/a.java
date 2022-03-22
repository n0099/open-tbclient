package c.a.o0.j0.q;

import android.text.TextUtils;
import c.a.o0.j0.b;
import c.a.p0.h0.m;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements b<HistoryEvent> {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.j0.b
    /* renamed from: a */
    public boolean onEvent(HistoryEvent historyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, historyEvent)) == null) {
            if (historyEvent == null || TextUtils.isEmpty(historyEvent.tid)) {
                return false;
            }
            m.a(historyEvent.tid);
            return true;
        }
        return invokeL.booleanValue;
    }
}
