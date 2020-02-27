package com.baidu.live.tbadk.core.dialog;

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
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.u.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class BdListDialog {
    private static final HashMap<Integer, Integer[]> sBtnStyleMap = new HashMap<>(2);
    private final Activity mActivity;
    private final ViewGroup mContentView;
    private BdPageContext<?> mContext;
    private AlertDialog mDialog;
    private List<CharSequence> mItems;
    private final View mLineView;
    private OnItemClickListener mOnItemClickListener;
    private final ViewGroup mRootView;
    private String mTitle;
    private final TextView mTitleView;
    private LinearLayout.LayoutParams mTvParam;
    private int mAnimationStyleId = -1;
    private int mDialogGravity = -1;
    private int mTextItemSize = -1;
    private boolean mDialogCreated = false;
    private int mTextViewGravity = -1;
    private int mItemView = a.h.sdk_dialog_bdlist_item;

    /* loaded from: classes3.dex */
    public static final class Animation {
        public static final int BOTTOM_TO_TOP = a.j.sdk_dialog_ani_b2t;
        public static final int TOP_TO_BOTTOM = a.j.sdk_dialog_ani_t2b;
        public static final int LEFT_TO_RIGHT = a.j.sdk_dialog_ani_l2r;
        public static final int RIGHT_TO_LEFT = a.j.sdk_dialog_ani_r2l;
    }

    /* loaded from: classes3.dex */
    public static final class ButtonStyle {
        public static final int HIGHLIGHT = 1;
        public static final int NORMAL = 0;
    }

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void itemClick(BdListDialog bdListDialog, int i, View view);
    }

    static {
        sBtnStyleMap.put(0, new Integer[]{Integer.valueOf(a.f.sdk_dialg_alert_btn_bg), Integer.valueOf(a.f.sdk_dialog_bdalert_button_textcolor_pressed)});
        sBtnStyleMap.put(1, new Integer[]{Integer.valueOf(a.f.sdk_btn_blue_square), Integer.valueOf(a.d.sdk_cp_bg_line_d)});
    }

    public BdListDialog(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(a.h.sdk_dialog_bdlist, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.g.dialog_title_list);
        this.mContentView = (ViewGroup) this.mRootView.findViewById(a.g.dialog_content);
        this.mLineView = this.mRootView.findViewById(a.g.line_bg);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setItemView(int i) {
        this.mItemView = i;
    }

    public BdListDialog setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public BdListDialog setTitle(int i) {
        return setTitle(this.mActivity.getResources().getString(i));
    }

    public BdListDialog setItems(CharSequence[] charSequenceArr, OnItemClickListener onItemClickListener) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            return setItems(Arrays.asList(charSequenceArr), onItemClickListener);
        }
        return this;
    }

    public BdListDialog setItems(List<CharSequence> list, OnItemClickListener onItemClickListener) {
        if (list != null && list.size() > 0) {
            this.mItems = list;
            if (onItemClickListener != null) {
                this.mOnItemClickListener = onItemClickListener;
            }
        }
        return this;
    }

    public BdListDialog setAnimation(int i) {
        this.mAnimationStyleId = i;
        return this;
    }

    public BdListDialog setGravity(int i) {
        this.mDialogGravity = i;
        return this;
    }

    public BdListDialog create(BdPageContext<?> bdPageContext) {
        if (!this.mDialogCreated) {
            this.mContext = bdPageContext;
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
            autoChangeSkinType(bdPageContext);
        }
        return this;
    }

    public void reset() {
        this.mDialogCreated = false;
        if (this.mContentView != null) {
            this.mContentView.removeAllViews();
        }
    }

    public BdListDialog show() {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            ShowUtil.showDialog(this.mDialog, this.mActivity);
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity, a.j.sdk_NoBackDimEnableDialog).create();
            this.mDialog.setCanceledOnTouchOutside(true);
            if (ShowUtil.showDialog(this.mDialog, this.mActivity)) {
                Window window = this.mDialog.getWindow();
                if (this.mAnimationStyleId == -1) {
                    this.mAnimationStyleId = Animation.BOTTOM_TO_TOP;
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

    public void autoChangeSkinType(BdPageContext<?> bdPageContext) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (bdPageContext instanceof TbPageContext) {
            ((TbPageContext) bdPageContext).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) bdPageContext).getLayoutMode().onModeChanged(this.mRootView);
        }
        this.mRootView.setBackgroundResource(a.f.sdk_transparent_bg);
    }

    public void hide() {
        if (this.mDialog != null) {
            this.mDialog.hide();
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            ShowUtil.dismissDialog(this.mDialog, this.mActivity);
        }
    }

    public void setTextViewGravity(int i) {
        this.mTextViewGravity = i;
    }

    private View createItemView(final int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(this.mItemView, this.mContentView, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        final TextView textView = (TextView) inflate.findViewById(a.g.dialog_item_btn);
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
        View findViewById = inflate.findViewById(a.g.line);
        CharSequence charSequence = this.mItems.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.mItems.size() - 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, a.f.sdk_dialog_single_button_bg_selector);
        } else if (this.mItems.size() == 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, a.f.sdk_dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.mTitle)) {
            SkinManager.setBackgroundResource(inflate, a.f.sdk_dialog_single_button_first_bg_selector);
        } else {
            SkinManager.setBackgroundResource(inflate, a.f.sdk_dialg_alert_btn_bg);
        }
        if (this.mOnItemClickListener != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.tbadk.core.dialog.BdListDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BdListDialog.this.mOnItemClickListener.itemClick(BdListDialog.this, i, textView);
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

    public int getItemCount() {
        int childCount;
        if (this.mContentView != null && (childCount = this.mContentView.getChildCount()) >= 0) {
            return childCount;
        }
        return 0;
    }

    public void setTextViewParams(LinearLayout.LayoutParams layoutParams) {
        this.mTvParam = layoutParams;
    }

    public void setItemTextSize(int i) {
        this.mTextItemSize = i;
    }
}
