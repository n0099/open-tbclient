package com.baidu.browser.explorer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.browser.core.BdNoProGuard;
/* loaded from: classes.dex */
public class BdExplorePopView extends LinearLayout implements View.OnClickListener, BdNoProGuard {
    public static final int SELECTION_PADDING = 15;
    public static final int SELECTION_TOP_DUR = 3000;
    private LinearLayout mCopyView;
    private BdExplorePopViewListener mListener;
    private int mPopBottomY;
    private int mPopLeftX;
    private int mPopRightX;
    private int mPopTopY;
    private int mPopX;
    private int mPopY;
    private LinearLayout mSearchView;
    private String mSelection;

    /* loaded from: classes.dex */
    public interface BdExplorePopViewListener {
        void doSelectionCancel();

        void doSelectionCopy(String str);

        void doSelectionSearch(String str);
    }

    public BdExplorePopView(Context context) {
        this(context, null);
    }

    public BdExplorePopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.mCopyView = (LinearLayout) findViewById(getContext().getResources().getIdentifier("btn_wv_copy", "id", getContext().getPackageName()));
        this.mCopyView.setOnClickListener(this);
        this.mSearchView = (LinearLayout) findViewById(getContext().getResources().getIdentifier("btn_wv_search", "id", getContext().getPackageName()));
        this.mSearchView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.mCopyView)) {
            if (this.mListener != null) {
                this.mListener.doSelectionCopy(this.mSelection);
            }
        } else if (view.equals(this.mSearchView) && this.mListener != null) {
            this.mListener.doSelectionSearch(this.mSelection);
        }
    }

    public int getPopX() {
        return this.mPopX;
    }

    public void setPopX(int i) {
        this.mPopX = i;
    }

    public int getPopY() {
        return this.mPopY;
    }

    public void setPopY(int i) {
        this.mPopY = i;
    }

    public int getPopLeftX() {
        return this.mPopLeftX;
    }

    public void setPopLeftX(int i) {
        this.mPopLeftX = i;
    }

    public int getPopRightX() {
        return this.mPopRightX;
    }

    public void setPopRightX(int i) {
        this.mPopRightX = i;
    }

    public int getPopTopY() {
        return this.mPopTopY;
    }

    public void setPopTopY(int i) {
        this.mPopTopY = i;
    }

    public int getPopBottomY() {
        return this.mPopBottomY;
    }

    public void setPopBottomY(int i) {
        this.mPopBottomY = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelection(String str) {
        this.mSelection = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getSelection() {
        return this.mSelection;
    }

    public void setEventListener(BdExplorePopViewListener bdExplorePopViewListener) {
        this.mListener = bdExplorePopViewListener;
    }
}
