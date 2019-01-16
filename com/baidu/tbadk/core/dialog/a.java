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
    private String awN;
    private String awO;
    private b awR;
    private b awS;
    private DialogInterface.OnCancelListener awT;
    private DialogInterface.OnDismissListener awU;
    private AlertDialog awV;
    private ViewGroup awW;
    private Object awZ;
    private TextView axa;
    private TextView axb;
    private View axc;
    private View axd;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int awJ = -1;
    private boolean awK = true;
    private boolean awL = false;
    private boolean awM = false;
    private int awP = -1;
    private int awQ = 0;
    private boolean awX = false;
    private boolean awY = true;
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
        this.awT = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.awU = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.awN = str;
        this.awR = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.awO = str;
        this.awS = bVar;
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
            this.awN = this.mActivity.getResources().getString(i);
            this.awR = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.awO = this.mActivity.getResources().getString(i);
            this.awS = bVar;
        }
        return this;
    }

    public a bg(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a bh(boolean z) {
        this.awY = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_bdalert, (ViewGroup) null);
        this.awW = (ViewGroup) this.mRootView.findViewById(e.g.real_view);
    }

    public a dc(int i) {
        if (isAutoNight()) {
            this.awP = al.getColor(i);
        } else {
            this.awP = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a dd(int i) {
        this.awQ = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.awX) {
            this.awX = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(e.g.dialog_content);
            this.axa = (TextView) this.mRootView.findViewById(e.g.yes);
            this.axb = (TextView) this.mRootView.findViewById(e.g.no);
            this.axc = this.mRootView.findViewById(e.g.divider_yes_no_button);
            this.axd = this.mRootView.findViewById(e.g.bdDialog_divider_line);
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
            if (this.awP != -1) {
                if (this.axa != null) {
                    this.axa.setTextColor(this.awP);
                }
                if (this.axb != null) {
                    this.axb.setTextColor(this.awP);
                }
            }
            if (TextUtils.isEmpty(this.awN) || this.axa == null) {
                z = false;
            } else {
                this.axa.setText(this.awN);
                this.axa.setTag(this.awZ);
                if (this.awR != null) {
                    this.axa.setOnClickListener(new View$OnClickListenerC0157a(this, this.awR));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.awO) || this.axb == null) {
                z2 = false;
            } else {
                this.axb.setText(this.awO);
                if (this.awS != null) {
                    this.axb.setOnClickListener(new View$OnClickListenerC0157a(this, this.awS));
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
                if (this.awL) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.awM) {
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
            if (this.awK) {
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
            if (this.axc != null) {
                this.axc.setVisibility(0);
            }
            if (this.axd != null) {
                this.axd.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.axc != null) {
            this.axc.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.axa != null && this.axb != null && this.axc != null && this.axd != null) {
                this.axa.setVisibility(8);
                this.axb.setVisibility(8);
                this.axc.setVisibility(8);
                this.axd.setVisibility(8);
            }
        } else if (z) {
            al.d(this.axa, e.f.dialog_single_button_bg_selector, skinType);
            if (this.axb != null && this.axc != null && this.axd != null) {
                this.axd.setVisibility(0);
                this.axa.setVisibility(0);
                this.axb.setVisibility(8);
            }
        } else if (z2) {
            al.d(this.axb, e.f.dialog_single_button_bg_selector, skinType);
            if (this.axa != null && this.axc != null && this.axd != null) {
                this.axd.setVisibility(0);
                this.axb.setVisibility(0);
                this.axa.setVisibility(8);
            }
        } else if (this.axa != null && this.axb != null && this.axd != null) {
            this.axd.setVisibility(8);
            this.axa.setVisibility(8);
            this.axb.setVisibility(8);
        }
    }

    public a BQ() {
        return bi(false);
    }

    private a bi(boolean z) {
        if (!this.awX) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.awV != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.awV, this.mActivity);
            } else {
                this.awV.show();
            }
        } else {
            this.awV = new AlertDialog.Builder(this.mActivity).create();
            this.awV.setCanceledOnTouchOutside(this.awY);
            this.awV.setCancelable(this.mCancelable);
            this.awV.setOnKeyListener(this.mOnKeyListener);
            if (this.awT != null) {
                this.awV.setOnCancelListener(this.awT);
            }
            if (this.awU != null) {
                this.awV.setOnDismissListener(this.awU);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.awV, this.mActivity);
            } else {
                this.awV.show();
            }
            if (this.awV.getWindow().getDecorView().getParent() != null) {
                Window window = this.awV.getWindow();
                if (this.awJ == -1) {
                    this.awJ = 17;
                }
                window.setGravity(this.awJ);
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
        return this.awQ == 1 ? l.h(this.mActivity, e.C0210e.ds40) : l.h(this.mActivity, e.C0210e.ds90);
    }

    public boolean isShowing() {
        if (this.awV != null) {
            return this.awV.isShowing();
        }
        return false;
    }

    public void bj(boolean z) {
        if (this.axa != null) {
            this.axa.setClickable(z);
        }
    }

    public void bk(boolean z) {
        if (this.axb != null) {
            this.axb.setClickable(z);
        }
    }

    public a BS() {
        return bi(true);
    }

    public void hide() {
        if (this.awV != null) {
            this.awV.hide();
        }
    }

    public void dismiss() {
        if (this.awV != null) {
            com.baidu.adp.lib.g.g.b(this.awV, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0157a implements View.OnClickListener {
        private final a Tm;
        private final b axg;

        public View$OnClickListenerC0157a(a aVar, b bVar) {
            this.Tm = aVar;
            this.axg = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.axg != null) {
                this.axg.onClick(this.Tm);
            }
        }
    }

    public ViewGroup BT() {
        return this.awW;
    }

    public void H(Object obj) {
        this.awZ = obj;
    }

    public Object BU() {
        return this.awZ;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void bl(boolean z) {
        this.awK = z;
    }

    public void bm(boolean z) {
        this.awL = z;
    }

    public void bn(boolean z) {
        this.awM = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.awX = false;
    }
}
