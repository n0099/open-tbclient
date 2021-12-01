package c.a.q0.v0;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e extends c.a.d.c.f.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.c.f.g
    /* renamed from: c */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpResponsedMessage)) == null) {
            if ((httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001536) && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                ReloginManager g2 = ReloginManager.g();
                if (((JsonHttpResponsedMessage) httpResponsedMessage).getError() == 1) {
                    if (httpMessage.removeParam("reloin_key") == null) {
                        httpMessage.addParam("reloin_key", "reloin_value");
                        g2.l((HttpMessage) httpResponsedMessage.getOrginalMessage());
                    } else {
                        g2.f(null);
                    }
                    return null;
                }
            }
            return httpResponsedMessage;
        }
        return (HttpResponsedMessage) invokeL.objValue;
    }
}
