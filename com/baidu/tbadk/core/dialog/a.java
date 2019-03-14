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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private b bEA;
    private DialogInterface.OnCancelListener bEB;
    private DialogInterface.OnDismissListener bEC;
    private AlertDialog bED;
    private ViewGroup bEE;
    private Object bEH;
    private TextView bEI;
    private TextView bEJ;
    private View bEK;
    private View bEL;
    private Button bEM;
    private String bEu;
    private String bEv;
    private b bEy;
    private b bEz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int bEq = -1;
    private boolean bEr = true;
    private boolean bEs = false;
    private boolean bEt = false;
    private int bEw = -1;
    private int bEx = 0;
    private boolean bEF = false;
    private boolean bEG = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a lx(String str) {
        this.mTitle = str;
        return this;
    }

    public a gC(int i) {
        lx(this.mActivity.getResources().getString(i));
        return this;
    }

    public a ly(String str) {
        this.mMessage = str;
        return this;
    }

    public a az(View view) {
        this.mContentView = view;
        return this;
    }

    public a b(DialogInterface.OnCancelListener onCancelListener) {
        this.bEB = onCancelListener;
        return this;
    }

    public a b(DialogInterface.OnDismissListener onDismissListener) {
        this.bEC = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.bEu = str;
        this.bEy = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.bEv = str;
        this.bEz = bVar;
        return this;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.bEA = bVar;
        }
        return this;
    }

    public a gD(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.bEu = this.mActivity.getResources().getString(i);
            this.bEy = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.bEv = this.mActivity.getResources().getString(i);
            this.bEz = bVar;
        }
        return this;
    }

    public a dq(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a dr(boolean z) {
        this.bEG = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.bEE = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a gE(int i) {
        if (isAutoNight()) {
            this.bEw = al.getColor(i);
        } else {
            this.bEw = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a gF(int i) {
        this.bEx = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.bEF) {
            this.bEF = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.bEI = (TextView) this.mRootView.findViewById(d.g.yes);
            this.bEJ = (TextView) this.mRootView.findViewById(d.g.no);
            this.bEK = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.bEL = this.mRootView.findViewById(d.g.bdDialog_divider_line);
            this.bEM = (Button) this.mRootView.findViewById(d.g.close_btn);
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
                View aaX = aaX();
                if (aaX != null) {
                    linearLayout.removeAllViews();
                    if (aaX.getParent() != null) {
                        if (aaX.getParent() instanceof ViewGroup) {
                            ((ViewGroup) aaX.getParent()).removeView(aaX);
                            linearLayout.addView(aaX);
                        }
                    } else {
                        linearLayout.addView(aaX);
                    }
                }
            }
            c(eVar);
            if (this.bEA != null) {
                this.bEM.setVisibility(0);
                this.bEM.setOnClickListener(new View$OnClickListenerC0224a(this, this.bEA));
                al.e(this.bEM, d.f.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.bEw != -1) {
                if (this.bEI != null) {
                    this.bEI.setTextColor(this.bEw);
                }
                if (this.bEJ != null) {
                    this.bEJ.setTextColor(this.bEw);
                }
            }
            if (TextUtils.isEmpty(this.bEu) || this.bEI == null) {
                z = false;
            } else {
                this.bEI.setText(this.bEu);
                this.bEI.setTag(this.bEH);
                if (this.bEy != null) {
                    this.bEI.setOnClickListener(new View$OnClickListenerC0224a(this, this.bEy));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.bEv) || this.bEJ == null) {
                z2 = false;
            } else {
                this.bEJ.setText(this.bEv);
                if (this.bEz != null) {
                    this.bEJ.setOnClickListener(new View$OnClickListenerC0224a(this, this.bEz));
                }
            }
            n(z, z2);
        }
        return this;
    }

    public View aaX() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.bEs) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.bEt) {
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
            if (this.bEr) {
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
            this.mRootView.setBackgroundResource(d.f.transparent_bg);
        }
        if (this.bEE != null && this.bEx == 2) {
            this.bEE.setBackgroundResource(d.f.dialog_private_background);
        } else {
            al.e(this.bEE, d.f.dialog_background, skinType);
        }
    }

    private void n(boolean z, boolean z2) {
        if (z && z2) {
            if (this.bEK != null) {
                this.bEK.setVisibility(0);
            }
            if (this.bEL != null) {
                this.bEL.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.bEK != null) {
            this.bEK.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.bEI != null && this.bEJ != null && this.bEK != null && this.bEL != null) {
                this.bEI.setVisibility(8);
                this.bEJ.setVisibility(8);
                this.bEK.setVisibility(8);
                this.bEL.setVisibility(8);
            }
        } else if (z) {
            al.e(this.bEI, d.f.dialog_single_button_bg_selector, skinType);
            if (this.bEJ != null && this.bEK != null && this.bEL != null) {
                this.bEL.setVisibility(0);
                this.bEI.setVisibility(0);
                this.bEJ.setVisibility(8);
            }
        } else if (z2) {
            al.e(this.bEJ, d.f.dialog_single_button_bg_selector, skinType);
            if (this.bEI != null && this.bEK != null && this.bEL != null) {
                this.bEL.setVisibility(0);
                this.bEJ.setVisibility(0);
                this.bEI.setVisibility(8);
            }
        } else if (this.bEI != null && this.bEJ != null && this.bEL != null) {
            this.bEL.setVisibility(8);
            this.bEI.setVisibility(8);
            this.bEJ.setVisibility(8);
        }
    }

    private a ds(boolean z) {
        if (!this.bEF) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.bED != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.bED, this.mActivity);
            } else {
                this.bED.show();
            }
        } else {
            this.bED = new AlertDialog.Builder(this.mActivity).create();
            this.bED.setCanceledOnTouchOutside(this.bEG);
            this.bED.setCancelable(this.mCancelable);
            this.bED.setOnKeyListener(this.mOnKeyListener);
            if (this.bEB != null) {
                this.bED.setOnCancelListener(this.bEB);
            }
            if (this.bEC != null) {
                this.bED.setOnDismissListener(this.bEC);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.bED, this.mActivity);
            } else {
                this.bED.show();
            }
            if (this.bED.getWindow().getDecorView().getParent() != null) {
                Window window = this.bED.getWindow();
                if (this.bEq == -1) {
                    this.bEq = 17;
                }
                window.setGravity(this.bEq);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics s = l.s(this.mActivity);
                if (s != null) {
                    int aaY = aaY();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = s.heightPixels - (aaY * 2);
                    } else {
                        attributes.width = s.widthPixels - (aaY * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bc.a(this.mRootView, false, new bc.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.bc.a
                    public boolean aA(View view) {
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

    public int aaY() {
        int i = d.e.tbds0;
        if (this.bEx == 0) {
            i = d.e.ds90;
        } else if (this.bEx == 1) {
            i = d.e.ds40;
        } else if (this.bEx == 2) {
            i = d.e.tbds44;
        }
        return l.h(this.mActivity, i);
    }

    public boolean isShowing() {
        if (this.bED != null) {
            return this.bED.isShowing();
        }
        return false;
    }

    public void dt(boolean z) {
        if (this.bEI != null) {
            this.bEI.setClickable(z);
        }
    }

    public void du(boolean z) {
        if (this.bEJ != null) {
            this.bEJ.setClickable(z);
        }
    }

    public a aaZ() {
        return ds(true);
    }

    public void hide() {
        if (this.bED != null) {
            this.bED.hide();
        }
    }

    public void dismiss() {
        if (this.bED != null) {
            com.baidu.adp.lib.g.g.b(this.bED, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0224a implements View.OnClickListener {
        private final a VQ;
        private final b bEP;

        public View$OnClickListenerC0224a(a aVar, b bVar) {
            this.VQ = aVar;
            this.bEP = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bEP != null) {
                this.bEP.onClick(this.VQ);
            }
        }
    }

    public ViewGroup aba() {
        return this.bEE;
    }

    public void ab(Object obj) {
        this.bEH = obj;
    }

    public Object abb() {
        return this.bEH;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void dv(boolean z) {
        this.bEr = z;
    }

    public void dw(boolean z) {
        this.bEs = z;
    }

    public void dx(boolean z) {
        this.bEt = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.bEF = false;
    }
}
