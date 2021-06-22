package com.baidu.swan.apps.res.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import d.a.m0.a.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.f;
import d.a.m0.a.v2.q0;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    public static final boolean DEBUG = k.f46983a;
    public static final String KEY_FOR_BUILDER = "BOX_ACTIVITY_DIALOG_FOR_BUILDER";
    public static final String KEY_FROM = "BOX_ACTIVITY_DIALOG_FROM";
    public static final String KEY_NIGHT_MODE = "BOX_ACTIVITY_DIALOG_NIGHT_MODE";
    public static final String TAG = "BaseActivityDialog";
    public int mBtnHeight;
    public LinearLayout mBtnPanelLayout;
    public e mBuilder;
    public FrameLayout mDialogContent;
    public RelativeLayout mDialogLayout;
    public View mDivider2;
    public View mDivider3;
    public View mDivider4;
    public ImageView mIcon;
    public TextView mMessage;
    public LinearLayout mMessageContent;
    public TextView mNegativeButton;
    public TextView mNeutralButton;
    public TextView mPositiveButton;
    public SwanAppScrollView mScrollView;
    public TextView mTitle;

    /* loaded from: classes3.dex */
    public class a implements Action<e.c> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        /* renamed from: a */
        public void call(e.c cVar) {
            BaseActivityDialog.this.mBuilder.onEvent(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Action<e.b> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        /* renamed from: a */
        public void call(e.b bVar) {
            if (bVar.f11382a == BaseActivityDialog.this.mBuilder.r) {
                BaseActivityDialog.this.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivityDialog.this.onButtonClick(-1);
            BdEventBus.Companion.getDefault().post(new e.c(BaseActivityDialog.this, -1));
            BaseActivityDialog.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivityDialog.this.onButtonClick(-2);
            BaseActivityDialog.this.dismiss();
            BdEventBus.Companion.getDefault().post(new e.c(BaseActivityDialog.this, -2));
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static volatile HashMap<String, e> t = new HashMap<>();
        public static ArrayList u = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        public String f11371a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f11372b;

        /* renamed from: c  reason: collision with root package name */
        public String f11373c;

        /* renamed from: d  reason: collision with root package name */
        public String f11374d;

        /* renamed from: e  reason: collision with root package name */
        public View f11375e;

        /* renamed from: f  reason: collision with root package name */
        public Drawable f11376f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f11377g;

        /* renamed from: h  reason: collision with root package name */
        public int f11378h;

        /* renamed from: i  reason: collision with root package name */
        public Bundle f11379i;
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
            public final /* synthetic */ boolean f11380e;

            public a(boolean z) {
                this.f11380e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context appContext = AppRuntime.getAppContext();
                if (e.this.o == null) {
                    e.this.o = BaseActivityDialog.class;
                }
                Intent intent = new Intent(appContext, e.this.o);
                intent.putExtra(BaseActivityDialog.KEY_NIGHT_MODE, this.f11380e);
                String valueOf = String.valueOf(intent.hashCode());
                intent.putExtra(BaseActivityDialog.KEY_FOR_BUILDER, valueOf);
                if (!TextUtils.isEmpty(e.this.q)) {
                    intent.putExtra(BaseActivityDialog.KEY_FROM, e.this.q);
                }
                if (e.this.f11379i != null) {
                    intent.putExtras(e.this.f11379i);
                }
                e.t(valueOf, e.this);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                f.g(appContext, intent);
            }
        }

        /* loaded from: classes3.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public Object f11382a;
        }

        /* loaded from: classes3.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public DialogInterface f11383a;

            /* renamed from: b  reason: collision with root package name */
            public int f11384b;

            public c(DialogInterface dialogInterface, int i2) {
                this.f11383a = dialogInterface;
                this.f11384b = i2;
            }
        }

        public e() {
            this(BaseActivityDialog.class);
        }

        public static e r(String str) {
            e remove;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (t) {
                remove = t.remove(str);
            }
            return remove;
        }

        public static void t(String str, e eVar) {
            if (TextUtils.isEmpty(str) || eVar == null) {
                return;
            }
            synchronized (t) {
                t.put(str, eVar);
            }
        }

        public e A(String str, DialogInterface.OnClickListener onClickListener) {
            this.f11373c = str;
            this.j = onClickListener;
            return this;
        }

        public e B(int i2) {
            C(this.n.getString(i2));
            return this;
        }

        public e C(String str) {
            this.f11371a = str;
            return this;
        }

        public void D() {
            E(false);
        }

        public void E(boolean z) {
            q0.X(new a(z));
        }

        public void onEvent(c cVar) {
            if (cVar == null) {
                return;
            }
            DialogInterface.OnClickListener onClickListener = null;
            int i2 = cVar.f11384b;
            if (i2 == -2) {
                onClickListener = this.k;
            } else if (i2 == -1) {
                onClickListener = this.j;
            }
            if (onClickListener != null) {
                onClickListener.onClick(cVar.f11383a, cVar.f11384b);
            }
        }

        public void s() {
            u.remove(this.r);
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.f11375e = null;
            this.f11376f = null;
        }

        public e u(int i2) {
            v(this.n.getString(i2));
            return this;
        }

        public e v(String str) {
            this.f11372b = str;
            return this;
        }

        public e w(int i2, DialogInterface.OnClickListener onClickListener) {
            x(this.n.getString(i2), onClickListener);
            return this;
        }

        public e x(String str, DialogInterface.OnClickListener onClickListener) {
            this.f11374d = str;
            this.k = onClickListener;
            return this;
        }

        public e y(DialogInterface.OnDismissListener onDismissListener) {
            this.m = onDismissListener;
            return this;
        }

        public e z(int i2, DialogInterface.OnClickListener onClickListener) {
            A(this.n.getString(i2), onClickListener);
            return this;
        }

        public e(Class<? extends Activity> cls) {
            this.f11377g = true;
            this.p = -1;
            this.n = AppRuntime.getAppContext();
            this.o = cls;
        }
    }

    private void release() {
        if (this.mBuilder != null) {
            BdEventBus.Companion.getDefault().unregister(this.mBuilder);
            this.mBuilder.s();
            this.mBuilder = null;
        }
        setView(null);
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        e eVar = this.mBuilder;
        if (eVar != null && (onCancelListener = eVar.l) != null) {
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
        Resources b2 = d.a.m0.a.c1.a.H().b();
        return b2 != null ? b2 : super.getResources();
    }

    public TextView ifOnlyOneBtnGetIt() {
        int i2;
        TextView textView;
        TextView textView2 = this.mPositiveButton;
        if (textView2 == null || textView2.getVisibility() != 0) {
            i2 = 0;
            textView = null;
        } else {
            textView = this.mPositiveButton;
            i2 = 1;
        }
        TextView textView3 = this.mNegativeButton;
        if (textView3 != null && textView3.getVisibility() == 0) {
            i2++;
            textView = this.mNegativeButton;
        }
        TextView textView4 = this.mNeutralButton;
        if (textView4 != null && textView4.getVisibility() == 0) {
            i2++;
            textView = this.mNeutralButton;
        }
        if (i2 != 1) {
            return null;
        }
        return textView;
    }

    public void initViews() {
        this.mTitle = (TextView) findViewById(d.a.m0.a.f.dialog_title);
        this.mMessage = (TextView) findViewById(d.a.m0.a.f.dialog_message);
        this.mMessageContent = (LinearLayout) findViewById(d.a.m0.a.f.dialog_message_content);
        this.mPositiveButton = (TextView) findViewById(d.a.m0.a.f.positive_button);
        this.mNegativeButton = (TextView) findViewById(d.a.m0.a.f.negative_button);
        this.mNeutralButton = (TextView) findViewById(d.a.m0.a.f.neutral_button);
        this.mDivider3 = findViewById(d.a.m0.a.f.divider3);
        this.mDivider4 = findViewById(d.a.m0.a.f.divider4);
        this.mDialogContent = (FrameLayout) findViewById(d.a.m0.a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(d.a.m0.a.f.dialog_icon);
        this.mDialogLayout = (RelativeLayout) findViewById(d.a.m0.a.f.searchbox_alert_dialog);
        this.mDivider2 = findViewById(d.a.m0.a.f.divider2);
        this.mScrollView = (SwanAppScrollView) findViewById(d.a.m0.a.f.message_scrollview);
        this.mBtnPanelLayout = (LinearLayout) findViewById(d.a.m0.a.f.btn_panel);
        this.mBtnHeight = getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_dialog_btns_height);
        if (this.mBuilder.p > 0) {
            this.mScrollView.getLayoutParams().height = this.mBuilder.p;
        }
        if (d.a.m0.a.v2.d.k() || d.a.m0.a.v2.d.l()) {
            int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_dialog_text_padding);
            this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        onDismiss();
        super.onBackPressed();
    }

    public void onButtonClick(int i2) {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        e r = e.r(getIntent().getStringExtra(KEY_FOR_BUILDER));
        this.mBuilder = r;
        if (r == null) {
            if (DEBUG) {
                Log.e(TAG, "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        BdEventBus.Companion.getDefault().register(this.mBuilder, e.c.class, new a());
        BdEventBus.Companion.getDefault().register(this.mBuilder, e.b.class, new b());
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
        e eVar = this.mBuilder;
        if (eVar == null || (onDismissListener = eVar.m) == null) {
            return;
        }
        onDismissListener.onDismiss(this);
    }

    public void post(Runnable runnable) {
        if (runnable != null) {
            q0.X(runnable);
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
        layoutParams.addRule(3, d.a.m0.a.f.dialog_message_content);
        this.mBtnPanelLayout.setLayoutParams(layoutParams);
    }

    public void setNegativeButton(String str) {
        this.mNegativeButton.setText(str);
        this.mNegativeButton.setOnClickListener(new d());
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
        this.mPositiveButton.setOnClickListener(new c());
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

    public void setPositiveTextColor(int i2) {
        this.mPositiveButton.setTextColor(i2);
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
                layoutParams.addRule(3, d.a.m0.a.f.dialog_customPanel);
                this.mBtnPanelLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public void setupViews() {
        e eVar = this.mBuilder;
        if (eVar == null) {
            return;
        }
        setTitle(eVar.f11371a);
        setIcon(eVar.f11376f);
        setMessage(eVar.f11372b);
        setView(eVar.f11375e);
        setPositiveEnable(eVar.f11377g);
        setPositiveTextColor(eVar.f11378h);
        setPositiveButton(eVar.f11373c);
        setNegativeButton(eVar.f11374d);
        setBtnsPanlVisible(eVar.s);
    }

    public void show() {
        Resources resources = getResources();
        int color = resources.getColor(d.a.m0.a.c.aiapps_dialog_title_text_color);
        int color2 = resources.getColor(d.a.m0.a.c.aiapps_box_dialog_message_text_color);
        int color3 = resources.getColor(d.a.m0.a.c.aiapps_dialog_gray);
        this.mDialogLayout.setBackground(resources.getDrawable(d.a.m0.a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.mMessage.setTextColor(color2);
        this.mPositiveButton.setTextColor(color);
        this.mNegativeButton.setTextColor(color);
        this.mNeutralButton.setTextColor(color);
        this.mDivider2.setBackgroundColor(color3);
        this.mDivider3.setBackgroundColor(color3);
        this.mDivider4.setBackgroundColor(color3);
        this.mPositiveButton.setBackground(resources.getDrawable(d.a.m0.a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.mNegativeButton.setBackground(resources.getDrawable(d.a.m0.a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.mNeutralButton.setBackground(resources.getDrawable(d.a.m0.a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
        if (ifOnlyOneBtnGetIt != null) {
            ifOnlyOneBtnGetIt.setBackground(resources.getDrawable(d.a.m0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
        }
    }
}
