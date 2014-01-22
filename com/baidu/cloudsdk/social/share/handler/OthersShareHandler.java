package com.baidu.cloudsdk.social.share.handler;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import com.ak;
import com.baidu.cloudsdk.Build;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.ShareContent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class OthersShareHandler extends ak {
    private static final String a = OthersShareHandler.class.getSimpleName();

    public OthersShareHandler(Context context, IBaiduListener iBaiduListener, int i) {
        super(context, iBaiduListener, i, MediaType.OTHERS.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ak
    public void doShare(Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.isEmpty()) {
            onStartLocalShareFailed("no_others", this.mListener);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (Build.DEBUG) {
                Log.d(a, activityInfo.packageName + "   " + activityInfo.name);
            }
            List noSupportedPackages = this.mConfig.getNoSupportedPackages();
            if (noSupportedPackages == null || noSupportedPackages.size() == 0 || !noSupportedPackages.contains(activityInfo.packageName)) {
                arrayList.add(activityInfo.packageName.equalsIgnoreCase("com.android.mms") ? getSmsIntent(uri) : activityInfo.packageName.equalsIgnoreCase("com.android.email") ? getEmailIntent(uri) : getOthersIntent(uri, activityInfo.packageName));
            }
        }
        String string = this.mConfig.getString("chooser_title");
        if (arrayList.isEmpty()) {
            onStartLocalShareFailed("no_others", this.mListener);
            return;
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), string);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        try {
            ((Activity) this.mContext).startActivityForResult(createChooser, this.mRequestCode);
        } catch (ActivityNotFoundException e) {
            onStartLocalShareFailed("no_others", this.mListener);
        }
    }

    @Override // com.ak, com.ag
    public /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.ak, com.ag, com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public /* bridge */ /* synthetic */ void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        super.share(shareContent, iBaiduListener, z);
    }
}
