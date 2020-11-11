package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Editable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.spanGroup.a;
/* loaded from: classes.dex */
public abstract class a<T extends a> {
    private static int eZY = 1;
    protected Editable eZZ;
    private InterfaceC0582a faa;
    private int mEnd;
    private int mFontSize;
    private final int mId;
    private boolean mIsValid;
    private int mStart;

    /* renamed from: com.baidu.tbadk.core.view.spanGroup.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0582a {
        void G(int i, boolean z);
    }

    public abstract void a(Editable editable);

    public abstract void a(Editable editable, int i);

    public a() {
        int i = eZY;
        eZY = i + 1;
        this.mId = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.eZZ = editable;
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
        if (z2 != z && this.faa != null) {
            this.faa.G(this.mId, z);
        }
    }

    public Editable btp() {
        return this.eZZ;
    }

    public void b(Editable editable) {
        this.eZZ = editable;
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

    public void qn(int i) {
        this.mEnd = i;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        this.mIsValid = t.isValid();
        this.eZZ = t.btp();
        this.mStart = t.getStart();
        this.mEnd = t.getEnd();
        this.mFontSize = t.getFontSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Object obj, int i, int i2, int i3) {
        if (this.eZZ != null) {
            this.eZZ.setSpan(obj, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@NonNull CharSequence charSequence) {
        if (this.eZZ != null && charSequence != null) {
            try {
                this.eZZ.replace(this.mStart, this.mEnd, charSequence);
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.mEnd = this.mStart + charSequence.length();
        }
    }

    public void a(InterfaceC0582a interfaceC0582a) {
        this.faa = interfaceC0582a;
    }
}
