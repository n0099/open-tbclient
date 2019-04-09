package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> bFa = new HashMap<>(2);
    private List<CharSequence> aMK;
    private InterfaceC0225b bET;
    private final View bEU;
    private LinearLayout.LayoutParams bEZ;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private AlertDialog mDialog;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int bEW = -1;
    private int bEu = -1;
    private int bEX = -1;
    private boolean bEI = false;
    private int bEY = -1;
    private int bEV = d.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int bFd = d.k.dialog_ani_b2t;
        public static final int bFe = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0225b {
        void a(b bVar, int i, View view);
    }

    static {
        bFa.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        bFa.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0277d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.bEU = this.mRootView.findViewById(d.g.line_bg);
    }

    public b lA(String str) {
        this.mTitle = str;
        return this;
    }

    public b gF(int i) {
        return lA(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0225b interfaceC0225b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0225b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0225b interfaceC0225b) {
        if (list != null && list.size() > 0) {
            this.aMK = list;
            if (interfaceC0225b != null) {
                this.bET = interfaceC0225b;
            }
        }
        return this;
    }

    public b gG(int i) {
        this.bEW = i;
        return this;
    }

    public b gH(int i) {
        this.bEu = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.bEI) {
            this.mContext = eVar;
            this.bEI = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.bEU.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.bEU.setVisibility(8);
            }
            if (this.aMK != null && this.aMK.size() > 0) {
                int size = this.aMK.size();
                for (int i = 0; i < size; i++) {
                    gI(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public b aaZ() {
        if (!this.bEI) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity, d.k.NoBackDimEnableDialog).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity)) {
                Window window = this.mDialog.getWindow();
                if (this.bEW == -1) {
                    this.bEW = a.bFd;
                }
                if (this.bEu == -1) {
                    this.bEu = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.bEu);
                window.setContentView(this.mRootView);
            }
        }
        return this;
    }

    public void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
        }
        this.mRootView.setBackgroundResource(d.f.transparent_bg);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.b(this.mDialog, this.mActivity);
        }
    }

    private View gI(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.bEV, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.bEZ != null) {
            textView.setLayoutParams(this.bEZ);
        }
        if (this.bEX != -1) {
            textView.setTextSize(0, this.bEX);
        }
        if (this.bEY != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.bEY);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.aMK.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.aMK.size() - 1) {
            findViewById.setVisibility(8);
            al.k(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.aMK.size() == 1) {
            findViewById.setVisibility(8);
            al.k(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            al.k(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            al.k(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.bET != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bET.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View gJ(int i) {
        if (this.mContentView == null) {
            return null;
        }
        int childCount = this.mContentView.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.mContentView.getChildAt(i);
    }
}
