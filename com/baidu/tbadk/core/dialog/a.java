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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String aaS;
    private String aaT;
    private b aaW;
    private b aaX;
    private DialogInterface.OnCancelListener aaY;
    private DialogInterface.OnKeyListener aaZ;
    private AlertDialog aba;
    private ViewGroup abb;
    private Object abf;
    private TextView abg;
    private TextView abh;
    private View abi;
    private View abj;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aaP = -1;
    private boolean aaQ = false;
    private boolean aaR = false;
    private int aaU = -1;
    private int aaV = 0;
    private boolean abd = false;
    private boolean abe = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cR(String str) {
        this.mTitle = str;
        return this;
    }

    public a cb(int i) {
        cR(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cS(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.aaY = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aaS = str;
        this.aaW = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aaT = str;
        this.aaX = bVar;
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
            this.aaS = this.mActivity.getResources().getString(i);
            this.aaW = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aaT = this.mActivity.getResources().getString(i);
            this.aaX = bVar;
        }
        return this;
    }

    public a ao(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ap(boolean z) {
        this.abe = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.abb = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a cd(int i) {
        if (isAutoNight()) {
            this.aaU = aj.getColor(i);
        } else {
            this.aaU = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ce(int i) {
        this.aaV = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.abd) {
            this.abd = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.abg = (TextView) this.mRootView.findViewById(d.g.yes);
            this.abh = (TextView) this.mRootView.findViewById(d.g.no);
            this.abi = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.abj = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
            if (this.aaU != -1) {
                if (this.abg != null) {
                    this.abg.setTextColor(this.aaU);
                }
                if (this.abh != null) {
                    this.abh.setTextColor(this.aaU);
                }
            }
            if (TextUtils.isEmpty(this.aaS) || this.abg == null) {
                z = false;
            } else {
                this.abg.setText(this.aaS);
                this.abg.setTag(this.abf);
                if (this.aaW != null) {
                    this.abg.setOnClickListener(new View$OnClickListenerC0046a(this, this.aaW));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aaT) || this.abh == null) {
                z2 = false;
            } else {
                this.abh.setText(this.aaT);
                if (this.aaX != null) {
                    this.abh.setOnClickListener(new View$OnClickListenerC0046a(this, this.aaX));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View te() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.aaQ) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aaR) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(d.g.message_view);
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
            ((TbPageContext) eVar).getLayoutMode().ag(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundResource(d.f.transparent_bg);
        }
    }

    private void h(boolean z, boolean z2) {
        if (z && z2) {
            if (this.abi != null) {
                this.abi.setVisibility(0);
            }
            if (this.abj != null) {
                this.abj.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.abi != null) {
            this.abi.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.abg != null && this.abh != null && this.abi != null && this.abj != null) {
                this.abg.setVisibility(8);
                this.abh.setVisibility(8);
                this.abi.setVisibility(8);
                this.abj.setVisibility(8);
            }
        } else if (z) {
            aj.d(this.abg, d.f.dialog_single_button_bg_selector, skinType);
            if (this.abh != null && this.abi != null && this.abj != null) {
                this.abj.setVisibility(0);
                this.abg.setVisibility(0);
                this.abh.setVisibility(8);
            }
        } else if (z2) {
            aj.d(this.abh, d.f.dialog_single_button_bg_selector, skinType);
            if (this.abg != null && this.abi != null && this.abj != null) {
                this.abj.setVisibility(0);
                this.abh.setVisibility(0);
                this.abg.setVisibility(8);
            }
        } else if (this.abg != null && this.abh != null && this.abj != null) {
            this.abj.setVisibility(8);
            this.abg.setVisibility(8);
            this.abh.setVisibility(8);
        }
    }

    public a tf() {
        return aq(false);
    }

    private a aq(boolean z) {
        if (!this.abd) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aba != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aba, this.mActivity);
            } else {
                this.aba.show();
            }
        } else {
            this.aba = new AlertDialog.Builder(this.mActivity).create();
            this.aba.setCanceledOnTouchOutside(this.abe);
            this.aba.setCancelable(this.mCancelable);
            this.aba.setOnKeyListener(this.aaZ);
            if (this.aaY != null) {
                this.aba.setOnCancelListener(this.aaY);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aba, this.mActivity);
            } else {
                this.aba.show();
            }
            if (this.aba.getWindow().getDecorView().getParent() != null) {
                Window window = this.aba.getWindow();
                if (this.aaP == -1) {
                    this.aaP = 17;
                }
                window.setGravity(this.aaP);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = l.o(this.mActivity);
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
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ax.a(this.mRootView, false, new ax.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.ax.a
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
        return this.aaV == 1 ? l.f(this.mActivity, d.e.ds40) : l.f(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.aba != null) {
            return this.aba.isShowing();
        }
        return false;
    }

    public void ar(boolean z) {
        if (this.abg != null) {
            this.abg.setClickable(z);
        }
    }

    public void as(boolean z) {
        if (this.abh != null) {
            this.abh.setClickable(z);
        }
    }

    public a th() {
        return aq(true);
    }

    public void hide() {
        if (this.aba != null) {
            this.aba.hide();
        }
    }

    public void dismiss() {
        if (this.aba != null) {
            com.baidu.adp.lib.g.g.b(this.aba, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0046a implements View.OnClickListener {
        private final a JV;
        private final b abm;

        public View$OnClickListenerC0046a(a aVar, b bVar) {
            this.JV = aVar;
            this.abm = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.abm != null) {
                this.abm.onClick(this.JV);
            }
        }
    }

    public ViewGroup ti() {
        return this.abb;
    }

    public void z(Object obj) {
        this.abf = obj;
    }

    public Object tj() {
        return this.abf;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.aba.getWindow();
    }

    public Dialog getDialog() {
        return this.aba;
    }

    public void at(boolean z) {
        this.aaQ = z;
    }

    public void au(boolean z) {
        this.aaR = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.aaZ = onKeyListener;
    }

    public void reset() {
        this.abd = false;
    }
}
