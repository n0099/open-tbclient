package com.baidu.swan.apps.core.container.view;

import android.content.Context;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.a;
@Keep
/* loaded from: classes2.dex */
public class SwanAppSelectPopView extends LinearLayout implements View.OnClickListener {
    public static final int SELECTION_PADDING = 22;
    public static final int SELECTION_TOP_DUR = 3000;
    private View mCopyView;
    private a mListener;
    private int mPopBottomY;
    private int mPopLeftX;
    private int mPopRightX;
    private int mPopTopY;
    private int mPopX;
    private int mPopY;
    private View mSearchView;
    private String mSelection;

    /* loaded from: classes2.dex */
    public interface a {
        void dR(String str);

        void dS(String str);
    }

    public SwanAppSelectPopView(Context context) {
        this(context, null);
    }

    public SwanAppSelectPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mCopyView = findViewById(a.f.btn_wv_copy);
        this.mCopyView.setOnClickListener(this);
        this.mSearchView = findViewById(a.f.btn_wv_search);
        this.mSearchView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.mCopyView)) {
            if (this.mListener != null) {
                this.mListener.dR(this.mSelection);
            }
        } else if (view.equals(this.mSearchView) && this.mListener != null) {
            this.mListener.dS(this.mSelection);
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

    public void setSelection(String str) {
        this.mSelection = str;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public void setEventListener(a aVar) {
        this.mListener = aVar;
    }
}
