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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String aQX;
    private String aQY;
    private b aRb;
    private b aRc;
    private DialogInterface.OnCancelListener aRd;
    private AlertDialog aRe;
    private ViewGroup aRf;
    private Object aRi;
    private TextView aRj;
    private TextView aRk;
    private View aRl;
    private View aRm;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aQT = -1;
    private boolean aQU = true;
    private boolean aQV = false;
    private boolean aQW = false;
    private int aQZ = -1;
    private int aRa = 0;
    private boolean aRg = false;
    private boolean aRh = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a dj(String str) {
        this.mTitle = str;
        return this;
    }

    public a fa(int i) {
        dj(this.mActivity.getResources().getString(i));
        return this;
    }

    public a dk(String str) {
        this.mMessage = str;
        return this;
    }

    public a aO(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.aRd = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aQX = str;
        this.aRb = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aQY = str;
        this.aRc = bVar;
        return this;
    }

    public a fb(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aQX = this.mActivity.getResources().getString(i);
            this.aRb = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aQY = this.mActivity.getResources().getString(i);
            this.aRc = bVar;
        }
        return this;
    }

    public a aZ(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ba(boolean z) {
        this.aRh = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.aRf = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a fc(int i) {
        if (isAutoNight()) {
            this.aQZ = aj.getColor(i);
        } else {
            this.aQZ = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a fd(int i) {
        this.aRa = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aRg) {
            this.aRg = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.aRj = (TextView) this.mRootView.findViewById(d.g.yes);
            this.aRk = (TextView) this.mRootView.findViewById(d.g.no);
            this.aRl = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.aRm = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
                View AS = AS();
                if (AS != null) {
                    linearLayout.removeAllViews();
                    if (AS.getParent() != null) {
                        if (AS.getParent() instanceof ViewGroup) {
                            ((ViewGroup) AS.getParent()).removeView(AS);
                            linearLayout.addView(AS);
                        }
                    } else {
                        linearLayout.addView(AS);
                    }
                }
            }
            c(eVar);
            if (this.aQZ != -1) {
                if (this.aRj != null) {
                    this.aRj.setTextColor(this.aQZ);
                }
                if (this.aRk != null) {
                    this.aRk.setTextColor(this.aQZ);
                }
            }
            if (TextUtils.isEmpty(this.aQX) || this.aRj == null) {
                z = false;
            } else {
                this.aRj.setText(this.aQX);
                this.aRj.setTag(this.aRi);
                if (this.aRb != null) {
                    this.aRj.setOnClickListener(new View$OnClickListenerC0096a(this, this.aRb));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aQY) || this.aRk == null) {
                z2 = false;
            } else {
                this.aRk.setText(this.aQY);
                if (this.aRc != null) {
                    this.aRk.setOnClickListener(new View$OnClickListenerC0096a(this, this.aRc));
                }
            }
            k(z, z2);
        }
        return this;
    }

    public View AS() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.aQV) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aQW) {
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
            if (this.aQU) {
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
            ((TbPageContext) eVar).getLayoutMode().aQ(skinType == 1);
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
            if (this.aRl != null) {
                this.aRl.setVisibility(0);
            }
            if (this.aRm != null) {
                this.aRm.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aRl != null) {
            this.aRl.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aRj != null && this.aRk != null && this.aRl != null && this.aRm != null) {
                this.aRj.setVisibility(8);
                this.aRk.setVisibility(8);
                this.aRl.setVisibility(8);
                this.aRm.setVisibility(8);
            }
        } else if (z) {
            aj.f(this.aRj, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aRk != null && this.aRl != null && this.aRm != null) {
                this.aRm.setVisibility(0);
                this.aRj.setVisibility(0);
                this.aRk.setVisibility(8);
            }
        } else if (z2) {
            aj.f(this.aRk, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aRj != null && this.aRl != null && this.aRm != null) {
                this.aRm.setVisibility(0);
                this.aRk.setVisibility(0);
                this.aRj.setVisibility(8);
            }
        } else if (this.aRj != null && this.aRk != null && this.aRm != null) {
            this.aRm.setVisibility(8);
            this.aRj.setVisibility(8);
            this.aRk.setVisibility(8);
        }
    }

    public a AT() {
        return bb(false);
    }

    private a bb(boolean z) {
        if (!this.aRg) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRe != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aRe, this.mActivity);
            } else {
                this.aRe.show();
            }
        } else {
            this.aRe = new AlertDialog.Builder(this.mActivity).create();
            this.aRe.setCanceledOnTouchOutside(this.aRh);
            this.aRe.setCancelable(this.mCancelable);
            this.aRe.setOnKeyListener(this.mOnKeyListener);
            if (this.aRd != null) {
                this.aRe.setOnCancelListener(this.aRd);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aRe, this.mActivity);
            } else {
                this.aRe.show();
            }
            if (this.aRe.getWindow().getDecorView().getParent() != null) {
                Window window = this.aRe.getWindow();
                if (this.aQT == -1) {
                    this.aQT = 17;
                }
                window.setGravity(this.aQT);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics q = l.q(this.mActivity);
                if (q != null) {
                    int AU = AU();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = q.heightPixels - (AU * 2);
                    } else {
                        attributes.width = q.widthPixels - (AU * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ay.a(this.mRootView, false, new ay.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.ay.a
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

    public int AU() {
        return this.aRa == 1 ? l.t(this.mActivity, d.e.ds40) : l.t(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.aRe != null) {
            return this.aRe.isShowing();
        }
        return false;
    }

    public void bc(boolean z) {
        if (this.aRj != null) {
            this.aRj.setClickable(z);
        }
    }

    public void bd(boolean z) {
        if (this.aRk != null) {
            this.aRk.setClickable(z);
        }
    }

    public a AV() {
        return bb(true);
    }

    public void hide() {
        if (this.aRe != null) {
            this.aRe.hide();
        }
    }

    public void dismiss() {
        if (this.aRe != null) {
            com.baidu.adp.lib.g.g.b(this.aRe, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0096a implements View.OnClickListener {
        private final b aRp;
        private final a axK;

        public View$OnClickListenerC0096a(a aVar, b bVar) {
            this.axK = aVar;
            this.aRp = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aRp != null) {
                this.aRp.onClick(this.axK);
            }
        }
    }

    public ViewGroup AW() {
        return this.aRf;
    }

    public void aE(Object obj) {
        this.aRi = obj;
    }

    public Object AX() {
        return this.aRi;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void be(boolean z) {
        this.aQU = z;
    }

    public void bf(boolean z) {
        this.aQV = z;
    }

    public void bg(boolean z) {
        this.aQW = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.aRg = false;
    }
}
