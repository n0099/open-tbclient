package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a alj;

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
        xl();
    }

    public TbCheckBox(Context context) {
        super(context);
        xk();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        xk();
    }

    private void xk() {
        setOnClickListener(new aa(this));
        xl();
    }

    public void setStatedChangedListener(a aVar) {
        this.alj = aVar;
    }

    public void xl() {
        if (xm()) {
            com.baidu.tbadk.core.util.aq.c(this, w.g.icon_set_list_ok_s);
            setContentDescription(getResources().getString(w.l.check_box_checked));
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this, w.g.icon_set_list_ok_n);
        setContentDescription(getResources().getString(w.l.check_box_not_checked));
    }

    public boolean isChecked() {
        return xm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xm() {
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
        xl();
        if (this.alj != null) {
            this.alj.a(this, z, getTag());
        }
    }
}
