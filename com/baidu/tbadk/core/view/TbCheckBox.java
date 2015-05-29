package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private af ZV;

    public void setTagData(ag agVar) {
        setTag(agVar);
        uy();
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
        setOnClickListener(new ae(this));
        uy();
    }

    public void setStatedChangedListener(af afVar) {
        this.ZV = afVar;
    }

    public void uy() {
        if (uz()) {
            com.baidu.tbadk.core.util.ay.c(this, com.baidu.tieba.p.icon_set_list_ok_s);
        } else {
            com.baidu.tbadk.core.util.ay.c(this, com.baidu.tieba.p.icon_set_list_ok_n);
        }
    }

    public boolean isChecked() {
        return uz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uz() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof ag)) {
            return false;
        }
        return ((ag) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof ag)) {
            ((ag) tag).setChecked(z);
        }
        uy();
        if (this.ZV != null) {
            this.ZV.handler(this, z, getTag());
        }
    }
}
