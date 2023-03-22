package com.baidu.ala.notify;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes.dex */
public class AlaLiveUserNotifyDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveUserNotifyDialog(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnClickListener = new View.OnClickListener(this) { // from class: com.baidu.ala.notify.AlaLiveUserNotifyDialog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaLiveUserNotifyDialog this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    this.this$0.dismiss();
                }
            }
        };
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                getWindow().addFlags(134217728);
            }
            super.onCreate(bundle);
            getWindow().requestFeature(1);
            initView();
            initDialog();
        }
    }

    private void bindDataToView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.userPortrait.M(this.mUserNotifyData.getAnchorPortrait(), 12, false);
            this.alaNotifyDescription.setText(this.mUserNotifyData.getMessageContent());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ColorDrawable colorDrawable = new ColorDrawable(0);
            getWindow().setDimAmount(0.66f);
            getWindow().setBackgroundDrawable(colorDrawable);
            getWindow().setLayout(-1, -2);
            getWindow().setGravity(17);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0106, (ViewGroup) null);
            this.mRootView = inflate;
            setContentView(inflate);
            this.alaNotifyContentPanel = (RelativeLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090213);
            this.alaNotifyDescription = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090214);
            this.btnKnow = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090479);
            this.portraitLayout = (FrameLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091bd1);
            this.userPortrait = (HeadImageView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0926c5);
            this.ivHeadWrapper = (ImageView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091174);
            this.overUserPortraitBg = this.mRootView.findViewById(R.id.obfuscated_res_0x7f09190b);
            this.userPortrait.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.userPortrait.setIsRound(true);
            this.userPortrait.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.btnKnow.setOnClickListener(this.mOnClickListener);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.alaNotifyContentPanel.setBackgroundResource(R.drawable.obfuscated_res_0x7f081350);
            this.alaNotifyDescription.setTextColor(getContext().getResources().getColor(R.color.common_color_10037));
            this.btnKnow.setTextColor(getContext().getResources().getColor(R.color.CAM_X0302));
            this.portraitLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f081351);
            this.overUserPortraitBg.setVisibility(8);
        }
    }

    public void show(AlaLiveUserNotifyData alaLiveUserNotifyData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaLiveUserNotifyData) != null) || alaLiveUserNotifyData == null) {
            return;
        }
        this.mUserNotifyData = alaLiveUserNotifyData;
        setCanceledOnTouchOutside(false);
        show();
        bindDataToView();
    }
}
