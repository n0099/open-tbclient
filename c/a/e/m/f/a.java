package c.a.e.m.f;

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
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3599b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f3600c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f3601d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f3602e;

    /* renamed from: c.a.e.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0142a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0142a(a aVar, int i2) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.f3599b = false;
                VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
                this.a.f3601d = videoPasterResponseData;
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                    return;
                }
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (this.a.a != null) {
                        this.a.a.b(videoPasterResponseData.getPasterData());
                    }
                } else if (this.a.a != null) {
                    this.a.a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2, String str);

        void b(c.a.e.m.e.a aVar);
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
        this.f3602e = new C0142a(this, CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        this.f3600c = BdUniqueId.gen();
        this.f3602e.setSelfListener(true);
        this.f3602e.setTag(this.f3600c);
        MessageManager.getInstance().registerListener(this.f3602e);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f3600c == null) {
            return;
        }
        MessageManager.getInstance().removeMessage(this.f3600c);
    }

    public VideoPasterResponseData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3601d : (VideoPasterResponseData) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3599b : invokeV.booleanValue;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoPasterRequestData) == null) || videoPasterRequestData == null) {
            return;
        }
        this.f3599b = true;
        videoPasterRequestData.setTag(this.f3600c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f3602e != null) {
                MessageManager.getInstance().unRegisterListener(this.f3602e);
            }
            if (this.a != null) {
                this.a = null;
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d();
            this.f3599b = false;
            this.f3601d = null;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.a = bVar;
        }
    }
}
