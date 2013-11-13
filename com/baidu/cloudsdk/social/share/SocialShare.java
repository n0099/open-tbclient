package com.baidu.cloudsdk.social.share;

import android.content.Context;
import android.view.View;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.SocialWidget;
import com.baidu.cloudsdk.social.core.WidgetStatisticsManager;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
import com.baidu.cloudsdk.social.share.handler.SocialShareHandlerFactory;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
import com.baidu.cloudsdk.social.share.ui.ShareUIWidget;
/* loaded from: classes.dex */
public class SocialShare extends SocialWidget {

    /* renamed from: a  reason: collision with root package name */
    private static SocialShare f857a;
    private Theme b;
    private View c;

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

    public static SocialShare getInstance(Context context) {
        if (f857a == null) {
            f857a = new SocialShare(context);
        } else {
            f857a.setContext(context);
        }
        return f857a;
    }

    public View getParentView() {
        return this.c;
    }

    @Override // com.baidu.cloudsdk.social.core.SocialWidget
    protected WidgetStatisticsManager getWidgetStatisticsManager() {
        return SocialShareStatisticsManager.getInstance(this.mContext);
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
        Validator.notNull(shareContent, "content");
        Validator.notNullOrEmpty(str, "mediaType");
        ISocialShareHandler newInstance = new SocialShareHandlerFactory(this.mContext, this.mClientId, this.b).newInstance(str);
        if (newInstance != null) {
            newInstance.share(shareContent, iBaiduListener, z);
        } else if (iBaiduListener != null) {
            iBaiduListener.onError(new BaiduException("no sharing handler for " + str));
        }
    }

    public void share(ShareContent shareContent, String[] strArr, IBaiduListener iBaiduListener, boolean z) {
        Validator.notNull(shareContent, "content");
        Validator.notNullOrEmpty(strArr, "mediaTypes");
        new CloudBatchShareHandler(this.mContext, this.mClientId, strArr).share(shareContent, iBaiduListener, z);
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
        ShareUIWidget.getInstance(getContext()).show(this.c, shareContent, theme, iBaiduListener, z);
    }
}
