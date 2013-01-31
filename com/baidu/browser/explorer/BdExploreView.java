package com.baidu.browser.explorer;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.browser.explorer.BdExplorePopView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.browser.explorer.WebStorageSizeManager;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webpool.BdWebPoolView;
/* loaded from: classes.dex */
public class BdExploreView extends BdWebPoolView implements BdExplorePopView.BdExplorePopViewListener, BdWebErrorView.BdErrorViewListener {
    public static final String BUNDLE_LAYOUT_TYPE = "LAYOUT_TYPE";
    public static final String BUNDLE_LOAD_WEBAPP = "LOAD_WEBAPP";
    private static final int CRITYCAL_POINT = 50;
    private ClipboardManager mClipboard;
    final GestureDetector mGestureDetector;
    private BdExploreViewListener mListener;
    private BdExplorePopView mPopupWindow;
    private int pointY;
    private WebStorageSizeManager webStorageSizeManager;

    public BdExploreView(Context context) {
        this(context, null);
    }

    public BdExploreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdExploreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.browser.explorer.BdExploreView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                BdWebView.BdHitTestResult hitTestResult = BdExploreView.this.getHitTestResult();
                if (hitTestResult != null) {
                    int type = hitTestResult.getType();
                    BdLog.d("type: " + type);
                    if (BdExploreView.this.mListener != null && !BdExploreView.this.checkPopMenuStatus() && type == 0) {
                        BdExploreView.this.mListener.onLongPress(hitTestResult);
                    }
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                BdLog.i("");
                if (BdExploreView.this.checkPopMenuStatus()) {
                    BdExploreView.this.doSelectionCancel();
                    return false;
                }
                return false;
            }
        });
        if (Build.VERSION.SDK_INT < 11) {
            this.mClipboard = (ClipboardManager) context.getSystemService("clipboard");
        } else {
            this.mClipboard = (ClipboardManager) context.getSystemService("clipboard");
        }
        this.mPopupWindow = (BdExplorePopView) LayoutInflater.from(getContext()).inflate(context.getResources().getIdentifier("browser_copy_search_view", "layout", context.getPackageName()), (ViewGroup) null);
        addView(this.mPopupWindow, new FrameLayout.LayoutParams(-2, -2));
        this.mPopupWindow.setVisibility(8);
        this.mPopupWindow.setEventListener(this);
        setWebViewClient(new BdExploreViewClient(this));
        setWebChromeClient(new BdExploreChromeClient(this));
        genNewWebView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = i3;
        int i10 = i2;
        int i11 = i;
        int i12 = i4;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt instanceof BdExplorePopView) {
                BdLog.d(String.valueOf(z) + ", " + i11 + ", " + i10 + ", " + i9 + ", " + i12);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                BdLog.d(String.valueOf(measuredWidth) + ", " + measuredHeight);
                BdExplorePopView bdExplorePopView = (BdExplorePopView) childAt;
                calcPopWindowPos(bdExplorePopView);
                if (bdExplorePopView != null) {
                    i6 = bdExplorePopView.getPopY() + i10;
                    i7 = i11 + bdExplorePopView.getPopX();
                } else {
                    i6 = i10;
                    i7 = i11;
                }
                int i13 = measuredWidth + i7;
                int i14 = i6 + measuredHeight;
                childAt.layout(i7, i6, i13, i14);
                i5 = i13;
                i11 = i7;
                i10 = i6;
                i12 = i14;
            } else {
                childAt.layout(i11, i10, i9, i12);
                i5 = i9;
            }
            i8++;
            i9 = i5;
        }
    }

    private void calcPopWindowPos(BdExplorePopView bdExplorePopView) {
        int popLeftX = bdExplorePopView.getPopLeftX();
        int popRightX = bdExplorePopView.getPopRightX();
        int popTopY = bdExplorePopView.getPopTopY();
        int popBottomY = bdExplorePopView.getPopBottomY();
        if (popLeftX <= popRightX) {
            popRightX = popLeftX;
            popLeftX = popRightX;
        }
        if (popTopY <= popBottomY) {
            popBottomY = popTopY;
            popTopY = popBottomY;
        }
        BdLog.d(String.valueOf(popRightX) + ", " + popLeftX + ", " + popBottomY + ", " + popTopY);
        int measuredWidth = bdExplorePopView.getMeasuredWidth();
        int width = getWidth();
        int i = ((popLeftX + popRightX) - measuredWidth) / 2;
        if (i + measuredWidth > width) {
            i = width - measuredWidth;
        }
        if (i < 0) {
            i = 0;
        }
        int measuredHeight = bdExplorePopView.getMeasuredHeight();
        int height = getHeight();
        int dip2pix = BdUtil.dip2pix(getContext(), 15.0f) + measuredHeight;
        int i2 = popBottomY - dip2pix;
        if (i2 < 0) {
            i2 = BdUtil.dip2pix(getContext(), 15.0f) + popTopY;
            bdExplorePopView.setBackgroundResource(getContext().getResources().getIdentifier("browser_select_menu_up_bg", "drawable", getContext().getPackageName()));
        } else {
            bdExplorePopView.setBackgroundResource(getContext().getResources().getIdentifier("browser_select_menu_down_bg", "drawable", getContext().getPackageName()));
        }
        int i3 = i2 + dip2pix > height ? (popTopY - popBottomY) - dip2pix : i2;
        bdExplorePopView.setPopX(i);
        bdExplorePopView.setPopY(i3);
        BdLog.d(String.valueOf(i) + ", " + i3);
    }

    @Override // com.baidu.browser.explorer.BdExplorePopView.BdExplorePopViewListener
    public void doSelectionCopy(String str) {
        doSelectionCancel();
        if (str.length() > 0) {
            this.mClipboard.setText(str);
            Toast.makeText(getContext(), getContext().getResources().getIdentifier("browser_text_selection_ok_tip", "string", getContext().getPackageName()), (int) BdExplorePopView.SELECTION_TOP_DUR).show();
            return;
        }
        Toast.makeText(getContext(), getContext().getResources().getIdentifier("browser_text_selection_fail_tip", "string", getContext().getPackageName()), (int) BdExplorePopView.SELECTION_TOP_DUR).show();
    }

    @Override // com.baidu.browser.explorer.BdExplorePopView.BdExplorePopViewListener
    public void doSelectionSearch(String str) {
        doSelectionCancel();
        if (str != null && str.length() > 0) {
            BdLog.i("start to search.");
            String trim = str.trim();
            if (this.mListener != null) {
                this.mListener.onSelectionSearch(trim);
                return;
            }
            return;
        }
        Toast.makeText(getContext(), getContext().getResources().getIdentifier("browser_text_selection_fail_tip", "string", getContext().getPackageName()), (int) BdExplorePopView.SELECTION_TOP_DUR).show();
    }

    @Override // com.baidu.browser.explorer.BdExplorePopView.BdExplorePopViewListener
    public void doSelectionCancel() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.setVisibility(8);
        }
        setExtendSelection(false);
        setTouchSelection(false);
        setShiftIsPressed(false);
        setSelectingText(false);
        BdLog.d("extendSelection: " + getExtendSelection());
        BdLog.d("touchSelection: " + getTouchSelection());
        BdLog.d("shiftIsPressed: " + getShiftIsPressed());
    }

    public boolean disposeShowOrHideTab(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int round = Math.round(motionEvent.getY());
        switch (action) {
            case 0:
                this.pointY = round;
                return true;
            case 1:
            case 3:
            default:
                return true;
            case 2:
                if (round - this.pointY < -50) {
                    if (this.mListener != null) {
                        this.mListener.onHideTabWindow();
                        return true;
                    }
                    return true;
                } else if (round - this.pointY > 0 && getCurScrollY() <= 0 && this.mListener != null) {
                    this.mListener.onShowTabWindow();
                    return true;
                } else {
                    return true;
                }
        }
    }

    @Override // com.baidu.browser.webpool.BdWebPoolView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mListener != null) {
            this.mListener.onWebViewTouch(motionEvent);
        }
        int action = motionEvent.getAction();
        BdLog.d("action: " + action);
        if (!checkPopMenuStatus()) {
            disposeShowOrHideTab(motionEvent);
        }
        boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            if (motionEvent.getPointerCount() > 1) {
                setExtendSelection(false);
            } else {
                boolean extendSelection = getExtendSelection();
                boolean selectingText = getSelectingText();
                if (action == 0 && ((extendSelection || selectingText) && this.mPopupWindow != null)) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    String selection = this.mPopupWindow.getSelection();
                    if (selection == null || selection.length() == 0) {
                        this.mPopupWindow.setPopLeftX(x);
                        this.mPopupWindow.setPopTopY(y);
                    }
                }
                if (action == 1 && (extendSelection || selectingText)) {
                    if (this.mPopupWindow != null) {
                        this.mPopupWindow.requestLayout();
                        int x2 = (int) motionEvent.getX();
                        int y2 = (int) motionEvent.getY();
                        String selection2 = this.mPopupWindow.getSelection();
                        if (selection2 == null || selection2.length() == 0) {
                            this.mPopupWindow.setPopRightX(x2);
                            this.mPopupWindow.setPopBottomY(y2);
                        } else if (x2 > (this.mPopupWindow.getPopLeftX() + this.mPopupWindow.getPopRightX()) / 2) {
                            this.mPopupWindow.setPopRightX(x2);
                            this.mPopupWindow.setPopBottomY(y2);
                        } else {
                            this.mPopupWindow.setPopLeftX(x2);
                            this.mPopupWindow.setPopTopY(y2);
                        }
                    }
                    if (Build.VERSION.SDK_INT < 14) {
                        return onUp();
                    }
                }
                if (action == 2 && (extendSelection || selectingText)) {
                    this.mPopupWindow.setVisibility(8);
                }
            }
            return superOnTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // com.baidu.browser.webpool.BdWebPoolView, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        BdWebView.BdHitTestResult hitTestResult = getHitTestResult();
        if (hitTestResult == null) {
            return false;
        }
        if (this.mListener != null && !checkPopMenuStatus()) {
            this.mListener.onLongPress(hitTestResult);
        }
        int type = hitTestResult.getType();
        BdLog.d("type: " + type);
        return type != 0;
    }

    private boolean onUp() {
        boolean extendSelection = getExtendSelection();
        boolean touchSelection = getTouchSelection();
        boolean shiftIsPressed = getShiftIsPressed();
        BdLog.d("extendSelection: " + extendSelection);
        BdLog.d("touchSelection: " + touchSelection);
        BdLog.d("shiftIsPressed: " + shiftIsPressed);
        BdLog.d("popLeftX: " + this.mPopupWindow.getPopLeftX());
        BdLog.d("popRightX: " + this.mPopupWindow.getPopRightX());
        BdLog.d("popTopY: " + this.mPopupWindow.getPopTopY());
        BdLog.d("popBottomY: " + this.mPopupWindow.getPopBottomY());
        boolean selectingText = getSelectingText();
        boolean drawSelectionPointer = getDrawSelectionPointer();
        if (extendSelection || (selectingText && !drawSelectionPointer)) {
            String selection = getSelection();
            BdLog.i(selection);
            BdLog.d("now show popup window.");
            showPopWindow();
            setDrawSelectionPointer(true);
            this.mPopupWindow.setSelection(selection);
        }
        return true;
    }

    public boolean checkPopMenuStatus() {
        return getExtendSelection() || getSelectingText();
    }

    private void showPopWindow() {
        if (this.mPopupWindow != null && this.mPopupWindow.getVisibility() != 0) {
            this.mPopupWindow.setVisibility(0);
        }
    }

    public void setEventListener(BdExploreViewListener bdExploreViewListener) {
        this.mListener = bdExploreViewListener;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (checkPopMenuStatus()) {
                doSelectionCancel();
                return true;
            } else if (hideCustomView()) {
                return true;
            } else {
                if (canGoBack()) {
                    goBack();
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean openVideoOnDownloadStart(String str, String str2, String str3) {
        if (str3 != null && str3.startsWith("video/") && (str2 == null || !str2.regionMatches(true, 0, "attachment", 0, 10))) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str3);
            Context context = getContext();
            ResolveInfo resolveActivity = getContext().getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                ComponentName componentName = activity.getComponentName();
                if (!componentName.getPackageName().equals(resolveActivity.activityInfo.packageName) || !componentName.getClassName().equals(resolveActivity.activityInfo.name)) {
                    try {
                        activity.startActivity(intent);
                        return true;
                    } catch (ActivityNotFoundException e) {
                        BdLog.e("Activity not found." + str3);
                    }
                }
            }
        }
        return false;
    }

    @Override // com.baidu.browser.explorer.BdWebErrorView.BdErrorViewListener
    public void onErrorPageGoBack() {
        goBack();
    }

    @Override // com.baidu.browser.explorer.BdWebErrorView.BdErrorViewListener
    public void onErrorPageRefresh() {
        reload();
    }

    public boolean goBackNotToHome() {
        return super.goBack();
    }

    public WebStorageSizeManager getWebStorageSizeManagerInstance() {
        if (this.webStorageSizeManager == null) {
            String path = getContext().getDir("appcache", 0).getPath();
            this.webStorageSizeManager = new WebStorageSizeManager(getContext(), new WebStorageSizeManager.StatFsDiskInfo(path), new WebStorageSizeManager.WebKitAppCacheInfo(path));
        }
        return this.webStorageSizeManager;
    }
}
