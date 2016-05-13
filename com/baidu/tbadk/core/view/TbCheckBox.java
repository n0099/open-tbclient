package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a ace;

    /* loaded from: classes.dex */
    public interface a {
        void a(TbCheckBox tbCheckBox, boolean z, Object obj);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean isChecked();

        void setChecked(boolean z);
    }

    public void setTagData(b bVar) {
        setTag(bVar);
        vm();
    }

    public TbCheckBox(Context context) {
        super(context);
        vl();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        vl();
    }

    private void vl() {
        setOnClickListener(new s(this));
        vm();
    }

    public void setStatedChangedListener(a aVar) {
        this.ace = aVar;
    }

    public void vm() {
        if (vn()) {
            com.baidu.tbadk.core.util.at.c(this, t.f.icon_set_list_ok_s);
            setContentDescription(getResources().getString(t.j.check_box_checked));
            return;
        }
        com.baidu.tbadk.core.util.at.c(this, t.f.icon_set_list_ok_n);
        setContentDescription(getResources().getString(t.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return vn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vn() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof b)) {
            return false;
        }
        return ((b) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof b)) {
            ((b) tag).setChecked(z);
        }
        vm();
        if (this.ace != null) {
            this.ace.a(this, z, getTag());
        }
    }
}
