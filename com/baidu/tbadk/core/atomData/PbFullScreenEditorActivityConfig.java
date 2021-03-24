package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class PbFullScreenEditorActivityConfig extends IntentConfig {
    public static final String EDITOR_DATA = "editor_data";
    public static final String POST_WRITE_CALLBACK_DATA = "post_write_callback_data";

    public PbFullScreenEditorActivityConfig(Context context, int i, PbEditorData pbEditorData, PostWriteCallBackData postWriteCallBackData) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        if (pbEditorData != null) {
            getIntent().putExtra(EDITOR_DATA, pbEditorData);
        }
        if (postWriteCallBackData != null) {
            getIntent().putExtra("post_write_callback_data", postWriteCallBackData);
        }
        setRequestCode(i);
    }
}
