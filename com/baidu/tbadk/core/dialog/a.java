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
    private Object abB;
    private TextView abC;
    private TextView abD;
    private View abE;
    private View abF;
    private String abo;
    private String abp;
    private b abt;
    private b abu;
    private DialogInterface.OnCancelListener abv;
    private DialogInterface.OnKeyListener abw;
    private AlertDialog abx;
    private ViewGroup aby;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int abl = -1;
    private boolean abm = false;
    private boolean abn = false;
    private int abq = -1;
    private int abr = 0;
    private boolean abz = false;
    private boolean abA = true;
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

    public a cc(int i) {
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
        this.abv = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.abo = str;
        this.abt = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.abp = str;
        this.abu = bVar;
        return this;
    }

    public a cd(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.abo = this.mActivity.getResources().getString(i);
            this.abt = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.abp = this.mActivity.getResources().getString(i);
            this.abu = bVar;
        }
        return this;
    }

    public a ao(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ap(boolean z) {
        this.abA = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.aby = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a ce(int i) {
        if (isAutoNight()) {
            this.abq = aj.getColor(i);
        } else {
            this.abq = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cf(int i) {
        this.abr = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.abz) {
            this.abz = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.abC = (TextView) this.mRootView.findViewById(d.g.yes);
            this.abD = (TextView) this.mRootView.findViewById(d.g.no);
            this.abE = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.abF = this.mRootView.findViewById(d.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View th = th();
                if (th != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(th);
                }
            }
            c(eVar);
            if (this.abq != -1) {
                if (this.abC != null) {
                    this.abC.setTextColor(this.abq);
                }
                if (this.abD != null) {
                    this.abD.setTextColor(this.abq);
                }
            }
            if (TextUtils.isEmpty(this.abo) || this.abC == null) {
                z = false;
            } else {
                this.abC.setText(this.abo);
                this.abC.setTag(this.abB);
                if (this.abt != null) {
                    this.abC.setOnClickListener(new View$OnClickListenerC0046a(this, this.abt));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.abp) || this.abD == null) {
                z2 = false;
            } else {
                this.abD.setText(this.abp);
                if (this.abu != null) {
                    this.abD.setOnClickListener(new View$OnClickListenerC0046a(this, this.abu));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View th() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.abm) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.abn) {
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
            if (this.abE != null) {
                this.abE.setVisibility(0);
            }
            if (this.abF != null) {
                this.abF.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.abE != null) {
            this.abE.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.abC != null && this.abD != null && this.abE != null && this.abF != null) {
                this.abC.setVisibility(8);
                this.abD.setVisibility(8);
                this.abE.setVisibility(8);
                this.abF.setVisibility(8);
            }
        } else if (z) {
            aj.d(this.abC, d.f.dialog_single_button_bg_selector, skinType);
            if (this.abD != null && this.abE != null && this.abF != null) {
                this.abF.setVisibility(0);
                this.abC.setVisibility(0);
                this.abD.setVisibility(8);
            }
        } else if (z2) {
            aj.d(this.abD, d.f.dialog_single_button_bg_selector, skinType);
            if (this.abC != null && this.abE != null && this.abF != null) {
                this.abF.setVisibility(0);
                this.abD.setVisibility(0);
                this.abC.setVisibility(8);
            }
        } else if (this.abC != null && this.abD != null && this.abF != null) {
            this.abF.setVisibility(8);
            this.abC.setVisibility(8);
            this.abD.setVisibility(8);
        }
    }

    public a ti() {
        return aq(false);
    }

    private a aq(boolean z) {
        if (!this.abz) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abx != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.abx, this.mActivity);
            } else {
                this.abx.show();
            }
        } else {
            this.abx = new AlertDialog.Builder(this.mActivity).create();
            this.abx.setCanceledOnTouchOutside(this.abA);
            this.abx.setCancelable(this.mCancelable);
            this.abx.setOnKeyListener(this.abw);
            if (this.abv != null) {
                this.abx.setOnCancelListener(this.abv);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.abx, this.mActivity);
            } else {
                this.abx.show();
            }
            if (this.abx.getWindow().getDecorView().getParent() != null) {
                Window window = this.abx.getWindow();
                if (this.abl == -1) {
                    this.abl = 17;
                }
                window.setGravity(this.abl);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = l.o(this.mActivity);
                if (o != null) {
                    int tj = tj();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (tj * 2);
                    } else {
                        attributes.width = o.widthPixels - (tj * 2);
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

    public int tj() {
        return this.abr == 1 ? l.f(this.mActivity, d.e.ds40) : l.f(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.abx != null) {
            return this.abx.isShowing();
        }
        return false;
    }

    public void ar(boolean z) {
        if (this.abC != null) {
            this.abC.setClickable(z);
        }
    }

    public void as(boolean z) {
        if (this.abD != null) {
            this.abD.setClickable(z);
        }
    }

    public a tk() {
        return aq(true);
    }

    public void hide() {
        if (this.abx != null) {
            this.abx.hide();
        }
    }

    public void dismiss() {
        if (this.abx != null) {
            com.baidu.adp.lib.g.g.b(this.abx, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0046a implements View.OnClickListener {
        private final a IW;
        private final b abI;

        public View$OnClickListenerC0046a(a aVar, b bVar) {
            this.IW = aVar;
            this.abI = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.abI != null) {
                this.abI.onClick(this.IW);
            }
        }
    }

    public ViewGroup tl() {
        return this.aby;
    }

    public void z(Object obj) {
        this.abB = obj;
    }

    public Object tm() {
        return this.abB;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.abx.getWindow();
    }

    public Dialog getDialog() {
        return this.abx;
    }

    public void at(boolean z) {
        this.abm = z;
    }

    public void au(boolean z) {
        this.abn = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.abw = onKeyListener;
    }

    public void reset() {
        this.abz = false;
    }
}
