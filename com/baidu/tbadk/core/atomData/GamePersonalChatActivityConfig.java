package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class GamePersonalChatActivityConfig extends PersonalChatActivityConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FLUTTER_INIT_PARAM = "key_flutter_init_param";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class SerializableMap implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2440454508522550999L;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final Map<String, Object> map;

        public SerializableMap(@NonNull Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.map = map;
        }

        @NonNull
        public Map<String, Object> getMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.map;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamePersonalChatActivityConfig(Context context, Map<String, Object> map) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, map};
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
        getIntent().putExtra(KEY_FLUTTER_INIT_PARAM, new SerializableMap(map));
    }

    @NonNull
    public static Map<String, Object> getIntentParam(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (intent == null) {
                return new HashMap();
            }
            Serializable serializableExtra = intent.getSerializableExtra(KEY_FLUTTER_INIT_PARAM);
            if (serializableExtra instanceof SerializableMap) {
                return ((SerializableMap) serializableExtra).getMap();
            }
            return new HashMap();
        }
        return (Map) invokeL.objValue;
    }

    public static void mockStart(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bar_name", "王者荣耀吧");
            hashMap.put("gender", AccountConstants.MALE_TEXT);
            hashMap.put("game_level", "王者");
            hashMap.put("good_at", "辅助");
            hashMap.put("avatar", "头像");
            start(context, hashMap);
        }
    }

    public static void start(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, context, map) == null) && context != null && map != null) {
            new GamePersonalChatActivityConfig(context, map).start();
        }
    }
}
