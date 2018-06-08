package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int awb;
    private int awc;
    private a awd;

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
        Ay();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.awb = d.f.icon_set_list_ok_s;
        this.awc = d.f.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awb = d.f.icon_set_list_ok_s;
        this.awc = d.f.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.awb = i;
        this.awc = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.Az());
            }
        });
        Ay();
    }

    public void setStatedChangedListener(a aVar) {
        this.awd = aVar;
    }

    public void Ay() {
        if (Az()) {
            al.c(this, this.awb);
            setContentDescription(getResources().getString(d.k.check_box_checked));
            return;
        }
        al.c(this, this.awc);
        setContentDescription(getResources().getString(d.k.check_box_not_checked));
    }

    public boolean isChecked() {
        return Az();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Az() {
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
        Ay();
        if (this.awd != null) {
            this.awd.a(this, z, getTag());
        }
    }
}
