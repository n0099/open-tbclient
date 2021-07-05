package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(28)
/* loaded from: classes.dex */
public class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public android.media.session.MediaSessionManager mObject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSessionManagerImplApi28(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mObject = (android.media.session.MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, remoteUserInfoImpl)) == null) {
            if (remoteUserInfoImpl instanceof RemoteUserInfoImplApi28) {
                return this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28) remoteUserInfoImpl).mObject);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes.dex */
    public static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaSessionManager.RemoteUserInfo mObject;

        public RemoteUserInfoImplApi28(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mObject = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RemoteUserInfoImplApi28) {
                    return this.mObject.equals(((RemoteUserInfoImplApi28) obj).mObject);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mObject.getPackageName() : (String) invokeV.objValue;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mObject.getPid() : invokeV.intValue;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mObject.getUid() : invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ObjectsCompat.hash(this.mObject) : invokeV.intValue;
        }

        public RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {remoteUserInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mObject = remoteUserInfo;
        }
    }
}
