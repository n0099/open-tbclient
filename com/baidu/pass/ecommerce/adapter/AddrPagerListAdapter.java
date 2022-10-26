package com.baidu.pass.ecommerce.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
public class AddrPagerListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int POSITION_HOT_CITY = -1;
    public static final String VALUE_NOT_SELECTED_ID = "-1";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDarkMode;
    public Context mContext;
    public ElementNode.AddressEntity mEntity;
    public boolean mHasHotList;
    public String mHotCityId;
    public boolean mHotCitySelected;
    public OnAddressSelectedListener mOnAddressSelectedListener;

    /* loaded from: classes2.dex */
    public interface OnAddressSelectedListener {
        void onAddressSelected(int i, AddressBean addressBean);
    }

    /* loaded from: classes2.dex */
    public class AddressSelectorHolder extends RecyclerView.ViewHolder {
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
        public AddressSelectorHolder(View view2, boolean z) {
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
            this.mLlAddressItem = (RelativeLayout) view2.findViewById(R.id.sapi_sdk_rl_address_item);
            this.mTvCityCategory = (TextView) view2.findViewById(R.id.sapi_sdk_tv_address_category);
            this.mTvAddressPy = (TextView) view2.findViewById(R.id.sapi_sdk_tv_address_py);
            this.mTvAddressName = (TextView) view2.findViewById(R.id.sapi_sdk_tv_address_name);
            this.mTvAddressHot = (TextView) view2.findViewById(R.id.sapi_sdk_tv_address_hot);
            this.mLlHotGroup = (LinearLayout) view2.findViewById(R.id.sapi_sdk_ll_address_hot_group);
            this.mTvAddressChecked = (ImageView) view2.findViewById(R.id.sapi_sdk_tv_address_check);
            Resources resources = view2.getContext().getResources();
            if (z) {
                this.mTvAddressHot.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_py_text_dark_color));
                this.mTvCityCategory.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_py_text_dark_color));
                this.mTvAddressPy.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_py_text_dark_color));
                this.mTvAddressName.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_text_dark_color));
            }
        }
    }

    public AddrPagerListAdapter(Context context, boolean z, ElementNode.AddressEntity addressEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), addressEntity};
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
        this.mEntity = optEntity(addressEntity);
    }

    private ElementNode.AddressEntity optEntity(ElementNode.AddressEntity addressEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, addressEntity)) == null) {
            this.mHasHotList = false;
            if (addressEntity == null) {
                return null;
            }
            List list = addressEntity.list;
            if (list != null && list.size() != 0) {
                optNotSelectedItem(list);
                optHotListItem(addressEntity, list);
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

    public void setEntity(ElementNode.AddressEntity addressEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, addressEntity) == null) {
            this.mEntity = optEntity(addressEntity);
        }
    }

    public void setHotCityId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mHotCityId = str;
        }
    }

    private void createHotViewByData(LinearLayout linearLayout, List list) {
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
                linearLayout2.setPadding((int) this.mContext.getResources().getDimension(R.dimen.sapi_sdk_address_dialog_item_hot_group_top_padding), 0, (int) this.mContext.getResources().getDimension(R.dimen.sapi_sdk_address_dialog_item_hot_group_top_padding), 0);
                for (int i2 = 0; i2 < 4; i2++) {
                    AddressBean addressBean = (AddressBean) list.get((i * 4) + i2);
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
                        textView.setOnClickListener(new View.OnClickListener(this, addressBean) { // from class: com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AddrPagerListAdapter this$0;
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
                                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) || this.this$0.mOnAddressSelectedListener == null) {
                                    return;
                                }
                                this.this$0.mHotCitySelected = true;
                                this.this$0.mOnAddressSelectedListener.onAddressSelected(-1, this.val$addressBean);
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
    public void onBindViewHolder(AddressSelectorHolder addressSelectorHolder, int i) {
        ElementNode.AddressEntity addressEntity;
        List list;
        AddressBean addressBean;
        String upperCase;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, addressSelectorHolder, i) != null) || (addressEntity = this.mEntity) == null || (list = addressEntity.list) == null || list.size() == 0 || (addressBean = (AddressBean) list.get(i)) == null) {
            return;
        }
        List list2 = addressBean.hotlists;
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
            addressSelectorHolder.mLlAddressItem.setOnClickListener(new View.OnClickListener(this, i, addressBean) { // from class: com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddrPagerListAdapter this$0;
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
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) || this.this$0.mOnAddressSelectedListener == null) {
                        return;
                    }
                    this.this$0.mHotCitySelected = false;
                    this.this$0.mOnAddressSelectedListener.onAddressSelected(this.val$position, this.val$addressBean);
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

    private void findHotSelected(AddressBean addressBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, addressBean) == null) {
            if (this.mHotCitySelected) {
                for (AddressBean addressBean2 : addressBean.hotlists) {
                    addressBean2.isHotSelected = this.mHotCityId.equals(addressBean2.id);
                }
                return;
            }
            for (AddressBean addressBean3 : addressBean.hotlists) {
                addressBean3.isHotSelected = false;
            }
        }
    }

    private void optNotSelectedItem(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, list) == null) {
            try {
                AddressBean addressBean = (AddressBean) list.get(list.size() - 1);
                if (addressBean != null && !addressBean.hasLeaf && !addressBean.isNotSelected) {
                    AddressBean addressBean2 = new AddressBean();
                    addressBean2.id = "-1";
                    addressBean2.name = "暂不选择";
                    addressBean2.type = addressBean.type;
                    addressBean2.isNotSelected = true;
                    list.add(addressBean2);
                }
            } catch (Exception e) {
                Log.e(e.getMessage(), new Object[0]);
            }
        }
    }

    private void optHotListItem(ElementNode.AddressEntity addressEntity, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, addressEntity, list) == null) {
            List list2 = addressEntity.hotlists;
            AddressBean addressBean = (AddressBean) list.get(0);
            if (list2 != null && !list2.isEmpty()) {
                if (addressBean.hotlists != null) {
                    findHotSelected(addressBean);
                    return;
                }
                AddressBean addressBean2 = new AddressBean();
                addressBean2.hotlists = list2;
                addressBean2.hasLeaf = true;
                list.add(0, addressBean2);
                this.mHasHotList = true;
                findHotSelected(addressBean2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        List list;
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
    public AddressSelectorHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            return new AddressSelectorHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_sapi_sdk_item_address_selector, viewGroup, false), this.isDarkMode);
        }
        return (AddressSelectorHolder) invokeLI.objValue;
    }
}
