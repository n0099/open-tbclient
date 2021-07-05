package androidx.core.content.pm;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class ShortcutInfoCompatSaver<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class NoopImpl extends ShortcutInfoCompatSaver<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NoopImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public /* bridge */ /* synthetic */ Void addShortcuts(List list) {
            return addShortcuts2((List<ShortcutInfoCompat>) list);
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* renamed from: addShortcuts  reason: avoid collision after fix types in other method */
        public Void addShortcuts2(List<ShortcutInfoCompat> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public Void removeAllShortcuts() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (Void) invokeV.objValue;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public /* bridge */ /* synthetic */ Void removeShortcuts(List list) {
            return removeShortcuts2((List<String>) list);
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* renamed from: removeShortcuts  reason: avoid collision after fix types in other method */
        public Void removeShortcuts2(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public ShortcutInfoCompatSaver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @AnyThread
    public abstract T addShortcuts(List<ShortcutInfoCompat> list);

    @WorkerThread
    public List<ShortcutInfoCompat> getShortcuts() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ArrayList() : (List) invokeV.objValue;
    }

    @AnyThread
    public abstract T removeAllShortcuts();

    @AnyThread
    public abstract T removeShortcuts(List<String> list);
}
