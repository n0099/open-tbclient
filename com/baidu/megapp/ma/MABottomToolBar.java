package com.baidu.megapp.ma;
/* loaded from: classes2.dex */
public class MABottomToolBar {
    public CommonToolBarType mCommonToolBarType = CommonToolBarType.TOOL_BAR_STYLE_NO;
    public CommonMenuType mCommonMenuType = CommonMenuType.MENU_STYLE_NO;
    public OnCommonToolBarClickListener mOnCommonToolBarClickListener = null;
    public OnCommonToolMenuClickListener mOnCommonToolMenuClickListener = null;
    public OnCommonToolBarItemClickListener mOnCommonToolBarItemClickListener = null;

    @Deprecated
    /* loaded from: classes2.dex */
    public enum CommonMenuType {
        MENU_STYLE_NO,
        MENU_STYLE_NS_NA,
        MENU_STYLE_NS_H5,
        MENU_STYLE_AD_IMMERSIVE_LANDING_PAGE
    }

    /* loaded from: classes2.dex */
    public enum CommonToolBarType {
        TOOL_BAR_STYLE_NO,
        TOOL_BAR_STYLE_NS,
        TOOL_BAR_STYLE_NEWS,
        TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface OnCommonToolBarClickListener {
        void onBackClick();
    }

    /* loaded from: classes2.dex */
    public interface OnCommonToolBarItemClickListener {
        public static final int TOOL_ITEM_BACK = 1;
        public static final int TOOL_ITEM_SHARE = 2;

        boolean onItemClick(int i2);
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface OnCommonToolMenuClickListener {
        void onRefreshClick();

        void onShareClick();
    }

    @Deprecated
    public OnCommonToolMenuClickListener getOnCommonToolMenuClickListener() {
        return this.mOnCommonToolMenuClickListener;
    }

    @Deprecated
    public OnCommonToolBarClickListener getOnToolBarClickListener() {
        return this.mOnCommonToolBarClickListener;
    }

    public OnCommonToolBarItemClickListener getOnToolBarItemClickListener() {
        return this.mOnCommonToolBarItemClickListener;
    }

    @Deprecated
    public CommonMenuType getToolBarMenuStyle() {
        return this.mCommonMenuType;
    }

    public CommonToolBarType getToolBarStyle() {
        return this.mCommonToolBarType;
    }

    @Deprecated
    public void setOnCommonToolMenuClickListener(OnCommonToolMenuClickListener onCommonToolMenuClickListener) {
        this.mOnCommonToolMenuClickListener = onCommonToolMenuClickListener;
    }

    @Deprecated
    public void setOnToolBarClickListener(OnCommonToolBarClickListener onCommonToolBarClickListener) {
        this.mOnCommonToolBarClickListener = onCommonToolBarClickListener;
    }

    public void setOnToolBarItemClickListener(OnCommonToolBarItemClickListener onCommonToolBarItemClickListener) {
        this.mOnCommonToolBarItemClickListener = onCommonToolBarItemClickListener;
    }

    @Deprecated
    public void setToolBarMenuStyle(CommonMenuType commonMenuType) {
        this.mCommonMenuType = commonMenuType;
    }

    public void setToolBarStyle(CommonToolBarType commonToolBarType) {
        this.mCommonToolBarType = commonToolBarType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mCommonToolBarType = " + this.mCommonToolBarType + "\n");
        sb.append("mCommonMenuType = " + this.mCommonMenuType + "\n");
        sb.append("mOnCommonToolBarClickListener = " + this.mOnCommonToolBarClickListener + "\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mOnCommonToolMenuClickListener = ");
        sb2.append(this.mOnCommonToolMenuClickListener);
        sb.append(sb2.toString());
        return sb.toString();
    }
}
