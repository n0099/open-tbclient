package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivityConfig extends c {
    public static final String NEW_PHOTO_URL = "new_photo";

    public ChangeSystemPhotoActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
