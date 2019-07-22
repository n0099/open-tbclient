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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String bMS;
    private String bMT;
    private b bMX;
    private b bMY;
    private b bMZ;
    private DialogInterface.OnCancelListener bNa;
    private DialogInterface.OnDismissListener bNb;
    private ViewGroup bNc;
    private Object bNf;
    private TextView bNg;
    private TextView bNh;
    private View bNi;
    private View bNj;
    private Button bNk;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int bMO = -1;
    private boolean bMP = true;
    private boolean bMQ = false;
    private boolean bMR = false;
    private int bMU = -1;
    private int bMV = -1;
    private int bMW = 0;
    private boolean bNd = false;
    private boolean bNe = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a mN(String str) {
        this.mTitle = str;
        return this;
    }

    public a ht(int i) {
        mN(this.mActivity.getResources().getString(i));
        return this;
    }

    public a mO(String str) {
        this.mMessage = str;
        return this;
    }

    public a aH(View view) {
        this.mContentView = view;
        return this;
    }

    public a b(DialogInterface.OnCancelListener onCancelListener) {
        this.bNa = onCancelListener;
        return this;
    }

    public a c(DialogInterface.OnDismissListener onDismissListener) {
        this.bNb = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.bMS = str;
        this.bMX = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.bMT = str;
        this.bMY = bVar;
        return this;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.bMZ = bVar;
        }
        return this;
    }

    public a hu(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.bMS = this.mActivity.getResources().getString(i);
            this.bMX = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.bMT = this.mActivity.getResources().getString(i);
            this.bMY = bVar;
        }
        return this;
    }

    public a dQ(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a dR(boolean z) {
        this.bNe = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdalert, (ViewGroup) null);
        this.bNc = (ViewGroup) this.mRootView.findViewById(R.id.real_view);
    }

    public a hv(int i) {
        if (isAutoNight()) {
            this.bMU = am.getColor(i);
        } else {
            this.bMU = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a hw(int i) {
        if (isAutoNight()) {
            this.bMV = am.getColor(i);
        } else {
            this.bMV = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a hx(int i) {
        this.bMW = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.bNd) {
            this.bNd = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.dialog_content);
            this.bNg = (TextView) this.mRootView.findViewById(R.id.yes);
            this.bNh = (TextView) this.mRootView.findViewById(R.id.no);
            this.bNi = this.mRootView.findViewById(R.id.divider_yes_no_button);
            this.bNj = this.mRootView.findViewById(R.id.bdDialog_divider_line);
            this.bNk = (Button) this.mRootView.findViewById(R.id.close_btn);
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
                View agG = agG();
                if (agG != null) {
                    linearLayout.removeAllViews();
                    if (agG.getParent() != null) {
                        if (agG.getParent() instanceof ViewGroup) {
                            ((ViewGroup) agG.getParent()).removeView(agG);
                            linearLayout.addView(agG);
                        }
                    } else {
                        linearLayout.addView(agG);
                    }
                }
            }
            c(eVar);
            if (this.bMZ != null) {
                this.bNk.setVisibility(0);
                this.bNk.setOnClickListener(new View$OnClickListenerC0236a(this, this.bMZ));
                am.g(this.bNk, R.drawable.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.bMU != -1) {
                if (this.bNg != null) {
                    this.bNg.setTextColor(this.bMU);
                }
                if (this.bNh != null) {
                    this.bNh.setTextColor(this.bMU);
                }
            }
            if (this.bMV != -1 && this.bNh != null) {
                this.bNh.setTextColor(this.bMV);
            }
            if (TextUtils.isEmpty(this.bMS) || this.bNg == null) {
                z = false;
            } else {
                this.bNg.setText(this.bMS);
                this.bNg.setTag(this.bNf);
                if (this.bMX != null) {
                    this.bNg.setOnClickListener(new View$OnClickListenerC0236a(this, this.bMX));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.bMT) || this.bNh == null) {
                z2 = false;
            } else {
                this.bNh.setText(this.bMT);
                if (this.bMY != null) {
                    this.bNh.setOnClickListener(new View$OnClickListenerC0236a(this, this.bMY));
                }
            }
            p(z, z2);
        }
        return this;
    }

    public View agG() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.message_view);
                if (this.bMQ) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.bMR) {
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
            if (this.bMP) {
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
        if (this.bNc != null && this.bMW == 2) {
            this.bNc.setBackgroundResource(R.drawable.dialog_private_background);
        } else {
            am.g(this.bNc, R.drawable.dialog_background, skinType);
        }
    }

    private void p(boolean z, boolean z2) {
        if (z && z2) {
            if (this.bNi != null) {
                this.bNi.setVisibility(0);
            }
            if (this.bNj != null) {
                this.bNj.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.bNi != null) {
            this.bNi.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.bNg != null && this.bNh != null && this.bNi != null && this.bNj != null) {
                this.bNg.setVisibility(8);
                this.bNh.setVisibility(8);
                this.bNi.setVisibility(8);
                this.bNj.setVisibility(8);
            }
        } else if (z) {
            am.g(this.bNg, R.drawable.dialog_single_button_bg_selector, skinType);
            if (this.bNh != null && this.bNi != null && this.bNj != null) {
                this.bNj.setVisibility(0);
                this.bNg.setVisibility(0);
                this.bNh.setVisibility(8);
            }
        } else if (z2) {
            am.g(this.bNh, R.drawable.dialog_single_button_bg_selector, skinType);
            if (this.bNg != null && this.bNi != null && this.bNj != null) {
                this.bNj.setVisibility(0);
                this.bNh.setVisibility(0);
                this.bNg.setVisibility(8);
            }
        } else if (this.bNg != null && this.bNh != null && this.bNj != null) {
            this.bNj.setVisibility(8);
            this.bNg.setVisibility(8);
            this.bNh.setVisibility(8);
        }
    }

    private a dS(boolean z) {
        if (!this.bNd) {
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
            this.mDialog.setCanceledOnTouchOutside(this.bNe);
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnKeyListener(this.mOnKeyListener);
            if (this.bNa != null) {
                this.mDialog.setOnCancelListener(this.bNa);
            }
            if (this.bNb != null) {
                this.mDialog.setOnDismissListener(this.bNb);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            if (this.mDialog.getWindow().getDecorView().getParent() != null) {
                Window window = this.mDialog.getWindow();
                if (this.bMO == -1) {
                    this.bMO = 17;
                }
                window.setGravity(this.bMO);
                window.setBackgroundDrawableResource(R.drawable.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics v = com.baidu.adp.lib.util.l.v(this.mActivity);
                if (v != null) {
                    int agH = agH();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = v.heightPixels - (agH * 2);
                    } else {
                        attributes.width = v.widthPixels - (agH * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bd.a(this.mRootView, false, new bd.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.bd.a
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

    public int agH() {
        int i = R.dimen.tbds0;
        if (this.bMW == 0) {
            i = R.dimen.ds90;
        } else if (this.bMW == 1) {
            i = R.dimen.ds40;
        } else if (this.bMW == 2) {
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
        if (this.bNg != null) {
            this.bNg.setClickable(z);
        }
    }

    public void dU(boolean z) {
        if (this.bNh != null) {
            this.bNh.setClickable(z);
        }
    }

    public a agI() {
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
    public class View$OnClickListenerC0236a implements View.OnClickListener {
        private final a TX;
        private final b bNn;

        public View$OnClickListenerC0236a(a aVar, b bVar) {
            this.TX = aVar;
            this.bNn = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bNn != null) {
                this.bNn.onClick(this.TX);
            }
        }
    }

    public ViewGroup agJ() {
        return this.bNc;
    }

    public void ab(Object obj) {
        this.bNf = obj;
    }

    public Object agK() {
        return this.bNf;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void dV(boolean z) {
        this.bMP = z;
    }

    public void dW(boolean z) {
        this.bMQ = z;
    }

    public void dX(boolean z) {
        this.bMR = z;
    }

    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.bNd = false;
    }
}
