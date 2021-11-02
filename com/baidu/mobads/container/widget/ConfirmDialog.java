package com.baidu.mobads.container.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import com.baidu.mobads.container.landingpage.LpCloseController;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.RoundRectButton;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ConfirmDialog extends DialogFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_DESC_COLOR_DEFAULT = -6710887;
    public static final int APP_NAME_COLOR_DEFAULT = -14737633;
    public static final int BACKGROUND_COLOR_DEFAULT = -1;
    public static final int CORNER_RADIUS_DEFAULT = 23;
    public static final String FRAG_TAG = "union_download_confirm_dialog";
    public static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    public static final String TAG;
    public static final int VIEW_ID_APP_ICON = 1001;
    public static final int VIEW_ID_APP_NAME = 1002;
    public static final int VIEW_ID_APP_PERMISSION_PRIVACY = 1005;
    public static final int VIEW_ID_APP_PUBLISHER = 1004;
    public static final int VIEW_ID_APP_VERSION = 1003;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity activity;
    public IXAdInstanceInfo adInfo;
    public RelativeLayout contentView;
    public RoundRectButton downloadButton;
    public boolean hideNavigation;
    public OnConfirmListener listener;
    public IOAdEventListener lpCloseListener;

    /* loaded from: classes7.dex */
    public class LpCloseListener implements IOAdEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConfirmDialog this$0;

        public LpCloseListener(ConfirmDialog confirmDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {confirmDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = confirmDialog;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iOAdEvent) == null) && "AdLpClosed".equals(iOAdEvent.getType()) && this.this$0.listener != null) {
                this.this$0.listener.onPrivacyClose();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnConfirmListener {
        void onAdClick();

        void onDialogClose();

        void onDialogShow();

        void onPermissionClose();

        void onPermissionShow();

        void onPrivacyClick();

        void onPrivacyClose();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1759143295, "Lcom/baidu/mobads/container/widget/ConfirmDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1759143295, "Lcom/baidu/mobads/container/widget/ConfirmDialog;");
                return;
            }
        }
        TAG = ConfirmDialog.class.getSimpleName();
    }

    public ConfirmDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hideNavigation = false;
    }

    private void addAppDesc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            TextView textView = new TextView(this.activity);
            float f2 = 14;
            textView.setTextSize(f2);
            textView.setTextColor(APP_DESC_COLOR_DEFAULT);
            TextView textView2 = new TextView(this.activity);
            textView2.setTextSize(f2);
            textView2.setTextColor(APP_DESC_COLOR_DEFAULT);
            TextView textView3 = new TextView(this.activity);
            textView3.setTextSize(f2);
            textView3.setTextColor(APP_DESC_COLOR_DEFAULT);
            TextView textView4 = new TextView(this.activity);
            textView4.setTextSize(f2);
            textView4.setTextColor(APP_DESC_COLOR_DEFAULT);
            IXAdInstanceInfo iXAdInstanceInfo = this.adInfo;
            if (iXAdInstanceInfo != null) {
                JSONObject originJsonObject = iXAdInstanceInfo.getOriginJsonObject();
                String optString = originJsonObject.optString("app_version");
                if (!TextUtils.isEmpty(optString)) {
                    String str = "版本 " + optString;
                    if (!optString.contains("版本")) {
                        optString = str;
                    }
                    textView.setText(optString);
                } else {
                    textView.setVisibility(8);
                }
                String optString2 = originJsonObject.optString("publisher");
                if (!TextUtils.isEmpty(optString2)) {
                    textView2.setText(optString2);
                } else {
                    textView2.setVisibility(8);
                }
                String optString3 = originJsonObject.optString(AppPriActivity.PRIVACY_LINK);
                if (!TextUtils.isEmpty(optString3)) {
                    textView3.setText(DisplayInfoView.PRI_TEXT);
                    textView3.setOnClickListener(new View.OnClickListener(this, optString3) { // from class: com.baidu.mobads.container.widget.ConfirmDialog.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConfirmDialog this$0;
                        public final /* synthetic */ String val$privacy_link;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, optString3};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$privacy_link = optString3;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.this$0.sendDownloadDialogLog("click_button_privacy");
                                Intent intent = new Intent();
                                intent.putExtra(AppPriActivity.PRIVACY_LINK, this.val$privacy_link);
                                if (this.this$0.listener != null) {
                                    this.this$0.listener.onPrivacyClick();
                                }
                                ActivityUtils.startAppPriActivity(this.this$0.activity, intent);
                                ConfirmDialog confirmDialog = this.this$0;
                                confirmDialog.registerLpCloseReceiver(confirmDialog.activity);
                            }
                        }
                    });
                } else {
                    textView3.setVisibility(8);
                }
                String optString4 = originJsonObject.optString("permission_link");
                if (!TextUtils.isEmpty(optString4)) {
                    textView4.setText(DisplayInfoView.AUTH_TEXT);
                    textView4.setOnClickListener(new View.OnClickListener(this, optString4) { // from class: com.baidu.mobads.container.widget.ConfirmDialog.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConfirmDialog this$0;
                        public final /* synthetic */ String val$permission_link;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, optString4};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$permission_link = optString4;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.this$0.sendDownloadDialogLog("click_button_permission");
                                VerifyPerDialog createVerPerDialog = VerifyPerDialog.createVerPerDialog(this.this$0.activity, this.val$permission_link);
                                createVerPerDialog.setHideNavigation(this.this$0.hideNavigation);
                                createVerPerDialog.setOnDialogListener(new OnDialogListener(this) { // from class: com.baidu.mobads.container.widget.ConfirmDialog.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.mobads.container.widget.OnDialogListener
                                    public void onDismiss() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            if (this.this$1.this$0.listener != null) {
                                                this.this$1.this$0.listener.onPermissionClose();
                                            }
                                            ConfirmDialog confirmDialog = this.this$1.this$0;
                                            confirmDialog.hideNavigation(confirmDialog.hideNavigation);
                                        }
                                    }

                                    @Override // com.baidu.mobads.container.widget.OnDialogListener
                                    public void onShow() {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.this$1.this$0.listener == null) {
                                            return;
                                        }
                                        this.this$1.this$0.listener.onPermissionShow();
                                    }
                                });
                                createVerPerDialog.show();
                            }
                        }
                    });
                } else {
                    textView4.setVisibility(8);
                }
            }
            textView.setId(1003);
            addViewBelow(textView, 1002, 18);
            textView2.setId(1004);
            textView2.setGravity(17);
            addViewBelow(textView2, 1003, 20, 13, 20, 0);
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.addView(textView3, new LinearLayout.LayoutParams(-2, -2));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = CommonUtils.dip2px(this.activity, 11.0f);
            linearLayout.addView(textView4, layoutParams);
            linearLayout.setId(1005);
            addViewBelow(linearLayout, 1004, 13);
        }
    }

    private void addAppIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            RemoteRoundCornerImageView remoteRoundCornerImageView = new RemoteRoundCornerImageView(this.activity);
            IXAdInstanceInfo iXAdInstanceInfo = this.adInfo;
            if (iXAdInstanceInfo != null && !TextUtils.isEmpty(iXAdInstanceInfo.getIconUrl())) {
                MaterialLoader.getInstance(this.activity.getApplicationContext()).loadImageForURLString(remoteRoundCornerImageView, this.adInfo.getIconUrl());
            } else {
                remoteRoundCornerImageView.setVisibility(8);
            }
            remoteRoundCornerImageView.setId(1001);
            remoteRoundCornerImageView.type = CornerImageType.RoundRect;
            remoteRoundCornerImageView.cornerRadius = CommonUtils.dip2px(this.activity, 15.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.activity, 76.0f), CommonUtils.dip2px(this.activity, 76.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, CommonUtils.dip2px(this.activity, 27.0f), 0, 0);
            this.contentView.addView(remoteRoundCornerImageView, layoutParams);
            TextView textView = new TextView(this.activity);
            IXAdInstanceInfo iXAdInstanceInfo2 = this.adInfo;
            if (iXAdInstanceInfo2 != null && !TextUtils.isEmpty(iXAdInstanceInfo2.getAppName())) {
                textView.setText(this.adInfo.getAppName());
            } else {
                textView.setVisibility(8);
            }
            textView.setId(1002);
            textView.setTextSize(remoteRoundCornerImageView.getVisibility() == 8 ? 22 : 18);
            textView.setTextColor(APP_NAME_COLOR_DEFAULT);
            textView.setTypeface(Typeface.defaultFromStyle(1));
            addViewBelow(textView, 1001, 13);
        }
    }

    private void addCloseButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            ImageView imageView = new ImageView(this.activity);
            imageView.setClickable(true);
            byte[] decode = Base64.decode(StaticPicUtils.DELETE_BTN, 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.widget.ConfirmDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ConfirmDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.sendDownloadDialogLog("click_button_close");
                        this.this$0.dismiss();
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.activity, 20.0f), CommonUtils.dip2px(this.activity, 20.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, CommonUtils.dip2px(this.activity, 15.0f), CommonUtils.dip2px(this.activity, 15.0f), 0);
            this.contentView.addView(imageView, layoutParams);
        }
    }

    private void addDownloadButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            RoundRectButton create = new RoundRectButton.Builder().setBtnTextMsg("立即下载").setBtnTextSizeSp(17).setLeftTopCorner(200).setLeftBottomCorner(200).setRightTopCorner(200).setRightBottomCorner(200).setBtnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.widget.ConfirmDialog.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ConfirmDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.sendDownloadDialogLog("click_button_download");
                        if (this.this$0.listener != null) {
                            this.this$0.listener.onAdClick();
                        }
                        this.this$0.dismiss();
                    }
                }
            }).create(this.activity);
            this.downloadButton = create;
            create.setSingleLine();
            RoundRectButton roundRectButton = this.downloadButton;
            roundRectButton.setPadding(roundRectButton.getPaddingLeft(), this.downloadButton.getPaddingTop() + CommonUtils.dip2px(this.activity, 12.0f), this.downloadButton.getPaddingRight(), this.downloadButton.getPaddingBottom() + CommonUtils.dip2px(this.activity, 12.0f));
            this.contentView.addView(this.downloadButton, getDownloadButtonParams(this.activity.getResources().getConfiguration().orientation));
        }
    }

    private void addViewBelow(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65548, this, view, i2, i3) == null) {
            addViewBelow(view, i2, 0, i3, 0, 0);
        }
    }

    private RelativeLayout getContentView(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, activity)) == null) {
            if (activity != null) {
                RelativeLayout relativeLayout = new RelativeLayout(activity);
                relativeLayout.setBackgroundColor(0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(-1);
                float dip2px = CommonUtils.dip2px(activity, 23.0f);
                gradientDrawable.setCornerRadii(new float[]{dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f});
                relativeLayout.setBackgroundDrawable(gradientDrawable);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                return relativeLayout;
            }
            return null;
        }
        return (RelativeLayout) invokeL.objValue;
    }

    private RelativeLayout.LayoutParams getDownloadButtonParams(int i2) {
        InterceptResult invokeI;
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i2)) == null) {
            if (i2 == 1) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.activity, 330.0f), -2);
            }
            layoutParams.addRule(3, 1005);
            layoutParams.addRule(14);
            layoutParams.setMargins(CommonUtils.dip2px(this.activity, 20.0f), CommonUtils.dip2px(this.activity, 30.0f), CommonUtils.dip2px(this.activity, 20.0f), CommonUtils.dip2px(this.activity, 25.0f));
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNavigation(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65552, this, z) == null) || !z || Build.VERSION.SDK_INT < 19 || getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        getDialog().getWindow().getDecorView().setSystemUiVisibility(4098);
    }

    public static ConfirmDialog loadWith(Activity activity, IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, activity, iXAdInstanceInfo)) == null) {
            ConfirmDialog confirmDialog = new ConfirmDialog();
            confirmDialog.activity = activity;
            confirmDialog.adInfo = iXAdInstanceInfo;
            confirmDialog.setCancelable(false);
            return confirmDialog;
        }
        return (ConfirmDialog) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLpCloseReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, context) == null) || this.listener == null) {
            return;
        }
        this.lpCloseListener = new LpCloseListener();
        LpCloseController.getInstance(context).startListener();
        LpCloseController.getInstance(context).addEventListener("AdLpClosed", this.lpCloseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDownloadDialogLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            try {
                SendLogUtil.Builder.create(this.activity.getApplicationContext()).appendType(SDKLogTypeConstants.TYPE_DOWNLOAD_DIALOG_LOG).appendAdInfo(this.adInfo).append("reason", str).append("materialtype", this.adInfo.getMaterialType()).sendWithVd();
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().e(TAG, th.getMessage());
            }
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            setShowsDialog(false);
            super.onActivityCreated(bundle);
            setShowsDialog(true);
            if (getShowsDialog()) {
                View view = getView();
                Dialog dialog = getDialog();
                if (view != null) {
                    if (view.getParent() == null) {
                        dialog.setContentView(view);
                    } else {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
                Activity activity = getActivity();
                if (activity != null) {
                    dialog.setOwnerActivity(activity);
                }
                dialog.setCancelable(isCancelable());
                if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                    return;
                }
                dialog.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        RoundRectButton roundRectButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            Dialog dialog = getDialog();
            if (configuration == null || dialog == null || dialog.getWindow() == null || (roundRectButton = this.downloadButton) == null) {
                return;
            }
            roundRectButton.setLayoutParams(getDownloadButtonParams(configuration.orientation));
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setStyle(1, 0);
            OnConfirmListener onConfirmListener = this.listener;
            if (onConfirmListener != null) {
                onConfirmListener.onDialogShow();
            }
            sendDownloadDialogLog("download_dialog_open");
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            Activity activity = this.activity;
            if (activity != null) {
                RelativeLayout contentView = getContentView(activity);
                this.contentView = contentView;
                if (contentView != null) {
                    addCloseButton();
                    addAppIcon();
                    addAppDesc();
                    addDownloadButton();
                }
            }
            return this.contentView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetach();
            OnConfirmListener onConfirmListener = this.listener;
            if (onConfirmListener != null) {
                onConfirmListener.onDialogClose();
            }
            Activity activity = this.activity;
            if (activity == null || this.lpCloseListener == null) {
                return;
            }
            LpCloseController.getInstance(activity.getApplicationContext()).stopListener();
            this.lpCloseListener = null;
            this.listener = null;
            this.activity = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Dialog dialog = getDialog();
            if (dialog != null && dialog.getWindow() != null) {
                Window window = dialog.getWindow();
                hideNavigation(this.hideNavigation);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(0);
                window.setBackgroundDrawable(gradientDrawable);
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 80;
                window.setAttributes(attributes);
            }
            super.onStart();
        }
    }

    public ConfirmDialog setConfirmListener(OnConfirmListener onConfirmListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, onConfirmListener)) == null) {
            this.listener = onConfirmListener;
            return this;
        }
        return (ConfirmDialog) invokeL.objValue;
    }

    public ConfirmDialog setHideNavigation(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.hideNavigation = z;
            return this;
        }
        return (ConfirmDialog) invokeZ.objValue;
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Activity activity = this.activity;
            if (activity != null && this.adInfo != null) {
                FragmentManager fragmentManager = activity.getFragmentManager();
                if (fragmentManager != null) {
                    show(fragmentManager, FRAG_TAG);
                    return;
                }
                return;
            }
            RemoteXAdLogger.getInstance().e("Confirm dialog initialize failed.");
        }
    }

    private void addViewBelow(View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, i2);
            layoutParams.addRule(14);
            View findViewById = this.contentView.findViewById(i2);
            if (findViewById != null && findViewById.getVisibility() == 8) {
                i4 = 36;
            }
            layoutParams.setMargins(CommonUtils.dip2px(this.activity, i3), CommonUtils.dip2px(this.activity, i4), CommonUtils.dip2px(this.activity, i5), CommonUtils.dip2px(this.activity, i6));
            this.contentView.addView(view, layoutParams);
        }
    }
}
