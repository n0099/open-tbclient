package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
/* loaded from: classes2.dex */
public class UniversityEvaluationConfig extends IntentConfig {
    public static final String FORUM_WRITE_DATA = "forum_write_data";
    public static final String ITEM_INFO = "item_info";
    public static final String ITEM_IS_SCHOOL = "item_is_school";

    public UniversityEvaluationConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setWriteData(ForumWriteData forumWriteData) {
        if (getIntent() != null) {
            getIntent().putExtra("forum_write_data", forumWriteData);
        }
    }

    public void setScoreItemInfo(SerializableItemInfo serializableItemInfo) {
        if (getIntent() != null) {
            getIntent().putExtra(ITEM_INFO, serializableItemInfo);
        }
    }

    public void setItemIsSchool(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra(ITEM_IS_SCHOOL, z);
        }
    }
}
