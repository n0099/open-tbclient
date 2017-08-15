package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a anI;

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
        xd();
    }

    public TbCheckBox(Context context) {
        super(context);
        bg();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bg();
    }

    private void bg() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.xe());
            }
        });
        xd();
    }

    public void setStatedChangedListener(a aVar) {
        this.anI = aVar;
    }

    public void xd() {
        if (xe()) {
            ai.c(this, d.g.icon_set_list_ok_s);
            setContentDescription(getResources().getString(d.l.check_box_checked));
            return;
        }
        ai.c(this, d.g.icon_set_list_ok_n);
        setContentDescription(getResources().getString(d.l.check_box_not_checked));
    }

    public boolean isChecked() {
        return xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xe() {
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
        xd();
        if (this.anI != null) {
            this.anI.a(this, z, getTag());
        }
    }
}
