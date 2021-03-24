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
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import d.b.g0.a.d;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.e;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    public static final boolean DEBUG = k.f45050a;
    public static final String KEY_FOR_BUILDER = "BOX_ACTIVITY_DIALOG_FOR_BUILDER";
    public static final String KEY_FROM = "BOX_ACTIVITY_DIALOG_FROM";
    public static final String KEY_NIGHT_MODE = "BOX_ACTIVITY_DIALOG_NIGHT_MODE";
    public static final String TAG = "BaseActivityDialog";
    public int mBtnHeight;
    public LinearLayout mBtnPanelLayout;
    public c mBuilder;
    public FrameLayout mDialogContent;
    public RelativeLayout mDialogLayout;
    public View mDivider2;
    public View mDivider3;
    public View mDivider4;
    public Handler mHandler;
    public ImageView mIcon;
    public TextView mMessage;
    public LinearLayout mMessageContent;
    public TextView mNegativeButton;
    public TextView mNeutralButton;
    public TextView mPositiveButton;
    public SwanAppScrollView mScrollView;
    public TextView mTitle;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivityDialog.this.onButtonClick(-1);
            if (BaseActivityDialog.this.mBuilder != null) {
                BaseActivityDialog.this.mBuilder.onEvent(new c.b(BaseActivityDialog.this, -1));
            }
            BaseActivityDialog.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivityDialog.this.onButtonClick(-2);
            if (BaseActivityDialog.this.mBuilder != null) {
                BaseActivityDialog.this.mBuilder.onEvent(new c.b(BaseActivityDialog.this, -2));
            }
            BaseActivityDialog.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static HashMap<String, c> t = new HashMap<>();
        public static ArrayList u = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        public String f12596a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f12597b;

        /* renamed from: c  reason: collision with root package name */
        public String f12598c;

        /* renamed from: d  reason: collision with root package name */
        public String f12599d;

        /* renamed from: e  reason: collision with root package name */
        public View f12600e;

        /* renamed from: f  reason: collision with root package name */
        public Drawable f12601f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f12602g;

        /* renamed from: h  reason: collision with root package name */
        public int f12603h;
        public Bundle i;
        public DialogInterface.OnClickListener j;
        public DialogInterface.OnClickListener k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public Context n;
        public Class<? extends Activity> o;
        public int p;
        public String q;
        public Object r;
        public boolean s;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f12604e;

            public a(boolean z) {
                this.f12604e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context appContext = AppRuntime.getAppContext();
                if (c.this.o == null) {
                    c.this.o = BaseActivityDialog.class;
                }
                Intent intent = new Intent(appContext, c.this.o);
                intent.putExtra(BaseActivityDialog.KEY_NIGHT_MODE, this.f12604e);
                String valueOf = String.valueOf(intent.hashCode());
                intent.putExtra(BaseActivityDialog.KEY_FOR_BUILDER, valueOf);
                if (!TextUtils.isEmpty(c.this.q)) {
                    intent.putExtra(BaseActivityDialog.KEY_FROM, c.this.q);
                }
                if (c.this.i != null) {
                    intent.putExtras(c.this.i);
                }
                c.s(valueOf, c.this);
                intent.addFlags(268435456);
                e.f(appContext, intent);
            }
        }

        /* loaded from: classes3.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public DialogInterface f12606a;

            /* renamed from: b  reason: collision with root package name */
            public int f12607b;

            public b(DialogInterface dialogInterface, int i) {
                this.f12606a = dialogInterface;
                this.f12607b = i;
            }
        }

        public c() {
            this(BaseActivityDialog.class);
        }

        public static c q(String str) {
            c remove;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (t) {
                remove = t.remove(str);
            }
            return remove;
        }

        public static void s(String str, c cVar) {
            if (TextUtils.isEmpty(str) || cVar == null) {
                return;
            }
            synchronized (t) {
                t.put(str, cVar);
            }
        }

        public c A(int i) {
            B(this.n.getString(i));
            return this;
        }

        public c B(String str) {
            this.f12596a = str;
            return this;
        }

        public void C() {
            D(false);
        }

        public void D(boolean z) {
            new Handler(Looper.getMainLooper()).post(new a(z));
        }

        public void onEvent(b bVar) {
            if (bVar == null) {
                return;
            }
            DialogInterface.OnClickListener onClickListener = null;
            int i = bVar.f12607b;
            if (i == -2) {
                onClickListener = this.k;
            } else if (i == -1) {
                onClickListener = this.j;
            }
            if (onClickListener != null) {
                onClickListener.onClick(bVar.f12606a, bVar.f12607b);
            }
        }

        public void r() {
            u.remove(this.r);
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.f12600e = null;
            this.f12601f = null;
        }

        public c t(int i) {
            u(this.n.getString(i));
            return this;
        }

        public c u(String str) {
            this.f12597b = str;
            return this;
        }

        public c v(int i, DialogInterface.OnClickListener onClickListener) {
            w(this.n.getString(i), onClickListener);
            return this;
        }

        public c w(String str, DialogInterface.OnClickListener onClickListener) {
            this.f12599d = str;
            this.k = onClickListener;
            return this;
        }

        public c x(DialogInterface.OnDismissListener onDismissListener) {
            this.m = onDismissListener;
            return this;
        }

        public c y(int i, DialogInterface.OnClickListener onClickListener) {
            z(this.n.getString(i), onClickListener);
            return this;
        }

        public c z(String str, DialogInterface.OnClickListener onClickListener) {
            this.f12598c = str;
            this.j = onClickListener;
            return this;
        }

        public c(Class<? extends Activity> cls) {
            this.f12602g = true;
            this.p = -1;
            this.n = AppRuntime.getAppContext();
            this.o = cls;
        }
    }

    private void release() {
        c cVar = this.mBuilder;
        if (cVar != null) {
            cVar.r();
            this.mBuilder = null;
        }
        setView(null);
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        c cVar = this.mBuilder;
        if (cVar != null && (onCancelListener = cVar.l) != null) {
            onCancelListener.onCancel(this);
        }
        finish();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        onDismiss();
        finish();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources b2 = d.b.g0.a.w0.a.z().b();
        return b2 != null ? b2 : super.getResources();
    }

    public TextView ifOnlyOneBtnGetIt() {
        int i;
        TextView textView;
        TextView textView2 = this.mPositiveButton;
        if (textView2 == null || textView2.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.mPositiveButton;
            i = 1;
        }
        TextView textView3 = this.mNegativeButton;
        if (textView3 != null && textView3.getVisibility() == 0) {
            i++;
            textView = this.mNegativeButton;
        }
        TextView textView4 = this.mNeutralButton;
        if (textView4 != null && textView4.getVisibility() == 0) {
            i++;
            textView = this.mNeutralButton;
        }
        if (i != 1) {
            return null;
        }
        return textView;
    }

    public void initViews() {
        this.mTitle = (TextView) findViewById(f.dialog_title);
        this.mMessage = (TextView) findViewById(f.dialog_message);
        this.mMessageContent = (LinearLayout) findViewById(f.dialog_message_content);
        this.mPositiveButton = (TextView) findViewById(f.positive_button);
        this.mNegativeButton = (TextView) findViewById(f.negative_button);
        this.mNeutralButton = (TextView) findViewById(f.neutral_button);
        this.mDivider3 = findViewById(f.divider3);
        this.mDivider4 = findViewById(f.divider4);
        this.mDialogContent = (FrameLayout) findViewById(f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(f.dialog_icon);
        this.mDialogLayout = (RelativeLayout) findViewById(f.searchbox_alert_dialog);
        this.mDivider2 = findViewById(f.divider2);
        this.mScrollView = (SwanAppScrollView) findViewById(f.message_scrollview);
        this.mBtnPanelLayout = (LinearLayout) findViewById(f.btn_panel);
        this.mBtnHeight = getResources().getDimensionPixelSize(d.aiapps_dialog_btns_height);
        if (this.mBuilder.p > 0) {
            this.mScrollView.getLayoutParams().height = this.mBuilder.p;
        }
        if (d.b.g0.a.i2.c.k() || d.b.g0.a.i2.c.l()) {
            int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(d.aiapps_dialog_text_padding);
            this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        onDismiss();
        super.onBackPressed();
    }

    public void onButtonClick(int i) {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        c q = c.q(getIntent().getStringExtra(KEY_FOR_BUILDER));
        this.mBuilder = q;
        if (q == null) {
            if (DEBUG) {
                Log.e(TAG, "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        initViews();
        setupViews();
        show();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        release();
        super.onDestroy();
    }

    public void onDismiss() {
        DialogInterface.OnDismissListener onDismissListener;
        c cVar = this.mBuilder;
        if (cVar == null || (onDismissListener = cVar.m) == null) {
            return;
        }
        onDismissListener.onDismiss(this);
    }

    public void post(Runnable runnable) {
        if (runnable != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            this.mHandler.post(runnable);
        }
    }

    public void setBtnsPanlVisible(boolean z) {
        if (z) {
            this.mBtnPanelLayout.setVisibility(8);
            this.mDivider2.setVisibility(8);
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon.setImageDrawable(drawable);
        this.mIcon.setVisibility(drawable != null ? 0 : 8);
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage.setText(charSequence);
        this.mMessageContent.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
        layoutParams.addRule(3, f.dialog_message_content);
        this.mBtnPanelLayout.setLayoutParams(layoutParams);
    }

    public void setNegativeButton(String str) {
        this.mNegativeButton.setText(str);
        this.mNegativeButton.setOnClickListener(new b());
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

    public void setPositiveButton(String str) {
        this.mPositiveButton.setText(str);
        this.mPositiveButton.setOnClickListener(new a());
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

    public void setPositiveEnable(boolean z) {
        this.mPositiveButton.setEnabled(z);
    }

    public void setPositiveTextColor(int i) {
        this.mPositiveButton.setTextColor(i);
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void setView(View view) {
        FrameLayout frameLayout = this.mDialogContent;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            if (view != null) {
                this.mDialogContent.addView(view);
                this.mMessageContent.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, f.dialog_customPanel);
                this.mBtnPanelLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public void setupViews() {
        c cVar = this.mBuilder;
        if (cVar == null) {
            return;
        }
        setTitle(cVar.f12596a);
        setIcon(cVar.f12601f);
        setMessage(cVar.f12597b);
        setView(cVar.f12600e);
        setPositiveEnable(cVar.f12602g);
        setPositiveTextColor(cVar.f12603h);
        setPositiveButton(cVar.f12598c);
        setNegativeButton(cVar.f12599d);
        setBtnsPanlVisible(cVar.s);
    }

    public void show() {
        Resources resources = getResources();
        int color = resources.getColor(d.b.g0.a.c.aiapps_dialog_title_text_color);
        int color2 = resources.getColor(d.b.g0.a.c.aiapps_box_dialog_message_text_color);
        int color3 = resources.getColor(d.b.g0.a.c.aiapps_dialog_gray);
        this.mDialogLayout.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.mMessage.setTextColor(color2);
        this.mPositiveButton.setTextColor(color);
        this.mNegativeButton.setTextColor(color);
        this.mNeutralButton.setTextColor(color);
        this.mDivider2.setBackgroundColor(color3);
        this.mDivider3.setBackgroundColor(color3);
        this.mDivider4.setBackgroundColor(color3);
        this.mPositiveButton.setBackground(resources.getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.mNegativeButton.setBackground(resources.getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.mNeutralButton.setBackground(resources.getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
        if (ifOnlyOneBtnGetIt != null) {
            ifOnlyOneBtnGetIt.setBackground(resources.getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
        }
    }
}
