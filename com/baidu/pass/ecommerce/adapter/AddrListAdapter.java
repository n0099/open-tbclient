package com.baidu.pass.ecommerce.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.adapter.CommonAdapter;
import com.baidu.pass.ecommerce.common.adapter.ViewHolder;
import com.baidu.sapi2.ecommerce.enums.PassAddrColorLocation;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AddrListAdapter extends CommonAdapter<JSONObject> {
    public static final long LIMIT_TIME = 500;
    public boolean isDarkMode;
    public long lastClickTime = 0;
    public EditAddressListener listener;
    public HashMap<PassAddrColorLocation, String> mAddrListColorMap;
    public HashMap<PassAddrColorLocation, Boolean> mAddrListTextStyle;
    public Context mContext;
    public Drawable mEditIcon;
    public List<String> nuomiAddressIds;

    /* loaded from: classes3.dex */
    public interface EditAddressListener {
        void edit(MapObject mapObject, AddressSelectedBean addressSelectedBean);
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public int getItemLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0567;
    }

    /* loaded from: classes3.dex */
    public class AddrListItemViewHolder extends ViewHolder<JSONObject> implements View.OnClickListener {
        public JSONObject addrJsonObj;
        public View darkShapeView;
        public ImageView ivEdit;
        public TextView tvDefaultTag;
        public TextView tvDetail;
        public TextView tvName;
        public TextView tvNuoMiTag;
        public TextView tvPhone;
        public TextView tvTag;
        public TextView tvTagIcon;

        public AddrListItemViewHolder(View view2) {
            super(view2);
            Typeface defaultFromStyle;
            Typeface defaultFromStyle2;
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091ff3);
            this.tvTagIcon = (TextView) findViewById(R.id.obfuscated_res_0x7f09200f);
            this.tvName = (TextView) findViewById(R.id.obfuscated_res_0x7f091ffe);
            this.tvPhone = (TextView) findViewById(R.id.obfuscated_res_0x7f092002);
            this.tvDefaultTag = (TextView) findViewById(R.id.obfuscated_res_0x7f091fe1);
            this.tvTag = (TextView) findViewById(R.id.obfuscated_res_0x7f09200b);
            this.tvNuoMiTag = (TextView) findViewById(R.id.obfuscated_res_0x7f092077);
            this.tvDetail = (TextView) findViewById(R.id.obfuscated_res_0x7f091fea);
            this.ivEdit = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fee);
            this.darkShapeView = findViewById(R.id.obfuscated_res_0x7f092010);
            if (AddrListAdapter.this.mAddrListColorMap != null) {
                String str = (String) AddrListAdapter.this.mAddrListColorMap.get(PassAddrColorLocation.ADDRESS_ITEM_IC_TEXT_COLOR);
                if (!TextUtils.isEmpty(str)) {
                    this.tvTagIcon.setTextColor(Color.parseColor(str));
                }
            }
            if (AddrListAdapter.this.mAddrListTextStyle != null) {
                Boolean bool = (Boolean) AddrListAdapter.this.mAddrListTextStyle.get(PassAddrColorLocation.ADDRESS_ITEM_TEXT_NAME_BOLD);
                Boolean bool2 = (Boolean) AddrListAdapter.this.mAddrListTextStyle.get(PassAddrColorLocation.ADDRESS_ITEM_TEXT_PHONE_BOLD);
                TextView textView = this.tvName;
                if (bool != null && bool.booleanValue()) {
                    defaultFromStyle = Typeface.defaultFromStyle(1);
                } else {
                    defaultFromStyle = Typeface.defaultFromStyle(0);
                }
                textView.setTypeface(defaultFromStyle);
                TextView textView2 = this.tvPhone;
                if (bool2 != null && bool2.booleanValue()) {
                    defaultFromStyle2 = Typeface.defaultFromStyle(1);
                } else {
                    defaultFromStyle2 = Typeface.defaultFromStyle(0);
                }
                textView2.setTypeface(defaultFromStyle2);
            }
            if (AddrListAdapter.this.mEditIcon != null) {
                this.ivEdit.setImageDrawable(AddrListAdapter.this.mEditIcon);
            }
            if (AddrListAdapter.this.isDarkMode) {
                Resources resources = AddrListAdapter.this.mContext.getResources();
                findViewById.setBackgroundResource(R.drawable.obfuscated_res_0x7f081293);
                this.ivEdit.setImageDrawable(AddrListAdapter.this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0812a9));
                this.tvName.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609f0));
                this.tvPhone.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609f0));
                this.tvDefaultTag.setBackgroundResource(R.drawable.obfuscated_res_0x7f081299);
                this.tvDefaultTag.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609ee));
                this.tvTag.setBackgroundResource(R.drawable.obfuscated_res_0x7f08129b);
                this.tvTag.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609eb));
                this.tvDetail.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609e6));
            }
        }

        private void cleanNuoMiStatus() {
            TextView textView = this.tvNuoMiTag;
            if (textView != null) {
                textView.setVisibility(8);
                String str = (String) this.tvNuoMiTag.getTag();
                if (AddrListAdapter.this.nuomiAddressIds != null) {
                    AddrListAdapter.this.nuomiAddressIds.remove(str);
                }
            }
        }

        private MapObject convertJsonObj2MapObject() {
            if (this.addrJsonObj == null) {
                return null;
            }
            MapObject mapObject = new MapObject();
            mapField(mapObject, this.addrJsonObj);
            return mapObject;
        }

        private AddressSelectedBean generateAddrRegion(MapObject mapObject) {
            AddressSelectedBean addressSelectedBean = new AddressSelectedBean();
            addressSelectedBean.countryId = mapObject.getStrValue(AddressField.KEY_COUNTRY_ID);
            addressSelectedBean.countryName = mapObject.getStrValue(AddressField.KEY_COUNTRY_NAME);
            addressSelectedBean.provinceId = mapObject.getStrValue(AddressField.KEY_PROVINCE_ID);
            addressSelectedBean.provinceName = mapObject.getStrValue(AddressField.KEY_PROVINCE_NAME);
            addressSelectedBean.cityId = mapObject.getStrValue(AddressField.KEY_CITY_ID);
            addressSelectedBean.cityName = mapObject.getStrValue("city_name");
            addressSelectedBean.districtId = mapObject.getStrValue(AddressField.KEY_DISTRICT_ID);
            addressSelectedBean.districtName = mapObject.getStrValue(AddressField.KEY_DISTRICT_NAME);
            addressSelectedBean.townId = mapObject.getStrValue(AddressField.KEY_TOWN_ID);
            addressSelectedBean.townName = mapObject.getStrValue(AddressField.KEY_TOWN_NAME);
            return addressSelectedBean;
        }

        private void mapField(MapObject mapObject, JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof JSONObject) {
                    mapField(mapObject, (JSONObject) opt);
                } else if (!(opt instanceof JSONArray)) {
                    mapObject.putValue(next, jSONObject.opt(next));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.ViewHolder
        public void bindView(JSONObject jSONObject) {
            boolean z;
            int i;
            int i2;
            String str;
            this.addrJsonObj = jSONObject;
            String trim = jSONObject.optString("name").trim();
            this.tvName.setText(trim);
            this.tvPhone.setText(jSONObject.optString("mobile").trim());
            if (jSONObject.optInt(AddressField.KEY_IS_DEFAULT, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            TextView textView = this.tvDefaultTag;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            String optString = jSONObject.optString("tag");
            if (TextUtils.isEmpty(optString)) {
                this.tvTag.setVisibility(8);
            } else {
                this.tvTag.setVisibility(0);
                this.tvTag.setText(optString);
            }
            this.tvTagIcon.setText("");
            View view2 = this.darkShapeView;
            if (AddrListAdapter.this.isDarkMode) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            char c = 65535;
            int hashCode = optString.hashCode();
            if (hashCode != 23478) {
                if (hashCode != 667660) {
                    if (hashCode == 751995 && optString.equals(AddressField.VALUE_SCHOOL_TAG)) {
                        c = 1;
                    }
                } else if (optString.equals(AddressField.VALUE_COMPANY_TAG)) {
                    c = 2;
                }
            } else if (optString.equals(AddressField.VALUE_HOME_TAG)) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        this.darkShapeView.setVisibility(8);
                        if (TextUtils.isEmpty(trim)) {
                            str = "";
                        } else {
                            str = trim.substring(0, 1);
                        }
                        this.tvTagIcon.setText(str);
                        this.tvTagIcon.setBackgroundResource(R.drawable.obfuscated_res_0x7f08129c);
                        if (AddrListAdapter.this.mAddrListColorMap != null) {
                            String str2 = (String) AddrListAdapter.this.mAddrListColorMap.get(PassAddrColorLocation.ADDRESS_ITEM_IC_BG_COLOR);
                            if (!TextUtils.isEmpty(str2)) {
                                GradientDrawable gradientDrawable = (GradientDrawable) this.tvTagIcon.getBackground();
                                gradientDrawable.setColor(Color.parseColor(str2));
                                this.tvTagIcon.setBackgroundDrawable(gradientDrawable);
                            }
                        }
                    } else {
                        this.tvTagIcon.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812c0);
                    }
                } else {
                    this.tvTagIcon.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812c3);
                }
            } else {
                this.tvTagIcon.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812c2);
            }
            this.tvNuoMiTag.setVisibility(8);
            String trim2 = jSONObject.optString(AddressField.KEY_ADDR_ID).trim();
            if (AddrListAdapter.this.nuomiAddressIds != null && AddrListAdapter.this.nuomiAddressIds.size() > 0 && AddrListAdapter.this.nuomiAddressIds.contains(trim2)) {
                this.tvNuoMiTag.setVisibility(0);
                this.tvNuoMiTag.setTag(trim2);
                this.tvDefaultTag.setVisibility(8);
                this.tvTag.setVisibility(8);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("addr_info");
            if (optJSONObject != null) {
                this.tvDetail.setText(optJSONObject.optString(AddressField.KEY_PROVINCE_NAME) + optJSONObject.optString("city_name") + optJSONObject.optString(AddressField.KEY_DISTRICT_NAME) + optJSONObject.optString(AddressField.KEY_TOWN_NAME) + optJSONObject.optString(AddressField.KEY_DETAIL_ADDR));
            } else {
                this.tvDetail.setText("");
            }
            this.ivEdit.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - AddrListAdapter.this.lastClickTime < 500) {
                return;
            }
            cleanNuoMiStatus();
            AddrListAdapter.this.lastClickTime = currentTimeMillis;
            if (AddrListAdapter.this.listener != null) {
                MapObject convertJsonObj2MapObject = convertJsonObj2MapObject();
                AddrListAdapter.this.listener.edit(convertJsonObj2MapObject, generateAddrRegion(convertJsonObj2MapObject));
            }
        }
    }

    public AddrListAdapter(Context context, boolean z) {
        this.mContext = context;
        this.isDarkMode = z;
    }

    public void setItemStyle(HashMap<PassAddrColorLocation, String> hashMap, HashMap<PassAddrColorLocation, Boolean> hashMap2) {
        this.mAddrListColorMap = hashMap;
        this.mAddrListTextStyle = hashMap2;
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public ViewHolder createViewHolder(View view2) {
        return new AddrListItemViewHolder(view2);
    }

    public void setEditIcon(Drawable drawable) {
        this.mEditIcon = drawable;
    }

    public void setListener(EditAddressListener editAddressListener) {
        this.listener = editAddressListener;
    }

    public void setNuoMiAddressIds(List<String> list) {
        this.nuomiAddressIds = list;
    }
}
