package com.baidu.tbadk.core.view.spanGroup;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.w95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/tbadk/core/view/spanGroup/DownKeyChecker;", "", "()V", "CONFIG_KEY", "", "CONFIG_KEY_DEBUG", "entrySet", "", "Lcom/baidu/tbadk/core/view/spanGroup/DownKeyChecker$Entry;", "isDisabled", "", "Entry", "Parser", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownKeyChecker {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<Entry> a;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/tbadk/core/view/spanGroup/DownKeyChecker$Entry;", "Ljava/io/Serializable;", HttpConstants.HTTP_MANUFACTURER, "", "model", CriusAttrConstants.DISPLAY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplay", "()Ljava/lang/String;", "getManufacturer", "getModel", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Entry implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String display;
        public final String manufacturer;
        public final String model;

        public static /* synthetic */ Entry copy$default(Entry entry, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = entry.manufacturer;
            }
            if ((i & 2) != 0) {
                str2 = entry.model;
            }
            if ((i & 4) != 0) {
                str3 = entry.display;
            }
            return entry.copy(str, str2, str3);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.manufacturer : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.model : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.display : (String) invokeV.objValue;
        }

        public final Entry copy(String manufacturer, String model, String display) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, manufacturer, model, display)) == null) {
                Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
                Intrinsics.checkNotNullParameter(model, "model");
                Intrinsics.checkNotNullParameter(display, "display");
                return new Entry(manufacturer, model, display);
            }
            return (Entry) invokeLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Entry) {
                    Entry entry = (Entry) obj;
                    return Intrinsics.areEqual(this.manufacturer, entry.manufacturer) && Intrinsics.areEqual(this.model, entry.model) && Intrinsics.areEqual(this.display, entry.display);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (((this.manufacturer.hashCode() * 31) + this.model.hashCode()) * 31) + this.display.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "Entry(manufacturer=" + this.manufacturer + ", model=" + this.model + ", display=" + this.display + ')';
            }
            return (String) invokeV.objValue;
        }

        public Entry(String manufacturer, String model, String display) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {manufacturer, model, display};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(display, "display");
            this.manufacturer = manufacturer;
            this.model = model;
            this.display = display;
        }

        public final String getDisplay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.display;
            }
            return (String) invokeV.objValue;
        }

        public final String getManufacturer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.manufacturer;
            }
            return (String) invokeV.objValue;
        }

        public final String getModel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.model;
            }
            return (String) invokeV.objValue;
        }
    }

    @Singleton
    @Service
    /* loaded from: classes5.dex */
    public static final class a implements w95 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.w95
        public void parseJson(JSONObject json) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
                Intrinsics.checkNotNullParameter(json, "json");
                try {
                    if (json.optBoolean("keyboard_down_key_config_debug", false)) {
                        DownKeyChecker.a.clear();
                    }
                    String optString = json.optString("keyboard_down_key_config");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(CONFIG_KEY)");
                    DownKeyChecker.a.addAll(DataExt.toEntityList(optString, Entry.class));
                } catch (Exception e) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("DownKeyChecker", "配置数据解析失败" + e.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(650869228, "Lcom/baidu/tbadk/core/view/spanGroup/DownKeyChecker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(650869228, "Lcom/baidu/tbadk/core/view/spanGroup/DownKeyChecker;");
                return;
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a = linkedHashSet;
        linkedHashSet.add(new Entry(ManufacturerUtils.SAMSUNG, "SM-G9860", "QP1A.190711.020.G9860ZCU2BTK3"));
        a.add(new Entry("HUAWEI", "CET-AL00", "CET-AL00 3.0.0.312(C00E300R5P11)"));
    }
}
