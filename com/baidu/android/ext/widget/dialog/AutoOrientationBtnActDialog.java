package com.baidu.android.ext.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.BaseActivityDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class AutoOrientationBtnActDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BREAK_POINT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivityDialog.Builder mBaseActivityDialogBuilder;
    public int mBreakPoint;
    public FrameLayout mBtnContainer;
    public List<BtnItem> mBtnItemList;
    public Builder mBuilder;
    public FrameLayout mContent;
    public Context mContext;
    public View mDivider;
    public Object mTag;
    public ViewGroup mView;

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onItemClick(View view2);
    }

    public View createContentView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public static class BtnItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OnItemClickListener mOnItemClickListener;
        public CharSequence mSubText;
        public int mSubTextColorId;
        public CharSequence mText;
        public int mTextColorId;

        public BtnItem(CharSequence charSequence, int i, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, Integer.valueOf(i), onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTextColorId = -1;
            this.mSubTextColorId = -1;
            this.mText = charSequence;
            this.mTextColorId = i;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BtnItem(CharSequence charSequence, CharSequence charSequence2, int i, int i2, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, charSequence2, Integer.valueOf(i), Integer.valueOf(i2), onItemClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTextColorId = -1;
            this.mSubTextColorId = -1;
            this.mText = charSequence;
            this.mSubText = charSequence2;
            this.mTextColorId = i;
            this.mSubTextColorId = i2;
            this.mOnItemClickListener = onItemClickListener;
        }

        public void onItemClick(View view2) {
            OnItemClickListener onItemClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (onItemClickListener = this.mOnItemClickListener) != null) {
                onItemClickListener.onItemClick(view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<BtnItem> list;
        public AutoOrientationBtnActDialog mDialog;
        public String title;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.list = new ArrayList();
            this.mDialog = onCreateDialog();
        }

        public AutoOrientationBtnActDialog getDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mDialog;
            }
            return (AutoOrientationBtnActDialog) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public AutoOrientationBtnActDialog onCreateDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new AutoOrientationBtnActDialog();
            }
            return (AutoOrientationBtnActDialog) invokeV.objValue;
        }

        public AutoOrientationBtnActDialog show() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                AutoOrientationBtnActDialog dialog = getDialog();
                dialog.setBuilder(this);
                dialog.show();
                return dialog;
            }
            return (AutoOrientationBtnActDialog) invokeV.objValue;
        }

        public Builder setButton(BtnItem btnItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, btnItem)) == null) {
                if (btnItem != null) {
                    this.list.add(btnItem);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return setTitle(AppRuntime.getAppContext().getString(i));
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.title = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class ViewHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout button;
        public AutoOrientationBtnActDialog mDialog;
        public TextView subText;
        public TextView text;
        public final /* synthetic */ AutoOrientationBtnActDialog this$0;

        public ViewHelper(AutoOrientationBtnActDialog autoOrientationBtnActDialog, View view2, AutoOrientationBtnActDialog autoOrientationBtnActDialog2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoOrientationBtnActDialog, view2, autoOrientationBtnActDialog2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = autoOrientationBtnActDialog;
            if (view2 != null) {
                this.text = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fb9);
                this.subText = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fb8);
                this.button = (LinearLayout) view2;
                this.mDialog = autoOrientationBtnActDialog2;
            }
        }

        public void onBindView(BtnItem btnItem) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, btnItem) != null) || btnItem == null) {
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
            this.button.setOnClickListener(new View.OnClickListener(this, btnItem) { // from class: com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog.ViewHelper.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$item = btnItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        BdEventBus.Companion.getDefault().post(new BaseActivityDialog.Builder.DismissEventObject(this.this$1.this$0.mTag));
                        OnItemClickListener onItemClickListener = this.val$item.mOnItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(view2);
                        }
                    }
                }
            });
        }
    }

    public AutoOrientationBtnActDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBtnItemList = new ArrayList();
        this.mBreakPoint = 2;
        this.mTag = new Object();
    }

    private void create() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mContext = AppRuntime.getAppContext();
            this.mBaseActivityDialogBuilder = new BaseActivityDialog.Builder();
            createView();
            this.mBaseActivityDialogBuilder.setView(this.mView);
            this.mBaseActivityDialogBuilder.setTitle(this.mBuilder.getTitle());
            this.mBaseActivityDialogBuilder.setTag(this.mTag);
            this.mBaseActivityDialogBuilder.setHideBtnsPanel(true);
        }
    }

    private void setBtnItemList(List<BtnItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, list) == null) {
            this.mBtnItemList.clear();
            if (list != null) {
                this.mBtnItemList.addAll(list);
            }
        }
    }

    public void setBuilder(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder) == null) {
            this.mBuilder = builder;
            setBtnItemList(builder.list);
        }
    }

    private LinearLayout createButton(BtnItem btnItem, LinearLayout linearLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, btnItem, linearLayout)) == null) {
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0452, (ViewGroup) linearLayout, false);
            linearLayout2.setBackground(this.mContent.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080208));
            new ViewHelper(this, linearLayout2, this).onBindView(btnItem);
            return linearLayout2;
        }
        return (LinearLayout) invokeLL.objValue;
    }

    private void createButtonItem(List<BtnItem> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, this, list) != null) || list == null) {
            return;
        }
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

    private View createDivider(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            View view2 = new View(this.mContext);
            view2.setBackgroundColor(this.mContent.getResources().getColor(R.color.obfuscated_res_0x7f060716));
            if (i == 1) {
                view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view2.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    @SuppressLint({"InflateParams"})
    private void createView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d09b6, (ViewGroup) null);
            this.mView = viewGroup;
            this.mContent = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f090fba);
            this.mDivider = this.mView.findViewById(R.id.obfuscated_res_0x7f090fbb);
            this.mBtnContainer = (FrameLayout) this.mView.findViewById(R.id.obfuscated_res_0x7f090fb7);
            View createContentView = createContentView(this.mContent);
            if (createContentView != null) {
                this.mContent.addView(createContentView);
            }
            updateBackground();
            createButtonItem(this.mBtnItemList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            create();
            BaseActivityDialog.Builder builder = this.mBaseActivityDialogBuilder;
            if (builder != null) {
                builder.show();
            }
        }
    }

    private void updateBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mDivider.setBackgroundColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060716));
        }
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaseActivityDialog.Builder builder = this.mBaseActivityDialogBuilder;
            if (builder != null && builder.isShowing(this.mTag)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
