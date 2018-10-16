package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int aEi;
    private int aEj;
    private a aEk;

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
        DV();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.aEi = e.f.icon_set_list_ok_s;
        this.aEj = e.f.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEi = e.f.icon_set_list_ok_s;
        this.aEj = e.f.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.aEi = i;
        this.aEj = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.DW());
            }
        });
        DV();
    }

    public void setStatedChangedListener(a aVar) {
        this.aEk = aVar;
    }

    public void DV() {
        if (DW()) {
            al.c(this, this.aEi);
            setContentDescription(getResources().getString(e.j.check_box_checked));
            return;
        }
        al.c(this, this.aEj);
        setContentDescription(getResources().getString(e.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return DW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean DW() {
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
        DV();
        if (this.aEk != null) {
            this.aEk.a(this, z, getTag());
        }
    }
}
