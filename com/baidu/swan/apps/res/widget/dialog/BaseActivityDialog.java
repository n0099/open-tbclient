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
    private SwanAppScrollView aIZ;
    private TextView aNT;
    private LinearLayout aNU;
    private TextView aNV;
    private TextView aNW;
    private TextView aNX;
    private View aNY;
    private View aNZ;
    private View aOa;
    private FrameLayout aOb;
    private RelativeLayout aOc;
    private a aOd;
    private LinearLayout aOe;
    private int aOf;
    private ImageView mIcon;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.aOd = a.gA(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.aOd == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        EventBusWrapper.register(this.aOd, a.b.class, new rx.functions.b<a.b>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.b bVar) {
                BaseActivityDialog.this.aOd.onEvent(bVar);
            }
        });
        EventBusWrapper.register(this.aOd, a.C0165a.class, new rx.functions.b<a.C0165a>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.C0165a c0165a) {
                if (c0165a.tag == BaseActivityDialog.this.aOd.mTag) {
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
        if (this.aOd != null && (onCancelListener = this.aOd.aOs) != null) {
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
        if (this.aOd != null && (onDismissListener = this.aOd.aOt) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void dp(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.aNT = (TextView) findViewById(a.f.dialog_message);
        this.aNU = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.aNV = (TextView) findViewById(a.f.positive_button);
        this.aNW = (TextView) findViewById(a.f.negative_button);
        this.aNX = (TextView) findViewById(a.f.neutral_button);
        this.aNZ = findViewById(a.f.divider3);
        this.aOa = findViewById(a.f.divider4);
        this.aOb = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(a.f.dialog_icon);
        this.aOc = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.aNY = findViewById(a.f.divider2);
        this.aIZ = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.aOe = (LinearLayout) findViewById(a.f.btn_panel);
        this.aOf = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.aOd.aOv > 0) {
            this.aIZ.getLayoutParams().height = this.aOd.aOv;
        }
        if (com.baidu.swan.apps.an.a.Pf() || com.baidu.swan.apps.an.a.Pe()) {
            int dimensionPixelSize = this.aNT.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.aNT.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.aOd != null) {
            a aVar = this.aOd;
            setTitle(aVar.title);
            setIcon(aVar.aOn);
            setMessage(aVar.message);
            setView(aVar.contentView);
            bW(aVar.aOo);
            dq(aVar.aOp);
            gw(aVar.aOl);
            gx(aVar.aOm);
            bX(aVar.aOw);
        }
    }

    public TextView Lo() {
        int i;
        TextView textView;
        if (this.aNV == null || this.aNV.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.aNV;
            i = 1;
        }
        if (this.aNW != null && this.aNW.getVisibility() == 0) {
            i++;
            textView = this.aNW;
        }
        if (this.aNX != null && this.aNX.getVisibility() == 0) {
            i++;
            textView = this.aNX;
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
        this.aOc.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.aNT.setTextColor(color2);
        this.aNV.setTextColor(color);
        this.aNW.setTextColor(color);
        this.aNX.setTextColor(color);
        this.aNY.setBackgroundColor(color3);
        this.aNZ.setBackgroundColor(color3);
        this.aOa.setBackgroundColor(color3);
        this.aNV.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.aNW.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.aNX.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView Lo = Lo();
        if (Lo != null) {
            Lo.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        this.aNT.setText(charSequence);
        this.aNU.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aOf);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.aOe.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.aOb != null) {
            this.aOb.removeAllViews();
            if (view != null) {
                this.aOb.addView(view);
                this.aNU.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aOf);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.aOe.setLayoutParams(layoutParams);
            }
        }
    }

    protected void bW(boolean z) {
        this.aNV.setEnabled(z);
    }

    protected void dq(int i) {
        this.aNV.setTextColor(i);
    }

    protected void gw(String str) {
        this.aNV.setText(str);
        this.aNV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.dp(-1);
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aNV.setVisibility(8);
            if (this.aNW.getVisibility() == 0) {
                this.aNZ.setVisibility(8);
                return;
            }
            return;
        }
        this.aNV.setVisibility(0);
        if (this.aNW.getVisibility() == 0) {
            this.aNZ.setVisibility(0);
        }
    }

    protected void gx(String str) {
        this.aNW.setText(str);
        this.aNW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.dp(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aNW.setVisibility(8);
            if (this.aNV.getVisibility() == 0) {
                this.aNZ.setVisibility(8);
                return;
            }
            return;
        }
        this.aNW.setVisibility(0);
        if (this.aNV.getVisibility() == 0) {
            this.aNZ.setVisibility(0);
        }
    }

    protected void bX(boolean z) {
        if (z) {
            this.aOe.setVisibility(8);
            this.aNY.setVisibility(8);
        }
    }

    private void release() {
        if (this.aOd != null) {
            EventBusWrapper.unregister(this.aOd);
            this.aOd.release();
            this.aOd = null;
        }
        setView(null);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aOh = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aOi = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> aOj = new HashMap<>();
        private static ArrayList aOk = new ArrayList();
        private String aOl;
        private String aOm;
        private Drawable aOn;
        private boolean aOo;
        private int aOp;
        private DialogInterface.OnClickListener aOq;
        private DialogInterface.OnClickListener aOr;
        private DialogInterface.OnCancelListener aOs;
        private DialogInterface.OnDismissListener aOt;
        private Class<? extends Activity> aOu;
        private int aOv;
        private boolean aOw;
        private View contentView;
        private Bundle extras;
        private String from;
        private Context mContext;
        private Object mTag;
        private CharSequence message;
        private String title;

        public a() {
            this(BaseActivityDialog.class);
        }

        public a(Class<? extends Activity> cls) {
            this.aOo = true;
            this.aOv = -1;
            this.mContext = AppRuntime.getAppContext();
            this.aOu = cls;
        }

        public a dr(int i) {
            return gy(this.mContext.getString(i));
        }

        public a gy(String str) {
            this.title = str;
            return this;
        }

        public a gz(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.aOl = str;
            this.aOq = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.aOt = onDismissListener;
            return this;
        }

        void release() {
            aOk.remove(this.mTag);
            this.aOq = null;
            this.aOr = null;
            this.aOs = null;
            this.aOt = null;
            this.contentView = null;
            this.aOn = null;
        }

        public void show() {
            show(false);
        }

        public void show(final boolean z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.a.1
                @Override // java.lang.Runnable
                public void run() {
                    Context appContext = AppRuntime.getAppContext();
                    if (a.this.aOu == null) {
                        a.this.aOu = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.aOu);
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

        static a gA(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (aOj) {
                    remove = aOj.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (aOj) {
                    aOj.put(str, aVar);
                }
            }
        }

        public void onEvent(b bVar) {
            if (bVar != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (bVar.aOA) {
                    case -2:
                        onClickListener = this.aOr;
                        break;
                    case -1:
                        onClickListener = this.aOq;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(bVar.aOz, bVar.aOA);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class b {
            private int aOA;
            private DialogInterface aOz;

            public b(DialogInterface dialogInterface, int i) {
                this.aOz = dialogInterface;
                this.aOA = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0165a {
            private Object tag;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources Fd = com.baidu.swan.apps.u.a.EF().Fd();
        return Fd != null ? Fd : super.getResources();
    }
}
