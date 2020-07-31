package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int eiY;
    private int eiZ;
    private a eja;

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
        bci();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.eiY = R.drawable.icon_set_list_ok_s;
        this.eiZ = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eiY = R.drawable.icon_set_list_ok_s;
        this.eiZ = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.eiY = i;
        this.eiZ = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.bcj());
            }
        });
        bci();
    }

    public void setStatedChangedListener(a aVar) {
        this.eja = aVar;
    }

    public void bci() {
        if (bcj()) {
            ao.setImageResource(this, this.eiY);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        ao.setImageResource(this, this.eiZ);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return bcj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bcj() {
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
        bci();
        if (this.eja != null) {
            this.eja.a(this, z, getTag());
        }
    }
}
