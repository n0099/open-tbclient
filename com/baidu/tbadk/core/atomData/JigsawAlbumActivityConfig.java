package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class JigsawAlbumActivityConfig extends c {
    public static final String SELECTED_URIS = "selected_uris";

    public JigsawAlbumActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
