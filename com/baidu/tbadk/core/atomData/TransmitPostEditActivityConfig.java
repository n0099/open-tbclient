package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TransmitPostEditActivityConfig extends BaseWriteConfig<TransmitPostEditActivityConfig> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAIJIAHAO_DATA = "baijiahao_data";
    public static final String FROM_SHARE = "from_share";
    public static final String KEY_ORIGINAL_THREAD = "key_original_thread";
    public static final String KEY_TAB_LIST = "tab_list";
    public static final String MORE_FORUM_TITLE = "more_forum_title";
    public static final String MORE_FORUM_URL = "more_forum_url";
    public static final String TRANSMIT_ORIGIN_THREAD_CONTENT = "transmit_origin_thread_content";
    public static final String TRANSMIT_THREAD_AUTHOR_NAME_SHOW = "transmit_thread_author_name_show";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransmitPostEditActivityConfig(Context context, int i, String str, String str2, String str3, AntiData antiData, int i2, PostPrefixData postPrefixData, String str4, OriginalThreadInfo.ShareInfo shareInfo) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), str, str2, str3, antiData, Integer.valueOf(i2), postPrefixData, str4, shareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        if (antiData != null && antiData.getIfpost() == 0 && !StringUtils.isNull(antiData.getForbid_info())) {
            yi.Q(context, antiData.getForbid_info());
            return;
        }
        getIntent().putExtra("type", i);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("from", str4);
        if (str3 != null) {
            getIntent().putExtra("thread_id", str3);
        }
        if (postPrefixData != null) {
            getIntent().putExtra(BaseWriteConfig.PREFIX_DATA, postPrefixData);
        }
        if (shareInfo != null) {
            getIntent().putExtra(KEY_ORIGINAL_THREAD, shareInfo);
        }
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, baijiahaoData) == null) && getIntent() != null) {
            getIntent().putExtra(BAIJIAHAO_DATA, baijiahaoData);
        }
    }

    public void setCallFrom(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && getIntent() != null) {
            getIntent().putExtra(BaseWriteConfig.KEY_CALL_FROM, str);
        }
    }

    public void setForumLevel(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(BaseWriteConfig.KEY_WRITE_LEVEL, i);
        }
    }

    public void setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, frsTabInfoData) == null) && getIntent() != null) {
            getIntent().putExtra("tab_list", frsTabInfoData);
        }
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && getIntent() != null) {
            getIntent().putExtra("from_share", z);
        }
    }

    public void setMoreForumTitle(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("more_forum_title", str);
        }
    }

    public void setMoreForumUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("more_forum_url", str);
        }
    }

    public void setPrivateThread(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(BaseWriteConfig.PRIVATE_THREAD, i);
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("topic_id", str);
        }
    }

    public void setTransmitOriginThreadComment(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && getIntent() != null) {
            getIntent().putExtra(TRANSMIT_ORIGIN_THREAD_CONTENT, str);
        }
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && getIntent() != null) {
            getIntent().putExtra(TRANSMIT_THREAD_AUTHOR_NAME_SHOW, str);
        }
    }

    public void setTitleAndContent(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, z) == null) {
            getIntent().putExtra(BaseWriteConfig.TITLE, str);
            getIntent().putExtra(BaseWriteConfig.CONTENT, str2);
            getIntent().putExtra(BaseWriteConfig.IS_SAVE_DRAFTE, z);
        }
    }
}
