package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int dGZ;
    private int dHa;
    private a dHb;

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
        aQp();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.dGZ = R.drawable.icon_set_list_ok_s;
        this.dHa = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGZ = R.drawable.icon_set_list_ok_s;
        this.dHa = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.dGZ = i;
        this.dHa = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.aQq());
            }
        });
        aQp();
    }

    public void setStatedChangedListener(a aVar) {
        this.dHb = aVar;
    }

    public void aQp() {
        if (aQq()) {
            am.setImageResource(this, this.dGZ);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        am.setImageResource(this, this.dHa);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return aQq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQq() {
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
        aQp();
        if (this.dHb != null) {
            this.dHb.a(this, z, getTag());
        }
    }
}
