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
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppScrollView aIr;
    private TextView aNk;
    private LinearLayout aNl;
    private TextView aNm;
    private TextView aNn;
    private TextView aNo;
    private View aNp;
    private View aNq;
    private View aNr;
    private FrameLayout aNs;
    private RelativeLayout aNt;
    private a aNu;
    private LinearLayout aNv;
    private int aNw;
    private ImageView mIcon;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.aNu = a.gu(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.aNu == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        EventBusWrapper.register(this.aNu, a.b.class, new rx.functions.b<a.b>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.b bVar) {
                BaseActivityDialog.this.aNu.onEvent(bVar);
            }
        });
        EventBusWrapper.register(this.aNu, a.C0168a.class, new rx.functions.b<a.C0168a>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.C0168a c0168a) {
                if (c0168a.tag == BaseActivityDialog.this.aNu.mTag) {
                    BaseActivityDialog.this.dismiss();
                }
            }
        });
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
        if (this.aNu != null && (onCancelListener = this.aNu.aNI) != null) {
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
        if (this.aNu != null && (onDismissListener = this.aNu.aNJ) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void dm(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.aNk = (TextView) findViewById(a.f.dialog_message);
        this.aNl = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.aNm = (TextView) findViewById(a.f.positive_button);
        this.aNn = (TextView) findViewById(a.f.negative_button);
        this.aNo = (TextView) findViewById(a.f.neutral_button);
        this.aNq = findViewById(a.f.divider3);
        this.aNr = findViewById(a.f.divider4);
        this.aNs = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(a.f.dialog_icon);
        this.aNt = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.aNp = findViewById(a.f.divider2);
        this.aIr = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.aNv = (LinearLayout) findViewById(a.f.btn_panel);
        this.aNw = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.aNu.aNL > 0) {
            this.aIr.getLayoutParams().height = this.aNu.aNL;
        }
        if (com.baidu.swan.apps.an.a.Oq() || com.baidu.swan.apps.an.a.Op()) {
            int dimensionPixelSize = this.aNk.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.aNk.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.aNu != null) {
            a aVar = this.aNu;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            bT(aVar.aNE);
            dn(aVar.aNF);
            gp(aVar.aNC);
            gq(aVar.aND);
            bU(aVar.aNM);
        }
    }

    public TextView KB() {
        int i;
        TextView textView;
        if (this.aNm == null || this.aNm.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.aNm;
            i = 1;
        }
        if (this.aNn != null && this.aNn.getVisibility() == 0) {
            i++;
            textView = this.aNn;
        }
        if (this.aNo != null && this.aNo.getVisibility() == 0) {
            i++;
            textView = this.aNo;
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
        this.aNt.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.aNk.setTextColor(color2);
        this.aNm.setTextColor(color);
        this.aNn.setTextColor(color);
        this.aNo.setTextColor(color);
        this.aNp.setBackgroundColor(color3);
        this.aNq.setBackgroundColor(color3);
        this.aNr.setBackgroundColor(color3);
        this.aNm.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.aNn.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.aNo.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView KB = KB();
        if (KB != null) {
            KB.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        this.aNk.setText(charSequence);
        this.aNl.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aNw);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.aNv.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.aNs != null) {
            this.aNs.removeAllViews();
            if (view != null) {
                this.aNs.addView(view);
                this.aNl.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aNw);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.aNv.setLayoutParams(layoutParams);
            }
        }
    }

    protected void bT(boolean z) {
        this.aNm.setEnabled(z);
    }

    protected void dn(int i) {
        this.aNm.setTextColor(i);
    }

    protected void gp(String str) {
        this.aNm.setText(str);
        this.aNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.dm(-1);
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aNm.setVisibility(8);
            if (this.aNn.getVisibility() == 0) {
                this.aNq.setVisibility(8);
                return;
            }
            return;
        }
        this.aNm.setVisibility(0);
        if (this.aNn.getVisibility() == 0) {
            this.aNq.setVisibility(0);
        }
    }

    protected void gq(String str) {
        this.aNn.setText(str);
        this.aNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.dm(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aNn.setVisibility(8);
            if (this.aNm.getVisibility() == 0) {
                this.aNq.setVisibility(8);
                return;
            }
            return;
        }
        this.aNn.setVisibility(0);
        if (this.aNm.getVisibility() == 0) {
            this.aNq.setVisibility(0);
        }
    }

    protected void bU(boolean z) {
        if (z) {
            this.aNv.setVisibility(8);
            this.aNp.setVisibility(8);
        }
    }

    private void release() {
        if (this.aNu != null) {
            EventBusWrapper.unregister(this.aNu);
            this.aNu.release();
            this.aNu = null;
        }
        setView(null);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String aNC;
        private String aND;
        private boolean aNE;
        private int aNF;
        private DialogInterface.OnClickListener aNG;
        private DialogInterface.OnClickListener aNH;
        private DialogInterface.OnCancelListener aNI;
        private DialogInterface.OnDismissListener aNJ;
        private Class<? extends Activity> aNK;
        private int aNL;
        private boolean aNM;
        private View contentView;
        private Bundle extras;
        private String from;
        private Drawable icon;
        private Context mContext;
        private Object mTag;
        private CharSequence message;
        private String title;
        public static final int aNy = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aNz = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> aNA = new HashMap<>();
        private static ArrayList aNB = new ArrayList();

        public a() {
            this(BaseActivityDialog.class);
        }

        public a(Class<? extends Activity> cls) {
            this.aNE = true;
            this.aNL = -1;
            this.mContext = AppRuntime.getAppContext();
            this.aNK = cls;
        }

        /* renamed from: do  reason: not valid java name */
        public a m16do(int i) {
            return gr(this.mContext.getString(i));
        }

        public a gr(String str) {
            this.title = str;
            return this;
        }

        public a gt(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.aNC = str;
            this.aNG = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.aNJ = onDismissListener;
            return this;
        }

        void release() {
            aNB.remove(this.mTag);
            this.aNG = null;
            this.aNH = null;
            this.aNI = null;
            this.aNJ = null;
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
                    if (a.this.aNK == null) {
                        a.this.aNK = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.aNK);
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
                    com.baidu.swan.apps.an.b.h(appContext, intent);
                }
            });
        }

        static a gu(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (aNA) {
                    remove = aNA.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (aNA) {
                    aNA.put(str, aVar);
                }
            }
        }

        public void onEvent(b bVar) {
            if (bVar != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (bVar.aNQ) {
                    case -2:
                        onClickListener = this.aNH;
                        break;
                    case -1:
                        onClickListener = this.aNG;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(bVar.aNP, bVar.aNQ);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class b {
            private DialogInterface aNP;
            private int aNQ;

            public b(DialogInterface dialogInterface, int i) {
                this.aNP = dialogInterface;
                this.aNQ = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0168a {
            private Object tag;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources Eu = com.baidu.swan.apps.u.a.DW().Eu();
        return Eu != null ? Eu : super.getResources();
    }
}
