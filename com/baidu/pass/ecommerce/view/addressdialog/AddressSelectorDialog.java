package com.baidu.pass.ecommerce.view.addressdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.adapter.AddrListPagerAdapter;
import com.baidu.pass.ecommerce.view.SlidingTabLayout;
import com.baidu.pass.ecommerce.view.addressdialog.ListPagerView;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.ecommerce.result.AddressBean;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AddressSelectorDialog extends Dialog implements NoProguard, ListPagerView.OnEntitySelectedListener, OnTabSelectListener {
    public float beforeX;
    public ResultHelpBean cityBean;
    public ResultHelpBean districtBean;
    public AddressSelectedBean mAddressSelectedBean;
    public Context mContext;
    public boolean mIsDarkMode;
    public OnDialogSelectedListenter mOnDialogSelectedListenter;
    public AddrListPagerAdapter mPagerAdapter;
    public int mRealPagerNumber;
    public SlidingTabLayout mTabLayout;
    public List<ListPagerView> mViewList;
    public AddrViewPager mViewPager;
    public ResultHelpBean provinceBean;
    public ResultHelpBean townBean;

    @Override // com.baidu.pass.ecommerce.view.addressdialog.OnTabSelectListener
    public void onTabReselect(int i) {
    }

    /* loaded from: classes2.dex */
    public static class ResultHelpBean {
        public String id;
        public String name;

        public ResultHelpBean() {
        }

        public void resetBean() {
            this.id = "";
            this.name = "";
        }

        public ResultHelpBean(String str, String str2) {
            this.id = str;
            this.name = str2;
        }

        public void refershBean(String str, String str2) {
            this.id = str;
            this.name = str2;
        }
    }

    public AddressSelectorDialog(@NonNull Context context) {
        this(context, (int) R.style.obfuscated_res_0x7f1003eb);
    }

    @Override // com.baidu.pass.ecommerce.view.addressdialog.OnTabSelectListener
    public void onTabSelect(int i) {
        if (i >= this.mRealPagerNumber) {
            return;
        }
        this.mViewPager.setCurrentItem(i, true);
    }

    public void setAddressSelectedBean(AddressSelectedBean addressSelectedBean) {
        if (addressSelectedBean == null) {
            AddressSelectedBean addressSelectedBean2 = new AddressSelectedBean();
            this.mAddressSelectedBean = addressSelectedBean2;
            addressSelectedBean2.countryId = ListPagerView.REQUEST_PARAM_CHINA;
            addressSelectedBean2.countryName = "中国";
        } else if (!this.mAddressSelectedBean.compare(addressSelectedBean)) {
            this.mAddressSelectedBean = addressSelectedBean;
            refershTabFromEntity();
            refershPageFromEntity();
        }
    }

    public void setOnDialogSelectedListenter(OnDialogSelectedListenter onDialogSelectedListenter) {
        this.mOnDialogSelectedListenter = onDialogSelectedListenter;
    }

    public AddressSelectorDialog(@NonNull Context context, int i) {
        super(context, i);
        this.mViewList = new ArrayList();
        this.provinceBean = new ResultHelpBean();
        this.cityBean = new ResultHelpBean();
        this.districtBean = new ResultHelpBean();
        this.townBean = new ResultHelpBean();
        this.mContext = context;
    }

    public AddressSelectorDialog(@NonNull Context context, AddressSelectedBean addressSelectedBean) {
        this(context, (int) R.style.obfuscated_res_0x7f1003eb);
        this.mAddressSelectedBean = addressSelectedBean;
    }

    public AddressSelectorDialog(@NonNull Context context, AddressSelectedBean addressSelectedBean, boolean z) {
        this(context, (int) R.style.obfuscated_res_0x7f1003eb);
        this.mAddressSelectedBean = addressSelectedBean;
        this.mIsDarkMode = z;
    }

    private void addTab2Layout(int i, String str, boolean z) {
        List<String> titles = this.mTabLayout.getTitles();
        titles.set(i, str);
        if (!z) {
            i++;
            titles.set(i, "请选择");
        }
        while (true) {
            i++;
            if (i < titles.size()) {
                titles.set(i, "");
            } else {
                this.mTabLayout.setTitles(titles);
                this.mTabLayout.notifyDataSetChanged();
                this.mTabLayout.postDelayed(new Runnable() { // from class: com.baidu.pass.ecommerce.view.addressdialog.AddressSelectorDialog.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AddressSelectorDialog.this.mTabLayout != null) {
                            AddressSelectorDialog.this.mTabLayout.smoothScrollTo(AddressSelectorDialog.this.mTabLayout.getWidth(), 0);
                        }
                    }
                }, 100L);
                return;
            }
        }
    }

    private void makeEntity2Result(AddressBean addressBean) {
        String str = addressBean.type;
        String str2 = addressBean.id;
        String str3 = addressBean.name;
        if (AddressLevel.PROVINCE.getName().equals(str)) {
            this.provinceBean.refershBean(str2, str3);
            this.cityBean.resetBean();
            this.districtBean.resetBean();
            this.townBean.resetBean();
        } else if (AddressLevel.CITY.getName().equals(str)) {
            if (addressBean.isHotCity) {
                this.provinceBean.refershBean(addressBean.pid, addressBean.pname);
            }
            this.cityBean.refershBean(str2, str3);
            this.districtBean.resetBean();
            this.townBean.resetBean();
        } else if (AddressLevel.DISTRICT.getName().equals(str)) {
            this.districtBean.refershBean(str2, str3);
            this.townBean.resetBean();
        } else if (AddressLevel.TOWN.getName().equals(str)) {
            if (addressBean.isNotSelected) {
                this.townBean.resetBean();
            } else {
                this.townBean.refershBean(str2, str3);
            }
        }
    }

    private void makePage(int i, AddressBean addressBean, String str, String str2, String str3) {
        int i2 = i + 1;
        ListPagerView listPagerView = this.mViewList.get(i2);
        if (!listPagerView.getPagerAddressId().equals(str)) {
            makeEntity2Result(addressBean);
            addTab2Layout(i, str3, false);
            listPagerView.setSelectedAddressId(str2);
            listPagerView.loadData(str);
            int i3 = i2 + 1;
            this.mRealPagerNumber = i3;
            this.mViewPager.setRealPagerNumber(i3);
        }
    }

    private void refershPageFromEntity() {
        int i;
        AddressSelectedBean addressSelectedBean = this.mAddressSelectedBean;
        if (addressSelectedBean == null) {
            return;
        }
        if (!TextUtils.isEmpty(addressSelectedBean.provinceId)) {
            this.mViewList.get(0).setSelectedAddressId(this.mAddressSelectedBean.provinceId);
            this.mViewList.get(1).loadData(this.mAddressSelectedBean.provinceId);
            ResultHelpBean resultHelpBean = this.provinceBean;
            AddressSelectedBean addressSelectedBean2 = this.mAddressSelectedBean;
            resultHelpBean.refershBean(addressSelectedBean2.provinceId, addressSelectedBean2.provinceName);
            i = 2;
        } else {
            i = 1;
        }
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.cityId)) {
            this.mViewList.get(i - 1).setSelectedAddressId(this.mAddressSelectedBean.cityId);
            this.mViewList.get(i).loadData(this.mAddressSelectedBean.cityId);
            ResultHelpBean resultHelpBean2 = this.cityBean;
            AddressSelectedBean addressSelectedBean3 = this.mAddressSelectedBean;
            resultHelpBean2.refershBean(addressSelectedBean3.cityId, addressSelectedBean3.cityName);
            i++;
        }
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.districtId)) {
            this.mViewList.get(i - 1).setSelectedAddressId(this.mAddressSelectedBean.districtId);
            this.mViewList.get(i).loadData(this.mAddressSelectedBean.districtId);
            ResultHelpBean resultHelpBean3 = this.districtBean;
            AddressSelectedBean addressSelectedBean4 = this.mAddressSelectedBean;
            resultHelpBean3.refershBean(addressSelectedBean4.districtId, addressSelectedBean4.districtName);
            i++;
        }
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.townId)) {
            this.mViewList.get(i - 1).setSelectedAddressId(this.mAddressSelectedBean.townId);
            ResultHelpBean resultHelpBean4 = this.townBean;
            AddressSelectedBean addressSelectedBean5 = this.mAddressSelectedBean;
            resultHelpBean4.refershBean(addressSelectedBean5.townId, addressSelectedBean5.townName);
            i++;
        }
        int i2 = i - 1;
        this.mRealPagerNumber = i2;
        this.mViewPager.setRealPagerNumber(i2);
    }

    private void refershTabFromEntity() {
        int i;
        String str;
        if (this.mAddressSelectedBean == null) {
            return;
        }
        List<String> titles = this.mTabLayout.getTitles();
        boolean z = false;
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.provinceId)) {
            titles.set(0, this.mAddressSelectedBean.provinceName);
            i = 1;
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.cityId)) {
            titles.set(i, this.mAddressSelectedBean.cityName);
            i++;
        }
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.districtId)) {
            titles.set(i, this.mAddressSelectedBean.districtName);
            i++;
        }
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.townId)) {
            titles.set(i, this.mAddressSelectedBean.townName);
            i++;
        } else {
            z = true;
        }
        for (int i2 = i; i2 < titles.size(); i2++) {
            if (i2 == i && z) {
                str = "请选择";
            } else {
                str = "";
            }
            titles.set(i, str);
        }
        this.mTabLayout.setTitles(titles);
        this.mTabLayout.notifyDataSetChanged();
        this.mTabLayout.postDelayed(new Runnable() { // from class: com.baidu.pass.ecommerce.view.addressdialog.AddressSelectorDialog.3
            @Override // java.lang.Runnable
            public void run() {
                if (AddressSelectorDialog.this.mTabLayout != null) {
                    AddressSelectorDialog.this.mTabLayout.smoothScrollTo(AddressSelectorDialog.this.mTabLayout.getWidth(), 0);
                }
            }
        }, 100L);
        this.mTabLayout.setCurrentTab(i - 1);
    }

    private void setUpPageData() {
        for (int i = 0; i < 4; i++) {
            this.mViewList.add(new ListPagerView(this.mContext, i, this.mIsDarkMode, this));
        }
        AddrListPagerAdapter addrListPagerAdapter = new AddrListPagerAdapter(this.mViewList);
        this.mPagerAdapter = addrListPagerAdapter;
        this.mViewPager.setAdapter(addrListPagerAdapter);
        this.mTabLayout.setViewPager(this.mViewPager, new String[]{"请选择", "", "", ""});
        if (this.mIsDarkMode) {
            this.mTabLayout.setTextUnselectColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608bb));
            this.mTabLayout.setTextSelectColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608bb));
            return;
        }
        this.mTabLayout.setTextUnselectColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608ba));
        this.mTabLayout.setTextSelectColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608ba));
    }

    private void resultWithFinsh() {
        if (this.mOnDialogSelectedListenter != null) {
            this.mAddressSelectedBean.provinceId = this.provinceBean.id;
            this.mAddressSelectedBean.provinceName = this.provinceBean.name;
            this.mAddressSelectedBean.cityId = this.cityBean.id;
            this.mAddressSelectedBean.cityName = this.cityBean.name;
            this.mAddressSelectedBean.districtId = this.districtBean.id;
            this.mAddressSelectedBean.districtName = this.districtBean.name;
            this.mAddressSelectedBean.townId = this.townBean.id;
            this.mAddressSelectedBean.townName = this.townBean.name;
            this.mOnDialogSelectedListenter.onItemSelected(this.mAddressSelectedBean);
        }
        dismiss();
    }

    private void setUpResultModel() {
        if (this.mAddressSelectedBean != null) {
            refershTabFromEntity();
            refershPageFromEntity();
            return;
        }
        AddressSelectedBean addressSelectedBean = new AddressSelectedBean();
        this.mAddressSelectedBean = addressSelectedBean;
        addressSelectedBean.countryId = ListPagerView.REQUEST_PARAM_CHINA;
        addressSelectedBean.countryName = "中国";
    }

    public void destory() {
        List<ListPagerView> list = this.mViewList;
        if (list != null) {
            for (ListPagerView listPagerView : list) {
                listPagerView.destroy();
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    private void setUpView() {
        setContentView(R.layout.obfuscated_res_0x7f0d052f);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ed);
        }
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.obfuscated_res_0x7f091eaf);
        this.mTabLayout = slidingTabLayout;
        slidingTabLayout.setOnTabSelectListener(this);
        this.mTabLayout.setTextSelectColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f06088f));
        AddrViewPager addrViewPager = (AddrViewPager) findViewById(R.id.obfuscated_res_0x7f091f57);
        this.mViewPager = addrViewPager;
        this.mRealPagerNumber = 1;
        addrViewPager.setRealPagerNumber(1);
        findViewById(R.id.obfuscated_res_0x7f091ef3).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.pass.ecommerce.view.addressdialog.AddressSelectorDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AddressSelectorDialog.this.dismiss();
            }
        });
        if (this.mIsDarkMode) {
            Resources resources = getContext().getResources();
            findViewById(R.id.obfuscated_res_0x7f091eae).setBackgroundResource(R.drawable.obfuscated_res_0x7f0810df);
            ((TextView) findViewById(R.id.obfuscated_res_0x7f091eb0)).setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0608bb));
            findViewById(R.id.obfuscated_res_0x7f091eb1).setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f0608b9));
            this.mTabLayout.setIndicatorColor(R.drawable.obfuscated_res_0x7f0810d7);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        if (!SapiAccountManager.getInstance().getConfignation().isNightMode && !SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.mIsDarkMode = false;
        } else {
            this.mIsDarkMode = true;
        }
        super.onCreate(bundle);
        setUpView();
        setUpPageData();
        setUpResultModel();
        this.mViewList.get(0).loadData();
    }

    @Override // com.baidu.pass.ecommerce.view.addressdialog.ListPagerView.OnEntitySelectedListener
    public void onEntitySelected(int i, AddressBean addressBean) {
        String str;
        if (addressBean == null) {
            return;
        }
        String str2 = addressBean.id;
        boolean z = addressBean.isHotCity;
        if (addressBean.isNotSelected) {
            str = "请选择";
        } else {
            str = addressBean.name;
        }
        String str3 = str;
        if (addressBean.hasLeaf && i != 3) {
            if (z && !ListPagerView.REQUEST_PARAM_CHINA.equals(addressBean.pid)) {
                makePage(i, addressBean, addressBean.pid, addressBean.id, addressBean.pname);
                makePage(i + 1, addressBean, addressBean.id, null, addressBean.name);
            } else {
                makePage(i, addressBean, str2, null, str3);
            }
            this.mTabLayout.setCurrentTab(this.mRealPagerNumber - 1);
            return;
        }
        addTab2Layout(i, str3, true);
        makeEntity2Result(addressBean);
        resultWithFinsh();
    }
}
