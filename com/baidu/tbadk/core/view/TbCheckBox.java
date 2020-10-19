package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int eHl;
    private int eHm;
    private a eHn;

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
        bok();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.eHl = R.drawable.icon_set_list_ok_s;
        this.eHm = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHl = R.drawable.icon_set_list_ok_s;
        this.eHm = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.eHl = i;
        this.eHm = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.bol());
            }
        });
        bok();
    }

    public void setStatedChangedListener(a aVar) {
        this.eHn = aVar;
    }

    public void bok() {
        if (bol()) {
            ap.setImageResource(this, this.eHl);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        ap.setImageResource(this, this.eHm);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return bol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bol() {
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
        bok();
        if (this.eHn != null) {
            this.eHn.a(this, z, getTag());
        }
    }
}
