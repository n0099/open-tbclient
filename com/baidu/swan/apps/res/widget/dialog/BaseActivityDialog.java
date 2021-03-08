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
    private TextView dCO;
    private LinearLayout dCP;
    private TextView dCQ;
    private TextView dCR;
    private TextView dCS;
    private View dCT;
    private View dCU;
    private View dCV;
    private FrameLayout dCW;
    private RelativeLayout dCX;
    private a dCY;
    private LinearLayout dCZ;
    private int dDa;
    private ImageView dwR;
    private SwanAppScrollView dxi;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.dCY = a.rC(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.dCY == null) {
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
        if (this.dCY != null && (onCancelListener = this.dCY.dDm) != null) {
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
        if (this.dCY != null && (onDismissListener = this.dCY.dDn) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void iN(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.dCO = (TextView) findViewById(a.f.dialog_message);
        this.dCP = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.dCQ = (TextView) findViewById(a.f.positive_button);
        this.dCR = (TextView) findViewById(a.f.negative_button);
        this.dCS = (TextView) findViewById(a.f.neutral_button);
        this.dCU = findViewById(a.f.divider3);
        this.dCV = findViewById(a.f.divider4);
        this.dCW = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.dwR = (ImageView) findViewById(a.f.dialog_icon);
        this.dCX = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.dCT = findViewById(a.f.divider2);
        this.dxi = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.dCZ = (LinearLayout) findViewById(a.f.btn_panel);
        this.dDa = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.dCY.dDp > 0) {
            this.dxi.getLayoutParams().height = this.dCY.dDp;
        }
        if (com.baidu.swan.apps.ao.c.isGingerbread() || com.baidu.swan.apps.ao.c.isGingerbreadmr1()) {
            int dimensionPixelSize = this.dCO.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.dCO.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.dCY != null) {
            a aVar = this.dCY;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            gL(aVar.dDi);
            iO(aVar.dDj);
            ry(aVar.dDg);
            rz(aVar.dDh);
            gM(aVar.dDq);
        }
    }

    public TextView aHP() {
        TextView textView;
        int i = 0;
        if (this.dCQ == null || this.dCQ.getVisibility() != 0) {
            textView = null;
        } else {
            textView = this.dCQ;
            i = 1;
        }
        if (this.dCR != null && this.dCR.getVisibility() == 0) {
            i++;
            textView = this.dCR;
        }
        if (this.dCS != null && this.dCS.getVisibility() == 0) {
            i++;
            textView = this.dCS;
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
        this.dCX.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.dCO.setTextColor(color2);
        this.dCQ.setTextColor(color);
        this.dCR.setTextColor(color);
        this.dCS.setTextColor(color);
        this.dCT.setBackgroundColor(color3);
        this.dCU.setBackgroundColor(color3);
        this.dCV.setBackgroundColor(color3);
        this.dCQ.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.dCR.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.dCS.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView aHP = aHP();
        if (aHP != null) {
            aHP.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        }
    }

    protected void setTitle(String str) {
        this.mTitle.setText(str);
    }

    protected void setIcon(Drawable drawable) {
        this.dwR.setImageDrawable(drawable);
        this.dwR.setVisibility(drawable != null ? 0 : 8);
    }

    protected void setMessage(CharSequence charSequence) {
        this.dCO.setText(charSequence);
        this.dCP.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dDa);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.dCZ.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.dCW != null) {
            this.dCW.removeAllViews();
            if (view != null) {
                this.dCW.addView(view);
                this.dCP.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dDa);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.dCZ.setLayoutParams(layoutParams);
            }
        }
    }

    protected void gL(boolean z) {
        this.dCQ.setEnabled(z);
    }

    protected void iO(int i) {
        this.dCQ.setTextColor(i);
    }

    protected void ry(String str) {
        this.dCQ.setText(str);
        this.dCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.iN(-1);
                if (BaseActivityDialog.this.dCY != null) {
                    BaseActivityDialog.this.dCY.onEvent(new a.C0457a(BaseActivityDialog.this, -1));
                }
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.dCQ.setVisibility(8);
            if (this.dCR.getVisibility() == 0) {
                this.dCU.setVisibility(8);
                return;
            }
            return;
        }
        this.dCQ.setVisibility(0);
        if (this.dCR.getVisibility() == 0) {
            this.dCU.setVisibility(0);
        }
    }

    protected void rz(String str) {
        this.dCR.setText(str);
        this.dCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.iN(-2);
                if (BaseActivityDialog.this.dCY != null) {
                    BaseActivityDialog.this.dCY.onEvent(new a.C0457a(BaseActivityDialog.this, -2));
                }
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.dCR.setVisibility(8);
            if (this.dCQ.getVisibility() == 0) {
                this.dCU.setVisibility(8);
                return;
            }
            return;
        }
        this.dCR.setVisibility(0);
        if (this.dCQ.getVisibility() == 0) {
            this.dCU.setVisibility(0);
        }
    }

    protected void gM(boolean z) {
        if (z) {
            this.dCZ.setVisibility(8);
            this.dCT.setVisibility(8);
        }
    }

    private void release() {
        if (this.dCY != null) {
            this.dCY.release();
            this.dCY = null;
        }
        setView(null);
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static final int dDc = a.h.aiapps_dialog_negative_title_cancel;
        public static final int dDd = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> dDe = new HashMap<>();
        private static ArrayList dDf = new ArrayList();
        private View contentView;
        private String dDg;
        private String dDh;
        private boolean dDi;
        private int dDj;
        private DialogInterface.OnClickListener dDk;
        private DialogInterface.OnClickListener dDl;
        private DialogInterface.OnCancelListener dDm;
        private DialogInterface.OnDismissListener dDn;
        private Class<? extends Activity> dDo;
        private int dDp;
        private boolean dDq;
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
            this.dDi = true;
            this.dDp = -1;
            this.mContext = AppRuntime.getAppContext();
            this.dDo = cls;
        }

        public a iP(int i) {
            return rA(this.mContext.getString(i));
        }

        public a rA(String str) {
            this.title = str;
            return this;
        }

        public a iQ(int i) {
            return rB(this.mContext.getString(i));
        }

        public a rB(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.dDg = str;
            this.dDk = onClickListener;
            return this;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return b(this.mContext.getString(i), onClickListener);
        }

        public a b(String str, DialogInterface.OnClickListener onClickListener) {
            this.dDh = str;
            this.dDl = onClickListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.dDn = onDismissListener;
            return this;
        }

        void release() {
            dDf.remove(this.mTag);
            this.dDk = null;
            this.dDl = null;
            this.dDm = null;
            this.dDn = null;
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
                    if (a.this.dDo == null) {
                        a.this.dDo = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.dDo);
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

        static a rC(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (dDe) {
                    remove = dDe.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (dDe) {
                    dDe.put(str, aVar);
                }
            }
        }

        public void onEvent(C0457a c0457a) {
            if (c0457a != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (c0457a.dDu) {
                    case -2:
                        onClickListener = this.dDl;
                        break;
                    case -1:
                        onClickListener = this.dDk;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(c0457a.dDt, c0457a.dDu);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C0457a {
            private DialogInterface dDt;
            private int dDu;

            public C0457a(DialogInterface dialogInterface, int i) {
                this.dDt = dialogInterface;
                this.dDu = i;
            }
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources aim = com.baidu.swan.apps.t.a.axv().aim();
        return aim != null ? aim : super.getResources();
    }
}
