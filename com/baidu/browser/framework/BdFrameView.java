package com.baidu.browser.framework;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.browser.Browser;
import com.baidu.browser.FloatSearchBoxLayout;
import com.baidu.browser.core.ui.BdPopMenuGroup;
import com.baidu.browser.core.ui.BdPopMenuListener;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.browser.framework.BdWindowTabCtrl;
import com.baidu.browser.webkit.BdValueCallback;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BdFrameView extends FrameLayout implements View.OnTouchListener, BdPopMenuListener, BdWindowTabCtrl.BdTabCtrlListener {
    public static final int UI_BROWSER_ID = 3;
    private View backView;
    private View exitView;
    private View forwordView;
    private int mAnchorImagePopMenu;
    private Browser mBrowser;
    private BdWindow mCurrentWindow;
    private int mImagePopMenu;
    private int mMaxTabNum;
    private BdPopMenuGroup mPopMenuGroup;
    private ProgressBar mProgressBar;
    private int mProgressHeight;
    private int mSearchWindowPopMenu;
    private int mSelectedPopMenu;
    private boolean mShowAdView;
    private int mToolBarShadowDis;
    private RelativeLayout mToolbar;
    private int mToolbarHeight;
    private List<BdWindow> mWindowList;
    private int mWindowPopMenu;
    private View refreshView;
    private View selectView;
    private View stopView;

    public BdFrameView(Context context) {
        this(context, null);
    }

    public BdFrameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mMaxTabNum = 4;
        this.mWindowList = new ArrayList();
        this.mToolbarHeight = (int) context.getResources().getDimension(context.getResources().getIdentifier("browser_bottom_toolbar_height", "dimen", context.getPackageName()));
        this.mProgressHeight = (int) context.getResources().getDimension(context.getResources().getIdentifier("browser_progress_bar_height", "dimen", context.getPackageName()));
        this.mToolBarShadowDis = BdUtil.dip2pix(context, 4.0f);
        this.mToolbar = (RelativeLayout) ((Activity) context).getLayoutInflater().inflate(context.getResources().getIdentifier("browser_toolbar", "layout", context.getPackageName()), (ViewGroup) null);
        this.mProgressBar = (ProgressBar) ((Activity) context).getLayoutInflater().inflate(context.getResources().getIdentifier("browser_progress_bar", "layout", context.getPackageName()), (ViewGroup) null);
        this.mPopMenuGroup = new BdPopMenuGroup(getContext());
        loadMenu(context);
        addView(this.mProgressBar, new FrameLayout.LayoutParams(-1, this.mProgressHeight));
        addView(this.mToolbar, new FrameLayout.LayoutParams(-1, this.mToolbarHeight));
        addView(this.mPopMenuGroup);
        initFuncListener();
        createNewWindow(true);
        setOnTouchListener(this);
    }

    public void loadMenu(Context context) {
        String[] strArr = {context.getString(context.getResources().getIdentifier("browser_menu_open", "string", context.getPackageName()))};
        String[] strArr2 = {context.getString(context.getResources().getIdentifier("browser_menu_select_text", "string", context.getPackageName())), context.getString(getContext().getResources().getIdentifier("browser_menu_share", "string", context.getPackageName()))};
        String[] strArr3 = {context.getString(context.getResources().getIdentifier("browser_menu_open", "string", context.getPackageName()))};
        String[] strArr4 = {getContext().getString(context.getResources().getIdentifier("browser_menu_load_image", "string", context.getPackageName()))};
        String[] strArr5 = {context.getString(context.getResources().getIdentifier("browser_menu_load_image", "string", context.getPackageName()))};
        int[] iArr = {context.getResources().getIdentifier("browser_menu_open_normal", "drawable", context.getPackageName())};
        int[] iArr2 = {context.getResources().getIdentifier("browser_menu_copy_normal", "drawable", context.getPackageName()), context.getResources().getIdentifier("browser_menu_share_normal", "drawable", context.getPackageName())};
        int[] iArr3 = {context.getResources().getIdentifier("browser_menu_open_normal", "drawable", context.getPackageName())};
        int[] iArr4 = {context.getResources().getIdentifier("browser_menu_image_open", "drawable", context.getPackageName())};
        int[] iArr5 = {context.getResources().getIdentifier("browser_menu_image_open", "drawable", context.getPackageName())};
        this.mWindowPopMenu = this.mPopMenuGroup.createMenu(this);
        this.mSearchWindowPopMenu = this.mPopMenuGroup.createMenu(this);
        this.mSelectedPopMenu = this.mPopMenuGroup.createMenu(this);
        this.mImagePopMenu = this.mPopMenuGroup.createMenu(this);
        this.mAnchorImagePopMenu = this.mPopMenuGroup.createMenu(this);
        BdPopMenuGroup.getInstance().setMenuSkin(this.mWindowPopMenu, getContext().getResources().getIdentifier("browser_popup_bg", "drawable", getContext().getPackageName()));
        BdPopMenuGroup.getInstance().setMenuSkin(this.mSearchWindowPopMenu, getContext().getResources().getIdentifier("browser_popup_bg", "drawable", getContext().getPackageName()));
        BdPopMenuGroup.getInstance().setMenuSkin(this.mSelectedPopMenu, getContext().getResources().getIdentifier("browser_popup_bg", "drawable", getContext().getPackageName()));
        BdPopMenuGroup.getInstance().setMenuSkin(this.mImagePopMenu, getContext().getResources().getIdentifier("browser_popup_bg", "drawable", getContext().getPackageName()));
        BdPopMenuGroup.getInstance().setMenuSkin(this.mAnchorImagePopMenu, getContext().getResources().getIdentifier("browser_popup_bg", "drawable", getContext().getPackageName()));
        BdPopMenuGroup.getInstance().addItem(this.mWindowPopMenu, strArr, getContext().getResources().getIdentifier("browser_popmenu_textcolor", "color", getContext().getPackageName()), iArr);
        BdPopMenuGroup.getInstance().addItem(this.mSearchWindowPopMenu, strArr3, getContext().getResources().getIdentifier("browser_popmenu_textcolor", "color", getContext().getPackageName()), iArr3);
        BdPopMenuGroup.getInstance().addItem(this.mSelectedPopMenu, strArr2, getContext().getResources().getIdentifier("browser_popmenu_textcolor", "color", getContext().getPackageName()), iArr2);
        BdPopMenuGroup.getInstance().addItem(this.mImagePopMenu, strArr4, getContext().getResources().getIdentifier("browser_popmenu_textcolor", "color", getContext().getPackageName()), iArr4);
        BdPopMenuGroup.getInstance().addItem(this.mAnchorImagePopMenu, strArr5, getContext().getResources().getIdentifier("browser_popmenu_textcolor", "color", getContext().getPackageName()), iArr5);
        BdPopMenuGroup.getInstance().layoutMenu(this.mWindowPopMenu);
        BdPopMenuGroup.getInstance().layoutMenu(this.mSearchWindowPopMenu);
        BdPopMenuGroup.getInstance().layoutMenu(this.mSelectedPopMenu);
        BdPopMenuGroup.getInstance().layoutMenu(this.mImagePopMenu);
        BdPopMenuGroup.getInstance().layoutMenu(this.mAnchorImagePopMenu);
    }

    public void swapWindowToFocus(BdWindow bdWindow) {
        if (bdWindow != null && !bdWindow.equals(this.mCurrentWindow)) {
            if (this.mCurrentWindow != null && this.mBrowser != null) {
                this.mCurrentWindow.setSearchboxBundle(this.mBrowser.onTabChangStarted(null));
                this.mCurrentWindow.setForeground(false);
            }
            removeView(this.mCurrentWindow);
            this.mCurrentWindow = bdWindow;
            addView(bdWindow, 2);
            bdWindow.setForeground(true);
            if (this.mCurrentWindow != null && this.mBrowser != null) {
                this.mBrowser.onTabChangeFinished(this.mCurrentWindow.getSearchboxBundle());
            }
            updateState(bdWindow);
        }
    }

    public void createNewWindowOpenUrl(String str) {
    }

    public BdWindow onInnerCreateNewWindow() {
        return null;
    }

    public void createNewWindow(boolean z) {
        createWindow(true);
    }

    public BdWindow createWindow(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = (int) getContext().getResources().getDimension(getContext().getResources().getIdentifier("browser_float_searchbox_height", "dimen", getContext().getPackageName()));
        layoutParams.bottomMargin = (int) getContext().getResources().getDimension(getContext().getResources().getIdentifier("browser_bottom_toolbar_height", "dimen", getContext().getPackageName()));
        BdWindow bdWindow = new BdWindow(getContext());
        bdWindow.setFrameView(this);
        bdWindow.setLayoutParams(layoutParams);
        this.mWindowList.add(bdWindow);
        if (z) {
            swapWindowToFocus(bdWindow);
        }
        return bdWindow;
    }

    public BdWindow creatNextWindow(boolean z, int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = (int) getContext().getResources().getDimension(getContext().getResources().getIdentifier("browser_float_searchbox_height", "dimen", getContext().getPackageName()));
        layoutParams.bottomMargin = (int) getContext().getResources().getDimension(getContext().getResources().getIdentifier("browser_bottom_toolbar_height", "dimen", getContext().getPackageName()));
        BdWindow bdWindow = new BdWindow(getContext());
        bdWindow.setFrameView(this);
        bdWindow.setLayoutParams(layoutParams);
        this.mWindowList.add(i, bdWindow);
        if (z) {
            swapWindowToFocus(bdWindow);
        }
        return bdWindow;
    }

    public void selectedWindowToOpenUrl(String str, int i, boolean z) {
        if (z) {
            swapWindowToFocus(this.mWindowList.get(i));
        }
        this.mWindowList.get(i).loadUrl(str);
    }

    private void initFuncListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.browser.framework.BdFrameView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.equals(BdFrameView.this.exitView)) {
                    BdFrameView.this.mBrowser.onExit();
                } else if (!view.equals(BdFrameView.this.backView)) {
                    if (!view.equals(BdFrameView.this.forwordView)) {
                        if (!view.equals(BdFrameView.this.refreshView)) {
                            if (!view.equals(BdFrameView.this.stopView)) {
                                view.equals(BdFrameView.this.selectView);
                                return;
                            } else {
                                BdFrameView.this.stopLoading();
                                return;
                            }
                        }
                        BdFrameView.this.reload();
                        return;
                    }
                    BdFrameView.this.goForward();
                } else {
                    BdFrameView.this.goBack();
                }
            }
        };
        this.exitView = findViewById(getContext().getResources().getIdentifier("browser_exit", LocaleUtil.INDONESIAN, getContext().getPackageName()));
        this.exitView.setOnClickListener(onClickListener);
        this.backView = findViewById(getContext().getResources().getIdentifier("browser_back", LocaleUtil.INDONESIAN, getContext().getPackageName()));
        this.backView.setOnClickListener(onClickListener);
        this.forwordView = findViewById(getContext().getResources().getIdentifier("browser_forword", LocaleUtil.INDONESIAN, getContext().getPackageName()));
        this.forwordView.setOnClickListener(onClickListener);
        this.refreshView = findViewById(getContext().getResources().getIdentifier("browser_refresh", LocaleUtil.INDONESIAN, getContext().getPackageName()));
        this.refreshView.setOnClickListener(onClickListener);
        this.stopView = findViewById(getContext().getResources().getIdentifier("browser_cancel", LocaleUtil.INDONESIAN, getContext().getPackageName()));
        this.stopView.setOnClickListener(onClickListener);
        this.selectView = findViewById(getContext().getResources().getIdentifier("browser_select", LocaleUtil.INDONESIAN, getContext().getPackageName()));
        this.selectView.setOnClickListener(onClickListener);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        super.onMeasure(i, i2);
        View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                if (childAt.equals(this.mProgressBar)) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824);
                } else if (childAt instanceof BdWindow) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(((size - 0) - this.mToolbarHeight) + this.mToolBarShadowDis, 1073741824);
                } else if (childAt instanceof BdPopMenuGroup) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824);
                }
                childAt.measure(i, makeMeasureSpec);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int height = childAt.getHeight();
                if (childAt instanceof ImageView) {
                    childAt.layout(0, i5, getWidth(), height + i5);
                } else if (childAt.equals(this.mProgressBar)) {
                    childAt.layout(0, i5, getWidth(), i5 + height);
                    i5 += height;
                } else if (childAt.equals(this.mToolbar)) {
                    this.mToolbar.getHeight();
                    childAt.layout(0, getHeight() - this.mToolbarHeight, getWidth(), getHeight());
                } else if (childAt instanceof BdPopMenuGroup) {
                    childAt.layout(0, 0, getWidth(), getHeight());
                } else {
                    childAt.layout(0, i5, getWidth(), (getHeight() - this.mToolbarHeight) + this.mToolBarShadowDis);
                }
            }
        }
    }

    public void updateInputBoxText(String str) {
    }

    public void setLoadingProgress(int i) {
        ProgressBar progressBar = this.mProgressBar;
        progressBar.setProgress(i);
        int visibility = progressBar.getVisibility();
        if (i != 0 && visibility == 4) {
            progressBar.setVisibility(0);
        } else if (i == 0 && visibility == 0) {
            progressBar.setVisibility(4);
        }
    }

    public void setGridViewScrolledDown(boolean z) {
    }

    public void setVoiceViewScrolledUp() {
    }

    public void clearAllCache() {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mPopMenuGroup.isMenuShow()) {
                this.mPopMenuGroup.hideAll();
                return true;
            } else if (this.mCurrentWindow != null && this.mCurrentWindow.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public void goBack() {
        this.mCurrentWindow.goBack();
        updateState(this.mCurrentWindow);
    }

    public void goForward() {
        this.mCurrentWindow.goForward();
        updateState(this.mCurrentWindow);
    }

    public boolean canGoForward() {
        return this.mCurrentWindow.canGoForward();
    }

    public boolean canGoBack() {
        return this.mCurrentWindow.canGoBack();
    }

    public void loadUrl(String str) {
        this.mCurrentWindow.loadUrl(str);
    }

    public void loadSearchUrl(String str, String str2) {
    }

    public String getUrl() {
        return this.mCurrentWindow.getUrl();
    }

    public void reload() {
        this.mCurrentWindow.reload();
    }

    public void stopLoading() {
        this.mCurrentWindow.stopLoading();
        setLoadingProgress(0);
        updateState(this.mCurrentWindow);
    }

    public void clearHistory() {
        this.mCurrentWindow.clearHistory();
    }

    public void freeMemory() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mWindowList.size()) {
                this.mWindowList.get(i2).freeMemory();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setUpSelect() {
        this.mCurrentWindow.setUpSelect();
    }

    public void addWebViewTitle(View view) {
        this.mCurrentWindow.setEmbeddedTitleBar(view);
    }

    public FloatSearchBoxLayout getSearchbox() {
        return null;
    }

    public Browser getBrowser() {
        return this.mBrowser;
    }

    public void setBrowser(Browser browser) {
        this.mBrowser = browser;
    }

    public void showSelectedPopMenu() {
        BdPopMenuGroup.getInstance().show(this.mSelectedPopMenu);
    }

    public void showWindowPopMenu() {
        BdPopMenuGroup.getInstance().show(this.mWindowPopMenu);
    }

    public void showSearchWindowPopMenu() {
        BdPopMenuGroup.getInstance().show(this.mSearchWindowPopMenu);
    }

    public void showImagePopMenu() {
        BdPopMenuGroup.getInstance().show(this.mImagePopMenu);
    }

    public void showAnchorImagePopMenu() {
        BdPopMenuGroup.getInstance().show(this.mAnchorImagePopMenu);
    }

    public void updateState(BdWindow bdWindow) {
        if (bdWindow.equals(this.mCurrentWindow)) {
            if (this.mCurrentWindow != null) {
                setLoadingProgress(this.mCurrentWindow.getCurrentPageProgerss());
                View findViewById = findViewById(getContext().getResources().getIdentifier("browser_refresh", LocaleUtil.INDONESIAN, getContext().getPackageName()));
                View findViewById2 = findViewById(getContext().getResources().getIdentifier("browser_cancel", LocaleUtil.INDONESIAN, getContext().getPackageName()));
                if (findViewById != null && findViewById2 != null) {
                    if (this.mCurrentWindow.getCurrentPageProgerss() != 0) {
                        findViewById.setVisibility(8);
                        findViewById2.setVisibility(0);
                    } else {
                        findViewById.setVisibility(0);
                        findViewById2.setVisibility(8);
                    }
                }
            }
            boolean canGoBack = canGoBack();
            boolean canGoForward = canGoForward();
            View findViewById3 = findViewById(getContext().getResources().getIdentifier("browser_back", LocaleUtil.INDONESIAN, getContext().getPackageName()));
            if (findViewById3 != null) {
                findViewById3.setEnabled(canGoBack);
                findViewById3.setFocusable(canGoBack);
            }
            View findViewById4 = findViewById(getContext().getResources().getIdentifier("browser_forword", LocaleUtil.INDONESIAN, getContext().getPackageName()));
            if (findViewById4 != null) {
                findViewById4.setEnabled(canGoForward);
                findViewById4.setFocusable(canGoForward);
            }
            bdWindow.setLastVisitTime(System.currentTimeMillis());
        }
    }

    public void checkTabWindowState() {
    }

    public int checkTabWindowNun() {
        return Math.max(this.mWindowList.size(), 0);
    }

    public void showTabWindow() {
    }

    public void hideTabWindow() {
    }

    @Override // com.baidu.browser.framework.BdWindowTabCtrl.BdTabCtrlListener
    public void onCreateTabMax() {
    }

    @Override // com.baidu.browser.framework.BdWindowTabCtrl.BdTabCtrlListener
    public void onTabSelected(BdWindowTabButton bdWindowTabButton) {
        if (bdWindowTabButton.getWindow() != null) {
            swapWindowToFocus(bdWindowTabButton.getWindow());
        }
        updateState(this.mCurrentWindow);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.mBrowser.onDownloadStart(str, str2, str3, str4, j);
    }

    public void onDownloadStartNoStream(String str, String str2, String str3, String str4, long j) {
        this.mBrowser.onDownloadStartNoStream(str, str2, str3, str4, j);
    }

    public void onSelectionSearch(String str) {
        this.mBrowser.onSelectionSearch(str);
    }

    public void webviewScrollBy(int i, int i2) {
        this.mCurrentWindow.webviewScrollBy(i, i2);
    }

    public void webviewScrollTo(int i, int i2) {
        this.mCurrentWindow.webviewScrollTo(i, i2);
    }

    public void closeSelectedMenu() {
        this.mCurrentWindow.closeSelectedMenu();
    }

    public void loadSearchboxData(BdWindow bdWindow) {
        if (bdWindow != null && this.mBrowser != null) {
            bdWindow.setSearchboxBundle(this.mBrowser.onTabChangStarted(null));
        }
    }

    @Override // com.baidu.browser.framework.BdWindowTabCtrl.BdTabCtrlListener
    public BdWindow onCreateWindow() {
        return createWindow(true);
    }

    @Override // com.baidu.browser.framework.BdWindowTabCtrl.BdTabCtrlListener
    public void onCloseTab(BdWindow bdWindow) {
        if (bdWindow != null) {
            int indexOf = this.mWindowList.indexOf(bdWindow);
            this.mWindowList.remove(bdWindow);
            int max = Math.max(0, indexOf - 1);
            if (max < this.mWindowList.size()) {
                swapWindowToFocus(this.mWindowList.get(max));
            }
            bdWindow.release();
        }
    }

    @Override // com.baidu.browser.core.ui.BdPopMenuListener
    public void onPopMenuClick(int i, int i2, String str) {
        if (i == this.mWindowPopMenu) {
            switch (i2) {
                case 0:
                    if (this.mCurrentWindow != null) {
                        this.mCurrentWindow.openSelectedUrl();
                        break;
                    }
                    break;
                case 1:
                    if (this.mCurrentWindow != null) {
                        createNewWindowOpenUrl(this.mCurrentWindow.getAnchorUrl());
                        break;
                    }
                    break;
                case 2:
                    if (this.mCurrentWindow != null) {
                        this.mBrowser.copyToCb(this.mCurrentWindow.getAnchorUrl());
                        break;
                    }
                    break;
            }
        } else if (i == this.mSearchWindowPopMenu) {
            switch (i2) {
                case 0:
                    if (this.mCurrentWindow != null) {
                        this.mCurrentWindow.openSelectedUrl();
                        break;
                    }
                    break;
                case 1:
                    if (this.mCurrentWindow != null) {
                        this.mBrowser.copyToCb(this.mCurrentWindow.getAnchorUrl());
                        break;
                    }
                    break;
            }
        } else if (i == this.mSelectedPopMenu) {
            switch (i2) {
                case 0:
                    if (this.mCurrentWindow != null) {
                        this.mCurrentWindow.setUpSelect();
                        break;
                    }
                    break;
                case 1:
                    if (this.mCurrentWindow != null) {
                        this.mBrowser.onOpenFromBrowser(this.mCurrentWindow.getTitle(), this.mCurrentWindow.getUrl());
                        break;
                    }
                    break;
            }
        } else if (i == this.mImagePopMenu) {
            switch (i2) {
                case 0:
                    if (this.mCurrentWindow != null && this.mCurrentWindow.getAnchorUrl() != null) {
                        loadUrl(this.mCurrentWindow.getAnchorUrl());
                        break;
                    }
                    break;
            }
        } else if (i == this.mAnchorImagePopMenu) {
            switch (i2) {
                case 0:
                    if (this.mCurrentWindow != null && this.mCurrentWindow.getAnchorUrl() != null) {
                        loadUrl(this.mCurrentWindow.getAnchorUrl());
                        break;
                    }
                    break;
                case 1:
                    Message onRequestCopyHref = this.mBrowser.onRequestCopyHref();
                    if (onRequestCopyHref != null) {
                        this.mCurrentWindow.requestFocusNodeHref(onRequestCopyHref);
                        break;
                    }
                    break;
            }
        }
        this.mPopMenuGroup.hide(i);
    }

    @Override // com.baidu.browser.core.ui.BdPopMenuListener
    public void onPopMenuShow(int i) {
    }

    @Override // com.baidu.browser.core.ui.BdPopMenuListener
    public void onPopMenuHide(int i) {
    }

    public void release() {
        for (BdWindow bdWindow : this.mWindowList) {
            bdWindow.release();
        }
        this.mWindowList.clear();
    }

    public void onPause() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mWindowList.size()) {
                this.mWindowList.get(i2).onPause();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onResume() {
        this.mCurrentWindow.onResume();
    }

    public void openFileChooser(BdValueCallback<Uri> bdValueCallback, String str) {
        this.mBrowser.openFileChooser(bdValueCallback, str);
    }

    public void openFileChooser(BdValueCallback<Uri> bdValueCallback) {
        this.mBrowser.openFileChooser(bdValueCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUrlTitle(String str, String str2) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void setCanShowAdView(boolean z) {
        this.mShowAdView = z;
    }

    public boolean isCanShowAdView() {
        return this.mShowAdView;
    }
}
