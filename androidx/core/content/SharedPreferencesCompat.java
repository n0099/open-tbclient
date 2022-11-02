package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public final class SharedPreferencesCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    /* loaded from: classes.dex */
    public static final class EditorCompat {
        public static /* synthetic */ Interceptable $ic;
        public static EditorCompat sInstance;
        public transient /* synthetic */ FieldHolder $fh;
        public final Helper mHelper;

        /* loaded from: classes.dex */
        public static class Helper {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public Helper() {
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

            public void apply(@NonNull SharedPreferences.Editor editor) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
                    try {
                        editor.apply();
                    } catch (AbstractMethodError unused) {
                        editor.commit();
                    }
                }
            }
        }

        public EditorCompat() {
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
            this.mHelper = new Helper();
        }

        @Deprecated
        public static EditorCompat getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (sInstance == null) {
                    sInstance = new EditorCompat();
                }
                return sInstance;
            }
            return (EditorCompat) invokeV.objValue;
        }

        @Deprecated
        public void apply(@NonNull SharedPreferences.Editor editor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
                this.mHelper.apply(editor);
            }
        }
    }

    public SharedPreferencesCompat() {
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
}
