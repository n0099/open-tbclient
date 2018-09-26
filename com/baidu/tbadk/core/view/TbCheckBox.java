package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int azA;
    private int azB;
    private a azC;

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
        BQ();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.azA = e.f.icon_set_list_ok_s;
        this.azB = e.f.icon_set_list_ok_n;
        BP();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azA = e.f.icon_set_list_ok_s;
        this.azB = e.f.icon_set_list_ok_n;
        BP();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.azA = i;
        this.azB = i2;
    }

    private void BP() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.BR());
            }
        });
        BQ();
    }

    public void setStatedChangedListener(a aVar) {
        this.azC = aVar;
    }

    public void BQ() {
        if (BR()) {
            al.c(this, this.azA);
            setContentDescription(getResources().getString(e.j.check_box_checked));
            return;
        }
        al.c(this, this.azB);
        setContentDescription(getResources().getString(e.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return BR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BR() {
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
        BQ();
        if (this.azC != null) {
            this.azC.a(this, z, getTag());
        }
    }
}
