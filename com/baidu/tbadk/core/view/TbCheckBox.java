package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a agj;

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
        vR();
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
        setOnClickListener(new q(this));
        vR();
    }

    public void setStatedChangedListener(a aVar) {
        this.agj = aVar;
    }

    public void vR() {
        if (vS()) {
            as.c(this, n.f.icon_set_list_ok_s);
        } else {
            as.c(this, n.f.icon_set_list_ok_n);
        }
    }

    public boolean isChecked() {
        return vS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vS() {
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
        vR();
        if (this.agj != null) {
            this.agj.handler(this, z, getTag());
        }
    }
}
