package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class MKOLUpdateElement {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DOWNLOADING = 1;
    public static final int FINISHED = 4;
    public static final int SUSPENDED = 3;
    public static final int UNDEFINED = 0;
    public static final int WAITING = 2;
    public static final int eOLDSFormatError = 9;
    public static final int eOLDSIOError = 7;
    public static final int eOLDSInstalling = 10;
    public static final int eOLDSMd5Error = 5;
    public static final int eOLDSNetError = 6;
    public static final int eOLDSWifiError = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public int cityID;
    public String cityName;
    public LatLng geoPt;
    public int level;
    public int ratio;
    public int serversize;
    public int size;
    public int status;
    public boolean update;

    public MKOLUpdateElement() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
