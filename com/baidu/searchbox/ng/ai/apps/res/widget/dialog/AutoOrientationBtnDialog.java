package com.baidu.searchbox.ng.ai.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AutoOrientationBtnDialog extends AiAppAlertDialog {
    private static final int DEFAULT_BREAK_POINT = 2;
    private int mBreakPoint;
    private FrameLayout mBtnContainer;
    private List<BtnItem> mBtnItemList;
    private FrameLayout mContent;
    protected Context mContext;
    private View mDivider;
    private ViewGroup mView;

    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void onItemClick(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AutoOrientationBtnDialog(Context context) {
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
        this.mView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_view_hv_dialog, getBuilder().getCustomContentParent(), false);
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
        this.mDivider.setBackgroundColor(getContext().getResources().getColor(R.color.aiapps_dialog_gray));
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
            if (list.size() > this.mBreakPoint) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(createButton(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.mBreakPoint) {
                        linearLayout.addView(createDivider(1));
                    } else {
                        linearLayout.addView(createDivider(0));
                    }
                }
            }
            this.mBtnContainer.removeAllViews();
            this.mBtnContainer.addView(linearLayout);
        }
    }

    private LinearLayout createButton(BtnItem btnItem, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(R.drawable.aiapps_alertdialog_button_day_bg_all_selector));
        new ViewHelper(linearLayout2, this).onBindView(btnItem);
        return linearLayout2;
    }

    private View createDivider(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.mContent.getResources().getColor(R.color.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes2.dex */
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
                this.button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.ViewHelper.1
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

    /* loaded from: classes2.dex */
    public static class Builder extends AiAppAlertDialog.Builder {
        private List<BtnItem> list;

        public Builder(Context context) {
            super(context);
            this.list = new ArrayList();
            setBtnsVersible(false);
            setDividerVisible(false);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        protected AiAppAlertDialog onCreateDialog(Context context) {
            return new AutoOrientationBtnDialog(context);
        }

        public Builder setButton(BtnItem btnItem) {
            if (btnItem != null) {
                this.list.add(btnItem);
            }
            return this;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public AiAppAlertDialog create() {
            AutoOrientationBtnDialog autoOrientationBtnDialog = (AutoOrientationBtnDialog) super.create();
            autoOrientationBtnDialog.setBtnItemList(this.list);
            return autoOrientationBtnDialog;
        }
    }

    /* loaded from: classes2.dex */
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
