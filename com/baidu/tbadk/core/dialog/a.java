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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.f;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private b akA;
    private b akB;
    private DialogInterface.OnCancelListener akC;
    private DialogInterface.OnDismissListener akD;
    private AlertDialog akE;
    private ViewGroup akF;
    private Object akI;
    private TextView akJ;
    private TextView akK;
    private View akL;
    private View akM;
    private String akw;
    private String akx;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aks = -1;
    private boolean akt = true;
    private boolean aku = false;
    private boolean akv = false;
    private int aky = -1;
    private int akz = 0;
    private boolean akG = false;
    private boolean akH = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a dA(String str) {
        this.mTitle = str;
        return this;
    }

    public a ce(int i) {
        dA(this.mActivity.getResources().getString(i));
        return this;
    }

    public a dB(String str) {
        this.mMessage = str;
        return this;
    }

    public a w(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.akC = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.akD = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.akw = str;
        this.akA = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.akx = str;
        this.akB = bVar;
        return this;
    }

    public a cf(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.akw = this.mActivity.getResources().getString(i);
            this.akA = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.akx = this.mActivity.getResources().getString(i);
            this.akB = bVar;
        }
        return this;
    }

    public a av(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a aw(boolean z) {
        this.akH = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(f.h.dialog_bdalert, (ViewGroup) null);
        this.akF = (ViewGroup) this.mRootView.findViewById(f.g.real_view);
    }

    public a cg(int i) {
        if (isAutoNight()) {
            this.aky = am.getColor(i);
        } else {
            this.aky = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ch(int i) {
        this.akz = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.akG) {
            this.akG = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(f.g.dialog_content);
            this.akJ = (TextView) this.mRootView.findViewById(f.g.yes);
            this.akK = (TextView) this.mRootView.findViewById(f.g.no);
            this.akL = this.mRootView.findViewById(f.g.divider_yes_no_button);
            this.akM = this.mRootView.findViewById(f.g.bdDialog_divider_line);
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
                View xb = xb();
                if (xb != null) {
                    linearLayout.removeAllViews();
                    if (xb.getParent() != null) {
                        if (xb.getParent() instanceof ViewGroup) {
                            ((ViewGroup) xb.getParent()).removeView(xb);
                            linearLayout.addView(xb);
                        }
                    } else {
                        linearLayout.addView(xb);
                    }
                }
            }
            c(eVar);
            if (this.aky != -1) {
                if (this.akJ != null) {
                    this.akJ.setTextColor(this.aky);
                }
                if (this.akK != null) {
                    this.akK.setTextColor(this.aky);
                }
            }
            if (TextUtils.isEmpty(this.akw) || this.akJ == null) {
                z = false;
            } else {
                this.akJ.setText(this.akw);
                this.akJ.setTag(this.akI);
                if (this.akA != null) {
                    this.akJ.setOnClickListener(new View$OnClickListenerC0100a(this, this.akA));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.akx) || this.akK == null) {
                z2 = false;
            } else {
                this.akK.setText(this.akx);
                if (this.akB != null) {
                    this.akK.setOnClickListener(new View$OnClickListenerC0100a(this, this.akB));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View xb() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(f.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(f.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(f.g.message_view);
                if (this.aku) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.akv) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(f.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(f.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            if (this.akt) {
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
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mContentView);
            }
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundResource(f.C0146f.transparent_bg);
        }
    }

    private void h(boolean z, boolean z2) {
        if (z && z2) {
            if (this.akL != null) {
                this.akL.setVisibility(0);
            }
            if (this.akM != null) {
                this.akM.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.akL != null) {
            this.akL.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.akJ != null && this.akK != null && this.akL != null && this.akM != null) {
                this.akJ.setVisibility(8);
                this.akK.setVisibility(8);
                this.akL.setVisibility(8);
                this.akM.setVisibility(8);
            }
        } else if (z) {
            am.d(this.akJ, f.C0146f.dialog_single_button_bg_selector, skinType);
            if (this.akK != null && this.akL != null && this.akM != null) {
                this.akM.setVisibility(0);
                this.akJ.setVisibility(0);
                this.akK.setVisibility(8);
            }
        } else if (z2) {
            am.d(this.akK, f.C0146f.dialog_single_button_bg_selector, skinType);
            if (this.akJ != null && this.akL != null && this.akM != null) {
                this.akM.setVisibility(0);
                this.akK.setVisibility(0);
                this.akJ.setVisibility(8);
            }
        } else if (this.akJ != null && this.akK != null && this.akM != null) {
            this.akM.setVisibility(8);
            this.akJ.setVisibility(8);
            this.akK.setVisibility(8);
        }
    }

    public a xc() {
        return ax(false);
    }

    private a ax(boolean z) {
        if (!this.akG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.akE != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.akE, this.mActivity);
            } else {
                this.akE.show();
            }
        } else {
            this.akE = new AlertDialog.Builder(this.mActivity).create();
            this.akE.setCanceledOnTouchOutside(this.akH);
            this.akE.setCancelable(this.mCancelable);
            this.akE.setOnKeyListener(this.mOnKeyListener);
            if (this.akC != null) {
                this.akE.setOnCancelListener(this.akC);
            }
            if (this.akD != null) {
                this.akE.setOnDismissListener(this.akD);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.akE, this.mActivity);
            } else {
                this.akE.show();
            }
            if (this.akE.getWindow().getDecorView().getParent() != null) {
                Window window = this.akE.getWindow();
                if (this.aks == -1) {
                    this.aks = 17;
                }
                window.setGravity(this.aks);
                window.setBackgroundDrawableResource(f.C0146f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = l.o(this.mActivity);
                if (o != null) {
                    int xd = xd();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (xd * 2);
                    } else {
                        attributes.width = o.widthPixels - (xd * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bb.a(this.mRootView, false, new bb.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.bb.a
                    public boolean x(View view) {
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

    public int xd() {
        return this.akz == 1 ? l.f(this.mActivity, f.e.ds40) : l.f(this.mActivity, f.e.ds90);
    }

    public boolean isShowing() {
        if (this.akE != null) {
            return this.akE.isShowing();
        }
        return false;
    }

    public void ay(boolean z) {
        if (this.akJ != null) {
            this.akJ.setClickable(z);
        }
    }

    public void az(boolean z) {
        if (this.akK != null) {
            this.akK.setClickable(z);
        }
    }

    public a xe() {
        return ax(true);
    }

    public void hide() {
        if (this.akE != null) {
            this.akE.hide();
        }
    }

    public void dismiss() {
        if (this.akE != null) {
            com.baidu.adp.lib.g.g.b(this.akE, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0100a implements View.OnClickListener {
        private final a Qj;
        private final b akP;

        public View$OnClickListenerC0100a(a aVar, b bVar) {
            this.Qj = aVar;
            this.akP = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.akP != null) {
                this.akP.onClick(this.Qj);
            }
        }
    }

    public ViewGroup xf() {
        return this.akF;
    }

    public void C(Object obj) {
        this.akI = obj;
    }

    public Object xg() {
        return this.akI;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void aA(boolean z) {
        this.akt = z;
    }

    public void aB(boolean z) {
        this.aku = z;
    }

    public void aC(boolean z) {
        this.akv = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.akG = false;
    }
}
