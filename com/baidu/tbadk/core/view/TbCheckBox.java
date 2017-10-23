package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int alW;
    private int alX;
    private a alY;

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
        wu();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.alW = d.g.icon_set_list_ok_s;
        this.alX = d.g.icon_set_list_ok_n;
        wt();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alW = d.g.icon_set_list_ok_s;
        this.alX = d.g.icon_set_list_ok_n;
        wt();
    }

    public void E(int i, int i2) {
        this.alW = i;
        this.alX = i2;
    }

    private void wt() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.wv());
            }
        });
        wu();
    }

    public void setStatedChangedListener(a aVar) {
        this.alY = aVar;
    }

    public void wu() {
        if (wv()) {
            aj.c(this, this.alW);
            setContentDescription(getResources().getString(d.l.check_box_checked));
            return;
        }
        aj.c(this, this.alX);
        setContentDescription(getResources().getString(d.l.check_box_not_checked));
    }

    public boolean isChecked() {
        return wv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wv() {
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
        wu();
        if (this.alY != null) {
            this.alY.a(this, z, getTag());
        }
    }
}
