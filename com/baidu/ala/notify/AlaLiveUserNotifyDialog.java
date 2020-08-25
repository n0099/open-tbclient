package com.baidu.ala.notify;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class AlaLiveUserNotifyDialog extends Dialog {
    private RelativeLayout alaNotifyContentPanel;
    private TextView alaNotifyDescription;
    private TextView btnKnow;
    private ImageView ivHeadWrapper;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private AlaLiveUserNotifyData mUserNotifyData;
    private View overUserPortraitBg;
    private FrameLayout portraitLayout;
    private HeadImageView userPortrait;

    public AlaLiveUserNotifyDialog(Activity activity) {
        super(activity);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.ala.notify.AlaLiveUserNotifyDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveUserNotifyDialog.this.dismiss();
            }
        };
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
        }
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        initView();
        initDialog();
    }

    private void initDialog() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        getWindow().setDimAmount(0.66f);
        getWindow().setBackgroundDrawable(colorDrawable);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(17);
    }

    private void initView() {
        this.mRootView = getLayoutInflater().inflate(R.layout.ala_notify_detail_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.alaNotifyContentPanel = (RelativeLayout) this.mRootView.findViewById(R.id.ala_notify_content_panel);
        this.alaNotifyDescription = (TextView) this.mRootView.findViewById(R.id.ala_notify_description);
        this.btnKnow = (TextView) this.mRootView.findViewById(R.id.btnKnow);
        this.portraitLayout = (FrameLayout) this.mRootView.findViewById(R.id.portrait_layout);
        this.userPortrait = (HeadImageView) this.mRootView.findViewById(R.id.user_portrait);
        this.ivHeadWrapper = (ImageView) this.mRootView.findViewById(R.id.iv_head_wrapper);
        this.overUserPortraitBg = this.mRootView.findViewById(R.id.over_user_portrait_bg);
        this.userPortrait.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.userPortrait.setIsRound(true);
        this.userPortrait.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.btnKnow.setOnClickListener(this.mOnClickListener);
    }

    public void show(AlaLiveUserNotifyData alaLiveUserNotifyData) {
        if (alaLiveUserNotifyData != null) {
            this.mUserNotifyData = alaLiveUserNotifyData;
            setCanceledOnTouchOutside(false);
            show();
            bindDataToView();
        }
    }

    private void bindDataToView() {
        this.userPortrait.startLoad(this.mUserNotifyData.getAnchorPortrait(), 12, false);
        this.alaNotifyDescription.setText(this.mUserNotifyData.getMessageContent());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i == 1) {
            this.alaNotifyContentPanel.setBackgroundResource(R.drawable.black_line_f_corner_all);
            this.alaNotifyDescription.setTextColor(getContext().getResources().getColor(R.color.cp_cont_j_1));
            this.btnKnow.setTextColor(getContext().getResources().getColor(R.color.cp_link_tip_a_1));
            this.portraitLayout.setBackgroundResource(R.drawable.black_line_f_oval_shape);
            this.overUserPortraitBg.setVisibility(0);
            return;
        }
        this.alaNotifyContentPanel.setBackgroundResource(R.drawable.white_corner_all);
        this.alaNotifyDescription.setTextColor(getContext().getResources().getColor(R.color.common_color_10037));
        this.btnKnow.setTextColor(getContext().getResources().getColor(R.color.cp_link_tip_a));
        this.portraitLayout.setBackgroundResource(R.drawable.white_oval_shape);
        this.overUserPortraitBg.setVisibility(8);
    }
}
