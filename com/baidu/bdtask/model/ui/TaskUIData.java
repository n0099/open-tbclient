package com.baidu.bdtask.model.ui;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u007f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002¢\u0006\u0004\bB\u0010CJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0088\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0000H\u0016¢\u0006\u0004\b$\u0010%J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b+\u0010\u0007J\u000f\u0010,\u001a\u00020(H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b3\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00104\u001a\u0004\b5\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b7\u0010\u0014R\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b8\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00109\u001a\u0004\b:\u0010\u0007R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b;\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b<\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00104\u001a\u0004\b=\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b>\u0010\u0007R\u0019\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010?\u001a\u0004\b@\u0010\u0011R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\bA\u0010\u0004¨\u0006E"}, d2 = {"Lcom/baidu/bdtask/model/ui/TaskUIData;", "Lcom/baidu/bdtask/model/ITaskModelData;", "", "component1", "()Ljava/lang/String;", "", "component10", "()I", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "Lcom/baidu/bdtask/model/ui/TaskUIProgress;", "component7", "()Lcom/baidu/bdtask/model/ui/TaskUIProgress;", "Lcom/baidu/bdtask/model/ui/TaskUIBtn;", "component8", "()Lcom/baidu/bdtask/model/ui/TaskUIBtn;", "component9", "backColor", "message", "duration", "foreColor", TaskUIData.keyBgUrl, TaskUIData.keyTxtColor, "progress", TaskUIData.keyBackBtn, TaskUIData.keyCancelBtn, TaskUIData.keyModalType, TaskUIData.keyCloseBg, "extra", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/bdtask/model/ui/TaskUIProgress;Lcom/baidu/bdtask/model/ui/TaskUIBtn;Lcom/baidu/bdtask/model/ui/TaskUIBtn;ILjava/lang/String;Ljava/lang/String;)Lcom/baidu/bdtask/model/ui/TaskUIData;", "deepCopy", "()Lcom/baidu/bdtask/model/ui/TaskUIData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "isEmpty", "()Z", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "toString", "Lcom/baidu/bdtask/model/ui/TaskUIBtn;", "getBackBtn", "Ljava/lang/String;", "getBackColor", "getBgUrl", "getCancelBtn", "getCloseBg", "I", "getDuration", "getExtra", "getForeColor", "getMessage", "getModalType", "Lcom/baidu/bdtask/model/ui/TaskUIProgress;", "getProgress", "getTxtColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/bdtask/model/ui/TaskUIProgress;Lcom/baidu/bdtask/model/ui/TaskUIBtn;Lcom/baidu/bdtask/model/ui/TaskUIBtn;ILjava/lang/String;Ljava/lang/String;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TaskUIData implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int DOUBLE_BTN_DIALOG = 2;
    public static final int SINGLE_BTN_DIALOG = 1;
    public static final String key = "ui";
    public static final String keyBackBtn = "backBtn";
    public static final String keyBackColor = "backcolor";
    public static final String keyBgUrl = "bgUrl";
    public static final String keyCancelBtn = "cancelBtn";
    public static final String keyCloseBg = "closeBg";
    public static final String keyDuration = "duration";
    public static final String keyExtra = "extra";
    public static final String keyForeColor = "forecolor";
    public static final String keyMessage = "message";
    public static final String keyModalType = "modalType";
    public static final String keyProgress = "progress";
    public static final String keyTxtColor = "txtColor";
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskUIBtn backBtn;
    public final String backColor;
    public final String bgUrl;
    public final TaskUIBtn cancelBtn;
    public final String closeBg;
    public final int duration;
    public final String extra;
    public final String foreColor;
    public final String message;
    public final int modalType;
    public final TaskUIProgress progress;
    public final String txtColor;

    /* loaded from: classes3.dex */
    public static final class a {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1807032451, "Lcom/baidu/bdtask/model/ui/TaskUIData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1807032451, "Lcom/baidu/bdtask/model/ui/TaskUIData;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskUIData() {
        this(null, null, 0, null, null, null, null, null, null, 0, null, null, 4095, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3], (String) objArr[4], (String) objArr[5], (TaskUIProgress) objArr[6], (TaskUIBtn) objArr[7], (TaskUIBtn) objArr[8], ((Integer) objArr[9]).intValue(), (String) objArr[10], (String) objArr[11], ((Integer) objArr[12]).intValue(), (DefaultConstructorMarker) objArr[13]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TaskUIData(String str, String str2, int i, String str3, String str4, String str5, TaskUIProgress taskUIProgress, TaskUIBtn taskUIBtn, TaskUIBtn taskUIBtn2, int i2, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, Integer.valueOf(i), str3, str4, str5, taskUIProgress, taskUIBtn, taskUIBtn2, Integer.valueOf(i2), str6, str7};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.backColor = str;
        this.message = str2;
        this.duration = i;
        this.foreColor = str3;
        this.bgUrl = str4;
        this.txtColor = str5;
        this.progress = taskUIProgress;
        this.backBtn = taskUIBtn;
        this.cancelBtn = taskUIBtn2;
        this.modalType = i2;
        this.closeBg = str6;
        this.extra = str7;
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.backColor : (String) invokeV.objValue;
    }

    public final int component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.modalType : invokeV.intValue;
    }

    public final String component11() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.closeBg : (String) invokeV.objValue;
    }

    public final String component12() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.extra : (String) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.duration : invokeV.intValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.foreColor : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.bgUrl : (String) invokeV.objValue;
    }

    public final String component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.txtColor : (String) invokeV.objValue;
    }

    public final TaskUIProgress component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.progress : (TaskUIProgress) invokeV.objValue;
    }

    public final TaskUIBtn component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.backBtn : (TaskUIBtn) invokeV.objValue;
    }

    public final TaskUIBtn component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.cancelBtn : (TaskUIBtn) invokeV.objValue;
    }

    public final TaskUIData copy(String str, String str2, int i, String str3, String str4, String str5, TaskUIProgress taskUIProgress, TaskUIBtn taskUIBtn, TaskUIBtn taskUIBtn2, int i2, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, str2, Integer.valueOf(i), str3, str4, str5, taskUIProgress, taskUIBtn, taskUIBtn2, Integer.valueOf(i2), str6, str7})) == null) ? new TaskUIData(str, str2, i, str3, str4, str5, taskUIProgress, taskUIBtn, taskUIBtn2, i2, str6, str7) : (TaskUIData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof TaskUIData) {
                    TaskUIData taskUIData = (TaskUIData) obj;
                    if (Intrinsics.areEqual(this.backColor, taskUIData.backColor) && Intrinsics.areEqual(this.message, taskUIData.message)) {
                        if ((this.duration == taskUIData.duration) && Intrinsics.areEqual(this.foreColor, taskUIData.foreColor) && Intrinsics.areEqual(this.bgUrl, taskUIData.bgUrl) && Intrinsics.areEqual(this.txtColor, taskUIData.txtColor) && Intrinsics.areEqual(this.progress, taskUIData.progress) && Intrinsics.areEqual(this.backBtn, taskUIData.backBtn) && Intrinsics.areEqual(this.cancelBtn, taskUIData.cancelBtn)) {
                            if (!(this.modalType == taskUIData.modalType) || !Intrinsics.areEqual(this.closeBg, taskUIData.closeBg) || !Intrinsics.areEqual(this.extra, taskUIData.extra)) {
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final TaskUIBtn getBackBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.backBtn : (TaskUIBtn) invokeV.objValue;
    }

    public final String getBackColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.backColor : (String) invokeV.objValue;
    }

    public final String getBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.bgUrl : (String) invokeV.objValue;
    }

    public final TaskUIBtn getCancelBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.cancelBtn : (TaskUIBtn) invokeV.objValue;
    }

    public final String getCloseBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.closeBg : (String) invokeV.objValue;
    }

    public final int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.duration : invokeV.intValue;
    }

    public final String getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.extra : (String) invokeV.objValue;
    }

    public final String getForeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.foreColor : (String) invokeV.objValue;
    }

    public final String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    public final int getModalType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.modalType : invokeV.intValue;
    }

    public final TaskUIProgress getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.progress : (TaskUIProgress) invokeV.objValue;
    }

    public final String getTxtColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.txtColor : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            String str = this.backColor;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.message;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.duration) * 31;
            String str3 = this.foreColor;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.bgUrl;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.txtColor;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            TaskUIProgress taskUIProgress = this.progress;
            int hashCode6 = (hashCode5 + (taskUIProgress != null ? taskUIProgress.hashCode() : 0)) * 31;
            TaskUIBtn taskUIBtn = this.backBtn;
            int hashCode7 = (hashCode6 + (taskUIBtn != null ? taskUIBtn.hashCode() : 0)) * 31;
            TaskUIBtn taskUIBtn2 = this.cancelBtn;
            int hashCode8 = (((hashCode7 + (taskUIBtn2 != null ? taskUIBtn2.hashCode() : 0)) * 31) + this.modalType) * 31;
            String str6 = this.closeBg;
            int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.extra;
            return hashCode9 + (str7 != null ? str7.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(keyBackColor, this.backColor);
            jSONObject.put("message", this.message);
            jSONObject.put("duration", this.duration);
            jSONObject.put(keyForeColor, this.foreColor);
            jSONObject.put(keyBgUrl, this.bgUrl);
            jSONObject.put(keyTxtColor, this.txtColor);
            jSONObject.put("progress", this.progress.toJson());
            jSONObject.put(keyBackBtn, this.backBtn.toJson());
            jSONObject.put(keyCancelBtn, this.cancelBtn.toJson());
            jSONObject.put(keyModalType, this.modalType);
            jSONObject.put(keyCloseBg, this.closeBg);
            jSONObject.put("extra", this.extra);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return "TaskUIData(backColor=" + this.backColor + ", message=" + this.message + ", duration=" + this.duration + ", foreColor=" + this.foreColor + ", bgUrl=" + this.bgUrl + ", txtColor=" + this.txtColor + ", progress=" + this.progress + ", backBtn=" + this.backBtn + ", cancelBtn=" + this.cancelBtn + ", modalType=" + this.modalType + ", closeBg=" + this.closeBg + ", extra=" + this.extra + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ TaskUIData(String str, String str2, int i, String str3, String str4, String str5, TaskUIProgress taskUIProgress, TaskUIBtn taskUIBtn, TaskUIBtn taskUIBtn2, int i2, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? new TaskUIProgress(null, null, 3, null) : taskUIProgress, (i3 & 128) != 0 ? new TaskUIBtn(null, null, null, null, null, 31, null) : taskUIBtn, (i3 & 256) != 0 ? new TaskUIBtn(null, null, null, null, null, 31, null) : taskUIBtn2, (i3 & 512) != 0 ? -1 : i2, (i3 & 1024) != 0 ? "" : str6, (i3 & 2048) == 0 ? str7 : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskUIData deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new TaskUIData(this.backColor, this.message, this.duration, this.foreColor, this.bgUrl, this.txtColor, this.progress.deepCopy(), this.backBtn.deepCopy(), this.cancelBtn.deepCopy(), this.modalType, this.closeBg, this.extra) : (TaskUIData) invokeV.objValue;
    }
}
