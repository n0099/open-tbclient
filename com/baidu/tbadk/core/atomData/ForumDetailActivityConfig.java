package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ForumDetailActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORUM_ID = "forum_id";
    public static final String FROM_TYPE = "from_type";
    public transient /* synthetic */ FieldHolder $fh;
    public List<Map<String, Object>> serviceAreaListData;
    public ArrayList<String> tabs;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class FromType {
        public static final /* synthetic */ FromType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FromType BAR;
        public static final FromType BAR_DIR;
        public static final FromType BAR_RANK;
        public static final FromType BAR_SQUARE;
        public static final FromType BLUEV_SETTLE;
        public static final FromType FRS;
        public static final FromType FRS_GAME_INFO;
        public static final FromType FRS_GAME_LIVE;
        public static final FromType FRS_GAME_STRATEGY;
        public static final FromType FRS_SIDE;
        public static final FromType GAME_FRS_GOOD;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2039669105, "Lcom/baidu/tbadk/core/atomData/ForumDetailActivityConfig$FromType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2039669105, "Lcom/baidu/tbadk/core/atomData/ForumDetailActivityConfig$FromType;");
                    return;
                }
            }
            BAR = new FromType("BAR", 0);
            FRS = new FromType("FRS", 1);
            FRS_SIDE = new FromType("FRS_SIDE", 2);
            BAR_DIR = new FromType("BAR_DIR", 3);
            BAR_RANK = new FromType("BAR_RANK", 4);
            BAR_SQUARE = new FromType("BAR_SQUARE", 5);
            GAME_FRS_GOOD = new FromType("GAME_FRS_GOOD", 6);
            FRS_GAME_INFO = new FromType("FRS_GAME_INFO", 7);
            FRS_GAME_STRATEGY = new FromType("FRS_GAME_STRATEGY", 8);
            FRS_GAME_LIVE = new FromType("FRS_GAME_LIVE", 9);
            FromType fromType = new FromType("BLUEV_SETTLE", 10);
            BLUEV_SETTLE = fromType;
            $VALUES = new FromType[]{BAR, FRS, FRS_SIDE, BAR_DIR, BAR_RANK, BAR_SQUARE, GAME_FRS_GOOD, FRS_GAME_INFO, FRS_GAME_STRATEGY, FRS_GAME_LIVE, fromType};
        }

        public FromType(String str, int i) {
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

        public static FromType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FromType) Enum.valueOf(FromType.class, str) : (FromType) invokeL.objValue;
        }

        public static FromType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FromType[]) $VALUES.clone() : (FromType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumDetailActivityConfig(Context context, String str, FromType fromType) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, fromType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("from_type", fromType.toString());
    }

    public static boolean isFromFrs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? FromType.FRS.toString().equals(str) || FromType.FRS_GAME_INFO.toString().equals(str) || FromType.FRS_GAME_STRATEGY.toString().equals(str) || FromType.FRS_GAME_LIVE.toString().equals(str) : invokeL.booleanValue;
    }

    public List<Map<String, Object>> getServiceAreaListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.serviceAreaListData : (List) invokeV.objValue;
    }

    public void setForumTabs(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.tabs = arrayList;
        }
    }

    public void setServiceAreaListData(List<Map<String, Object>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.serviceAreaListData = list;
        }
    }
}
