package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int awq;
    private int awr;
    private a aws;

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
        AG();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.awq = d.f.icon_set_list_ok_s;
        this.awr = d.f.icon_set_list_ok_n;
        AF();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awq = d.f.icon_set_list_ok_s;
        this.awr = d.f.icon_set_list_ok_n;
        AF();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.awq = i;
        this.awr = i2;
    }

    private void AF() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.AH());
            }
        });
        AG();
    }

    public void setStatedChangedListener(a aVar) {
        this.aws = aVar;
    }

    public void AG() {
        if (AH()) {
            am.c(this, this.awq);
            setContentDescription(getResources().getString(d.j.check_box_checked));
            return;
        }
        am.c(this, this.awr);
        setContentDescription(getResources().getString(d.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return AH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AH() {
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
        AG();
        if (this.aws != null) {
            this.aws.a(this, z, getTag());
        }
    }
}
