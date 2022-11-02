package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MapObj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int ad;
    public String adLog;
    public int adstyle;
    public String bid;
    public String clickAction;
    public int dynamicSrc;
    public int dysrc;
    public int dystge;
    public String exJson;
    public Point geoPt;
    public float geoZ;
    public int index;
    public boolean indoorpoi;
    public boolean isAgg;
    public int layer_id;
    public int level;
    public int nIndex;
    public int nType;
    public int offset;
    public int poiOnlineType;
    public String puid;
    public String qid;
    public int routeId;
    public String routeType;
    public int slobj;
    public int sltime;
    public int slvisi;
    public String ssData;
    public String ssIndoorId;
    public String ssName;
    public String ssPanoId;
    public String ssPoiUid;
    public double ssRotation;
    public String ssType;
    public int ssZ;
    public int statisticValue;
    public int status;
    public String strText;
    public String strUid;
    public double streetArrowCenterX;
    public double streetArrowCenterY;
    public int style_id;
    public String url;

    public MapObj() {
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
        this.dysrc = -1;
        this.dystge = -1;
        this.level = -1;
        this.strUid = "";
        this.nIndex = 0;
        this.nType = 26;
        this.strText = "";
        this.geoPt = new Point();
        this.offset = 0;
        this.sltime = 0;
        this.slobj = 0;
        this.ssName = "";
        this.ssIndoorId = "";
        this.ssPoiUid = "";
        this.ssZ = 0;
        this.ssRotation = 0.0d;
        this.ssPanoId = "";
        this.routeId = 0;
        this.index = 0;
        this.status = 0;
        this.routeType = "";
        this.poiOnlineType = 0;
        this.bid = "";
        this.clickAction = "";
        this.statisticValue = 0;
        this.isAgg = false;
    }
}
