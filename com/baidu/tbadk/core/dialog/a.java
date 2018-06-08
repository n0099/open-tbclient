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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private b akC;
    private b akD;
    private DialogInterface.OnCancelListener akE;
    private DialogInterface.OnDismissListener akF;
    private AlertDialog akG;
    private ViewGroup akH;
    private Object akK;
    private TextView akL;
    private TextView akM;
    private View akN;
    private View akO;
    private String aky;
    private String akz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aku = -1;
    private boolean akv = true;
    private boolean akw = false;
    private boolean akx = false;
    private int akA = -1;
    private int akB = 0;
    private boolean akI = false;
    private boolean akJ = true;
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

    public a cb(int i) {
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
        this.akE = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.akF = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aky = str;
        this.akC = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.akz = str;
        this.akD = bVar;
        return this;
    }

    public a cc(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aky = this.mActivity.getResources().getString(i);
            this.akC = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.akz = this.mActivity.getResources().getString(i);
            this.akD = bVar;
        }
        return this;
    }

    public a au(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a av(boolean z) {
        this.akJ = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_bdalert, (ViewGroup) null);
        this.akH = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a cd(int i) {
        if (isAutoNight()) {
            this.akA = al.getColor(i);
        } else {
            this.akA = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ce(int i) {
        this.akB = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.akI) {
            this.akI = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.akL = (TextView) this.mRootView.findViewById(d.g.yes);
            this.akM = (TextView) this.mRootView.findViewById(d.g.no);
            this.akN = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.akO = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
                View wX = wX();
                if (wX != null) {
                    linearLayout.removeAllViews();
                    if (wX.getParent() != null) {
                        if (wX.getParent() instanceof ViewGroup) {
                            ((ViewGroup) wX.getParent()).removeView(wX);
                            linearLayout.addView(wX);
                        }
                    } else {
                        linearLayout.addView(wX);
                    }
                }
            }
            c(eVar);
            if (this.akA != -1) {
                if (this.akL != null) {
                    this.akL.setTextColor(this.akA);
                }
                if (this.akM != null) {
                    this.akM.setTextColor(this.akA);
                }
            }
            if (TextUtils.isEmpty(this.aky) || this.akL == null) {
                z = false;
            } else {
                this.akL.setText(this.aky);
                this.akL.setTag(this.akK);
                if (this.akC != null) {
                    this.akL.setOnClickListener(new View$OnClickListenerC0102a(this, this.akC));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.akz) || this.akM == null) {
                z2 = false;
            } else {
                this.akM.setText(this.akz);
                if (this.akD != null) {
                    this.akM.setOnClickListener(new View$OnClickListenerC0102a(this, this.akD));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View wX() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.i.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.akw) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.akx) {
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
            if (this.akv) {
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
            this.mRootView.setBackgroundResource(d.f.transparent_bg);
        }
    }

    private void h(boolean z, boolean z2) {
        if (z && z2) {
            if (this.akN != null) {
                this.akN.setVisibility(0);
            }
            if (this.akO != null) {
                this.akO.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.akN != null) {
            this.akN.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.akL != null && this.akM != null && this.akN != null && this.akO != null) {
                this.akL.setVisibility(8);
                this.akM.setVisibility(8);
                this.akN.setVisibility(8);
                this.akO.setVisibility(8);
            }
        } else if (z) {
            al.d(this.akL, d.f.dialog_single_button_bg_selector, skinType);
            if (this.akM != null && this.akN != null && this.akO != null) {
                this.akO.setVisibility(0);
                this.akL.setVisibility(0);
                this.akM.setVisibility(8);
            }
        } else if (z2) {
            al.d(this.akM, d.f.dialog_single_button_bg_selector, skinType);
            if (this.akL != null && this.akN != null && this.akO != null) {
                this.akO.setVisibility(0);
                this.akM.setVisibility(0);
                this.akL.setVisibility(8);
            }
        } else if (this.akL != null && this.akM != null && this.akO != null) {
            this.akO.setVisibility(8);
            this.akL.setVisibility(8);
            this.akM.setVisibility(8);
        }
    }

    public a wY() {
        return aw(false);
    }

    private a aw(boolean z) {
        if (!this.akI) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.akG != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.akG, this.mActivity);
            } else {
                this.akG.show();
            }
        } else {
            this.akG = new AlertDialog.Builder(this.mActivity).create();
            this.akG.setCanceledOnTouchOutside(this.akJ);
            this.akG.setCancelable(this.mCancelable);
            this.akG.setOnKeyListener(this.mOnKeyListener);
            if (this.akE != null) {
                this.akG.setOnCancelListener(this.akE);
            }
            if (this.akF != null) {
                this.akG.setOnDismissListener(this.akF);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.akG, this.mActivity);
            } else {
                this.akG.show();
            }
            if (this.akG.getWindow().getDecorView().getParent() != null) {
                Window window = this.akG.getWindow();
                if (this.aku == -1) {
                    this.aku = 17;
                }
                window.setGravity(this.aku);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics p = l.p(this.mActivity);
                if (p != null) {
                    int wZ = wZ();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = p.heightPixels - (wZ * 2);
                    } else {
                        attributes.width = p.widthPixels - (wZ * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ba.a(this.mRootView, false, new ba.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.ba.a
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

    public int wZ() {
        return this.akB == 1 ? l.e(this.mActivity, d.e.ds40) : l.e(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.akG != null) {
            return this.akG.isShowing();
        }
        return false;
    }

    public void ax(boolean z) {
        if (this.akL != null) {
            this.akL.setClickable(z);
        }
    }

    public void ay(boolean z) {
        if (this.akM != null) {
            this.akM.setClickable(z);
        }
    }

    public a xa() {
        return aw(true);
    }

    public void hide() {
        if (this.akG != null) {
            this.akG.hide();
        }
    }

    public void dismiss() {
        if (this.akG != null) {
            com.baidu.adp.lib.g.g.b(this.akG, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0102a implements View.OnClickListener {
        private final a Qk;
        private final b akR;

        public View$OnClickListenerC0102a(a aVar, b bVar) {
            this.Qk = aVar;
            this.akR = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.akR != null) {
                this.akR.onClick(this.Qk);
            }
        }
    }

    public ViewGroup xb() {
        return this.akH;
    }

    public void C(Object obj) {
        this.akK = obj;
    }

    public Object xc() {
        return this.akK;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void az(boolean z) {
        this.akv = z;
    }

    public void aA(boolean z) {
        this.akw = z;
    }

    public void aB(boolean z) {
        this.akx = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.akI = false;
    }
}
