package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int evb;
    private int evc;
    private a evd;

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
        blA();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.evb = R.drawable.icon_set_list_ok_s;
        this.evc = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evb = R.drawable.icon_set_list_ok_s;
        this.evc = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.evb = i;
        this.evc = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.blB());
            }
        });
        blA();
    }

    public void setStatedChangedListener(a aVar) {
        this.evd = aVar;
    }

    public void blA() {
        if (blB()) {
            ap.setImageResource(this, this.evb);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        ap.setImageResource(this, this.evc);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return blB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blB() {
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
        blA();
        if (this.evd != null) {
            this.evd.a(this, z, getTag());
        }
    }
}
