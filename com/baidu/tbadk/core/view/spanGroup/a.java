package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Editable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.spanGroup.a;
/* loaded from: classes.dex */
public abstract class a<T extends a> {
    private static int fgD = 1;
    protected Editable fgE;
    private InterfaceC0594a fgF;
    private int mEnd;
    private int mFontSize;
    private final int mId;
    private boolean mIsValid;
    private int mStart;

    /* renamed from: com.baidu.tbadk.core.view.spanGroup.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0594a {
        void G(int i, boolean z);
    }

    public abstract void a(Editable editable);

    public abstract void a(Editable editable, int i);

    public a() {
        int i = fgD;
        fgD = i + 1;
        this.mId = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.fgE = editable;
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
        if (z2 != z && this.fgF != null) {
            this.fgF.G(this.mId, z);
        }
    }

    public Editable bwf() {
        return this.fgE;
    }

    public void b(Editable editable) {
        this.fgE = editable;
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

    public void rm(int i) {
        this.mEnd = i;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        this.mIsValid = t.isValid();
        this.fgE = t.bwf();
        this.mStart = t.getStart();
        this.mEnd = t.getEnd();
        this.mFontSize = t.getFontSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Object obj, int i, int i2, int i3) {
        if (this.fgE != null) {
            this.fgE.setSpan(obj, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(@NonNull CharSequence charSequence) {
        if (this.fgE != null && charSequence != null) {
            try {
                this.fgE.replace(this.mStart, this.mEnd, charSequence);
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.mEnd = this.mStart + charSequence.length();
        }
    }

    public void a(InterfaceC0594a interfaceC0594a) {
        this.fgF = interfaceC0594a;
    }
}
