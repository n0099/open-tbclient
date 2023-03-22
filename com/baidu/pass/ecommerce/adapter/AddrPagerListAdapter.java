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
import com.baidu.sapi2.ecommerce.result.AddressBean;
import com.baidu.sapi2.utils.Log;
import com.baidu.tieba.R;
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
    public interface OnAddressSelectedListener {
        void onAddressSelected(int i, AddressBean addressBean);
    }

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

        public AddressSelectorHolder(@NonNull View view2, boolean z) {
            super(view2);
            this.mItemView = view2;
            this.mLlAddressItem = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f37);
            this.mTvCityCategory = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f52);
            this.mTvAddressPy = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f56);
            this.mTvAddressName = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f55);
            this.mTvAddressHot = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f54);
            this.mLlHotGroup = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f14);
            this.mTvAddressChecked = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091f53);
            Resources resources = view2.getContext().getResources();
            if (z) {
                this.mTvAddressHot.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0608b0));
                this.mTvCityCategory.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0608b0));
                this.mTvAddressPy.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0608b0));
                this.mTvAddressName.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0608b4));
            }
        }
    }

    public AddrPagerListAdapter(Context context, boolean z, ElementNode.AddressEntity addressEntity) {
        this.mContext = context;
        this.isDarkMode = z;
        this.mEntity = optEntity(addressEntity);
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

    public void setAddressSelectedListener(OnAddressSelectedListener onAddressSelectedListener) {
        this.mOnAddressSelectedListener = onAddressSelectedListener;
    }

    public void setEntity(ElementNode.AddressEntity addressEntity) {
        this.mEntity = optEntity(addressEntity);
    }

    public void setHotCityId(String str) {
        this.mHotCityId = str;
    }

    private void optHotListItem(ElementNode.AddressEntity addressEntity, List<AddressBean> list) {
        List<AddressBean> list2 = addressEntity.hotlists;
        AddressBean addressBean = list.get(0);
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

    private void createHotViewByData(LinearLayout linearLayout, List<AddressBean> list) {
        linearLayout.removeAllViews();
        if (list.size() > 8) {
            list = list.subList(0, 8);
        }
        int size = list.size() / 4;
        for (int i = 0; i < size; i++) {
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout2.setPadding((int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070627), 0, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070627), 0);
            for (int i2 = 0; i2 < 4; i2++) {
                final AddressBean addressBean = list.get((i * 4) + i2);
                if (addressBean != null) {
                    TextView textView = new TextView(this.mContext);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070626), (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070624));
                    layoutParams.bottomMargin = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070625);
                    textView.setLayoutParams(layoutParams);
                    textView.setTextSize(1, 13.0f);
                    textView.setClickable(true);
                    if (addressBean.isHotSelected) {
                        if (this.isDarkMode) {
                            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810f1));
                            textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608a9));
                        } else {
                            textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810f0));
                            textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608a8));
                        }
                    } else if (this.isDarkMode) {
                        textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810f2));
                        textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608a7));
                    } else {
                        textView.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810ef));
                        textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608a6));
                    }
                    textView.setGravity(17);
                    textView.setText(addressBean.name);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (AddrPagerListAdapter.this.mOnAddressSelectedListener == null) {
                                return;
                            }
                            AddrPagerListAdapter.this.mHotCitySelected = true;
                            AddrPagerListAdapter.this.mOnAddressSelectedListener.onAddressSelected(-1, addressBean);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull AddressSelectorHolder addressSelectorHolder, @SuppressLint({"RecyclerView"}) final int i) {
        List<AddressBean> list;
        final AddressBean addressBean;
        String upperCase;
        int i2;
        ElementNode.AddressEntity addressEntity = this.mEntity;
        if (addressEntity == null || (list = addressEntity.list) == null || list.size() == 0 || (addressBean = list.get(i)) == null) {
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
                    addressSelectorHolder.mLlAddressItem.setBackgroundColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608b8));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608b2));
                } else {
                    addressSelectorHolder.mLlAddressItem.setBackgroundColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608b7));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608b1));
                }
                addressSelectorHolder.mTvAddressChecked.setVisibility(0);
                addressSelectorHolder.mTvAddressChecked.setColorFilter(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608b1));
            } else {
                if (this.isDarkMode) {
                    addressSelectorHolder.mLlAddressItem.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810c7));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608b4));
                } else {
                    addressSelectorHolder.mLlAddressItem.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810c6));
                    addressSelectorHolder.mTvAddressName.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608b3));
                }
                addressSelectorHolder.mTvAddressChecked.setVisibility(8);
            }
            addressSelectorHolder.mLlAddressItem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (AddrPagerListAdapter.this.mOnAddressSelectedListener == null) {
                        return;
                    }
                    AddrPagerListAdapter.this.mHotCitySelected = false;
                    AddrPagerListAdapter.this.mOnAddressSelectedListener.onAddressSelected(i, addressBean);
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

    private void optNotSelectedItem(List<AddressBean> list) {
        try {
            AddressBean addressBean = list.get(list.size() - 1);
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<AddressBean> list;
        ElementNode.AddressEntity addressEntity = this.mEntity;
        if (addressEntity != null && (list = addressEntity.list) != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public AddressSelectorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AddressSelectorHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d053b, viewGroup, false), this.isDarkMode);
    }
}
