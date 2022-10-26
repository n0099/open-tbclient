package com.baidu.bdtask.framework.ui.dialog;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.ui.mvvm.IViewData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0010\b\u0017\u0018\u0000 32\u00020\u0001:\u00013B\u0083\u0001\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b1\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b¨\u00064"}, d2 = {"Lcom/baidu/bdtask/framework/ui/dialog/TaskDialogData;", "Lcom/baidu/bdtask/framework/ui/mvvm/IViewData;", "", "backBtnBgUrl", "Ljava/lang/String;", "getBackBtnBgUrl", "()Ljava/lang/String;", "setBackBtnBgUrl", "(Ljava/lang/String;)V", "backBtnSchema", "getBackBtnSchema", "setBackBtnSchema", "backBtnTxt", "getBackBtnTxt", "setBackBtnTxt", "backBtnTxtColor", "getBackBtnTxtColor", "setBackBtnTxtColor", TaskUIData.keyBgUrl, "getBgUrl", "setBgUrl", "cancelBtnBgUrl", "getCancelBtnBgUrl", "setCancelBtnBgUrl", "cancelBtnSchema", "getCancelBtnSchema", "setCancelBtnSchema", "cancelBtnTxt", "getCancelBtnTxt", "setCancelBtnTxt", "cancelBtnTxtColor", "getCancelBtnTxtColor", "setCancelBtnTxtColor", TaskUIData.keyCloseBg, "getCloseBg", "setCloseBg", "", "showType", "I", "getShowType", "()I", "setShowType", "(I)V", "taskInfoSingleKey", "getTaskInfoSingleKey", "setTaskInfoSingleKey", TaskUIData.keyTxtColor, "getTxtColor", "setTxtColor", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TYPE", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public class TaskDialogData implements IViewData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a TYPE;
    public static final int TYPE_ONE_BTN = 1;
    public static final int TYPE_TWO_BTN = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String backBtnBgUrl;
    public String backBtnSchema;
    public String backBtnTxt;
    public String backBtnTxtColor;
    public String bgUrl;
    public String cancelBtnBgUrl;
    public String cancelBtnSchema;
    public String cancelBtnTxt;
    public String cancelBtnTxtColor;
    public String closeBg;
    public int showType;
    public String taskInfoSingleKey;
    public String txtColor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(638986509, "Lcom/baidu/bdtask/framework/ui/dialog/TaskDialogData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(638986509, "Lcom/baidu/bdtask/framework/ui/dialog/TaskDialogData;");
                return;
            }
        }
        TYPE = new a(null);
    }

    /* loaded from: classes.dex */
    public final class a {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TaskDialogData(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.taskInfoSingleKey = str;
        this.showType = i;
        this.txtColor = str2;
        this.bgUrl = str3;
        this.backBtnTxtColor = str4;
        this.backBtnTxt = str5;
        this.backBtnBgUrl = str6;
        this.backBtnSchema = str7;
        this.cancelBtnTxt = str8;
        this.cancelBtnBgUrl = str9;
        this.cancelBtnTxtColor = str10;
        this.cancelBtnSchema = str11;
        this.closeBg = str12;
    }

    public final String getBackBtnBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.backBtnBgUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getBackBtnSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.backBtnSchema;
        }
        return (String) invokeV.objValue;
    }

    public final String getBackBtnTxt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.backBtnTxt;
        }
        return (String) invokeV.objValue;
    }

    public final String getBackBtnTxtColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.backBtnTxtColor;
        }
        return (String) invokeV.objValue;
    }

    public final String getBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.bgUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getCancelBtnBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.cancelBtnBgUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getCancelBtnSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.cancelBtnSchema;
        }
        return (String) invokeV.objValue;
    }

    public final String getCancelBtnTxt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.cancelBtnTxt;
        }
        return (String) invokeV.objValue;
    }

    public final String getCancelBtnTxtColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.cancelBtnTxtColor;
        }
        return (String) invokeV.objValue;
    }

    public final String getCloseBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.closeBg;
        }
        return (String) invokeV.objValue;
    }

    public final int getShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.showType;
        }
        return invokeV.intValue;
    }

    public final String getTaskInfoSingleKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.taskInfoSingleKey;
        }
        return (String) invokeV.objValue;
    }

    public final String getTxtColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.txtColor;
        }
        return (String) invokeV.objValue;
    }

    public final void setBackBtnBgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.backBtnBgUrl = str;
        }
    }

    public final void setBackBtnSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.backBtnSchema = str;
        }
    }

    public final void setBackBtnTxt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.backBtnTxt = str;
        }
    }

    public final void setBackBtnTxtColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.backBtnTxtColor = str;
        }
    }

    public final void setBgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.bgUrl = str;
        }
    }

    public final void setCancelBtnBgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.cancelBtnBgUrl = str;
        }
    }

    public final void setCancelBtnSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.cancelBtnSchema = str;
        }
    }

    public final void setCancelBtnTxt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.cancelBtnTxt = str;
        }
    }

    public final void setCancelBtnTxtColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.cancelBtnTxtColor = str;
        }
    }

    public final void setCloseBg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.closeBg = str;
        }
    }

    public final void setShowType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.showType = i;
        }
    }

    public final void setTaskInfoSingleKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.taskInfoSingleKey = str;
        }
    }

    public final void setTxtColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.txtColor = str;
        }
    }
}
