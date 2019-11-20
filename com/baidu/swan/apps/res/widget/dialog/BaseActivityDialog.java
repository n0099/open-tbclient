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
    private SwanAppScrollView bct;
    private TextView bhg;
    private LinearLayout bhh;
    private TextView bhi;
    private TextView bhj;
    private TextView bhk;
    private View bhl;
    private View bhm;
    private View bhn;
    private FrameLayout bho;
    private RelativeLayout bhp;
    private a bhq;
    private LinearLayout bhr;
    private int bhs;
    private ImageView mIcon;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.bhq = a.hg(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.bhq == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        EventBusWrapper.register(this.bhq, a.b.class, new rx.functions.b<a.b>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.b bVar) {
                BaseActivityDialog.this.bhq.onEvent(bVar);
            }
        });
        EventBusWrapper.register(this.bhq, a.C0211a.class, new rx.functions.b<a.C0211a>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.C0211a c0211a) {
                if (c0211a.tag == BaseActivityDialog.this.bhq.mTag) {
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
        if (this.bhq != null && (onCancelListener = this.bhq.bhF) != null) {
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
        if (this.bhq != null && (onDismissListener = this.bhq.bhG) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void el(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.bhg = (TextView) findViewById(a.f.dialog_message);
        this.bhh = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.bhi = (TextView) findViewById(a.f.positive_button);
        this.bhj = (TextView) findViewById(a.f.negative_button);
        this.bhk = (TextView) findViewById(a.f.neutral_button);
        this.bhm = findViewById(a.f.divider3);
        this.bhn = findViewById(a.f.divider4);
        this.bho = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(a.f.dialog_icon);
        this.bhp = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.bhl = findViewById(a.f.divider2);
        this.bct = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.bhr = (LinearLayout) findViewById(a.f.btn_panel);
        this.bhs = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.bhq.bhI > 0) {
            this.bct.getLayoutParams().height = this.bhq.bhI;
        }
        if (com.baidu.swan.apps.an.a.TX() || com.baidu.swan.apps.an.a.TW()) {
            int dimensionPixelSize = this.bhg.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.bhg.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.bhq != null) {
            a aVar = this.bhq;
            setTitle(aVar.title);
            setIcon(aVar.bhA);
            setMessage(aVar.message);
            setView(aVar.contentView);
            cn(aVar.bhB);
            em(aVar.bhC);
            hc(aVar.bhy);
            hd(aVar.bhz);
            co(aVar.bhJ);
        }
    }

    public TextView Qm() {
        int i;
        TextView textView;
        if (this.bhi == null || this.bhi.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.bhi;
            i = 1;
        }
        if (this.bhj != null && this.bhj.getVisibility() == 0) {
            i++;
            textView = this.bhj;
        }
        if (this.bhk != null && this.bhk.getVisibility() == 0) {
            i++;
            textView = this.bhk;
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
        this.bhp.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.bhg.setTextColor(color2);
        this.bhi.setTextColor(color);
        this.bhj.setTextColor(color);
        this.bhk.setTextColor(color);
        this.bhl.setBackgroundColor(color3);
        this.bhm.setBackgroundColor(color3);
        this.bhn.setBackgroundColor(color3);
        this.bhi.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.bhj.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.bhk.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView Qm = Qm();
        if (Qm != null) {
            Qm.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        this.bhg.setText(charSequence);
        this.bhh.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.bhs);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.bhr.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.bho != null) {
            this.bho.removeAllViews();
            if (view != null) {
                this.bho.addView(view);
                this.bhh.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.bhs);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.bhr.setLayoutParams(layoutParams);
            }
        }
    }

    protected void cn(boolean z) {
        this.bhi.setEnabled(z);
    }

    protected void em(int i) {
        this.bhi.setTextColor(i);
    }

    protected void hc(String str) {
        this.bhi.setText(str);
        this.bhi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.el(-1);
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.bhi.setVisibility(8);
            if (this.bhj.getVisibility() == 0) {
                this.bhm.setVisibility(8);
                return;
            }
            return;
        }
        this.bhi.setVisibility(0);
        if (this.bhj.getVisibility() == 0) {
            this.bhm.setVisibility(0);
        }
    }

    protected void hd(String str) {
        this.bhj.setText(str);
        this.bhj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.el(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.bhj.setVisibility(8);
            if (this.bhi.getVisibility() == 0) {
                this.bhm.setVisibility(8);
                return;
            }
            return;
        }
        this.bhj.setVisibility(0);
        if (this.bhi.getVisibility() == 0) {
            this.bhm.setVisibility(0);
        }
    }

    protected void co(boolean z) {
        if (z) {
            this.bhr.setVisibility(8);
            this.bhl.setVisibility(8);
        }
    }

    private void release() {
        if (this.bhq != null) {
            EventBusWrapper.unregister(this.bhq);
            this.bhq.release();
            this.bhq = null;
        }
        setView(null);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int bhu = a.h.aiapps_dialog_negative_title_cancel;
        public static final int bhv = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> bhw = new HashMap<>();
        private static ArrayList bhx = new ArrayList();
        private Drawable bhA;
        private boolean bhB;
        private int bhC;
        private DialogInterface.OnClickListener bhD;
        private DialogInterface.OnClickListener bhE;
        private DialogInterface.OnCancelListener bhF;
        private DialogInterface.OnDismissListener bhG;
        private Class<? extends Activity> bhH;
        private int bhI;
        private boolean bhJ;
        private String bhy;
        private String bhz;
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
            this.bhB = true;
            this.bhI = -1;
            this.mContext = AppRuntime.getAppContext();
            this.bhH = cls;
        }

        public a en(int i) {
            return he(this.mContext.getString(i));
        }

        public a he(String str) {
            this.title = str;
            return this;
        }

        public a hf(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.bhy = str;
            this.bhD = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.bhG = onDismissListener;
            return this;
        }

        void release() {
            bhx.remove(this.mTag);
            this.bhD = null;
            this.bhE = null;
            this.bhF = null;
            this.bhG = null;
            this.contentView = null;
            this.bhA = null;
        }

        public void show() {
            show(false);
        }

        public void show(final boolean z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.a.1
                @Override // java.lang.Runnable
                public void run() {
                    Context appContext = AppRuntime.getAppContext();
                    if (a.this.bhH == null) {
                        a.this.bhH = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.bhH);
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
                    com.baidu.swan.apps.an.b.e(appContext, intent);
                }
            });
        }

        static a hg(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (bhw) {
                    remove = bhw.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (bhw) {
                    bhw.put(str, aVar);
                }
            }
        }

        public void onEvent(b bVar) {
            if (bVar != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (bVar.bhN) {
                    case -2:
                        onClickListener = this.bhE;
                        break;
                    case -1:
                        onClickListener = this.bhD;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(bVar.bhM, bVar.bhN);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class b {
            private DialogInterface bhM;
            private int bhN;

            public b(DialogInterface dialogInterface, int i) {
                this.bhM = dialogInterface;
                this.bhN = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0211a {
            private Object tag;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources Kc = com.baidu.swan.apps.u.a.JE().Kc();
        return Kc != null ? Kc : super.getResources();
    }
}
