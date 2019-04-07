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
    private SwanAppScrollView aGx;
    private a aLA;
    private LinearLayout aLB;
    private int aLC;
    private TextView aLq;
    private LinearLayout aLr;
    private TextView aLs;
    private TextView aLt;
    private TextView aLu;
    private View aLv;
    private View aLw;
    private View aLx;
    private FrameLayout aLy;
    private RelativeLayout aLz;
    private ImageView mIcon;
    private TextView mTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
        this.aLA = a.gc(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        if (this.aLA == null) {
            if (DEBUG) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        EventBusWrapper.register(this.aLA, a.b.class, new rx.functions.b<a.b>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.b bVar) {
                BaseActivityDialog.this.aLA.onEvent(bVar);
            }
        });
        EventBusWrapper.register(this.aLA, a.C0162a.class, new rx.functions.b<a.C0162a>() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(a.C0162a c0162a) {
                if (c0162a.tag == BaseActivityDialog.this.aLA.mTag) {
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
        if (this.aLA != null && (onCancelListener = this.aLA.aLO) != null) {
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
        if (this.aLA != null && (onDismissListener = this.aLA.aLP) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    protected void dh(int i) {
    }

    protected void initViews() {
        this.mTitle = (TextView) findViewById(a.f.dialog_title);
        this.aLq = (TextView) findViewById(a.f.dialog_message);
        this.aLr = (LinearLayout) findViewById(a.f.dialog_message_content);
        this.aLs = (TextView) findViewById(a.f.positive_button);
        this.aLt = (TextView) findViewById(a.f.negative_button);
        this.aLu = (TextView) findViewById(a.f.neutral_button);
        this.aLw = findViewById(a.f.divider3);
        this.aLx = findViewById(a.f.divider4);
        this.aLy = (FrameLayout) findViewById(a.f.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(a.f.dialog_icon);
        this.aLz = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.aLv = findViewById(a.f.divider2);
        this.aGx = (SwanAppScrollView) findViewById(a.f.message_scrollview);
        this.aLB = (LinearLayout) findViewById(a.f.btn_panel);
        this.aLC = getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        if (this.aLA.aLR > 0) {
            this.aGx.getLayoutParams().height = this.aLA.aLR;
        }
        if (com.baidu.swan.apps.an.a.LJ() || com.baidu.swan.apps.an.a.LI()) {
            int dimensionPixelSize = this.aLq.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
            this.aLq.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    protected void setupViews() {
        if (this.aLA != null) {
            a aVar = this.aLA;
            setTitle(aVar.title);
            setIcon(aVar.icon);
            setMessage(aVar.message);
            setView(aVar.contentView);
            bK(aVar.aLK);
            di(aVar.aLL);
            fY(aVar.aLI);
            fZ(aVar.aLJ);
            bL(aVar.aLS);
        }
    }

    public TextView Il() {
        int i;
        TextView textView;
        if (this.aLs == null || this.aLs.getVisibility() != 0) {
            i = 0;
            textView = null;
        } else {
            textView = this.aLs;
            i = 1;
        }
        if (this.aLt != null && this.aLt.getVisibility() == 0) {
            i++;
            textView = this.aLt;
        }
        if (this.aLu != null && this.aLu.getVisibility() == 0) {
            i++;
            textView = this.aLu;
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
        this.aLz.setBackground(resources.getDrawable(a.e.aiapps_dialog_bg_white));
        this.mTitle.setTextColor(color);
        this.aLq.setTextColor(color2);
        this.aLs.setTextColor(color);
        this.aLt.setTextColor(color);
        this.aLu.setTextColor(color);
        this.aLv.setBackgroundColor(color3);
        this.aLw.setBackgroundColor(color3);
        this.aLx.setBackgroundColor(color3);
        this.aLs.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
        this.aLt.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
        this.aLu.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_selector));
        TextView Il = Il();
        if (Il != null) {
            Il.setBackground(resources.getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
        this.aLq.setText(charSequence);
        this.aLr.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLC);
        layoutParams.addRule(3, a.f.dialog_message_content);
        this.aLB.setLayoutParams(layoutParams);
    }

    protected void setView(View view) {
        if (this.aLy != null) {
            this.aLy.removeAllViews();
            if (view != null) {
                this.aLy.addView(view);
                this.aLr.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLC);
                layoutParams.addRule(3, a.f.dialog_customPanel);
                this.aLB.setLayoutParams(layoutParams);
            }
        }
    }

    protected void bK(boolean z) {
        this.aLs.setEnabled(z);
    }

    protected void di(int i) {
        this.aLs.setTextColor(i);
    }

    protected void fY(String str) {
        this.aLs.setText(str);
        this.aLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.dh(-1);
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aLs.setVisibility(8);
            if (this.aLt.getVisibility() == 0) {
                this.aLw.setVisibility(8);
                return;
            }
            return;
        }
        this.aLs.setVisibility(0);
        if (this.aLt.getVisibility() == 0) {
            this.aLw.setVisibility(0);
        }
    }

    protected void fZ(String str) {
        this.aLt.setText(str);
        this.aLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseActivityDialog.this.dh(-2);
                BaseActivityDialog.this.dismiss();
                EventBusWrapper.post(new a.b(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.aLt.setVisibility(8);
            if (this.aLs.getVisibility() == 0) {
                this.aLw.setVisibility(8);
                return;
            }
            return;
        }
        this.aLt.setVisibility(0);
        if (this.aLs.getVisibility() == 0) {
            this.aLw.setVisibility(0);
        }
    }

    protected void bL(boolean z) {
        if (z) {
            this.aLB.setVisibility(8);
            this.aLv.setVisibility(8);
        }
    }

    private void release() {
        if (this.aLA != null) {
            EventBusWrapper.unregister(this.aLA);
            this.aLA.release();
            this.aLA = null;
        }
        setView(null);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aLE = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aLF = a.h.aiapps_dialog_positive_title_ok;
        private static HashMap<String, a> aLG = new HashMap<>();
        private static ArrayList aLH = new ArrayList();
        private String aLI;
        private String aLJ;
        private boolean aLK;
        private int aLL;
        private DialogInterface.OnClickListener aLM;
        private DialogInterface.OnClickListener aLN;
        private DialogInterface.OnCancelListener aLO;
        private DialogInterface.OnDismissListener aLP;
        private Class<? extends Activity> aLQ;
        private int aLR;
        private boolean aLS;
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
            this.aLK = true;
            this.aLR = -1;
            this.mContext = AppRuntime.getAppContext();
            this.aLQ = cls;
        }

        public a dj(int i) {
            return ga(this.mContext.getString(i));
        }

        public a ga(String str) {
            this.title = str;
            return this;
        }

        public a gb(String str) {
            this.message = str;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getString(i), onClickListener);
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            this.aLI = str;
            this.aLM = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.aLP = onDismissListener;
            return this;
        }

        void release() {
            aLH.remove(this.mTag);
            this.aLM = null;
            this.aLN = null;
            this.aLO = null;
            this.aLP = null;
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
                    if (a.this.aLQ == null) {
                        a.this.aLQ = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, a.this.aLQ);
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

        static a gc(String str) {
            a remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (aLG) {
                    remove = aLG.remove(str);
                }
                return remove;
            }
            return null;
        }

        static void a(String str, a aVar) {
            if (!TextUtils.isEmpty(str) && aVar != null) {
                synchronized (aLG) {
                    aLG.put(str, aVar);
                }
            }
        }

        public void onEvent(b bVar) {
            if (bVar != null) {
                DialogInterface.OnClickListener onClickListener = null;
                switch (bVar.aLW) {
                    case -2:
                        onClickListener = this.aLN;
                        break;
                    case -1:
                        onClickListener = this.aLM;
                        break;
                }
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(bVar.aLV, bVar.aLW);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class b {
            private DialogInterface aLV;
            private int aLW;

            public b(DialogInterface dialogInterface, int i) {
                this.aLV = dialogInterface;
                this.aLW = i;
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
        Resources Dp = com.baidu.swan.apps.u.a.CR().Dp();
        return Dp != null ? Dp : super.getResources();
    }
}
