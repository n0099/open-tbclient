package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.spanGroup.a;
/* loaded from: classes.dex */
public abstract class a<T extends a> {
    private static int fpv = 1;
    protected Editable fpw;
    private InterfaceC0571a fpx;
    private int mEnd;
    private int mFontSize;
    private final int mId;
    private boolean mIsValid;
    private int mStart;

    /* renamed from: com.baidu.tbadk.core.view.spanGroup.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0571a {
        void G(int i, boolean z);
    }

    public abstract void a(Editable editable, int i);

    public abstract void b(Editable editable);

    public a() {
        int i = fpv;
        fpv = i + 1;
        this.mId = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.fpw = editable;
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
        if (z2 != z && this.fpx != null) {
            this.fpx.G(this.mId, z);
        }
    }

    public Editable getText() {
        return this.fpw;
    }

    public void c(Editable editable) {
        this.fpw = editable;
    }

    public int getStart() {
        return this.mStart;
    }

    public void pX(int i) {
        this.mStart = i;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public void pY(int i) {
        this.mEnd = i;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        this.mIsValid = t.isValid();
        this.fpw = t.getText();
        this.mStart = t.getStart();
        this.mEnd = t.getEnd();
        this.mFontSize = t.getFontSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (this.fpw != null) {
            this.fpw.setSpan(obj, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@NonNull CharSequence charSequence) {
        if (this.fpw != null && charSequence != null) {
            try {
                this.fpw.replace(this.mStart, this.mEnd, charSequence);
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.mEnd = this.mStart + charSequence.length();
        }
    }

    public void a(InterfaceC0571a interfaceC0571a) {
        this.fpx = interfaceC0571a;
    }
}
