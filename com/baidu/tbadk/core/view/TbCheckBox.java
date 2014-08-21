package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private t a;

    public void setTagData(u uVar) {
        setTag(uVar);
        a();
    }

    public TbCheckBox(Context context) {
        super(context);
        c();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        setOnClickListener(new s(this));
        a();
    }

    public void setStatedChangedListener(t tVar) {
        this.a = tVar;
    }

    public void a() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            setImageResource(d() ? com.baidu.tieba.t.btn_friend_choose_s_1 : com.baidu.tieba.t.btn_friend_choose_n_1);
        } else {
            setImageResource(d() ? com.baidu.tieba.t.btn_friend_choose_s : com.baidu.tieba.t.btn_friend_choose_n);
        }
    }

    public boolean b() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof u)) {
            return false;
        }
        return ((u) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof u)) {
            ((u) tag).setChecked(z);
        }
        a();
        if (this.a != null) {
            this.a.a(this, z, getTag());
        }
    }
}
