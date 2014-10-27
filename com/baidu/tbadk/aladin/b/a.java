package com.baidu.tbadk.aladin.b;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* loaded from: classes.dex */
public class a {
    public boolean b(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("type");
            if (stringExtra == null) {
                if (com.baidu.tbadk.core.b.b.ld() != null) {
                    return true;
                }
            } else if (stringExtra.equals("web")) {
                if (!TextUtils.isEmpty(intent.getStringExtra(ImageViewerConfig.URL))) {
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
                if (!TextUtils.isEmpty(intent.getStringExtra("groupid"))) {
                    return true;
                }
            } else if (stringExtra.equals("pay")) {
                if (TbadkApplication.m251getInst().isDQShouldOpen()) {
                    return true;
                }
            } else if (stringExtra.equals("livegroup")) {
                if (!TextUtils.isEmpty(intent.getStringExtra("groupid"))) {
                    return true;
                }
            } else if (!stringExtra.equals("officialba_msg")) {
                return false;
            } else {
                if (!TextUtils.isEmpty(intent.getStringExtra("barid")) && !TextUtils.isEmpty(intent.getStringExtra("barname"))) {
                    return true;
                }
            }
        }
        return false;
    }
}
