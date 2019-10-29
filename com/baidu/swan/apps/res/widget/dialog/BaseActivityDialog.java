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
    private SwanAppScrollView bcL;
    private TextView bhA;
    private TextView bhB;
    private TextView bhC;
    private View bhD;
    private View bhE;
    private View bhF;
    private FrameLayout bhG;
    private RelativeLayout bhH;
    private a bhI;
    private LinearLayout bhJ;
    private int bhK;
    private TextView bhy;
    private LinearLayout bhz;
    private ImageView mIcon;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.bhI = a.hg(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.bhI == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        EventBusWrapper.register(this.bhI, a.b.class, new rx.functions.b<a.b>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.b bVar) {
                BaseActivityDialog.this.bhI.onEvent(bVar);
            }
        });
        EventBusWrapper.register(this.bhI, a.C0211a.class, new rx.functions.b<a.C0211a>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.C0211a c0211a) {
                if (c0211a.tag == BaseActivityDialog.this.bhI.mTag) {
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
        if (this.bhI != null && (onCancelListener = this.bhI.bhX) != null) {
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
        if (this.bhI != null && (onDismissListener = this.bhI.bhY) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void el(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.bhy = (TextView) findViewById(a.f.dialog_message);
        this.bhz = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.bhA = (TextView) findViewById(a.f.positive_button);
        this.bhB = (TextView) findViewById(a.f.negative_button);
        this.bhC = (TextView) findViewById(a.f.neutral_button);
        this.bhE = findViewById(a.f.divider3);
        this.bhF = findViewById(a.f.divider4);
        this.bhG = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(a.f.dialog_icon);
        this.bhH = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.bhD = findViewById(a.f.divider2);
        this.bcL = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.bhJ = (LinearLayout) findViewById(a.f.btn_panel);
        this.bhK = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.bhI.bia > 0) {
            this.bcL.getLayoutParams().height = this.bhI.bia;
        }
        if (com.baidu.swan.apps.an.a.TZ() || com.baidu.swan.apps.an.a.TY()) {
            int dimensionPixelSize = this.bhy.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.bhy.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.bhI != null) {
            a aVar = this.bhI;
            setTitle(aVar.title);
            setIcon(aVar.bhS);
            setMessage(aVar.message);
            setView(aVar.contentView);
            cn(aVar.bhT);
            em(aVar.bhU);
            hc(aVar.bhQ);
            hd(aVar.bhR);
            co(aVar.bib);
        }
    }

    public TextView Ql() {
        int i;
        TextView textView;
        if (this.bhA == null || this.bhA.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.bhA;
            i = 1;
        }
        if (this.bhB != null && this.bhB.getVisibility() == 0) {
            i++;
            textView = this.bhB;
        }
        if (this.bhC != null && this.bhC.getVisibility() == 0) {
            i++;
            textView = this.bhC;
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
        this.bhH.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.bhy.setTextColor(color2);
        this.bhA.setTextColor(color);
        this.bhB.setTextColor(color);
        this.bhC.setTextColor(color);
        this.bhD.setBackgroundColor(color3);
        this.bhE.setBackgroundColor(color3);
        this.bhF.setBackgroundColor(color3);
        this.bhA.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.bhB.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.bhC.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView Ql = Ql();
        if (Ql != null) {
            Ql.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        this.bhy.setText(charSequence);
        this.bhz.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.bhK);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.bhJ.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.bhG != null) {
            this.bhG.removeAllViews();
            if (view != null) {
                this.bhG.addView(view);
                this.bhz.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.bhK);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.bhJ.setLayoutParams(layoutParams);
            }
        }
    }

    protected void cn(boolean z) {
        this.bhA.setEnabled(z);
    }

    protected void em(int i) {
        this.bhA.setTextColor(i);
    }

    protected void hc(String str) {
        this.bhA.setText(str);
        this.bhA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.el(-1);
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.bhA.setVisibility(8);
            if (this.bhB.getVisibility() == 0) {
                this.bhE.setVisibility(8);
                return;
            }
            return;
        }
        this.bhA.setVisibility(0);
        if (this.bhB.getVisibility() == 0) {
            this.bhE.setVisibility(0);
        }
    }

    protected void hd(String str) {
        this.bhB.setText(str);
        this.bhB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.el(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.bhB.setVisibility(8);
            if (this.bhA.getVisibility() == 0) {
                this.bhE.setVisibility(8);
                return;
            }
            return;
        }
        this.bhB.setVisibility(0);
        if (this.bhA.getVisibility() == 0) {
            this.bhE.setVisibility(0);
        }
    }

    protected void co(boolean z) {
        if (z) {
            this.bhJ.setVisibility(8);
            this.bhD.setVisibility(8);
        }
    }

    private void release() {
        if (this.bhI != null) {
            EventBusWrapper.unregister(this.bhI);
            this.bhI.release();
            this.bhI = null;
        }
        setView(null);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int bhM = a.h.aiapps_dialog_negative_title_cancel;
        public static final int bhN = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> bhO = new HashMap<>();
        private static ArrayList bhP = new ArrayList();
        private String bhQ;
        private String bhR;
        private Drawable bhS;
        private boolean bhT;
        private int bhU;
        private DialogInterface.OnClickListener bhV;
        private DialogInterface.OnClickListener bhW;
        private DialogInterface.OnCancelListener bhX;
        private DialogInterface.OnDismissListener bhY;
        private Class<? extends Activity> bhZ;
        private int bia;
        private boolean bib;
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
            this.bhT = true;
            this.bia = -1;
            this.mContext = AppRuntime.getAppContext();
            this.bhZ = cls;
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
            this.bhQ = str;
            this.bhV = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.bhY = onDismissListener;
            return this;
        }

        void release() {
            bhP.remove(this.mTag);
            this.bhV = null;
            this.bhW = null;
            this.bhX = null;
            this.bhY = null;
            this.contentView = null;
            this.bhS = null;
        }

        public void show() {
            show(false);
        }

        public void show(final boolean z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.a.1
                @Override // java.lang.Runnable
                public void run() {
                    Context appContext = AppRuntime.getAppContext();
                    if (a.this.bhZ == null) {
                        a.this.bhZ = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.bhZ);
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
                synchronized (bhO) {
                    remove = bhO.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (bhO) {
                    bhO.put(str, aVar);
                }
            }
        }

        public void onEvent(b bVar) {
            if (bVar != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (bVar.bih) {
                    case -2:
                        onClickListener = this.bhW;
                        break;
                    case -1:
                        onClickListener = this.bhV;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(bVar.bif, bVar.bih);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class b {
            private DialogInterface bif;
            private int bih;

            public b(DialogInterface dialogInterface, int i) {
                this.bif = dialogInterface;
                this.bih = i;
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
        Resources Kb = com.baidu.swan.apps.u.a.JD().Kb();
        return Kb != null ? Kb : super.getResources();
    }
}
