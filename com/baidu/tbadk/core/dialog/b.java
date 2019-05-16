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
import com.baidu.tieba.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> bMu = new HashMap<>(2);
    private List<CharSequence> aOH;
    private a bMn;
    private final View bMo;
    private LinearLayout.LayoutParams bMt;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private AlertDialog mDialog;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private int bMq = -1;
    private int bLN = -1;
    private int bMr = -1;
    private boolean bMc = false;
    private int bMs = -1;
    private int bMp = R.layout.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar, int i, View view);
    }

    static {
        bMu.put(0, new Integer[]{Integer.valueOf((int) R.drawable.dialg_alert_btn_bg), Integer.valueOf((int) R.drawable.dialog_bdalert_button_textcolor_pressed)});
        bMu.put(1, new Integer[]{Integer.valueOf((int) R.drawable.btn_blue_square), Integer.valueOf((int) R.color.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(R.id.dialog_content);
        this.bMo = this.mRootView.findViewById(R.id.line_bg);
    }

    public b mF(String str) {
        this.mTitle = str;
        return this;
    }

    public b hs(int i) {
        return mF(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, a aVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), aVar);
        }
        return this;
    }

    public b a(List<CharSequence> list, a aVar) {
        if (list != null && list.size() > 0) {
            this.aOH = list;
            if (aVar != null) {
                this.bMn = aVar;
            }
        }
        return this;
    }

    public b ht(int i) {
        this.bMq = i;
        return this;
    }

    public b hu(int i) {
        this.bLN = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.bMc) {
            this.mContext = eVar;
            this.bMc = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.bMo.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.bMo.setVisibility(8);
            }
            if (this.aOH != null && this.aOH.size() > 0) {
                int size = this.aOH.size();
                for (int i = 0; i < size; i++) {
                    hv(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public b afJ() {
        if (!this.bMc) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity, R.style.NoBackDimEnableDialog).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.a(this.mDialog, this.mActivity)) {
                Window window = this.mDialog.getWindow();
                if (this.bMq == -1) {
                    this.bMq = R.style.dialog_ani_b2t;
                }
                if (this.bLN == -1) {
                    this.bLN = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.bLN);
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
        this.mRootView.setBackgroundResource(R.drawable.transparent_bg);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.b(this.mDialog, this.mActivity);
        }
    }

    private View hv(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.bMp, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(R.id.dialog_item_btn);
        if (this.bMt != null) {
            textView.setLayoutParams(this.bMt);
        }
        if (this.bMr != -1) {
            textView.setTextSize(0, this.bMr);
        }
        if (this.bMs != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.bMs);
        }
        View findViewById = inflate.findViewById(R.id.line);
        CharSequence charSequence = this.aOH.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.aOH.size() - 1) {
            findViewById.setVisibility(8);
            al.k(inflate, R.drawable.dialog_single_button_bg_selector);
        } else if (this.aOH.size() == 1) {
            findViewById.setVisibility(8);
            al.k(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            al.k(inflate, R.drawable.dialog_single_button_first_bg_selector);
        } else {
            al.k(inflate, R.drawable.dialg_alert_btn_bg);
        }
        if (this.bMn != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bMn.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View hw(int i) {
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
