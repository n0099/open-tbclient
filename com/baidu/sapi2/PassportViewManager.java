package com.baidu.sapi2;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.k.a.a;
import com.baidu.sapi2.callback.TitleBtnCallback;
/* loaded from: classes25.dex */
public class PassportViewManager implements NoProguard {
    private static SapiConfiguration c;
    private static PassportViewManager d;
    private TitleBtnCallback a;
    private TitleViewModule b = null;

    /* loaded from: classes25.dex */
    public static class TitleViewModule implements NoProguard {
        public static final int DEFAULT_TEXT_COLOR = PassportViewManager.c.context.getResources().getColor(a.b.sapi_sdk_edit_text_color);
        public int bgColor = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        public int bgHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        public int leftBtnImgResId = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        public int leftBtnImgVisible = 0;
        public int leftBtnTextColor = DEFAULT_TEXT_COLOR;
        public String leftBtnText = null;
        public int leftBtnTextVisible = 4;
        public float leftBtnTextSize = PassportViewManager.c.context.getResources().getDimension(a.c.sapi_sdk_title_left_btn_text_size);
        public Drawable leftBtnDrawableLeft = null;
        public Drawable leftBtnDrawableTop = null;
        public Drawable leftBtnDrawableRight = null;
        public Drawable leftBtnDrawableBottom = null;
        public int titleTextColor = DEFAULT_TEXT_COLOR;
        public String titleText = null;
        public int titleVisible = 0;
        public float titleTextSize = PassportViewManager.c.context.getResources().getDimension(a.c.sapi_sdk_title_text_size);
        public boolean titleTextBold = false;
        public boolean useWebviewTitle = true;
        public Drawable titleDrawableLeft = null;
        public Drawable titleDrawableTop = null;
        public Drawable titleDrawableRight = null;
        public Drawable titleDrawableBottom = null;
        public int rightBtnTextColor = DEFAULT_TEXT_COLOR;
        public String rightBtnText = null;
        public int rightBtnVisible = 4;
        public float rightBtnTextSize = PassportViewManager.c.context.getResources().getDimension(a.c.sapi_sdk_title_right_btn_text_size);
        public int dividerLineVisible = 0;
    }

    private PassportViewManager() {
        c = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    public static synchronized PassportViewManager getInstance() {
        PassportViewManager passportViewManager;
        synchronized (PassportViewManager.class) {
            if (d == null) {
                d = new PassportViewManager();
            }
            passportViewManager = d;
        }
        return passportViewManager;
    }

    public void configTitle(TitleViewModule titleViewModule) {
        this.b = titleViewModule;
        if (titleViewModule.bgColor == Integer.MAX_VALUE) {
            titleViewModule.bgColor = -1;
        }
        if (titleViewModule.leftBtnImgResId == Integer.MAX_VALUE) {
            titleViewModule.leftBtnImgResId = a.d.sapi_sdk_btn_back;
        }
    }

    public TitleBtnCallback getTitleBtnCallback() {
        return this.a;
    }

    public TitleViewModule getTitleViewModule() {
        return this.b;
    }

    public void release() {
        this.a = null;
        this.b = null;
        SapiWebView.statLoadLogin = null;
    }

    public void setTitleBtnCallback(TitleBtnCallback titleBtnCallback) {
        this.a = titleBtnCallback;
    }
}
