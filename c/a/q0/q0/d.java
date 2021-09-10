package c.a.q0.q0;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, boolean z, ResponsedMessage<?> responsedMessage, long j2, long j3, long j4, boolean z2, long j5) {
        super(i2, z, responsedMessage, j2, j3, j4, z2, 0L, 0L, j5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z2), Long.valueOf(j5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (ResponsedMessage) objArr2[2], ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), ((Long) objArr2[5]).longValue(), ((Boolean) objArr2[6]).booleanValue(), ((Long) objArr2[7]).longValue(), ((Long) objArr2[8]).longValue(), ((Long) objArr2[9]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.F = 0;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = 0;
    }
}
