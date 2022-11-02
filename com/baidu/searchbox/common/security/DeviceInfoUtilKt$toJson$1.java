package com.baidu.searchbox.common.security;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DeviceInfoUtilKt$toJson$1 extends Lambda implements Function1<Integer, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ int $deviceFlag;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ DeviceIdBagMap $infoMap;
    public final /* synthetic */ JSONObject $json;
    public final /* synthetic */ List $validInfoList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoUtilKt$toJson$1(int i, DeviceIdBagMap deviceIdBagMap, List list, JSONObject jSONObject) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), deviceIdBagMap, list, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$deviceFlag = i;
        this.$infoMap = deviceIdBagMap;
        this.$validInfoList = list;
        this.$json = jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        DeviceIdBag deviceIdBag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (this.$deviceFlag & i) != 0 && (deviceIdBag = (DeviceIdBag) this.$infoMap.get((Object) Integer.valueOf(i))) != null && !TextUtils.isEmpty(deviceIdBag.deviceId)) {
            this.$validInfoList.add(Integer.valueOf(i));
            String str = DeviceInfoUtilKt.getSyncJsonKeyMap().get(i);
            if (i == 2) {
                JSONObject jSONObject = this.$json;
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(deviceIdBag.deviceId);
                Unit unit = Unit.INSTANCE;
                jSONObject.put(str, jSONArray);
                return;
            }
            this.$json.put(str, deviceIdBag.deviceId);
        }
    }
}
