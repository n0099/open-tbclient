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
import com.baidu.tieba.e;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private View awA;
    private View awB;
    private String awl;
    private String awm;
    private b awp;
    private b awq;
    private DialogInterface.OnCancelListener awr;
    private DialogInterface.OnDismissListener aws;
    private AlertDialog awt;
    private ViewGroup awu;
    private Object awx;
    private TextView awy;
    private TextView awz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int awh = -1;
    private boolean awi = true;
    private boolean awj = false;
    private boolean awk = false;
    private int awn = -1;
    private int awo = 0;
    private boolean awv = false;
    private boolean aww = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a eA(String str) {
        this.mTitle = str;
        return this;
    }

    public a da(int i) {
        eA(this.mActivity.getResources().getString(i));
        return this;
    }

    public a eB(String str) {
        this.mMessage = str;
        return this;
    }

    public a G(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.awr = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.aws = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.awl = str;
        this.awp = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.awm = str;
        this.awq = bVar;
        return this;
    }

    public a db(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.awl = this.mActivity.getResources().getString(i);
            this.awp = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.awm = this.mActivity.getResources().getString(i);
            this.awq = bVar;
        }
        return this;
    }

    public a bf(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a bg(boolean z) {
        this.aww = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_bdalert, (ViewGroup) null);
        this.awu = (ViewGroup) this.mRootView.findViewById(e.g.real_view);
    }

    public a dc(int i) {
        if (isAutoNight()) {
            this.awn = al.getColor(i);
        } else {
            this.awn = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a dd(int i) {
        this.awo = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.awv) {
            this.awv = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(e.g.dialog_content);
            this.awy = (TextView) this.mRootView.findViewById(e.g.yes);
            this.awz = (TextView) this.mRootView.findViewById(e.g.no);
            this.awA = this.mRootView.findViewById(e.g.divider_yes_no_button);
            this.awB = this.mRootView.findViewById(e.g.bdDialog_divider_line);
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
                View BC = BC();
                if (BC != null) {
                    linearLayout.removeAllViews();
                    if (BC.getParent() != null) {
                        if (BC.getParent() instanceof ViewGroup) {
                            ((ViewGroup) BC.getParent()).removeView(BC);
                            linearLayout.addView(BC);
                        }
                    } else {
                        linearLayout.addView(BC);
                    }
                }
            }
            c(eVar);
            if (this.awn != -1) {
                if (this.awy != null) {
                    this.awy.setTextColor(this.awn);
                }
                if (this.awz != null) {
                    this.awz.setTextColor(this.awn);
                }
            }
            if (TextUtils.isEmpty(this.awl) || this.awy == null) {
                z = false;
            } else {
                this.awy.setText(this.awl);
                this.awy.setTag(this.awx);
                if (this.awp != null) {
                    this.awy.setOnClickListener(new View$OnClickListenerC0157a(this, this.awp));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.awm) || this.awz == null) {
                z2 = false;
            } else {
                this.awz.setText(this.awm);
                if (this.awq != null) {
                    this.awz.setOnClickListener(new View$OnClickListenerC0157a(this, this.awq));
                }
            }
            j(z, z2);
        }
        return this;
    }

    public View BC() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(e.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(e.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(e.g.message_view);
                if (this.awj) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.awk) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(e.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(e.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            if (this.awi) {
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
            this.mRootView.setBackgroundResource(e.f.transparent_bg);
        }
    }

    private void j(boolean z, boolean z2) {
        if (z && z2) {
            if (this.awA != null) {
                this.awA.setVisibility(0);
            }
            if (this.awB != null) {
                this.awB.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.awA != null) {
            this.awA.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.awy != null && this.awz != null && this.awA != null && this.awB != null) {
                this.awy.setVisibility(8);
                this.awz.setVisibility(8);
                this.awA.setVisibility(8);
                this.awB.setVisibility(8);
            }
        } else if (z) {
            al.d(this.awy, e.f.dialog_single_button_bg_selector, skinType);
            if (this.awz != null && this.awA != null && this.awB != null) {
                this.awB.setVisibility(0);
                this.awy.setVisibility(0);
                this.awz.setVisibility(8);
            }
        } else if (z2) {
            al.d(this.awz, e.f.dialog_single_button_bg_selector, skinType);
            if (this.awy != null && this.awA != null && this.awB != null) {
                this.awB.setVisibility(0);
                this.awz.setVisibility(0);
                this.awy.setVisibility(8);
            }
        } else if (this.awy != null && this.awz != null && this.awB != null) {
            this.awB.setVisibility(8);
            this.awy.setVisibility(8);
            this.awz.setVisibility(8);
        }
    }

    public a BD() {
        return bh(false);
    }

    private a bh(boolean z) {
        if (!this.awv) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.awt != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.awt, this.mActivity);
            } else {
                this.awt.show();
            }
        } else {
            this.awt = new AlertDialog.Builder(this.mActivity).create();
            this.awt.setCanceledOnTouchOutside(this.aww);
            this.awt.setCancelable(this.mCancelable);
            this.awt.setOnKeyListener(this.mOnKeyListener);
            if (this.awr != null) {
                this.awt.setOnCancelListener(this.awr);
            }
            if (this.aws != null) {
                this.awt.setOnDismissListener(this.aws);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.awt, this.mActivity);
            } else {
                this.awt.show();
            }
            if (this.awt.getWindow().getDecorView().getParent() != null) {
                Window window = this.awt.getWindow();
                if (this.awh == -1) {
                    this.awh = 17;
                }
                window.setGravity(this.awh);
                window.setBackgroundDrawableResource(e.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics s = l.s(this.mActivity);
                if (s != null) {
                    int BE = BE();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = s.heightPixels - (BE * 2);
                    } else {
                        attributes.width = s.widthPixels - (BE * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ba.a(this.mRootView, false, new ba.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.ba.a
                    public boolean H(View view) {
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

    public int BE() {
        return this.awo == 1 ? l.h(this.mActivity, e.C0210e.ds40) : l.h(this.mActivity, e.C0210e.ds90);
    }

    public boolean isShowing() {
        if (this.awt != null) {
            return this.awt.isShowing();
        }
        return false;
    }

    public void bi(boolean z) {
        if (this.awy != null) {
            this.awy.setClickable(z);
        }
    }

    public void bj(boolean z) {
        if (this.awz != null) {
            this.awz.setClickable(z);
        }
    }

    public a BF() {
        return bh(true);
    }

    public void hide() {
        if (this.awt != null) {
            this.awt.hide();
        }
    }

    public void dismiss() {
        if (this.awt != null) {
            com.baidu.adp.lib.g.g.b(this.awt, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0157a implements View.OnClickListener {
        private final a Td;
        private final b awE;

        public View$OnClickListenerC0157a(a aVar, b bVar) {
            this.Td = aVar;
            this.awE = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.awE != null) {
                this.awE.onClick(this.Td);
            }
        }
    }

    public ViewGroup BG() {
        return this.awu;
    }

    public void H(Object obj) {
        this.awx = obj;
    }

    public Object BH() {
        return this.awx;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void bk(boolean z) {
        this.awi = z;
    }

    public void bl(boolean z) {
        this.awj = z;
    }

    public void bm(boolean z) {
        this.awk = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.awv = false;
    }
}
