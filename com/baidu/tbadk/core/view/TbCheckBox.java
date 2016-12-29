package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a agr;

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
        wx();
    }

    public TbCheckBox(Context context) {
        super(context);
        ww();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ww();
    }

    private void ww() {
        setOnClickListener(new y(this));
        wx();
    }

    public void setStatedChangedListener(a aVar) {
        this.agr = aVar;
    }

    public void wx() {
        if (wy()) {
            com.baidu.tbadk.core.util.ar.c(this, r.f.icon_set_list_ok_s);
            setContentDescription(getResources().getString(r.j.check_box_checked));
            return;
        }
        com.baidu.tbadk.core.util.ar.c(this, r.f.icon_set_list_ok_n);
        setContentDescription(getResources().getString(r.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return wy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wy() {
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
        wx();
        if (this.agr != null) {
            this.agr.a(this, z, getTag());
        }
    }
}
