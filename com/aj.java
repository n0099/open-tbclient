package com;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
/* loaded from: classes.dex */
public class aj extends ak {
    public aj(Context context, IBaiduListener iBaiduListener, int i) {
        super(context, iBaiduListener, i, MediaType.SMS.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ak
    public void doShare(Uri uri) {
        try {
            ((Activity) this.mContext).startActivityForResult(getSmsIntent(uri), this.mRequestCode);
        } catch (ActivityNotFoundException e) {
            onStartLocalShareFailed("no_valid_sms_app", this.mListener);
        }
    }
}
