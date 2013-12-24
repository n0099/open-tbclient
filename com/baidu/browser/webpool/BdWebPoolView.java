package com.baidu.browser.webpool;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.browser.webkit.BdConsoleMessage;
import com.baidu.browser.webkit.BdDownloadListener;
import com.baidu.browser.webkit.BdGeolocationPermissions;
import com.baidu.browser.webkit.BdHttpAuthHandler;
import com.baidu.browser.webkit.BdPictureListener;
import com.baidu.browser.webkit.BdSslError;
import com.baidu.browser.webkit.BdSslErrorHandler;
import com.baidu.browser.webkit.BdValueCallback;
import com.baidu.browser.webkit.BdWapEngine;
import com.baidu.browser.webkit.BdWebChromeClient;
import com.baidu.browser.webkit.BdWebErrorEngine;
import com.baidu.browser.webkit.BdWebHistoryItem;
import com.baidu.browser.webkit.BdWebJsClient;
import com.baidu.browser.webkit.BdWebSettings;
import com.baidu.browser.webkit.BdWebStorage;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webkit.BdWebViewClient;
import com.baidu.browser.webpool.BdWebPoolBackForwardListItem;
import com.baidu.browser.webpool.BdWebPoolCustomView;
import com.baidu.loginshare.e;
import com.baidu.zeus.NotificationProxy;
import com.baidu.zeus.WebView;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class BdWebPoolView extends FrameLayout implements View.OnLongClickListener, BdNoProGuard, BdWebErrorEngine.BdWebErrorListener {
    public static final String BUNDLE_CLINK_MODE = "CLINK_MODE";
    public static final String BUNDLE_DESTORY_WEBVIEW = "DESTORY_WEBVIEW";
    public static final String BUNDLE_LOAD_BACKGROUND = "LOAD_BACKGROUND";
    public static final String BUNDLE_LOAD_MODE = "LOAD_MODE";
    public static final String BUNDLE_LOAD_REFER = "LOAD_REFER";
    public static final String BUNDLE_LOAD_VIEW_MODE = "LOAD_VIEW_MODE";
    public static final String BUNDLE_PAGE_MAGNITUDE = "PAGE_MAGNITUDE";
    public static final String BUNDLE_PAGE_TYPE = "PAGE_TYPE";
    public static final byte CLICK_FROM_OUTSIDE_PAGE = 2;
    public static final byte CLICK_FROM_PAGE = 1;
    private static final boolean DEBUG = true;
    public static final int DELAYED_TIME = 200;
    public static final int INIT_POOL_SIZE = 4;
    public static final byte LOAD_VIEW_MODE_MULTI = 3;
    public static final byte LOAD_VIEW_MODE_SINGLE_OWN = 2;
    public static final byte LOAD_VIEW_MODE_SINGLE_SYS = 1;
    private static final String LOG_TAG = "BdWebPoolView";
    private static final int MSG_WEBJSCLIENT_CLICK = 5;
    private static final int MSG_WEBJSCLIENT_FINISHED = 6;
    private static final int MSG_WEBJSCLIENT_GO = 3;
    private static final int MSG_WEBJSCLIENT_GOBACK = 1;
    private static final int MSG_WEBJSCLIENT_GOFORWARD = 2;
    private static final int MSG_WEBJSCLIENT_RELOAD = 4;
    public static final byte PAGE_MAGNITUDE_BIG = 1;
    public static final byte PAGE_MAGNITUDE_SMALL = 2;
    public static final byte PAGE_MAGNITUDE_UNDEFINE = 0;
    public static final byte PAGE_TYPE_NORMAL = 1;
    public static final byte PAGE_TYPE_WAP10 = 2;
    public static final int RECYCLE_WEBVIEW_COUNT = 3;
    protected BdWebPoolBackForwardList mBackForwardList;
    private boolean mCanUseBackupWebView;
    protected BdWebPoolCustomView mCurWebView;
    private boolean mCurWebViewNotify;
    private View mCustomView;
    private BdWebChromeClient.BdCustomViewCallback mCustomViewCallback;
    private BdDownloadListener mDownloadListener;
    protected FrameLayout mFullscreenContainer;
    private boolean mIsForeground;
    protected Map<String, Object> mJsItems;
    private long mLastVisitTime;
    private Bundle mLoadExtra;
    private BdWebPoolMaskView mMaskView;
    private int mOriginalOrientation;
    protected BdWebSettings mSettings;
    private BdWebErrorEngine mWebErrorEngine;
    private BdWebPoolChromeClient mWebPoolChromeClient;
    private BdWebPoolCustomViewClient mWebPoolCustomViewClient;
    private BdWebPoolViewClient mWebPoolViewClient;
    private List<BdWebPoolCustomView> mWebViewList;
    private static final String[] ARRAY_STR_MARKET_URLS = {"market://", "http://market.android.com/search?q=", "https://market.android.com/search?q=", "http://market.android.com/details?id=", "https://market.android.com/details?id=", "http://play.google.com/store/search?q=", "https://play.google.com/store/search?q=", "http://play.google.com/store/apps/details?id=", "https://play.google.com/store/apps/details?id="};
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    private static Handler sPrivateHandler = new Handler() { // from class: com.baidu.browser.webpool.BdWebPoolView.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((BdWebPoolView) message.obj).goBack();
                    return;
                case 2:
                    ((BdWebPoolView) message.obj).goForward();
                    return;
                case 3:
                    BdWebPoolView bdWebPoolView = (BdWebPoolView) message.obj;
                    int i = message.arg1;
                    if (i < 0) {
                        bdWebPoolView.goBack();
                        return;
                    } else if (i > 0) {
                        bdWebPoolView.goForward();
                        return;
                    } else {
                        return;
                    }
                case 4:
                    ((BdWebPoolView) message.obj).reload();
                    return;
                case 5:
                case 6:
                default:
                    return;
            }
        }
    };

    public BdWebPoolView(Context context) {
        this(context, null);
    }

    public BdWebPoolView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdWebPoolView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBackgroundColor(-1);
        this.mWebViewList = new ArrayList(4);
        this.mBackForwardList = new BdWebPoolBackForwardList();
        this.mMaskView = new BdWebPoolMaskView(context);
        this.mWebErrorEngine = new BdWebErrorEngine();
        this.mWebErrorEngine.setEventLisener(this);
    }

    public void setWebViewClient(BdWebPoolViewClient bdWebPoolViewClient) {
        this.mWebPoolViewClient = bdWebPoolViewClient;
    }

    public void setWebChromeClient(BdWebPoolChromeClient bdWebPoolChromeClient) {
        this.mWebPoolChromeClient = bdWebPoolChromeClient;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.mJsItems == null) {
            this.mJsItems = new HashMap();
        }
        if (this.mJsItems.containsKey(str)) {
            this.mJsItems.remove(str);
        }
        this.mJsItems.put(str, obj);
        for (BdWebPoolCustomView bdWebPoolCustomView : this.mWebViewList) {
            bdWebPoolCustomView.addJavascriptInterface(obj, str);
        }
    }

    public BdWebSettings getSettings() {
        return this.mSettings;
    }

    protected void initLoadContext(String str) {
    }

    public String getUrl() {
        return this.mCurWebView != null ? this.mCurWebView.getUrl() : "";
    }

    public void reload() {
        if (this.mCurWebView != null) {
            this.mCurWebView.setLoadMode(BdWebPoolCustomView.LoadMode.LOAD_RELOAD);
            this.mCurWebView.reload();
        }
        if (this.mWebPoolViewClient != null) {
            this.mWebPoolViewClient.onReload(this);
        }
    }

    public void findAll(String str) {
        if (this.mCurWebView != null) {
            this.mCurWebView.findAll(str);
        }
    }

    public void findNext(boolean z) {
        if (this.mCurWebView != null) {
            this.mCurWebView.findNext(z);
        }
    }

    public void clearMatches() {
        if (this.mCurWebView != null) {
            this.mCurWebView.clearMatches();
        }
    }

    public void stopLoading() {
        if (this.mCurWebView != null) {
            this.mCurWebView.stopLoading();
        }
    }

    public void clearHistory() {
        for (BdWebPoolCustomView bdWebPoolCustomView : this.mWebViewList) {
            bdWebPoolCustomView.setHistoryCount(0);
            bdWebPoolCustomView.clearHistory();
        }
        this.mBackForwardList.clear();
    }

    public void freeMemory() {
        if (isForeground()) {
            freeMemory(false);
        } else {
            freeMemory(true);
        }
    }

    public void freeMemory(boolean z) {
        BdLog.w("");
        int size = this.mWebViewList.size() - 1;
        if (!z) {
            size /= 2;
        }
        recycleBgWebViews(size);
    }

    public void setWebViewType(WebView.WebViewType webViewType) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setWebViewType(webViewType);
        }
    }

    public void emulateShiftHeld() {
        if (this.mCurWebView != null) {
            this.mCurWebView.emulateShiftHeld();
        }
    }

    public void clear() {
        BdLog.i("");
        while (this.mWebViewList.size() > 0) {
            destoryWebView(this.mWebViewList.get(0));
        }
        this.mBackForwardList.clear();
        this.mCurWebView = null;
    }

    public BdWebPoolCustomView clearExceptReuseOne(int i) {
        BdLog.i("");
        BdWebPoolCustomView remove = this.mWebViewList.remove(i);
        while (this.mWebViewList.size() > 0) {
            destoryWebView(this.mWebViewList.get(0));
        }
        this.mBackForwardList.clear();
        this.mCurWebView = null;
        return remove;
    }

    protected void reuseWebView(BdWebPoolCustomView bdWebPoolCustomView) {
        BdLog.i(bdWebPoolCustomView.toString());
        bdWebPoolCustomView.clearView();
        bdWebPoolCustomView.clearHistory();
        if (this.mWebPoolViewClient != null) {
            this.mWebPoolViewClient.onWebViewDestory(bdWebPoolCustomView);
        }
        BdWebPoolViewManager.getInstance().onWebViewDestory(this, bdWebPoolCustomView);
        removeItemWebViewRef(bdWebPoolCustomView);
        this.mWebViewList.remove(bdWebPoolCustomView);
        removeView(bdWebPoolCustomView.getWebView());
        BdWebPoolViewManager.getInstance().reuseWebView(bdWebPoolCustomView);
    }

    private void freeWebView(BdWebPoolCustomView bdWebPoolCustomView) {
        bdWebPoolCustomView.setWebViewClient(new BdWebViewClient() { // from class: com.baidu.browser.webpool.BdWebPoolView.2
            @Override // com.baidu.browser.webkit.BdWebViewClient
            public void onPageFinished(BdWebView bdWebView, String str) {
                bdWebView.freeMemory();
                bdWebView.setWebViewClient(BdWebPoolView.this.mWebPoolCustomViewClient);
            }
        });
        bdWebPoolCustomView.loadUrl("about:blank");
    }

    protected boolean recycleWebView(BdWebPoolCustomView bdWebPoolCustomView) {
        BdLog.i("");
        if (bdWebPoolCustomView.copyBackForwardList().getSize() > 1) {
            freeWebView(bdWebPoolCustomView);
            return false;
        }
        destoryWebView(bdWebPoolCustomView);
        return true;
    }

    private void destoryWebView(BdWebView bdWebView) {
        BdLog.i(bdWebView.toString());
        if (this.mWebPoolViewClient != null) {
            this.mWebPoolViewClient.onWebViewDestory(bdWebView);
        }
        BdWebPoolViewManager.getInstance().onWebViewDestory(this, bdWebView);
        removeItemWebViewRef(bdWebView);
        this.mWebViewList.remove(bdWebView);
        removeView(bdWebView.getWebView());
        bdWebView.destroy();
    }

    private void removeItemWebViewRef(BdWebView bdWebView) {
        for (int i = 0; i < this.mBackForwardList.getSize(); i++) {
            BdWebPoolBackForwardListItem item = this.mBackForwardList.getItem(i);
            BdWebView webView = item.getWebView();
            if (bdWebView != null && bdWebView.equals(webView)) {
                item.setWebView(null);
                item.getExtras().putBoolean(BUNDLE_DESTORY_WEBVIEW, true);
            }
        }
    }

    public void clearView() {
        if (this.mCurWebView != null) {
            this.mCurWebView.clearView();
        }
    }

    public boolean canGoBackOrForward(int i) {
        return this.mBackForwardList.canGoBackOrForward(i);
    }

    public boolean canGoBack() {
        return canGoBackOrForward(-1);
    }

    public boolean canGoForward() {
        return canGoBackOrForward(1);
    }

    public boolean goBack() {
        boolean z = false;
        BdLog.d(toString());
        BdLog.d(this.mBackForwardList.toString());
        checkCurIndex();
        BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem = null;
        if (canGoBack()) {
            checkCurItem();
            int curIndex = this.mBackForwardList.getCurIndex();
            BdLog.d("curIndex: " + curIndex);
            bdWebPoolBackForwardListItem = getPreItem(curIndex);
            if (bdWebPoolBackForwardListItem != null) {
                z = goToItem(curIndex, this.mBackForwardList.getItemIndex(bdWebPoolBackForwardListItem));
            } else {
                BdLog.w("can not find back item in cur pos " + curIndex);
            }
        } else {
            BdLog.v("can not goback.");
        }
        if (z && this.mWebPoolViewClient != null) {
            onDetectPoolUseCondition(bdWebPoolBackForwardListItem);
            this.mWebPoolViewClient.onGoBack(bdWebPoolBackForwardListItem);
        }
        return z;
    }

    public boolean goForward() {
        boolean z = false;
        BdLog.d(toString());
        BdLog.d(this.mBackForwardList.toString());
        checkCurIndex();
        BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem = null;
        if (canGoForward()) {
            int curIndex = this.mBackForwardList.getCurIndex();
            BdLog.d("curIndex: " + curIndex);
            bdWebPoolBackForwardListItem = getNextItem(curIndex);
            if (bdWebPoolBackForwardListItem != null) {
                z = goToItem(curIndex, this.mBackForwardList.getItemIndex(bdWebPoolBackForwardListItem));
            } else {
                BdLog.w("can not find forward item in pos " + curIndex);
            }
        } else {
            BdLog.v("can not goforward.");
        }
        if (z && this.mWebPoolViewClient != null) {
            onDetectPoolUseCondition(bdWebPoolBackForwardListItem);
            this.mWebPoolViewClient.onGoForward(bdWebPoolBackForwardListItem);
        }
        return z;
    }

    private void checkCurIndex() {
        int curIndex = getCurIndex();
        BdWebPoolBackForwardListItem curItem = getCurItem();
        if (curItem != null) {
            BdWebView webView = curItem.getWebView();
            int index = curItem.getIndex();
            if (webView != null) {
                int currentIndex = webView.copyBackForwardList().getCurrentIndex();
                int i = -1;
                if (currentIndex > index) {
                    i = getIndexByNativeIndex(webView, currentIndex, curIndex + 1, true);
                } else if (currentIndex < index) {
                    i = getIndexByNativeIndex(webView, currentIndex, curIndex - 1, false);
                }
                if (i >= 0) {
                    BdLog.w("adjust cur index from " + curIndex + " to " + i);
                    this.mBackForwardList.goBackOrForward(i - curIndex);
                }
            }
        }
    }

    private int getIndexByNativeIndex(BdWebView bdWebView, int i, int i2, boolean z) {
        int i3 = -1;
        if (z) {
            while (i2 < this.mBackForwardList.getSize()) {
                BdWebPoolBackForwardListItem item = this.mBackForwardList.getItem(i2);
                if (item != null && bdWebView != null && bdWebView.equals(item.getWebView()) && item.getIndex() == i) {
                    i3 = i2;
                }
                i2++;
            }
        } else {
            for (int i4 = i2; i4 >= 0; i4--) {
                BdWebPoolBackForwardListItem item2 = this.mBackForwardList.getItem(i4);
                if (item2 != null && bdWebView != null && bdWebView.equals(item2.getWebView()) && item2.getIndex() == i) {
                    i3 = i4;
                }
            }
        }
        return i3;
    }

    private boolean goToItem(int i, int i2) {
        BdLog.d("toIndex: " + i2);
        int i3 = i2 - i;
        BdWebPoolBackForwardListItem item = this.mBackForwardList.getItem(i2);
        BdWebView webView = item.getWebView();
        if (webView == null) {
            this.mBackForwardList.goBackOrForward(i3);
            BdLog.i(String.valueOf(i2) + "'s webview has been destory. now create new webview to load it.");
            getLoadExtra().putByte(BUNDLE_CLINK_MODE, (byte) 2);
            getLoadExtra().putByte(BUNDLE_PAGE_TYPE, (byte) 1);
            getLoadExtra().putString(BUNDLE_LOAD_MODE, BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD_BY_NEW_WEBVIEW.name());
            getLoadExtra().putByte(BUNDLE_LOAD_VIEW_MODE, (byte) 3);
            loadUrl(item.getUrl());
            item.setWebView(this.mCurWebView);
            return true;
        } else if (webView.copyBackForwardList().getSize() <= 0) {
            this.mBackForwardList.goBackOrForward(i3);
            BdLog.i(String.valueOf(i2) + "'s webview has no item. now use this webview to reload it.");
            getLoadExtra().putByte(BUNDLE_CLINK_MODE, (byte) 2);
            getLoadExtra().putByte(BUNDLE_PAGE_TYPE, (byte) 1);
            getLoadExtra().putString(BUNDLE_LOAD_MODE, BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD_BY_NEW_WEBVIEW.name());
            getLoadExtra().putByte(BUNDLE_LOAD_VIEW_MODE, (byte) 2);
            loadUrl(item.getUrl());
            return true;
        } else {
            BdWebPoolCustomView bdWebPoolCustomView = (BdWebPoolCustomView) webView;
            int webViewIndex = getWebViewIndex(bdWebPoolCustomView);
            if (bdWebPoolCustomView != null) {
                int index = item.getIndex();
                if (index >= 0 && i2 >= 0) {
                    int currentIndex = bdWebPoolCustomView.copyBackForwardList().getCurrentIndex();
                    int i4 = index - currentIndex;
                    if (i4 != 0) {
                        bdWebPoolCustomView.setLoadMode(BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD);
                    }
                    this.mBackForwardList.goBackOrForward(i3);
                    bdWebPoolCustomView.goBackOrForward(i4);
                    switchWebView(this.mCurWebView, bdWebPoolCustomView);
                    if (Build.VERSION.SDK_INT >= 14) {
                        bdWebPoolCustomView.getWebView().scrollBy(0, 5);
                        bdWebPoolCustomView.getWebView().scrollBy(0, -5);
                        bdWebPoolCustomView.getWebView().invalidate();
                    }
                    BdWebHistoryItem itemAtIndex = bdWebPoolCustomView.copyBackForwardList().getItemAtIndex(index);
                    if (itemAtIndex != null) {
                        String title = itemAtIndex.getTitle();
                        BdLog.d(title);
                        item.setTitle(title);
                    }
                    BdLog.d("switch webview " + webViewIndex + " from " + currentIndex + " to " + index);
                    BdLog.d("switch backforward list from " + i + " to " + i2);
                    return true;
                }
                BdLog.w(String.valueOf(webViewIndex) + "'s to item not exsit, can not go back.");
            }
            return false;
        }
    }

    public BdWebPoolBackForwardListItem getCurItem() {
        try {
            return this.mBackForwardList.getCurItem();
        } catch (Exception e) {
            BdLog.i(e.getMessage());
            return null;
        }
    }

    public int getCurIndex() {
        return this.mBackForwardList.getCurIndex();
    }

    public String getCurUrl() {
        BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem;
        try {
            bdWebPoolBackForwardListItem = this.mBackForwardList.getCurItem();
        } catch (Exception e) {
            BdLog.w(e.getMessage());
            bdWebPoolBackForwardListItem = null;
        }
        if (bdWebPoolBackForwardListItem != null) {
            return bdWebPoolBackForwardListItem.getUrl();
        }
        return null;
    }

    public void setEmbeddedTitleBar(View view) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setEmbeddedTitleBar(view);
        }
    }

    public String getSelection() {
        return this.mCurWebView != null ? this.mCurWebView.getSelection() : "";
    }

    public boolean getExtendSelection() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getExtendSelection();
        }
        return false;
    }

    public boolean setExtendSelection(boolean z) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.setExtendSelection(z);
        }
        return false;
    }

    public boolean getSelectingText() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getSelectingText();
        }
        return false;
    }

    public boolean setSelectingText(boolean z) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.setSelectingText(z);
        }
        return false;
    }

    public boolean getDrawSelectionPointer() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getDrawSelectionPointer();
        }
        return false;
    }

    public boolean setDrawSelectionPointer(boolean z) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.setDrawSelectionPointer(z);
        }
        return false;
    }

    public boolean getShiftIsPressed() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getShiftIsPressed();
        }
        return false;
    }

    public boolean setShiftIsPressed(boolean z) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.setShiftIsPressed(z);
        }
        return false;
    }

    public boolean getTouchSelection() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getTouchSelection();
        }
        return false;
    }

    public boolean isCurWebViewNotify() {
        return this.mCurWebViewNotify;
    }

    public boolean setTouchSelection(boolean z) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.setTouchSelection(z);
        }
        return false;
    }

    public BdWebView.BdHitTestResult getHitTestResult() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getHitTestResult();
        }
        return null;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return superPerformLongClick();
    }

    public boolean superPerformLongClick() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.superPerformLongClick();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        if (view.getClass().getName().equals("com.adobe.flashplayer.FlashPaintSurface")) {
            ((SurfaceView) view).setZOrderOnTop(false);
        }
        return superDrawChild(canvas, view, j);
    }

    public boolean superDrawChild(Canvas canvas, View view, long j) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.superDrawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return superOnTouchEvent(motionEvent);
    }

    public boolean superOnTouchEvent(MotionEvent motionEvent) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.superOnTouchEvent(motionEvent);
        }
        return false;
    }

    public int getCurScrollX() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getWebView().getScrollX();
        }
        return -1;
    }

    public final int getCurScrollY() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getWebView().getScrollY();
        }
        return -1;
    }

    @Override // android.view.View
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (BdWebPoolCustomView bdWebPoolCustomView : this.mWebViewList) {
            stringBuffer.append(getWebViewDebugInfo(bdWebPoolCustomView));
        }
        return stringBuffer.toString();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (this.mCurWebView != null) {
            this.mCurWebView.getWebView().scrollTo(i, i2);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        if (this.mCurWebView != null) {
            this.mCurWebView.getWebView().scrollBy(i, i2);
        }
    }

    public void setDownloadListener(BdDownloadListener bdDownloadListener) {
        for (BdWebPoolCustomView bdWebPoolCustomView : this.mWebViewList) {
            bdWebPoolCustomView.setDownloadListener(bdDownloadListener);
        }
        this.mDownloadListener = bdDownloadListener;
    }

    public String getTitle() {
        return this.mCurWebView != null ? this.mCurWebView.getTitle() : "";
    }

    public BdWebPoolCustomView getAvailableWebView(byte b, byte b2) {
        if (this.mCurWebView == null && isBlankView()) {
            BdWebPoolCustomView webViewByPos = getWebViewByPos(0);
            if (webViewByPos == null) {
                return genNewWebView();
            }
            return webViewByPos;
        } else if (b2 == 2) {
            return this.mCurWebView;
        } else {
            if (b == 1) {
                if (isRedirectLoad(this.mCurWebView)) {
                    BdLog.v("the request is redirect, use current webview to load it.");
                    return this.mCurWebView;
                }
                return genNewWebView();
            }
            return genNewWebView();
        }
    }

    private void initWebView(BdWebPoolCustomView bdWebPoolCustomView) {
        bdWebPoolCustomView.setWebPoolView(this);
        this.mWebPoolCustomViewClient = new BdWebPoolCustomViewClient();
        bdWebPoolCustomView.setWebViewClient(this.mWebPoolCustomViewClient);
        bdWebPoolCustomView.setWebJsClient(new BdWebPoolCustomJsClient());
        bdWebPoolCustomView.setWebChromeClient(new BdWebPoolCustomChromeClient(bdWebPoolCustomView));
        bdWebPoolCustomView.setOnLongClickListener(this);
        bdWebPoolCustomView.disableZoomButtonsController();
        bdWebPoolCustomView.setScrollBarStyle(33554432);
        BdWebSettings settings = bdWebPoolCustomView.getSettings();
        if (this.mSettings == null) {
            this.mSettings = settings.m0clone();
            this.mSettings.attach(settings, false);
        } else {
            this.mSettings.attach(settings);
        }
        initJavascriptClients(bdWebPoolCustomView);
        if (this.mDownloadListener != null) {
            bdWebPoolCustomView.setDownloadListener(this.mDownloadListener);
        }
    }

    private void destoryWebViewAfterCurrent() {
        if (!isBlankView()) {
            int curIndex = this.mBackForwardList.getCurIndex();
            while (true) {
                curIndex++;
                if (curIndex < this.mBackForwardList.getSize()) {
                    BdWebView webView = this.mBackForwardList.getItem(curIndex).getWebView();
                    if (webView != null && !webView.equals(this.mCurWebView)) {
                        BdLog.i("destory webview: " + webView);
                        destoryWebView(webView);
                    }
                } else {
                    return;
                }
            }
        } else {
            BdLog.i("poolview has no any webpage, do not destory webview.");
        }
    }

    protected BdWebPoolCustomView getWebViewByPos(int i) {
        if (i < 0 || i >= this.mWebViewList.size()) {
            return null;
        }
        return this.mWebViewList.get(i);
    }

    public BdWebPoolBackForwardListItem getItem(int i) {
        BdWebView webView;
        if (i < 0 || i >= this.mBackForwardList.getSize()) {
            BdLog.w(String.valueOf(i) + " Out Of Bounds.");
            return null;
        }
        BdWebPoolBackForwardListItem item = this.mBackForwardList.getItem(i);
        if (item.getUrl() != null && (webView = item.getWebView()) != null) {
            int index = item.getIndex();
            BdLog.d("itemIdex: " + index);
            BdWebHistoryItem itemAtIndex = webView.copyBackForwardList().getItemAtIndex(index);
            if (itemAtIndex != null) {
                String url = itemAtIndex.getUrl();
                String url2 = item.getUrl();
                BdLog.v(String.valueOf(url) + ", " + url2);
                if (url != null && url.equals(url2)) {
                    BdLog.i("get item. pos: " + i + ", native native: " + index);
                    return item;
                }
            }
        }
        if (verifyItemIndex(i)) {
            BdLog.i("verify item index ok, return item.");
            return item;
        }
        BdLog.w(String.valueOf(i) + " is not found, delete it.");
        removeItem(i);
        return null;
    }

    private boolean verifyItemIndex(int i) {
        BdWebPoolBackForwardListItem item = this.mBackForwardList.getItem(i);
        if (item != null) {
            if (item.getExtras().getBoolean(BUNDLE_DESTORY_WEBVIEW)) {
                return true;
            }
            BdWebView webView = item.getWebView();
            if (webView != null) {
                for (int index = item.getIndex() - 1; index >= 0; index--) {
                    BdWebHistoryItem itemAtIndex = webView.copyBackForwardList().getItemAtIndex(index);
                    if (itemAtIndex != null) {
                        String url = itemAtIndex.getUrl();
                        String url2 = item.getUrl();
                        BdLog.v(String.valueOf(url) + ", " + url2);
                        if (url != null && url.equals(url2)) {
                            int i2 = i - 1;
                            if (isNativeIndexInBfList(webView, index, i2)) {
                                removeItem(i2);
                                if (i2 <= getCurIndex()) {
                                    this.mBackForwardList.goBack();
                                }
                            }
                            BdLog.i("get correct native index. pos: " + i + ", native native: " + index);
                            item.setIndex(index);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isNativeIndexInBfList(BdWebView bdWebView, int i, int i2) {
        while (i2 >= 0) {
            BdWebPoolBackForwardListItem item = this.mBackForwardList.getItem(i2);
            int index = item.getIndex();
            BdWebView webView = item.getWebView();
            if (webView == null) {
                return false;
            }
            if (!webView.equals(bdWebView) || index != i) {
                i2--;
            } else {
                return true;
            }
        }
        return false;
    }

    private BdWebPoolBackForwardListItem getPreItem(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            BdLog.w("can not find any back item, return.");
            return null;
        }
        try {
            BdWebPoolBackForwardListItem item = getItem(i2);
            return item != null ? item : getPreItem(i2);
        } catch (Exception e) {
            BdLog.e("get back item error.", e);
            return null;
        }
    }

    private BdWebPoolBackForwardListItem getNextItem(int i) {
        int i2 = i + 1;
        if (i2 >= this.mBackForwardList.getSize()) {
            BdLog.w("can not find any forward item, return.");
            return null;
        }
        try {
            BdWebPoolBackForwardListItem item = getItem(i2);
            return item != null ? item : getNextItem(i2);
        } catch (Exception e) {
            BdLog.e("get back item error.", e);
            return null;
        }
    }

    private boolean isRedirectLoad(BdWebView bdWebView) {
        BdWebPoolCustomView bdWebPoolCustomView = (BdWebPoolCustomView) bdWebView;
        boolean z = bdWebPoolCustomView.copyBackForwardList().getSize() <= bdWebPoolCustomView.getHistoryCount();
        if (z && isValidUrl(bdWebPoolCustomView.getClickLink())) {
            Log.d(LOG_TAG, "[isRedirectLoad]because get clink link, we think this load is not redirect.");
            return false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNewItemIndex(BdWebView bdWebView, String str) {
        int i = -1;
        int lastCurrentIndex = getLastCurrentIndex(bdWebView);
        int currentIndex = bdWebView.copyBackForwardList().getCurrentIndex();
        BdLog.d("webview: " + getWebViewIndex(bdWebView) + ", cur index: " + currentIndex + ", last index: " + lastCurrentIndex + ", cur url: " + bdWebView.getUrl());
        if (currentIndex - lastCurrentIndex == 1) {
            i = currentIndex;
        } else if (str != null && str.equals(bdWebView.getUrl())) {
            BdLog.i("get resource url as new item.");
            i = currentIndex;
        }
        setLastCurrentIndex(bdWebView, currentIndex);
        return i;
    }

    private boolean isDestroyItem(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
        return false;
    }

    protected boolean switchWebView(BdWebPoolCustomView bdWebPoolCustomView, BdWebPoolCustomView bdWebPoolCustomView2) {
        BdLog.i(bdWebPoolCustomView + ", " + bdWebPoolCustomView2);
        if (bdWebPoolCustomView != null && this.mWebViewList.indexOf(bdWebPoolCustomView) >= 0) {
            View webView = bdWebPoolCustomView.getWebView();
            if (bdWebPoolCustomView.equals(bdWebPoolCustomView2)) {
                BdLog.i("the same webview, not need to switch.");
                return false;
            }
            bdWebPoolCustomView.setWebViewAction(WebView.WebViewAction.SingleWindowPauseAction);
            bdWebPoolCustomView.stopLoading();
            bdWebPoolCustomView.onPause();
            if (webView != null && webView.getParent() != null) {
                webView.clearFocus();
                removeView(webView);
            }
        }
        if (bdWebPoolCustomView2 != null) {
            addWebView(bdWebPoolCustomView2);
            bdWebPoolCustomView2.onResume();
            View webView2 = bdWebPoolCustomView2.getWebView();
            if (webView2 != null) {
                webView2.requestFocus();
            }
            this.mCurWebView = bdWebPoolCustomView2;
            if (this.mWebPoolViewClient != null) {
                this.mWebPoolViewClient.onWebViewChanged(this, bdWebPoolCustomView, bdWebPoolCustomView2);
            }
            return true;
        }
        BdLog.i("no new webview to switch.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWebViewIndex(BdWebView bdWebView) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mWebViewList.size()) {
                if (this.mWebViewList.get(i2).equals(bdWebView)) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    private void removeItemsAfterPos(int i) {
        removeItemsAfterPos(i, false);
    }

    private void removeItemsAfterPos(int i, boolean z) {
        int size = this.mBackForwardList.getSize();
        BdLog.d("aPos: " + i + ", size: " + size);
        for (int i2 = size - 1; i2 > i && i2 >= 0; i2--) {
            if (z) {
                try {
                    if (isDestroyItem(this.mBackForwardList.getItem(i2))) {
                        BdLog.d("remove item: " + i2);
                        removeItem(i2);
                    }
                } catch (Exception e) {
                    BdLog.e("pos" + i2 + " remove fail.", e);
                    return;
                }
            } else {
                BdLog.d("remove item: " + i2);
                removeItem(i2);
            }
        }
    }

    protected void removeItem(int i) {
        this.mBackForwardList.removeItem(i);
    }

    public void addWebView(BdWebPoolCustomView bdWebPoolCustomView) {
        View webView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (bdWebPoolCustomView != null && (webView = bdWebPoolCustomView.getWebView()) != null) {
            boolean z = getLoadExtra().getBoolean(BUNDLE_LOAD_BACKGROUND, false);
            if (webView.getParent() == null) {
                addView(webView, 0, layoutParams);
            } else {
                webView.setVisibility(0);
            }
            if (!z) {
                onShowMaskView();
            }
        }
    }

    public void setMaskView(BdWebPoolMaskView bdWebPoolMaskView) {
        removeView(bdWebPoolMaskView);
        this.mMaskView = bdWebPoolMaskView;
        this.mMaskView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBackForwardItem(BdWebView bdWebView, String str, int i, boolean z) {
        BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem;
        String str2;
        BdWebView bdWebView2;
        int i2;
        int curIndex = this.mBackForwardList.getCurIndex();
        BdLog.d("curIndex: " + curIndex + ", aNewNativeIndex: " + i);
        if (str == null) {
            BdLog.w("Url is null, do not add item.");
        } else if (bdWebView == null) {
            BdLog.w("webview is null, do not add item.");
        } else {
            BdLog.d(getWebViewDebugInfo(bdWebView));
            BdWebPoolCustomView webViewByPos = getWebViewByPos(getWebViewIndex(bdWebView));
            if (webViewByPos != null) {
                BdWebPoolCustomView.LoadMode loadMode = webViewByPos.getLoadMode();
                BdLog.d("loadMode: " + loadMode);
                if (loadMode == BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD || loadMode == BdWebPoolCustomView.LoadMode.LOAD_RELOAD || loadMode == BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD_BY_NEW_WEBVIEW) {
                    BdLog.i("go back or forward or refresh, not add BackForwardItem");
                    return;
                } else if (!bdWebView.equals(this.mCurWebView)) {
                    BdLog.i("webview is in background, not add BackForwardItem");
                    return;
                }
            }
            if (i < 0) {
                BdLog.w("NewNativeIndex is invalid. " + i);
                return;
            }
            boolean z2 = false;
            boolean z3 = false;
            try {
                bdWebPoolBackForwardListItem = this.mBackForwardList.getItem(curIndex);
            } catch (Exception e) {
                BdLog.w(e.getMessage());
                bdWebPoolBackForwardListItem = null;
            }
            if (bdWebPoolBackForwardListItem == null) {
                str2 = null;
                bdWebView2 = null;
                i2 = -1;
            } else {
                String url = bdWebPoolBackForwardListItem.getUrl();
                BdLog.d("curUrl: " + url);
                BdWebView webView = bdWebPoolBackForwardListItem.getWebView();
                int index = bdWebPoolBackForwardListItem.getIndex();
                BdLog.d("curNativeIndex: " + index);
                str2 = url;
                bdWebView2 = webView;
                i2 = index;
            }
            if (bdWebView.equals(bdWebView2)) {
                z2 = true;
            }
            if (str.equals(str2)) {
                z3 = true;
            }
            BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem2 = new BdWebPoolBackForwardListItem();
            bdWebPoolBackForwardListItem2.setIndex(i);
            bdWebPoolBackForwardListItem2.setWebView(webViewByPos);
            bdWebPoolBackForwardListItem2.setUrl(str);
            Object tag = getTag(getContext().getResources().getIdentifier("browser_webcontent_error_code", "id", getContext().getPackageName()));
            if ((tag == null ? 0 : ((Integer) tag).intValue()) != 0) {
                bdWebPoolBackForwardListItem2.setLoadStatus(BdWebPoolBackForwardListItem.LoadStatus.STATUS_ERROR);
            }
            BdLog.d("curWebViewIndex: " + getWebViewIndex(bdWebView2) + ", newWebViewIndex: " + getWebViewIndex(bdWebView));
            if ((!z2 && z3) || isReplaceLoadMode()) {
                BdLog.i("current url is exsit or is replace mode, only update item.");
                this.mBackForwardList.setItem(curIndex, bdWebPoolBackForwardListItem2);
                return;
            }
            boolean z4 = true;
            if (z2) {
                if (i2 == i) {
                    z4 = false;
                    z = false;
                    if (!isInNativeIndex(bdWebView2, curIndex, i2)) {
                        BdLog.i(String.valueOf(curIndex) + " is replace because a new item is coming.");
                        this.mBackForwardList.setItem(curIndex, bdWebPoolBackForwardListItem2);
                    }
                } else if (i2 > i) {
                    BdLog.i("curNativeIndex great than newNativeIndex, do not add new item or update current item.");
                    z4 = false;
                }
            }
            if (z && curIndex >= 0) {
                removeItemsAfterPos(curIndex);
            }
            if (z4) {
                BdLog.i("add new item. " + str);
                this.mBackForwardList.addItem(bdWebPoolBackForwardListItem2);
                this.mBackForwardList.goForward();
            }
            int curIndex2 = this.mBackForwardList.getCurIndex();
            if (isInNativeIndex(bdWebView, curIndex2 - 1, i)) {
                BdLog.i(String.valueOf(curIndex2) + "'s native index is exsit, remove it.");
                this.mBackForwardList.removeItem(curIndex2);
                this.mBackForwardList.goBack();
            }
            if (this.mWebPoolViewClient != null) {
                this.mWebPoolViewClient.onNewItem(bdWebPoolBackForwardListItem2);
            }
        }
    }

    private void setLastCurrentIndex(BdWebView bdWebView, int i) {
        int currentIndex = bdWebView.copyBackForwardList().getCurrentIndex();
        BdWebPoolCustomView webViewByPos = getWebViewByPos(getWebViewIndex(bdWebView));
        if (webViewByPos != null) {
            webViewByPos.setLastIndex(currentIndex);
        }
    }

    private int getLastCurrentIndex(BdWebView bdWebView) {
        BdWebPoolCustomView webViewByPos = getWebViewByPos(getWebViewIndex(bdWebView));
        if (webViewByPos != null) {
            return webViewByPos.getLastIndex();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidUrl(String str) {
        BdLog.d(str);
        return (str == null || str.equals("undefined") || str.startsWith("#") || str.startsWith("javascript")) ? false : true;
    }

    public void loadUrl(String str) {
        Bundle loadExtra = getLoadExtra();
        boolean isJsUrl = isJsUrl(str);
        if (isJsUrl) {
            loadExtra.putByte(BUNDLE_LOAD_VIEW_MODE, (byte) 2);
        }
        byte byteValue = loadExtra.getByte(BUNDLE_LOAD_VIEW_MODE, (byte) 3).byteValue();
        if (byteValue != 1) {
            byte byteValue2 = loadExtra.getByte(BUNDLE_CLINK_MODE, (byte) 2).byteValue();
            byte byteValue3 = loadExtra.getByte(BUNDLE_PAGE_TYPE, (byte) 1).byteValue();
            String string = loadExtra.getString(BUNDLE_LOAD_REFER);
            BdLog.i(String.valueOf((int) byteValue2) + ", " + ((int) byteValue3));
            String string2 = getLoadExtra().getString(BUNDLE_LOAD_MODE);
            if (isReplaceLoadMode() || isJsUrl || (string2 != null && string2.equals(BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD_BY_NEW_WEBVIEW.name()))) {
                BdLog.i("create new webview to backforward, not destory webview after current.");
            } else if (shouldReload(str)) {
                BdLog.i("load the same url, use current webview to load.");
                if (this.mCurWebView != null) {
                    this.mCurWebView.loadUrl(str);
                    return;
                }
                return;
            } else {
                destoryWebViewAfterCurrent();
            }
            switchWebView(this.mCurWebView, getAvailableWebView(byteValue2, byteValue));
            if (this.mCurWebView != null) {
                if (this.mCurWebView.getWebView().getParent() == null) {
                    BdLog.w(this.mCurWebView + " has been removed!.");
                    return;
                }
                if (string2 != null && string2.equals(BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD_BY_NEW_WEBVIEW.name())) {
                    this.mCurWebView.setLoadMode(BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD_BY_NEW_WEBVIEW);
                    getLoadExtra().putString(BUNDLE_LOAD_MODE, BdWebPoolCustomView.LoadMode.LOAD_NORMAL.name());
                } else {
                    this.mCurWebView.setLoadMode(BdWebPoolCustomView.LoadMode.LOAD_NORMAL);
                }
                initLoadContext(str);
                if (string != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Referer", string);
                    this.mCurWebView.loadUrl(str, hashMap);
                } else {
                    this.mCurWebView.loadUrl(str);
                }
            }
            this.mWebErrorEngine.hideErrorPage();
        }
    }

    private boolean shouldReload(String str) {
        return isUrlEqual(getCurUrl(), str);
    }

    private String urlComplete(String str) {
        if (str == null) {
            return "";
        }
        if (!str.contains("://")) {
            str = e.f + str;
        }
        if (!str.endsWith("/")) {
            return String.valueOf(str) + "/";
        }
        return str;
    }

    public boolean isUrlEqual(String str, String str2) {
        return urlComplete(str).equals(urlComplete(str2));
    }

    public Bundle getLoadExtra() {
        if (this.mLoadExtra == null) {
            this.mLoadExtra = new Bundle();
            this.mLoadExtra.putByte(BUNDLE_CLINK_MODE, (byte) 2);
            this.mLoadExtra.putByte(BUNDLE_PAGE_TYPE, (byte) 1);
        }
        return this.mLoadExtra;
    }

    private void initJavascriptClients(BdWebView bdWebView) {
        if (this.mJsItems != null) {
            for (String str : this.mJsItems.keySet()) {
                bdWebView.addJavascriptInterface(this.mJsItems.get(str), str);
            }
        }
    }

    private String getWebViewDebugInfo(BdWebView bdWebView) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = bdWebView.copyBackForwardList().getSize();
        stringBuffer.append(bdWebView + ", " + size);
        stringBuffer.append("\n");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(String.valueOf(i) + ": ");
            BdWebHistoryItem itemAtIndex = bdWebView.copyBackForwardList().getItemAtIndex(i);
            if (itemAtIndex != null) {
                stringBuffer.append(itemAtIndex.getUrl());
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("***************************");
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNextItem() {
        checkItem(getCurIndex() + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCurItem() {
        checkItem(getCurIndex());
    }

    private void checkItem(int i) {
        BdLog.d("checkIndex: " + i);
        if (getItem(i) == null) {
            BdLog.w(String.valueOf(i) + " is not found.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInNativeIndex(BdWebView bdWebView, int i, int i2) {
        BdWebPoolBackForwardListItem item;
        BdWebHistoryItem itemAtIndex;
        if (bdWebView != null && i >= 0 && i < this.mBackForwardList.getSize() && (item = this.mBackForwardList.getItem(i)) != null && item.getIndex() == i2) {
            String url = item.getUrl();
            BdWebView webView = item.getWebView();
            if (webView == null || (itemAtIndex = webView.copyBackForwardList().getItemAtIndex(i2)) == null) {
                return false;
            }
            return bdWebView.equals(webView) && url.equals(itemAtIndex.getUrl());
        }
        return false;
    }

    public boolean isContainUrl(int i, String str) {
        BdWebPoolBackForwardListItem item;
        return i >= 0 && i < this.mBackForwardList.getSize() && (item = this.mBackForwardList.getItem(i)) != null && isUrlEqual(str, item.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDialer(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        intent.setFlags(268435456);
        getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMessager(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + str));
        intent.putExtra("sms_body", str2);
        getContext().startActivity(intent);
    }

    public boolean onLongClick(View view) {
        return false;
    }

    public void onResume() {
        if (this.mCurWebView != null) {
            BdLog.i(this.mCurWebView.toString());
            this.mCurWebView.onResume();
        }
    }

    public void resumeAudio() {
        if (this.mCurWebView != null) {
            BdLog.i(this.mCurWebView.toString());
            this.mCurWebView.resumeAudio();
        }
    }

    public void onPause() {
        if (this.mCurWebView != null) {
            BdLog.i(this.mCurWebView.toString());
            this.mCurWebView.onPause();
        }
    }

    public void pauseAudio() {
        if (this.mCurWebView != null) {
            BdLog.i(this.mCurWebView.toString());
            this.mCurWebView.pauseAudio();
        }
    }

    public boolean setWebViewToTarget(Message message, BdWebView.BdWebViewTransport bdWebViewTransport) {
        BdWebPoolCustomView availableWebView = getAvailableWebView((byte) 1, (byte) 3);
        if (availableWebView != null) {
            if (this.mCurWebView != null && this.mCurWebView.equals(availableWebView)) {
                availableWebView = genNewWebView();
            }
            switchWebView(this.mCurWebView, availableWebView);
            bdWebViewTransport.setWebView(availableWebView);
            message.sendToTarget();
            return true;
        }
        return false;
    }

    public void requestFocusNodeHref(Message message) {
        if (this.mCurWebView != null) {
            this.mCurWebView.requestFocusNodeHref(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startActivitySafely(Activity activity, Intent intent) {
        intent.addFlags(268435456);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, getContext().getResources().getIdentifier("browser_msg_activity_not_found", "string", getContext().getPackageName()), 0).show();
        } catch (SecurityException e2) {
            Toast.makeText(activity, getContext().getResources().getIdentifier("browser_msg_activity_not_found", "string", getContext().getPackageName()), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWapInvalidItem(String str) {
        int curIndex = getCurIndex();
        if (isContainUrl(curIndex, BdWapEngine.getSrcUrl(str))) {
            debugInfo("[removeWapInvalidItem]remove current item, because reload wap1.0 by weblite mode.");
            removeItem(curIndex);
        }
    }

    public int recycleBgWebViews(int i) {
        int i2 = 0;
        int indexOf = this.mWebViewList.indexOf(this.mCurWebView);
        if (isBlankView()) {
            BdLog.i("blank pool view, not recycle webview.");
            return i;
        }
        int size = this.mWebViewList.size();
        int i3 = size - 1;
        if (i3 <= 0) {
            BdLog.i("have no background, not recycle webview.");
            return i;
        }
        int i4 = i3 < i ? i3 : i;
        if (indexOf < 0) {
            indexOf = 0;
        }
        int round = Math.round((new Float(indexOf).floatValue() * new Float(i4).floatValue()) / new Float(i3).floatValue());
        int i5 = i4 - round;
        BdLog.i(String.valueOf(round) + ", " + i5 + ", " + size);
        int i6 = 0;
        int i7 = 0;
        while (i6 < round) {
            int i8 = !recycleWebView(this.mWebViewList.get(i7)) ? i7 + 1 : i7;
            BdLog.i(new StringBuilder(String.valueOf(i8)).toString());
            i6++;
            i7 = i8;
        }
        int size2 = this.mWebViewList.size() - 1;
        while (i2 < i5) {
            recycleWebView(this.mWebViewList.get(size2));
            int i9 = size2 - 1;
            BdLog.i(new StringBuilder(String.valueOf(i9)).toString());
            i2++;
            size2 = i9;
        }
        int i10 = (i - round) - i5;
        BdLog.i("leftRecycleCount: " + round + ", rightRecycleCount: " + i5 + ", reminder: " + i10);
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int recycleBgWebViewsWithLimit(int i) {
        if (this.mWebViewList.size() <= 4) {
            BdLog.i(this + " 's webview count le 4, do not recycle it.");
            return i;
        }
        return recycleBgWebViews(i);
    }

    public boolean isBlankView() {
        return this.mBackForwardList.getSize() == 0;
    }

    private void addWebViewToPool(BdWebPoolCustomView bdWebPoolCustomView) {
        initWebView(bdWebPoolCustomView);
        this.mWebViewList.add(bdWebPoolCustomView);
        if (this.mWebPoolViewClient != null) {
            this.mWebPoolViewClient.onWebViewAttached(bdWebPoolCustomView);
        }
    }

    public void addWebViewToPool(BdWebPoolCustomView bdWebPoolCustomView, int i) {
        initWebView(bdWebPoolCustomView);
        this.mWebViewList.add(i, bdWebPoolCustomView);
        if (isReplaceLoadMode() && this.mCurWebView != null) {
            recycleWebView(this.mCurWebView);
        }
        if (this.mWebPoolViewClient != null) {
            this.mWebPoolViewClient.onWebViewAttached(bdWebPoolCustomView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BdWebPoolCustomView genNewWebView() {
        BdWebPoolCustomView idleWebView = BdWebPoolViewManager.getInstance().getIdleWebView(getContext(), this);
        BdLog.d(idleWebView.toString());
        String string = getLoadExtra().getString(BUNDLE_LOAD_MODE);
        if (string != null && (string.equals(BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD_BY_NEW_WEBVIEW.name()) || string.equals(BdWebPoolCustomView.LoadMode.LOAD_REPLACE.name()))) {
            int findBackForwardNewWebViewLoc = findBackForwardNewWebViewLoc();
            BdLog.i("loc: " + findBackForwardNewWebViewLoc);
            if (findBackForwardNewWebViewLoc >= 0) {
                addWebViewToPool(idleWebView, findBackForwardNewWebViewLoc);
            } else {
                BdLog.w("can not find valid pos to put into webpool.");
                initWebView(idleWebView);
            }
        } else {
            addWebViewToPool(idleWebView);
        }
        return idleWebView;
    }

    private int findBackForwardNewWebViewLoc() {
        BdWebView webView;
        BdWebView webView2;
        BdWebView webView3;
        int curIndex = this.mBackForwardList.getCurIndex();
        try {
            BdWebPoolBackForwardListItem item = this.mBackForwardList.getItem(curIndex + 1);
            if (item != null && (webView3 = item.getWebView()) != null) {
                return this.mWebViewList.indexOf(webView3);
            }
        } catch (Exception e) {
            BdLog.w(e.getMessage());
        }
        try {
            BdWebPoolBackForwardListItem item2 = this.mBackForwardList.getItem(curIndex - 1);
            if (item2 != null && (webView2 = item2.getWebView()) != null) {
                return this.mWebViewList.indexOf(webView2) + 1;
            }
        } catch (Exception e2) {
            BdLog.w(e2.getMessage());
        }
        try {
            BdWebPoolBackForwardListItem item3 = this.mBackForwardList.getItem(curIndex);
            if (item3 != null && (webView = item3.getWebView()) != null) {
                return this.mWebViewList.indexOf(webView);
            }
        } catch (Exception e3) {
            BdLog.w(e3.getMessage());
        }
        return -1;
    }

    public int getWebViewCount() {
        return this.mWebViewList.size();
    }

    public boolean notifyNativeExitFullScreenIfNeeded(int i) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.notifyNativeExitFullScreenIfNeeded(i);
        }
        return false;
    }

    public Bitmap capturePicture(int i, int i2) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.capturePicture(i, i2);
        }
        return null;
    }

    public void emulateShiftHeldOnLink() {
        if (this.mCurWebView != null) {
            this.mCurWebView.emulateShiftHeldOnLink();
        }
    }

    public boolean isWapAllowScale() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.isWapAllowScale();
        }
        return false;
    }

    public int getActionNodesCount() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getActionNodesCount();
        }
        return 0;
    }

    public void onClickActionNode(int i) {
        if (this.mCurWebView != null) {
            this.mCurWebView.onClickActionNode(i);
        }
    }

    public String getActionNodeText(int i) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getActionNodeText(i);
        }
        return null;
    }

    public void startPreviewZoomScale() {
        if (this.mCurWebView != null) {
            this.mCurWebView.startPreviewZoomScale();
        }
    }

    public void setBeginScale() {
        if (this.mCurWebView != null) {
            this.mCurWebView.setBeginScale();
        }
    }

    public void setEndScale() {
        if (this.mCurWebView != null) {
            this.mCurWebView.setEndScale();
        }
    }

    public float getCurrentScale() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getCurrentScale();
        }
        return 0.0f;
    }

    public void setPreviewZoomScale(float f) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setPreviewZoomScale(f);
        }
    }

    public float getActualZoomScale() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getActualZoomScale();
        }
        return 0.0f;
    }

    public float getScale() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getScale();
        }
        return 0.0f;
    }

    public Picture capturePicture() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.capturePicture();
        }
        return null;
    }

    public void pageVisibilityChange(int i, boolean z) {
        if (this.mCurWebView != null) {
            this.mCurWebView.pageVisibilityChange(i, z);
        }
    }

    public boolean pageDown(boolean z) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.pageDown(z);
        }
        return false;
    }

    public boolean pageUp(boolean z) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.pageUp(z);
        }
        return false;
    }

    public void resumeWebkitDraw() {
        if (this.mCurWebView != null) {
            this.mCurWebView.resumeWebkitDraw();
        }
    }

    public void pauseWebkitDraw() {
        if (this.mCurWebView != null) {
            this.mCurWebView.pauseWebkitDraw();
        }
    }

    public boolean isNeedToFindTreasure() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.isNeedToFindTreasure();
        }
        return false;
    }

    public void exitFullScreenMode() {
        if (this.mCurWebView != null) {
            this.mCurWebView.exitFullScreenMode();
        }
    }

    public void setPictureListener(BdPictureListener bdPictureListener) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setPictureListener(bdPictureListener);
        }
    }

    public int getContentHeight() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getContentHeight();
        }
        return 0;
    }

    public int getContentWidth() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getContentWidth();
        }
        return 0;
    }

    public void setWebViewVisible(boolean z) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setWebViewVisible(z);
        }
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getHttpAuthUsernamePassword(str, str2);
        }
        return null;
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public Bitmap getCanvasCacheBmp() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getCanvasCacheBmp();
        }
        return null;
    }

    public void destroyCanvasCacheBmp() {
        if (this.mCurWebView != null) {
            this.mCurWebView.destroyCanvasCacheBmp();
        }
    }

    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setMapTrackballToArrowKeys(z);
        }
    }

    private boolean isReplaceLoadMode() {
        String string = getLoadExtra().getString(BUNDLE_LOAD_MODE);
        return string != null && string.equals(BdWebPoolCustomView.LoadMode.LOAD_REPLACE.name());
    }

    protected boolean isJsUrl(String str) {
        return str.startsWith("javascript:");
    }

    @Override // android.view.View
    public void setScrollbarFadingEnabled(boolean z) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setScrollbarFadingEnabled(z);
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setScrollBarStyle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDetectPoolUseCondition(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
        byte byteValue = bdWebPoolBackForwardListItem.getExtras().getByte(BUNDLE_PAGE_MAGNITUDE, (byte) 0).byteValue();
        BdLog.i("pageMagnitude: " + ((int) byteValue));
        BdWebPoolViewManager.getInstance().detectPoolUseCondition(byteValue);
    }

    public long getLastVisitTime() {
        return this.mLastVisitTime;
    }

    public void setLastVisitTime(long j) {
        this.mLastVisitTime = j;
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    public void setForeground(boolean z) {
        this.mIsForeground = z;
    }

    public void hideErrorPage() {
        onHideErrorPage();
    }

    @Override // com.baidu.browser.webkit.BdWebErrorEngine.BdWebErrorListener
    public void onShowErrorPage(int i) {
    }

    @Override // com.baidu.browser.webkit.BdWebErrorEngine.BdWebErrorListener
    public void onHideErrorPage() {
    }

    public void hideMaskView() {
        onHideMaskView();
    }

    public void onShowMaskView() {
        Log.d(LOG_TAG, "[onShowMaskView]");
        if (this.mMaskView.getParent() == null) {
            addView(this.mMaskView, new FrameLayout.LayoutParams(-1, -1));
        }
        this.mMaskView.onStart();
    }

    public void onHideMaskView() {
        Log.d(LOG_TAG, "[onHideMaskView]");
        if (this.mMaskView.getVisibility() == 0) {
            this.mMaskView.onStop();
            if (this.mCurWebView != null) {
                this.mCurWebView.getWebView().requestFocus();
            }
        }
    }

    public void setFindIsUp(boolean z) {
        if (this.mCurWebView != null) {
            this.mCurWebView.setFindIsUp(z);
        }
    }

    public boolean requestPoolFocus() {
        if (this.mCurWebView != null) {
            return this.mCurWebView.getWebView().requestFocus();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debugInfo(String str) {
        Log.d(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debugWarn(String str) {
        Log.w(LOG_TAG, str);
    }

    protected void setCanUseBackupWebView(boolean z) {
        this.mCanUseBackupWebView = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isCanUseBackupWebView() {
        return this.mCanUseBackupWebView;
    }

    private void setFullscreen(boolean z) {
        if (getContext() instanceof Activity) {
            Window window = ((Activity) getContext()).getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.flags |= NotificationProxy.MAX_URL_LENGTH;
            } else {
                attributes.flags &= -1025;
                if (this.mCustomView != null) {
                    BdUtil.invokeMethod(this.mCustomView, "setSystemUiVisibility", new Object[]{0}, null);
                }
            }
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCustomView(View view, int i, BdWebChromeClient.BdCustomViewCallback bdCustomViewCallback) {
        Context context = getContext();
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null) {
            if (this.mCustomView != null) {
                bdCustomViewCallback.onCustomViewHidden();
                return;
            }
            this.mOriginalOrientation = activity.getRequestedOrientation();
            this.mFullscreenContainer = new FullscreenHolder(activity);
            this.mFullscreenContainer.addView(view, COVER_SCREEN_PARAMS);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.mFullscreenContainer, COVER_SCREEN_PARAMS);
            this.mCustomView = view;
            setFullscreen(activity, true);
            this.mCustomViewCallback = bdCustomViewCallback;
            activity.setRequestedOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hideCustomView() {
        if (this.mCustomView == null) {
            return false;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            setFullscreen(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.mFullscreenContainer);
            this.mFullscreenContainer = null;
            this.mCustomView = null;
            this.mCustomViewCallback.onCustomViewHidden();
            activity.setRequestedOrientation(this.mOriginalOrientation);
        }
        return true;
    }

    public void setFullscreen(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, NotificationProxy.MAX_URL_LENGTH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class FullscreenHolder extends FrameLayout {
        public FullscreenHolder(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(context.getResources().getIdentifier("browser_black", "color", context.getPackageName())));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class BdWebPoolCustomViewClient extends BdWebViewClient {
        BdWebPoolCustomViewClient() {
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public BdWebView obtainWebViewWrapper(android.webkit.WebView webView) {
            return (BdWebView) webView.getTag();
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public BdWebView obtainWebViewWrapper(WebView webView) {
            return (BdWebView) webView.getTag();
        }

        private boolean procMarketIntent(String str) {
            boolean z;
            if (str == null) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i >= BdWebPoolView.ARRAY_STR_MARKET_URLS.length) {
                    z = false;
                    break;
                } else if (str.startsWith(BdWebPoolView.ARRAY_STR_MARKET_URLS[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                Context context = BdWebPoolView.this.getContext();
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    if (context.getPackageManager().resolveActivity(parseUri, 0) == null) {
                        String str2 = parseUri.getPackage();
                        if (str2 != null) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:" + str2));
                            intent.addCategory("android.intent.category.BROWSABLE");
                            context.startActivity(intent);
                            return true;
                        }
                        return false;
                    }
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(0).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PackageInfo next = it.next();
                        if (next.packageName.equals("com.baidu.appsearch")) {
                            parseUri.setPackage(next.packageName);
                            break;
                        }
                    }
                    parseUri.setComponent(null);
                    try {
                        if (context instanceof Activity) {
                            return ((Activity) context).startActivityIfNeeded(parseUri, -1);
                        }
                        return false;
                    } catch (ActivityNotFoundException e) {
                        BdLog.e("", e);
                        return false;
                    }
                } catch (URISyntaxException e2) {
                    Log.w("Browser", "Bad URI " + str + ": " + e2.getMessage());
                    return false;
                }
            }
            return false;
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public boolean shouldOverrideUrlLoading(BdWebView bdWebView, String str) {
            int indexOf;
            String str2;
            String str3;
            boolean z;
            BdLog.d(str);
            if (BdWebPoolView.this.mWebPoolViewClient == null || !BdWebPoolView.this.mWebPoolViewClient.shouldOverrideUrlLoading(BdWebPoolView.this, str)) {
                if (str.startsWith("about:")) {
                    return false;
                }
                if (str.startsWith("wtai://")) {
                    int length = "wtai://wp/wc;".length();
                    if (str.length() > length) {
                        BdWebPoolView.this.startDialer(str.substring(length));
                        return true;
                    }
                } else if (str.startsWith("tel:")) {
                    BdWebPoolView.this.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                } else if (str.startsWith("sms:")) {
                    int indexOf2 = str.indexOf("?");
                    if (indexOf2 < 5) {
                        str3 = str.substring(4);
                        str2 = "";
                    } else {
                        String substring = str.substring(4, indexOf2);
                        int indexOf3 = str.indexOf("body=");
                        if (indexOf3 > -1) {
                            str2 = str.substring(5 + indexOf3);
                            str3 = substring;
                        } else {
                            str2 = null;
                            str3 = substring;
                        }
                    }
                    BdWebPoolView.this.startMessager(str3, str2);
                    return true;
                } else if (str.startsWith("mailto:")) {
                    MailTo parse = MailTo.parse(str);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{parse.getTo()});
                    intent.putExtra("android.intent.extra.SUBJECT", parse.getSubject());
                    intent.putExtra("android.intent.extra.CC", parse.getCc());
                    intent.putExtra("android.intent.extra.TEXT", parse.getBody());
                    BdWebPoolView.this.getContext().startActivity(intent);
                    return true;
                } else if (str.startsWith("wandoujia:")) {
                    BdLog.w("wandoujia can not supported now.");
                    return false;
                } else if (procMarketIntent(str)) {
                    return true;
                } else {
                    if (str.startsWith("market://details?id=") && (indexOf = str.indexOf("market://details?id=")) >= 0) {
                        String substring2 = str.substring("market://details?id=".length() + indexOf);
                        BdLog.i(substring2);
                        if (substring2 != null) {
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent2.addCategory("android.intent.category.BROWSABLE");
                            Context context = BdWebPoolView.this.getContext();
                            if (context instanceof Activity) {
                                BdWebPoolView.this.startActivitySafely((Activity) context, intent2);
                                BdLog.i(String.valueOf(str) + " is a market download link, directly go back.");
                                BdWebPoolView.this.goBack();
                                return true;
                            }
                        }
                    }
                }
                BdWebPoolCustomView bdWebPoolCustomView = (BdWebPoolCustomView) bdWebView;
                if (BdWebPoolView.this.isValidUrl(bdWebPoolCustomView.getClickLink())) {
                    Bundle bundle = new Bundle();
                    bundle.putByte(BdWebPoolView.BUNDLE_CLINK_MODE, (byte) 1);
                    bundle.putByte(BdWebPoolView.BUNDLE_PAGE_TYPE, (byte) 1);
                    bundle.putString(BdWebPoolView.BUNDLE_LOAD_REFER, bdWebPoolCustomView.getUrl());
                    BdWebPoolView.this.getLoadExtra().putAll(bundle);
                    BdWebPoolView.this.loadUrl(str);
                    z = true;
                } else {
                    z = false;
                }
                bdWebPoolCustomView.setClickLink(null);
                return z;
            }
            return true;
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onPageStarted(BdWebView bdWebView, String str, Bitmap bitmap) {
            BdLog.d(str);
            int currentIndex = bdWebView.copyBackForwardList().getCurrentIndex() + 1;
            BdLog.d("newNativeIndex: " + currentIndex);
            BdWebPoolView.this.addBackForwardItem(bdWebView, str, currentIndex, true);
            BdWebPoolView.this.mWebErrorEngine.onPageStarted(bdWebView, str, bitmap);
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onPageStarted(BdWebPoolView.this, str, bitmap);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onPageFinished(BdWebView bdWebView, String str) {
            BdWebView webView;
            Log.d(BdWebPoolView.LOG_TAG, "[onPageFinished]Url:" + str);
            BdWebPoolView.this.checkNextItem();
            BdWebPoolView.this.onHideMaskView();
            int currentIndex = bdWebView.copyBackForwardList().getCurrentIndex();
            BdWebPoolView.this.addBackForwardItem(bdWebView, str, currentIndex, true);
            int curIndex = BdWebPoolView.this.mBackForwardList.getCurIndex();
            boolean isContainUrl = BdWebPoolView.this.isContainUrl(curIndex, str);
            boolean isInNativeIndex = BdWebPoolView.this.isInNativeIndex(bdWebView, curIndex, currentIndex);
            BdLog.i(String.valueOf(isContainUrl) + ", " + isInNativeIndex);
            BdWebPoolCustomView webViewByPos = BdWebPoolView.this.getWebViewByPos(BdWebPoolView.this.getWebViewIndex(bdWebView));
            if (webViewByPos != null && isContainUrl && isInNativeIndex) {
                webViewByPos.setLoadMode(BdWebPoolCustomView.LoadMode.LOAD_NORMAL);
            }
            Log.d(BdWebPoolView.LOG_TAG, "[onPageFinished]" + BdWebPoolView.this.toString());
            Log.d(BdWebPoolView.LOG_TAG, "[onPageFinished]" + BdWebPoolView.this.mBackForwardList.toString());
            BdWebPoolView.this.mWebErrorEngine.onPageFinished(bdWebView, str);
            try {
                BdWebPoolBackForwardListItem curItem = BdWebPoolView.this.mBackForwardList.getCurItem();
                if (curItem != null && curItem.getExtras().getByte(BdWebPoolView.BUNDLE_PAGE_MAGNITUDE, (byte) 0).byteValue() == 0) {
                    boolean isMobileSite = webViewByPos.isMobileSite();
                    BdLog.i("isMobileSite: " + isMobileSite);
                    if (isMobileSite) {
                        curItem.getExtras().putByte(BdWebPoolView.BUNDLE_PAGE_MAGNITUDE, (byte) 2);
                    } else {
                        curItem.getExtras().putByte(BdWebPoolView.BUNDLE_PAGE_MAGNITUDE, (byte) 1);
                    }
                }
            } catch (Exception e) {
                Log.d(BdWebPoolView.LOG_TAG, "[onPageFinished]Exception:" + e.getMessage());
            }
            BdWebPoolView.this.checkCurItem();
            try {
                BdWebPoolBackForwardListItem curItem2 = BdWebPoolView.this.mBackForwardList.getCurItem();
                if (curItem2 != null && (webView = curItem2.getWebView()) != null && (webView instanceof BdWebPoolCustomView)) {
                    BdWebPoolCustomView.LoadMode loadMode = ((BdWebPoolCustomView) webView).getLoadMode();
                    BdLog.d("loadMode: " + loadMode);
                    if (loadMode != BdWebPoolCustomView.LoadMode.LOAD_RELOAD && loadMode != BdWebPoolCustomView.LoadMode.LOAD_BACKORFORWARD) {
                        BdWebPoolView.this.onDetectPoolUseCondition(curItem2);
                    } else {
                        BdLog.i("go back or forward or refresh, not detect pool use condition.");
                        return;
                    }
                }
            } catch (Exception e2) {
                BdLog.w(e2.getMessage());
            }
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onPageFinished(BdWebPoolView.this, str);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onLoadResource(BdWebView bdWebView, String str) {
            BdWebPoolView.this.debugInfo("[onLoadResource]Url:" + str);
            int newItemIndex = BdWebPoolView.this.getNewItemIndex(bdWebView, str);
            if (newItemIndex >= 0) {
                String url = bdWebView.getUrl();
                BdWebHistoryItem itemAtIndex = bdWebView.copyBackForwardList().getItemAtIndex(newItemIndex);
                if (itemAtIndex != null) {
                    String url2 = itemAtIndex.getUrl();
                    if (url != null && url.equals(url2)) {
                        BdWebPoolView.this.addBackForwardItem(bdWebView, url, newItemIndex, true);
                    } else {
                        BdWebPoolView.this.debugWarn("not the item to add. " + url + ", " + url2);
                    }
                }
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onReceivedError(BdWebView bdWebView, int i, String str, String str2) {
            BdWebPoolView.this.debugInfo("[onReceivedError]ErrorCode:" + i + " Des:" + str);
            BdWebPoolView.this.mWebErrorEngine.onReceivedError(bdWebView, i, str, str2);
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onReceivedError(BdWebPoolView.this, i, str, str2);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onReceivedSslError(BdWebView bdWebView, BdSslErrorHandler bdSslErrorHandler, BdSslError bdSslError) {
            BdWebPoolView.this.debugInfo("[onReceivedSslError]");
            bdSslErrorHandler.proceed();
            BdWebPoolView.this.mWebErrorEngine.onReceivedSslError(bdWebView, bdSslErrorHandler, bdSslError);
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onReceivedSslError(BdWebPoolView.this, bdSslErrorHandler, bdSslError);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void doUpdateVisitedHistory(BdWebView bdWebView, String str, boolean z) {
            BdWebPoolView.this.debugInfo("[doUpdateVisitedHistory]Url:" + str + " isReload:" + z);
            BdWebPoolView.this.mWebErrorEngine.doUpdateVisitedHistory(bdWebView, str, z);
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onWapPageStarted(BdWebView bdWebView, String str, boolean z) {
            BdWebPoolView.this.debugInfo("[onWapPageStarted]Url:" + str + " isLoad:" + z);
            if (z) {
                BdWebPoolView.this.removeWapInvalidItem(str);
            } else {
                BdWebPoolView.this.onShowMaskView();
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onWapPageFinished(BdWebView bdWebView, String str) {
            BdWebPoolView.this.debugInfo("[onWapPageFinished]Url:" + str);
            BdWebPoolView.this.onHideMaskView();
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onReceivedHttpAuthRequest(BdWebView bdWebView, BdHttpAuthHandler bdHttpAuthHandler, String str, String str2) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onReceivedHttpAuthRequest(BdWebPoolView.this, bdHttpAuthHandler, str, str2);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onBaiduSearchPVCollected(BdWebView bdWebView) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onBaiduSearchPVCollected(BdWebPoolView.this);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onFirstLayoutDid(BdWebView bdWebView, String str) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onFirstLayoutDid(BdWebPoolView.this, str);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onSubjectsCollected(BdWebView bdWebView, boolean z, int i) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onSubjectsCollected(BdWebPoolView.this, z, i);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public boolean shouldShowSubject(BdWebView bdWebView, String str, String str2, String str3) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                return BdWebPoolView.this.mWebPoolViewClient.shouldShowSubject(BdWebPoolView.this, str, str2, str3);
            }
            return false;
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onMainActionsCollected(BdWebView bdWebView, boolean z, int i) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onMainActionsCollected(BdWebPoolView.this, z, i);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onPageCanBeScaled(BdWebView bdWebView) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onPageCanBeScaled(BdWebPoolView.this);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onFullScreenMode(BdWebView bdWebView, boolean z, int i, int i2) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onFullScreenMode(BdWebPoolView.this, z, i, i2);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebViewClient
        public void onHasVideo(BdWebView bdWebView) {
            if (BdWebPoolView.this.mWebPoolViewClient != null) {
                BdWebPoolView.this.mWebPoolViewClient.onHasVideo(BdWebPoolView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class BdWebPoolCustomChromeClient extends BdWebChromeClient {
        protected static final String JIS_NAME = "FLYFLOW-JSI:";
        protected static final String PARAM_SEPARATOR = "\\|";
        BdWebPoolCustomView webview;

        BdWebPoolCustomChromeClient(BdWebPoolCustomView bdWebPoolCustomView) {
            this.webview = bdWebPoolCustomView;
        }

        protected boolean isJsPromptDefaultValueValid(String str) {
            return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null")) ? false : true;
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public boolean onConsoleMessage(BdConsoleMessage bdConsoleMessage) {
            String message = bdConsoleMessage.message();
            if (TextUtils.isEmpty(message) || !message.startsWith(JIS_NAME)) {
                return super.onConsoleMessage(bdConsoleMessage);
            }
            BdWebPoolCustomJsClient webJsClient = this.webview.getWebJsClient();
            String substring = message.substring(JIS_NAME.length());
            int indexOf = substring.indexOf(58);
            if (indexOf != -1) {
                String substring2 = substring.substring(0, indexOf);
                String substring3 = substring.substring(indexOf + 1);
                if (!isJsPromptDefaultValueValid(substring3)) {
                    substring3 = null;
                }
                dispatchJsConsole(substring2, substring3, webJsClient);
            }
            return true;
        }

        private void dispatchJsConsole(String str, String str2, BdWebPoolCustomJsClient bdWebPoolCustomJsClient) {
            if (bdWebPoolCustomJsClient != null) {
                try {
                    if (str.equals("onGoBack")) {
                        bdWebPoolCustomJsClient.onGoBack(this.webview);
                    } else if (str.equals("onGoForward")) {
                        bdWebPoolCustomJsClient.onGoForward(this.webview);
                    } else if (str.equals("onGo")) {
                        if (str2 != null) {
                            bdWebPoolCustomJsClient.onGo(this.webview, Integer.parseInt(str2));
                        }
                    } else if (str.equals("onClick")) {
                        bdWebPoolCustomJsClient.onClick(this.webview, str2);
                    } else if (str.equals("onReload")) {
                        bdWebPoolCustomJsClient.onReload(this.webview);
                    }
                } catch (Exception e) {
                    BdLog.printStackTrace(e);
                }
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public BdWebView obtainWebViewWrapper(android.webkit.WebView webView) {
            return (BdWebView) webView.getTag();
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public BdWebView obtainWebViewWrapper(WebView webView) {
            return (BdWebView) webView.getTag();
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onProgressChanged(BdWebView bdWebView, int i) {
            BdWebPoolView.this.debugInfo("[onProgressChanged]Progress:" + i);
            if (i == 100) {
                BdWebPoolView.this.onHideMaskView();
            }
            BdWebPoolView.this.mWebErrorEngine.onProgressChanged(bdWebView, i);
            if (BdWebPoolView.this.mWebPoolChromeClient != null && bdWebView.equals(BdWebPoolView.this.mCurWebView)) {
                BdWebPoolView.this.mWebPoolChromeClient.onProgressChanged(BdWebPoolView.this, i);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onReceivedTitle(BdWebView bdWebView, String str) {
            BdWebPoolView.this.debugInfo("[onReceivedTitle]Title:" + str);
            ((BdWebPoolCustomView) bdWebView).runWebJsClientJavaScript();
            BdWebPoolView.this.mWebErrorEngine.onReceivedTitle(bdWebView, str);
            if (BdWebPoolView.this.mWebPoolChromeClient != null && bdWebView.equals(BdWebPoolView.this.mCurWebView)) {
                BdWebPoolView.this.mWebPoolChromeClient.onReceivedTitle(BdWebPoolView.this, str);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public Bitmap getDefaultVideoPoster() {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                return BdWebPoolView.this.mWebPoolChromeClient.getDefaultVideoPoster();
            }
            return null;
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public View getVideoLoadingProgressView() {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                return BdWebPoolView.this.mWebPoolChromeClient.getVideoLoadingProgressView();
            }
            return null;
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public boolean onCreateWindow(BdWebView bdWebView, boolean z, boolean z2, Message message, BdWebView.BdWebViewTransport bdWebViewTransport) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                return BdWebPoolView.this.mWebPoolChromeClient.onCreateWindow(BdWebPoolView.this, z, z2, message, bdWebViewTransport);
            }
            return false;
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onCloseWindow(BdWebView bdWebView) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.onCloseWindow(BdWebPoolView.this);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onHideCustomView() {
            BdWebPoolView.this.hideCustomView();
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onShowCustomView(View view, BdWebChromeClient.BdCustomViewCallback bdCustomViewCallback) {
            Activity activity;
            Context context = BdWebPoolView.this.getContext();
            if (!(context instanceof Activity)) {
                activity = null;
            } else {
                activity = (Activity) context;
            }
            onShowCustomView(view, activity.getRequestedOrientation(), bdCustomViewCallback);
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onShowCustomView(View view, int i, BdWebChromeClient.BdCustomViewCallback bdCustomViewCallback) {
            BdWebPoolView.this.showCustomView(view, i, bdCustomViewCallback);
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void openFileChooser(BdValueCallback<Uri> bdValueCallback, String str, String str2) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.openFileChooser(bdValueCallback, str, str2);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void openFileChooser(BdValueCallback<Uri> bdValueCallback, String str) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.openFileChooser(bdValueCallback, str);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void openFileChooser(BdValueCallback<Uri> bdValueCallback) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.openFileChooser(bdValueCallback);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, BdGeolocationPermissions.BdCallback bdCallback) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.onGeolocationPermissionsShowPrompt(str, bdCallback);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void copyText(BdWebView bdWebView, String str) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.copyText(BdWebPoolView.this, str);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public String getStringById(int i) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                return BdWebPoolView.this.mWebPoolChromeClient.getStringById(i);
            }
            return null;
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void hideMagnifier(BdWebView bdWebView, int i, int i2) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.hideMagnifier(BdWebPoolView.this, i, i2);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void hideSelectionActionDialog(BdWebView bdWebView) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.hideSelectionActionDialog(BdWebPoolView.this);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void moveMagnifier(BdWebView bdWebView, int i, int i2, int i3, int i4) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.moveMagnifier(BdWebPoolView.this, i, i2, i3, i4);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void performLongClick(BdWebView bdWebView, int i, String str, String str2, int i2, int i3) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.performLongClick(BdWebPoolView.this, i, str, str2, i2, i3);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void showMagnifier(BdWebView bdWebView, int i, int i2, int i3, int i4) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.showMagnifier(BdWebPoolView.this, i, i2, i3, i4);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void showSelectionActionDialog(BdWebView bdWebView, int i, int i2, int i3, int i4, String str) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.showSelectionActionDialog(BdWebPoolView.this, i, i2, i3, i4, str);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, bdQuotaUpdater);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onSetLoadURL(BdWebView bdWebView, String str) {
            ((BdWebPoolCustomView) bdWebView).setClickLink(str);
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.onSetLoadURL(BdWebPoolView.this, str);
            }
        }

        @Override // com.baidu.browser.webkit.BdWebChromeClient
        public void onReachedMaxAppCacheSize(long j, long j2, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
            if (BdWebPoolView.this.mWebPoolChromeClient != null) {
                BdWebPoolView.this.mWebPoolChromeClient.onReachedMaxAppCacheSize(j, j2, bdQuotaUpdater);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class BdWebPoolCustomJsClient extends BdWebJsClient {
        BdWebPoolCustomJsClient() {
        }

        @Override // com.baidu.browser.webkit.BdWebJsClient
        public void onGoBack(BdWebView bdWebView) {
            if (bdWebView.equals(BdWebPoolView.this.mCurWebView)) {
                BdWebPoolView.this.goBack();
            }
        }

        @Override // com.baidu.browser.webkit.BdWebJsClient
        public void onGoForward(BdWebView bdWebView) {
            if (bdWebView.equals(BdWebPoolView.this.mCurWebView)) {
                BdWebPoolView.this.getForeground();
            }
        }

        @Override // com.baidu.browser.webkit.BdWebJsClient
        public void onGo(BdWebView bdWebView, int i) {
            if (bdWebView.equals(BdWebPoolView.this.mCurWebView)) {
                if (i < 0) {
                    BdWebPoolView.this.goBack();
                } else if (i > 0) {
                    BdWebPoolView.this.goForward();
                }
            }
        }

        @Override // com.baidu.browser.webkit.BdWebJsClient
        public void onClick(BdWebView bdWebView, String str) {
            bdWebView.equals(BdWebPoolView.this.mCurWebView);
        }

        @Override // com.baidu.browser.webkit.BdWebJsClient
        public void onReload(BdWebView bdWebView) {
            if (bdWebView.equals(BdWebPoolView.this.mCurWebView)) {
                BdWebPoolView.this.reload();
            }
        }
    }
}
