package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private int coW;
    private int coX;
    private a coY;

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
        anM();
    }

    public TbCheckBox(Context context) {
        super(context);
        this.coW = R.drawable.icon_set_list_ok_s;
        this.coX = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coW = R.drawable.icon_set_list_ok_s;
        this.coX = R.drawable.icon_set_list_ok_n;
        initialize();
    }

    public void setBackgroundDrawableId(int i, int i2) {
        this.coW = i;
        this.coX = i2;
    }

    private void initialize() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.TbCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbCheckBox.this.setChecked(!TbCheckBox.this.anN());
            }
        });
        anM();
    }

    public void setStatedChangedListener(a aVar) {
        this.coY = aVar;
    }

    public void anM() {
        if (anN()) {
            am.setImageResource(this, this.coW);
            setContentDescription(getResources().getString(R.string.check_box_checked));
            return;
        }
        am.setImageResource(this, this.coX);
        setContentDescription(getResources().getString(R.string.check_box_not_checked));
    }

    public boolean isChecked() {
        return anN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anN() {
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
        anM();
        if (this.coY != null) {
            this.coY.a(this, z, getTag());
        }
    }
}
