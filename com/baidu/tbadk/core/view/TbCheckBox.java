package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int dhe;
    private int dhf;
    private a dhg;

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
        aHS();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.dhe = R.drawable.icon_set_list_ok_s;
        this.dhf = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhe = R.drawable.icon_set_list_ok_s;
        this.dhf = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.dhe = i;
        this.dhf = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.aHT());
            }
        });
        aHS();
    }

    public void setStatedChangedListener(a aVar) {
        this.dhg = aVar;
    }

    public void aHS() {
        if (aHT()) {
            am.setImageResource(this, this.dhe);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        am.setImageResource(this, this.dhf);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return aHT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHT() {
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
        aHS();
        if (this.dhg != null) {
            this.dhg.a(this, z, getTag());
        }
    }
}
