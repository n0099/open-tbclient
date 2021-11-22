package b.a.q0.c1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static c f12756c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.q0.t.c.a f12757a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f12758b;

    public c() {
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

    public static c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f12756c == null) {
                synchronized (c.class) {
                    if (f12756c == null) {
                        f12756c = new c();
                    }
                }
            }
            return f12756c;
        }
        return (c) invokeV.objValue;
    }

    public final void a(b.a.q0.t.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            boolean z = aVar == null || this.f12757a == null || aVar.a() != this.f12757a.a();
            this.f12757a = aVar;
            if (z) {
                b("zan_or_cai_smallflow");
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f12758b == null) {
                ABTestExtraData aBTestExtraData = new ABTestExtraData();
                this.f12758b = aBTestExtraData;
                aBTestExtraData.parserABTestExtraFormSharedPref();
            }
            return this.f12758b.getABTestResult();
        }
        return (String) invokeV.objValue;
    }

    public void e(b.a.q0.t.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            a(aVar);
        }
    }

    public void f(ABTestExtraData aBTestExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aBTestExtraData) == null) {
            this.f12758b = aBTestExtraData;
        }
    }
}
