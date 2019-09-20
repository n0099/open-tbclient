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
    private SwanAppScrollView aJx;
    private RelativeLayout aOA;
    private a aOB;
    private LinearLayout aOC;
    private int aOD;
    private TextView aOr;
    private LinearLayout aOs;
    private TextView aOt;
    private TextView aOu;
    private TextView aOv;
    private View aOw;
    private View aOx;
    private View aOy;
    private FrameLayout aOz;
    private ImageView mIcon;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.aOB = a.gC(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.aOB == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        EventBusWrapper.register(this.aOB, a.b.class, new rx.functions.b<a.b>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.b bVar) {
                BaseActivityDialog.this.aOB.onEvent(bVar);
            }
        });
        EventBusWrapper.register(this.aOB, a.C0179a.class, new rx.functions.b<a.C0179a>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.C0179a c0179a) {
                if (c0179a.tag == BaseActivityDialog.this.aOB.mTag) {
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
        if (this.aOB != null && (onCancelListener = this.aOB.aOQ) != null) {
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
        if (this.aOB != null && (onDismissListener = this.aOB.aOR) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void dq(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.aOr = (TextView) findViewById(a.f.dialog_message);
        this.aOs = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.aOt = (TextView) findViewById(a.f.positive_button);
        this.aOu = (TextView) findViewById(a.f.negative_button);
        this.aOv = (TextView) findViewById(a.f.neutral_button);
        this.aOx = findViewById(a.f.divider3);
        this.aOy = findViewById(a.f.divider4);
        this.aOz = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(a.f.dialog_icon);
        this.aOA = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.aOw = findViewById(a.f.divider2);
        this.aJx = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.aOC = (LinearLayout) findViewById(a.f.btn_panel);
        this.aOD = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.aOB.aOT > 0) {
            this.aJx.getLayoutParams().height = this.aOB.aOT;
        }
        if (com.baidu.swan.apps.an.a.Pj() || com.baidu.swan.apps.an.a.Pi()) {
            int dimensionPixelSize = this.aOr.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.aOr.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.aOB != null) {
            a aVar = this.aOB;
            setTitle(aVar.title);
            setIcon(aVar.aOL);
            setMessage(aVar.message);
            setView(aVar.contentView);
            bW(aVar.aOM);
            dr(aVar.aON);
            gy(aVar.aOJ);
            gz(aVar.aOK);
            bX(aVar.aOU);
        }
    }

    public TextView Ls() {
        int i;
        TextView textView;
        if (this.aOt == null || this.aOt.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.aOt;
            i = 1;
        }
        if (this.aOu != null && this.aOu.getVisibility() == 0) {
            i++;
            textView = this.aOu;
        }
        if (this.aOv != null && this.aOv.getVisibility() == 0) {
            i++;
            textView = this.aOv;
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
        this.aOA.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.aOr.setTextColor(color2);
        this.aOt.setTextColor(color);
        this.aOu.setTextColor(color);
        this.aOv.setTextColor(color);
        this.aOw.setBackgroundColor(color3);
        this.aOx.setBackgroundColor(color3);
        this.aOy.setBackgroundColor(color3);
        this.aOt.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.aOu.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.aOv.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView Ls = Ls();
        if (Ls != null) {
            Ls.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        this.aOr.setText(charSequence);
        this.aOs.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aOD);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.aOC.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.aOz != null) {
            this.aOz.removeAllViews();
            if (view != null) {
                this.aOz.addView(view);
                this.aOs.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aOD);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.aOC.setLayoutParams(layoutParams);
            }
        }
    }

    protected void bW(boolean z) {
        this.aOt.setEnabled(z);
    }

    protected void dr(int i) {
        this.aOt.setTextColor(i);
    }

    protected void gy(String str) {
        this.aOt.setText(str);
        this.aOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.dq(-1);
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aOt.setVisibility(8);
            if (this.aOu.getVisibility() == 0) {
                this.aOx.setVisibility(8);
                return;
            }
            return;
        }
        this.aOt.setVisibility(0);
        if (this.aOu.getVisibility() == 0) {
            this.aOx.setVisibility(0);
        }
    }

    protected void gz(String str) {
        this.aOu.setText(str);
        this.aOu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.dq(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aOu.setVisibility(8);
            if (this.aOt.getVisibility() == 0) {
                this.aOx.setVisibility(8);
                return;
            }
            return;
        }
        this.aOu.setVisibility(0);
        if (this.aOt.getVisibility() == 0) {
            this.aOx.setVisibility(0);
        }
    }

    protected void bX(boolean z) {
        if (z) {
            this.aOC.setVisibility(8);
            this.aOw.setVisibility(8);
        }
    }

    private void release() {
        if (this.aOB != null) {
            EventBusWrapper.unregister(this.aOB);
            this.aOB.release();
            this.aOB = null;
        }
        setView(null);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aOF = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aOG = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> aOH = new HashMap<>();
        private static ArrayList aOI = new ArrayList();
        private String aOJ;
        private String aOK;
        private Drawable aOL;
        private boolean aOM;
        private int aON;
        private DialogInterface.OnClickListener aOO;
        private DialogInterface.OnClickListener aOP;
        private DialogInterface.OnCancelListener aOQ;
        private DialogInterface.OnDismissListener aOR;
        private Class<? extends Activity> aOS;
        private int aOT;
        private boolean aOU;
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
            this.aOM = true;
            this.aOT = -1;
            this.mContext = AppRuntime.getAppContext();
            this.aOS = cls;
        }

        public a ds(int i) {
            return gA(this.mContext.getString(i));
        }

        public a gA(String str) {
            this.title = str;
            return this;
        }

        public a gB(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.aOJ = str;
            this.aOO = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.aOR = onDismissListener;
            return this;
        }

        void release() {
            aOI.remove(this.mTag);
            this.aOO = null;
            this.aOP = null;
            this.aOQ = null;
            this.aOR = null;
            this.contentView = null;
            this.aOL = null;
        }

        public void show() {
            show(false);
        }

        public void show(final boolean z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.a.1
                @Override // java.lang.Runnable
                public void run() {
                    Context appContext = AppRuntime.getAppContext();
                    if (a.this.aOS == null) {
                        a.this.aOS = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.aOS);
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

        static a gC(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (aOH) {
                    remove = aOH.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (aOH) {
                    aOH.put(str, aVar);
                }
            }
        }

        public void onEvent(b bVar) {
            if (bVar != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (bVar.aOY) {
                    case -2:
                        onClickListener = this.aOP;
                        break;
                    case -1:
                        onClickListener = this.aOO;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(bVar.aOX, bVar.aOY);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class b {
            private DialogInterface aOX;
            private int aOY;

            public b(DialogInterface dialogInterface, int i) {
                this.aOX = dialogInterface;
                this.aOY = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0179a {
            private Object tag;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources Fh = com.baidu.swan.apps.u.a.EJ().Fh();
        return Fh != null ? Fh : super.getResources();
    }
}
