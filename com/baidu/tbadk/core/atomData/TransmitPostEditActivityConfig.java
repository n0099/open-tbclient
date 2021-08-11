package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TransmitPostEditActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADDITION_DATA = "addition_data";
    public static final String BAIJIAHAO_DATA = "baijiahao_data";
    public static final String CATEGORY_ID = "category_id";
    public static final String CONTENT = "write_content";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FROM_SHARE = "from_share";
    public static final String HOT_TOPIC = "hot_topic";
    public static final String HOT_TOPIC_POST_FORUM = "hot_topic_forum_list";
    public static final String IS_SAVE_DRAFTE = "need_save_draft";
    public static final String KEY_CALL_FROM = "KEY_CALL_FROM";
    public static final String KEY_ORIGINAL_THREAD = "key_original_thread";
    public static final String KEY_TAB_LIST = "tab_list";
    public static final String KEY_WRITE_IMAGES_INFO_STRING = "KEY_WRITE_IMAGES_INFO_STRING";
    public static final String KEY_WRITE_LEVEL = "key_write_level";
    public static final String POST_WRITE_CALLBACK_DATA = "post_write_callback_data";
    public static final String PREFIX_DATA = "prefix_data";
    public static final String PRIVATE_THREAD = "private_thread";
    public static final String THREAD_ID = "thread_id";
    public static final String TITLE = "write_title";
    public static final String TRANSMIT_ORIGIN_THREAD_CONTENT = "transmit_origin_thread_content";
    public static final String TRANSMIT_THREAD_AUTHOR_NAME_SHOW = "transmit_thread_author_name_show";
    public static final String TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransmitPostEditActivityConfig(Context context, int i2, String str, String str2, String str3, AntiData antiData, int i3, AdditionData additionData, PostPrefixData postPrefixData, String str4, OriginalThreadInfo.ShareInfo shareInfo) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2, str3, antiData, Integer.valueOf(i3), additionData, postPrefixData, str4, shareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
        if (antiData != null && antiData.getIfpost() == 0 && !StringUtils.isNull(antiData.getForbid_info())) {
            l.M(context, antiData.getForbid_info());
            return;
        }
        getIntent().putExtra("type", i2);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("from", str4);
        if (str3 != null) {
            getIntent().putExtra("thread_id", str3);
        }
        if (additionData != null) {
            getIntent().putExtra("addition_data", additionData);
        }
        if (postPrefixData != null) {
            getIntent().putExtra("prefix_data", postPrefixData);
        }
        if (shareInfo != null) {
            getIntent().putExtra(KEY_ORIGINAL_THREAD, shareInfo);
        }
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, baijiahaoData) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(BAIJIAHAO_DATA, baijiahaoData);
    }

    public void setCallFrom(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("KEY_CALL_FROM", str);
    }

    public void setCategroyId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            getIntent().putExtra("category_id", i2);
        }
    }

    public void setForumDir(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            Intent intent = getIntent();
            intent.putExtra(IntentConfig.FORUM_FIRST_DIR, str);
            intent.putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
        }
    }

    public void setForumLevel(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("key_write_level", i2);
    }

    public void setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, frsTabInfoData) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("tab_list", frsTabInfoData);
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("from_share", z);
    }

    public void setPrivateThread(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("private_thread", i2);
    }

    public void setTitleAndContent(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, z) == null) {
            getIntent().putExtra("write_title", str);
            getIntent().putExtra("write_content", str2);
            getIntent().putExtra("need_save_draft", z);
        }
    }

    public void setTransmitOriginThreadComment(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TRANSMIT_ORIGIN_THREAD_CONTENT, str);
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(TRANSMIT_THREAD_AUTHOR_NAME_SHOW, str);
    }
}
