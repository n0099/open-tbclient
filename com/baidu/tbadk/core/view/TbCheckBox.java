package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a afD;

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
        ws();
    }

    public TbCheckBox(Context context) {
        super(context);
        wr();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        wr();
    }

    private void wr() {
        setOnClickListener(new z(this));
        ws();
    }

    public void setStatedChangedListener(a aVar) {
        this.afD = aVar;
    }

    public void ws() {
        if (wt()) {
            com.baidu.tbadk.core.util.ap.c(this, r.g.icon_set_list_ok_s);
            setContentDescription(getResources().getString(r.l.check_box_checked));
            return;
        }
        com.baidu.tbadk.core.util.ap.c(this, r.g.icon_set_list_ok_n);
        setContentDescription(getResources().getString(r.l.check_box_not_checked));
    }

    public boolean isChecked() {
        return wt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wt() {
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
        ws();
        if (this.afD != null) {
            this.afD.a(this, z, getTag());
        }
    }
}
