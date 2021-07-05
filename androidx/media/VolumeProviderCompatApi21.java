package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(21)
/* loaded from: classes.dex */
public class VolumeProviderCompatApi21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Delegate {
        void onAdjustVolume(int i2);

        void onSetVolumeTo(int i2);
    }

    public VolumeProviderCompatApi21() {
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

    public static Object createVolumeProvider(int i2, int i3, int i4, Delegate delegate) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), delegate})) == null) ? new VolumeProvider(i2, i3, i4, delegate) { // from class: androidx.media.VolumeProviderCompatApi21.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Delegate val$delegate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(i2, i3, i4);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), delegate};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$delegate = delegate;
            }

            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i5) == null) {
                    this.val$delegate.onAdjustVolume(i5);
                }
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i5) == null) {
                    this.val$delegate.onSetVolumeTo(i5);
                }
            }
        } : invokeCommon.objValue;
    }

    public static void setCurrentVolume(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, obj, i2) == null) {
            ((VolumeProvider) obj).setCurrentVolume(i2);
        }
    }
}
