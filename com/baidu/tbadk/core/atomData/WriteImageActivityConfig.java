package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class WriteImageActivityConfig extends IntentConfig {
    public static final String CANCEL_TEXT = "cancel_text";
    public static final String DELET_FLAG = "delete";
    public static final String DISPLAY_SIZE = "display_size";
    public static final String FILE_NAME = "file_name";
    public static final String FILTER_NAME_NORMAL = "normal";
    public static final String FINISH_TEXT = "finish_text";
    public static final String FORUMID = "forumid";
    public static final String FORUMNAME = "foruimname";
    public static final String FROM = "from";
    public static final String FROMCODE = "request";
    public static final String THREADID = "threadid";
    public static boolean isActivityInStack = false;

    public WriteImageActivityConfig(Context context, int i2, int i3, Uri uri, String str, String str2, AntiData antiData, int i4, String str3, String str4, String str5, String str6) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("request", i2);
        getIntent().putExtra("from", str5);
        getIntent().putExtra("forumid", str);
        getIntent().putExtra("foruimname", str2);
        getIntent().putExtra("display_size", i4);
        if (str3 != null) {
            getIntent().putExtra("finish_text", str3);
        }
        if (str4 != null) {
            getIntent().putExtra("cancel_text", str4);
        }
        if (str6 != null) {
            getIntent().putExtra("file_name", str6);
        }
        getIntent().setData(uri);
        setRequestCode(i3);
    }

    public WriteImageActivityConfig(Context context, int i2, int i3, Uri uri, String str, String str2, AntiData antiData, int i4, String str3, String str4, String str5) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("request", i2);
        getIntent().putExtra("from", str5);
        getIntent().putExtra("forumid", str);
        getIntent().putExtra("foruimname", str2);
        getIntent().putExtra("display_size", i4);
        if (str3 != null) {
            getIntent().putExtra("finish_text", str3);
        }
        if (str4 != null) {
            getIntent().putExtra("cancel_text", str4);
        }
        getIntent().setData(uri);
        setRequestCode(i3);
    }

    public WriteImageActivityConfig(Context context, int i2, int i3, Uri uri, String str, String str2, AntiData antiData) {
        this(context, i2, i3, uri, str, str2, antiData, 0, null, null, "frs");
    }
}
