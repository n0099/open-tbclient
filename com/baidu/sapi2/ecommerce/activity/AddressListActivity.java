package com.baidu.sapi2.ecommerce.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.baidu.pass.ecommerce.common.view.ToastUtil;
import com.baidu.pass.ecommerce.dialog.AddrOptionDialog;
import com.baidu.pass.ecommerce.presenter.AddressPresenter;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.activity.BaseOptionActivity;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.enums.PassAddrColorLocation;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.SweepLightLoadingView;
import com.baidu.sapi2.views.ViewUtility;
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
    public static final int CREATE_ADDRESS_CODE = 1001;
    public static final String CREATE_ADDRESS_RESULT = "create_address_result";
    public static final String CREATE_REGION_RESULT = "create_region_result";
    public static final String DEL_ADDRESS_ID = "del_address_id";
    public static final int MAX_COUNT = 30;
    public static final String OPTION_DIALOG_TAG = "option_dialog_tag";
    public static final String TAG = "AddressListActivity";
    public static final int UPDATE_ADDRESS_CODE = 1002;
    public TextView addAddrBtn;
    public TextView addAddrBtnAtEmptyView;
    public View addAddrBtnWrap;
    public View addAddrBtnWrapLayout;
    public ImageView addAddrImageAtEmptyView;
    public List<JSONObject> addrJsonObjects;
    public View addrListBg;
    public TextView addrListCountTv;
    public View addrListLayout;
    public ListView addrListView;
    public CommonDialog authNuoMiAddressDialog;
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

    private void callbackAddressResult(JSONObject jSONObject) {
        if (this.addressManageCallback == null) {
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
    }

    private void changColorByConfigSetting() {
        if (this.mAddrListColorMap == null) {
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) this.addAddrBtn.getBackground();
        if (this.isDarkMode) {
            String str = this.mAddrListColorMap.get(PassAddrColorLocation.ADD_ADDRESS_BTN_BG);
            if (!TextUtils.isEmpty(str)) {
                gradientDrawable.setColor(Color.parseColor(str));
            }
        } else {
            String str2 = this.mAddrListColorMap.get(PassAddrColorLocation.ADD_ADDRESS_BTN_BG_DARKMODE);
            if (!TextUtils.isEmpty(str2)) {
                gradientDrawable.setColor(Color.parseColor(str2));
            }
        }
        this.addAddrBtn.setBackgroundDrawable(gradientDrawable);
    }

    private String getOptionRegionStr() {
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

    private void getUserDisplayName() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            this.userDisplayName = currentAccount.displayname;
        }
    }

    private void initView() {
        this.addrListBg = findViewById(R.id.sapi_sdk_addr_list_bg);
        TitleBarView titleBarView = (TitleBarView) findViewById(R.id.sapi_sdk_addres_list_title);
        this.titleBarView = titleBarView;
        titleBarView.setTitle("我的地址");
        this.addrListLayout = findViewById(R.id.sapi_sdk_addr_list_layout);
        this.loadingView = (SweepLightLoadingView) findViewById(R.id.sapi_sdk_addr_loading_view);
        this.addAddrBtnWrapLayout = findViewById(R.id.sapi_sdk_add_addr_btn_wrap_layout);
        this.addAddrBtn = (TextView) findViewById(R.id.sapi_sdk_add_addr_btn);
        this.addAddrBtnWrap = findViewById(R.id.sapi_sdk_add_addr_btn_wrap);
        this.addrListView = (ListView) findViewById(R.id.sapi_sdk_address_list);
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_sapi_sdk_address_list_header, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.sapi_sdk_addr_list_count);
        this.addrListCountTv = textView;
        if (this.isDarkMode) {
            textView.setBackgroundResource(R.drawable.sapi_sdk_add_addr_list_header_dark_bg);
            this.addrListCountTv.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_user_hint_text_dark_color));
        }
        this.addrListView.addHeaderView(inflate);
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.layout_sapi_sdk_address_list_footer, (ViewGroup) null);
        if (this.isDarkMode) {
            inflate2.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_list_bg_dark_color));
        }
        this.addrListView.addFooterView(inflate2);
        AddrListAdapter addrListAdapter = new AddrListAdapter(this, this.isDarkMode);
        this.listAdapter = addrListAdapter;
        addrListAdapter.setColorMap(this.mAddrListColorMap);
        this.listAdapter.setListener(this);
        this.addrListView.setAdapter((ListAdapter) this.listAdapter);
        this.addrListView.setOnItemLongClickListener(this);
        if (this.isSelectAddressType) {
            this.addrListView.setOnItemClickListener(this);
        }
        ViewUtility.setViewClickAlpha(this.addAddrBtn, 0.2f);
        this.addAddrBtn.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.sapi_sdk_addr_list_bottom_back);
        imageView.setOnClickListener(this);
        if (this.isDarkMode) {
            this.addrListBg.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_list_bg_dark_color));
            this.titleBarView.setDarkMode();
            this.addrListLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_list_bg_dark_color));
            this.addAddrBtnWrap.setBackgroundResource(R.drawable.sapi_sdk_add_addr_wrap_dark_bg);
            this.addAddrBtn.setBackgroundResource(R.drawable.sapi_sdk_add_address_btn_dark_bg);
            this.addAddrBtn.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_btn_text_dark_color));
            findViewById(R.id.sapi_sdk_bottom_back_layout).setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_list_buttom_bar_bg_dark_color));
            findViewById(R.id.sapi_sdk_bottom_back_line).setBackgroundColor(getResources().getColor(R.color.sapi_sek_title_bar_bg_end_dark_color));
            imageView.setColorFilter(getResources().getColor(R.color.sapi_sdk_addr_list_buttom_bar_image_color_drak));
        }
        changColorByConfigSetting();
    }

    private void insertNewAddress(JSONObject jSONObject) {
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

    private void loadAddrList() {
        this.loadingView.setVisibility(0);
        ((AddressPresenter) this.presenter).getAddressList(true);
    }

    private void processAddAddrResult(Intent intent) {
        if (intent == null) {
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

    private void processNuoMiAddressStatus() {
        final int cancelNuomiAddrCount = SapiContext.getInstance().getCancelNuomiAddrCount();
        Log.d(TAG, "processNuoMiAddressStatus cancelCount=" + cancelNuomiAddrCount);
        CommonDialog build = new CommonDialog.Builder(this).setTitle("授权提示").setMessage("是否同意导入您在百度糯米保存的地址信息").setNegativeButton("取消", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_CANCEL_CLICK);
                if (cancelNuomiAddrCount >= 1) {
                    ((AddressPresenter) AddressListActivity.this.presenter).ignoreNuoMiAddressStatus();
                } else {
                    SapiContext.getInstance().setCancelNuomiAddrCount(cancelNuomiAddrCount + 1);
                }
                AddressListActivity.this.authNuoMiAddressDialog.dismiss();
            }
        }).setPositiveBtn("同意", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_CONFIRM_CLICK);
                AddressListActivity.this.authNuoMiAddressDialog.dismiss();
                ((AddressPresenter) AddressListActivity.this.presenter).importNuoMiAddressStatus();
            }
        }).build();
        this.authNuoMiAddressDialog = build;
        build.show();
        AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_DIALOG_SHOW);
    }

    private void processSetAddrDefaultStatus(Object obj) {
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

    private void processUpdateAddrResult(Intent intent) {
        if (intent == null || this.addrJsonObjects == null) {
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
        this.listAdapter.setNuoMiAddressIds(list);
        ((AddressPresenter) this.presenter).getAddressList(false);
        AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_RESULT);
    }

    private void showEmpty() {
        if (this.emptyView == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.sapi_sdk_list_empty);
            this.emptyView = viewStub.inflate();
            viewStub.setVisibility(0);
            TextView textView = (TextView) findViewById(R.id.sapi_sdk_address_add_tips);
            TextView textView2 = (TextView) findViewById(R.id.sapi_sdk_empty_address_tips);
            this.addAddrImageAtEmptyView = (ImageView) findViewById(R.id.sapi_sdk_empty_address_image);
            this.addAddrBtnAtEmptyView = (TextView) findViewById(R.id.sapi_sdk_add_addr_btn_at_empty);
            TextView textView3 = (TextView) findViewById(R.id.sapi_sdk_addr_empty_bottom_tv);
            this.addAddrBtnAtEmptyView.setOnClickListener(this);
            if (this.isDarkMode) {
                this.emptyView.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_list_empty_page_bg_dark_color));
                textView.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_empty_page_text_dark_color));
                textView2.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_empty_page_tip_text_dark_color));
                this.addAddrImageAtEmptyView.setColorFilter(getResources().getColor(R.color.sapi_sdk_addr_list_empty_page_image_color_drak));
                this.addAddrBtnAtEmptyView.setBackgroundResource(R.drawable.sapi_sdk_add_address_btn_dark_bg);
                this.addAddrBtnAtEmptyView.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_empty_add_addr_btn_text_dark_color));
                textView3.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_empty_page_text_dark_color));
            }
        }
        this.addrListView.setVisibility(8);
        this.addAddrBtnWrapLayout.setVisibility(8);
        this.emptyView.setVisibility(0);
    }

    private void showLoadTimeView() {
        if (this.loadTimeoutView == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.sapi_sdk_load_time);
            this.loadTimeoutView = viewStub.inflate();
            viewStub.setVisibility(0);
            this.retryLoadAddrListBtn = findViewById(R.id.sapi_sdk_load_timeout_retry_btn);
            TextView textView = (TextView) findViewById(R.id.sapi_sdk_notice_net_error);
            TextView textView2 = (TextView) findViewById(R.id.sapi_sdk_load_timeout_retry_btn);
            this.retryLoadAddrListBtn.setOnClickListener(this);
            if (this.isDarkMode) {
                this.loadTimeoutView.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_list_bg_color));
                textView.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_item_addr_text_dark_color));
                this.retryLoadAddrListBtn.setBackgroundResource(R.drawable.sapi_sdk_common_reload_btn_dark_bg);
                textView2.setTextColor(getResources().getColor(R.color.sapi_sdk_common_select_btn_text_dark_color));
            }
        }
        this.loadTimeoutView.setVisibility(0);
        View view = this.emptyView;
        if (view != null) {
            view.setVisibility(8);
        }
        this.addAddrBtnWrapLayout.setVisibility(8);
        this.addrListView.setVisibility(8);
    }

    private void showOptionDialog() {
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

    private void sortAddrListByTag() {
        Collections.sort(this.addrJsonObjects, new Comparator<JSONObject>() { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
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
        });
    }

    private void updateAddAddrBtnWrapStatus() {
        this.addrListView.post(new Runnable() { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                int lastVisiblePosition = AddressListActivity.this.addrListView.getLastVisiblePosition() - AddressListActivity.this.addrListView.getFirstVisiblePosition();
                Log.d(AddressListActivity.TAG, "visibleCount=" + lastVisiblePosition);
                if (lastVisiblePosition <= AddressListActivity.this.listAdapter.getCount() + 1) {
                    AddressListActivity.this.addAddrBtnWrap.setVisibility(0);
                } else {
                    AddressListActivity.this.addAddrBtnWrap.setVisibility(8);
                }
            }
        });
    }

    private void updateAddrListView() {
        List<JSONObject> list = this.addrJsonObjects;
        if (list != null && !list.isEmpty()) {
            View view = this.emptyView;
            if (view != null) {
                view.setVisibility(8);
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

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i, int i2, String str, String str2) {
        LoadingUtil.cancel();
        this.loadingView.setVisibility(8);
        if (i != 1000) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ToastUtil.show(R.drawable.sapi_sdk_common_error_ic, str);
            return;
        }
        showLoadTimeView();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i, Object obj, String str) {
        LoadingUtil.cancel();
        this.loadingView.setVisibility(8);
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

    @Override // com.baidu.pass.ecommerce.adapter.AddrListAdapter.EditAddressListener
    public void edit(MapObject mapObject, AddressSelectedBean addressSelectedBean) {
        AddressStatUtil.statAddressOption(StatKey.ADDRLIST_EDITBTN_CLICK);
        Intent intent = new Intent(this, AddressEditActivity.class);
        intent.putExtra(AddressEditActivity.KEY_ADDRESS_DETAIL_MAP_OBJ, mapObject);
        intent.putExtra(AddressEditActivity.KEY_ADDRESS_ADDR_REGION_BEAN, addressSelectedBean);
        intent.putExtra(AddressEditActivity.KEY_BDSTOKEN_FROM_ADDRLIST, ((AddressPresenter) this.presenter).getBdSTokenFromAddrList());
        startActivityForResult(intent, 1002);
        overridePendingTransition(R.anim.sapi_sdk_anim_activity_push_bottom_in, R.anim.sapi_sdk_anim_activity_stay);
    }

    @Override // com.baidu.sapi2.activity.NaSlideActiviy
    public void finishActivityAfterSlideOver() {
        endProcess();
        finish();
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1001 == i) {
            processAddAddrResult(intent);
        } else if (1002 == i) {
            processUpdateAddrResult(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        endProcess();
        super.onBackPressed();
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("ONCLICK", "currentTime=" + currentTimeMillis + " lastClickTime=" + BaseOptionActivity.lastClickTime);
        if (currentTimeMillis - BaseOptionActivity.lastClickTime < 500) {
            return;
        }
        BaseOptionActivity.lastClickTime = currentTimeMillis;
        if (view != this.addAddrBtn && view != this.addAddrBtnAtEmptyView) {
            if (view.getId() == R.id.sapi_sdk_addr_list_bottom_back) {
                endProcess();
                finish();
                return;
            } else if (view.getId() == R.id.sapi_sdk_load_timeout_retry_btn) {
                this.loadTimeoutView.setVisibility(8);
                loadAddrList();
                return;
            } else {
                return;
            }
        }
        AddressStatUtil.statAddressOption(StatKey.ADDRLIST_ADDBTN_CLICK);
        if (this.listAdapter.getCount() >= 30) {
            ToastUtil.show("地址最多30个，删除一条再添加吧！");
            return;
        }
        Intent intent = new Intent(this, AddressEditActivity.class);
        intent.putExtra(AddressEditActivity.KEY_BDSTOKEN_FROM_ADDRLIST, ((AddressPresenter) this.presenter).getBdSTokenFromAddrList());
        startActivityForResult(intent, 1001);
        overridePendingTransition(R.anim.sapi_sdk_anim_activity_push_bottom_in, R.anim.sapi_sdk_anim_activity_stay);
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, com.baidu.sapi2.activity.NaSlideActiviy, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AddressStatUtil.statAddressOption(StatKey.ADDRLIST_ENTER);
        setContentView(R.layout.layout_sapi_sdk_address_list_activity);
        ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.sapi_sek_title_bar_bg_start_color));
        AddressManageDTO addressManageDTO = this.addressManageDTO;
        if (addressManageDTO != null) {
            this.mAddrListColorMap = addressManageDTO.addrListColorMap;
        }
        initView();
        loadAddrList();
        getUserDisplayName();
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.addrListView.getHeaderViewsCount();
        if (headerViewsCount < 0 || headerViewsCount >= this.listAdapter.getCount()) {
            return;
        }
        callbackAddressResult(this.listAdapter.getItem(headerViewsCount));
        finish();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < this.addrListView.getHeaderViewsCount()) {
            return false;
        }
        this.optionJsonObj = this.listAdapter.getItem(i - this.addrListView.getHeaderViewsCount());
        showOptionDialog();
        return true;
    }

    @Override // com.baidu.pass.ecommerce.dialog.AddrOptionDialog.OptionOnClickListener
    public void onOptionClick(int i) {
        JSONObject jSONObject = this.optionJsonObj;
        if (jSONObject == null) {
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
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("address", this.optionJsonObj.optString("name") + "\n" + this.optionJsonObj.optString("mobile") + "\n" + getOptionRegionStr()));
            ToastUtil.show(R.drawable.sapi_sdk_common_success_ic, "复制成功");
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        ToastUtil.show("加载中");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity
    public AddressPresenter createPresenter() {
        return new AddressPresenter();
    }
}
