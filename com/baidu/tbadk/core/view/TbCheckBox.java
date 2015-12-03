package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a afw;

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
        wh();
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
        setOnClickListener(new p(this));
        wh();
    }

    public void setStatedChangedListener(a aVar) {
        this.afw = aVar;
    }

    public void wh() {
        if (wi()) {
            as.c(this, n.e.icon_set_list_ok_s);
        } else {
            as.c(this, n.e.icon_set_list_ok_n);
        }
    }

    public boolean isChecked() {
        return wi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wi() {
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
        wh();
        if (this.afw != null) {
            this.afw.handler(this, z, getTag());
        }
    }
}
