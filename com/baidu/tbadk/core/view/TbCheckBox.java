package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private a agy;

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
        wH();
    }

    public TbCheckBox(Context context) {
        super(context);
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize();
    }

    private void initialize() {
        setOnClickListener(new x(this));
        wH();
    }

    public void setStatedChangedListener(a aVar) {
        this.agy = aVar;
    }

    public void wH() {
        if (wI()) {
            av.c(this, r.f.icon_set_list_ok_s);
            setContentDescription(getResources().getString(r.j.check_box_checked));
            return;
        }
        av.c(this, r.f.icon_set_list_ok_n);
        setContentDescription(getResources().getString(r.j.check_box_not_checked));
    }

    public boolean isChecked() {
        return wI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wI() {
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
        wH();
        if (this.agy != null) {
            this.agy.a(this, z, getTag());
        }
    }
}
