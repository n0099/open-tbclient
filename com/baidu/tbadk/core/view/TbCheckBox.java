package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int anT;
    private int anU;
    private a anV;

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
        wX();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.anT = d.f.icon_set_list_ok_s;
        this.anU = d.f.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anT = d.f.icon_set_list_ok_s;
        this.anU = d.f.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.anT = i;
        this.anU = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.wY());
            }
        });
        wX();
    }

    public void setStatedChangedListener(a aVar) {
        this.anV = aVar;
    }

    public void wX() {
        if (wY()) {
            ak.c(this, this.anT);
            setContentDescription(getResources().getString(d.k.check_box_checked));
            return;
        }
        ak.c(this, this.anU);
        setContentDescription(getResources().getString(d.k.check_box_not_checked));
    }

    public boolean isChecked() {
        return wY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wY() {
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
        wX();
        if (this.anV != null) {
            this.anV.a(this, z, getTag());
        }
    }
}
