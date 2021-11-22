package b.a.r0.w.i.a;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.c1.t0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f26579a;

    /* renamed from: b  reason: collision with root package name */
    public View f26580b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f26581c;

    /* renamed from: d  reason: collision with root package name */
    public ScrollBridgeWebview f26582d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.g0.g f26583e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.g0.h f26584f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26585g;

    /* renamed from: h  reason: collision with root package name */
    public String f26586h;

    /* renamed from: i  reason: collision with root package name */
    public int f26587i;
    public boolean j;
    public boolean k;
    public ShareFromPBMsgData l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f26588e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f26589f;

        public a(b bVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26589f = bVar;
            this.f26588e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.f.p.a.a(this.f26588e.t);
                l.M(this.f26589f.f26579a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* renamed from: b.a.r0.w.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1289b implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26590e;

        public C1289b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26590e = bVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921015, this.f26590e.l);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26591e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26591e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f26591e.f26579a.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ScrollBridgeWebview.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26592a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26592a = bVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void a(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void b(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) || Math.abs(i3 - this.f26592a.f26587i) <= 50) {
                return;
            }
            this.f26592a.f26587i = i3;
            if (i3 > i5) {
                this.f26592a.E(false, true);
            } else {
                this.f26592a.E(true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26593e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26593e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26593e.D();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26594e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26594e = bVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                this.f26594e.x(str);
                if (StringUtils.isNull(str) || str.contains(UrlSchemaHelper.REDIRECT_JUMP_KEY)) {
                    return false;
                }
                if (!this.f26594e.z(str)) {
                    UrlManager.getInstance().dealOneLink(this.f26594e.f26579a.getPageContext(), new String[]{str});
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements BaseWebView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26595e;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26595e = bVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void a(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f26595e.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26596e;

        public h(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26596e = bVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f26596e.l();
                if (b.a.e.f.p.j.z()) {
                    this.f26596e.H();
                    this.f26596e.f26585g = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26597a;

        public i(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26597a = bVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                this.f26597a.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26598e;

        public j(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26598e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.f26598e.f26579a.getActivity(), 23007, 1)));
            }
        }
    }

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26587i = 0;
        this.k = false;
        CustomMessageTask customMessageTask = new CustomMessageTask(2921015, new C1289b(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.k = z;
    }

    public void A(int i2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (navigationBar = this.f26581c) == null) {
            return;
        }
        navigationBar.onChangeSkinType(this.f26579a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.f26581c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
    }

    public View B(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup)) == null) {
            View inflate = layoutInflater.inflate(R.layout.ala_frs_live_video_fragment, (ViewGroup) null);
            this.f26580b = inflate;
            inflate.setDrawingCacheEnabled(false);
            return this.f26580b;
        }
        return (View) invokeLL.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921015);
            NavigationBar navigationBar = this.f26581c;
            if (navigationBar != null) {
                navigationBar.release();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f26585g) {
                this.f26582d.loadUrl("javascript:window.reload_page()");
            } else {
                this.f26582d.loadUrl(this.f26586h);
            }
        }
    }

    public final void E(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                CustomMessage customMessage = new CustomMessage(2001617);
                customMessage.setTag(this.f26579a.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            CustomMessage customMessage2 = new CustomMessage(2001618);
            customMessage2.setTag(this.f26579a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
            customResponsedMessage2.setOrginalMessage(customMessage2);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
        }
    }

    public void F() {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (baseFragment = this.f26579a) == null || this.f26580b == null || !baseFragment.isAdded()) {
            return;
        }
        this.j = true;
        b.a.q0.g0.g gVar = new b.a.q0.g0.g(this.f26579a.getActivity(), this.f26579a.getResources().getDimensionPixelSize(R.dimen.ds270));
        this.f26583e = gVar;
        gVar.attachView(this.f26580b, false);
        this.f26583e.onChangeSkinType();
    }

    public void G() {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (baseFragment = this.f26579a) != null && baseFragment.isAdded()) {
            String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
            if (this.f26584f == null) {
                b.a.q0.g0.h hVar = new b.a.q0.g0.h(this.f26579a.getActivity(), new e(this));
                this.f26584f = hVar;
                hVar.onChangeSkinType();
            }
            this.f26582d.setVisibility(8);
            this.f26584f.l(string);
            this.f26584f.attachView(this.f26580b, false);
            this.f26584f.o();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            m();
            this.f26582d.setVisibility(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.j && b.a.e.f.p.j.z()) {
            this.f26582d.loadUrl(this.f26586h);
        }
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f26581c : (NavigationBar) invokeV.objValue;
    }

    public BaseWebView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f26582d : (BaseWebView) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.j = false;
            b.a.q0.g0.g gVar = this.f26583e;
            if (gVar != null) {
                gVar.dettachView(this.f26580b);
                this.f26583e = null;
            }
        }
    }

    public void m() {
        b.a.q0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.f26584f) == null) {
            return;
        }
        hVar.dettachView(this.f26580b);
        this.f26584f = null;
    }

    public final void n() {
        ScrollBridgeWebview scrollBridgeWebview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (scrollBridgeWebview = this.f26582d) == null) {
            return;
        }
        scrollBridgeWebview.setOnLoadUrlListener(new f(this));
        this.f26582d.setOnPageStartedListener(new g(this));
        this.f26582d.setOnPageFinishedListener(new h(this));
        this.f26582d.setOnReceivedErrorListener(new i(this));
    }

    public void o(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, baseFragment) == null) {
            this.f26579a = baseFragment;
            NavigationBar navigationBar = (NavigationBar) this.f26580b.findViewById(R.id.view_navigation_bar);
            this.f26581c = navigationBar;
            navigationBar.setVisibility(this.k ? 0 : 8);
            if (this.k) {
                this.f26581c.onChangeSkinType(this.f26579a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                this.f26581c.showBottomLine(true);
                this.f26581c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
                this.f26581c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            ScrollBridgeWebview scrollBridgeWebview = (ScrollBridgeWebview) this.f26580b.findViewById(R.id.webview);
            this.f26582d = scrollBridgeWebview;
            scrollBridgeWebview.setOnScrollChangeListener(new d(this));
            n();
        }
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_BEAUTY_PIC) && str.contains("data=")) {
                String substring = str.substring(str.indexOf("data=") + 5);
                ArrayList<String> arrayList = new ArrayList<>();
                try {
                    JSONArray optJSONArray = new JSONObject(substring).optJSONArray("pic");
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(optJSONArray.getString(i2));
                    }
                    if (arrayList.size() <= 0) {
                        return false;
                    }
                    ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                    bVar.x(arrayList);
                    bVar.C(true);
                    bVar.J(arrayList.get(0));
                    bVar.F(true);
                    ImageViewerConfig v = bVar.v(this.f26579a.getActivity());
                    v.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.f26579a.sendMessage(new CustomMessage(2010000, v));
                    return true;
                } catch (JSONException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (str.contains("nohead:url") || str.contains("booktown")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    l.L(this.f26579a.getActivity(), R.string.plugin_install_fail);
                } else {
                    UrlManager.getInstance().dealOneLink(this.f26579a.getPageContext(), new String[]{str});
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
                return false;
            }
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                l.L(this.f26579a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.f26579a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_FORUM_LIST)) {
                return false;
            }
            if (MessageManager.getInstance().findTask(2902025) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.f26579a.getActivity(), t0.c(str, "menuname="), t0.c(str, "menutype="), t0.c(str, "menuid="))));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") && !str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
                if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
                    new HotRanklistActivityConfig(this.f26579a.getActivity()).createNormalConfig("discover", "all").start();
                    return true;
                }
                return false;
            }
            String c2 = t0.c(str, "topic_id=");
            String c3 = t0.c(str, "topic_name=");
            String c4 = t0.c(str, "is_video_topic=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (!StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
                if (appResponseToIntentClass) {
                    new HotTopicActivityConfig(this.f26579a.getActivity()).createNormalConfig(c2, c3, c4, null).start();
                } else {
                    b.a.q0.m.a.n(this.f26579a.getActivity(), c3, str);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_LEGO)) {
                if (!(MessageManager.getInstance().findTask(2016447) != null)) {
                    l.L(this.f26579a.getActivity(), R.string.plugin_install_fail);
                } else {
                    UrlManager.getInstance().dealOneLink(this.f26579a.getPageContext(), new String[]{str});
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER)) {
                return false;
            }
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
                l.L(this.f26579a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.f26579a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (this.f26579a.isAdded() && str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE)) {
                String urlDecode = k.getUrlDecode(str);
                if (!urlDecode.contains("data=")) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(urlDecode.substring(urlDecode.indexOf("data=") + 5));
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (ViewHelper.checkUpIsLogin(this.f26579a.getActivity())) {
                        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                        this.l = shareFromPBMsgData;
                        shareFromPBMsgData.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.l.setImageUrl(optString6);
                        }
                        this.l.setForumName(optString5);
                        this.l.setThreadId(optString4);
                        this.l.setTitle(optString);
                        String format = MessageFormat.format(this.f26579a.getResources().getString(R.string.share_content_tpl), optString, optString2);
                        ShareItem shareItem = new ShareItem();
                        shareItem.r = optString;
                        shareItem.s = format;
                        shareItem.t = optString3;
                        shareItem.q = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            shareItem.v = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f26579a.getActivity(), shareItem, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_unite_share_baf, new j(this));
                        shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
                        this.f26579a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
                    }
                    return true;
                } catch (JSONException unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, str) != null) || StringUtils.isNull(str)) {
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f26586h = str;
            this.f26582d.loadUrl(str);
        }
    }

    public final boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? u(str) || q(str) || t(str) || s(str) || v(str) || r(str) || p(str) || w(str) : invokeL.booleanValue;
    }
}
