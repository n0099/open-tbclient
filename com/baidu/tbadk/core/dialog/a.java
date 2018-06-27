package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String akX;
    private String akY;
    private b alb;
    private b alc;
    private DialogInterface.OnCancelListener ald;
    private DialogInterface.OnDismissListener ale;
    private AlertDialog alf;
    private ViewGroup alg;
    private Object alj;
    private TextView alk;
    private TextView alm;
    private View aln;
    private View alo;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int akT = -1;
    private boolean akU = true;
    private boolean akV = false;
    private boolean akW = false;
    private int akZ = -1;
    private int ala = 0;
    private boolean alh = false;
    private boolean ali = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a dD(String str) {
        this.mTitle = str;
        return this;
    }

    public a cc(int i) {
        dD(this.mActivity.getResources().getString(i));
        return this;
    }

    public a dE(String str) {
        this.mMessage = str;
        return this;
    }

    public a w(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.ald = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.ale = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.akX = str;
        this.alb = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.akY = str;
        this.alc = bVar;
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
            this.akX = this.mActivity.getResources().getString(i);
            this.alb = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.akY = this.mActivity.getResources().getString(i);
            this.alc = bVar;
        }
        return this;
    }

    public a aw(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ax(boolean z) {
        this.ali = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_bdalert, (ViewGroup) null);
        this.alg = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a ce(int i) {
        if (isAutoNight()) {
            this.akZ = am.getColor(i);
        } else {
            this.akZ = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cf(int i) {
        this.ala = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.alh) {
            this.alh = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.alk = (TextView) this.mRootView.findViewById(d.g.yes);
            this.alm = (TextView) this.mRootView.findViewById(d.g.no);
            this.aln = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.alo = this.mRootView.findViewById(d.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                if (this.mContentView.getParent() != null) {
                    if (this.mContentView.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                        linearLayout.addView(this.mContentView);
                    }
                } else {
                    linearLayout.addView(this.mContentView);
                }
            } else {
                View xk = xk();
                if (xk != null) {
                    linearLayout.removeAllViews();
                    if (xk.getParent() != null) {
                        if (xk.getParent() instanceof ViewGroup) {
                            ((ViewGroup) xk.getParent()).removeView(xk);
                            linearLayout.addView(xk);
                        }
                    } else {
                        linearLayout.addView(xk);
                    }
                }
            }
            c(eVar);
            if (this.akZ != -1) {
                if (this.alk != null) {
                    this.alk.setTextColor(this.akZ);
                }
                if (this.alm != null) {
                    this.alm.setTextColor(this.akZ);
                }
            }
            if (TextUtils.isEmpty(this.akX) || this.alk == null) {
                z = false;
            } else {
                this.alk.setText(this.akX);
                this.alk.setTag(this.alj);
                if (this.alb != null) {
                    this.alk.setOnClickListener(new View$OnClickListenerC0103a(this, this.alb));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.akY) || this.alm == null) {
                z2 = false;
            } else {
                this.alm.setText(this.akY);
                if (this.alc != null) {
                    this.alm.setOnClickListener(new View$OnClickListenerC0103a(this, this.alc));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View xk() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.i.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.akV) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.akW) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.i.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(d.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            if (this.akU) {
                textView3.setGravity(17);
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mContentView);
            }
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundResource(d.f.transparent_bg);
        }
    }

    private void h(boolean z, boolean z2) {
        if (z && z2) {
            if (this.aln != null) {
                this.aln.setVisibility(0);
            }
            if (this.alo != null) {
                this.alo.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aln != null) {
            this.aln.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.alk != null && this.alm != null && this.aln != null && this.alo != null) {
                this.alk.setVisibility(8);
                this.alm.setVisibility(8);
                this.aln.setVisibility(8);
                this.alo.setVisibility(8);
            }
        } else if (z) {
            am.d(this.alk, d.f.dialog_single_button_bg_selector, skinType);
            if (this.alm != null && this.aln != null && this.alo != null) {
                this.alo.setVisibility(0);
                this.alk.setVisibility(0);
                this.alm.setVisibility(8);
            }
        } else if (z2) {
            am.d(this.alm, d.f.dialog_single_button_bg_selector, skinType);
            if (this.alk != null && this.aln != null && this.alo != null) {
                this.alo.setVisibility(0);
                this.alm.setVisibility(0);
                this.alk.setVisibility(8);
            }
        } else if (this.alk != null && this.alm != null && this.alo != null) {
            this.alo.setVisibility(8);
            this.alk.setVisibility(8);
            this.alm.setVisibility(8);
        }
    }

    public a xl() {
        return ay(false);
    }

    private a ay(boolean z) {
        if (!this.alh) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.alf != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.alf, this.mActivity);
            } else {
                this.alf.show();
            }
        } else {
            this.alf = new AlertDialog.Builder(this.mActivity).create();
            this.alf.setCanceledOnTouchOutside(this.ali);
            this.alf.setCancelable(this.mCancelable);
            this.alf.setOnKeyListener(this.mOnKeyListener);
            if (this.ald != null) {
                this.alf.setOnCancelListener(this.ald);
            }
            if (this.ale != null) {
                this.alf.setOnDismissListener(this.ale);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.alf, this.mActivity);
            } else {
                this.alf.show();
            }
            if (this.alf.getWindow().getDecorView().getParent() != null) {
                Window window = this.alf.getWindow();
                if (this.akT == -1) {
                    this.akT = 17;
                }
                window.setGravity(this.akT);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics p = l.p(this.mActivity);
                if (p != null) {
                    int xm = xm();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = p.heightPixels - (xm * 2);
                    } else {
                        attributes.width = p.widthPixels - (xm * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bb.a(this.mRootView, false, new bb.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.bb.a
                    public boolean x(View view) {
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

    public int xm() {
        return this.ala == 1 ? l.e(this.mActivity, d.e.ds40) : l.e(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.alf != null) {
            return this.alf.isShowing();
        }
        return false;
    }

    public void az(boolean z) {
        if (this.alk != null) {
            this.alk.setClickable(z);
        }
    }

    public void aA(boolean z) {
        if (this.alm != null) {
            this.alm.setClickable(z);
        }
    }

    public a xn() {
        return ay(true);
    }

    public void hide() {
        if (this.alf != null) {
            this.alf.hide();
        }
    }

    public void dismiss() {
        if (this.alf != null) {
            com.baidu.adp.lib.g.g.b(this.alf, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0103a implements View.OnClickListener {
        private final a Qm;
        private final b alr;

        public View$OnClickListenerC0103a(a aVar, b bVar) {
            this.Qm = aVar;
            this.alr = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.alr != null) {
                this.alr.onClick(this.Qm);
            }
        }
    }

    public ViewGroup xo() {
        return this.alg;
    }

    public void C(Object obj) {
        this.alj = obj;
    }

    public Object xp() {
        return this.alj;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void aB(boolean z) {
        this.akU = z;
    }

    public void aC(boolean z) {
        this.akV = z;
    }

    public void aD(boolean z) {
        this.akW = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.alh = false;
    }
}
