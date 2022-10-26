package com.baidu.sapi2.ecommerce.dto;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.ecommerce.callback.MapStatusAndLocateCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AddressManageDTO extends SapiWebDTO implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADDRESS_EDIT = "1";
    public static final String ADDRESS_LIST = "0";
    public static final String TYPE_MANAGE = "0";
    public static final String TYPE_SELECT = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap addrListColorMap;
    public HashMap addrListTextStyle;
    public Drawable backBtnDrawable;
    public Drawable itemAddEditBtnDrawable;
    public View loadingView;
    public MapStatusAndLocateCallback mapStatusAndLocateCallback;
    public String openPageName;
    public PermissionsDTO permissionsDTO;
    public boolean selectAddedAddress;
    public boolean showBottomBack;
    public String tplse;
    public String tplt;
    public String type;

    public AddressManageDTO() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = "0";
        this.openPageName = "0";
        this.showBottomBack = true;
    }
}
