package b.a.r0.l2.c;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pbextra.praise.PraiseListResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f22018a;

    /* renamed from: b  reason: collision with root package name */
    public String f22019b;

    /* renamed from: c  reason: collision with root package name */
    public String f22020c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22021d;

    /* renamed from: e  reason: collision with root package name */
    public int f22022e;

    /* renamed from: f  reason: collision with root package name */
    public int f22023f;

    /* renamed from: g  reason: collision with root package name */
    public int f22024g;

    /* renamed from: h  reason: collision with root package name */
    public final List<b.a.r0.l2.c.a> f22025h;

    /* renamed from: i  reason: collision with root package name */
    public b f22026i;
    public final HttpMessageListener j;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22027a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f22027a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (this.f22027a.f22026i != null) {
                        this.f22027a.f22026i.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (this.f22027a.f22026i != null) {
                        this.f22027a.f22026i.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (this.f22027a.f22026i != null) {
                            this.f22027a.f22026i.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<b.a.r0.l2.c.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (b.a.r0.l2.c.a aVar : list) {
                            this.f22027a.f22025h.add(aVar);
                        }
                    }
                    d dVar = this.f22027a;
                    dVar.f22024g = dVar.f22025h.size();
                    this.f22027a.f22023f = praiseListResponsedMessage.getTotalNum();
                    d.h(this.f22027a);
                    int i2 = this.f22027a.f22022e > 5 ? 1003 : 1001;
                    if (this.f22027a.f22024g >= this.f22027a.f22023f) {
                        i2 = 1002;
                    }
                    if (this.f22027a.f22026i != null) {
                        this.f22027a.f22026i.onLoadSuccessed(this.f22027a.f22023f, this.f22027a.f22025h, i2, this.f22027a.f22023f - this.f22027a.f22024g);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onLoadFailed(String str);

        void onLoadSuccessed(int i2, List<b.a.r0.l2.c.a> list, int i3, int i4);
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
        this.f22018a = "";
        this.f22019b = "";
        this.f22020c = "";
        this.f22021d = true;
        this.f22022e = 1;
        this.f22023f = 0;
        this.f22024g = 0;
        this.f22025h = new ArrayList(100);
        this.f22026i = null;
        this.j = new a(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.f22018a = "";
        this.f22019b = "";
    }

    public static /* synthetic */ int h(d dVar) {
        int i2 = dVar.f22022e;
        dVar.f22022e = i2 + 1;
        return i2;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22020c : (String) invokeV.objValue;
    }

    public b.a.r0.l2.c.a j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 <= -1 || i2 >= this.f22025h.size()) {
                return null;
            }
            return this.f22025h.get(i2);
        }
        return (b.a.r0.l2.c.a) invokeI.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22018a : (String) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22021d : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
            httpMessage.addParam("post_id", this.f22019b + "");
            httpMessage.addParam(SuggestAddrField.KEY_PAGE_NUM, this.f22022e + "");
            httpMessage.addParam("res_num", "20");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void o(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, str) == null) {
            bundle.putBoolean(str, this.f22021d);
        }
    }

    public void p(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bundle, str) == null) {
            bundle.putString(str, this.f22020c);
        }
    }

    public void q(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, str) == null) {
            bundle.putString(str, this.f22019b);
        }
    }

    public void r(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bundle, str) == null) {
            bundle.putInt(str, this.f22023f);
        }
    }

    public void s(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bundle, str) == null) {
            bundle.putString(str, this.f22018a);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f22023f = i2;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.unRegisterListener(this.j);
            messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
            messageManager.unRegisterTask(309326);
        }
    }

    public d(String str, String str2, String str3, boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Boolean.valueOf(z), bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22018a = "";
        this.f22019b = "";
        this.f22020c = "";
        this.f22021d = true;
        this.f22022e = 1;
        this.f22023f = 0;
        this.f22024g = 0;
        this.f22025h = new ArrayList(100);
        this.f22026i = null;
        this.j = new a(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.f22018a = str;
        this.f22019b = str2;
        this.f22020c = str3;
        this.f22026i = bVar;
        this.f22021d = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.j);
    }
}
