package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int fju;
    private int fjv;
    private boolean fjw;
    private a fjx;

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
        bup();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.fju = R.drawable.icon_set_list_ok_s;
        this.fjv = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fju = R.drawable.icon_set_list_ok_s;
        this.fjv = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.fju = i;
        this.fjv = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.fjw = z;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.buq());
            }
        });
        bup();
    }

    public void setStatedChangedListener(a aVar) {
        this.fjx = aVar;
    }

    public void bup() {
        if (buq()) {
            if (this.fjw) {
                setImageDrawable(WebPManager.a(this.fju, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                ap.setImageResource(this, this.fju);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.fjw) {
            setImageDrawable(WebPManager.a(this.fjv, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            ap.setImageResource(this, this.fjv);
        }
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return buq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buq() {
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
        bup();
        if (this.fjx != null) {
            this.fjx.a(this, z, getTag());
        }
    }
}
