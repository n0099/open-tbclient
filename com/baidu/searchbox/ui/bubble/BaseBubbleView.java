package com.baidu.searchbox.ui.bubble;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.tieba.R;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class BaseBubbleView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public static final boolean DEBUG = false;
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final int DEFAULT_TEXT_SIZE = 11;
    public static final String TAG = "BaseBubbleView";
    public BubbleFrameLayout mBubbleLayout;
    public TextView mContentView;
    public SimpleDraweeView mImageView;
    public int mTextColor;
    public int mTextSize;

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
    }

    public BaseBubbleView(Context context) {
        this(context, null);
    }

    public void setBubbleArrowPosition(float f) {
        BubbleFrameLayout bubbleFrameLayout = this.mBubbleLayout;
        if (bubbleFrameLayout != null) {
            bubbleFrameLayout.setArrowPosition(f);
            this.mBubbleLayout.requestLayout();
        }
    }

    public void setContent(String str) {
        if (this.mContentView != null && !TextUtils.isEmpty(str)) {
            this.mContentView.setText(str);
        }
    }

    public void setImageView(String str) {
        if (this.mImageView != null && URLUtil.isValidUrl(str)) {
            this.mImageView.setImageURI(Uri.parse(str));
        }
    }

    public void setTextColor(int i) {
        TextView textView = this.mContentView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        TextView textView = this.mContentView;
        if (textView != null) {
            textView.setTextSize(i);
        }
    }

    public BaseBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseBubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextColor = -16777216;
        this.mTextSize = 11;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.base_buddle_view, (ViewGroup) this, true);
        this.mBubbleLayout = (BubbleFrameLayout) findViewById(R.id.share_buddle_layout);
        this.mContentView = (TextView) findViewById(R.id.obfuscated_res_0x7f092214);
        this.mImageView = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f092213);
    }
}
