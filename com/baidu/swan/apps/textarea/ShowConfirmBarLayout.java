package com.baidu.swan.apps.textarea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public class ShowConfirmBarLayout extends RelativeLayout {
    private Button dLA;
    private a dLB;

    /* loaded from: classes8.dex */
    public interface a {
        void onClick(View view);
    }

    public ShowConfirmBarLayout(Context context) {
        super(context);
        this.dLA = (Button) LayoutInflater.from(context).inflate(a.g.aiapps_textarea_confirm_bar, this).findViewById(a.f.confirm_button);
        this.dLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.textarea.ShowConfirmBarLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ShowConfirmBarLayout.this.dLB != null) {
                    ShowConfirmBarLayout.this.dLB.onClick(view);
                }
            }
        });
    }

    public void setOnConfirmButtonClickListener(a aVar) {
        this.dLB = aVar;
    }
}
