package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class TbCheckBox extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f13482e;

    /* renamed from: f  reason: collision with root package name */
    public int f13483f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13484g;

    /* renamed from: h  reason: collision with root package name */
    public b f13485h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbCheckBox tbCheckBox = TbCheckBox.this;
            tbCheckBox.setChecked(!tbCheckBox.e());
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(TbCheckBox tbCheckBox, boolean z, Object obj);
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean isChecked();

        void setChecked(boolean z);
    }

    public TbCheckBox(Context context) {
        super(context);
        this.f13482e = R.drawable.icon_set_list_ok_s;
        this.f13483f = R.drawable.icon_set_list_ok_n;
        c();
    }

    public void b() {
        if (e()) {
            if (this.f13484g) {
                setImageDrawable(WebPManager.getPureDrawable(this.f13482e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                SkinManager.setImageResource(this, this.f13482e);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.f13484g) {
            setImageDrawable(WebPManager.getPureDrawable(this.f13483f, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            SkinManager.setImageResource(this, this.f13483f);
        }
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public final void c() {
        setOnClickListener(new a());
        b();
    }

    public boolean d() {
        return e();
    }

    public final boolean e() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof c)) {
            return false;
        }
        return ((c) tag).isChecked();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.f13482e = i;
        this.f13483f = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.f13484g = z;
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof c)) {
            ((c) tag).setChecked(z);
        }
        b();
        b bVar = this.f13485h;
        if (bVar != null) {
            bVar.a(this, z, getTag());
        }
    }

    public void setStatedChangedListener(b bVar) {
        this.f13485h = bVar;
    }

    public void setTagData(c cVar) {
        setTag(cVar);
        b();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13482e = R.drawable.icon_set_list_ok_s;
        this.f13483f = R.drawable.icon_set_list_ok_n;
        c();
    }
}
