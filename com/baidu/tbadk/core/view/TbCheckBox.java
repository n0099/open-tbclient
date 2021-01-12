package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int fhb;
    private int fhc;
    private boolean fhd;
    private a fhe;

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
        btV();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.fhb = R.drawable.icon_set_list_ok_s;
        this.fhc = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhb = R.drawable.icon_set_list_ok_s;
        this.fhc = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.fhb = i;
        this.fhc = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.fhd = z;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.btW());
            }
        });
        btV();
    }

    public void setStatedChangedListener(a aVar) {
        this.fhe = aVar;
    }

    public void btV() {
        if (btW()) {
            if (this.fhd) {
                setImageDrawable(WebPManager.a(this.fhb, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                ao.setImageResource(this, this.fhb);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.fhd) {
            setImageDrawable(WebPManager.a(this.fhc, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            ao.setImageResource(this, this.fhc);
        }
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return btW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btW() {
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
        btV();
        if (this.fhe != null) {
            this.fhe.a(this, z, getTag());
        }
    }
}
