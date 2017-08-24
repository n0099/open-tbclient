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
    private String abD;
    private String abE;
    private b abH;
    private b abI;
    private DialogInterface.OnCancelListener abJ;
    private DialogInterface.OnKeyListener abK;
    private AlertDialog abL;
    private final ViewGroup abM;
    private ViewGroup abN;
    private Object abQ;
    private TextView abR;
    private TextView abS;
    private View abT;
    private View abU;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int abA = -1;
    private boolean abB = false;
    private boolean abC = false;
    private int abF = -1;
    private int abG = 0;
    private boolean abO = false;
    private boolean abP = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cV(String str) {
        this.mTitle = str;
        return this;
    }

    public a cb(int i) {
        cV(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cW(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.abJ = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.abD = str;
        this.abH = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.abE = str;
        this.abI = bVar;
        return this;
    }

    public a cc(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.abD = this.mActivity.getResources().getString(i);
            this.abH = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.abE = this.mActivity.getResources().getString(i);
            this.abI = bVar;
        }
        return this;
    }

    public a ar(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a as(boolean z) {
        this.abP = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.abM = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdalert, (ViewGroup) null);
        this.abN = (ViewGroup) this.abM.findViewById(d.h.real_view);
    }

    public a cd(int i) {
        if (isAutoNight()) {
            this.abF = ai.getColor(i);
        } else {
            this.abF = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ce(int i) {
        this.abG = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.abO) {
            this.abO = true;
            LinearLayout linearLayout = (LinearLayout) this.abM.findViewById(d.h.dialog_content);
            this.abR = (TextView) this.abM.findViewById(d.h.yes);
            this.abS = (TextView) this.abM.findViewById(d.h.no);
            this.abT = this.abM.findViewById(d.h.divider_yes_no_button);
            this.abU = this.abM.findViewById(d.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View tp = tp();
                if (tp != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(tp);
                }
            }
            c(eVar);
            if (this.abF != -1) {
                if (this.abR != null) {
                    this.abR.setTextColor(this.abF);
                }
                if (this.abS != null) {
                    this.abS.setTextColor(this.abF);
                }
            }
            if (TextUtils.isEmpty(this.abD) || this.abR == null) {
                z = false;
            } else {
                this.abR.setText(this.abD);
                this.abR.setTag(this.abQ);
                if (this.abH != null) {
                    this.abR.setOnClickListener(new View$OnClickListenerC0042a(this, this.abH));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.abE) || this.abS == null) {
                z2 = false;
            } else {
                this.abS.setText(this.abE);
                if (this.abI != null) {
                    this.abS.setOnClickListener(new View$OnClickListenerC0042a(this, this.abI));
                }
            }
            g(z, z2);
        }
        return this;
    }

    public View tp() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.h.message_view);
                if (this.abB) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.abC) {
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
            ((TbPageContext) eVar).getLayoutMode().t(this.abM);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.abM != null) {
            this.abM.setBackgroundResource(d.g.transparent_bg);
        }
    }

    private void g(boolean z, boolean z2) {
        if (z && z2) {
            if (this.abT != null) {
                this.abT.setVisibility(0);
            }
            if (this.abU != null) {
                this.abU.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.abT != null) {
            this.abT.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.abR != null && this.abS != null && this.abT != null && this.abU != null) {
                this.abR.setVisibility(8);
                this.abS.setVisibility(8);
                this.abT.setVisibility(8);
                this.abU.setVisibility(8);
            }
        } else if (z) {
            ai.d(this.abR, d.g.dialog_single_button_bg_selector, skinType);
            if (this.abS != null && this.abT != null && this.abU != null) {
                this.abU.setVisibility(0);
                this.abR.setVisibility(0);
                this.abS.setVisibility(8);
            }
        } else if (z2) {
            ai.d(this.abS, d.g.dialog_single_button_bg_selector, skinType);
            if (this.abR != null && this.abT != null && this.abU != null) {
                this.abU.setVisibility(0);
                this.abS.setVisibility(0);
                this.abR.setVisibility(8);
            }
        } else if (this.abR != null && this.abS != null && this.abU != null) {
            this.abU.setVisibility(8);
            this.abR.setVisibility(8);
            this.abS.setVisibility(8);
        }
    }

    public a tq() {
        return at(false);
    }

    private a at(boolean z) {
        if (!this.abO) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abL != null) {
            if (z) {
                g.a(this.abL, this.mActivity);
            } else {
                this.abL.show();
            }
        } else {
            this.abL = new AlertDialog.Builder(this.mActivity).create();
            this.abL.setCanceledOnTouchOutside(this.abP && !this.mCancelable);
            this.abL.setCancelable(this.mCancelable);
            this.abL.setOnKeyListener(this.abK);
            if (this.abJ != null) {
                this.abL.setOnCancelListener(this.abJ);
            }
            if (z) {
                g.a(this.abL, this.mActivity);
            } else {
                this.abL.show();
            }
            if (this.abL.getWindow().getDecorView().getParent() != null) {
                Window window = this.abL.getWindow();
                if (this.abA == -1) {
                    this.abA = 17;
                }
                window.setGravity(this.abA);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = k.o(this.mActivity);
                if (o != null) {
                    int tr = tr();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (tr * 2);
                    } else {
                        attributes.width = o.widthPixels - (tr * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.abM);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                aw.a(this.abM, false, new aw.a() { // from class: com.baidu.tbadk.core.dialog.a.1
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

    public int tr() {
        return this.abG == 1 ? k.g(this.mActivity, d.f.ds40) : k.g(this.mActivity, d.f.ds90);
    }

    public boolean isShowing() {
        if (this.abL != null) {
            return this.abL.isShowing();
        }
        return false;
    }

    public void au(boolean z) {
        if (this.abR != null) {
            this.abR.setClickable(z);
        }
    }

    public void av(boolean z) {
        if (this.abS != null) {
            this.abS.setClickable(z);
        }
    }

    public a ts() {
        return at(true);
    }

    public void hide() {
        if (this.abL != null) {
            this.abL.hide();
        }
    }

    public void dismiss() {
        if (this.abL != null) {
            g.b(this.abL, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0042a implements View.OnClickListener {
        private final a Mn;
        private final b abX;

        public View$OnClickListenerC0042a(a aVar, b bVar) {
            this.Mn = aVar;
            this.abX = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.abX != null) {
                this.abX.onClick(this.Mn);
            }
        }
    }

    public ViewGroup tt() {
        return this.abN;
    }

    public void A(Object obj) {
        this.abQ = obj;
    }

    public Object tu() {
        return this.abQ;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.abL.getWindow();
    }

    public Dialog getDialog() {
        return this.abL;
    }

    public void aw(boolean z) {
        this.abB = z;
    }

    public void ax(boolean z) {
        this.abC = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.abK = onKeyListener;
    }

    public void reset() {
        this.abO = false;
    }
}
