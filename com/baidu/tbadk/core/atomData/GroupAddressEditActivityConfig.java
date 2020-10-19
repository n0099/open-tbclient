package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.List;
/* loaded from: classes21.dex */
public class GroupAddressEditActivityConfig extends IntentConfig {
    public static final String INTENT_GROUP_ADDRESS_ISHIDDEN = "HiddenAddress";
    public static final String INTENT_GROUP_ADRESS_LIST = "GroupAdressList";
    public static final String INTENT_GROUP_SELECTEDINDEX = "IntentSelectedIndex";

    public GroupAddressEditActivityConfig(Context context, int i, List<String> list, int i2, boolean z) {
        super(context);
        String[] strArr = new String[list.size()];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < list.size()) {
                strArr[i4] = list.get(i4);
                i3 = i4 + 1;
            } else {
                getIntent().putExtra(INTENT_GROUP_ADRESS_LIST, strArr);
                getIntent().putExtra(INTENT_GROUP_ADDRESS_ISHIDDEN, z);
                getIntent().putExtra(INTENT_GROUP_SELECTEDINDEX, i2);
                setRequestCode(i);
                setIntentAction(IntentAction.ActivityForResult);
                return;
            }
        }
    }
}
