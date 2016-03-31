package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonalCardDetailActivityConfig extends IntentConfig {
    public static final String CARD_ID = "card_id";

    public PersonalCardDetailActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra(CARD_ID, j);
    }
}
