package com.baidu.megapp.ma;
/* loaded from: classes10.dex */
public class MABottomToolBar {
    private CommonToolBarType mCommonToolBarType = CommonToolBarType.TOOL_BAR_STYLE_NO;
    private CommonMenuType mCommonMenuType = CommonMenuType.MENU_STYLE_NO;
    private OnCommonToolBarClickListener mOnCommonToolBarClickListener = null;
    private OnCommonToolMenuClickListener mOnCommonToolMenuClickListener = null;
    private OnCommonToolBarItemClickListener mOnCommonToolBarItemClickListener = null;

    @Deprecated
    /* loaded from: classes10.dex */
    public enum CommonMenuType {
        MENU_STYLE_NO,
        MENU_STYLE_NS_NA,
        MENU_STYLE_NS_H5,
        MENU_STYLE_AD_IMMERSIVE_LANDING_PAGE
    }

    /* loaded from: classes10.dex */
    public enum CommonToolBarType {
        TOOL_BAR_STYLE_NO,
        TOOL_BAR_STYLE_NS,
        TOOL_BAR_STYLE_NEWS,
        TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE
    }

    @Deprecated
    /* loaded from: classes10.dex */
    public interface OnCommonToolBarClickListener {
        void onBackClick();
    }

    /* loaded from: classes10.dex */
    public interface OnCommonToolBarItemClickListener {
        public static final int TOOL_ITEM_BACK = 1;
        public static final int TOOL_ITEM_SHARE = 2;

        boolean onItemClick(int i);
    }

    @Deprecated
    /* loaded from: classes10.dex */
    public interface OnCommonToolMenuClickListener {
        void onRefreshClick();

        void onShareClick();
    }

    public void setToolBarStyle(CommonToolBarType commonToolBarType) {
        this.mCommonToolBarType = commonToolBarType;
    }

    public CommonToolBarType getToolBarStyle() {
        return this.mCommonToolBarType;
    }

    public void setOnToolBarItemClickListener(OnCommonToolBarItemClickListener onCommonToolBarItemClickListener) {
        this.mOnCommonToolBarItemClickListener = onCommonToolBarItemClickListener;
    }

    public OnCommonToolBarItemClickListener getOnToolBarItemClickListener() {
        return this.mOnCommonToolBarItemClickListener;
    }

    @Deprecated
    public void setToolBarMenuStyle(CommonMenuType commonMenuType) {
        this.mCommonMenuType = commonMenuType;
    }

    @Deprecated
    public CommonMenuType getToolBarMenuStyle() {
        return this.mCommonMenuType;
    }

    @Deprecated
    public void setOnToolBarClickListener(OnCommonToolBarClickListener onCommonToolBarClickListener) {
        this.mOnCommonToolBarClickListener = onCommonToolBarClickListener;
    }

    @Deprecated
    public OnCommonToolBarClickListener getOnToolBarClickListener() {
        return this.mOnCommonToolBarClickListener;
    }

    @Deprecated
    public void setOnCommonToolMenuClickListener(OnCommonToolMenuClickListener onCommonToolMenuClickListener) {
        this.mOnCommonToolMenuClickListener = onCommonToolMenuClickListener;
    }

    @Deprecated
    public OnCommonToolMenuClickListener getOnCommonToolMenuClickListener() {
        return this.mOnCommonToolMenuClickListener;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mCommonToolBarType = " + this.mCommonToolBarType + "\n");
        sb.append("mCommonMenuType = " + this.mCommonMenuType + "\n");
        sb.append("mOnCommonToolBarClickListener = " + this.mOnCommonToolBarClickListener + "\n");
        sb.append("mOnCommonToolMenuClickListener = " + this.mOnCommonToolMenuClickListener);
        return sb.toString();
    }
}
