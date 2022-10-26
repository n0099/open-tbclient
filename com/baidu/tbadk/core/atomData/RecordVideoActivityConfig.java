package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RecordVideoActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENTRANCE_FLAG = "entrance_flag";
    public static final String FORUM_WRITE_DATA = "forum_write_data";
    public static final String SHOW_TYPE = "show_type";
    public static final int SHOW_TYPE_PIC_ONLY = 1;
    public static final int SHOW_TYPE_TRY_BOTH = 0;
    public static final int SHOW_TYPE_VIDEO_ONLY = 2;
    public static final String VIDEO_TITLE = "video_title";
    public static final String WRITE_IMAGE_INFO = "write_image_info";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordVideoActivityConfig(Context context, int i, ForumWriteData forumWriteData, WriteImagesInfo writeImagesInfo, String str, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), forumWriteData, writeImagesInfo, str, Integer.valueOf(i2)};
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
        getIntent().putExtra(FORUM_WRITE_DATA, forumWriteData);
        getIntent().putExtra(WRITE_IMAGE_INFO, writeImagesInfo);
        getIntent().putExtra("video_title", str);
        getIntent().putExtra(ENTRANCE_FLAG, i);
        getIntent().putExtra("from_type", i2);
        setRequestCode(13010);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, antiData, postPrefixData, str, str2) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.FORUM_FIRST_DIR, str);
            getIntent().putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
            getIntent().putExtra(BaseWriteConfig.PREFIX_DATA, postPrefixData);
            getIntent().putExtra("anti_data", antiData);
        }
    }

    public void setShowType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(SHOW_TYPE, i);
        }
    }
}
