package com.baidu.sapi2.ecommerce.dto;

import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.dto.SapiWebDTO;
/* loaded from: classes17.dex */
public class AddressManageDTO extends SapiWebDTO implements NoProguard {
    public static final String ADDRESS_EDIT = "1";
    public static final String ADDRESS_LIST = "0";
    public static final String TYPE_MANAGE = "0";
    public static final String TYPE_SELECT = "1";
    public PermissionsDTO permissionsDTO;
    public boolean selectAddedAddress;
    public String tplse;
    public String tplt;
    public String type = "0";
    public String openPageName = "0";
}
