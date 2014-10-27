package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private w Is;

    public void setTagData(x xVar) {
        setTag(xVar);
        nz();
    }

    public TbCheckBox(Context context) {
        super(context);
        ny();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ny();
    }

    private void ny() {
        setOnClickListener(new v(this));
        nz();
    }

    public void setStatedChangedListener(w wVar) {
        this.Is = wVar;
    }

    public void nz() {
        if (nA()) {
            aw.c(this, com.baidu.tieba.u.btn_friend_choose_s);
        } else {
            aw.c(this, com.baidu.tieba.u.btn_friend_choose_n);
        }
    }

    public boolean isChecked() {
        return nA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nA() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof x)) {
            return false;
        }
        return ((x) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof x)) {
            ((x) tag).setChecked(z);
        }
        nz();
        if (this.Is != null) {
            this.Is.a(this, z, getTag());
        }
    }
}
