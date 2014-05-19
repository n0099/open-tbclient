package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.core.frameworkData.a {
    public w(Context context) {
        super(context);
    }

    public w a(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4) {
        Intent intent = getIntent();
        intent.putExtra("start_activity_type", "start_activity_normal");
        if (arrayList != null && arrayList.size() > 0) {
            intent.putExtra("is_data_valid", "data_valid");
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            intent.putExtra("isCdn", z);
            intent.putExtra("fname", str);
            intent.putExtra("fid", str2);
            intent.putExtra("tid", str3);
            intent.putExtra("last_id", str4);
        } else {
            intent.putExtra("is_data_valid", "data_not_valid");
        }
        return this;
    }

    public w a(ArrayList<String> arrayList, int i, int i2, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        Intent intent = getIntent();
        intent.putExtra("start_activity_type", "start_activity_result");
        if (arrayList != null && arrayList.size() > 0) {
            intent.putExtra("is_data_valid", "data_valid");
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("need_broadcast", true);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            intent.putExtra("count", i2);
            intent.putExtra("hasnext", z2);
            intent.putExtra("fname", str);
            intent.putExtra("fid", str2);
            intent.putExtra("tid", str3);
            intent.putExtra("nexttile", str4);
            intent.putExtra("isCdn", z);
        } else {
            intent.putExtra("is_data_valid", "data_not_valid");
        }
        return this;
    }
}
