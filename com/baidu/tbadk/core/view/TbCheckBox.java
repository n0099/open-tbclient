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
    private int fcd;
    private int fce;
    private boolean fcf;
    private a fcg;

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
        bvt();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.fcd = R.drawable.icon_set_list_ok_s;
        this.fce = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fcd = R.drawable.icon_set_list_ok_s;
        this.fce = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.fcd = i;
        this.fce = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.fcf = z;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.bvu());
            }
        });
        bvt();
    }

    public void setStatedChangedListener(a aVar) {
        this.fcg = aVar;
    }

    public void bvt() {
        if (bvu()) {
            if (this.fcf) {
                setImageDrawable(WebPManager.a(this.fcd, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                ap.setImageResource(this, this.fcd);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.fcf) {
            setImageDrawable(WebPManager.a(this.fce, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            ap.setImageResource(this, this.fce);
        }
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return bvu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvu() {
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
        bvt();
        if (this.fcg != null) {
            this.fcg.a(this, z, getTag());
        }
    }
}
