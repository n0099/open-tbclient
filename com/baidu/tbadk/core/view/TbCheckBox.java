package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private o a;

    public void setTagData(p pVar) {
        setTag(pVar);
        c();
    }

    public TbCheckBox(Context context) {
        super(context);
        b();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void b() {
        setOnClickListener(new n(this));
        c();
    }

    public void setStatedChangedListener(o oVar) {
        this.a = oVar;
    }

    private void c() {
        if (TbadkApplication.j().l() == 1) {
            setImageResource(d() ? com.baidu.tbadk.i.btn_friend_choose_s_1 : com.baidu.tbadk.i.btn_friend_choose_n_1);
        } else {
            setImageResource(d() ? com.baidu.tbadk.i.btn_friend_choose_s : com.baidu.tbadk.i.btn_friend_choose_n);
        }
    }

    public final boolean a() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof p)) {
            return false;
        }
        return ((p) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof p)) {
            ((p) tag).setChecked(z);
        }
        c();
        if (this.a != null) {
            this.a.a(this, z, getTag());
        }
    }
}
