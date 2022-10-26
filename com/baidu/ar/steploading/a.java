package com.baidu.ar.steploading;

import com.baidu.ar.h.i;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String xt;
    public Map xu;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.xt = str;
    }

    private Map gv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Map map = this.xu;
            if (map != null) {
                return map;
            }
            this.xu = new HashMap();
            File file = new File(this.xt.concat(File.separator).concat("res_config.json"));
            if (file.exists()) {
                try {
                    JSONArray optJSONArray = new JSONObject(i.f(file)).optJSONArray(UriUtil.LOCAL_RESOURCE_SCHEME);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                f fVar = new f();
                                fVar.xK = optJSONObject.getString("resPath");
                                fVar.xL = optJSONObject.optString("resId");
                                fVar.xM = optJSONObject.optString("encoding");
                                fVar.xN = optJSONObject.optString(PackageTable.MD5);
                                this.xu.put(fVar.xK, fVar);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this.xu;
        }
        return (Map) invokeV.objValue;
    }

    public f aN(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map gv = gv();
            if (gv.containsKey(str)) {
                return (f) gv.get(str);
            }
            return null;
        }
        return (f) invokeL.objValue;
    }
}
