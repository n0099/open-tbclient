package com.baidu.pass.ecommerce.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.adapter.CommonAdapter;
import com.baidu.pass.ecommerce.common.adapter.ViewHolder;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.sapi2.ecommerce.enums.PassAddrColorLocation;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddrListAdapter extends CommonAdapter<JSONObject> {
    public static final long LIMIT_TIME = 500;
    public boolean isDarkMode;
    public long lastClickTime = 0;
    public EditAddressListener listener;
    public HashMap<PassAddrColorLocation, String> mAddrListColorMap;
    public Context mContext;
    public List<String> nuomiAddressIds;

    /* loaded from: classes2.dex */
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

        public AddrListItemViewHolder(View view) {
            super(view);
            View findViewById = findViewById(R.id.sapi_sdk_addr_list_item_layout);
            this.tvTagIcon = (TextView) findViewById(R.id.sapi_sdk_addr_tag_icon);
            this.tvName = (TextView) findViewById(R.id.sapi_sdk_addr_name_tv);
            this.tvPhone = (TextView) findViewById(R.id.sapi_sdk_addr_phone_tv);
            this.tvDefaultTag = (TextView) findViewById(R.id.sapi_sdk_addr_default_tag);
            this.tvTag = (TextView) findViewById(R.id.sapi_sdk_addr_tag);
            this.tvNuoMiTag = (TextView) findViewById(R.id.sapi_sdk_nuomi_addr_tag);
            this.tvDetail = (TextView) findViewById(R.id.sapi_sdk_addr_detail);
            this.ivEdit = (ImageView) findViewById(R.id.ic_sapi_sdk_addr_edit);
            this.darkShapeView = findViewById(R.id.sapi_sdk_addr_tag_icon_dark_shape);
            if (AddrListAdapter.this.mAddrListColorMap != null) {
                String str = (String) AddrListAdapter.this.mAddrListColorMap.get(PassAddrColorLocation.ADDRESS_ITEM_IC_TEXT_COLOR);
                if (!TextUtils.isEmpty(str)) {
                    this.tvTagIcon.setTextColor(Color.parseColor(str));
                }
            }
            if (AddrListAdapter.this.isDarkMode) {
                Resources resources = AddrListAdapter.this.mContext.getResources();
                findViewById.setBackgroundResource(R.drawable.sapi_sdk_add_addr_list_item_dark_bg);
                this.ivEdit.setImageDrawable(AddrListAdapter.this.mContext.getResources().getDrawable(R.drawable.sapi_sdk_addr_edit_dark));
                this.tvName.setTextColor(resources.getColor(R.color.sapi_sdk_addr_list_item_user_name_text_dark_color));
                this.tvPhone.setTextColor(resources.getColor(R.color.sapi_sdk_addr_list_item_user_name_text_dark_color));
                this.tvDefaultTag.setBackgroundResource(R.drawable.sapi_sdk_add_address_default_tag_dark_bg);
                this.tvDefaultTag.setTextColor(resources.getColor(R.color.sapi_sdk_addr_list_item_user_defalut_tag_text_dark_color));
                this.tvTag.setBackgroundResource(R.drawable.sapi_sdk_add_address_tag_dark_bg);
                this.tvTag.setTextColor(resources.getColor(R.color.sapi_sdk_addr_list_item_user_company_tag_text_dark_color));
                this.tvDetail.setTextColor(resources.getColor(R.color.sapi_sdk_addr_list_item_addr_text_dark_color));
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.ViewHolder
        public void bindView(JSONObject jSONObject) {
            this.addrJsonObj = jSONObject;
            String trim = jSONObject.optString("name").trim();
            this.tvName.setText(trim);
            this.tvPhone.setText(jSONObject.optString("mobile").trim());
            this.tvDefaultTag.setVisibility(jSONObject.optInt(AddressField.KEY_IS_DEFAULT, 0) == 1 ? 0 : 8);
            String optString = jSONObject.optString("tag");
            if (TextUtils.isEmpty(optString)) {
                this.tvTag.setVisibility(8);
            } else {
                this.tvTag.setVisibility(0);
                this.tvTag.setText(optString);
            }
            this.tvTagIcon.setText("");
            this.darkShapeView.setVisibility(AddrListAdapter.this.isDarkMode ? 0 : 8);
            char c2 = 65535;
            int hashCode = optString.hashCode();
            if (hashCode != 23478) {
                if (hashCode != 667660) {
                    if (hashCode == 751995 && optString.equals(AddressField.VALUE_SCHOOL_TAG)) {
                        c2 = 1;
                    }
                } else if (optString.equals(AddressField.VALUE_COMPANY_TAG)) {
                    c2 = 2;
                }
            } else if (optString.equals(AddressField.VALUE_HOME_TAG)) {
                c2 = 0;
            }
            if (c2 == 0) {
                this.tvTagIcon.setBackgroundResource(R.drawable.sapi_sdk_addr_tag_home);
            } else if (c2 == 1) {
                this.tvTagIcon.setBackgroundResource(R.drawable.sapi_sdk_addr_tag_school);
            } else if (c2 != 2) {
                this.darkShapeView.setVisibility(8);
                this.tvTagIcon.setText(!TextUtils.isEmpty(trim) ? trim.substring(0, 1) : "");
                this.tvTagIcon.setBackgroundResource(R.drawable.sapi_sdk_add_address_tag_icon_bg);
                if (AddrListAdapter.this.mAddrListColorMap != null) {
                    String str = (String) AddrListAdapter.this.mAddrListColorMap.get(PassAddrColorLocation.ADDRESS_ITEM_IC_BG_COLOR);
                    if (!TextUtils.isEmpty(str)) {
                        GradientDrawable gradientDrawable = (GradientDrawable) this.tvTagIcon.getBackground();
                        gradientDrawable.setColor(Color.parseColor(str));
                        this.tvTagIcon.setBackgroundDrawable(gradientDrawable);
                    }
                }
            } else {
                this.tvTagIcon.setBackgroundResource(R.drawable.sapi_sdk_addr_tag_company);
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
    }

    /* loaded from: classes2.dex */
    public interface EditAddressListener {
        void edit(MapObject mapObject, AddressSelectedBean addressSelectedBean);
    }

    public AddrListAdapter(Context context, boolean z) {
        this.mContext = context;
        this.isDarkMode = z;
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public ViewHolder createViewHolder(View view) {
        return new AddrListItemViewHolder(view);
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public int getItemLayoutId() {
        return R.layout.layout_sapi_sdk_address_list_item;
    }

    public void setColorMap(HashMap<PassAddrColorLocation, String> hashMap) {
        this.mAddrListColorMap = hashMap;
    }

    public void setListener(EditAddressListener editAddressListener) {
        this.listener = editAddressListener;
    }

    public void setNuoMiAddressIds(List<String> list) {
        this.nuomiAddressIds = list;
    }
}
