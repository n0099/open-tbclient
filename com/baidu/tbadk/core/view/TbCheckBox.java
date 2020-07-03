package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int ecO;
    private int ecP;
    private a ecQ;

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
        aYj();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.ecO = R.drawable.icon_set_list_ok_s;
        this.ecP = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ecO = R.drawable.icon_set_list_ok_s;
        this.ecP = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.ecO = i;
        this.ecP = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.aYk());
            }
        });
        aYj();
    }

    public void setStatedChangedListener(a aVar) {
        this.ecQ = aVar;
    }

    public void aYj() {
        if (aYk()) {
            an.setImageResource(this, this.ecO);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        an.setImageResource(this, this.ecP);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return aYk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYk() {
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
        aYj();
        if (this.ecQ != null) {
            this.ecQ.a(this, z, getTag());
        }
    }
}
