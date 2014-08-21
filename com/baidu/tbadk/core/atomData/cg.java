package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class cg extends com.baidu.tbadk.core.frameworkData.a {
    public cg(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData, int i3, String str3, String str4, String str5) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("request", i);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, str5);
        getIntent().putExtra("forumid", str);
        getIntent().putExtra("foruimname", str2);
        getIntent().putExtra("display_size", i3);
        if (str3 != null) {
            getIntent().putExtra("finish_text", str3);
        }
        if (str4 != null) {
            getIntent().putExtra("cancel_text", str4);
        }
        getIntent().setData(uri);
        setRequestCode(i2);
    }

    public cg(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData) {
        this(context, i, i2, uri, str, str2, antiData, 0, null, null, "frs");
    }
}
