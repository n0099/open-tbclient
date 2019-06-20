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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String bLS;
    private String bLT;
    private b bLX;
    private b bLY;
    private b bLZ;
    private DialogInterface.OnCancelListener bMa;
    private DialogInterface.OnDismissListener bMb;
    private ViewGroup bMc;
    private Object bMf;
    private TextView bMg;
    private TextView bMh;
    private View bMi;
    private View bMj;
    private Button bMk;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int bLO = -1;
    private boolean bLP = true;
    private boolean bLQ = false;
    private boolean bLR = false;
    private int bLU = -1;
    private int bLV = -1;
    private int bLW = 0;
    private boolean bMd = false;
    private boolean bMe = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a mC(String str) {
        this.mTitle = str;
        return this;
    }

    public a hn(int i) {
        mC(this.mActivity.getResources().getString(i));
        return this;
    }

    public a mD(String str) {
        this.mMessage = str;
        return this;
    }

    public a aF(View view) {
        this.mContentView = view;
        return this;
    }

    public a b(DialogInterface.OnCancelListener onCancelListener) {
        this.bMa = onCancelListener;
        return this;
    }

    public a c(DialogInterface.OnDismissListener onDismissListener) {
        this.bMb = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.bLS = str;
        this.bLX = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.bLT = str;
        this.bLY = bVar;
        return this;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.bLZ = bVar;
        }
        return this;
    }

    public a ho(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.bLS = this.mActivity.getResources().getString(i);
            this.bLX = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.bLT = this.mActivity.getResources().getString(i);
            this.bLY = bVar;
        }
        return this;
    }

    public a dM(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a dN(boolean z) {
        this.bMe = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdalert, (ViewGroup) null);
        this.bMc = (ViewGroup) this.mRootView.findViewById(R.id.real_view);
    }

    public a hp(int i) {
        if (isAutoNight()) {
            this.bLU = al.getColor(i);
        } else {
            this.bLU = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a hq(int i) {
        if (isAutoNight()) {
            this.bLV = al.getColor(i);
        } else {
            this.bLV = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a hr(int i) {
        this.bLW = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.bMd) {
            this.bMd = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.dialog_content);
            this.bMg = (TextView) this.mRootView.findViewById(R.id.yes);
            this.bMh = (TextView) this.mRootView.findViewById(R.id.no);
            this.bMi = this.mRootView.findViewById(R.id.divider_yes_no_button);
            this.bMj = this.mRootView.findViewById(R.id.bdDialog_divider_line);
            this.bMk = (Button) this.mRootView.findViewById(R.id.close_btn);
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
                View afE = afE();
                if (afE != null) {
                    linearLayout.removeAllViews();
                    if (afE.getParent() != null) {
                        if (afE.getParent() instanceof ViewGroup) {
                            ((ViewGroup) afE.getParent()).removeView(afE);
                            linearLayout.addView(afE);
                        }
                    } else {
                        linearLayout.addView(afE);
                    }
                }
            }
            c(eVar);
            if (this.bLZ != null) {
                this.bMk.setVisibility(0);
                this.bMk.setOnClickListener(new View$OnClickListenerC0239a(this, this.bLZ));
                al.g(this.bMk, R.drawable.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.bLU != -1) {
                if (this.bMg != null) {
                    this.bMg.setTextColor(this.bLU);
                }
                if (this.bMh != null) {
                    this.bMh.setTextColor(this.bLU);
                }
            }
            if (this.bLV != -1 && this.bMh != null) {
                this.bMh.setTextColor(this.bLV);
            }
            if (TextUtils.isEmpty(this.bLS) || this.bMg == null) {
                z = false;
            } else {
                this.bMg.setText(this.bLS);
                this.bMg.setTag(this.bMf);
                if (this.bLX != null) {
                    this.bMg.setOnClickListener(new View$OnClickListenerC0239a(this, this.bLX));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.bLT) || this.bMh == null) {
                z2 = false;
            } else {
                this.bMh.setText(this.bLT);
                if (this.bLY != null) {
                    this.bMh.setOnClickListener(new View$OnClickListenerC0239a(this, this.bLY));
                }
            }
            n(z, z2);
        }
        return this;
    }

    public View afE() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.message_view);
                if (this.bLQ) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.bLR) {
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
            if (this.bLP) {
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
            this.mRootView.setBackgroundResource(R.drawable.transparent_bg);
        }
        if (this.bMc != null && this.bLW == 2) {
            this.bMc.setBackgroundResource(R.drawable.dialog_private_background);
        } else {
            al.g(this.bMc, R.drawable.dialog_background, skinType);
        }
    }

    private void n(boolean z, boolean z2) {
        if (z && z2) {
            if (this.bMi != null) {
                this.bMi.setVisibility(0);
            }
            if (this.bMj != null) {
                this.bMj.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.bMi != null) {
            this.bMi.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.bMg != null && this.bMh != null && this.bMi != null && this.bMj != null) {
                this.bMg.setVisibility(8);
                this.bMh.setVisibility(8);
                this.bMi.setVisibility(8);
                this.bMj.setVisibility(8);
            }
        } else if (z) {
            al.g(this.bMg, R.drawable.dialog_single_button_bg_selector, skinType);
            if (this.bMh != null && this.bMi != null && this.bMj != null) {
                this.bMj.setVisibility(0);
                this.bMg.setVisibility(0);
                this.bMh.setVisibility(8);
            }
        } else if (z2) {
            al.g(this.bMh, R.drawable.dialog_single_button_bg_selector, skinType);
            if (this.bMg != null && this.bMi != null && this.bMj != null) {
                this.bMj.setVisibility(0);
                this.bMh.setVisibility(0);
                this.bMg.setVisibility(8);
            }
        } else if (this.bMg != null && this.bMh != null && this.bMj != null) {
            this.bMj.setVisibility(8);
            this.bMg.setVisibility(8);
            this.bMh.setVisibility(8);
        }
    }

    private a dO(boolean z) {
        if (!this.bMd) {
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
            this.mDialog.setCanceledOnTouchOutside(this.bMe);
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnKeyListener(this.mOnKeyListener);
            if (this.bMa != null) {
                this.mDialog.setOnCancelListener(this.bMa);
            }
            if (this.bMb != null) {
                this.mDialog.setOnDismissListener(this.bMb);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            if (this.mDialog.getWindow().getDecorView().getParent() != null) {
                Window window = this.mDialog.getWindow();
                if (this.bLO == -1) {
                    this.bLO = 17;
                }
                window.setGravity(this.bLO);
                window.setBackgroundDrawableResource(R.drawable.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics s = com.baidu.adp.lib.util.l.s(this.mActivity);
                if (s != null) {
                    int afF = afF();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = s.heightPixels - (afF * 2);
                    } else {
                        attributes.width = s.widthPixels - (afF * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bc.a(this.mRootView, false, new bc.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.bc.a
                    public boolean aG(View view) {
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

    public int afF() {
        int i = R.dimen.tbds0;
        if (this.bLW == 0) {
            i = R.dimen.ds90;
        } else if (this.bLW == 1) {
            i = R.dimen.ds40;
        } else if (this.bLW == 2) {
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

    public void dP(boolean z) {
        if (this.bMg != null) {
            this.bMg.setClickable(z);
        }
    }

    public void dQ(boolean z) {
        if (this.bMh != null) {
            this.bMh.setClickable(z);
        }
    }

    public a afG() {
        return dO(true);
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
    public class View$OnClickListenerC0239a implements View.OnClickListener {
        private final a TD;
        private final b bMn;

        public View$OnClickListenerC0239a(a aVar, b bVar) {
            this.TD = aVar;
            this.bMn = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bMn != null) {
                this.bMn.onClick(this.TD);
            }
        }
    }

    public ViewGroup afH() {
        return this.bMc;
    }

    public void ab(Object obj) {
        this.bMf = obj;
    }

    public Object afI() {
        return this.bMf;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void dR(boolean z) {
        this.bLP = z;
    }

    public void dS(boolean z) {
        this.bLQ = z;
    }

    public void dT(boolean z) {
        this.bLR = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.bMd = false;
    }
}
