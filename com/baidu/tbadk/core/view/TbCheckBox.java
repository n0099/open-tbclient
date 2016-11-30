package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a agY;

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
        wM();
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
        setOnClickListener(new y(this));
        wM();
    }

    public void setStatedChangedListener(a aVar) {
        this.agY = aVar;
    }

    public void wM() {
        if (wN()) {
            at.c(this, r.f.icon_set_list_ok_s);
            setContentDescription(getResources().getString(r.j.check_box_checked));
            return;
        }
        at.c(this, r.f.icon_set_list_ok_n);
        setContentDescription(getResources().getString(r.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return wN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wN() {
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
        wM();
        if (this.agY != null) {
            this.agY.a(this, z, getTag());
        }
    }
}
