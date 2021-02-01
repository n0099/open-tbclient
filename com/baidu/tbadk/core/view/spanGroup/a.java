package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.spanGroup.a;
/* loaded from: classes.dex */
public abstract class a<T extends a> {
    private static int fnU = 1;
    protected Editable fnV;
    private InterfaceC0565a fnW;
    private int mEnd;
    private int mFontSize;
    private final int mId;
    private boolean mIsValid;
    private int mStart;

    /* renamed from: com.baidu.tbadk.core.view.spanGroup.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0565a {
        void G(int i, boolean z);
    }

    public abstract void a(Editable editable, int i);

    public abstract void b(Editable editable);

    public a() {
        int i = fnU;
        fnU = i + 1;
        this.mId = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.fnV = editable;
        this.mStart = i;
        this.mEnd = i2;
        this.mFontSize = i3;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setValid(boolean z) {
        boolean z2 = this.mIsValid;
        this.mIsValid = z;
        if (z2 != z && this.fnW != null) {
            this.fnW.G(this.mId, z);
        }
    }

    public Editable getText() {
        return this.fnV;
    }

    public void c(Editable editable) {
        this.fnV = editable;
    }

    public int getStart() {
        return this.mStart;
    }

    public void pW(int i) {
        this.mStart = i;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public void pX(int i) {
        this.mEnd = i;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        this.mIsValid = t.isValid();
        this.fnV = t.getText();
        this.mStart = t.getStart();
        this.mEnd = t.getEnd();
        this.mFontSize = t.getFontSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (this.fnV != null) {
            this.fnV.setSpan(obj, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@NonNull CharSequence charSequence) {
        if (this.fnV != null && charSequence != null) {
            try {
                this.fnV.replace(this.mStart, this.mEnd, charSequence);
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.mEnd = this.mStart + charSequence.length();
        }
    }

    public void a(InterfaceC0565a interfaceC0565a) {
        this.fnW = interfaceC0565a;
    }
}
