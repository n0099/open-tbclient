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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.adapter.CommonAdapter;
import com.baidu.pass.ecommerce.common.adapter.ViewHolder;
import com.baidu.sapi2.ecommerce.enums.PassAddrColorLocation;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddrListAdapter extends CommonAdapter<JSONObject> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long LIMIT_TIME = 500;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDarkMode;
    public long lastClickTime;
    public EditAddressListener listener;
    public HashMap<PassAddrColorLocation, String> mAddrListColorMap;
    public HashMap<PassAddrColorLocation, Boolean> mAddrListTextStyle;
    public Context mContext;
    public Drawable mEditIcon;
    public List<String> nuomiAddressIds;

    /* loaded from: classes2.dex */
    public interface EditAddressListener {
        void edit(MapObject mapObject, AddressSelectedBean addressSelectedBean);
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public int getItemLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.layout_sapi_sdk_address_list_item : invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public class AddrListItemViewHolder extends ViewHolder<JSONObject> implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject addrJsonObj;
        public View darkShapeView;
        public ImageView ivEdit;
        public final /* synthetic */ AddrListAdapter this$0;
        public TextView tvDefaultTag;
        public TextView tvDetail;
        public TextView tvName;
        public TextView tvNuoMiTag;
        public TextView tvPhone;
        public TextView tvTag;
        public TextView tvTagIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddrListItemViewHolder(AddrListAdapter addrListAdapter, View view2) {
            super(view2);
            Typeface defaultFromStyle;
            Typeface defaultFromStyle2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addrListAdapter, view2};
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
            this.this$0 = addrListAdapter;
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
            if (addrListAdapter.mAddrListColorMap != null) {
                String str = (String) addrListAdapter.mAddrListColorMap.get(PassAddrColorLocation.ADDRESS_ITEM_IC_TEXT_COLOR);
                if (!TextUtils.isEmpty(str)) {
                    this.tvTagIcon.setTextColor(Color.parseColor(str));
                }
            }
            if (addrListAdapter.mAddrListTextStyle != null) {
                Boolean bool = (Boolean) addrListAdapter.mAddrListTextStyle.get(PassAddrColorLocation.ADDRESS_ITEM_TEXT_NAME_BOLD);
                Boolean bool2 = (Boolean) addrListAdapter.mAddrListTextStyle.get(PassAddrColorLocation.ADDRESS_ITEM_TEXT_PHONE_BOLD);
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
            if (addrListAdapter.mEditIcon != null) {
                this.ivEdit.setImageDrawable(addrListAdapter.mEditIcon);
            }
            if (addrListAdapter.isDarkMode) {
                Resources resources = addrListAdapter.mContext.getResources();
                findViewById.setBackgroundResource(R.drawable.sapi_sdk_add_addr_list_item_dark_bg);
                this.ivEdit.setImageDrawable(addrListAdapter.mContext.getResources().getDrawable(R.drawable.sapi_sdk_addr_edit_dark));
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
            TextView textView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, this) == null) && (textView = this.tvNuoMiTag) != null) {
                textView.setVisibility(8);
                String str = (String) this.tvNuoMiTag.getTag();
                if (this.this$0.nuomiAddressIds != null) {
                    this.this$0.nuomiAddressIds.remove(str);
                }
            }
        }

        private MapObject convertJsonObj2MapObject() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.addrJsonObj == null) {
                    return null;
                }
                MapObject mapObject = new MapObject();
                mapField(mapObject, this.addrJsonObj);
                return mapObject;
            }
            return (MapObject) invokeV.objValue;
        }

        private AddressSelectedBean generateAddrRegion(MapObject mapObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, mapObject)) == null) {
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
            return (AddressSelectedBean) invokeL.objValue;
        }

        private void mapField(MapObject mapObject, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, mapObject, jSONObject) == null) {
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.ViewHolder
        public void bindView(JSONObject jSONObject) {
            boolean z;
            int i;
            int i2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
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
                if (this.this$0.isDarkMode) {
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
                            this.tvTagIcon.setBackgroundResource(R.drawable.sapi_sdk_add_address_tag_icon_bg);
                            if (this.this$0.mAddrListColorMap != null) {
                                String str2 = (String) this.this$0.mAddrListColorMap.get(PassAddrColorLocation.ADDRESS_ITEM_IC_BG_COLOR);
                                if (!TextUtils.isEmpty(str2)) {
                                    GradientDrawable gradientDrawable = (GradientDrawable) this.tvTagIcon.getBackground();
                                    gradientDrawable.setColor(Color.parseColor(str2));
                                    this.tvTagIcon.setBackgroundDrawable(gradientDrawable);
                                }
                            }
                        } else {
                            this.tvTagIcon.setBackgroundResource(R.drawable.sapi_sdk_addr_tag_company);
                        }
                    } else {
                        this.tvTagIcon.setBackgroundResource(R.drawable.sapi_sdk_addr_tag_school);
                    }
                } else {
                    this.tvTagIcon.setBackgroundResource(R.drawable.sapi_sdk_addr_tag_home);
                }
                this.tvNuoMiTag.setVisibility(8);
                String trim2 = jSONObject.optString(AddressField.KEY_ADDR_ID).trim();
                if (this.this$0.nuomiAddressIds != null && this.this$0.nuomiAddressIds.size() > 0 && this.this$0.nuomiAddressIds.contains(trim2)) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.this$0.lastClickTime < 500) {
                    return;
                }
                cleanNuoMiStatus();
                this.this$0.lastClickTime = currentTimeMillis;
                if (this.this$0.listener != null) {
                    MapObject convertJsonObj2MapObject = convertJsonObj2MapObject();
                    this.this$0.listener.edit(convertJsonObj2MapObject, generateAddrRegion(convertJsonObj2MapObject));
                }
            }
        }
    }

    public AddrListAdapter(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lastClickTime = 0L;
        this.mContext = context;
        this.isDarkMode = z;
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public ViewHolder createViewHolder(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            return new AddrListItemViewHolder(this, view2);
        }
        return (ViewHolder) invokeL.objValue;
    }

    public void setEditIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
            this.mEditIcon = drawable;
        }
    }

    public void setListener(EditAddressListener editAddressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, editAddressListener) == null) {
            this.listener = editAddressListener;
        }
    }

    public void setNuoMiAddressIds(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.nuomiAddressIds = list;
        }
    }

    public void setItemStyle(HashMap<PassAddrColorLocation, String> hashMap, HashMap<PassAddrColorLocation, Boolean> hashMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, hashMap, hashMap2) == null) {
            this.mAddrListColorMap = hashMap;
            this.mAddrListTextStyle = hashMap2;
        }
    }
}
