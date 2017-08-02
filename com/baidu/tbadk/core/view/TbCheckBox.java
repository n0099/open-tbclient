package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a amo;

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
        wV();
    }

    public TbCheckBox(Context context) {
        super(context);
        wU();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        wU();
    }

    private void wU() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.wW());
            }
        });
        wV();
    }

    public void setStatedChangedListener(a aVar) {
        this.amo = aVar;
    }

    public void wV() {
        if (wW()) {
            ai.c(this, d.g.icon_set_list_ok_s);
            setContentDescription(getResources().getString(d.l.check_box_checked));
            return;
        }
        ai.c(this, d.g.icon_set_list_ok_n);
        setContentDescription(getResources().getString(d.l.check_box_not_checked));
    }

    public boolean isChecked() {
        return wW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wW() {
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
        wV();
        if (this.amo != null) {
            this.amo.a(this, z, getTag());
        }
    }
}
