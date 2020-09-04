package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MemberExchangeActivityConfig extends IntentConfig {
    public static final String DESC_STR = "desc_str";
    public static final String DUE_DATE = "due_date";
    public static final String MEMBER_IMAGE = "member_image";
    public static final String MEMBER_LEVEL_IMAGE = "member_level_image";
    public static final String MEMBER_NAME = "member_name";

    public MemberExchangeActivityConfig(Context context, String str, String str2, String str3, String str4, String str5) {
        super(context);
        getIntent().putExtra(MEMBER_IMAGE, str);
        getIntent().putExtra(MEMBER_NAME, str2);
        getIntent().putExtra(MEMBER_LEVEL_IMAGE, str3);
        getIntent().putExtra(DUE_DATE, str4);
        getIntent().putExtra(DESC_STR, str5);
    }

    /* loaded from: classes.dex */
    public class MemberInfo implements Serializable {
        private String dueDate;
        private String memberImage;
        private String memberLevelIcon;
        private String memberName;

        public MemberInfo() {
        }
    }

    /* loaded from: classes.dex */
    public class VipRecommendData implements Serializable {
        private int dayCounts;
        private String descStr;
        private String expire;
        private String nextLevelStr;
        private int vipDays;

        public VipRecommendData() {
        }
    }
}
