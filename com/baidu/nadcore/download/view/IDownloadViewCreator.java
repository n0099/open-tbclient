package com.baidu.nadcore.download.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.tieba.fl0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public interface IDownloadViewCreator {
    public static final ServiceReference a = new ServiceReference("nad.core", "downloadview");
    public static final IDownloadViewCreator b = new a();

    fl0<?> a(@NonNull ViewGroup viewGroup, ViewType viewType);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ViewType {
        public static final /* synthetic */ ViewType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ViewType DEFAULT;
        public static final ViewType FEED_DOWNLOAD_VIEW;
        public static final ViewType LP_DOWNLOAD_VIEW;
        public static final ViewType REWARD_DOWNLOAD_VIEW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-177838946, "Lcom/baidu/nadcore/download/view/IDownloadViewCreator$ViewType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-177838946, "Lcom/baidu/nadcore/download/view/IDownloadViewCreator$ViewType;");
                    return;
                }
            }
            LP_DOWNLOAD_VIEW = new ViewType("LP_DOWNLOAD_VIEW", 0);
            FEED_DOWNLOAD_VIEW = new ViewType("FEED_DOWNLOAD_VIEW", 1);
            REWARD_DOWNLOAD_VIEW = new ViewType("REWARD_DOWNLOAD_VIEW", 2);
            ViewType viewType = new ViewType(EngineName.DEFAULT_ENGINE, 3);
            DEFAULT = viewType;
            $VALUES = new ViewType[]{LP_DOWNLOAD_VIEW, FEED_DOWNLOAD_VIEW, REWARD_DOWNLOAD_VIEW, viewType};
        }

        public ViewType(String str, int i) {
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

        public static ViewType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ViewType) Enum.valueOf(ViewType.class, str);
            }
            return (ViewType) invokeL.objValue;
        }

        public static ViewType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ViewType[]) $VALUES.clone();
            }
            return (ViewType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements IDownloadViewCreator {
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

        @Override // com.baidu.nadcore.download.view.IDownloadViewCreator
        public fl0<?> a(@NonNull ViewGroup viewGroup, ViewType viewType) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, viewType)) == null) {
                int i = b.a[viewType.ordinal()];
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        return null;
                    }
                    AdProgressButton adProgressButton = new AdProgressButton(viewGroup.getContext());
                    adProgressButton.b(viewGroup);
                    return adProgressButton;
                }
                DefaultDownloadViewLP defaultDownloadViewLP = new DefaultDownloadViewLP(viewGroup.getContext());
                defaultDownloadViewLP.b(viewGroup);
                return defaultDownloadViewLP;
            }
            return (fl0) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(167564855, "Lcom/baidu/nadcore/download/view/IDownloadViewCreator$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(167564855, "Lcom/baidu/nadcore/download/view/IDownloadViewCreator$b;");
                    return;
                }
            }
            int[] iArr = new int[ViewType.values().length];
            a = iArr;
            try {
                iArr[ViewType.LP_DOWNLOAD_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ViewType.FEED_DOWNLOAD_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ViewType.REWARD_DOWNLOAD_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ViewType.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
