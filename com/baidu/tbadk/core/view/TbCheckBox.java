package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int cbw;
    private int cbx;
    private a cby;

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
        akZ();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.cbw = R.drawable.icon_set_list_ok_s;
        this.cbx = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbw = R.drawable.icon_set_list_ok_s;
        this.cbx = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.cbw = i;
        this.cbx = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.ala());
            }
        });
        akZ();
    }

    public void setStatedChangedListener(a aVar) {
        this.cby = aVar;
    }

    public void akZ() {
        if (ala()) {
            am.c(this, this.cbw);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        am.c(this, this.cbx);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return ala();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ala() {
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
        akZ();
        if (this.cby != null) {
            this.cby.a(this, z, getTag());
        }
    }
}
