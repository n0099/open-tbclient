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
    private int eUH;
    private int eUI;
    private boolean eUJ;
    private a eUK;

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
        brT();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.eUH = R.drawable.icon_set_list_ok_s;
        this.eUI = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eUH = R.drawable.icon_set_list_ok_s;
        this.eUI = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.eUH = i;
        this.eUI = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.eUJ = z;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.brU());
            }
        });
        brT();
    }

    public void setStatedChangedListener(a aVar) {
        this.eUK = aVar;
    }

    public void brT() {
        if (brU()) {
            if (this.eUJ) {
                setImageDrawable(WebPManager.a(this.eUH, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                ap.setImageResource(this, this.eUH);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.eUJ) {
            setImageDrawable(WebPManager.a(this.eUI, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            ap.setImageResource(this, this.eUI);
        }
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return brU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brU() {
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
        brT();
        if (this.eUK != null) {
            this.eUK.a(this, z, getTag());
        }
    }
}
