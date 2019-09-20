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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private b bNB;
    private b bNC;
    private b bND;
    private DialogInterface.OnCancelListener bNE;
    private DialogInterface.OnDismissListener bNF;
    private ViewGroup bNG;
    private Object bNJ;
    private TextView bNK;
    private TextView bNL;
    private View bNM;
    private View bNN;
    private Button bNO;
    private String bNw;
    private String bNx;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int bNs = -1;
    private boolean bNt = true;
    private boolean bNu = false;
    private boolean bNv = false;
    private int bNy = -1;
    private int bNz = -1;
    private int bNA = 0;
    private boolean bNH = false;
    private boolean bNI = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a mP(String str) {
        this.mTitle = str;
        return this;
    }

    public a hu(int i) {
        mP(this.mActivity.getResources().getString(i));
        return this;
    }

    public a mQ(String str) {
        this.mMessage = str;
        return this;
    }

    public a aH(View view) {
        this.mContentView = view;
        return this;
    }

    public a b(DialogInterface.OnCancelListener onCancelListener) {
        this.bNE = onCancelListener;
        return this;
    }

    public a c(DialogInterface.OnDismissListener onDismissListener) {
        this.bNF = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.bNw = str;
        this.bNB = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.bNx = str;
        this.bNC = bVar;
        return this;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.bND = bVar;
        }
        return this;
    }

    public a hv(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.bNw = this.mActivity.getResources().getString(i);
            this.bNB = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.bNx = this.mActivity.getResources().getString(i);
            this.bNC = bVar;
        }
        return this;
    }

    public a dQ(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a dR(boolean z) {
        this.bNI = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdalert, (ViewGroup) null);
        this.bNG = (ViewGroup) this.mRootView.findViewById(R.id.real_view);
    }

    public a hw(int i) {
        if (isAutoNight()) {
            this.bNy = am.getColor(i);
        } else {
            this.bNy = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a hx(int i) {
        if (isAutoNight()) {
            this.bNz = am.getColor(i);
        } else {
            this.bNz = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a hy(int i) {
        this.bNA = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.bNH) {
            this.bNH = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.dialog_content);
            this.bNK = (TextView) this.mRootView.findViewById(R.id.yes);
            this.bNL = (TextView) this.mRootView.findViewById(R.id.no);
            this.bNM = this.mRootView.findViewById(R.id.divider_yes_no_button);
            this.bNN = this.mRootView.findViewById(R.id.bdDialog_divider_line);
            this.bNO = (Button) this.mRootView.findViewById(R.id.close_btn);
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
                View agM = agM();
                if (agM != null) {
                    linearLayout.removeAllViews();
                    if (agM.getParent() != null) {
                        if (agM.getParent() instanceof ViewGroup) {
                            ((ViewGroup) agM.getParent()).removeView(agM);
                            linearLayout.addView(agM);
                        }
                    } else {
                        linearLayout.addView(agM);
                    }
                }
            }
            c(eVar);
            if (this.bND != null) {
                this.bNO.setVisibility(0);
                this.bNO.setOnClickListener(new View$OnClickListenerC0250a(this, this.bND));
                am.g(this.bNO, R.drawable.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.bNy != -1) {
                if (this.bNK != null) {
                    this.bNK.setTextColor(this.bNy);
                }
                if (this.bNL != null) {
                    this.bNL.setTextColor(this.bNy);
                }
            }
            if (this.bNz != -1 && this.bNL != null) {
                this.bNL.setTextColor(this.bNz);
            }
            if (TextUtils.isEmpty(this.bNw) || this.bNK == null) {
                z = false;
            } else {
                this.bNK.setText(this.bNw);
                this.bNK.setTag(this.bNJ);
                if (this.bNB != null) {
                    this.bNK.setOnClickListener(new View$OnClickListenerC0250a(this, this.bNB));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.bNx) || this.bNL == null) {
                z2 = false;
            } else {
                this.bNL.setText(this.bNx);
                if (this.bNC != null) {
                    this.bNL.setOnClickListener(new View$OnClickListenerC0250a(this, this.bNC));
                }
            }
            p(z, z2);
        }
        return this;
    }

    public View agM() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.message_view);
                if (this.bNu) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.bNv) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(R.id.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            if (this.bNt) {
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
            ((TbPageContext) eVar).getLayoutMode().setFroceDayMode(isAutoNight() ? false : true);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mContentView);
            }
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundResource(R.drawable.transparent_bg);
        }
        if (this.bNG != null && this.bNA == 2) {
            this.bNG.setBackgroundResource(R.drawable.dialog_private_background);
        } else {
            am.g(this.bNG, R.drawable.dialog_background, skinType);
        }
    }

    private void p(boolean z, boolean z2) {
        if (z && z2) {
            if (this.bNM != null) {
                this.bNM.setVisibility(0);
            }
            if (this.bNN != null) {
                this.bNN.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.bNM != null) {
            this.bNM.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.bNK != null && this.bNL != null && this.bNM != null && this.bNN != null) {
                this.bNK.setVisibility(8);
                this.bNL.setVisibility(8);
                this.bNM.setVisibility(8);
                this.bNN.setVisibility(8);
            }
        } else if (z) {
            am.g(this.bNK, R.drawable.dialog_single_button_bg_selector, skinType);
            if (this.bNL != null && this.bNM != null && this.bNN != null) {
                this.bNN.setVisibility(0);
                this.bNK.setVisibility(0);
                this.bNL.setVisibility(8);
            }
        } else if (z2) {
            am.g(this.bNL, R.drawable.dialog_single_button_bg_selector, skinType);
            if (this.bNK != null && this.bNM != null && this.bNN != null) {
                this.bNN.setVisibility(0);
                this.bNL.setVisibility(0);
                this.bNK.setVisibility(8);
            }
        } else if (this.bNK != null && this.bNL != null && this.bNN != null) {
            this.bNN.setVisibility(8);
            this.bNK.setVisibility(8);
            this.bNL.setVisibility(8);
        }
    }

    private a dS(boolean z) {
        if (!this.bNH) {
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
            this.mDialog.setCanceledOnTouchOutside(this.bNI);
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnKeyListener(this.mOnKeyListener);
            if (this.bNE != null) {
                this.mDialog.setOnCancelListener(this.bNE);
            }
            if (this.bNF != null) {
                this.mDialog.setOnDismissListener(this.bNF);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            if (this.mDialog.getWindow().getDecorView().getParent() != null) {
                Window window = this.mDialog.getWindow();
                if (this.bNs == -1) {
                    this.bNs = 17;
                }
                window.setGravity(this.bNs);
                window.setBackgroundDrawableResource(R.drawable.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics v = com.baidu.adp.lib.util.l.v(this.mActivity);
                if (v != null) {
                    int agN = agN();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = v.heightPixels - (agN * 2);
                    } else {
                        attributes.width = v.widthPixels - (agN * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bc.a(this.mRootView, false, new bc.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.bc.a
                    public boolean aI(View view) {
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

    public int agN() {
        int i = R.dimen.tbds0;
        if (this.bNA == 0) {
            i = R.dimen.ds90;
        } else if (this.bNA == 1) {
            i = R.dimen.ds40;
        } else if (this.bNA == 2) {
            i = R.dimen.tbds44;
        }
        return com.baidu.adp.lib.util.l.g(this.mActivity, i);
    }

    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

    public void dT(boolean z) {
        if (this.bNK != null) {
            this.bNK.setClickable(z);
        }
    }

    public void dU(boolean z) {
        if (this.bNL != null) {
            this.bNL.setClickable(z);
        }
    }

    public a agO() {
        return dS(true);
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
    public class View$OnClickListenerC0250a implements View.OnClickListener {
        private final a TW;
        private final b bNR;

        public View$OnClickListenerC0250a(a aVar, b bVar) {
            this.TW = aVar;
            this.bNR = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bNR != null) {
                this.bNR.onClick(this.TW);
            }
        }
    }

    public ViewGroup agP() {
        return this.bNG;
    }

    public void ab(Object obj) {
        this.bNJ = obj;
    }

    public Object agQ() {
        return this.bNJ;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.mDialog.getWindow();
    }

    public void dV(boolean z) {
        this.bNt = z;
    }

    public void dW(boolean z) {
        this.bNu = z;
    }

    public void dX(boolean z) {
        this.bNv = z;
    }

    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.bNH = false;
    }
}
