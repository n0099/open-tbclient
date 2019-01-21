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
    private String awO;
    private String awP;
    private b awS;
    private b awT;
    private DialogInterface.OnCancelListener awU;
    private DialogInterface.OnDismissListener awV;
    private AlertDialog awW;
    private ViewGroup awX;
    private Object axa;
    private TextView axb;
    private TextView axc;
    private View axd;
    private View axe;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int awK = -1;
    private boolean awL = true;
    private boolean awM = false;
    private boolean awN = false;
    private int awQ = -1;
    private int awR = 0;
    private boolean awY = false;
    private boolean awZ = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a eJ(String str) {
        this.mTitle = str;
        return this;
    }

    public a da(int i) {
        eJ(this.mActivity.getResources().getString(i));
        return this;
    }

    public a eK(String str) {
        this.mMessage = str;
        return this;
    }

    public a G(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.awU = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.awV = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.awO = str;
        this.awS = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.awP = str;
        this.awT = bVar;
        return this;
    }

    public a db(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.awO = this.mActivity.getResources().getString(i);
            this.awS = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.awP = this.mActivity.getResources().getString(i);
            this.awT = bVar;
        }
        return this;
    }

    public a bg(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a bh(boolean z) {
        this.awZ = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_bdalert, (ViewGroup) null);
        this.awX = (ViewGroup) this.mRootView.findViewById(e.g.real_view);
    }

    public a dc(int i) {
        if (isAutoNight()) {
            this.awQ = al.getColor(i);
        } else {
            this.awQ = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a dd(int i) {
        this.awR = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.awY) {
            this.awY = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(e.g.dialog_content);
            this.axb = (TextView) this.mRootView.findViewById(e.g.yes);
            this.axc = (TextView) this.mRootView.findViewById(e.g.no);
            this.axd = this.mRootView.findViewById(e.g.divider_yes_no_button);
            this.axe = this.mRootView.findViewById(e.g.bdDialog_divider_line);
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
                View BP = BP();
                if (BP != null) {
                    linearLayout.removeAllViews();
                    if (BP.getParent() != null) {
                        if (BP.getParent() instanceof ViewGroup) {
                            ((ViewGroup) BP.getParent()).removeView(BP);
                            linearLayout.addView(BP);
                        }
                    } else {
                        linearLayout.addView(BP);
                    }
                }
            }
            c(eVar);
            if (this.awQ != -1) {
                if (this.axb != null) {
                    this.axb.setTextColor(this.awQ);
                }
                if (this.axc != null) {
                    this.axc.setTextColor(this.awQ);
                }
            }
            if (TextUtils.isEmpty(this.awO) || this.axb == null) {
                z = false;
            } else {
                this.axb.setText(this.awO);
                this.axb.setTag(this.axa);
                if (this.awS != null) {
                    this.axb.setOnClickListener(new View$OnClickListenerC0157a(this, this.awS));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.awP) || this.axc == null) {
                z2 = false;
            } else {
                this.axc.setText(this.awP);
                if (this.awT != null) {
                    this.axc.setOnClickListener(new View$OnClickListenerC0157a(this, this.awT));
                }
            }
            j(z, z2);
        }
        return this;
    }

    public View BP() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(e.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(e.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(e.g.message_view);
                if (this.awM) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.awN) {
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
            if (this.awL) {
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
            this.mRootView.setBackgroundResource(e.f.transparent_bg);
        }
    }

    private void j(boolean z, boolean z2) {
        if (z && z2) {
            if (this.axd != null) {
                this.axd.setVisibility(0);
            }
            if (this.axe != null) {
                this.axe.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.axd != null) {
            this.axd.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.axb != null && this.axc != null && this.axd != null && this.axe != null) {
                this.axb.setVisibility(8);
                this.axc.setVisibility(8);
                this.axd.setVisibility(8);
                this.axe.setVisibility(8);
            }
        } else if (z) {
            al.d(this.axb, e.f.dialog_single_button_bg_selector, skinType);
            if (this.axc != null && this.axd != null && this.axe != null) {
                this.axe.setVisibility(0);
                this.axb.setVisibility(0);
                this.axc.setVisibility(8);
            }
        } else if (z2) {
            al.d(this.axc, e.f.dialog_single_button_bg_selector, skinType);
            if (this.axb != null && this.axd != null && this.axe != null) {
                this.axe.setVisibility(0);
                this.axc.setVisibility(0);
                this.axb.setVisibility(8);
            }
        } else if (this.axb != null && this.axc != null && this.axe != null) {
            this.axe.setVisibility(8);
            this.axb.setVisibility(8);
            this.axc.setVisibility(8);
        }
    }

    public a BQ() {
        return bi(false);
    }

    private a bi(boolean z) {
        if (!this.awY) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.awW != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.awW, this.mActivity);
            } else {
                this.awW.show();
            }
        } else {
            this.awW = new AlertDialog.Builder(this.mActivity).create();
            this.awW.setCanceledOnTouchOutside(this.awZ);
            this.awW.setCancelable(this.mCancelable);
            this.awW.setOnKeyListener(this.mOnKeyListener);
            if (this.awU != null) {
                this.awW.setOnCancelListener(this.awU);
            }
            if (this.awV != null) {
                this.awW.setOnDismissListener(this.awV);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.awW, this.mActivity);
            } else {
                this.awW.show();
            }
            if (this.awW.getWindow().getDecorView().getParent() != null) {
                Window window = this.awW.getWindow();
                if (this.awK == -1) {
                    this.awK = 17;
                }
                window.setGravity(this.awK);
                window.setBackgroundDrawableResource(e.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics s = l.s(this.mActivity);
                if (s != null) {
                    int BR = BR();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = s.heightPixels - (BR * 2);
                    } else {
                        attributes.width = s.widthPixels - (BR * 2);
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

    public int BR() {
        return this.awR == 1 ? l.h(this.mActivity, e.C0210e.ds40) : l.h(this.mActivity, e.C0210e.ds90);
    }

    public boolean isShowing() {
        if (this.awW != null) {
            return this.awW.isShowing();
        }
        return false;
    }

    public void bj(boolean z) {
        if (this.axb != null) {
            this.axb.setClickable(z);
        }
    }

    public void bk(boolean z) {
        if (this.axc != null) {
            this.axc.setClickable(z);
        }
    }

    public a BS() {
        return bi(true);
    }

    public void hide() {
        if (this.awW != null) {
            this.awW.hide();
        }
    }

    public void dismiss() {
        if (this.awW != null) {
            com.baidu.adp.lib.g.g.b(this.awW, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0157a implements View.OnClickListener {
        private final a Tm;
        private final b axh;

        public View$OnClickListenerC0157a(a aVar, b bVar) {
            this.Tm = aVar;
            this.axh = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.axh != null) {
                this.axh.onClick(this.Tm);
            }
        }
    }

    public ViewGroup BT() {
        return this.awX;
    }

    public void H(Object obj) {
        this.axa = obj;
    }

    public Object BU() {
        return this.axa;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void bl(boolean z) {
        this.awL = z;
    }

    public void bm(boolean z) {
        this.awM = z;
    }

    public void bn(boolean z) {
        this.awN = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.awY = false;
    }
}
