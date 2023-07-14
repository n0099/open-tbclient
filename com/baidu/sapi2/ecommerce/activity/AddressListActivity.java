package com.baidu.sapi2.ecommerce.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AddressListActivity extends BaseAddressActivity<AddressPresenter> implements AdapterView.OnItemLongClickListener, AddrOptionDialog.OptionOnClickListener, AddrListAdapter.EditAddressListener, AdapterView.OnItemClickListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
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

    private void getUserDisplayName() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            this.userDisplayName = currentAccount.displayname;
        }
    }

    private void loadAddrList() {
        setLoadingViewVisibility(0);
        ((AddressPresenter) this.presenter).getAddressList(true);
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
                if (!TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
                    return -1;
                }
                if (TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    return 1;
                }
                return 0;
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        endProcess();
        super.onBackPressed();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
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

    private void processUpdateNuoMiAddrStatus(List<String> list) {
        this.listAdapter.setNuoMiAddressIds(list);
        ((AddressPresenter) this.presenter).getAddressList(false);
        AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_RESULT);
    }

    private void setLoadingViewVisibility(int i) {
        View view2;
        AddressManageDTO addressManageDTO = this.addressManageDTO;
        if (addressManageDTO != null && (view2 = addressManageDTO.loadingView) != null) {
            view2.setVisibility(i);
        } else {
            this.loadingView.setVisibility(i);
        }
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AddressStatUtil.statAddressOption(StatKey.ADDRLIST_ENTER);
        setContentView(R.layout.obfuscated_res_0x7f0d055e);
        ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.obfuscated_res_0x7f060a85));
        AddressManageDTO addressManageDTO = this.addressManageDTO;
        if (addressManageDTO != null) {
            this.mAddrListColorMap = addressManageDTO.addrListColorMap;
            this.addrListTextStyle = addressManageDTO.addrListTextStyle;
        }
        initView();
        loadAddrList();
        getUserDisplayName();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i) {
        if (isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && isDestroyed()) {
            return;
        }
        ToastUtil.show("加载中");
    }

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
        AddressManagerStat.upload();
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("ONCLICK", "currentTime=" + currentTimeMillis + " lastClickTime=" + BaseOptionActivity.lastClickTime);
        if (currentTimeMillis - BaseOptionActivity.lastClickTime < 500) {
            return;
        }
        BaseOptionActivity.lastClickTime = currentTimeMillis;
        if (view2 != this.addAddrBtn && view2 != this.addAddrBtnAtEmptyView) {
            if (view2.getId() != R.id.obfuscated_res_0x7f091fd4 && view2.getId() != R.id.obfuscated_res_0x7f092074) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092042) {
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
        overridePendingTransition(R.anim.obfuscated_res_0x7f010137, R.anim.obfuscated_res_0x7f010139);
    }

    private void changColorByConfigSetting() {
        String str;
        View view2;
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
        if (!TextUtils.isEmpty(str3)) {
            try {
                gradientDrawable.setCornerRadius((int) ((Float.parseFloat(str3) * Resources.getSystem().getDisplayMetrics().density) + 0.5f));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void showLoadTimeView() {
        if (this.loadTimeoutView == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f092041);
            this.loadTimeoutView = viewStub.inflate();
            viewStub.setVisibility(0);
            this.retryLoadAddrListBtn = findViewById(R.id.obfuscated_res_0x7f092042);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092059);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f092042);
            this.retryLoadAddrListBtn.setOnClickListener(this);
            if (this.isDarkMode) {
                this.loadTimeoutView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609ca));
                textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e6));
                this.retryLoadAddrListBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812d3);
                textView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a2a));
            }
        }
        this.loadTimeoutView.setVisibility(0);
        View view2 = this.emptyView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        TextView textView3 = this.addAddrBtn;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        this.addrListView.setVisibility(8);
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

    private void processNuoMiAddressStatus() {
        final int cancelNuomiAddrCount = SapiContext.getInstance().getCancelNuomiAddrCount();
        Log.d(TAG, "processNuoMiAddressStatus cancelCount=" + cancelNuomiAddrCount);
        CommonDialog build = new CommonDialog.Builder(this).setTitle("授权提示").setMessage("是否同意导入您在百度糯米保存的地址信息").setNegativeButton("取消", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
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
            public void onClick(View view2) {
                AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_CONFIRM_CLICK);
                AddressListActivity.this.authNuoMiAddressDialog.dismiss();
                ((AddressPresenter) AddressListActivity.this.presenter).importNuoMiAddressStatus();
            }
        }).build();
        this.authNuoMiAddressDialog = build;
        build.show();
        AddressStatUtil.statAddressOption(StatKey.NUOMI_AUTH_DIALOG_SHOW);
    }

    private void updateAddrListView() {
        List<JSONObject> list = this.addrJsonObjects;
        if (list != null && !list.isEmpty()) {
            View view2 = this.emptyView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            TextView textView = this.addAddrBtn;
            if (textView != null) {
                textView.setVisibility(0);
            }
            sortAddrListByTag();
            this.addrListView.setVisibility(0);
            this.listAdapter.setData(this.addrJsonObjects);
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

    private void initView() {
        Drawable drawable;
        this.addrListBg = findViewById(R.id.obfuscated_res_0x7f091fd3);
        TitleBarView titleBarView = (TitleBarView) findViewById(R.id.obfuscated_res_0x7f091ff6);
        this.titleBarView = titleBarView;
        titleBarView.setTitle("我的地址");
        this.addrListLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091fd7);
        this.bottomBackLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ffa);
        this.loadingView = (SweepLightLoadingView) findViewById(R.id.obfuscated_res_0x7f091fd8);
        this.addAddrBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091fb9);
        this.addrListView = (ListView) findViewById(R.id.obfuscated_res_0x7f091ff8);
        View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0561, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091fd5);
        this.addrListCountTv = textView;
        if (this.isDarkMode) {
            textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081288);
            this.addrListCountTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609fe));
        }
        this.addrListView.addHeaderView(inflate);
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0560, (ViewGroup) null);
        if (this.isDarkMode) {
            inflate2.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609cb));
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
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fd4);
        imageView.setOnClickListener(this);
        if (this.isDarkMode) {
            this.addrListBg.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609cb));
            this.titleBarView.setDarkMode();
            this.addrListLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609cb));
            this.addAddrBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f08128e);
            this.addAddrBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609d6));
            this.bottomBackLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609d8));
            findViewById(R.id.obfuscated_res_0x7f091ffb).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060a84));
            imageView.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f0609d9));
        }
        this.addAddrBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f08128d);
        AddressManageDTO addressManageDTO2 = this.addressManageDTO;
        if (addressManageDTO2 != null) {
            if (addressManageDTO2.showBottomBack) {
                this.bottomBackLayout.setVisibility(0);
                Drawable drawable2 = this.addressManageDTO.backBtnDrawable;
                if (drawable2 == null) {
                    drawable2 = getResources().getDrawable(R.drawable.obfuscated_res_0x7f0812e7);
                }
                imageView.setImageDrawable(drawable2);
            } else {
                this.bottomBackLayout.setVisibility(8);
                TitleBarView titleBarView2 = this.titleBarView;
                Drawable drawable3 = this.addressManageDTO.backBtnDrawable;
                if (drawable3 == null) {
                    drawable3 = getResources().getDrawable(R.drawable.obfuscated_res_0x7f0812e7);
                }
                titleBarView2.setLeftBtn(drawable3, this);
            }
        }
        changColorByConfigSetting();
    }

    private void insertNewAddress(JSONObject jSONObject) {
        boolean z;
        if (this.addrJsonObjects == null) {
            this.addrJsonObjects = new ArrayList();
        }
        JsonFieldConverter.putStr("mobile", ContactUtil.hidePhoneNumber(jSONObject.optString("mobile")), jSONObject);
        if (this.addrJsonObjects.isEmpty()) {
            this.addrJsonObjects.add(jSONObject);
        } else {
            int i = 0;
            if (1 == jSONObject.optInt(AddressField.KEY_IS_DEFAULT, 0)) {
                z = true;
            } else {
                z = false;
            }
            JSONObject jSONObject2 = this.addrJsonObjects.get(0);
            if (z) {
                JsonFieldConverter.putInt(AddressField.KEY_IS_DEFAULT, 0, jSONObject2);
                this.addrJsonObjects.add(0, jSONObject);
            } else {
                if (1 == jSONObject2.optInt(AddressField.KEY_IS_DEFAULT, 0)) {
                    i = 1;
                }
                this.addrJsonObjects.add(i, jSONObject);
            }
        }
        updateAddrListView();
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
            ((ClipboardManager) getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("address", this.optionJsonObj.optString("name") + "\n" + this.optionJsonObj.optString("mobile") + "\n" + getOptionRegionStr()));
            ToastUtil.show(R.drawable.obfuscated_res_0x7f0812d4, "复制成功");
        }
    }

    private void showEmpty() {
        if (this.emptyView == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f09203b);
            this.emptyView = viewStub.inflate();
            viewStub.setVisibility(0);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091ff7);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f092018);
            this.addAddrImageAtEmptyView = (ImageView) findViewById(R.id.obfuscated_res_0x7f092017);
            this.addAddrBtnAtEmptyView = (TextView) findViewById(R.id.obfuscated_res_0x7f091fba);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f091fd2);
            this.addAddrBtnAtEmptyView.setOnClickListener(this);
            if (this.isDarkMode) {
                this.emptyView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609df));
                textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e2));
                textView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e4));
                this.addAddrImageAtEmptyView.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f0609e0));
                this.addAddrBtnAtEmptyView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08128e);
                this.addAddrBtnAtEmptyView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609dd));
                textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e2));
            }
        }
        this.addrListView.setVisibility(8);
        this.emptyView.setVisibility(0);
        this.addAddrBtn.setVisibility(8);
    }

    private void showOptionDialog() {
        AddrOptionDialog addrOptionDialog = new AddrOptionDialog(this.isDarkMode);
        this.optionDialog = addrOptionDialog;
        boolean z = true;
        addrOptionDialog.setCancelable(true);
        this.optionDialog.setOptionOnClickListener(this);
        if (1 != this.optionJsonObj.optInt(AddressField.KEY_IS_DEFAULT)) {
            z = false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(AddrOptionDialog.KEY_IS_DEFAULT_ADDR, z);
        this.optionDialog.setArguments(bundle);
        this.optionDialog.show(getSupportFragmentManager(), OPTION_DIALOG_TAG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity
    public AddressPresenter createPresenter() {
        return new AddressPresenter();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i, int i2, String str, String str2) {
        LoadingUtil.cancel();
        setLoadingViewVisibility(8);
        if (i != 1000) {
            if (!TextUtils.isEmpty(str)) {
                ToastUtil.show(R.drawable.obfuscated_res_0x7f0812c9, str);
                return;
            }
            return;
        }
        showLoadTimeView();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        int headerViewsCount = i - this.addrListView.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.listAdapter.getCount()) {
            callbackAddressResult(this.listAdapter.getItem(headerViewsCount));
            finish();
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        int headerViewsCount;
        if (i < this.addrListView.getHeaderViewsCount() || (headerViewsCount = i - this.addrListView.getHeaderViewsCount()) >= this.listAdapter.getCount()) {
            return false;
        }
        this.optionJsonObj = this.listAdapter.getItem(headerViewsCount);
        showOptionDialog();
        return true;
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i, Object obj, String str) {
        LoadingUtil.cancel();
        setLoadingViewVisibility(8);
        if (i != 1000) {
            if (i != 1002) {
                if (i != 1003) {
                    if (i != 10001) {
                        if (i == 10002) {
                            processUpdateNuoMiAddrStatus((List) obj);
                            return;
                        }
                        return;
                    }
                    processNuoMiAddressStatus();
                    return;
                }
                processSetAddrDefaultStatus(str);
                return;
            }
            processDelAddrResult(str);
            return;
        }
        this.addrJsonObjects = (List) obj;
        updateAddrListView();
        AddressStatUtil.statAddressOption(StatKey.ADDRLIST_LOADTIME, gapTimeFromEnter());
    }

    @Override // com.baidu.pass.ecommerce.adapter.AddrListAdapter.EditAddressListener
    public void edit(MapObject mapObject, AddressSelectedBean addressSelectedBean) {
        AddressStatUtil.statAddressOption(StatKey.ADDRLIST_EDITBTN_CLICK);
        Intent intent = new Intent(this, AddressEditActivity.class);
        intent.putExtra(AddressEditActivity.KEY_ADDRESS_DETAIL_MAP_OBJ, mapObject);
        intent.putExtra(AddressEditActivity.KEY_ADDRESS_ADDR_REGION_BEAN, addressSelectedBean);
        intent.putExtra(AddressEditActivity.KEY_BDSTOKEN_FROM_ADDRLIST, ((AddressPresenter) this.presenter).getBdSTokenFromAddrList());
        startActivityForResult(intent, 1002);
        overridePendingTransition(R.anim.obfuscated_res_0x7f010137, R.anim.obfuscated_res_0x7f010139);
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
}
