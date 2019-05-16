package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int bZu;
    private int bZv;
    private a bZw;

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
        ajG();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.bZu = R.drawable.icon_set_list_ok_s;
        this.bZv = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZu = R.drawable.icon_set_list_ok_s;
        this.bZv = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.bZu = i;
        this.bZv = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.ajH());
            }
        });
        ajG();
    }

    public void setStatedChangedListener(a aVar) {
        this.bZw = aVar;
    }

    public void ajG() {
        if (ajH()) {
            al.c(this, this.bZu);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        al.c(this, this.bZv);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return ajH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajH() {
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
        ajG();
        if (this.bZw != null) {
            this.bZw.a(this, z, getTag());
        }
    }
}
