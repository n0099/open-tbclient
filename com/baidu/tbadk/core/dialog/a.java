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
    private String aRg;
    private String aRh;
    private b aRk;
    private b aRl;
    private DialogInterface.OnCancelListener aRm;
    private AlertDialog aRn;
    private ViewGroup aRo;
    private Object aRr;
    private TextView aRs;
    private TextView aRt;
    private View aRu;
    private View aRv;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aRc = -1;
    private boolean aRd = true;
    private boolean aRe = false;
    private boolean aRf = false;
    private int aRi = -1;
    private int aRj = 0;
    private boolean aRp = false;
    private boolean aRq = true;
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
        this.aRm = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aRg = str;
        this.aRk = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aRh = str;
        this.aRl = bVar;
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
            this.aRg = this.mActivity.getResources().getString(i);
            this.aRk = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aRh = this.mActivity.getResources().getString(i);
            this.aRl = bVar;
        }
        return this;
    }

    public a aZ(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ba(boolean z) {
        this.aRq = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdalert, (ViewGroup) null);
        this.aRo = (ViewGroup) this.mRootView.findViewById(d.g.real_view);
    }

    public a fc(int i) {
        if (isAutoNight()) {
            this.aRi = aj.getColor(i);
        } else {
            this.aRi = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a fd(int i) {
        this.aRj = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aRp) {
            this.aRp = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.dialog_content);
            this.aRs = (TextView) this.mRootView.findViewById(d.g.yes);
            this.aRt = (TextView) this.mRootView.findViewById(d.g.no);
            this.aRu = this.mRootView.findViewById(d.g.divider_yes_no_button);
            this.aRv = this.mRootView.findViewById(d.g.bdDialog_divider_line);
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
            if (this.aRi != -1) {
                if (this.aRs != null) {
                    this.aRs.setTextColor(this.aRi);
                }
                if (this.aRt != null) {
                    this.aRt.setTextColor(this.aRi);
                }
            }
            if (TextUtils.isEmpty(this.aRg) || this.aRs == null) {
                z = false;
            } else {
                this.aRs.setText(this.aRg);
                this.aRs.setTag(this.aRr);
                if (this.aRk != null) {
                    this.aRs.setOnClickListener(new View$OnClickListenerC0095a(this, this.aRk));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aRh) || this.aRt == null) {
                z2 = false;
            } else {
                this.aRt.setText(this.aRh);
                if (this.aRl != null) {
                    this.aRt.setOnClickListener(new View$OnClickListenerC0095a(this, this.aRl));
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
                if (this.aRe) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aRf) {
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
            if (this.aRd) {
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
            if (this.aRu != null) {
                this.aRu.setVisibility(0);
            }
            if (this.aRv != null) {
                this.aRv.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aRu != null) {
            this.aRu.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aRs != null && this.aRt != null && this.aRu != null && this.aRv != null) {
                this.aRs.setVisibility(8);
                this.aRt.setVisibility(8);
                this.aRu.setVisibility(8);
                this.aRv.setVisibility(8);
            }
        } else if (z) {
            aj.f(this.aRs, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aRt != null && this.aRu != null && this.aRv != null) {
                this.aRv.setVisibility(0);
                this.aRs.setVisibility(0);
                this.aRt.setVisibility(8);
            }
        } else if (z2) {
            aj.f(this.aRt, d.f.dialog_single_button_bg_selector, skinType);
            if (this.aRs != null && this.aRu != null && this.aRv != null) {
                this.aRv.setVisibility(0);
                this.aRt.setVisibility(0);
                this.aRs.setVisibility(8);
            }
        } else if (this.aRs != null && this.aRt != null && this.aRv != null) {
            this.aRv.setVisibility(8);
            this.aRs.setVisibility(8);
            this.aRt.setVisibility(8);
        }
    }

    public a AS() {
        return bb(false);
    }

    private a bb(boolean z) {
        if (!this.aRp) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRn != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aRn, this.mActivity);
            } else {
                this.aRn.show();
            }
        } else {
            this.aRn = new AlertDialog.Builder(this.mActivity).create();
            this.aRn.setCanceledOnTouchOutside(this.aRq);
            this.aRn.setCancelable(this.mCancelable);
            this.aRn.setOnKeyListener(this.mOnKeyListener);
            if (this.aRm != null) {
                this.aRn.setOnCancelListener(this.aRm);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.aRn, this.mActivity);
            } else {
                this.aRn.show();
            }
            if (this.aRn.getWindow().getDecorView().getParent() != null) {
                Window window = this.aRn.getWindow();
                if (this.aRc == -1) {
                    this.aRc = 17;
                }
                window.setGravity(this.aRc);
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
        return this.aRj == 1 ? l.t(this.mActivity, d.e.ds40) : l.t(this.mActivity, d.e.ds90);
    }

    public boolean isShowing() {
        if (this.aRn != null) {
            return this.aRn.isShowing();
        }
        return false;
    }

    public void bc(boolean z) {
        if (this.aRs != null) {
            this.aRs.setClickable(z);
        }
    }

    public void bd(boolean z) {
        if (this.aRt != null) {
            this.aRt.setClickable(z);
        }
    }

    public a AU() {
        return bb(true);
    }

    public void hide() {
        if (this.aRn != null) {
            this.aRn.hide();
        }
    }

    public void dismiss() {
        if (this.aRn != null) {
            com.baidu.adp.lib.g.g.b(this.aRn, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0095a implements View.OnClickListener {
        private final b aRy;
        private final a axS;

        public View$OnClickListenerC0095a(a aVar, b bVar) {
            this.axS = aVar;
            this.aRy = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aRy != null) {
                this.aRy.onClick(this.axS);
            }
        }
    }

    public ViewGroup AV() {
        return this.aRo;
    }

    public void aE(Object obj) {
        this.aRr = obj;
    }

    public Object AW() {
        return this.aRr;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void be(boolean z) {
        this.aRd = z;
    }

    public void bf(boolean z) {
        this.aRe = z;
    }

    public void bg(boolean z) {
        this.aRf = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.aRp = false;
    }
}
