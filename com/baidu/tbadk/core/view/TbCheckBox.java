package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int amK;
    private int amL;
    private a amM;

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
        wC();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.amK = d.f.icon_set_list_ok_s;
        this.amL = d.f.icon_set_list_ok_n;
        wB();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amK = d.f.icon_set_list_ok_s;
        this.amL = d.f.icon_set_list_ok_n;
        wB();
    }

    private void wB() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.wD());
            }
        });
        wC();
    }

    public void setStatedChangedListener(a aVar) {
        this.amM = aVar;
    }

    public void wC() {
        if (wD()) {
            aj.c(this, this.amK);
            setContentDescription(getResources().getString(d.j.check_box_checked));
            return;
        }
        aj.c(this, this.amL);
        setContentDescription(getResources().getString(d.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return wD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wD() {
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
        wC();
        if (this.amM != null) {
            this.amM.a(this, z, getTag());
        }
    }
}
