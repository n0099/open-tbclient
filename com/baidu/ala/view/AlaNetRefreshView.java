package com.baidu.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.l.a;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class AlaNetRefreshView extends a {
    private TextView mNetFailTipView;
    private TextView mNetRefreshBtn;
    private LinearLayout mNetRefreshContainer;
    private ImageView mNetRefreshImg;

    public AlaNetRefreshView(Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.ala_live_net_refresh_view_layout, (ViewGroup) null));
        this.mNetRefreshImg = (ImageView) this.attachedView.findViewById(R.id.ala_net_refresh_img);
        this.mNetFailTipView = (TextView) this.attachedView.findViewById(R.id.ala_net_refresh_text);
        this.mNetRefreshBtn = (TextView) this.attachedView.findViewById(R.id.ala_net_refresh_btn);
        this.mNetRefreshContainer = (LinearLayout) this.attachedView.findViewById(R.id.ala_net_refresh_container);
    }

    public void setOnRefreshClickListener(View.OnClickListener onClickListener) {
        if (this.mNetRefreshBtn != null) {
            this.mNetRefreshBtn.setOnClickListener(onClickListener);
        }
    }

    public void setImageResource(int i) {
        if (this.mNetRefreshImg != null) {
            this.mNetRefreshImg.setImageResource(i);
        }
    }

    public void setNetFailTipText(String str) {
        if (this.mNetFailTipView != null) {
            this.mNetFailTipView.setText(str);
        }
    }

    public void setNetRefreshBtnText(String str) {
        if (this.mNetRefreshBtn != null) {
            this.mNetRefreshBtn.setText(str);
        }
    }

    public void setIsShowRefreshButton(boolean z) {
        if (this.mNetRefreshBtn != null) {
            this.mNetRefreshBtn.setVisibility(z ? 0 : 8);
        }
    }

    public void setBackgroundColor(int i) {
        this.attachedView.setBackgroundColor(i);
    }

    public void setNetRefreshImgAlpha(float f) {
        if (this.mNetRefreshImg != null) {
            this.mNetRefreshImg.setAlpha(f);
        }
    }

    public void setNetRefreshBtnTextColor(int i) {
        if (this.mNetRefreshBtn != null) {
            this.mNetRefreshBtn.setTextColor(i);
        }
    }

    public void setNetRefreshBtnBackgroundResource(int i) {
        if (this.mNetRefreshBtn != null) {
            this.mNetRefreshBtn.setBackgroundResource(i);
        }
    }

    public void setNetRefreshTipTextColor(int i) {
        if (this.mNetFailTipView != null) {
            this.mNetFailTipView.setTextColor(i);
        }
    }

    public void setContainerBackgroundColor(int i) {
        if (this.mNetRefreshContainer != null) {
            this.mNetRefreshContainer.setBackgroundColor(i);
        }
    }

    public void onChangeSkinType() {
        if (this.mNetFailTipView != null) {
            ao.setViewTextColor(this.mNetFailTipView, R.color.CAM_X0106);
        }
        if (this.mNetRefreshContainer != null) {
            ao.setBackgroundResource(this.mNetRefreshContainer, R.color.CAM_X0201);
        }
        if (this.mNetRefreshBtn != null) {
            ao.setViewTextColor(this.mNetRefreshBtn, R.color.CAM_X0106);
            ao.setBackgroundResource(this.mNetRefreshBtn, R.drawable.ala_net_refresh_btn_bg);
        }
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        if (this.mNetRefreshImg != null) {
            if (z) {
                this.mNetRefreshImg.setAlpha(0.4f);
            } else {
                this.mNetRefreshImg.setAlpha(1.0f);
            }
        }
    }
}
