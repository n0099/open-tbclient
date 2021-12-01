package com.baidu.nadcore.download.consts;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class AdDownloadAction {
    public static final /* synthetic */ AdDownloadAction[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdDownloadAction COMPLETE;
    public static final AdDownloadAction FAIL;
    public static final AdDownloadAction INSTALL_FINISH;
    public static final AdDownloadAction INSTALL_START;
    public static final AdDownloadAction OPEN;
    public static final AdDownloadAction PAUSE;
    public static final AdDownloadAction PROGRESS_UPDATE;
    public static final AdDownloadAction REMOVE;
    public static final AdDownloadAction RESUME;
    public static final AdDownloadAction START;
    public transient /* synthetic */ FieldHolder $fh;
    public final int action;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(106861493, "Lcom/baidu/nadcore/download/consts/AdDownloadAction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(106861493, "Lcom/baidu/nadcore/download/consts/AdDownloadAction;");
                return;
            }
        }
        START = new AdDownloadAction("START", 0, 1);
        PAUSE = new AdDownloadAction("PAUSE", 1, 2);
        RESUME = new AdDownloadAction("RESUME", 2, 3);
        PROGRESS_UPDATE = new AdDownloadAction("PROGRESS_UPDATE", 3, 4);
        COMPLETE = new AdDownloadAction("COMPLETE", 4, 5);
        INSTALL_START = new AdDownloadAction("INSTALL_START", 5, 6);
        INSTALL_FINISH = new AdDownloadAction("INSTALL_FINISH", 6, 7);
        REMOVE = new AdDownloadAction("REMOVE", 7, 8);
        OPEN = new AdDownloadAction("OPEN", 8, 9);
        AdDownloadAction adDownloadAction = new AdDownloadAction("FAIL", 9, 10);
        FAIL = adDownloadAction;
        $VALUES = new AdDownloadAction[]{START, PAUSE, RESUME, PROGRESS_UPDATE, COMPLETE, INSTALL_START, INSTALL_FINISH, REMOVE, OPEN, adDownloadAction};
    }

    public AdDownloadAction(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.action = i3;
    }

    public static AdDownloadAction valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdDownloadAction) Enum.valueOf(AdDownloadAction.class, str) : (AdDownloadAction) invokeL.objValue;
    }

    public static AdDownloadAction[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdDownloadAction[]) $VALUES.clone() : (AdDownloadAction[]) invokeV.objValue;
    }
}
