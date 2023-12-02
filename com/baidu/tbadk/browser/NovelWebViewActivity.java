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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NovelWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.tieba.R;
import com.baidu.tieba.es4;
import com.baidu.tieba.to5;
import com.baidu.tieba.uo5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.xj6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NovelWebViewActivity extends TBWebContainerActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static String d0 = "";
    public static String e0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean X;
    public boolean Y;
    public String Z;
    public String a0;
    public final CustomMessageListener b0;
    public xj6 c0;

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
                this.a.X = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error == 0) {
                    NovelWebViewActivity novelWebViewActivity = this.a;
                    if (novelWebViewActivity.X) {
                        novelWebViewActivity.z1();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements xj6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NovelWebViewActivity a;

        public b(NovelWebViewActivity novelWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {novelWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = novelWebViewActivity;
        }

        @Override // com.baidu.tieba.xj6
        public void onPageFinished(WebView webView, String str) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                String unused = NovelWebViewActivity.e0 = to5.b(NovelWebViewActivity.d0, TbadkCoreApplication.getCurrentAccount());
                if (this.a.Y && StringUtils.isNull(NovelWebViewActivity.e0)) {
                    this.a.z1();
                }
                if (this.a.Y) {
                    i = 2;
                } else {
                    i = 1;
                }
                uo5.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_JUMP_H5, i, NovelWebViewActivity.d0, this.a.Z, this.a.a0);
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
        this.X = false;
        this.Y = false;
        this.b0 = new a(this, 2921697);
        this.c0 = new b(this);
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.b0);
        }
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.X) {
                this.X = false;
                finish();
                return true;
            }
            return super.webViewGoBack();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null) {
                this.Y = getIntent().getBooleanExtra(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, false);
                d0 = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_ID);
                this.Z = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_TID);
                this.a0 = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_FID);
            }
            this.a.setOnPageFinishedListener(this.c0);
            es4 es4Var = this.mView;
            if (es4Var != null && (imageView = es4Var.j) != null) {
                imageView.setVisibility(8);
            }
            registerListener(this.b0);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, keyEvent)) == null) {
            if (i == 4 && webViewGoBack()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            to5.d(d0, new ReadRecordsData(d0));
            new BdTopToast(getPageContext().getPageActivity()).setIcon(true).setContent(getPageContext().getString(R.string.novel_add_mark_tip)).show((ViewGroup) getPageContext().getPageActivity().findViewById(16908290));
        }
    }
}
