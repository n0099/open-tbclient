package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a aeW;

    /* loaded from: classes.dex */
    public interface a {
        void handler(TbCheckBox tbCheckBox, boolean z, Object obj);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean isChecked();

        void setChecked(boolean z);
    }

    public void setTagData(b bVar) {
        setTag(bVar);
        vD();
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
        setOnClickListener(new w(this));
        vD();
    }

    public void setStatedChangedListener(a aVar) {
        this.aeW = aVar;
    }

    public void vD() {
        if (vE()) {
            al.c(this, i.e.icon_set_list_ok_s);
        } else {
            al.c(this, i.e.icon_set_list_ok_n);
        }
    }

    public boolean isChecked() {
        return vE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vE() {
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
        vD();
        if (this.aeW != null) {
            this.aeW.handler(this, z, getTag());
        }
    }
}
