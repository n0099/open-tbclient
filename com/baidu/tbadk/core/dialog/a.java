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
    private String aQV;
    private String aQW;
    private b aQZ;
    private b aRa;
    private DialogInterface.OnCancelListener aRb;
    private AlertDialog aRc;
    private ViewGroup aRd;
    private Object aRg;
    private TextView aRh;
    private TextView aRi;
    private View aRj;
    private View aRk;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aQR = -1;
    private boolean aQS = true;
    private boolean aQT = false;
    private boolean aQU = false;
    private int aQX = -1;
    private int aQY = 0;
    private boolean aRe = false;
    private boolean aRf = true;
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
        this.aRb = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aQV = str;
        this.aQZ = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aQW = str;
        this.aRa = bVar;
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
            this.aQV = this.mActivity.getResources().getString(i);
            this.aQZ = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aQW = this.mActivity.getResources().getString(i);
            this.aRa = bVar;
        }
        return this;
    }

    public a aZ(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ba(boolean z) {
        this.aRf = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.aRd = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a fc(int i) {
        if (isAutoNight()) {
            this.aQX = aj.getColor(i);
        } else {
            this.aQX = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a fd(int i) {
        this.aQY = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aRe) {
            this.aRe = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.aRh = (TextView) this.mRootView.findViewById(d.g.yes);
            this.aRi = (TextView) this.mRootView.findViewById(d.g.no);
            this.aRj = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.aRk = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
                View AR = AR();
                if (AR != null) {
                    linearLayout.removeAllViews();
                    if (AR.getParent() != null) {
                        if (AR.getParent() instanceof ViewGroup) {
                            ((ViewGroup) AR.getParent()).removeView(AR);
                            linearLayout.addView(AR);
                        }
                    } else {
                        linearLayout.addView(AR);
                    }
                }
            }
            c(eVar);
            if (this.aQX != -1) {
                if (this.aRh != null) {
                    this.aRh.setTextColor(this.aQX);
                }
                if (this.aRi != null) {
                    this.aRi.setTextColor(this.aQX);
                }
            }
            if (TextUtils.isEmpty(this.aQV) || this.aRh == null) {
                z = false;
            } else {
                this.aRh.setText(this.aQV);
                this.aRh.setTag(this.aRg);
                if (this.aQZ != null) {
                    this.aRh.setOnClickListener(new View$OnClickListenerC0096a(this, this.aQZ));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aQW) || this.aRi == null) {
                z2 = false;
            } else {
                this.aRi.setText(this.aQW);
                if (this.aRa != null) {
                    this.aRi.setOnClickListener(new View$OnClickListenerC0096a(this, this.aRa));
                }
            }
            k(z, z2);
        }
        return this;
    }

    public View AR() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.g.message_view);
                if (this.aQT) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aQU) {
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
            if (this.aQS) {
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
            if (this.aRj != null) {
                this.aRj.setVisibility(0);
            }
            if (this.aRk != null) {
                this.aRk.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aRj != null) {
            this.aRj.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aRh != null && this.aRi != null && this.aRj != null && this.aRk != null) {
                this.aRh.setVisibility(8);
                this.aRi.setVisibility(8);
                this.aRj.setVisibility(8);
                this.aRk.setVisibility(8);
            }
        } else if (z) {
            aj.f(this.aRh, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aRi != null && this.aRj != null && this.aRk != null) {
                this.aRk.setVisibility(0);
                this.aRh.setVisibility(0);
                this.aRi.setVisibility(8);
            }
        } else if (z2) {
            aj.f(this.aRi, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aRh != null && this.aRj != null && this.aRk != null) {
                this.aRk.setVisibility(0);
                this.aRi.setVisibility(0);
                this.aRh.setVisibility(8);
            }
        } else if (this.aRh != null && this.aRi != null && this.aRk != null) {
            this.aRk.setVisibility(8);
            this.aRh.setVisibility(8);
            this.aRi.setVisibility(8);
        }
    }

    public a AS() {
        return bb(false);
    }

    private a bb(boolean z) {
        if (!this.aRe) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRc != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aRc, this.mActivity);
            } else {
                this.aRc.show();
            }
        } else {
            this.aRc = new AlertDialog.Builder(this.mActivity).create();
            this.aRc.setCanceledOnTouchOutside(this.aRf);
            this.aRc.setCancelable(this.mCancelable);
            this.aRc.setOnKeyListener(this.mOnKeyListener);
            if (this.aRb != null) {
                this.aRc.setOnCancelListener(this.aRb);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aRc, this.mActivity);
            } else {
                this.aRc.show();
            }
            if (this.aRc.getWindow().getDecorView().getParent() != null) {
                Window window = this.aRc.getWindow();
                if (this.aQR == -1) {
                    this.aQR = 17;
                }
                window.setGravity(this.aQR);
                window.setBackgroundDrawableResource(d.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics q = l.q(this.mActivity);
                if (q != null) {
                    int AT = AT();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = q.heightPixels - (AT * 2);
                    } else {
                        attributes.width = q.widthPixels - (AT * 2);
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

    public int AT() {
        return this.aQY == 1 ? l.t(this.mActivity, d.e.ds40) : l.t(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.aRc != null) {
            return this.aRc.isShowing();
        }
        return false;
    }

    public void bc(boolean z) {
        if (this.aRh != null) {
            this.aRh.setClickable(z);
        }
    }

    public void bd(boolean z) {
        if (this.aRi != null) {
            this.aRi.setClickable(z);
        }
    }

    public a AU() {
        return bb(true);
    }

    public void hide() {
        if (this.aRc != null) {
            this.aRc.hide();
        }
    }

    public void dismiss() {
        if (this.aRc != null) {
            com.baidu.adp.lib.g.g.b(this.aRc, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0096a implements View.OnClickListener {
        private final b aRn;
        private final a axJ;

        public View$OnClickListenerC0096a(a aVar, b bVar) {
            this.axJ = aVar;
            this.aRn = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aRn != null) {
                this.aRn.onClick(this.axJ);
            }
        }
    }

    public ViewGroup AV() {
        return this.aRd;
    }

    public void aE(Object obj) {
        this.aRg = obj;
    }

    public Object AW() {
        return this.aRg;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void be(boolean z) {
        this.aQS = z;
    }

    public void bf(boolean z) {
        this.aQT = z;
    }

    public void bg(boolean z) {
        this.aQU = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.aRe = false;
    }
}
