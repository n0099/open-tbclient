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
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NovelWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.v65;
import com.repackage.zk4;
/* loaded from: classes2.dex */
public class NovelWebViewActivity extends TbWebViewActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static String isFirstRead = null;
    public static String mNovelId = "";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsNovelMember;
    public boolean mIsPaySuccess;
    public final CustomMessageListener mPaySuccessListener;

    /* loaded from: classes2.dex */
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
                if (customResponsedMessage.getData() instanceof Boolean) {
                    this.a.mIsPaySuccess = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (error == 0) {
                        NovelWebViewActivity novelWebViewActivity = this.a;
                        if (novelWebViewActivity.mIsPaySuccess) {
                            novelWebViewActivity.showTopToastTip();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends TbWebViewActivity.t {
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
                    super((TbWebViewActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = novelWebViewActivity;
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.t, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                String unused = NovelWebViewActivity.isFirstRead = v65.c(NovelWebViewActivity.mNovelId, TbadkCoreApplication.getCurrentAccount());
                if (this.c.mIsNovelMember && StringUtils.isNull(NovelWebViewActivity.isFirstRead)) {
                    this.c.showTopToastTip();
                }
                StatisticItem.make(CommonStatisticKey.KEY_PB_NOVEL_INFO_JUMP_H5).eventStat();
            }
        }

        public /* synthetic */ b(NovelWebViewActivity novelWebViewActivity, a aVar) {
            this(novelWebViewActivity);
        }
    }

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
        this.mIsPaySuccess = false;
        this.mIsNovelMember = false;
        this.mPaySuccessListener = new a(this, 2921697);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTopToastTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            v65.e(mNovelId, new ReadRecordsData(mNovelId));
            BdTopToast bdTopToast = new BdTopToast(getPageContext().getPageActivity());
            bdTopToast.i(true);
            bdTopToast.h(getPageContext().getString(R.string.obfuscated_res_0x7f0f0caf));
            bdTopToast.j((ViewGroup) getPageContext().getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null) {
                this.mIsNovelMember = getIntent().getBooleanExtra(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, false);
                mNovelId = getIntent().getStringExtra(NovelWebViewActivityConfig.KEY_NOVEL_ID);
            }
            this.mWebView.setWebViewClient(new b(this, null));
            zk4 zk4Var = this.mView;
            if (zk4Var != null && (imageView = zk4Var.i) != null) {
                imageView.setVisibility(8);
            }
            registerListener(this.mPaySuccessListener);
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.mPaySuccessListener);
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

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mIsPaySuccess) {
                this.mIsPaySuccess = false;
                finish();
                return true;
            }
            return super.webViewGoBack();
        }
        return invokeV.booleanValue;
    }
}
