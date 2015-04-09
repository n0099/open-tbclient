package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private aa YU;

    public void setTagData(ab abVar) {
        setTag(abVar);
        tP();
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
        setOnClickListener(new z(this));
        tP();
    }

    public void setStatedChangedListener(aa aaVar) {
        this.YU = aaVar;
    }

    public void tP() {
        if (tQ()) {
            ba.c(this, com.baidu.tieba.u.icon_set_list_ok_s);
        } else {
            ba.c(this, com.baidu.tieba.u.icon_set_list_ok_n);
        }
    }

    public boolean isChecked() {
        return tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tQ() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof ab)) {
            return false;
        }
        return ((ab) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof ab)) {
            ((ab) tag).setChecked(z);
        }
        tP();
        if (this.YU != null) {
            this.YU.a(this, z, getTag());
        }
    }
}
