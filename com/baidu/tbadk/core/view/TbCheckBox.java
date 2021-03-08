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
    private int fkT;
    private int fkU;
    private boolean fkV;
    private a fkW;

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
        bus();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.fkT = R.drawable.icon_set_list_ok_s;
        this.fkU = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkT = R.drawable.icon_set_list_ok_s;
        this.fkU = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.fkT = i;
        this.fkU = i2;
    }

    public void setBackgroundDrawableIdIsWebP(boolean z) {
        this.fkV = z;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.but());
            }
        });
        bus();
    }

    public void setStatedChangedListener(a aVar) {
        this.fkW = aVar;
    }

    public void bus() {
        if (but()) {
            if (this.fkV) {
                setImageDrawable(WebPManager.a(this.fkT, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                ap.setImageResource(this, this.fkT);
            }
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        if (this.fkV) {
            setImageDrawable(WebPManager.a(this.fkU, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            ap.setImageResource(this, this.fkU);
        }
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return but();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean but() {
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
        bus();
        if (this.fkW != null) {
            this.fkW.a(this, z, getTag());
        }
    }
}
