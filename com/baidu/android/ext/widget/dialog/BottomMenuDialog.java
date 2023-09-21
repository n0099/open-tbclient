package com.baidu.android.ext.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class BottomMenuDialog extends DialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isTitleShow;
    public OptionAdapter mAdapter;
    public String mBottomTxt;
    public TextView mBottomView;
    public ListView mListView;
    public OnClickItemListener mOnClickItemListener;
    public List<String> mOriginalData;
    public View mRootView;
    public String mTitle;
    public TextView mTitleView;

    /* loaded from: classes.dex */
    public interface OnClickItemListener {
        void onBottomClick();

        void onItemClick(int i, String str);
    }

    /* loaded from: classes.dex */
    public class OptionAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public List<String> mData;
        public final /* synthetic */ BottomMenuDialog this$0;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
        }

        public OptionAdapter(BottomMenuDialog bottomMenuDialog, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bottomMenuDialog, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bottomMenuDialog;
            this.mContext = null;
            this.mData = null;
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<String> list = this.mData;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                List<String> list = this.mData;
                if (list == null) {
                    return null;
                }
                return list.get(i);
            }
            return invokeI.objValue;
        }

        public void setData(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
                this.mData = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ViewHolder"})
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                View inflate = View.inflate(this.mContext, R.layout.bottom_menu_item, null);
                TextView textView = (TextView) inflate.findViewById(R.id.menu_item);
                textView.setTextColor(this.this$0.getResources().getColor(R.color.obfuscated_res_0x7f060768));
                List<String> list = this.mData;
                if (list != null && list.size() > i) {
                    textView.setText(this.mData.get(i));
                }
                return inflate;
            }
            return (View) invokeILL.objValue;
        }
    }

    public BottomMenuDialog() {
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
        this.mOriginalData = null;
        this.mOnClickItemListener = null;
    }

    private void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.android.ext.widget.dialog.BottomMenuDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomMenuDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.this$0.mOnClickItemListener != null) {
                        this.this$0.mOnClickItemListener.onItemClick(i, (String) this.this$0.mOriginalData.get(i));
                    }
                }
            });
            this.mBottomView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.dialog.BottomMenuDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomMenuDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.dismissAllowingStateLoss();
                        if (this.this$0.mOnClickItemListener != null) {
                            this.this$0.mOnClickItemListener.onBottomClick();
                        }
                    }
                }
            });
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            getView().setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.obfuscated_res_0x7f01004d));
            super.onStop();
        }
    }

    public void setBottomTxt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mBottomTxt = str;
            TextView textView = this.mBottomView;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public BottomMenuDialog setClickItemListener(OnClickItemListener onClickItemListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, onClickItemListener)) == null) {
            this.mOnClickItemListener = onClickItemListener;
            return this;
        }
        return (BottomMenuDialog) invokeL.objValue;
    }

    public void setMenuData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.mOriginalData = list;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mTitle = str;
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public void setTitleShow(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.isTitleShow = z;
            TextView textView = this.mTitleView;
            if (textView != null) {
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                textView.setVisibility(i);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            getDialog().requestWindowFeature(1);
            int i = 0;
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getDialog().getWindow().setWindowAnimations(R.style.obfuscated_res_0x7f1003e9);
            View inflate = layoutInflater.inflate(R.layout.bottom_menu_dialog, viewGroup);
            this.mRootView = inflate;
            inflate.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060ba2));
            TextView textView = (TextView) this.mRootView.findViewById(R.id.menu_title);
            this.mTitleView = textView;
            textView.setText(this.mTitle);
            this.mTitleView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0604a9));
            TextView textView2 = this.mTitleView;
            if (!this.isTitleShow) {
                i = 8;
            }
            textView2.setVisibility(i);
            TextView textView3 = (TextView) this.mRootView.findViewById(R.id.menu_bottom);
            this.mBottomView = textView3;
            textView3.setText(this.mBottomTxt);
            this.mBottomView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0604a9));
            this.mListView = (ListView) this.mRootView.findViewById(R.id.bottom_dialog_list);
            OptionAdapter optionAdapter = new OptionAdapter(this, getContext());
            this.mAdapter = optionAdapter;
            optionAdapter.setData(this.mOriginalData);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            this.mListView.setDivider(getResources().getDrawable(R.color.obfuscated_res_0x7f0604ff));
            this.mListView.setDividerHeight(1);
            this.mListView.setSelector(R.drawable.obfuscated_res_0x7f0803a4);
            this.mRootView.findViewById(R.id.header_devider).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0604ff));
            this.mRootView.findViewById(R.id.bottom_devider).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0604fe));
            this.mBottomView.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0803a4));
            setup();
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onStart();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            getDialog().getWindow().setLayout(displayMetrics.widthPixels, getDialog().getWindow().getAttributes().height);
            WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
            attributes.gravity = 80;
            getDialog().getWindow().setAttributes(attributes);
        }
    }
}
