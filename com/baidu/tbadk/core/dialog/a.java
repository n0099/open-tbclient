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
    private String aPJ;
    private String aPK;
    private b aPN;
    private b aPO;
    private DialogInterface.OnCancelListener aPP;
    private AlertDialog aPQ;
    private ViewGroup aPR;
    private Object aPU;
    private TextView aPV;
    private TextView aPW;
    private View aPX;
    private View aPY;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aPF = -1;
    private boolean aPG = true;
    private boolean aPH = false;
    private boolean aPI = false;
    private int aPL = -1;
    private int aPM = 0;
    private boolean aPS = false;
    private boolean aPT = true;
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
        this.aPP = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aPJ = str;
        this.aPN = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aPK = str;
        this.aPO = bVar;
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
            this.aPJ = this.mActivity.getResources().getString(i);
            this.aPN = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aPK = this.mActivity.getResources().getString(i);
            this.aPO = bVar;
        }
        return this;
    }

    public a aW(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a aX(boolean z) {
        this.aPT = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.aPR = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a fc(int i) {
        if (isAutoNight()) {
            this.aPL = aj.getColor(i);
        } else {
            this.aPL = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a fd(int i) {
        this.aPM = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aPS) {
            this.aPS = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.aPV = (TextView) this.mRootView.findViewById(d.g.yes);
            this.aPW = (TextView) this.mRootView.findViewById(d.g.no);
            this.aPX = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.aPY = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
                View Ay = Ay();
                if (Ay != null) {
                    linearLayout.removeAllViews();
                    if (Ay.getParent() != null) {
                        if (Ay.getParent() instanceof ViewGroup) {
                            ((ViewGroup) Ay.getParent()).removeView(Ay);
                            linearLayout.addView(Ay);
                        }
                    } else {
                        linearLayout.addView(Ay);
                    }
                }
            }
            c(eVar);
            if (this.aPL != -1) {
                if (this.aPV != null) {
                    this.aPV.setTextColor(this.aPL);
                }
                if (this.aPW != null) {
                    this.aPW.setTextColor(this.aPL);
                }
            }
            if (TextUtils.isEmpty(this.aPJ) || this.aPV == null) {
                z = false;
            } else {
                this.aPV.setText(this.aPJ);
                this.aPV.setTag(this.aPU);
                if (this.aPN != null) {
                    this.aPV.setOnClickListener(new View$OnClickListenerC0072a(this, this.aPN));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aPK) || this.aPW == null) {
                z2 = false;
            } else {
                this.aPW.setText(this.aPK);
                if (this.aPO != null) {
                    this.aPW.setOnClickListener(new View$OnClickListenerC0072a(this, this.aPO));
                }
            }
            k(z, z2);
        }
        return this;
    }

    public View Ay() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.aPH) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aPI) {
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
            if (this.aPG) {
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
            ((TbPageContext) eVar).getLayoutMode().aN(skinType == 1);
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
            if (this.aPX != null) {
                this.aPX.setVisibility(0);
            }
            if (this.aPY != null) {
                this.aPY.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aPX != null) {
            this.aPX.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aPV != null && this.aPW != null && this.aPX != null && this.aPY != null) {
                this.aPV.setVisibility(8);
                this.aPW.setVisibility(8);
                this.aPX.setVisibility(8);
                this.aPY.setVisibility(8);
            }
        } else if (z) {
            aj.f(this.aPV, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aPW != null && this.aPX != null && this.aPY != null) {
                this.aPY.setVisibility(0);
                this.aPV.setVisibility(0);
                this.aPW.setVisibility(8);
            }
        } else if (z2) {
            aj.f(this.aPW, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aPV != null && this.aPX != null && this.aPY != null) {
                this.aPY.setVisibility(0);
                this.aPW.setVisibility(0);
                this.aPV.setVisibility(8);
            }
        } else if (this.aPV != null && this.aPW != null && this.aPY != null) {
            this.aPY.setVisibility(8);
            this.aPV.setVisibility(8);
            this.aPW.setVisibility(8);
        }
    }

    public a Az() {
        return aY(false);
    }

    private a aY(boolean z) {
        if (!this.aPS) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aPQ != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aPQ, this.mActivity);
            } else {
                this.aPQ.show();
            }
        } else {
            this.aPQ = new AlertDialog.Builder(this.mActivity).create();
            this.aPQ.setCanceledOnTouchOutside(this.aPT);
            this.aPQ.setCancelable(this.mCancelable);
            this.aPQ.setOnKeyListener(this.mOnKeyListener);
            if (this.aPP != null) {
                this.aPQ.setOnCancelListener(this.aPP);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aPQ, this.mActivity);
            } else {
                this.aPQ.show();
            }
            if (this.aPQ.getWindow().getDecorView().getParent() != null) {
                Window window = this.aPQ.getWindow();
                if (this.aPF == -1) {
                    this.aPF = 17;
                }
                window.setGravity(this.aPF);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = l.o(this.mActivity);
                if (o != null) {
                    int AA = AA();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (AA * 2);
                    } else {
                        attributes.width = o.widthPixels - (AA * 2);
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

    public int AA() {
        return this.aPM == 1 ? l.s(this.mActivity, d.e.ds40) : l.s(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.aPQ != null) {
            return this.aPQ.isShowing();
        }
        return false;
    }

    public void aZ(boolean z) {
        if (this.aPV != null) {
            this.aPV.setClickable(z);
        }
    }

    public void ba(boolean z) {
        if (this.aPW != null) {
            this.aPW.setClickable(z);
        }
    }

    public a AB() {
        return aY(true);
    }

    public void hide() {
        if (this.aPQ != null) {
            this.aPQ.hide();
        }
    }

    public void dismiss() {
        if (this.aPQ != null) {
            com.baidu.adp.lib.g.g.b(this.aPQ, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0072a implements View.OnClickListener {
        private final b aQb;
        private final a axT;

        public View$OnClickListenerC0072a(a aVar, b bVar) {
            this.axT = aVar;
            this.aQb = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aQb != null) {
                this.aQb.onClick(this.axT);
            }
        }
    }

    public ViewGroup AC() {
        return this.aPR;
    }

    public void aE(Object obj) {
        this.aPU = obj;
    }

    public Object AD() {
        return this.aPU;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void bb(boolean z) {
        this.aPG = z;
    }

    public void bc(boolean z) {
        this.aPH = z;
    }

    public void bd(boolean z) {
        this.aPI = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.aPS = false;
    }
}
