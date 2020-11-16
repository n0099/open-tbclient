package com.baidu.swan.apps.res.widget.dialog;

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
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppScrollView dlV;
    private a dpO;
    private int mBtnHeight;
    private LinearLayout mBtnPanelLayout;
    private FrameLayout mDialogContent;
    private RelativeLayout mDialogLayout;
    private View mDivider2;
    private View mDivider3;
    private View mDivider4;
    private ImageView mIcon;
    private TextView mMessage;
    private LinearLayout mMessageContent;
    private TextView mNegativeButton;
    private TextView mNeutralButton;
    private TextView mPositiveButton;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.dpO = a.rJ(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.dpO == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        initViews();
        setupViews();
        show();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        release();
        super.onDestroy();
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        if (this.dpO != null && (onCancelListener = this.dpO.cancelListener) != null) {
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
        if (this.dpO != null && (onDismissListener = this.dpO.dismissListener) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void onButtonClick(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.mMessage = (TextView) findViewById(a.f.dialog_message);
        this.mMessageContent = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.mPositiveButton = (TextView) findViewById(a.f.positive_button);
        this.mNegativeButton = (TextView) findViewById(a.f.negative_button);
        this.mNeutralButton = (TextView) findViewById(a.f.neutral_button);
        this.mDivider3 = findViewById(a.f.divider3);
        this.mDivider4 = findViewById(a.f.divider4);
        this.mDialogContent = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(a.f.dialog_icon);
        this.mDialogLayout = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.mDivider2 = findViewById(a.f.divider2);
        this.dlV = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.mBtnPanelLayout = (LinearLayout) findViewById(a.f.btn_panel);
        this.mBtnHeight = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.dpO.mScrollViewHeight > 0) {
            this.dlV.getLayoutParams().height = this.dpO.mScrollViewHeight;
        }
        if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
            int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.dpO != null) {
            a aVar = this.dpO;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            setPositiveEnable(aVar.positiveEnabled);
            setPositiveTextColor(aVar.positiveTextColor);
            setPositiveButton(aVar.positiveText);
            setNegativeButton(aVar.negativeText);
            setBtnsPanlVisible(aVar.hideBtnsPanel);
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
        int color = resources.getColor(a.c.aiapps_dialog_title_text_color);
        int color2 = resources.getColor(a.c.aiapps_box_dialog_message_text_color);
        int color3 = resources.getColor(a.c.aiapps_dialog_gray);
        this.mDialogLayout.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.mMessage.setTextColor(color2);
        this.mPositiveButton.setTextColor(color);
        this.mNegativeButton.setTextColor(color);
        this.mNeutralButton.setTextColor(color);
        this.mDivider2.setBackgroundColor(color3);
        this.mDivider3.setBackgroundColor(color3);
        this.mDivider4.setBackgroundColor(color3);
        this.mPositiveButton.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.mNegativeButton.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.mNeutralButton.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
        if (ifOnlyOneBtnGetIt != null) {
            ifOnlyOneBtnGetIt.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.mBtnPanelLayout.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.mDialogContent != null) {
            this.mDialogContent.removeAllViews();
            if (view != null) {
                this.mDialogContent.addView(view);
                this.mMessageContent.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, a.f.dialog_customPanel);
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
        this.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.onButtonClick(-1);
                if (BaseActivityDialog.this.dpO != null) {
                    BaseActivityDialog.this.dpO.onEvent(new a.C0466a(BaseActivityDialog.this, -1));
                }
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
        this.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.onButtonClick(-2);
                if (BaseActivityDialog.this.dpO != null) {
                    BaseActivityDialog.this.dpO.onEvent(new a.C0466a(BaseActivityDialog.this, -2));
                }
                BaseActivityDialog.this.dismiss();
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

    private void release() {
        if (this.dpO != null) {
            this.dpO.release();
            this.dpO = null;
        }
        setView(null);
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = a.h.aiapps_dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> sBuilderMap = new HashMap<>();
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

        public a() {
            this(BaseActivityDialog.class);
        }

        public a(Class<? extends Activity> cls) {
            this.positiveEnabled = true;
            this.mScrollViewHeight = -1;
            this.mContext = AppRuntime.getAppContext();
            this.mDialogClass = cls;
        }

        public a jQ(int i) {
            return rH(this.mContext.getString(i));
        }

        public a rH(String str) {
            this.title = str;
            return this;
        }

        public a jR(int i) {
            return rI(this.mContext.getString(i));
        }

        public a rI(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.positiveText = str;
            this.positiveListener = onClickListener;
            return this;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return b(this.mContext.getString(i), onClickListener);
        }

        public a b(String str, DialogInterface.OnClickListener onClickListener) {
            this.negativeText = str;
            this.negativeListener = onClickListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
            return this;
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.a.1
                @Override // java.lang.Runnable
                public void run() {
                    Context appContext = AppRuntime.getAppContext();
                    if (a.this.mDialogClass == null) {
                        a.this.mDialogClass = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.mDialogClass);
                    intent.putExtra("BOX_ACTIVITY_DIALOG_NIGHT_MODE", z);
                    String valueOf = String.valueOf(intent.hashCode());
                    intent.putExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER", valueOf);
                    if (!TextUtils.isEmpty(a.this.from)) {
                        intent.putExtra(com.baidu.android.ext.widget.dialog.BaseActivityDialog.KEY_FROM, a.this.from);
                    }
                    if (a.this.extras != null) {
                        intent.putExtras(a.this.extras);
                    }
                    a.a(valueOf, a.this);
                    intent.addFlags(268435456);
                    com.baidu.swan.apps.ap.e.startActivitySafely(appContext, intent);
                }
            });
        }

        static a rJ(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (sBuilderMap) {
                    remove = sBuilderMap.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (sBuilderMap) {
                    sBuilderMap.put(str, aVar);
                }
            }
        }

        public void onEvent(C0466a c0466a) {
            if (c0466a != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (c0466a.which) {
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
                onClickListener.onClick(c0466a.dialog, c0466a.which);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0466a {
            private DialogInterface dialog;
            private int which;

            public C0466a(DialogInterface dialogInterface, int i) {
                this.dialog = dialogInterface;
                this.which = i;
            }
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources skinResources = com.baidu.swan.apps.t.a.awo().getSkinResources();
        return skinResources != null ? skinResources : super.getResources();
    }
}
