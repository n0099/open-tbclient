package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a aIA;
    private int aIy;
    private int aIz;

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
        Fj();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.aIy = e.f.icon_set_list_ok_s;
        this.aIz = e.f.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIy = e.f.icon_set_list_ok_s;
        this.aIz = e.f.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.aIy = i;
        this.aIz = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.Fk());
            }
        });
        Fj();
    }

    public void setStatedChangedListener(a aVar) {
        this.aIA = aVar;
    }

    public void Fj() {
        if (Fk()) {
            al.c(this, this.aIy);
            setContentDescription(getResources().getString(e.j.check_box_checked));
            return;
        }
        al.c(this, this.aIz);
        setContentDescription(getResources().getString(e.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return Fk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fk() {
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
        Fj();
        if (this.aIA != null) {
            this.aIA.a(this, z, getTag());
        }
    }
}
