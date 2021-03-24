package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PbSearchEmotionActivityConfig extends IntentConfig {
    public static final String AUTHOR_SHOW_NAME = "author_show_name";
    public static final String CURRENT_QUERY_WORD = "current_query_word";
    public static final String KEEP_IMG_CACHE_LIST = "keep_img_cache_list";
    public static final String TOP_WORDS = "top_words";

    public PbSearchEmotionActivityConfig(Context context, int i, String str, List<String> list, String str2, List<String> list2) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        if (!TextUtils.isEmpty(str)) {
            getIntent().putExtra(CURRENT_QUERY_WORD, str);
        }
        if (list != null && (list instanceof ArrayList)) {
            getIntent().putStringArrayListExtra(TOP_WORDS, (ArrayList) list);
        }
        if (str2 != null) {
            getIntent().putExtra(AUTHOR_SHOW_NAME, str2);
        }
        if (list2 == null || !(list2 instanceof ArrayList)) {
            return;
        }
        getIntent().putStringArrayListExtra(KEEP_IMG_CACHE_LIST, (ArrayList) list2);
    }
}
