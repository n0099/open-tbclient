package aegon.chrome.net.impl;

import aegon.chrome.net.CronetEngine$Builder$LibraryLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class VersionSafeCallbacks$LibraryLoader extends CronetEngine$Builder$LibraryLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CronetEngine$Builder$LibraryLoader mWrappedLoader;

    public VersionSafeCallbacks$LibraryLoader(CronetEngine$Builder$LibraryLoader cronetEngine$Builder$LibraryLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cronetEngine$Builder$LibraryLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWrappedLoader = cronetEngine$Builder$LibraryLoader;
    }

    @Override // aegon.chrome.net.CronetEngine$Builder$LibraryLoader
    public void loadLibrary(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.mWrappedLoader.loadLibrary(str);
        }
    }
}
