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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String anc;
    private String and;
    private b ang;
    private b anh;
    private DialogInterface.OnCancelListener ani;
    private DialogInterface.OnDismissListener anj;
    private AlertDialog ank;
    private ViewGroup anl;
    private Object ano;
    private TextView anp;
    private TextView anq;
    private View anr;
    private View ans;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int amY = -1;
    private boolean amZ = true;
    private boolean ana = false;
    private boolean anb = false;
    private int ane = -1;
    private int anf = 0;
    private boolean anm = false;
    private boolean ann = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a dS(String str) {
        this.mTitle = str;
        return this;
    }

    public a co(int i) {
        dS(this.mActivity.getResources().getString(i));
        return this;
    }

    public a dT(String str) {
        this.mMessage = str;
        return this;
    }

    public a G(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.ani = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.anj = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.anc = str;
        this.ang = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.and = str;
        this.anh = bVar;
        return this;
    }

    public a cp(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.anc = this.mActivity.getResources().getString(i);
            this.ang = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.and = this.mActivity.getResources().getString(i);
            this.anh = bVar;
        }
        return this;
    }

    public a aE(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a aF(boolean z) {
        this.ann = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_bdalert, (ViewGroup) null);
        this.anl = (ViewGroup) this.mRootView.findViewById(e.g.real_view);
    }

    public a cq(int i) {
        if (isAutoNight()) {
            this.ane = al.getColor(i);
        } else {
            this.ane = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cr(int i) {
        this.anf = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.anm) {
            this.anm = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(e.g.dialog_content);
            this.anp = (TextView) this.mRootView.findViewById(e.g.yes);
            this.anq = (TextView) this.mRootView.findViewById(e.g.no);
            this.anr = this.mRootView.findViewById(e.g.divider_yes_no_button);
            this.ans = this.mRootView.findViewById(e.g.bdDialog_divider_line);
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
                View yi = yi();
                if (yi != null) {
                    linearLayout.removeAllViews();
                    if (yi.getParent() != null) {
                        if (yi.getParent() instanceof ViewGroup) {
                            ((ViewGroup) yi.getParent()).removeView(yi);
                            linearLayout.addView(yi);
                        }
                    } else {
                        linearLayout.addView(yi);
                    }
                }
            }
            c(eVar);
            if (this.ane != -1) {
                if (this.anp != null) {
                    this.anp.setTextColor(this.ane);
                }
                if (this.anq != null) {
                    this.anq.setTextColor(this.ane);
                }
            }
            if (TextUtils.isEmpty(this.anc) || this.anp == null) {
                z = false;
            } else {
                this.anp.setText(this.anc);
                this.anp.setTag(this.ano);
                if (this.ang != null) {
                    this.anp.setOnClickListener(new View$OnClickListenerC0099a(this, this.ang));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.and) || this.anq == null) {
                z2 = false;
            } else {
                this.anq.setText(this.and);
                if (this.anh != null) {
                    this.anq.setOnClickListener(new View$OnClickListenerC0099a(this, this.anh));
                }
            }
            j(z, z2);
        }
        return this;
    }

    public View yi() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(e.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(e.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(e.g.message_view);
                if (this.ana) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.anb) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(e.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(e.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            if (this.amZ) {
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
            this.mRootView.setBackgroundResource(e.f.transparent_bg);
        }
    }

    private void j(boolean z, boolean z2) {
        if (z && z2) {
            if (this.anr != null) {
                this.anr.setVisibility(0);
            }
            if (this.ans != null) {
                this.ans.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.anr != null) {
            this.anr.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.anp != null && this.anq != null && this.anr != null && this.ans != null) {
                this.anp.setVisibility(8);
                this.anq.setVisibility(8);
                this.anr.setVisibility(8);
                this.ans.setVisibility(8);
            }
        } else if (z) {
            al.d(this.anp, e.f.dialog_single_button_bg_selector, skinType);
            if (this.anq != null && this.anr != null && this.ans != null) {
                this.ans.setVisibility(0);
                this.anp.setVisibility(0);
                this.anq.setVisibility(8);
            }
        } else if (z2) {
            al.d(this.anq, e.f.dialog_single_button_bg_selector, skinType);
            if (this.anp != null && this.anr != null && this.ans != null) {
                this.ans.setVisibility(0);
                this.anq.setVisibility(0);
                this.anp.setVisibility(8);
            }
        } else if (this.anp != null && this.anq != null && this.ans != null) {
            this.ans.setVisibility(8);
            this.anp.setVisibility(8);
            this.anq.setVisibility(8);
        }
    }

    public a yj() {
        return aG(false);
    }

    private a aG(boolean z) {
        if (!this.anm) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ank != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.ank, this.mActivity);
            } else {
                this.ank.show();
            }
        } else {
            this.ank = new AlertDialog.Builder(this.mActivity).create();
            this.ank.setCanceledOnTouchOutside(this.ann);
            this.ank.setCancelable(this.mCancelable);
            this.ank.setOnKeyListener(this.mOnKeyListener);
            if (this.ani != null) {
                this.ank.setOnCancelListener(this.ani);
            }
            if (this.anj != null) {
                this.ank.setOnDismissListener(this.anj);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.ank, this.mActivity);
            } else {
                this.ank.show();
            }
            if (this.ank.getWindow().getDecorView().getParent() != null) {
                Window window = this.ank.getWindow();
                if (this.amY == -1) {
                    this.amY = 17;
                }
                window.setGravity(this.amY);
                window.setBackgroundDrawableResource(e.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics s = l.s(this.mActivity);
                if (s != null) {
                    int yk = yk();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = s.heightPixels - (yk * 2);
                    } else {
                        attributes.width = s.widthPixels - (yk * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ba.a(this.mRootView, false, new ba.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.ba.a
                    public boolean H(View view) {
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

    public int yk() {
        return this.anf == 1 ? l.h(this.mActivity, e.C0141e.ds40) : l.h(this.mActivity, e.C0141e.ds90);
    }

    public boolean isShowing() {
        if (this.ank != null) {
            return this.ank.isShowing();
        }
        return false;
    }

    public void aH(boolean z) {
        if (this.anp != null) {
            this.anp.setClickable(z);
        }
    }

    public void aI(boolean z) {
        if (this.anq != null) {
            this.anq.setClickable(z);
        }
    }

    public a yl() {
        return aG(true);
    }

    public void hide() {
        if (this.ank != null) {
            this.ank.hide();
        }
    }

    public void dismiss() {
        if (this.ank != null) {
            com.baidu.adp.lib.g.g.b(this.ank, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0099a implements View.OnClickListener {
        private final a SK;
        private final b anv;

        public View$OnClickListenerC0099a(a aVar, b bVar) {
            this.SK = aVar;
            this.anv = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.anv != null) {
                this.anv.onClick(this.SK);
            }
        }
    }

    public ViewGroup ym() {
        return this.anl;
    }

    public void D(Object obj) {
        this.ano = obj;
    }

    public Object yn() {
        return this.ano;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void aJ(boolean z) {
        this.amZ = z;
    }

    public void aK(boolean z) {
        this.ana = z;
    }

    public void aL(boolean z) {
        this.anb = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.anm = false;
    }
}
