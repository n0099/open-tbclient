package com.baidu.android.ext.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.a.a.a;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.ioc.SkinResourcesRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import rx.functions.b;
/* loaded from: classes14.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    private static final boolean DEBUG = false;
    private static final String KEY_FOR_BUILDER = "BOX_ACTIVITY_DIALOG_FOR_BUILDER";
    public static final String KEY_FROM = "BOX_ACTIVITY_DIALOG_FROM";
    private static final String KEY_NIGHT_MODE = "BOX_ACTIVITY_DIALOG_NIGHT_MODE";
    private static final String TAG = "BaseActivityDialog";
    private int mBtnHeight;
    private LinearLayout mBtnPanelLayout;
    private Builder mBuilder;
    private FrameLayout mDialogContent;
    protected RelativeLayout mDialogLayout;
    private View mDivider2;
    private View mDivider3;
    private View mDivider4;
    private Handler mHandler;
    private ImageView mIcon;
    private TextView mMessage;
    private LinearLayout mMessageContent;
    private TextView mNegativeButton;
    private TextView mNeutralButton;
    private TextView mPositiveButton;
    private BoxScrollView mScrollView;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = a.releaseFixedOrientation(this);
        super.onCreate(bundle);
        a.fixedOrientation(this, releaseFixedOrientation);
        setContentView(R.layout.searchbox_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.mBuilder = Builder.getBuilder(getIntent().getStringExtra(KEY_FOR_BUILDER));
        if (this.mBuilder == null) {
            finish();
            return;
        }
        EventBusWrapper.register(this.mBuilder, Builder.EventObject.class, new b<Builder.EventObject>() { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Builder.EventObject eventObject) {
                BaseActivityDialog.this.mBuilder.onEvent(eventObject);
            }
        });
        EventBusWrapper.register(this.mBuilder, Builder.DismissEventObject.class, new b<Builder.DismissEventObject>() { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Builder.DismissEventObject dismissEventObject) {
                if (dismissEventObject.tag == BaseActivityDialog.this.mBuilder.mTag) {
                    BaseActivityDialog.this.dismiss();
                }
            }
        });
        initViews();
        setupViews();
        show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        release();
        super.onDestroy();
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        if (this.mBuilder != null && (onCancelListener = this.mBuilder.cancelListener) != null) {
            onCancelListener.onCancel(this);
        }
        finish();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        onDismiss();
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        onDismiss();
        super.onBackPressed();
    }

    protected void onDismiss() {
        DialogInterface.OnDismissListener onDismissListener;
        if (this.mBuilder != null && (onDismissListener = this.mBuilder.dismissListener) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void onButtonClick(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(R.id.dialog_title);
        this.mMessage = (TextView) findViewById(R.id.dialog_message);
        this.mMessageContent = (LinearLayout) findViewById(R.id.dialog_message_content);
        this.mPositiveButton = (TextView) findViewById(R.id.positive_button);
        this.mNegativeButton = (TextView) findViewById(R.id.negative_button);
        this.mNeutralButton = (TextView) findViewById(R.id.neutral_button);
        this.mDivider3 = findViewById(R.id.divider3);
        this.mDivider4 = findViewById(R.id.divider4);
        this.mDialogContent = (FrameLayout) findViewById(R.id.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(R.id.dialog_icon);
        this.mDialogLayout = (RelativeLayout) findViewById(R.id.searchbox_alert_dialog);
        this.mDivider2 = findViewById(R.id.divider2);
        this.mScrollView = (BoxScrollView) findViewById(R.id.message_scrollview);
        this.mBtnPanelLayout = (LinearLayout) findViewById(R.id.btn_panel);
        this.mBtnHeight = getResources().getDimensionPixelSize(R.dimen.dialog_btns_height);
        if (this.mBuilder.mScrollViewHeight > 0) {
            this.mScrollView.getLayoutParams().height = this.mBuilder.mScrollViewHeight;
        }
        if (DeviceUtil.OSInfo.isGingerbread() || DeviceUtil.OSInfo.isGingerbreadmr1()) {
            int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(R.dimen.dialog_text_padding);
            this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.mBuilder != null) {
            Builder builder = this.mBuilder;
            setTitle(builder.title);
            setIcon(builder.icon);
            setMessage(builder.message);
            setView(builder.contentView);
            setPositiveEnable(builder.positiveEnabled);
            setPositiveTextColor(builder.positiveTextColor);
            setPositiveButton(builder.positiveText);
            setNegativeButton(builder.negativeText);
            setBtnsPanlVisible(builder.hideBtnsPanel);
        }
    }

    public TextView ifOnlyOneBtnGetIt() {
        int i;
        TextView textView;
        if (this.mPositiveButton == null || this.mPositiveButton.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.mPositiveButton;
            i = 1;
        }
        if (this.mNegativeButton != null && this.mNegativeButton.getVisibility() == 0) {
            i++;
            textView = this.mNegativeButton;
        }
        if (this.mNeutralButton != null && this.mNeutralButton.getVisibility() == 0) {
            i++;
            textView = this.mNeutralButton;
        }
        if (i != 1) {
            return null;
        }
        return textView;
    }

    protected void show() {
        Resources resources = getResources();
        int color = resources.getColor(R.color.dialog_title_text_color);
        int color2 = resources.getColor(R.color.box_dialog_message_text_color);
        int color3 = resources.getColor(R.color.dialog_gray);
        this.mDialogLayout.setBackground(resources.getDrawable(R.drawable.dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.mMessage.setTextColor(color2);
        this.mPositiveButton.setTextColor(color);
        this.mNegativeButton.setTextColor(color);
        this.mNeutralButton.setTextColor(color);
        this.mDivider2.setBackgroundColor(color3);
        this.mDivider3.setBackgroundColor(color3);
        this.mDivider4.setBackgroundColor(color3);
        this.mPositiveButton.setBackground(resources.getDrawable(R.drawable.alertdialog_button_day_bg_right_selector));
        this.mNegativeButton.setBackground(resources.getDrawable(R.drawable.alertdialog_button_day_bg_left_selector));
        this.mNeutralButton.setBackground(resources.getDrawable(R.drawable.alertdialog_button_day_bg_selector));
        TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
        if (ifOnlyOneBtnGetIt != null) {
            ifOnlyOneBtnGetIt.setBackground(resources.getDrawable(R.drawable.alertdialog_button_day_bg_all_selector));
        }
    }

    protected void setTitle(String str) {
        this.mTitle.setText(str);
    }

    protected void setIcon(Drawable drawable) {
        this.mIcon.setImageDrawable(drawable);
        this.mIcon.setVisibility(drawable != null ? 0 : 8);
    }

    protected void setMessage(CharSequence charSequence) {
        this.mMessage.setText(charSequence);
        this.mMessageContent.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
        layoutParams.addRule(3, R.id.dialog_message_content);
        this.mBtnPanelLayout.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.mDialogContent != null) {
            this.mDialogContent.removeAllViews();
            if (view != null) {
                this.mDialogContent.addView(view);
                this.mMessageContent.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, R.id.dialog_customPanel);
                this.mBtnPanelLayout.setLayoutParams(layoutParams);
            }
        }
    }

    protected void setPositiveEnable(boolean z) {
        this.mPositiveButton.setEnabled(z);
    }

    protected void setPositiveTextColor(int i) {
        this.mPositiveButton.setTextColor(i);
    }

    protected void setPositiveButton(String str) {
        this.mPositiveButton.setText(str);
        this.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.onButtonClick(-1);
                EventBusWrapper.post(new Builder.EventObject(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.mPositiveButton.setVisibility(8);
            if (this.mNegativeButton.getVisibility() == 0) {
                this.mDivider3.setVisibility(8);
                return;
            }
            return;
        }
        this.mPositiveButton.setVisibility(0);
        if (this.mNegativeButton.getVisibility() == 0) {
            this.mDivider3.setVisibility(0);
        }
    }

    protected void setNegativeButton(String str) {
        this.mNegativeButton.setText(str);
        this.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.onButtonClick(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new Builder.EventObject(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.mNegativeButton.setVisibility(8);
            if (this.mPositiveButton.getVisibility() == 0) {
                this.mDivider3.setVisibility(8);
                return;
            }
            return;
        }
        this.mNegativeButton.setVisibility(0);
        if (this.mPositiveButton.getVisibility() == 0) {
            this.mDivider3.setVisibility(0);
        }
    }

    protected void setBtnsPanlVisible(boolean z) {
        if (z) {
            this.mBtnPanelLayout.setVisibility(8);
            this.mDivider2.setVisibility(8);
        }
    }

    protected void post(Runnable runnable) {
        if (runnable != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            this.mHandler.post(runnable);
        }
    }

    private void release() {
        if (this.mBuilder != null) {
            EventBusWrapper.unregister(this.mBuilder);
            this.mBuilder.release();
            this.mBuilder = null;
        }
        setView(null);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources skinResources = SkinResourcesRuntime.getSkinResourceContext().getSkinResources();
        return skinResources != null ? skinResources : super.getResources();
    }

    /* loaded from: classes14.dex */
    public static class Builder {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = R.string.dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = R.string.dialog_positive_title_ok;
        private static HashMap<String, Builder> sBuilderMap = new HashMap<>();
        private static ArrayList sDialogList = new ArrayList();
        private DialogInterface.OnCancelListener cancelListener;
        private View contentView;
        private DialogInterface.OnDismissListener dismissListener;
        private Bundle extras;
        private String from;
        private boolean hideBtnsPanel;
        private Drawable icon;
        private Context mContext;
        private Class<? extends Activity> mDialogClass;
        private int mScrollViewHeight;
        private Object mTag;
        private CharSequence message;
        private DialogInterface.OnClickListener negativeListener;
        private String negativeText;
        private boolean positiveEnabled;
        private DialogInterface.OnClickListener positiveListener;
        private String positiveText;
        private int positiveTextColor;
        private String title;

        public Builder() {
            this(BaseActivityDialog.class);
        }

        public Builder(Class<? extends Activity> cls) {
            this.positiveEnabled = true;
            this.mScrollViewHeight = -1;
            if (this.mContext == null) {
                this.mContext = AppRuntime.getAppContext();
            }
            this.mDialogClass = cls;
        }

        static Builder getBuilder(String str) {
            Builder remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (sBuilderMap) {
                    remove = sBuilderMap.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void setBuilder(String str, Builder builder) {
            if (!TextUtils.isEmpty(str) && builder != null) {
                synchronized (sBuilderMap) {
                    sBuilderMap.put(str, builder);
                }
            }
        }

        public Builder setTitle(int i) {
            return setTitle(this.mContext.getString(i));
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setMessage(int i) {
            return setMessage(this.mContext.getString(i));
        }

        public Builder setMessage(CharSequence charSequence) {
            this.message = charSequence;
            return this;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setMessageHeight(int i) {
            this.mScrollViewHeight = i;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            return setPositiveButton(this.mContext.getString(i), onClickListener);
        }

        public Builder setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
            this.positiveText = str;
            this.positiveListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            return setNegativeButton(this.mContext.getString(i), onClickListener);
        }

        public Builder setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
            this.negativeText = str;
            this.negativeListener = onClickListener;
            return this;
        }

        public Builder setIcon(int i) {
            return setIcon(this.mContext.getResources().getDrawable(i));
        }

        public Builder setIcon(Drawable drawable) {
            this.icon = drawable;
            return this;
        }

        public Builder setView(View view) {
            this.contentView = view;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.contentView = view;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.cancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
            return this;
        }

        public Builder setPositiveEnabled(boolean z) {
            this.positiveEnabled = z;
            return this;
        }

        public Builder setPositiveTextColor(int i) {
            this.positiveTextColor = i;
            return this;
        }

        public Builder setBundle(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setFrom(String str) {
            this.from = str;
            return this;
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public void setTag(Object obj) {
            this.mTag = obj;
            sDialogList.add(this.mTag);
        }

        public void setHideBtnsPanel(boolean z) {
            this.hideBtnsPanel = z;
        }

        public boolean isShowing(Object obj) {
            return sDialogList.contains(obj);
        }

        void release() {
            sDialogList.remove(this.mTag);
            this.positiveListener = null;
            this.negativeListener = null;
            this.cancelListener = null;
            this.dismissListener = null;
            this.contentView = null;
            this.icon = null;
        }

        public void show() {
            show(false);
        }

        public void show(final boolean z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.Builder.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Builder.this.mContext == null) {
                        Builder.this.mContext = AppRuntime.getAppContext();
                    }
                    if (Builder.this.mDialogClass == null) {
                        Builder.this.mDialogClass = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(Builder.this.mContext, Builder.this.mDialogClass);
                    intent.putExtra(BaseActivityDialog.KEY_NIGHT_MODE, z);
                    String valueOf = String.valueOf(intent.hashCode());
                    intent.putExtra(BaseActivityDialog.KEY_FOR_BUILDER, valueOf);
                    if (!TextUtils.isEmpty(Builder.this.from)) {
                        intent.putExtra(BaseActivityDialog.KEY_FROM, Builder.this.from);
                    }
                    if (Builder.this.extras != null) {
                        intent.putExtras(Builder.this.extras);
                    }
                    Builder.setBuilder(valueOf, Builder.this);
                    intent.addFlags(268435456);
                    try {
                        ActivityUtils.startActivitySafely(Builder.this.mContext, intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public void onEvent(EventObject eventObject) {
            if (eventObject != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (eventObject.which) {
                    case -2:
                        onClickListener = this.negativeListener;
                        break;
                    case -1:
                        onClickListener = this.positiveListener;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(eventObject.dialog, eventObject.which);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes14.dex */
        public static class EventObject {
            private DialogInterface dialog;
            private int which;

            public EventObject(DialogInterface dialogInterface, int i) {
                this.dialog = dialogInterface;
                this.which = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes14.dex */
        public static class DismissEventObject {
            private Object tag;

            public DismissEventObject(Object obj) {
                this.tag = obj;
            }
        }
    }
}
