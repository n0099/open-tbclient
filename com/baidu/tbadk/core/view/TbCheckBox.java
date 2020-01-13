package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a dcA;
    private int dcy;
    private int dcz;

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
        aFw();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.dcy = R.drawable.icon_set_list_ok_s;
        this.dcz = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dcy = R.drawable.icon_set_list_ok_s;
        this.dcz = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.dcy = i;
        this.dcz = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.aFx());
            }
        });
        aFw();
    }

    public void setStatedChangedListener(a aVar) {
        this.dcA = aVar;
    }

    public void aFw() {
        if (aFx()) {
            am.setImageResource(this, this.dcy);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        am.setImageResource(this, this.dcz);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return aFx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFx() {
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
        aFw();
        if (this.dcA != null) {
            this.dcA.a(this, z, getTag());
        }
    }
}
