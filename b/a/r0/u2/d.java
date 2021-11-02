package b.a.r0.u2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.tieba.postsearch.PostSearchHttpResponseMessage;
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
    public PostSearchActivity f24070a;

    /* renamed from: b  reason: collision with root package name */
    public String f24071b;

    /* renamed from: c  reason: collision with root package name */
    public String f24072c;

    /* renamed from: d  reason: collision with root package name */
    public int f24073d;

    /* renamed from: e  reason: collision with root package name */
    public int f24074e;

    /* renamed from: f  reason: collision with root package name */
    public int f24075f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24076g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24077h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24078i;
    public ArrayList<String> j;
    public int k;
    public final HttpMessageListener l;
    public CustomMessageListener m;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24079a;

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
            this.f24079a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                    HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                    int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                    this.f24079a.p(intValue);
                    boolean z = this.f24079a.i(intValue) > 1;
                    PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                    if (statusCode == 200 && error == 0) {
                        this.f24079a.f24070a.refreshResultListByTab(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                        this.f24079a.f(intValue);
                        this.f24079a.r();
                        this.f24079a.s();
                        return;
                    }
                    String errorString = postSearchHttpResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f24079a.f24070a.getResources().getString(R.string.neterror);
                    }
                    this.f24079a.f24070a.showToast(errorString);
                    this.f24079a.f24070a.refreshResultListByTab(intValue, null, z);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24080a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
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
            this.f24080a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (data = customResponsedMessage.getData()) == null || !(data instanceof ArrayList)) {
                return;
            }
            d dVar = this.f24080a;
            dVar.j = (ArrayList) data;
            dVar.f24070a.refreshHistoryList();
        }
    }

    public d(PostSearchActivity postSearchActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24073d = 1;
        this.f24074e = 1;
        this.f24075f = 1;
        this.f24076g = false;
        this.f24077h = false;
        this.f24078i = false;
        this.k = 0;
        this.l = new a(this, CmdConfigHttp.CMD_POST_SEARCH);
        b bVar = new b(this, 2009001);
        this.m = bVar;
        this.f24070a = postSearchActivity;
        postSearchActivity.registerListener(bVar);
        this.f24070a.registerListener(this.l);
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 1) {
                this.f24073d++;
            } else if (i2 == 2) {
                this.f24074e++;
            } else if (i2 != 3) {
            } else {
                this.f24075f++;
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList<String> arrayList = this.j;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.f24070a.sendMessage(new CustomMessage(2009004));
        }
    }

    public final HttpMessage h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
            httpMessage.addParam("word", this.f24071b);
            httpMessage.addParam("rn", 30);
            httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.f24070a.mForumName);
            httpMessage.setExtra(Integer.valueOf(this.k));
            if (i2 == 1) {
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.f24073d);
            } else if (i2 == 2) {
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.f24074e);
            } else if (i2 == 3) {
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.f24075f);
            }
            return httpMessage;
        }
        return (HttpMessage) invokeI.objValue;
    }

    public final int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return 0;
                    }
                    return this.f24075f;
                }
                return this.f24074e;
            }
            return this.f24073d;
        }
        return invokeI.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f24070a.sendMessage(new CustomMessage(2009001));
        }
    }

    public final void k(List<String> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null || list.size() - 5 <= 0) {
            return;
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.remove((size2 - i2) - 1);
        }
    }

    public boolean l(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            if (!str.equals(this.f24071b)) {
                q();
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return m(str);
                }
                return n(str);
            }
            return o(str);
        }
        return invokeLI.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.f24078i) {
                return false;
            }
            this.f24071b = str;
            this.k = 3;
            this.f24070a.sendMessage(h(3));
            this.f24078i = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.f24077h) {
                return false;
            }
            this.f24071b = str;
            this.k = 2;
            this.f24070a.sendMessage(h(2));
            this.f24077h = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (this.f24076g) {
                return false;
            }
            this.f24071b = str;
            this.k = 1;
            this.f24070a.sendMessage(h(1));
            this.f24076g = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 == 1) {
                this.f24076g = false;
            } else if (i2 == 2) {
                this.f24077h = false;
            } else if (i2 != 3) {
            } else {
                this.f24078i = false;
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24073d = 1;
            this.f24074e = 1;
            this.f24075f = 1;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || StringUtils.isNull(this.f24071b) || this.f24071b.equals(this.f24072c)) {
            return;
        }
        this.f24070a.sendMessage(new CustomMessage(2009003, this.f24071b));
        this.f24072c = this.f24071b;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            this.j.remove(this.f24071b);
            this.j.add(0, this.f24071b);
            k(this.j);
        }
    }
}
