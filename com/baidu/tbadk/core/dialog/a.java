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
    private String arX;
    private String arY;
    private b asb;
    private b asc;
    private DialogInterface.OnCancelListener asd;
    private DialogInterface.OnDismissListener ase;
    private AlertDialog asf;
    private ViewGroup asg;
    private Object asj;
    private TextView ask;
    private TextView asl;
    private View asm;
    private View asn;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int arT = -1;
    private boolean arU = true;
    private boolean arV = false;
    private boolean arW = false;
    private int arZ = -1;
    private int asa = 0;
    private boolean ash = false;
    private boolean asi = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a ei(String str) {
        this.mTitle = str;
        return this;
    }

    public a cy(int i) {
        ei(this.mActivity.getResources().getString(i));
        return this;
    }

    public a ej(String str) {
        this.mMessage = str;
        return this;
    }

    public a G(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.asd = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.ase = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.arX = str;
        this.asb = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.arY = str;
        this.asc = bVar;
        return this;
    }

    public a cz(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.arX = this.mActivity.getResources().getString(i);
            this.asb = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.arY = this.mActivity.getResources().getString(i);
            this.asc = bVar;
        }
        return this;
    }

    public a aO(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a aP(boolean z) {
        this.asi = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_bdalert, (ViewGroup) null);
        this.asg = (ViewGroup) this.mRootView.findViewById(e.g.real_view);
    }

    public a cA(int i) {
        if (isAutoNight()) {
            this.arZ = al.getColor(i);
        } else {
            this.arZ = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cB(int i) {
        this.asa = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.ash) {
            this.ash = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(e.g.dialog_content);
            this.ask = (TextView) this.mRootView.findViewById(e.g.yes);
            this.asl = (TextView) this.mRootView.findViewById(e.g.no);
            this.asm = this.mRootView.findViewById(e.g.divider_yes_no_button);
            this.asn = this.mRootView.findViewById(e.g.bdDialog_divider_line);
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
                View Ar = Ar();
                if (Ar != null) {
                    linearLayout.removeAllViews();
                    if (Ar.getParent() != null) {
                        if (Ar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) Ar.getParent()).removeView(Ar);
                            linearLayout.addView(Ar);
                        }
                    } else {
                        linearLayout.addView(Ar);
                    }
                }
            }
            c(eVar);
            if (this.arZ != -1) {
                if (this.ask != null) {
                    this.ask.setTextColor(this.arZ);
                }
                if (this.asl != null) {
                    this.asl.setTextColor(this.arZ);
                }
            }
            if (TextUtils.isEmpty(this.arX) || this.ask == null) {
                z = false;
            } else {
                this.ask.setText(this.arX);
                this.ask.setTag(this.asj);
                if (this.asb != null) {
                    this.ask.setOnClickListener(new View$OnClickListenerC0123a(this, this.asb));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.arY) || this.asl == null) {
                z2 = false;
            } else {
                this.asl.setText(this.arY);
                if (this.asc != null) {
                    this.asl.setOnClickListener(new View$OnClickListenerC0123a(this, this.asc));
                }
            }
            j(z, z2);
        }
        return this;
    }

    public View Ar() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(e.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(e.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(e.g.message_view);
                if (this.arV) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.arW) {
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
            if (this.arU) {
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
            if (this.asm != null) {
                this.asm.setVisibility(0);
            }
            if (this.asn != null) {
                this.asn.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.asm != null) {
            this.asm.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.ask != null && this.asl != null && this.asm != null && this.asn != null) {
                this.ask.setVisibility(8);
                this.asl.setVisibility(8);
                this.asm.setVisibility(8);
                this.asn.setVisibility(8);
            }
        } else if (z) {
            al.d(this.ask, e.f.dialog_single_button_bg_selector, skinType);
            if (this.asl != null && this.asm != null && this.asn != null) {
                this.asn.setVisibility(0);
                this.ask.setVisibility(0);
                this.asl.setVisibility(8);
            }
        } else if (z2) {
            al.d(this.asl, e.f.dialog_single_button_bg_selector, skinType);
            if (this.ask != null && this.asm != null && this.asn != null) {
                this.asn.setVisibility(0);
                this.asl.setVisibility(0);
                this.ask.setVisibility(8);
            }
        } else if (this.ask != null && this.asl != null && this.asn != null) {
            this.asn.setVisibility(8);
            this.ask.setVisibility(8);
            this.asl.setVisibility(8);
        }
    }

    public a As() {
        return aQ(false);
    }

    private a aQ(boolean z) {
        if (!this.ash) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.asf != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.asf, this.mActivity);
            } else {
                this.asf.show();
            }
        } else {
            this.asf = new AlertDialog.Builder(this.mActivity).create();
            this.asf.setCanceledOnTouchOutside(this.asi);
            this.asf.setCancelable(this.mCancelable);
            this.asf.setOnKeyListener(this.mOnKeyListener);
            if (this.asd != null) {
                this.asf.setOnCancelListener(this.asd);
            }
            if (this.ase != null) {
                this.asf.setOnDismissListener(this.ase);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.asf, this.mActivity);
            } else {
                this.asf.show();
            }
            if (this.asf.getWindow().getDecorView().getParent() != null) {
                Window window = this.asf.getWindow();
                if (this.arT == -1) {
                    this.arT = 17;
                }
                window.setGravity(this.arT);
                window.setBackgroundDrawableResource(e.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics s = l.s(this.mActivity);
                if (s != null) {
                    int At = At();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = s.heightPixels - (At * 2);
                    } else {
                        attributes.width = s.widthPixels - (At * 2);
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

    public int At() {
        return this.asa == 1 ? l.h(this.mActivity, e.C0175e.ds40) : l.h(this.mActivity, e.C0175e.ds90);
    }

    public boolean isShowing() {
        if (this.asf != null) {
            return this.asf.isShowing();
        }
        return false;
    }

    public void aR(boolean z) {
        if (this.ask != null) {
            this.ask.setClickable(z);
        }
    }

    public void aS(boolean z) {
        if (this.asl != null) {
            this.asl.setClickable(z);
        }
    }

    public a Au() {
        return aQ(true);
    }

    public void hide() {
        if (this.asf != null) {
            this.asf.hide();
        }
    }

    public void dismiss() {
        if (this.asf != null) {
            com.baidu.adp.lib.g.g.b(this.asf, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0123a implements View.OnClickListener {
        private final a Tb;
        private final b asq;

        public View$OnClickListenerC0123a(a aVar, b bVar) {
            this.Tb = aVar;
            this.asq = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.asq != null) {
                this.asq.onClick(this.Tb);
            }
        }
    }

    public ViewGroup Av() {
        return this.asg;
    }

    public void H(Object obj) {
        this.asj = obj;
    }

    public Object Aw() {
        return this.asj;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void aT(boolean z) {
        this.arU = z;
    }

    public void aU(boolean z) {
        this.arV = z;
    }

    public void aV(boolean z) {
        this.arW = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.ash = false;
    }
}
