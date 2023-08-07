package com.baidu.sapi2.ecommerce.activity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.bumptech.glide.load.engine.GlideException;
import com.kuaishou.weapon.p0.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AddressEditActivity extends BaseAddressActivity<AddressEditPresenter> implements ImgOcrOptionDialog.OptionOnClickListener, OnDialogSelectedListenter {
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
    public static String sFromType;
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
    public String imageType = "";
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
    public TextFormView mOcrEditLayout;
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

    private boolean checkGpsSwitcherStatus() {
        return ((LocationManager) getSystemService("location")).isProviderEnabled("gps");
    }

    private void closeDefaultAddr() {
        this.isSetDefaultAddr = false;
        if (this.isDarkMode) {
            this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812bd);
        } else {
            this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812bb);
        }
        this.defaultTagClose.setVisibility(0);
        this.defaultTagOpen.setVisibility(8);
        setTopRightBtnEnableStatus();
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_DEFAULT_OFF);
    }

    private void initNewAddrMapObj() {
        MapObject mapObject = new MapObject();
        this.newMapObject = mapObject;
        mapObject.putValue(AddressField.KEY_IS_DEFAULT, 0);
        this.newMapObject.putValue("tag", "");
        this.newMapObject.putValue(AddressField.KEY_ZIP_CODE, "");
        this.newMapObject.putValue(AddressField.KEY_MOBILE_COUNTRY_CODE, "0086");
    }

    private void openAddrMapLocationActivity() {
        Intent intent = new Intent(this, MapLocationAddrActivity.class);
        intent.putExtra("key_from_type", this.isCreateAddress);
        intent.putExtra(MapLocationAddrActivity.KEY_BDSTOKEN_FROM_ADDR_EDIT, ((AddressEditPresenter) this.presenter).getBdSTokenFromAddrList());
        startActivityForResult(intent, 10001);
        overridePendingTransition(R.anim.obfuscated_res_0x7f01013c, R.anim.obfuscated_res_0x7f01013e);
    }

    private void openDefaultAddr() {
        this.isSetDefaultAddr = true;
        if (this.isDarkMode) {
            this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a5);
        } else {
            this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a4);
        }
        this.defaultTagClose.setVisibility(8);
        this.defaultTagOpen.setVisibility(0);
        setTopRightBtnEnableStatus();
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_DEFAULT_ON);
    }

    private void processUpdateAddrResult() {
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_EDIT_FINISH);
        Intent intent = new Intent();
        intent.putExtra(AddressListActivity.CREATE_ADDRESS_RESULT, this.newMapObject);
        intent.putExtra(AddressListActivity.CREATE_REGION_RESULT, this.selectedRegion);
        setResult(1002, intent);
        finish();
    }

    private void readClipBoardAddrText() {
        boolean z;
        SapiOptions.Gray.GrayModule grayModuleByFunName;
        SapiOptions.Gray gray = SapiContext.getInstance().getSapiOptions().gray;
        if (gray != null && (grayModuleByFunName = gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_CLIPBOARD_ADDR)) != null) {
            z = grayModuleByFunName.isMeetGray();
        } else {
            z = false;
        }
        if (z) {
            this.titleBarView.post(new Runnable() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AddressEditActivity.this.isCreateAddress && !AddressEditActivity.this.isClipBoardAddrDialogShowed) {
                        String readClipBoardAddrText = ((AddressEditPresenter) AddressEditActivity.this.presenter).readClipBoardAddrText(AddressEditActivity.this);
                        if (!TextUtils.isEmpty(readClipBoardAddrText)) {
                            ((AddressEditPresenter) AddressEditActivity.this.presenter).recogniseTextOcrAddressResult(readClipBoardAddrText, 3003);
                        }
                    }
                }
            });
        }
    }

    private void setInputBeyondLengthLimitListener() {
        this.nameInputEt.setOnTextBeyondLengthLimitListener(new LengthLimitEditText.OnTextBeyondLengthLimitListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.4
            @Override // com.baidu.pass.ecommerce.view.LengthLimitEditText.OnTextBeyondLengthLimitListener
            public void onBeyondLengthLimit() {
                ToastUtil.show("姓名长度不超过25位");
            }
        });
        this.mobileInputEt.setOnTextBeyondLengthLimitListener(new LengthLimitEditText.OnTextBeyondLengthLimitListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.5
            @Override // com.baidu.pass.ecommerce.view.LengthLimitEditText.OnTextBeyondLengthLimitListener
            public void onBeyondLengthLimit() {
                ToastUtil.show("手机号不超过11位");
            }
        });
        this.detailAddrEt.setOnTextBeyondLengthLimitListener(new LengthLimitEditText.OnTextBeyondLengthLimitListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.6
            @Override // com.baidu.pass.ecommerce.view.LengthLimitEditText.OnTextBeyondLengthLimitListener
            public void onBeyondLengthLimit() {
                ToastUtil.show("地址长度不超过120位");
            }
        });
        this.editTagEt.setOnTextBeyondLengthLimitListener(new LengthLimitEditText.OnTextBeyondLengthLimitListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.7
            @Override // com.baidu.pass.ecommerce.view.LengthLimitEditText.OnTextBeyondLengthLimitListener
            public void onBeyondLengthLimit() {
                ToastUtil.show("标签长度不超过5位");
            }
        });
    }

    private void setTopRightBtnEnableStatus() {
        boolean z;
        TitleBarView titleBarView = this.titleBarView;
        if (15 == this.addressElementStatus) {
            z = true;
        } else {
            z = false;
        }
        titleBarView.setRightBtnEnable(z);
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.isCreateAddress) {
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_COSTTIME_ADD, gapTimeFromEnter());
        } else {
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_COSTTIME_EDIT, gapTimeFromEnter());
        }
        super.finish();
        if (!this.isOpenEdit) {
            overridePendingTransition(0, R.anim.obfuscated_res_0x7f01013d);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.isOpenEdit) {
            endProcess();
        }
        super.onBackPressed();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AddressSelectorDialog addressSelectorDialog = this.regionSelectorDialog;
        if (addressSelectorDialog != null) {
            addressSelectorDialog.destory();
        }
        sFromType = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isActivityStopped = false;
        readClipBoardAddrText();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.isActivityStopped = true;
    }

    private void processDelAddrResult(String str) {
        Intent intent = new Intent();
        intent.putExtra(AddressListActivity.DEL_ADDRESS_ID, str);
        setResult(1002, intent);
        finish();
    }

    private void processImgOcrResult(Object obj) {
        if (obj instanceof String) {
            this.textOcrEt.setText((String) obj);
            openAddrCopyLayout();
        }
    }

    private void processRecogniseTextOcrResult(Object obj) {
        if (obj == null) {
            ToastUtil.show("当前地址信息不完整，建议手动填写");
        }
        selectSuggestAddrDetail(obj);
    }

    private void updateRegion(AddressSelectedBean addressSelectedBean) {
        String regionDetailStr = getRegionDetailStr(this.selectedRegion);
        if (!TextUtils.isEmpty(regionDetailStr) && !TextUtils.equals(regionDetailStr, getRegionDetailStr(addressSelectedBean))) {
            ToastUtil.show(R.drawable.obfuscated_res_0x7f08132c, "已切换所在地区");
        }
        this.selectedRegion = addressSelectedBean;
        this.tvRegion.setText(getRegionDetailStr(addressSelectedBean));
        updateTopRightBtnStatus(true, 4);
    }

    public int dip2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.baidu.pass.ecommerce.view.addressdialog.OnDialogSelectedListenter
    public void onItemSelected(AddressSelectedBean addressSelectedBean) {
        if (addressSelectedBean == null) {
            return;
        }
        if (TextUtils.isEmpty(addressSelectedBean.countryId)) {
            addressSelectedBean.countryId = ListPagerView.REQUEST_PARAM_CHINA;
            addressSelectedBean.countryName = "中国";
        }
        updateRegion(addressSelectedBean);
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_SELECTED_REGION);
    }

    @Override // com.baidu.pass.ecommerce.dialog.ImgOcrOptionDialog.OptionOnClickListener
    public void onOptionClick(int i) {
        if (i != 1001) {
            if (i == 1002) {
                this.imageType = StatKey.EDITADDR_OCR_STAGE_ALBUM_IMG;
                pickPhoto();
                return;
            }
            return;
        }
        this.imageType = StatKey.EDITADDR_OCR_STAGE_CAMERA_IMG;
        takePhoto();
    }

    public int sp2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTopRightBtnStatus(boolean z, int i) {
        if (z) {
            this.addressElementStatus |= i;
        } else {
            this.addressElementStatus &= ~i;
        }
        setTopRightBtnEnableStatus();
    }

    private void addAddress4ElementUpdateListener() {
        this.nameInputEt.addTextChangedListener(new SimpleTextWatcher() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.8
            @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!AddressEditActivity.this.isAutoSetNameText) {
                    AddressEditActivity.this.nameInput.updateCleanBtnStatus();
                }
                AddressEditActivity.this.isAutoSetNameText = false;
                String trim = charSequence.toString().trim();
                AddressEditActivity.this.newMapObject.putValue("name", trim);
                AddressEditActivity.this.updateTopRightBtnStatus(!TextUtils.isEmpty(trim), 1);
            }
        });
        this.nameInputEt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.9
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                AddressEditActivity.this.nameInput.updateCleanBtnStatus(z);
            }
        });
        this.mobileInputEt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.10
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                AddressEditActivity.this.mobileInput.updateCleanBtnStatus(z);
            }
        });
        this.detailAddrEt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                AddressEditActivity.this.detailInput.updateCleanBtnStatus(z);
            }
        });
        this.mobileInputEt.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.12
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view2, int i, KeyEvent keyEvent) {
                if (i == 67 && AddressEditActivity.this.autoCleanMobileStr) {
                    AddressEditActivity.this.autoCleanMobileStr = false;
                    AddressEditActivity.this.mobileInput.setText("");
                }
                return false;
            }
        });
        this.mobileInputEt.addTextChangedListener(new SimpleTextWatcher() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.13
            @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String trim = charSequence.toString().trim();
                if (AddressEditActivity.this.autoSetMobile) {
                    AddressEditActivity.this.autoSetMobile = false;
                } else {
                    AddressEditActivity.this.inputMobile = trim;
                    AddressEditActivity.this.mobileInput.updateCleanBtnStatus();
                }
                AddressEditActivity.this.newMapObject.putValue("mobile", trim);
                AddressEditActivity.this.updateTopRightBtnStatus(!TextUtils.isEmpty(trim), 2);
            }
        });
        this.detailAddrEt.addTextChangedListener(new SimpleTextWatcher() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.14
            @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                boolean z;
                AddressEditActivity.this.inputDetailAddr = charSequence.toString().trim();
                AddressEditActivity.this.newMapObject.putValue(AddressField.KEY_DETAIL_ADDR, AddressEditActivity.this.inputDetailAddr);
                if (!TextUtils.isEmpty(AddressEditActivity.this.inputDetailAddr) && AddressEditActivity.this.inputDetailAddr.length() >= 4) {
                    z = true;
                } else {
                    z = false;
                }
                AddressEditActivity.this.updateTopRightBtnStatus(z, 8);
                if (!AddressEditActivity.this.isAutoSetAddrDetailText) {
                    AddressEditActivity.this.detailInput.updateCleanBtnStatus();
                    if (!TextUtils.isEmpty(AddressEditActivity.this.inputDetailAddr)) {
                        if (AddressEditActivity.this.selectedRegion == null) {
                            return;
                        }
                        AddressEditActivity.this.scrollToAddrDetail(true);
                        return;
                    }
                    AddressEditActivity.this.scrollToAddrDetail(false);
                    return;
                }
                AddressEditActivity.this.isAutoSetAddrDetailText = false;
            }
        });
        this.detailAddrEt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AddressEditActivity.this.isFocusAddrDetailEt = true;
                }
                ViewParent parent = view2.getParent();
                if (view2 == AddressEditActivity.this.detailAddrEt && parent != null) {
                    if (motionEvent.getAction() != 1) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.addrContentSv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (AddressEditActivity.this.suggestAddrLayout.getVisibility() == 0) {
                    AddressEditActivity.this.scrollToAddrDetail(false);
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGpsSwitcherAndShowDialog() {
        if (checkGpsSwitcherStatus()) {
            openAddrMapLocationActivity();
            return;
        }
        CommonDialog build = new CommonDialog.Builder(this).setDarkMode(this.isDarkMode).setTitle("开启定位服务").setMessage("为了正常使用定位功能，请开启定位服务").setNegativeButton("取消", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AddressEditActivity.this.openGPSDialog.dismiss();
            }
        }).setPositiveBtn("去开启", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AddressEditActivity.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 10010);
                AddressEditActivity.this.openGPSDialog.dismiss();
            }
        }).setCancelable(true).build();
        this.openGPSDialog = build;
        build.show();
    }

    private void requestLocPermission() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.isDarkMode = this.isDarkMode;
        permissionsDTO.permissions = new String[]{h.h, h.g};
        permissionsDTO.dialogTitle = "定位权限";
        permissionsDTO.dialogMsg = "如你选择通过地图选择收货地址，则请允许" + SapiUtils.getAppName(this) + "使用定位权限。你可以通过系统\"设置\"进行权限的管理";
        permissionsDTO.okBtnTxt = "去设置";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.26
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                AddressEditActivity.this.checkGpsSwitcherAndShowDialog();
            }
        });
    }

    private void setDarkModelIcon() {
        if (this.isDarkMode) {
            this.nameInput.getImg().setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f0609c8));
            this.selectRegionIv.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f0609c8));
            this.imgOcrIcon.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f0609c8));
            this.ivAddrCopyToggle.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f0609c8));
            this.selectRegionIv.setColorFilter(getResources().getColor(R.color.obfuscated_res_0x7f0609c8));
        }
    }

    private void callbackAddressResult() {
        if (this.addressManageCallback == null) {
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

    private void checkUserInputAndSubmit() {
        String str;
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
                if (checkedRadioButtonId == R.id.obfuscated_res_0x7f092008) {
                    str = AddressField.VALUE_HOME_TAG;
                } else if (checkedRadioButtonId == R.id.obfuscated_res_0x7f092006) {
                    str = AddressField.VALUE_COMPANY_TAG;
                } else if (checkedRadioButtonId == R.id.obfuscated_res_0x7f09200c) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void checkedCustomTag() {
        this.isCheckedCustomTag = true;
        this.addrTagGroup.clearCheck();
        this.checkedCustomTagTv.setText(this.editTagEt.getText().toString().trim());
        if (this.isDarkMode) {
            this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a3));
            this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a5);
        } else {
            this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a2));
            this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a4);
        }
        this.customTagLine.setVisibility(0);
        setTopRightBtnEnableStatus();
        HashMap hashMap = new HashMap();
        hashMap.put("stage", StatKey.EDITADDR_TAG_STAGE_SELECT_NEW);
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap);
    }

    private void closeAddrCopyLayout() {
        this.ivAddrCopyToggle.setImageResource(R.drawable.obfuscated_res_0x7f0812c2);
        if (this.isDarkMode) {
            this.copyFormView.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a8);
        } else {
            this.copyFormView.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a7);
        }
        this.addrCopyLayout.setVisibility(8);
        HashMap hashMap = new HashMap();
        hashMap.put("stage", StatKey.EDITADDR_PASTE_ADDRESS_STAGE_FOLD);
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_PASTE_ADDRESS_STAGE, hashMap);
    }

    private void openAddrCopyLayout() {
        this.ivAddrCopyToggle.setImageResource(R.drawable.obfuscated_res_0x7f0812c3);
        if (this.isDarkMode) {
            this.copyFormView.setBackgroundResource(R.color.obfuscated_res_0x7f0609b5);
        } else {
            this.copyFormView.setBackgroundResource(R.color.obfuscated_res_0x7f0609b4);
        }
        this.addrCopyLayout.setVisibility(0);
        HashMap hashMap = new HashMap();
        hashMap.put("stage", "show");
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_PASTE_ADDRESS_STAGE, hashMap);
    }

    private void setListener() {
        SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.17
            @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
            public void keyBoardHide(int i) {
                AddressEditActivity.this.isKeyBoardShowing = false;
                AddressEditActivity.this.scrollToAddrDetail(false);
                if (AddressEditActivity.this.isShowImgOcrDialog) {
                    AddressEditActivity.this.isShowImgOcrDialog = false;
                    AddressEditActivity.this.showImgOcrOptionDialog();
                }
                if (!AddressEditActivity.this.isShowRegionSelectDialog) {
                    return;
                }
                AddressEditActivity.this.isShowRegionSelectDialog = false;
                AddressEditActivity.this.showRegionSelectorDialog();
            }

            @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
            public void keyBoardShow(int i) {
                AddressEditActivity.this.isKeyBoardShowing = true;
                if (AddressEditActivity.this.isFocusAddrDetailEt && AddressEditActivity.this.selectedRegion != null) {
                    AddressEditActivity.this.addrContentSv.smoothScrollTo(0, AddressEditActivity.this.regionLayout.getTop() + SapiUtils.dip2px(AddressEditActivity.this.getApplication(), 10.0f));
                }
                if (AddressEditActivity.this.isFocusCopyAddrEt) {
                    AddressEditActivity.this.addrContentSv.smoothScrollBy(0, AddressEditActivity.this.textOcrEt.getHeight() / 2);
                }
                if (AddressEditActivity.this.isFocusCustomTagEt) {
                    AddressEditActivity.this.addrContentSv.smoothScrollBy(0, AddressEditActivity.this.editTagEt.getHeight());
                }
                AddressEditActivity.this.isFocusCustomTagEt = false;
                AddressEditActivity.this.isFocusCopyAddrEt = false;
                AddressEditActivity.this.isFocusAddrDetailEt = false;
            }
        });
        this.textOcrEt.addTextChangedListener(new SimpleTextWatcher() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.18
            @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (TextUtils.isEmpty(charSequence.toString().trim())) {
                    AddressEditActivity.this.cleanLongTextBtn.setVisibility(8);
                    AddressEditActivity.this.useLongTextBtn.setVisibility(8);
                    return;
                }
                AddressEditActivity.this.cleanLongTextBtn.setVisibility(0);
                AddressEditActivity.this.useLongTextBtn.setVisibility(0);
            }
        });
        this.textOcrEt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AddressEditActivity.this.isFocusCopyAddrEt = true;
                    HashMap hashMap = new HashMap();
                    hashMap.put("stage", "input");
                    AddressStatUtil.statAddressOption(StatKey.EDITADDR_PASTE_ADDRESS_STAGE, hashMap);
                }
                ViewParent parent = view2.getParent();
                if (view2 == AddressEditActivity.this.textOcrEt && parent != null) {
                    if (motionEvent.getAction() != 1) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.editTagEt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                AddressEditActivity.this.isFocusCustomTagEt = true;
                HashMap hashMap = new HashMap();
                hashMap.put("stage", "input");
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap);
                return false;
            }
        });
        this.suggestAddrListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.21
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                InputMethodManager inputMethodManager = (InputMethodManager) AddressEditActivity.this.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(AddressEditActivity.this.detailAddrEt.getWindowToken(), 0);
                }
                AddressEditActivity.this.scrollToAddrDetail(false);
                ((AddressEditPresenter) AddressEditActivity.this.presenter).getSuggestAddrDetail(AddressEditActivity.this.listAdapter.getItem(i), AddressEditActivity.this.selectedRegion);
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_SELECTED_PREDICTIVE);
            }
        });
        this.addrTagGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.22
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (!AddressEditActivity.this.isClickConfirmCustomTag) {
                    if (R.id.obfuscated_res_0x7f092008 == i) {
                        AddressEditActivity.this.unCheckedCustomTag();
                        HashMap hashMap = new HashMap();
                        hashMap.put("stage", StatKey.EDITADDR_TAG_STAGE_SELECT_EXISTED);
                        AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap);
                        return;
                    } else if (R.id.obfuscated_res_0x7f092006 == i) {
                        AddressEditActivity.this.unCheckedCustomTag();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("stage", StatKey.EDITADDR_TAG_STAGE_SELECT_EXISTED);
                        AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap2);
                        return;
                    } else if (R.id.obfuscated_res_0x7f09200c == i) {
                        AddressEditActivity.this.unCheckedCustomTag();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("stage", StatKey.EDITADDR_TAG_STAGE_SELECT_EXISTED);
                        AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap3);
                        return;
                    } else {
                        return;
                    }
                }
                AddressEditActivity.this.isClickConfirmCustomTag = false;
            }
        });
        this.editTagEt.addTextChangedListener(new SimpleTextWatcher() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.23
            @Override // com.baidu.pass.ecommerce.callback.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AddressEditActivity.this.editTagConfirmBtn.setEnabled(!TextUtils.isEmpty(charSequence.toString().trim()));
            }
        });
    }

    private void showDelNoticeDialog() {
        CommonDialog build = new CommonDialog.Builder(this).setDarkMode(this.isDarkMode).setTitle("删除提示").setMessage("确定要删除该地址吗？").setNegativeButton("取消", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AddressEditActivity.this.delAddrDialog.dismiss();
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_CANCEL_DELETE);
            }
        }).setPositiveBtn("删除", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((AddressEditPresenter) AddressEditActivity.this.presenter).delAddress(AddressEditActivity.this.addressId);
                AddressEditActivity.this.delAddrDialog.dismiss();
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_CONFIRM_DELETE);
            }
        }).build();
        this.delAddrDialog = build;
        build.show();
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_DELETE_ADDRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImgOcrOptionDialog() {
        if (this.ocrOptionDialog == null) {
            ImgOcrOptionDialog imgOcrOptionDialog = new ImgOcrOptionDialog(this.isDarkMode);
            this.ocrOptionDialog = imgOcrOptionDialog;
            imgOcrOptionDialog.setCancelable(true);
            this.ocrOptionDialog.setOptionOnClickListener(this);
        }
        this.ocrOptionDialog.show(getSupportFragmentManager(), OPTION_DIALOG_TAG);
        HashMap hashMap = new HashMap();
        hashMap.put("stage", "show");
        AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRegionSelectorDialog() {
        this.nameInputEt.clearFocus();
        this.mobileInputEt.clearFocus();
        this.detailAddrEt.clearFocus();
        AddressSelectorDialog addressSelectorDialog = this.regionSelectorDialog;
        if (addressSelectorDialog == null) {
            AddressSelectorDialog addressSelectorDialog2 = new AddressSelectorDialog(this, this.selectedRegion);
            this.regionSelectorDialog = addressSelectorDialog2;
            addressSelectorDialog2.setCanceledOnTouchOutside(true);
            this.regionSelectorDialog.setOnDialogSelectedListenter(this);
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_SELECTING_REGION);
        } else {
            addressSelectorDialog.setAddressSelectedBean(this.selectedRegion);
        }
        if (!this.regionSelectorDialog.isShowing()) {
            this.regionSelectorDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unCheckedCustomTag() {
        this.isCheckedCustomTag = false;
        if (this.isDarkMode) {
            this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a7));
            this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812d3);
        } else {
            this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a6));
            this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812d2);
        }
        this.customTagLine.setVisibility(8);
        setTopRightBtnEnableStatus();
    }

    private String getRegionDetailStr(AddressSelectedBean addressSelectedBean) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void selectSuggestAddrDetail(Object obj) {
        if (obj instanceof JSONObject) {
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

    private void initDefaultTagLayout(boolean z) {
        ViewStub viewStub;
        if (z) {
            viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091fdd);
        } else {
            viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091fdf);
        }
        View inflate = viewStub.inflate();
        this.addrTagGroup = (RadioGroup) inflate.findViewById(R.id.obfuscated_res_0x7f092007);
        this.homeTagRb = (CheckedRadioButton) inflate.findViewById(R.id.obfuscated_res_0x7f092008);
        this.companyTagRb = (CheckedRadioButton) inflate.findViewById(R.id.obfuscated_res_0x7f092006);
        this.schoolTagRb = (CheckedRadioButton) inflate.findViewById(R.id.obfuscated_res_0x7f09200c);
    }

    private void processCreateAddrResult(Object obj) {
        if (obj instanceof String) {
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

    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i) {
        if (Build.VERSION.SDK_INT >= 17 && (isFinishing() || isDestroyed())) {
            return;
        }
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

    private void initView() {
        int i;
        this.rootView = findViewById(R.id.obfuscated_res_0x7f091fe7);
        this.titleBarView = (TitleBarView) findViewById(R.id.obfuscated_res_0x7f09202c);
        this.addrContentSv = (ScrollView) findViewById(R.id.obfuscated_res_0x7f091fd5);
        InputFormView inputFormView = (InputFormView) findViewById(R.id.obfuscated_res_0x7f091ff7);
        this.nameInput = inputFormView;
        this.nameInputEt = inputFormView.getEditText();
        this.nameInput.setDarkMode(this.isDarkMode);
        this.nameInput.setInputType(InputFormView.InputType.NAME);
        InputFormView inputFormView2 = (InputFormView) findViewById(R.id.obfuscated_res_0x7f091ff6);
        this.mobileInput = inputFormView2;
        this.mobileInputEt = inputFormView2.getEditText();
        this.mobileInput.setDarkMode(this.isDarkMode);
        this.mobileInput.setInputType(InputFormView.InputType.PHONE);
        this.regionLayout = findViewById(R.id.obfuscated_res_0x7f091ffe);
        this.selectRegionIv = (ImageView) findViewById(R.id.obfuscated_res_0x7f09207d);
        this.tvRegion = (TextView) findViewById(R.id.obfuscated_res_0x7f091fd2);
        InputFormView inputFormView3 = (InputFormView) findViewById(R.id.obfuscated_res_0x7f091fe5);
        this.detailInput = inputFormView3;
        this.detailAddrEt = inputFormView3.getEditText();
        this.detailInput.setDarkMode(this.isDarkMode);
        this.mobileInput.setInputType(InputFormView.InputType.DETAIL);
        this.ivAddrCopyToggle = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fda);
        this.copyFormView = (TextFormView) findViewById(R.id.obfuscated_res_0x7f091fd9);
        this.addrCopyLayout = findViewById(R.id.obfuscated_res_0x7f092026);
        this.textOcrEt = (EditText) findViewById(R.id.obfuscated_res_0x7f091ffa);
        this.cleanLongTextBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f09201d);
        this.useLongTextBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f0920a4);
        this.voiceOcrBtn = findViewById(R.id.obfuscated_res_0x7f0920a7);
        this.mOcrEditLayout = (TextFormView) findViewById(R.id.obfuscated_res_0x7f091ff9);
        this.imgOcrBtn = findViewById(R.id.obfuscated_res_0x7f09203d);
        this.imgOcrIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f09203b);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fd3);
        this.addTagBtn = imageView;
        if (this.isDarkMode) {
            i = R.drawable.obfuscated_res_0x7f08129c;
        } else {
            i = R.drawable.obfuscated_res_0x7f08129b;
        }
        imageView.setImageResource(i);
        this.editTagLayout = findViewById(R.id.obfuscated_res_0x7f09202d);
        LengthLimitEditText lengthLimitEditText = (LengthLimitEditText) findViewById(R.id.obfuscated_res_0x7f092088);
        this.editTagEt = lengthLimitEditText;
        lengthLimitEditText.setLengthLimit(5);
        this.editTagConfirmBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f092087);
        this.customTagLayout = findViewById(R.id.obfuscated_res_0x7f092027);
        this.checkedCustomTagTv = (TextView) findViewById(R.id.obfuscated_res_0x7f092029);
        this.customTagLine = findViewById(R.id.obfuscated_res_0x7f092028);
        this.updateCustomTagBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f09202a);
        this.isDefaultToggle = findViewById(R.id.obfuscated_res_0x7f091fe0);
        this.defaultTagClose = findViewById(R.id.obfuscated_res_0x7f091fdc);
        this.defaultTagOpen = findViewById(R.id.obfuscated_res_0x7f091fde);
        this.suggestAddrLayout = findViewById(R.id.obfuscated_res_0x7f092080);
        this.suggestAddrListView = (ListView) findViewById(R.id.obfuscated_res_0x7f092081);
        this.delAddrBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091fe2);
        this.mapAddrCheckValidTv = (TextView) findViewById(R.id.obfuscated_res_0x7f091fd4);
        initDefaultTagLayout(this.isDarkMode);
        this.titleBarView.setLeft("取消", this);
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
            this.mapAddrCheckValidTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f08128e);
            this.mapAddrCheckValidTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609fe));
            this.rootView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060a84));
            this.titleBarView.setDarkMode();
            this.nameInput.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812aa);
            this.mobileInput.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b5));
            this.regionLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b5));
            this.tvRegion.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b7));
            this.tvRegion.setHintTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b3));
            findViewById(R.id.obfuscated_res_0x7f092020).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b1));
            this.detailInput.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a8);
            this.mOcrEditLayout.setDarkMode();
            this.mOcrEditLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812aa);
            this.imgOcrBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812d3);
            ((TextView) findViewById(R.id.obfuscated_res_0x7f09203c)).setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b9));
            this.addrCopyLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a8);
            findViewById(R.id.obfuscated_res_0x7f091fd8).setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a0);
            this.textOcrEt.setHintTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b3));
            this.textOcrEt.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b7));
            this.cleanLongTextBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812cc);
            this.cleanLongTextBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a1));
            this.useLongTextBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f081294);
            this.useLongTextBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609c7));
            TextFormView textFormView = (TextFormView) findViewById(R.id.obfuscated_res_0x7f091fe8);
            textFormView.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812aa);
            textFormView.setDarkMode();
            findViewById(R.id.obfuscated_res_0x7f09202b).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b5));
            this.addTagBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812bd);
            this.editTagEt.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812d3);
            this.editTagEt.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b7));
            this.editTagEt.setHintTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b3));
            this.editTagConfirmBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f08129e);
            this.editTagConfirmBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609bf));
            this.checkedCustomTagTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a7));
            this.customTagLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812d3);
            this.customTagLine.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609c5));
            this.updateCustomTagBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812f2);
            findViewById(R.id.obfuscated_res_0x7f091fe6).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b1));
            TextFormView textFormView2 = (TextFormView) findViewById(R.id.obfuscated_res_0x7f09207e);
            textFormView2.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a8);
            textFormView2.setDarkMode();
            this.isDefaultToggle.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a2);
            this.defaultTagClose.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812dd);
            this.defaultTagOpen.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812dd);
            this.delAddrBtn.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812de);
            this.delAddrBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609af));
            this.copyFormView.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812a8);
            this.copyFormView.setDarkMode();
            this.suggestAddrLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609bb));
        }
        this.checkedCustomTagTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AddressEditActivity.this.isCheckedCustomTag) {
                    AddressEditActivity.this.unCheckedCustomTag();
                    return;
                }
                AddressEditActivity.this.isClickConfirmCustomTag = true;
                AddressEditActivity.this.checkedCustomTag();
                HashMap hashMap = new HashMap();
                hashMap.put("stage", StatKey.EDITADDR_TAG_STAGE_SELECT_NEW);
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap);
            }
        });
        this.nameInput.getImg().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_CONTACT_CLICK);
                ContactUtil.getInstance().requestContact(AddressEditActivity.this, new GetContactCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.3.1
                    @Override // com.baidu.pass.ecommerce.callback.GetContactCallback
                    public void onCall(GetContactResult getContactResult) {
                        String str;
                        if (getContactResult != null && !TextUtils.isEmpty(getContactResult.name) && !TextUtils.isEmpty(getContactResult.phone)) {
                            String str2 = "";
                            if (TextUtils.isEmpty(getContactResult.name)) {
                                str = "";
                            } else {
                                str = getContactResult.name;
                            }
                            AddressEditActivity.this.nameInput.setText(str);
                            if (!TextUtils.isEmpty(getContactResult.phone)) {
                                String replaceAll = getContactResult.phone.replaceAll(" ", "").replaceAll("\\+", "").replaceAll("-", "");
                                if (replaceAll.startsWith(AddressEditActivity.CHINA_REGION_CODE)) {
                                    str2 = replaceAll.replaceFirst(AddressEditActivity.CHINA_REGION_CODE, "");
                                } else {
                                    str2 = replaceAll;
                                }
                            }
                            AddressEditActivity.this.mobileInput.setText(str2);
                            AddressStatUtil.statAddressOption(StatKey.EDITADDR_CONTACT_FINISH);
                        }
                    }
                });
            }
        });
    }

    private void initViewByAddrMapObj(MapObject mapObject) {
        if (mapObject == null) {
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

    private void processPastedAddrOcrResult(final Object obj) {
        if (this.isActivityStopped) {
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
            CommonDialog build = new CommonDialog.Builder(this).setTitle("是否使用该地址").setMessage(str).setMessageGravity(3).setNegativeButton("暂不使用", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AddressStatUtil.statAddressOption(StatKey.CLIPBOARD_ADDR_CANCEL_CLICK);
                    AddressEditActivity.this.usePastedAddrDialog.dismiss();
                }
            }).setPositiveBtn("使用", new View.OnClickListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressEditActivity.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AddressEditActivity.this.mapAddrCheckValidTv.setVisibility(0);
                    AddressStatUtil.statAddressOption(StatKey.CLIPBOARD_ADDR_CONFIRM_CLICK);
                    AddressEditActivity.this.usePastedAddrDialog.dismiss();
                    AddressEditActivity.this.selectSuggestAddrDetail(obj);
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

    private void processSuggestAddrList(String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToAddrDetail(boolean z) {
        if (z) {
            this.addrContentSv.smoothScrollTo(0, this.regionLayout.getTop() + SapiUtils.dip2px(this, 10.0f));
            if (!TextUtils.isEmpty(this.detailAddrEt.getText().toString().trim())) {
                ((AddressEditPresenter) this.presenter).getSuggestAddrList(this.inputDetailAddr, this.selectedRegion);
                InputFormView inputFormView = this.detailInput;
                if (inputFormView != null) {
                    int max = Math.max(Math.min(inputFormView.getLineCount(), 3), 2);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.suggestAddrLayout.getLayoutParams();
                    layoutParams.topMargin = dip2px(110.0f) + (max * sp2px(18.0f));
                    this.suggestAddrLayout.setLayoutParams(layoutParams);
                }
                this.suggestAddrLayout.setVisibility(0);
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_PREDICTIVE);
                return;
            }
            return;
        }
        this.addrContentSv.smoothScrollTo(0, 0);
        this.suggestAddrLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity
    public AddressEditPresenter createPresenter() {
        AddressEditPresenter addressEditPresenter = new AddressEditPresenter();
        String stringExtra = getIntent().getStringExtra(KEY_BDSTOKEN_FROM_ADDRLIST);
        if (TextUtils.isEmpty(stringExtra)) {
            addressEditPresenter.getBdStokenFromServer(Integer.MIN_VALUE, null);
        } else {
            addressEditPresenter.setBdSTokenFromAddrList(stringExtra);
        }
        return addressEditPresenter;
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i, int i2, String str, String str2) {
        LoadingUtil.cancel();
        if (i != 2001 && i != 2002) {
            if (i != 3001) {
                if (i != 3003 && !TextUtils.isEmpty(str)) {
                    ToastUtil.show(R.drawable.obfuscated_res_0x7f0812cf, str);
                    return;
                }
                return;
            }
            ToastUtil.show(R.drawable.obfuscated_res_0x7f0812cf, "图片识别失败");
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i, Object obj, String str) {
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

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
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
            AddressStatUtil.statAddressOption(StatKey.ADDR_EDIT_INFO_FROM_MAP);
        } else if (i == 10010 && checkGpsSwitcherStatus()) {
            openAddrMapLocationActivity();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        AddressManageDTO addressManageDTO;
        MapStatusAndLocateCallback mapStatusAndLocateCallback;
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("ONCLICK", "currentTime=" + currentTimeMillis + " lastClickTime=" + BaseOptionActivity.lastClickTime);
        if (currentTimeMillis - BaseOptionActivity.lastClickTime < 500) {
            return;
        }
        BaseOptionActivity.lastClickTime = currentTimeMillis;
        int id = view2.getId();
        if (R.id.obfuscated_res_0x7f091fe0 == id) {
            if (this.isSetDefaultAddr) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_CANCEL_DEFAULT);
                closeDefaultAddr();
                return;
            }
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_SET_DEFAULT);
            openDefaultAddr();
        } else if (R.id.obfuscated_res_0x7f091fd3 == id) {
            this.addTagBtn.setVisibility(8);
            this.customTagLayout.setVisibility(8);
            this.editTagLayout.setVisibility(0);
            HashMap hashMap = new HashMap();
            hashMap.put("stage", "add");
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap);
        } else if (R.id.obfuscated_res_0x7f092087 == id) {
            this.isClickConfirmCustomTag = true;
            checkedCustomTag();
            this.editTagLayout.setVisibility(8);
            this.customTagLayout.setVisibility(0);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("stage", StatKey.EDITADDR_TAG_STAGE_CONFIRM_INPUT);
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap2);
        } else if (R.id.obfuscated_res_0x7f09202a == id) {
            this.customTagLayout.setVisibility(8);
            this.editTagLayout.setVisibility(0);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("stage", StatKey.EDITADDR_TAG_STAGE_EDIT);
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_TAG_STAGE, hashMap3);
        } else if (R.id.obfuscated_res_0x7f09201d == id) {
            this.textOcrEt.setText("");
            HashMap hashMap4 = new HashMap();
            hashMap4.put("stage", "cancel");
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_PASTE_ADDRESS_STAGE, hashMap4);
        } else if (R.id.obfuscated_res_0x7f0920a4 == id) {
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_SPLIT_CLICK);
            String trim = this.textOcrEt.getText().toString().trim();
            HashMap hashMap5 = new HashMap();
            hashMap5.put("stage", "use");
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_PASTE_ADDRESS_STAGE, hashMap5);
            if (TextUtils.isEmpty(trim)) {
                return;
            }
            ((AddressEditPresenter) this.presenter).recogniseTextOcrAddressResult(trim, 3002);
        } else if (R.id.obfuscated_res_0x7f091fd2 == id) {
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
        } else if (R.id.obfuscated_res_0x7f09203d == id) {
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
        } else if (R.id.obfuscated_res_0x7f09208c == id) {
            if (this.isOpenEdit) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_CANCEL);
                endProcess();
            }
            finish();
        } else if (R.id.obfuscated_res_0x7f09208d == id) {
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_SAVEBTN_CLICK);
            checkUserInputAndSubmit();
        } else if (R.id.obfuscated_res_0x7f091fd9 == id) {
            if (this.addrCopyLayout.getVisibility() == 0) {
                closeAddrCopyLayout();
            } else {
                openAddrCopyLayout();
            }
        } else if (R.id.obfuscated_res_0x7f091fe2 == id) {
            showDelNoticeDialog();
        } else if (R.id.obfuscated_res_0x7f09207d == id) {
            AddressStatUtil.statAddressOption(StatKey.ADDR_LOCATE_BTN_CLICK);
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

    @Override // com.baidu.sapi2.ecommerce.activity.BaseAddressActivity, com.baidu.pass.ecommerce.common.mvp.BaseMvpActivity, com.baidu.sapi2.activity.BaseOptionActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0562);
        ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.obfuscated_res_0x7f060a85));
        initView();
        addAddress4ElementUpdateListener();
        setInputBeyondLengthLimitListener();
        setDarkModelIcon();
        this.newMapObject = (MapObject) getIntent().getParcelableExtra(KEY_ADDRESS_DETAIL_MAP_OBJ);
        this.selectedRegion = (AddressSelectedBean) getIntent().getSerializableExtra(KEY_ADDRESS_ADDR_REGION_BEAN);
        if (this.newMapObject != null) {
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_ENTER_EDIT);
            this.titleBarView.setTitle("编辑地址");
            sFromType = "1";
            this.isCreateAddress = false;
            initViewByAddrMapObj(this.newMapObject);
            this.titleBarView.setRightBtnEnable(true);
        } else {
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_ENTER_ADD);
            this.titleBarView.setTitle("添加地址");
            this.isCreateAddress = true;
            sFromType = "0";
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

    @Override // com.baidu.sapi2.activity.BaseOptionActivity
    public void processImgBase64Data(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.imageType)) {
            HashMap hashMap = new HashMap();
            hashMap.put("stage", this.imageType);
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap);
            this.imageType = "";
        }
        if (10000 == i && !TextUtils.isEmpty(str2)) {
            ((AddressEditPresenter) this.presenter).getImgOcrAddressResult(str2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("stage", "success");
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap2);
        } else if (!TextUtils.isEmpty(str)) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("stage", "failed");
            AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap3);
            ToastUtil.show(str);
        }
    }
}
