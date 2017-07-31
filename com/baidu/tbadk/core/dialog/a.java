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
    private String abB;
    private String abC;
    private b abF;
    private b abG;
    private DialogInterface.OnCancelListener abH;
    private DialogInterface.OnKeyListener abI;
    private AlertDialog abJ;
    private final ViewGroup abK;
    private ViewGroup abL;
    private Object abO;
    private TextView abP;
    private TextView abQ;
    private View abR;
    private View abS;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int aby = -1;
    private boolean abz = false;
    private boolean abA = false;
    private int abD = -1;
    private int abE = 0;
    private boolean abM = false;
    private boolean abN = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cS(String str) {
        this.mTitle = str;
        return this;
    }

    public a cb(int i) {
        cS(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cT(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.abH = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.abB = str;
        this.abF = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.abC = str;
        this.abG = bVar;
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
            this.abB = this.mActivity.getResources().getString(i);
            this.abF = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.abC = this.mActivity.getResources().getString(i);
            this.abG = bVar;
        }
        return this;
    }

    public a ar(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a as(boolean z) {
        this.abN = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.abK = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdalert, (ViewGroup) null);
        this.abL = (ViewGroup) this.abK.findViewById(d.h.real_view);
    }

    public a cd(int i) {
        if (isAutoNight()) {
            this.abD = ai.getColor(i);
        } else {
            this.abD = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ce(int i) {
        this.abE = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.abM) {
            this.abM = true;
            LinearLayout linearLayout = (LinearLayout) this.abK.findViewById(d.h.dialog_content);
            this.abP = (TextView) this.abK.findViewById(d.h.yes);
            this.abQ = (TextView) this.abK.findViewById(d.h.no);
            this.abR = this.abK.findViewById(d.h.divider_yes_no_button);
            this.abS = this.abK.findViewById(d.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View view = to();
                if (view != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(view);
                }
            }
            c(eVar);
            if (this.abD != -1) {
                if (this.abP != null) {
                    this.abP.setTextColor(this.abD);
                }
                if (this.abQ != null) {
                    this.abQ.setTextColor(this.abD);
                }
            }
            if (TextUtils.isEmpty(this.abB) || this.abP == null) {
                z = false;
            } else {
                this.abP.setText(this.abB);
                this.abP.setTag(this.abO);
                if (this.abF != null) {
                    this.abP.setOnClickListener(new View$OnClickListenerC0042a(this, this.abF));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.abC) || this.abQ == null) {
                z2 = false;
            } else {
                this.abQ.setText(this.abC);
                if (this.abG != null) {
                    this.abQ.setOnClickListener(new View$OnClickListenerC0042a(this, this.abG));
                }
            }
            g(z, z2);
        }
        return this;
    }

    public View to() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.h.message_view);
                if (this.abz) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.abA) {
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
            ((TbPageContext) eVar).getLayoutMode().t(this.abK);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.abK != null) {
            this.abK.setBackgroundResource(d.g.transparent_bg);
        }
    }

    private void g(boolean z, boolean z2) {
        if (z && z2) {
            if (this.abR != null) {
                this.abR.setVisibility(0);
            }
            if (this.abS != null) {
                this.abS.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.abR != null) {
            this.abR.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.abP != null && this.abQ != null && this.abR != null && this.abS != null) {
                this.abP.setVisibility(8);
                this.abQ.setVisibility(8);
                this.abR.setVisibility(8);
                this.abS.setVisibility(8);
            }
        } else if (z) {
            ai.d(this.abP, d.g.dialog_single_button_bg_selector, skinType);
            if (this.abQ != null && this.abR != null && this.abS != null) {
                this.abS.setVisibility(0);
                this.abP.setVisibility(0);
                this.abQ.setVisibility(8);
            }
        } else if (z2) {
            ai.d(this.abQ, d.g.dialog_single_button_bg_selector, skinType);
            if (this.abP != null && this.abR != null && this.abS != null) {
                this.abS.setVisibility(0);
                this.abQ.setVisibility(0);
                this.abP.setVisibility(8);
            }
        } else if (this.abP != null && this.abQ != null && this.abS != null) {
            this.abS.setVisibility(8);
            this.abP.setVisibility(8);
            this.abQ.setVisibility(8);
        }
    }

    public a tp() {
        return at(false);
    }

    private a at(boolean z) {
        if (!this.abM) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abJ != null) {
            if (z) {
                g.a(this.abJ, this.mActivity);
            } else {
                this.abJ.show();
            }
        } else {
            this.abJ = new AlertDialog.Builder(this.mActivity).create();
            this.abJ.setCanceledOnTouchOutside(this.abN && !this.mCancelable);
            this.abJ.setCancelable(this.mCancelable);
            this.abJ.setOnKeyListener(this.abI);
            if (this.abH != null) {
                this.abJ.setOnCancelListener(this.abH);
            }
            if (z) {
                g.a(this.abJ, this.mActivity);
            } else {
                this.abJ.show();
            }
            if (this.abJ.getWindow().getDecorView().getParent() != null) {
                Window window = this.abJ.getWindow();
                if (this.aby == -1) {
                    this.aby = 17;
                }
                window.setGravity(this.aby);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = k.o(this.mActivity);
                if (o != null) {
                    int tq = tq();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (tq * 2);
                    } else {
                        attributes.width = o.widthPixels - (tq * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.abK);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                aw.a(this.abK, false, new aw.a() { // from class: com.baidu.tbadk.core.dialog.a.1
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

    public int tq() {
        return this.abE == 1 ? k.g(this.mActivity, d.f.ds40) : k.g(this.mActivity, d.f.ds90);
    }

    public boolean isShowing() {
        if (this.abJ != null) {
            return this.abJ.isShowing();
        }
        return false;
    }

    public void au(boolean z) {
        if (this.abP != null) {
            this.abP.setClickable(z);
        }
    }

    public void av(boolean z) {
        if (this.abQ != null) {
            this.abQ.setClickable(z);
        }
    }

    public a tr() {
        return at(true);
    }

    public void hide() {
        if (this.abJ != null) {
            this.abJ.hide();
        }
    }

    public void dismiss() {
        if (this.abJ != null) {
            g.b(this.abJ, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0042a implements View.OnClickListener {
        private final a Ml;
        private final b abV;

        public View$OnClickListenerC0042a(a aVar, b bVar) {
            this.Ml = aVar;
            this.abV = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.abV != null) {
                this.abV.onClick(this.Ml);
            }
        }
    }

    public ViewGroup ts() {
        return this.abL;
    }

    public void A(Object obj) {
        this.abO = obj;
    }

    public Object tt() {
        return this.abO;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.abJ.getWindow();
    }

    public Dialog getDialog() {
        return this.abJ;
    }

    public void aw(boolean z) {
        this.abz = z;
    }

    public void ax(boolean z) {
        this.abA = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.abI = onKeyListener;
    }

    public void reset() {
        this.abM = false;
    }
}
