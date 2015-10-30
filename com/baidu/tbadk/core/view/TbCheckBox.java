package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a aeu;

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
        vx();
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
        vx();
    }

    public void setStatedChangedListener(a aVar) {
        this.aeu = aVar;
    }

    public void vx() {
        if (vy()) {
            an.c(this, i.e.icon_set_list_ok_s);
        } else {
            an.c(this, i.e.icon_set_list_ok_n);
        }
    }

    public boolean isChecked() {
        return vy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vy() {
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
        vx();
        if (this.aeu != null) {
            this.aeu.handler(this, z, getTag());
        }
    }
}
