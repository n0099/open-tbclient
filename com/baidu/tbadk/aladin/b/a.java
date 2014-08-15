package com.baidu.tbadk.aladin.b;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class a {
    public boolean a(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("type");
            if (stringExtra == null) {
                if (com.baidu.tbadk.core.b.b.a() != null) {
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
                if (!TextUtils.isEmpty(intent.getStringExtra("fname"))) {
                    return true;
                }
            } else if (stringExtra.equals("groupinfo")) {
                if (!TextUtils.isEmpty(intent.getStringExtra("groupid"))) {
                    return true;
                }
            } else if (stringExtra.equals("pay")) {
                if (TbadkApplication.m252getInst().isDQShouldOpen()) {
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
