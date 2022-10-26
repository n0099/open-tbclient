package androidx.media2.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.SessionPlayer;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class SessionResult extends CustomVersionedParcelable implements RemoteResult {
    public static /* synthetic */ Interceptable $ic;
    public static final int RESULT_SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCompletionTime;
    public Bundle mCustomCommandResult;
    public MediaItem mItem;
    public MediaItem mParcelableItem;
    public int mResultCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ResultCode {
    }

    public SessionResult() {
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

    @Override // androidx.media2.common.BaseResult
    public long getCompletionTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCompletionTime;
        }
        return invokeV.longValue;
    }

    public Bundle getCustomCommandResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCustomCommandResult;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // androidx.media2.common.BaseResult
    public MediaItem getMediaItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mItem;
        }
        return (MediaItem) invokeV.objValue;
    }

    @Override // androidx.media2.common.BaseResult
    public int getResultCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mResultCode;
        }
        return invokeV.intValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mItem = this.mParcelableItem;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionResult(int i) {
        this(i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Bundle) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionResult(int i, Bundle bundle) {
        this(i, bundle, null, SystemClock.elapsedRealtime());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {Integer.valueOf(i), bundle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Bundle) objArr2[1], (MediaItem) objArr2[2], ((Long) objArr2[3]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionResult(int i, Bundle bundle, MediaItem mediaItem) {
        this(i, bundle, mediaItem, SystemClock.elapsedRealtime());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {Integer.valueOf(i), bundle, mediaItem};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Bundle) objArr2[1], (MediaItem) objArr2[2], ((Long) objArr2[3]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public SessionResult(int i, Bundle bundle, MediaItem mediaItem, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bundle, mediaItem, Long.valueOf(j)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mResultCode = i;
        this.mCustomCommandResult = bundle;
        this.mItem = mediaItem;
        this.mCompletionTime = j;
    }

    public static ListenableFuture<SessionResult> createFutureWithResult(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            ResolvableFuture create = ResolvableFuture.create();
            create.set(new SessionResult(i));
            return create;
        }
        return (ListenableFuture) invokeI.objValue;
    }

    public static SessionResult from(SessionPlayer.PlayerResult playerResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, playerResult)) == null) {
            if (playerResult == null) {
                return null;
            }
            return new SessionResult(playerResult.getResultCode(), null, playerResult.getMediaItem(), playerResult.getCompletionTime());
        }
        return (SessionResult) invokeL.objValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z) {
        MediaItem mediaItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (mediaItem = this.mItem) != null) {
            synchronized (mediaItem) {
                if (this.mParcelableItem == null) {
                    this.mParcelableItem = MediaUtils.upcastForPreparceling(this.mItem);
                }
            }
        }
    }
}
