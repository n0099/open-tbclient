package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes.dex */
public class a {
    public Activity activity;
    public int channel;
    public ShareItem evY;
    public DialogInterface.OnCancelListener onCancelListener;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.evY = shareItem;
        this.activity = activity;
        this.onCancelListener = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i) {
        this.evY = shareItem;
        this.activity = activity;
        this.channel = i;
    }
}
