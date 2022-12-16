package com.baidu.pass.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.view.addressdialog.ElementNode;
import com.baidu.sapi2.ecommerce.result.AddressBean;
import com.baidu.sapi2.utils.Log;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class AddressSelectorAdapter extends RecyclerView.Adapter<AddressSelectorHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String VALUE_NOT_SELECTED_ID = "-1";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDarkMode;
    public Context mContext;
    public ElementNode.AddressEntity mEntity;
    public boolean mHasHotList;
    public OnAddressSelectedListener mOnAddressSelectedListener;
    public OnHotCitySelectedListener mOnHotCitySelectedListener;

    /* loaded from: classes2.dex */
    public interface OnAddressSelectedListener {
        void onAddressSelected(int i, AddressBean addressBean);
    }

    /* loaded from: classes2.dex */
    public interface OnHotCitySelectedListener {
        void onHotCitySelected(AddressBean addressBean);
    }

    /* loaded from: classes2.dex */
    public static class AddressSelectorHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View mItemView;
        public RelativeLayout mLlAddressItem;
        public LinearLayout mLlHotGroup;
        public ImageView mTvAddressChecked;
        public TextView mTvAddressHot;
        public TextView mTvAddressName;
        public TextView mTvAddressPy;
        public TextView mTvCityCategory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddressSelectorHolder(@NonNull View view2, boolean z) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mItemView = view2;
            this.mLlAddressItem = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e33);
            this.mTvCityCategory = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e4e);
            this.mTvAddressPy = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e52);
            this.mTvAddressName = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e51);
            this.mTvAddressHot = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e50);
            this.mLlHotGroup = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e10);
            this.mTvAddressChecked = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e4f);
            Resources resources = view2.getContext().getResources();
            if (z) {
                this.mTvAddressHot.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a06));
                this.mTvCityCategory.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a06));
                this.mTvAddressPy.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a06));
                this.mTvAddressName.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a0a));
            }
        }
    }

    public AddressSelectorAdapter(Context context, boolean z, ElementNode elementNode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), elementNode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.isDarkMode = z;
        this.mEntity = optEntity(elementNode);
    }

    private ElementNode.AddressEntity optEntity(ElementNode elementNode) {
        InterceptResult invokeL;
        ElementNode.AddressEntity addressEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, elementNode)) == null) {
            this.mHasHotList = false;
            if (elementNode == null || (addressEntity = elementNode.addressEntity) == null) {
                return null;
            }
            List<AddressBean> list = addressEntity.list;
            if (list != null && list.size() != 0) {
                optNotSelectedItem(list);
                optHotListItem(elementNode, list);
            }
            return addressEntity;
        }
        return (ElementNode.AddressEntity) invokeL.objValue;
    }

    public void setAddressSelectedListener(OnAddressSelectedListener onAddressSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onAddressSelectedListener) == null) {
            this.mOnAddressSelectedListener = onAddressSelectedListener;
        }
    }

    public void setEntity(ElementNode elementNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, elementNode) == null) {
            this.mEntity = optEntity(elementNode);
        }
    }

    public void setOnHotCitySelectedListener(OnHotCitySelectedListener onHotCitySelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onHotCitySelectedListener) == null) {
            this.mOnHotCitySelectedListener = onHotCitySelectedListener;
        }
    }

    private void createHotViewByData(LinearLayout linearLayout, List<AddressBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, linearLayout, list) == null) {
            linearLayout.removeAllViews();
            if (list.size() > 8) {
                list = list.subList(0, 8);
            }
            int size = list.size() / 4;
            for (int i = 0; i < size; i++) {
                LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout2.setPadding((int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070619), 0, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070619), 0);
                for (int i2 = 0; i2 < 4; i2++) {
                    AddressBean addressBean = list.get((i * 4) + i2);
                    if (addressBean != null) {
                        TextView textView = new TextView(this.mContext);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070618), (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070616));
                        layoutParams.bottomMargin = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070617);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextSize(1, 13.0f);
                        textView.setClickable(true);
                        if (addressBean.isHotSelected) {
                            if (this.isDarkMode) {
                                textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810b6));
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609ff));
                            } else {
                                textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810b5));
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609fe));
                            }
                        } else if (this.isDarkMode) {
                            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810b7));
                            textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609fd));
                        } else {
                            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810b4));
                            textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609fc));
                        }
                        textView.setGravity(17);
                        textView.setText(addressBean.name);
                        textView.setOnClickListener(new View.OnClickListener(this, addressBean) { // from class: com.baidu.pass.ecommerce.adapter.AddressSelectorAdapter.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AddressSelectorAdapter this$0;
                            public final /* synthetic */ AddressBean val$addressBean;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, addressBean};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$addressBean = addressBean;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.this$0.mOnHotCitySelectedListener != null) {
                                    this.this$0.mOnHotCitySelectedListener.onHotCitySelected(this.val$addressBean);
                                }
                            }
                        });
                        linearLayout2.addView(textView);
                        if (i2 != 3) {
                            View view2 = new View(this.mContext);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
                            layoutParams2.weight = 1.0f;
                            view2.setLayoutParams(layoutParams2);
                            linearLayout2.addView(view2);
                        }
                    }
                }
                linearLayout.addView(linearLayout2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull AddressSelectorHolder addressSelectorHolder, @SuppressLint({"RecyclerView"}) int i) {
        ElementNode.AddressEntity addressEntity;
        List<AddressBean> list;
        AddressBean addressBean;
        String upperCase;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, addressSelectorHolder, i) != null) || (addressEntity = this.mEntity) == null || (list = addressEntity.list) == null || list.size() == 0 || (addressBean = list.get(i)) == null) {
            return;
        }
        List<AddressBean> list2 = addressBean.hotlists;
        int i3 = 0;
        if (list2 != null && !list2.isEmpty()) {
            addressSelectorHolder.mLlAddressItem.setVisibility(8);
            addressSelectorHolder.mTvAddressHot.setVisibility(0);
            addressSelectorHolder.mLlHotGroup.setVisibility(0);
            createHotViewByData(addressSelectorHolder.mLlHotGroup, addressBean.hotlists);
        } else {
            addressSelectorHolder.mTvAddressHot.setVisibility(8);
            addressSelectorHolder.mLlHotGroup.setVisibility(8);
            addressSelectorHolder.mLlAddressItem.setVisibility(0);
            TextView textView = addressSelectorHolder.mTvAddressPy;
            String str = addressBean.namePyInit;
            String str2 = "";
            if (str == null) {
                upperCase = "";
            } else {
                upperCase = str.toUpperCase();
            }
            textView.setText(upperCase);
            TextView textView2 = addressSelectorHolder.mTvAddressPy;
            if (addressBean.isShowPy) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView2.setVisibility(i2);
            TextView textView3 = addressSelectorHolder.mTvAddressName;
            String str3 = addressBean.name;
            if (str3 != null) {
                str2 = str3;
            }
            textView3.setText(str2);
            String str4 = this.mEntity.selectedId;
            if (str4 != null && str4.equals(addressBean.id)) {
                if (this.isDarkMode) {
                    addressSelectorHolder.mLlAddressItem.setBackgroundColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060a0e));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060a08));
                } else {
                    addressSelectorHolder.mLlAddressItem.setBackgroundColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060a0d));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060a07));
                }
                addressSelectorHolder.mTvAddressChecked.setVisibility(0);
                addressSelectorHolder.mTvAddressChecked.setColorFilter(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060a07));
            } else {
                if (this.isDarkMode) {
                    addressSelectorHolder.mLlAddressItem.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08108c));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060a0a));
                } else {
                    addressSelectorHolder.mLlAddressItem.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08108b));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060a09));
                }
                addressSelectorHolder.mTvAddressChecked.setVisibility(8);
            }
            addressSelectorHolder.mLlAddressItem.setOnClickListener(new View.OnClickListener(this, i, addressBean) { // from class: com.baidu.pass.ecommerce.adapter.AddressSelectorAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressSelectorAdapter this$0;
                public final /* synthetic */ AddressBean val$addressBean;
                public final /* synthetic */ int val$position;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), addressBean};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$position = i;
                    this.val$addressBean = addressBean;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.this$0.mOnAddressSelectedListener != null) {
                        this.this$0.mOnAddressSelectedListener.onAddressSelected(this.val$position, this.val$addressBean);
                    }
                }
            });
        }
        if (this.mHasHotList) {
            TextView textView4 = addressSelectorHolder.mTvCityCategory;
            if (i != 1) {
                i3 = 8;
            }
            textView4.setVisibility(i3);
            return;
        }
        TextView textView5 = addressSelectorHolder.mTvCityCategory;
        if (i != 0) {
            i3 = 8;
        }
        textView5.setVisibility(i3);
    }

    private void findHotSelected(ElementNode elementNode, AddressBean addressBean) {
        String str;
        String str2;
        boolean z;
        ElementNode elementNode2;
        ElementNode.AddressEntity addressEntity;
        ElementNode.AddressEntity addressEntity2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, elementNode, addressBean) == null) {
            ElementNode moveHeader = ElementNode.moveHeader(elementNode);
            String str3 = "";
            if (moveHeader == null || (addressEntity2 = moveHeader.addressEntity) == null) {
                str = "";
            } else {
                str = addressEntity2.selectedId;
            }
            if (moveHeader == null || (elementNode2 = moveHeader.next) == null || (addressEntity = elementNode2.addressEntity) == null) {
                str2 = "";
            } else {
                str2 = addressEntity.selectedId;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (str == null) {
                str = "";
            }
            if (str2 != null) {
                str3 = str2;
            }
            for (AddressBean addressBean2 : addressBean.hotlists) {
                if (!str.equals(addressBean2.id) && (!str.equals(addressBean2.pid) || !str3.equals(addressBean2.id))) {
                    z = false;
                } else {
                    z = true;
                }
                addressBean2.isHotSelected = z;
            }
        }
    }

    private void optHotListItem(ElementNode elementNode, List<AddressBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, elementNode, list) == null) {
            List<AddressBean> list2 = elementNode.addressEntity.hotlists;
            AddressBean addressBean = list.get(0);
            if (list2 != null && !list2.isEmpty()) {
                if (addressBean.hotlists != null) {
                    findHotSelected(elementNode, addressBean);
                    return;
                }
                AddressBean addressBean2 = new AddressBean();
                addressBean2.hotlists = list2;
                addressBean2.hasLeaf = true;
                list.add(0, addressBean2);
                this.mHasHotList = true;
                findHotSelected(elementNode, addressBean2);
            }
        }
    }

    private void optNotSelectedItem(List<AddressBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, list) == null) {
            try {
                AddressBean addressBean = list.get(list.size() - 1);
                if (addressBean != null && !addressBean.hasLeaf && !addressBean.isNotSelected) {
                    AddressBean addressBean2 = new AddressBean();
                    addressBean2.id = "-1";
                    addressBean2.name = "暂不选择";
                    addressBean2.isNotSelected = true;
                    list.add(0, addressBean2);
                }
            } catch (Exception e) {
                Log.e(e.getMessage(), new Object[0]);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        List<AddressBean> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ElementNode.AddressEntity addressEntity = this.mEntity;
            if (addressEntity != null && (list = addressEntity.list) != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public AddressSelectorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            return new AddressSelectorHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d051b, viewGroup, false), this.isDarkMode);
        }
        return (AddressSelectorHolder) invokeLI.objValue;
    }
}
