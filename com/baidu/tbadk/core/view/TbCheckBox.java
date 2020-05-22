package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int dVp;
    private int dVq;
    private a dVr;

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
        aWq();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.dVp = R.drawable.icon_set_list_ok_s;
        this.dVq = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVp = R.drawable.icon_set_list_ok_s;
        this.dVq = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.dVp = i;
        this.dVq = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.aWr());
            }
        });
        aWq();
    }

    public void setStatedChangedListener(a aVar) {
        this.dVr = aVar;
    }

    public void aWq() {
        if (aWr()) {
            am.setImageResource(this, this.dVp);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        am.setImageResource(this, this.dVq);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return aWr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWr() {
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
        aWq();
        if (this.dVr != null) {
            this.dVr.a(this, z, getTag());
        }
    }
}
