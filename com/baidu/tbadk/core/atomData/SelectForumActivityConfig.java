package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SelectForumActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_KEY_BAIJIAHAO_DATA = "extra_key_baijiahao_data";
    public static final String EXTRA_KEY_FROM = "extra_key_from";
    public static final String EXTRA_KEY_LIVE_ID = "extra_key_live_id";
    public static final String EXTRA_KEY_ORIGINAL_THREAD = "extra_key_original_thread";
    public static final String EXTRA_KEY_PRIVATE_THREAD = "extra_key_private_thread";
    public static final String EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT = "extra_key_transmit_origin_thread_content";
    public static final String EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW = "extra_key_transmit_thread_author_name_show";
    public static final String EXTRA_KEY_YY_ANCHOR_BDUID = "extra_key_yy_anchor_bduid";
    public static final int FROM_ALA_SHARE = 1;
    public static final int FROM_FORUM_SHARE = 4;
    public static final String FROM_SHARE = "from_share";
    public static final int FROM_SHARE_SDK = 3;
    public static final int FROM_TRANSMIT_SHARE = 2;
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_APPLETSKEY = "appletsKey";
    public static final String KEY_INPUT_FORUM_LIST = "KEY_INTPUT_FORUM_LIST";
    public static final String KEY_OUTPUT_FORUM_LIST = "KEY_OUTPUT_FORUM_LIST";
    public static final String KEY_SHARE_APPLETS_LINK = "linkAppletsUrl";
    public static final String KEY_SHARE_DESC = "desc";
    public static final String KEY_SHARE_IMGURL = "image";
    public static final String KEY_SHARE_LINK = "link";
    public static final String KEY_SHARE_TITLE = "title";
    public static final String KEY_TBOPEN_APP_KEY = "81d0b67309e0c2387a031408597139f358f32b4d";
    public static final String MORE_FORUM_IMG = "more_forum_img";
    public static final String MORE_FORUM_TITLE = "more_forum_title";
    public static final String MORE_FORUM_URL = "more_forum_url";
    public static final String SELECT_FORUM_ID = "select_forum_id";
    public static final String SELECT_FORUM_NAME = "select_forum_name";
    public static final String URL_AIAPPS_SHARE_FORUM = "tieba://baidu.tieba.share:8080/selectForum";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectForumActivityConfig(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setAiAppsParams(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            Intent intent = getIntent();
            intent.setData(Uri.parse(URL_AIAPPS_SHARE_FORUM));
            intent.putExtra("appkey", KEY_TBOPEN_APP_KEY);
            intent.putExtra(KEY_APPLETSKEY, str);
            intent.putExtra("title", str2);
            intent.putExtra("image", str3);
            intent.putExtra("desc", str4);
            intent.putExtra("link", str5);
            intent.putExtra(KEY_SHARE_APPLETS_LINK, str6);
        }
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baijiahaoData) == null) && getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_BAIJIAHAO_DATA, baijiahaoData);
        }
    }

    public void setForumList(ArrayList<TransmitForumData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) && getIntent() != null) {
            getIntent().putParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST", arrayList);
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_FROM, i);
        }
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && getIntent() != null) {
            getIntent().putExtra("from_share", z);
        }
    }

    public void setLiveId(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && getIntent() != null) {
            getIntent().putExtra("extra_key_live_id", j);
        }
    }

    public void setMoreForumImg(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("more_forum_img", str);
        }
    }

    public void setMoreForumTitle(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("more_forum_title", str);
        }
    }

    public void setMoreForumUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("more_forum_url", str);
        }
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, shareInfo) == null) && getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_ORIGINAL_THREAD, shareInfo);
        }
    }

    public void setPrivateThread(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_PRIVATE_THREAD, i);
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("topic_id", str);
        }
    }

    public void setTransmitOriginThreadComment(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT, str);
        }
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW, str);
        }
    }

    public void setYyAnchorBdUid(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("extra_key_yy_anchor_bduid", str);
        }
    }
}
