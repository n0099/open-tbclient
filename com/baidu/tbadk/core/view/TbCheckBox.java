package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int bRA;
    private int bRB;
    private a bRC;

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
        aeK();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.bRA = d.f.icon_set_list_ok_s;
        this.bRB = d.f.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRA = d.f.icon_set_list_ok_s;
        this.bRB = d.f.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.bRA = i;
        this.bRB = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.aeL());
            }
        });
        aeK();
    }

    public void setStatedChangedListener(a aVar) {
        this.bRC = aVar;
    }

    public void aeK() {
        if (aeL()) {
            al.c(this, this.bRA);
            setContentDescription(getResources().getString(d.j.check_box_checked));
            return;
        }
        al.c(this, this.bRB);
        setContentDescription(getResources().getString(d.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return aeL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aeL() {
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
        aeK();
        if (this.bRC != null) {
            this.bRC.a(this, z, getTag());
        }
    }
}
