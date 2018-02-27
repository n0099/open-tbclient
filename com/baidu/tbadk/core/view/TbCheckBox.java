package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int bcA;
    private a bcB;
    private int bcz;

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
        Em();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.bcz = d.f.icon_set_list_ok_s;
        this.bcA = d.f.icon_set_list_ok_n;
        El();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcz = d.f.icon_set_list_ok_s;
        this.bcA = d.f.icon_set_list_ok_n;
        El();
    }

    private void El() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.En());
            }
        });
        Em();
    }

    public void setStatedChangedListener(a aVar) {
        this.bcB = aVar;
    }

    public void Em() {
        if (En()) {
            aj.c(this, this.bcz);
            setContentDescription(getResources().getString(d.j.check_box_checked));
            return;
        }
        aj.c(this, this.bcA);
        setContentDescription(getResources().getString(d.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return En();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean En() {
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
        Em();
        if (this.bcB != null) {
            this.bcB.a(this, z, getTag());
        }
    }
}
