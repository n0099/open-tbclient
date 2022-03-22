package com.baidu.tbadk.core.view.itemcard.download;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class ItemDownloadExtraData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LINK_TYPE_SHOUZHU = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int apkSourceType;
    public String appName;
    public String pkgName;
    public int shouzhuCategory;
    public int shouzhuScene;
    public String shouzhuSource;

    public ItemDownloadExtraData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.apkSourceType = i;
    }

    public boolean isShouzhuData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.apkSourceType == 1 : invokeV.booleanValue;
    }

    public void updateSceneCategory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            switch (i) {
                case -1:
                    this.shouzhuScene = 4001;
                    this.shouzhuCategory = 4001001;
                    return;
                case 0:
                default:
                    return;
                case 1:
                    this.shouzhuScene = 4002;
                    this.shouzhuCategory = 4002001;
                    return;
                case 2:
                    this.shouzhuScene = 4002;
                    this.shouzhuCategory = 4002002;
                    return;
                case 3:
                    this.shouzhuScene = 4002;
                    this.shouzhuCategory = 4002003;
                    return;
                case 4:
                    this.shouzhuScene = 4002;
                    this.shouzhuCategory = 4002004;
                    return;
                case 5:
                    this.shouzhuScene = 4002;
                    this.shouzhuCategory = 4002005;
                    return;
                case 6:
                    this.shouzhuScene = 4002;
                    this.shouzhuCategory = 4002006;
                    return;
                case 7:
                    this.shouzhuScene = 4002;
                    this.shouzhuCategory = 4002007;
                    return;
            }
        }
    }
}
