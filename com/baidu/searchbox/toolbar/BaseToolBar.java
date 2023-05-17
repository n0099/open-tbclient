package com.baidu.searchbox.toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class BaseToolBar extends LinearLayout implements View.OnClickListener {
    public int mFontSizeLevel;
    public boolean mIsHightToolbarType;
    public boolean mIsResponseFontSize;
    public List<BaseToolBarItem> mItemList;
    public OnCommonToolItemClickListener mListener;

    public BaseToolBar(Context context, List<BaseToolBarItem> list) {
        super(context);
        this.mIsResponseFontSize = true;
        this.mFontSizeLevel = FontSizeHelper.getFontSizeType();
        this.mIsHightToolbarType = false;
        init(list);
    }

    public BaseToolBar(Context context, List<BaseToolBarItem> list, boolean z) {
        super(context);
        this.mIsResponseFontSize = true;
        this.mFontSizeLevel = FontSizeHelper.getFontSizeType();
        this.mIsHightToolbarType = false;
        this.mIsResponseFontSize = z;
        init(list);
    }

    public BaseToolBar(Context context, List<BaseToolBarItem> list, boolean z, boolean z2) {
        super(context);
        this.mIsResponseFontSize = true;
        this.mFontSizeLevel = FontSizeHelper.getFontSizeType();
        this.mIsHightToolbarType = false;
        this.mIsResponseFontSize = z;
        this.mIsHightToolbarType = z2;
        init(list);
    }

    private void init(List<BaseToolBarItem> list) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelOffset(BaseToolBarExtKt.getBarHeightDimen(this))));
        setPadding(0, 0, 0, 0);
        setGravity(16);
        update(list);
    }

    @NonNull
    public View createToolBarItemView(int i) {
        return new View(getContext());
    }

    public boolean getIsResponseFontSize(int i) {
        BaseToolBarItem toolBarItem = getToolBarItem(i);
        if (toolBarItem == null) {
            return false;
        }
        return toolBarItem.isResponseFontSize();
    }

    @Nullable
    public BaseToolBarItem getToolBarItem(int i) {
        for (BaseToolBarItem baseToolBarItem : this.mItemList) {
            if (baseToolBarItem.getItemId() == i) {
                return baseToolBarItem;
            }
        }
        return null;
    }

    @Nullable
    public View getToolBarItemView(int i) {
        for (BaseToolBarItem baseToolBarItem : this.mItemList) {
            if (baseToolBarItem.getItemId() == i) {
                return baseToolBarItem.getItemView();
            }
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.mListener != null) {
            this.mListener.onItemClick(view2, getToolBarItem(view2));
        }
    }

    public void setIsResponseFontSize(boolean z) {
        this.mIsResponseFontSize = z;
        updateBarHeight();
    }

    public void setItemClickListener(OnCommonToolItemClickListener onCommonToolItemClickListener) {
        this.mListener = onCommonToolItemClickListener;
    }

    private void updateBarHeight() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = getResources().getDimensionPixelOffset(BaseToolBarExtKt.getBarHeightDimen(this));
            setLayoutParams(layoutParams);
        }
    }

    public boolean getIsHightToolbarType() {
        return this.mIsHightToolbarType;
    }

    public boolean getIsResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsResponseFontSize) {
            BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() { // from class: com.baidu.searchbox.toolbar.BaseToolBar.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.bdeventbus.Action
                public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                    BaseToolBar.this.onFontSizeChange();
                }
            });
            int i = this.mFontSizeLevel;
            int fontSizeType = FontSizeHelper.getFontSizeType();
            this.mFontSizeLevel = fontSizeType;
            if (fontSizeType != i) {
                onFontSizeChange();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void onFontSizeChange() {
        this.mFontSizeLevel = FontSizeHelper.getFontSizeType();
        updateBarHeight();
        List<BaseToolBarItem> list = this.mItemList;
        if (list != null) {
            for (BaseToolBarItem baseToolBarItem : list) {
                if (baseToolBarItem != null && baseToolBarItem.isResponseFontSize()) {
                    baseToolBarItem.onFontSizeChange();
                }
            }
        }
    }

    public void reset() {
        update(this.mItemList);
    }

    @Nullable
    public BaseToolBarItem getToolBarItem(View view2) {
        for (BaseToolBarItem baseToolBarItem : this.mItemList) {
            if (baseToolBarItem.getItemView() == view2) {
                return baseToolBarItem;
            }
        }
        return null;
    }

    public void update(List<BaseToolBarItem> list) {
        removeAllViews();
        this.mItemList = list;
        if (list != null && list.size() > 0) {
            for (BaseToolBarItem baseToolBarItem : this.mItemList) {
                if (baseToolBarItem.getItemView() == null) {
                    baseToolBarItem.setItemView(createToolBarItemView(baseToolBarItem.getItemId()));
                }
                if (baseToolBarItem.getItemView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) baseToolBarItem.getItemView().getParent()).removeView(baseToolBarItem.getItemView());
                }
                addView(baseToolBarItem.getItemView());
                if (!baseToolBarItem.isCustomClick()) {
                    baseToolBarItem.getItemView().setOnClickListener(this);
                }
            }
        }
    }
}
