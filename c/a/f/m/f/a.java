package c.a.f.m.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f3319a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3320b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f3321c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f3322d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f3323e;

    /* renamed from: c.a.f.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0069a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f3324a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0069a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f3324a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f3324a.f3320b = false;
                VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
                this.f3324a.f3322d = videoPasterResponseData;
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                    return;
                }
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (this.f3324a.f3319a != null) {
                        this.f3324a.f3319a.b(videoPasterResponseData.getPasterData());
                    }
                } else if (this.f3324a.f3319a != null) {
                    this.f3324a.f3319a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2, String str);

        void b(c.a.f.m.e.a aVar);
    }

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
                return;
            }
        }
        this.f3323e = new C0069a(this, CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        this.f3321c = BdUniqueId.gen();
        this.f3323e.setSelfListener(true);
        this.f3323e.setTag(this.f3321c);
        MessageManager.getInstance().registerListener(this.f3323e);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f3321c == null) {
            return;
        }
        MessageManager.getInstance().removeMessage(this.f3321c);
    }

    public VideoPasterResponseData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3322d : (VideoPasterResponseData) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3320b : invokeV.booleanValue;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoPasterRequestData) == null) || videoPasterRequestData == null) {
            return;
        }
        this.f3320b = true;
        videoPasterRequestData.setTag(this.f3321c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f3323e != null) {
                MessageManager.getInstance().unRegisterListener(this.f3323e);
            }
            if (this.f3319a != null) {
                this.f3319a = null;
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d();
            this.f3320b = false;
            this.f3322d = null;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f3319a = bVar;
        }
    }
}
