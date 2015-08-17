package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivityConfig extends IntentConfig {
    public static final String NEED_UPLOAD = "need_upload";
    public static final String NEW_PHOTO_URL = "new_photo";

    public ChangeSystemPhotoActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public ChangeSystemPhotoActivityConfig(Context context, int i, boolean z) {
        super(context);
        setRequestCode(i);
        getIntent().putExtra("need_upload", z);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
