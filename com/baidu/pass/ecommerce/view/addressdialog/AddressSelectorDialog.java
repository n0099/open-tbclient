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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.adapter.AddrListPagerAdapter;
import com.baidu.pass.ecommerce.view.SlidingTabLayout;
import com.baidu.pass.ecommerce.view.addressdialog.ListPagerView;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.ecommerce.result.AddressBean;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AddressSelectorDialog extends Dialog implements NoProguard, ListPagerView.OnEntitySelectedListener, OnTabSelectListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes2.dex */
    public static class ResultHelpBean {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String id;
        public String name;

        public ResultHelpBean() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void refershBean(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.id = str;
                this.name = str2;
            }
        }

        public void resetBean() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.id = "";
                this.name = "";
            }
        }

        public ResultHelpBean(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.id = str;
            this.name = str2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AddressSelectorDialog(@NonNull Context context) {
        this(context, (int) R.style.obfuscated_res_0x7f1003de);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addTab2Layout(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) != null) {
            return;
        }
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
                this.mTabLayout.postDelayed(new Runnable(this) { // from class: com.baidu.pass.ecommerce.view.addressdialog.AddressSelectorDialog.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressSelectorDialog this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mTabLayout == null) {
                            return;
                        }
                        this.this$0.mTabLayout.smoothScrollTo(this.this$0.mTabLayout.getWidth(), 0);
                    }
                }, 100L);
                return;
            }
        }
    }

    private void makeEntity2Result(AddressBean addressBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, addressBean) == null) {
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
    }

    private void makePage(int i, AddressBean addressBean, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), addressBean, str, str2, str3}) == null) {
            int i2 = i + 1;
            ListPagerView listPagerView = this.mViewList.get(i2);
            if (listPagerView.getPagerAddressId().equals(str)) {
                return;
            }
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
        AddressSelectedBean addressSelectedBean;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (addressSelectedBean = this.mAddressSelectedBean) == null) {
            return;
        }
        if (TextUtils.isEmpty(addressSelectedBean.provinceId)) {
            i = 1;
        } else {
            this.mViewList.get(0).setSelectedAddressId(this.mAddressSelectedBean.provinceId);
            this.mViewList.get(1).loadData(this.mAddressSelectedBean.provinceId);
            ResultHelpBean resultHelpBean = this.provinceBean;
            AddressSelectedBean addressSelectedBean2 = this.mAddressSelectedBean;
            resultHelpBean.refershBean(addressSelectedBean2.provinceId, addressSelectedBean2.provinceName);
            i = 2;
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.mAddressSelectedBean == null) {
            return;
        }
        List<String> titles = this.mTabLayout.getTitles();
        boolean z = false;
        if (TextUtils.isEmpty(this.mAddressSelectedBean.provinceId)) {
            i = 0;
        } else {
            titles.set(0, this.mAddressSelectedBean.provinceName);
            i = 1;
        }
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.cityId)) {
            titles.set(i, this.mAddressSelectedBean.cityName);
            i++;
        }
        if (!TextUtils.isEmpty(this.mAddressSelectedBean.districtId)) {
            titles.set(i, this.mAddressSelectedBean.districtName);
            i++;
        }
        if (TextUtils.isEmpty(this.mAddressSelectedBean.townId)) {
            z = true;
        } else {
            titles.set(i, this.mAddressSelectedBean.townName);
            i++;
        }
        int i2 = i;
        while (i2 < titles.size()) {
            titles.set(i, (i2 == i && z) ? "请选择" : "");
            i2++;
        }
        this.mTabLayout.setTitles(titles);
        this.mTabLayout.notifyDataSetChanged();
        this.mTabLayout.postDelayed(new Runnable(this) { // from class: com.baidu.pass.ecommerce.view.addressdialog.AddressSelectorDialog.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AddressSelectorDialog this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mTabLayout == null) {
                    return;
                }
                this.this$0.mTabLayout.smoothScrollTo(this.this$0.mTabLayout.getWidth(), 0);
            }
        }, 100L);
        this.mTabLayout.setCurrentTab(i - 1);
    }

    private void resultWithFinsh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
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
    }

    private void setUpPageData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            for (int i = 0; i < 4; i++) {
                this.mViewList.add(new ListPagerView(this.mContext, i, this.mIsDarkMode, this));
            }
            AddrListPagerAdapter addrListPagerAdapter = new AddrListPagerAdapter(this.mViewList);
            this.mPagerAdapter = addrListPagerAdapter;
            this.mViewPager.setAdapter(addrListPagerAdapter);
            this.mTabLayout.setViewPager(this.mViewPager, new String[]{"请选择", "", "", ""});
            if (this.mIsDarkMode) {
                this.mTabLayout.setTextUnselectColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_title_text_dark_color));
                this.mTabLayout.setTextSelectColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_title_text_dark_color));
                return;
            }
            this.mTabLayout.setTextUnselectColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_title_text_color));
            this.mTabLayout.setTextSelectColor(this.mContext.getResources().getColor(R.color.sapi_sdk_dialog_address_selector_title_text_color));
        }
    }

    private void setUpResultModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
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
    }

    private void setUpView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            setContentView(R.layout.layout_sapi_sdk_dialog_address_selector);
            Window window = getWindow();
            if (window != null) {
                window.setGravity(80);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f1003e0);
            }
            SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sapi_sdk_addr_select_tab_layout);
            this.mTabLayout = slidingTabLayout;
            slidingTabLayout.setOnTabSelectListener(this);
            this.mTabLayout.setTextSelectColor(this.mContext.getResources().getColor(R.color.sapi_sdk_common_select_btn_text_color));
            AddrViewPager addrViewPager = (AddrViewPager) findViewById(R.id.sapi_sdk_vp_address_list);
            this.mViewPager = addrViewPager;
            this.mRealPagerNumber = 1;
            addrViewPager.setRealPagerNumber(1);
            findViewById(R.id.sapi_sdk_iv_address_dialog_close).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.pass.ecommerce.view.addressdialog.AddressSelectorDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressSelectorDialog this$0;

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
                        this.this$0.dismiss();
                    }
                }
            });
            if (this.mIsDarkMode) {
                Resources resources = getContext().getResources();
                findViewById(R.id.sapi_sdk_addr_select_layout).setBackgroundResource(R.drawable.sapi_sdk_dialog_address_selector_dark_bg);
                ((TextView) findViewById(R.id.sapi_sdk_addr_select_title)).setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_title_text_dark_color));
                findViewById(R.id.sapi_sdk_addr_select_title_bottom_line).setBackgroundColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_line_dark_color));
                this.mTabLayout.setIndicatorColor(R.drawable.sapi_sdk_dialog_address_indicator_checked_dark);
            }
        }
    }

    public void destory() {
        List<ListPagerView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.mViewList) == null) {
            return;
        }
        for (ListPagerView listPagerView : list) {
            listPagerView.destroy();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
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
    }

    @Override // com.baidu.pass.ecommerce.view.addressdialog.ListPagerView.OnEntitySelectedListener
    public void onEntitySelected(int i, AddressBean addressBean) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, addressBean) == null) || addressBean == null) {
            return;
        }
        String str = addressBean.id;
        boolean z = addressBean.isHotCity;
        String str2 = addressBean.isNotSelected ? "请选择" : addressBean.name;
        if (addressBean.hasLeaf && i != 3) {
            if (z && !ListPagerView.REQUEST_PARAM_CHINA.equals(addressBean.pid)) {
                makePage(i, addressBean, addressBean.pid, addressBean.id, addressBean.pname);
                makePage(i + 1, addressBean, addressBean.id, null, addressBean.name);
            } else {
                makePage(i, addressBean, str, null, str2);
            }
            this.mTabLayout.setCurrentTab(this.mRealPagerNumber - 1);
            return;
        }
        addTab2Layout(i, str2, true);
        makeEntity2Result(addressBean);
        resultWithFinsh();
    }

    @Override // com.baidu.pass.ecommerce.view.addressdialog.OnTabSelectListener
    public void onTabReselect(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }

    @Override // com.baidu.pass.ecommerce.view.addressdialog.OnTabSelectListener
    public void onTabSelect(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || i >= this.mRealPagerNumber) {
            return;
        }
        this.mViewPager.setCurrentItem(i, true);
    }

    public void setAddressSelectedBean(AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, addressSelectedBean) == null) {
            if (addressSelectedBean == null) {
                AddressSelectedBean addressSelectedBean2 = new AddressSelectedBean();
                this.mAddressSelectedBean = addressSelectedBean2;
                addressSelectedBean2.countryId = ListPagerView.REQUEST_PARAM_CHINA;
                addressSelectedBean2.countryName = "中国";
            } else if (this.mAddressSelectedBean.compare(addressSelectedBean)) {
            } else {
                this.mAddressSelectedBean = addressSelectedBean;
                refershTabFromEntity();
                refershPageFromEntity();
            }
        }
    }

    public void setOnDialogSelectedListenter(OnDialogSelectedListenter onDialogSelectedListenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onDialogSelectedListenter) == null) {
            this.mOnDialogSelectedListenter = onDialogSelectedListenter;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.show();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AddressSelectorDialog(@NonNull Context context, AddressSelectedBean addressSelectedBean) {
        this(context, (int) R.style.obfuscated_res_0x7f1003de);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, addressSelectedBean};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mAddressSelectedBean = addressSelectedBean;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AddressSelectorDialog(@NonNull Context context, AddressSelectedBean addressSelectedBean, boolean z) {
        this(context, (int) R.style.obfuscated_res_0x7f1003de);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, addressSelectedBean, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mAddressSelectedBean = addressSelectedBean;
        this.mIsDarkMode = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressSelectorDialog(@NonNull Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mViewList = new ArrayList();
        this.provinceBean = new ResultHelpBean();
        this.cityBean = new ResultHelpBean();
        this.districtBean = new ResultHelpBean();
        this.townBean = new ResultHelpBean();
        this.mContext = context;
    }
}
