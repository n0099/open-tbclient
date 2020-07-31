package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes.dex */
public class a {
    public Activity activity;
    public int channel;
    public ShareItem dLR;

    public a(ShareItem shareItem, Activity activity) {
        this.dLR = shareItem;
        this.activity = activity;
    }

    public a(ShareItem shareItem, Activity activity, int i) {
        this.dLR = shareItem;
        this.activity = activity;
        this.channel = i;
    }
}
