package com.baidu.cloudsdk.social.share;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialWidget;
import com.baidu.cloudsdk.social.core.WidgetStatisticsManager;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
import com.baidu.cloudsdk.social.share.handler.FacebookShareHandler;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
import com.baidu.cloudsdk.social.share.handler.SocialShareHandlerFactory;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
import com.baidu.cloudsdk.social.share.handler.TwitterShareHandler;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareUIWidget;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class SocialShare extends SocialWidget {
    private static SocialShare a;
    private Theme b;
    private View c;
    private ShareUIWidget d;

    /* loaded from: classes.dex */
    public enum Theme {
        LIGHT,
        DARK,
        NIGHT
    }

    private SocialShare(Context context) {
        super(context);
        this.b = Theme.LIGHT;
    }

    public static void clean() {
        if (a != null) {
            SessionManager.clean();
            SocialShareConfig.clean();
            SocialConfig.clean();
            ImageManager.clean();
            SocialOAuthActivity.setListener(null);
            a.mContext = null;
            a = null;
        }
    }

    public static SocialShare getInstance(Context context) {
        if (a == null) {
            a = new SocialShare(context);
        } else {
            a.setContext(context);
        }
        return a;
    }

    public View getParentView() {
        return this.c;
    }

    public Theme getTheme() {
        return this.b;
    }

    @Override // com.baidu.cloudsdk.social.core.SocialWidget
    protected WidgetStatisticsManager getWidgetStatisticsManager() {
        return SocialShareStatisticsManager.getInstance(this.mContext);
    }

    public void hide() {
        if (this.d != null) {
            this.d.hide();
        }
    }

    public SocialShare setParentView(View view) {
        this.c = view;
        return this;
    }

    public SocialShare setTheme(Theme theme) {
        this.b = theme;
        return this;
    }

    public void share(ShareContent shareContent, String str, IBaiduListener iBaiduListener) {
        share(shareContent, str, iBaiduListener, false);
    }

    public void share(ShareContent shareContent, String str, IBaiduListener iBaiduListener, boolean z) {
        Validator.notNull(shareContent, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
        Validator.notNullOrEmpty(str, "mediaType");
        ISocialShareHandler newInstance = new SocialShareHandlerFactory(this.mContext, this.mClientId, this.b).newInstance(str);
        if (newInstance != null) {
            newInstance.share(shareContent, iBaiduListener, z);
        } else if (iBaiduListener != null) {
            iBaiduListener.onError(new BaiduException("no sharing handler for " + str));
        }
    }

    public void share(ShareContent shareContent, String[] strArr, IBaiduListener iBaiduListener, boolean z) {
        Validator.notNull(shareContent, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
        Validator.notNullOrEmpty(strArr, "mediaTypes");
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        if (arrayList.contains(MediaType.FACEBOOK.toString())) {
            Log.d("SocialShare", "share to FaceBook");
            arrayList.remove(MediaType.FACEBOOK.toString());
            new FacebookShareHandler(this.mContext, SocialConfig.getInstance(this.mContext).getClientId(MediaType.FACEBOOK.toString()), false).share(shareContent, iBaiduListener, z);
        }
        if (arrayList.contains(MediaType.TWITTER.toString())) {
            Log.d("SocialShare", "share to TWITTER");
            arrayList.remove(MediaType.TWITTER.toString());
            new TwitterShareHandler(this.mContext, this.mClientId, false).share(shareContent, iBaiduListener, z);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        new CloudBatchShareHandler(this.mContext, this.mClientId, strArr2).share(shareContent, iBaiduListener, z);
    }

    public void show(View view, ShareContent shareContent, Theme theme, IBaiduListener iBaiduListener) {
        show(view, shareContent, theme, iBaiduListener, false);
    }

    public void show(View view, ShareContent shareContent, Theme theme, IBaiduListener iBaiduListener, boolean z) {
        if (!z && view != null) {
            this.c = view;
        } else if (z && this.c == null && view != null) {
            this.c = view;
        } else if (this.c == null) {
            throw new NullPointerException("no valid parent view specified");
        }
        this.b = theme;
        if (this.d == null) {
            this.d = new ShareUIWidget(this.mContext);
        }
        this.d.setContext(this.mContext);
        this.d.show(this.c, shareContent, theme, iBaiduListener, z);
    }
}
