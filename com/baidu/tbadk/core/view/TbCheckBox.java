package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int baM;
    private int baN;
    private a baO;

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
        Ea();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.baM = d.f.icon_set_list_ok_s;
        this.baN = d.f.icon_set_list_ok_n;
        DZ();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baM = d.f.icon_set_list_ok_s;
        this.baN = d.f.icon_set_list_ok_n;
        DZ();
    }

    private void DZ() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.Eb());
            }
        });
        Ea();
    }

    public void setStatedChangedListener(a aVar) {
        this.baO = aVar;
    }

    public void Ea() {
        if (Eb()) {
            aj.c(this, this.baM);
            setContentDescription(getResources().getString(d.j.check_box_checked));
            return;
        }
        aj.c(this, this.baN);
        setContentDescription(getResources().getString(d.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return Eb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Eb() {
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
        Ea();
        if (this.baO != null) {
            this.baO.a(this, z, getTag());
        }
    }
}
