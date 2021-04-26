package com.baidu.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i0.d0.a;
/* loaded from: classes.dex */
public class AlaNetRefreshView extends a {
    public TextView mNetFailTipView;
    public TextView mNetRefreshBtn;
    public LinearLayout mNetRefreshContainer;
    public ImageView mNetRefreshImg;

    public AlaNetRefreshView(Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.ala_live_net_refresh_view_layout, (ViewGroup) null));
        this.mNetRefreshImg = (ImageView) this.attachedView.findViewById(R.id.ala_net_refresh_img);
        this.mNetFailTipView = (TextView) this.attachedView.findViewById(R.id.ala_net_refresh_text);
        this.mNetRefreshBtn = (TextView) this.attachedView.findViewById(R.id.ala_net_refresh_btn);
        this.mNetRefreshContainer = (LinearLayout) this.attachedView.findViewById(R.id.ala_net_refresh_container);
    }

    public void onChangeSkinType() {
        TextView textView = this.mNetFailTipView;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        }
        LinearLayout linearLayout = this.mNetRefreshContainer;
        if (linearLayout != null) {
            SkinManager.setBackgroundResource(linearLayout, R.color.CAM_X0201);
        }
        TextView textView2 = this.mNetRefreshBtn;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this.mNetRefreshBtn, R.drawable.ala_net_refresh_btn_bg);
        }
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        ImageView imageView = this.mNetRefreshImg;
        if (imageView != null) {
            if (z) {
                imageView.setAlpha(0.4f);
            } else {
                imageView.setAlpha(1.0f);
            }
        }
    }

    public void setBackgroundColor(int i2) {
        this.attachedView.setBackgroundColor(i2);
    }

    public void setContainerBackgroundColor(int i2) {
        LinearLayout linearLayout = this.mNetRefreshContainer;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(i2);
        }
    }

    public void setImageResource(int i2) {
        ImageView imageView = this.mNetRefreshImg;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }

    public void setIsShowRefreshButton(boolean z) {
        TextView textView = this.mNetRefreshBtn;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setNetFailTipText(String str) {
        TextView textView = this.mNetFailTipView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setNetRefreshBtnBackgroundResource(int i2) {
        TextView textView = this.mNetRefreshBtn;
        if (textView != null) {
            textView.setBackgroundResource(i2);
        }
    }

    public void setNetRefreshBtnText(String str) {
        TextView textView = this.mNetRefreshBtn;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setNetRefreshBtnTextColor(int i2) {
        TextView textView = this.mNetRefreshBtn;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setNetRefreshImgAlpha(float f2) {
        ImageView imageView = this.mNetRefreshImg;
        if (imageView != null) {
            imageView.setAlpha(f2);
        }
    }

    public void setNetRefreshTipTextColor(int i2) {
        TextView textView = this.mNetFailTipView;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setOnRefreshClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.mNetRefreshBtn;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }
}
