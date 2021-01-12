package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.spanGroup.a;
/* loaded from: classes.dex */
public abstract class a<T extends a> {
    private static int flC = 1;
    protected Editable flD;
    private InterfaceC0568a flE;
    private int mEnd;
    private int mFontSize;
    private final int mId;
    private boolean mIsValid;
    private int mStart;

    /* renamed from: com.baidu.tbadk.core.view.spanGroup.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0568a {
        void G(int i, boolean z);
    }

    public abstract void a(Editable editable, int i);

    public abstract void b(Editable editable);

    public a() {
        int i = flC;
        flC = i + 1;
        this.mId = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.flD = editable;
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
        if (z2 != z && this.flE != null) {
            this.flE.G(this.mId, z);
        }
    }

    public Editable getText() {
        return this.flD;
    }

    public void c(Editable editable) {
        this.flD = editable;
    }

    public int getStart() {
        return this.mStart;
    }

    public void pR(int i) {
        this.mStart = i;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public void pS(int i) {
        this.mEnd = i;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        this.mIsValid = t.isValid();
        this.flD = t.getText();
        this.mStart = t.getStart();
        this.mEnd = t.getEnd();
        this.mFontSize = t.getFontSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (this.flD != null) {
            this.flD.setSpan(obj, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(@NonNull CharSequence charSequence) {
        if (this.flD != null && charSequence != null) {
            try {
                this.flD.replace(this.mStart, this.mEnd, charSequence);
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.mEnd = this.mStart + charSequence.length();
        }
    }

    public void a(InterfaceC0568a interfaceC0568a) {
        this.flE = interfaceC0568a;
    }
}
