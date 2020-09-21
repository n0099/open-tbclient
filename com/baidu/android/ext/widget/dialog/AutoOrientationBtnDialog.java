package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public class AutoOrientationBtnDialog extends BoxAlertDialog {
    private static final int DEFAULT_BREAK_POINT = 2;
    private int mBreakPoint;
    private FrameLayout mBtnContainer;
    private List<BtnItem> mBtnItemList;
    private FrameLayout mContent;
    protected Context mContext;
    private View mDivider;
    private ViewGroup mView;

    /* loaded from: classes19.dex */
    public interface OnItemClickListener {
        void onItemClick(View view);
    }

    protected AutoOrientationBtnDialog(Context context) {
        super(context, R.style.NoTitleDialog);
        this.mBtnItemList = new ArrayList();
        this.mBreakPoint = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        getBuilder().setView(this.mView);
    }

    private void createView() {
        this.mContext = getContext();
        this.mView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.view_hv_dialog, getBuilder().getCustomContentParent(), false);
        this.mContent = (FrameLayout) this.mView.findViewById(R.id.hv_content);
        this.mDivider = this.mView.findViewById(R.id.hv_divider);
        this.mBtnContainer = (FrameLayout) this.mView.findViewById(R.id.hv_btn_content);
        View createContentView = createContentView(this.mContent);
        if (createContentView != null) {
            this.mContent.addView(createContentView);
        }
        updateBackground();
        createButtonItem(this.mBtnItemList);
    }

    private void updateBackground() {
        this.mDivider.setBackgroundColor(getContext().getResources().getColor(R.color.dialog_gray));
    }

    protected View createContentView(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBtnItemList(List<BtnItem> list) {
        this.mBtnItemList.clear();
        if (list != null) {
            this.mBtnItemList.addAll(list);
        }
    }

    private void createButtonItem(List<BtnItem> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            int size = list.size();
            if (size != 0) {
                if (size == 1) {
                    linearLayout.setOrientation(0);
                    linearLayout.addView(createButton(list.get(0), linearLayout, R.drawable.auto_orientation_dialog_btn_left_right_corner_bg_selector));
                } else if (size == this.mBreakPoint) {
                    linearLayout.setOrientation(0);
                    linearLayout.addView(createButton(list.get(0), linearLayout, R.drawable.auto_orientation_dialog_btn_left_corner_bg_selector));
                    linearLayout.addView(createDivider(0));
                    linearLayout.addView(createButton(list.get(1), linearLayout, R.drawable.auto_orientation_dialog_btn_right_corner_bg_selector));
                } else {
                    linearLayout.setOrientation(1);
                    for (int i = 0; i < list.size(); i++) {
                        if (i < list.size() - 1) {
                            linearLayout.addView(createButton(list.get(i), linearLayout, R.drawable.auto_orientation_dialog_btn_bg_selector));
                            linearLayout.addView(createDivider(1));
                        } else if (i == list.size() - 1) {
                            linearLayout.addView(createButton(list.get(i), linearLayout, R.drawable.auto_orientation_dialog_btn_left_right_corner_bg_selector));
                        }
                    }
                }
                this.mBtnContainer.removeAllViews();
                this.mBtnContainer.addView(linearLayout);
            }
        }
    }

    private LinearLayout createButton(BtnItem btnItem, LinearLayout linearLayout, int i) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(i));
        new ViewHelper(linearLayout2, this).onBindView(btnItem);
        return linearLayout2;
    }

    private View createDivider(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.mContent.getResources().getColor(R.color.dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes19.dex */
    public class ViewHelper {
        LinearLayout button;
        AutoOrientationBtnDialog mDialog;
        TextView subText;
        TextView text;

        public ViewHelper(View view, AutoOrientationBtnDialog autoOrientationBtnDialog) {
            if (view != null) {
                this.text = (TextView) view.findViewById(R.id.hv_btn_text);
                this.subText = (TextView) view.findViewById(R.id.hv_btn_subtext);
                this.button = (LinearLayout) view;
                this.mDialog = autoOrientationBtnDialog;
            }
        }

        public void onBindView(final BtnItem btnItem) {
            if (btnItem != null) {
                this.text.setText(btnItem.mText);
                if (btnItem.mTextColorId > 0) {
                    this.text.setTextColor(AutoOrientationBtnDialog.this.mContent.getResources().getColor(btnItem.mTextColorId));
                }
                if (!TextUtils.isEmpty(btnItem.mSubText)) {
                    this.subText.setVisibility(0);
                    this.subText.setText(btnItem.mSubText);
                } else {
                    this.subText.setVisibility(8);
                }
                if (btnItem.mSubTextColorId > 0) {
                    this.subText.setTextColor(AutoOrientationBtnDialog.this.mContent.getResources().getColor(btnItem.mSubTextColorId));
                }
                this.button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.AutoOrientationBtnDialog.ViewHelper.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ViewHelper.this.mDialog.dismiss();
                        if (btnItem.mOnItemClickListener != null) {
                            btnItem.mOnItemClickListener.onItemClick(view);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class Builder extends BoxAlertDialog.Builder {
        private List<BtnItem> list;

        public Builder(Context context) {
            super(context);
            this.list = new ArrayList();
            setBtnsVersible(false);
            setDividerVisible(false);
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        protected BoxAlertDialog onCreateDialog(Context context) {
            return new AutoOrientationBtnDialog(context);
        }

        public Builder setButton(BtnItem btnItem) {
            if (btnItem != null) {
                this.list.add(btnItem);
            }
            return this;
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog create() {
            AutoOrientationBtnDialog autoOrientationBtnDialog = (AutoOrientationBtnDialog) super.create();
            autoOrientationBtnDialog.setBtnItemList(this.list);
            return autoOrientationBtnDialog;
        }
    }

    /* loaded from: classes19.dex */
    public static class BtnItem {
        public OnItemClickListener mOnItemClickListener;
        public CharSequence mSubText;
        public int mSubTextColorId;
        public CharSequence mText;
        public int mTextColorId;

        public BtnItem(CharSequence charSequence, CharSequence charSequence2, int i, int i2, OnItemClickListener onItemClickListener) {
            this.mTextColorId = -1;
            this.mSubTextColorId = -1;
            this.mText = charSequence;
            this.mSubText = charSequence2;
            this.mTextColorId = i;
            this.mSubTextColorId = i2;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BtnItem(CharSequence charSequence, int i, OnItemClickListener onItemClickListener) {
            this.mTextColorId = -1;
            this.mSubTextColorId = -1;
            this.mText = charSequence;
            this.mTextColorId = i;
            this.mOnItemClickListener = onItemClickListener;
        }

        public void onItemClick(View view) {
            if (this.mOnItemClickListener != null) {
                this.mOnItemClickListener.onItemClick(view);
            }
        }
    }
}
