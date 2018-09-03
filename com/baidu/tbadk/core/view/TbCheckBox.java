package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int awn;
    private int awo;
    private a awp;

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
        AD();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.awn = f.C0146f.icon_set_list_ok_s;
        this.awo = f.C0146f.icon_set_list_ok_n;
        AC();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awn = f.C0146f.icon_set_list_ok_s;
        this.awo = f.C0146f.icon_set_list_ok_n;
        AC();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.awn = i;
        this.awo = i2;
    }

    private void AC() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.AE());
            }
        });
        AD();
    }

    public void setStatedChangedListener(a aVar) {
        this.awp = aVar;
    }

    public void AD() {
        if (AE()) {
            am.c(this, this.awn);
            setContentDescription(getResources().getString(f.j.check_box_checked));
            return;
        }
        am.c(this, this.awo);
        setContentDescription(getResources().getString(f.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return AE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AE() {
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
        AD();
        if (this.awp != null) {
            this.awp.a(this, z, getTag());
        }
    }
}
