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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private DialogInterface.OnDismissListener acA;
    private AlertDialog acB;
    private ViewGroup acC;
    private Object acF;
    private TextView acG;
    private TextView acH;
    private View acI;
    private View acJ;
    private String act;
    private String acu;
    private b acx;
    private b acy;
    private DialogInterface.OnCancelListener acz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int acp = -1;
    private boolean acq = true;
    private boolean acr = false;
    private boolean acs = false;
    private int acv = -1;
    private int acw = 0;
    private boolean acD = false;
    private boolean acE = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a db(String str) {
        this.mTitle = str;
        return this;
    }

    public a bY(int i) {
        db(this.mActivity.getResources().getString(i));
        return this;
    }

    public a dc(String str) {
        this.mMessage = str;
        return this;
    }

    public a w(View view2) {
        this.mContentView = view2;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.acz = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.acA = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.act = str;
        this.acx = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.acu = str;
        this.acy = bVar;
        return this;
    }

    public a bZ(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.act = this.mActivity.getResources().getString(i);
            this.acx = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.acu = this.mActivity.getResources().getString(i);
            this.acy = bVar;
        }
        return this;
    }

    public a ar(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a as(boolean z) {
        this.acE = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_bdalert, (ViewGroup) null);
        this.acC = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a ca(int i) {
        if (isAutoNight()) {
            this.acv = ak.getColor(i);
        } else {
            this.acv = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cb(int i) {
        this.acw = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.acD) {
            this.acD = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.acG = (TextView) this.mRootView.findViewById(d.g.yes);
            this.acH = (TextView) this.mRootView.findViewById(d.g.no);
            this.acI = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.acJ = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
                View tA = tA();
                if (tA != null) {
                    linearLayout.removeAllViews();
                    if (tA.getParent() != null) {
                        if (tA.getParent() instanceof ViewGroup) {
                            ((ViewGroup) tA.getParent()).removeView(tA);
                            linearLayout.addView(tA);
                        }
                    } else {
                        linearLayout.addView(tA);
                    }
                }
            }
            c(eVar);
            if (this.acv != -1) {
                if (this.acG != null) {
                    this.acG.setTextColor(this.acv);
                }
                if (this.acH != null) {
                    this.acH.setTextColor(this.acv);
                }
            }
            if (TextUtils.isEmpty(this.act) || this.acG == null) {
                z = false;
            } else {
                this.acG.setText(this.act);
                this.acG.setTag(this.acF);
                if (this.acx != null) {
                    this.acG.setOnClickListener(new View$OnClickListenerC0085a(this, this.acx));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.acu) || this.acH == null) {
                z2 = false;
            } else {
                this.acH.setText(this.acu);
                if (this.acy != null) {
                    this.acH.setOnClickListener(new View$OnClickListenerC0085a(this, this.acy));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View tA() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.i.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.acr) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.acs) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.i.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(d.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            if (this.acq) {
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
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().u(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().u(this.mContentView);
            }
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundResource(d.f.transparent_bg);
        }
    }

    private void h(boolean z, boolean z2) {
        if (z && z2) {
            if (this.acI != null) {
                this.acI.setVisibility(0);
            }
            if (this.acJ != null) {
                this.acJ.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.acI != null) {
            this.acI.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.acG != null && this.acH != null && this.acI != null && this.acJ != null) {
                this.acG.setVisibility(8);
                this.acH.setVisibility(8);
                this.acI.setVisibility(8);
                this.acJ.setVisibility(8);
            }
        } else if (z) {
            ak.d(this.acG, d.f.dialog_single_button_bg_selector, skinType);
            if (this.acH != null && this.acI != null && this.acJ != null) {
                this.acJ.setVisibility(0);
                this.acG.setVisibility(0);
                this.acH.setVisibility(8);
            }
        } else if (z2) {
            ak.d(this.acH, d.f.dialog_single_button_bg_selector, skinType);
            if (this.acG != null && this.acI != null && this.acJ != null) {
                this.acJ.setVisibility(0);
                this.acH.setVisibility(0);
                this.acG.setVisibility(8);
            }
        } else if (this.acG != null && this.acH != null && this.acJ != null) {
            this.acJ.setVisibility(8);
            this.acG.setVisibility(8);
            this.acH.setVisibility(8);
        }
    }

    public a tB() {
        return at(false);
    }

    private a at(boolean z) {
        if (!this.acD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.acB != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.acB, this.mActivity);
            } else {
                this.acB.show();
            }
        } else {
            this.acB = new AlertDialog.Builder(this.mActivity).create();
            this.acB.setCanceledOnTouchOutside(this.acE);
            this.acB.setCancelable(this.mCancelable);
            this.acB.setOnKeyListener(this.mOnKeyListener);
            if (this.acz != null) {
                this.acB.setOnCancelListener(this.acz);
            }
            if (this.acA != null) {
                this.acB.setOnDismissListener(this.acA);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.acB, this.mActivity);
            } else {
                this.acB.show();
            }
            if (this.acB.getWindow().getDecorView().getParent() != null) {
                Window window = this.acB.getWindow();
                if (this.acp == -1) {
                    this.acp = 17;
                }
                window.setGravity(this.acp);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics q = l.q(this.mActivity);
                if (q != null) {
                    int tC = tC();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = q.heightPixels - (tC * 2);
                    } else {
                        attributes.width = q.widthPixels - (tC * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                az.a(this.mRootView, false, new az.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.az.a
                    public boolean x(View view2) {
                        if (view2 instanceof EditText) {
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

    public int tC() {
        return this.acw == 1 ? l.e(this.mActivity, d.e.ds40) : l.e(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.acB != null) {
            return this.acB.isShowing();
        }
        return false;
    }

    public void au(boolean z) {
        if (this.acG != null) {
            this.acG.setClickable(z);
        }
    }

    public void av(boolean z) {
        if (this.acH != null) {
            this.acH.setClickable(z);
        }
    }

    public a tD() {
        return at(true);
    }

    public void hide() {
        if (this.acB != null) {
            this.acB.hide();
        }
    }

    public void dismiss() {
        if (this.acB != null) {
            com.baidu.adp.lib.g.g.b(this.acB, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0085a implements View.OnClickListener {
        private final a JV;
        private final b acM;

        public View$OnClickListenerC0085a(a aVar, b bVar) {
            this.JV = aVar;
            this.acM = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.acM != null) {
                this.acM.onClick(this.JV);
            }
        }
    }

    public ViewGroup tE() {
        return this.acC;
    }

    public void z(Object obj) {
        this.acF = obj;
    }

    public Object tF() {
        return this.acF;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void aw(boolean z) {
        this.acq = z;
    }

    public void ax(boolean z) {
        this.acr = z;
    }

    public void ay(boolean z) {
        this.acs = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.acD = false;
    }
}
