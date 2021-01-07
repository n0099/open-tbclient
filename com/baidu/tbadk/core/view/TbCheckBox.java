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
    private int flM;
    private int flN;
    private boolean flO;
    private a flP;

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
        bxP();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.flM = R.drawable.icon_set_list_ok_s;
        this.flN = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flM = R.drawable.icon_set_list_ok_s;
        this.flN = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.flM = i;
        this.flN = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.flO = z;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.bxQ());
            }
        });
        bxP();
    }

    public void setStatedChangedListener(a aVar) {
        this.flP = aVar;
    }

    public void bxP() {
        if (bxQ()) {
            if (this.flO) {
                setImageDrawable(WebPManager.a(this.flM, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                ao.setImageResource(this, this.flM);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.flO) {
            setImageDrawable(WebPManager.a(this.flN, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            ao.setImageResource(this, this.flN);
        }
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return bxQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxQ() {
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
        bxP();
        if (this.flP != null) {
            this.flP.a(this, z, getTag());
        }
    }
}
