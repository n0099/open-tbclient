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
    private DialogInterface.OnCancelListener acA;
    private DialogInterface.OnDismissListener acB;
    private AlertDialog acC;
    private ViewGroup acD;
    private Object acG;
    private TextView acH;
    private TextView acI;
    private View acJ;
    private View acK;
    private String acu;
    private String acv;
    private b acy;
    private b acz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int acq = -1;
    private boolean acr = true;
    private boolean acs = false;
    private boolean act = false;
    private int acw = -1;
    private int acx = 0;
    private boolean acE = false;
    private boolean acF = true;
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

    public a bZ(int i) {
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
        this.acA = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.acB = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.acu = str;
        this.acy = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.acv = str;
        this.acz = bVar;
        return this;
    }

    public a ca(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.acu = this.mActivity.getResources().getString(i);
            this.acy = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.acv = this.mActivity.getResources().getString(i);
            this.acz = bVar;
        }
        return this;
    }

    public a ar(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a as(boolean z) {
        this.acF = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_bdalert, (ViewGroup) null);
        this.acD = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a cb(int i) {
        if (isAutoNight()) {
            this.acw = ak.getColor(i);
        } else {
            this.acw = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cc(int i) {
        this.acx = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.acE) {
            this.acE = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.acH = (TextView) this.mRootView.findViewById(d.g.yes);
            this.acI = (TextView) this.mRootView.findViewById(d.g.no);
            this.acJ = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.acK = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
                View tz = tz();
                if (tz != null) {
                    linearLayout.removeAllViews();
                    if (tz.getParent() != null) {
                        if (tz.getParent() instanceof ViewGroup) {
                            ((ViewGroup) tz.getParent()).removeView(tz);
                            linearLayout.addView(tz);
                        }
                    } else {
                        linearLayout.addView(tz);
                    }
                }
            }
            c(eVar);
            if (this.acw != -1) {
                if (this.acH != null) {
                    this.acH.setTextColor(this.acw);
                }
                if (this.acI != null) {
                    this.acI.setTextColor(this.acw);
                }
            }
            if (TextUtils.isEmpty(this.acu) || this.acH == null) {
                z = false;
            } else {
                this.acH.setText(this.acu);
                this.acH.setTag(this.acG);
                if (this.acy != null) {
                    this.acH.setOnClickListener(new View$OnClickListenerC0085a(this, this.acy));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.acv) || this.acI == null) {
                z2 = false;
            } else {
                this.acI.setText(this.acv);
                if (this.acz != null) {
                    this.acI.setOnClickListener(new View$OnClickListenerC0085a(this, this.acz));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View tz() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.i.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.acs) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.act) {
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
            if (this.acr) {
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
            if (this.acJ != null) {
                this.acJ.setVisibility(0);
            }
            if (this.acK != null) {
                this.acK.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.acJ != null) {
            this.acJ.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.acH != null && this.acI != null && this.acJ != null && this.acK != null) {
                this.acH.setVisibility(8);
                this.acI.setVisibility(8);
                this.acJ.setVisibility(8);
                this.acK.setVisibility(8);
            }
        } else if (z) {
            ak.d(this.acH, d.f.dialog_single_button_bg_selector, skinType);
            if (this.acI != null && this.acJ != null && this.acK != null) {
                this.acK.setVisibility(0);
                this.acH.setVisibility(0);
                this.acI.setVisibility(8);
            }
        } else if (z2) {
            ak.d(this.acI, d.f.dialog_single_button_bg_selector, skinType);
            if (this.acH != null && this.acJ != null && this.acK != null) {
                this.acK.setVisibility(0);
                this.acI.setVisibility(0);
                this.acH.setVisibility(8);
            }
        } else if (this.acH != null && this.acI != null && this.acK != null) {
            this.acK.setVisibility(8);
            this.acH.setVisibility(8);
            this.acI.setVisibility(8);
        }
    }

    public a tA() {
        return at(false);
    }

    private a at(boolean z) {
        if (!this.acE) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.acC != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.acC, this.mActivity);
            } else {
                this.acC.show();
            }
        } else {
            this.acC = new AlertDialog.Builder(this.mActivity).create();
            this.acC.setCanceledOnTouchOutside(this.acF);
            this.acC.setCancelable(this.mCancelable);
            this.acC.setOnKeyListener(this.mOnKeyListener);
            if (this.acA != null) {
                this.acC.setOnCancelListener(this.acA);
            }
            if (this.acB != null) {
                this.acC.setOnDismissListener(this.acB);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.acC, this.mActivity);
            } else {
                this.acC.show();
            }
            if (this.acC.getWindow().getDecorView().getParent() != null) {
                Window window = this.acC.getWindow();
                if (this.acq == -1) {
                    this.acq = 17;
                }
                window.setGravity(this.acq);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics q = l.q(this.mActivity);
                if (q != null) {
                    int tB = tB();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = q.heightPixels - (tB * 2);
                    } else {
                        attributes.width = q.widthPixels - (tB * 2);
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

    public int tB() {
        return this.acx == 1 ? l.e(this.mActivity, d.e.ds40) : l.e(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.acC != null) {
            return this.acC.isShowing();
        }
        return false;
    }

    public void au(boolean z) {
        if (this.acH != null) {
            this.acH.setClickable(z);
        }
    }

    public void av(boolean z) {
        if (this.acI != null) {
            this.acI.setClickable(z);
        }
    }

    public a tC() {
        return at(true);
    }

    public void hide() {
        if (this.acC != null) {
            this.acC.hide();
        }
    }

    public void dismiss() {
        if (this.acC != null) {
            com.baidu.adp.lib.g.g.b(this.acC, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0085a implements View.OnClickListener {
        private final a JR;
        private final b acN;

        public View$OnClickListenerC0085a(a aVar, b bVar) {
            this.JR = aVar;
            this.acN = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.acN != null) {
                this.acN.onClick(this.JR);
            }
        }
    }

    public ViewGroup tD() {
        return this.acD;
    }

    public void z(Object obj) {
        this.acG = obj;
    }

    public Object tE() {
        return this.acG;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void aw(boolean z) {
        this.acr = z;
    }

    public void ax(boolean z) {
        this.acs = z;
    }

    public void ay(boolean z) {
        this.act = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.acE = false;
    }
}
