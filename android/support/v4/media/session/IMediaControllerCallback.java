package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public interface IMediaControllerCallback extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMediaControllerCallback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
        public static final int TRANSACTION_onCaptioningEnabledChanged = 11;
        public static final int TRANSACTION_onEvent = 1;
        public static final int TRANSACTION_onExtrasChanged = 7;
        public static final int TRANSACTION_onMetadataChanged = 4;
        public static final int TRANSACTION_onPlaybackStateChanged = 3;
        public static final int TRANSACTION_onQueueChanged = 5;
        public static final int TRANSACTION_onQueueTitleChanged = 6;
        public static final int TRANSACTION_onRepeatModeChanged = 9;
        public static final int TRANSACTION_onSessionDestroyed = 2;
        public static final int TRANSACTION_onSessionReady = 13;
        public static final int TRANSACTION_onShuffleModeChanged = 12;
        public static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
        public static final int TRANSACTION_onVolumeInfoChanged = 8;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class Proxy implements IMediaControllerCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRemote : (IBinder) invokeV.objValue;
            }

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(z ? 1 : 0);
                        this.mRemote.transact(11, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(1, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(7, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, mediaMetadataCompat) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (mediaMetadataCompat != null) {
                            obtain.writeInt(1);
                            mediaMetadataCompat.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(4, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, playbackStateCompat) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (playbackStateCompat != null) {
                            obtain.writeInt(1);
                            playbackStateCompat.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(3, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeTypedList(list);
                        this.mRemote.transact(5, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (charSequence != null) {
                            obtain.writeInt(1);
                            TextUtils.writeToParcel(charSequence, obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(6, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        this.mRemote.transact(9, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(2, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(13, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        this.mRemote.transact(12, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(z ? 1 : 0);
                        this.mRemote.transact(10, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048590, this, parcelableVolumeInfo) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (parcelableVolumeInfo != null) {
                            obtain.writeInt(1);
                            parcelableVolumeInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(8, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }
        }

        public Stub() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaControllerCallback asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaControllerCallback)) {
                    return (IMediaControllerCallback) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IMediaControllerCallback) invokeL.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 != 1598968902) {
                    switch (i2) {
                        case 1:
                            parcel.enforceInterface(DESCRIPTOR);
                            onEvent(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 2:
                            parcel.enforceInterface(DESCRIPTOR);
                            onSessionDestroyed();
                            return true;
                        case 3:
                            parcel.enforceInterface(DESCRIPTOR);
                            onPlaybackStateChanged(parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 4:
                            parcel.enforceInterface(DESCRIPTOR);
                            onMetadataChanged(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 5:
                            parcel.enforceInterface(DESCRIPTOR);
                            onQueueChanged(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                            return true;
                        case 6:
                            parcel.enforceInterface(DESCRIPTOR);
                            onQueueTitleChanged(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 7:
                            parcel.enforceInterface(DESCRIPTOR);
                            onExtrasChanged(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 8:
                            parcel.enforceInterface(DESCRIPTOR);
                            onVolumeInfoChanged(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 9:
                            parcel.enforceInterface(DESCRIPTOR);
                            onRepeatModeChanged(parcel.readInt());
                            return true;
                        case 10:
                            parcel.enforceInterface(DESCRIPTOR);
                            onShuffleModeChangedRemoved(parcel.readInt() != 0);
                            return true;
                        case 11:
                            parcel.enforceInterface(DESCRIPTOR);
                            onCaptioningEnabledChanged(parcel.readInt() != 0);
                            return true;
                        case 12:
                            parcel.enforceInterface(DESCRIPTOR);
                            onShuffleModeChanged(parcel.readInt());
                            return true;
                        case 13:
                            parcel.enforceInterface(DESCRIPTOR);
                            onSessionReady();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    void onCaptioningEnabledChanged(boolean z) throws RemoteException;

    void onEvent(String str, Bundle bundle) throws RemoteException;

    void onExtrasChanged(Bundle bundle) throws RemoteException;

    void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void onQueueTitleChanged(CharSequence charSequence) throws RemoteException;

    void onRepeatModeChanged(int i2) throws RemoteException;

    void onSessionDestroyed() throws RemoteException;

    void onSessionReady() throws RemoteException;

    void onShuffleModeChanged(int i2) throws RemoteException;

    void onShuffleModeChangedRemoved(boolean z) throws RemoteException;

    void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;
}
