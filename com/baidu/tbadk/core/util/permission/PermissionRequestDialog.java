package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kuaishou.weapon.p0.h;
/* loaded from: classes4.dex */
public class PermissionRequestDialog extends zz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mCloseView;
    public TextView mContinueView;
    public TextView mDetailView;
    public OnClickCallback mOnClickCallback;
    public String mRequestPermission;
    public ViewGroup mRootView;
    public TextView mTitleView;

    /* loaded from: classes4.dex */
    public interface OnClickCallback {
        void onClickClose(Activity activity, String str);

        void onClickContinue(Activity activity, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionRequestDialog(Activity activity) {
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
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initView();
        setContentViewSize(3);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setAutoNight(false);
    }

    public void setOnClickCallback(OnClickCallback onClickCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickCallback) == null) {
            this.mOnClickCallback = onClickCallback;
        }
    }

    public void setRequestPermission(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mRequestPermission = str;
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
            this.mRootView = viewGroup;
            this.mTitleView = (TextView) viewGroup.findViewById(R.id.tv_permission_request_title);
            this.mDetailView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
            TextView textView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
            this.mCloseView = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0478);
            TextView textView2 = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
            this.mContinueView = textView2;
            textView2.setText(R.string.alert_yes_button);
            onChangeSkinType();
            setContentView(this.mRootView);
        }
    }

    @Override // com.baidu.tieba.zz4
    public zz4 create(BdPageContext<?> bdPageContext) {
        InterceptResult invokeL;
        char c;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bdPageContext)) == null) {
            super.create(bdPageContext);
            String str = this.mRequestPermission;
            int hashCode = str.hashCode();
            if (hashCode != -63024214) {
                if (hashCode != 463403621) {
                    if (hashCode == 1831139720 && str.equals(PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                        c = 1;
                    }
                    c = 65535;
                } else {
                    if (str.equals(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                        c = 0;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals(h.h)) {
                    c = 2;
                }
                c = 65535;
            }
            String str2 = null;
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        string = null;
                    } else {
                        str2 = bdPageContext.getString(R.string.request_permission_title_location);
                        string = bdPageContext.getString(R.string.request_permission_detail_location);
                    }
                } else {
                    str2 = bdPageContext.getString(R.string.request_permission_title_record_audio);
                    string = bdPageContext.getString(R.string.request_permission_detail_record_audio);
                }
            } else {
                str2 = bdPageContext.getString(R.string.request_permission_title_camera);
                string = bdPageContext.getString(R.string.request_permission_detail_camera);
            }
            this.mTitleView.setText(str2);
            this.mDetailView.setText(string);
            this.mCloseView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tbadk.core.util.permission.PermissionRequestDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PermissionRequestDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.this$0.mOnClickCallback != null) {
                        this.this$0.mOnClickCallback.onClickClose(this.this$0.mActivity, this.this$0.mRequestPermission);
                    }
                }
            });
            this.mContinueView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tbadk.core.util.permission.PermissionRequestDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PermissionRequestDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.this$0.mOnClickCallback != null) {
                        this.this$0.mOnClickCallback.onClickContinue(this.this$0.mActivity, this.this$0.mRequestPermission);
                    }
                }
            });
            return this;
        }
        return (zz4) invokeL.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
            SkinManager.setViewTextColor(this.mTitleView, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mDetailView, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColorSelector(this.mCloseView, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
            SkinManager.setViewTextColorSelector(this.mContinueView, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        }
    }
}
