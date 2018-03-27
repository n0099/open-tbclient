package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int bcB;
    private int bcC;
    private a bcD;

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
        En();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.bcB = d.f.icon_set_list_ok_s;
        this.bcC = d.f.icon_set_list_ok_n;
        Em();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcB = d.f.icon_set_list_ok_s;
        this.bcC = d.f.icon_set_list_ok_n;
        Em();
    }

    private void Em() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.Eo());
            }
        });
        En();
    }

    public void setStatedChangedListener(a aVar) {
        this.bcD = aVar;
    }

    public void En() {
        if (Eo()) {
            aj.c(this, this.bcB);
            setContentDescription(getResources().getString(d.j.check_box_checked));
            return;
        }
        aj.c(this, this.bcC);
        setContentDescription(getResources().getString(d.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Eo() {
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
        En();
        if (this.bcD != null) {
            this.bcD.a(this, z, getTag());
        }
    }
}
