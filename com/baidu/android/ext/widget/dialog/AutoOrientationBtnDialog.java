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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class AutoOrientationBtnDialog extends BoxAlertDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BREAK_POINT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBreakPoint;
    public FrameLayout mBtnContainer;
    public List<BtnItem> mBtnItemList;
    public FrameLayout mContent;
    public Context mContext;
    public View mDivider;
    public ViewGroup mView;

    /* loaded from: classes6.dex */
    public static class Builder extends BoxAlertDialog.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<BtnItem> list;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.list = new ArrayList();
            setBtnsVersible(false);
            setDividerVisible(false);
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                AutoOrientationBtnDialog autoOrientationBtnDialog = (AutoOrientationBtnDialog) super.create();
                autoOrientationBtnDialog.setBtnItemList(this.list);
                return autoOrientationBtnDialog;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog onCreateDialog(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new AutoOrientationBtnDialog(context) : (BoxAlertDialog) invokeL.objValue;
        }

        public Builder setButton(BtnItem btnItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, btnItem)) == null) {
                if (btnItem != null) {
                    this.list.add(btnItem);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface OnItemClickListener {
        void onItemClick(View view);
    }

    /* loaded from: classes6.dex */
    public class ViewHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout button;
        public AutoOrientationBtnDialog mDialog;
        public TextView subText;
        public TextView text;
        public final /* synthetic */ AutoOrientationBtnDialog this$0;

        public ViewHelper(AutoOrientationBtnDialog autoOrientationBtnDialog, View view, AutoOrientationBtnDialog autoOrientationBtnDialog2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoOrientationBtnDialog, view, autoOrientationBtnDialog2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = autoOrientationBtnDialog;
            if (view != null) {
                this.text = (TextView) view.findViewById(R.id.hv_btn_text);
                this.subText = (TextView) view.findViewById(R.id.hv_btn_subtext);
                this.button = (LinearLayout) view;
                this.mDialog = autoOrientationBtnDialog2;
            }
        }

        public void onBindView(BtnItem btnItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, btnItem) == null) || btnItem == null) {
                return;
            }
            this.text.setText(btnItem.mText);
            if (btnItem.mTextColorId > 0) {
                this.text.setTextColor(this.this$0.mContent.getResources().getColor(btnItem.mTextColorId));
            }
            if (!TextUtils.isEmpty(btnItem.mSubText)) {
                this.subText.setVisibility(0);
                this.subText.setText(btnItem.mSubText);
            } else {
                this.subText.setVisibility(8);
            }
            if (btnItem.mSubTextColorId > 0) {
                this.subText.setTextColor(this.this$0.mContent.getResources().getColor(btnItem.mSubTextColorId));
            }
            this.button.setOnClickListener(new View.OnClickListener(this, btnItem) { // from class: com.baidu.android.ext.widget.dialog.AutoOrientationBtnDialog.ViewHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewHelper this$1;
                public final /* synthetic */ BtnItem val$item;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, btnItem};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$item = btnItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$1.mDialog.dismiss();
                        OnItemClickListener onItemClickListener = this.val$item.mOnItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(view);
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoOrientationBtnDialog(Context context) {
        super(context, R.style.NoTitleDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBtnItemList = new ArrayList();
        this.mBreakPoint = 2;
    }

    private LinearLayout createButton(BtnItem btnItem, LinearLayout linearLayout, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, this, btnItem, linearLayout, i2)) == null) {
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.item_hv_dialog, (ViewGroup) linearLayout, false);
            linearLayout2.setBackground(getContext().getResources().getDrawable(i2));
            new ViewHelper(this, linearLayout2, this).onBindView(btnItem);
            return linearLayout2;
        }
        return (LinearLayout) invokeLLI.objValue;
    }

    private void createButtonItem(List<BtnItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list) == null) || list == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int size = list.size();
        if (size == 0) {
            return;
        }
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
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 < list.size() - 1) {
                    linearLayout.addView(createButton(list.get(i2), linearLayout, R.drawable.auto_orientation_dialog_btn_bg_selector));
                    linearLayout.addView(createDivider(1));
                } else if (i2 == list.size() - 1) {
                    linearLayout.addView(createButton(list.get(i2), linearLayout, R.drawable.auto_orientation_dialog_btn_left_right_corner_bg_selector));
                }
            }
        }
        this.mBtnContainer.removeAllViews();
        this.mBtnContainer.addView(linearLayout);
    }

    private View createDivider(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(this.mContent.getResources().getColor(R.color.dialog_gray));
            if (i2 == 1) {
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    private void createView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            Context context = getContext();
            this.mContext = context;
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.view_hv_dialog, getBuilder().getCustomContentParent(), false);
            this.mView = viewGroup;
            this.mContent = (FrameLayout) viewGroup.findViewById(R.id.hv_content);
            this.mDivider = this.mView.findViewById(R.id.hv_divider);
            this.mBtnContainer = (FrameLayout) this.mView.findViewById(R.id.hv_btn_content);
            View createContentView = createContentView(this.mContent);
            if (createContentView != null) {
                this.mContent.addView(createContentView);
            }
            updateBackground();
            createButtonItem(this.mBtnItemList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBtnItemList(List<BtnItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, list) == null) {
            this.mBtnItemList.clear();
            if (list != null) {
                this.mBtnItemList.addAll(list);
            }
        }
    }

    private void updateBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mDivider.setBackgroundColor(getContext().getResources().getColor(R.color.dialog_gray));
        }
    }

    public View createContentView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            createView();
            getBuilder().setView(this.mView);
        }
    }

    /* loaded from: classes6.dex */
    public static class BtnItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OnItemClickListener mOnItemClickListener;
        public CharSequence mSubText;
        public int mSubTextColorId;
        public CharSequence mText;
        public int mTextColorId;

        public BtnItem(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, charSequence2, Integer.valueOf(i2), Integer.valueOf(i3), onItemClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTextColorId = -1;
            this.mSubTextColorId = -1;
            this.mText = charSequence;
            this.mSubText = charSequence2;
            this.mTextColorId = i2;
            this.mSubTextColorId = i3;
            this.mOnItemClickListener = onItemClickListener;
        }

        public void onItemClick(View view) {
            OnItemClickListener onItemClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onItemClickListener = this.mOnItemClickListener) == null) {
                return;
            }
            onItemClickListener.onItemClick(view);
        }

        public BtnItem(CharSequence charSequence, int i2, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, Integer.valueOf(i2), onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTextColorId = -1;
            this.mSubTextColorId = -1;
            this.mText = charSequence;
            this.mTextColorId = i2;
            this.mOnItemClickListener = onItemClickListener;
        }
    }
}
