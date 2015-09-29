package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a aet;

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
        vA();
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
        setOnClickListener(new o(this));
        vA();
    }

    public void setStatedChangedListener(a aVar) {
        this.aet = aVar;
    }

    public void vA() {
        if (vB()) {
            am.c(this, i.e.icon_set_list_ok_s);
        } else {
            am.c(this, i.e.icon_set_list_ok_n);
        }
    }

    public boolean isChecked() {
        return vB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vB() {
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
        vA();
        if (this.aet != null) {
            this.aet.handler(this, z, getTag());
        }
    }
}
