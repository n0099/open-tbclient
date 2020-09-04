package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int esW;
    private int esX;
    private a esY;

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
        bkF();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.esW = R.drawable.icon_set_list_ok_s;
        this.esX = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.esW = R.drawable.icon_set_list_ok_s;
        this.esX = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.esW = i;
        this.esX = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.bkG());
            }
        });
        bkF();
    }

    public void setStatedChangedListener(a aVar) {
        this.esY = aVar;
    }

    public void bkF() {
        if (bkG()) {
            ap.setImageResource(this, this.esW);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        ap.setImageResource(this, this.esX);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return bkG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkG() {
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
        bkF();
        if (this.esY != null) {
            this.esY.a(this, z, getTag());
        }
    }
}
