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
    private static final HashMap<Integer, Integer[]> bEV = new HashMap<>(2);
    private List<CharSequence> aMF;
    private AlertDialog bEB;
    private InterfaceC0191b bEO;
    private final View bEP;
    private LinearLayout.LayoutParams bEU;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int bER = -1;
    private int bEo = -1;
    private int bES = -1;
    private boolean bED = false;
    private int bET = -1;
    private int bEQ = d.h.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public static final class a {
        public static final int bEY = d.k.dialog_ani_b2t;
        public static final int bEZ = d.k.dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = d.k.dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = d.k.dialog_ani_r2l;
    }

    /* renamed from: com.baidu.tbadk.core.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0191b {
        void a(b bVar, int i, View view);
    }

    static {
        bEV.put(0, new Integer[]{Integer.valueOf(d.f.dialg_alert_btn_bg), Integer.valueOf(d.f.dialog_bdalert_button_textcolor_pressed)});
        bEV.put(1, new Integer[]{Integer.valueOf(d.f.btn_blue_square), Integer.valueOf(d.C0236d.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(d.g.dialog_content);
        this.bEP = this.mRootView.findViewById(d.g.line_bg);
    }

    public b lz(String str) {
        this.mTitle = str;
        return this;
    }

    public b gG(int i) {
        return lz(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, InterfaceC0191b interfaceC0191b) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), interfaceC0191b);
        }
        return this;
    }

    public b a(List<CharSequence> list, InterfaceC0191b interfaceC0191b) {
        if (list != null && list.size() > 0) {
            this.aMF = list;
            if (interfaceC0191b != null) {
                this.bEO = interfaceC0191b;
            }
        }
        return this;
    }

    public b gH(int i) {
        this.bER = i;
        return this;
    }

    public b gI(int i) {
        this.bEo = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.bED) {
            this.mContext = eVar;
            this.bED = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.bEP.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.bEP.setVisibility(8);
            }
            if (this.aMF != null && this.aMF.size() > 0) {
                int size = this.aMF.size();
                for (int i = 0; i < size; i++) {
                    gJ(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public b abc() {
        if (!this.bED) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.bEB != null) {
            com.baidu.adp.lib.g.g.a(this.bEB, this.mActivity);
        } else {
            this.bEB = new AlertDialog.Builder(this.mActivity, d.k.NoBackDimEnableDialog).create();
            this.bEB.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.bEB, this.mActivity)) {
                Window window = this.bEB.getWindow();
                if (this.bER == -1) {
                    this.bER = a.bEY;
                }
                if (this.bEo == -1) {
                    this.bEo = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.bEo);
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
        if (this.bEB != null) {
            com.baidu.adp.lib.g.g.b(this.bEB, this.mActivity);
        }
    }

    private View gJ(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.bEQ, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(d.g.dialog_item_btn);
        if (this.bEU != null) {
            textView.setLayoutParams(this.bEU);
        }
        if (this.bES != -1) {
            textView.setTextSize(0, this.bES);
        }
        if (this.bET != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.bET);
        }
        View findViewById = inflate.findViewById(d.g.line);
        CharSequence charSequence = this.aMF.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.aMF.size() - 1) {
            findViewById.setVisibility(8);
            al.k(inflate, d.f.dialog_single_button_bg_selector);
        } else if (this.aMF.size() == 1) {
            findViewById.setVisibility(8);
            al.k(inflate, d.f.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            al.k(inflate, d.f.dialog_single_button_first_bg_selector);
        } else {
            al.k(inflate, d.f.dialg_alert_btn_bg);
        }
        if (this.bEO != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bEO.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View gK(int i) {
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
