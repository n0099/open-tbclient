package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PbFullScreenEditorActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EDITOR_DATA = "editor_data";
    public static final String POST_WRITE_CALLBACK_DATA = "post_write_callback_data";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFullScreenEditorActivityConfig(Context context, int i2, PbEditorData pbEditorData, PostWriteCallBackData postWriteCallBackData) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), pbEditorData, postWriteCallBackData};
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
        if (pbEditorData != null) {
            getIntent().putExtra(EDITOR_DATA, pbEditorData);
        }
        if (postWriteCallBackData != null) {
            getIntent().putExtra("post_write_callback_data", postWriteCallBackData);
        }
        setRequestCode(i2);
    }
}
