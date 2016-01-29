package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a agX;

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
        xf();
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
        xf();
    }

    public void setStatedChangedListener(a aVar) {
        this.agX = aVar;
    }

    public void xf() {
        if (xg()) {
            ar.c(this, t.f.icon_set_list_ok_s);
        } else {
            ar.c(this, t.f.icon_set_list_ok_n);
        }
    }

    public boolean isChecked() {
        return xg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xg() {
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
        xf();
        if (this.agX != null) {
            this.agX.a(this, z, getTag());
        }
    }
}
