package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private b bEB;
    private b bEC;
    private b bED;
    private DialogInterface.OnCancelListener bEE;
    private DialogInterface.OnDismissListener bEF;
    private ViewGroup bEG;
    private Object bEJ;
    private TextView bEK;
    private TextView bEL;
    private View bEM;
    private View bEN;
    private Button bEO;
    private String bEx;
    private String bEy;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int bEt = -1;
    private boolean bEu = true;
    private boolean bEv = false;
    private boolean bEw = false;
    private int bEz = -1;
    private int bEA = 0;
    private boolean bEH = false;
    private boolean bEI = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a ly(String str) {
        this.mTitle = str;
        return this;
    }

    public a gB(int i) {
        ly(this.mActivity.getResources().getString(i));
        return this;
    }

    public a lz(String str) {
        this.mMessage = str;
        return this;
    }

    public a az(View view) {
        this.mContentView = view;
        return this;
    }

    public a b(DialogInterface.OnCancelListener onCancelListener) {
        this.bEE = onCancelListener;
        return this;
    }

    public a b(DialogInterface.OnDismissListener onDismissListener) {
        this.bEF = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.bEx = str;
        this.bEB = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.bEy = str;
        this.bEC = bVar;
        return this;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.bED = bVar;
        }
        return this;
    }

    public a gC(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.bEx = this.mActivity.getResources().getString(i);
            this.bEB = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.bEy = this.mActivity.getResources().getString(i);
            this.bEC = bVar;
        }
        return this;
    }

    public a dq(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a dr(boolean z) {
        this.bEI = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.bEG = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a gD(int i) {
        if (isAutoNight()) {
            this.bEz = al.getColor(i);
        } else {
            this.bEz = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a gE(int i) {
        this.bEA = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.bEH) {
            this.bEH = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.bEK = (TextView) this.mRootView.findViewById(d.g.yes);
            this.bEL = (TextView) this.mRootView.findViewById(d.g.no);
            this.bEM = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.bEN = this.mRootView.findViewById(d.g.bdDialog_divider_line);
            this.bEO = (Button) this.mRootView.findViewById(d.g.close_btn);
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
                View aaU = aaU();
                if (aaU != null) {
                    linearLayout.removeAllViews();
                    if (aaU.getParent() != null) {
                        if (aaU.getParent() instanceof ViewGroup) {
                            ((ViewGroup) aaU.getParent()).removeView(aaU);
                            linearLayout.addView(aaU);
                        }
                    } else {
                        linearLayout.addView(aaU);
                    }
                }
            }
            c(eVar);
            if (this.bED != null) {
                this.bEO.setVisibility(0);
                this.bEO.setOnClickListener(new View$OnClickListenerC0224a(this, this.bED));
                al.e(this.bEO, d.f.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.bEz != -1) {
                if (this.bEK != null) {
                    this.bEK.setTextColor(this.bEz);
                }
                if (this.bEL != null) {
                    this.bEL.setTextColor(this.bEz);
                }
            }
            if (TextUtils.isEmpty(this.bEx) || this.bEK == null) {
                z = false;
            } else {
                this.bEK.setText(this.bEx);
                this.bEK.setTag(this.bEJ);
                if (this.bEB != null) {
                    this.bEK.setOnClickListener(new View$OnClickListenerC0224a(this, this.bEB));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.bEy) || this.bEL == null) {
                z2 = false;
            } else {
                this.bEL.setText(this.bEy);
                if (this.bEC != null) {
                    this.bEL.setOnClickListener(new View$OnClickListenerC0224a(this, this.bEC));
                }
            }
            n(z, z2);
        }
        return this;
    }

    public View aaU() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.bEv) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.bEw) {
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
            if (this.bEu) {
                textView3.setGravity(17);
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void c(@Nullable com.baidu.adp.base.e<?> eVar) {
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
        if (this.bEG != null && this.bEA == 2) {
            this.bEG.setBackgroundResource(d.f.dialog_private_background);
        } else {
            al.e(this.bEG, d.f.dialog_background, skinType);
        }
    }

    private void n(boolean z, boolean z2) {
        if (z && z2) {
            if (this.bEM != null) {
                this.bEM.setVisibility(0);
            }
            if (this.bEN != null) {
                this.bEN.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.bEM != null) {
            this.bEM.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.bEK != null && this.bEL != null && this.bEM != null && this.bEN != null) {
                this.bEK.setVisibility(8);
                this.bEL.setVisibility(8);
                this.bEM.setVisibility(8);
                this.bEN.setVisibility(8);
            }
        } else if (z) {
            al.e(this.bEK, d.f.dialog_single_button_bg_selector, skinType);
            if (this.bEL != null && this.bEM != null && this.bEN != null) {
                this.bEN.setVisibility(0);
                this.bEK.setVisibility(0);
                this.bEL.setVisibility(8);
            }
        } else if (z2) {
            al.e(this.bEL, d.f.dialog_single_button_bg_selector, skinType);
            if (this.bEK != null && this.bEM != null && this.bEN != null) {
                this.bEN.setVisibility(0);
                this.bEL.setVisibility(0);
                this.bEK.setVisibility(8);
            }
        } else if (this.bEK != null && this.bEL != null && this.bEN != null) {
            this.bEN.setVisibility(8);
            this.bEK.setVisibility(8);
            this.bEL.setVisibility(8);
        }
    }

    private a ds(boolean z) {
        if (!this.bEH) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(this.bEI);
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnKeyListener(this.mOnKeyListener);
            if (this.bEE != null) {
                this.mDialog.setOnCancelListener(this.bEE);
            }
            if (this.bEF != null) {
                this.mDialog.setOnDismissListener(this.bEF);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            if (this.mDialog.getWindow().getDecorView().getParent() != null) {
                Window window = this.mDialog.getWindow();
                if (this.bEt == -1) {
                    this.bEt = 17;
                }
                window.setGravity(this.bEt);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics s = l.s(this.mActivity);
                if (s != null) {
                    int aaV = aaV();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = s.heightPixels - (aaV * 2);
                    } else {
                        attributes.width = s.widthPixels - (aaV * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bc.a(this.mRootView, false, new bc.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.bc.a
                    public boolean aA(View view) {
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

    public int aaV() {
        int i = d.e.tbds0;
        if (this.bEA == 0) {
            i = d.e.ds90;
        } else if (this.bEA == 1) {
            i = d.e.ds40;
        } else if (this.bEA == 2) {
            i = d.e.tbds44;
        }
        return l.h(this.mActivity, i);
    }

    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

    public void dt(boolean z) {
        if (this.bEK != null) {
            this.bEK.setClickable(z);
        }
    }

    public void du(boolean z) {
        if (this.bEL != null) {
            this.bEL.setClickable(z);
        }
    }

    public a aaW() {
        return ds(true);
    }

    public void hide() {
        if (this.mDialog != null) {
            this.mDialog.hide();
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.b(this.mDialog, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0224a implements View.OnClickListener {
        private final a VQ;
        private final b bER;

        public View$OnClickListenerC0224a(a aVar, b bVar) {
            this.VQ = aVar;
            this.bER = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bER != null) {
                this.bER.onClick(this.VQ);
            }
        }
    }

    public ViewGroup aaX() {
        return this.bEG;
    }

    public void Z(Object obj) {
        this.bEJ = obj;
    }

    public Object aaY() {
        return this.bEJ;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void dv(boolean z) {
        this.bEu = z;
    }

    public void dw(boolean z) {
        this.bEv = z;
    }

    public void dx(boolean z) {
        this.bEw = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.bEH = false;
    }
}
