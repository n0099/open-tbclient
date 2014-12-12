package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class BarFolderFirstDirActivityConfig extends a {
    public static String URL_ST_TYPE = "st_type";

    public BarFolderFirstDirActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(URL_ST_TYPE, str);
    }
}
