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
import com.baidu.tieba.jr4;
import com.baidu.tieba.nh6;
import com.baidu.tieba.pm5;
import com.baidu.tieba.qm5;
import com.baidu.tieba.view.BdTopToast;
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
    public static String b0 = "";
    public static String c0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean V;
    public boolean W;
    public String X;
    public String Y;
    public final CustomMessageListener Z;
    public nh6 a0;

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
                this.a.V = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error == 0) {
                    NovelWebViewActivity novelWebViewActivity = this.a;
                    if (novelWebViewActivity.V) {
                        novelWebViewActivity.B1();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements nh6 {
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

        @Override // com.baidu.tieba.nh6
        public void onPageFinished(WebView webView, String str) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                String unused = NovelWebViewActivity.c0 = pm5.b(NovelWebViewActivity.b0, TbadkCoreApplication.getCurrentAccount());
                if (this.a.W && StringUtils.isNull(NovelWebViewActivity.c0)) {
                    this.a.B1();
                }
                if (this.a.W) {
                    i = 2;
                } else {
                    i = 1;
                }
                qm5.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_JUMP_H5, i, NovelWebViewActivity.b0, this.a.X, this.a.Y);
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
        this.V = false;
        this.W = false;
        this.Z = new a(this, 2921697);
        this.a0 = new b(this);
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.Z);
        }
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.V) {
                this.V = false;
                finish();
                return true;
            }
            return super.webViewGoBack();
        }
        return invokeV.booleanValue;
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pm5.d(b0, new ReadRecordsData(b0));
            new BdTopToast(getPageContext().getPageActivity()).setIcon(true).setContent(getPageContext().getString(R.string.novel_add_mark_tip)).show((ViewGroup) getPageContext().getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null) {
                this.W = getIntent().getBooleanExtra(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, false);
                b0 = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_ID);
                this.X = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_TID);
                this.Y = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_FID);
            }
            this.a.setOnPageFinishedListener(this.a0);
            jr4 jr4Var = this.mView;
            if (jr4Var != null && (imageView = jr4Var.j) != null) {
                imageView.setVisibility(8);
            }
            registerListener(this.Z);
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
