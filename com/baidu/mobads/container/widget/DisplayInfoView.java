package com.baidu.mobads.container.widget;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import com.baidu.mobads.container.landingpage.LpCloseController;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
/* loaded from: classes2.dex */
public class DisplayInfoView extends LinearLayout {
    public static final String AUTH_TEXT = "权限";
    public static final String LP_ACTIVITY_CLOSE_ACTION = "lp_close";
    public static final String PRI_TEXT = "隐私";
    public String authUrl;
    public final Context context;
    public String devText;
    public boolean hideNavigation;
    public OnDisplayListener listener;
    public IOAdEventListener lpCloseListener;
    public String priUrl;
    public double sideMarginPercent;
    public int textColor;
    public double textPercent;
    public String verText;

    /* loaded from: classes2.dex */
    public static class Builder {
        public DisplayInfoView view;

        public Builder(Context context) {
            this.view = new DisplayInfoView(context);
        }

        public Builder addContent(String str, String str2, String str3, String str4) {
            String str5 = "版本 " + str;
            if (str.indexOf("版本") == -1) {
                str = str5;
            }
            this.view.verText = str;
            this.view.devText = str2;
            this.view.priUrl = str3;
            this.view.authUrl = str4;
            return this;
        }

        public Builder addHideNavigation(boolean z) {
            this.view.hideNavigation = z;
            return this;
        }

        public Builder addListener(OnDisplayListener onDisplayListener) {
            this.view.listener = onDisplayListener;
            return this;
        }

        public Builder addSideMarginPercent(double d2) {
            this.view.sideMarginPercent = d2;
            return this;
        }

        public Builder addTextColor(int i) {
            this.view.textColor = i;
            return this;
        }

        public Builder addTextPercent(double d2) {
            this.view.textPercent = d2;
            return this;
        }

        public DisplayInfoView build() {
            return this.view;
        }
    }

    /* loaded from: classes2.dex */
    public class LpCloseListener implements IOAdEventListener {
        public LpCloseListener() {
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if ("AdLpClosed".equals(iOAdEvent.getType())) {
                if (DisplayInfoView.this.listener != null) {
                    DisplayInfoView.this.listener.onDismiss(false);
                }
                if (DisplayInfoView.this.lpCloseListener != null) {
                    DisplayInfoView.this.lpCloseListener = null;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OnDisplayListener {
        void onDismiss(boolean z);

        void onShow(boolean z);
    }

    private TextView addItem(String str) {
        TextView textView = new TextView(this.context);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        textView.setText(str);
        textView.setTextColor(this.textColor);
        textView.setTextSize(1, (int) ((this.textPercent * displayMetrics.widthPixels) / displayMetrics.density));
        addView(textView, getTextLayoutParams(this.sideMarginPercent));
        return textView;
    }

    private LinearLayout.LayoutParams getTextLayoutParams(double d2) {
        int i = (int) (d2 * getResources().getDisplayMetrics().widthPixels);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, 0, i, 0);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private void init() {
        addItem(this.verText);
        addItem(this.devText);
        addItem(PRI_TEXT).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.widget.DisplayInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(AppPriActivity.PRIVACY_LINK, DisplayInfoView.this.priUrl);
                if (DisplayInfoView.this.listener != null) {
                    DisplayInfoView.this.listener.onShow(false);
                }
                ActivityUtils.startAppPriActivity(DisplayInfoView.this.context, intent);
                DisplayInfoView displayInfoView = DisplayInfoView.this;
                displayInfoView.registerLpCloseReceiver(displayInfoView.context);
            }
        });
        addItem(AUTH_TEXT).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.widget.DisplayInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VerifyPerDialog createVerPerDialog = VerifyPerDialog.createVerPerDialog(DisplayInfoView.this.context, DisplayInfoView.this.authUrl);
                createVerPerDialog.setHideNavigation(DisplayInfoView.this.hideNavigation);
                createVerPerDialog.setOnDialogListener(new OnDialogListener() { // from class: com.baidu.mobads.container.widget.DisplayInfoView.2.1
                    @Override // com.baidu.mobads.container.widget.OnDialogListener
                    public void onDismiss() {
                        if (DisplayInfoView.this.listener != null) {
                            DisplayInfoView.this.listener.onDismiss(true);
                        }
                    }

                    @Override // com.baidu.mobads.container.widget.OnDialogListener
                    public void onShow() {
                        if (DisplayInfoView.this.listener != null) {
                            DisplayInfoView.this.listener.onShow(true);
                        }
                    }
                });
                createVerPerDialog.show();
            }
        });
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

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Context context = this.context;
        if (context == null || this.lpCloseListener == null) {
            return;
        }
        LpCloseController.getInstance(context).stopListener();
        this.lpCloseListener = null;
        this.listener = null;
    }

    public DisplayInfoView(Context context) {
        super(context);
        this.textPercent = 0.027777777777777776d;
        this.sideMarginPercent = 0.0196078431372549d;
        this.textColor = -1728053248;
        this.hideNavigation = false;
        setOrientation(0);
        this.context = context;
        removeAllViews();
    }
}
