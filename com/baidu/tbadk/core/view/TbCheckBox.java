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
    public int f13152e;

    /* renamed from: f  reason: collision with root package name */
    public int f13153f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13154g;

    /* renamed from: h  reason: collision with root package name */
    public b f13155h;

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
        this.f13152e = R.drawable.icon_set_list_ok_s;
        this.f13153f = R.drawable.icon_set_list_ok_n;
        c();
    }

    public void b() {
        if (e()) {
            if (this.f13154g) {
                setImageDrawable(WebPManager.getPureDrawable(this.f13152e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                SkinManager.setImageResource(this, this.f13152e);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.f13154g) {
            setImageDrawable(WebPManager.getPureDrawable(this.f13153f, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            SkinManager.setImageResource(this, this.f13153f);
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
        this.f13152e = i;
        this.f13153f = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.f13154g = z;
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof c)) {
            ((c) tag).setChecked(z);
        }
        b();
        b bVar = this.f13155h;
        if (bVar != null) {
            bVar.a(this, z, getTag());
        }
    }

    public void setStatedChangedListener(b bVar) {
        this.f13155h = bVar;
    }

    public void setTagData(c cVar) {
        setTag(cVar);
        b();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13152e = R.drawable.icon_set_list_ok_s;
        this.f13153f = R.drawable.icon_set_list_ok_n;
        c();
    }
}
