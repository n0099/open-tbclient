package com.baidu.sapi2;

import android.graphics.drawable.Drawable;
import com.baidu.sapi2.callback.TitleBtnCallback;
import d.a.a0.a.b;
import d.a.a0.a.c;
import d.a.a0.a.d;
/* loaded from: classes2.dex */
public class PassportViewManager implements NoProguard {

    /* renamed from: c  reason: collision with root package name */
    public static SapiConfiguration f9533c;

    /* renamed from: d  reason: collision with root package name */
    public static PassportViewManager f9534d;

    /* renamed from: a  reason: collision with root package name */
    public TitleBtnCallback f9535a;

    /* renamed from: b  reason: collision with root package name */
    public TitleViewModule f9536b = null;

    /* loaded from: classes2.dex */
    public static class TitleViewModule implements NoProguard {
        public static final int DEFAULT_TEXT_COLOR = PassportViewManager.f9533c.context.getResources().getColor(b.sapi_sdk_edit_text_color);
        public int bgColor = Integer.MAX_VALUE;
        public int bgHeight = Integer.MAX_VALUE;
        public int leftBtnImgResId = Integer.MAX_VALUE;
        public int leftBtnImgVisible = 0;
        public int leftBtnTextColor = DEFAULT_TEXT_COLOR;
        public String leftBtnText = null;
        public int leftBtnTextVisible = 4;
        public float leftBtnTextSize = PassportViewManager.f9533c.context.getResources().getDimension(c.sapi_sdk_title_left_btn_text_size);
        public Drawable leftBtnDrawableLeft = null;
        public Drawable leftBtnDrawableTop = null;
        public Drawable leftBtnDrawableRight = null;
        public Drawable leftBtnDrawableBottom = null;
        public int titleTextColor = DEFAULT_TEXT_COLOR;
        public String titleText = null;
        public int titleVisible = 0;
        public float titleTextSize = PassportViewManager.f9533c.context.getResources().getDimension(c.sapi_sdk_title_text_size);
        public boolean titleTextBold = false;
        public boolean useWebviewTitle = true;
        public Drawable titleDrawableLeft = null;
        public Drawable titleDrawableTop = null;
        public Drawable titleDrawableRight = null;
        public Drawable titleDrawableBottom = null;
        public int rightBtnTextColor = DEFAULT_TEXT_COLOR;
        public String rightBtnText = null;
        public int rightBtnVisible = 4;
        public float rightBtnTextSize = PassportViewManager.f9533c.context.getResources().getDimension(c.sapi_sdk_title_right_btn_text_size);
        public int dividerLineVisible = 0;
    }

    public PassportViewManager() {
        f9533c = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    public static synchronized PassportViewManager getInstance() {
        PassportViewManager passportViewManager;
        synchronized (PassportViewManager.class) {
            if (f9534d == null) {
                f9534d = new PassportViewManager();
            }
            passportViewManager = f9534d;
        }
        return passportViewManager;
    }

    public void configTitle(TitleViewModule titleViewModule) {
        this.f9536b = titleViewModule;
        if (titleViewModule.bgColor == Integer.MAX_VALUE) {
            titleViewModule.bgColor = -1;
        }
        if (titleViewModule.leftBtnImgResId == Integer.MAX_VALUE) {
            titleViewModule.leftBtnImgResId = d.sapi_sdk_btn_back;
        }
    }

    public TitleBtnCallback getTitleBtnCallback() {
        return this.f9535a;
    }

    public TitleViewModule getTitleViewModule() {
        return this.f9536b;
    }

    public void release() {
        this.f9535a = null;
        this.f9536b = null;
        SapiWebView.statLoadLogin = null;
    }

    public void setTitleBtnCallback(TitleBtnCallback titleBtnCallback) {
        this.f9535a = titleBtnCallback;
    }
}
