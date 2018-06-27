package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int awK;
    private int awL;
    private a awM;

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
        AP();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.awK = d.f.icon_set_list_ok_s;
        this.awL = d.f.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awK = d.f.icon_set_list_ok_s;
        this.awL = d.f.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.awK = i;
        this.awL = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.AQ());
            }
        });
        AP();
    }

    public void setStatedChangedListener(a aVar) {
        this.awM = aVar;
    }

    public void AP() {
        if (AQ()) {
            am.c(this, this.awK);
            setContentDescription(getResources().getString(d.k.check_box_checked));
            return;
        }
        am.c(this, this.awL);
        setContentDescription(getResources().getString(d.k.check_box_not_checked));
    }

    public boolean isChecked() {
        return AQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AQ() {
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
        AP();
        if (this.awM != null) {
            this.awM.a(this, z, getTag());
        }
    }
}
