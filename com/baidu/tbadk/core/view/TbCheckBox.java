package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int ePH;
    private int ePI;
    private a ePJ;

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
        bqd();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.ePH = R.drawable.icon_set_list_ok_s;
        this.ePI = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ePH = R.drawable.icon_set_list_ok_s;
        this.ePI = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.ePH = i;
        this.ePI = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.bqe());
            }
        });
        bqd();
    }

    public void setStatedChangedListener(a aVar) {
        this.ePJ = aVar;
    }

    public void bqd() {
        if (bqe()) {
            ap.setImageResource(this, this.ePH);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        ap.setImageResource(this, this.ePI);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqe() {
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
        bqd();
        if (this.ePJ != null) {
            this.ePJ.a(this, z, getTag());
        }
    }
}
