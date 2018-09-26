package com.baidu.sapi2;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.d.a.a;
import com.baidu.sapi2.callback.TitleBtnCallback;
/* loaded from: classes2.dex */
public class PassportViewManager {
    private static SapiConfiguration configuration;
    private static PassportViewManager instance;
    private TitleBtnCallback titleBtnCallback;
    private ReloadWebviewObserver webviewObserver;
    private View noNetworkView = null;
    private View timeoutView = null;
    private ProgressBar progressBar = null;
    private View webviewLoadingView = null;
    private TitleViewModule titleViewModule = null;

    /* loaded from: classes2.dex */
    public interface ReloadWebviewObserver {
        void onWebviewReload();
    }

    /* loaded from: classes2.dex */
    public static class TitleViewModule {
        public static final int DEFAULT_TEXT_COLOR = PassportViewManager.configuration.context.getResources().getColor(a.C0060a.sapi_sdk_edit_text_color);
        public int bgColor = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        public int leftBtnImgResId = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        public int leftBtnImgVisible = 0;
        public int leftBtnTextColor = DEFAULT_TEXT_COLOR;
        public String leftBtnText = null;
        public int leftBtnTextVisible = 4;
        public float leftBtnTextSize = PassportViewManager.configuration.context.getResources().getDimension(a.b.sapi_sdk_title_left_btn_text_size);
        public Drawable leftBtnDrawableLeft = null;
        public Drawable leftBtnDrawableTop = null;
        public Drawable leftBtnDrawableRight = null;
        public Drawable leftBtnDrawableBottom = null;
        public int titleTextColor = DEFAULT_TEXT_COLOR;
        public String titleText = null;
        public int titleVisible = 0;
        public float titleTextSize = PassportViewManager.configuration.context.getResources().getDimension(a.b.sapi_sdk_title_text_size);
        public boolean useWebviewTitle = true;
        public Drawable titleDrawableLeft = null;
        public Drawable titleDrawableTop = null;
        public Drawable titleDrawableRight = null;
        public Drawable titleDrawableBottom = null;
        public int rightBtnTextColor = DEFAULT_TEXT_COLOR;
        public String rightBtnText = null;
        public int rightBtnVisible = 4;
        public float rightBtnTextSize = PassportViewManager.configuration.context.getResources().getDimension(a.b.sapi_sdk_title_right_btn_text_size);
    }

    private PassportViewManager() {
        configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    public static synchronized PassportViewManager getInstance() {
        PassportViewManager passportViewManager;
        synchronized (PassportViewManager.class) {
            if (instance == null) {
                instance = new PassportViewManager();
            }
            passportViewManager = instance;
        }
        return passportViewManager;
    }

    public TitleBtnCallback getTitleBtnCallback() {
        return this.titleBtnCallback;
    }

    public void setTitleBtnCallback(TitleBtnCallback titleBtnCallback) {
        this.titleBtnCallback = titleBtnCallback;
    }

    public TitleViewModule getTitleViewModule() {
        return this.titleViewModule;
    }

    public View getNoNetworkView() {
        return this.noNetworkView;
    }

    public View getTimeoutView() {
        return this.timeoutView;
    }

    public ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public View getWebviewLoadingView() {
        return this.webviewLoadingView;
    }

    public void setNoNetworkView(View view) {
        this.noNetworkView = view;
    }

    public void setTimeoutView(View view) {
        this.timeoutView = view;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void setWebviewLoadingView(View view) {
        this.webviewLoadingView = view;
    }

    public void reloadWebview() {
        if (this.webviewObserver != null) {
            this.webviewObserver.onWebviewReload();
        }
    }

    public void setReloadWebviewObserver(ReloadWebviewObserver reloadWebviewObserver) {
        this.webviewObserver = reloadWebviewObserver;
    }

    public void configTitle(TitleViewModule titleViewModule) {
        this.titleViewModule = titleViewModule;
        if (titleViewModule.bgColor == Integer.MAX_VALUE) {
            titleViewModule.bgColor = -1;
        }
        if (titleViewModule.leftBtnImgResId == Integer.MAX_VALUE) {
            titleViewModule.leftBtnImgResId = a.c.sapi_sdk_btn_back;
        }
    }

    public void release() {
        this.noNetworkView = null;
        this.timeoutView = null;
        this.progressBar = null;
        this.webviewObserver = null;
        this.titleBtnCallback = null;
        this.titleViewModule = null;
    }
}
