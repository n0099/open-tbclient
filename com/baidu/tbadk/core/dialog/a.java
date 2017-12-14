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
    private String abi;
    private String abj;
    private b abm;
    private b abn;
    private DialogInterface.OnCancelListener abo;
    private DialogInterface.OnKeyListener abp;
    private AlertDialog abq;
    private ViewGroup abr;
    private Object abv;
    private TextView abw;
    private TextView abx;
    private View aby;
    private View abz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int abf = -1;
    private boolean abg = false;
    private boolean abh = false;
    private int abk = -1;
    private int abl = 0;
    private boolean abt = false;
    private boolean abu = true;
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
        this.abo = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.abi = str;
        this.abm = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.abj = str;
        this.abn = bVar;
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
            this.abi = this.mActivity.getResources().getString(i);
            this.abm = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.abj = this.mActivity.getResources().getString(i);
            this.abn = bVar;
        }
        return this;
    }

    public a ao(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ap(boolean z) {
        this.abu = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.abr = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a ce(int i) {
        if (isAutoNight()) {
            this.abk = aj.getColor(i);
        } else {
            this.abk = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cf(int i) {
        this.abl = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.abt) {
            this.abt = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.abw = (TextView) this.mRootView.findViewById(d.g.yes);
            this.abx = (TextView) this.mRootView.findViewById(d.g.no);
            this.aby = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.abz = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
            if (this.abk != -1) {
                if (this.abw != null) {
                    this.abw.setTextColor(this.abk);
                }
                if (this.abx != null) {
                    this.abx.setTextColor(this.abk);
                }
            }
            if (TextUtils.isEmpty(this.abi) || this.abw == null) {
                z = false;
            } else {
                this.abw.setText(this.abi);
                this.abw.setTag(this.abv);
                if (this.abm != null) {
                    this.abw.setOnClickListener(new View$OnClickListenerC0060a(this, this.abm));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.abj) || this.abx == null) {
                z2 = false;
            } else {
                this.abx.setText(this.abj);
                if (this.abn != null) {
                    this.abx.setOnClickListener(new View$OnClickListenerC0060a(this, this.abn));
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
                if (this.abg) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.abh) {
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
            if (this.aby != null) {
                this.aby.setVisibility(0);
            }
            if (this.abz != null) {
                this.abz.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aby != null) {
            this.aby.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.abw != null && this.abx != null && this.aby != null && this.abz != null) {
                this.abw.setVisibility(8);
                this.abx.setVisibility(8);
                this.aby.setVisibility(8);
                this.abz.setVisibility(8);
            }
        } else if (z) {
            aj.d(this.abw, d.f.dialog_single_button_bg_selector, skinType);
            if (this.abx != null && this.aby != null && this.abz != null) {
                this.abz.setVisibility(0);
                this.abw.setVisibility(0);
                this.abx.setVisibility(8);
            }
        } else if (z2) {
            aj.d(this.abx, d.f.dialog_single_button_bg_selector, skinType);
            if (this.abw != null && this.aby != null && this.abz != null) {
                this.abz.setVisibility(0);
                this.abx.setVisibility(0);
                this.abw.setVisibility(8);
            }
        } else if (this.abw != null && this.abx != null && this.abz != null) {
            this.abz.setVisibility(8);
            this.abw.setVisibility(8);
            this.abx.setVisibility(8);
        }
    }

    public a tf() {
        return aq(false);
    }

    private a aq(boolean z) {
        if (!this.abt) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abq != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.abq, this.mActivity);
            } else {
                this.abq.show();
            }
        } else {
            this.abq = new AlertDialog.Builder(this.mActivity).create();
            this.abq.setCanceledOnTouchOutside(this.abu);
            this.abq.setCancelable(this.mCancelable);
            this.abq.setOnKeyListener(this.abp);
            if (this.abo != null) {
                this.abq.setOnCancelListener(this.abo);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.abq, this.mActivity);
            } else {
                this.abq.show();
            }
            if (this.abq.getWindow().getDecorView().getParent() != null) {
                Window window = this.abq.getWindow();
                if (this.abf == -1) {
                    this.abf = 17;
                }
                window.setGravity(this.abf);
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
        return this.abl == 1 ? l.f(this.mActivity, d.e.ds40) : l.f(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.abq != null) {
            return this.abq.isShowing();
        }
        return false;
    }

    public void ar(boolean z) {
        if (this.abw != null) {
            this.abw.setClickable(z);
        }
    }

    public void as(boolean z) {
        if (this.abx != null) {
            this.abx.setClickable(z);
        }
    }

    public a th() {
        return aq(true);
    }

    public void hide() {
        if (this.abq != null) {
            this.abq.hide();
        }
    }

    public void dismiss() {
        if (this.abq != null) {
            com.baidu.adp.lib.g.g.b(this.abq, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0060a implements View.OnClickListener {
        private final a IU;
        private final b abC;

        public View$OnClickListenerC0060a(a aVar, b bVar) {
            this.IU = aVar;
            this.abC = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.abC != null) {
                this.abC.onClick(this.IU);
            }
        }
    }

    public ViewGroup ti() {
        return this.abr;
    }

    public void z(Object obj) {
        this.abv = obj;
    }

    public Object tj() {
        return this.abv;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.abq.getWindow();
    }

    public Dialog getDialog() {
        return this.abq;
    }

    public void at(boolean z) {
        this.abg = z;
    }

    public void au(boolean z) {
        this.abh = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.abp = onKeyListener;
    }

    public void reset() {
        this.abt = false;
    }
}
