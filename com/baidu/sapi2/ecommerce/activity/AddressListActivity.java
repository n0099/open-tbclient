package com.baidu.sapi2.ecommerce.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.AddressStatUtil;
import com.baidu.pass.ecommerce.ContactUtil;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.pass.ecommerce.adapter.AddrListAdapter;
import com.baidu.pass.ecommerce.adapter.AddressConverter;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.common.JsonFieldConverter;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.view.LoadingUtil;
import com.baidu.pass.ecommerce.common.view.TitleBarView;
import com.baidu.pass.ecommerce.dialog.AddrOptionDialog;
import com.baidu.pass.ecommerce.presenter.AddressPresenter;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.BaseOptionActivity;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.enums.PassAddrColorLocation;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.sapi2.stat.AddressManagerStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.views.SweepLightLoadingView;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddressListActivity extends BaseAddressActivity<AddressPresenter> implements AdapterView.OnItemLongClickListener, AddrOptionDialog.OptionOnClickListener, AddrListAdapter.EditAddressListener, AdapterView.OnItemClickListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CREATE_ADDRESS_CODE = 1001;
    public static final String CREATE_ADDRESS_RESULT = "create_address_result";
    public static final String CREATE_REGION_RESULT = "create_region_result";
    public static final String DEL_ADDRESS_ID = "del_address_id";
    public static final int MAX_COUNT = 30;
    public static final String OPTION_DIALOG_TAG = "option_dialog_tag";
    public static final String TAG = "AddressListActivity";
    public static final int UPDATE_ADDRESS_CODE = 1002;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView addAddrBtn;
    public TextView addAddrBtnAtEmptyView;
    public View addAddrBtnWrap;
    public View addAddrBtnWrapLayout;
    public ImageView addAddrImageAtEmptyView;
    public List<JSONObject> addrJsonObjects;
    public View addrListBg;
    public TextView addrListCountTv;
    public FrameLayout addrListLayout;
    public HashMap<PassAddrColorLocation, Boolean> addrListTextStyle;
    public ListView addrListView;
    public CommonDialog authNuoMiAddressDialog;
    public LinearLayout bottomBackLayout;
    public View emptyView;
    public AddrListAdapter listAdapter;
    public View loadTimeoutView;
    public SweepLightLoadingView loadingView;
    public HashMap<PassAddrColorLocation, String> mAddrListColorMap;
    public AddrOptionDialog optionDialog;
    public JSONObject optionJsonObj;
    public View retryLoadAddrListBtn;
    public TitleBarView titleBarView;
    public String userDisplayName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-549912071, "Lcom/baidu/sapi2/ecommerce/activity/AddressListActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-549912071, "Lcom/baidu/sapi2/ecommerce/activity/AddressListActivity;");
            }
        }
    }

    public AddressListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void callbackAddressResult(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, jSONObject) == null) || this.addressManageCallback == null) {
            return;
        }
        AddressManageResult addressManageResult = new AddressManageResult();
        HashMap<String, String> hashMap = addressManageResult.map;
        hashMap.put("addrId", jSONObject.optString(AddressField.KEY_ADDR_ID));
        hashMap.put("name", jSONObject.optString("name"));
        hashMap.put("mobile", jSONObject.optString("mobile"));
        hashMap.put("tag", jSONObject.optString("tag"));
        hashMap.put("isDefault", "" + jSONObject.optInt(AddressField.KEY_IS_DEFAULT));
        JSONObject optJSONObject = jSONObject.optJSONObject("addr_info");
        if (optJSONObject != null) {
            hashMap.put("addrRegion", optJSONObject.optString(AddressField.KEY_PROVINCE_NAME) + optJSONObject.optString("city_name") + optJSONObject.optString(AddressField.KEY_DISTRICT_NAME) + optJSONObject.optString(AddressField.KEY_TOWN_NAME));
            hashMap.put("addrInfo", optJSONObject.optString(AddressField.KEY_DETAIL_ADDR));
        }
        addressManageResult.setResultCode(0);
        this.addressManageCallback.onFinish(addressManageResult);
        AddressManagerStat.upload();
    }

    private void changColorByConfigSetting() {
        String str;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            AddressManageDTO addressManageDTO = this.addressManageDTO;
            if (addressManageDTO != null && (view2 = addressManageDTO.loadingView) != null) {
                this.addrListLayout.addView(view2);
                ((FrameLayout.LayoutParams) this.addressManageDTO.loadingView.getLayoutParams()).gravity = 17;
            }
            HashMap<PassAddrColorLocation, String> hashMap = this.mAddrListColorMap;
            if (hashMap == null) {
                return;
            }
            String str2 = hashMap.get(PassAddrColorLocation.ADD_ADDRESS_TEXT_BG);
            if (!TextUtils.isEmpty(str2)) {
                this.addAddrBtn.setTextColor(Color.parseColor(str2));
            }
            GradientDrawable gradientDrawable = (GradientDrawable) this.addAddrBtn.getBackground();
            if (this.isDarkMode) {
                str = this.mAddrListColorMap.get(PassAddrColorLocation.ADD_ADDRESS_BTN_BG_DARKMODE);
            } else {
                str = this.mAddrListColorMap.get(PassAddrColorLocation.ADD_ADDRESS_BTN_BG);
            }
            if (!TextUtils.isEmpty(str)) {
                gradientDrawable.setColor(Color.parseColor(str));
            }
            String str3 = this.mAddrListColorMap.get(PassAddrColorLocation.ADD_ADDRESS_BTN_CORNER_RADIUS);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            try {
                gradientDrawable.setCornerRadius((int) ((Float.parseFloat(str3) * Resources.getSystem().getDisplayMetrics().density) + 0.5f));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private String getOptionRegionStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            StringBuilder sb = new StringBuilder();
            JSONObject optJSONObject = this.optionJsonObj.optJSONObject("addr_info");
            if (optJSONObject == null) {
                return "";
            }
            sb.append(optJSONObject.optString(AddressField.KEY_PROVINCE_NAME));
            sb.append(optJSONObject.optString("city_name"));
            sb.append(optJSONObject.optString(AddressField.KEY_DISTRICT_NAME));
            sb.append(optJSONObject.optString(AddressField.KEY_TOWN_NAME));
            sb.append("\n");
            sb.append(optJSONObject.optString(AddressField.KEY_DETAIL_ADDR));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private void getUserDisplayName() {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (currentAccount = SapiContext.getInstance().getCurrentAccount()) == null) {
            return;
        }
        this.userDisplayName = currentAccount.displayname;
    }

    private void initView() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.addrListBg = findViewById(R.id.obfuscated_res_0x7f091c98);
            TitleBarView titleBarView = (TitleBarView) findViewById(R.id.obfuscated_res_0x7f091cbb);
            this.titleBarView = titleBarView;
            titleBarView.setTitle("我的地址");
            this.addrListLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091c9c);
            this.bottomBackLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cbf);
            this.loadingView = (SweepLightLoadingView) findViewById(R.id.obfuscated_res_0x7f091c9d);
            this.addAddrBtnWrapLayout = findViewById(R.id.obfuscated_res_0x7f091c7f);
            this.addAddrBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091c7c);
            this.addAddrBtnWrap = findViewById(R.id.obfuscated_res_0x7f091c7e);
            this.addrListView = (ListView) findViewById(R.id.obfuscated_res_0x7f091cbd);
            View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d04d6, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091c9a);
            this.addrListCountTv = textView;
            if (this.isDarkMode) {
                textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fcf);
                this.addrListCountTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06098e));
            }
            this.addrListView.addHeaderView(inflate);
            View inflate2 = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d04d5, (ViewGroup) null);
            if (this.isDarkMode) {
                inflate2.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06095b));
            }
            this.addrListView.addFooterView(inflate2);
            AddrListAdapter addrListAdapter = new AddrListAdapter(this, this.isDarkMode);
            this.listAdapter = addrListAdapter;
            addrListAdapter.setItemStyle(this.mAddrListColorMap, this.addrListTextStyle);
            AddressManageDTO addressManageDTO = this.addressManageDTO;
            if (addressManageDTO != null && (drawable = addressManageDTO.itemAddEditBtnDrawable) != null) {
                this.listAdapter.setEditIcon(drawable);
            }
            this.listAdapter.setListener(this);
            this.addrListView.setAdapter((ListAdapter) this.listAdapter);
            this.addrListView.setOnItemLongClickListener(this);
            if (this.isSelectAddressType) {
                this.addrListView.setOnItemClickListener(this);
            }
            ViewUtility.setViewClickAlpha(this.addAddrBtn, 0.2f);
            this.addAddrBtn.setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091c99);
            imageView.setOnClickListener(this);
            if (this.isDarkMode) {
                this.addrListBg.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06095b));
                this.titleBarView.setDarkMode();
                this.addrListLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06095b));
                this.addAddrBtnWrap.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fd3);
                this.addAddrBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fd5);
                this.addAddrBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060966));
                this.bottomBackLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060968));
                findViewById(R.id.obfuscated_res_0x7f091cc0).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060a14));
                imageView.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f060969));
            }
            this.addAddrBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fd4);
            AddressManageDTO addressManageDTO2 = this.addressManageDTO;
            if (addressManageDTO2 != null) {
                if (addressManageDTO2.showBottomBack) {
                    this.bottomBackLayout.setVisibility(0);
                    Drawable drawable2 = this.addressManageDTO.backBtnDrawable;
                    if (drawable2 == null) {
                        drawable2 = getResources().getDrawable(R.drawable.obfuscated_res_0x7f08102d);
                    }
                    imageView.setImageDrawable(drawable2);
                } else {
                    this.bottomBackLayout.setVisibility(8);
                    TitleBarView titleBarView2 = this.titleBarView;
                    Drawable drawable3 = this.addressManageDTO.backBtnDrawable;
                    if (drawable3 == null) {
                        drawable3 = getResources().getDrawable(R.drawable.obfuscated_res_0x7f08102d);
                    }
                    titleBarView2.setLeftBtn(drawable3, this);
                }
            }
            changColorByConfigSetting();
        }
    }

    private void insertNewAddress(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, jSONObject) == null) {
            if (this.addrJsonObjects == null) {
                this.addrJsonObjects = new ArrayList();
            }
            JsonFieldConverter.putStr("mobile", ContactUtil.hidePhoneNumber(jSONObject.optString("mobile")), jSONObject);
            if (this.addrJsonObjects.isEmpty()) {
                this.addrJsonObjects.add(jSONObject);
            } else {
                boolean z = 1 == jSONObject.optInt(AddressField.KEY_IS_DEFAULT, 0);
                JSONObject jSONObject2 = this.addrJsonObjects.get(0);
                if (z) {
                    JsonFieldConverter.putInt(AddressField.KEY_IS_DEFAULT, 0, jSONObject2);
                    this.addrJsonObjects.add(0, jSONObject);
                } else {
                    this.addrJsonObjects.add(1 == jSONObject2.optInt(AddressField.KEY_IS_DEFAULT, 0) ? 1 : 0, jSONObject);
                }
            }
            updateAddrListView();
        }
    }

    private void loadAddrList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            setLoadingViewVisibility(0);
            ((AddressPresenter) this.presenter).getAddressList(true);
        }
    }

    private void processAddAddrResult(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, intent) == null) || intent == null) {
            return;
        }
        JSONObject createAddressJsonObj = AddressConverter.createAddressJsonObj((MapObject) intent.getParcelableExtra(CREATE_ADDRESS_RESULT), (AddressSelectedBean) intent.getSerializableExtra(CREATE_REGION_RESULT));
        if (this.selectAddedAddress) {
            callbackAddressResult(createAddressJsonObj);
            finish();
            return;
        }
        insertNewAddress(createAddressJsonObj);
    }

    private void processDelAddrResult(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, obj) == null) {
            String str = (String) obj;
            ListIterator<JSONObject> listIterator = this.addrJsonObjects.listIterator();
            while (true) {
                if (!listIterator.hasNext()) {
                    break;
                }
                JSONObject next = listIterator.next();
                if (next != null && TextUtils.equals(str, next.optString(AddressField.KEY_ADDR_ID))) {
                    listIterator.remove();
                    break;
                }
            }
            updateAddrListView();
        }
    }

    private void processNuoMiAddressStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            int cancelNuomiAddrCount = SapiContext.getInstance().getCancelNuomiAddrCount();
            Log.d(TAG, "processNuoMiAddressStatus cancelCount=" + cancelNuomiAddrCount);
            CommonDialog build = new CommonDialog.Builder(this).setTitle("授权提示").setMessage("是否同意导入您在百度糯米保存的地址信息").setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new View.OnClickListener(this, cancelNuomiAddrCount) { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressListActivity this$0;
                public final /* synthetic */ int val$cancelCount;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(cancelNuomiAddrCount)};
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
                    this.val$cancelCount = cancelNuomiAddrCount;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_CANCEL_CLICK);
                        if (this.val$cancelCount >= 1) {
                            ((AddressPresenter) this.this$0.presenter).ignoreNuoMiAddressStatus();
                        } else {
                            SapiContext.getInstance().setCancelNuomiAddrCount(this.val$cancelCount + 1);
                        }
                        this.this$0.authNuoMiAddressDialog.dismiss();
                    }
                }
            }).setPositiveBtn("同意", new View.OnClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressListActivity this$0;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_CONFIRM_CLICK);
                        this.this$0.authNuoMiAddressDialog.dismiss();
                        ((AddressPresenter) this.this$0.presenter).importNuoMiAddressStatus();
                    }
                }
            }).build();
            this.authNuoMiAddressDialog = build;
            build.show();
            AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_DIALOG_SHOW);
        }
    }

    private void processSetAddrDefaultStatus(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, obj) == null) {
            String str = (String) obj;
            ListIterator<JSONObject> listIterator = this.addrJsonObjects.listIterator();
            while (listIterator.hasNext()) {
                JSONObject next = listIterator.next();
                if (next != null) {
                    if (TextUtils.equals(str, next.optString(AddressField.KEY_ADDR_ID))) {
                        if (1 == this.optionJsonObj.optInt(AddressField.KEY_IS_DEFAULT)) {
                            JsonFieldConverter.putInt(AddressField.KEY_IS_DEFAULT, 0, next);
                        } else {
                            JsonFieldConverter.putInt(AddressField.KEY_IS_DEFAULT, 1, next);
                        }
                    } else {
                        JsonFieldConverter.putInt(AddressField.KEY_IS_DEFAULT, 0, next);
                    }
                }
            }
            updateAddrListView();
        }
    }

    private void processUpdateAddrResult(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, intent) == null) || intent == null || this.addrJsonObjects == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(DEL_ADDRESS_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            Iterator<JSONObject> it = this.addrJsonObjects.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (TextUtils.equals(it.next().optString(AddressField.KEY_ADDR_ID), stringExtra)) {
                    it.remove();
                    break;
                }
            }
            updateAddrListView();
            return;
        }
        JSONObject createAddressJsonObj = AddressConverter.createAddressJsonObj((MapObject) intent.getParcelableExtra(CREATE_ADDRESS_RESULT), (AddressSelectedBean) intent.getSerializableExtra(CREATE_REGION_RESULT));
        int i = 0;
        while (true) {
            if (i >= this.addrJsonObjects.size()) {
                break;
            } else if (TextUtils.equals(this.addrJsonObjects.get(i).optString(AddressField.KEY_ADDR_ID), createAddressJsonObj.optString(AddressField.KEY_ADDR_ID))) {
                this.addrJsonObjects.remove(i);
                break;
            } else {
                i++;
            }
        }
        insertNewAddress(createAddressJsonObj);
    }

    private void processUpdateNuoMiAddrStatus(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, list) == null) {
            this.listAdapter.setNuoMiAddressIds(list);
            ((AddressPresenter) this.presenter).getAddressList(false);
            AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_RESULT);
        }
    }

    private void setLoadingViewVisibility(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i) == null) {
            AddressManageDTO addressManageDTO = this.addressManageDTO;
            if (addressManageDTO != null && (view2 = addressManageDTO.loadingView) != null) {
                view2.setVisibility(i);
            } else {
                this.loadingView.setVisibility(i);
            }
        }
    }

    private void showEmpty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            if (this.emptyView == null) {
                ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091d00);
                this.emptyView = viewStub.inflate();
                viewStub.setVisibility(0);
                TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091cbc);
                TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091cdd);
                this.addAddrImageAtEmptyView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cdc);
                this.addAddrBtnAtEmptyView = (TextView) findViewById(R.id.obfuscated_res_0x7f091c7d);
                TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f091c97);
                this.addAddrBtnAtEmptyView.setOnClickListener(this);
                if (this.isDarkMode) {
                    this.emptyView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06096f));
                    textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060972));
                    textView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060974));
                    this.addAddrImageAtEmptyView.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f060970));
                    this.addAddrBtnAtEmptyView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fd5);
                    this.addAddrBtnAtEmptyView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06096d));
                    textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060972));
                }
            }
            this.addrListView.setVisibility(8);
            this.addAddrBtnWrapLayout.setVisibility(8);
            this.emptyView.setVisibility(0);
        }
    }

    private void showLoadTimeView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            if (this.loadTimeoutView == null) {
                ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091d06);
                this.loadTimeoutView = viewStub.inflate();
                viewStub.setVisibility(0);
                this.retryLoadAddrListBtn = findViewById(R.id.obfuscated_res_0x7f091d07);
                TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091d1e);
                TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091d07);
                this.retryLoadAddrListBtn.setOnClickListener(this);
                if (this.isDarkMode) {
                    this.loadTimeoutView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06095a));
                    textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060976));
                    this.retryLoadAddrListBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f081019);
                    textView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609ba));
                }
            }
            this.loadTimeoutView.setVisibility(0);
            View view2 = this.emptyView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.addAddrBtnWrapLayout.setVisibility(8);
            this.addrListView.setVisibility(8);
        }
    }

    private void showOptionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            AddrOptionDialog addrOptionDialog = new AddrOptionDialog(this.isDarkMode);
            this.optionDialog = addrOptionDialog;
            addrOptionDialog.setCancelable(true);
            this.optionDialog.setOptionOnClickListener(this);
            boolean z = 1 == this.optionJsonObj.optInt(AddressField.KEY_IS_DEFAULT);
            Bundle bundle = new Bundle();
            bundle.putBoolean(AddrOptionDialog.KEY_IS_DEFAULT_ADDR, z);
            this.optionDialog.setArguments(bundle);
            this.optionDialog.show(getSupportFragmentManager(), OPTION_DIALOG_TAG);
        }
    }

    private void sortAddrListByTag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            Collections.sort(this.addrJsonObjects, new Comparator<JSONObject>(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressListActivity this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, jSONObject2)) == null) {
                        if (1 == jSONObject.optInt(AddressField.KEY_IS_DEFAULT)) {
                            return -1;
                        }
                        if (1 == jSONObject2.optInt(AddressField.KEY_IS_DEFAULT)) {
                            return 1;
                        }
                        String optString = jSONObject.optString("tag");
                        String optString2 = jSONObject2.optString("tag");
                        if (TextUtils.isEmpty(optString) || !TextUtils.isEmpty(optString2)) {
                            return (!TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) ? 0 : 1;
                        }
                        return -1;
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }

    private void updateAddAddrBtnWrapStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.addrListView.post(new Runnable(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressListActivity this$0;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int lastVisiblePosition = this.this$0.addrListView.getLastVisiblePosition() - this.this$0.addrListView.getFirstVisiblePosition();
                        Log.d(AddressListActivity.TAG, "visibleCount=" + lastVisiblePosition);
                        if (lastVisiblePosition <= this.this$0.listAdapter.getCount() + 1) {
                            this.this$0.addAddrBtnWrap.setVisibility(0);
                        } else {
                            this.this$0.addAddrBtnWrap.setVisibility(8);
                        }
                    }
                }
            });
        }
    }

    private void updateAddrListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            List<JSONObject> list = this.addrJsonObjects;
            if (list != null && !list.isEmpty()) {
                View view2 = this.emptyView;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                sortAddrListByTag();
                this.addrListView.setVisibility(0);
                this.addAddrBtnWrapLayout.setVisibility(0);
                this.listAdapter.setData(this.addrJsonObjects);
                updateAddAddrBtnWrapStatus();
                StringBuilder sb = new StringBuilder(this.userDisplayName);
                if (sb.length() > 0) {
                    sb.append("，");
                }
                sb.append("你有");
                sb.append(this.addrJsonObjects.size());
                sb.append("个地址");
                this.addrListCountTv.setText(sb.toString());
                return;
            }
            showEmpty();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            LoadingUtil.cancel();
            setLoadingViewVisibility(8);
            if (i != 1000) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ToastUtil.show(R.drawable.obfuscated_res_0x7f08100f, str);
                return;
            }
            showLoadTimeView();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, obj, str) == null) {
            LoadingUtil.cancel();
            setLoadingViewVisibility(8);
            if (i == 1000) {
                this.addrJsonObjects = (List) obj;
                updateAddrListView();
                AddressStatUtil.statAddressOption(StatKey.ADDRLIST_LOADTIME, gapTimeFromEnter());
            } else if (i == 1002) {
                processDelAddrResult(str);
            } else if (i == 1003) {
                processSetAddrDefaultStatus(str);
            } else if (i == 10001) {
                processNuoMiAddressStatus();
            } else if (i != 10002) {
            } else {
                processUpdateNuoMiAddrStatus((List) obj);
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.adapter.AddrListAdapter.EditAddressListener
    public void edit(MapObject mapObject, AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, mapObject, addressSelectedBean) == null) {
            AddressStatUtil.statAddressOption(StatKey.ADDRLIST_EDITBTN_CLICK);
            Intent intent = new Intent(this, AddressEditActivity.class);
            intent.putExtra(AddressEditActivity.KEY_ADDRESS_DETAIL_MAP_OBJ, mapObject);
            intent.putExtra(AddressEditActivity.KEY_ADDRESS_ADDR_REGION_BEAN, addressSelectedBean);
            intent.putExtra(AddressEditActivity.KEY_BDSTOKEN_FROM_ADDRLIST, ((AddressPresenter) this.presenter).getBdSTokenFromAddrList());
            startActivityForResult(intent, 1002);
            overridePendingTransition(R.anim.obfuscated_res_0x7f010110, R.anim.obfuscated_res_0x7f010112);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (1001 == i) {
                processAddAddrResult(intent);
            } else if (1002 == i) {
                processUpdateAddrResult(intent);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            endProcess();
            super.onBackPressed();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("ONCLICK", "currentTime=" + currentTimeMillis + " lastClickTime=" + BaseOptionActivity.lastClickTime);
            if (currentTimeMillis - BaseOptionActivity.lastClickTime < 500) {
                return;
            }
            BaseOptionActivity.lastClickTime = currentTimeMillis;
            if (view2 != this.addAddrBtn && view2 != this.addAddrBtnAtEmptyView) {
                if (view2.getId() != R.id.obfuscated_res_0x7f091c99 && view2.getId() != R.id.obfuscated_res_0x7f091d39) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091d07) {
                        this.loadTimeoutView.setVisibility(8);
                        loadAddrList();
                        return;
                    }
                    return;
                }
                endProcess();
                finish();
                return;
            }
            AddressStatUtil.statAddressOption(StatKey.ADDRLIST_ADDBTN_CLICK);
            if (this.listAdapter.getCount() >= 30) {
                ToastUtil.show("地址最多30个，删除一条再添加吧！");
                return;
            }
            Intent intent = new Intent(this, AddressEditActivity.class);
            intent.putExtra(AddressEditActivity.KEY_BDSTOKEN_FROM_ADDRLIST, ((AddressPresenter) this.presenter).getBdSTokenFromAddrList());
            startActivityForResult(intent, 1001);
            overridePendingTransition(R.anim.obfuscated_res_0x7f010110, R.anim.obfuscated_res_0x7f010112);
        }
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            AddressStatUtil.statAddressOption(StatKey.ADDRLIST_ENTER);
            setContentView(R.layout.obfuscated_res_0x7f0d04d3);
            ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.obfuscated_res_0x7f060a15));
            AddressManageDTO addressManageDTO = this.addressManageDTO;
            if (addressManageDTO != null) {
                this.mAddrListColorMap = addressManageDTO.addrListColorMap;
                this.addrListTextStyle = addressManageDTO.addrListTextStyle;
            }
            initView();
            loadAddrList();
            getUserDisplayName();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (headerViewsCount = i - this.addrListView.getHeaderViewsCount()) < 0 || headerViewsCount >= this.listAdapter.getCount()) {
            return;
        }
        callbackAddressResult(this.listAdapter.getItem(headerViewsCount));
        finish();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i >= this.addrListView.getHeaderViewsCount() && (headerViewsCount = i - this.addrListView.getHeaderViewsCount()) < this.listAdapter.getCount()) {
                this.optionJsonObj = this.listAdapter.getItem(headerViewsCount);
                showOptionDialog();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.pass.ecommerce.dialog.AddrOptionDialog.OptionOnClickListener
    public void onOptionClick(int i) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (jSONObject = this.optionJsonObj) == null) {
            return;
        }
        if (1001 == i) {
            ((AddressPresenter) this.presenter).setAddressDefaultStatus(jSONObject);
        } else if (1002 == i) {
            String optString = jSONObject.optString(AddressField.KEY_ADDR_ID);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            ((AddressPresenter) this.presenter).delAddress(optString);
        } else if (1003 == i) {
            ((ClipboardManager) getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("address", this.optionJsonObj.optString("name") + "\n" + this.optionJsonObj.optString("mobile") + "\n" + getOptionRegionStr()));
            ToastUtil.show(R.drawable.obfuscated_res_0x7f08101a, "复制成功");
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || isFinishing() || isDestroyed()) {
            return;
        }
        ToastUtil.show("加载中");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity
    public AddressPresenter createPresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new AddressPresenter() : (AddressPresenter) invokeV.objValue;
    }
}
