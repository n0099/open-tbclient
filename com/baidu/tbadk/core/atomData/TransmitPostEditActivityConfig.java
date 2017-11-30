package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class TransmitPostEditActivityConfig extends IntentConfig {
    public static final String ADDITION_DATA = "addition_data";
    public static final String CATEGORY_ID = "category_id";
    public static final String CONTENT = "write_content";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String HOT_TOPIC = "hot_topic";
    public static final String HOT_TOPIC_POST_FORUM = "hot_topic_forum_list";
    public static final String IS_SAVE_DRAFTE = "need_save_draft";
    public static final String KEY_CALL_FROM = "KEY_CALL_FROM";
    public static final String KEY_ORIGINAL_THREAD = "key_original_thread";
    public static final String KEY_WRITE_IMAGES_INFO_STRING = "KEY_WRITE_IMAGES_INFO_STRING";
    public static final String KEY_WRITE_LEVEL = "key_write_level";
    public static final String POST_WRITE_CALLBACK_DATA = "post_write_callback_data";
    public static final String PREFIX_DATA = "prefix_data";
    public static final String THREAD_ID = "thread_id";
    public static final String TITLE = "write_title";
    public static final String TYPE = "type";

    public TransmitPostEditActivityConfig(Context context, int i, String str, String str2, String str3, AntiData antiData, int i2, AdditionData additionData, PostPrefixData postPrefixData, String str4, OriginalThreadInfo originalThreadInfo) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        if (antiData != null && antiData.getIfpost() == 0 && !StringUtils.isNull(antiData.getForbid_info())) {
            l.showToast(context, antiData.getForbid_info());
            return;
        }
        getIntent().putExtra("type", i);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("from", str4);
        if (str3 != null) {
            getIntent().putExtra("thread_id", str3);
        }
        if (additionData != null) {
            getIntent().putExtra("addition_data", additionData);
        }
        if (postPrefixData != null) {
            getIntent().putExtra("prefix_data", postPrefixData);
        }
        if (originalThreadInfo != null) {
            getIntent().putExtra(KEY_ORIGINAL_THREAD, originalThreadInfo);
        }
    }

    public void setCategroyId(int i) {
        getIntent().putExtra("category_id", i);
    }

    public void setTitleAndContent(String str, String str2, boolean z) {
        getIntent().putExtra("write_title", str);
        getIntent().putExtra("write_content", str2);
        getIntent().putExtra("need_save_draft", z);
    }

    public void setCallFrom(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("KEY_CALL_FROM", str);
        }
    }

    public void setForumLevel(int i) {
        if (getIntent() != null) {
            getIntent().putExtra("key_write_level", i);
        }
    }
}
