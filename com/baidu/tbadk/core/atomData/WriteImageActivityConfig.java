package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class WriteImageActivityConfig extends a {
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

    public WriteImageActivityConfig(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData, int i3, String str3, String str4, String str5, String str6) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(FROMCODE, i);
        getIntent().putExtra("from", str5);
        getIntent().putExtra(FORUMID, str);
        getIntent().putExtra(FORUMNAME, str2);
        getIntent().putExtra(DISPLAY_SIZE, i3);
        if (str3 != null) {
            getIntent().putExtra(FINISH_TEXT, str3);
        }
        if (str4 != null) {
            getIntent().putExtra(CANCEL_TEXT, str4);
        }
        if (str6 != null) {
            getIntent().putExtra("file_name", str6);
        }
        getIntent().setData(uri);
        setRequestCode(i2);
    }

    public WriteImageActivityConfig(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData, int i3, String str3, String str4, String str5) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(FROMCODE, i);
        getIntent().putExtra("from", str5);
        getIntent().putExtra(FORUMID, str);
        getIntent().putExtra(FORUMNAME, str2);
        getIntent().putExtra(DISPLAY_SIZE, i3);
        if (str3 != null) {
            getIntent().putExtra(FINISH_TEXT, str3);
        }
        if (str4 != null) {
            getIntent().putExtra(CANCEL_TEXT, str4);
        }
        getIntent().setData(uri);
        setRequestCode(i2);
    }

    public WriteImageActivityConfig(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData) {
        this(context, i, i2, uri, str, str2, antiData, 0, null, null, "frs");
    }
}
