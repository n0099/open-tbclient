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
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private SwanAppScrollView aGt;
    private TextView aLm;
    private LinearLayout aLn;
    private TextView aLo;
    private TextView aLp;
    private TextView aLq;
    private View aLr;
    private View aLs;
    private View aLt;
    private FrameLayout aLu;
    private RelativeLayout aLv;
    private a aLw;
    private LinearLayout aLx;
    private int aLy;
    private ImageView mIcon;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.aLw = a.gb(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.aLw == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        EventBusWrapper.register(this.aLw, a.b.class, new rx.functions.b<a.b>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.b bVar) {
                BaseActivityDialog.this.aLw.onEvent(bVar);
            }
        });
        EventBusWrapper.register(this.aLw, a.C0133a.class, new rx.functions.b<a.C0133a>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.C0133a c0133a) {
                if (c0133a.tag == BaseActivityDialog.this.aLw.mTag) {
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
        if (this.aLw != null && (onCancelListener = this.aLw.aLK) != null) {
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
        if (this.aLw != null && (onDismissListener = this.aLw.aLL) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void di(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(b.f.dialog_title);
        this.aLm = (TextView) findViewById(b.f.dialog_message);
        this.aLn = (LinearLayout) findViewById(b.f.dialog_message_content);
        this.aLo = (TextView) findViewById(b.f.positive_button);
        this.aLp = (TextView) findViewById(b.f.negative_button);
        this.aLq = (TextView) findViewById(b.f.neutral_button);
        this.aLs = findViewById(b.f.divider3);
        this.aLt = findViewById(b.f.divider4);
        this.aLu = (FrameLayout) findViewById(b.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(b.f.dialog_icon);
        this.aLv = (RelativeLayout) findViewById(b.f.searchbox_alert_dialog);
        this.aLr = findViewById(b.f.divider2);
        this.aGt = (SwanAppScrollView) findViewById(b.f.message_scrollview);
        this.aLx = (LinearLayout) findViewById(b.f.btn_panel);
        this.aLy = getResources().getDimensionPixelSize(b.d.aiapps_dialog_btns_height);
        if (this.aLw.aLN > 0) {
            this.aGt.getLayoutParams().height = this.aLw.aLN;
        }
        if (com.baidu.swan.apps.an.a.LL() || com.baidu.swan.apps.an.a.LK()) {
            int dimensionPixelSize = this.aLm.getResources().getDimensionPixelSize(b.d.aiapps_dialog_text_padding);
            this.aLm.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.aLw != null) {
            a aVar = this.aLw;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            bK(aVar.aLG);
            dj(aVar.aLH);
            fX(aVar.aLE);
            fY(aVar.aLF);
            bL(aVar.aLO);
        }
    }

    public TextView In() {
        int i;
        TextView textView;
        if (this.aLo == null || this.aLo.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.aLo;
            i = 1;
        }
        if (this.aLp != null && this.aLp.getVisibility() == 0) {
            i++;
            textView = this.aLp;
        }
        if (this.aLq != null && this.aLq.getVisibility() == 0) {
            i++;
            textView = this.aLq;
        }
        if (i != 1) {
            return null;
        }
        return textView;
    }

    protected void show() {
        Resources resources = getResources();
        int color = resources.getColor(b.c.aiapps_dialog_title_text_color);
        int color2 = resources.getColor(b.c.aiapps_box_dialog_message_text_color);
        int color3 = resources.getColor(b.c.aiapps_dialog_gray);
        this.aLv.setBackground(resources.getDrawable(b.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.aLm.setTextColor(color2);
        this.aLo.setTextColor(color);
        this.aLp.setTextColor(color);
        this.aLq.setTextColor(color);
        this.aLr.setBackgroundColor(color3);
        this.aLs.setBackgroundColor(color3);
        this.aLt.setBackgroundColor(color3);
        this.aLo.setBackground(resources.getDrawable(b.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.aLp.setBackground(resources.getDrawable(b.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.aLq.setBackground(resources.getDrawable(b.e.aiapp_alertdialog_button_day_bg_selector));
        TextView In = In();
        if (In != null) {
            In.setBackground(resources.getDrawable(b.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        this.aLm.setText(charSequence);
        this.aLn.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLy);
        layoutParams.addRule(3, b.f.dialog_message_content);
        this.aLx.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.aLu != null) {
            this.aLu.removeAllViews();
            if (view != null) {
                this.aLu.addView(view);
                this.aLn.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLy);
                layoutParams.addRule(3, b.f.dialog_customPanel);
                this.aLx.setLayoutParams(layoutParams);
            }
        }
    }

    protected void bK(boolean z) {
        this.aLo.setEnabled(z);
    }

    protected void dj(int i) {
        this.aLo.setTextColor(i);
    }

    protected void fX(String str) {
        this.aLo.setText(str);
        this.aLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.di(-1);
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aLo.setVisibility(8);
            if (this.aLp.getVisibility() == 0) {
                this.aLs.setVisibility(8);
                return;
            }
            return;
        }
        this.aLo.setVisibility(0);
        if (this.aLp.getVisibility() == 0) {
            this.aLs.setVisibility(0);
        }
    }

    protected void fY(String str) {
        this.aLp.setText(str);
        this.aLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.di(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aLp.setVisibility(8);
            if (this.aLo.getVisibility() == 0) {
                this.aLs.setVisibility(8);
                return;
            }
            return;
        }
        this.aLp.setVisibility(0);
        if (this.aLo.getVisibility() == 0) {
            this.aLs.setVisibility(0);
        }
    }

    protected void bL(boolean z) {
        if (z) {
            this.aLx.setVisibility(8);
            this.aLr.setVisibility(8);
        }
    }

    private void release() {
        if (this.aLw != null) {
            EventBusWrapper.unregister(this.aLw);
            this.aLw.release();
            this.aLw = null;
        }
        setView(null);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aLA = b.h.aiapps_dialog_negative_title_cancel;
        public static final int aLB = b.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> aLC = new HashMap<>();
        private static ArrayList aLD = new ArrayList();
        private String aLE;
        private String aLF;
        private boolean aLG;
        private int aLH;
        private DialogInterface.OnClickListener aLI;
        private DialogInterface.OnClickListener aLJ;
        private DialogInterface.OnCancelListener aLK;
        private DialogInterface.OnDismissListener aLL;
        private Class<? extends Activity> aLM;
        private int aLN;
        private boolean aLO;
        private View contentView;
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
            this.aLG = true;
            this.aLN = -1;
            this.mContext = AppRuntime.getAppContext();
            this.aLM = cls;
        }

        public a dk(int i) {
            return fZ(this.mContext.getString(i));
        }

        public a fZ(String str) {
            this.title = str;
            return this;
        }

        public a ga(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.aLE = str;
            this.aLI = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.aLL = onDismissListener;
            return this;
        }

        void release() {
            aLD.remove(this.mTag);
            this.aLI = null;
            this.aLJ = null;
            this.aLK = null;
            this.aLL = null;
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
                    if (a.this.aLM == null) {
                        a.this.aLM = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.aLM);
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

        static a gb(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (aLC) {
                    remove = aLC.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (aLC) {
                    aLC.put(str, aVar);
                }
            }
        }

        public void onEvent(b bVar) {
            if (bVar != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (bVar.aLS) {
                    case -2:
                        onClickListener = this.aLJ;
                        break;
                    case -1:
                        onClickListener = this.aLI;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(bVar.aLR, bVar.aLS);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class b {
            private DialogInterface aLR;
            private int aLS;

            public b(DialogInterface dialogInterface, int i) {
                this.aLR = dialogInterface;
                this.aLS = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0133a {
            private Object tag;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources Dr = com.baidu.swan.apps.u.a.CT().Dr();
        return Dr != null ? Dr : super.getResources();
    }
}
