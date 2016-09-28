package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ForumDetailActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";
    public static final String FROM_TYPE = "from_type";

    /* loaded from: classes.dex */
    public enum FromType {
        BAR,
        FRS,
        FRS_SIDE,
        BAR_DIR,
        BAR_RANK,
        BAR_SQUARE;

        /* JADX DEBUG: Replace access to removed values field (OB) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static FromType[] valuesCustom() {
            FromType[] valuesCustom = values();
            int length = valuesCustom.length;
            FromType[] fromTypeArr = new FromType[length];
            System.arraycopy(valuesCustom, 0, fromTypeArr, 0, length);
            return fromTypeArr;
        }
    }

    public ForumDetailActivityConfig(Context context, String str, FromType fromType) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra(FROM_TYPE, fromType.toString());
    }
}
