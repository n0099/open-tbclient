package com.baidu.searchbox.ui.bubble;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.PopupWindow;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class PopupBubble extends BdMenu {
    public static final int BUBBLE_ARROW_OFFSET_RIGHT = 15;
    public static final int BUBBLE_ARROW_WIDTH = 10;
    public static final boolean DEBUG = false;
    public static final int MARGIN_BETWEEN_BUBBLE_TOOLBAR = 1;
    public static final int SHOW_DURATION = 7000;
    public static final String TAG = "PopupBubble";
    public BaseBubbleView mBubbleView;
    public int mGravity;
    public int mXOffset;
    public int mYOffset;

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void ensureMenuLoaded(View view2, List<BdMenuItem> list) {
    }

    public PopupBubble(View view2) {
        super(view2);
        this.mXOffset = 0;
        this.mYOffset = 0;
        this.mGravity = 83;
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public View getMenuView(Context context) {
        BaseBubbleView baseBubbleView = new BaseBubbleView(context);
        this.mBubbleView = baseBubbleView;
        return baseBubbleView;
    }

    public void onConfigurationChanged(Configuration configuration) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing() && this.mViewToAttach != null) {
            dismiss();
        }
    }

    public void setBubbleBackground(String str) {
        if (this.mBubbleView != null && URLUtil.isValidUrl(str)) {
            this.mBubbleView.setImageView(str);
        }
    }

    public void setBubbleContent(String str) {
        if (this.mBubbleView != null && !TextUtils.isEmpty(str)) {
            this.mBubbleView.setContent(str);
        }
    }

    public void setBubbleTextColor(String str) {
        if (this.mBubbleView != null && !TextUtils.isEmpty(str)) {
            try {
                this.mBubbleView.setTextColor(this.mContext.getResources().getColor(R.color.feed_share_bubble_stroke_color));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        if (popupWindow == null) {
            return;
        }
        popupWindow.setFocusable(false);
        calculateLocationPos();
        popupWindow.showAtLocation(this.mViewToAttach, this.mGravity, this.mXOffset, this.mYOffset);
        dismiss(7000L);
    }

    private void calculateLocationPos() {
        Rect rect = new Rect();
        this.mViewToAttach.getGlobalVisibleRect(rect);
        if (!rect.isEmpty()) {
            this.mBubbleView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = this.mBubbleView.getMeasuredWidth() - ((DeviceUtil.ScreenInfo.getDisplayWidth(null) - rect.centerX()) - DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 15.0f));
            this.mXOffset = rect.centerX() - measuredWidth;
            this.mBubbleView.setBubbleArrowPosition(measuredWidth - DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 5.0f));
            this.mYOffset = ((int) this.mViewToAttach.getResources().getDimension(R.dimen.obfuscated_res_0x7f07024f)) + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 1.0f);
        }
    }
}
