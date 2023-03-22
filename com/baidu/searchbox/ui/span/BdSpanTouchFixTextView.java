package com.baidu.searchbox.ui.span;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.baidu.searchbox.ui.UnifyTextView;
/* loaded from: classes2.dex */
public class BdSpanTouchFixTextView extends UnifyTextView implements ISpanTouchFix {
    public boolean mNeedForceEventToParent;
    public boolean mRealPressStatus;
    public boolean mSuperNeedLongClickEvent;
    public boolean mSyncSpanPressStatus;
    public boolean mTouchSpanHit;

    public BdSpanTouchFixTextView(Context context) {
        this(context, null);
    }

    public void onSetPressed(boolean z) {
        super.setPressed(z);
    }

    @Override // com.baidu.searchbox.ui.span.ISpanTouchFix
    public void onSpanSetPressed(boolean z) {
        if (this.mSyncSpanPressStatus) {
            setPressed(z);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(getText() instanceof Spannable)) {
            return super.onTouchEvent(motionEvent);
        }
        this.mTouchSpanHit = false;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.mNeedForceEventToParent) {
            return this.mTouchSpanHit;
        }
        return onTouchEvent;
    }

    public void setNeedForceEventToParent(boolean z) {
        this.mNeedForceEventToParent = z;
        setFocusable(!z);
        setClickable(!z);
        setLongClickable(!z);
    }

    @Override // android.view.View
    public final void setPressed(boolean z) {
        this.mRealPressStatus = z;
        if (this.mSyncSpanPressStatus || !this.mTouchSpanHit) {
            onSetPressed(z);
        }
    }

    public void setSuperNeedLongClickEvent(boolean z) {
        this.mSuperNeedLongClickEvent = z;
    }

    public void setSyncSpanPressStatus(boolean z) {
        this.mSyncSpanPressStatus = z;
    }

    @Override // com.baidu.searchbox.ui.span.ISpanTouchFix
    public void setTouchSpanHit(boolean z) {
        if (this.mTouchSpanHit != z) {
            this.mTouchSpanHit = z;
            setPressed(this.mRealPressStatus);
        }
    }

    public BdSpanTouchFixTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdSpanTouchFixTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRealPressStatus = false;
        this.mNeedForceEventToParent = false;
        this.mSyncSpanPressStatus = false;
        this.mSuperNeedLongClickEvent = false;
        setHighlightColor(0);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (!this.mTouchSpanHit && !this.mNeedForceEventToParent) {
            return super.performClick();
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        if ((!this.mTouchSpanHit && !this.mNeedForceEventToParent) || this.mSuperNeedLongClickEvent) {
            return super.performLongClick();
        }
        return false;
    }

    public void setBdMovementMethod() {
        setMovementMethod(BdLinkTouchMovementMethod.getInstance());
        if (this.mNeedForceEventToParent) {
            setNeedForceEventToParent(true);
        }
    }
}
