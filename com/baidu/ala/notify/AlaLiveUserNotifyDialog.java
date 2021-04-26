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
import com.google.protobuf.CodedInputStream;
/* loaded from: classes.dex */
public class AlaLiveUserNotifyDialog extends Dialog {
    public RelativeLayout alaNotifyContentPanel;
    public TextView alaNotifyDescription;
    public TextView btnKnow;
    public ImageView ivHeadWrapper;
    public View.OnClickListener mOnClickListener;
    public View mRootView;
    public AlaLiveUserNotifyData mUserNotifyData;
    public View overUserPortraitBg;
    public FrameLayout portraitLayout;
    public HeadImageView userPortrait;

    public AlaLiveUserNotifyDialog(Activity activity) {
        super(activity);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.ala.notify.AlaLiveUserNotifyDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveUserNotifyDialog.this.dismiss();
            }
        };
    }

    private void bindDataToView() {
        this.userPortrait.V(this.mUserNotifyData.getAnchorPortrait(), 12, false);
        this.alaNotifyDescription.setText(this.mUserNotifyData.getMessageContent());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initDialog() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        getWindow().setDimAmount(0.66f);
        getWindow().setBackgroundDrawable(colorDrawable);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(17);
    }

    private void initView() {
        View inflate = getLayoutInflater().inflate(R.layout.ala_notify_detail_layout, (ViewGroup) null);
        this.mRootView = inflate;
        setContentView(inflate);
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

    public void onChangeSkinType(int i2) {
        if (i2 == 1) {
            this.alaNotifyContentPanel.setBackgroundResource(R.drawable.black_line_f_corner_all);
            this.alaNotifyDescription.setTextColor(getContext().getResources().getColor(R.color.CAM_X0107_1));
            this.btnKnow.setTextColor(getContext().getResources().getColor(R.color.CAM_X0302_1));
            this.portraitLayout.setBackgroundResource(R.drawable.black_line_f_oval_shape);
            this.overUserPortraitBg.setVisibility(0);
            return;
        }
        this.alaNotifyContentPanel.setBackgroundResource(R.drawable.white_corner_all);
        this.alaNotifyDescription.setTextColor(getContext().getResources().getColor(R.color.common_color_10037));
        this.btnKnow.setTextColor(getContext().getResources().getColor(R.color.CAM_X0302));
        this.portraitLayout.setBackgroundResource(R.drawable.white_oval_shape);
        this.overUserPortraitBg.setVisibility(8);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            getWindow().addFlags(134217728);
        }
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        initView();
        initDialog();
    }

    public void show(AlaLiveUserNotifyData alaLiveUserNotifyData) {
        if (alaLiveUserNotifyData == null) {
            return;
        }
        this.mUserNotifyData = alaLiveUserNotifyData;
        setCanceledOnTouchOutside(false);
        show();
        bindDataToView();
    }
}
