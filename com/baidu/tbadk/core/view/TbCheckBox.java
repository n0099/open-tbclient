package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a alK;

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
        wK();
    }

    public TbCheckBox(Context context) {
        super(context);
        wJ();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        wJ();
    }

    private void wJ() {
        setOnClickListener(new ad(this));
        wK();
    }

    public void setStatedChangedListener(a aVar) {
        this.alK = aVar;
    }

    public void wK() {
        if (wL()) {
            com.baidu.tbadk.core.util.as.c(this, w.g.icon_set_list_ok_s);
            setContentDescription(getResources().getString(w.l.check_box_checked));
            return;
        }
        com.baidu.tbadk.core.util.as.c(this, w.g.icon_set_list_ok_n);
        setContentDescription(getResources().getString(w.l.check_box_not_checked));
    }

    public boolean isChecked() {
        return wL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wL() {
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
        wK();
        if (this.alK != null) {
            this.alK.a(this, z, getTag());
        }
    }
}
