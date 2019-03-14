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
    private SwanAppScrollView aGu;
    private TextView aLn;
    private LinearLayout aLo;
    private TextView aLp;
    private TextView aLq;
    private TextView aLr;
    private View aLs;
    private View aLt;
    private View aLu;
    private FrameLayout aLv;
    private RelativeLayout aLw;
    private a aLx;
    private LinearLayout aLy;
    private int aLz;
    private ImageView mIcon;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.aLx = a.gb(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.aLx == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        EventBusWrapper.register(this.aLx, a.b.class, new rx.functions.b<a.b>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.b bVar) {
                BaseActivityDialog.this.aLx.onEvent(bVar);
            }
        });
        EventBusWrapper.register(this.aLx, a.C0162a.class, new rx.functions.b<a.C0162a>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.C0162a c0162a) {
                if (c0162a.tag == BaseActivityDialog.this.aLx.mTag) {
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
        if (this.aLx != null && (onCancelListener = this.aLx.aLL) != null) {
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
        if (this.aLx != null && (onDismissListener = this.aLx.aLM) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void di(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.aLn = (TextView) findViewById(a.f.dialog_message);
        this.aLo = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.aLp = (TextView) findViewById(a.f.positive_button);
        this.aLq = (TextView) findViewById(a.f.negative_button);
        this.aLr = (TextView) findViewById(a.f.neutral_button);
        this.aLt = findViewById(a.f.divider3);
        this.aLu = findViewById(a.f.divider4);
        this.aLv = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(a.f.dialog_icon);
        this.aLw = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.aLs = findViewById(a.f.divider2);
        this.aGu = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.aLy = (LinearLayout) findViewById(a.f.btn_panel);
        this.aLz = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.aLx.aLO > 0) {
            this.aGu.getLayoutParams().height = this.aLx.aLO;
        }
        if (com.baidu.swan.apps.an.a.LL() || com.baidu.swan.apps.an.a.LK()) {
            int dimensionPixelSize = this.aLn.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.aLn.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.aLx != null) {
            a aVar = this.aLx;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            bK(aVar.aLH);
            dj(aVar.aLI);
            fX(aVar.aLF);
            fY(aVar.aLG);
            bL(aVar.aLP);
        }
    }

    public TextView In() {
        int i;
        TextView textView;
        if (this.aLp == null || this.aLp.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.aLp;
            i = 1;
        }
        if (this.aLq != null && this.aLq.getVisibility() == 0) {
            i++;
            textView = this.aLq;
        }
        if (this.aLr != null && this.aLr.getVisibility() == 0) {
            i++;
            textView = this.aLr;
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
        this.aLw.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.aLn.setTextColor(color2);
        this.aLp.setTextColor(color);
        this.aLq.setTextColor(color);
        this.aLr.setTextColor(color);
        this.aLs.setBackgroundColor(color3);
        this.aLt.setBackgroundColor(color3);
        this.aLu.setBackgroundColor(color3);
        this.aLp.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.aLq.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.aLr.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView In = In();
        if (In != null) {
            In.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        this.aLn.setText(charSequence);
        this.aLo.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLz);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.aLy.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.aLv != null) {
            this.aLv.removeAllViews();
            if (view != null) {
                this.aLv.addView(view);
                this.aLo.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLz);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.aLy.setLayoutParams(layoutParams);
            }
        }
    }

    protected void bK(boolean z) {
        this.aLp.setEnabled(z);
    }

    protected void dj(int i) {
        this.aLp.setTextColor(i);
    }

    protected void fX(String str) {
        this.aLp.setText(str);
        this.aLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.di(-1);
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aLp.setVisibility(8);
            if (this.aLq.getVisibility() == 0) {
                this.aLt.setVisibility(8);
                return;
            }
            return;
        }
        this.aLp.setVisibility(0);
        if (this.aLq.getVisibility() == 0) {
            this.aLt.setVisibility(0);
        }
    }

    protected void fY(String str) {
        this.aLq.setText(str);
        this.aLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.di(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aLq.setVisibility(8);
            if (this.aLp.getVisibility() == 0) {
                this.aLt.setVisibility(8);
                return;
            }
            return;
        }
        this.aLq.setVisibility(0);
        if (this.aLp.getVisibility() == 0) {
            this.aLt.setVisibility(0);
        }
    }

    protected void bL(boolean z) {
        if (z) {
            this.aLy.setVisibility(8);
            this.aLs.setVisibility(8);
        }
    }

    private void release() {
        if (this.aLx != null) {
            EventBusWrapper.unregister(this.aLx);
            this.aLx.release();
            this.aLx = null;
        }
        setView(null);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aLB = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aLC = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> aLD = new HashMap<>();
        private static ArrayList aLE = new ArrayList();
        private String aLF;
        private String aLG;
        private boolean aLH;
        private int aLI;
        private DialogInterface.OnClickListener aLJ;
        private DialogInterface.OnClickListener aLK;
        private DialogInterface.OnCancelListener aLL;
        private DialogInterface.OnDismissListener aLM;
        private Class<? extends Activity> aLN;
        private int aLO;
        private boolean aLP;
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
            this.aLH = true;
            this.aLO = -1;
            this.mContext = AppRuntime.getAppContext();
            this.aLN = cls;
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
            this.aLF = str;
            this.aLJ = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.aLM = onDismissListener;
            return this;
        }

        void release() {
            aLE.remove(this.mTag);
            this.aLJ = null;
            this.aLK = null;
            this.aLL = null;
            this.aLM = null;
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
                    if (a.this.aLN == null) {
                        a.this.aLN = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.aLN);
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
                synchronized (aLD) {
                    remove = aLD.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (aLD) {
                    aLD.put(str, aVar);
                }
            }
        }

        public void onEvent(b bVar) {
            if (bVar != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (bVar.aLT) {
                    case -2:
                        onClickListener = this.aLK;
                        break;
                    case -1:
                        onClickListener = this.aLJ;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(bVar.aLS, bVar.aLT);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class b {
            private DialogInterface aLS;
            private int aLT;

            public b(DialogInterface dialogInterface, int i) {
                this.aLS = dialogInterface;
                this.aLT = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0162a {
            private Object tag;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources Dr = com.baidu.swan.apps.u.a.CT().Dr();
        return Dr != null ? Dr : super.getResources();
    }
}
