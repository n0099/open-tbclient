package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Editable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.spanGroup.a;
/* loaded from: classes.dex */
public abstract class a<T extends a> {
    private static int ehi = 1;
    private Editable ehj;
    private int mEnd;
    private int mFontSize;
    private final int mId;
    private boolean mIsValid;
    private int mStart;

    public abstract void a(Editable editable);

    public abstract void b(Editable editable);

    public a() {
        int i = ehi;
        ehi = i + 1;
        this.mId = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.ehj = editable;
        this.mStart = i;
        this.mEnd = i2;
        this.mFontSize = i3;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setValid(boolean z) {
        this.mIsValid = z;
    }

    public Editable aYX() {
        return this.ehj;
    }

    public void c(Editable editable) {
        this.ehj = editable;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setStart(int i) {
        this.mStart = i;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public void mI(int i) {
        this.mEnd = i;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        this.mIsValid = t.isValid();
        this.ehj = t.aYX();
        this.mStart = t.getStart();
        this.mEnd = t.getEnd();
        this.mFontSize = t.getFontSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Object obj, int i, int i2, int i3) {
        if (this.ehj != null) {
            this.ehj.setSpan(obj, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(@NonNull CharSequence charSequence) {
        if (this.ehj != null && charSequence != null) {
            try {
                this.ehj.replace(this.mStart, this.mEnd, charSequence);
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.mEnd = this.mStart + charSequence.length();
        }
    }
}
