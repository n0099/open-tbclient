package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a anc;

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
        xc();
    }

    public TbCheckBox(Context context) {
        super(context);
        xb();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        xb();
    }

    private void xb() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.xd());
            }
        });
        xc();
    }

    public void setStatedChangedListener(a aVar) {
        this.anc = aVar;
    }

    public void xc() {
        if (xd()) {
            aj.c(this, d.g.icon_set_list_ok_s);
            setContentDescription(getResources().getString(d.l.check_box_checked));
            return;
        }
        aj.c(this, d.g.icon_set_list_ok_n);
        setContentDescription(getResources().getString(d.l.check_box_not_checked));
    }

    public boolean isChecked() {
        return xd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xd() {
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
        xc();
        if (this.anc != null) {
            this.anc.a(this, z, getTag());
        }
    }
}
