package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int ams;
    private int amt;
    private a amu;

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
        wB();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.ams = d.f.icon_set_list_ok_s;
        this.amt = d.f.icon_set_list_ok_n;
        wA();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ams = d.f.icon_set_list_ok_s;
        this.amt = d.f.icon_set_list_ok_n;
        wA();
    }

    public void E(int i, int i2) {
        this.ams = i;
        this.amt = i2;
    }

    private void wA() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.wC());
            }
        });
        wB();
    }

    public void setStatedChangedListener(a aVar) {
        this.amu = aVar;
    }

    public void wB() {
        if (wC()) {
            aj.c(this, this.ams);
            setContentDescription(getResources().getString(d.j.check_box_checked));
            return;
        }
        aj.c(this, this.amt);
        setContentDescription(getResources().getString(d.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return wC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wC() {
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
        wB();
        if (this.amu != null) {
            this.amu.a(this, z, getTag());
        }
    }
}
