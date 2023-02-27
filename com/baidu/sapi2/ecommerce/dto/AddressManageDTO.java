package com.baidu.sapi2.ecommerce.dto;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.ecommerce.callback.MapStatusAndLocateCallback;
import com.baidu.sapi2.ecommerce.enums.PassAddrColorLocation;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AddressManageDTO extends SapiWebDTO implements NoProguard {
    public static final String ADDRESS_EDIT = "1";
    public static final String ADDRESS_LIST = "0";
    public static final String TYPE_MANAGE = "0";
    public static final String TYPE_SELECT = "1";
    public HashMap<PassAddrColorLocation, String> addrListColorMap;
    public HashMap<PassAddrColorLocation, Boolean> addrListTextStyle;
    public Drawable backBtnDrawable;
    public Drawable itemAddEditBtnDrawable;
    public View loadingView;
    public MapStatusAndLocateCallback mapStatusAndLocateCallback;
    public PermissionsDTO permissionsDTO;
    public boolean selectAddedAddress;
    public String tplse;
    public String tplt;
    public String type = "0";
    public String openPageName = "0";
    public boolean showBottomBack = true;
}
