package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.n0.c1.b.e;
/* loaded from: classes3.dex */
public class PostSearchActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";

    public PostSearchActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("forum_name", str);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean startActivity(Class<?> cls) {
        if (e.d()) {
            e.g(getContext());
            return false;
        }
        return super.startActivity(cls);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public void startActivityForResult(int i2, Class<?> cls) {
        if (e.d()) {
            e.g(getContext());
        } else {
            super.startActivityForResult(i2, cls);
        }
    }

    public PostSearchActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("forum_name", str);
        getIntent().putExtra("forum_id", str2);
    }
}
