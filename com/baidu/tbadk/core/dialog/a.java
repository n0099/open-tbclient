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
    private TextView abA;
    private View abB;
    private View abC;
    private String abl;
    private String abm;
    private b abp;
    private b abq;
    private DialogInterface.OnCancelListener abr;
    private DialogInterface.OnKeyListener abt;
    private AlertDialog abu;
    private ViewGroup abv;
    private Object aby;
    private TextView abz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int abi = -1;
    private boolean abj = false;
    private boolean abk = false;
    private int abn = -1;
    private int abo = 0;
    private boolean abw = false;
    private boolean abx = true;
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
        this.abr = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.abl = str;
        this.abp = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.abm = str;
        this.abq = bVar;
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
            this.abl = this.mActivity.getResources().getString(i);
            this.abp = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.abm = this.mActivity.getResources().getString(i);
            this.abq = bVar;
        }
        return this;
    }

    public a ao(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ap(boolean z) {
        this.abx = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.abv = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a ce(int i) {
        if (isAutoNight()) {
            this.abn = aj.getColor(i);
        } else {
            this.abn = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cf(int i) {
        this.abo = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.abw) {
            this.abw = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.abz = (TextView) this.mRootView.findViewById(d.g.yes);
            this.abA = (TextView) this.mRootView.findViewById(d.g.no);
            this.abB = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.abC = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
            if (this.abn != -1) {
                if (this.abz != null) {
                    this.abz.setTextColor(this.abn);
                }
                if (this.abA != null) {
                    this.abA.setTextColor(this.abn);
                }
            }
            if (TextUtils.isEmpty(this.abl) || this.abz == null) {
                z = false;
            } else {
                this.abz.setText(this.abl);
                this.abz.setTag(this.aby);
                if (this.abp != null) {
                    this.abz.setOnClickListener(new View$OnClickListenerC0059a(this, this.abp));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.abm) || this.abA == null) {
                z2 = false;
            } else {
                this.abA.setText(this.abm);
                if (this.abq != null) {
                    this.abA.setOnClickListener(new View$OnClickListenerC0059a(this, this.abq));
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
                if (this.abj) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.abk) {
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
            if (this.abB != null) {
                this.abB.setVisibility(0);
            }
            if (this.abC != null) {
                this.abC.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.abB != null) {
            this.abB.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.abz != null && this.abA != null && this.abB != null && this.abC != null) {
                this.abz.setVisibility(8);
                this.abA.setVisibility(8);
                this.abB.setVisibility(8);
                this.abC.setVisibility(8);
            }
        } else if (z) {
            aj.d(this.abz, d.f.dialog_single_button_bg_selector, skinType);
            if (this.abA != null && this.abB != null && this.abC != null) {
                this.abC.setVisibility(0);
                this.abz.setVisibility(0);
                this.abA.setVisibility(8);
            }
        } else if (z2) {
            aj.d(this.abA, d.f.dialog_single_button_bg_selector, skinType);
            if (this.abz != null && this.abB != null && this.abC != null) {
                this.abC.setVisibility(0);
                this.abA.setVisibility(0);
                this.abz.setVisibility(8);
            }
        } else if (this.abz != null && this.abA != null && this.abC != null) {
            this.abC.setVisibility(8);
            this.abz.setVisibility(8);
            this.abA.setVisibility(8);
        }
    }

    public a tf() {
        return aq(false);
    }

    private a aq(boolean z) {
        if (!this.abw) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.abu != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.abu, this.mActivity);
            } else {
                this.abu.show();
            }
        } else {
            this.abu = new AlertDialog.Builder(this.mActivity).create();
            this.abu.setCanceledOnTouchOutside(this.abx);
            this.abu.setCancelable(this.mCancelable);
            this.abu.setOnKeyListener(this.abt);
            if (this.abr != null) {
                this.abu.setOnCancelListener(this.abr);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.abu, this.mActivity);
            } else {
                this.abu.show();
            }
            if (this.abu.getWindow().getDecorView().getParent() != null) {
                Window window = this.abu.getWindow();
                if (this.abi == -1) {
                    this.abi = 17;
                }
                window.setGravity(this.abi);
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
        return this.abo == 1 ? l.f(this.mActivity, d.e.ds40) : l.f(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.abu != null) {
            return this.abu.isShowing();
        }
        return false;
    }

    public void ar(boolean z) {
        if (this.abz != null) {
            this.abz.setClickable(z);
        }
    }

    public void as(boolean z) {
        if (this.abA != null) {
            this.abA.setClickable(z);
        }
    }

    public a th() {
        return aq(true);
    }

    public void hide() {
        if (this.abu != null) {
            this.abu.hide();
        }
    }

    public void dismiss() {
        if (this.abu != null) {
            com.baidu.adp.lib.g.g.b(this.abu, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0059a implements View.OnClickListener {
        private final a IW;
        private final b abF;

        public View$OnClickListenerC0059a(a aVar, b bVar) {
            this.IW = aVar;
            this.abF = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.abF != null) {
                this.abF.onClick(this.IW);
            }
        }
    }

    public ViewGroup ti() {
        return this.abv;
    }

    public void z(Object obj) {
        this.aby = obj;
    }

    public Object tj() {
        return this.aby;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.abu.getWindow();
    }

    public Dialog getDialog() {
        return this.abu;
    }

    public void at(boolean z) {
        this.abj = z;
    }

    public void au(boolean z) {
        this.abk = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.abt = onKeyListener;
    }

    public void reset() {
        this.abw = false;
    }
}
