package com.baidu.tbadk.core.b;

import android.content.Context;
import android.net.Uri;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class aw extends com.baidu.tbadk.core.frameworkData.a {
    public aw(Context context, int i, int i2, Uri uri, String str, String str2, int i3, String str3, String str4, String str5) {
        super(context);
        a(IntentAction.ActivityForResult);
        d().putExtra("request", i);
        d().putExtra("from", str5);
        d().putExtra("forumid", str);
        d().putExtra("foruimname", str2);
        d().putExtra("display_size", i3);
        if (str3 != null) {
            d().putExtra("finish_text", str3);
        }
        if (str4 != null) {
            d().putExtra("cancel_text", str4);
        }
        d().setData(uri);
        a(i2);
    }

    public aw(Context context, int i, int i2, Uri uri, String str, String str2, AntiData antiData) {
        this(context, i, i2, uri, str, str2, 0, null, null, "frs");
    }
}
