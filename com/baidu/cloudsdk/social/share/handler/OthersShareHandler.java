package com.baidu.cloudsdk.social.share.handler;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import com.baidu.cloudsdk.Build;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.MobileQQ;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class OthersShareHandler extends am {

    /* renamed from: a  reason: collision with root package name */
    private static final String f865a = OthersShareHandler.class.getSimpleName();
    private static Map b = new HashMap();

    static {
        b.put("com.android.email", MediaType.EMAIL);
        b.put("com.android.mms", MediaType.SMS);
        b.put("com.sina.weibo", MediaType.SINAWEIBO);
        b.put(MobileQQ.PACKAGE_NAME, MediaType.QQFRIEND);
        b.put(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN, MediaType.WEIXIN);
        b.put("com.qzone", MediaType.QZONE);
    }

    public OthersShareHandler(Activity activity, IBaiduListener iBaiduListener, int i) {
        super(activity, iBaiduListener, i, MediaType.OTHERS.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.am
    public void doShare(Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.isEmpty()) {
            onStartLocalShareFailed("no_others", this.mListener);
            return;
        }
        boolean z = this.mConfig.getInt("no_supported_medias_in_others") != 0;
        List supportedMediaTypes = this.mConfig.getSupportedMediaTypes();
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (Build.DEBUG) {
                Log.d(f865a, activityInfo.packageName + "   " + activityInfo.name);
            }
            if (z) {
                MediaType mediaType = (MediaType) b.get(activityInfo.packageName);
                if (!supportedMediaTypes.contains(mediaType)) {
                    if (mediaType == MediaType.WEIXIN) {
                        if (!supportedMediaTypes.contains(MediaType.WEIXIN_FRIEND) && !supportedMediaTypes.contains(MediaType.WEIXIN_TIMELINE)) {
                        }
                    }
                }
            }
            arrayList.add(activityInfo.packageName.equalsIgnoreCase("com.android.mms") ? getSmsIntent(uri) : activityInfo.packageName.equalsIgnoreCase("com.android.email") ? getEmailIntent(uri) : getOthersIntent(uri, activityInfo.packageName));
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), this.mConfig.getString("chooser_title"));
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        try {
            this.mActivity.startActivityForResult(createChooser, this.mRequestCode);
        } catch (ActivityNotFoundException e) {
            onStartLocalShareFailed("no_others", this.mListener);
        }
    }

    @Override // defpackage.am, defpackage.ai
    public /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // defpackage.am, defpackage.ai, com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public /* bridge */ /* synthetic */ void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        super.share(shareContent, iBaiduListener, z);
    }
}
