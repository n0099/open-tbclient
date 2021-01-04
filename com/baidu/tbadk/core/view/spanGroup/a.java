package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.spanGroup.a;
/* loaded from: classes.dex */
public abstract class a<T extends a> {
    private static int fqm = 1;
    protected Editable fqn;
    private InterfaceC0585a fqo;
    private int mEnd;
    private int mFontSize;
    private final int mId;
    private boolean mIsValid;
    private int mStart;

    /* renamed from: com.baidu.tbadk.core.view.spanGroup.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0585a {
        void G(int i, boolean z);
    }

    public abstract void a(Editable editable, int i);

    public abstract void b(Editable editable);

    public a() {
        int i = fqm;
        fqm = i + 1;
        this.mId = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.fqn = editable;
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
        if (z2 != z && this.fqo != null) {
            this.fqo.G(this.mId, z);
        }
    }

    public Editable getText() {
        return this.fqn;
    }

    public void c(Editable editable) {
        this.fqn = editable;
    }

    public int getStart() {
        return this.mStart;
    }

    public void rx(int i) {
        this.mStart = i;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public void ry(int i) {
        this.mEnd = i;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        this.mIsValid = t.isValid();
        this.fqn = t.getText();
        this.mStart = t.getStart();
        this.mEnd = t.getEnd();
        this.mFontSize = t.getFontSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (this.fqn != null) {
            this.fqn.setSpan(obj, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(@NonNull CharSequence charSequence) {
        if (this.fqn != null && charSequence != null) {
            try {
                this.fqn.replace(this.mStart, this.mEnd, charSequence);
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.mEnd = this.mStart + charSequence.length();
        }
    }

    public void a(InterfaceC0585a interfaceC0585a) {
        this.fqo = interfaceC0585a;
    }
}
