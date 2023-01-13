package com.baidu.sapi2.ecommerce.activity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.AddressStatUtil;
import com.baidu.pass.ecommerce.ContactUtil;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.pass.ecommerce.adapter.AddressConverter;
import com.baidu.pass.ecommerce.adapter.SuggestAddrListAdapter;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.ecommerce.callback.GetContactCallback;
import com.baidu.pass.ecommerce.callback.SimpleTextWatcher;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.pass.ecommerce.common.view.CheckedRadioButton;
import com.baidu.pass.ecommerce.common.view.InputFormView;
import com.baidu.pass.ecommerce.common.view.LoadingUtil;
import com.baidu.pass.ecommerce.common.view.TextFormView;
import com.baidu.pass.ecommerce.common.view.TitleBarView;
import com.baidu.pass.ecommerce.dialog.ImgOcrOptionDialog;
import com.baidu.pass.ecommerce.presenter.AddressEditPresenter;
import com.baidu.pass.ecommerce.result.GetContactResult;
import com.baidu.pass.ecommerce.view.LengthLimitEditText;
import com.baidu.pass.ecommerce.view.addressdialog.AddressSelectorDialog;
import com.baidu.pass.ecommerce.view.addressdialog.ListPagerView;
import com.baidu.pass.ecommerce.view.addressdialog.OnDialogSelectedListenter;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.BaseOptionActivity;
import com.baidu.sapi2.ecommerce.callback.MapStatusAndLocateCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.AddressSelectedBean;
import com.baidu.sapi2.stat.AddressManagerStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SoftKeyBoardListener;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.kuaishou.weapon.p0.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddressEditActivity extends BaseAddressActivity<AddressEditPresenter> implements ImgOcrOptionDialog.OptionOnClickListener, OnDialogSelectedListenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADDRESS_4_ELEMENT = 15;
    public static final String CHINA_REGION_CODE = "86";
    public static final int CUSTOM_TEXT_LENGTH = 5;
    public static final int DETAIL_FLAG = 8;
    public static final int DETAIL_TEXT_MAX_LENGTH = 120;
    public static final int DETAIL_TEXT_MIN_LENGTH = 4;
    public static final String KEY_ADDRESS_ADDR_REGION_BEAN = "key_address_addr_region_bean";
    public static final String KEY_ADDRESS_DETAIL_MAP_OBJ = "key_address_detail_map_obj";
    public static final String KEY_BDSTOKEN_FROM_ADDRLIST = "key_bdstoken_from_addrlist";
    public static final String MAP_LOC_ADDR_DETAIL = "map_loc_addr_detail";
    public static final String MAP_LOC_REGION_DETAIL = "map_loc_region_detail";
    public static final int MOBILE_FLAG = 2;
    public static final int MOBILE_TEXT_LENGTH = 11;
    public static final int NAME_FLAG = 1;
    public static final int NAME_TEXT_LENGTH = 25;
    public static final String OPTION_DIALOG_TAG = "img_ocr_option_dialog_tag";
    public static final int REGION_FLAG = 4;
    public static final int REQUEST_CODE_OPEN_GPS = 10010;
    public static final int REQUEST_MAP_LOC_REGION = 10001;
    public static final String TAG = "AddressEditActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView addTagBtn;
    public ScrollView addrContentSv;
    public View addrCopyLayout;
    public RadioGroup addrTagGroup;
    public int addressElementStatus;
    public String addressId;
    public boolean autoCleanMobileStr;
    public boolean autoSetMobile;
    public TextView checkedCustomTagTv;
    public TextView cleanLongTextBtn;
    public CheckedRadioButton companyTagRb;
    public TextFormView copyFormView;
    public View customTagLayout;
    public View customTagLine;
    public View defaultTagClose;
    public View defaultTagOpen;
    public TextView delAddrBtn;
    public CommonDialog delAddrDialog;
    public LengthLimitEditText detailAddrEt;
    public InputFormView detailInput;
    public TextView editTagConfirmBtn;
    public LengthLimitEditText editTagEt;
    public View editTagLayout;
    public CheckedRadioButton homeTagRb;
    public View imgOcrBtn;
    public ImageView imgOcrIcon;
    public String inputDetailAddr;
    public String inputMobile;
    public boolean isActivityStopped;
    public boolean isAutoSetAddrDetailText;
    public boolean isAutoSetNameText;
    public boolean isCheckedCustomTag;
    public boolean isClickConfirmCustomTag;
    public boolean isClipBoardAddrDialogShowed;
    public boolean isCreateAddress;
    public View isDefaultToggle;
    public boolean isFocusAddrDetailEt;
    public boolean isFocusCopyAddrEt;
    public boolean isFocusCustomTagEt;
    public boolean isKeyBoardShowing;
    public boolean isSetDefaultAddr;
    public boolean isShowImgOcrDialog;
    public boolean isShowRegionSelectDialog;
    public ImageView ivAddrCopyToggle;
    public SuggestAddrListAdapter listAdapter;
    public TextView mapAddrCheckValidTv;
    public InputFormView mobileInput;
    public LengthLimitEditText mobileInputEt;
    public InputFormView nameInput;
    public LengthLimitEditText nameInputEt;
    public MapObject newMapObject;
    public ImgOcrOptionDialog ocrOptionDialog;
    public String oldAddressTagValue;
    public CommonDialog openGPSDialog;
    public View regionLayout;
    public AddressSelectorDialog regionSelectorDialog;
    public View rootView;
    public CheckedRadioButton schoolTagRb;
    public ImageView selectRegionIv;
    public AddressSelectedBean selectedRegion;
    public View suggestAddrLayout;
    public ListView suggestAddrListView;
    public EditText textOcrEt;
    public TitleBarView titleBarView;
    public TextView tvRegion;
    public ImageView updateCustomTagBtn;
    public TextView useLongTextBtn;
    public CommonDialog usePastedAddrDialog;
    public View voiceOcrBtn;

    public AddressEditActivity() {
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

    private boolean checkGpsSwitcherStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, this)) == null) {
            return ((LocationManager) getSystemService("location")).isProviderEnabled("gps");
        }
        return invokeV.booleanValue;
    }

    private void processUpdateAddrResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65618, this) == null) {
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_EDIT_FINISH);
            Intent intent = new Intent();
            intent.putExtra(AddressListActivity.CREATE_ADDRESS_RESULT, this.newMapObject);
            intent.putExtra(AddressListActivity.CREATE_REGION_RESULT, this.selectedRegion);
            setResult(1002, intent);
            finish();
        }
    }

    private void setTopRightBtnEnableStatus() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65626, this) == null) {
            TitleBarView titleBarView = this.titleBarView;
            if (15 == this.addressElementStatus) {
                z = true;
            } else {
                z = false;
            }
            titleBarView.setRightBtnEnable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImgOcrOptionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65628, this) == null) {
            if (this.ocrOptionDialog == null) {
                ImgOcrOptionDialog imgOcrOptionDialog = new ImgOcrOptionDialog(this.isDarkMode);
                this.ocrOptionDialog = imgOcrOptionDialog;
                imgOcrOptionDialog.setCancelable(true);
                this.ocrOptionDialog.setOptionOnClickListener(this);
            }
            this.ocrOptionDialog.show(getSupportFragmentManager(), OPTION_DIALOG_TAG);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.isOpenEdit) {
                endProcess();
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AddressSelectorDialog addressSelectorDialog = this.regionSelectorDialog;
            if (addressSelectorDialog != null) {
                addressSelectorDialog.destory();
            }
            super.onDestroy();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            this.isActivityStopped = false;
            readClipBoardAddrText();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            this.isActivityStopped = true;
        }
    }

    private void processDelAddrResult(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65613, this, str) == null) {
            Intent intent = new Intent();
            intent.putExtra(AddressListActivity.DEL_ADDRESS_ID, str);
            setResult(1002, intent);
            finish();
        }
    }

    private void processImgOcrResult(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65614, this, obj) == null) && (obj instanceof String)) {
            this.textOcrEt.setText((String) obj);
            openAddrCopyLayout();
        }
    }

    private void processRecogniseTextOcrResult(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65616, this, obj) == null) {
            if (obj == null) {
                ToastUtil.show("当前地址信息不完整，建议手动填写");
            }
            selectSuggestAddrDetail(obj);
        }
    }

    @Override // com.baidu.pass.ecommerce.view.addressdialog.OnDialogSelectedListenter
    public void onItemSelected(AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, addressSelectedBean) != null) || addressSelectedBean == null) {
            return;
        }
        if (TextUtils.isEmpty(addressSelectedBean.countryId)) {
            addressSelectedBean.countryId = ListPagerView.REQUEST_PARAM_CHINA;
            addressSelectedBean.countryName = "中国";
        }
        updateRegion(addressSelectedBean);
    }

    @Override // com.baidu.pass.ecommerce.dialog.ImgOcrOptionDialog.OptionOnClickListener
    public void onOptionClick(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i != 1001) {
                if (i == 1002) {
                    pickPhoto();
                    return;
                }
                return;
            }
            takePhoto();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity
    public void processImgBase64Data(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i, str, str2) == null) {
            if (10000 == i && !TextUtils.isEmpty(str2)) {
                ((AddressEditPresenter) this.presenter).getImgOcrAddressResult(str2);
            } else if (!TextUtils.isEmpty(str)) {
                ToastUtil.show(str);
            }
        }
    }

    private void addAddress4ElementUpdateListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65596, this) == null) {
            this.nameInputEt.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, charSequence, i, i2, i3) == null) {
                        if (!this.this$0.isAutoSetNameText) {
                            this.this$0.nameInput.updateCleanBtnStatus();
                        }
                        this.this$0.isAutoSetNameText = false;
                        String trim = charSequence.toString().trim();
                        this.this$0.newMapObject.putValue("name", trim);
                        this.this$0.updateTopRightBtnStatus(!TextUtils.isEmpty(trim), 1);
                    }
                }
            });
            this.nameInputEt.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view2, z) == null) {
                        this.this$0.nameInput.updateCleanBtnStatus(z);
                    }
                }
            });
            this.mobileInputEt.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view2, z) == null) {
                        this.this$0.mobileInput.updateCleanBtnStatus(z);
                    }
                }
            });
            this.detailAddrEt.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view2, z) == null) {
                        this.this$0.detailInput.updateCleanBtnStatus(z);
                    }
                }
            });
            this.mobileInputEt.setOnKeyListener(new View.OnKeyListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view2, int i, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                        if (i == 67 && this.this$0.autoCleanMobileStr) {
                            this.this$0.autoCleanMobileStr = false;
                            this.this$0.mobileInput.setText("");
                        }
                        return false;
                    }
                    return invokeLIL.booleanValue;
                }
            });
            this.mobileInputEt.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, charSequence, i, i2, i3) == null) {
                        String trim = charSequence.toString().trim();
                        if (this.this$0.autoSetMobile) {
                            this.this$0.autoSetMobile = false;
                        } else {
                            this.this$0.inputMobile = trim;
                            this.this$0.mobileInput.updateCleanBtnStatus();
                        }
                        this.this$0.newMapObject.putValue("mobile", trim);
                        this.this$0.updateTopRightBtnStatus(!TextUtils.isEmpty(trim), 2);
                    }
                }
            });
            this.detailAddrEt.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, charSequence, i, i2, i3) == null) {
                        this.this$0.inputDetailAddr = charSequence.toString().trim();
                        this.this$0.newMapObject.putValue(AddressField.KEY_DETAIL_ADDR, this.this$0.inputDetailAddr);
                        if (!TextUtils.isEmpty(this.this$0.inputDetailAddr) && this.this$0.inputDetailAddr.length() >= 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.this$0.updateTopRightBtnStatus(z, 8);
                        if (!this.this$0.isAutoSetAddrDetailText) {
                            this.this$0.detailInput.updateCleanBtnStatus();
                            if (!TextUtils.isEmpty(this.this$0.inputDetailAddr)) {
                                if (this.this$0.selectedRegion == null) {
                                    return;
                                }
                                this.this$0.scrollToAddrDetail(true);
                                return;
                            }
                            this.this$0.scrollToAddrDetail(false);
                            return;
                        }
                        this.this$0.isAutoSetAddrDetailText = false;
                    }
                }
            });
            this.detailAddrEt.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.this$0.isFocusAddrDetailEt = true;
                        }
                        ViewParent parent = view2.getParent();
                        if (view2 == this.this$0.detailAddrEt && parent != null) {
                            if (motionEvent.getAction() != 1) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            } else {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.addrContentSv.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        if (this.this$0.suggestAddrLayout.getVisibility() == 0) {
                            this.this$0.scrollToAddrDetail(false);
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkedCustomTag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, this) == null) {
            this.isCheckedCustomTag = true;
            this.addrTagGroup.clearCheck();
            this.checkedCustomTagTv.setText(this.editTagEt.getText().toString().trim());
            if (this.isDarkMode) {
                this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060960));
                this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108b);
            } else {
                this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06095f));
                this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108a);
            }
            this.customTagLine.setVisibility(0);
            setTopRightBtnEnableStatus();
        }
    }

    private void callbackAddressResult() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65597, this) != null) || this.addressManageCallback == null) {
            return;
        }
        AddressManageResult addressManageResult = new AddressManageResult();
        HashMap<String, String> hashMap = addressManageResult.map;
        hashMap.put("addrId", this.newMapObject.getStrValue(AddressField.KEY_ADDR_ID));
        hashMap.put("name", this.newMapObject.getStrValue("name"));
        hashMap.put("mobile", this.newMapObject.getStrValue("mobile"));
        hashMap.put("tag", this.newMapObject.getStrValue("tag"));
        hashMap.put("isDefault", "" + this.newMapObject.getIntValue(AddressField.KEY_IS_DEFAULT));
        hashMap.put("addrInfo", this.newMapObject.getStrValue(AddressField.KEY_DETAIL_ADDR));
        hashMap.put("addrRegion", this.selectedRegion.provinceName + this.selectedRegion.cityName + this.selectedRegion.districtName + this.selectedRegion.townName);
        addressManageResult.setResultCode(0);
        this.addressManageCallback.onFinish(addressManageResult);
        AddressManagerStat.upload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGpsSwitcherAndShowDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            if (checkGpsSwitcherStatus()) {
                openAddrMapLocationActivity();
                return;
            }
            CommonDialog build = new CommonDialog.Builder(this).setDarkMode(this.isDarkMode).setTitle("开启定位服务").setMessage("为了正常使用定位功能，请开启定位服务").setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new View.OnClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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
                        this.this$0.openGPSDialog.dismiss();
                    }
                }
            }).setPositiveBtn("去开启", new View.OnClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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
                        this.this$0.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 10010);
                        this.this$0.openGPSDialog.dismiss();
                    }
                }
            }).setCancelable(true).build();
            this.openGPSDialog = build;
            build.show();
        }
    }

    private void requestLocPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65620, this) == null) {
            PermissionsDTO permissionsDTO = new PermissionsDTO();
            permissionsDTO.context = this;
            permissionsDTO.isDarkMode = this.isDarkMode;
            permissionsDTO.permissions = new String[]{h.h, h.g};
            permissionsDTO.dialogTitle = "定位权限";
            permissionsDTO.dialogMsg = "如你选择通过地图选择收货地址，则请允许" + SapiUtils.getAppName(this) + "使用定位权限。你可以通过系统\"设置\"进行权限的管理";
            permissionsDTO.okBtnTxt = "去设置";
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                    }
                }

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

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.checkGpsSwitcherAndShowDialog();
                    }
                }
            });
        }
    }

    private void setDarkModelIcon() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65623, this) == null) && this.isDarkMode) {
            this.nameInput.getImg().setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f060985));
            this.selectRegionIv.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f060985));
            this.imgOcrIcon.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f060985));
            this.ivAddrCopyToggle.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f060985));
            this.selectRegionIv.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f060985));
        }
    }

    private void setListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65625, this) == null) {
            SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                public void keyBoardHide(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeI(1048576, this, i) != null) {
                        return;
                    }
                    this.this$0.isKeyBoardShowing = false;
                    this.this$0.scrollToAddrDetail(false);
                    if (this.this$0.isShowImgOcrDialog) {
                        this.this$0.isShowImgOcrDialog = false;
                        this.this$0.showImgOcrOptionDialog();
                    }
                    if (!this.this$0.isShowRegionSelectDialog) {
                        return;
                    }
                    this.this$0.isShowRegionSelectDialog = false;
                    this.this$0.showRegionSelectorDialog();
                }

                @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                public void keyBoardShow(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                        this.this$0.isKeyBoardShowing = true;
                        if (this.this$0.isFocusAddrDetailEt && this.this$0.selectedRegion != null) {
                            this.this$0.addrContentSv.smoothScrollTo(0, this.this$0.regionLayout.getTop() + SapiUtils.dip2px(this.this$0.getApplication(), 10.0f));
                        }
                        if (this.this$0.isFocusCopyAddrEt) {
                            this.this$0.addrContentSv.smoothScrollBy(0, this.this$0.textOcrEt.getHeight() / 2);
                        }
                        if (this.this$0.isFocusCustomTagEt) {
                            this.this$0.addrContentSv.smoothScrollBy(0, this.this$0.editTagEt.getHeight());
                        }
                        this.this$0.isFocusCustomTagEt = false;
                        this.this$0.isFocusCopyAddrEt = false;
                        this.this$0.isFocusAddrDetailEt = false;
                    }
                }
            });
            this.textOcrEt.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, charSequence, i, i2, i3) == null) {
                        if (TextUtils.isEmpty(charSequence.toString().trim())) {
                            this.this$0.cleanLongTextBtn.setVisibility(8);
                            this.this$0.useLongTextBtn.setVisibility(8);
                            return;
                        }
                        this.this$0.cleanLongTextBtn.setVisibility(0);
                        this.this$0.useLongTextBtn.setVisibility(0);
                    }
                }
            });
            this.textOcrEt.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.this$0.isFocusCopyAddrEt = true;
                        }
                        ViewParent parent = view2.getParent();
                        if (view2 == this.this$0.textOcrEt && parent != null) {
                            if (motionEvent.getAction() != 1) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            } else {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.editTagEt.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        if (motionEvent.getAction() != 0) {
                            return false;
                        }
                        this.this$0.isFocusCustomTagEt = true;
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.suggestAddrListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        InputMethodManager inputMethodManager = (InputMethodManager) this.this$0.getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(this.this$0.detailAddrEt.getWindowToken(), 0);
                        }
                        this.this$0.scrollToAddrDetail(false);
                        ((AddressEditPresenter) this.this$0.presenter).getSuggestAddrDetail(this.this$0.listAdapter.getItem(i), this.this$0.selectedRegion);
                    }
                }
            });
            this.addrTagGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, radioGroup, i) == null) {
                        if (!this.this$0.isClickConfirmCustomTag) {
                            if (R.id.obfuscated_res_0x7f091de4 == i) {
                                this.this$0.unCheckedCustomTag();
                                return;
                            } else if (R.id.obfuscated_res_0x7f091de2 == i) {
                                this.this$0.unCheckedCustomTag();
                                return;
                            } else if (R.id.obfuscated_res_0x7f091de8 == i) {
                                this.this$0.unCheckedCustomTag();
                                return;
                            } else {
                                return;
                            }
                        }
                        this.this$0.isClickConfirmCustomTag = false;
                    }
                }
            });
            this.editTagEt.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, charSequence, i, i2, i3) == null) {
                        this.this$0.editTagConfirmBtn.setEnabled(!TextUtils.isEmpty(charSequence.toString().trim()));
                    }
                }
            });
        }
    }

    private void showDelNoticeDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65627, this) == null) {
            CommonDialog build = new CommonDialog.Builder(this).setDarkMode(this.isDarkMode).setTitle("删除提示").setMessage("确定要删除该地址吗？").setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new View.OnClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.30
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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
                        this.this$0.delAddrDialog.dismiss();
                    }
                }
            }).setPositiveBtn("删除", new View.OnClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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
                        ((AddressEditPresenter) this.this$0.presenter).delAddress(this.this$0.addressId);
                        this.this$0.delAddrDialog.dismiss();
                    }
                }
            }).build();
            this.delAddrDialog = build;
            build.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRegionSelectorDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65629, this) == null) {
            this.nameInputEt.clearFocus();
            this.mobileInputEt.clearFocus();
            this.detailAddrEt.clearFocus();
            AddressSelectorDialog addressSelectorDialog = this.regionSelectorDialog;
            if (addressSelectorDialog == null) {
                AddressSelectorDialog addressSelectorDialog2 = new AddressSelectorDialog(this, this.selectedRegion);
                this.regionSelectorDialog = addressSelectorDialog2;
                addressSelectorDialog2.setCanceledOnTouchOutside(true);
                this.regionSelectorDialog.setOnDialogSelectedListenter(this);
            } else {
                addressSelectorDialog.setAddressSelectedBean(this.selectedRegion);
            }
            if (!this.regionSelectorDialog.isShowing()) {
                this.regionSelectorDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unCheckedCustomTag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65630, this) == null) {
            this.isCheckedCustomTag = false;
            if (this.isDarkMode) {
                this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060964));
                this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810b8);
            } else {
                this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060963));
                this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810b7);
            }
            this.customTagLine.setVisibility(8);
            setTopRightBtnEnableStatus();
        }
    }

    private void checkUserInputAndSubmit() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, this) == null) {
            if (TextUtils.isEmpty(this.nameInput.getContent())) {
                ToastUtil.show("姓名长度需要在1-25个字符之间");
                return;
            }
            if (this.isCreateAddress || !TextUtils.isEmpty(this.inputMobile)) {
                String content = this.mobileInput.getContent();
                if (!SapiUtils.validateMobile(content) || content.length() != 11) {
                    ToastUtil.show("输入的手机号格式有误，请重新输入");
                    return;
                }
            }
            if (this.selectedRegion == null) {
                ToastUtil.show("请选择地区");
            } else if (this.isCreateAddress && (TextUtils.isEmpty(this.inputDetailAddr) || this.inputDetailAddr.length() < 4)) {
                ToastUtil.show("详细地址长度需要在4-120个字符之间");
            } else {
                if (this.isCheckedCustomTag) {
                    str = this.editTagEt.getText().toString().trim();
                } else {
                    int checkedRadioButtonId = this.addrTagGroup.getCheckedRadioButtonId();
                    if (checkedRadioButtonId == R.id.obfuscated_res_0x7f091de4) {
                        str = AddressField.VALUE_HOME_TAG;
                    } else if (checkedRadioButtonId == R.id.obfuscated_res_0x7f091de2) {
                        str = AddressField.VALUE_COMPANY_TAG;
                    } else if (checkedRadioButtonId == R.id.obfuscated_res_0x7f091de8) {
                        str = AddressField.VALUE_SCHOOL_TAG;
                    } else {
                        str = "";
                    }
                }
                this.newMapObject.putValue("tag", str);
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, this.oldAddressTagValue)) {
                    AddressStatUtil.statAddressOption(StatKey.EDITADDR_CHOISE_TAG);
                }
                if (this.isSetDefaultAddr) {
                    this.newMapObject.putValue(AddressField.KEY_IS_DEFAULT, 1);
                } else {
                    this.newMapObject.putValue(AddressField.KEY_IS_DEFAULT, 0);
                }
                if (this.isCreateAddress) {
                    ((AddressEditPresenter) this.presenter).createAddress(this.newMapObject, this.selectedRegion);
                } else {
                    ((AddressEditPresenter) this.presenter).updateAddress(this.inputMobile, this.newMapObject, this.selectedRegion);
                }
            }
        }
    }

    private void closeAddrCopyLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65602, this) == null) {
            this.ivAddrCopyToggle.setImageResource(R.drawable.obfuscated_res_0x7f0810a7);
            if (this.isDarkMode) {
                this.copyFormView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108e);
            } else {
                this.copyFormView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108d);
            }
            this.addrCopyLayout.setVisibility(8);
        }
    }

    private void closeDefaultAddr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65603, this) == null) {
            this.isSetDefaultAddr = false;
            if (this.isDarkMode) {
                this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810a3);
            } else {
                this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810a1);
            }
            this.defaultTagClose.setVisibility(0);
            this.defaultTagOpen.setVisibility(8);
            setTopRightBtnEnableStatus();
        }
    }

    private void initNewAddrMapObj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, this) == null) {
            MapObject mapObject = new MapObject();
            this.newMapObject = mapObject;
            mapObject.putValue(AddressField.KEY_IS_DEFAULT, 0);
            this.newMapObject.putValue("tag", "");
            this.newMapObject.putValue(AddressField.KEY_ZIP_CODE, "");
            this.newMapObject.putValue(AddressField.KEY_MOBILE_COUNTRY_CODE, "0086");
        }
    }

    private void openAddrCopyLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65609, this) == null) {
            this.ivAddrCopyToggle.setImageResource(R.drawable.obfuscated_res_0x7f0810a8);
            if (this.isDarkMode) {
                this.copyFormView.setBackgroundResource(R.color.obfuscated_res_0x7f060972);
            } else {
                this.copyFormView.setBackgroundResource(R.color.obfuscated_res_0x7f060971);
            }
            this.addrCopyLayout.setVisibility(0);
        }
    }

    private void openAddrMapLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65610, this) == null) {
            Intent intent = new Intent(this, MapLocationAddrActivity.class);
            intent.putExtra("key_from_type", this.isCreateAddress);
            intent.putExtra(MapLocationAddrActivity.KEY_BDSTOKEN_FROM_ADDR_EDIT, ((AddressEditPresenter) this.presenter).getBdSTokenFromAddrList());
            startActivityForResult(intent, 10001);
            overridePendingTransition(R.anim.obfuscated_res_0x7f010111, R.anim.obfuscated_res_0x7f010113);
        }
    }

    private void openDefaultAddr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65611, this) == null) {
            this.isSetDefaultAddr = true;
            if (this.isDarkMode) {
                this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108b);
            } else {
                this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108a);
            }
            this.defaultTagClose.setVisibility(8);
            this.defaultTagOpen.setVisibility(0);
            setTopRightBtnEnableStatus();
        }
    }

    private void readClipBoardAddrText() {
        boolean z;
        SapiOptions.Gray.GrayModule grayModuleByFunName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65619, this) == null) {
            SapiOptions.Gray gray = SapiContext.getInstance().getSapiOptions().gray;
            if (gray != null && (grayModuleByFunName = gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_CLIPBOARD_ADDR)) != null) {
                z = grayModuleByFunName.isMeetGray();
            } else {
                z = false;
            }
            if (z) {
                this.titleBarView.post(new Runnable(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AddressEditActivity this$0;

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
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.isCreateAddress && !this.this$0.isClipBoardAddrDialogShowed) {
                            String readClipBoardAddrText = ((AddressEditPresenter) this.this$0.presenter).readClipBoardAddrText(this.this$0);
                            if (!TextUtils.isEmpty(readClipBoardAddrText)) {
                                ((AddressEditPresenter) this.this$0.presenter).recogniseTextOcrAddressResult(readClipBoardAddrText, 3003);
                            }
                        }
                    }
                });
            }
        }
    }

    private void setInputBeyondLengthLimitListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65624, this) == null) {
            this.nameInputEt.setOnTextBeyondLengthLimitListener(new LengthLimitEditText.OnTextBeyondLengthLimitListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.view.LengthLimitEditText.OnTextBeyondLengthLimitListener
                public void onBeyondLengthLimit() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ToastUtil.show("姓名长度不超过25位");
                    }
                }
            });
            this.mobileInputEt.setOnTextBeyondLengthLimitListener(new LengthLimitEditText.OnTextBeyondLengthLimitListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.view.LengthLimitEditText.OnTextBeyondLengthLimitListener
                public void onBeyondLengthLimit() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ToastUtil.show("手机号不超过11位");
                    }
                }
            });
            this.detailAddrEt.setOnTextBeyondLengthLimitListener(new LengthLimitEditText.OnTextBeyondLengthLimitListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.view.LengthLimitEditText.OnTextBeyondLengthLimitListener
                public void onBeyondLengthLimit() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ToastUtil.show("地址长度不超过120位");
                    }
                }
            });
            this.editTagEt.setOnTextBeyondLengthLimitListener(new LengthLimitEditText.OnTextBeyondLengthLimitListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // com.baidu.pass.ecommerce.view.LengthLimitEditText.OnTextBeyondLengthLimitListener
                public void onBeyondLengthLimit() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ToastUtil.show("标签长度不超过5位");
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity
    public AddressEditPresenter createPresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AddressEditPresenter addressEditPresenter = new AddressEditPresenter();
            String stringExtra = getIntent().getStringExtra(KEY_BDSTOKEN_FROM_ADDRLIST);
            if (TextUtils.isEmpty(stringExtra)) {
                addressEditPresenter.getBdStokenFromServer(Integer.MIN_VALUE, null);
            } else {
                addressEditPresenter.setBdSTokenFromAddrList(stringExtra);
            }
            return addressEditPresenter;
        }
        return (AddressEditPresenter) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.isCreateAddress) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_COSTTIME_ADD, gapTimeFromEnter());
            } else {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_COSTTIME_EDIT, gapTimeFromEnter());
            }
            super.finish();
            if (!this.isOpenEdit) {
                overridePendingTransition(0, R.anim.obfuscated_res_0x7f010112);
            }
        }
    }

    private String getRegionDetailStr(AddressSelectedBean addressSelectedBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, this, addressSelectedBean)) == null) {
            if (addressSelectedBean == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(addressSelectedBean.provinceName)) {
                sb.append(addressSelectedBean.provinceName);
                sb.append(GlideException.IndentedAppendable.INDENT);
            }
            if (!TextUtils.isEmpty(addressSelectedBean.cityName)) {
                sb.append(addressSelectedBean.cityName);
                sb.append(GlideException.IndentedAppendable.INDENT);
            }
            if (!TextUtils.isEmpty(addressSelectedBean.districtName)) {
                sb.append(addressSelectedBean.districtName);
                sb.append(GlideException.IndentedAppendable.INDENT);
            }
            if (!TextUtils.isEmpty(addressSelectedBean.townName)) {
                sb.append(addressSelectedBean.townName);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private void initDefaultTagLayout(boolean z) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65605, this, z) == null) {
            if (z) {
                viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091db9);
            } else {
                viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091dbb);
            }
            View inflate = viewStub.inflate();
            this.addrTagGroup = (RadioGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091de3);
            this.homeTagRb = (CheckedRadioButton) inflate.findViewById(R.id.obfuscated_res_0x7f091de4);
            this.companyTagRb = (CheckedRadioButton) inflate.findViewById(R.id.obfuscated_res_0x7f091de2);
            this.schoolTagRb = (CheckedRadioButton) inflate.findViewById(R.id.obfuscated_res_0x7f091de8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToAddrDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65621, this, z) == null) {
            if (z) {
                this.addrContentSv.smoothScrollTo(0, this.regionLayout.getTop() + SapiUtils.dip2px(this, 10.0f));
                if (!TextUtils.isEmpty(this.detailAddrEt.getText().toString().trim())) {
                    ((AddressEditPresenter) this.presenter).getSuggestAddrList(this.inputDetailAddr, this.selectedRegion);
                    this.suggestAddrLayout.setVisibility(0);
                    return;
                }
                return;
            }
            this.addrContentSv.smoothScrollTo(0, 0);
            this.suggestAddrLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectSuggestAddrDetail(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65622, this, obj) == null) && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            updateRegion(AddressConverter.convertRegionJsonObj2Region(jSONObject));
            String optString = jSONObject.optString(AddressField.KEY_DETAIL_ADDR);
            if (!TextUtils.isEmpty(optString)) {
                this.newMapObject.putValue(AddressField.KEY_DETAIL_ADDR, optString);
                this.isAutoSetAddrDetailText = true;
                this.detailAddrEt.setText(optString);
            }
            String optString2 = jSONObject.optString("name");
            if (!TextUtils.isEmpty(optString2)) {
                this.nameInput.setText(optString2);
            }
            String optString3 = jSONObject.optString("phone");
            if (!TextUtils.isEmpty(optString3)) {
                this.mobileInput.setText(optString3);
            }
        }
    }

    private void initView() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65607, this) == null) {
            this.rootView = findViewById(R.id.obfuscated_res_0x7f091dc3);
            this.titleBarView = (TitleBarView) findViewById(R.id.obfuscated_res_0x7f091e08);
            this.addrContentSv = (ScrollView) findViewById(R.id.obfuscated_res_0x7f091db1);
            InputFormView inputFormView = (InputFormView) findViewById(R.id.obfuscated_res_0x7f091dd3);
            this.nameInput = inputFormView;
            this.nameInputEt = inputFormView.getEditText();
            this.nameInput.setDarkMode(this.isDarkMode);
            InputFormView inputFormView2 = (InputFormView) findViewById(R.id.obfuscated_res_0x7f091dd2);
            this.mobileInput = inputFormView2;
            this.mobileInputEt = inputFormView2.getEditText();
            this.mobileInput.setDarkMode(this.isDarkMode);
            this.regionLayout = findViewById(R.id.obfuscated_res_0x7f091dda);
            this.selectRegionIv = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e59);
            this.tvRegion = (TextView) findViewById(R.id.obfuscated_res_0x7f091dae);
            InputFormView inputFormView3 = (InputFormView) findViewById(R.id.obfuscated_res_0x7f091dc1);
            this.detailInput = inputFormView3;
            this.detailAddrEt = inputFormView3.getEditText();
            this.detailInput.setDarkMode(this.isDarkMode);
            this.ivAddrCopyToggle = (ImageView) findViewById(R.id.obfuscated_res_0x7f091db6);
            this.copyFormView = (TextFormView) findViewById(R.id.obfuscated_res_0x7f091db5);
            this.addrCopyLayout = findViewById(R.id.obfuscated_res_0x7f091e02);
            this.textOcrEt = (EditText) findViewById(R.id.obfuscated_res_0x7f091dd6);
            this.cleanLongTextBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091df9);
            this.useLongTextBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091e80);
            this.voiceOcrBtn = findViewById(R.id.obfuscated_res_0x7f091e83);
            this.imgOcrBtn = findViewById(R.id.obfuscated_res_0x7f091e19);
            this.imgOcrIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e17);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091daf);
            this.addTagBtn = imageView;
            if (this.isDarkMode) {
                i = R.drawable.obfuscated_res_0x7f081082;
            } else {
                i = R.drawable.obfuscated_res_0x7f081081;
            }
            imageView.setImageResource(i);
            this.editTagLayout = findViewById(R.id.obfuscated_res_0x7f091e09);
            LengthLimitEditText lengthLimitEditText = (LengthLimitEditText) findViewById(R.id.obfuscated_res_0x7f091e64);
            this.editTagEt = lengthLimitEditText;
            lengthLimitEditText.setLengthLimit(5);
            this.editTagConfirmBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091e63);
            this.customTagLayout = findViewById(R.id.obfuscated_res_0x7f091e03);
            this.checkedCustomTagTv = (TextView) findViewById(R.id.obfuscated_res_0x7f091e05);
            this.customTagLine = findViewById(R.id.obfuscated_res_0x7f091e04);
            this.updateCustomTagBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e06);
            this.isDefaultToggle = findViewById(R.id.obfuscated_res_0x7f091dbc);
            this.defaultTagClose = findViewById(R.id.obfuscated_res_0x7f091db8);
            this.defaultTagOpen = findViewById(R.id.obfuscated_res_0x7f091dba);
            this.suggestAddrLayout = findViewById(R.id.obfuscated_res_0x7f091e5c);
            this.suggestAddrListView = (ListView) findViewById(R.id.obfuscated_res_0x7f091e5d);
            this.delAddrBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091dbe);
            this.mapAddrCheckValidTv = (TextView) findViewById(R.id.obfuscated_res_0x7f091db0);
            initDefaultTagLayout(this.isDarkMode);
            this.titleBarView.setLeft(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, this);
            this.titleBarView.setRight("保存", this);
            this.isDefaultToggle.setOnClickListener(this);
            this.tvRegion.setOnClickListener(this);
            this.cleanLongTextBtn.setOnClickListener(this);
            this.useLongTextBtn.setOnClickListener(this);
            this.selectRegionIv.setOnClickListener(this);
            this.voiceOcrBtn.setOnClickListener(this);
            this.imgOcrBtn.setOnClickListener(this);
            this.copyFormView.setOnClickListener(this);
            this.addTagBtn.setOnClickListener(this);
            this.editTagConfirmBtn.setOnClickListener(this);
            this.updateCustomTagBtn.setOnClickListener(this);
            if (this.isDarkMode) {
                this.mapAddrCheckValidTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081073);
                this.mapAddrCheckValidTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609bb));
                this.rootView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060a41));
                this.titleBarView.setDarkMode();
                this.nameInput.setBackgroundResource(R.drawable.obfuscated_res_0x7f081090);
                this.mobileInput.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060972));
                this.regionLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060972));
                this.tvRegion.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060974));
                this.tvRegion.setHintTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060970));
                findViewById(R.id.obfuscated_res_0x7f091dfc).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06096e));
                this.detailInput.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108e);
                TextFormView textFormView = (TextFormView) findViewById(R.id.obfuscated_res_0x7f091dd5);
                textFormView.setDarkMode();
                textFormView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081090);
                this.imgOcrBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810b8);
                ((TextView) findViewById(R.id.obfuscated_res_0x7f091e18)).setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060976));
                this.addrCopyLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108e);
                findViewById(R.id.obfuscated_res_0x7f091db4).setBackgroundResource(R.drawable.obfuscated_res_0x7f081086);
                this.textOcrEt.setHintTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060970));
                this.textOcrEt.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060974));
                this.cleanLongTextBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810b1);
                this.cleanLongTextBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06095e));
                this.useLongTextBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f081079);
                this.useLongTextBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060984));
                TextFormView textFormView2 = (TextFormView) findViewById(R.id.obfuscated_res_0x7f091dc4);
                textFormView2.setBackgroundResource(R.drawable.obfuscated_res_0x7f081090);
                textFormView2.setDarkMode();
                findViewById(R.id.obfuscated_res_0x7f091e07).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060972));
                this.addTagBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810a3);
                this.editTagEt.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810b8);
                this.editTagEt.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060974));
                this.editTagEt.setHintTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060970));
                this.editTagConfirmBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f081084);
                this.editTagConfirmBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06097c));
                this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060964));
                this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810b8);
                this.customTagLine.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060982));
                this.updateCustomTagBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810d7);
                findViewById(R.id.obfuscated_res_0x7f091dc2).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06096e));
                TextFormView textFormView3 = (TextFormView) findViewById(R.id.obfuscated_res_0x7f091e5a);
                textFormView3.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108e);
                textFormView3.setDarkMode();
                this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f081088);
                this.defaultTagClose.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810c2);
                this.defaultTagOpen.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810c2);
                this.delAddrBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810c3);
                this.delAddrBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06096c));
                this.copyFormView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08108e);
                this.copyFormView.setDarkMode();
                this.suggestAddrLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060978));
            }
            this.checkedCustomTagTv.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.this$0.isCheckedCustomTag) {
                            this.this$0.unCheckedCustomTag();
                            return;
                        }
                        this.this$0.isClickConfirmCustomTag = true;
                        this.this$0.checkedCustomTag();
                    }
                }
            });
            this.nameInput.getImg().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AddressStatUtil.statAddressOption(StatKey.EDITADDR_CONTACT_CLICK);
                        ContactUtil.getInstance().requestContact(this.this$0, new GetContactCallback(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.pass.ecommerce.callback.GetContactCallback
                            public void onCall(GetContactResult getContactResult) {
                                String str;
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeL(1048576, this, getContactResult) == null) && getContactResult != null && !TextUtils.isEmpty(getContactResult.name) && !TextUtils.isEmpty(getContactResult.phone)) {
                                    String str2 = "";
                                    if (TextUtils.isEmpty(getContactResult.name)) {
                                        str = "";
                                    } else {
                                        str = getContactResult.name;
                                    }
                                    this.this$1.this$0.nameInput.setText(str);
                                    if (!TextUtils.isEmpty(getContactResult.phone)) {
                                        String replaceAll = getContactResult.phone.replaceAll(" ", "").replaceAll("\\+", "").replaceAll("-", "");
                                        if (replaceAll.startsWith(AddressEditActivity.CHINA_REGION_CODE)) {
                                            str2 = replaceAll.replaceFirst(AddressEditActivity.CHINA_REGION_CODE, "");
                                        } else {
                                            str2 = replaceAll;
                                        }
                                    }
                                    this.this$1.this$0.mobileInput.setText(str2);
                                    AddressStatUtil.statAddressOption(StatKey.EDITADDR_CONTACT_FINISH);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void initViewByAddrMapObj(MapObject mapObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65608, this, mapObject) != null) || mapObject == null) {
            return;
        }
        this.addressId = mapObject.getStrValue(AddressField.KEY_ADDR_ID);
        boolean z = true;
        this.isAutoSetNameText = true;
        this.nameInput.setText(mapObject.getStrValue("name"));
        String strValue = mapObject.getStrValue("mobile");
        if (!TextUtils.isEmpty(strValue)) {
            this.autoCleanMobileStr = true;
            this.autoSetMobile = true;
            this.mobileInput.setText(strValue);
        }
        this.isAutoSetAddrDetailText = true;
        this.detailInput.setText(mapObject.getStrValue(AddressField.KEY_DETAIL_ADDR));
        String strValue2 = mapObject.getStrValue("tag");
        this.oldAddressTagValue = strValue2;
        if (!TextUtils.isEmpty(strValue2)) {
            String str = this.oldAddressTagValue;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 23478) {
                if (hashCode != 667660) {
                    if (hashCode == 751995 && str.equals(AddressField.VALUE_SCHOOL_TAG)) {
                        c = 1;
                    }
                } else if (str.equals(AddressField.VALUE_COMPANY_TAG)) {
                    c = 2;
                }
            } else if (str.equals(AddressField.VALUE_HOME_TAG)) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        this.addTagBtn.setVisibility(8);
                        this.editTagLayout.setVisibility(8);
                        this.customTagLayout.setVisibility(0);
                        this.editTagEt.setText(this.oldAddressTagValue);
                        this.editTagConfirmBtn.setEnabled(true);
                        checkedCustomTag();
                    } else {
                        this.companyTagRb.setChecked(true);
                    }
                } else {
                    this.schoolTagRb.setChecked(true);
                }
            } else {
                this.homeTagRb.setChecked(true);
            }
        }
        if (mapObject.getIntValue(AddressField.KEY_IS_DEFAULT) != 1) {
            z = false;
        }
        this.isSetDefaultAddr = z;
        if (z) {
            openDefaultAddr();
        } else {
            closeDefaultAddr();
        }
        this.delAddrBtn.setVisibility(0);
        this.delAddrBtn.setOnClickListener(this);
    }

    private void processPastedAddrOcrResult(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65615, this, obj) != null) || this.isActivityStopped) {
            return;
        }
        String str = null;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            StringBuilder sb = new StringBuilder();
            String optString = jSONObject.optString("name");
            if (!TextUtils.isEmpty(optString)) {
                sb.append("姓名：");
                sb.append(optString);
                sb.append("\n");
            }
            String optString2 = jSONObject.optString("phone");
            if (!TextUtils.isEmpty(optString2)) {
                sb.append("电话：");
                sb.append(optString2);
                sb.append("\n");
            }
            String replaceAll = getRegionDetailStr(AddressConverter.convertRegionJsonObj2Region(jSONObject)).replaceAll(" ", "");
            if (!TextUtils.isEmpty(replaceAll)) {
                sb.append("所在地区：");
                sb.append(replaceAll);
                sb.append("\n");
            }
            String optString3 = jSONObject.optString(AddressField.KEY_DETAIL_ADDR);
            if (!TextUtils.isEmpty(optString3)) {
                sb.append("详细地址：");
                sb.append(optString3);
            }
            str = sb.toString();
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            CommonDialog build = new CommonDialog.Builder(this).setTitle("是否使用该地址").setMessage(str).setMessageGravity(3).setNegativeButton("暂不使用", new View.OnClickListener(this) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;

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
                        AddressStatUtil.statAddressOption(StatKey.CLIPBOARD_ADDR_CANCEL_CLICK);
                        this.this$0.usePastedAddrDialog.dismiss();
                    }
                }
            }).setPositiveBtn("使用", new View.OnClickListener(this, obj) { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AddressEditActivity this$0;
                public final /* synthetic */ Object val$object;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obj};
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
                    this.val$object = obj;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.mapAddrCheckValidTv.setVisibility(0);
                        AddressStatUtil.statAddressOption(StatKey.CLIPBOARD_ADDR_CONFIRM_CLICK);
                        this.this$0.usePastedAddrDialog.dismiss();
                        this.this$0.selectSuggestAddrDetail(this.val$object);
                    }
                }
            }).setDarkMode(this.isDarkMode).build();
            this.usePastedAddrDialog = build;
            build.show();
            this.isClipBoardAddrDialogShowed = true;
            hashMap.put("result", "0");
        } else {
            hashMap.put("result", "1");
        }
        AddressStatUtil.statAddressOption(StatKey.CLIPBOARD_TXT_ANALYSE, hashMap);
    }

    private void processCreateAddrResult(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65612, this, obj) == null) && (obj instanceof String)) {
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_ADD_FINISH);
            this.newMapObject.putValue(AddressField.KEY_ADDR_ID, (String) obj);
            if (this.isOpenEdit) {
                callbackAddressResult();
            } else {
                Intent intent = new Intent();
                intent.putExtra(AddressListActivity.CREATE_ADDRESS_RESULT, this.newMapObject);
                intent.putExtra(AddressListActivity.CREATE_REGION_RESULT, this.selectedRegion);
                setResult(1001, intent);
            }
            finish();
        }
    }

    private void updateRegion(AddressSelectedBean addressSelectedBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65631, this, addressSelectedBean) == null) {
            String regionDetailStr = getRegionDetailStr(this.selectedRegion);
            if (!TextUtils.isEmpty(regionDetailStr) && !TextUtils.equals(regionDetailStr, getRegionDetailStr(addressSelectedBean))) {
                ToastUtil.show(R.drawable.obfuscated_res_0x7f08110f, "已切换所在地区");
            }
            this.selectedRegion = addressSelectedBean;
            this.tvRegion.setText(getRegionDetailStr(addressSelectedBean));
            updateTopRightBtnStatus(true, 4);
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && !isFinishing() && !isDestroyed()) {
            if (i != 1001 && i != 1004) {
                if (i != 3001) {
                    if (i == 3002) {
                        LoadingUtil.show("地址识别中");
                        return;
                    }
                    return;
                }
                LoadingUtil.show("图片识别中");
                return;
            }
            LoadingUtil.show("地址保存中");
        }
    }

    private void processSuggestAddrList(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65617, this, str, obj) == null) {
            String trim = this.detailAddrEt.getText().toString().trim();
            if (!TextUtils.isEmpty(trim) && TextUtils.equals(trim, str)) {
                if (this.listAdapter == null) {
                    SuggestAddrListAdapter suggestAddrListAdapter = new SuggestAddrListAdapter(this.isDarkMode);
                    this.listAdapter = suggestAddrListAdapter;
                    this.suggestAddrListView.setAdapter((ListAdapter) suggestAddrListAdapter);
                }
                this.listAdapter.setQueryContent(str);
                this.listAdapter.setData((List) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTopRightBtnStatus(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65632, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.addressElementStatus |= i;
            } else {
                this.addressElementStatus &= ~i;
            }
            setTopRightBtnEnableStatus();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            LoadingUtil.cancel();
            if (i != 2001 && i != 2002) {
                if (i != 3001) {
                    if (i != 3003 && !TextUtils.isEmpty(str)) {
                        ToastUtil.show(R.drawable.obfuscated_res_0x7f0810b4, str);
                        return;
                    }
                    return;
                }
                ToastUtil.show(R.drawable.obfuscated_res_0x7f0810b4, "图片识别失败");
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, obj, str) == null) {
            LoadingUtil.cancel();
            if (i != 1001) {
                if (i != 1002) {
                    if (i != 1004) {
                        if (i != 2001) {
                            if (i != 2002) {
                                switch (i) {
                                    case 3001:
                                        processImgOcrResult(obj);
                                        return;
                                    case 3002:
                                        processRecogniseTextOcrResult(obj);
                                        return;
                                    case 3003:
                                        processPastedAddrOcrResult(obj);
                                        return;
                                    default:
                                        return;
                                }
                            }
                            selectSuggestAddrDetail(obj);
                            return;
                        }
                        processSuggestAddrList(str, obj);
                        return;
                    }
                    processCreateAddrResult(obj);
                    return;
                }
                processDelAddrResult(str);
                return;
            }
            processUpdateAddrResult();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 10001 && intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(MAP_LOC_REGION_DETAIL);
                if (serializableExtra == null) {
                    return;
                }
                updateRegion((AddressSelectedBean) serializableExtra);
                this.isAutoSetAddrDetailText = true;
                this.detailAddrEt.setText(intent.getStringExtra(MAP_LOC_ADDR_DETAIL));
                this.mapAddrCheckValidTv.setVisibility(0);
                if (this.isCreateAddress) {
                    str = "0";
                } else {
                    str = "1";
                }
                AddressStatUtil.onEventAutoStatistic(StatKey.ADDR_EDIT_INFO_FROM_MAP, str);
            } else if (i == 10010 && checkGpsSwitcherStatus()) {
                openAddrMapLocationActivity();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        AddressManageDTO addressManageDTO;
        MapStatusAndLocateCallback mapStatusAndLocateCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("ONCLICK", "currentTime=" + currentTimeMillis + " lastClickTime=" + BaseOptionActivity.lastClickTime);
            if (currentTimeMillis - BaseOptionActivity.lastClickTime < 500) {
                return;
            }
            BaseOptionActivity.lastClickTime = currentTimeMillis;
            int id = view2.getId();
            if (R.id.obfuscated_res_0x7f091dbc == id) {
                if (this.isSetDefaultAddr) {
                    AddressStatUtil.statAddressOption(StatKey.EDITADDR_CANCEL_DEFAULT);
                    closeDefaultAddr();
                    return;
                }
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_SET_DEFAULT);
                openDefaultAddr();
            } else if (R.id.obfuscated_res_0x7f091daf == id) {
                this.addTagBtn.setVisibility(8);
                this.customTagLayout.setVisibility(8);
                this.editTagLayout.setVisibility(0);
            } else if (R.id.obfuscated_res_0x7f091e63 == id) {
                this.isClickConfirmCustomTag = true;
                checkedCustomTag();
                this.editTagLayout.setVisibility(8);
                this.customTagLayout.setVisibility(0);
            } else if (R.id.obfuscated_res_0x7f091e06 == id) {
                this.customTagLayout.setVisibility(8);
                this.editTagLayout.setVisibility(0);
            } else if (R.id.obfuscated_res_0x7f091df9 == id) {
                this.textOcrEt.setText("");
            } else if (R.id.obfuscated_res_0x7f091e80 == id) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_SPLIT_CLICK);
                String trim = this.textOcrEt.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    return;
                }
                ((AddressEditPresenter) this.presenter).recogniseTextOcrAddressResult(trim, 3002);
            } else if (R.id.obfuscated_res_0x7f091dae == id) {
                if (this.isKeyBoardShowing) {
                    this.isShowRegionSelectDialog = true;
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.imgOcrBtn.getWindowToken(), 0);
                        return;
                    }
                    return;
                }
                showRegionSelectorDialog();
            } else if (R.id.obfuscated_res_0x7f091e19 == id) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_CLICK);
                if (this.isKeyBoardShowing) {
                    this.isShowImgOcrDialog = true;
                    InputMethodManager inputMethodManager2 = (InputMethodManager) getSystemService("input_method");
                    if (inputMethodManager2 != null) {
                        inputMethodManager2.hideSoftInputFromWindow(this.imgOcrBtn.getWindowToken(), 0);
                        return;
                    }
                    return;
                }
                showImgOcrOptionDialog();
            } else if (R.id.obfuscated_res_0x7f091e68 == id) {
                if (this.isOpenEdit) {
                    endProcess();
                }
                finish();
            } else if (R.id.obfuscated_res_0x7f091e69 == id) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_SAVEBTN_CLICK);
                checkUserInputAndSubmit();
            } else if (R.id.obfuscated_res_0x7f091db5 == id) {
                if (this.addrCopyLayout.getVisibility() == 0) {
                    closeAddrCopyLayout();
                } else {
                    openAddrCopyLayout();
                }
            } else if (R.id.obfuscated_res_0x7f091dbe == id) {
                showDelNoticeDialog();
            } else if (R.id.obfuscated_res_0x7f091e59 == id) {
                if (this.isCreateAddress) {
                    str = "0";
                } else {
                    str = "1";
                }
                AddressStatUtil.onEventAutoStatistic(StatKey.ADDR_LOCATE_BTN_CLICK, str);
                boolean isMeetGray = SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_ADDRESS_NA_MAP).isMeetGray();
                Log.d(TAG, "isMeetAddrMapGray is " + isMeetGray);
                if (isMeetGray && (addressManageDTO = this.addressManageDTO) != null && (mapStatusAndLocateCallback = addressManageDTO.mapStatusAndLocateCallback) != null && addressManageDTO != null && mapStatusAndLocateCallback != null) {
                    if (mapStatusAndLocateCallback.isMapInitSuccess()) {
                        Log.d(TAG, "mapStatusAndLocateCallback: map init is success");
                        requestLocPermission();
                        return;
                    }
                    Log.d(TAG, "mapStatusAndLocateCallback: map init is failed");
                }
            }
        }
    }

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0501);
            ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.obfuscated_res_0x7f060a42));
            initView();
            addAddress4ElementUpdateListener();
            setInputBeyondLengthLimitListener();
            setDarkModelIcon();
            this.newMapObject = (MapObject) getIntent().getParcelableExtra(KEY_ADDRESS_DETAIL_MAP_OBJ);
            this.selectedRegion = (AddressSelectedBean) getIntent().getSerializableExtra(KEY_ADDRESS_ADDR_REGION_BEAN);
            if (this.newMapObject != null) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_ENTER_EDIT);
                this.titleBarView.setTitle("编辑地址");
                this.isCreateAddress = false;
                initViewByAddrMapObj(this.newMapObject);
                this.titleBarView.setRightBtnEnable(true);
            } else {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_ENTER_ADD);
                this.titleBarView.setTitle("添加地址");
                this.isCreateAddress = true;
                initNewAddrMapObj();
                this.titleBarView.setRightBtnEnable(false);
            }
            AddressSelectedBean addressSelectedBean = this.selectedRegion;
            if (addressSelectedBean != null) {
                this.addressElementStatus |= 4;
                this.tvRegion.setText(getRegionDetailStr(addressSelectedBean));
            }
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_LOADTIME, gapTimeFromEnter());
            setListener();
        }
    }
}
