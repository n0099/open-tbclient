package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends IntentConfig {
    public c(Context context, int i, int i2) {
        super(context);
        getIntent().putExtra("key_choose_type", i);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void d(String str, ArrayList<String> arrayList) {
        getIntent().putExtra("key_chosen_gift_id", str);
        getIntent().putStringArrayListExtra("key_used_gift_list", arrayList);
    }

    public void bz(int i) {
        getIntent().putExtra("key_chosen_gift_num", i);
    }

    public void bA(int i) {
        getIntent().putExtra("key_chosen_date", i);
    }
}
