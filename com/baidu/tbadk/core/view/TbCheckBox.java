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
    public int f13483e;

    /* renamed from: f  reason: collision with root package name */
    public int f13484f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13485g;

    /* renamed from: h  reason: collision with root package name */
    public b f13486h;

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
        this.f13483e = R.drawable.icon_set_list_ok_s;
        this.f13484f = R.drawable.icon_set_list_ok_n;
        c();
    }

    public void b() {
        if (e()) {
            if (this.f13485g) {
                setImageDrawable(WebPManager.getPureDrawable(this.f13483e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                SkinManager.setImageResource(this, this.f13483e);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.f13485g) {
            setImageDrawable(WebPManager.getPureDrawable(this.f13484f, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            SkinManager.setImageResource(this, this.f13484f);
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
        this.f13483e = i;
        this.f13484f = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.f13485g = z;
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof c)) {
            ((c) tag).setChecked(z);
        }
        b();
        b bVar = this.f13486h;
        if (bVar != null) {
            bVar.a(this, z, getTag());
        }
    }

    public void setStatedChangedListener(b bVar) {
        this.f13486h = bVar;
    }

    public void setTagData(c cVar) {
        setTag(cVar);
        b();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13483e = R.drawable.icon_set_list_ok_s;
        this.f13484f = R.drawable.icon_set_list_ok_n;
        c();
    }
}
