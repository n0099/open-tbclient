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
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.pass.ecommerce.view.addressdialog.ElementNode;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.sapi2.ecommerce.result.AddressBean;
import java.util.List;
/* loaded from: classes2.dex */
public class AddrPagerListAdapter extends RecyclerView.Adapter<AddressSelectorHolder> {
    public static final int POSITION_HOT_CITY = -1;
    public static final String VALUE_NOT_SELECTED_ID = "-1";
    public boolean isDarkMode;
    public Context mContext;
    public ElementNode.AddressEntity mEntity;
    public boolean mHasHotList;
    public String mHotCityId;
    public boolean mHotCitySelected;
    public OnAddressSelectedListener mOnAddressSelectedListener;

    /* loaded from: classes2.dex */
    public static class AddressSelectorHolder extends RecyclerView.ViewHolder {
        public View mItemView;
        public RelativeLayout mLlAddressItem;
        public LinearLayout mLlHotGroup;
        public ImageView mTvAddressChecked;
        public TextView mTvAddressHot;
        public TextView mTvAddressName;
        public TextView mTvAddressPy;
        public TextView mTvCityCategory;

        public AddressSelectorHolder(@NonNull View view, boolean z) {
            super(view);
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

    /* loaded from: classes2.dex */
    public interface OnAddressSelectedListener {
        void onAddressSelected(int i, AddressBean addressBean);
    }

    public AddrPagerListAdapter(Context context, boolean z, ElementNode.AddressEntity addressEntity) {
        this.mContext = context;
        this.isDarkMode = z;
        this.mEntity = optEntity(addressEntity);
    }

    private void createHotViewByData(LinearLayout linearLayout, List<AddressBean> list) {
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
                final AddressBean addressBean = list.get((i * 4) + i2);
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
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AddrPagerListAdapter.this.mOnAddressSelectedListener != null) {
                                AddrPagerListAdapter.this.mHotCitySelected = true;
                                AddrPagerListAdapter.this.mOnAddressSelectedListener.onAddressSelected(-1, addressBean);
                            }
                        }
                    });
                    linearLayout2.addView(textView);
                    if (i2 != 3) {
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

    private void findHotSelected(AddressBean addressBean) {
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

    private ElementNode.AddressEntity optEntity(ElementNode.AddressEntity addressEntity) {
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

    private void optHotListItem(ElementNode.AddressEntity addressEntity, List<AddressBean> list) {
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

    private void optNotSelectedItem(List<AddressBean> list) {
        AddressBean addressBean = list.get(0);
        if (addressBean == null || addressBean.hasLeaf || addressBean.isNotSelected) {
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
        List<AddressBean> list;
        ElementNode.AddressEntity addressEntity = this.mEntity;
        if (addressEntity == null || (list = addressEntity.list) == null) {
            return 0;
        }
        return list.size();
    }

    public void setAddressSelectedListener(OnAddressSelectedListener onAddressSelectedListener) {
        this.mOnAddressSelectedListener = onAddressSelectedListener;
    }

    public void setEntity(ElementNode.AddressEntity addressEntity) {
        this.mEntity = optEntity(addressEntity);
    }

    public void setHotCityId(String str) {
        this.mHotCityId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull AddressSelectorHolder addressSelectorHolder, @SuppressLint({"RecyclerView"}) final int i) {
        List<AddressBean> list;
        final AddressBean addressBean;
        ElementNode.AddressEntity addressEntity = this.mEntity;
        if (addressEntity == null || (list = addressEntity.list) == null || list.size() == 0 || (addressBean = list.get(i)) == null) {
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
            addressSelectorHolder.mLlAddressItem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AddrPagerListAdapter.this.mOnAddressSelectedListener != null) {
                        AddrPagerListAdapter.this.mHotCitySelected = false;
                        AddrPagerListAdapter.this.mOnAddressSelectedListener.onAddressSelected(i, addressBean);
                    }
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
        return new AddressSelectorHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_sapi_sdk_item_address_selector, viewGroup, false), this.isDarkMode);
    }
}
