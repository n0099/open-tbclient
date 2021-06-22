package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.n0.c1.b.e;
/* loaded from: classes3.dex */
public class SquareSearchActivityConfig extends IntentConfig {
    public static final String BACK_SPECIAL = "back_special";
    public static final String FROM = "start_from";
    public static final String IS_FROM_ENTER_FROUM = "is_from_enter_forum";
    public static boolean IS_SHOW_LIKE_FORUM = false;
    public static boolean IS_SHOW_RECOMMEND_FORUM = true;
    public static final String SEARCH_TITLE = "search";
    public static final String SEARCH_VALUE = "searchValue";

    public SquareSearchActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
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

    public SquareSearchActivityConfig(Context context, String str, boolean z, String str2) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
        getIntent().putExtra("search", str2);
    }

    public SquareSearchActivityConfig(Context context, String str, boolean z, String str2, String str3) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
        getIntent().putExtra("search", str2);
        getIntent().putExtra(SEARCH_VALUE, str3);
    }
}
