package com.baidu.searchbox.ng.ai.apps.textarea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.searchbox.ng.ai.apps.R;
/* loaded from: classes2.dex */
public class ShowConfirmBarLayout extends RelativeLayout {
    private Button mConfirmButton;
    private OnConfirmButtonClickListener mOnConfirmButtonClickListener;

    /* loaded from: classes2.dex */
    public interface OnConfirmButtonClickListener {
        void onClick(View view);
    }

    public ShowConfirmBarLayout(Context context) {
        super(context);
        this.mConfirmButton = (Button) LayoutInflater.from(context).inflate(R.layout.aiapps_textarea_confirm_bar, this).findViewById(R.id.confirm_button);
        this.mConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.textarea.ShowConfirmBarLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ShowConfirmBarLayout.this.mOnConfirmButtonClickListener != null) {
                    ShowConfirmBarLayout.this.mOnConfirmButtonClickListener.onClick(view);
                }
            }
        });
    }

    public void setOnConfirmButtonClickListener(OnConfirmButtonClickListener onConfirmButtonClickListener) {
        this.mOnConfirmButtonClickListener = onConfirmButtonClickListener;
    }
}
