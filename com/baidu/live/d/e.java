package com.baidu.live.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e extends IntentConfig {
    public e(Context context, int i, int i2) {
        super(context);
        getIntent().putExtra("key_choose_type", i);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void d(String str, ArrayList<String> arrayList) {
        getIntent().putExtra("key_chosen_gift_id", str);
        getIntent().putStringArrayListExtra("key_used_gift_list", arrayList);
    }

    public void dQ(int i) {
        getIntent().putExtra("key_chosen_gift_num", i);
    }

    public void dR(int i) {
        getIntent().putExtra("key_chosen_date", i);
    }
}
