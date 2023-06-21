package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.vi;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class WebViewActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_SCHEMA = "isFromSchema";
    public static final String PAGE_TYPE = "page=";
    public static final String TAG_ADD_PARMAS = "isAddParam";
    public static final String TAG_AD_DEEPLINK_URL = "tag_ad_deeplink_url";
    public static final String TAG_AD_EXT_INFO = "tag_ad_ext_info";
    public static final String TAG_AUTO_PLAY_VIDEO = "isAutoPlay";
    public static final String TAG_BUNDLE = "tag_bundle";
    public static final String TAG_COOKIE = "tag_cookie";
    public static final String TAG_CUSTOM_MORE_JUMP = "tag_custom_more_jump";
    public static final String TAG_DOWNLOAD_AD_ID = "tag_download_ad_id";
    public static final String TAG_ENABLE_JS = "tag_enable_js";
    public static final String TAG_FIX_TITLE = "tag_fix_title";
    public static final String TAG_LOADING_STYLE = "tag_loading_style";
    public static final String TAG_LOAD_BY_WEB_CLIENT = "tag_load_by_web_client";
    public static final String TAG_NAV_BAR = "tag_navigation_bar";
    public static final String TAG_NEED_STYLE_IMMERSIVE_STICKY = "tag_style_immersive_sticky";
    public static final String TAG_NEW_GOD_INVITE = "god-invite";
    public static final String TAG_NO_CLOSE = "tag_no_close";
    public static final String TAG_NO_HELP = "tag_nohelp";
    public static final String TAG_NO_MENU = "tag_nomenu";
    public static final String TAG_NO_SHARE = "tag_noshare";
    public static final String TAG_PAGE_DATA = "pageData";
    public static final String TAG_PAGE_TRANSLUCENT = "tag_page_translucent";
    public static final String TAG_SHOW_LOADING_SWITCH = "tag_show_loading_switch";
    public static final String TAG_TEXT_AUTO_SIZE = "tag_text_auto_size";
    public static final String TAG_TITLE = "tag_title";
    public static final String TAG_TRANSLUCENT_AUTO_CLOSE = "trans_auto_close";
    public static final String TAG_URL = "tag_url";
    public static final String TAG_WEB_DIALOG_NAME = "tag_web_dialog_name";
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        addPageIdParams(context);
    }

    public void addPageIdParams(Context context) {
        BdUniqueId uniqueId;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && getIntent() != null && (context instanceof TbPageContextSupport) && (uniqueId = ((TbPageContextSupport) context).getPageContext().getUniqueId()) != null) {
            getIntent().putExtra(IntentConfig.PRE_PAGE_ID, uniqueId.getId());
        }
    }

    public static HashMap<String, Object> getPageData(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (intent == null) {
                return new HashMap<>();
            }
            Serializable serializableExtra = intent.getSerializableExtra(TAG_PAGE_DATA);
            if (serializableExtra instanceof HashMap) {
                return (HashMap) serializableExtra;
            }
            return new HashMap<>();
        }
        return (HashMap) invokeL.objValue;
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_AUTO_PLAY_VIDEO, z);
        }
    }

    public void setBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_BUNDLE, bundle);
        }
    }

    public void setCustomMoreHelp(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_CUSTOM_MORE_JUMP, z);
        }
    }

    public void setFixTitle(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_FIX_TITLE, z);
        }
    }

    public void setLoadType(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_LOAD_BY_WEB_CLIENT, z);
        }
    }

    public void setLoadingStyle(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_LOADING_STYLE, i);
        }
    }

    public void setLoadingSwitch(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_SHOW_LOADING_SWITCH, i);
        }
    }

    public void setNeedImmerSiveSticky(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_NEED_STYLE_IMMERSIVE_STICKY, z);
        }
    }

    public void setNoClose(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_NO_CLOSE, z);
        }
    }

    public void setNoHelp(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_NO_HELP, z);
        }
    }

    public void setNoMenu(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_NO_MENU, z);
        }
    }

    public void setNoShare(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_NO_SHARE, z);
        }
    }

    public void setPageData(HashMap<String, Serializable> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, hashMap) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_PAGE_DATA, hashMap);
        }
    }

    public void setPageTranslucent(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_PAGE_TRANSLUCENT, str);
        }
    }

    public void setTextAutoSize(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_TEXT_AUTO_SIZE, z);
        }
    }

    public void setTranslucentAutoClose(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_TRANSLUCENT_AUTO_CLOSE, z);
        }
    }

    public void setWebDialogName(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && getIntent() != null) {
            getIntent().putExtra(TAG_WEB_DIALOG_NAME, str);
        }
    }

    public String addTiebaParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!vi.isEmpty(str)) {
                if (str.indexOf("_client_version=") < 0) {
                    if (vi.isEmpty(Uri.parse(str).getQuery())) {
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
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void init(String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            getIntent().putExtra(TAG_TITLE, str);
            getIntent().putExtra(TAG_URL, addTiebaParams(str2));
            getIntent().putExtra(TAG_COOKIE, z);
            getIntent().putExtra(TAG_NAV_BAR, z2);
            getIntent().putExtra(TAG_ENABLE_JS, z3);
            getIntent().putExtra(TAG_NEED_STYLE_IMMERSIVE_STICKY, true);
            if (!(getContext() instanceof Activity)) {
                getIntent().addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            setIntentAction(IntentAction.Activity);
        }
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
                wi.Q(getContext(), getContext().getString(R.string.web_view_corrupted));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
