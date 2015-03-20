package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class JigsawAlbumActivityConfig extends a {
    public static final String SELECTED_URIS = "selected_uris";

    public JigsawAlbumActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
