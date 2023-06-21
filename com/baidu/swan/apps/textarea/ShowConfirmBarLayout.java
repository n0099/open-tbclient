package com.baidu.swan.apps.textarea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ShowConfirmBarLayout extends RelativeLayout {
    public Button a;
    public b b;

    /* loaded from: classes4.dex */
    public interface b {
        void onClick(View view2);
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ShowConfirmBarLayout.this.b != null) {
                ShowConfirmBarLayout.this.b.onClick(view2);
            }
        }
    }

    public ShowConfirmBarLayout(Context context) {
        super(context);
        Button button = (Button) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00da, this).findViewById(R.id.obfuscated_res_0x7f09078e);
        this.a = button;
        button.setOnClickListener(new a());
    }

    public void setOnConfirmButtonClickListener(b bVar) {
        this.b = bVar;
    }
}
