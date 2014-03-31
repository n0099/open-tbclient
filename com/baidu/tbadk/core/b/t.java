package com.baidu.tbadk.core.b;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class t extends com.baidu.tbadk.core.frameworkData.a {
    public t(Context context) {
        super(context);
    }

    public final t a(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4) {
        Intent d = d();
        d.putExtra("start_activity_type", "start_activity_normal");
        if (arrayList != null && arrayList.size() > 0) {
            d.putExtra("is_data_valid", "data_valid");
            d.putStringArrayListExtra("url", arrayList);
            d.putExtra("index", i);
            d.putExtra("is_pv", true);
            d.putExtra("pv_type", "pb");
            d.putExtra("isCdn", z);
            d.putExtra("fname", str);
            d.putExtra("fid", str2);
            d.putExtra("tid", str3);
            d.putExtra("last_id", str4);
        } else {
            d.putExtra("is_data_valid", "data_not_valid");
        }
        return this;
    }
}
