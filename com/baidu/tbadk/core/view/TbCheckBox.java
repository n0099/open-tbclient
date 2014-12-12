package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private ai Nw;

    public void setTagData(aj ajVar) {
        setTag(ajVar);
        qA();
    }

    public TbCheckBox(Context context) {
        super(context);
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize();
    }

    private void initialize() {
        setOnClickListener(new ah(this));
        qA();
    }

    public void setStatedChangedListener(ai aiVar) {
        this.Nw = aiVar;
    }

    public void qA() {
        if (qB()) {
            com.baidu.tbadk.core.util.ax.c(this, com.baidu.tieba.v.btn_friend_choose_s);
        } else {
            com.baidu.tbadk.core.util.ax.c(this, com.baidu.tieba.v.btn_friend_choose_n);
        }
    }

    public boolean isChecked() {
        return qB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qB() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof aj)) {
            return false;
        }
        return ((aj) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof aj)) {
            ((aj) tag).setChecked(z);
        }
        qA();
        if (this.Nw != null) {
            this.Nw.a(this, z, getTag());
        }
    }
}
