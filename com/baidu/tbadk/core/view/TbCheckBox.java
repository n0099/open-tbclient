package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private ai NP;

    public void setTagData(aj ajVar) {
        setTag(ajVar);
        qF();
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
        qF();
    }

    public void setStatedChangedListener(ai aiVar) {
        this.NP = aiVar;
    }

    public void qF() {
        if (qG()) {
            bc.c(this, com.baidu.tieba.v.btn_friend_choose_s);
        } else {
            bc.c(this, com.baidu.tieba.v.btn_friend_choose_n);
        }
    }

    public boolean isChecked() {
        return qG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qG() {
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
        qF();
        if (this.NP != null) {
            this.NP.a(this, z, getTag());
        }
    }
}
