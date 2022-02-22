package c.a.d.i.g;

import android.content.pm.Signature;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.nps.interfa.ISignatureVerifier;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class b implements ISignatureVerifier {
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

    @Override // com.baidu.nps.interfa.ISignatureVerifier
    public boolean checkSignature(String str, Signature[] signatureArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, signatureArr)) == null) {
            if (BdLog.isDebugMode()) {
                return true;
            }
            String c2 = a.c(signatureArr);
            BdLog.e("new signature: " + c2);
            return "YvigAa51R7YgCp8eDveR1g==".equals(c2);
        }
        return invokeLL.booleanValue;
    }
}
