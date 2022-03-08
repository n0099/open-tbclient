package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FoldCommentActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FROM_VIDEO_PAGE_ID = "key_from_video_page_id";
    public static final String KEY_IS_JUMP_FROM_VIDEO_MIDDLE = "is_jump_from_video_middle";
    public static final String KEY_IS_JUMP_FROM_VIDEO_TAB = "is_jump_from_video_tab";
    public static final String KEY_THREAD_ID = "thread_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldCommentActivityConfig(Context context, String str, boolean z, boolean z2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("is_jump_from_video_tab", z);
        intent.putExtra("is_jump_from_video_middle", z2);
    }

    public void setFromVideoPageUniqueId(BdUniqueId bdUniqueId) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("key_from_video_page_id", bdUniqueId);
    }
}
