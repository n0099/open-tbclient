package com.baidu.swan.apps.textarea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public class ShowConfirmBarLayout extends RelativeLayout {
    private Button dQm;
    private a dQn;

    /* loaded from: classes9.dex */
    public interface a {
        void onClick(View view);
    }

    public ShowConfirmBarLayout(Context context) {
        super(context);
        this.dQm = (Button) LayoutInflater.from(context).inflate(a.g.aiapps_textarea_confirm_bar, this).findViewById(a.f.confirm_button);
        this.dQm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.textarea.ShowConfirmBarLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ShowConfirmBarLayout.this.dQn != null) {
                    ShowConfirmBarLayout.this.dQn.onClick(view);
                }
            }
        });
    }

    public void setOnConfirmButtonClickListener(a aVar) {
        this.dQn = aVar;
    }
}
