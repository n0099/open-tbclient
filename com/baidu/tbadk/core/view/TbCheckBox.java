package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int aJb;
    private int aJc;
    private a aJd;

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
        Fw();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.aJb = e.f.icon_set_list_ok_s;
        this.aJc = e.f.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJb = e.f.icon_set_list_ok_s;
        this.aJc = e.f.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.aJb = i;
        this.aJc = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.Fx());
            }
        });
        Fw();
    }

    public void setStatedChangedListener(a aVar) {
        this.aJd = aVar;
    }

    public void Fw() {
        if (Fx()) {
            al.c(this, this.aJb);
            setContentDescription(getResources().getString(e.j.check_box_checked));
            return;
        }
        al.c(this, this.aJc);
        setContentDescription(getResources().getString(e.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return Fx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fx() {
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
        Fw();
        if (this.aJd != null) {
            this.aJd.a(this, z, getTag());
        }
    }
}
