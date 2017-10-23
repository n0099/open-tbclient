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
    private b aaA;
    private DialogInterface.OnCancelListener aaB;
    private DialogInterface.OnKeyListener aaC;
    private AlertDialog aaD;
    private final ViewGroup aaE;
    private ViewGroup aaF;
    private Object aaI;
    private TextView aaJ;
    private TextView aaK;
    private View aaL;
    private View aaM;
    private String aav;
    private String aaw;
    private b aaz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int aas = -1;
    private boolean aat = false;
    private boolean aau = false;
    private int aax = -1;
    private int aay = 0;
    private boolean aaG = false;
    private boolean aaH = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cK(String str) {
        this.mTitle = str;
        return this;
    }

    public a cb(int i) {
        cK(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cL(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.aaB = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aav = str;
        this.aaz = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aaw = str;
        this.aaA = bVar;
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
            this.aav = this.mActivity.getResources().getString(i);
            this.aaz = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aaw = this.mActivity.getResources().getString(i);
            this.aaA = bVar;
        }
        return this;
    }

    public a aq(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ar(boolean z) {
        this.aaH = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.aaE = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdalert, (ViewGroup) null);
        this.aaF = (ViewGroup) this.aaE.findViewById(d.h.real_view);
    }

    public a cd(int i) {
        if (isAutoNight()) {
            this.aax = aj.getColor(i);
        } else {
            this.aax = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ce(int i) {
        this.aay = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aaG) {
            this.aaG = true;
            LinearLayout linearLayout = (LinearLayout) this.aaE.findViewById(d.h.dialog_content);
            this.aaJ = (TextView) this.aaE.findViewById(d.h.yes);
            this.aaK = (TextView) this.aaE.findViewById(d.h.no);
            this.aaL = this.aaE.findViewById(d.h.divider_yes_no_button);
            this.aaM = this.aaE.findViewById(d.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View sY = sY();
                if (sY != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(sY);
                }
            }
            c(eVar);
            if (this.aax != -1) {
                if (this.aaJ != null) {
                    this.aaJ.setTextColor(this.aax);
                }
                if (this.aaK != null) {
                    this.aaK.setTextColor(this.aax);
                }
            }
            if (TextUtils.isEmpty(this.aav) || this.aaJ == null) {
                z = false;
            } else {
                this.aaJ.setText(this.aav);
                this.aaJ.setTag(this.aaI);
                if (this.aaz != null) {
                    this.aaJ.setOnClickListener(new View$OnClickListenerC0046a(this, this.aaz));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aaw) || this.aaK == null) {
                z2 = false;
            } else {
                this.aaK.setText(this.aaw);
                if (this.aaA != null) {
                    this.aaK.setOnClickListener(new View$OnClickListenerC0046a(this, this.aaA));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View sY() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.h.message_view);
                if (this.aat) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aau) {
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
            ((TbPageContext) eVar).getLayoutMode().t(this.aaE);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.aaE != null) {
            this.aaE.setBackgroundResource(d.g.transparent_bg);
        }
    }

    private void h(boolean z, boolean z2) {
        if (z && z2) {
            if (this.aaL != null) {
                this.aaL.setVisibility(0);
            }
            if (this.aaM != null) {
                this.aaM.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aaL != null) {
            this.aaL.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aaJ != null && this.aaK != null && this.aaL != null && this.aaM != null) {
                this.aaJ.setVisibility(8);
                this.aaK.setVisibility(8);
                this.aaL.setVisibility(8);
                this.aaM.setVisibility(8);
            }
        } else if (z) {
            aj.d(this.aaJ, d.g.dialog_single_button_bg_selector, skinType);
            if (this.aaK != null && this.aaL != null && this.aaM != null) {
                this.aaM.setVisibility(0);
                this.aaJ.setVisibility(0);
                this.aaK.setVisibility(8);
            }
        } else if (z2) {
            aj.d(this.aaK, d.g.dialog_single_button_bg_selector, skinType);
            if (this.aaJ != null && this.aaL != null && this.aaM != null) {
                this.aaM.setVisibility(0);
                this.aaK.setVisibility(0);
                this.aaJ.setVisibility(8);
            }
        } else if (this.aaJ != null && this.aaK != null && this.aaM != null) {
            this.aaM.setVisibility(8);
            this.aaJ.setVisibility(8);
            this.aaK.setVisibility(8);
        }
    }

    public a sZ() {
        return as(false);
    }

    private a as(boolean z) {
        if (!this.aaG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aaD != null) {
            if (z) {
                g.a(this.aaD, this.mActivity);
            } else {
                this.aaD.show();
            }
        } else {
            this.aaD = new AlertDialog.Builder(this.mActivity).create();
            this.aaD.setCanceledOnTouchOutside(this.aaH);
            this.aaD.setCancelable(this.mCancelable);
            this.aaD.setOnKeyListener(this.aaC);
            if (this.aaB != null) {
                this.aaD.setOnCancelListener(this.aaB);
            }
            if (z) {
                g.a(this.aaD, this.mActivity);
            } else {
                this.aaD.show();
            }
            if (this.aaD.getWindow().getDecorView().getParent() != null) {
                Window window = this.aaD.getWindow();
                if (this.aas == -1) {
                    this.aas = 17;
                }
                window.setGravity(this.aas);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = l.o(this.mActivity);
                if (o != null) {
                    int ta = ta();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (ta * 2);
                    } else {
                        attributes.width = o.widthPixels - (ta * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.aaE);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ax.a(this.aaE, false, new ax.a() { // from class: com.baidu.tbadk.core.dialog.a.1
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

    public int ta() {
        return this.aay == 1 ? l.f(this.mActivity, d.f.ds40) : l.f(this.mActivity, d.f.ds90);
    }

    public boolean isShowing() {
        if (this.aaD != null) {
            return this.aaD.isShowing();
        }
        return false;
    }

    public void at(boolean z) {
        if (this.aaJ != null) {
            this.aaJ.setClickable(z);
        }
    }

    public void au(boolean z) {
        if (this.aaK != null) {
            this.aaK.setClickable(z);
        }
    }

    public a tb() {
        return as(true);
    }

    public void hide() {
        if (this.aaD != null) {
            this.aaD.hide();
        }
    }

    public void dismiss() {
        if (this.aaD != null) {
            g.b(this.aaD, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0046a implements View.OnClickListener {
        private final a KB;
        private final b aaP;

        public View$OnClickListenerC0046a(a aVar, b bVar) {
            this.KB = aVar;
            this.aaP = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aaP != null) {
                this.aaP.onClick(this.KB);
            }
        }
    }

    public ViewGroup tc() {
        return this.aaF;
    }

    public void z(Object obj) {
        this.aaI = obj;
    }

    public Object td() {
        return this.aaI;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.aaD.getWindow();
    }

    public Dialog getDialog() {
        return this.aaD;
    }

    public void av(boolean z) {
        this.aat = z;
    }

    public void aw(boolean z) {
        this.aau = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.aaC = onKeyListener;
    }

    public void reset() {
        this.aaG = false;
    }
}
