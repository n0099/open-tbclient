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
    private String aPH;
    private String aPI;
    private b aPL;
    private b aPM;
    private DialogInterface.OnCancelListener aPN;
    private AlertDialog aPO;
    private ViewGroup aPP;
    private Object aPS;
    private TextView aPT;
    private TextView aPU;
    private View aPV;
    private View aPW;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aPD = -1;
    private boolean aPE = true;
    private boolean aPF = false;
    private boolean aPG = false;
    private int aPJ = -1;
    private int aPK = 0;
    private boolean aPQ = false;
    private boolean aPR = true;
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

    public a fc(int i) {
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
        this.aPN = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aPH = str;
        this.aPL = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aPI = str;
        this.aPM = bVar;
        return this;
    }

    public a fd(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aPH = this.mActivity.getResources().getString(i);
            this.aPL = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aPI = this.mActivity.getResources().getString(i);
            this.aPM = bVar;
        }
        return this;
    }

    public a aV(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a aW(boolean z) {
        this.aPR = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.aPP = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a fe(int i) {
        if (isAutoNight()) {
            this.aPJ = aj.getColor(i);
        } else {
            this.aPJ = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ff(int i) {
        this.aPK = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aPQ) {
            this.aPQ = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.aPT = (TextView) this.mRootView.findViewById(d.g.yes);
            this.aPU = (TextView) this.mRootView.findViewById(d.g.no);
            this.aPV = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.aPW = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
                View AF = AF();
                if (AF != null) {
                    linearLayout.removeAllViews();
                    if (AF.getParent() != null) {
                        if (AF.getParent() instanceof ViewGroup) {
                            ((ViewGroup) AF.getParent()).removeView(AF);
                            linearLayout.addView(AF);
                        }
                    } else {
                        linearLayout.addView(AF);
                    }
                }
            }
            c(eVar);
            if (this.aPJ != -1) {
                if (this.aPT != null) {
                    this.aPT.setTextColor(this.aPJ);
                }
                if (this.aPU != null) {
                    this.aPU.setTextColor(this.aPJ);
                }
            }
            if (TextUtils.isEmpty(this.aPH) || this.aPT == null) {
                z = false;
            } else {
                this.aPT.setText(this.aPH);
                this.aPT.setTag(this.aPS);
                if (this.aPL != null) {
                    this.aPT.setOnClickListener(new View$OnClickListenerC0073a(this, this.aPL));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aPI) || this.aPU == null) {
                z2 = false;
            } else {
                this.aPU.setText(this.aPI);
                if (this.aPM != null) {
                    this.aPU.setOnClickListener(new View$OnClickListenerC0073a(this, this.aPM));
                }
            }
            k(z, z2);
        }
        return this;
    }

    public View AF() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.aPF) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aPG) {
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
            if (this.aPE) {
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
            if (this.aPV != null) {
                this.aPV.setVisibility(0);
            }
            if (this.aPW != null) {
                this.aPW.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aPV != null) {
            this.aPV.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aPT != null && this.aPU != null && this.aPV != null && this.aPW != null) {
                this.aPT.setVisibility(8);
                this.aPU.setVisibility(8);
                this.aPV.setVisibility(8);
                this.aPW.setVisibility(8);
            }
        } else if (z) {
            aj.f(this.aPT, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aPU != null && this.aPV != null && this.aPW != null) {
                this.aPW.setVisibility(0);
                this.aPT.setVisibility(0);
                this.aPU.setVisibility(8);
            }
        } else if (z2) {
            aj.f(this.aPU, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aPT != null && this.aPV != null && this.aPW != null) {
                this.aPW.setVisibility(0);
                this.aPU.setVisibility(0);
                this.aPT.setVisibility(8);
            }
        } else if (this.aPT != null && this.aPU != null && this.aPW != null) {
            this.aPW.setVisibility(8);
            this.aPT.setVisibility(8);
            this.aPU.setVisibility(8);
        }
    }

    public a AG() {
        return aX(false);
    }

    private a aX(boolean z) {
        if (!this.aPQ) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aPO != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aPO, this.mActivity);
            } else {
                this.aPO.show();
            }
        } else {
            this.aPO = new AlertDialog.Builder(this.mActivity).create();
            this.aPO.setCanceledOnTouchOutside(this.aPR);
            this.aPO.setCancelable(this.mCancelable);
            this.aPO.setOnKeyListener(this.mOnKeyListener);
            if (this.aPN != null) {
                this.aPO.setOnCancelListener(this.aPN);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aPO, this.mActivity);
            } else {
                this.aPO.show();
            }
            if (this.aPO.getWindow().getDecorView().getParent() != null) {
                Window window = this.aPO.getWindow();
                if (this.aPD == -1) {
                    this.aPD = 17;
                }
                window.setGravity(this.aPD);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = l.o(this.mActivity);
                if (o != null) {
                    int AH = AH();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (AH * 2);
                    } else {
                        attributes.width = o.widthPixels - (AH * 2);
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

    public int AH() {
        return this.aPK == 1 ? l.s(this.mActivity, d.e.ds40) : l.s(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.aPO != null) {
            return this.aPO.isShowing();
        }
        return false;
    }

    public void aY(boolean z) {
        if (this.aPT != null) {
            this.aPT.setClickable(z);
        }
    }

    public void aZ(boolean z) {
        if (this.aPU != null) {
            this.aPU.setClickable(z);
        }
    }

    public a AI() {
        return aX(true);
    }

    public void hide() {
        if (this.aPO != null) {
            this.aPO.hide();
        }
    }

    public void dismiss() {
        if (this.aPO != null) {
            com.baidu.adp.lib.g.g.b(this.aPO, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0073a implements View.OnClickListener {
        private final b aPZ;
        private final a axR;

        public View$OnClickListenerC0073a(a aVar, b bVar) {
            this.axR = aVar;
            this.aPZ = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aPZ != null) {
                this.aPZ.onClick(this.axR);
            }
        }
    }

    public ViewGroup AJ() {
        return this.aPP;
    }

    public void aE(Object obj) {
        this.aPS = obj;
    }

    public Object AK() {
        return this.aPS;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.aPO.getWindow();
    }

    public Dialog getDialog() {
        return this.aPO;
    }

    public void ba(boolean z) {
        this.aPE = z;
    }

    public void bb(boolean z) {
        this.aPF = z;
    }

    public void bc(boolean z) {
        this.aPG = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.aPQ = false;
    }
}
