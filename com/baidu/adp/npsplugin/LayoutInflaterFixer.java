package com.baidu.adp.npsplugin;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j91;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class LayoutInflaterFixer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class PrivateMap extends HashMap<String, Constructor<? extends View>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> excludeClasses;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateMap(List<String> list, @NonNull Map<? extends String, ? extends Constructor<? extends View>> map) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Map) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.excludeClasses = arrayList;
            arrayList.addAll(list);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public Constructor<? extends View> get(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof String) {
                    for (String str : this.excludeClasses) {
                        if (((String) obj).startsWith(str)) {
                            super.remove(obj);
                            return null;
                        }
                    }
                }
                return (Constructor) super.get(obj);
            }
            return (Constructor) invokeL.objValue;
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && Build.VERSION.SDK_INT == 23) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("androidx.recyclerview");
            try {
                Field b = j91.b(LayoutInflater.class, "sConstructorMap");
                j91.h(b);
                Object obj = b.get(null);
                if (obj instanceof Map) {
                    b.set(null, new PrivateMap(arrayList, (Map) obj));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
