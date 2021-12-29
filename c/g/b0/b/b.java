package c.g.b0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Ssp.Pid pid) {
        super(pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Ssp.Pid) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.BaseAdRipper
    public RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            try {
                if (obj instanceof NativeUnifiedADDataAdapter) {
                    NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = (NativeUnifiedADDataAdapter) obj;
                    Field declaredField2 = nativeUnifiedADDataAdapter.getClass().getDeclaredField("a");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(nativeUnifiedADDataAdapter);
                    if (obj2 == null) {
                        return null;
                    }
                    Field declaredField3 = obj2.getClass().getDeclaredField("d");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 == null || (declaredField = obj3.getClass().getSuperclass().getDeclaredField("L")) == null) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                    Object obj4 = declaredField.get(obj3);
                    if (obj4 instanceof JSONObject) {
                        return g.a((JSONObject) obj4);
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                LogPrinter.e(e2);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
