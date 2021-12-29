package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class WebViewActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG_AD_DEEPLINK_URL = "tag_ad_deeplink_url";
    public static final String TAG_AD_EXT_INFO = "tag_ad_ext_info";
    public static final String TAG_BUNDLE = "tag_bundle";
    public static final String TAG_COOKIE = "tag_cookie";
    public static final String TAG_DOWNLOAD_AD_ID = "tag_download_ad_id";
    public static final String TAG_ENABLE_JS = "tag_enable_js";
    public static final String TAG_FIX_TITLE = "tag_fix_title";
    public static final String TAG_LOAD_BY_WEB_CLIENT = "tag_load_by_web_client";
    public static final String TAG_NAV_BAR = "tag_navigation_bar";
    public static final String TAG_NEED_STYLE_IMMERSIVE_STICKY = "tag_style_immersive_sticky";
    public static final String TAG_NO_MENU = "tag_nomenu";
    public static final String TAG_NO_SHARE = "tag_noshare";
    public static final String TAG_PAGE_TRANSLUCENT = "tag_page_translucent";
    public static final String TAG_TITLE = "tag_title";
    public static final String TAG_URL = "tag_url";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void addPageIdParams(Context context) {
        BdUniqueId uniqueId;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || getIntent() == null || !(context instanceof TbPageContextSupport) || (uniqueId = ((TbPageContextSupport) context).getPageContext().getUniqueId()) == null) {
            return;
        }
        getIntent().putExtra(IntentConfig.PRE_PAGE_ID, uniqueId.getId());
    }

    public String addTiebaParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (m.isEmpty(str)) {
                return str;
            }
            if (str.indexOf("_client_version=") < 0) {
                if (m.isEmpty(Uri.parse(str).getQuery())) {
                    str = str + "?_client_version=" + TbConfig.getVersion();
                } else {
                    str = str + "&_client_version=" + TbConfig.getVersion();
                }
            }
            if (str.indexOf("nohead=1") < 0) {
                return str + "&nohead=1";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
                n.M(getContext(), getContext().getString(R.string.web_view_corrupted));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TAG_BUNDLE, bundle);
    }

    public void setFixTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TAG_FIX_TITLE, z);
    }

    public void setLoadType(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TAG_LOAD_BY_WEB_CLIENT, z);
    }

    public void setNeedImmerSiveSticky(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TAG_NEED_STYLE_IMMERSIVE_STICKY, z);
    }

    public void setNoMenu(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TAG_NO_MENU, z);
    }

    public void setNoShare(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TAG_NO_SHARE, z);
    }

    public void setPageTranslucent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TAG_PAGE_TRANSLUCENT, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewActivityConfig(Context context, String str, String str2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(TAG_TITLE, str);
        getIntent().putExtra(TAG_URL, addTiebaParams(str2));
        getIntent().putExtra(TAG_COOKIE, z);
        getIntent().putExtra(TAG_ENABLE_JS, true);
        getIntent().putExtra(TAG_NAV_BAR, true);
        getIntent().putExtra(TAG_NEED_STYLE_IMMERSIVE_STICKY, true);
        addPageIdParams(context);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra(TAG_TITLE, str);
        getIntent().putExtra(TAG_URL, addTiebaParams(str2));
        getIntent().putExtra(TAG_NAV_BAR, z);
        getIntent().putExtra(TAG_COOKIE, z2);
        getIntent().putExtra(TAG_ENABLE_JS, z3);
        getIntent().putExtra(TAG_NEED_STYLE_IMMERSIVE_STICKY, true);
        addPageIdParams(context);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }
}
