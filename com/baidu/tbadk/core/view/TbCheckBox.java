package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int baT;
    private int baU;
    private a baV;

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
        DT();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.baT = d.f.icon_set_list_ok_s;
        this.baU = d.f.icon_set_list_ok_n;
        DS();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baT = d.f.icon_set_list_ok_s;
        this.baU = d.f.icon_set_list_ok_n;
        DS();
    }

    private void DS() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.DU());
            }
        });
        DT();
    }

    public void setStatedChangedListener(a aVar) {
        this.baV = aVar;
    }

    public void DT() {
        if (DU()) {
            aj.c(this, this.baT);
            setContentDescription(getResources().getString(d.j.check_box_checked));
            return;
        }
        aj.c(this, this.baU);
        setContentDescription(getResources().getString(d.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return DU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean DU() {
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
        DT();
        if (this.baV != null) {
            this.baV.a(this, z, getTag());
        }
    }
}
