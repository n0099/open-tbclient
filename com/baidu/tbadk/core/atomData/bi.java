package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class bi extends com.baidu.tbadk.core.frameworkData.a {
    public bi(Activity activity, int i, String str, String str2, String str3, String str4, int i2, AntiData antiData, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6, AdditionData additionData, PostPrefixData postPrefixData) {
        super(activity);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.k.a((Context) activity, antiData.getForbid_info());
            return;
        }
        getIntent().putExtra("type", i);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, str);
        getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str2);
        getIntent().putExtra("reply_sub_pb", z2);
        getIntent().putExtra("is_ad", z3);
        if (antiData != null) {
            getIntent().putExtra("enable_audio", antiData.isIfvoice());
            getIntent().putExtra("disable_audio_message", antiData.getVoice_message());
        }
        if (str6 != null) {
            getIntent().putExtra("file_name", str6);
        }
        getIntent().putExtra("refresh_pic", z4);
        if (z) {
            getIntent().putExtra("feed_back", true);
        }
        if (str3 != null) {
            getIntent().putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str3);
        }
        if (str4 != null) {
            getIntent().putExtra("floor_id", str4);
        }
        if (i2 > 0) {
            getIntent().putExtra("floor_num", i2);
        }
        if (str5 != null) {
            getIntent().putExtra("sub_user_name", str5);
        }
        if (additionData != null) {
            getIntent().putExtra("addition_data", additionData);
        }
        if (postPrefixData != null) {
            getIntent().putExtra("prefix_data", postPrefixData);
        }
    }

    public void a(int i, String str, String str2, int i2, int i3, String str3, String str4, String str5) {
        getIntent().putExtra("is_live_post", true);
        getIntent().putExtra("live_group_id", i);
        if (str != null) {
            getIntent().putExtra("live_group_head", str);
        }
        if (str2 != null) {
            getIntent().putExtra("live_group_name", str2);
        }
        if (str4 != null) {
            getIntent().putExtra("live_group_author_head", str4);
        }
        getIntent().putExtra("live_group_member_count", i2);
        getIntent().putExtra("live_group_zan_count", i3);
        if (str3 != null) {
            getIntent().putExtra("live_group_author", str3);
        }
        if (str5 != null) {
            getIntent().putExtra("live_group_intro", str5);
        }
    }
}
