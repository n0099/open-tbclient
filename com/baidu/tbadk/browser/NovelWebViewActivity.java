package com.baidu.tbadk.browser;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.TBWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NovelWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.tieba.R;
import com.baidu.tieba.ir5;
import com.baidu.tieba.jr5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.yx4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NovelWebViewActivity extends TBWebViewActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static String f = "";
    public static String g;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public final CustomMessageListener e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1500810213, "Lcom/baidu/tbadk/browser/NovelWebViewActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1500810213, "Lcom/baidu/tbadk/browser/NovelWebViewActivity;");
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NovelWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NovelWebViewActivity novelWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {novelWebViewActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = novelWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921697) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                this.a.a = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error == 0) {
                    NovelWebViewActivity novelWebViewActivity = this.a;
                    if (novelWebViewActivity.a) {
                        novelWebViewActivity.D1();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends TBWebViewActivity.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NovelWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NovelWebViewActivity novelWebViewActivity) {
            super(novelWebViewActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {novelWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((TBWebViewActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = novelWebViewActivity;
        }

        public /* synthetic */ b(NovelWebViewActivity novelWebViewActivity, a aVar) {
            this(novelWebViewActivity);
        }

        @Override // com.baidu.tbadk.browser.TBWebViewActivity.x, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                String unused = NovelWebViewActivity.g = ir5.c(NovelWebViewActivity.f, TbadkCoreApplication.getCurrentAccount());
                if (this.c.b && StringUtils.isNull(NovelWebViewActivity.g)) {
                    this.c.D1();
                }
                if (this.c.b) {
                    i = 2;
                } else {
                    i = 1;
                }
                jr5.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_JUMP_H5, i, NovelWebViewActivity.f, this.c.c, this.c.d);
            }
        }
    }

    public NovelWebViewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.e = new a(this, 2921697);
    }

    @Override // com.baidu.tbadk.browser.TBWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    @Override // com.baidu.tbadk.browser.TBWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a) {
                this.a = false;
                finish();
                return true;
            }
            return super.webViewGoBack();
        }
        return invokeV.booleanValue;
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ir5.e(f, new ReadRecordsData(f));
            BdTopToast bdTopToast = new BdTopToast(getPageContext().getPageActivity());
            bdTopToast.h(true);
            bdTopToast.g(getPageContext().getString(R.string.novel_add_mark_tip));
            bdTopToast.i((ViewGroup) getPageContext().getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tbadk.browser.TBWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null) {
                this.b = getIntent().getBooleanExtra(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, false);
                f = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_ID);
                this.c = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_TID);
                this.d = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_FID);
            }
            this.mWebView.setWebViewClient(new b(this, null));
            yx4 yx4Var = this.mView;
            if (yx4Var != null && (imageView = yx4Var.j) != null) {
                imageView.setVisibility(8);
            }
            registerListener(this.e);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, keyEvent)) == null) {
            if (i == 4 && webViewGoBack()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
