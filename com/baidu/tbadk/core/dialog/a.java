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
    private String asK;
    private String asL;
    private b asO;
    private b asP;
    private DialogInterface.OnCancelListener asQ;
    private DialogInterface.OnDismissListener asR;
    private AlertDialog asS;
    private ViewGroup asT;
    private Object asW;
    private TextView asX;
    private TextView asY;
    private View asZ;
    private View ata;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private int asG = -1;
    private boolean asH = true;
    private boolean asI = false;
    private boolean asJ = false;
    private int asM = -1;
    private int asN = 0;
    private boolean asU = false;
    private boolean asV = true;
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

    public a cM(int i) {
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
        this.asQ = onCancelListener;
        return this;
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.asR = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.asK = str;
        this.asO = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.asL = str;
        this.asP = bVar;
        return this;
    }

    public a cN(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.asK = this.mActivity.getResources().getString(i);
            this.asO = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.asL = this.mActivity.getResources().getString(i);
            this.asP = bVar;
        }
        return this;
    }

    public a be(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a bf(boolean z) {
        this.asV = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_bdalert, (ViewGroup) null);
        this.asT = (ViewGroup) this.mRootView.findViewById(e.g.real_view);
    }

    public a cO(int i) {
        if (isAutoNight()) {
            this.asM = al.getColor(i);
        } else {
            this.asM = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cP(int i) {
        this.asN = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.asU) {
            this.asU = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(e.g.dialog_content);
            this.asX = (TextView) this.mRootView.findViewById(e.g.yes);
            this.asY = (TextView) this.mRootView.findViewById(e.g.no);
            this.asZ = this.mRootView.findViewById(e.g.divider_yes_no_button);
            this.ata = this.mRootView.findViewById(e.g.bdDialog_divider_line);
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
                View Ay = Ay();
                if (Ay != null) {
                    linearLayout.removeAllViews();
                    if (Ay.getParent() != null) {
                        if (Ay.getParent() instanceof ViewGroup) {
                            ((ViewGroup) Ay.getParent()).removeView(Ay);
                            linearLayout.addView(Ay);
                        }
                    } else {
                        linearLayout.addView(Ay);
                    }
                }
            }
            c(eVar);
            if (this.asM != -1) {
                if (this.asX != null) {
                    this.asX.setTextColor(this.asM);
                }
                if (this.asY != null) {
                    this.asY.setTextColor(this.asM);
                }
            }
            if (TextUtils.isEmpty(this.asK) || this.asX == null) {
                z = false;
            } else {
                this.asX.setText(this.asK);
                this.asX.setTag(this.asW);
                if (this.asO != null) {
                    this.asX.setOnClickListener(new View$OnClickListenerC0147a(this, this.asO));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.asL) || this.asY == null) {
                z2 = false;
            } else {
                this.asY.setText(this.asL);
                if (this.asP != null) {
                    this.asY.setOnClickListener(new View$OnClickListenerC0147a(this, this.asP));
                }
            }
            j(z, z2);
        }
        return this;
    }

    public View Ay() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(e.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(e.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(e.g.message_view);
                if (this.asI) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.asJ) {
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
            if (this.asH) {
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
            if (this.asZ != null) {
                this.asZ.setVisibility(0);
            }
            if (this.ata != null) {
                this.ata.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.asZ != null) {
            this.asZ.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.asX != null && this.asY != null && this.asZ != null && this.ata != null) {
                this.asX.setVisibility(8);
                this.asY.setVisibility(8);
                this.asZ.setVisibility(8);
                this.ata.setVisibility(8);
            }
        } else if (z) {
            al.d(this.asX, e.f.dialog_single_button_bg_selector, skinType);
            if (this.asY != null && this.asZ != null && this.ata != null) {
                this.ata.setVisibility(0);
                this.asX.setVisibility(0);
                this.asY.setVisibility(8);
            }
        } else if (z2) {
            al.d(this.asY, e.f.dialog_single_button_bg_selector, skinType);
            if (this.asX != null && this.asZ != null && this.ata != null) {
                this.ata.setVisibility(0);
                this.asY.setVisibility(0);
                this.asX.setVisibility(8);
            }
        } else if (this.asX != null && this.asY != null && this.ata != null) {
            this.ata.setVisibility(8);
            this.asX.setVisibility(8);
            this.asY.setVisibility(8);
        }
    }

    public a Az() {
        return bg(false);
    }

    private a bg(boolean z) {
        if (!this.asU) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.asS != null) {
            if (z) {
                com.baidu.adp.lib.g.g.a(this.asS, this.mActivity);
            } else {
                this.asS.show();
            }
        } else {
            this.asS = new AlertDialog.Builder(this.mActivity).create();
            this.asS.setCanceledOnTouchOutside(this.asV);
            this.asS.setCancelable(this.mCancelable);
            this.asS.setOnKeyListener(this.mOnKeyListener);
            if (this.asQ != null) {
                this.asS.setOnCancelListener(this.asQ);
            }
            if (this.asR != null) {
                this.asS.setOnDismissListener(this.asR);
            }
            if (z) {
                com.baidu.adp.lib.g.g.a(this.asS, this.mActivity);
            } else {
                this.asS.show();
            }
            if (this.asS.getWindow().getDecorView().getParent() != null) {
                Window window = this.asS.getWindow();
                if (this.asG == -1) {
                    this.asG = 17;
                }
                window.setGravity(this.asG);
                window.setBackgroundDrawableResource(e.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics s = l.s(this.mActivity);
                if (s != null) {
                    int AA = AA();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = s.heightPixels - (AA * 2);
                    } else {
                        attributes.width = s.widthPixels - (AA * 2);
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

    public int AA() {
        return this.asN == 1 ? l.h(this.mActivity, e.C0200e.ds40) : l.h(this.mActivity, e.C0200e.ds90);
    }

    public boolean isShowing() {
        if (this.asS != null) {
            return this.asS.isShowing();
        }
        return false;
    }

    public void bh(boolean z) {
        if (this.asX != null) {
            this.asX.setClickable(z);
        }
    }

    public void bi(boolean z) {
        if (this.asY != null) {
            this.asY.setClickable(z);
        }
    }

    public a AB() {
        return bg(true);
    }

    public void hide() {
        if (this.asS != null) {
            this.asS.hide();
        }
    }

    public void dismiss() {
        if (this.asS != null) {
            com.baidu.adp.lib.g.g.b(this.asS, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0147a implements View.OnClickListener {
        private final a Td;
        private final b atd;

        public View$OnClickListenerC0147a(a aVar, b bVar) {
            this.Td = aVar;
            this.atd = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.atd != null) {
                this.atd.onClick(this.Td);
            }
        }
    }

    public ViewGroup AC() {
        return this.asT;
    }

    public void H(Object obj) {
        this.asW = obj;
    }

    public Object AD() {
        return this.asW;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public void bj(boolean z) {
        this.asH = z;
    }

    public void bk(boolean z) {
        this.asI = z;
    }

    public void bl(boolean z) {
        this.asJ = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.asU = false;
    }
}
