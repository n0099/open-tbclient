package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.dialog.BaseActivityDialog;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class AutoOrientationBtnActDialog {
    private static final int DEFAULT_BREAK_POINT = 2;
    private BaseActivityDialog.Builder mBaseActivityDialogBuilder;
    private FrameLayout mBtnContainer;
    private Builder mBuilder;
    private FrameLayout mContent;
    protected Context mContext;
    private View mDivider;
    private ViewGroup mView;
    private List<BtnItem> mBtnItemList = new ArrayList();
    private int mBreakPoint = 2;
    private Object mTag = new Object();

    /* loaded from: classes12.dex */
    public interface OnItemClickListener {
        void onItemClick(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        create();
        if (this.mBaseActivityDialogBuilder != null) {
            this.mBaseActivityDialogBuilder.show();
        }
    }

    public boolean isShowing() {
        return this.mBaseActivityDialogBuilder != null && this.mBaseActivityDialogBuilder.isShowing(this.mTag);
    }

    private void create() {
        this.mContext = AppRuntime.getAppContext();
        this.mBaseActivityDialogBuilder = new BaseActivityDialog.Builder();
        createView();
        this.mBaseActivityDialogBuilder.setView(this.mView);
        this.mBaseActivityDialogBuilder.setTitle(this.mBuilder.getTitle());
        this.mBaseActivityDialogBuilder.setTag(this.mTag);
        this.mBaseActivityDialogBuilder.setHideBtnsPanel(true);
    }

    private void createView() {
        this.mView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.view_hv_dialog, (ViewGroup) null);
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
        this.mDivider.setBackgroundColor(this.mContext.getResources().getColor(R.color.dialog_gray));
    }

    protected View createContentView(ViewGroup viewGroup) {
        return null;
    }

    private void setBtnItemList(List<BtnItem> list) {
        this.mBtnItemList.clear();
        if (list != null) {
            this.mBtnItemList.addAll(list);
        }
    }

    public void setBuilder(Builder builder) {
        this.mBuilder = builder;
        setBtnItemList(builder.list);
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
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(this.mContent.getResources().getDrawable(R.drawable.alertdialog_button_day_bg_all_selector));
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

    /* loaded from: classes12.dex */
    public class ViewHelper {
        LinearLayout button;
        AutoOrientationBtnActDialog mDialog;
        TextView subText;
        TextView text;

        public ViewHelper(View view, AutoOrientationBtnActDialog autoOrientationBtnActDialog) {
            if (view != null) {
                this.text = (TextView) view.findViewById(R.id.hv_btn_text);
                this.subText = (TextView) view.findViewById(R.id.hv_btn_subtext);
                this.button = (LinearLayout) view;
                this.mDialog = autoOrientationBtnActDialog;
            }
        }

        public void onBindView(final BtnItem btnItem) {
            if (btnItem != null) {
                this.text.setText(btnItem.mText);
                if (btnItem.mTextColorId > 0) {
                    this.text.setTextColor(AutoOrientationBtnActDialog.this.mContent.getResources().getColor(btnItem.mTextColorId));
                }
                if (!TextUtils.isEmpty(btnItem.mSubText)) {
                    this.subText.setVisibility(0);
                    this.subText.setText(btnItem.mSubText);
                } else {
                    this.subText.setVisibility(8);
                }
                if (btnItem.mSubTextColorId > 0) {
                    this.subText.setTextColor(AutoOrientationBtnActDialog.this.mContent.getResources().getColor(btnItem.mSubTextColorId));
                }
                this.button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog.ViewHelper.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventBusWrapper.post(new BaseActivityDialog.Builder.DismissEventObject(AutoOrientationBtnActDialog.this.mTag));
                        if (btnItem.mOnItemClickListener != null) {
                            btnItem.mOnItemClickListener.onItemClick(view);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class Builder {
        private List<BtnItem> list = new ArrayList();
        private AutoOrientationBtnActDialog mDialog = onCreateDialog();
        private String title;

        public Builder setTitle(int i) {
            return setTitle(AppRuntime.getAppContext().getString(i));
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public String getTitle() {
            return this.title;
        }

        public Builder setButton(BtnItem btnItem) {
            if (btnItem != null) {
                this.list.add(btnItem);
            }
            return this;
        }

        public AutoOrientationBtnActDialog onCreateDialog() {
            return new AutoOrientationBtnActDialog();
        }

        public AutoOrientationBtnActDialog getDialog() {
            return this.mDialog;
        }

        public AutoOrientationBtnActDialog show() {
            AutoOrientationBtnActDialog dialog = getDialog();
            dialog.setBuilder(this);
            dialog.show();
            return dialog;
        }
    }

    /* loaded from: classes12.dex */
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
