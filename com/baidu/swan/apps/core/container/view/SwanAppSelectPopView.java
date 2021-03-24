package com.baidu.swan.apps.core.container.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import d.b.g0.a.f;
@Keep
/* loaded from: classes3.dex */
public class SwanAppSelectPopView extends LinearLayout implements View.OnClickListener {
    public static final int SELECTION_PADDING = 22;
    public static final int SELECTION_TOP_DUR = 3000;
    public View mCopyView;
    public a mListener;
    public int mPopBottomY;
    public int mPopLeftX;
    public int mPopRightX;
    public int mPopTopY;
    public int mPopX;
    public int mPopY;
    public View mSearchView;
    public String mSelection;

    /* loaded from: classes3.dex */
    public interface a {
        void doSelectionCopy(String str);

        void doSelectionSearch(String str);
    }

    public SwanAppSelectPopView(Context context) {
        this(context, null);
    }

    public int getPopBottomY() {
        return this.mPopBottomY;
    }

    public int getPopLeftX() {
        return this.mPopLeftX;
    }

    public int getPopRightX() {
        return this.mPopRightX;
    }

    public int getPopTopY() {
        return this.mPopTopY;
    }

    public int getPopX() {
        return this.mPopX;
    }

    public int getPopY() {
        return this.mPopY;
    }

    public String getSelection() {
        return this.mSelection;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.mCopyView)) {
            a aVar2 = this.mListener;
            if (aVar2 != null) {
                aVar2.doSelectionCopy(this.mSelection);
            }
        } else if (!view.equals(this.mSearchView) || (aVar = this.mListener) == null) {
        } else {
            aVar.doSelectionSearch(this.mSelection);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(f.btn_wv_copy);
        this.mCopyView = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(f.btn_wv_search);
        this.mSearchView = findViewById2;
        findViewById2.setOnClickListener(this);
    }

    public void setEventListener(a aVar) {
        this.mListener = aVar;
    }

    public void setPopBottomY(int i) {
        this.mPopBottomY = i;
    }

    public void setPopLeftX(int i) {
        this.mPopLeftX = i;
    }

    public void setPopRightX(int i) {
        this.mPopRightX = i;
    }

    public void setPopTopY(int i) {
        this.mPopTopY = i;
    }

    public void setPopX(int i) {
        this.mPopX = i;
    }

    public void setPopY(int i) {
        this.mPopY = i;
    }

    public void setSelection(String str) {
        this.mSelection = str;
    }

    public SwanAppSelectPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
