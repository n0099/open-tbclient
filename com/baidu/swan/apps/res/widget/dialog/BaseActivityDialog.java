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
/* loaded from: classes9.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView dDU;
    private LinearLayout dDV;
    private TextView dDW;
    private TextView dDX;
    private TextView dDY;
    private View dDZ;
    private View dEa;
    private View dEb;
    private FrameLayout dEc;
    private RelativeLayout dEd;
    private a dEe;
    private LinearLayout dEf;
    private int dEg;
    private ImageView dxS;
    private SwanAppScrollView dyj;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.dEe = a.sn(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.dEe == null) {
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
        if (this.dEe != null && (onCancelListener = this.dEe.dEs) != null) {
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
        if (this.dEe != null && (onDismissListener = this.dEe.dEt) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void kp(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.dDU = (TextView) findViewById(a.f.dialog_message);
        this.dDV = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.dDW = (TextView) findViewById(a.f.positive_button);
        this.dDX = (TextView) findViewById(a.f.negative_button);
        this.dDY = (TextView) findViewById(a.f.neutral_button);
        this.dEa = findViewById(a.f.divider3);
        this.dEb = findViewById(a.f.divider4);
        this.dEc = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.dxS = (ImageView) findViewById(a.f.dialog_icon);
        this.dEd = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.dDZ = findViewById(a.f.divider2);
        this.dyj = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.dEf = (LinearLayout) findViewById(a.f.btn_panel);
        this.dEg = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.dEe.dEv > 0) {
            this.dyj.getLayoutParams().height = this.dEe.dEv;
        }
        if (com.baidu.swan.apps.ao.c.isGingerbread() || com.baidu.swan.apps.ao.c.isGingerbreadmr1()) {
            int dimensionPixelSize = this.dDU.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.dDU.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.dEe != null) {
            a aVar = this.dEe;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            gN(aVar.dEo);
            kq(aVar.dEp);
            sj(aVar.dEm);
            sk(aVar.dEn);
            gO(aVar.dEw);
        }
    }

    public TextView aLm() {
        TextView textView;
        int i = 0;
        if (this.dDW == null || this.dDW.getVisibility() != 0) {
            textView = null;
        } else {
            textView = this.dDW;
            i = 1;
        }
        if (this.dDX != null && this.dDX.getVisibility() == 0) {
            i++;
            textView = this.dDX;
        }
        if (this.dDY != null && this.dDY.getVisibility() == 0) {
            i++;
            textView = this.dDY;
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
        this.dEd.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.dDU.setTextColor(color2);
        this.dDW.setTextColor(color);
        this.dDX.setTextColor(color);
        this.dDY.setTextColor(color);
        this.dDZ.setBackgroundColor(color3);
        this.dEa.setBackgroundColor(color3);
        this.dEb.setBackgroundColor(color3);
        this.dDW.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.dDX.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.dDY.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView aLm = aLm();
        if (aLm != null) {
            aLm.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        }
    }

    protected void setTitle(String str) {
        this.mTitle.setText(str);
    }

    protected void setIcon(Drawable drawable) {
        this.dxS.setImageDrawable(drawable);
        this.dxS.setVisibility(drawable != null ? 0 : 8);
    }

    protected void setMessage(CharSequence charSequence) {
        this.dDU.setText(charSequence);
        this.dDV.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dEg);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.dEf.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.dEc != null) {
            this.dEc.removeAllViews();
            if (view != null) {
                this.dEc.addView(view);
                this.dDV.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dEg);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.dEf.setLayoutParams(layoutParams);
            }
        }
    }

    protected void gN(boolean z) {
        this.dDW.setEnabled(z);
    }

    protected void kq(int i) {
        this.dDW.setTextColor(i);
    }

    protected void sj(String str) {
        this.dDW.setText(str);
        this.dDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.kp(-1);
                if (BaseActivityDialog.this.dEe != null) {
                    BaseActivityDialog.this.dEe.onEvent(new a.C0471a(BaseActivityDialog.this, -1));
                }
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.dDW.setVisibility(8);
            if (this.dDX.getVisibility() == 0) {
                this.dEa.setVisibility(8);
                return;
            }
            return;
        }
        this.dDW.setVisibility(0);
        if (this.dDX.getVisibility() == 0) {
            this.dEa.setVisibility(0);
        }
    }

    protected void sk(String str) {
        this.dDX.setText(str);
        this.dDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.kp(-2);
                if (BaseActivityDialog.this.dEe != null) {
                    BaseActivityDialog.this.dEe.onEvent(new a.C0471a(BaseActivityDialog.this, -2));
                }
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.dDX.setVisibility(8);
            if (this.dDW.getVisibility() == 0) {
                this.dEa.setVisibility(8);
                return;
            }
            return;
        }
        this.dDX.setVisibility(0);
        if (this.dDW.getVisibility() == 0) {
            this.dEa.setVisibility(0);
        }
    }

    protected void gO(boolean z) {
        if (z) {
            this.dEf.setVisibility(8);
            this.dDZ.setVisibility(8);
        }
    }

    private void release() {
        if (this.dEe != null) {
            this.dEe.release();
            this.dEe = null;
        }
        setView(null);
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static final int dEi = a.h.aiapps_dialog_negative_title_cancel;
        public static final int dEj = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> dEk = new HashMap<>();
        private static ArrayList dEl = new ArrayList();
        private View contentView;
        private String dEm;
        private String dEn;
        private boolean dEo;
        private int dEp;
        private DialogInterface.OnClickListener dEq;
        private DialogInterface.OnClickListener dEr;
        private DialogInterface.OnCancelListener dEs;
        private DialogInterface.OnDismissListener dEt;
        private Class<? extends Activity> dEu;
        private int dEv;
        private boolean dEw;
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
            this.dEo = true;
            this.dEv = -1;
            this.mContext = AppRuntime.getAppContext();
            this.dEu = cls;
        }

        public a kr(int i) {
            return sl(this.mContext.getString(i));
        }

        public a sl(String str) {
            this.title = str;
            return this;
        }

        public a ks(int i) {
            return sm(this.mContext.getString(i));
        }

        public a sm(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.dEm = str;
            this.dEq = onClickListener;
            return this;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return b(this.mContext.getString(i), onClickListener);
        }

        public a b(String str, DialogInterface.OnClickListener onClickListener) {
            this.dEn = str;
            this.dEr = onClickListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.dEt = onDismissListener;
            return this;
        }

        void release() {
            dEl.remove(this.mTag);
            this.dEq = null;
            this.dEr = null;
            this.dEs = null;
            this.dEt = null;
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
                    if (a.this.dEu == null) {
                        a.this.dEu = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.dEu);
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

        static a sn(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (dEk) {
                    remove = dEk.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (dEk) {
                    dEk.put(str, aVar);
                }
            }
        }

        public void onEvent(C0471a c0471a) {
            if (c0471a != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (c0471a.dEA) {
                    case -2:
                        onClickListener = this.dEr;
                        break;
                    case -1:
                        onClickListener = this.dEq;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(c0471a.dEz, c0471a.dEA);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C0471a {
            private int dEA;
            private DialogInterface dEz;

            public C0471a(DialogInterface dialogInterface, int i) {
                this.dEz = dialogInterface;
                this.dEA = i;
            }
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources alE = com.baidu.swan.apps.t.a.aAN().alE();
        return alE != null ? alE : super.getResources();
    }
}
