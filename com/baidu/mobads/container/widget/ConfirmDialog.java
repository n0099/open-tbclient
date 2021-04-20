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
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ConfirmDialog extends DialogFragment {
    public static final int APP_DESC_COLOR_DEFAULT = -6710887;
    public static final int APP_NAME_COLOR_DEFAULT = -14737633;
    public static final int BACKGROUND_COLOR_DEFAULT = -1;
    public static final int CORNER_RADIUS_DEFAULT = 23;
    public static final String FRAG_TAG = "union_download_confirm_dialog";
    public static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    public static final String TAG = ConfirmDialog.class.getSimpleName();
    public static final int VIEW_ID_APP_ICON = 1001;
    public static final int VIEW_ID_APP_NAME = 1002;
    public static final int VIEW_ID_APP_PERMISSION_PRIVACY = 1005;
    public static final int VIEW_ID_APP_PUBLISHER = 1004;
    public static final int VIEW_ID_APP_VERSION = 1003;
    public Activity activity;
    public IXAdInstanceInfo adInfo;
    public RelativeLayout contentView;
    public RoundRectButton downloadButton;
    public boolean hideNavigation = false;
    public OnConfirmListener listener;
    public IOAdEventListener lpCloseListener;

    /* loaded from: classes2.dex */
    public class LpCloseListener implements IOAdEventListener {
        public LpCloseListener() {
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (!"AdLpClosed".equals(iOAdEvent.getType()) || ConfirmDialog.this.listener == null) {
                return;
            }
            ConfirmDialog.this.listener.onPrivacyClose();
        }
    }

    /* loaded from: classes2.dex */
    public interface OnConfirmListener {
        void onAdClick();

        void onDialogClose();

        void onDialogShow();

        void onPermissionClose();

        void onPermissionShow();

        void onPrivacyClick();

        void onPrivacyClose();
    }

    private void addAppDesc() {
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
            final String optString3 = originJsonObject.optString(AppPriActivity.PRIVACY_LINK);
            if (!TextUtils.isEmpty(optString3)) {
                textView3.setText(DisplayInfoView.PRI_TEXT);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.widget.ConfirmDialog.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ConfirmDialog.this.sendDownloadDialogLog("click_button_privacy");
                        Intent intent = new Intent();
                        intent.putExtra(AppPriActivity.PRIVACY_LINK, optString3);
                        if (ConfirmDialog.this.listener != null) {
                            ConfirmDialog.this.listener.onPrivacyClick();
                        }
                        ActivityUtils.startAppPriActivity(ConfirmDialog.this.activity, intent);
                        ConfirmDialog confirmDialog = ConfirmDialog.this;
                        confirmDialog.registerLpCloseReceiver(confirmDialog.activity);
                    }
                });
            } else {
                textView3.setVisibility(8);
            }
            final String optString4 = originJsonObject.optString("permission_link");
            if (!TextUtils.isEmpty(optString4)) {
                textView4.setText(DisplayInfoView.AUTH_TEXT);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.widget.ConfirmDialog.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ConfirmDialog.this.sendDownloadDialogLog("click_button_permission");
                        VerifyPerDialog createVerPerDialog = VerifyPerDialog.createVerPerDialog(ConfirmDialog.this.activity, optString4);
                        createVerPerDialog.setHideNavigation(ConfirmDialog.this.hideNavigation);
                        createVerPerDialog.setOnDialogListener(new OnDialogListener() { // from class: com.baidu.mobads.container.widget.ConfirmDialog.3.1
                            @Override // com.baidu.mobads.container.widget.OnDialogListener
                            public void onDismiss() {
                                if (ConfirmDialog.this.listener != null) {
                                    ConfirmDialog.this.listener.onPermissionClose();
                                }
                                ConfirmDialog confirmDialog = ConfirmDialog.this;
                                confirmDialog.hideNavigation(confirmDialog.hideNavigation);
                            }

                            @Override // com.baidu.mobads.container.widget.OnDialogListener
                            public void onShow() {
                                if (ConfirmDialog.this.listener != null) {
                                    ConfirmDialog.this.listener.onPermissionShow();
                                }
                            }
                        });
                        createVerPerDialog.show();
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

    private void addAppIcon() {
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

    private void addCloseButton() {
        ImageView imageView = new ImageView(this.activity);
        imageView.setClickable(true);
        byte[] decode = Base64.decode(StaticPicUtils.DELETE_BTN, 0);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.widget.ConfirmDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConfirmDialog.this.sendDownloadDialogLog("click_button_close");
                ConfirmDialog.this.dismiss();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.activity, 20.0f), CommonUtils.dip2px(this.activity, 20.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, CommonUtils.dip2px(this.activity, 15.0f), CommonUtils.dip2px(this.activity, 15.0f), 0);
        this.contentView.addView(imageView, layoutParams);
    }

    private void addDownloadButton() {
        RoundRectButton create = new RoundRectButton.Builder().setBtnTextMsg("立即下载").setBtnTextSizeSp(17).setLeftTopCorner(200).setLeftBottomCorner(200).setRightTopCorner(200).setRightBottomCorner(200).setBtnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.widget.ConfirmDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConfirmDialog.this.sendDownloadDialogLog("click_button_download");
                if (ConfirmDialog.this.listener != null) {
                    ConfirmDialog.this.listener.onAdClick();
                }
                ConfirmDialog.this.dismiss();
            }
        }).create(this.activity);
        this.downloadButton = create;
        create.setSingleLine();
        RoundRectButton roundRectButton = this.downloadButton;
        roundRectButton.setPadding(roundRectButton.getPaddingLeft(), this.downloadButton.getPaddingTop() + CommonUtils.dip2px(this.activity, 12.0f), this.downloadButton.getPaddingRight(), this.downloadButton.getPaddingBottom() + CommonUtils.dip2px(this.activity, 12.0f));
        this.contentView.addView(this.downloadButton, getDownloadButtonParams(this.activity.getResources().getConfiguration().orientation));
    }

    private void addViewBelow(View view, int i, int i2) {
        addViewBelow(view, i, 0, i2, 0, 0);
    }

    private RelativeLayout getContentView(Activity activity) {
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

    private RelativeLayout.LayoutParams getDownloadButtonParams(int i) {
        RelativeLayout.LayoutParams layoutParams;
        if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.activity, 330.0f), -2);
        }
        layoutParams.addRule(3, 1005);
        layoutParams.addRule(14);
        layoutParams.setMargins(CommonUtils.dip2px(this.activity, 20.0f), CommonUtils.dip2px(this.activity, 30.0f), CommonUtils.dip2px(this.activity, 20.0f), CommonUtils.dip2px(this.activity, 25.0f));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNavigation(boolean z) {
        if (!z || Build.VERSION.SDK_INT < 19 || getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        getDialog().getWindow().getDecorView().setSystemUiVisibility(4098);
    }

    public static ConfirmDialog loadWith(Activity activity, IXAdInstanceInfo iXAdInstanceInfo) {
        ConfirmDialog confirmDialog = new ConfirmDialog();
        confirmDialog.activity = activity;
        confirmDialog.adInfo = iXAdInstanceInfo;
        confirmDialog.setCancelable(false);
        return confirmDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLpCloseReceiver(Context context) {
        if (this.listener == null) {
            return;
        }
        this.lpCloseListener = new LpCloseListener();
        LpCloseController.getInstance(context).startListener();
        LpCloseController.getInstance(context).addEventListener("AdLpClosed", this.lpCloseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDownloadDialogLog(String str) {
        try {
            SendLogUtil.Builder.create(this.activity.getApplicationContext()).appendType(SDKLogTypeConstants.TYPE_DOWNLOAD_DIALOG_LOG).appendAdInfo(this.adInfo).append("reason", str).append("materialtype", this.adInfo.getMaterialType()).sendWithVd();
        } catch (Throwable th) {
            RemoteXAdLogger.getInstance().e(TAG, th.getMessage());
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
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

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        RoundRectButton roundRectButton;
        super.onConfigurationChanged(configuration);
        Dialog dialog = getDialog();
        if (configuration == null || dialog == null || dialog.getWindow() == null || (roundRectButton = this.downloadButton) == null) {
            return;
        }
        roundRectButton.setLayoutParams(getDownloadButtonParams(configuration.orientation));
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
        OnConfirmListener onConfirmListener = this.listener;
        if (onConfirmListener != null) {
            onConfirmListener.onDialogShow();
        }
        sendDownloadDialogLog("download_dialog_open");
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
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

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
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

    public ConfirmDialog setConfirmListener(OnConfirmListener onConfirmListener) {
        this.listener = onConfirmListener;
        return this;
    }

    public ConfirmDialog setHideNavigation(boolean z) {
        this.hideNavigation = z;
        return this;
    }

    public void show() {
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

    private void addViewBelow(View view, int i, int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, i);
        layoutParams.addRule(14);
        View findViewById = this.contentView.findViewById(i);
        if (findViewById != null && findViewById.getVisibility() == 8) {
            i3 = 36;
        }
        layoutParams.setMargins(CommonUtils.dip2px(this.activity, i2), CommonUtils.dip2px(this.activity, i3), CommonUtils.dip2px(this.activity, i4), CommonUtils.dip2px(this.activity, i5));
        this.contentView.addView(view, layoutParams);
    }
}
