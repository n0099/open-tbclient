package com.baidu.pass.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class AddrPagerListAdapter extends RecyclerView.Adapter<AddressSelectorHolder> {
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
            this.mLlAddressItem = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091bad);
            this.mTvCityCategory = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bc8);
            this.mTvAddressPy = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bcc);
            this.mTvAddressName = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bcb);
            this.mTvAddressHot = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bca);
            this.mLlHotGroup = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b92);
            this.mTvAddressChecked = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bc9);
            Resources resources = view2.getContext().getResources();
            if (z) {
                this.mTvAddressHot.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609ca));
                this.mTvCityCategory.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609ca));
                this.mTvAddressPy.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609ca));
                this.mTvAddressName.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609ce));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OnAddressSelectedListener {
        void onAddressSelected(int i, AddressBean addressBean);
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
                linearLayout2.setPadding((int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705bc), 0, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705bc), 0);
                for (int i2 = 0; i2 < 4; i2++) {
                    AddressBean addressBean = list.get((i * 4) + i2);
                    if (addressBean != null) {
                        TextView textView = new TextView(this.mContext);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705bb), (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705b9));
                        layoutParams.bottomMargin = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705ba);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextSize(1, 13.0f);
                        textView.setClickable(true);
                        if (addressBean.isHotSelected) {
                            if (this.isDarkMode) {
                                textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081020));
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609c1));
                            } else {
                                textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08101f));
                                textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609c0));
                            }
                        } else if (this.isDarkMode) {
                            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081021));
                            textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609bf));
                        } else {
                            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08101e));
                            textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609be));
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
                                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.this$0.mOnAddressSelectedListener == null) {
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

    private ElementNode.AddressEntity optEntity(ElementNode.AddressEntity addressEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, addressEntity)) == null) {
            this.mHasHotList = false;
            if (addressEntity == null) {
                return null;
            }
            List<AddressBean> list = addressEntity.list;
            if (list != null && list.size() != 0) {
                optNotSelectedItem(list);
                optHotListItem(addressEntity, list);
            }
            return addressEntity;
        }
        return (ElementNode.AddressEntity) invokeL.objValue;
    }

    private void optHotListItem(ElementNode.AddressEntity addressEntity, List<AddressBean> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, addressEntity, list) == null) {
            List<AddressBean> list2 = addressEntity.hotlists;
            AddressBean addressBean = list.get(0);
            if (list2 == null || list2.isEmpty()) {
                return;
            }
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

    private void optNotSelectedItem(List<AddressBean> list) {
        AddressBean addressBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, list) == null) || (addressBean = list.get(0)) == null || addressBean.hasLeaf || addressBean.isNotSelected) {
            return;
        }
        AddressBean addressBean2 = new AddressBean();
        addressBean2.id = "-1";
        addressBean2.name = "暂不选择";
        addressBean2.type = addressBean.type;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull AddressSelectorHolder addressSelectorHolder, @SuppressLint({"RecyclerView"}) int i) {
        ElementNode.AddressEntity addressEntity;
        List<AddressBean> list;
        AddressBean addressBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, addressSelectorHolder, i) == null) || (addressEntity = this.mEntity) == null || (list = addressEntity.list) == null || list.size() == 0 || (addressBean = list.get(i)) == null) {
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
                    addressSelectorHolder.mLlAddressItem.setBackgroundColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609d2));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609cc));
                } else {
                    addressSelectorHolder.mLlAddressItem.setBackgroundColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609d1));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609cb));
                }
                addressSelectorHolder.mTvAddressChecked.setVisibility(0);
                addressSelectorHolder.mTvAddressChecked.setColorFilter(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609cb));
            } else {
                if (this.isDarkMode) {
                    addressSelectorHolder.mLlAddressItem.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ff1));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609ce));
                } else {
                    addressSelectorHolder.mLlAddressItem.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ff0));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0609cd));
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.this$0.mOnAddressSelectedListener == null) {
                        return;
                    }
                    this.this$0.mHotCitySelected = false;
                    this.this$0.mOnAddressSelectedListener.onAddressSelected(this.val$position, this.val$addressBean);
                }
            });
        }
        if (this.mHasHotList) {
            addressSelectorHolder.mTvCityCategory.setVisibility(i != 1 ? 8 : 0);
        } else {
            addressSelectorHolder.mTvCityCategory.setVisibility(i != 0 ? 8 : 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public AddressSelectorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) ? new AddressSelectorHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d04d3, viewGroup, false), this.isDarkMode) : (AddressSelectorHolder) invokeLI.objValue;
    }
}
