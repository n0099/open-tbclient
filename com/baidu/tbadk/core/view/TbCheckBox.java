package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int cax;
    private int cay;
    private a caz;

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
        akL();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.cax = R.drawable.icon_set_list_ok_s;
        this.cay = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cax = R.drawable.icon_set_list_ok_s;
        this.cay = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.cax = i;
        this.cay = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.akM());
            }
        });
        akL();
    }

    public void setStatedChangedListener(a aVar) {
        this.caz = aVar;
    }

    public void akL() {
        if (akM()) {
            am.c(this, this.cax);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        am.c(this, this.cay);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akM() {
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
        akL();
        if (this.caz != null) {
            this.caz.a(this, z, getTag());
        }
    }
}
