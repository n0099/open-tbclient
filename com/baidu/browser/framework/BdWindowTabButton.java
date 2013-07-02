package com.baidu.browser.framework;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.core.util.BdUtil;
/* loaded from: classes.dex */
public class BdWindowTabButton extends LinearLayout {
    private int UI_TEXT_COLOR_FOCUS;
    private int UI_TEXT_COLOR_NORMAL;
    private int UI_TEXT_SIZE;
    private ImageView mCloseIcon;
    private ImageView mIcon;
    private BdWindowTabCtrl mParentWindowCtrl;
    private boolean mSearchMode;
    private boolean mSelected;
    private TextView mTitle;
    private BdWindow mWindow;
    private int pressX;

    public BdWindowTabButton(Context context, boolean z, BdWindowTabCtrl bdWindowTabCtrl) {
        super(context);
        this.UI_TEXT_COLOR_NORMAL = -6710887;
        this.UI_TEXT_COLOR_FOCUS = -14540254;
        this.UI_TEXT_SIZE = 15;
        this.mParentWindowCtrl = bdWindowTabCtrl;
        this.mSearchMode = z;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = BdUtil.dip2pix(context, 2.0f);
        if (z) {
            this.mIcon = new ImageView(context);
            addView(this.mIcon, layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 17;
        this.mCloseIcon = new ImageView(context);
        this.mCloseIcon.setImageResource(getContext().getResources().getIdentifier("browser_tabwindow_tab_close_selector", "drawable", getContext().getPackageName()));
        this.mTitle = new TextView(context);
        this.mTitle.setGravity(17);
        this.mTitle.setSingleLine();
        this.mTitle.setTextSize(this.UI_TEXT_SIZE);
        this.mTitle.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitle.setText(getContext().getResources().getIdentifier("browser_tab_default_text", "string", getContext().getPackageName()));
        addView(this.mTitle, layoutParams2);
        addView(this.mCloseIcon, layoutParams);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.mSelected;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.mSelected = z;
        if (this.mSelected) {
            if (isSearchMode()) {
                setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tabsearch_selected", "drawable", getContext().getPackageName()));
                this.mIcon.setImageResource(getContext().getResources().getIdentifier("browser_icon_searchtab_selected", "drawable", getContext().getPackageName()));
                return;
            }
            if (this.mTitle != null) {
                this.mTitle.setTextColor(this.UI_TEXT_COLOR_FOCUS);
            }
            this.mCloseIcon.setVisibility(0);
            setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tab_selected", "drawable", getContext().getPackageName()));
        } else if (isSearchMode()) {
            setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tabsearch_normal", "drawable", getContext().getPackageName()));
            this.mIcon.setImageResource(getContext().getResources().getIdentifier("browser_icon_searchtab_normal", "drawable", getContext().getPackageName()));
        } else {
            if (this.mTitle != null) {
                this.mTitle.setTextColor(this.UI_TEXT_COLOR_NORMAL);
            }
            this.mCloseIcon.setVisibility(8);
            setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tab_normal", "drawable", getContext().getPackageName()));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        refreshBackground(action);
        int round = Math.round(motionEvent.getX());
        int round2 = Math.round(motionEvent.getY());
        switch (action) {
            case 0:
                this.pressX = round;
                return true;
            case 1:
                if ((!this.mSelected && round2 < getHeight()) || (this.pressX < getWidth() / 2 && round < getWidth() / 2 && round2 < getHeight())) {
                    this.mParentWindowCtrl.selectWindowToFocus(this);
                    return true;
                } else if (!this.mSearchMode && this.mSelected && this.pressX > getWidth() / 2 && round > getWidth() / 2 && round2 < getHeight()) {
                    this.mParentWindowCtrl.removeTab(this);
                    return true;
                } else {
                    return true;
                }
            case 2:
            default:
                return true;
        }
    }

    public void refreshBackground(int i) {
        switch (i) {
            case 0:
                if (this.mSearchMode) {
                    if (this.mSelected) {
                        setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tabsearch_selected", "drawable", getContext().getPackageName()));
                        return;
                    } else {
                        setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tabsearch_normal", "drawable", getContext().getPackageName()));
                        return;
                    }
                }
                setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tab_press", "drawable", getContext().getPackageName()));
                return;
            case 1:
                if (this.mSearchMode) {
                    if (this.mSelected) {
                        setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tabsearch_selected", "drawable", getContext().getPackageName()));
                        return;
                    } else {
                        setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tabsearch_normal", "drawable", getContext().getPackageName()));
                        return;
                    }
                } else if (this.mSelected) {
                    setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tab_selected", "drawable", getContext().getPackageName()));
                    return;
                } else {
                    setBackgroundResource(getContext().getResources().getIdentifier("browser_tabwindow_tab_normal", "drawable", getContext().getPackageName()));
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    public void setTitleText(String str) {
        if (this.mTitle != null) {
            if (!TextUtils.isEmpty(str)) {
                this.mTitle.setText(str);
            } else {
                this.mTitle.setText(getContext().getString(getContext().getResources().getIdentifier("browser_tab_default_text", "string", getContext().getPackageName())));
            }
        }
    }

    public BdWindow getWindow() {
        return this.mWindow;
    }

    public void setWindow(BdWindow bdWindow) {
        this.mWindow = bdWindow;
        if (this.mWindow != null) {
            this.mWindow.setTab(this);
        }
    }

    public boolean isSearchMode() {
        return this.mSearchMode;
    }

    public void setSearchMode(boolean z) {
        this.mSearchMode = z;
    }
}
