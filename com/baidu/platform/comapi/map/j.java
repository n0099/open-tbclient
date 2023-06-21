package com.baidu.platform.comapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ap a;
    public boolean b;
    public boolean c;
    public double[] d;
    public GeoPoint e;
    public GeoPoint f;
    public boolean g;
    public JsonBuilder h;
    public int i;
    public int j;

    public abstract String a();

    public j(ap apVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new GeoPoint(0, 0);
        this.f = new GeoPoint(0, 0);
        this.g = true;
        this.i = -1;
        this.j = 0;
        this.a = apVar;
    }

    public String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            JsonBuilder jsonBuilder = new JsonBuilder();
            this.h = jsonBuilder;
            jsonBuilder.object();
            if (i == 0) {
                this.h.key("path").arrayValue();
                if (this.d != null) {
                    int i2 = 0;
                    while (true) {
                        double[] dArr = this.d;
                        if (i2 >= dArr.length) {
                            break;
                        }
                        this.h.value(dArr[i2]);
                        i2++;
                    }
                }
                this.h.endArrayValue();
            } else if (i == 1) {
                this.h.key("sgeo");
                this.h.object();
                this.h.key(IResourceProvider.PraiseLevelConfig.JSON_KEY_BOUND).arrayValue();
                GeoPoint geoPoint = this.e;
                if (geoPoint != null && this.f != null) {
                    this.h.value(geoPoint.getLongitude());
                    this.h.value(this.e.getLatitude());
                    this.h.value(this.f.getLongitude());
                    this.h.value(this.f.getLatitude());
                }
                this.h.endArrayValue();
                if (this.j == 4) {
                    this.h.key("type").value(3);
                } else {
                    this.h.key("type").value(this.j);
                }
                this.h.key("elements").arrayValue();
                this.h.object();
                this.h.key("points").arrayValue();
                if (this.d != null) {
                    int i3 = 0;
                    while (true) {
                        double[] dArr2 = this.d;
                        if (i3 >= dArr2.length) {
                            break;
                        }
                        this.h.value(dArr2[i3]);
                        i3++;
                    }
                }
                this.h.endArrayValue();
                this.h.endObject();
                this.h.endArrayValue();
                this.h.endObject();
            }
            this.h.key("ud").value(String.valueOf(hashCode()));
            this.h.key(MapBundleKey.MapObjKey.OBJ_DIR).value(0);
            ap apVar = this.a;
            if (apVar != null && apVar.a() != 0) {
                this.h.key(MapBundleKey.MapObjKey.OBJ_NORMALSTYTLE).value(this.a.a());
                this.h.key(MapBundleKey.MapObjKey.OBJ_FOCUSSTYTLE).value(this.a.a());
                this.h.key("ty").value(32);
            } else {
                int i4 = this.j;
                if (i4 == 3) {
                    this.h.key("ty").value(3100);
                } else if (i4 == 4) {
                    this.h.key("ty").value(3200);
                } else {
                    this.h.key("ty").value(-1);
                }
            }
            this.h.key(MapBundleKey.MapObjKey.OBJ_OFFSET).value(0);
            this.h.key("in").value(0);
            this.h.key("tx").value("");
            this.h.key(MapBundleKey.MapObjKey.OBJ_DIS).value(0);
            this.h.key(ConstPath.KEY_ALIGN).value(0);
            if (this.b) {
                this.h.key("dash").value(1);
                this.h.key("ty").value(this.j);
            }
            if (this.c) {
                this.h.key("trackMove").object();
                this.h.key("pointStyle").value(((ar) this.a).e());
                this.h.endObject();
            }
            this.h.key("style").object();
            if (this.a != null) {
                this.h.key("width").value(this.a.c());
                this.h.key("color").value(ap.c(this.a.b()));
                int i5 = this.j;
                if (i5 == 3 || i5 == 4) {
                    this.h.key("scolor").value(ap.c(this.a.d()));
                }
            }
            this.h.endObject();
            this.h.endObject();
            return this.h.toString();
        }
        return (String) invokeI.objValue;
    }
}
