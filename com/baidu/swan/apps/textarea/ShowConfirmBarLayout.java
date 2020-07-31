package com.baidu.swan.apps.textarea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes7.dex */
public class ShowConfirmBarLayout extends RelativeLayout {
    private Button cQI;
    private a cQJ;

    /* loaded from: classes7.dex */
    public interface a {
        void onClick(View view);
    }

    public ShowConfirmBarLayout(Context context) {
        super(context);
        this.cQI = (Button) LayoutInflater.from(context).inflate(a.g.aiapps_textarea_confirm_bar, this).findViewById(a.f.confirm_button);
        this.cQI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.textarea.ShowConfirmBarLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ShowConfirmBarLayout.this.cQJ != null) {
                    ShowConfirmBarLayout.this.cQJ.onClick(view);
                }
            }
        });
    }

    public void setOnConfirmButtonClickListener(a aVar) {
        this.cQJ = aVar;
    }
}
