package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private ai NS;

    public void setTagData(aj ajVar) {
        setTag(ajVar);
        qL();
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
        qL();
    }

    public void setStatedChangedListener(ai aiVar) {
        this.NS = aiVar;
    }

    public void qL() {
        if (qM()) {
            bc.c(this, com.baidu.tieba.v.btn_friend_choose_s);
        } else {
            bc.c(this, com.baidu.tieba.v.btn_friend_choose_n);
        }
    }

    public boolean isChecked() {
        return qM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qM() {
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
        qL();
        if (this.NS != null) {
            this.NS.a(this, z, getTag());
        }
    }
}
