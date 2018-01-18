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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String aPG;
    private String aPH;
    private b aPK;
    private b aPL;
    private DialogInterface.OnCancelListener aPM;
    private AlertDialog aPN;
    private ViewGroup aPO;
    private Object aPR;
    private TextView aPS;
    private TextView aPT;
    private View aPU;
    private View aPV;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aPC = -1;
    private boolean aPD = true;
    private boolean aPE = false;
    private boolean aPF = false;
    private int aPI = -1;
    private int aPJ = 0;
    private boolean aPP = false;
    private boolean aPQ = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cY(String str) {
        this.mTitle = str;
        return this;
    }

    public a fa(int i) {
        cY(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cZ(String str) {
        this.mMessage = str;
        return this;
    }

    public a aO(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.aPM = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aPG = str;
        this.aPK = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aPH = str;
        this.aPL = bVar;
        return this;
    }

    public a fb(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aPG = this.mActivity.getResources().getString(i);
            this.aPK = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aPH = this.mActivity.getResources().getString(i);
            this.aPL = bVar;
        }
        return this;
    }

    public a aV(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a aW(boolean z) {
        this.aPQ = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.aPO = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a fc(int i) {
        if (isAutoNight()) {
            this.aPI = aj.getColor(i);
        } else {
            this.aPI = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a fd(int i) {
        this.aPJ = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aPP) {
            this.aPP = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.aPS = (TextView) this.mRootView.findViewById(d.g.yes);
            this.aPT = (TextView) this.mRootView.findViewById(d.g.no);
            this.aPU = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.aPV = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
                View Ax = Ax();
                if (Ax != null) {
                    linearLayout.removeAllViews();
                    if (Ax.getParent() != null) {
                        if (Ax.getParent() instanceof ViewGroup) {
                            ((ViewGroup) Ax.getParent()).removeView(Ax);
                            linearLayout.addView(Ax);
                        }
                    } else {
                        linearLayout.addView(Ax);
                    }
                }
            }
            c(eVar);
            if (this.aPI != -1) {
                if (this.aPS != null) {
                    this.aPS.setTextColor(this.aPI);
                }
                if (this.aPT != null) {
                    this.aPT.setTextColor(this.aPI);
                }
            }
            if (TextUtils.isEmpty(this.aPG) || this.aPS == null) {
                z = false;
            } else {
                this.aPS.setText(this.aPG);
                this.aPS.setTag(this.aPR);
                if (this.aPK != null) {
                    this.aPS.setOnClickListener(new View$OnClickListenerC0072a(this, this.aPK));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aPH) || this.aPT == null) {
                z2 = false;
            } else {
                this.aPT.setText(this.aPH);
                if (this.aPL != null) {
                    this.aPT.setOnClickListener(new View$OnClickListenerC0072a(this, this.aPL));
                }
            }
            k(z, z2);
        }
        return this;
    }

    public View Ax() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.aPE) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aPF) {
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
            if (this.aPD) {
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
            ((TbPageContext) eVar).getLayoutMode().aM(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().aM(this.mContentView);
            }
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundResource(d.f.transparent_bg);
        }
    }

    private void k(boolean z, boolean z2) {
        if (z && z2) {
            if (this.aPU != null) {
                this.aPU.setVisibility(0);
            }
            if (this.aPV != null) {
                this.aPV.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aPU != null) {
            this.aPU.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aPS != null && this.aPT != null && this.aPU != null && this.aPV != null) {
                this.aPS.setVisibility(8);
                this.aPT.setVisibility(8);
                this.aPU.setVisibility(8);
                this.aPV.setVisibility(8);
            }
        } else if (z) {
            aj.f(this.aPS, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aPT != null && this.aPU != null && this.aPV != null) {
                this.aPV.setVisibility(0);
                this.aPS.setVisibility(0);
                this.aPT.setVisibility(8);
            }
        } else if (z2) {
            aj.f(this.aPT, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aPS != null && this.aPU != null && this.aPV != null) {
                this.aPV.setVisibility(0);
                this.aPT.setVisibility(0);
                this.aPS.setVisibility(8);
            }
        } else if (this.aPS != null && this.aPT != null && this.aPV != null) {
            this.aPV.setVisibility(8);
            this.aPS.setVisibility(8);
            this.aPT.setVisibility(8);
        }
    }

    public a Ay() {
        return aX(false);
    }

    private a aX(boolean z) {
        if (!this.aPP) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aPN != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aPN, this.mActivity);
            } else {
                this.aPN.show();
            }
        } else {
            this.aPN = new AlertDialog.Builder(this.mActivity).create();
            this.aPN.setCanceledOnTouchOutside(this.aPQ);
            this.aPN.setCancelable(this.mCancelable);
            this.aPN.setOnKeyListener(this.mOnKeyListener);
            if (this.aPM != null) {
                this.aPN.setOnCancelListener(this.aPM);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aPN, this.mActivity);
            } else {
                this.aPN.show();
            }
            if (this.aPN.getWindow().getDecorView().getParent() != null) {
                Window window = this.aPN.getWindow();
                if (this.aPC == -1) {
                    this.aPC = 17;
                }
                window.setGravity(this.aPC);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = l.o(this.mActivity);
                if (o != null) {
                    int Az = Az();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (Az * 2);
                    } else {
                        attributes.width = o.widthPixels - (Az * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ax.a(this.mRootView, false, new ax.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.ax.a
                    public boolean aP(View view) {
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

    public int Az() {
        return this.aPJ == 1 ? l.s(this.mActivity, d.e.ds40) : l.s(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.aPN != null) {
            return this.aPN.isShowing();
        }
        return false;
    }

    public void aY(boolean z) {
        if (this.aPS != null) {
            this.aPS.setClickable(z);
        }
    }

    public void aZ(boolean z) {
        if (this.aPT != null) {
            this.aPT.setClickable(z);
        }
    }

    public a AA() {
        return aX(true);
    }

    public void hide() {
        if (this.aPN != null) {
            this.aPN.hide();
        }
    }

    public void dismiss() {
        if (this.aPN != null) {
            com.baidu.adp.lib.g.g.b(this.aPN, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0072a implements View.OnClickListener {
        private final b aPY;
        private final a axQ;

        public View$OnClickListenerC0072a(a aVar, b bVar) {
            this.axQ = aVar;
            this.aPY = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aPY != null) {
                this.aPY.onClick(this.axQ);
            }
        }
    }

    public ViewGroup AB() {
        return this.aPO;
    }

    public void aE(Object obj) {
        this.aPR = obj;
    }

    public Object AC() {
        return this.aPR;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void ba(boolean z) {
        this.aPD = z;
    }

    public void bb(boolean z) {
        this.aPE = z;
    }

    public void bc(boolean z) {
        this.aPF = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.aPP = false;
    }
}
