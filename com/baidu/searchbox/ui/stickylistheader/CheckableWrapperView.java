package com.baidu.searchbox.ui.stickylistheader;

import android.content.Context;
import android.widget.Checkable;
/* loaded from: classes4.dex */
public class CheckableWrapperView extends WrapperView implements Checkable {
    public CheckableWrapperView(Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        ((Checkable) this.mItem).setChecked(z);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return ((Checkable) this.mItem).isChecked();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
