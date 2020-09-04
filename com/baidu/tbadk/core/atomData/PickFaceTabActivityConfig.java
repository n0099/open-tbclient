package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.face.data.FaceData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PickFaceTabActivityConfig extends IntentConfig {
    public static final String CHOOSED_LIST = "choosed_list";

    public PickFaceTabActivityConfig(Context context, int i, ArrayList<FaceData> arrayList) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        if (arrayList != null) {
            getIntent().putExtra(CHOOSED_LIST, arrayList);
        }
        setRequestCode(i);
    }
}
