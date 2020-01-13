package com.baidu.sapi2;

import android.graphics.drawable.Drawable;
import com.baidu.i.a.a;
import com.baidu.sapi2.callback.TitleBtnCallback;
/* loaded from: classes5.dex */
public class PassportViewManager implements c {
    private static SapiConfiguration a;
    private static PassportViewManager b;
    private TitleBtnCallback c;
    private TitleViewModule d = null;

    /* loaded from: classes5.dex */
    public static class TitleViewModule implements c {
        public static final int DEFAULT_TEXT_COLOR = PassportViewManager.a.context.getResources().getColor(a.b.sapi_sdk_edit_text_color);
        public int bgColor = Integer.MAX_VALUE;
        public int bgHeight = Integer.MAX_VALUE;
        public int leftBtnImgResId = Integer.MAX_VALUE;
        public int leftBtnImgVisible = 0;
        public int leftBtnTextColor = DEFAULT_TEXT_COLOR;
        public String leftBtnText = null;
        public int leftBtnTextVisible = 4;
        public float leftBtnTextSize = PassportViewManager.a.context.getResources().getDimension(a.c.sapi_sdk_title_left_btn_text_size);
        public Drawable leftBtnDrawableLeft = null;
        public Drawable leftBtnDrawableTop = null;
        public Drawable leftBtnDrawableRight = null;
        public Drawable leftBtnDrawableBottom = null;
        public int titleTextColor = DEFAULT_TEXT_COLOR;
        public String titleText = null;
        public int titleVisible = 0;
        public float titleTextSize = PassportViewManager.a.context.getResources().getDimension(a.c.sapi_sdk_title_text_size);
        public boolean titleTextBold = false;
        public boolean useWebviewTitle = true;
        public Drawable titleDrawableLeft = null;
        public Drawable titleDrawableTop = null;
        public Drawable titleDrawableRight = null;
        public Drawable titleDrawableBottom = null;
        public int rightBtnTextColor = DEFAULT_TEXT_COLOR;
        public String rightBtnText = null;
        public int rightBtnVisible = 4;
        public float rightBtnTextSize = PassportViewManager.a.context.getResources().getDimension(a.c.sapi_sdk_title_right_btn_text_size);
        public int dividerLineVisible = 0;
    }

    private PassportViewManager() {
        a = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    public static synchronized PassportViewManager getInstance() {
        PassportViewManager passportViewManager;
        synchronized (PassportViewManager.class) {
            if (b == null) {
                b = new PassportViewManager();
            }
            passportViewManager = b;
        }
        return passportViewManager;
    }

    public void configTitle(TitleViewModule titleViewModule) {
        this.d = titleViewModule;
        if (titleViewModule.bgColor == Integer.MAX_VALUE) {
            titleViewModule.bgColor = -1;
        }
        if (titleViewModule.leftBtnImgResId == Integer.MAX_VALUE) {
            titleViewModule.leftBtnImgResId = a.d.sapi_sdk_btn_back;
        }
    }

    public TitleBtnCallback getTitleBtnCallback() {
        return this.c;
    }

    public TitleViewModule getTitleViewModule() {
        return this.d;
    }

    public void release() {
        this.c = null;
        this.d = null;
    }

    public void setTitleBtnCallback(TitleBtnCallback titleBtnCallback) {
        this.c = titleBtnCallback;
    }
}
