package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ListBtnDialog extends BoxAlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListBtnAdapter mAdapter;
    public FrameLayout mContentView;
    public List<ListBtnData> mDataList;
    public boolean mDayOrNight;
    public ListView mListView;
    public View mView;

    public View createContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class Builder extends BoxAlertDialog.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ListBtnData> mDataList;
        public boolean mDayOrNight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDataList = new ArrayList();
            this.mDayOrNight = true;
        }

        public Builder addListBtnItem(CharSequence charSequence, int i, int[] iArr, AdapterView.OnItemClickListener onItemClickListener) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048576, this, charSequence, i, iArr, onItemClickListener)) == null) {
                this.mDataList.add(i, new ListBtnData(charSequence, iArr, onItemClickListener));
                return this;
            }
            return (Builder) invokeLILL.objValue;
        }

        public Builder addListBtnItem(CharSequence charSequence, AdapterView.OnItemClickListener onItemClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, onItemClickListener)) == null) {
                this.mDataList.add(new ListBtnData(charSequence, onItemClickListener));
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addListBtnItem(CharSequence charSequence, int[] iArr, AdapterView.OnItemClickListener onItemClickListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, iArr, onItemClickListener)) == null) {
                this.mDataList.add(new ListBtnData(charSequence, iArr, onItemClickListener));
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ListBtnDialog listBtnDialog = (ListBtnDialog) super.create();
                listBtnDialog.setListBtnItems(this.mDataList);
                listBtnDialog.setDayOrNight(this.mDayOrNight);
                return listBtnDialog;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog onCreateDialog(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                return new ListBtnDialog(context);
            }
            return (BoxAlertDialog) invokeL.objValue;
        }

        public Builder setListBtnItems(List<ListBtnData> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
                this.mDataList.clear();
                if (list != null) {
                    this.mDataList.addAll(list);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog show(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.mDayOrNight = z;
                return super.show(z);
            }
            return (BoxAlertDialog) invokeZ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class ListBtnAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ListBtnDialog this$0;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
        }

        public ListBtnAdapter(ListBtnDialog listBtnDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listBtnDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listBtnDialog;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return this.this$0.mDataList.get(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.this$0.mDataList.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                ListBtnData listBtnData = (ListBtnData) this.this$0.mDataList.get(i);
                if (view2 == null) {
                    textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_btn_dialog_btn_item_view, viewGroup, false);
                } else {
                    textView = (TextView) view2;
                }
                if (listBtnData == null) {
                    return null;
                }
                Resources resources = textView.getContext().getResources();
                if (this.this$0.mDayOrNight) {
                    textView.setTextColor(textView.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06071f));
                    textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080209);
                    if (listBtnData.getTextDayColor() != -1) {
                        textView.setTextColor(resources.getColor(listBtnData.getTextDayColor()));
                    }
                } else {
                    textView.setTextColor(textView.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06071e));
                    textView.setBackgroundResource(R.drawable.alertdialog_button_night_bg_all_selector);
                    if (listBtnData.getTextNightColor() != -1) {
                        textView.setTextColor(resources.getColor(listBtnData.getTextNightColor()));
                    }
                }
                textView.setText(listBtnData.getText());
                textView.setTag(listBtnData);
                return textView;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ListBtnData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mDayColorId;
        public int mNightColorId;
        public AdapterView.OnItemClickListener mOnItemClickListener;
        public CharSequence mText;

        public ListBtnData(CharSequence charSequence, AdapterView.OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDayColorId = -1;
            this.mNightColorId = -1;
            this.mText = charSequence;
            this.mOnItemClickListener = onItemClickListener;
        }

        public ListBtnData(CharSequence charSequence, int[] iArr, AdapterView.OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, iArr, onItemClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mDayColorId = -1;
            this.mNightColorId = -1;
            this.mText = charSequence;
            if (iArr != null && iArr.length == 2) {
                this.mDayColorId = iArr[0];
                this.mNightColorId = iArr[1];
            }
            this.mOnItemClickListener = onItemClickListener;
        }

        public CharSequence getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mText;
            }
            return (CharSequence) invokeV.objValue;
        }

        public int getTextDayColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDayColorId;
            }
            return invokeV.intValue;
        }

        public int getTextNightColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mNightColorId;
            }
            return invokeV.intValue;
        }

        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            AdapterView.OnItemClickListener onItemClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onItemClickListener = this.mOnItemClickListener) != null) {
                onItemClickListener.onItemClick(adapterView, view2, i, j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListBtnDialog(Context context) {
        super(context, R.style.obfuscated_res_0x7f10014f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataList = new ArrayList();
        this.mDayOrNight = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListBtnDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDataList = new ArrayList();
        this.mDayOrNight = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDayOrNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            this.mDayOrNight = z;
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            createListBtnContentView();
            getBuilder().setView(this.mView);
        }
    }

    public void setListBtnItems(List<ListBtnData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.mDataList.clear();
            if (list != null) {
                this.mDataList.addAll(list);
            }
            ListBtnAdapter listBtnAdapter = this.mAdapter;
            if (listBtnAdapter != null) {
                listBtnAdapter.notifyDataSetChanged();
            }
        }
    }

    private void createListBtnContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.list_btn_dialog_content_view, getBuilder().getCustomContentParent(), false);
            this.mView = inflate;
            this.mContentView = (FrameLayout) inflate.findViewById(R.id.list_btn_dialog_content);
            this.mListView = (ListView) this.mView.findViewById(R.id.list_btn_dialog_listview);
            View findViewById = this.mView.findViewById(R.id.list_btn_divider);
            ListBtnAdapter listBtnAdapter = new ListBtnAdapter();
            this.mAdapter = listBtnAdapter;
            this.mListView.setAdapter((ListAdapter) listBtnAdapter);
            this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.android.ext.widget.dialog.ListBtnDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ListBtnDialog this$0;

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
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        ListBtnData listBtnData = (ListBtnData) view2.getTag();
                        this.this$0.dismiss();
                        if (listBtnData != null) {
                            listBtnData.onItemClick(adapterView, view2, i, j);
                        }
                    }
                }
            });
            findViewById.setBackgroundColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f06071c));
            this.mListView.setDivider(new ColorDrawable(getContext().getResources().getColor(R.color.obfuscated_res_0x7f06071c)));
            this.mListView.setDividerHeight(1);
            View createContentView = createContentView();
            if (createContentView != null) {
                this.mContentView.addView(createContentView);
            }
        }
    }

    public void notifyAdapter() {
        ListBtnAdapter listBtnAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (listBtnAdapter = this.mAdapter) != null) {
            listBtnAdapter.notifyDataSetChanged();
        }
    }
}
