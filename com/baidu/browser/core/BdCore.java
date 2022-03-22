package com.baidu.browser.core;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.util.BdLog;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class BdCore {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static BdCore f24975c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24976b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class EditTextType {
        public static final /* synthetic */ EditTextType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EditTextType ADD_BAR;
        public static final EditTextType BD_EDIT;
        public static final EditTextType BD_RSS_WEB;
        public static final EditTextType DEFAULT;
        public static final EditTextType WEB_EDIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-72324414, "Lcom/baidu/browser/core/BdCore$EditTextType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-72324414, "Lcom/baidu/browser/core/BdCore$EditTextType;");
                    return;
                }
            }
            DEFAULT = new EditTextType(EngineName.DEFAULT_ENGINE, 0);
            WEB_EDIT = new EditTextType("WEB_EDIT", 1);
            ADD_BAR = new EditTextType("ADD_BAR", 2);
            BD_EDIT = new EditTextType("BD_EDIT", 3);
            EditTextType editTextType = new EditTextType("BD_RSS_WEB", 4);
            BD_RSS_WEB = editTextType;
            $VALUES = new EditTextType[]{DEFAULT, WEB_EDIT, ADD_BAR, BD_EDIT, editTextType};
        }

        public EditTextType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EditTextType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EditTextType) Enum.valueOf(EditTextType.class, str) : (EditTextType) invokeL.objValue;
        }

        public static EditTextType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EditTextType[]) $VALUES.clone() : (EditTextType[]) invokeV.objValue;
        }
    }

    public BdCore() {
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
        EditTextType editTextType = EditTextType.DEFAULT;
        this.f24976b = false;
    }

    public static synchronized BdCore a() {
        InterceptResult invokeV;
        BdCore bdCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (BdCore.class) {
                if (f24975c == null) {
                    f24975c = new BdCore();
                }
                bdCore = f24975c;
            }
            return bdCore;
        }
        return (BdCore) invokeV.objValue;
    }

    public void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) || this.f24976b) {
            return;
        }
        BdLog.f(z);
        this.a = context.getApplicationContext();
        this.f24976b = true;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = this.a;
            if (context != null) {
                return context;
            }
            throw new RuntimeException("context is null");
        }
        return (Context) invokeV.objValue;
    }
}
