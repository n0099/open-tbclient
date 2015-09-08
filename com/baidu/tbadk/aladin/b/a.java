package com.baidu.tbadk.aladin.b;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
/* loaded from: classes.dex */
public class a {
    public boolean G(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("type");
            if (stringExtra == null) {
                if (com.baidu.tbadk.core.c.b.tq() != null) {
                    return true;
                }
            } else if (stringExtra.equals("web")) {
                if (!TextUtils.isEmpty(intent.getStringExtra("url"))) {
                    return true;
                }
            } else if (stringExtra.equals("pb")) {
                if (!TextUtils.isEmpty(intent.getStringExtra("id"))) {
                    return true;
                }
            } else if (stringExtra.equals("frs")) {
                if (!TextUtils.isEmpty(intent.getStringExtra(ImageViewerConfig.FORUM_NAME))) {
                    return true;
                }
            } else if (stringExtra.equals("groupinfo")) {
                if (!TextUtils.isEmpty(intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID))) {
                    return true;
                }
            } else if (stringExtra.equals("pay")) {
                if (TbadkCoreApplication.m411getInst().isDQShouldOpen()) {
                    return true;
                }
            } else if (stringExtra.equals("livegroup")) {
                if (!TextUtils.isEmpty(intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID))) {
                    return true;
                }
            } else if (stringExtra.equals("officialba_msg")) {
                if (!TextUtils.isEmpty(intent.getStringExtra("barid")) && !TextUtils.isEmpty(intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING))) {
                    return true;
                }
            } else if (!stringExtra.equals("recommendpb")) {
                return false;
            } else {
                if (!TextUtils.isEmpty(intent.getStringExtra(PbChosenActivityConfig.KEY_TID))) {
                    return true;
                }
            }
        }
        return false;
    }
}
