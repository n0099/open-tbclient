package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes4.dex */
public class YuyinAlaPersonCardActivityConfig extends AlaPersonCardActivityConfig {
    public static final String PERSON_REENTER_GIFTCARD = "PERSON_REENTER_GIFTCARD";
    public static final String PERSON_USER_KEY = "PERSON_USER_KEY";

    public YuyinAlaPersonCardActivityConfig(Context context, String str) {
        super(context, str);
    }

    public YuyinAlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, long j, long j2, long j3, int i3, String str6, String str7, boolean z, String str8, String str9, String str10, String str11) {
        super(context, str, str2, str3, i, i2, str4, str5, j, j2, j3, i3, str6, str7, z, str8, str9, str10, str11);
    }

    public YuyinAlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, long j, long j2, long j3, int i3, String str6, String str7, boolean z, String str8, String str9, String str10, String str11, String str12) {
        super(context, str, str2, str3, i, i2, str4, str5, j, j2, j3, i3, str6, str7, z, str8, str9, str10, str11, str12);
    }

    public YuyinAlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, long j, long j2, long j3, int i3, String str6, String str7, boolean z, String str8, String str9, String str10, String str11, String str12, boolean z2) {
        super(context, str, str2, str3, i, i2, str4, str5, j, j2, j3, i3, str6, str7, z, str8, str9, str10, str11, str12, z2);
    }

    public YuyinAlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i, int i2, String str4, String str5, long j, long j2, long j3, int i3, String str6, String str7, boolean z, String str8, String str9, String str10) {
        super(context, str, str2, str3, i, i2, str4, str5, j, j2, j3, i3, str6, str7, z, str8, str9, str10);
    }

    public YuyinAlaPersonCardActivityConfig(Context context, String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, long j, long j2, long j3, int i3, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13) {
        super(context, str, str3, str4, i, i2, str5, str6, j, j2, j3, i3, str7, str8, z, str9, str10, str11, str12, str13);
        getIntent().putExtra(PERSON_USER_KEY, str2);
    }

    public void cacheReEnterGiftPanel(Intent intent) {
        getIntent().putExtra(PERSON_REENTER_GIFTCARD, intent);
    }
}
