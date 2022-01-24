package c.a.t0.d2.i;

import android.content.Intent;
import android.net.http.SslError;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.d1.j0;
import c.a.s0.d1.k0;
import c.a.s0.d1.n0;
import c.a.s0.d1.v0;
import c.a.s0.s.q.t0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchsuggestlist.SearchListNetMessage;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.SearchSug.DataRes;
/* loaded from: classes7.dex */
public class e implements c.a.t0.d2.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.d2.i.d f15934b;

    /* renamed from: c  reason: collision with root package name */
    public View f15935c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15936d;

    /* renamed from: e  reason: collision with root package name */
    public HotSearchInfoData f15937e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15938f;

    /* renamed from: g  reason: collision with root package name */
    public String f15939g;

    /* renamed from: h  reason: collision with root package name */
    public Stack<String> f15940h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.d2.i.c f15941i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f15942j;
    public final CustomMessageListener k;

    /* loaded from: classes7.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15943e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15943e = eVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                c.a.s0.s.c0.a.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
                if (!TbadkCoreApplication.isLogin() && str != null && j0.e(str) && j0.a()) {
                    t0 t0Var = new t0(this.f15943e.a, "sousuo_dianji");
                    t0Var.k(str);
                    DialogLoginHelper.checkUpIsLogin(t0Var);
                    return true;
                } else if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f15943e.a.getPageContext(), new String[]{str}) != 3) {
                    return true;
                } else {
                    if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                        Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(this.f15943e.a.getApplicationContext(), str);
                        if (parseIntentFromUrl != null) {
                            try {
                                ArrayList<String> arrayList = (ArrayList) this.f15943e.a.getCurrentPageSourceKeyList();
                                String currentPageKey = this.f15943e.a.getCurrentPageKey();
                                if (arrayList != null && !StringUtils.isNull(currentPageKey) && !arrayList.contains(currentPageKey)) {
                                    arrayList.add(currentPageKey);
                                }
                                if (!ListUtils.isEmpty(arrayList)) {
                                    parseIntentFromUrl.putStringArrayListExtra("obj_source", arrayList);
                                }
                                this.f15943e.a.startActivity(parseIntentFromUrl);
                            } catch (Throwable th) {
                                BdLog.detailException(th);
                            }
                            return true;
                        }
                        return false;
                    }
                    UrlManager.getInstance().dealOneLink(this.f15943e.a.getPageContext(), new String[]{str}, true);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends k0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.s0.d1.k0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.t0.x3.p0.a.o(this.a);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.f15934b.I(!((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.a((String) customResponsedMessage.getData(), true, 3);
            }
        }
    }

    /* renamed from: c.a.t0.d2.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnFocusChangeListenerC1014e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15944e;

        public View$OnFocusChangeListenerC1014e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15944e = eVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z) {
                    n.w(this.f15944e.a.getPageContext().getPageActivity(), view);
                    return;
                }
                if (this.f15944e.f15934b != null && this.f15944e.f15934b.g() != null) {
                    e eVar = this.f15944e;
                    eVar.f15939g = eVar.f15934b.g().getText().toString();
                }
                if (StringUtils.isNull(this.f15944e.f15939g)) {
                    this.f15944e.n();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 3) {
                    if (StringUtils.isNull(this.a.f15939g)) {
                        n.w(this.a.a.getPageContext().getPageActivity(), textView);
                        this.a.w();
                    } else {
                        e eVar = this.a;
                        eVar.a(eVar.f15939g, false, 1);
                        TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", this.a.f15939g).param("obj_source", "1").param("obj_type", "1"));
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15945e;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15945e = eVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            if (this.f15945e.f15938f) {
                this.f15945e.f15939g = editable.toString();
                this.f15945e.B();
            }
            this.f15945e.f15934b.r(!StringUtils.isNull(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15946e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f15947e;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15947e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15947e.f15946e.a.finish();
                }
            }
        }

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15946e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view != this.f15946e.f15934b.g() || this.f15946e.f15934b.g().getText() == null) {
                    if (view == this.f15946e.f15934b.d()) {
                        n.w(this.f15946e.a.getPageContext().getPageActivity(), this.f15946e.f15934b.g());
                        c.a.d.f.m.e.a().postDelayed(new a(this), 1000L);
                        return;
                    }
                    return;
                }
                e eVar = this.f15946e;
                eVar.f15939g = eVar.f15934b.g().getText().toString();
                if (StringUtils.isNull(this.f15946e.f15939g)) {
                    this.f15946e.A();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                c.a.s0.s.c0.a.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                c.a.s0.s.c0.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i2), "description", str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements BaseWebView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) || sslError == null) {
                return;
            }
            c.a.s0.s.c0.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
        }
    }

    public e(BaseActivity baseActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15938f = true;
        this.f15940h = new Stack<>();
        this.f15942j = new c(this, 2921444);
        this.k = new d(this, 2921595);
        this.a = baseActivity;
        this.f15936d = z;
        q();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15941i.r();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!StringUtils.isNull(this.f15939g)) {
                v();
            } else {
                A();
            }
        }
    }

    @Override // c.a.t0.d2.i.b
    public void a(String str, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (!l.z()) {
                this.a.showToast(R.string.neterror);
            } else if (StringUtils.isNull(str)) {
            } else {
                Matcher matcher = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2).matcher(str);
                if (matcher != null && matcher.find() && !TextUtils.isEmpty(matcher.group(2))) {
                    str = matcher.group(2);
                }
                if (z) {
                    this.f15938f = false;
                    this.f15934b.A(str);
                    this.f15938f = true;
                }
                n.w(this.a.getPageContext().getPageActivity(), this.f15934b.g());
                this.f15934b.w();
                String str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + str + "&sub_type=" + i2;
                try {
                    str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, "utf-8");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f15934b.f().loadUrl(str2);
                this.f15940h.push(str);
                n0.b(new b(this, str), null);
                this.f15941i.k(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15934b.f().addJsPromptInterface(new UegTbJsBridge(this.a.getPageContext()));
            this.f15934b.f().addJsPromptInterface(new SearchJsBridge());
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i iVar = new i(this);
            j jVar = new j(this);
            k kVar = new k(this);
            a aVar = new a(this);
            this.f15934b.F(iVar);
            this.f15934b.H(jVar);
            this.f15934b.G(kVar);
            this.f15934b.E(aVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View$OnFocusChangeListenerC1014e view$OnFocusChangeListenerC1014e = new View$OnFocusChangeListenerC1014e(this);
            f fVar = new f(this);
            g gVar = new g(this);
            h hVar = new h(this);
            this.f15934b.y(view$OnFocusChangeListenerC1014e);
            this.f15934b.x(fVar);
            this.f15934b.B(gVar);
            this.f15934b.v(hVar);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f15934b.n()) {
            return;
        }
        v();
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15934b.g() : (View) invokeV.objValue;
    }

    public BaseWebView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f15934b.f() : (BaseWebView) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                this.f15935c = inflate;
                this.a.setContentView(inflate);
            } catch (Exception e2) {
                e2.printStackTrace();
                Map<String, String> a2 = c.a.t0.d2.i.a.a();
                if (a2 != null) {
                    int size = a2.size();
                    int i2 = 0;
                    for (String str : a2.keySet()) {
                        c.a.t0.d2.i.a.b(str);
                        try {
                            View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                            this.f15935c = inflate2;
                            this.a.setContentView(inflate2);
                            break;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            i2++;
                        }
                    }
                    if (i2 == size) {
                        this.a.finish();
                        return;
                    }
                } else {
                    this.a.finish();
                    return;
                }
            }
            View view = this.f15935c;
            if (view == null) {
                this.a.finish();
                return;
            }
            c.a.t0.d2.i.d dVar = new c.a.t0.d2.i.d(view, this.a.getPageContext().getPageActivity());
            this.f15934b = dVar;
            this.f15941i = new c.a.t0.d2.i.c(this.a, this, dVar);
            m();
            l();
            k();
            x();
            B();
            v0.g(this.f15934b.f(), this.a.getUniqueId());
            v0.g(this.f15934b.e(), this.a.getUniqueId());
            this.a.registerListener(this.f15942j);
            this.k.setTag(this.a.getUniqueId());
            this.k.setSelfListener(true);
            this.a.registerListener(this.k);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f15934b.o(this.a.getPageContext(), i2);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.t0.d2.i.d dVar = this.f15934b;
            if (dVar != null) {
                dVar.p();
            }
            c.a.t0.d2.i.c cVar = this.f15941i;
            if (cVar != null) {
                cVar.s();
            }
        }
    }

    public void t() {
        c.a.t0.d2.i.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (dVar = this.f15934b) == null) {
            return;
        }
        dVar.q();
    }

    public void u() {
        c.a.t0.d2.i.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f15940h.size() > 1) {
                this.f15940h.pop();
                String peek = this.f15940h.peek();
                if (TextUtils.isEmpty(peek) || (dVar = this.f15934b) == null) {
                    return;
                }
                boolean z = this.f15938f;
                this.f15938f = false;
                dVar.A(peek);
                this.f15938f = z;
                this.f15934b.w();
                return;
            }
            this.f15940h.clear();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (StringUtils.isNull(this.f15939g)) {
                A();
                return;
            }
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.f15939g.trim();
            searchListNetMessage.isForum = Integer.valueOf(this.f15936d ? 1 : 0);
            this.a.sendMessage(searchListNetMessage);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            HotSearchInfoData hotSearchInfoData = this.f15937e;
            if (hotSearchInfoData == null) {
                BaseActivity baseActivity = this.a;
                baseActivity.showToast(baseActivity.getResources().getString(R.string.write_keyword));
                return;
            }
            if (hotSearchInfoData.getType() != 0 && this.f15937e.getType() != 2) {
                if (this.f15937e.getType() == 1 && !c.a.s0.u0.a.b(this.a.getPageContext())) {
                    this.a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.a.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.f15937e.getId()), this.f15937e.getName(), "4")));
                }
            } else {
                a(this.f15937e.getName(), true, 1);
            }
            TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.f15937e.getName()).param("obj_type", this.f15937e.getType() == 0 ? 2 : 1));
        }
    }

    public final void x() {
        c.a.t0.d2.i.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (dVar = this.f15934b) == null) {
            return;
        }
        HotSearchInfoData hotSearchInfoData = this.f15937e;
        if (hotSearchInfoData == null) {
            dVar.z(this.a.getResources().getString(R.string.search_bar));
        } else {
            dVar.z(hotSearchInfoData.w());
        }
    }

    public void y(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hotSearchInfoData) == null) {
            this.f15937e = hotSearchInfoData;
            x();
        }
    }

    public void z(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, dataRes, str) == null) && !TextUtils.isEmpty(str) && str.equals(this.f15939g)) {
            this.f15934b.C(dataRes, this.f15939g);
        }
    }
}
