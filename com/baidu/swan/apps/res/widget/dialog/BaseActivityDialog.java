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
/* loaded from: classes8.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ImageView dtf;
    private SwanAppScrollView dtx;
    private TextView dzi;
    private LinearLayout dzj;
    private TextView dzk;
    private TextView dzl;
    private TextView dzm;
    private View dzn;
    private View dzo;
    private View dzp;
    private FrameLayout dzq;
    private RelativeLayout dzr;
    private a dzs;
    private LinearLayout dzt;
    private int dzu;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.dzs = a.rc(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.dzs == null) {
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
        if (this.dzs != null && (onCancelListener = this.dzs.dzG) != null) {
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
        if (this.dzs != null && (onDismissListener = this.dzs.dzH) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void iJ(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.dzi = (TextView) findViewById(a.f.dialog_message);
        this.dzj = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.dzk = (TextView) findViewById(a.f.positive_button);
        this.dzl = (TextView) findViewById(a.f.negative_button);
        this.dzm = (TextView) findViewById(a.f.neutral_button);
        this.dzo = findViewById(a.f.divider3);
        this.dzp = findViewById(a.f.divider4);
        this.dzq = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.dtf = (ImageView) findViewById(a.f.dialog_icon);
        this.dzr = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.dzn = findViewById(a.f.divider2);
        this.dtx = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.dzt = (LinearLayout) findViewById(a.f.btn_panel);
        this.dzu = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.dzs.dzJ > 0) {
            this.dtx.getLayoutParams().height = this.dzs.dzJ;
        }
        if (com.baidu.swan.apps.ao.c.isGingerbread() || com.baidu.swan.apps.ao.c.isGingerbreadmr1()) {
            int dimensionPixelSize = this.dzi.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.dzi.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.dzs != null) {
            a aVar = this.dzs;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            gJ(aVar.dzC);
            iK(aVar.dzD);
            qY(aVar.dzA);
            qZ(aVar.dzB);
            gK(aVar.dzK);
        }
    }

    public TextView aHt() {
        TextView textView;
        int i = 0;
        if (this.dzk == null || this.dzk.getVisibility() != 0) {
            textView = null;
        } else {
            textView = this.dzk;
            i = 1;
        }
        if (this.dzl != null && this.dzl.getVisibility() == 0) {
            i++;
            textView = this.dzl;
        }
        if (this.dzm != null && this.dzm.getVisibility() == 0) {
            i++;
            textView = this.dzm;
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
        this.dzr.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.dzi.setTextColor(color2);
        this.dzk.setTextColor(color);
        this.dzl.setTextColor(color);
        this.dzm.setTextColor(color);
        this.dzn.setBackgroundColor(color3);
        this.dzo.setBackgroundColor(color3);
        this.dzp.setBackgroundColor(color3);
        this.dzk.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.dzl.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.dzm.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView aHt = aHt();
        if (aHt != null) {
            aHt.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        }
    }

    protected void setTitle(String str) {
        this.mTitle.setText(str);
    }

    protected void setIcon(Drawable drawable) {
        this.dtf.setImageDrawable(drawable);
        this.dtf.setVisibility(drawable != null ? 0 : 8);
    }

    protected void setMessage(CharSequence charSequence) {
        this.dzi.setText(charSequence);
        this.dzj.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dzu);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.dzt.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.dzq != null) {
            this.dzq.removeAllViews();
            if (view != null) {
                this.dzq.addView(view);
                this.dzj.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dzu);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.dzt.setLayoutParams(layoutParams);
            }
        }
    }

    protected void gJ(boolean z) {
        this.dzk.setEnabled(z);
    }

    protected void iK(int i) {
        this.dzk.setTextColor(i);
    }

    protected void qY(String str) {
        this.dzk.setText(str);
        this.dzk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.iJ(-1);
                if (BaseActivityDialog.this.dzs != null) {
                    BaseActivityDialog.this.dzs.onEvent(new a.C0454a(BaseActivityDialog.this, -1));
                }
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.dzk.setVisibility(8);
            if (this.dzl.getVisibility() == 0) {
                this.dzo.setVisibility(8);
                return;
            }
            return;
        }
        this.dzk.setVisibility(0);
        if (this.dzl.getVisibility() == 0) {
            this.dzo.setVisibility(0);
        }
    }

    protected void qZ(String str) {
        this.dzl.setText(str);
        this.dzl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.iJ(-2);
                if (BaseActivityDialog.this.dzs != null) {
                    BaseActivityDialog.this.dzs.onEvent(new a.C0454a(BaseActivityDialog.this, -2));
                }
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.dzl.setVisibility(8);
            if (this.dzk.getVisibility() == 0) {
                this.dzo.setVisibility(8);
                return;
            }
            return;
        }
        this.dzl.setVisibility(0);
        if (this.dzk.getVisibility() == 0) {
            this.dzo.setVisibility(0);
        }
    }

    protected void gK(boolean z) {
        if (z) {
            this.dzt.setVisibility(8);
            this.dzn.setVisibility(8);
        }
    }

    private void release() {
        if (this.dzs != null) {
            this.dzs.release();
            this.dzs = null;
        }
        setView(null);
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static final int dzw = a.h.aiapps_dialog_negative_title_cancel;
        public static final int dzx = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> dzy = new HashMap<>();
        private static ArrayList dzz = new ArrayList();
        private View contentView;
        private String dzA;
        private String dzB;
        private boolean dzC;
        private int dzD;
        private DialogInterface.OnClickListener dzE;
        private DialogInterface.OnClickListener dzF;
        private DialogInterface.OnCancelListener dzG;
        private DialogInterface.OnDismissListener dzH;
        private Class<? extends Activity> dzI;
        private int dzJ;
        private boolean dzK;
        private Bundle extras;
        private String from;
        private Drawable icon;
        private Context mContext;
        private Object mTag;
        private CharSequence message;
        private String title;

        public a() {
            this(BaseActivityDialog.class);
        }

        public a(Class<? extends Activity> cls) {
            this.dzC = true;
            this.dzJ = -1;
            this.mContext = AppRuntime.getAppContext();
            this.dzI = cls;
        }

        public a iL(int i) {
            return ra(this.mContext.getString(i));
        }

        public a ra(String str) {
            this.title = str;
            return this;
        }

        public a iM(int i) {
            return rb(this.mContext.getString(i));
        }

        public a rb(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.dzA = str;
            this.dzE = onClickListener;
            return this;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return b(this.mContext.getString(i), onClickListener);
        }

        public a b(String str, DialogInterface.OnClickListener onClickListener) {
            this.dzB = str;
            this.dzF = onClickListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.dzH = onDismissListener;
            return this;
        }

        void release() {
            dzz.remove(this.mTag);
            this.dzE = null;
            this.dzF = null;
            this.dzG = null;
            this.dzH = null;
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
                    if (a.this.dzI == null) {
                        a.this.dzI = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.dzI);
                    intent.putExtra("BOX_ACTIVITY_DIALOG_NIGHT_MODE", z);
                    String valueOf = String.valueOf(intent.hashCode());
                    intent.putExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER", valueOf);
                    if (!TextUtils.isEmpty(a.this.from)) {
                        intent.putExtra("BOX_ACTIVITY_DIALOG_FROM", a.this.from);
                    }
                    if (a.this.extras != null) {
                        intent.putExtras(a.this.extras);
                    }
                    a.a(valueOf, a.this);
                    intent.addFlags(268435456);
                    com.baidu.swan.apps.ao.e.f(appContext, intent);
                }
            });
        }

        static a rc(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (dzy) {
                    remove = dzy.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (dzy) {
                    dzy.put(str, aVar);
                }
            }
        }

        public void onEvent(C0454a c0454a) {
            if (c0454a != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (c0454a.dzO) {
                    case -2:
                        onClickListener = this.dzF;
                        break;
                    case -1:
                        onClickListener = this.dzE;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(c0454a.dzN, c0454a.dzO);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C0454a {
            private DialogInterface dzN;
            private int dzO;

            public C0454a(DialogInterface dialogInterface, int i) {
                this.dzN = dialogInterface;
                this.dzO = i;
            }
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources ahL = com.baidu.swan.apps.t.a.awU().ahL();
        return ahL != null ? ahL : super.getResources();
    }
}
