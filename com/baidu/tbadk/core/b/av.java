package com.baidu.tbadk.core.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class av extends com.baidu.tbadk.core.frameworkData.a {
    public av(Activity activity, int i, String str, String str2, String str3, String str4, int i2, AntiData antiData, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6, AdditionData additionData, PostPrefixData postPrefixData) {
        super(activity);
        a(IntentAction.ActivityForResult);
        a(i3);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.i.a((Context) activity, antiData.getForbid_info());
            return;
        }
        d().putExtra("type", i);
        d().putExtra("forum_id", str);
        d().putExtra("forum_name", str2);
        d().putExtra("reply_sub_pb", z2);
        d().putExtra("is_ad", false);
        if (antiData != null) {
            d().putExtra("enable_audio", antiData.isIfvoice());
            d().putExtra("disable_audio_message", antiData.getVoice_message());
        }
        if (str6 != null) {
            d().putExtra("file_name", str6);
        }
        d().putExtra("refresh_pic", z4);
        if (z) {
            d().putExtra("feed_back", true);
        }
        if (str3 != null) {
            d().putExtra("thread_id", str3);
        }
        if (str4 != null) {
            d().putExtra("floor_id", str4);
        }
        if (i2 > 0) {
            d().putExtra("floor_num", i2);
        }
        if (str5 != null) {
            d().putExtra("sub_user_name", str5);
        }
        if (additionData != null) {
            d().putExtra("addition_data", additionData);
        }
        if (postPrefixData != null) {
            d().putExtra("prefix_data", postPrefixData);
        }
    }
}
