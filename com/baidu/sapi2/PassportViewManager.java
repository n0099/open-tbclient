package com.baidu.sapi2;

import android.graphics.drawable.Drawable;
import com.baidu.j.a.a;
import com.baidu.sapi2.callback.TitleBtnCallback;
/* loaded from: classes3.dex */
public class PassportViewManager implements NoProguard {
    private static SapiConfiguration c;
    private static PassportViewManager d;

    /* renamed from: a  reason: collision with root package name */
    private TitleBtnCallback f3118a;
    private TitleViewModule b = null;

    /* loaded from: classes3.dex */
    public static class TitleViewModule implements NoProguard {
        public static final int DEFAULT_TEXT_COLOR = PassportViewManager.c.context.getResources().getColor(a.b.sapi_sdk_edit_text_color);
        public int bgColor = Integer.MAX_VALUE;
        public int bgHeight = Integer.MAX_VALUE;
        public int leftBtnImgResId = Integer.MAX_VALUE;
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
        return this.f3118a;
    }

    public TitleViewModule getTitleViewModule() {
        return this.b;
    }

    public void release() {
        this.f3118a = null;
        this.b = null;
        SapiWebView.statLoadLogin = null;
    }

    public void setTitleBtnCallback(TitleBtnCallback titleBtnCallback) {
        this.f3118a = titleBtnCallback;
    }
}
