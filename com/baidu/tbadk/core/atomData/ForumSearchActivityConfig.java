package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ForumSearchActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumSearchActivityConfig(Context context) {
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

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, baijiahaoData) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA, baijiahaoData);
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, i2);
    }

    public void setLiveId(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("extra_key_live_id", j2);
    }

    public void setMoreForumImg(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("more_forum_img", str);
    }

    public void setMoreForumTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("more_forum_title", str);
    }

    public void setMoreForumUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("more_forum_url", str);
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, shareInfo) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD, shareInfo);
    }

    public void setTransmitOriginThreadComment(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT, str);
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW, str);
    }

    public void setYyAnchorBdUid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("extra_key_yy_anchor_bduid", str);
    }
}
