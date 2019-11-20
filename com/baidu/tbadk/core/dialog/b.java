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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static final HashMap<Integer, Integer[]> sBtnStyleMap = new HashMap<>(2);
    private a cen;
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private com.baidu.adp.base.e<?> mContext;
    private AlertDialog mDialog;
    private List<CharSequence> mItems;
    private final View mLineView;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private LinearLayout.LayoutParams mTvParam;
    private int mAnimationStyleId = -1;
    private int mDialogGravity = -1;
    private int mTextItemSize = -1;
    private boolean mDialogCreated = false;
    private int mTextViewGravity = -1;
    private int mItemView = R.layout.dialog_bdlist_item;

    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar, int i, View view);
    }

    static {
        sBtnStyleMap.put(0, new Integer[]{Integer.valueOf((int) R.drawable.dialg_alert_btn_bg), Integer.valueOf((int) R.drawable.dialog_bdalert_button_textcolor_pressed)});
        sBtnStyleMap.put(1, new Integer[]{Integer.valueOf((int) R.drawable.btn_blue_square), Integer.valueOf((int) R.color.cp_bg_line_d)});
    }

    public b(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(R.id.dialog_content);
        this.mLineView = this.mRootView.findViewById(R.id.line_bg);
    }

    public b no(String str) {
        this.mTitle = str;
        return this;
    }

    public b hX(int i) {
        return no(this.mActivity.getResources().getString(i));
    }

    public b a(CharSequence[] charSequenceArr, a aVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return a(Arrays.asList(charSequenceArr), aVar);
        }
        return this;
    }

    public b a(List<CharSequence> list, a aVar) {
        if (list != null && list.size() > 0) {
            this.mItems = list;
            if (aVar != null) {
                this.cen = aVar;
            }
        }
        return this;
    }

    public b hY(int i) {
        this.mAnimationStyleId = i;
        return this;
    }

    public b hZ(int i) {
        this.mDialogGravity = i;
        return this;
    }

    public b d(com.baidu.adp.base.e<?> eVar) {
        if (!this.mDialogCreated) {
            this.mContext = eVar;
            this.mDialogCreated = true;
            if (!TextUtils.isEmpty(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
                this.mTitleView.setVisibility(0);
                this.mLineView.setVisibility(0);
            } else {
                this.mTitleView.setVisibility(8);
                this.mLineView.setVisibility(8);
            }
            if (this.mItems != null && this.mItems.size() > 0) {
                int size = this.mItems.size();
                for (int i = 0; i < size; i++) {
                    createItemView(i);
                }
            }
            c(eVar);
        }
        return this;
    }

    public b akN() {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.g.showDialog(this.mDialog, this.mActivity);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity, R.style.NoBackDimEnableDialog).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (com.baidu.adp.lib.g.g.showDialog(this.mDialog, this.mActivity)) {
                Window window = this.mDialog.getWindow();
                if (this.mAnimationStyleId == -1) {
                    this.mAnimationStyleId = R.style.dialog_ani_b2t;
                }
                if (this.mDialogGravity == -1) {
                    this.mDialogGravity = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.mDialogGravity);
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
            com.baidu.adp.lib.g.g.dismissDialog(this.mDialog, this.mActivity);
        }
    }

    private View createItemView(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.mItemView, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(R.id.dialog_item_btn);
        if (this.mTvParam != null) {
            textView.setLayoutParams(this.mTvParam);
        }
        if (this.mTextItemSize != -1) {
            textView.setTextSize(0, this.mTextItemSize);
        }
        if (this.mTextViewGravity != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.mTextViewGravity);
        }
        View findViewById = inflate.findViewById(R.id.line);
        CharSequence charSequence = this.mItems.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.mItems.size() - 1) {
            findViewById.setVisibility(8);
            am.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
        } else if (this.mItems.size() == 1) {
            findViewById.setVisibility(8);
            am.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            am.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
        } else {
            am.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
        }
        if (this.cen != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cen.a(b.this, i, textView);
                }
            });
        }
        this.mContentView.addView(inflate);
        return inflate;
    }

    public View getItemView(int i) {
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
