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
    private DialogInterface.OnDismissListener bEA;
    private AlertDialog bEB;
    private ViewGroup bEC;
    private Object bEF;
    private TextView bEG;
    private TextView bEH;
    private View bEI;
    private View bEJ;
    private Button bEK;
    private String bEs;
    private String bEt;
    private b bEw;
    private b bEx;
    private b bEy;
    private DialogInterface.OnCancelListener bEz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int bEo = -1;
    private boolean bEp = true;
    private boolean bEq = false;
    private boolean bEr = false;
    private int bEu = -1;
    private int bEv = 0;
    private boolean bED = false;
    private boolean bEE = true;
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
        this.bEz = onCancelListener;
        return this;
    }

    public a b(DialogInterface.OnDismissListener onDismissListener) {
        this.bEA = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.bEs = str;
        this.bEw = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.bEt = str;
        this.bEx = bVar;
        return this;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.bEy = bVar;
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
            this.bEs = this.mActivity.getResources().getString(i);
            this.bEw = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.bEt = this.mActivity.getResources().getString(i);
            this.bEx = bVar;
        }
        return this;
    }

    public a dq(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a dr(boolean z) {
        this.bEE = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.bEC = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a gE(int i) {
        if (isAutoNight()) {
            this.bEu = al.getColor(i);
        } else {
            this.bEu = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a gF(int i) {
        this.bEv = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.bED) {
            this.bED = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.bEG = (TextView) this.mRootView.findViewById(d.g.yes);
            this.bEH = (TextView) this.mRootView.findViewById(d.g.no);
            this.bEI = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.bEJ = this.mRootView.findViewById(d.g.bdDialog_divider_line);
            this.bEK = (Button) this.mRootView.findViewById(d.g.close_btn);
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
            if (this.bEy != null) {
                this.bEK.setVisibility(0);
                this.bEK.setOnClickListener(new View$OnClickListenerC0190a(this, this.bEy));
                al.e(this.bEK, d.f.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.bEu != -1) {
                if (this.bEG != null) {
                    this.bEG.setTextColor(this.bEu);
                }
                if (this.bEH != null) {
                    this.bEH.setTextColor(this.bEu);
                }
            }
            if (TextUtils.isEmpty(this.bEs) || this.bEG == null) {
                z = false;
            } else {
                this.bEG.setText(this.bEs);
                this.bEG.setTag(this.bEF);
                if (this.bEw != null) {
                    this.bEG.setOnClickListener(new View$OnClickListenerC0190a(this, this.bEw));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.bEt) || this.bEH == null) {
                z2 = false;
            } else {
                this.bEH.setText(this.bEt);
                if (this.bEx != null) {
                    this.bEH.setOnClickListener(new View$OnClickListenerC0190a(this, this.bEx));
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
                if (this.bEq) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.bEr) {
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
            if (this.bEp) {
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
        if (this.bEC != null && this.bEv == 2) {
            this.bEC.setBackgroundResource(d.f.dialog_private_background);
        } else {
            al.e(this.bEC, d.f.dialog_background, skinType);
        }
    }

    private void n(boolean z, boolean z2) {
        if (z && z2) {
            if (this.bEI != null) {
                this.bEI.setVisibility(0);
            }
            if (this.bEJ != null) {
                this.bEJ.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.bEI != null) {
            this.bEI.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.bEG != null && this.bEH != null && this.bEI != null && this.bEJ != null) {
                this.bEG.setVisibility(8);
                this.bEH.setVisibility(8);
                this.bEI.setVisibility(8);
                this.bEJ.setVisibility(8);
            }
        } else if (z) {
            al.e(this.bEG, d.f.dialog_single_button_bg_selector, skinType);
            if (this.bEH != null && this.bEI != null && this.bEJ != null) {
                this.bEJ.setVisibility(0);
                this.bEG.setVisibility(0);
                this.bEH.setVisibility(8);
            }
        } else if (z2) {
            al.e(this.bEH, d.f.dialog_single_button_bg_selector, skinType);
            if (this.bEG != null && this.bEI != null && this.bEJ != null) {
                this.bEJ.setVisibility(0);
                this.bEH.setVisibility(0);
                this.bEG.setVisibility(8);
            }
        } else if (this.bEG != null && this.bEH != null && this.bEJ != null) {
            this.bEJ.setVisibility(8);
            this.bEG.setVisibility(8);
            this.bEH.setVisibility(8);
        }
    }

    private a ds(boolean z) {
        if (!this.bED) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.bEB != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.bEB, this.mActivity);
            } else {
                this.bEB.show();
            }
        } else {
            this.bEB = new AlertDialog.Builder(this.mActivity).create();
            this.bEB.setCanceledOnTouchOutside(this.bEE);
            this.bEB.setCancelable(this.mCancelable);
            this.bEB.setOnKeyListener(this.mOnKeyListener);
            if (this.bEz != null) {
                this.bEB.setOnCancelListener(this.bEz);
            }
            if (this.bEA != null) {
                this.bEB.setOnDismissListener(this.bEA);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.bEB, this.mActivity);
            } else {
                this.bEB.show();
            }
            if (this.bEB.getWindow().getDecorView().getParent() != null) {
                Window window = this.bEB.getWindow();
                if (this.bEo == -1) {
                    this.bEo = 17;
                }
                window.setGravity(this.bEo);
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
        if (this.bEv == 0) {
            i = d.e.ds90;
        } else if (this.bEv == 1) {
            i = d.e.ds40;
        } else if (this.bEv == 2) {
            i = d.e.tbds44;
        }
        return l.h(this.mActivity, i);
    }

    public boolean isShowing() {
        if (this.bEB != null) {
            return this.bEB.isShowing();
        }
        return false;
    }

    public void dt(boolean z) {
        if (this.bEG != null) {
            this.bEG.setClickable(z);
        }
    }

    public void du(boolean z) {
        if (this.bEH != null) {
            this.bEH.setClickable(z);
        }
    }

    public a aaZ() {
        return ds(true);
    }

    public void hide() {
        if (this.bEB != null) {
            this.bEB.hide();
        }
    }

    public void dismiss() {
        if (this.bEB != null) {
            com.baidu.adp.lib.g.g.b(this.bEB, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0190a implements View.OnClickListener {
        private final a VP;
        private final b bEN;

        public View$OnClickListenerC0190a(a aVar, b bVar) {
            this.VP = aVar;
            this.bEN = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.bEN != null) {
                this.bEN.onClick(this.VP);
            }
        }
    }

    public ViewGroup aba() {
        return this.bEC;
    }

    public void ab(Object obj) {
        this.bEF = obj;
    }

    public Object abb() {
        return this.bEF;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void dv(boolean z) {
        this.bEp = z;
    }

    public void dw(boolean z) {
        this.bEq = z;
    }

    public void dx(boolean z) {
        this.bEr = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.bED = false;
    }
}
