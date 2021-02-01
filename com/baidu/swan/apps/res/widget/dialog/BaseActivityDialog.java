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
    private TextView dBn;
    private LinearLayout dBo;
    private TextView dBp;
    private TextView dBq;
    private TextView dBr;
    private View dBs;
    private View dBt;
    private View dBu;
    private FrameLayout dBv;
    private RelativeLayout dBw;
    private a dBx;
    private LinearLayout dBy;
    private int dBz;
    private SwanAppScrollView dvH;
    private ImageView dvq;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.dBx = a.rv(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.dBx == null) {
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
        if (this.dBx != null && (onCancelListener = this.dBx.dBL) != null) {
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
        if (this.dBx != null && (onDismissListener = this.dBx.dBM) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void iM(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.dBn = (TextView) findViewById(a.f.dialog_message);
        this.dBo = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.dBp = (TextView) findViewById(a.f.positive_button);
        this.dBq = (TextView) findViewById(a.f.negative_button);
        this.dBr = (TextView) findViewById(a.f.neutral_button);
        this.dBt = findViewById(a.f.divider3);
        this.dBu = findViewById(a.f.divider4);
        this.dBv = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.dvq = (ImageView) findViewById(a.f.dialog_icon);
        this.dBw = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.dBs = findViewById(a.f.divider2);
        this.dvH = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.dBy = (LinearLayout) findViewById(a.f.btn_panel);
        this.dBz = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.dBx.dBO > 0) {
            this.dvH.getLayoutParams().height = this.dBx.dBO;
        }
        if (com.baidu.swan.apps.ao.c.isGingerbread() || com.baidu.swan.apps.ao.c.isGingerbreadmr1()) {
            int dimensionPixelSize = this.dBn.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.dBn.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.dBx != null) {
            a aVar = this.dBx;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            gL(aVar.dBH);
            iN(aVar.dBI);
            rr(aVar.dBF);
            rs(aVar.dBG);
            gM(aVar.dBP);
        }
    }

    public TextView aHM() {
        TextView textView;
        int i = 0;
        if (this.dBp == null || this.dBp.getVisibility() != 0) {
            textView = null;
        } else {
            textView = this.dBp;
            i = 1;
        }
        if (this.dBq != null && this.dBq.getVisibility() == 0) {
            i++;
            textView = this.dBq;
        }
        if (this.dBr != null && this.dBr.getVisibility() == 0) {
            i++;
            textView = this.dBr;
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
        this.dBw.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.dBn.setTextColor(color2);
        this.dBp.setTextColor(color);
        this.dBq.setTextColor(color);
        this.dBr.setTextColor(color);
        this.dBs.setBackgroundColor(color3);
        this.dBt.setBackgroundColor(color3);
        this.dBu.setBackgroundColor(color3);
        this.dBp.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.dBq.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.dBr.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView aHM = aHM();
        if (aHM != null) {
            aHM.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        }
    }

    protected void setTitle(String str) {
        this.mTitle.setText(str);
    }

    protected void setIcon(Drawable drawable) {
        this.dvq.setImageDrawable(drawable);
        this.dvq.setVisibility(drawable != null ? 0 : 8);
    }

    protected void setMessage(CharSequence charSequence) {
        this.dBn.setText(charSequence);
        this.dBo.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dBz);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.dBy.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.dBv != null) {
            this.dBv.removeAllViews();
            if (view != null) {
                this.dBv.addView(view);
                this.dBo.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dBz);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.dBy.setLayoutParams(layoutParams);
            }
        }
    }

    protected void gL(boolean z) {
        this.dBp.setEnabled(z);
    }

    protected void iN(int i) {
        this.dBp.setTextColor(i);
    }

    protected void rr(String str) {
        this.dBp.setText(str);
        this.dBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.iM(-1);
                if (BaseActivityDialog.this.dBx != null) {
                    BaseActivityDialog.this.dBx.onEvent(new a.C0451a(BaseActivityDialog.this, -1));
                }
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.dBp.setVisibility(8);
            if (this.dBq.getVisibility() == 0) {
                this.dBt.setVisibility(8);
                return;
            }
            return;
        }
        this.dBp.setVisibility(0);
        if (this.dBq.getVisibility() == 0) {
            this.dBt.setVisibility(0);
        }
    }

    protected void rs(String str) {
        this.dBq.setText(str);
        this.dBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.iM(-2);
                if (BaseActivityDialog.this.dBx != null) {
                    BaseActivityDialog.this.dBx.onEvent(new a.C0451a(BaseActivityDialog.this, -2));
                }
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.dBq.setVisibility(8);
            if (this.dBp.getVisibility() == 0) {
                this.dBt.setVisibility(8);
                return;
            }
            return;
        }
        this.dBq.setVisibility(0);
        if (this.dBp.getVisibility() == 0) {
            this.dBt.setVisibility(0);
        }
    }

    protected void gM(boolean z) {
        if (z) {
            this.dBy.setVisibility(8);
            this.dBs.setVisibility(8);
        }
    }

    private void release() {
        if (this.dBx != null) {
            this.dBx.release();
            this.dBx = null;
        }
        setView(null);
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static final int dBB = a.h.aiapps_dialog_negative_title_cancel;
        public static final int dBC = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> dBD = new HashMap<>();
        private static ArrayList dBE = new ArrayList();
        private View contentView;
        private String dBF;
        private String dBG;
        private boolean dBH;
        private int dBI;
        private DialogInterface.OnClickListener dBJ;
        private DialogInterface.OnClickListener dBK;
        private DialogInterface.OnCancelListener dBL;
        private DialogInterface.OnDismissListener dBM;
        private Class<? extends Activity> dBN;
        private int dBO;
        private boolean dBP;
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
            this.dBH = true;
            this.dBO = -1;
            this.mContext = AppRuntime.getAppContext();
            this.dBN = cls;
        }

        public a iO(int i) {
            return rt(this.mContext.getString(i));
        }

        public a rt(String str) {
            this.title = str;
            return this;
        }

        public a iP(int i) {
            return ru(this.mContext.getString(i));
        }

        public a ru(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.dBF = str;
            this.dBJ = onClickListener;
            return this;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return b(this.mContext.getString(i), onClickListener);
        }

        public a b(String str, DialogInterface.OnClickListener onClickListener) {
            this.dBG = str;
            this.dBK = onClickListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.dBM = onDismissListener;
            return this;
        }

        void release() {
            dBE.remove(this.mTag);
            this.dBJ = null;
            this.dBK = null;
            this.dBL = null;
            this.dBM = null;
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
                    if (a.this.dBN == null) {
                        a.this.dBN = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.dBN);
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

        static a rv(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (dBD) {
                    remove = dBD.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (dBD) {
                    dBD.put(str, aVar);
                }
            }
        }

        public void onEvent(C0451a c0451a) {
            if (c0451a != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (c0451a.dBT) {
                    case -2:
                        onClickListener = this.dBK;
                        break;
                    case -1:
                        onClickListener = this.dBJ;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(c0451a.dBS, c0451a.dBT);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C0451a {
            private DialogInterface dBS;
            private int dBT;

            public C0451a(DialogInterface dialogInterface, int i) {
                this.dBS = dialogInterface;
                this.dBT = i;
            }
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources aij = com.baidu.swan.apps.t.a.axs().aij();
        return aij != null ? aij : super.getResources();
    }
}
