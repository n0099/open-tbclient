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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.ecommerce.view.addressdialog.ElementNode;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.sapi2.ecommerce.result.AddressBean;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        public AddressSelectorHolder(@NonNull View view, boolean z) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mItemView = view;
            this.mLlAddressItem = (RelativeLayout) view.findViewById(R.id.sapi_sdk_rl_address_item);
            this.mTvCityCategory = (TextView) view.findViewById(R.id.sapi_sdk_tv_address_category);
            this.mTvAddressPy = (TextView) view.findViewById(R.id.sapi_sdk_tv_address_py);
            this.mTvAddressName = (TextView) view.findViewById(R.id.sapi_sdk_tv_address_name);
            this.mTvAddressHot = (TextView) view.findViewById(R.id.sapi_sdk_tv_address_hot);
            this.mLlHotGroup = (LinearLayout) view.findViewById(R.id.sapi_sdk_ll_address_hot_group);
            this.mTvAddressChecked = (ImageView) view.findViewById(R.id.sapi_sdk_tv_address_check);
            Resources resources = view.getContext().getResources();
            if (z) {
                this.mTvAddressHot.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_py_text_dark_color));
                this.mTvCityCategory.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_py_text_dark_color));
                this.mTvAddressPy.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_py_text_dark_color));
                this.mTvAddressName.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_text_dark_color));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface OnAddressSelectedListener {
        void onAddressSelected(int i2, AddressBean addressBean);
    }

    /* loaded from: classes5.dex */
    public interface OnHotCitySelectedListener {
        void onHotCitySelected(AddressBean addressBean);
    }

    public AddressSelectorAdapter(Context context, boolean z, ElementNode elementNode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), elementNode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.isDarkMode = z;
        this.mEntity = optEntity(elementNode);
    }

    private void createHotViewByData(LinearLayout linearLayout, List<AddressBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, linearLayout, list) == null) {
            linearLayout.removeAllViews();
            if (list.size() > 8) {
                list = list.subList(0, 8);
            }
            int size = list.size() / 4;
            for (int i2 = 0; i2 < size; i2++) {
                LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout2.setPadding((int) this.mContext.getResources().getDimension(R.dimen.sapi_sdk_address_dialog_item_hot_group_top_padding), 0, (int) this.mContext.getResources().getDimension(R.dimen.sapi_sdk_address_dialog_item_hot_group_top_padding), 0);
                for (int i3 = 0; i3 < 4; i3++) {
                    AddressBean addressBean = list.get((i2 * 4) + i3);
                    if (addressBean != null) {
                        TextView textView = new TextView(this.mContext);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.mContext.getResources().getDimension(R.dimen.sapi_sdk_address_dialog_item_hot_group_text_width), (int) this.mContext.getResources().getDimension(R.dimen.sapi_sdk_address_dialog_item_hot_group_text_height));
                        layoutParams.bottomMargin = (int) this.mContext.getResources().getDimension(R.dimen.sapi_sdk_address_dialog_item_hot_group_text_top_margin);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextSize(1, 13.0f);
                        textView.setClickable(true);
                        if (addressBean.isHotSelected) {
                            if (this.isDarkMode) {
                                textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.sapi_sdk_dialog_address_nearby_city_bg_selected_dark));
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_hot_city_text_selected_dark));
                            } else {
                                textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.sapi_sdk_dialog_address_nearby_city_bg_selected));
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_hot_city_text_selected));
                            }
                        } else if (this.isDarkMode) {
                            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.sapi_sdk_dialog_address_nearby_city_dark_bg));
                            textView.setTextColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_hot_city_text_dark));
                        } else {
                            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.sapi_sdk_dialog_address_nearby_city_bg));
                            textView.setTextColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_hot_city_text));
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
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$addressBean = addressBean;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.mOnHotCitySelectedListener == null) {
                                    return;
                                }
                                this.this$0.mOnHotCitySelectedListener.onHotCitySelected(this.val$addressBean);
                            }
                        });
                        linearLayout2.addView(textView);
                        if (i3 != 3) {
                            View view = new View(this.mContext);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
                            layoutParams2.weight = 1.0f;
                            view.setLayoutParams(layoutParams2);
                            linearLayout2.addView(view);
                        }
                    }
                }
                linearLayout.addView(linearLayout2);
            }
        }
    }

    private void findHotSelected(ElementNode elementNode, AddressBean addressBean) {
        ElementNode elementNode2;
        ElementNode.AddressEntity addressEntity;
        ElementNode.AddressEntity addressEntity2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, elementNode, addressBean) == null) {
            ElementNode moveHeader = ElementNode.moveHeader(elementNode);
            String str = (moveHeader == null || (addressEntity2 = moveHeader.addressEntity) == null) ? "" : addressEntity2.selectedId;
            String str2 = (moveHeader == null || (elementNode2 = moveHeader.next) == null || (addressEntity = elementNode2.addressEntity) == null) ? "" : addressEntity.selectedId;
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (str == null) {
                str = "";
            }
            String str3 = str2 != null ? str2 : "";
            for (AddressBean addressBean2 : addressBean.hotlists) {
                addressBean2.isHotSelected = str.equals(addressBean2.id) || (str.equals(addressBean2.pid) && str3.equals(addressBean2.id));
            }
        }
    }

    private ElementNode.AddressEntity optEntity(ElementNode elementNode) {
        InterceptResult invokeL;
        ElementNode.AddressEntity addressEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, elementNode)) == null) {
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

    private void optHotListItem(ElementNode elementNode, List<AddressBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, elementNode, list) == null) {
            List<AddressBean> list2 = elementNode.addressEntity.hotlists;
            AddressBean addressBean = list.get(0);
            if (list2 == null || list2.isEmpty()) {
                return;
            }
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

    private void optNotSelectedItem(List<AddressBean> list) {
        AddressBean addressBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, list) == null) || (addressBean = list.get(0)) == null || addressBean.hasLeaf || addressBean.isNotSelected) {
            return;
        }
        AddressBean addressBean2 = new AddressBean();
        addressBean2.id = "-1";
        addressBean2.name = "暂不选择";
        addressBean2.isNotSelected = true;
        list.add(0, addressBean2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        List<AddressBean> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ElementNode.AddressEntity addressEntity = this.mEntity;
            if (addressEntity == null || (list = addressEntity.list) == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull AddressSelectorHolder addressSelectorHolder, @SuppressLint({"RecyclerView"}) int i2) {
        ElementNode.AddressEntity addressEntity;
        List<AddressBean> list;
        AddressBean addressBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, addressSelectorHolder, i2) == null) || (addressEntity = this.mEntity) == null || (list = addressEntity.list) == null || list.size() == 0 || (addressBean = list.get(i2)) == null) {
            return;
        }
        List<AddressBean> list2 = addressBean.hotlists;
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
            textView.setText(str == null ? "" : str.toUpperCase());
            addressSelectorHolder.mTvAddressPy.setVisibility(addressBean.isShowPy ? 0 : 8);
            TextView textView2 = addressSelectorHolder.mTvAddressName;
            String str2 = addressBean.name;
            textView2.setText(str2 != null ? str2 : "");
            String str3 = this.mEntity.selectedId;
            if (str3 != null && str3.equals(addressBean.id)) {
                if (this.isDarkMode) {
                    addressSelectorHolder.mLlAddressItem.setBackgroundColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_item_selected_dark_bg));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_item_address_selected_text_dark_color));
                } else {
                    addressSelectorHolder.mLlAddressItem.setBackgroundColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_item_selected_bg));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_item_address_selected_text_color));
                }
                addressSelectorHolder.mTvAddressChecked.setVisibility(0);
                addressSelectorHolder.mTvAddressChecked.setColorFilter(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_item_address_selected_text_color));
            } else {
                if (this.isDarkMode) {
                    addressSelectorHolder.mLlAddressItem.setBackground(this.mContext.getResources().getDrawable(R.drawable.sapi_sdk_addr_selector_item_bg_dark));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_item_address_text_dark_color));
                } else {
                    addressSelectorHolder.mLlAddressItem.setBackground(this.mContext.getResources().getDrawable(R.drawable.sapi_sdk_addr_selector_item_bg));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_item_address_text_color));
                }
                addressSelectorHolder.mTvAddressChecked.setVisibility(8);
            }
            addressSelectorHolder.mLlAddressItem.setOnClickListener(new View.OnClickListener(this, i2, addressBean) { // from class: com.baidu.pass.ecommerce.adapter.AddressSelectorAdapter.1
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
                        Object[] objArr = {this, Integer.valueOf(i2), addressBean};
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
                    this.val$position = i2;
                    this.val$addressBean = addressBean;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.mOnAddressSelectedListener == null) {
                        return;
                    }
                    this.this$0.mOnAddressSelectedListener.onAddressSelected(this.val$position, this.val$addressBean);
                }
            });
        }
        if (this.mHasHotList) {
            addressSelectorHolder.mTvCityCategory.setVisibility(i2 != 1 ? 8 : 0);
        } else {
            addressSelectorHolder.mTvCityCategory.setVisibility(i2 != 0 ? 8 : 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public AddressSelectorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) ? new AddressSelectorHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_sapi_sdk_item_address_selector, viewGroup, false), this.isDarkMode) : (AddressSelectorHolder) invokeLI.objValue;
    }
}
