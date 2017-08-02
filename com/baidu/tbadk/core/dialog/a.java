package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String aae;
    private String aaf;
    private b aai;
    private b aaj;
    private DialogInterface.OnCancelListener aak;
    private DialogInterface.OnKeyListener aal;
    private AlertDialog aam;
    private final ViewGroup aan;
    private ViewGroup aao;
    private Object aar;
    private TextView aas;
    private TextView aat;
    private View aau;
    private View aav;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int aab = -1;
    private boolean aac = false;
    private boolean aad = false;
    private int aag = -1;
    private int aah = 0;
    private boolean aap = false;
    private boolean aaq = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cM(String str) {
        this.mTitle = str;
        return this;
    }

    public a bZ(int i) {
        cM(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cN(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.aak = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aae = str;
        this.aai = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aaf = str;
        this.aaj = bVar;
        return this;
    }

    public a ca(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aae = this.mActivity.getResources().getString(i);
            this.aai = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aaf = this.mActivity.getResources().getString(i);
            this.aaj = bVar;
        }
        return this;
    }

    public a ar(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a as(boolean z) {
        this.aaq = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.aan = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdalert, (ViewGroup) null);
        this.aao = (ViewGroup) this.aan.findViewById(d.h.real_view);
    }

    public a cb(int i) {
        if (isAutoNight()) {
            this.aag = ai.getColor(i);
        } else {
            this.aag = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cc(int i) {
        this.aah = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aap) {
            this.aap = true;
            LinearLayout linearLayout = (LinearLayout) this.aan.findViewById(d.h.dialog_content);
            this.aas = (TextView) this.aan.findViewById(d.h.yes);
            this.aat = (TextView) this.aan.findViewById(d.h.no);
            this.aau = this.aan.findViewById(d.h.divider_yes_no_button);
            this.aav = this.aan.findViewById(d.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View te = te();
                if (te != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(te);
                }
            }
            c(eVar);
            if (this.aag != -1) {
                if (this.aas != null) {
                    this.aas.setTextColor(this.aag);
                }
                if (this.aat != null) {
                    this.aat.setTextColor(this.aag);
                }
            }
            if (TextUtils.isEmpty(this.aae) || this.aas == null) {
                z = false;
            } else {
                this.aas.setText(this.aae);
                this.aas.setTag(this.aar);
                if (this.aai != null) {
                    this.aas.setOnClickListener(new View$OnClickListenerC0042a(this, this.aai));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aaf) || this.aat == null) {
                z2 = false;
            } else {
                this.aat.setText(this.aaf);
                if (this.aaj != null) {
                    this.aat.setOnClickListener(new View$OnClickListenerC0042a(this, this.aaj));
                }
            }
            g(z, z2);
        }
        return this;
    }

    public View te() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.h.message_view);
                if (this.aac) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aad) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.j.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(d.h.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.aan);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.aan != null) {
            this.aan.setBackgroundResource(d.g.transparent_bg);
        }
    }

    private void g(boolean z, boolean z2) {
        if (z && z2) {
            if (this.aau != null) {
                this.aau.setVisibility(0);
            }
            if (this.aav != null) {
                this.aav.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aau != null) {
            this.aau.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aas != null && this.aat != null && this.aau != null && this.aav != null) {
                this.aas.setVisibility(8);
                this.aat.setVisibility(8);
                this.aau.setVisibility(8);
                this.aav.setVisibility(8);
            }
        } else if (z) {
            ai.d(this.aas, d.g.dialog_single_button_bg_selector, skinType);
            if (this.aat != null && this.aau != null && this.aav != null) {
                this.aav.setVisibility(0);
                this.aas.setVisibility(0);
                this.aat.setVisibility(8);
            }
        } else if (z2) {
            ai.d(this.aat, d.g.dialog_single_button_bg_selector, skinType);
            if (this.aas != null && this.aau != null && this.aav != null) {
                this.aav.setVisibility(0);
                this.aat.setVisibility(0);
                this.aas.setVisibility(8);
            }
        } else if (this.aas != null && this.aat != null && this.aav != null) {
            this.aav.setVisibility(8);
            this.aas.setVisibility(8);
            this.aat.setVisibility(8);
        }
    }

    public a tf() {
        return at(false);
    }

    private a at(boolean z) {
        if (!this.aap) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aam != null) {
            if (z) {
                g.a(this.aam, this.mActivity);
            } else {
                this.aam.show();
            }
        } else {
            this.aam = new AlertDialog.Builder(this.mActivity).create();
            this.aam.setCanceledOnTouchOutside(this.aaq && !this.mCancelable);
            this.aam.setCancelable(this.mCancelable);
            this.aam.setOnKeyListener(this.aal);
            if (this.aak != null) {
                this.aam.setOnCancelListener(this.aak);
            }
            if (z) {
                g.a(this.aam, this.mActivity);
            } else {
                this.aam.show();
            }
            if (this.aam.getWindow().getDecorView().getParent() != null) {
                Window window = this.aam.getWindow();
                if (this.aab == -1) {
                    this.aab = 17;
                }
                window.setGravity(this.aab);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = k.o(this.mActivity);
                if (o != null) {
                    int tg = tg();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (tg * 2);
                    } else {
                        attributes.width = o.widthPixels - (tg * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.aan);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                aw.a(this.aan, false, new aw.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.aw.a
                    public boolean w(View view) {
                        if (view instanceof EditText) {
                            atomicBoolean.set(true);
                            return true;
                        }
                        return false;
                    }
                });
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int tg() {
        return this.aah == 1 ? k.g(this.mActivity, d.f.ds40) : k.g(this.mActivity, d.f.ds90);
    }

    public boolean isShowing() {
        if (this.aam != null) {
            return this.aam.isShowing();
        }
        return false;
    }

    public void au(boolean z) {
        if (this.aas != null) {
            this.aas.setClickable(z);
        }
    }

    public void av(boolean z) {
        if (this.aat != null) {
            this.aat.setClickable(z);
        }
    }

    public a th() {
        return at(true);
    }

    public void hide() {
        if (this.aam != null) {
            this.aam.hide();
        }
    }

    public void dismiss() {
        if (this.aam != null) {
            g.b(this.aam, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0042a implements View.OnClickListener {
        private final a KN;
        private final b aay;

        public View$OnClickListenerC0042a(a aVar, b bVar) {
            this.KN = aVar;
            this.aay = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aay != null) {
                this.aay.onClick(this.KN);
            }
        }
    }

    public ViewGroup ti() {
        return this.aao;
    }

    public void A(Object obj) {
        this.aar = obj;
    }

    public Object tj() {
        return this.aar;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.aam.getWindow();
    }

    public Dialog getDialog() {
        return this.aam;
    }

    public void aw(boolean z) {
        this.aac = z;
    }

    public void ax(boolean z) {
        this.aad = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.aal = onKeyListener;
    }

    public void reset() {
        this.aap = false;
    }
}
